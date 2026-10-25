package com.magneticchen.daijishou.daijishou_widget.widgets.rss;

import android.widget.TextView;
import com.magneticchen.daijishou.R;
import com.prof18.rssparser.model.RssChannel;
import com.prof18.rssparser.model.RssItem;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

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

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            try {
                this.L$0 = coroutineScope;
                this.label = 1;
                Object rssChannelObj = this.this$0.parser.getRssChannel(this.$url, this);
                if (rssChannelObj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                RssChannel rssChannel = (RssChannel) rssChannelObj;
                if (Intrinsics.areEqual(this.this$0.cachedChannel, rssChannel)) {
                    return Unit.INSTANCE;
                }
                this.this$0.cachedChannel = rssChannel;
                String description;
                if (rssChannel.getItems().isEmpty()) {
                    description = rssChannel.getDescription();
                } else {
                    description = rssChannel.getItems().get(0).getTitle();
                }
                this.L$0 = coroutineScope;
                this.label = 2;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.$title, rssChannel, this.$subtitle, description, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Exception e) {
                this.this$0.getLogger().warn(coroutineScope, ExceptionsKt.stackTraceToString(e));
                this.L$0 = null;
                this.label = 3;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(this.$title, this.this$0, this.$subtitle, e, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                Object res = obj;
                RssChannel rssChannel2 = (RssChannel) res;
                if (Intrinsics.areEqual(this.this$0.cachedChannel, rssChannel2)) {
                    return Unit.INSTANCE;
                }
                this.this$0.cachedChannel = rssChannel2;
                String description2;
                if (rssChannel2.getItems().isEmpty()) {
                    description2 = rssChannel2.getDescription();
                } else {
                    description2 = rssChannel2.getItems().get(0).getTitle();
                }
                this.L$0 = coroutineScope2;
                this.label = 2;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.$title, rssChannel2, this.$subtitle, description2, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Exception e2) {
                this.this$0.getLogger().warn(coroutineScope2, ExceptionsKt.stackTraceToString(e2));
                this.L$0 = null;
                this.label = 3;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(this.$title, this.this$0, this.$subtitle, e2, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 2 || i == 3) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
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
