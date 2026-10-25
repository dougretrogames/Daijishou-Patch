package org.eclipse.jgit.api;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.errors.ConfigInvalidException;
import org.eclipse.jgit.errors.NotSupportedException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.FetchConnection;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.Transport;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UrlConfig;
import org.eclipse.jgit.util.SystemReader;

/* JADX INFO: loaded from: classes5.dex */
public class LsRemoteCommand extends TransportCommand<LsRemoteCommand, Collection<Ref>> {
    private boolean heads;
    private String remote;
    private boolean tags;
    private String uploadPack;

    public LsRemoteCommand(Repository repository) {
        super(repository);
        this.remote = "origin";
    }

    public LsRemoteCommand setRemote(String str) {
        checkCallable();
        this.remote = str;
        return this;
    }

    public LsRemoteCommand setHeads(boolean z) {
        this.heads = z;
        return this;
    }

    public LsRemoteCommand setTags(boolean z) {
        this.tags = z;
        return this;
    }

    public LsRemoteCommand setUploadPack(String str) {
        this.uploadPack = str;
        return this;
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public Collection<Ref> call() throws GitAPIException {
        return execute().values();
    }

    public Map<String, Ref> callAsMap() throws GitAPIException {
        return Collections.unmodifiableMap(execute());
    }

    private Map<String, Ref> execute() throws GitAPIException {
        Transport transportOpen;
        checkCallable();
        Throwable th = null;
        try {
            if (this.repo != null) {
                transportOpen = Transport.open(this.repo, this.remote);
            } else {
                transportOpen = Transport.open(new URIish(translate(this.remote)));
            }
            try {
                transportOpen.setOptionUploadPack(this.uploadPack);
                configure(transportOpen);
                ArrayList arrayList = new ArrayList(1);
                if (this.tags) {
                    arrayList.add(new RefSpec("refs/tags/*:refs/remotes/origin/tags/*"));
                }
                if (this.heads) {
                    arrayList.add(new RefSpec("refs/heads/*:refs/remotes/origin/*"));
                }
                HashMap map = new HashMap();
                try {
                    FetchConnection fetchConnectionOpenFetch = transportOpen.openFetch(arrayList, new String[0]);
                    try {
                        Collection<Ref> refs = fetchConnectionOpenFetch.getRefs();
                        if (arrayList.isEmpty()) {
                            for (Ref ref : refs) {
                                map.put(ref.getName(), ref);
                            }
                        } else {
                            for (Ref ref2 : refs) {
                                Iterator<RefSpec> it = arrayList.iterator();
                                while (it.hasNext()) {
                                    if (it.next().matchSource(ref2)) {
                                        map.put(ref2.getName(), ref2);
                                        break;
                                    }
                                }
                            }
                        }
                        if (fetchConnectionOpenFetch != null) {
                            fetchConnectionOpenFetch.close();
                        }
                        if (transportOpen != null) {
                            transportOpen.close();
                        }
                        return map;
                    } catch (Throwable th2) {
                        if (fetchConnectionOpenFetch != null) {
                            fetchConnectionOpenFetch.close();
                        }
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
                    throw null;
                }
            } catch (Throwable th4) {
                if (transportOpen != null) {
                    transportOpen.close();
                }
                throw th4;
            }
        } catch (Throwable th5) {
            if (0 == 0) {
                throw th5;
            }
            if (null == th5) {
                throw null;
            }
            try {
                th.addSuppressed(th5);
                throw null;
            } catch (IOException e) {
                e = e;
                throw new TransportException(e.getMessage(), e);
            } catch (URISyntaxException e2) {
                throw new InvalidRemoteException(MessageFormat.format(JGitText.get().invalidRemote, this.remote), e2);
            } catch (ConfigInvalidException e3) {
                e = e3;
                throw new TransportException(e.getMessage(), e);
            } catch (NotSupportedException e4) {
                throw new JGitInternalException(JGitText.get().exceptionCaughtDuringExecutionOfLsRemoteCommand, e4);
            }
        }
    }

    private String translate(String str) throws ConfigInvalidException, IOException {
        return new UrlConfig(SystemReader.getInstance().getUserConfig()).replace(str);
    }
}
