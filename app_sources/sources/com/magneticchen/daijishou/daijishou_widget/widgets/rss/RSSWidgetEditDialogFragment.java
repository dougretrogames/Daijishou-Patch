package com.magneticchen.daijishou.daijishou_widget.widgets.rss;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.textfield.TextInputEditText;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment;
import com.magneticchen.daijishou.daijishou_widget.widget_db.RSSWidgetInstanceEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: RSSWidgetEditDialogFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u0014\u0010\u0011\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J)\u0010\u0012\u001a\u00020\u00002!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00050\u0007R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/rss/RSSWidgetEditDialogFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/DaijishouDialogFragment;", "()V", "onCanceledListener", "Lkotlin/Function0;", "", "onEditedListener", "Lkotlin/Function1;", "Lcom/magneticchen/daijishou/daijishou_widget/widget_db/RSSWidgetInstanceEntity;", "Lkotlin/ParameterName;", "name", "rssWidgetInstanceEntity", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setOnCanceledListener", "setOnEditedListener", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RSSWidgetEditDialogFragment extends DaijishouDialogFragment {

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Function0<Unit> onCanceledListener;
    private Function1<? super RSSWidgetInstanceEntity, Unit> onEditedListener;

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0(DialogInterface dialogInterface, int i) {
    }

    /* INFO: compiled from: RSSWidgetEditDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/rss/RSSWidgetEditDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/rss/RSSWidgetEditDialogFragment;", "rssWidgetInstanceEntity", "Lcom/magneticchen/daijishou/daijishou_widget/widget_db/RSSWidgetInstanceEntity;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RSSWidgetEditDialogFragment newInstance(RSSWidgetInstanceEntity rssWidgetInstanceEntity) {
            Intrinsics.checkNotNullParameter(rssWidgetInstanceEntity, "rssWidgetInstanceEntity");
            RSSWidgetEditDialogFragment rSSWidgetEditDialogFragment = new RSSWidgetEditDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("rssWidgetInstanceEntity", rssWidgetInstanceEntity);
            rSSWidgetEditDialogFragment.setArguments(bundle);
            return rSSWidgetEditDialogFragment;
        }
    }

    public final RSSWidgetEditDialogFragment setOnEditedListener(Function1<? super RSSWidgetInstanceEntity, Unit> onEditedListener) {
        Intrinsics.checkNotNullParameter(onEditedListener, "onEditedListener");
        this.onEditedListener = onEditedListener;
        return this;
    }

    public final RSSWidgetEditDialogFragment setOnCanceledListener(Function0<Unit> onCanceledListener) {
        Intrinsics.checkNotNullParameter(onCanceledListener, "onCanceledListener");
        this.onCanceledListener = onCanceledListener;
        return this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.dialog_background));
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Parcelable parcelable = requireArguments().getParcelable("rssWidgetInstanceEntity");
        Intrinsics.checkNotNull(parcelable);
        RSSWidgetInstanceEntity rSSWidgetInstanceEntity = (RSSWidgetInstanceEntity) parcelable;
        View viewInflate = requireActivity().getLayoutInflater().inflate(R.layout.widget_edit_rss, (ViewGroup) null);
        TextInputEditText textInputEditText = (TextInputEditText) viewInflate.findViewById(R.id.widget_edit_rss_edit_text);
        textInputEditText.setText(rSSWidgetInstanceEntity.getUrl());
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireContext()).setView(viewInflate).setTitle(getString(R.string.rss_uri_title)).setPositiveButton(getString(R.string.save), new RSSWidgetEditDialogFragment$$ExternalSyntheticLambda0()).setNegativeButton(getString(R.string.cancel), new RSSWidgetEditDialogFragment$$ExternalSyntheticLambda1(this)).create();
        Intrinsics.checkNotNull(alertDialogCreate);
        AlertDialog alertDialog = alertDialogCreate;
        setupDaijishouDialog(alertDialog);
        textInputEditText.requestFocus();
        alertDialogCreate.setOnShowListener(new RSSWidgetEditDialogFragment$$ExternalSyntheticLambda2(alertDialogCreate, textInputEditText, rSSWidgetInstanceEntity, this));
        return alertDialog;
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$1(RSSWidgetEditDialogFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.onCanceledListener;
        if (function0 != null) {
            function0.invoke();
        }
        dialogInterface.cancel();
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$3(AlertDialog alertDialog, TextInputEditText textInputEditText, RSSWidgetInstanceEntity rssWidgetInstanceEntity, RSSWidgetEditDialogFragment this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(rssWidgetInstanceEntity, "$rssWidgetInstanceEntity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(alertDialog, "null cannot be cast to non-null type android.app.AlertDialog");
        Button button = alertDialog.getButton(-1);
        Intrinsics.checkNotNullExpressionValue(button, "getButton(...)");
        button.setOnClickListener(new RSSWidgetEditDialogFragment$$ExternalSyntheticLambda3(textInputEditText, rssWidgetInstanceEntity, this$0, alertDialog));
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$3$lambda$2(TextInputEditText textInputEditText, RSSWidgetInstanceEntity rssWidgetInstanceEntity, RSSWidgetEditDialogFragment this$0, AlertDialog alertDialog, View view) {
        Intrinsics.checkNotNullParameter(rssWidgetInstanceEntity, "$rssWidgetInstanceEntity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String strValueOf = String.valueOf(textInputEditText.getText());
        if (Intrinsics.areEqual(strValueOf, "")) {
            strValueOf = null;
        }
        rssWidgetInstanceEntity.setUrl(strValueOf);
        Function1<? super RSSWidgetInstanceEntity, Unit> function1 = this$0.onEditedListener;
        if (function1 != null) {
            function1.invoke(rssWidgetInstanceEntity);
        }
        alertDialog.dismiss();
    }
}
