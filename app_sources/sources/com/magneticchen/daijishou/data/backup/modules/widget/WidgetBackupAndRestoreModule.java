package com.magneticchen.daijishou.data.backup.modules.widget;

import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.backup.BackupAndRestoreModule;
import com.magneticchen.daijishou.data.db.WidgetDatabase;
import com.magneticchen.daijishou.data.db.entity.AppShortcutWidgetInstanceEntity;
import com.magneticchen.daijishou.data.db.entity.ImageBlockWidgetInstanceEntity;
import com.magneticchen.daijishou.data.db.entity.PinAndPlayWidgetInstanceEntity;
import com.magneticchen.daijishou.data.db.entity.RSSWidgetInstanceEntity;
import com.magneticchen.daijishou.data.db.entity.WidgetId;
import com.magneticchen.daijishou.data.db.entity.WidgetInstanceEntity;
import com.magneticchen.daijishou.data.db.repositories.DaijishouWidgetRepository;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: compiled from: WidgetBackupAndRestoreModule.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JR\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001a0\u0019j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001a`\u001b2&\u0010\u001c\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0019j\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u001d`\u001bH\u0096@¢\u0006\u0002\u0010\u001eJb\u0010\u001f\u001a\u00020 2\"\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001a0\u0019j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001a`\u001b2&\u0010\u001c\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0019j\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u001d`\u001b2\u0006\u0010\"\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010#R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u0014\u0010\u0016\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013¨\u0006$"}, d2 = {"Lcom/magneticchen/daijishou/data/backup/modules/widget/WidgetBackupAndRestoreModule;", "Lcom/magneticchen/daijishou/data/backup/BackupAndRestoreModule;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "BATCH_SIZE", "", "SKIP_WIDGETS_INSTANCE_ID_MIGRATION_WIDGET_IDS", "", "", "backupContentListMigrations", "Lcom/magneticchen/daijishou/data/backup/BackupAndRestoreModule$Companion$BackupContentMigration;", "getBackupContentListMigrations", "()Ljava/util/List;", "id", "getId", "()Ljava/lang/String;", "nameStringId", "getNameStringId", "()I", "supportedPolicies", "getSupportedPolicies", "version", "getVersion", "createBackupContentHashMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "pipeLineData", "", "(Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restoreFromBackupContentHashMap", "", "contentHashMap", "restorePolicy", "(Ljava/util/HashMap;Ljava/util/HashMap;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WidgetBackupAndRestoreModule extends BackupAndRestoreModule {
    private final int BATCH_SIZE;
    private final List<String> SKIP_WIDGETS_INSTANCE_ID_MIGRATION_WIDGET_IDS;
    private final List<BackupAndRestoreModule.Companion.BackupContentMigration> backupContentListMigrations;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f13id;
    private final int nameStringId;
    private final List<Integer> supportedPolicies;
    private final int version;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetBackupAndRestoreModule(DaijishouApplication application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.f13id = "daijishou.widgets";
        this.nameStringId = R.string.widgets_backup_and_restore_name;
        this.backupContentListMigrations = CollectionsKt.emptyList();
        this.supportedPolicies = CollectionsKt.listOf(0);
        this.BATCH_SIZE = 128;
        this.SKIP_WIDGETS_INSTANCE_ID_MIGRATION_WIDGET_IDS = CollectionsKt.listOf((Object[]) new String[]{WidgetId.ACTIVITY.getId(), WidgetId.CATEGORY.getId(), WidgetId.RANDOM.getId(), WidgetId.RETRO_ACHIEVEMENTS.getId()});
    }

    @Override // com.magneticchen.daijishou.data.backup.BackupAndRestoreModule
    public String getId() {
        return this.f13id;
    }

    @Override // com.magneticchen.daijishou.data.backup.BackupAndRestoreModule
    public int getNameStringId() {
        return this.nameStringId;
    }

    @Override // com.magneticchen.daijishou.data.backup.BackupAndRestoreModule
    public int getVersion() {
        return this.version;
    }

    @Override // com.magneticchen.daijishou.data.backup.BackupAndRestoreModule
    public List<BackupAndRestoreModule.Companion.BackupContentMigration> getBackupContentListMigrations() {
        return this.backupContentListMigrations;
    }

    @Override // com.magneticchen.daijishou.data.backup.BackupAndRestoreModule
    public List<Integer> getSupportedPolicies() {
        return this.supportedPolicies;
    }

    @Override // com.magneticchen.daijishou.data.backup.BackupAndRestoreModule
    public Object createBackupContentHashMap(HashMap<String, Object> map, Continuation<? super HashMap<String, byte[]>> continuation) {
        HashMap map2 = new HashMap();
        File databasePath = getApplication().getDatabasePath(WidgetDatabase.DB_NAME);
        File file = new File(databasePath.getPath() + "-shm");
        File file2 = new File(databasePath.getPath() + "-wal");
        File file3 = new File(databasePath.getPath() + "-bkp");
        if (databasePath.exists()) {
            Intrinsics.checkNotNull(databasePath);
            map2.put("widgetDatabaseFile", FilesKt.readBytes(databasePath));
        }
        if (file.exists()) {
            map2.put("widgetDatabaseShmFile", FilesKt.readBytes(file));
        }
        if (file2.exists()) {
            map2.put("widgetDatabaseWalFile", FilesKt.readBytes(file2));
        }
        if (file3.exists()) {
            map2.put("widgetDatabaseBkbFile", FilesKt.readBytes(file3));
        }
        return map2;
    }

    /* JADX WARN: Code duplicated, block: B:156:0x0567  */
    /* JADX WARN: Code duplicated, block: B:159:0x0570  */
    /* JADX WARN: Code duplicated, block: B:162:0x0579  */
    @Override // com.magneticchen.daijishou.data.backup.BackupAndRestoreModule
    public Object restoreFromBackupContentHashMap(HashMap<String, byte[]> map, HashMap<String, Object> map2, int i, Continuation<? super Unit> continuation) {
        File file;
        File file2;
        File file3;
        File file4;
        HashMap map3;
        DaijishouWidgetRepository daijishouWidgetRepository;
        HashMap map4;
        HashMap map5;
        HashMap map6;
        byte[] bArr = map.get("widgetDatabaseFile");
        if (bArr != null) {
            File databasePath = getApplication().getDatabasePath("WidgetDatabaseRestore.db");
            File file5 = new File(databasePath.getPath() + "-shm");
            File file6 = new File(databasePath.getPath() + "-wal");
            File file7 = new File(databasePath.getPath() + "-bkp");
            Intrinsics.checkNotNull(databasePath);
            FilesKt.writeBytes(databasePath, bArr);
            byte[] bArr2 = map.get("widgetDatabaseShmFile");
            if (bArr2 != null) {
                Intrinsics.checkNotNull(bArr2);
                FilesKt.writeBytes(file5, bArr2);
            }
            byte[] bArr3 = map.get("widgetDatabaseWalFile");
            if (bArr3 != null) {
                Intrinsics.checkNotNull(bArr3);
                FilesKt.writeBytes(file6, bArr3);
            }
            byte[] bArr4 = map.get("widgetDatabaseBkbFile");
            if (bArr4 != null) {
                Intrinsics.checkNotNull(bArr4);
                FilesKt.writeBytes(file7, bArr4);
            }
            WidgetDatabase companion = WidgetDatabase.Companion.getInstance(getApplication(), "WidgetDatabaseRestore.db");
            getLogger().debug(this, "Acquired restored widget database.\nName: WidgetDatabaseRestore.db\nPath: " + databasePath.getAbsolutePath() + "\nObject: " + companion + "\nWidgets counts: " + companion.widgetInstanceDAO().countAllStatically() + "\n");
            DaijishouWidgetRepository daijishouWidgetRepository2 = getApplication().getDaijishouWidgetRepository();
            DaijishouWidgetRepository daijishouWidgetRepository3 = new DaijishouWidgetRepository(getApplication(), "WidgetDatabaseRestore.db");
            try {
                Object obj = map2.get("playableItemIdMigration");
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.util.HashMap<kotlin.Long, kotlin.Long>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.Long, kotlin.Long> }");
                HashMap map7 = (HashMap) obj;
                daijishouWidgetRepository2.clearAll();
                HashMap map8 = new HashMap();
                HashMap map9 = new HashMap();
                HashMap map10 = new HashMap();
                map8.put(WidgetId.RSS.getId(), map9);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (RSSWidgetInstanceEntity rSSWidgetInstanceEntity : daijishouWidgetRepository3.getAllRSSWidgetInstancesStatically()) {
                    try {
                        arrayList.add(rSSWidgetInstanceEntity.copyAndResetDatabaseAndDeviceDependentValues());
                        arrayList2.add(Boxing.boxLong(rSSWidgetInstanceEntity.getId()));
                        file = databasePath;
                        try {
                            getLogger().debug(this, String.valueOf(rSSWidgetInstanceEntity));
                            if (arrayList.size() >= this.BATCH_SIZE) {
                                restoreFromBackupContentHashMap$lambda$15$digestRSSWidgetInstances(daijishouWidgetRepository2, arrayList, arrayList2, map9);
                            }
                            file2 = file5;
                        } catch (Exception e) {
                            e = e;
                            try {
                                file2 = file5;
                                try {
                                    getLogger().error(this, ExceptionsKt.stackTraceToString(e));
                                    map10.put(Boxing.boxLong(rSSWidgetInstanceEntity.getId()), e);
                                } catch (Exception e2) {
                                    e = e2;
                                    file4 = file6;
                                    file3 = file7;
                                    getLogger().error(this, ExceptionsKt.stackTraceToString(e));
                                    WidgetDatabase.Companion.closeInstance("WidgetDatabaseRestore.db");
                                    file.delete();
                                    if (file2.exists()) {
                                        file2.delete();
                                    }
                                    if (file4.exists()) {
                                        file4.delete();
                                    }
                                    if (file3.exists()) {
                                        file3.delete();
                                    }
                                    BuildersKt.launch$default(CoroutineScopeKt.MainScope(), (CoroutineContext) null, (CoroutineStart) null, new WidgetBackupAndRestoreModule$restoreFromBackupContentHashMap$2$9(this, null), 3, (Object) null);
                                    return Unit.INSTANCE;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                file2 = file5;
                                file4 = file6;
                                file3 = file7;
                                getLogger().error(this, ExceptionsKt.stackTraceToString(e));
                                WidgetDatabase.Companion.closeInstance("WidgetDatabaseRestore.db");
                                file.delete();
                                if (file2.exists()) {
                                    file2.delete();
                                }
                                if (file4.exists()) {
                                    file4.delete();
                                }
                                if (file3.exists()) {
                                    file3.delete();
                                }
                                BuildersKt.launch$default(CoroutineScopeKt.MainScope(), (CoroutineContext) null, (CoroutineStart) null, new WidgetBackupAndRestoreModule$restoreFromBackupContentHashMap$2$9(this, null), 3, (Object) null);
                                return Unit.INSTANCE;
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        file = databasePath;
                    }
                    databasePath = file;
                    file5 = file2;
                }
                file = databasePath;
                file2 = file5;
                restoreFromBackupContentHashMap$lambda$15$digestRSSWidgetInstances(daijishouWidgetRepository2, arrayList, arrayList2, map9);
                HashMap map11 = new HashMap();
                HashMap map12 = new HashMap();
                map8.put(WidgetId.IMAGE_BLOCK.getId(), map11);
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                for (ImageBlockWidgetInstanceEntity imageBlockWidgetInstanceEntity : daijishouWidgetRepository3.getAllImageBlockWidgetInstancesStatically()) {
                    try {
                        ImageBlockWidgetInstanceEntity imageBlockWidgetInstanceEntityCopyAndResetDatabaseAndDeviceDependentValues = imageBlockWidgetInstanceEntity.copyAndResetDatabaseAndDeviceDependentValues();
                        if (imageBlockWidgetInstanceEntityCopyAndResetDatabaseAndDeviceDependentValues.getImagePath() != null) {
                            map6 = map12;
                            try {
                                String imagePath = imageBlockWidgetInstanceEntity.getImagePath();
                                Intrinsics.checkNotNull(imagePath);
                                if (new File(imagePath).exists()) {
                                    imageBlockWidgetInstanceEntityCopyAndResetDatabaseAndDeviceDependentValues.getImagePath();
                                }
                            } catch (Exception e5) {
                                e = e5;
                                getLogger().error(this, ExceptionsKt.stackTraceToString(e));
                                map6.put(Boxing.boxLong(imageBlockWidgetInstanceEntity.getId()), e);
                                if (imageBlockWidgetInstanceEntity.getImagePath() != null) {
                                    String imagePath2 = imageBlockWidgetInstanceEntity.getImagePath();
                                    Intrinsics.checkNotNull(imagePath2);
                                    if (new File(imagePath2).exists()) {
                                        String imagePath3 = imageBlockWidgetInstanceEntity.getImagePath();
                                        Intrinsics.checkNotNull(imagePath3);
                                        new File(imagePath3).delete();
                                    }
                                }
                            }
                        } else {
                            map6 = map12;
                        }
                        arrayList3.add(imageBlockWidgetInstanceEntityCopyAndResetDatabaseAndDeviceDependentValues);
                        arrayList4.add(Boxing.boxLong(imageBlockWidgetInstanceEntity.getId()));
                        getLogger().debug(this, String.valueOf(imageBlockWidgetInstanceEntity));
                        if (arrayList3.size() >= this.BATCH_SIZE) {
                            restoreFromBackupContentHashMap$lambda$15$digestImageBlockWidgetInstances(daijishouWidgetRepository2, arrayList3, arrayList4, map11);
                        }
                    } catch (Exception e6) {
                        e = e6;
                        map6 = map12;
                    }
                    map12 = map6;
                }
                restoreFromBackupContentHashMap$lambda$15$digestImageBlockWidgetInstances(daijishouWidgetRepository2, arrayList3, arrayList4, map11);
                HashMap map13 = new HashMap();
                HashMap map14 = new HashMap();
                map8.put(WidgetId.PIN_AND_PLAY.getId(), map13);
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                for (PinAndPlayWidgetInstanceEntity pinAndPlayWidgetInstanceEntity : daijishouWidgetRepository3.getAllPinAndPlayWidgetInstancesStatically()) {
                    try {
                        PinAndPlayWidgetInstanceEntity pinAndPlayWidgetInstanceEntityCopyAndResetDatabaseAndDeviceDependentValues = pinAndPlayWidgetInstanceEntity.copyAndResetDatabaseAndDeviceDependentValues();
                        if (pinAndPlayWidgetInstanceEntityCopyAndResetDatabaseAndDeviceDependentValues.getAlternativeImagePath() != null) {
                            map5 = map14;
                            try {
                                String alternativeImagePath = pinAndPlayWidgetInstanceEntity.getAlternativeImagePath();
                                Intrinsics.checkNotNull(alternativeImagePath);
                                if (new File(alternativeImagePath).exists()) {
                                    pinAndPlayWidgetInstanceEntityCopyAndResetDatabaseAndDeviceDependentValues.getAlternativeImagePath();
                                }
                            } catch (Exception e7) {
                                e = e7;
                                getLogger().error(this, ExceptionsKt.stackTraceToString(e));
                                map5.put(Boxing.boxLong(pinAndPlayWidgetInstanceEntity.getId()), e);
                                if (pinAndPlayWidgetInstanceEntity.getAlternativeImagePath() != null) {
                                    String alternativeImagePath2 = pinAndPlayWidgetInstanceEntity.getAlternativeImagePath();
                                    Intrinsics.checkNotNull(alternativeImagePath2);
                                    if (new File(alternativeImagePath2).exists()) {
                                        String alternativeImagePath3 = pinAndPlayWidgetInstanceEntity.getAlternativeImagePath();
                                        Intrinsics.checkNotNull(alternativeImagePath3);
                                        new File(alternativeImagePath3).delete();
                                    }
                                }
                            }
                        } else {
                            map5 = map14;
                        }
                        Object obj2 = map7.get(pinAndPlayWidgetInstanceEntity.getPlayableItemId());
                        Intrinsics.checkNotNull(obj2);
                        pinAndPlayWidgetInstanceEntityCopyAndResetDatabaseAndDeviceDependentValues.setPlayableItemId((Long) obj2);
                        arrayList5.add(pinAndPlayWidgetInstanceEntityCopyAndResetDatabaseAndDeviceDependentValues);
                        arrayList6.add(Boxing.boxLong(pinAndPlayWidgetInstanceEntity.getId()));
                        getLogger().debug(this, String.valueOf(pinAndPlayWidgetInstanceEntity));
                        if (arrayList5.size() >= this.BATCH_SIZE) {
                            restoreFromBackupContentHashMap$lambda$15$digestPinAndPlayWidgetInstances(daijishouWidgetRepository2, arrayList5, arrayList6, map13);
                        }
                    } catch (Exception e8) {
                        e = e8;
                        map5 = map14;
                    }
                    map14 = map5;
                }
                restoreFromBackupContentHashMap$lambda$15$digestPinAndPlayWidgetInstances(daijishouWidgetRepository2, arrayList5, arrayList6, map13);
                HashMap map15 = new HashMap();
                HashMap map16 = new HashMap();
                map8.put(WidgetId.APP_SHORTCUT.getId(), map15);
                ArrayList arrayList7 = new ArrayList();
                ArrayList arrayList8 = new ArrayList();
                for (AppShortcutWidgetInstanceEntity appShortcutWidgetInstanceEntity : daijishouWidgetRepository3.getAllAppShortcutWidgetInstancesStatically()) {
                    try {
                        arrayList7.add(appShortcutWidgetInstanceEntity.copyAndResetDatabaseAndDeviceDependentValues());
                        arrayList8.add(Boxing.boxLong(appShortcutWidgetInstanceEntity.getId()));
                        getLogger().debug(this, String.valueOf(appShortcutWidgetInstanceEntity));
                        if (arrayList7.size() >= this.BATCH_SIZE) {
                            restoreFromBackupContentHashMap$lambda$15$digestAppShortcutWidgetInstances(daijishouWidgetRepository2, arrayList7, arrayList8, map15);
                        }
                    } catch (Exception e9) {
                        getLogger().error(this, ExceptionsKt.stackTraceToString(e9));
                        map16.put(Boxing.boxLong(appShortcutWidgetInstanceEntity.getId()), e9);
                    }
                }
                restoreFromBackupContentHashMap$lambda$15$digestAppShortcutWidgetInstances(daijishouWidgetRepository2, arrayList7, arrayList8, map15);
                HashMap map17 = new HashMap();
                HashMap map18 = new HashMap();
                ArrayList arrayList9 = new ArrayList();
                ArrayList arrayList10 = new ArrayList();
                getLogger().debug(this, "allWidgetWidgetInstanceIdMigrations: " + map8);
                Iterator<T> it = daijishouWidgetRepository3.getAllWidgetInstanceIdsStatically().iterator();
                while (it.hasNext()) {
                    long jLongValue = ((Number) it.next()).longValue();
                    try {
                        WidgetInstanceEntity widgetInstanceByIdStatically = daijishouWidgetRepository3.getWidgetInstanceByIdStatically(jLongValue);
                        Intrinsics.checkNotNull(widgetInstanceByIdStatically);
                        WidgetInstanceEntity widgetInstanceEntityCopyAndResetDatabaseAndDeviceDependentValues = widgetInstanceByIdStatically.copyAndResetDatabaseAndDeviceDependentValues();
                        map3 = map18;
                        try {
                            file4 = file6;
                            try {
                                if (this.SKIP_WIDGETS_INSTANCE_ID_MIGRATION_WIDGET_IDS.contains(widgetInstanceEntityCopyAndResetDatabaseAndDeviceDependentValues.getWidgetId())) {
                                    file3 = file7;
                                    daijishouWidgetRepository = daijishouWidgetRepository3;
                                    map4 = map8;
                                } else {
                                    HashMap map19 = (HashMap) map8.get(widgetInstanceEntityCopyAndResetDatabaseAndDeviceDependentValues.getWidgetId());
                                    if (map19 != null) {
                                        file3 = file7;
                                        try {
                                            daijishouWidgetRepository = daijishouWidgetRepository3;
                                            try {
                                                map4 = map8;
                                                try {
                                                    getLogger().debug(this, "Migration " + widgetInstanceEntityCopyAndResetDatabaseAndDeviceDependentValues.getWidgetId() + ": " + map19);
                                                    Long l = (Long) map19.get(Boxing.boxLong(widgetInstanceByIdStatically.getWidgetInstanceId()));
                                                    if (l != null) {
                                                        Intrinsics.checkNotNull(l);
                                                        widgetInstanceEntityCopyAndResetDatabaseAndDeviceDependentValues.setWidgetInstanceId(l.longValue());
                                                    }
                                                } catch (Exception e10) {
                                                    e = e10;
                                                    try {
                                                        getLogger().error(this, ExceptionsKt.stackTraceToString(e));
                                                        map3.put(Boxing.boxLong(jLongValue), e);
                                                    } catch (Exception e11) {
                                                        e = e11;
                                                        getLogger().error(this, ExceptionsKt.stackTraceToString(e));
                                                        WidgetDatabase.Companion.closeInstance("WidgetDatabaseRestore.db");
                                                        file.delete();
                                                        if (file2.exists()) {
                                                            file2.delete();
                                                        }
                                                        if (file4.exists()) {
                                                            file4.delete();
                                                        }
                                                        if (file3.exists()) {
                                                            file3.delete();
                                                        }
                                                        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), (CoroutineContext) null, (CoroutineStart) null, new WidgetBackupAndRestoreModule$restoreFromBackupContentHashMap$2$9(this, null), 3, (Object) null);
                                                        return Unit.INSTANCE;
                                                    }
                                                }
                                            } catch (Exception e12) {
                                                e = e12;
                                                map4 = map8;
                                                getLogger().error(this, ExceptionsKt.stackTraceToString(e));
                                                map3.put(Boxing.boxLong(jLongValue), e);
                                            }
                                        } catch (Exception e13) {
                                            e = e13;
                                            daijishouWidgetRepository = daijishouWidgetRepository3;
                                            map4 = map8;
                                            getLogger().error(this, ExceptionsKt.stackTraceToString(e));
                                            map3.put(Boxing.boxLong(jLongValue), e);
                                            map18 = map3;
                                            map8 = map4;
                                            file6 = file4;
                                            file7 = file3;
                                            daijishouWidgetRepository3 = daijishouWidgetRepository;
                                        }
                                    } else {
                                        file3 = file7;
                                        daijishouWidgetRepository = daijishouWidgetRepository3;
                                        map4 = map8;
                                    }
                                    throw new Exception("Has no migration for:\n" + widgetInstanceByIdStatically);
                                }
                                arrayList9.add(widgetInstanceEntityCopyAndResetDatabaseAndDeviceDependentValues);
                                arrayList10.add(Boxing.boxLong(jLongValue));
                                arrayList10.add(Boxing.boxLong(widgetInstanceByIdStatically.getWidgetInstanceId()));
                                if (arrayList9.size() >= this.BATCH_SIZE) {
                                    restoreFromBackupContentHashMap$lambda$15$digestWidgetInstances(daijishouWidgetRepository2, arrayList9, this, arrayList10, map17);
                                }
                            } catch (Exception e14) {
                                e = e14;
                                file3 = file7;
                                daijishouWidgetRepository = daijishouWidgetRepository3;
                                map4 = map8;
                                getLogger().error(this, ExceptionsKt.stackTraceToString(e));
                                map3.put(Boxing.boxLong(jLongValue), e);
                                map18 = map3;
                                map8 = map4;
                                file6 = file4;
                                file7 = file3;
                                daijishouWidgetRepository3 = daijishouWidgetRepository;
                            }
                        } catch (Exception e15) {
                            e = e15;
                            file4 = file6;
                            file3 = file7;
                            daijishouWidgetRepository = daijishouWidgetRepository3;
                            map4 = map8;
                            getLogger().error(this, ExceptionsKt.stackTraceToString(e));
                            map3.put(Boxing.boxLong(jLongValue), e);
                            map18 = map3;
                            map8 = map4;
                            file6 = file4;
                            file7 = file3;
                            daijishouWidgetRepository3 = daijishouWidgetRepository;
                        }
                    } catch (Exception e16) {
                        e = e16;
                        map3 = map18;
                    }
                    map18 = map3;
                    map8 = map4;
                    file6 = file4;
                    file7 = file3;
                    daijishouWidgetRepository3 = daijishouWidgetRepository;
                }
                file4 = file6;
                file3 = file7;
                restoreFromBackupContentHashMap$lambda$15$digestWidgetInstances(daijishouWidgetRepository2, arrayList9, this, arrayList10, map17);
            } catch (Exception e17) {
                e = e17;
                file = databasePath;
            }
            WidgetDatabase.Companion.closeInstance("WidgetDatabaseRestore.db");
            file.delete();
            if (file2.exists()) {
                file2.delete();
            }
            if (file4.exists()) {
                file4.delete();
            }
            if (file3.exists()) {
                file3.delete();
            }
            BuildersKt.launch$default(CoroutineScopeKt.MainScope(), (CoroutineContext) null, (CoroutineStart) null, new WidgetBackupAndRestoreModule$restoreFromBackupContentHashMap$2$9(this, null), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }

    private static final void restoreFromBackupContentHashMap$lambda$15$digestRSSWidgetInstances(DaijishouWidgetRepository daijishouWidgetRepository, List<RSSWidgetInstanceEntity> list, List<Long> list2, HashMap<Long, Long> map) {
        int i = 0;
        RSSWidgetInstanceEntity[] rSSWidgetInstanceEntityArr = (RSSWidgetInstanceEntity[]) list.toArray(new RSSWidgetInstanceEntity[0]);
        for (Object obj : daijishouWidgetRepository.addRSSWidgetInstances((RSSWidgetInstanceEntity[]) Arrays.copyOf(rSSWidgetInstanceEntityArr, rSSWidgetInstanceEntityArr.length))) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            map.put(list2.get(i), Long.valueOf(((Number) obj).longValue()));
            i = i2;
        }
        list.clear();
        list2.clear();
    }

    private static final void restoreFromBackupContentHashMap$lambda$15$digestImageBlockWidgetInstances(DaijishouWidgetRepository daijishouWidgetRepository, List<ImageBlockWidgetInstanceEntity> list, List<Long> list2, HashMap<Long, Long> map) {
        int i = 0;
        ImageBlockWidgetInstanceEntity[] imageBlockWidgetInstanceEntityArr = (ImageBlockWidgetInstanceEntity[]) list.toArray(new ImageBlockWidgetInstanceEntity[0]);
        for (Object obj : daijishouWidgetRepository.addImageBlockWidgetInstances((ImageBlockWidgetInstanceEntity[]) Arrays.copyOf(imageBlockWidgetInstanceEntityArr, imageBlockWidgetInstanceEntityArr.length))) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            map.put(list2.get(i), Long.valueOf(((Number) obj).longValue()));
            i = i2;
        }
        list.clear();
        list2.clear();
    }

    private static final void restoreFromBackupContentHashMap$lambda$15$digestPinAndPlayWidgetInstances(DaijishouWidgetRepository daijishouWidgetRepository, List<PinAndPlayWidgetInstanceEntity> list, List<Long> list2, HashMap<Long, Long> map) {
        int i = 0;
        PinAndPlayWidgetInstanceEntity[] pinAndPlayWidgetInstanceEntityArr = (PinAndPlayWidgetInstanceEntity[]) list.toArray(new PinAndPlayWidgetInstanceEntity[0]);
        for (Object obj : daijishouWidgetRepository.addPinAndPlayWidgetInstances((PinAndPlayWidgetInstanceEntity[]) Arrays.copyOf(pinAndPlayWidgetInstanceEntityArr, pinAndPlayWidgetInstanceEntityArr.length))) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            map.put(list2.get(i), Long.valueOf(((Number) obj).longValue()));
            i = i2;
        }
        list.clear();
        list2.clear();
    }

    private static final void restoreFromBackupContentHashMap$lambda$15$digestAppShortcutWidgetInstances(DaijishouWidgetRepository daijishouWidgetRepository, List<AppShortcutWidgetInstanceEntity> list, List<Long> list2, HashMap<Long, Long> map) {
        int i = 0;
        AppShortcutWidgetInstanceEntity[] appShortcutWidgetInstanceEntityArr = (AppShortcutWidgetInstanceEntity[]) list.toArray(new AppShortcutWidgetInstanceEntity[0]);
        for (Object obj : daijishouWidgetRepository.addAppShortcutWidgetInstances((AppShortcutWidgetInstanceEntity[]) Arrays.copyOf(appShortcutWidgetInstanceEntityArr, appShortcutWidgetInstanceEntityArr.length))) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            map.put(list2.get(i), Long.valueOf(((Number) obj).longValue()));
            i = i2;
        }
        list.clear();
        list2.clear();
    }

    private static final void restoreFromBackupContentHashMap$lambda$15$digestWidgetInstances(DaijishouWidgetRepository daijishouWidgetRepository, List<WidgetInstanceEntity> list, WidgetBackupAndRestoreModule widgetBackupAndRestoreModule, List<Long> list2, HashMap<Long, Long> map) {
        int i = 0;
        WidgetInstanceEntity[] widgetInstanceEntityArr = (WidgetInstanceEntity[]) list.toArray(new WidgetInstanceEntity[0]);
        for (Object obj : daijishouWidgetRepository.addWidgetInstances((WidgetInstanceEntity[]) Arrays.copyOf(widgetInstanceEntityArr, widgetInstanceEntityArr.length))) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            long jLongValue = ((Number) obj).longValue();
            daijishouWidgetRepository.getWidgetInstanceByIdStatically(jLongValue);
            map.put(list2.get(i), Long.valueOf(jLongValue));
            i = i2;
        }
        widgetBackupAndRestoreModule.getLogger().debug(widgetBackupAndRestoreModule, "widgetInstancesToBeAdded: " + list);
        list.clear();
        list2.clear();
    }
}
