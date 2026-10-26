package com.magneticchen.daijishou.backup_and_restore.modules.library;

import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.backup_and_restore.BackupAndRestoreModule;
import com.magneticchen.daijishou.daijishou_library_db.DaijishouDatabase;
import com.magneticchen.daijishou.daijishou_library_db.EventEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayerEntity;
import com.magneticchen.daijishou.repositories.DaijishouLibraryRepository;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.eclipse.jgit.lib.BranchConfig;

/* INFO: compiled from: LibraryBackupAndRestoreModule.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001#B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JR\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00180\u0017j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0018`\u00192&\u0010\u001a\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001b`\u0019H\u0096@¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0002Jb\u0010\u001f\u001a\u00020\u001e2\"\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00180\u0017j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0018`\u00192&\u0010\u001a\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001b`\u00192\u0006\u0010!\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\"R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011¨\u0006$"}, d2 = {"Lcom/magneticchen/daijishou/backup_and_restore/modules/library/LibraryBackupAndRestoreModule;", "Lcom/magneticchen/daijishou/backup_and_restore/BackupAndRestoreModule;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "backupContentListMigrations", "", "Lcom/magneticchen/daijishou/backup_and_restore/BackupAndRestoreModule$Companion$BackupContentMigration;", "getBackupContentListMigrations", "()Ljava/util/List;", "id", "", "getId", "()Ljava/lang/String;", "nameStringId", "", "getNameStringId", "()I", "supportedPolicies", "getSupportedPolicies", "version", "getVersion", "createBackupContentHashMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "pipeLineData", "", "(Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensurePlatformWallpapersDirectory", "", "restoreFromBackupContentHashMap", "contentHashMap", "restorePolicy", "(Ljava/util/HashMap;Ljava/util/HashMap;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LibraryBackupAndRestoreModule extends BackupAndRestoreModule {
    private static final int BATCH_SIZE = 128;
    private static final int MEDIA_BACKUP_INTERVAL_MS = 3600000;
    private final List<BackupAndRestoreModule.Companion.BackupContentMigration> backupContentListMigrations;
    private final String id;
    private final int nameStringId;
    private final List<Integer> supportedPolicies;
    private final int version = 0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LibraryBackupAndRestoreModule(DaijishouApplication application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.id = "daijishou.library";
        this.nameStringId = R.string.library_backup_and_restore_name;
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

    private final void ensurePlatformWallpapersDirectory() {
        File file = new File(getApplication().getFilesDir() + "/platform_wallpapers/");
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    @Override // com.magneticchen.daijishou.backup_and_restore.BackupAndRestoreModule
    public Object createBackupContentHashMap(HashMap<String, Object> map, Continuation<? super HashMap<String, byte[]>> continuation) {
        Object obj = map.get("lastBackupTimestamp");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
        ((Long) obj).longValue();
        Object obj2 = map.get("useLightweightBackup");
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
        boolean zBooleanValue = ((Boolean) obj2).booleanValue();
        HashMap map2 = new HashMap();
        DaijishouLibraryRepository daijishouLibraryRepository = getApplication().getDaijishouLibraryRepository();
        File databasePath = getApplication().getDatabasePath(DaijishouDatabase.DB_NAME);
        File file = new File(databasePath.getPath() + "-shm");
        File file2 = new File(databasePath.getPath() + "-wal");
        File file3 = new File(databasePath.getPath() + "-bkp");
        if (databasePath.exists()) {
            Intrinsics.checkNotNull(databasePath);
            map2.put("daijishouDatabaseFile", FilesKt.readBytes(databasePath));
        }
        if (file.exists()) {
            map2.put("daijishouDatabaseShmFile", FilesKt.readBytes(file));
        }
        if (file2.exists()) {
            map2.put("daijishouDatabaseWalFile", FilesKt.readBytes(file2));
        }
        if (file3.exists()) {
            map2.put("daijishouDatabaseBkbFile", FilesKt.readBytes(file3));
        }
        if (!zBooleanValue) {
            Iterator it = daijishouLibraryRepository.getAllPlatformIdsStatically().iterator();
            while (it.hasNext()) {
                long jLongValue = ((Number) it.next()).longValue();
                PlatformEntity platformByIdStatically = daijishouLibraryRepository.getPlatformByIdStatically(jLongValue);
                String wallpaperPath = platformByIdStatically != null ? platformByIdStatically.getWallpaperPath() : null;
                if (wallpaperPath != null) {
                    File file4 = new File(wallpaperPath);
                    map2.put("platformWallpaper" + jLongValue + "-" + FilesKt.getExtension(file4), FilesKt.readBytes(file4));
                }
            }
        }
        return map2;
    }

    /* WARN: Code duplicated, block: B:150:0x05c4  */
    /* WARN: Code duplicated, block: B:153:0x05cd  */
    /* WARN: Code duplicated, block: B:156:0x05d6  */
    /* WARN: Code duplicated, block: B:160:0x05eb  */
    /* WARN: Code duplicated, block: B:163:0x0617  */
    /* WARN: Code duplicated, block: B:167:0x0692 A[Catch: Exception -> 0x06d7, TryCatch #6 {Exception -> 0x06d7, blocks: (B:165:0x0635, B:167:0x0692, B:169:0x06cc, B:170:0x06d0), top: B:193:0x0635 }] */
    /* WARN: Code duplicated, block: B:169:0x06cc A[Catch: Exception -> 0x06d7, TryCatch #6 {Exception -> 0x06d7, blocks: (B:165:0x0635, B:167:0x0692, B:169:0x06cc, B:170:0x06d0), top: B:193:0x0635 }] */
    /* WARN: Code duplicated, block: B:170:0x06d0 A[Catch: Exception -> 0x06d7, TRY_LEAVE, TryCatch #6 {Exception -> 0x06d7, blocks: (B:165:0x0635, B:167:0x0692, B:169:0x06cc, B:170:0x06d0), top: B:193:0x0635 }] */
    /* WARN: Code duplicated, block: B:177:0x07c6 A[RETURN] */
    /* WARN: Code duplicated, block: B:178:0x07c7  */
    /* WARN: Code duplicated, block: B:193:0x0635 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* WARN: Code duplicated, block: B:224:0x06e5 A[SYNTHETIC] */
    /* WARN: Code duplicated, block: B:225:0x06e5 A[SYNTHETIC] */
    /* WARN: Multi-variable type inference failed */
    @Override // com.magneticchen.daijishou.backup_and_restore.BackupAndRestoreModule
    public Object restoreFromBackupContentHashMap(HashMap<String, byte[]> map, HashMap<String, Object> map2, int i, Continuation<?> continuation) {
        byte[] bArr;
        HashMap map3 = new HashMap();
        File file;
        File file2;
        File file3 = null;
        DaijishouLibraryRepository daijishouLibraryRepository;
        Iterator it;
        Object objWithContext;
        long jLongValue;
        long jLongValue2;
        String key;
        byte[] value;
        long j;
        String str;
        String str2;
        File file4;
        PlatformEntity platformByIdStatically;
        long j2;
        EventEntity eventEntity;
        PlayableItemEntity playableItemEntity;
        Iterator it2 = null;
        if (i == 0 && (bArr = map.get("daijishouDatabaseFile")) != null) {
            File databasePath = getApplication().getDatabasePath("DaijishouDatabaseRestore.db");
            File file5 = new File(databasePath.getPath() + "-shm");
            File file6 = new File(databasePath.getPath() + "-wal");
            File file7 = new File(databasePath.getPath() + "-bkp");
            Intrinsics.checkNotNull(databasePath);
            FilesKt.writeBytes(databasePath, bArr);
            byte[] bArr2 = map.get("daijishouDatabaseShmFile");
            if (bArr2 != null) {
                FilesKt.writeBytes(file5, bArr2);
                Unit unit = Unit.INSTANCE;
            }
            byte[] bArr3 = map.get("daijishouDatabaseWalFile");
            if (bArr3 != null) {
                FilesKt.writeBytes(file6, bArr3);
                Unit unit2 = Unit.INSTANCE;
            }
            byte[] bArr4 = map.get("daijishouDatabaseWalFile");
            if (bArr4 != null) {
                FilesKt.writeBytes(file7, bArr4);
                Unit unit3 = Unit.INSTANCE;
            }
            DaijishouDatabase companion = DaijishouDatabase.INSTANCE.getInstance(getApplication(), "DaijishouDatabaseRestore.db");
            getLogger().debug(this, "Acquired restored daijishou database.\nName: DaijishouDatabaseRestore.db\nPath: " + databasePath.getAbsolutePath() + "\nObject: " + companion + "\nPlatforms count: " + companion.platformDAO().countAllStatically() + "\nPlayers count: " + companion.playerDAO().countAllStatically() + "\nPlayable items count: " + companion.playableItemDAO().countAllStatically() + "\nEvents count: " + companion.eventDAO().countAllStatically());
            HashMap map4 = new HashMap();
            HashMap map5 = new HashMap();
            HashMap map6 = new HashMap();
            HashMap map7 = new HashMap();
            HashMap map8 = new HashMap();
            HashMap map9 = new HashMap();
            HashMap map10 = new HashMap();
            HashMap map11 = new HashMap();
            HashMap map12 = new HashMap();
            HashMap map13 = new HashMap();
            DaijishouLibraryRepository daijishouLibraryRepository2 = getApplication().getDaijishouLibraryRepository();
            DaijishouLibraryRepository daijishouLibraryRepository3 = new DaijishouLibraryRepository(getApplication(), "DaijishouDatabaseRestore.db", null, 4, null);
            try {
                daijishouLibraryRepository2.clearAll();
                daijishouLibraryRepository2.removeAllPlayableItemsPreviewMediaAndRelations();
                daijishouLibraryRepository2.removeAllPlatformsPreviewMedia();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (Iterator it3 = daijishouLibraryRepository3.getAllPlayerIdsStatically().iterator(); it3.hasNext(); it3 = it2) {
                    try {
                        file = file5;
                        try {
                            long jLongValue3 = ((Number) it3.next()).longValue();
                            try {
                                PlayerEntity playerByIdStatically = daijishouLibraryRepository3.getPlayerByIdStatically(jLongValue3);
                                Intrinsics.checkNotNull(playerByIdStatically);
                                arrayList.add(playerByIdStatically.copyAndResetDatabaseAndDeviceDependentValues());
                                arrayList2.add(Boxing.boxLong(jLongValue3));
                                it2 = it3;
                                if (arrayList.size() >= 128) {
                                    daijishouLibraryRepository = daijishouLibraryRepository2;
                                    try {
                                        restoreFromBackupContentHashMap$lambda$19$digestPlayers(daijishouLibraryRepository, arrayList, arrayList2, map4);
                                    } catch (Exception e) {
                                        e = e;
                                        try {
                                            getLogger().error(this, ExceptionsKt.stackTraceToString(e));
                                            map9.put(Boxing.boxLong(jLongValue3), e);
                                        } catch (Exception e2) {
                                            e = e2;
                                            map3 = map4;
                                            file2 = file6;
                                            file3 = file7;
                                            getLogger().error(this, ExceptionsKt.stackTraceToString(e));
                                            DaijishouDatabase.INSTANCE.closeInstance("DaijishouDatabaseRestore.db");
                                            databasePath.delete();
                                            if (file.exists()) {
                                                file.delete();
                                            }
                                            if (file2.exists()) {
                                                file2.delete();
                                            }
                                            if (file3.exists()) {
                                                file3.delete();
                                            }
                                            it = map5.entrySet().iterator();
                                            while (it.hasNext()) {
                                                Map.Entry entry = (Map.Entry) it.next();
                                                jLongValue = ((Number) entry.getKey()).longValue();
                                                jLongValue2 = ((Number) entry.getValue()).longValue();
                                                for (Map.Entry<String, byte[]> entry2 : map.entrySet()) {
                                                    key = (String) entry2.getKey();
                                                    value = (byte[]) entry2.getValue();
                                                    Iterator it4 = it;
                                                    if (StringsKt.startsWith$default(key, "platformWallpaper", false, 2, (Object) null)) {
                                                        try {
                                                            String str3 = (String) StringsKt.split$default((CharSequence) key, new String[]{"platformWallpaper"}, false, 0, 6, (Object) null).get(1);
                                                            j = Long.parseLong((String) StringsKt.split$default((CharSequence) str3, new String[]{"-"}, false, 0, 6, (Object) null).get(0));
                                                            str = (String) StringsKt.split$default((CharSequence) str3, new String[]{"-"}, false, 0, 6, (Object) null).get(1);
                                                            if (j == jLongValue) {
                                                                ensurePlatformWallpapersDirectory();
                                                                str2 = getApplication().getFilesDir() + "/platform_wallpapers/" + jLongValue2 + BranchConfig.LOCAL_REPOSITORY + str;
                                                                file4 = new File(str2);
                                                                FilesKt.writeBytes(file4, value);
                                                                platformByIdStatically = daijishouLibraryRepository.getPlatformByIdStatically(jLongValue2);
                                                                if (platformByIdStatically == null) {
                                                                    file4.delete();
                                                                } else {
                                                                    platformByIdStatically.setWallpaperPath(str2);
                                                                    daijishouLibraryRepository.updatePlatform(platformByIdStatically);
                                                                }
                                                            }
                                                        } catch (Exception e3) {
                                                            getLogger().error(this, ExceptionsKt.stackTraceToString(e3));
                                                        }
                                                    }
                                                    it = it4;
                                                }
                                            }
                                            HashMap map14 = map3;
                                            getLogger().debug(this, "Restore finished with below migrations:\n> playerIdMigration(" + map3.size() + "): " + map14 + "\n> platformIdMigration(" + map5.size() + "): " + map5 + "\n> playableItemIdMigration(" + map6.size() + "): " + map6 + "\n> eventIdMigration(" + map7.size() + "): " + map7);
                                            getLogger().debug(this, "Restore exceptions report:\n> playerMigration failed counts: " + map9.size() + "\n> platformMigration failed counts: " + map10.size() + "\n> playableItemMigration failed counts: " + map11.size() + "\n> eventMigration failed counts: " + map12.size());
                                            HashMap<String, Object> map15 = map2;
                                            map15.put("playerIdMigration", map14);
                                            map15.put("platformIdMigration", map5);
                                            map15.put("playableItemIdMigration", map6);
                                            map15.put("eventIdMigration", map7);
                                            objWithContext = BuildersKt.withContext(Dispatchers.getMain(), new LibraryBackupAndRestoreModule$restoreFromBackupContentHashMap$2$11(this, null), continuation);
                                            if (objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                return objWithContext;
                                            }
                                            Unit unit4 = Unit.INSTANCE;
                                            return Unit.INSTANCE;
                                        }
                                    }
                                } else {
                                    daijishouLibraryRepository = daijishouLibraryRepository2;
                                }
                            } catch (Exception e4) {
                                Exception e = null;
                                e = e4;
                                it2 = it3;
                                daijishouLibraryRepository = daijishouLibraryRepository2;
                            }
                            daijishouLibraryRepository2 = daijishouLibraryRepository;
                            file5 = file;
                        } catch (Exception e5) {
                            Exception e = null;
                            e = e5;
                            daijishouLibraryRepository = daijishouLibraryRepository2;
                            map3 = map4;
                            file2 = file6;
                            file3 = file7;
                            getLogger().error(this, ExceptionsKt.stackTraceToString(e));
                            DaijishouDatabase.INSTANCE.closeInstance("DaijishouDatabaseRestore.db");
                            databasePath.delete();
                            if (file.exists()) {
                                file.delete();
                            }
                            if (file2.exists()) {
                                file2.delete();
                            }
                            if (file3.exists()) {
                                file3.delete();
                            }
                            it = map5.entrySet().iterator();
                            while (it.hasNext()) {
                                Map.Entry entry3 = (Map.Entry) it.next();
                                jLongValue = ((Number) entry3.getKey()).longValue();
                                jLongValue2 = ((Number) entry3.getValue()).longValue();
                                Iterator r10 = map.entrySet().iterator();
                                while (r10.hasNext()) {
                                    Map.Entry entry2 = (Map.Entry) r10.next();
                                    key = (String) entry2.getKey();
                                    value = (byte[]) entry2.getValue();
                                    Iterator it5 = it;
                                    if (StringsKt.startsWith$default(key, "platformWallpaper", false, 2, (Object) null)) {
                                        String str4 = (String) StringsKt.split$default((CharSequence) key, new String[]{"platformWallpaper"}, false, 0, 6, (Object) null).get(1);
                                        j = Long.parseLong((String) StringsKt.split$default((CharSequence) str4, new String[]{"-"}, false, 0, 6, (Object) null).get(0));
                                        str = (String) StringsKt.split$default((CharSequence) str4, new String[]{"-"}, false, 0, 6, (Object) null).get(1);
                                        if (j == jLongValue) {
                                            ensurePlatformWallpapersDirectory();
                                            str2 = getApplication().getFilesDir() + "/platform_wallpapers/" + jLongValue2 + BranchConfig.LOCAL_REPOSITORY + str;
                                            file4 = new File(str2);
                                            FilesKt.writeBytes(file4, value);
                                            platformByIdStatically = daijishouLibraryRepository.getPlatformByIdStatically(jLongValue2);
                                            if (platformByIdStatically == null) {
                                                file4.delete();
                                            } else {
                                                platformByIdStatically.setWallpaperPath(str2);
                                                daijishouLibraryRepository.updatePlatform(platformByIdStatically);
                                            }
                                        }
                                    }
                                    it = it5;
                                }
                            }
                            HashMap map16 = map3;
                            getLogger().debug(this, "Restore finished with below migrations:\n> playerIdMigration(" + map3.size() + "): " + map16 + "\n> platformIdMigration(" + map5.size() + "): " + map5 + "\n> playableItemIdMigration(" + map6.size() + "): " + map6 + "\n> eventIdMigration(" + map7.size() + "): " + map7);
                            getLogger().debug(this, "Restore exceptions report:\n> playerMigration failed counts: " + map9.size() + "\n> platformMigration failed counts: " + map10.size() + "\n> playableItemMigration failed counts: " + map11.size() + "\n> eventMigration failed counts: " + map12.size());
                            HashMap<String, Object> map17 = map2;
                            map17.put("playerIdMigration", map16);
                            map17.put("platformIdMigration", map5);
                            map17.put("playableItemIdMigration", map6);
                            map17.put("eventIdMigration", map7);
                            objWithContext = BuildersKt.withContext(Dispatchers.getMain(), new LibraryBackupAndRestoreModule$restoreFromBackupContentHashMap$2$11(this, null), continuation);
                            if (objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                return objWithContext;
                            }
                            Unit unit5 = Unit.INSTANCE;
                            return Unit.INSTANCE;
                        }
                    } catch (Exception e6) {
                        Exception e = null;
                        e = e6;
                        file = file5;
                    }
                }
                file = file5;
                daijishouLibraryRepository = daijishouLibraryRepository2;
                restoreFromBackupContentHashMap$lambda$19$digestPlayers(daijishouLibraryRepository, arrayList, arrayList2, map4);
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                Iterator it6 = daijishouLibraryRepository3.getAllPlatformIdsStatically().iterator();
                while (it6.hasNext()) {
                    Iterator it7 = it6;
                    long jLongValue4 = ((Number) it6.next()).longValue();
                    try {
                        PlatformEntity platformByIdStatically2 = daijishouLibraryRepository3.getPlatformByIdStatically(jLongValue4);
                        Intrinsics.checkNotNull(platformByIdStatically2);
                        PlatformEntity platformEntityCopyAndResetDatabaseAndDeviceDependentValues = platformByIdStatically2.copyAndResetDatabaseAndDeviceDependentValues();
                        file2 = file6;
                        try {
                            Object obj = map4.get(Boxing.boxLong(platformByIdStatically2.getDefaultPlayerId()));
                            Intrinsics.checkNotNull(obj);
                            file3 = file7;
                            try {
                                platformEntityCopyAndResetDatabaseAndDeviceDependentValues.setDefaultPlayerId(((Number) obj).longValue());
                                Iterator it8 = platformByIdStatically2.getPlayerIdList().iterator();
                                while (it8.hasNext()) {
                                    long jLongValue5 = ((Number) it8.next()).longValue();
                                    List<Long> playerIdList = platformEntityCopyAndResetDatabaseAndDeviceDependentValues.getPlayerIdList();
                                    Iterator it9 = it8;
                                    Object obj2 = map4.get(Boxing.boxLong(jLongValue5));
                                    Intrinsics.checkNotNull(obj2);
                                    playerIdList.add(((Number) obj2).longValue());
                                    it8 = it9;
                                }
                                arrayList3.add(platformEntityCopyAndResetDatabaseAndDeviceDependentValues);
                                arrayList4.add(Boxing.boxLong(jLongValue4));
                                if (arrayList3.size() >= 128) {
                                    restoreFromBackupContentHashMap$lambda$19$digestPlatforms(daijishouLibraryRepository, arrayList3, arrayList4, map5);
                                }
                                map3 = map4;
                            } catch (Exception e7) {
                                Exception e = null;
                                e = e7;
                                try {
                                    map3 = map4;
                                    try {
                                        getLogger().error(this, "Platform: " + daijishouLibraryRepository3.getPlatformByIdStatically(jLongValue4) + "\nError: " + ExceptionsKt.stackTraceToString(e));
                                        getLogger().error(this, ExceptionsKt.stackTraceToString(e));
                                        map10.put(Boxing.boxLong(jLongValue4), e);
                                    } catch (Exception e8) {
                                        e = e8;
                                        getLogger().error(this, ExceptionsKt.stackTraceToString(e));
                                        DaijishouDatabase.INSTANCE.closeInstance("DaijishouDatabaseRestore.db");
                                        databasePath.delete();
                                        if (file.exists()) {
                                            file.delete();
                                        }
                                        if (file2.exists()) {
                                            file2.delete();
                                        }
                                        if (file3.exists()) {
                                            file3.delete();
                                        }
                                        it = map5.entrySet().iterator();
                                        while (it.hasNext()) {
                                            Map.Entry entry4 = (Map.Entry) it.next();
                                            jLongValue = ((Number) entry4.getKey()).longValue();
                                            jLongValue2 = ((Number) entry4.getValue()).longValue();
                                            Iterator r10 = map.entrySet().iterator();
                                            while (r10.hasNext()) {
                                                Map.Entry entry2 = (Map.Entry) r10.next();
                                                key = (String) entry2.getKey();
                                                value = (byte[]) entry2.getValue();
                                                Iterator it10 = it;
                                                if (StringsKt.startsWith$default(key, "platformWallpaper", false, 2, (Object) null)) {
                                                    String str5 = (String) StringsKt.split$default((CharSequence) key, new String[]{"platformWallpaper"}, false, 0, 6, (Object) null).get(1);
                                                    j = Long.parseLong((String) StringsKt.split$default((CharSequence) str5, new String[]{"-"}, false, 0, 6, (Object) null).get(0));
                                                    str = (String) StringsKt.split$default((CharSequence) str5, new String[]{"-"}, false, 0, 6, (Object) null).get(1);
                                                    if (j == jLongValue) {
                                                        ensurePlatformWallpapersDirectory();
                                                        str2 = getApplication().getFilesDir() + "/platform_wallpapers/" + jLongValue2 + BranchConfig.LOCAL_REPOSITORY + str;
                                                        file4 = new File(str2);
                                                        FilesKt.writeBytes(file4, value);
                                                        platformByIdStatically = daijishouLibraryRepository.getPlatformByIdStatically(jLongValue2);
                                                        if (platformByIdStatically == null) {
                                                            file4.delete();
                                                        } else {
                                                            platformByIdStatically.setWallpaperPath(str2);
                                                            daijishouLibraryRepository.updatePlatform(platformByIdStatically);
                                                        }
                                                    }
                                                }
                                                it = it10;
                                            }
                                        }
                                        HashMap map18 = map3;
                                        getLogger().debug(this, "Restore finished with below migrations:\n> playerIdMigration(" + map3.size() + "): " + map18 + "\n> platformIdMigration(" + map5.size() + "): " + map5 + "\n> playableItemIdMigration(" + map6.size() + "): " + map6 + "\n> eventIdMigration(" + map7.size() + "): " + map7);
                                        getLogger().debug(this, "Restore exceptions report:\n> playerMigration failed counts: " + map9.size() + "\n> platformMigration failed counts: " + map10.size() + "\n> playableItemMigration failed counts: " + map11.size() + "\n> eventMigration failed counts: " + map12.size());
                                        HashMap<String, Object> map19 = map2;
                                        map19.put("playerIdMigration", map18);
                                        map19.put("platformIdMigration", map5);
                                        map19.put("playableItemIdMigration", map6);
                                        map19.put("eventIdMigration", map7);
                                        objWithContext = BuildersKt.withContext(Dispatchers.getMain(), new LibraryBackupAndRestoreModule$restoreFromBackupContentHashMap$2$11(this, null), continuation);
                                        if (objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                            return objWithContext;
                                        }
                                        Unit unit6 = Unit.INSTANCE;
                                        return Unit.INSTANCE;
                                    }
                                } catch (Exception e9) {
                                    e = e9;
                                    map3 = map4;
                                    getLogger().error(this, ExceptionsKt.stackTraceToString(e));
                                    DaijishouDatabase.INSTANCE.closeInstance("DaijishouDatabaseRestore.db");
                                    databasePath.delete();
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    if (file2.exists()) {
                                        file2.delete();
                                    }
                                    if (file3.exists()) {
                                        file3.delete();
                                    }
                                    it = map5.entrySet().iterator();
                                    while (it.hasNext()) {
                                        Map.Entry entry5 = (Map.Entry) it.next();
                                        jLongValue = ((Number) entry5.getKey()).longValue();
                                        jLongValue2 = ((Number) entry5.getValue()).longValue();
                                        Iterator r10 = map.entrySet().iterator();
                                        while (r10.hasNext()) {
                                            Map.Entry entry2 = (Map.Entry) r10.next();
                                            key = (String) entry2.getKey();
                                            value = (byte[]) entry2.getValue();
                                            Iterator it11 = it;
                                            if (StringsKt.startsWith$default(key, "platformWallpaper", false, 2, (Object) null)) {
                                                String str6 = (String) StringsKt.split$default((CharSequence) key, new String[]{"platformWallpaper"}, false, 0, 6, (Object) null).get(1);
                                                j = Long.parseLong((String) StringsKt.split$default((CharSequence) str6, new String[]{"-"}, false, 0, 6, (Object) null).get(0));
                                                str = (String) StringsKt.split$default((CharSequence) str6, new String[]{"-"}, false, 0, 6, (Object) null).get(1);
                                                if (j == jLongValue) {
                                                    ensurePlatformWallpapersDirectory();
                                                    str2 = getApplication().getFilesDir() + "/platform_wallpapers/" + jLongValue2 + BranchConfig.LOCAL_REPOSITORY + str;
                                                    file4 = new File(str2);
                                                    FilesKt.writeBytes(file4, value);
                                                    platformByIdStatically = daijishouLibraryRepository.getPlatformByIdStatically(jLongValue2);
                                                    if (platformByIdStatically == null) {
                                                        file4.delete();
                                                    } else {
                                                        platformByIdStatically.setWallpaperPath(str2);
                                                        daijishouLibraryRepository.updatePlatform(platformByIdStatically);
                                                    }
                                                }
                                            }
                                            it = it11;
                                        }
                                    }
                                    HashMap map110 = map3;
                                    getLogger().debug(this, "Restore finished with below migrations:\n> playerIdMigration(" + map3.size() + "): " + map110 + "\n> platformIdMigration(" + map5.size() + "): " + map5 + "\n> playableItemIdMigration(" + map6.size() + "): " + map6 + "\n> eventIdMigration(" + map7.size() + "): " + map7);
                                    getLogger().debug(this, "Restore exceptions report:\n> playerMigration failed counts: " + map9.size() + "\n> platformMigration failed counts: " + map10.size() + "\n> playableItemMigration failed counts: " + map11.size() + "\n> eventMigration failed counts: " + map12.size());
                                    HashMap<String, Object> map111 = map2;
                                    map111.put("playerIdMigration", map110);
                                    map111.put("platformIdMigration", map5);
                                    map111.put("playableItemIdMigration", map6);
                                    map111.put("eventIdMigration", map7);
                                    objWithContext = BuildersKt.withContext(Dispatchers.getMain(), new LibraryBackupAndRestoreModule$restoreFromBackupContentHashMap$2$11(this, null), continuation);
                                    if (objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                        return objWithContext;
                                    }
                                    Unit unit7 = Unit.INSTANCE;
                                    return Unit.INSTANCE;
                                }
                            }
                        } catch (Exception e10) {
                            Exception e = null;
                            e = e10;
                            file3 = file7;
                            map3 = map4;
                            getLogger().error(this, "Platform: " + daijishouLibraryRepository3.getPlatformByIdStatically(jLongValue4) + "\nError: " + ExceptionsKt.stackTraceToString(e));
                            getLogger().error(this, ExceptionsKt.stackTraceToString(e));
                            map10.put(Boxing.boxLong(jLongValue4), e);
                            it6 = it7;
                            map4 = map3;
                            file7 = file3;
                            file6 = file2;
                        }
                    } catch (Exception e11) {
                        Exception e = null;
                        e = e11;
                        file2 = file6;
                    }
                    it6 = it7;
                    map4 = map3;
                    file7 = file3;
                    file6 = file2;
                }
                map3 = map4;
                file2 = file6;
                file3 = file7;
                restoreFromBackupContentHashMap$lambda$19$digestPlatforms(daijishouLibraryRepository, arrayList3, arrayList4, map5);
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                Iterator it12 = daijishouLibraryRepository3.getAllPlayableItemIdsStatically().iterator();
                while (it12.hasNext()) {
                    long jLongValue6 = ((Number) it12.next()).longValue();
                    try {
                        PlayableItemEntity playableItemByIdStatically = daijishouLibraryRepository3.getPlayableItemByIdStatically(jLongValue6);
                        Intrinsics.checkNotNull(playableItemByIdStatically);
                        PlayableItemEntity playableItemEntityCopyAndResetDatabaseAndDeviceDependentValues = playableItemByIdStatically.copyAndResetDatabaseAndDeviceDependentValues();
                        if (playableItemByIdStatically.getAttachedPlatformId() != null) {
                            playableItemEntity = playableItemByIdStatically;
                            Object obj3 = map5.get(playableItemEntity.getAttachedPlatformId());
                            Intrinsics.checkNotNull(obj3);
                            playableItemEntityCopyAndResetDatabaseAndDeviceDependentValues.setAttachedPlatformId((Long) obj3);
                        } else {
                            playableItemEntity = playableItemByIdStatically;
                        }
                        if (playableItemEntity.getCustomPlayerId() != null) {
                            Object obj4 = map3.get(playableItemEntity.getCustomPlayerId());
                            Intrinsics.checkNotNull(obj4);
                            playableItemEntityCopyAndResetDatabaseAndDeviceDependentValues.setCustomPlayerId((Long) obj4);
                        }
                        arrayList5.add(playableItemEntityCopyAndResetDatabaseAndDeviceDependentValues);
                        arrayList6.add(Boxing.boxLong(jLongValue6));
                        if (arrayList5.size() >= 128) {
                            restoreFromBackupContentHashMap$lambda$19$digestPlayableItems(daijishouLibraryRepository, arrayList5, arrayList6, map6);
                        }
                    } catch (Exception e12) {
                        getLogger().error(this, ExceptionsKt.stackTraceToString(e12));
                        map11.put(Boxing.boxLong(jLongValue6), e12);
                    }
                }
                restoreFromBackupContentHashMap$lambda$19$digestPlayableItems(daijishouLibraryRepository, arrayList5, arrayList6, map6);
                Iterator it13 = daijishouLibraryRepository3.getAllPlayableItemIdsStatically().iterator();
                while (it13.hasNext()) {
                    long jLongValue7 = ((Number) it13.next()).longValue();
                    try {
                        PlayableItemEntity playableItemByIdStatically2 = daijishouLibraryRepository3.getPlayableItemByIdStatically(jLongValue7);
                        Intrinsics.checkNotNull(playableItemByIdStatically2);
                        Object obj5 = map6.get(Boxing.boxLong(playableItemByIdStatically2.getId()));
                        Intrinsics.checkNotNull(obj5);
                        PlayableItemEntity playableItemByIdStatically3 = daijishouLibraryRepository.getPlayableItemByIdStatically(((Number) obj5).longValue());
                        Intrinsics.checkNotNull(playableItemByIdStatically3);
                        playableItemByIdStatically3.setInSingletonDisjointSet(playableItemByIdStatically2.isInSingletonDisjointSet());
                        playableItemByIdStatically3.setUseDisjointSetPrimaryPlayableItem(playableItemByIdStatically2.getUseDisjointSetPrimaryPlayableItem());
                        if (playableItemByIdStatically2.getDisjointSetPrimaryPlayableItemId() != null) {
                            Object obj6 = map6.get(playableItemByIdStatically2.getDisjointSetPrimaryPlayableItemId());
                            Intrinsics.checkNotNull(obj6);
                            playableItemByIdStatically3.setDisjointSetPrimaryPlayableItemId((Long) obj6);
                        }
                        arrayList5.add(playableItemByIdStatically3);
                        arrayList6.add(Boxing.boxLong(jLongValue7));
                        if (arrayList5.size() >= 128) {
                            restoreFromBackupContentHashMap$lambda$19$digestPlayableItems(daijishouLibraryRepository, arrayList5, arrayList6, map6);
                        }
                    } catch (Exception e13) {
                        getLogger().error(this, ExceptionsKt.stackTraceToString(e13));
                        map11.put(Boxing.boxLong(jLongValue7), e13);
                    }
                }
                restoreFromBackupContentHashMap$lambda$19$digestPlayableItems(daijishouLibraryRepository, arrayList5, arrayList6, map6);
                ArrayList arrayList7 = new ArrayList();
                ArrayList arrayList8 = new ArrayList();
                Iterator it14 = daijishouLibraryRepository3.getAllEventIdsStatically().iterator();
                while (it14.hasNext()) {
                    long jLongValue8 = ((Number) it14.next()).longValue();
                    try {
                        EventEntity eventByIdStatically = daijishouLibraryRepository3.getEventByIdStatically(jLongValue8);
                        Intrinsics.checkNotNull(eventByIdStatically);
                        EventEntity eventEntityCopyAndResetDatabaseAndDeviceDependentValues = eventByIdStatically.copyAndResetDatabaseAndDeviceDependentValues();
                        if (eventByIdStatically.getPlayableItemId() != null) {
                            eventEntity = eventByIdStatically;
                            Object obj7 = map6.get(eventEntity.getPlayableItemId());
                            Intrinsics.checkNotNull(obj7);
                            eventEntityCopyAndResetDatabaseAndDeviceDependentValues.setPlayableItemId((Long) obj7);
                        } else {
                            eventEntity = eventByIdStatically;
                        }
                        if (eventEntity.getPlatformId() != null) {
                            Object obj8 = map5.get(eventEntity.getPlatformId());
                            Intrinsics.checkNotNull(obj8);
                            eventEntityCopyAndResetDatabaseAndDeviceDependentValues.setPlatformId((Long) obj8);
                        }
                        if (eventEntity.getPlayerId() != null) {
                            Object obj9 = map3.get(eventEntity.getPlayerId());
                            Intrinsics.checkNotNull(obj9);
                            eventEntityCopyAndResetDatabaseAndDeviceDependentValues.setPlayerId((Long) obj9);
                        }
                        arrayList7.add(eventEntityCopyAndResetDatabaseAndDeviceDependentValues);
                        arrayList8.add(Boxing.boxLong(jLongValue8));
                        if (arrayList7.size() >= 128) {
                            restoreFromBackupContentHashMap$lambda$19$digestEvents(daijishouLibraryRepository, arrayList7, arrayList8, map7);
                        }
                    } catch (Exception e14) {
                        getLogger().error(this, ExceptionsKt.stackTraceToString(e14));
                        map12.put(Boxing.boxLong(jLongValue8), e14);
                    }
                }
                restoreFromBackupContentHashMap$lambda$19$digestEvents(daijishouLibraryRepository, arrayList7, arrayList8, map7);
                ArrayList arrayList9 = new ArrayList();
                ArrayList arrayList10 = new ArrayList();
                Iterator it15 = daijishouLibraryRepository3.getAllPlayableItemToGenrePairIdsStatically().iterator();
                while (it15.hasNext()) {
                    long jLongValue9 = ((Number) it15.next()).longValue();
                    try {
                        PlayableItemToGenrePairEntity playableItemToGenrePairByIdStatically = daijishouLibraryRepository3.getPlayableItemToGenrePairByIdStatically(jLongValue9);
                        Intrinsics.checkNotNull(playableItemToGenrePairByIdStatically);
                        PlayableItemToGenrePairEntity playableItemToGenrePairEntityCopyAndResetDatabaseAndDeviceDependentValues = playableItemToGenrePairByIdStatically.copyAndResetDatabaseAndDeviceDependentValues();
                        Object obj10 = map6.get(Boxing.boxLong(playableItemToGenrePairByIdStatically.getPlayableItemId()));
                        Intrinsics.checkNotNull(obj10);
                        j2 = jLongValue9;
                        try {
                            playableItemToGenrePairEntityCopyAndResetDatabaseAndDeviceDependentValues.setPlayableItemId(((Number) obj10).longValue());
                            arrayList9.add(playableItemToGenrePairEntityCopyAndResetDatabaseAndDeviceDependentValues);
                            arrayList10.add(Boxing.boxLong(j2));
                            if (arrayList9.size() >= 128) {
                                try {
                                    restoreFromBackupContentHashMap$lambda$19$digestGenres(daijishouLibraryRepository, arrayList9, arrayList10, map8);
                                } catch (Exception e15) {
                                    Exception e = null;
                                    e = e15;
                                    getLogger().error(this, ExceptionsKt.stackTraceToString(e));
                                    map13.put(Boxing.boxLong(j2), e);
                                }
                            }
                        } catch (Exception e16) {
                            Exception e = null;
                            e = e16;
                            getLogger().error(this, ExceptionsKt.stackTraceToString(e));
                            map13.put(Boxing.boxLong(j2), e);
                        }
                    } catch (Exception e17) {
                        Exception e = null;
                        e = e17;
                        j2 = jLongValue9;
                    }
                }
                restoreFromBackupContentHashMap$lambda$19$digestGenres(daijishouLibraryRepository, arrayList9, arrayList10, map8);
            } catch (Exception e18) {
                Exception e = null;
                e = e18;
                map3 = map4;
                file = file5;
                file2 = file6;
                file3 = file7;
                daijishouLibraryRepository = daijishouLibraryRepository2;
            }
            DaijishouDatabase.INSTANCE.closeInstance("DaijishouDatabaseRestore.db");
            databasePath.delete();
            if (file.exists()) {
                file.delete();
            }
            if (file2.exists()) {
                file2.delete();
            }
            if (file3.exists()) {
                file3.delete();
            }
            it = map5.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry6 = (Map.Entry) it.next();
                jLongValue = ((Number) entry6.getKey()).longValue();
                jLongValue2 = ((Number) entry6.getValue()).longValue();
                Iterator r10 = map.entrySet().iterator();
                while (r10.hasNext()) {
                    Map.Entry entry2 = (Map.Entry) r10.next();
                    key = (String) entry2.getKey();
                    value = (byte[]) entry2.getValue();
                    Iterator it16 = it;
                    if (StringsKt.startsWith$default(key, "platformWallpaper", false, 2, (Object) null)) {
                        String str7 = (String) StringsKt.split$default((CharSequence) key, new String[]{"platformWallpaper"}, false, 0, 6, (Object) null).get(1);
                        j = Long.parseLong((String) StringsKt.split$default((CharSequence) str7, new String[]{"-"}, false, 0, 6, (Object) null).get(0));
                        str = (String) StringsKt.split$default((CharSequence) str7, new String[]{"-"}, false, 0, 6, (Object) null).get(1);
                        if (j == jLongValue) {
                            ensurePlatformWallpapersDirectory();
                            str2 = getApplication().getFilesDir() + "/platform_wallpapers/" + jLongValue2 + BranchConfig.LOCAL_REPOSITORY + str;
                            file4 = new File(str2);
                            FilesKt.writeBytes(file4, value);
                            platformByIdStatically = daijishouLibraryRepository.getPlatformByIdStatically(jLongValue2);
                            if (platformByIdStatically == null) {
                                file4.delete();
                            } else {
                                platformByIdStatically.setWallpaperPath(str2);
                                daijishouLibraryRepository.updatePlatform(platformByIdStatically);
                            }
                        }
                    }
                    it = it16;
                }
            }
            HashMap map112 = map3;
            getLogger().debug(this, "Restore finished with below migrations:\n> playerIdMigration(" + map3.size() + "): " + map112 + "\n> platformIdMigration(" + map5.size() + "): " + map5 + "\n> playableItemIdMigration(" + map6.size() + "): " + map6 + "\n> eventIdMigration(" + map7.size() + "): " + map7);
            getLogger().debug(this, "Restore exceptions report:\n> playerMigration failed counts: " + map9.size() + "\n> platformMigration failed counts: " + map10.size() + "\n> playableItemMigration failed counts: " + map11.size() + "\n> eventMigration failed counts: " + map12.size());
            HashMap<String, Object> map113 = map2;
            map113.put("playerIdMigration", map112);
            map113.put("platformIdMigration", map5);
            map113.put("playableItemIdMigration", map6);
            map113.put("eventIdMigration", map7);
            objWithContext = BuildersKt.withContext(Dispatchers.getMain(), new LibraryBackupAndRestoreModule$restoreFromBackupContentHashMap$2$11(this, null), continuation);
            if (objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return objWithContext;
            }
            Unit unit8 = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    private static final void restoreFromBackupContentHashMap$lambda$19$digestPlayers(DaijishouLibraryRepository daijishouLibraryRepository, List<PlayerEntity> list, List<Long> list2, HashMap<Long, Long> map) {
        int i = 0;
        PlayerEntity[] playerEntityArr = (PlayerEntity[]) list.toArray(new PlayerEntity[0]);
        for (Object obj : daijishouLibraryRepository.addPlayers((PlayerEntity[]) Arrays.copyOf(playerEntityArr, playerEntityArr.length))) {
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

    private static final void restoreFromBackupContentHashMap$lambda$19$digestPlatforms(DaijishouLibraryRepository daijishouLibraryRepository, List<PlatformEntity> list, List<Long> list2, HashMap<Long, Long> map) {
        int i = 0;
        PlatformEntity[] platformEntityArr = (PlatformEntity[]) list.toArray(new PlatformEntity[0]);
        for (Object obj : daijishouLibraryRepository.addPlatforms((PlatformEntity[]) Arrays.copyOf(platformEntityArr, platformEntityArr.length))) {
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

    private static final void restoreFromBackupContentHashMap$lambda$19$digestPlayableItems(DaijishouLibraryRepository daijishouLibraryRepository, List<PlayableItemEntity> list, List<Long> list2, HashMap<Long, Long> map) {
        int i = 0;
        PlayableItemEntity[] playableItemEntityArr = (PlayableItemEntity[]) list.toArray(new PlayableItemEntity[0]);
        for (Object obj : daijishouLibraryRepository.addPlayableItems((PlayableItemEntity[]) Arrays.copyOf(playableItemEntityArr, playableItemEntityArr.length))) {
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

    private static final void restoreFromBackupContentHashMap$lambda$19$digestEvents(DaijishouLibraryRepository daijishouLibraryRepository, List<EventEntity> list, List<Long> list2, HashMap<Long, Long> map) {
        int i = 0;
        EventEntity[] eventEntityArr = (EventEntity[]) list.toArray(new EventEntity[0]);
        for (Object obj : daijishouLibraryRepository.addEvents((EventEntity[]) Arrays.copyOf(eventEntityArr, eventEntityArr.length))) {
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

    private static final void restoreFromBackupContentHashMap$lambda$19$digestGenres(DaijishouLibraryRepository daijishouLibraryRepository, List<PlayableItemToGenrePairEntity> list, List<Long> list2, HashMap<Long, Long> map) {
        int i = 0;
        PlayableItemToGenrePairEntity[] playableItemToGenrePairEntityArr = (PlayableItemToGenrePairEntity[]) list.toArray(new PlayableItemToGenrePairEntity[0]);
        for (Object obj : daijishouLibraryRepository.addPlayableItemToGenrePairs((PlayableItemToGenrePairEntity[]) Arrays.copyOf(playableItemToGenrePairEntityArr, playableItemToGenrePairEntityArr.length))) {
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
}
