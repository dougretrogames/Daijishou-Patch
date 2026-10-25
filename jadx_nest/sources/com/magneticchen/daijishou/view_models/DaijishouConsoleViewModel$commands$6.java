package com.magneticchen.daijishou.view_models;

import kotlin.Metadata;

/* JADX INFO: compiled from: DaijishouConsoleViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0010"}, d2 = {"com/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$commands$6", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$Command;", "description", "", "getDescription", "()Ljava/lang/String;", "startWith", "getStartWith", "execute", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$CommandResult;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "command", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/magneticchen/daijishou/DaijishouApplication;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouConsoleViewModel$commands$6 extends DaijishouConsoleViewModel.Companion.Command {
    final /* synthetic */ DaijishouConsoleViewModel this$0;
    private final String startWith = "\\drive ";
    private final String description = "Google Drive command. Usage:\n> \\drive list all\n> \\drive delete all";

    DaijishouConsoleViewModel$commands$6(DaijishouConsoleViewModel daijishouConsoleViewModel) {
        this.this$0 = daijishouConsoleViewModel;
    }

    @Override // com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel.Companion.Command
    public String getStartWith() {
        return this.startWith;
    }

    @Override // com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel.Companion.Command
    public String getDescription() {
        return this.description;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006d, code lost:
    
        if (com.magneticchen.daijishou.google_drive.GoogleDrive.logAllFiles$default(r13, false, r12, 1, null) == r0) goto L36;
     */
    @Override // com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel.Companion.Command
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object execute(androidx.appcompat.app.AppCompatActivity r12, com.magneticchen.daijishou.DaijishouApplication r13, java.lang.String r14, kotlin.coroutines.Continuation<?> r15) {
        /*
            r11 = this;
            boolean r12 = r15 instanceof com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel$commands$6$execute$1
            if (r12 == 0) goto L14
            r12 = r15
            com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel$commands$6$execute$1 r12 = (com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel$commands$6$execute$1) r12
            int r0 = r12.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r1
            if (r0 == 0) goto L14
            int r15 = r12.label
            int r15 = r15 - r1
            r12.label = r15
            goto L19
        L14:
            com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel$commands$6$execute$1 r12 = new com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel$commands$6$execute$1
            r12.<init>(r11, r15)
        L19:
            java.lang.Object r15 = r12.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L39
            if (r1 == r3) goto L35
            if (r1 != r2) goto L2d
            kotlin.ResultKt.throwOnFailure(r15)
            return r15
        L2d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L35:
            kotlin.ResultKt.throwOnFailure(r15)
            goto L70
        L39:
            kotlin.ResultKt.throwOnFailure(r15)
            com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel$Companion r15 = com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel.INSTANCE
            java.util.List r15 = com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel.Companion.access$splitCommandBySpaces(r15, r14)
            int r1 = r15.size()
            r4 = 0
            java.lang.String r5 = "all"
            r6 = 3
            if (r1 != r6) goto L7e
            java.lang.Object r1 = r15.get(r3)
            java.lang.String r7 = "list"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r7)
            if (r1 == 0) goto L7e
            java.lang.Object r1 = r15.get(r2)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r5)
            if (r1 == 0) goto L7e
            com.magneticchen.daijishou.google_drive.GoogleDrive r13 = r13.getGoogleDrive()
            r12.label = r3
            r14 = 0
            java.lang.Object r12 = com.magneticchen.daijishou.google_drive.GoogleDrive.logAllFiles$default(r13, r14, r12, r3, r4)
            if (r12 != r0) goto L70
            goto Lba
        L70:
            com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel$Companion$CommandResult r1 = new com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel$Companion$CommandResult
            r6 = 14
            r7 = 0
            java.lang.String r2 = "Results printed in the logger."
            r3 = 0
            r4 = 0
            r5 = 0
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return r1
        L7e:
            int r1 = r15.size()
            if (r1 != r6) goto Lbc
            java.lang.Object r1 = r15.get(r3)
            java.lang.String r3 = "delete"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 == 0) goto Lbc
            java.lang.Object r15 = r15.get(r2)
            boolean r15 = kotlin.jvm.internal.Intrinsics.areEqual(r15, r5)
            if (r15 == 0) goto Lbc
            com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel r5 = r11.this$0
            r9 = 4
            r10 = 0
            java.lang.String r7 = "Executed. This can take a while. Please wait..."
            r8 = 0
            r6 = r14
            com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel.logCommand$default(r5, r6, r7, r8, r9, r10)
            kotlinx.coroutines.CoroutineDispatcher r14 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r14 = (kotlin.coroutines.CoroutineContext) r14
            com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel$commands$6$execute$2 r15 = new com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel$commands$6$execute$2
            r15.<init>(r13, r4)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r12.label = r2
            java.lang.Object r12 = kotlinx.coroutines.BuildersKt.withContext(r14, r15, r12)
            if (r12 != r0) goto Lbb
        Lba:
            return r0
        Lbb:
            return r12
        Lbc:
            com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel$Companion r12 = com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel.INSTANCE
            com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel$Companion$CommandResult r12 = r12.getUnsupportedCommandResult()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel$commands$6.execute(androidx.appcompat.app.AppCompatActivity, com.magneticchen.daijishou.DaijishouApplication, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
