package org.eclipse.jgit.api;

import java.io.IOException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.dfs.DfsGarbageCollector;
import org.eclipse.jgit.internal.storage.dfs.DfsRepository;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.internal.storage.file.GC;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.storage.pack.PackConfig;

/* INFO: loaded from: classes5.dex */
public class GarbageCollectCommand extends GitCommand<Properties> {
    public static final int DEFAULT_GC_AGGRESSIVE_DEPTH = 250;
    public static final int DEFAULT_GC_AGGRESSIVE_WINDOW = 250;
    private Date expire;
    private ProgressMonitor monitor;
    private Boolean packKeptObjects;
    private PackConfig pconfig;

    protected GarbageCollectCommand(Repository repository) {
        super(repository);
        this.pconfig = new PackConfig(repository);
    }

    public GarbageCollectCommand setProgressMonitor(ProgressMonitor progressMonitor) {
        this.monitor = progressMonitor;
        return this;
    }

    public GarbageCollectCommand setExpire(Date date) {
        this.expire = date;
        return this;
    }

    public GarbageCollectCommand setAggressive(boolean z) {
        if (z) {
            StoredConfig config = this.repo.getConfig();
            this.pconfig.setDeltaSearchWindowSize(config.getInt(ConfigConstants.CONFIG_GC_SECTION, ConfigConstants.CONFIG_KEY_AGGRESSIVE_WINDOW, 250));
            this.pconfig.setMaxDeltaDepth(config.getInt(ConfigConstants.CONFIG_GC_SECTION, ConfigConstants.CONFIG_KEY_AGGRESSIVE_DEPTH, 250));
            this.pconfig.setReuseObjects(false);
            return this;
        }
        this.pconfig = new PackConfig(this.repo);
        return this;
    }

    public GarbageCollectCommand setPackKeptObjects(boolean z) {
        this.packKeptObjects = Boolean.valueOf(z);
        return this;
    }

    public GarbageCollectCommand setPreserveOldPacks(boolean z) {
        if (this.pconfig == null) {
            this.pconfig = new PackConfig(this.repo);
        }
        this.pconfig.setPreserveOldPacks(z);
        return this;
    }

    public GarbageCollectCommand setPrunePreserved(boolean z) {
        if (this.pconfig == null) {
            this.pconfig = new PackConfig(this.repo);
        }
        this.pconfig.setPrunePreserved(z);
        return this;
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public Properties call() throws GitAPIException {
        checkCallable();
        try {
            if (this.repo instanceof FileRepository) {
                GC gc = new GC((FileRepository) this.repo);
                gc.setPackConfig(this.pconfig);
                gc.setProgressMonitor(this.monitor);
                Date date = this.expire;
                if (date != null) {
                    gc.setExpire(date);
                }
                Boolean bool = this.packKeptObjects;
                if (bool != null) {
                    gc.setPackKeptObjects(bool.booleanValue());
                }
                try {
                    gc.gc().get();
                    return toProperties(gc.getStatistics());
                } catch (InterruptedException | ParseException | ExecutionException e) {
                    throw new JGitInternalException(JGitText.get().gcFailed, e);
                }
            }
            if (this.repo instanceof DfsRepository) {
                DfsGarbageCollector dfsGarbageCollector = new DfsGarbageCollector((DfsRepository) this.repo);
                dfsGarbageCollector.setPackConfig(this.pconfig);
                dfsGarbageCollector.pack(this.monitor);
                return new Properties();
            }
            throw new UnsupportedOperationException(MessageFormat.format(JGitText.get().unsupportedGC, this.repo.getClass().toString()));
        } catch (IOException e2) {
            throw new JGitInternalException(JGitText.get().gcFailed, e2);
        }
    }

    public Properties getStatistics() throws GitAPIException {
        try {
            if (this.repo instanceof FileRepository) {
                return toProperties(new GC((FileRepository) this.repo).getStatistics());
            }
            return new Properties();
        } catch (IOException e) {
            throw new JGitInternalException(JGitText.get().couldNotGetRepoStatistics, e);
        }
    }

    private static Properties toProperties(GC.RepoStatistics repoStatistics) {
        Properties properties = new Properties();
        properties.put("numberOfBitmaps", Long.valueOf(repoStatistics.numberOfBitmaps));
        properties.put("numberOfLooseObjects", Long.valueOf(repoStatistics.numberOfLooseObjects));
        properties.put("numberOfLooseRefs", Long.valueOf(repoStatistics.numberOfLooseRefs));
        properties.put("numberOfPackedObjects", Long.valueOf(repoStatistics.numberOfPackedObjects));
        properties.put("numberOfPackedRefs", Long.valueOf(repoStatistics.numberOfPackedRefs));
        properties.put("numberOfPackFiles", Long.valueOf(repoStatistics.numberOfPackFiles));
        properties.put("sizeOfLooseObjects", Long.valueOf(repoStatistics.sizeOfLooseObjects));
        properties.put("sizeOfPackedObjects", Long.valueOf(repoStatistics.sizeOfPackedObjects));
        return properties;
    }
}
