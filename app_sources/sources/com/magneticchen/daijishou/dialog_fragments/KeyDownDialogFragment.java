package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import androidx.appcompat.content.res.AppCompatResources;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;

/* INFO: compiled from: KeyDownDialogFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u0014\u0010\u000f\u001a\u00020\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bJ\u0014\u0010\u0010\u001a\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\bJ\u001a\u0010\u0011\u001a\u00020\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/KeyDownDialogFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/DaijishouDialogFragment;", "()V", "keyDownListener", "Lkotlin/Function1;", "Landroid/view/KeyEvent;", "", "onCanceledListener", "Lkotlin/Function0;", "onClearedListener", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setOnCanceledListener", "setOnClearedListener", "setOnKeyDownListener", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class KeyDownDialogFragment extends DaijishouDialogFragment {

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Function1<? super KeyEvent, Unit> keyDownListener;
    private Function0<Unit> onCanceledListener;
    private Function0<Unit> onClearedListener;

    /* INFO: compiled from: KeyDownDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/KeyDownDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/dialog_fragments/KeyDownDialogFragment;", "title", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KeyDownDialogFragment newInstance(String title) {
            KeyDownDialogFragment keyDownDialogFragment = new KeyDownDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title", title);
            keyDownDialogFragment.setArguments(bundle);
            return keyDownDialogFragment;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.dialog_background));
        }
    }

    public final KeyDownDialogFragment setOnKeyDownListener(Function1<? super KeyEvent, Unit> keyDownListener) {
        Intrinsics.checkNotNullParameter(keyDownListener, "keyDownListener");
        this.keyDownListener = keyDownListener;
        return this;
    }

    public final KeyDownDialogFragment setOnCanceledListener(Function0<Unit> onCanceledListener) {
        Intrinsics.checkNotNullParameter(onCanceledListener, "onCanceledListener");
        this.onCanceledListener = onCanceledListener;
        return this;
    }

    public final KeyDownDialogFragment setOnClearedListener(Function0<Unit> onClearedListener) {
        Intrinsics.checkNotNullParameter(onClearedListener, "onClearedListener");
        this.onClearedListener = onClearedListener;
        return this;
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        AlertDialog alertDialogCreate = null;
        String string = arguments != null ? arguments.getString("title") : null;
        Context context = getContext();
        if (context != null) {
            alertDialogCreate = new AlertDialog.Builder(context).setView(getView()).setMessage(getString(R.string.press_the_key_twice_to_register)).setTitle(string).setNeutralButton(getString(R.string.clear), new KeyDownDialogFragment$$ExternalSyntheticLambda0(this)).setNegativeButton(getString(R.string.cancel), new KeyDownDialogFragment$$ExternalSyntheticLambda1(this)).create();
            Intrinsics.checkNotNull(alertDialogCreate);
            setupDaijishouDialog(alertDialogCreate);
            alertDialogCreate.setOnKeyListener(new KeyDownDialogFragment$$ExternalSyntheticLambda2(new Ref.ObjectRef(), this, alertDialogCreate));
        }
        if (alertDialogCreate != null) {
            return alertDialogCreate;
        }
        throw new IllegalStateException("Context cannot be null");
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$6$lambda$1(KeyDownDialogFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.onClearedListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$6$lambda$3(KeyDownDialogFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.onCanceledListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* INFO: Access modifiers changed from: private */
    /* WARN: Multi-variable type inference failed */
    /* WARN: Type inference failed for: r3v6, types: [T, java.lang.Integer] */
    public static final boolean onCreateDialog$lambda$6$lambda$5(Ref.ObjectRef keyCode, KeyDownDialogFragment this$0, AlertDialog alertDialog, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyCode, "$keyCode");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (keyEvent.getAction() == 0) {
            if (keyCode.element != null) {
                int keyCode2 = keyEvent.getKeyCode();
                Integer num = (Integer) keyCode.element;
                if (num != null && keyCode2 == num.intValue()) {
                    Function1<? super KeyEvent, Unit> function1 = this$0.keyDownListener;
                    if (function1 != null) {
                        Intrinsics.checkNotNull(keyEvent);
                        function1.invoke(keyEvent);
                    }
                    alertDialog.dismiss();
                }
            }
        } else if (keyEvent.getAction() == 1) {
            keyCode.element = Integer.valueOf(keyEvent.getKeyCode());
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = this$0.getString(R.string.press_again_to_register_format);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String str = String.format(string, Arrays.copyOf(new Object[]{keyCode.element}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            alertDialog.setMessage(str);
        }
        return true;
    }
}
