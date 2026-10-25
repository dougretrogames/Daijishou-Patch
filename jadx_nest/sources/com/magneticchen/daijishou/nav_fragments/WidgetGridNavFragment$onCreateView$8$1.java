package com.magneticchen.daijishou.nav_fragments;

import android.content.Context;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.daijishou_widget.WidgetsManager;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetBuilder;
import com.magneticchen.daijishou.dialog_fragments.ChoosePlayableItemFromLibraryDialogFragment;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: WidgetGridNavFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "playableItemEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class WidgetGridNavFragment$onCreateView$8$1 extends Lambda<Unit> implements Function1<PlayableItemEntity, Unit> {
    final /* synthetic */ Ref.BooleanRef $canceled;
    final /* synthetic */ Context $context;
    final /* synthetic */ ChoosePlayableItemFromLibraryDialogFragment $dialog;
    final /* synthetic */ Class<? extends WidgetBuilder> $widgetBuilder;
    final /* synthetic */ WidgetGridNavFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WidgetGridNavFragment$onCreateView$8$1(Context context, WidgetGridNavFragment widgetGridNavFragment, Class<? extends WidgetBuilder> cls, ChoosePlayableItemFromLibraryDialogFragment choosePlayableItemFromLibraryDialogFragment, Ref.BooleanRef booleanRef) {
        super(1);
        this.$context = context;
        this.this$0 = widgetGridNavFragment;
        this.$widgetBuilder = cls;
        this.$dialog = choosePlayableItemFromLibraryDialogFragment;
        this.$canceled = booleanRef;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PlayableItemEntity playableItemEntity) {
        invoke2(playableItemEntity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PlayableItemEntity playableItemEntity) {
        Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
        Toast.makeText(this.$context, playableItemEntity.getName(), 0).show();
        try {
            WidgetsManager widgetsManager = this.this$0.getWidgetsManager();
            FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
            Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            widgetsManager.requestWidgetInstanceCreation((AppCompatActivity) fragmentActivityRequireActivity, this.$widgetBuilder, Long.valueOf(playableItemEntity.getId()), new AnonymousClass1(this.$canceled, this.$context, this.this$0));
        } catch (Exception e) {
            this.this$0.getLogger().warn(this.this$0, ExceptionsKt.stackTraceToString(e));
            Context context = this.$context;
            String str = this.this$0.widgetCreateCanceledString;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("widgetCreateCanceledString");
                str = null;
            }
            Toast.makeText(context, str, 0).show();
        }
        this.$dialog.dismiss();
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.WidgetGridNavFragment$onCreateView$8$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGridNavFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "succeed", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda<Unit> implements Function1<Boolean, Unit> {
        final /* synthetic */ Ref.BooleanRef $canceled;
        final /* synthetic */ Context $context;
        final /* synthetic */ WidgetGridNavFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.BooleanRef booleanRef, Context context, WidgetGridNavFragment widgetGridNavFragment) {
            super(1);
            this.$canceled = booleanRef;
            this.$context = context;
            this.this$0 = widgetGridNavFragment;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean z) {
            this.$canceled.element = !z;
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
}
