package com.magneticchen.daijishou.upgrade_scripts;

import android.content.DialogInterface;
import androidx.appcompat.app.AppCompatActivity;
import com.magneticchen.daijishou.application_data.portables.MessageJson;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class ForeverUpgradeScript$upgrade$2$$ExternalSyntheticLambda1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ MessageJson f$0;
    public final /* synthetic */ Function1 f$1;
    public final /* synthetic */ AppCompatActivity f$2;

    public /* synthetic */ ForeverUpgradeScript$upgrade$2$$ExternalSyntheticLambda1(MessageJson messageJson, Function1 function1, AppCompatActivity appCompatActivity) {
        this.f$0 = messageJson;
        this.f$1 = function1;
        this.f$2 = appCompatActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            ForeverUpgradeScript.AnonymousClass2.invokeSuspendImpl$nextMessage$lambda$4$lambda$3(this.f$0, this.f$1, this.f$2, dialogInterface, i);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
