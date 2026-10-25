package com.magneticchen.daijishou.nav_fragments;

import android.content.Context;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.magneticchen.daijishou.daijishou_widget.WidgetsManager;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetBuilder;
import com.magneticchen.daijishou.daijishou_widget.widget_db.RSSWidgetInstanceEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: WidgetGridNavFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/magneticchen/daijishou/daijishou_widget/widget_db/RSSWidgetInstanceEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class WidgetGridNavFragment$onCreateView$8$6 extends Lambda<Unit> implements Function1<RSSWidgetInstanceEntity, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Class<? extends WidgetBuilder> $widgetBuilder;
    final /* synthetic */ WidgetGridNavFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WidgetGridNavFragment$onCreateView$8$6(WidgetGridNavFragment widgetGridNavFragment, Class<? extends WidgetBuilder> cls, Context context) {
        super(1);
        this.this$0 = widgetGridNavFragment;
        this.$widgetBuilder = cls;
        this.$context = context;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.WidgetGridNavFragment$onCreateView$8$6$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGridNavFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "succeed", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda<Unit> implements Function1<Boolean, Unit> {
        final /* synthetic */ Context $context;
        final /* synthetic */ WidgetGridNavFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, WidgetGridNavFragment widgetGridNavFragment) {
            super(1);
            this.$context = context;
            this.this$0 = widgetGridNavFragment;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean z) {
            String str = null;
            if (z) {
                Context context = this.$context;
                String str2 = this.this$0.widgetCreatedSuccessfullyString;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("widgetCreatedSuccessfullyString");
                } else {
                    str = str2;
                }
                Toast.makeText(context, str, 0).show();
                return;
            }
            Context context2 = this.$context;
            String str3 = this.this$0.widgetCreateCanceledString;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("widgetCreateCanceledString");
            } else {
                str = str3;
            }
            Toast.makeText(context2, str, 0).show();
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RSSWidgetInstanceEntity rSSWidgetInstanceEntity) {
        invoke2(rSSWidgetInstanceEntity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RSSWidgetInstanceEntity it) {
        Intrinsics.checkNotNullParameter(it, "it");
        WidgetsManager widgetsManager = this.this$0.getWidgetsManager();
        FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        widgetsManager.requestWidgetInstanceCreation((AppCompatActivity) fragmentActivityRequireActivity, this.$widgetBuilder, it, new AnonymousClass1(this.$context, this.this$0));
    }
}
