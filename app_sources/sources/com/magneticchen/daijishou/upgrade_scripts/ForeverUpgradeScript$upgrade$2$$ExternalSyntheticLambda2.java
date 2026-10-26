package com.magneticchen.daijishou.upgrade_scripts;

import android.content.DialogInterface;
import androidx.appcompat.app.AppCompatActivity;
import com.magneticchen.daijishou.application_data.portables.MessageJson;
import com.magneticchen.daijishou.application_data.portables.MessagesIndexJson;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class ForeverUpgradeScript$upgrade$2$$ExternalSyntheticLambda2 implements DialogInterface.OnClickListener {
    public final /* synthetic */ MessageJson f$0;
    public final /* synthetic */ AppCompatActivity f$1;
    public final /* synthetic */ Ref.IntRef f$2;
    public final /* synthetic */ MessagesIndexJson f$3;
    public final /* synthetic */ Function1 f$4;
    public final /* synthetic */ int f$5;

    public /* synthetic */ ForeverUpgradeScript$upgrade$2$$ExternalSyntheticLambda2(MessageJson messageJson, AppCompatActivity appCompatActivity, Ref.IntRef intRef, MessagesIndexJson messagesIndexJson, Function1 function1, int i) {
        this.f$0 = messageJson;
        this.f$1 = appCompatActivity;
        this.f$2 = intRef;
        this.f$3 = messagesIndexJson;
        this.f$4 = function1;
        this.f$5 = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            ForeverUpgradeScript.AnonymousClass2.invokeSuspendImpl$nextMessage$lambda$7$lambda$6(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, dialogInterface, i);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
