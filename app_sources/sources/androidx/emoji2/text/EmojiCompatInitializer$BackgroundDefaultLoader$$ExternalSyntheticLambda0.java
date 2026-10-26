package androidx.emoji2.text;

import java.util.concurrent.ThreadPoolExecutor;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class EmojiCompatInitializer$BackgroundDefaultLoader$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ EmojiCompatInitializer.BackgroundDefaultLoader f$0;
    public final /* synthetic */ EmojiCompat.MetadataRepoLoaderCallback f$1;
    public final /* synthetic */ ThreadPoolExecutor f$2;

    public /* synthetic */ EmojiCompatInitializer$BackgroundDefaultLoader$$ExternalSyntheticLambda0(EmojiCompatInitializer.BackgroundDefaultLoader backgroundDefaultLoader, EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, ThreadPoolExecutor threadPoolExecutor) {
        this.f$0 = backgroundDefaultLoader;
        this.f$1 = metadataRepoLoaderCallback;
        this.f$2 = threadPoolExecutor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.m3181x5cc8028a(this.f$1, this.f$2);
    }
}
