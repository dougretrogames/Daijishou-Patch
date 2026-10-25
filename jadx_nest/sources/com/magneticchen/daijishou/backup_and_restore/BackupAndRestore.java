package com.magneticchen.daijishou.backup_and_restore;

import android.content.SharedPreferences;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.application_data.BooleanPreference;
import com.magneticchen.daijishou.backup_and_restore.modules.library.LibraryBackupAndRestoreModule;
import com.magneticchen.daijishou.backup_and_restore.modules.misc.MiscBackupAndRestoreModule;
import com.magneticchen.daijishou.backup_and_restore.modules.settings.SettingsBackupAndRestoreModule;
import com.magneticchen.daijishou.backup_and_restore.modules.widget.WidgetBackupAndRestoreModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
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

    public final Object backupToListOfBackupData(List<BackupData> previousListOfBackupData, Continuation<?> continuation) {
        AnonymousClass1 cont;
        if (continuation instanceof AnonymousClass1) {
            cont = (AnonymousClass1) continuation;
            if ((cont.label & Integer.MIN_VALUE) != 0) {
                cont.label -= Integer.MIN_VALUE;
            } else {
                cont = new AnonymousClass1(continuation);
            }
        } else {
            cont = new AnonymousClass1(continuation);
        }
        Object result = cont.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int label = cont.label;
        HashMap pipeLineData;
        List<BackupData> listOfBackupData;
        Iterator<BackupAndRestoreModule> it;
        BackupAndRestoreModule module;
        int randomInt;

        if (label == 0) {
            ResultKt.throwOnFailure(result);
            pipeLineData = new HashMap();
            listOfBackupData = new ArrayList<>();
            pipeLineData.put("lastBackupTimestamp", Boxing.boxLong(this.defaultSharedPreferences.getLong("last_backup_timestamp", 0L)));
            pipeLineData.put("useLightweightBackup", Boxing.boxBoolean(this.defaultSharedPreferences.getBoolean(BooleanPreference.USE_LIGHTWEIGHT_BACKUP.getKey(), BooleanPreference.USE_LIGHTWEIGHT_BACKUP.getDefaultValue())));
            it = this.modules.iterator();
        } else if (label == 1) {
            randomInt = cont.I$0;
            module = (BackupAndRestoreModule) cont.L$3;
            it = (Iterator<BackupAndRestoreModule>) cont.L$2;
            listOfBackupData = (List<BackupData>) cont.L$1;
            pipeLineData = (HashMap) cont.L$0;
            ResultKt.throwOnFailure(result);
            HashMap contentMap = (HashMap) result;
            for (Map.Entry entry : (Set<Map.Entry>) contentMap.entrySet()) {
                listOfBackupData.add(new BackupData(
                    module.getId(),
                    module.getVersion(),
                    randomInt,
                    System.currentTimeMillis(),
                    (String) entry.getKey(),
                    (byte[]) entry.getValue()
                ));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        while (it.hasNext()) {
            module = it.next();
            randomInt = Random.Default.nextInt();
            cont.L$0 = pipeLineData;
            cont.L$1 = listOfBackupData;
            cont.L$2 = it;
            cont.L$3 = module;
            cont.I$0 = randomInt;
            cont.label = 1;
            Object res = module.createBackupContentHashMap(pipeLineData, cont);
            if (res == coroutine_suspended) {
                return coroutine_suspended;
            }
            HashMap contentMap = (HashMap) res;
            for (Map.Entry entry : (Set<Map.Entry>) contentMap.entrySet()) {
                listOfBackupData.add(new BackupData(
                    module.getId(),
                    module.getVersion(),
                    randomInt,
                    System.currentTimeMillis(),
                    (String) entry.getKey(),
                    (byte[]) entry.getValue()
                ));
            }
        }
        return listOfBackupData;
    }

    public final Object restoreFromListOfBackupData(List<BackupData> listOfBackupData, int restorePolicy, Continuation<?> continuation) {
        C02091 cont;
        if (continuation instanceof C02091) {
            cont = (C02091) continuation;
            if ((cont.label & Integer.MIN_VALUE) != 0) {
                cont.label -= Integer.MIN_VALUE;
            } else {
                cont = new C02091(continuation);
            }
        } else {
            cont = new C02091(continuation);
        }
        Object result = cont.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int label = cont.label;
        HashMap pipeLineData;
        Iterator<BackupAndRestoreModule> it;

        if (label == 0) {
            ResultKt.throwOnFailure(result);
            pipeLineData = new HashMap();
            it = getBackupAndRestoreModulesByPolicy(restorePolicy).iterator();
        } else if (label == 1) {
            restorePolicy = cont.I$0;
            it = (Iterator<BackupAndRestoreModule>) cont.L$3;
            pipeLineData = (HashMap) cont.L$2;
            listOfBackupData = (List<BackupData>) cont.L$1;
            ResultKt.throwOnFailure(result);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        String tag = "Restore from module with id (";
        while (it.hasNext()) {
            BackupAndRestoreModule module = it.next();
            List<BackupData> listOfBackupDataForModule = new ArrayList<>();
            boolean hasOlderVersion = false;
            boolean hasNewerVersion = false;
            for (BackupData item : listOfBackupData) {
                if (Intrinsics.areEqual(item.getModuleId(), module.getId())) {
                    listOfBackupDataForModule.add(item);
                }
                if (item.getModuleVersion() < module.getVersion()) {
                    hasOlderVersion = true;
                }
                if (item.getModuleVersion() > module.getVersion()) {
                    hasNewerVersion = true;
                }
            }
            if (hasNewerVersion || listOfBackupDataForModule.isEmpty()) {
                if (hasNewerVersion) {
                    this.application.getLogger().error(this, tag + module.getId() + ") abort. Because backup has a newer version.");
                } else {
                    this.application.getLogger().error(this, tag + module.getId() + ") abort. Because listOfBackupDataForModule is empty.");
                }
                continue;
            }
            int firstVersion = listOfBackupDataForModule.get(0).getModuleVersion();
            int firstRandomInt = listOfBackupDataForModule.get(0).getModuleRandomInt();
            if (listOfBackupDataForModule.size() > 1) {
                CollectionsKt.sortWith(listOfBackupDataForModule, new BackupAndRestore$restoreFromListOfBackupData$lambda$15$$inlined$sortBy$1());
            }
            boolean unaligned = false;
            for (BackupData item : listOfBackupDataForModule) {
                if (item.getModuleVersion() != firstVersion) {
                    this.application.getLogger().error(this, tag + module.getId() + ") abort. Because versions are unaligned.");
                    unaligned = true;
                    break;
                }
                if (item.getModuleRandomInt() != firstRandomInt) {
                    this.application.getLogger().error(this, tag + module.getId() + ") abort. Because random ints are unaligned.");
                    unaligned = true;
                    break;
                }
            }
            if (unaligned) {
                continue;
            }
            HashMap<String, byte[]> backupContent = new HashMap<>();
            for (BackupData item : listOfBackupDataForModule) {
                backupContent.put(item.getContentHashMapKey(), item.getContent());
            }
            if (hasOlderVersion) {
                List<List<BackupAndRestoreModule.Companion.BackupContentMigration>> migrationChains =
                    acquireMigrationChainsFromBackupContentListMigrations(firstVersion, module.getVersion(), module.getBackupContentListMigrations());
                if (!migrationChains.isEmpty()) {
                    List<BackupAndRestoreModule.Companion.BackupContentMigration> shortestChain =
                        (List<BackupAndRestoreModule.Companion.BackupContentMigration>) CollectionsKt.sortedWith(migrationChains, new BackupAndRestore$restoreFromListOfBackupData$lambda$15$$inlined$sortedBy$1()).get(0);
                    for (BackupAndRestoreModule.Companion.BackupContentMigration migration : shortestChain) {
                        backupContent = migration.migrate(backupContent);
                    }
                } else {
                    this.application.getLogger().error(this, tag + module.getId() + ") abort. Because migration from \"" + firstVersion + "\" to \"{" + module + ".version}\" is not supported.");
                    continue;
                }
            }
            cont.L$0 = this;
            cont.L$1 = listOfBackupData;
            cont.L$2 = pipeLineData;
            cont.L$3 = it;
            cont.I$0 = restorePolicy;
            cont.label = 1;
            if (module.restoreFromBackupContentHashMap(backupContent, pipeLineData, restorePolicy, cont) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
