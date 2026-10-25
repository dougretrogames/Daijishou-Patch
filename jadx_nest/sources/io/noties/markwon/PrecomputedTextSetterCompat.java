package io.noties.markwon;

import android.os.Build;
import android.text.Spanned;
import android.util.Log;
import android.widget.TextView;
import androidx.core.text.PrecomputedTextCompat;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
public class PrecomputedTextSetterCompat implements Markwon.TextSetter {
    private final Executor executor;

    public static PrecomputedTextSetterCompat create(Executor executor) {
        return new PrecomputedTextSetterCompat(executor);
    }

    PrecomputedTextSetterCompat(Executor executor) {
        this.executor = executor;
    }

    /* JADX INFO: renamed from: io.noties.markwon.PrecomputedTextSetterCompat$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ TextView.BufferType val$bufferType;
        final /* synthetic */ Spanned val$markdown;
        final /* synthetic */ Runnable val$onComplete;
        final /* synthetic */ WeakReference val$reference;

        AnonymousClass1(WeakReference weakReference, Spanned spanned, TextView.BufferType bufferType, Runnable runnable) {
            this.val$reference = weakReference;
            this.val$markdown = spanned;
            this.val$bufferType = bufferType;
            this.val$onComplete = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                PrecomputedTextCompat precomputedTextCompatPrecomputedText = PrecomputedTextSetterCompat.precomputedText((TextView) this.val$reference.get(), this.val$markdown);
                if (precomputedTextCompatPrecomputedText != null) {
                    PrecomputedTextSetterCompat.applyText((TextView) this.val$reference.get(), precomputedTextCompatPrecomputedText, this.val$bufferType, this.val$onComplete);
                }
            } catch (Throwable th) {
                Log.e("PrecomputdTxtSetterCmpt", "Exception during pre-computing text", th);
                PrecomputedTextSetterCompat.applyText((TextView) this.val$reference.get(), this.val$markdown, this.val$bufferType, this.val$onComplete);
            }
        }
    }

    @Override // io.noties.markwon.Markwon.TextSetter
    public void setText(TextView textView, Spanned spanned, TextView.BufferType bufferType, Runnable runnable) {
        this.executor.execute(new AnonymousClass1(new WeakReference(textView), spanned, bufferType, runnable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PrecomputedTextCompat precomputedText(TextView textView, Spanned spanned) {
        PrecomputedTextCompat.Params paramsBuild;
        if (textView == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            paramsBuild = new PrecomputedTextCompat.Params(textView.getTextMetricsParams());
        } else {
            PrecomputedTextCompat.Params.Builder builder = new PrecomputedTextCompat.Params.Builder(textView.getPaint());
            builder.setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            paramsBuild = builder.build();
        }
        return PrecomputedTextCompat.create(spanned, paramsBuild);
    }

    /* JADX INFO: renamed from: io.noties.markwon.PrecomputedTextSetterCompat$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ TextView.BufferType val$bufferType;
        final /* synthetic */ Runnable val$onComplete;
        final /* synthetic */ Spanned val$text;
        final /* synthetic */ TextView val$textView;

        AnonymousClass2(TextView textView, Spanned spanned, TextView.BufferType bufferType, Runnable runnable) {
            this.val$textView = textView;
            this.val$text = spanned;
            this.val$bufferType = bufferType;
            this.val$onComplete = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$textView.setText(this.val$text, this.val$bufferType);
            this.val$onComplete.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void applyText(TextView textView, Spanned spanned, TextView.BufferType bufferType, Runnable runnable) {
        if (textView != null) {
            textView.post(new AnonymousClass2(textView, spanned, bufferType, runnable));
        }
    }
}
