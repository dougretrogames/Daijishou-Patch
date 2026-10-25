package org.eclipse.jgit.transport;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.http.message.TokenParser;
import org.eclipse.jgit.errors.InvalidObjectIdException;
import org.eclipse.jgit.errors.NoRemoteRepositoryException;
import org.eclipse.jgit.errors.PackProtocolException;
import org.eclipse.jgit.errors.RemoteRepositoryException;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectIdRef;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.SymbolicRef;
import org.eclipse.jgit.util.StringUtils;
import org.eclipse.jgit.util.io.InterruptTimer;
import org.eclipse.jgit.util.io.TimeoutInputStream;
import org.eclipse.jgit.util.io.TimeoutOutputStream;

/* JADX INFO: loaded from: classes5.dex */
abstract class BasePackConnection extends BaseConnection {
    protected static final String CAPABILITY_SYMREF_PREFIX = "symref=";
    protected InputStream in;
    protected final Repository local;
    private InterruptTimer myTimer;
    protected OutputStream out;
    protected boolean outNeedsEnd;
    protected PacketLineIn pckIn;
    protected PacketLineOut pckOut;
    protected boolean statelessRPC;
    protected TimeoutInputStream timeoutIn;
    protected TimeoutOutputStream timeoutOut;
    protected final Transport transport;
    protected final URIish uri;
    private final Map<String, String> remoteCapabilities = new HashMap();
    protected final Set<ObjectId> additionalHaves = new HashSet();
    private TransferConfig.ProtocolVersion protocol = TransferConfig.ProtocolVersion.V0;

    /* JADX WARN: Multi-variable type inference failed */
    BasePackConnection(PackTransport packTransport) {
        Transport transport = (Transport) packTransport;
        this.transport = transport;
        this.local = transport.local;
        this.uri = transport.uri;
    }

    TransferConfig.ProtocolVersion getProtocolVersion() {
        return this.protocol;
    }

    void setProtocolVersion(TransferConfig.ProtocolVersion protocolVersion) {
        this.protocol = protocolVersion;
    }

    protected final void init(InputStream inputStream, OutputStream outputStream) {
        int timeout = this.transport.getTimeout();
        if (timeout > 0) {
            Thread threadCurrentThread = Thread.currentThread();
            if (this.myTimer == null) {
                this.myTimer = new InterruptTimer(threadCurrentThread.getName() + "-Timer");
            }
            this.timeoutIn = new TimeoutInputStream(inputStream, this.myTimer);
            this.timeoutOut = new TimeoutOutputStream(outputStream, this.myTimer);
            int i = timeout * 1000;
            this.timeoutIn.setTimeout(i);
            this.timeoutOut.setTimeout(i);
            inputStream = this.timeoutIn;
            outputStream = this.timeoutOut;
        }
        this.in = inputStream;
        this.out = outputStream;
        this.pckIn = new PacketLineIn(this.in);
        this.pckOut = new PacketLineOut(this.out);
        this.outNeedsEnd = true;
    }

    protected boolean readAdvertisedRefs() throws TransportException {
        try {
            return readAdvertisedRefsImpl();
        } catch (RuntimeException e) {
            e = e;
            close();
            throw new TransportException(e.getMessage(), e);
        } catch (TransportException e2) {
            close();
            throw e2;
        } catch (IOException e3) {
            e = e3;
            close();
            throw new TransportException(e.getMessage(), e);
        }
    }

    private String readLine() throws IOException {
        String string = this.pckIn.readString();
        if (PacketLineIn.isEnd(string)) {
            return null;
        }
        if (string.startsWith(GitProtocolConstants.PACKET_ERR)) {
            throw new RemoteRepositoryException(this.uri, string.substring(4));
        }
        return string;
    }

    private boolean readAdvertisedRefsImpl() throws IOException {
        String line;
        boolean z;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        boolean z2 = true;
        while (true) {
            if (z2) {
                try {
                    line = readLine();
                    if (line == null || !GitProtocolConstants.VERSION_1.equals(line)) {
                        z = false;
                    } else {
                        setProtocolVersion(TransferConfig.ProtocolVersion.V0);
                        line = readLine();
                        z = true;
                    }
                    if (line == null) {
                        break;
                    }
                    int iIndexOf = line.indexOf(0);
                    if (iIndexOf >= 0) {
                        for (String str : line.substring(iIndexOf + 1).split(" ")) {
                            if (str.startsWith(CAPABILITY_SYMREF_PREFIX)) {
                                String[] strArrSplit = str.substring(CAPABILITY_SYMREF_PREFIX.length()).split(CollectionUtils.COLON, 2);
                                if (strArrSplit.length == 2) {
                                    linkedHashMap2.put(strArrSplit[0], strArrSplit[1]);
                                }
                            } else {
                                addCapability(str);
                            }
                        }
                        line = line.substring(0, iIndexOf);
                        setProtocolVersion(TransferConfig.ProtocolVersion.V0);
                    } else {
                        if (!z && GitProtocolConstants.VERSION_2.equals(line)) {
                            setProtocolVersion(TransferConfig.ProtocolVersion.V2);
                            readCapabilitiesV2();
                            return false;
                        }
                        setProtocolVersion(TransferConfig.ProtocolVersion.V0);
                    }
                    if (line.length() >= 41 || line.charAt(40) != ' ') {
                        throw invalidRefAdvertisementLine(line);
                    }
                    String strSubstring = line.substring(41, line.length());
                    if (!z2 || !strSubstring.equals("capabilities^{}")) {
                        ObjectId id2 = toId(line, line.substring(0, 40));
                        if (strSubstring.equals(".have")) {
                            this.additionalHaves.add(id2);
                        } else {
                            processLineV1(strSubstring, id2, linkedHashMap);
                        }
                    }
                    z2 = false;
                } catch (EOFException e) {
                    throw noRepository(e);
                }
            } else {
                line = readLine();
                if (line == null) {
                    break;
                }
                if (line.length() >= 41) {
                }
                throw invalidRefAdvertisementLine(line);
            }
        }
        updateWithSymRefs(linkedHashMap, linkedHashMap2);
        available(linkedHashMap);
        return true;
    }

    protected void lsRefs(Collection<RefSpec> collection, String... strArr) throws TransportException {
        try {
            lsRefsImpl(collection, strArr);
        } catch (RuntimeException e) {
            e = e;
            close();
            throw new TransportException(e.getMessage(), e);
        } catch (TransportException e2) {
            close();
            throw e2;
        } catch (IOException e3) {
            e = e3;
            close();
            throw new TransportException(e.getMessage(), e);
        }
    }

    private void lsRefsImpl(Collection<RefSpec> collection, String... strArr) throws IOException {
        this.pckOut.writeString("command=ls-refs");
        String str = UserAgent.get();
        if (str != null && isCapableOf(GitProtocolConstants.OPTION_AGENT)) {
            this.pckOut.writeString("agent=" + str);
        }
        this.pckOut.writeDelim();
        this.pckOut.writeString("peel");
        this.pckOut.writeString("symrefs");
        Iterator<String> it = getRefPrefixes(collection, strArr).iterator();
        while (it.hasNext()) {
            this.pckOut.writeString("ref-prefix " + it.next());
        }
        this.pckOut.end();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        while (true) {
            String line = readLine();
            if (line != null) {
                if (line.length() < 41 || line.charAt(40) != ' ') {
                    throw invalidRefAdvertisementLine(line);
                }
                String strSubstring = line.substring(41, line.length());
                ObjectId id2 = toId(line, line.substring(0, 40));
                if (strSubstring.equals(".have")) {
                    this.additionalHaves.add(id2);
                } else {
                    processLineV2(line, id2, strSubstring, linkedHashMap, linkedHashMap2);
                }
            } else {
                updateWithSymRefs(linkedHashMap, linkedHashMap2);
                available(linkedHashMap);
                return;
            }
        }
    }

    private Collection<String> getRefPrefixes(Collection<RefSpec> collection, String... strArr) {
        if (collection.isEmpty() && (strArr == null || strArr.length == 0)) {
            return Collections.emptyList();
        }
        HashSet hashSet = new HashSet();
        if (strArr != null) {
            Arrays.stream(strArr).filter(new BasePackConnection$$ExternalSyntheticLambda0()).forEach(new BasePackConnection$$ExternalSyntheticLambda1(hashSet));
        }
        for (RefSpec refSpec : collection) {
            String source = refSpec.getSource();
            if (!ObjectId.isId(source)) {
                if (refSpec.isWildcard()) {
                    hashSet.add(source.substring(0, source.indexOf(42)));
                } else {
                    hashSet.add(source);
                    hashSet.add(Constants.R_REFS + source);
                    hashSet.add(Constants.R_HEADS + source);
                    hashSet.add(Constants.R_TAGS + source);
                }
            }
        }
        return hashSet;
    }

    private void readCapabilitiesV2() throws IOException {
        while (true) {
            String line = readLine();
            if (line == null) {
                return;
            } else {
                addCapability(line);
            }
        }
    }

    private void addCapability(String str) {
        String[] strArrSplit = str.split("=", 2);
        if (strArrSplit.length == 2) {
            this.remoteCapabilities.put(strArrSplit[0], strArrSplit[1]);
        }
        this.remoteCapabilities.put(str, null);
    }

    private ObjectId toId(String str, String str2) throws PackProtocolException {
        try {
            return ObjectId.fromString(str2);
        } catch (InvalidObjectIdException e) {
            PackProtocolException packProtocolExceptionInvalidRefAdvertisementLine = invalidRefAdvertisementLine(str);
            packProtocolExceptionInvalidRefAdvertisementLine.initCause(e);
            throw packProtocolExceptionInvalidRefAdvertisementLine;
        }
    }

    private void processLineV1(String str, ObjectId objectId, Map<String, Ref> map) throws IOException {
        if (str.endsWith("^{}")) {
            String strSubstring = str.substring(0, str.length() - 3);
            Ref ref = map.get(strSubstring);
            if (ref == null) {
                throw new PackProtocolException(this.uri, MessageFormat.format(JGitText.get().advertisementCameBefore, strSubstring, strSubstring));
            }
            if (ref.getPeeledObjectId() != null) {
                throw duplicateAdvertisement(strSubstring + "^{}");
            }
            map.put(strSubstring, new ObjectIdRef.PeeledTag(Ref.Storage.NETWORK, strSubstring, ref.getObjectId(), objectId));
            return;
        }
        if (map.put(str, new ObjectIdRef.PeeledNonTag(Ref.Storage.NETWORK, str, objectId)) != null) {
            throw duplicateAdvertisement(str);
        }
    }

    private void processLineV2(String str, ObjectId objectId, String str2, Map<String, Ref> map, Map<String, String> map2) throws IOException {
        Ref peeledNonTag;
        String[] strArrSplit = str2.split(" ");
        String str3 = strArrSplit[0];
        String strSubstring = null;
        String strSubstring2 = null;
        for (int i = 1; i < strArrSplit.length; i++) {
            if (strArrSplit[i].startsWith(GitProtocolConstants.REF_ATTR_SYMREF_TARGET)) {
                if (strSubstring != null) {
                    throw new PackProtocolException(this.uri, MessageFormat.format(JGitText.get().duplicateRefAttribute, str));
                }
                strSubstring = strArrSplit[i].substring(GitProtocolConstants.REF_ATTR_SYMREF_TARGET.length());
            } else if (strArrSplit[i].startsWith(GitProtocolConstants.REF_ATTR_PEELED)) {
                if (strSubstring2 != null) {
                    throw new PackProtocolException(this.uri, MessageFormat.format(JGitText.get().duplicateRefAttribute, str));
                }
                strSubstring2 = strArrSplit[i].substring(GitProtocolConstants.REF_ATTR_PEELED.length());
            }
            if (strSubstring2 != null && strSubstring != null) {
                break;
            }
        }
        if (strSubstring2 != null) {
            peeledNonTag = new ObjectIdRef.PeeledTag(Ref.Storage.NETWORK, str3, objectId, toId(str, strSubstring2));
        } else {
            peeledNonTag = new ObjectIdRef.PeeledNonTag(Ref.Storage.NETWORK, str3, objectId);
        }
        if (map.put(str3, peeledNonTag) != null) {
            throw duplicateAdvertisement(str3);
        }
        if (StringUtils.isEmptyOrNull(strSubstring)) {
            return;
        }
        map2.put(str3, strSubstring);
    }

    static void updateWithSymRefs(Map<String, Ref> map, Map<String, String> map2) {
        Ref ref;
        boolean z;
        Ref ref2;
        for (boolean z2 = !map.isEmpty(); !map2.isEmpty() && z2; z2 = z) {
            Iterator<Map.Entry<String, String>> it = map2.entrySet().iterator();
            z = false;
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                if (!map2.containsKey(next.getValue()) && (ref2 = map.get(next.getValue())) != null) {
                    map.put(next.getKey(), new SymbolicRef(next.getKey(), ref2));
                    it.remove();
                    z = true;
                }
            }
        }
        String str = map2.get("HEAD");
        if (str == null || map.containsKey(str) || (ref = map.get("HEAD")) == null) {
            return;
        }
        ObjectIdRef.PeeledNonTag peeledNonTag = new ObjectIdRef.PeeledNonTag(Ref.Storage.NETWORK, str, ref.getObjectId());
        map.put(str, peeledNonTag);
        map.put("HEAD", new SymbolicRef("HEAD", peeledNonTag));
        map2.remove("HEAD");
    }

    protected TransportException noRepository(Throwable th) {
        return new NoRemoteRepositoryException(this.uri, JGitText.get().notFound, th);
    }

    protected boolean isCapableOf(String str) {
        return this.remoteCapabilities.containsKey(str);
    }

    protected boolean wantCapability(StringBuilder sb, String str) {
        if (!isCapableOf(str)) {
            return false;
        }
        sb.append(TokenParser.SP);
        sb.append(str);
        return true;
    }

    protected String getCapability(String str) {
        return this.remoteCapabilities.get(str);
    }

    protected void addUserAgentCapability(StringBuilder sb) {
        String str = UserAgent.get();
        if (str == null || this.remoteCapabilities.get(GitProtocolConstants.OPTION_AGENT) == null) {
            return;
        }
        sb.append(TokenParser.SP).append(GitProtocolConstants.OPTION_AGENT).append('=').append(str);
    }

    @Override // org.eclipse.jgit.transport.BaseConnection, org.eclipse.jgit.transport.Connection
    public String getPeerUserAgent() {
        String str = this.remoteCapabilities.get(GitProtocolConstants.OPTION_AGENT);
        return str != null ? str : super.getPeerUserAgent();
    }

    private PackProtocolException duplicateAdvertisement(String str) {
        return new PackProtocolException(this.uri, MessageFormat.format(JGitText.get().duplicateAdvertisementsOf, str));
    }

    private PackProtocolException invalidRefAdvertisementLine(String str) {
        return new PackProtocolException(this.uri, MessageFormat.format(JGitText.get().invalidRefAdvertisementLine, str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.eclipse.jgit.transport.BaseConnection, org.eclipse.jgit.transport.Connection, java.lang.AutoCloseable
    public void close() {
        if (this.out != null) {
            try {
                if (this.outNeedsEnd) {
                    this.outNeedsEnd = false;
                    this.pckOut.end();
                }
                this.out.close();
            } catch (IOException unused) {
            } finally {
                this.out = null;
                this.pckOut = null;
            }
        }
        InputStream inputStream = this.in;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused2) {
            } finally {
                this.in = null;
                this.pckIn = null;
            }
        }
        InterruptTimer interruptTimer = this.myTimer;
        if (interruptTimer != null) {
            try {
                interruptTimer.terminate();
            } finally {
                this.myTimer = null;
                this.timeoutIn = null;
                this.timeoutOut = null;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void endOut() {
        if (!this.outNeedsEnd || this.out == null) {
            return;
        }
        try {
            this.outNeedsEnd = false;
            this.pckOut.end();
        } catch (IOException unused) {
            try {
                this.out.close();
            } catch (IOException unused2) {
            } finally {
                this.out = null;
                this.pckOut = null;
            }
        }
    }
}
