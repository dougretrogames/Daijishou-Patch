package org.eclipse.jgit.lib;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.eclipse.jgit.errors.RepositoryNotFoundException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.internal.WorkQueue;
import org.eclipse.jgit.util.FS;
import org.eclipse.jgit.util.IO;
import org.eclipse.jgit.util.RawParseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* INFO: loaded from: classes5.dex */
public class RepositoryCache {
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) RepositoryCache.class);
    private static final RepositoryCache cache = new RepositoryCache();
    private ScheduledFuture<?> cleanupTask;
    private volatile long expireAfter;
    private final Object schedulerLock = new Lock(null);
    private final Map<Key, Repository> cacheMap = new ConcurrentHashMap();
    private final Lock[] openLocks = new Lock[4];

    public interface Key {
        Repository open(boolean z) throws IOException;
    }

    public static Repository open(Key key) throws IOException {
        return open(key, true);
    }

    public static Repository open(Key key, boolean z) throws IOException {
        return cache.openRepository(key, z);
    }

    public static void register(Repository repository) {
        if (repository.getDirectory() != null) {
            cache.registerRepository(FileKey.exact(repository.getDirectory(), repository.getFS()), repository);
        }
    }

    public static void close(Repository repository) {
        if (repository.getDirectory() != null) {
            cache.unregisterAndCloseRepository(FileKey.exact(repository.getDirectory(), repository.getFS()));
        }
    }

    public static void unregister(Repository repository) {
        if (repository.getDirectory() != null) {
            unregister(FileKey.exact(repository.getDirectory(), repository.getFS()));
        }
    }

    public static void unregister(Key key) {
        cache.unregisterRepository(key);
    }

    public static Collection<Key> getRegisteredKeys() {
        return cache.getKeys();
    }

    static boolean isCached(Repository repository) {
        File directory = repository.getDirectory();
        if (directory == null) {
            return false;
        }
        return cache.cacheMap.get(new FileKey(directory, repository.getFS())) == repository;
    }

    public static void clear() {
        cache.clearAll();
    }

    static void clearExpired() {
        cache.clearAllExpired();
    }

    static void reconfigure(RepositoryCacheConfig repositoryCacheConfig) {
        cache.configureEviction(repositoryCacheConfig);
    }

    private RepositoryCache() {
        int i = 0;
        while (true) {
            Lock[] lockArr = this.openLocks;
            if (i < lockArr.length) {
                lockArr[i] = new Lock(null);
                i++;
            } else {
                configureEviction(new RepositoryCacheConfig());
                return;
            }
        }
    }

    private void configureEviction(RepositoryCacheConfig repositoryCacheConfig) {
        this.expireAfter = repositoryCacheConfig.getExpireAfter();
        ScheduledThreadPoolExecutor executor = WorkQueue.getExecutor();
        synchronized (this.schedulerLock) {
            ScheduledFuture<?> scheduledFuture = this.cleanupTask;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            long cleanupDelay = repositoryCacheConfig.getCleanupDelay();
            if (cleanupDelay == 0) {
                return;
            }
            this.cleanupTask = executor.scheduleWithFixedDelay(new RepositoryCache$$ExternalSyntheticLambda0(), cleanupDelay, cleanupDelay, TimeUnit.MILLISECONDS);
        }
    }

    static /* synthetic */ void lambda$0() {
        try {
            cache.clearAllExpired();
        } catch (Throwable th) {
            LOG.error(th.getMessage(), th);
        }
    }

    private Repository openRepository(Key key, boolean z) throws IOException {
        Repository repositoryOpen;
        Repository repository = this.cacheMap.get(key);
        if (repository == null) {
            synchronized (lockFor(key)) {
                repositoryOpen = this.cacheMap.get(key);
                if (repositoryOpen == null) {
                    repositoryOpen = key.open(z);
                    this.cacheMap.put(key, repositoryOpen);
                } else {
                    repositoryOpen.incrementOpen();
                }
            }
            return repositoryOpen;
        }
        repository.incrementOpen();
        return repository;
    }

    private void registerRepository(Key key, Repository repository) {
        Repository repositoryPut = this.cacheMap.put(key, repository);
        if (repositoryPut != null) {
            repositoryPut.close();
        }
    }

    private Repository unregisterRepository(Key key) {
        return this.cacheMap.remove(key);
    }

    private boolean isExpired(Repository repository) {
        return repository != null && repository.useCnt.get() <= 0 && System.currentTimeMillis() - repository.closedAt.get() > this.expireAfter;
    }

    private void unregisterAndCloseRepository(Key key) {
        synchronized (lockFor(key)) {
            Repository repositoryUnregisterRepository = unregisterRepository(key);
            if (repositoryUnregisterRepository != null) {
                repositoryUnregisterRepository.doClose();
            }
        }
    }

    private Collection<Key> getKeys() {
        return new ArrayList(this.cacheMap.keySet());
    }

    private void clearAllExpired() {
        for (Repository repository : this.cacheMap.values()) {
            if (isExpired(repository)) {
                close(repository);
            }
        }
    }

    private void clearAll() {
        Iterator<Key> it = this.cacheMap.keySet().iterator();
        while (it.hasNext()) {
            unregisterAndCloseRepository(it.next());
        }
    }

    private Lock lockFor(Key key) {
        return this.openLocks[(key.hashCode() >>> 1) % this.openLocks.length];
    }

    private static class Lock {
        /* synthetic */ Lock(RepositoryCacheIA repositoryCacheIA) {
            this();
        }

        private Lock() {
        }
    }

    public static class FileKey implements Key {
        private final FS fs;
        private final File path;

        public static FileKey exact(File file, FS fs) {
            return new FileKey(file, fs);
        }

        public static FileKey lenient(File file, FS fs) {
            File fileResolve = resolve(file, fs);
            if (fileResolve != null) {
                file = fileResolve;
            }
            return new FileKey(file, fs);
        }

        protected FileKey(File file, FS fs) {
            this.path = canonical(file);
            this.fs = fs;
        }

        private static File canonical(File file) {
            try {
                return file.getCanonicalFile();
            } catch (IOException unused) {
                return file.getAbsoluteFile();
            }
        }

        public final File getFile() {
            return this.path;
        }

        @Override // org.eclipse.jgit.lib.RepositoryCache.Key
        public Repository open(boolean z) throws IOException {
            if (z && !isGitRepository(this.path, this.fs)) {
                throw new RepositoryNotFoundException(this.path);
            }
            return new FileRepository(this.path);
        }

        public int hashCode() {
            return this.path.hashCode();
        }

        public boolean equals(Object obj) {
            return (obj instanceof FileKey) && this.path.equals(((FileKey) obj).path);
        }

        public String toString() {
            return this.path.toString();
        }

        public static boolean isGitRepository(File file, FS fs) {
            File commonDir;
            try {
                commonDir = fs.getCommonDir(file);
            } catch (IOException unused) {
                commonDir = null;
            }
            if (commonDir != null) {
                file = commonDir;
            }
            if (fs.resolve(file, Constants.OBJECTS).exists() && fs.resolve(file, "refs").exists()) {
                return fs.resolve(file, "reftable").exists() || isValidHead(new File(file, "HEAD"));
            }
            return false;
        }

        private static boolean isValidHead(File file) {
            String firstLine = readFirstLine(file);
            if (firstLine != null) {
                return firstLine.startsWith("ref: refs/") || ObjectId.isId(firstLine);
            }
            return false;
        }

        private static String readFirstLine(File file) {
            try {
                byte[] fully = IO.readFully(file, 4096);
                int length = fully.length;
                if (length == 0) {
                    return null;
                }
                if (fully[length - 1] == 10) {
                    length--;
                }
                return RawParseUtils.decode(fully, 0, length);
            } catch (IOException unused) {
                return null;
            }
        }

        public static File resolve(File file, FS fs) {
            if (isGitRepository(file, fs)) {
                return file;
            }
            File file2 = new File(file, ".git");
            if (file2.isFile()) {
                try {
                    File symRef = BaseRepositoryBuilder.getSymRef(file, file2, fs);
                    if (symRef != null && isGitRepository(symRef, fs)) {
                        return symRef;
                    }
                } catch (IOException unused) {
                }
            } else if (isGitRepository(file2, fs)) {
                return file2;
            }
            File file3 = new File(file.getParentFile(), file.getName() + ".git");
            if (isGitRepository(file3, fs)) {
                return file3;
            }
            return null;
        }
    }
}
