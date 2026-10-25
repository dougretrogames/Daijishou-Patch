package com.magneticchen.daijishou.backup_and_restore;

import android.content.SharedPreferences;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.backup_and_restore.modules.library.LibraryBackupAndRestoreModule;
import com.magneticchen.daijishou.backup_and_restore.modules.misc.MiscBackupAndRestoreModule;
import com.magneticchen.daijishou.backup_and_restore.modules.settings.SettingsBackupAndRestoreModule;
import com.magneticchen.daijishou.backup_and_restore.modules.widget.WidgetBackupAndRestoreModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.Constants;

/* JADX INFO: compiled from: BackupAndRestore.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\n0\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\nJ&\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\n2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\nH\u0086@¢\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0017\u001a\u00020\u000fJ\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\u0006\u0010\u0017\u001a\u00020\u000fJ$\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\n2\u0006\u0010\u001c\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/magneticchen/daijishou/backup_and_restore/BackupAndRestore;", "", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "getApplication", "()Lcom/magneticchen/daijishou/DaijishouApplication;", "defaultSharedPreferences", "Landroid/content/SharedPreferences;", Constants.MODULES, "", "Lcom/magneticchen/daijishou/backup_and_restore/BackupAndRestoreModule;", "acquireMigrationChainsFromBackupContentListMigrations", "Lcom/magneticchen/daijishou/backup_and_restore/BackupAndRestoreModule$Companion$BackupContentMigration;", "fromVersion", "", "toVersion", "migrations", "backupToListOfBackupData", "Lcom/magneticchen/daijishou/backup_and_restore/BackupData;", "previousListOfBackupData", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBackupAndRestoreModulesByPolicy", "policy", "getBackupAndRestoreModulesNameStringIdsByPolicy", "restoreFromListOfBackupData", "", "listOfBackupData", "restorePolicy", "(Ljava/util/List;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BackupAndRestore {
    public static final int OVERRIDE_RESTORE_POLICY = 1;
    public static final int PRESERVE_RESTORE_POLICY = 2;
    public static final int RESET_RESTORE_POLICY = 0;
    private final DaijishouApplication application;
    private final SharedPreferences defaultSharedPreferences;
    private final List<BackupAndRestoreModule> modules;

    /* JADX INFO: renamed from: com.magneticchen.daijishou.backup_and_restore.BackupAndRestore$backupToListOfBackupData$1, reason: invalid class name */
    /* JADX INFO: compiled from: BackupAndRestore.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.backup_and_restore.BackupAndRestore", f = "BackupAndRestore.kt", i = {0, 0, 0, 0}, l = {117}, m = "backupToListOfBackupData", n = {"pipeLineData", "listOfBackupData", "module", "randomInt"}, s = {"L$0", "L$1", "L$3", "I$0"})
    final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj)throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BackupAndRestore.this.backupToListOfBackupData(null, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.backup_and_restore.BackupAndRestore$restoreFromListOfBackupData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BackupAndRestore.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.backup_and_restore.BackupAndRestore", f = "BackupAndRestore.kt", i = {0, 0, 0, 0}, l = {182}, m = "restoreFromListOfBackupData", n = {"this", "listOfBackupData", "pipeLineData", "restorePolicy"}, s = {"L$0", "L$1", "L$2", "I$0"})
    final class C02091 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C02091(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj)throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BackupAndRestore.this.restoreFromListOfBackupData(null, 0, this);
        }
    }

    public BackupAndRestore(DaijishouApplication application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.application = application;
        this.defaultSharedPreferences = application.getDefaultSharedPreferences();
        this.modules = CollectionsKt.listOf(new BackupAndRestoreModule[]{new SettingsBackupAndRestoreModule(application), new MiscBackupAndRestoreModule(application), new LibraryBackupAndRestoreModule(application), new WidgetBackupAndRestoreModule(application)});
    }

    public final DaijishouApplication getApplication() {
        return this.application;
    }

    public final List<BackupAndRestoreModule> getBackupAndRestoreModulesByPolicy(int policy) {
        ArrayList arrayList = new ArrayList();
        for (BackupAndRestoreModule backupAndRestoreModule : this.modules) {
            if (backupAndRestoreModule.getSupportedPolicies().contains(Integer.valueOf(policy))) {
                arrayList.add(backupAndRestoreModule);
            }
        }
        return arrayList;
    }

    public final List<Integer> getBackupAndRestoreModulesNameStringIdsByPolicy(int policy) {
        ArrayList arrayList = new ArrayList();
        for (BackupAndRestoreModule backupAndRestoreModule : this.modules) {
            if (backupAndRestoreModule.getSupportedPolicies().contains(Integer.valueOf(policy))) {
                arrayList.add(Integer.valueOf(backupAndRestoreModule.getNameStringId()));
            }
        }
        return arrayList;
    }

    public final List<List<BackupAndRestoreModule.Companion.BackupContentMigration>> acquireMigrationChainsFromBackupContentListMigrations(int fromVersion, int toVersion, List<? extends BackupAndRestoreModule.Companion.BackupContentMigration> migrations) {
        Intrinsics.checkNotNullParameter(migrations, "migrations");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<BackupAndRestoreModule.Companion.BackupContentMigration> arrayList3 = new ArrayList();
        ArrayList<BackupAndRestoreModule.Companion.BackupContentMigration> arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        for (BackupAndRestoreModule.Companion.BackupContentMigration backupContentMigration : migrations) {
            if (backupContentMigration.getFromVersion() == fromVersion && backupContentMigration.getToVersion() == toVersion) {
                arrayList2.add(backupContentMigration);
            } else if (backupContentMigration.getFromVersion() == fromVersion) {
                arrayList3.add(backupContentMigration);
            } else if (backupContentMigration.getToVersion() == toVersion) {
                arrayList4.add(backupContentMigration);
            } else {
                arrayList5.add(backupContentMigration);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(CollectionsKt.listOf((BackupAndRestoreModule.Companion.BackupContentMigration) it.next()));
        }
        if (!arrayList3.isEmpty() && !arrayList4.isEmpty()) {
            for (BackupAndRestoreModule.Companion.BackupContentMigration backupContentMigration2 : arrayList3) {
                for (BackupAndRestoreModule.Companion.BackupContentMigration backupContentMigration3 : arrayList4) {
                    if (backupContentMigration2.getToVersion() == backupContentMigration3.getFromVersion()) {
                        arrayList.add(CollectionsKt.listOf(new BackupAndRestoreModule.Companion.BackupContentMigration[]{backupContentMigration2, backupContentMigration3}));
                    } else {
                        Iterator it2 = acquireMigrationChainsFromBackupContentListMigrations(backupContentMigration2.getToVersion(), backupContentMigration3.getFromVersion(), arrayList5).iterator();
                        while (it2.hasNext()) {
                            List list = (List) it2.next();
                            ArrayList arrayList6 = new ArrayList();
                            arrayList6.add(backupContentMigration2);
                            arrayList6.addAll(list);
                            arrayList6.add(backupContentMigration3);
                            arrayList.add(arrayList6);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object backupToListOfBackupData$default(BackupAndRestore backupAndRestore, List list, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        return backupAndRestore.backupToListOfBackupData(list, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:20:0x00bf A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x00d2 A[LOOP:0: B:22:0x00cc->B:24:0x00d2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00bd -> B:12:0x003f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object backupToListOfBackupData(java.util.List<com.magneticchen.daijishou.backup_and_restore.BackupData> r18, kotlin.coroutines.Continuation<?> r19) {
        /*
            Method dump skipped, instruction units count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.backup_and_restore.BackupAndRestore.backupToListOfBackupData(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:43:0x0100  */
    /* JADX WARN: Code duplicated, block: B:48:0x012e  */
    /* JADX WARN: Code duplicated, block: B:51:0x0155 A[LOOP:1: B:39:0x00f2->B:51:0x0155, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x0134 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v6, types: [T, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r5v21, types: [T, java.util.HashMap] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x012b -> B:74:0x0265). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x021e -> B:69:0x021f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x0224 -> B:74:0x0265). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x0245 -> B:74:0x0265). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object restoreFromListOfBackupData(java.util.List<com.magneticchen.daijishou.backup_and_restore.BackupData> r19, int r20, kotlin.coroutines.Continuation<?> r21) {
        /*
            Method dump skipped, instruction units count: 621
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.backup_and_restore.BackupAndRestore.restoreFromListOfBackupData(java.util.List, int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
