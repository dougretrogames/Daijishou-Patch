package com.magneticchen.daijishou.backup_and_restore.modules.widget;

import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.backup_and_restore.BackupAndRestoreModule;
import com.magneticchen.daijishou.daijishou_widget.widget_db.AppShortcutWidgetInstanceEntity;
import com.magneticchen.daijishou.daijishou_widget.widget_db.ImageBlockWidgetInstanceEntity;
import com.magneticchen.daijishou.daijishou_widget.widget_db.PinAndPlayWidgetInstanceEntity;
import com.magneticchen.daijishou.daijishou_widget.widget_db.RSSWidgetInstanceEntity;
import com.magneticchen.daijishou.daijishou_widget.widget_db.WidgetDatabase;
import com.magneticchen.daijishou.daijishou_widget.widget_db.WidgetId;
import com.magneticchen.daijishou.daijishou_widget.widget_db.WidgetInstanceEntity;
import com.magneticchen.daijishou.repositories.DaijishouWidgetRepository;
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
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: WidgetBackupAndRestoreModule.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0001\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JR\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00180\u0017j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0018`\u00192&\u0010\u001a\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001b`\u0019H\u0096@¢\u0006\u0002\u0010\u001cJb\u0010\u001d\u001a\u00020\u001e2\"\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00180\u0017j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0018`\u00192&\u0010\u001a\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001b`\u00192\u0006\u0010 \u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010!R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011¨\u0006#"}, d2 = {"Lcom/magneticchen/daijishou/backup_and_restore/modules/widget/WidgetBackupAndRestoreModule;", "Lcom/magneticchen/daijishou/backup_and_restore/BackupAndRestoreModule;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "backupContentListMigrations", "", "Lcom/magneticchen/daijishou/backup_and_restore/BackupAndRestoreModule$Companion$BackupContentMigration;", "getBackupContentListMigrations", "()Ljava/util/List;", "id", "", "getId", "()Ljava/lang/String;", "nameStringId", "", "getNameStringId", "()I", "supportedPolicies", "getSupportedPolicies", "version", "getVersion", "createBackupContentHashMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "pipeLineData", "", "(Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restoreFromBackupContentHashMap", "", "contentHashMap", "restorePolicy", "(Ljava/util/HashMap;Ljava/util/HashMap;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WidgetBackupAndRestoreModule extends BackupAndRestoreModule {
    private final List<BackupAndRestoreModule.Companion.BackupContentMigration> backupContentListMigrations;
    private final String id;
    private final int nameStringId;
    private final List<Integer> supportedPolicies;
    private final int version = 0;
    private static final int BATCH_SIZE = 128;
    private static final List<String> SKIP_WIDGETS_INSTANCE_ID_MIGRATION_WIDGET_IDS = CollectionsKt.listOf(new String[]{WidgetId.ACTIVITY.getId(), WidgetId.CATEGORY.getId(), WidgetId.RANDOM.getId(), WidgetId.RETRO_ACHIEVEMENTS.getId()});

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetBackupAndRestoreModule(DaijishouApplication application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.id = "daijishou.widgets";
        this.nameStringId = R.string.widgets_backup_and_restore_name;
        this.backupContentListMigrations = CollectionsKt.emptyList();
        this.supportedPolicies = CollectionsKt.listOf(0);
    }

    @Override // com.magneticchen.daijishou.backup_and_restore.BackupAndRestoreModule
    public String getId() {
        return this.id;
    }

    @Override // com.magneticchen.daijishou.backup_and_restore.BackupAndRestoreModule
    public int getNameStringId() {
        return this.nameStringId;
    }

    @Override // com.magneticchen.daijishou.backup_and_restore.BackupAndRestoreModule
    public int getVersion() {
        return this.version;
    }

    @Override // com.magneticchen.daijishou.backup_and_restore.BackupAndRestoreModule
    public List<BackupAndRestoreModule.Companion.BackupContentMigration> getBackupContentListMigrations() {
        return this.backupContentListMigrations;
    }

    @Override // com.magneticchen.daijishou.backup_and_restore.BackupAndRestoreModule
    public List<Integer> getSupportedPolicies() {
        return this.supportedPolicies;
    }

    @Override // com.magneticchen.daijishou.backup_and_restore.BackupAndRestoreModule
    public Object createBackupContentHashMap(HashMap<String, Object> map, Continuation<? super HashMap<String, byte[]>> continuation) {
        HashMap map2 = new HashMap();
        getApplication().getDaijishouWidgetRepository();
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

    /* JADX WARN: Code duplicated, block: B:155:0x0594  */
    /* JADX WARN: Code duplicated, block: B:158:0x059d  */
    /* JADX WARN: Code duplicated, block: B:161:0x05a6  */
    @Override // com.magneticchen.daijishou.backup_and_restore.BackupAndRestoreModule
    public Object restoreFromBackupContentHashMap(HashMap<String, byte[]> map, HashMap<String, Object> map2, int i, Continuation<?> continuation) {
        File file = null;
        File file2 = null;
        File file3 = null;
        File file4 = null;
        HashMap map3;
        DaijishouWidgetRepository daijishouWidgetRepository = null;
        HashMap map4;
        HashMap map5;
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
                Unit unit = Unit.INSTANCE;
            }
            byte[] bArr3 = map.get("widgetDatabaseWalFile");
            if (bArr3 != null) {
                Intrinsics.checkNotNull(bArr3);
                FilesKt.writeBytes(file6, bArr3);
                Unit unit2 = Unit.INSTANCE;
            }
            byte[] bArr4 = map.get("widgetDatabaseBkbFile");
            if (bArr4 != null) {
                Intrinsics.checkNotNull(bArr4);
                FilesKt.writeBytes(file7, bArr4);
                Unit unit3 = Unit.INSTANCE;
            }
            WidgetDatabase companion = WidgetDatabase.INSTANCE.getInstance(getApplication(), "WidgetDatabaseRestore.db");
            getLogger().debug(this, "Acquired restored widget database.\nName: WidgetDatabaseRestore.db\nPath: " + databasePath.getAbsolutePath() + "\nObject: " + companion + "\nWidgets counts: " + companion.widgetInstanceDAO().countAllStatically() + "\n");
            DaijishouWidgetRepository daijishouWidgetRepository2 = getApplication().getDaijishouWidgetRepository();
            DaijishouWidgetRepository daijishouWidgetRepository3 = new DaijishouWidgetRepository(getApplication(), "WidgetDatabaseRestore.db");
            try {
                Object obj = map2.get("playerIdMigration");
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.util.HashMap<kotlin.Long, kotlin.Long>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.Long, kotlin.Long> }");
                Object obj2 = map2.get("platformIdMigration");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type java.util.HashMap<kotlin.Long, kotlin.Long>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.Long, kotlin.Long> }");
                Object obj3 = map2.get("playableItemIdMigration");
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type java.util.HashMap<kotlin.Long, kotlin.Long>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.Long, kotlin.Long> }");
                HashMap map6 = (HashMap) obj3;
                Object obj4 = map2.get("eventIdMigration");
                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type java.util.HashMap<kotlin.Long, kotlin.Long>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.Long, kotlin.Long> }");
                daijishouWidgetRepository2.clearAll();
                HashMap map7 = new HashMap();
                HashMap map8 = new HashMap();
                HashMap map9 = new HashMap();
                map7.put(WidgetId.RSS.getId(), map8);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (RSSWidgetInstanceEntity rSSWidgetInstanceEntity : daijishouWidgetRepository3.getAllRSSWidgetInstancesStatically()) {
                    try {
                        arrayList.add(rSSWidgetInstanceEntity.copyAndResetDatabaseAndDeviceDependentValues());
                        arrayList2.add(Boxing.boxLong(rSSWidgetInstanceEntity.getId()));
                        file = databasePath;
                        try {
                            getLogger().debug(this, String.valueOf(rSSWidgetInstanceEntity));
                            if (arrayList.size() >= BATCH_SIZE) {
                                restoreFromBackupContentHashMap$lambda$15$digestRSSWidgetInstances(daijishouWidgetRepository2, arrayList, arrayList2, map8);
                            }
                            file2 = file5;
                        } catch (Exception e) {
                            e = e;
                            try {
                                file2 = file5;
                                try {
                                    getLogger().error(this, ExceptionsKt.stackTraceToString(e));
                                    map9.put(Boxing.boxLong(rSSWidgetInstanceEntity.getId()), e);
                                } catch (Exception e2) {
                                    e = e2;
                                    file4 = file6;
                                    file3 = file7;
                                    getLogger().error(this, ExceptionsKt.stackTraceToString(e));
                                    WidgetDatabase.INSTANCE.closeInstance("WidgetDatabaseRestore.db");
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
                                    BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new WidgetBackupAndRestoreModule$restoreFromBackupContentHashMap$2$9(this, null), 3, null);
                                    return Unit.INSTANCE;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                file2 = file5;
                                file4 = file6;
                                file3 = file7;
                                getLogger().error(this, ExceptionsKt.stackTraceToString(e));
                                WidgetDatabase.INSTANCE.closeInstance("WidgetDatabaseRestore.db");
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
                                BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new WidgetBackupAndRestoreModule$restoreFromBackupContentHashMap$2$9(this, null), 3, null);
                                return Unit.INSTANCE;
                            }
                        }
                    } catch (Exception e4) {
                        Exception e = null;
                        e = e4;
                        file = databasePath;
                    }
                    databasePath = file;
                    file5 = file2;
                }
                file = databasePath;
                file2 = file5;
                restoreFromBackupContentHashMap$lambda$15$digestRSSWidgetInstances(daijishouWidgetRepository2, arrayList, arrayList2, map8);
                HashMap map10 = new HashMap();
                HashMap map11 = new HashMap();
                map7.put(WidgetId.IMAGE_BLOCK.getId(), map10);
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                for (ImageBlockWidgetInstanceEntity imageBlockWidgetInstanceEntity : daijishouWidgetRepository3.getAllImageBlockWidgetInstancesStatically()) {
                    try {
                        ImageBlockWidgetInstanceEntity imageBlockWidgetInstanceEntityCopyAndResetDatabaseAndDeviceDependentValues = imageBlockWidgetInstanceEntity.copyAndResetDatabaseAndDeviceDependentValues();
                        if (imageBlockWidgetInstanceEntityCopyAndResetDatabaseAndDeviceDependentValues.getImagePath() != null) {
                            map5 = map11;
                            try {
                                String imagePath = imageBlockWidgetInstanceEntity.getImagePath();
                                Intrinsics.checkNotNull(imagePath);
                                if (new File(imagePath).exists()) {
                                    imageBlockWidgetInstanceEntityCopyAndResetDatabaseAndDeviceDependentValues.getImagePath();
                                }
                            } catch (Exception e5) {
                                Exception e = e5;
                                getLogger().error(this, ExceptionsKt.stackTraceToString(e));
                                map5.put(Boxing.boxLong(imageBlockWidgetInstanceEntity.getId()), e);
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
                            map5 = map11;
                        }
                        arrayList3.add(imageBlockWidgetInstanceEntityCopyAndResetDatabaseAndDeviceDependentValues);
                        arrayList4.add(Boxing.boxLong(imageBlockWidgetInstanceEntity.getId()));
                        getLogger().debug(this, String.valueOf(imageBlockWidgetInstanceEntity));
                        if (arrayList3.size() >= BATCH_SIZE) {
                            restoreFromBackupContentHashMap$lambda$15$digestImageBlockWidgetInstances(daijishouWidgetRepository2, arrayList3, arrayList4, map10);
                        }
                    } catch (Exception e6) {
                        Exception e = e6;
                        map5 = map11;
                    }
                    map11 = map5;
                }
                restoreFromBackupContentHashMap$lambda$15$digestImageBlockWidgetInstances(daijishouWidgetRepository2, arrayList3, arrayList4, map10);
                HashMap map12 = new HashMap();
                HashMap map13 = new HashMap();
                map7.put(WidgetId.PIN_AND_PLAY.getId(), map12);
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                for (PinAndPlayWidgetInstanceEntity pinAndPlayWidgetInstanceEntity : daijishouWidgetRepository3.getAllPinAndPlayWidgetInstancesStatically()) {
                    try {
                        PinAndPlayWidgetInstanceEntity pinAndPlayWidgetInstanceEntityCopyAndResetDatabaseAndDeviceDependentValues = pinAndPlayWidgetInstanceEntity.copyAndResetDatabaseAndDeviceDependentValues();
                        if (pinAndPlayWidgetInstanceEntityCopyAndResetDatabaseAndDeviceDependentValues.getAlternativeImagePath() != null) {
                            map4 = map13;
                            try {
                                String alternativeImagePath = pinAndPlayWidgetInstanceEntity.getAlternativeImagePath();
                                Intrinsics.checkNotNull(alternativeImagePath);
                                if (new File(alternativeImagePath).exists()) {
                                    pinAndPlayWidgetInstanceEntityCopyAndResetDatabaseAndDeviceDependentValues.getAlternativeImagePath();
                                }
                            } catch (Exception e7) {
                                Exception e = e7;
                                getLogger().error(this, ExceptionsKt.stackTraceToString(e));
                                map4.put(Boxing.boxLong(pinAndPlayWidgetInstanceEntity.getId()), e);
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
                            map4 = map13;
                        }
                        Object obj5 = map6.get(pinAndPlayWidgetInstanceEntity.getPlayableItemId());
                        Intrinsics.checkNotNull(obj5);
                        pinAndPlayWidgetInstanceEntityCopyAndResetDatabaseAndDeviceDependentValues.setPlayableItemId((Long) obj5);
                        arrayList5.add(pinAndPlayWidgetInstanceEntityCopyAndResetDatabaseAndDeviceDependentValues);
                        arrayList6.add(Boxing.boxLong(pinAndPlayWidgetInstanceEntity.getId()));
                        getLogger().debug(this, String.valueOf(pinAndPlayWidgetInstanceEntity));
                        if (arrayList5.size() >= BATCH_SIZE) {
                            restoreFromBackupContentHashMap$lambda$15$digestPinAndPlayWidgetInstances(daijishouWidgetRepository2, arrayList5, arrayList6, map12);
                        }
                    } catch (Exception e8) {
                        Exception e = e8;
                        map4 = map13;
                    }
                    map13 = map4;
                }
                restoreFromBackupContentHashMap$lambda$15$digestPinAndPlayWidgetInstances(daijishouWidgetRepository2, arrayList5, arrayList6, map12);
                HashMap map14 = new HashMap();
                HashMap map15 = new HashMap();
                map7.put(WidgetId.APP_SHORTCUT.getId(), map14);
                ArrayList arrayList7 = new ArrayList();
                ArrayList arrayList8 = new ArrayList();
                for (AppShortcutWidgetInstanceEntity appShortcutWidgetInstanceEntity : daijishouWidgetRepository3.getAllAppShortcutWidgetInstancesStatically()) {
                    try {
                        arrayList7.add(appShortcutWidgetInstanceEntity.copyAndResetDatabaseAndDeviceDependentValues());
                        arrayList8.add(Boxing.boxLong(appShortcutWidgetInstanceEntity.getId()));
                        getLogger().debug(this, String.valueOf(appShortcutWidgetInstanceEntity));
                        if (arrayList7.size() >= BATCH_SIZE) {
                            restoreFromBackupContentHashMap$lambda$15$digestAppShortcutWidgetInstances(daijishouWidgetRepository2, arrayList7, arrayList8, map14);
                        }
                    } catch (Exception e9) {
                        getLogger().error(this, ExceptionsKt.stackTraceToString(e9));
                        map15.put(Boxing.boxLong(appShortcutWidgetInstanceEntity.getId()), e9);
                    }
                }
                restoreFromBackupContentHashMap$lambda$15$digestAppShortcutWidgetInstances(daijishouWidgetRepository2, arrayList7, arrayList8, map14);
                HashMap map16 = new HashMap();
                HashMap map17 = new HashMap();
                ArrayList arrayList9 = new ArrayList();
                ArrayList arrayList10 = new ArrayList();
                getLogger().debug(this, "allWidgetWidgetInstanceIdMigrations: " + map7);
                Iterator it = daijishouWidgetRepository3.getAllWidgetInstanceIdsStatically().iterator();
                while (it.hasNext()) {
                    long jLongValue = ((Number) it.next()).longValue();
                    try {
                        WidgetInstanceEntity widgetInstanceByIdStatically = daijishouWidgetRepository3.getWidgetInstanceByIdStatically(jLongValue);
                        Intrinsics.checkNotNull(widgetInstanceByIdStatically);
                        WidgetInstanceEntity widgetInstanceEntityCopyAndResetDatabaseAndDeviceDependentValues = widgetInstanceByIdStatically.copyAndResetDatabaseAndDeviceDependentValues();
                        map3 = map17;
                        try {
                            file4 = file6;
                            try {
                                if (SKIP_WIDGETS_INSTANCE_ID_MIGRATION_WIDGET_IDS.contains(widgetInstanceEntityCopyAndResetDatabaseAndDeviceDependentValues.getWidgetId())) {
                                    map7 = map7;
                                    file3 = file7;
                                    daijishouWidgetRepository = daijishouWidgetRepository3;
                                } else {
                                    HashMap map18 = (HashMap) map7.get(widgetInstanceEntityCopyAndResetDatabaseAndDeviceDependentValues.getWidgetId());
                                    if (map18 != null) {
                                        map7 = map7;
                                        try {
                                            file3 = file7;
                                            try {
                                                daijishouWidgetRepository = daijishouWidgetRepository3;
                                                try {
                                                    getLogger().debug(this, "Migration " + widgetInstanceEntityCopyAndResetDatabaseAndDeviceDependentValues.getWidgetId() + ": " + map18);
                                                    Long l = (Long) map18.get(Boxing.boxLong(widgetInstanceByIdStatically.getWidgetInstanceId()));
                                                    if (l != null) {
                                                        Intrinsics.checkNotNull(l);
                                                        widgetInstanceEntityCopyAndResetDatabaseAndDeviceDependentValues.setWidgetInstanceId(l.longValue());
                                                        Unit unit4 = Unit.INSTANCE;
                                                    }
                                                } catch (Exception e10) {
                                                    Exception e = e10;
                                                    try {
                                                        getLogger().error(this, ExceptionsKt.stackTraceToString(e));
                                                        map3.put(Boxing.boxLong(jLongValue), e);
                                                    } catch (Exception e11) {
                                                        getLogger().error(this, ExceptionsKt.stackTraceToString(e11));
                                                        WidgetDatabase.INSTANCE.closeInstance("WidgetDatabaseRestore.db");
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
                                                        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new WidgetBackupAndRestoreModule$restoreFromBackupContentHashMap$2$9(this, null), 3, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                }
                                            } catch (Exception e12) {
                                                Exception e = e12;
                                                daijishouWidgetRepository = daijishouWidgetRepository3;
                                                getLogger().error(this, ExceptionsKt.stackTraceToString(e));
                                                map3.put(Boxing.boxLong(jLongValue), e);
                                            }
                                        } catch (Exception e13) {
                                            Exception e = e13;
                                            file3 = file7;
                                            daijishouWidgetRepository = daijishouWidgetRepository3;
                                            getLogger().error(this, ExceptionsKt.stackTraceToString(e));
                                            map3.put(Boxing.boxLong(jLongValue), e);
                                            map17 = map3;
                                            map7 = map7;
                                            file6 = file4;
                                            file7 = file3;
                                            daijishouWidgetRepository3 = daijishouWidgetRepository;
                                        }
                                    } else {
                                        map7 = map7;
                                        file3 = file7;
                                        daijishouWidgetRepository = daijishouWidgetRepository3;
                                    }
                                    throw new Exception("Has no migration for:\n" + widgetInstanceByIdStatically);
                                }
                                arrayList9.add(widgetInstanceEntityCopyAndResetDatabaseAndDeviceDependentValues);
                                arrayList10.add(Boxing.boxLong(jLongValue));
                                arrayList10.add(Boxing.boxLong(widgetInstanceByIdStatically.getWidgetInstanceId()));
                                if (arrayList9.size() >= BATCH_SIZE) {
                                    restoreFromBackupContentHashMap$lambda$15$digestWidgetInstances(daijishouWidgetRepository2, arrayList9, this, arrayList10, map16);
                                }
                            } catch (Exception e14) {
                                Exception e = e14;
                                map7 = map7;
                            }
                        } catch (Exception e15) {
                            Exception e = e15;
                            file4 = file6;
                            file3 = file7;
                            daijishouWidgetRepository = daijishouWidgetRepository3;
                            getLogger().error(this, ExceptionsKt.stackTraceToString(e));
                            map3.put(Boxing.boxLong(jLongValue), e);
                            map17 = map3;
                            map7 = map7;
                            file6 = file4;
                            file7 = file3;
                            daijishouWidgetRepository3 = daijishouWidgetRepository;
                        }
                    } catch (Exception e16) {
                        Exception e = e16;
                        map3 = map17;
                    }
                    map17 = map3;
                    map7 = map7;
                    file6 = file4;
                    file7 = file3;
                    daijishouWidgetRepository3 = daijishouWidgetRepository;
                }
                file4 = file6;
                file3 = file7;
                restoreFromBackupContentHashMap$lambda$15$digestWidgetInstances(daijishouWidgetRepository2, arrayList9, this, arrayList10, map16);
            } catch (Exception e17) {
                Exception e = e17;
                file = databasePath;
            }
            WidgetDatabase.INSTANCE.closeInstance("WidgetDatabaseRestore.db");
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
            BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new WidgetBackupAndRestoreModule$restoreFromBackupContentHashMap$2$9(this, null), 3, null);
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
