package com.magneticchen.daijishou.ui.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.BooleanPreference;
import com.magneticchen.daijishou.ui.activities.abstract_classes.DaijishouAppCompatActivity;
import com.magneticchen.daijishou.ui.fragments.dialog.LoggerDialogFragment;
import java.util.Arrays;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RescueActivity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\t"}, d2 = {"Lcom/magneticchen/daijishou/ui/activities/RescueActivity;", "Lcom/magneticchen/daijishou/ui/activities/abstract_classes/DaijishouAppCompatActivity;", "()V", "createCopyrightMessage", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RescueActivity extends DaijishouAppCompatActivity {
    @Override // com.magneticchen.daijishou.ui.activities.abstract_classes.DaijishouAppCompatActivity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_rescue);
        findViewById(R.id.activity_rescue_console_button).setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.activities.RescueActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RescueActivity.onCreate$lambda$0(this.f$0, view);
            }
        });
        ((TextView) findViewById(R.id.about_this_app_copyright)).setText(createCopyrightMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(RescueActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LoggerDialogFragment.Companion.newInstance().show(((FragmentActivity) this$0).getSupportFragmentManager(), LoggerDialogFragment.class.getName());
    }

    private final String createCopyrightMessage() {
        String string = getString(R.string.copyright_statement);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(Calendar.getInstance().get(1))}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_DEBUG_MODE.getKey(), BooleanPreference.USE_DEBUG_MODE.getDefaultValue()) ? str + " (Debug mode)" : str;
    }
}
