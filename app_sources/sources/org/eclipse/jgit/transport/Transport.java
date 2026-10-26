package org.eclipse.jgit.transport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.errors.NotSupportedException;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.hooks.Hooks;
import org.eclipse.jgit.hooks.PrePushHook;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectChecker;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.pack.PackConfig;

/* INFO: loaded from: classes5.dex */
public abstract class Transport implements AutoCloseable {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$Transport$Operation = null;
    public static final boolean DEFAULT_FETCH_THIN = true;
    public static final boolean DEFAULT_PUSH_THIN = false;
    public static final boolean DEFAULT_PUSH_USE_BITMAPS = true;
    public static final RefSpec REFSPEC_PUSH_ALL;
    public static final RefSpec REFSPEC_TAGS;
    private static final List<WeakReference<TransportProtocol>> protocols = new CopyOnWriteArrayList();
    private CredentialsProvider credentialsProvider;
    private List<String> deepenNots;
    private Instant deepenSince;
    private Integer depth;
    private boolean dryRun;
    private List<RefSpec> fetch;
    private boolean fetchThin;
    private FilterSpec filterSpec;
    private PrintStream hookErrRedirect;
    private PrintStream hookOutRedirect;
    protected final Repository local;
    private ObjectChecker objectChecker;
    private String optionReceivePack;
    private String optionUploadPack;
    private PackConfig packConfig;

    @Nullable
    TransferConfig.ProtocolVersion protocol;
    private List<RefSpec> push;
    private boolean pushAtomic;
    private List<String> pushOptions;
    private boolean pushThin;
    private boolean pushUseBitmaps;
    private String remoteName;
    private boolean removeDeletedRefs;
    private TagOpt tagopt;
    private int timeout;
    protected final URIish uri;

    public enum Operation {
        FETCH,
        PUSH;

        /* INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static Operation[] valuesCustom() {
            Operation[] operationArrValuesCustom = values();
            int length = operationArrValuesCustom.length;
            Operation[] operationArr = new Operation[length];
            System.arraycopy(operationArrValuesCustom, 0, operationArr, 0, length);
            return operationArr;
        }
    }

    @Override // java.lang.AutoCloseable
    public abstract void close();

    public abstract FetchConnection openFetch() throws NotSupportedException, TransportException;

    public abstract PushConnection openPush() throws NotSupportedException, TransportException;

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$Transport$Operation() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$transport$Transport$Operation;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[Operation.valuesCustom().length];
        try {
            iArr2[Operation.FETCH.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[Operation.PUSH.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$transport$Transport$Operation = iArr2;
        return iArr2;
    }

    static {
        register(TransportLocal.PROTO_LOCAL);
        register(TransportBundleFile.PROTO_BUNDLE);
        register(TransportAmazonS3.PROTO_S3);
        register(TransportGitAnon.PROTO_GIT);
        register(TransportSftp.PROTO_SFTP);
        register(TransportHttp.PROTO_FTP);
        register(TransportHttp.PROTO_HTTP);
        register(TransportGitSsh.PROTO_SSH);
        registerByService();
        REFSPEC_TAGS = new RefSpec("refs/tags/*:refs/tags/*");
        REFSPEC_PUSH_ALL = new RefSpec("refs/heads/*:refs/heads/*");
    }

    private static void registerByService() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            contextClassLoader = Transport.class.getClassLoader();
        }
        Enumeration<URL> enumerationCatalogs = catalogs(contextClassLoader);
        while (enumerationCatalogs.hasMoreElements()) {
            scan(contextClassLoader, enumerationCatalogs.nextElement());
        }
    }

    private static Enumeration<URL> catalogs(ClassLoader classLoader) {
        try {
            return classLoader.getResources("META-INF/services/" + Transport.class.getName());
        } catch (IOException unused) {
            return Collections.emptyEnumeration();
        }
    }

    private static void scan(ClassLoader classLoader, URL url) {
        int iIndexOf;
        Throwable th = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        String strTrim = line.trim();
                        if (strTrim.length() != 0 && (iIndexOf = strTrim.indexOf(35)) != 0) {
                            if (iIndexOf != -1) {
                                strTrim = strTrim.substring(0, iIndexOf).trim();
                            }
                            load(classLoader, strTrim);
                        }
                    } else {
                        bufferedReader.close();
                        return;
                    }
                } catch (Throwable th2) {
                    bufferedReader.close();
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            if (0 == 0) {
                throw th3;
            }
            if (null != th3) {
                try {
                    th.addSuppressed(th3);
                } catch (IOException unused) {
                    return;
                }
            }
            throw null;
        }
    }

    private static void load(ClassLoader classLoader, String str) {
        try {
            for (Field field : Class.forName(str, false, classLoader).getDeclaredFields()) {
                if ((field.getModifiers() & 8) == 8 && TransportProtocol.class.isAssignableFrom(field.getType())) {
                    try {
                        TransportProtocol transportProtocol = (TransportProtocol) field.get(null);
                        if (transportProtocol != null) {
                            register(transportProtocol);
                        }
                    } catch (IllegalAccessException | IllegalArgumentException unused) {
                    }
                }
            }
        } catch (ClassNotFoundException unused2) {
        }
    }

    public static void register(TransportProtocol transportProtocol) {
        protocols.add(0, new WeakReference<>(transportProtocol));
    }

    public static void unregister(TransportProtocol transportProtocol) {
        for (WeakReference<TransportProtocol> weakReference : protocols) {
            TransportProtocol transportProtocol2 = weakReference.get();
            if (transportProtocol2 == null || transportProtocol2 == transportProtocol) {
                protocols.remove(weakReference);
            }
        }
    }

    public static List<TransportProtocol> getTransportProtocols() {
        List<WeakReference<TransportProtocol>> list = protocols;
        ArrayList arrayList = new ArrayList(list.size());
        for (WeakReference<TransportProtocol> weakReference : list) {
            TransportProtocol transportProtocol = weakReference.get();
            if (transportProtocol != null) {
                arrayList.add(transportProtocol);
            } else {
                protocols.remove(weakReference);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static Transport open(Repository repository, String str) throws URISyntaxException, NotSupportedException, TransportException {
        return open(repository, str, Operation.FETCH);
    }

    public static Transport open(Repository repository, String str, Operation operation) throws URISyntaxException, NotSupportedException, TransportException {
        if (repository != null) {
            RemoteConfig remoteConfig = new RemoteConfig(repository.getConfig(), str);
            if (doesNotExist(remoteConfig)) {
                return open(repository, new URIish(str), (String) null);
            }
            return open(repository, remoteConfig, operation);
        }
        return open(new URIish(str));
    }

    public static List<Transport> openAll(Repository repository, String str) throws URISyntaxException, NotSupportedException, TransportException {
        return openAll(repository, str, Operation.FETCH);
    }

    public static List<Transport> openAll(Repository repository, String str, Operation operation) throws URISyntaxException, NotSupportedException, TransportException {
        RemoteConfig remoteConfig = new RemoteConfig(repository.getConfig(), str);
        if (doesNotExist(remoteConfig)) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(open(repository, new URIish(str), (String) null));
            return arrayList;
        }
        return openAll(repository, remoteConfig, operation);
    }

    public static Transport open(Repository repository, RemoteConfig remoteConfig) throws NotSupportedException, TransportException {
        return open(repository, remoteConfig, Operation.FETCH);
    }

    public static Transport open(Repository repository, RemoteConfig remoteConfig, Operation operation) throws NotSupportedException, TransportException {
        List<URIish> uRIs = getURIs(remoteConfig, operation);
        if (uRIs.isEmpty()) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().remoteConfigHasNoURIAssociated, remoteConfig.getName()));
        }
        Transport transportOpen = open(repository, uRIs.get(0), remoteConfig.getName());
        transportOpen.applyConfig(remoteConfig);
        return transportOpen;
    }

    public static List<Transport> openAll(Repository repository, RemoteConfig remoteConfig) throws NotSupportedException, TransportException {
        return openAll(repository, remoteConfig, Operation.FETCH);
    }

    public static List<Transport> openAll(Repository repository, RemoteConfig remoteConfig, Operation operation) throws NotSupportedException, TransportException {
        List<URIish> uRIs = getURIs(remoteConfig, operation);
        ArrayList arrayList = new ArrayList(uRIs.size());
        Iterator<URIish> it = uRIs.iterator();
        while (it.hasNext()) {
            Transport transportOpen = open(repository, it.next(), remoteConfig.getName());
            transportOpen.applyConfig(remoteConfig);
            arrayList.add(transportOpen);
        }
        return arrayList;
    }

    private static List<URIish> getURIs(RemoteConfig remoteConfig, Operation operation) {
        int i = $SWITCH_TABLE$org$eclipse$jgit$transport$Transport$Operation()[operation.ordinal()];
        if (i == 1) {
            return remoteConfig.getURIs();
        }
        if (i == 2) {
            List<URIish> pushURIs = remoteConfig.getPushURIs();
            return pushURIs.isEmpty() ? remoteConfig.getURIs() : pushURIs;
        }
        throw new IllegalArgumentException(operation.toString());
    }

    private static boolean doesNotExist(RemoteConfig remoteConfig) {
        return remoteConfig.getURIs().isEmpty() && remoteConfig.getPushURIs().isEmpty();
    }

    public static Transport open(Repository repository, URIish uRIish) throws NotSupportedException, TransportException {
        return open(repository, uRIish, (String) null);
    }

    public static Transport open(Repository repository, URIish uRIish, String str) throws NotSupportedException, TransportException {
        for (WeakReference<TransportProtocol> weakReference : protocols) {
            TransportProtocol transportProtocol = weakReference.get();
            if (transportProtocol == null) {
                protocols.remove(weakReference);
            } else if (transportProtocol.canHandle(uRIish, repository, str)) {
                Transport transportOpen = transportProtocol.open(uRIish, repository, str);
                transportOpen.remoteName = str;
                return transportOpen;
            }
        }
        throw new NotSupportedException(MessageFormat.format(JGitText.get().URINotSupported, uRIish));
    }

    public static Transport open(URIish uRIish) throws NotSupportedException, TransportException {
        for (WeakReference<TransportProtocol> weakReference : protocols) {
            TransportProtocol transportProtocol = weakReference.get();
            if (transportProtocol == null) {
                protocols.remove(weakReference);
            } else if (transportProtocol.canHandle(uRIish, null, null)) {
                return transportProtocol.open(uRIish);
            }
        }
        throw new NotSupportedException(MessageFormat.format(JGitText.get().URINotSupported, uRIish));
    }

    public static Collection<RemoteRefUpdate> findRemoteRefUpdatesFor(Repository repository, Collection<RefSpec> collection, Map<String, RefLeaseSpec> map, Collection<RefSpec> collection2) throws IOException {
        if (collection2 == null) {
            collection2 = Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (RefSpec refSpec : expandPushWildcardsFor(repository, collection)) {
            if (refSpec.isMatching()) {
                arrayList.add(new RemoteRefUpdate(repository, refSpec.isForceUpdate(), collection2));
            } else {
                String source = refSpec.getSource();
                Ref refFindRef = repository.findRef(source);
                if (refFindRef != null) {
                    source = refFindRef.getName();
                }
                String str = source;
                String destination = refSpec.getDestination();
                if (destination == null) {
                    destination = str;
                }
                if (refFindRef != null && !destination.startsWith(Constants.R_REFS)) {
                    String name = refFindRef.getName();
                    destination = name.substring(0, name.indexOf(47, Constants.R_REFS.length()) + 1) + destination;
                }
                String str2 = destination;
                boolean zIsForceUpdate = refSpec.isForceUpdate();
                String strFindTrackingRefName = findTrackingRefName(str2, collection2);
                RefLeaseSpec refLeaseSpec = map.get(str2);
                arrayList.add(new RemoteRefUpdate(repository, str, str2, zIsForceUpdate, strFindTrackingRefName, refLeaseSpec == null ? null : repository.resolve(refLeaseSpec.getExpected())));
            }
        }
        return arrayList;
    }

    public static Collection<RemoteRefUpdate> findRemoteRefUpdatesFor(Repository repository, Collection<RefSpec> collection, Collection<RefSpec> collection2) throws IOException {
        return findRemoteRefUpdatesFor(repository, collection, Collections.emptyMap(), collection2);
    }

    private static Collection<RefSpec> expandPushWildcardsFor(Repository repository, Collection<RefSpec> collection) throws IOException {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        List<Ref> refs = null;
        for (RefSpec refSpec : collection) {
            if (!refSpec.isMatching() && refSpec.isWildcard()) {
                if (refs == null) {
                    refs = repository.getRefDatabase().getRefs();
                }
                List<Ref> list = refs;
                for (Ref ref : list) {
                    if (refSpec.matchSource(ref)) {
                        linkedHashSet.add(refSpec.expandFromSource(ref));
                    }
                }
                refs = list;
            } else {
                linkedHashSet.add(refSpec);
            }
        }
        return linkedHashSet;
    }

    static String findTrackingRefName(String str, Collection<RefSpec> collection) {
        for (RefSpec refSpec : collection) {
            if (refSpec.matchSource(str)) {
                if (refSpec.isWildcard()) {
                    return refSpec.expandFromSource(str).getDestination();
                }
                return refSpec.getDestination();
            }
        }
        return null;
    }

    protected Transport(Repository repository, URIish uRIish) {
        this.optionUploadPack = RemoteConfig.DEFAULT_UPLOAD_PACK;
        this.fetch = Collections.emptyList();
        this.tagopt = TagOpt.NO_TAGS;
        this.fetchThin = true;
        this.optionReceivePack = RemoteConfig.DEFAULT_RECEIVE_PACK;
        this.push = Collections.emptyList();
        this.pushThin = false;
        this.pushUseBitmaps = true;
        this.filterSpec = FilterSpec.NO_FILTER;
        this.deepenNots = new ArrayList();
        TransferConfig transferConfig = (TransferConfig) repository.getConfig().get(TransferConfig.KEY);
        this.local = repository;
        this.uri = uRIish;
        this.protocol = transferConfig.protocolVersion;
        this.objectChecker = transferConfig.newObjectChecker();
        this.credentialsProvider = CredentialsProvider.getDefault();
    }

    protected Transport(URIish uRIish) {
        this.optionUploadPack = RemoteConfig.DEFAULT_UPLOAD_PACK;
        this.fetch = Collections.emptyList();
        this.tagopt = TagOpt.NO_TAGS;
        this.fetchThin = true;
        this.optionReceivePack = RemoteConfig.DEFAULT_RECEIVE_PACK;
        this.push = Collections.emptyList();
        this.pushThin = false;
        this.pushUseBitmaps = true;
        this.filterSpec = FilterSpec.NO_FILTER;
        this.deepenNots = new ArrayList();
        this.uri = uRIish;
        this.local = null;
        this.objectChecker = new ObjectChecker();
        this.credentialsProvider = CredentialsProvider.getDefault();
    }

    public URIish getURI() {
        return this.uri;
    }

    public String getOptionUploadPack() {
        return this.optionUploadPack;
    }

    public void setOptionUploadPack(String str) {
        if (str != null && str.length() > 0) {
            this.optionUploadPack = str;
        } else {
            this.optionUploadPack = RemoteConfig.DEFAULT_UPLOAD_PACK;
        }
    }

    public void setHookOutputStream(PrintStream printStream) {
        this.hookOutRedirect = printStream;
    }

    public void setHookErrorStream(PrintStream printStream) {
        this.hookErrRedirect = printStream;
    }

    public TagOpt getTagOpt() {
        return this.tagopt;
    }

    public void setTagOpt(TagOpt tagOpt) {
        if (tagOpt == null) {
            tagOpt = TagOpt.AUTO_FOLLOW;
        }
        this.tagopt = tagOpt;
    }

    public boolean isFetchThin() {
        return this.fetchThin;
    }

    public void setFetchThin(boolean z) {
        this.fetchThin = z;
    }

    public boolean isCheckFetchedObjects() {
        return getObjectChecker() != null;
    }

    public void setCheckFetchedObjects(boolean z) {
        if (z && this.objectChecker == null) {
            setObjectChecker(new ObjectChecker());
        } else {
            if (z || this.objectChecker == null) {
                return;
            }
            setObjectChecker(null);
        }
    }

    public ObjectChecker getObjectChecker() {
        return this.objectChecker;
    }

    public void setObjectChecker(ObjectChecker objectChecker) {
        this.objectChecker = objectChecker;
    }

    public String getOptionReceivePack() {
        return this.optionReceivePack;
    }

    public void setOptionReceivePack(String str) {
        if (str != null && str.length() > 0) {
            this.optionReceivePack = str;
        } else {
            this.optionReceivePack = RemoteConfig.DEFAULT_RECEIVE_PACK;
        }
    }

    public boolean isPushThin() {
        return this.pushThin;
    }

    public void setPushThin(boolean z) {
        this.pushThin = z;
    }

    public boolean isPushAtomic() {
        return this.pushAtomic;
    }

    public void setPushAtomic(boolean z) {
        this.pushAtomic = z;
    }

    public boolean isPushUseBitmaps() {
        return this.pushUseBitmaps;
    }

    public void setPushUseBitmaps(boolean z) {
        this.pushUseBitmaps = z;
    }

    public boolean isRemoveDeletedRefs() {
        return this.removeDeletedRefs;
    }

    public void setRemoveDeletedRefs(boolean z) {
        this.removeDeletedRefs = z;
    }

    public final FilterSpec getFilterSpec() {
        return this.filterSpec;
    }

    public final void setFilterSpec(FilterSpec filterSpec) {
        this.filterSpec = (FilterSpec) Objects.requireNonNull(filterSpec);
    }

    public final Integer getDepth() {
        return this.depth;
    }

    public final void setDepth(int i) {
        if (i < 1) {
            throw new IllegalArgumentException(JGitText.get().depthMustBeAt1);
        }
        this.depth = Integer.valueOf(i);
    }

    public final void setDepth(Integer num) {
        if (num != null && num.intValue() < 1) {
            throw new IllegalArgumentException(JGitText.get().depthMustBeAt1);
        }
        this.depth = num;
    }

    public final Instant getDeepenSince() {
        return this.deepenSince;
    }

    public final void setDeepenSince(Instant instant) {
        this.deepenSince = instant;
    }

    public final List<String> getDeepenNots() {
        return this.deepenNots;
    }

    public final void setDeepenNots(List<String> list) {
        this.deepenNots = list;
    }

    public void applyConfig(RemoteConfig remoteConfig) {
        setOptionUploadPack(remoteConfig.getUploadPack());
        setOptionReceivePack(remoteConfig.getReceivePack());
        setTagOpt(remoteConfig.getTagOpt());
        this.fetch = remoteConfig.getFetchRefSpecs();
        this.push = remoteConfig.getPushRefSpecs();
        this.timeout = remoteConfig.getTimeout();
    }

    public boolean isDryRun() {
        return this.dryRun;
    }

    public void setDryRun(boolean z) {
        this.dryRun = z;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public void setTimeout(int i) {
        this.timeout = i;
    }

    public PackConfig getPackConfig() {
        if (this.packConfig == null) {
            this.packConfig = new PackConfig(this.local);
        }
        return this.packConfig;
    }

    public void setPackConfig(PackConfig packConfig) {
        this.packConfig = packConfig;
    }

    public void setCredentialsProvider(CredentialsProvider credentialsProvider) {
        this.credentialsProvider = credentialsProvider;
    }

    public CredentialsProvider getCredentialsProvider() {
        return this.credentialsProvider;
    }

    public List<String> getPushOptions() {
        return this.pushOptions;
    }

    public void setPushOptions(List<String> list) {
        this.pushOptions = list;
    }

    public FetchResult fetch(ProgressMonitor progressMonitor, Collection<RefSpec> collection) throws NotSupportedException, TransportException {
        return fetch(progressMonitor, collection, null);
    }

    public FetchResult fetch(ProgressMonitor progressMonitor, Collection<RefSpec> collection, String str) throws NotSupportedException, TransportException {
        if (collection == null || collection.isEmpty()) {
            if (this.fetch.isEmpty()) {
                throw new TransportException(JGitText.get().nothingToFetch);
            }
            collection = this.fetch;
        } else if (!this.fetch.isEmpty()) {
            ArrayList arrayList = new ArrayList(collection);
            Iterator<RefSpec> it = collection.iterator();
            while (it.hasNext()) {
                String source = it.next().getSource();
                for (RefSpec refSpec : this.fetch) {
                    String source2 = refSpec.getSource();
                    String destination = refSpec.getDestination();
                    if (source2.equals(source) && destination != null) {
                        arrayList.add(refSpec);
                        break;
                    }
                }
            }
            collection = arrayList;
        }
        FetchResult fetchResult = new FetchResult();
        new FetchProcess(this, collection).execute(progressMonitor, fetchResult, str);
        this.local.autoGC(progressMonitor);
        return fetchResult;
    }

    public PushResult push(ProgressMonitor progressMonitor, Collection<RemoteRefUpdate> collection, OutputStream outputStream) throws TransportException, NotSupportedException {
        PrePushHook prePushHookPrePush;
        if (collection == null || collection.isEmpty()) {
            try {
                collection = findRemoteRefUpdatesFor(this.push);
                if (collection.isEmpty()) {
                    throw new TransportException(JGitText.get().nothingToPush);
                }
            } catch (IOException e) {
                throw new TransportException(MessageFormat.format(JGitText.get().problemWithResolvingPushRefSpecsLocally, e.getMessage()), e);
            }
        }
        Repository repository = this.local;
        if (repository != null) {
            prePushHookPrePush = Hooks.prePush(repository, this.hookOutRedirect, this.hookErrRedirect);
            prePushHookPrePush.setRemoteLocation(this.uri.toString());
            prePushHookPrePush.setRemoteName(this.remoteName);
        } else {
            prePushHookPrePush = null;
        }
        return new PushProcess(this, collection, prePushHookPrePush, outputStream).execute(progressMonitor);
    }

    public PushResult push(ProgressMonitor progressMonitor, Collection<RemoteRefUpdate> collection) throws NotSupportedException, TransportException {
        return push(progressMonitor, collection, null);
    }

    public Collection<RemoteRefUpdate> findRemoteRefUpdatesFor(Collection<RefSpec> collection) throws IOException {
        return findRemoteRefUpdatesFor(this.local, collection, Collections.emptyMap(), this.fetch);
    }

    public Collection<RemoteRefUpdate> findRemoteRefUpdatesFor(Collection<RefSpec> collection, Map<String, RefLeaseSpec> map) throws IOException {
        return findRemoteRefUpdatesFor(this.local, collection, map, this.fetch);
    }

    public FetchConnection openFetch(Collection<RefSpec> collection, String... strArr) throws NotSupportedException, TransportException {
        return openFetch();
    }
}
