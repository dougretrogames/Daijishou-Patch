package com.magneticchen.daijishou.ui.model;

import kotlin.Lazy;
import kotlin.Metadata;

/* JADX INFO: compiled from: DaijishouConsoleViewModel.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0010²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002"}, d2 = {"com/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel$commands$2", "Lcom/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel$Companion$Command;", "description", "", "getDescription", "()Ljava/lang/String;", "startWith", "getStartWith", "execute", "Lcom/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel$Companion$CommandResult;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "command", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/magneticchen/daijishou/DaijishouApplication;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release", "daijishouSynchronizationModel", "Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouConsoleViewModel$commands$2 extends DaijishouConsoleViewModel.Companion.Command {
    private final String startWith = "\\library ";
    private final String description = "Library command. Usages:\n> \\library clear all\n> \\library clear media\n> \\library clear events\n> \\library clear disjointed_events\n> \\library clear genres\n> \\library sync all\n> \\library sync backup\n> \\library show sync_status\n> \\library show sync_platform_count\n> \\library update_every_platform";

    DaijishouConsoleViewModel$commands$2() {
    }

    @Override // com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel.Companion.Command
    public String getStartWith() {
        return this.startWith;
    }

    @Override // com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel.Companion.Command
    public String getDescription() {
        return this.description;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0337, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r11, r12, r1) == r2) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01b1, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r12, r13, r1) == r2) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0216, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r11, r12, r1) == r2) goto L105;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel.Companion.Command
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object execute(androidx.appcompat.app.AppCompatActivity r11, com.magneticchen.daijishou.DaijishouApplication r12, java.lang.String r13, kotlin.coroutines.Continuation<? super com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel.Companion.CommandResult> r14) {
        /*
            Method dump skipped, instruction units count: 847
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel$commands$2.execute(androidx.appcompat.app.AppCompatActivity, com.magneticchen.daijishou.DaijishouApplication, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DaijishouSynchronizationModel execute$lambda$0(Lazy<DaijishouSynchronizationModel> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DaijishouSynchronizationModel execute$lambda$1(Lazy<DaijishouSynchronizationModel> lazy) {
        return lazy.getValue();
    }

    private static final DaijishouSynchronizationModel execute$lambda$2(Lazy<DaijishouSynchronizationModel> lazy) {
        return lazy.getValue();
    }

    private static final DaijishouSynchronizationModel execute$lambda$3(Lazy<DaijishouSynchronizationModel> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DaijishouSynchronizationModel execute$lambda$4(Lazy<DaijishouSynchronizationModel> lazy) {
        return lazy.getValue();
    }
}
