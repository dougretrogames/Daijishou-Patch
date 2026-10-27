package com.magneticchen.daijishou.data.backup.modules.settings;

import android.content.SharedPreferences;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.backup.BackupAndRestoreModule;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SettingsBackupAndRestoreModule.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JR\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00180\u0017j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0018`\u00192&\u0010\u001a\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001b`\u0019H\u0096@¢\u0006\u0002\u0010\u001cJb\u0010\u001d\u001a\u00020\u001e2\"\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00180\u0017j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0018`\u00192&\u0010\u001a\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001b`\u00192\u0006\u0010 \u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010!R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011¨\u0006\""}, d2 = {"Lcom/magneticchen/daijishou/data/backup/modules/settings/SettingsBackupAndRestoreModule;", "Lcom/magneticchen/daijishou/data/backup/BackupAndRestoreModule;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "backupContentListMigrations", "", "Lcom/magneticchen/daijishou/data/backup/BackupAndRestoreModule$Companion$BackupContentMigration;", "getBackupContentListMigrations", "()Ljava/util/List;", "id", "", "getId", "()Ljava/lang/String;", "nameStringId", "", "getNameStringId", "()I", "supportedPolicies", "getSupportedPolicies", "version", "getVersion", "createBackupContentHashMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "pipeLineData", "", "(Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restoreFromBackupContentHashMap", "", "contentHashMap", "restorePolicy", "(Ljava/util/HashMap;Ljava/util/HashMap;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SettingsBackupAndRestoreModule extends BackupAndRestoreModule {
    private final List<BackupAndRestoreModule.Companion.BackupContentMigration> backupContentListMigrations;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f12id;
    private final int nameStringId;
    private final List<Integer> supportedPolicies;
    private final int version;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsBackupAndRestoreModule(DaijishouApplication application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.f12id = "daijishou.settings";
        this.nameStringId = R.string.settings_backup_and_restore_name;
        this.backupContentListMigrations = CollectionsKt.listOf(new BackupAndRestoreModule.Companion.BackupContentMigration() { // from class: com.magneticchen.daijishou.data.backup.modules.settings.SettingsBackupAndRestoreModule$backupContentListMigrations$1
            @Override // com.magneticchen.daijishou.data.backup.BackupAndRestoreModule.Companion.BackupContentMigration
            public HashMap<String, byte[]> migrate(HashMap<String, byte[]> contentHashMap) {
                Intrinsics.checkNotNullParameter(contentHashMap, "contentHashMap");
                return contentHashMap;
            }
        });
        this.supportedPolicies = CollectionsKt.listOf((Object[]) new Integer[]{0, 1, 2});
    }

    @Override // com.magneticchen.daijishou.data.backup.BackupAndRestoreModule
    public String getId() {
        return this.f12id;
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
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(getApplication().getDefaultSharedPreferences().getAll());
            objectOutputStream.close();
            return MapsKt.hashMapOf(TuplesKt.to("defaultSharedPreferences", byteArrayOutputStream.toByteArray()));
        } catch (Exception e) {
            getApplication().getLogger().error(this, ExceptionsKt.stackTraceToString(e));
            return new HashMap();
        }
    }

    @Override // com.magneticchen.daijishou.data.backup.BackupAndRestoreModule
    public Object restoreFromBackupContentHashMap(HashMap<String, byte[]> map, HashMap<String, Object> map2, int i, Continuation<? super Unit> continuation) {
        getApplication().getLogger().debug("defaultSharedPreferences", String.valueOf(map.get("defaultSharedPreferences")));
        byte[] bArr = map.get("defaultSharedPreferences");
        if (bArr != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    Object object = objectInputStream.readObject();
                    Intrinsics.checkNotNull(object, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String?, kotlin.Any>");
                    SharedPreferences.Editor editorEdit = getApplication().getDefaultSharedPreferences().edit();
                    editorEdit.clear();
                    for (Map.Entry entry : ((Map) object).entrySet()) {
                        String str = (String) entry.getKey();
                        Object value = entry.getValue();
                        if (value instanceof Boolean) {
                            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Boolean");
                            editorEdit.putBoolean(str, ((Boolean) value).booleanValue());
                        } else if (value instanceof String) {
                            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.String");
                            editorEdit.putString(str, (String) value);
                        } else if (value instanceof Integer) {
                            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Int");
                            editorEdit.putInt(str, ((Integer) value).intValue());
                        } else if (value instanceof Float) {
                            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Float");
                            editorEdit.putFloat(str, ((Float) value).floatValue());
                        } else if (value instanceof Long) {
                            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Long");
                            editorEdit.putLong(str, ((Long) value).longValue());
                        } else if (value instanceof Set) {
                            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String?>");
                            editorEdit.putStringSet(str, (Set) value);
                        } else {
                            getApplication().getLogger().error(this, "Type " + value.getClass().getName() + " is unknown");
                        }
                        editorEdit.commit();
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(objectInputStream, null);
                    Unit unit2 = Unit.INSTANCE;
                    CloseableKt.closeFinally(byteArrayInputStream, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(objectInputStream, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(byteArrayInputStream, th3);
                    throw th4;
                }
            }
        }
        return Unit.INSTANCE;
    }
}
