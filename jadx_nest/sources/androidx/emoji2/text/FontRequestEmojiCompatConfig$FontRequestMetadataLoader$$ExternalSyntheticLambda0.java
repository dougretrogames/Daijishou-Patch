package androidx.emoji2.text;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FontRequestEmojiCompatConfig$FontRequestMetadataLoader$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ FontRequestEmojiCompatConfig.FontRequestMetadataLoader f$0;

    public /* synthetic */ FontRequestEmojiCompatConfig$FontRequestMetadataLoader$$ExternalSyntheticLambda0(FontRequestEmojiCompatConfig.FontRequestMetadataLoader fontRequestMetadataLoader) {
        this.f$0 = fontRequestMetadataLoader;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.createMetadata();
    }
}
