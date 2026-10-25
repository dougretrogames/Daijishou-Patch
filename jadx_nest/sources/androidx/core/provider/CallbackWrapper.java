package androidx.core.provider;

import android.graphics.Typeface;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
class CallbackWrapper {
    private final FontsContractCompat.FontRequestCallback mCallback;
    private final Executor mExecutor;

    CallbackWrapper(FontsContractCompat.FontRequestCallback fontRequestCallback, Executor executor) {
        this.mCallback = fontRequestCallback;
        this.mExecutor = executor;
    }

    CallbackWrapper(FontsContractCompat.FontRequestCallback fontRequestCallback) {
        this(fontRequestCallback, RequestExecutor.createHandlerExecutor(CalleeHandler.create()));
    }

    /* JADX INFO: renamed from: androidx.core.provider.CallbackWrapper$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ FontsContractCompat.FontRequestCallback val$callback;
        final /* synthetic */ Typeface val$typeface;

        AnonymousClass1(FontsContractCompat.FontRequestCallback fontRequestCallback, Typeface typeface) {
            this.val$callback = fontRequestCallback;
            this.val$typeface = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$callback.onTypefaceRetrieved(this.val$typeface);
        }
    }

    private void onTypefaceRetrieved(Typeface typeface) {
        this.mExecutor.execute(new AnonymousClass1(this.mCallback, typeface));
    }

    /* JADX INFO: renamed from: androidx.core.provider.CallbackWrapper$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ FontsContractCompat.FontRequestCallback val$callback;
        final /* synthetic */ int val$reason;

        AnonymousClass2(FontsContractCompat.FontRequestCallback fontRequestCallback, int i) {
            this.val$callback = fontRequestCallback;
            this.val$reason = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$callback.onTypefaceRequestFailed(this.val$reason);
        }
    }

    private void onTypefaceRequestFailed(int i) {
        this.mExecutor.execute(new AnonymousClass2(this.mCallback, i));
    }

    void onTypefaceResult(FontRequestWorker.TypefaceResult typefaceResult) {
        if (typefaceResult.isSuccess()) {
            onTypefaceRetrieved(typefaceResult.mTypeface);
        } else {
            onTypefaceRequestFailed(typefaceResult.mResult);
        }
    }
}
