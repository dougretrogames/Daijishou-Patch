package org.eclipse.jgit.internal.util;

import org.eclipse.jgit.internal.JGitText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public final class CleanupService {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static CleanupService INSTANCE;
    private Runnable cleanup;
    private final boolean isOsgi;
    private JGitText jgitText;
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) CleanupService.class);
    private static final Object LOCK = new Object();

    void start() {
    }

    public CleanupService() {
        this.isOsgi = true;
        setInstance(this);
    }

    private CleanupService(boolean z) {
        this.isOsgi = z;
    }

    private static void setInstance(CleanupService cleanupService) {
        synchronized (LOCK) {
            INSTANCE = cleanupService;
        }
    }

    public static CleanupService getInstance() {
        CleanupService cleanupService;
        synchronized (LOCK) {
            if (INSTANCE == null) {
                INSTANCE = new CleanupService(false);
            }
            cleanupService = INSTANCE;
        }
        return cleanupService;
    }

    void register(Runnable runnable) {
        if (this.isOsgi) {
            this.cleanup = runnable;
            return;
        }
        this.jgitText = JGitText.get();
        try {
            Runtime.getRuntime().addShutdownHook(new Thread(new CleanupService$$ExternalSyntheticLambda0(this, runnable)));
        } catch (IllegalStateException unused) {
        }
    }

    /* JADX INFO: renamed from: lambda$0$org-eclipse-jgit-internal-util-CleanupService, reason: not valid java name */
    /* synthetic */ void m5768lambda$0$orgeclipsejgitinternalutilCleanupService(Runnable runnable) {
        try {
            runnable.run();
        } finally {
            this.jgitText = null;
        }
    }

    void shutDown() {
        Runnable runnable;
        if (!this.isOsgi || (runnable = this.cleanup) == null) {
            return;
        }
        this.cleanup = null;
        try {
            runnable.run();
        } catch (RuntimeException e) {
            LOG.error(JGitText.get().shutdownCleanupFailed, (Throwable) e);
        }
    }
}
