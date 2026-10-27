package com.magneticchen.daijishou.ui.fragments.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import androidx.appcompat.content.res.AppCompatResources;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AcknowledgementDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u0014\u0010\u0010\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0014\u0010\u0011\u001a\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0014\u0010\u0012\u001a\u00020\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouDialogFragment;", "()V", "acknowledgedListener", "Lkotlin/Function0;", "", "canceledListener", "neutralButtonClickedListener", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setOnAcknowledgedListener", "setOnCanceledListener", "setOnNeutralButtonClickedListener", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AcknowledgementDialogFragment extends DaijishouDialogFragment {
    public static final Companion Companion = new Companion(null);
    private Function0<Unit> acknowledgedListener;
    private Function0<Unit> canceledListener;
    private Function0<Unit> neutralButtonClickedListener;

    /* JADX INFO: compiled from: AcknowledgementDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J>\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¨\u0006\u000b"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment;", "title", "", "message", "positiveText", "negativeText", "neutralText", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ AcknowledgementDialogFragment newInstance$default(Companion companion, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 4) != 0) {
                str3 = null;
            }
            if ((i & 8) != 0) {
                str4 = null;
            }
            if ((i & 16) != 0) {
                str5 = null;
            }
            return companion.newInstance(str, str2, str3, str4, str5);
        }

        public final AcknowledgementDialogFragment newInstance(String str, String str2, String str3, String str4, String str5) {
            AcknowledgementDialogFragment acknowledgementDialogFragment = new AcknowledgementDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title", str);
            bundle.putString("message", str2);
            bundle.putString("positiveText", str3);
            bundle.putString("negativeText", str4);
            bundle.putString("neutralText", str5);
            acknowledgementDialogFragment.setArguments(bundle);
            return acknowledgementDialogFragment;
        }
    }

    public final AcknowledgementDialogFragment setOnAcknowledgedListener(Function0<Unit> acknowledgedListener) {
        Intrinsics.checkNotNullParameter(acknowledgedListener, "acknowledgedListener");
        this.acknowledgedListener = acknowledgedListener;
        return this;
    }

    public final AcknowledgementDialogFragment setOnCanceledListener(Function0<Unit> canceledListener) {
        Intrinsics.checkNotNullParameter(canceledListener, "canceledListener");
        this.canceledListener = canceledListener;
        return this;
    }

    public final AcknowledgementDialogFragment setOnNeutralButtonClickedListener(Function0<Unit> neutralButtonClickedListener) {
        Intrinsics.checkNotNullParameter(neutralButtonClickedListener, "neutralButtonClickedListener");
        this.neutralButtonClickedListener = neutralButtonClickedListener;
        return this;
    }

    public void onCancel(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        Function0<Unit> function0 = this.canceledListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        String string;
        String string2;
        Bundle arguments = getArguments();
        String string3 = arguments != null ? arguments.getString("title") : null;
        Bundle arguments2 = getArguments();
        String string4 = arguments2 != null ? arguments2.getString("message") : null;
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (string = arguments3.getString("positiveText")) == null) {
            string = getString(R.string.confirm);
        }
        Intrinsics.checkNotNull(string);
        Bundle arguments4 = getArguments();
        final String string5 = arguments4 != null ? arguments4.getString("negativeText") : null;
        Bundle arguments5 = getArguments();
        String string6 = arguments5 != null ? arguments5.getString("neutralText") : null;
        AlertDialog.Builder negativeButton = new AlertDialog.Builder(requireContext()).setView(getView()).setMessage(string4).setTitle(string3).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.AcknowledgementDialogFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                AcknowledgementDialogFragment.onCreateDialog$lambda$14$lambda$2(this.f$0, dialogInterface);
            }
        }).setPositiveButton(string, new DialogInterface.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.AcknowledgementDialogFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AcknowledgementDialogFragment.onCreateDialog$lambda$14$lambda$4(this.f$0, dialogInterface, i);
            }
        }).setNegativeButton(string5, new DialogInterface.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.AcknowledgementDialogFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AcknowledgementDialogFragment.onCreateDialog$lambda$14$lambda$6(this.f$0, dialogInterface, i);
            }
        });
        String str = string6;
        AlertDialog.Builder neutralButton = negativeButton.setNeutralButton(str, new DialogInterface.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.AcknowledgementDialogFragment$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AcknowledgementDialogFragment.onCreateDialog$lambda$14$lambda$8(this.f$0, dialogInterface, i);
            }
        });
        if (string5 != null || this.canceledListener != null) {
            if (string5 == null) {
                string2 = getString(R.string.cancel);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            } else {
                string2 = string5;
            }
            neutralButton.setNegativeButton(string2, new DialogInterface.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.AcknowledgementDialogFragment$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AcknowledgementDialogFragment.onCreateDialog$lambda$14$lambda$10(this.f$0, dialogInterface, i);
                }
            });
        }
        if (string6 != null || this.neutralButtonClickedListener != null) {
            neutralButton.setNeutralButton(str, new DialogInterface.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.AcknowledgementDialogFragment$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AcknowledgementDialogFragment.onCreateDialog$lambda$14$lambda$12(this.f$0, dialogInterface, i);
                }
            });
        }
        final AlertDialog alertDialogCreate = neutralButton.create();
        alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.AcknowledgementDialogFragment$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                AcknowledgementDialogFragment.onCreateDialog$lambda$14$lambda$13(string5, this, alertDialogCreate, dialogInterface);
            }
        });
        Intrinsics.checkNotNull(alertDialogCreate);
        AlertDialog alertDialog = alertDialogCreate;
        setupDaijishouDialog(alertDialog);
        return alertDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$14$lambda$2(AcknowledgementDialogFragment this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.canceledListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$14$lambda$4(AcknowledgementDialogFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.acknowledgedListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$14$lambda$6(AcknowledgementDialogFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.canceledListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$14$lambda$8(AcknowledgementDialogFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.neutralButtonClickedListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$14$lambda$10(AcknowledgementDialogFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.canceledListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$14$lambda$12(AcknowledgementDialogFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.neutralButtonClickedListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$14$lambda$13(String str, AcknowledgementDialogFragment this$0, AlertDialog alertDialog, DialogInterface dialogInterface) {
        boolean z;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (str == null && this$0.canceledListener == null) {
            z = false;
        } else {
            Button button = alertDialog.getButton(-2);
            button.setFocusable(true);
            button.setFocusableInTouchMode(true);
            button.requestFocus();
            z = true;
        }
        Button button2 = alertDialog.getButton(-1);
        button2.setFocusable(true);
        button2.setFocusableInTouchMode(true);
        if (z) {
            return;
        }
        button2.requestFocus();
    }

    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.dialog_background));
        }
    }
}
