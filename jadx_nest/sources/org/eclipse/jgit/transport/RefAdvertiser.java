package org.eclipse.jgit.transport;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.http.message.TokenParser;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefComparator;
import org.eclipse.jgit.lib.Repository;

/* INFO: loaded from: classes5.dex */
public abstract class RefAdvertiser {
    private boolean derefTags;
    private Repository repository;
    private boolean useProtocolV2;
    private final StringBuilder tmpLine = new StringBuilder(100);
    private final char[] tmpId = new char[40];
    final Set<String> capablities = new LinkedHashSet();
    private final Set<ObjectId> sent = new HashSet();
    boolean first = true;
    private final Map<String, String> symrefs = new HashMap();

    protected abstract void end() throws IOException;

    protected abstract void writeOne(CharSequence charSequence) throws IOException;

    public static class PacketLineOutRefAdvertiser extends RefAdvertiser {
        private byte[] binArr;
        private ByteBuffer binBuf;
        private char[] chArr;
        private CharBuffer chBuf;
        private final PacketLineOut pckOut;
        private final CharsetEncoder utf8 = StandardCharsets.UTF_8.newEncoder();

        public PacketLineOutRefAdvertiser(PacketLineOut packetLineOut) {
            byte[] bArr = new byte[256];
            this.binArr = bArr;
            this.binBuf = ByteBuffer.wrap(bArr);
            char[] cArr = new char[256];
            this.chArr = cArr;
            this.chBuf = CharBuffer.wrap(cArr);
            this.pckOut = packetLineOut;
        }

        @Override // org.eclipse.jgit.transport.RefAdvertiser
        public void advertiseId(AnyObjectId anyObjectId, String str) throws IOException {
            anyObjectId.copyTo(this.binArr, 0);
            this.binArr[40] = 32;
            append(str);
            if (this.first) {
                this.first = false;
                if (!this.capablities.isEmpty()) {
                    append(0);
                    for (String str2 : this.capablities) {
                        append(32);
                        append(str2);
                    }
                }
            }
            append(10);
            this.pckOut.writePacket(this.binArr, 0, this.binBuf.position());
        }

        private void append(String str) throws CharacterCodingException {
            int length = str.length();
            if (length > this.chArr.length) {
                char[] cArr = new char[length + 256];
                this.chArr = cArr;
                this.chBuf = CharBuffer.wrap(cArr);
            }
            str.getChars(0, length, this.chArr, 0);
            this.utf8.reset();
            while (true) {
                CoderResult coderResultEncode = this.utf8.encode(this.chBuf, this.binBuf, true);
                if (coderResultEncode.isOverflow()) {
                    grow();
                } else if (coderResultEncode.isUnderflow()) {
                    return;
                } else {
                    coderResultEncode.throwException();
                }
            }
        }

        private void append(int i) {
            if (!this.binBuf.hasRemaining()) {
                grow();
            }
            this.binBuf.put((byte) i);
        }

        private void grow() {
            int iPosition = this.binBuf.position();
            byte[] bArr = this.binArr;
            byte[] bArr2 = new byte[bArr.length << 1];
            System.arraycopy(bArr, 0, bArr2, 0, iPosition);
            this.binArr = bArr2;
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr2);
            this.binBuf = byteBufferWrap;
        }

        @Override // org.eclipse.jgit.transport.RefAdvertiser
        protected void writeOne(CharSequence charSequence) throws IOException {
            this.pckOut.writeString(charSequence.toString());
        }

        @Override // org.eclipse.jgit.transport.RefAdvertiser
        protected void end() throws IOException {
            this.pckOut.end();
        }
    }

    public void init(Repository repository) {
        this.repository = repository;
    }

    public void setUseProtocolV2(boolean z) {
        this.useProtocolV2 = z;
    }

    public void setDerefTags(boolean z) {
        this.derefTags = z;
    }

    public void advertiseCapability(String str) {
        this.capablities.add(str);
    }

    public void advertiseCapability(String str, String str2) {
        if (str2 != null) {
            this.capablities.add(str + "=" + str2);
        }
    }

    public void addSymref(String str, String str2) {
        if (this.useProtocolV2) {
            this.symrefs.put(str, str2);
        } else {
            advertiseCapability(GitProtocolConstants.OPTION_SYMREF, str + CollectionUtils.COLON + str2);
        }
    }

    public Set<ObjectId> send(Collection<Ref> collection) throws IOException {
        Repository repository;
        Iterator<Ref> it = RefComparator.sort(collection).iterator();
        while (it.hasNext()) {
            Ref next = it.next();
            ObjectId objectId = next.getObjectId();
            if (objectId != null) {
                if (this.useProtocolV2) {
                    String str = "";
                    String str2 = this.symrefs.containsKey(next.getName()) ? " symref-target:" + this.symrefs.get(next.getName()) : "";
                    if (this.derefTags) {
                        if (!next.isPeeled() && (repository = this.repository) != null) {
                            next = repository.getRefDatabase().peel(next);
                        }
                        ObjectId peeledObjectId = next.getPeeledObjectId();
                        if (peeledObjectId != null) {
                            str = " peeled:" + peeledObjectId.getName();
                        }
                    }
                    writeOne(objectId.getName() + " " + next.getName() + str2 + str + "\n");
                } else {
                    advertiseAny(objectId, next.getName());
                    if (this.derefTags) {
                        if (!next.isPeeled()) {
                            Repository repository2 = this.repository;
                            if (repository2 != null) {
                                next = repository2.getRefDatabase().peel(next);
                            }
                        }
                        if (next.getPeeledObjectId() != null) {
                            advertiseAny(next.getPeeledObjectId(), next.getName() + "^{}");
                        }
                    }
                }
            }
        }
        return this.sent;
    }

    public void advertiseHave(AnyObjectId anyObjectId) throws IOException {
        advertiseAnyOnce(anyObjectId, ".have");
    }

    public boolean isEmpty() {
        return this.first;
    }

    private void advertiseAnyOnce(AnyObjectId anyObjectId, String str) throws IOException {
        if (this.sent.contains(anyObjectId)) {
            return;
        }
        advertiseAny(anyObjectId, str);
    }

    private void advertiseAny(AnyObjectId anyObjectId, String str) throws IOException {
        this.sent.add(anyObjectId.toObjectId());
        advertiseId(anyObjectId, str);
    }

    public void advertiseId(AnyObjectId anyObjectId, String str) throws IOException {
        this.tmpLine.setLength(0);
        anyObjectId.copyTo(this.tmpId, this.tmpLine);
        this.tmpLine.append(TokenParser.SP);
        this.tmpLine.append(str);
        if (this.first) {
            this.first = false;
            if (!this.capablities.isEmpty()) {
                this.tmpLine.append((char) 0);
                for (String str2 : this.capablities) {
                    this.tmpLine.append(TokenParser.SP);
                    this.tmpLine.append(str2);
                }
                this.tmpLine.append(TokenParser.SP);
            }
        }
        this.tmpLine.append('\n');
        writeOne(this.tmpLine);
    }
}
