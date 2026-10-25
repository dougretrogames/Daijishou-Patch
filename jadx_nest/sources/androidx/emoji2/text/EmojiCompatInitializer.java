package androidx.emoji2.text;

import android.content.Context;
import androidx.core.os.TraceCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class EmojiCompatInitializer implements Initializer<Boolean> {
    private static final long STARTUP_THREAD_CREATION_DELAY_MS = 500;
    private static final String S_INITIALIZER_THREAD_NAME = "EmojiCompatInitializer";

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    public Boolean create(Context context) {
        EmojiCompat.init(new BackgroundDefaultConfig(context));
        delayUntilFirstResume(context);
        return true;
    }

    void delayUntilFirstResume(Context context) {
        Lifecycle lifecycle = ((LifecycleOwner) AppInitializer.getInstance(context).initializeComponent(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.addObserver(new AnonymousClass1(lifecycle));
    }

    /* JADX INFO: renamed from: androidx.emoji2.text.EmojiCompatInitializer$1, reason: invalid class name */
    class AnonymousClass1 implements DefaultLifecycleObserver {
        final /* synthetic */ Lifecycle val$lifecycle;

        AnonymousClass1(Lifecycle lifecycle) {
            this.val$lifecycle = lifecycle;
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onResume(LifecycleOwner lifecycleOwner) {
            EmojiCompatInitializer.this.loadEmojiCompatAfterDelay();
            this.val$lifecycle.removeObserver(this);
        }
    }

    void loadEmojiCompatAfterDelay() {
        ConcurrencyHelpers.mainHandlerAsync().postDelayed(new LoadEmojiCompatRunnable(), STARTUP_THREAD_CREATION_DELAY_MS);
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    static class LoadEmojiCompatRunnable implements Runnable {
        LoadEmojiCompatRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TraceCompat.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                if (EmojiCompat.isConfigured()) {
                    EmojiCompat.get().load();
                }
            } finally {
                TraceCompat.endSection();
            }
        }
    }

    static class BackgroundDefaultConfig extends EmojiCompat.Config {
        protected BackgroundDefaultConfig(Context context) {
            super(new BackgroundDefaultLoader(context));
            setMetadataLoadStrategy(1);
        }
    }

    static class BackgroundDefaultLoader implements EmojiCompat.MetadataRepoLoader {
        private final Context mContext;

        BackgroundDefaultLoader(Context context) {
            this.mContext = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        public void load(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            ThreadPoolExecutor threadPoolExecutorCreateBackgroundPriorityExecutor = ConcurrencyHelpers.createBackgroundPriorityExecutor(EmojiCompatInitializer.S_INITIALIZER_THREAD_NAME);
            threadPoolExecutorCreateBackgroundPriorityExecutor.execute(new EmojiCompatInitializer$BackgroundDefaultLoader$$ExternalSyntheticLambda0(this, metadataRepoLoaderCallback, threadPoolExecutorCreateBackgroundPriorityExecutor));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX INFO: renamed from: doLoad, reason: merged with bridge method [inline-methods] */
        public void m3181x5cc8028a(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, ThreadPoolExecutor threadPoolExecutor) {
            try {
                FontRequestEmojiCompatConfig fontRequestEmojiCompatConfigCreate = DefaultEmojiCompatConfig.create(this.mContext);
                if (fontRequestEmojiCompatConfigCreate == null) {
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                }
                fontRequestEmojiCompatConfigCreate.setLoadingExecutor(threadPoolExecutor);
                fontRequestEmojiCompatConfigCreate.getMetadataRepoLoader().load(new AnonymousClass1(metadataRepoLoaderCallback, threadPoolExecutor));
            } catch (Throwable th) {
                metadataRepoLoaderCallback.onFailed(th);
                threadPoolExecutor.shutdown();
            }
        }

        /* JADX INFO: renamed from: androidx.emoji2.text.EmojiCompatInitializer$BackgroundDefaultLoader$1, reason: invalid class name */
        class AnonymousClass1 extends EmojiCompat.MetadataRepoLoaderCallback {
            final /* synthetic */ ThreadPoolExecutor val$executor;
            final /* synthetic */ EmojiCompat.MetadataRepoLoaderCallback val$loaderCallback;

            AnonymousClass1(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, ThreadPoolExecutor threadPoolExecutor) {
                this.val$loaderCallback = metadataRepoLoaderCallback;
                this.val$executor = threadPoolExecutor;
            }

            @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
            public void onLoaded(MetadataRepo metadataRepo) {
                try {
                    this.val$loaderCallback.onLoaded(metadataRepo);
                } finally {
                    this.val$executor.shutdown();
                }
            }

            @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
            public void onFailed(Throwable th) {
                try {
                    this.val$loaderCallback.onFailed(th);
                } finally {
                    this.val$executor.shutdown();
                }
            }
        }
    }
}
