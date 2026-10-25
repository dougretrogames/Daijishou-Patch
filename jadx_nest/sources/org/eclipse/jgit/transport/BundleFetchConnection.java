package org.eclipse.jgit.transport;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.eclipse.jgit.errors.MissingBundlePrerequisiteException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.errors.PackProtocolException;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.NullProgressMonitor;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectIdRef;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevFlag;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.util.IO;
import org.eclipse.jgit.util.RawParseUtils;

/* JADX INFO: loaded from: classes5.dex */
class BundleFetchConnection extends BaseFetchConnection {
    InputStream bin;
    private String lockMessage;
    private PackLock packLock;
    final Map<ObjectId, String> prereqs = new HashMap();
    private final Transport transport;

    @Override // org.eclipse.jgit.transport.FetchConnection
    public boolean didFetchTestConnectivity() {
        return false;
    }

    BundleFetchConnection(Transport transport, InputStream inputStream) throws TransportException {
        this.transport = transport;
        this.bin = new BufferedInputStream(inputStream);
        try {
            if (readSignature() == 2) {
                readBundleV2();
                return;
            }
            throw new TransportException(transport.uri, JGitText.get().notABundle);
        } catch (RuntimeException e) {
            e = e;
            close();
            throw new TransportException(this.transport.uri, e.getMessage(), e);
        } catch (TransportException e2) {
            close();
            throw e2;
        } catch (IOException e3) {
            e = e3;
            close();
            throw new TransportException(this.transport.uri, e.getMessage(), e);
        }
    }

    private int readSignature() throws IOException {
        if (TransportBundle.V2_BUNDLE_SIGNATURE.equals(readLine(new byte[1024]))) {
            return 2;
        }
        throw new TransportException(this.transport.uri, JGitText.get().notABundle);
    }

    private void readBundleV2() throws IOException {
        byte[] bArr = new byte[1024];
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (true) {
            String line = readLine(bArr);
            if (line.length() != 0) {
                if (line.charAt(0) == '-') {
                    this.prereqs.put(ObjectId.fromString(line.substring(1, 41)), line.length() > 42 ? line.substring(42) : null);
                } else {
                    String strSubstring = line.substring(41, line.length());
                    if (((Ref) linkedHashMap.put(strSubstring, new ObjectIdRef.Unpeeled(Ref.Storage.NETWORK, strSubstring, ObjectId.fromString(line.substring(0, 40))))) != null) {
                        throw duplicateAdvertisement(strSubstring);
                    }
                }
            } else {
                available(linkedHashMap);
                return;
            }
        }
    }

    private PackProtocolException duplicateAdvertisement(String str) {
        return new PackProtocolException(this.transport.uri, MessageFormat.format(JGitText.get().duplicateAdvertisementsOf, str));
    }

    private String readLine(byte[] bArr) throws IOException {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        while (!z) {
            this.bin.mark(bArr.length);
            int i = this.bin.read(bArr);
            if (i < 0) {
                throw new EOFException(JGitText.get().shortReadOfBlock);
            }
            int i2 = 0;
            while (i2 < i && bArr[i2] != 10) {
                i2++;
            }
            this.bin.reset();
            IO.skipFully(this.bin, i2);
            if (i2 < i && bArr[i2] == 10) {
                IO.skipFully(this.bin, 1L);
                z = true;
            }
            sb.append(RawParseUtils.decode(StandardCharsets.UTF_8, bArr, 0, i2));
        }
        return sb.toString();
    }

    @Override // org.eclipse.jgit.transport.BaseFetchConnection
    protected void doFetch(ProgressMonitor progressMonitor, Collection<Ref> collection, Set<ObjectId> set) throws TransportException {
        verifyPrerequisites();
        Throwable th = null;
        try {
            ObjectInserter objectInserterNewObjectInserter = this.transport.local.newObjectInserter();
            try {
                PackParser packParserNewPackParser = objectInserterNewObjectInserter.newPackParser(this.bin);
                packParserNewPackParser.setAllowThin(true);
                packParserNewPackParser.setObjectChecker(this.transport.getObjectChecker());
                packParserNewPackParser.setLockMessage(this.lockMessage);
                this.packLock = packParserNewPackParser.parse(NullProgressMonitor.INSTANCE);
                objectInserterNewObjectInserter.flush();
            } finally {
                if (objectInserterNewObjectInserter != null) {
                    objectInserterNewObjectInserter.close();
                }
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null == th2) {
                throw null;
            }
            try {
                th.addSuppressed(th2);
                throw null;
            } catch (IOException | RuntimeException e) {
                close();
                throw new TransportException(this.transport.uri, e.getMessage(), e);
            }
            close();
            throw new TransportException(this.transport.uri, e.getMessage(), e);
        }
    }

    @Override // org.eclipse.jgit.transport.FetchConnection
    public void setPackLockMessage(String str) {
        this.lockMessage = str;
    }

    @Override // org.eclipse.jgit.transport.FetchConnection
    public Collection<PackLock> getPackLocks() {
        PackLock packLock = this.packLock;
        if (packLock != null) {
            return Collections.singleton(packLock);
        }
        return Collections.emptyList();
    }

    private void verifyPrerequisites() throws TransportException {
        if (this.prereqs.isEmpty()) {
            return;
        }
        Throwable th = null;
        try {
            RevWalk revWalk = new RevWalk(this.transport.local);
            try {
                RevFlag revFlagNewFlag = revWalk.newFlag("PREREQ");
                RevFlag revFlagNewFlag2 = revWalk.newFlag("SEEN");
                HashMap map = new HashMap();
                ArrayList<RevObject> arrayList = new ArrayList();
                for (Map.Entry<ObjectId, String> entry : this.prereqs.entrySet()) {
                    ObjectId key = entry.getKey();
                    try {
                        RevCommit commit = revWalk.parseCommit(key);
                        if (!commit.has(revFlagNewFlag)) {
                            commit.add(revFlagNewFlag);
                            arrayList.add(commit);
                        }
                    } catch (MissingObjectException unused) {
                        map.put(key, entry.getValue());
                    } catch (IOException e) {
                        throw new TransportException(this.transport.uri, MessageFormat.format(JGitText.get().cannotReadCommit, key.name()), e);
                    }
                }
                if (!map.isEmpty()) {
                    throw new MissingBundlePrerequisiteException(this.transport.uri, map);
                }
                try {
                    Iterator<Ref> it = this.transport.local.getRefDatabase().getRefs().iterator();
                    while (it.hasNext()) {
                        try {
                            revWalk.markStart(revWalk.parseCommit(it.next().getObjectId()));
                        } catch (IOException unused2) {
                        }
                    }
                    int size = arrayList.size();
                    while (true) {
                        try {
                            RevCommit next = revWalk.next();
                            if (next == null) {
                                break;
                            }
                            if (next.has(revFlagNewFlag)) {
                                next.add(revFlagNewFlag2);
                                size--;
                                if (size == 0) {
                                    break;
                                }
                            }
                        } catch (IOException e2) {
                            throw new TransportException(this.transport.uri, JGitText.get().cannotReadObject, e2);
                        }
                    }
                    if (size > 0) {
                        for (RevObject revObject : arrayList) {
                            if (!revObject.has(revFlagNewFlag2)) {
                                map.put(revObject, this.prereqs.get(revObject));
                            }
                        }
                        throw new MissingBundlePrerequisiteException(this.transport.uri, map);
                    }
                    revWalk.close();
                } catch (IOException e3) {
                    throw new TransportException(this.transport.uri, e3.getMessage(), e3);
                }
            } catch (Throwable th2) {
                revWalk.close();
                throw th2;
            }
        } catch (Throwable th3) {
            if (0 == 0) {
                throw th3;
            }
            if (null == th3) {
                throw null;
            }
            th.addSuppressed(th3);
        }
    }

    @Override // org.eclipse.jgit.transport.BaseConnection, org.eclipse.jgit.transport.Connection, java.lang.AutoCloseable
    public void close() {
        InputStream inputStream = this.bin;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            } finally {
                this.bin = null;
            }
        }
    }
}
