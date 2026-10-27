package com.magneticchen.daijishou.ui.widget.widgets.rss;

import android.widget.TextView;
import com.google.android.material.chip.Chip;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.prof18.rssparser.model.RssChannel;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RSSWidgetNavFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.widget.widgets.rss.RSSWidgetNavFragment$onCreateView$4$1$2", f = "RSSWidgetNavFragment.kt", i = {0, 1}, l = {261, 264, 275}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
final class RSSWidgetNavFragment$onCreateView$4$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $url;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ RSSWidgetNavFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RSSWidgetNavFragment$onCreateView$4$1$2(RSSWidgetNavFragment rSSWidgetNavFragment, String str, Continuation<? super RSSWidgetNavFragment$onCreateView$4$1$2> continuation) {
        super(2, continuation);
        this.this$0 = rSSWidgetNavFragment;
        this.$url = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RSSWidgetNavFragment$onCreateView$4$1$2 rSSWidgetNavFragment$onCreateView$4$1$2 = new RSSWidgetNavFragment$onCreateView$4$1$2(this.this$0, this.$url, continuation);
        rSSWidgetNavFragment$onCreateView$4$1$2.L$0 = obj;
        return rSSWidgetNavFragment$onCreateView$4$1$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RSSWidgetNavFragment$onCreateView$4$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a0, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.ui.widget.widgets.rss.RSSWidgetNavFragment$onCreateView$4$1$2.AnonymousClass1(r10.this$0, r11, null), r10) == r0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00cf, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.ui.widget.widgets.rss.RSSWidgetNavFragment$onCreateView$4$1$2.AnonymousClass2(r10.this$0, null), r10) == r0) goto L37;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            Method dump skipped, instruction units count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.widget.widgets.rss.RSSWidgetNavFragment$onCreateView$4$1$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.widget.widgets.rss.RSSWidgetNavFragment$onCreateView$4$1$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: RSSWidgetNavFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.widget.widgets.rss.RSSWidgetNavFragment$onCreateView$4$1$2$1", f = "RSSWidgetNavFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $title;
        int label;
        final /* synthetic */ RSSWidgetNavFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RSSWidgetNavFragment rSSWidgetNavFragment, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = rSSWidgetNavFragment;
            this.$title = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$title, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                LinearProgressIndicator linearProgressIndicator = this.this$0.progressbar;
                RSSWidgetNavFragment.RSSArticleListAdapter rSSArticleListAdapter = null;
                if (linearProgressIndicator == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("progressbar");
                    linearProgressIndicator = null;
                }
                linearProgressIndicator.setIndeterminate(false);
                LinearProgressIndicator linearProgressIndicator2 = this.this$0.progressbar;
                if (linearProgressIndicator2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("progressbar");
                    linearProgressIndicator2 = null;
                }
                linearProgressIndicator2.setVisibility(8);
                TextView textView = this.this$0.titleTextView;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
                    textView = null;
                }
                if (this.$title.length() > 24) {
                    String strSubstring = this.$title.substring(0, 24);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    str = strSubstring + "..";
                } else {
                    str = this.$title;
                }
                textView.setText(str);
                Chip chip = this.this$0.articlesCountButton;
                if (chip == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("articlesCountButton");
                    chip = null;
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str2 = this.this$0.articlesFormatString;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("articlesFormatString");
                    str2 = null;
                }
                RssChannel rssChannel = this.this$0.channel;
                if (rssChannel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("channel");
                    rssChannel = null;
                }
                String str3 = String.format(str2, Arrays.copyOf(new Object[]{Boxing.boxInt(rssChannel.getItems().size())}, 1));
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                chip.setText(str3);
                this.this$0.articleList.clear();
                List list = this.this$0.articleList;
                RssChannel rssChannel2 = this.this$0.channel;
                if (rssChannel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("channel");
                    rssChannel2 = null;
                }
                list.addAll(rssChannel2.getItems());
                RSSWidgetNavFragment.RSSArticleListAdapter rSSArticleListAdapter2 = this.this$0.recyclerViewAdapter;
                if (rSSArticleListAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                } else {
                    rSSArticleListAdapter = rSSArticleListAdapter2;
                }
                rSSArticleListAdapter.notifyDataSetChanged();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.widget.widgets.rss.RSSWidgetNavFragment$onCreateView$4$1$2$2, reason: invalid class name */
    /* JADX INFO: compiled from: RSSWidgetNavFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.widget.widgets.rss.RSSWidgetNavFragment$onCreateView$4$1$2$2", f = "RSSWidgetNavFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ RSSWidgetNavFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(RSSWidgetNavFragment rSSWidgetNavFragment, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = rSSWidgetNavFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                LinearProgressIndicator linearProgressIndicator = this.this$0.progressbar;
                RSSWidgetNavFragment.RSSArticleListAdapter rSSArticleListAdapter = null;
                if (linearProgressIndicator == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("progressbar");
                    linearProgressIndicator = null;
                }
                linearProgressIndicator.setIndeterminate(false);
                LinearProgressIndicator linearProgressIndicator2 = this.this$0.progressbar;
                if (linearProgressIndicator2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("progressbar");
                    linearProgressIndicator2 = null;
                }
                linearProgressIndicator2.setVisibility(8);
                TextView textView = this.this$0.titleTextView;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
                    textView = null;
                }
                String str = this.this$0.rSSFeedString;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rSSFeedString");
                    str = null;
                }
                textView.setText(str);
                this.this$0.articleList.clear();
                RSSWidgetNavFragment.RSSArticleListAdapter rSSArticleListAdapter2 = this.this$0.recyclerViewAdapter;
                if (rSSArticleListAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                } else {
                    rSSArticleListAdapter = rSSArticleListAdapter2;
                }
                rSSArticleListAdapter.notifyDataSetChanged();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
