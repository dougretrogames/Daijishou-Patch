package com.magneticchen.daijishou.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.activities.abstract_classes.DaijishouAppCompatActivity;
import com.magneticchen.daijishou.application_data.BooleanPreference;
import com.magneticchen.daijishou.dialog_fragments.LoggerDialogFragment;
import java.util.Arrays;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RescueActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/activities/RescueActivity;", "Lcom/magneticchen/daijishou/activities/abstract_classes/DaijishouAppCompatActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RescueActivity extends DaijishouAppCompatActivity {
    @Override // com.magneticchen.daijishou.activities.abstract_classes.DaijishouAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rescue);
        ((MaterialButton) findViewById(R.id.activity_rescue_console_button)).setOnClickListener(new RescueActivity$$ExternalSyntheticLambda0(this));
        TextView textView = (TextView) findViewById(R.id.about_this_app_copyright);
        String string = getString(R.string.copyright_statement);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(Calendar.getInstance().get(1))}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        if (getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_DEBUG_MODE.getKey(), BooleanPreference.USE_DEBUG_MODE.getDefaultValue())) {
            str = str + " (Debug mode)";
        }
        textView.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(RescueActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LoggerDialogFragment.INSTANCE.newInstance().show(this$0.getSupportFragmentManager(), LoggerDialogFragment.class.getName());
    }
}
