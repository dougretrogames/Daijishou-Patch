package com.magneticchen.daijishou.daijishou_widget.widgets.rss;

import android.widget.TextView;
import com.magneticchen.daijishou.R;
import com.prof18.rssparser.model.RssChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RSSWidgetFaceFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.daijishou_widget.widgets.rss.RSSWidgetFaceFragment$onCreateView$1$1$2", f = "RSSWidgetFaceFragment.kt", i = {0, 1}, l = {121, 126, 133}, m = "invokeSuspendImpl", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
final class RSSWidgetFaceFragment$onCreateView$1$1$2 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ TextView $subtitle;
    final /* synthetic */ TextView $title;
    final /* synthetic */ String $url;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RSSWidgetFaceFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RSSWidgetFaceFragment$onCreateView$1$1$2(RSSWidgetFaceFragment rSSWidgetFaceFragment, String str, TextView textView, TextView textView2, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = rSSWidgetFaceFragment;
        this.$url = str;
        this.$title = textView;
        this.$subtitle = textView2;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        RSSWidgetFaceFragment$onCreateView$1$1$2 rSSWidgetFaceFragment$onCreateView$1$1$2 = new RSSWidgetFaceFragment$onCreateView$1$1$2(this.this$0, this.$url, this.$title, this.$subtitle, continuation);
        rSSWidgetFaceFragment$onCreateView$1$1$2.L$0 = obj;
        return rSSWidgetFaceFragment$onCreateView$1$1$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((RSSWidgetFaceFragment$onCreateView$1$1$2) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x006b A[Catch: Exception -> 0x0036, TryCatch #1 {Exception -> 0x0036, blocks: (B:16:0x0032, B:25:0x005c, B:27:0x006b, B:29:0x006e, B:31:0x007d, B:34:0x0093, B:33:0x0083), top: B:46:0x0032 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x006e A[Catch: Exception -> 0x0036, TryCatch #1 {Exception -> 0x0036, blocks: (B:16:0x0032, B:25:0x005c, B:27:0x006b, B:29:0x006e, B:31:0x007d, B:34:0x0093, B:33:0x0083), top: B:46:0x0032 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x007d A[Catch: Exception -> 0x0036, TryCatch #1 {Exception -> 0x0036, blocks: (B:16:0x0032, B:25:0x005c, B:27:0x006b, B:29:0x006e, B:31:0x007d, B:34:0x0093, B:33:0x0083), top: B:46:0x0032 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0083 A[Catch: Exception -> 0x0036, TryCatch #1 {Exception -> 0x0036, blocks: (B:16:0x0032, B:25:0x005c, B:27:0x006b, B:29:0x006e, B:31:0x007d, B:34:0x0093, B:33:0x0083), top: B:46:0x0032 }] */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b0, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.daijishou_widget.widgets.rss.RSSWidgetFaceFragment$onCreateView$1$1$2.AnonymousClass1(r11.$title, r7, r11.$subtitle, r9, null), r11) == r1) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e6, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.daijishou_widget.widgets.rss.RSSWidgetFaceFragment$onCreateView$1$1$2.AnonymousClass2(r11.$title, r11.this$0, r11.$subtitle, r7, null), r11) == r1) goto L41;
     */

    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspendImpl(java.lang.Object r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.daijishou_widget.widgets.rss.RSSWidgetFaceFragment$onCreateView$1$1$2.invokeSuspendImpl(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.rss.RSSWidgetFaceFragment$onCreateView$1$1$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: RSSWidgetFaceFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.daijishou_widget.widgets.rss.RSSWidgetFaceFragment$onCreateView$1$1$2$1", f = "RSSWidgetFaceFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ RssChannel $channel;
        final /* synthetic */ String $description;
        final /* synthetic */ TextView $subtitle;
        final /* synthetic */ TextView $title;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TextView textView, RssChannel rssChannel, TextView textView2, String str, Continuation<?> continuation) {
            super(2, continuation);
            this.$title = textView;
            this.$channel = rssChannel;
            this.$subtitle = textView2;
            this.$description = str;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$title, this.$channel, this.$subtitle, this.$description, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$title.setText(this.$channel.getTitle());
            this.$subtitle.setText(this.$description);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.rss.RSSWidgetFaceFragment$onCreateView$1$1$2$2, reason: invalid class name */
    /* JADX INFO: compiled from: RSSWidgetFaceFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.daijishou_widget.widgets.rss.RSSWidgetFaceFragment$onCreateView$1$1$2$2", f = "RSSWidgetFaceFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass2 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ Exception $e;
        final /* synthetic */ TextView $subtitle;
        final /* synthetic */ TextView $title;
        int label;
        final /* synthetic */ RSSWidgetFaceFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(TextView textView, RSSWidgetFaceFragment rSSWidgetFaceFragment, TextView textView2, Exception exc, Continuation<?> continuation) {
            super(2, continuation);
            this.$title = textView;
            this.this$0 = rSSWidgetFaceFragment;
            this.$subtitle = textView2;
            this.$e = exc;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$title, this.this$0, this.$subtitle, this.$e, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$title.setText(this.this$0.getString(R.string.widget_face_rss_title));
            TextView textView = this.$subtitle;
            String message = this.$e.getMessage();
            if (message == null) {
                Throwable cause = this.$e.getCause();
                message = cause != null ? cause.getMessage() : null;
                if (message == null) {
                    message = this.this$0.getString(R.string.none);
                }
            }
            textView.setText(message);
            return Unit.INSTANCE;
        }
    }
}
