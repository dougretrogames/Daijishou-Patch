package org.eclipse.jgit.api;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.api.errors.DetachedHeadException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.errors.NotSupportedException;
import org.eclipse.jgit.errors.TooLargeObjectInPackException;
import org.eclipse.jgit.errors.TooLargePackException;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.BranchConfig;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.NullProgressMonitor;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.transport.PushConfig;
import org.eclipse.jgit.transport.PushResult;
import org.eclipse.jgit.transport.RefLeaseSpec;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.RemoteConfig;
import org.eclipse.jgit.transport.Transport;

/* JADX INFO: loaded from: classes5.dex */
public class PushCommand extends TransportCommand<PushCommand, Iterable<PushResult>> {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$PushConfig$PushDefault;
    private boolean atomic;
    private boolean dryRun;
    private boolean force;
    private PrintStream hookErrRedirect;
    private PrintStream hookOutRedirect;
    private ProgressMonitor monitor;
    private OutputStream out;
    private PushConfig.PushDefault pushDefault;
    private List<String> pushOptions;
    private String receivePack;
    private final Map<String, RefLeaseSpec> refLeaseSpecs;
    private final List<RefSpec> refSpecs;
    private String remote;
    private boolean thin;
    private boolean useBitmaps;

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$PushConfig$PushDefault() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$transport$PushConfig$PushDefault;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[PushConfig.PushDefault.valuesCustom().length];
        try {
            iArr2[PushConfig.PushDefault.CURRENT.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[PushConfig.PushDefault.MATCHING.ordinal()] = 5;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[PushConfig.PushDefault.NOTHING.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[PushConfig.PushDefault.SIMPLE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[PushConfig.PushDefault.UPSTREAM.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$transport$PushConfig$PushDefault = iArr2;
        return iArr2;
    }

    protected PushCommand(Repository repository) {
        super(repository);
        this.monitor = NullProgressMonitor.INSTANCE;
        this.receivePack = RemoteConfig.DEFAULT_RECEIVE_PACK;
        this.thin = false;
        this.useBitmaps = true;
        this.pushDefault = PushConfig.PushDefault.CURRENT;
        this.refSpecs = new ArrayList(3);
        this.refLeaseSpecs = new HashMap();
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public Iterable<PushResult> call() throws GitAPIException {
        checkCallable();
        setCallable(false);
        ArrayList arrayList = new ArrayList(3);
        try {
            StoredConfig config = this.repo.getConfig();
            this.remote = determineRemote(config, this.remote);
            if (this.refSpecs.isEmpty()) {
                this.refSpecs.addAll(new RemoteConfig(config, getRemote()).getPushRefSpecs());
                if (this.refSpecs.isEmpty()) {
                    determineDefaultRefSpecs(config);
                }
            }
            if (this.force) {
                for (int i = 0; i < this.refSpecs.size(); i++) {
                    List<RefSpec> list = this.refSpecs;
                    list.set(i, list.get(i).setForceUpdate(true));
                }
            }
            for (Transport transport : Transport.openAll(this.repo, this.remote, Transport.Operation.PUSH)) {
                transport.setPushThin(this.thin);
                transport.setPushAtomic(this.atomic);
                String str = this.receivePack;
                if (str != null) {
                    transport.setOptionReceivePack(str);
                }
                transport.setDryRun(this.dryRun);
                transport.setPushOptions(this.pushOptions);
                transport.setPushUseBitmaps(this.useBitmaps);
                transport.setHookOutputStream(this.hookOutRedirect);
                transport.setHookErrorStream(this.hookErrRedirect);
                configure(transport);
                try {
                    try {
                        arrayList.add(transport.push(this.monitor, transport.findRemoteRefUpdatesFor(this.refSpecs, this.refLeaseSpecs), this.out));
                        transport.close();
                    } catch (TooLargeObjectInPackException e) {
                        throw new org.eclipse.jgit.api.errors.TooLargeObjectInPackException(e.getMessage(), e);
                    } catch (TooLargePackException e2) {
                        throw new org.eclipse.jgit.api.errors.TooLargePackException(e2.getMessage(), e2);
                    } catch (TransportException e3) {
                        throw new org.eclipse.jgit.api.errors.TransportException(e3.getMessage(), e3);
                    }
                } catch (Throwable th) {
                    transport.close();
                    throw th;
                }
            }
            return arrayList;
        } catch (TransportException e4) {
            throw new org.eclipse.jgit.api.errors.TransportException(e4.getMessage(), e4);
        } catch (IOException e5) {
            throw new JGitInternalException(JGitText.get().exceptionCaughtDuringExecutionOfPushCommand, e5);
        } catch (URISyntaxException e6) {
            throw new InvalidRemoteException(MessageFormat.format(JGitText.get().invalidRemote, this.remote), e6);
        } catch (NotSupportedException e7) {
            throw new JGitInternalException(JGitText.get().exceptionCaughtDuringExecutionOfPushCommand, e7);
        }
    }

    private String determineRemote(Config config, String str) throws IOException {
        String string;
        BranchConfig branchConfig;
        if (str != null) {
            return str;
        }
        Ref refExactRef = this.repo.exactRef("HEAD");
        if (refExactRef == null || !refExactRef.isSymbolic()) {
            string = null;
            branchConfig = null;
        } else {
            branchConfig = new BranchConfig(config, Repository.shortenRefName(refExactRef.getLeaf().getName()));
            string = branchConfig.getPushRemote();
        }
        if (string == null && (string = config.getString("remote", null, ConfigConstants.CONFIG_KEY_PUSH_DEFAULT)) == null && branchConfig != null) {
            string = branchConfig.getRemote();
        }
        return string == null ? "origin" : string;
    }

    private String getCurrentBranch() throws IOException, DetachedHeadException {
        Ref refExactRef = this.repo.exactRef("HEAD");
        if (refExactRef != null && refExactRef.isSymbolic()) {
            return refExactRef.getLeaf().getName();
        }
        throw new DetachedHeadException();
    }

    private void determineDefaultRefSpecs(Config config) throws GitAPIException, IOException {
        if (this.pushDefault == null) {
            this.pushDefault = ((PushConfig) config.get(new PushCommand$$ExternalSyntheticLambda0())).getPushDefault();
        }
        int i = $SWITCH_TABLE$org$eclipse$jgit$transport$PushConfig$PushDefault()[this.pushDefault.ordinal()];
        if (i == 1) {
            throw new InvalidRefNameException(JGitText.get().pushDefaultNothing);
        }
        if (i == 2) {
            this.refSpecs.add(new RefSpec(getCurrentBranch()));
            return;
        }
        if (i != 3 && i != 4) {
            if (i == 5) {
                this.refSpecs.add(new RefSpec(CollectionUtils.COLON));
                return;
            }
            throw new InvalidRefNameException(MessageFormat.format(JGitText.get().pushDefaultUnknown, this.pushDefault));
        }
        String currentBranch = getCurrentBranch();
        BranchConfig branchConfig = new BranchConfig(config, Repository.shortenRefName(currentBranch));
        String remote = branchConfig.getRemote();
        if (remote == null) {
            remote = "origin";
        }
        if (!remote.equals(this.remote)) {
            if (PushConfig.PushDefault.UPSTREAM.equals(this.pushDefault)) {
                throw new InvalidRefNameException(MessageFormat.format(JGitText.get().pushDefaultTriangularUpstream, this.remote, remote));
            }
            this.refSpecs.add(new RefSpec(currentBranch));
            return;
        }
        String merge = branchConfig.getMerge();
        if (branchConfig.isRemoteLocal() || merge == null || !merge.startsWith(Constants.R_HEADS)) {
            throw new InvalidRefNameException(MessageFormat.format(JGitText.get().pushDefaultNoUpstream, currentBranch));
        }
        if (PushConfig.PushDefault.SIMPLE.equals(this.pushDefault) && !merge.equals(currentBranch)) {
            throw new InvalidRefNameException(MessageFormat.format(JGitText.get().pushDefaultSimple, currentBranch, merge));
        }
        this.refSpecs.add(new RefSpec(currentBranch + CollectionUtils.COLON + merge));
    }

    public PushCommand setRemote(String str) {
        checkCallable();
        this.remote = str;
        return this;
    }

    public String getRemote() {
        return this.remote;
    }

    public PushCommand setHookOutputStream(PrintStream printStream) {
        checkCallable();
        this.hookOutRedirect = printStream;
        return this;
    }

    public PushCommand setHookErrorStream(PrintStream printStream) {
        checkCallable();
        this.hookErrRedirect = printStream;
        return this;
    }

    public PushCommand setReceivePack(String str) {
        checkCallable();
        this.receivePack = str;
        return this;
    }

    public String getReceivePack() {
        return this.receivePack;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public ProgressMonitor getProgressMonitor() {
        return this.monitor;
    }

    public PushCommand setProgressMonitor(ProgressMonitor progressMonitor) {
        checkCallable();
        if (progressMonitor == null) {
            progressMonitor = NullProgressMonitor.INSTANCE;
        }
        this.monitor = progressMonitor;
        return this;
    }

    public List<RefLeaseSpec> getRefLeaseSpecs() {
        return new ArrayList(this.refLeaseSpecs.values());
    }

    public PushCommand setRefLeaseSpecs(RefLeaseSpec... refLeaseSpecArr) {
        return setRefLeaseSpecs(Arrays.asList(refLeaseSpecArr));
    }

    public PushCommand setRefLeaseSpecs(List<RefLeaseSpec> list) {
        checkCallable();
        this.refLeaseSpecs.clear();
        for (RefLeaseSpec refLeaseSpec : list) {
            this.refLeaseSpecs.put(refLeaseSpec.getRef(), refLeaseSpec);
        }
        return this;
    }

    public List<RefSpec> getRefSpecs() {
        return this.refSpecs;
    }

    public PushCommand setRefSpecs(RefSpec... refSpecArr) {
        checkCallable();
        this.refSpecs.clear();
        Collections.addAll(this.refSpecs, refSpecArr);
        return this;
    }

    public PushCommand setRefSpecs(List<RefSpec> list) {
        checkCallable();
        this.refSpecs.clear();
        this.refSpecs.addAll(list);
        return this;
    }

    public PushConfig.PushDefault getPushDefault() {
        return this.pushDefault;
    }

    public PushCommand setPushDefault(PushConfig.PushDefault pushDefault) {
        checkCallable();
        this.pushDefault = pushDefault;
        return this;
    }

    public PushCommand setPushAll() {
        this.refSpecs.add(Transport.REFSPEC_PUSH_ALL);
        return this;
    }

    public PushCommand setPushTags() {
        this.refSpecs.add(Transport.REFSPEC_TAGS);
        return this;
    }

    public PushCommand add(Ref ref) {
        this.refSpecs.add(new RefSpec(ref.getLeaf().getName()));
        return this;
    }

    public PushCommand add(String str) {
        if (str.indexOf(58) >= 0) {
            this.refSpecs.add(new RefSpec(str));
            return this;
        }
        try {
            Ref refFindRef = this.repo.findRef(str);
            if (refFindRef != null) {
                add(refFindRef);
            }
            return this;
        } catch (IOException e) {
            throw new JGitInternalException(JGitText.get().exceptionCaughtDuringExecutionOfPushCommand, e);
        }
    }

    public boolean isDryRun() {
        return this.dryRun;
    }

    public PushCommand setDryRun(boolean z) {
        checkCallable();
        this.dryRun = z;
        return this;
    }

    public boolean isThin() {
        return this.thin;
    }

    public PushCommand setThin(boolean z) {
        checkCallable();
        this.thin = z;
        return this;
    }

    public boolean isUseBitmaps() {
        return this.useBitmaps;
    }

    public PushCommand setUseBitmaps(boolean z) {
        checkCallable();
        this.useBitmaps = z;
        return this;
    }

    public boolean isAtomic() {
        return this.atomic;
    }

    public PushCommand setAtomic(boolean z) {
        checkCallable();
        this.atomic = z;
        return this;
    }

    public boolean isForce() {
        return this.force;
    }

    public PushCommand setForce(boolean z) {
        checkCallable();
        this.force = z;
        return this;
    }

    public PushCommand setOutputStream(OutputStream outputStream) {
        this.out = outputStream;
        return this;
    }

    public List<String> getPushOptions() {
        return this.pushOptions;
    }

    public PushCommand setPushOptions(List<String> list) {
        this.pushOptions = list;
        return this;
    }
}
