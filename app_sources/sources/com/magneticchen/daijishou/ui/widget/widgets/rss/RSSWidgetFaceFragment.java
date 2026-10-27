package com.magneticchen.daijishou.ui.widget.widgets.rss;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.db.entity.RSSWidgetInstanceEntity;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetFaceFragment;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: RSSWidgetFaceFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/rss/RSSWidgetFaceFragment;", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetFaceFragment;", "()V", "cachedChannel", "Lcom/prof18/rssparser/model/RssChannel;", "parser", "Lcom/prof18/rssparser/RssParser;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onPreload", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RSSWidgetFaceFragment extends WidgetFaceFragment {
    public static final Companion Companion = new Companion(null);
    private RssChannel cachedChannel;
    private final RssParser parser = RssParserBuilderKt.RssParser();

    /* JADX INFO: compiled from: RSSWidgetFaceFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/rss/RSSWidgetFaceFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/ui/widget/widgets/rss/RSSWidgetFaceFragment;", "widgetInstanceId", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RSSWidgetFaceFragment newInstance(long j) {
            RSSWidgetFaceFragment rSSWidgetFaceFragment = new RSSWidgetFaceFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("widgetInstanceId", j);
            rSSWidgetFaceFragment.setArguments(bundle);
            return rSSWidgetFaceFragment;
        }
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetFaceFragment
    public void onPreload() {
        super.onPreload();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), Dispatchers.getIO(), (CoroutineStart) null, new C01471(requireArguments().getLong("widgetInstanceId"), null), 2, (Object) null);
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.widget.widgets.rss.RSSWidgetFaceFragment$onPreload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RSSWidgetFaceFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.widget.widgets.rss.RSSWidgetFaceFragment$onPreload$1", f = "RSSWidgetFaceFragment.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
    static final class C01471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $widgetInstanceId;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01471(long j, Continuation<? super C01471> continuation) {
            super(2, continuation);
            this.$widgetInstanceId = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RSSWidgetFaceFragment.this.new C01471(this.$widgetInstanceId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01471) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
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
            } catch (Exception e2) {
                e = e2;
                rSSWidgetFaceFragment.getLogger().warn(rSSWidgetFaceFragment, ExceptionsKt.stackTraceToString(e));
            }
            rSSWidgetFaceFragment.cachedChannel = (RssChannel) obj;
            return Unit.INSTANCE;
        }
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetFaceFragment, com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Application application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        setDaijishouWidgetRepository(((DaijishouApplication) application).getDaijishouWidgetRepository());
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        long j = requireArguments().getLong("widgetInstanceId");
        View viewInflate = inflater.inflate(R.layout.widget_face_rss, viewGroup, false);
        final TextView textView = (TextView) viewInflate.findViewById(R.id.widget_face_rss_title);
        final TextView textView2 = (TextView) viewInflate.findViewById(R.id.widget_face_rss_subtitle);
        getDaijishouWidgetRepository().getRSSWidgetInstanceById(j).observe(getViewLifecycleOwner(), new RSSWidgetFaceFragment$sam$androidx_lifecycle_Observer$0(new Function1<RSSWidgetInstanceEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.rss.RSSWidgetFaceFragment.onCreateView.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RSSWidgetInstanceEntity rSSWidgetInstanceEntity) {
                invoke2(rSSWidgetInstanceEntity);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RSSWidgetInstanceEntity rSSWidgetInstanceEntity) {
                if (rSSWidgetInstanceEntity != null) {
                    TextView textView3 = textView;
                    LifecycleOwner lifecycleOwner = this;
                    TextView textView4 = textView2;
                    try {
                        String url = rSSWidgetInstanceEntity.getUrl();
                        if (url != null) {
                            RssChannel rssChannel = ((RSSWidgetFaceFragment) lifecycleOwner).cachedChannel;
                            if (rssChannel != null) {
                                String description = rssChannel.getItems().isEmpty() ? rssChannel.getDescription() : rssChannel.getItems().get(0).getTitle();
                                textView3.setText(rssChannel.getTitle());
                                textView4.setText(description);
                            }
                            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), Dispatchers.getIO(), (CoroutineStart) null, new RSSWidgetFaceFragment$onCreateView$1$1$2(lifecycleOwner, url, textView3, textView4, null), 2, (Object) null);
                            return;
                        }
                        textView3.setText(lifecycleOwner.getString(R.string.widget_face_rss_title));
                        textView4.setText(lifecycleOwner.getString(R.string.widget_face_rss_subtitle));
                    } catch (Exception e) {
                        lifecycleOwner.getLogger().warn(lifecycleOwner, ExceptionsKt.stackTraceToString(e));
                    }
                }
            }
        }));
        return viewInflate;
    }
}
