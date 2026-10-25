package io.noties.markwon.image;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;
import io.noties.markwon.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AsyncDrawableScheduler {
    public static void schedule(TextView textView) {
        Integer num = (Integer) textView.getTag(R.id.markwon_drawables_scheduler_last_text_hashcode);
        int iHashCode = textView.getText().hashCode();
        if (num == null || num.intValue() != iHashCode) {
            textView.setTag(R.id.markwon_drawables_scheduler_last_text_hashcode, Integer.valueOf(iHashCode));
            AsyncDrawableSpan[] asyncDrawableSpanArrExtractSpans = extractSpans(textView);
            if (asyncDrawableSpanArrExtractSpans == null || asyncDrawableSpanArrExtractSpans.length <= 0) {
                return;
            }
            if (textView.getTag(R.id.markwon_drawables_scheduler) == null) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(textView);
                textView.addOnAttachStateChangeListener(anonymousClass1);
                textView.setTag(R.id.markwon_drawables_scheduler, anonymousClass1);
            }
            TextViewInvalidator textViewInvalidator = new TextViewInvalidator(textView);
            for (AsyncDrawableSpan asyncDrawableSpan : asyncDrawableSpanArrExtractSpans) {
                AsyncDrawable drawable = asyncDrawableSpan.getDrawable();
                drawable.setCallback2(new DrawableCallbackImpl(textView, textViewInvalidator, drawable.getBounds()));
            }
        }
    }

    /* JADX INFO: renamed from: io.noties.markwon.image.AsyncDrawableScheduler$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnAttachStateChangeListener {
        final /* synthetic */ TextView val$textView;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        AnonymousClass1(TextView textView) {
            this.val$textView = textView;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            AsyncDrawableScheduler.unschedule(this.val$textView);
            view.removeOnAttachStateChangeListener(this);
            view.setTag(R.id.markwon_drawables_scheduler, null);
        }
    }

    public static void unschedule(TextView textView) {
        if (textView.getTag(R.id.markwon_drawables_scheduler_last_text_hashcode) == null) {
            return;
        }
        textView.setTag(R.id.markwon_drawables_scheduler_last_text_hashcode, null);
        AsyncDrawableSpan[] asyncDrawableSpanArrExtractSpans = extractSpans(textView);
        if (asyncDrawableSpanArrExtractSpans == null || asyncDrawableSpanArrExtractSpans.length <= 0) {
            return;
        }
        for (AsyncDrawableSpan asyncDrawableSpan : asyncDrawableSpanArrExtractSpans) {
            asyncDrawableSpan.getDrawable().setCallback2(null);
        }
    }

    private static AsyncDrawableSpan[] extractSpans(TextView textView) {
        CharSequence text = textView.getText();
        int length = text != null ? text.length() : 0;
        if (length == 0 || !(text instanceof Spanned)) {
            return null;
        }
        return (AsyncDrawableSpan[]) ((Spanned) text).getSpans(0, length, AsyncDrawableSpan.class);
    }

    private AsyncDrawableScheduler() {
    }

    private static class DrawableCallbackImpl implements Drawable.Callback {
        private final Invalidator invalidator;
        private Rect previousBounds;
        private final TextView view;

        interface Invalidator {
            void invalidate();
        }

        DrawableCallbackImpl(TextView textView, Invalidator invalidator, Rect rect) {
            this.view = textView;
            this.invalidator = invalidator;
            this.previousBounds = new Rect(rect);
        }

        /* JADX INFO: renamed from: io.noties.markwon.image.AsyncDrawableScheduler$DrawableCallbackImpl$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ Drawable val$who;

            AnonymousClass1(Drawable drawable) {
                this.val$who = drawable;
            }

            @Override // java.lang.Runnable
            public void run() {
                DrawableCallbackImpl.this.invalidateDrawable(this.val$who);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.view.post(new AnonymousClass1(drawable));
                return;
            }
            Rect bounds = drawable.getBounds();
            if (!this.previousBounds.equals(bounds)) {
                this.invalidator.invalidate();
                this.previousBounds = new Rect(bounds);
            } else {
                this.view.postInvalidate();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            this.view.postDelayed(runnable, j - SystemClock.uptimeMillis());
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            this.view.removeCallbacks(runnable);
        }
    }

    private static class TextViewInvalidator implements DrawableCallbackImpl.Invalidator, Runnable {
        private final TextView textView;

        TextViewInvalidator(TextView textView) {
            this.textView = textView;
        }

        @Override // io.noties.markwon.image.AsyncDrawableScheduler.DrawableCallbackImpl.Invalidator
        public void invalidate() {
            this.textView.removeCallbacks(this);
            this.textView.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            TextView textView = this.textView;
            textView.setText(textView.getText());
        }
    }
}
