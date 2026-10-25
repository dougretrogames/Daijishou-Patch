package com.magneticchen.daijishou.daijishou_widget.widgets.rss;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwnerKt;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetFaceFragment;
import com.magneticchen.daijishou.daijishou_widget.widget_db.RSSWidgetInstanceEntity;
import com.prof18.rssparser.RssParser;
import com.prof18.rssparser.RssParserBuilderKt;
import com.prof18.rssparser.model.RssChannel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: RSSWidgetFaceFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/rss/RSSWidgetFaceFragment;", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetFaceFragment;", "()V", "cachedChannel", "Lcom/prof18/rssparser/model/RssChannel;", "parser", "Lcom/prof18/rssparser/RssParser;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onPreload", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RSSWidgetFaceFragment extends WidgetFaceFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    RssChannel cachedChannel;
    final RssParser parser = RssParserBuilderKt.RssParser();

    public static final RssParser access$getParser$p(RSSWidgetFaceFragment rSSWidgetFaceFragment) {
        return rSSWidgetFaceFragment.parser;
    }

    public static final RssChannel access$getCachedChannel$p(RSSWidgetFaceFragment rSSWidgetFaceFragment) {
        return rSSWidgetFaceFragment.cachedChannel;
    }

    public static final void access$setCachedChannel$p(RSSWidgetFaceFragment rSSWidgetFaceFragment, RssChannel rssChannel) {
        rSSWidgetFaceFragment.cachedChannel = rssChannel;
    }

    public static final DaijishouApplication.WrappedLogger access$getLogger(RSSWidgetFaceFragment rSSWidgetFaceFragment) {
        return rSSWidgetFaceFragment.getLogger();
    }

    /* JADX INFO: compiled from: RSSWidgetFaceFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/rss/RSSWidgetFaceFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/rss/RSSWidgetFaceFragment;", "widgetInstanceId", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RSSWidgetFaceFragment newInstance(long widgetInstanceId) {
            RSSWidgetFaceFragment rSSWidgetFaceFragment = new RSSWidgetFaceFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("widgetInstanceId", widgetInstanceId);
            rSSWidgetFaceFragment.setArguments(bundle);
            return rSSWidgetFaceFragment;
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetFaceFragment
    public void onPreload() {
        super.onPreload();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new C02201(requireArguments().getLong("widgetInstanceId"), null), 2, null);
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.rss.RSSWidgetFaceFragment$onPreload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RSSWidgetFaceFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.daijishou_widget.widgets.rss.RSSWidgetFaceFragment$onPreload$1", f = "RSSWidgetFaceFragment.kt", i = {}, l = {70}, m = "invokeSuspendImpl", n = {}, s = {})
    final class C02201 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ long $widgetInstanceId;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02201(long j, Continuation<?> continuation) {
            super(2, continuation);
            this.$widgetInstanceId = j;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return RSSWidgetFaceFragment.this.new C02201(this.$widgetInstanceId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    return ((C02201) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            RSSWidgetFaceFragment rSSWidgetFaceFragment;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                RSSWidgetInstanceEntity rSSWidgetInstanceByIdStatically = RSSWidgetFaceFragment.this.getDaijishouWidgetRepository().getRSSWidgetInstanceByIdStatically(this.$widgetInstanceId);
                RSSWidgetFaceFragment rSSWidgetFaceFragment2 = RSSWidgetFaceFragment.this;
                if (rSSWidgetInstanceByIdStatically != null) {
                    try {
                        String url = rSSWidgetInstanceByIdStatically.getUrl();
                        if (url == null) {
                            return Unit.INSTANCE;
                        }
                        RssParser rssParser = rSSWidgetFaceFragment2.parser;
                        this.L$0 = rSSWidgetFaceFragment2;
                        this.label = 1;
                        obj = rssParser.getRssChannel(url, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        rSSWidgetFaceFragment = rSSWidgetFaceFragment2;
                    } catch (Exception e) {
                        e = e;
                        rSSWidgetFaceFragment = rSSWidgetFaceFragment2;
                        rSSWidgetFaceFragment.getLogger().warn(rSSWidgetFaceFragment, ExceptionsKt.stackTraceToString(e));
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            rSSWidgetFaceFragment = (RSSWidgetFaceFragment) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                rSSWidgetFaceFragment.cachedChannel = (RssChannel) obj;
            } catch (Exception e2) {
                rSSWidgetFaceFragment.getLogger().warn(rSSWidgetFaceFragment, ExceptionsKt.stackTraceToString(e2));
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetFaceFragment, com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Application application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        setDaijishouWidgetRepository(((DaijishouApplication) application).getDaijishouWidgetRepository());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        long j = requireArguments().getLong("widgetInstanceId");
        View viewInflate = inflater.inflate(R.layout.widget_face_rss, container, false);
        getDaijishouWidgetRepository().getRSSWidgetInstanceById(j).observe(getViewLifecycleOwner(), new RSSWidgetFaceFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass1((TextView) viewInflate.findViewById(R.id.widget_face_rss_title), this, (TextView) viewInflate.findViewById(R.id.widget_face_rss_subtitle))));
        return viewInflate;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.rss.RSSWidgetFaceFragment$onCreateView$1, reason: invalid class name */
    /* JADX INFO: compiled from: RSSWidgetFaceFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/magneticchen/daijishou/daijishou_widget/widget_db/RSSWidgetInstanceEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda<Unit> implements Function1<RSSWidgetInstanceEntity, Unit> {
        final /* synthetic */ TextView $subtitle;
        final /* synthetic */ TextView $title;
        final /* synthetic */ RSSWidgetFaceFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TextView textView, RSSWidgetFaceFragment rSSWidgetFaceFragment, TextView textView2) {
            super(1);
            this.$title = textView;
            this.this$0 = rSSWidgetFaceFragment;
            this.$subtitle = textView2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RSSWidgetInstanceEntity rSSWidgetInstanceEntity) {
            invoke2(rSSWidgetInstanceEntity);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RSSWidgetInstanceEntity rSSWidgetInstanceEntity) {
            if (rSSWidgetInstanceEntity != null) {
                TextView textView = this.$title;
                RSSWidgetFaceFragment rSSWidgetFaceFragment = this.this$0;
                TextView textView2 = this.$subtitle;
                try {
                    String url = rSSWidgetInstanceEntity.getUrl();
                    if (url != null) {
                        RssChannel rssChannel = rSSWidgetFaceFragment.cachedChannel;
                        if (rssChannel != null) {
                            String description = rssChannel.getItems().isEmpty() ? rssChannel.getDescription() : rssChannel.getItems().get(0).getTitle();
                            textView.setText(rssChannel.getTitle());
                            textView2.setText(description);
                        }
                        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(rSSWidgetFaceFragment), Dispatchers.getIO(), null, new RSSWidgetFaceFragment$onCreateView$1$1$2(rSSWidgetFaceFragment, url, textView, textView2, null), 2, null);
                        return;
                    }
                    textView.setText(rSSWidgetFaceFragment.getString(R.string.widget_face_rss_title));
                    textView2.setText(rSSWidgetFaceFragment.getString(R.string.widget_face_rss_subtitle));
                } catch (Exception e) {
                    rSSWidgetFaceFragment.getLogger().warn(rSSWidgetFaceFragment, ExceptionsKt.stackTraceToString(e));
                }
            }
        }
    }
}
