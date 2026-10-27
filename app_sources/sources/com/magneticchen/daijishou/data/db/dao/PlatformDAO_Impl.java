package com.magneticchen.daijishou.data.db.dao;

import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.magneticchen.daijishou.data.RoomDatabaseConverters;
import com.magneticchen.daijishou.data.db.entity.PlatformEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
public final class PlatformDAO_Impl implements PlatformDAO {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<PlatformEntity> __deletionAdapterOfPlatformEntity;
    private final EntityInsertionAdapter<PlatformEntity> __insertionAdapterOfPlatformEntity;
    private final SharedSQLiteStatement __preparedStmtOfUpdateWallpaperPathAll;
    private final RoomDatabaseConverters __roomDatabaseConverters = new RoomDatabaseConverters();
    private final EntityDeletionOrUpdateAdapter<PlatformEntity> __updateAdapterOfPlatformEntity;

    public PlatformDAO_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfPlatformEntity = new EntityInsertionAdapter<PlatformEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.PlatformDAO_Impl.1
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `PlatformEntity` (`id`,`unique_id`,`name`,`shortname`,`description`,`is_visible`,`scrape_preview_media`,`wallpaper_path`,`thumbnail_path`,`color_theme`,`color_on_theme`,`accept_filename_regex`,`default_player_id`,`player_id_list`,`scraper_source_list`,`box_art_aspect_ratio_id`,`use_custom_box_art_aspect_ratio`,`custom_box_art_aspect_ratio`,`screen_aspect_ratio_id`,`use_custom_screen_aspect_ratio`,`custom_screen_aspect_ratio`,`items_sync_tree_uri_list`,`retro_achievements_console_id_list`,`position`,`extra`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, PlatformEntity platformEntity) {
                supportSQLiteStatement.bindLong(1, platformEntity.getId());
                if (platformEntity.getUniqueId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, platformEntity.getUniqueId());
                }
                supportSQLiteStatement.bindString(3, platformEntity.getName());
                supportSQLiteStatement.bindString(4, platformEntity.getShortname());
                if (platformEntity.getDescription() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, platformEntity.getDescription());
                }
                supportSQLiteStatement.bindLong(6, platformEntity.isVisible() ? 1L : 0L);
                supportSQLiteStatement.bindLong(7, platformEntity.getScrapePreviewMedia() ? 1L : 0L);
                if (platformEntity.getWallpaperPath() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, platformEntity.getWallpaperPath());
                }
                if (platformEntity.getThumbnailPath() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, platformEntity.getThumbnailPath());
                }
                if (platformEntity.getColorTheme() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindLong(10, platformEntity.getColorTheme().intValue());
                }
                if (platformEntity.getColorOnTheme() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindLong(11, platformEntity.getColorOnTheme().intValue());
                }
                supportSQLiteStatement.bindString(12, platformEntity.getAcceptedFilenameRegex());
                supportSQLiteStatement.bindLong(13, platformEntity.getDefaultPlayerId());
                supportSQLiteStatement.bindString(14, PlatformDAO_Impl.this.__roomDatabaseConverters.fromMutableLongList(platformEntity.getPlayerIdList()));
                supportSQLiteStatement.bindString(15, PlatformDAO_Impl.this.__roomDatabaseConverters.fromMutableStringList(platformEntity.getScraperSourceList()));
                supportSQLiteStatement.bindLong(16, platformEntity.getBoxArtAspectRatioId());
                supportSQLiteStatement.bindLong(17, platformEntity.getUseCustomBoxArtAspectRatio() ? 1L : 0L);
                if (platformEntity.getCustomBoxArtAspectRatio() == null) {
                    supportSQLiteStatement.bindNull(18);
                } else {
                    supportSQLiteStatement.bindString(18, platformEntity.getCustomBoxArtAspectRatio());
                }
                supportSQLiteStatement.bindLong(19, platformEntity.getScreenAspectRatioId());
                supportSQLiteStatement.bindLong(20, platformEntity.getUseCustomScreenAspectRatio() ? 1L : 0L);
                if (platformEntity.getCustomScreenAspectRatio() == null) {
                    supportSQLiteStatement.bindNull(21);
                } else {
                    supportSQLiteStatement.bindString(21, platformEntity.getCustomScreenAspectRatio());
                }
                supportSQLiteStatement.bindString(22, PlatformDAO_Impl.this.__roomDatabaseConverters.fromMutableUriList(platformEntity.getItemsSyncTreeUriList()));
                supportSQLiteStatement.bindString(23, PlatformDAO_Impl.this.__roomDatabaseConverters.fromMutableLongList(platformEntity.getRetroAchievementsConsoleIdList()));
                supportSQLiteStatement.bindLong(24, platformEntity.getPosition());
                supportSQLiteStatement.bindString(25, platformEntity.getExtra());
            }
        };
        this.__deletionAdapterOfPlatformEntity = new EntityDeletionOrUpdateAdapter<PlatformEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.PlatformDAO_Impl.2
            protected String createQuery() {
                return "DELETE FROM `PlatformEntity` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(final SupportSQLiteStatement statement, final PlatformEntity entity) {
                statement.bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfPlatformEntity = new EntityDeletionOrUpdateAdapter<PlatformEntity>(__db) { // from class: com.magneticchen.daijishou.data.db.dao.PlatformDAO_Impl.3
            protected String createQuery() {
                return "UPDATE OR ABORT `PlatformEntity` SET `id` = ?,`unique_id` = ?,`name` = ?,`shortname` = ?,`description` = ?,`is_visible` = ?,`scrape_preview_media` = ?,`wallpaper_path` = ?,`thumbnail_path` = ?,`color_theme` = ?,`color_on_theme` = ?,`accept_filename_regex` = ?,`default_player_id` = ?,`player_id_list` = ?,`scraper_source_list` = ?,`box_art_aspect_ratio_id` = ?,`use_custom_box_art_aspect_ratio` = ?,`custom_box_art_aspect_ratio` = ?,`screen_aspect_ratio_id` = ?,`use_custom_screen_aspect_ratio` = ?,`custom_screen_aspect_ratio` = ?,`items_sync_tree_uri_list` = ?,`retro_achievements_console_id_list` = ?,`position` = ?,`extra` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, PlatformEntity platformEntity) {
                supportSQLiteStatement.bindLong(1, platformEntity.getId());
                if (platformEntity.getUniqueId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, platformEntity.getUniqueId());
                }
                supportSQLiteStatement.bindString(3, platformEntity.getName());
                supportSQLiteStatement.bindString(4, platformEntity.getShortname());
                if (platformEntity.getDescription() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, platformEntity.getDescription());
                }
                supportSQLiteStatement.bindLong(6, platformEntity.isVisible() ? 1L : 0L);
                supportSQLiteStatement.bindLong(7, platformEntity.getScrapePreviewMedia() ? 1L : 0L);
                if (platformEntity.getWallpaperPath() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, platformEntity.getWallpaperPath());
                }
                if (platformEntity.getThumbnailPath() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, platformEntity.getThumbnailPath());
                }
                if (platformEntity.getColorTheme() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindLong(10, platformEntity.getColorTheme().intValue());
                }
                if (platformEntity.getColorOnTheme() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindLong(11, platformEntity.getColorOnTheme().intValue());
                }
                supportSQLiteStatement.bindString(12, platformEntity.getAcceptedFilenameRegex());
                supportSQLiteStatement.bindLong(13, platformEntity.getDefaultPlayerId());
                supportSQLiteStatement.bindString(14, PlatformDAO_Impl.this.__roomDatabaseConverters.fromMutableLongList(platformEntity.getPlayerIdList()));
                supportSQLiteStatement.bindString(15, PlatformDAO_Impl.this.__roomDatabaseConverters.fromMutableStringList(platformEntity.getScraperSourceList()));
                supportSQLiteStatement.bindLong(16, platformEntity.getBoxArtAspectRatioId());
                supportSQLiteStatement.bindLong(17, platformEntity.getUseCustomBoxArtAspectRatio() ? 1L : 0L);
                if (platformEntity.getCustomBoxArtAspectRatio() == null) {
                    supportSQLiteStatement.bindNull(18);
                } else {
                    supportSQLiteStatement.bindString(18, platformEntity.getCustomBoxArtAspectRatio());
                }
                supportSQLiteStatement.bindLong(19, platformEntity.getScreenAspectRatioId());
                supportSQLiteStatement.bindLong(20, platformEntity.getUseCustomScreenAspectRatio() ? 1L : 0L);
                if (platformEntity.getCustomScreenAspectRatio() == null) {
                    supportSQLiteStatement.bindNull(21);
                } else {
                    supportSQLiteStatement.bindString(21, platformEntity.getCustomScreenAspectRatio());
                }
                supportSQLiteStatement.bindString(22, PlatformDAO_Impl.this.__roomDatabaseConverters.fromMutableUriList(platformEntity.getItemsSyncTreeUriList()));
                supportSQLiteStatement.bindString(23, PlatformDAO_Impl.this.__roomDatabaseConverters.fromMutableLongList(platformEntity.getRetroAchievementsConsoleIdList()));
                supportSQLiteStatement.bindLong(24, platformEntity.getPosition());
                supportSQLiteStatement.bindString(25, platformEntity.getExtra());
                supportSQLiteStatement.bindLong(26, platformEntity.getId());
            }
        };
        this.__preparedStmtOfUpdateWallpaperPathAll = new SharedSQLiteStatement(__db) { // from class: com.magneticchen.daijishou.data.db.dao.PlatformDAO_Impl.4
            public String createQuery() {
                return "UPDATE PlatformEntity SET wallpaper_path = ?";
            }
        };
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public long insert(final PlatformEntity platformEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfPlatformEntity.insertAndReturnId(platformEntity);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public List<Long> insertAll(final PlatformEntity... platformEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.__insertionAdapterOfPlatformEntity.insertAndReturnIdsList(platformEntities);
            this.__db.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public void delete(final PlatformEntity platformEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfPlatformEntity.handle(platformEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public void deleteAll(final PlatformEntity... platformEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfPlatformEntity.handleMultiple(platformEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public void update(final PlatformEntity platformEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfPlatformEntity.handle(platformEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public void updateAll(final PlatformEntity... platformEntities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfPlatformEntity.handleMultiple(platformEntities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public void updateWallpaperPathAll(final String wallpaperPath) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateWallpaperPathAll.acquire();
        if (wallpaperPath == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, wallpaperPath);
        }
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                this.__preparedStmtOfUpdateWallpaperPathAll.release(supportSQLiteStatementAcquire);
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            this.__preparedStmtOfUpdateWallpaperPathAll.release(supportSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public LiveData<Integer> countAll() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM PlatformEntity", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PlatformEntity"}, false, new Callable<Integer>() { // from class: com.magneticchen.daijishou.data.db.dao.PlatformDAO_Impl.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                Integer numValueOf = null;
                Cursor cursorQuery = DBUtil.query(PlatformDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    if (cursorQuery.moveToFirst() && !cursorQuery.isNull(0)) {
                        numValueOf = Integer.valueOf(cursorQuery.getInt(0));
                    }
                    return numValueOf;
                } finally {
                    cursorQuery.close();
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public int countAllStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(id) FROM PlatformEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public LiveData<List<Long>> selectAllIds() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id FROM PlatformEntity ORDER BY name COLLATE NOCASE ASC", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PlatformEntity"}, false, new Callable<List<Long>>() { // from class: com.magneticchen.daijishou.data.db.dao.PlatformDAO_Impl.6
            @Override // java.util.concurrent.Callable
            public List<Long> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(PlatformDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(Long.valueOf(cursorQuery.getLong(0)));
                    }
                    cursorQuery.close();
                    return arrayList;
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public List<Long> selectAllIdsStatically() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id FROM PlatformEntity ORDER BY name COLLATE NOCASE ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(Long.valueOf(cursorQuery.getLong(0)));
            }
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            return arrayList;
        } catch (Throwable th) {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            throw th;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public LiveData<List<PlatformEntity>> selectAll() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlatformEntity ORDER BY name COLLATE NOCASE ASC", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PlatformEntity"}, false, new Callable<List<PlatformEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.PlatformDAO_Impl.7
            @Override // java.util.concurrent.Callable
            public List<PlatformEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(PlatformDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "shortname");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_visible");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scrape_preview_media");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wallpaper_path");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_path");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_theme");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_on_theme");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accept_filename_regex");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "default_player_id");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player_id_list");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scraper_source_list");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "box_art_aspect_ratio_id");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_box_art_aspect_ratio");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_box_art_aspect_ratio");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "screen_aspect_ratio_id");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_screen_aspect_ratio");
                        int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_screen_aspect_ratio");
                        int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "items_sync_tree_uri_list");
                        int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "retro_achievements_console_id_list");
                        int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "position");
                        int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                        int i = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            long j = cursorQuery.getLong(columnIndexOrThrow);
                            String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                            String string2 = cursorQuery.getString(columnIndexOrThrow3);
                            String string3 = cursorQuery.getString(columnIndexOrThrow4);
                            String string4 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                            boolean z = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                            boolean z2 = cursorQuery.getInt(columnIndexOrThrow7) != 0;
                            String string5 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                            String string6 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                            Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow10));
                            Integer numValueOf2 = cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11));
                            String string7 = cursorQuery.getString(columnIndexOrThrow12);
                            long j2 = cursorQuery.getLong(columnIndexOrThrow13);
                            int i2 = i;
                            int i3 = columnIndexOrThrow;
                            int i4 = columnIndexOrThrow13;
                            try {
                                List<Long> mutableLongList = PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(i2));
                                int i5 = columnIndexOrThrow15;
                                columnIndexOrThrow15 = i5;
                                List<String> mutableStringList = PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(i5));
                                int i6 = columnIndexOrThrow16;
                                int i7 = cursorQuery.getInt(i6);
                                columnIndexOrThrow17 = columnIndexOrThrow17;
                                boolean z3 = cursorQuery.getInt(columnIndexOrThrow17) != 0;
                                columnIndexOrThrow16 = i6;
                                int i8 = columnIndexOrThrow18;
                                String string8 = cursorQuery.isNull(i8) ? null : cursorQuery.getString(i8);
                                columnIndexOrThrow18 = i8;
                                int i9 = columnIndexOrThrow19;
                                int i10 = cursorQuery.getInt(i9);
                                columnIndexOrThrow19 = i9;
                                int i11 = columnIndexOrThrow20;
                                boolean z4 = cursorQuery.getInt(i11) != 0;
                                columnIndexOrThrow20 = i11;
                                columnIndexOrThrow21 = columnIndexOrThrow21;
                                String string9 = cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21);
                                String string10 = cursorQuery.getString(columnIndexOrThrow22);
                                columnIndexOrThrow22 = columnIndexOrThrow22;
                                List<Uri> mutableUriList = PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableUriList(string10);
                                int i12 = columnIndexOrThrow23;
                                columnIndexOrThrow23 = i12;
                                List<Long> mutableLongList2 = PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(i12));
                                int i13 = columnIndexOrThrow24;
                                int i14 = columnIndexOrThrow25;
                                columnIndexOrThrow24 = i13;
                                arrayList.add(new PlatformEntity(j, string, string2, string3, string4, z, z2, string5, string6, numValueOf, numValueOf2, string7, j2, mutableLongList, mutableStringList, i7, z3, string8, i10, z4, string9, mutableUriList, mutableLongList2, cursorQuery.getInt(i13), cursorQuery.getString(i14)));
                                columnIndexOrThrow25 = i14;
                                columnIndexOrThrow = i3;
                                columnIndexOrThrow13 = i4;
                                i = i2;
                            } catch (Throwable th) {
                                th = th;
                                cursorQuery.close();
                                throw th;
                            }
                        }
                        cursorQuery.close();
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public List<PlatformEntity> selectAllStatically() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlatformEntity ORDER BY name COLLATE NOCASE ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "shortname");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_visible");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scrape_preview_media");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wallpaper_path");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_path");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_theme");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_on_theme");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accept_filename_regex");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "default_player_id");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player_id_list");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scraper_source_list");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "box_art_aspect_ratio_id");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_box_art_aspect_ratio");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_box_art_aspect_ratio");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "screen_aspect_ratio_id");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_screen_aspect_ratio");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_screen_aspect_ratio");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "items_sync_tree_uri_list");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "retro_achievements_console_id_list");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "position");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                    int i = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        long j = cursorQuery.getLong(columnIndexOrThrow);
                        String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string2 = cursorQuery.getString(columnIndexOrThrow3);
                        String string3 = cursorQuery.getString(columnIndexOrThrow4);
                        String string4 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        boolean z = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                        boolean z2 = cursorQuery.getInt(columnIndexOrThrow7) != 0;
                        String string5 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                        String string6 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                        Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow10));
                        Integer numValueOf2 = cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11));
                        String string7 = cursorQuery.getString(columnIndexOrThrow12);
                        long j2 = cursorQuery.getLong(columnIndexOrThrow13);
                        int i2 = i;
                        int i3 = columnIndexOrThrow;
                        int i4 = columnIndexOrThrow12;
                        try {
                            List<Long> mutableLongList = this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(i2));
                            int i5 = columnIndexOrThrow15;
                            columnIndexOrThrow15 = i5;
                            List<String> mutableStringList = this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(i5));
                            int i6 = columnIndexOrThrow16;
                            int i7 = cursorQuery.getInt(i6);
                            columnIndexOrThrow17 = columnIndexOrThrow17;
                            boolean z3 = cursorQuery.getInt(columnIndexOrThrow17) != 0;
                            columnIndexOrThrow16 = i6;
                            int i8 = columnIndexOrThrow18;
                            String string8 = cursorQuery.isNull(i8) ? null : cursorQuery.getString(i8);
                            columnIndexOrThrow18 = i8;
                            int i9 = columnIndexOrThrow19;
                            int i10 = cursorQuery.getInt(i9);
                            columnIndexOrThrow19 = i9;
                            int i11 = columnIndexOrThrow20;
                            boolean z4 = cursorQuery.getInt(i11) != 0;
                            columnIndexOrThrow20 = i11;
                            columnIndexOrThrow21 = columnIndexOrThrow21;
                            String string9 = cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21);
                            String string10 = cursorQuery.getString(columnIndexOrThrow22);
                            columnIndexOrThrow22 = columnIndexOrThrow22;
                            List<Uri> mutableUriList = this.__roomDatabaseConverters.toMutableUriList(string10);
                            int i12 = columnIndexOrThrow23;
                            columnIndexOrThrow23 = i12;
                            List<Long> mutableLongList2 = this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(i12));
                            int i13 = columnIndexOrThrow24;
                            int i14 = columnIndexOrThrow25;
                            columnIndexOrThrow24 = i13;
                            arrayList.add(new PlatformEntity(j, string, string2, string3, string4, z, z2, string5, string6, numValueOf, numValueOf2, string7, j2, mutableLongList, mutableStringList, i7, z3, string8, i10, z4, string9, mutableUriList, mutableLongList2, cursorQuery.getInt(i13), cursorQuery.getString(i14)));
                            columnIndexOrThrow25 = i14;
                            columnIndexOrThrow = i3;
                            columnIndexOrThrow12 = i4;
                            i = i2;
                        } catch (Throwable th) {
                            th = th;
                            cursorQuery.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    }
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public LiveData<List<PlatformEntity>> selectAllOrderedByShortName() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlatformEntity ORDER BY shortname ASC", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PlatformEntity"}, false, new Callable<List<PlatformEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.PlatformDAO_Impl.8
            @Override // java.util.concurrent.Callable
            public List<PlatformEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(PlatformDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "shortname");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_visible");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scrape_preview_media");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wallpaper_path");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_path");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_theme");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_on_theme");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accept_filename_regex");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "default_player_id");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player_id_list");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scraper_source_list");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "box_art_aspect_ratio_id");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_box_art_aspect_ratio");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_box_art_aspect_ratio");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "screen_aspect_ratio_id");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_screen_aspect_ratio");
                        int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_screen_aspect_ratio");
                        int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "items_sync_tree_uri_list");
                        int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "retro_achievements_console_id_list");
                        int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "position");
                        int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                        int i = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            long j = cursorQuery.getLong(columnIndexOrThrow);
                            String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                            String string2 = cursorQuery.getString(columnIndexOrThrow3);
                            String string3 = cursorQuery.getString(columnIndexOrThrow4);
                            String string4 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                            boolean z = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                            boolean z2 = cursorQuery.getInt(columnIndexOrThrow7) != 0;
                            String string5 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                            String string6 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                            Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow10));
                            Integer numValueOf2 = cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11));
                            String string7 = cursorQuery.getString(columnIndexOrThrow12);
                            long j2 = cursorQuery.getLong(columnIndexOrThrow13);
                            int i2 = i;
                            int i3 = columnIndexOrThrow;
                            int i4 = columnIndexOrThrow13;
                            try {
                                List<Long> mutableLongList = PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(i2));
                                int i5 = columnIndexOrThrow15;
                                columnIndexOrThrow15 = i5;
                                List<String> mutableStringList = PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(i5));
                                int i6 = columnIndexOrThrow16;
                                int i7 = cursorQuery.getInt(i6);
                                columnIndexOrThrow17 = columnIndexOrThrow17;
                                boolean z3 = cursorQuery.getInt(columnIndexOrThrow17) != 0;
                                columnIndexOrThrow16 = i6;
                                int i8 = columnIndexOrThrow18;
                                String string8 = cursorQuery.isNull(i8) ? null : cursorQuery.getString(i8);
                                columnIndexOrThrow18 = i8;
                                int i9 = columnIndexOrThrow19;
                                int i10 = cursorQuery.getInt(i9);
                                columnIndexOrThrow19 = i9;
                                int i11 = columnIndexOrThrow20;
                                boolean z4 = cursorQuery.getInt(i11) != 0;
                                columnIndexOrThrow20 = i11;
                                columnIndexOrThrow21 = columnIndexOrThrow21;
                                String string9 = cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21);
                                String string10 = cursorQuery.getString(columnIndexOrThrow22);
                                columnIndexOrThrow22 = columnIndexOrThrow22;
                                List<Uri> mutableUriList = PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableUriList(string10);
                                int i12 = columnIndexOrThrow23;
                                columnIndexOrThrow23 = i12;
                                List<Long> mutableLongList2 = PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(i12));
                                int i13 = columnIndexOrThrow24;
                                int i14 = columnIndexOrThrow25;
                                columnIndexOrThrow24 = i13;
                                arrayList.add(new PlatformEntity(j, string, string2, string3, string4, z, z2, string5, string6, numValueOf, numValueOf2, string7, j2, mutableLongList, mutableStringList, i7, z3, string8, i10, z4, string9, mutableUriList, mutableLongList2, cursorQuery.getInt(i13), cursorQuery.getString(i14)));
                                columnIndexOrThrow25 = i14;
                                columnIndexOrThrow = i3;
                                columnIndexOrThrow13 = i4;
                                i = i2;
                            } catch (Throwable th) {
                                th = th;
                                cursorQuery.close();
                                throw th;
                            }
                        }
                        cursorQuery.close();
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public List<PlatformEntity> selectAllOrderedByShortNameStatically() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlatformEntity ORDER BY shortname ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "shortname");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_visible");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scrape_preview_media");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wallpaper_path");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_path");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_theme");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_on_theme");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accept_filename_regex");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "default_player_id");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player_id_list");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scraper_source_list");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "box_art_aspect_ratio_id");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_box_art_aspect_ratio");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_box_art_aspect_ratio");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "screen_aspect_ratio_id");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_screen_aspect_ratio");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_screen_aspect_ratio");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "items_sync_tree_uri_list");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "retro_achievements_console_id_list");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "position");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                    int i = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        long j = cursorQuery.getLong(columnIndexOrThrow);
                        String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string2 = cursorQuery.getString(columnIndexOrThrow3);
                        String string3 = cursorQuery.getString(columnIndexOrThrow4);
                        String string4 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        boolean z = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                        boolean z2 = cursorQuery.getInt(columnIndexOrThrow7) != 0;
                        String string5 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                        String string6 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                        Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow10));
                        Integer numValueOf2 = cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11));
                        String string7 = cursorQuery.getString(columnIndexOrThrow12);
                        long j2 = cursorQuery.getLong(columnIndexOrThrow13);
                        int i2 = i;
                        int i3 = columnIndexOrThrow;
                        int i4 = columnIndexOrThrow12;
                        try {
                            List<Long> mutableLongList = this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(i2));
                            int i5 = columnIndexOrThrow15;
                            columnIndexOrThrow15 = i5;
                            List<String> mutableStringList = this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(i5));
                            int i6 = columnIndexOrThrow16;
                            int i7 = cursorQuery.getInt(i6);
                            columnIndexOrThrow17 = columnIndexOrThrow17;
                            boolean z3 = cursorQuery.getInt(columnIndexOrThrow17) != 0;
                            columnIndexOrThrow16 = i6;
                            int i8 = columnIndexOrThrow18;
                            String string8 = cursorQuery.isNull(i8) ? null : cursorQuery.getString(i8);
                            columnIndexOrThrow18 = i8;
                            int i9 = columnIndexOrThrow19;
                            int i10 = cursorQuery.getInt(i9);
                            columnIndexOrThrow19 = i9;
                            int i11 = columnIndexOrThrow20;
                            boolean z4 = cursorQuery.getInt(i11) != 0;
                            columnIndexOrThrow20 = i11;
                            columnIndexOrThrow21 = columnIndexOrThrow21;
                            String string9 = cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21);
                            String string10 = cursorQuery.getString(columnIndexOrThrow22);
                            columnIndexOrThrow22 = columnIndexOrThrow22;
                            List<Uri> mutableUriList = this.__roomDatabaseConverters.toMutableUriList(string10);
                            int i12 = columnIndexOrThrow23;
                            columnIndexOrThrow23 = i12;
                            List<Long> mutableLongList2 = this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(i12));
                            int i13 = columnIndexOrThrow24;
                            int i14 = columnIndexOrThrow25;
                            columnIndexOrThrow24 = i13;
                            arrayList.add(new PlatformEntity(j, string, string2, string3, string4, z, z2, string5, string6, numValueOf, numValueOf2, string7, j2, mutableLongList, mutableStringList, i7, z3, string8, i10, z4, string9, mutableUriList, mutableLongList2, cursorQuery.getInt(i13), cursorQuery.getString(i14)));
                            columnIndexOrThrow25 = i14;
                            columnIndexOrThrow = i3;
                            columnIndexOrThrow12 = i4;
                            i = i2;
                        } catch (Throwable th) {
                            th = th;
                            cursorQuery.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    }
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public LiveData<List<PlatformEntity>> selectVisible() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlatformEntity WHERE is_visible = 1 ORDER BY name COLLATE NOCASE ASC", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PlatformEntity"}, false, new Callable<List<PlatformEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.PlatformDAO_Impl.9
            @Override // java.util.concurrent.Callable
            public List<PlatformEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(PlatformDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "shortname");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_visible");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scrape_preview_media");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wallpaper_path");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_path");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_theme");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_on_theme");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accept_filename_regex");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "default_player_id");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player_id_list");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scraper_source_list");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "box_art_aspect_ratio_id");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_box_art_aspect_ratio");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_box_art_aspect_ratio");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "screen_aspect_ratio_id");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_screen_aspect_ratio");
                        int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_screen_aspect_ratio");
                        int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "items_sync_tree_uri_list");
                        int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "retro_achievements_console_id_list");
                        int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "position");
                        int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                        int i = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            long j = cursorQuery.getLong(columnIndexOrThrow);
                            String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                            String string2 = cursorQuery.getString(columnIndexOrThrow3);
                            String string3 = cursorQuery.getString(columnIndexOrThrow4);
                            String string4 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                            boolean z = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                            boolean z2 = cursorQuery.getInt(columnIndexOrThrow7) != 0;
                            String string5 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                            String string6 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                            Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow10));
                            Integer numValueOf2 = cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11));
                            String string7 = cursorQuery.getString(columnIndexOrThrow12);
                            long j2 = cursorQuery.getLong(columnIndexOrThrow13);
                            int i2 = i;
                            int i3 = columnIndexOrThrow;
                            int i4 = columnIndexOrThrow13;
                            try {
                                List<Long> mutableLongList = PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(i2));
                                int i5 = columnIndexOrThrow15;
                                columnIndexOrThrow15 = i5;
                                List<String> mutableStringList = PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(i5));
                                int i6 = columnIndexOrThrow16;
                                int i7 = cursorQuery.getInt(i6);
                                columnIndexOrThrow17 = columnIndexOrThrow17;
                                boolean z3 = cursorQuery.getInt(columnIndexOrThrow17) != 0;
                                columnIndexOrThrow16 = i6;
                                int i8 = columnIndexOrThrow18;
                                String string8 = cursorQuery.isNull(i8) ? null : cursorQuery.getString(i8);
                                columnIndexOrThrow18 = i8;
                                int i9 = columnIndexOrThrow19;
                                int i10 = cursorQuery.getInt(i9);
                                columnIndexOrThrow19 = i9;
                                int i11 = columnIndexOrThrow20;
                                boolean z4 = cursorQuery.getInt(i11) != 0;
                                columnIndexOrThrow20 = i11;
                                columnIndexOrThrow21 = columnIndexOrThrow21;
                                String string9 = cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21);
                                String string10 = cursorQuery.getString(columnIndexOrThrow22);
                                columnIndexOrThrow22 = columnIndexOrThrow22;
                                List<Uri> mutableUriList = PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableUriList(string10);
                                int i12 = columnIndexOrThrow23;
                                columnIndexOrThrow23 = i12;
                                List<Long> mutableLongList2 = PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(i12));
                                int i13 = columnIndexOrThrow24;
                                int i14 = columnIndexOrThrow25;
                                columnIndexOrThrow24 = i13;
                                arrayList.add(new PlatformEntity(j, string, string2, string3, string4, z, z2, string5, string6, numValueOf, numValueOf2, string7, j2, mutableLongList, mutableStringList, i7, z3, string8, i10, z4, string9, mutableUriList, mutableLongList2, cursorQuery.getInt(i13), cursorQuery.getString(i14)));
                                columnIndexOrThrow25 = i14;
                                columnIndexOrThrow = i3;
                                columnIndexOrThrow13 = i4;
                                i = i2;
                            } catch (Throwable th) {
                                th = th;
                                cursorQuery.close();
                                throw th;
                            }
                        }
                        cursorQuery.close();
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public List<PlatformEntity> selectVisibleStatically() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlatformEntity WHERE is_visible = 1 ORDER BY name COLLATE NOCASE ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "shortname");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_visible");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scrape_preview_media");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wallpaper_path");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_path");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_theme");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_on_theme");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accept_filename_regex");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "default_player_id");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player_id_list");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scraper_source_list");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "box_art_aspect_ratio_id");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_box_art_aspect_ratio");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_box_art_aspect_ratio");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "screen_aspect_ratio_id");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_screen_aspect_ratio");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_screen_aspect_ratio");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "items_sync_tree_uri_list");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "retro_achievements_console_id_list");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "position");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                    int i = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        long j = cursorQuery.getLong(columnIndexOrThrow);
                        String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string2 = cursorQuery.getString(columnIndexOrThrow3);
                        String string3 = cursorQuery.getString(columnIndexOrThrow4);
                        String string4 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        boolean z = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                        boolean z2 = cursorQuery.getInt(columnIndexOrThrow7) != 0;
                        String string5 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                        String string6 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                        Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow10));
                        Integer numValueOf2 = cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11));
                        String string7 = cursorQuery.getString(columnIndexOrThrow12);
                        long j2 = cursorQuery.getLong(columnIndexOrThrow13);
                        int i2 = i;
                        int i3 = columnIndexOrThrow;
                        int i4 = columnIndexOrThrow12;
                        try {
                            List<Long> mutableLongList = this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(i2));
                            int i5 = columnIndexOrThrow15;
                            columnIndexOrThrow15 = i5;
                            List<String> mutableStringList = this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(i5));
                            int i6 = columnIndexOrThrow16;
                            int i7 = cursorQuery.getInt(i6);
                            columnIndexOrThrow17 = columnIndexOrThrow17;
                            boolean z3 = cursorQuery.getInt(columnIndexOrThrow17) != 0;
                            columnIndexOrThrow16 = i6;
                            int i8 = columnIndexOrThrow18;
                            String string8 = cursorQuery.isNull(i8) ? null : cursorQuery.getString(i8);
                            columnIndexOrThrow18 = i8;
                            int i9 = columnIndexOrThrow19;
                            int i10 = cursorQuery.getInt(i9);
                            columnIndexOrThrow19 = i9;
                            int i11 = columnIndexOrThrow20;
                            boolean z4 = cursorQuery.getInt(i11) != 0;
                            columnIndexOrThrow20 = i11;
                            columnIndexOrThrow21 = columnIndexOrThrow21;
                            String string9 = cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21);
                            String string10 = cursorQuery.getString(columnIndexOrThrow22);
                            columnIndexOrThrow22 = columnIndexOrThrow22;
                            List<Uri> mutableUriList = this.__roomDatabaseConverters.toMutableUriList(string10);
                            int i12 = columnIndexOrThrow23;
                            columnIndexOrThrow23 = i12;
                            List<Long> mutableLongList2 = this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(i12));
                            int i13 = columnIndexOrThrow24;
                            int i14 = columnIndexOrThrow25;
                            columnIndexOrThrow24 = i13;
                            arrayList.add(new PlatformEntity(j, string, string2, string3, string4, z, z2, string5, string6, numValueOf, numValueOf2, string7, j2, mutableLongList, mutableStringList, i7, z3, string8, i10, z4, string9, mutableUriList, mutableLongList2, cursorQuery.getInt(i13), cursorQuery.getString(i14)));
                            columnIndexOrThrow25 = i14;
                            columnIndexOrThrow = i3;
                            columnIndexOrThrow12 = i4;
                            i = i2;
                        } catch (Throwable th) {
                            th = th;
                            cursorQuery.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    }
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public LiveData<List<PlatformEntity>> selectVisibleOrderedByShortName() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlatformEntity WHERE is_visible = 1 ORDER BY shortname ASC", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PlatformEntity"}, false, new Callable<List<PlatformEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.PlatformDAO_Impl.10
            @Override // java.util.concurrent.Callable
            public List<PlatformEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(PlatformDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "shortname");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_visible");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scrape_preview_media");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wallpaper_path");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_path");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_theme");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_on_theme");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accept_filename_regex");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "default_player_id");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player_id_list");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scraper_source_list");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "box_art_aspect_ratio_id");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_box_art_aspect_ratio");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_box_art_aspect_ratio");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "screen_aspect_ratio_id");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_screen_aspect_ratio");
                        int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_screen_aspect_ratio");
                        int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "items_sync_tree_uri_list");
                        int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "retro_achievements_console_id_list");
                        int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "position");
                        int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                        int i = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            long j = cursorQuery.getLong(columnIndexOrThrow);
                            String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                            String string2 = cursorQuery.getString(columnIndexOrThrow3);
                            String string3 = cursorQuery.getString(columnIndexOrThrow4);
                            String string4 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                            boolean z = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                            boolean z2 = cursorQuery.getInt(columnIndexOrThrow7) != 0;
                            String string5 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                            String string6 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                            Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow10));
                            Integer numValueOf2 = cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11));
                            String string7 = cursorQuery.getString(columnIndexOrThrow12);
                            long j2 = cursorQuery.getLong(columnIndexOrThrow13);
                            int i2 = i;
                            int i3 = columnIndexOrThrow;
                            int i4 = columnIndexOrThrow13;
                            try {
                                List<Long> mutableLongList = PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(i2));
                                int i5 = columnIndexOrThrow15;
                                columnIndexOrThrow15 = i5;
                                List<String> mutableStringList = PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(i5));
                                int i6 = columnIndexOrThrow16;
                                int i7 = cursorQuery.getInt(i6);
                                columnIndexOrThrow17 = columnIndexOrThrow17;
                                boolean z3 = cursorQuery.getInt(columnIndexOrThrow17) != 0;
                                columnIndexOrThrow16 = i6;
                                int i8 = columnIndexOrThrow18;
                                String string8 = cursorQuery.isNull(i8) ? null : cursorQuery.getString(i8);
                                columnIndexOrThrow18 = i8;
                                int i9 = columnIndexOrThrow19;
                                int i10 = cursorQuery.getInt(i9);
                                columnIndexOrThrow19 = i9;
                                int i11 = columnIndexOrThrow20;
                                boolean z4 = cursorQuery.getInt(i11) != 0;
                                columnIndexOrThrow20 = i11;
                                columnIndexOrThrow21 = columnIndexOrThrow21;
                                String string9 = cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21);
                                String string10 = cursorQuery.getString(columnIndexOrThrow22);
                                columnIndexOrThrow22 = columnIndexOrThrow22;
                                List<Uri> mutableUriList = PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableUriList(string10);
                                int i12 = columnIndexOrThrow23;
                                columnIndexOrThrow23 = i12;
                                List<Long> mutableLongList2 = PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(i12));
                                int i13 = columnIndexOrThrow24;
                                int i14 = columnIndexOrThrow25;
                                columnIndexOrThrow24 = i13;
                                arrayList.add(new PlatformEntity(j, string, string2, string3, string4, z, z2, string5, string6, numValueOf, numValueOf2, string7, j2, mutableLongList, mutableStringList, i7, z3, string8, i10, z4, string9, mutableUriList, mutableLongList2, cursorQuery.getInt(i13), cursorQuery.getString(i14)));
                                columnIndexOrThrow25 = i14;
                                columnIndexOrThrow = i3;
                                columnIndexOrThrow13 = i4;
                                i = i2;
                            } catch (Throwable th) {
                                th = th;
                                cursorQuery.close();
                                throw th;
                            }
                        }
                        cursorQuery.close();
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public List<PlatformEntity> selectVisibleOrderedByShortNameStatically() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlatformEntity WHERE is_visible = 1 ORDER BY shortname ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "shortname");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_visible");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scrape_preview_media");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wallpaper_path");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_path");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_theme");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_on_theme");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accept_filename_regex");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "default_player_id");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player_id_list");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scraper_source_list");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "box_art_aspect_ratio_id");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_box_art_aspect_ratio");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_box_art_aspect_ratio");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "screen_aspect_ratio_id");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_screen_aspect_ratio");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_screen_aspect_ratio");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "items_sync_tree_uri_list");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "retro_achievements_console_id_list");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "position");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                    int i = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        long j = cursorQuery.getLong(columnIndexOrThrow);
                        String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string2 = cursorQuery.getString(columnIndexOrThrow3);
                        String string3 = cursorQuery.getString(columnIndexOrThrow4);
                        String string4 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        boolean z = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                        boolean z2 = cursorQuery.getInt(columnIndexOrThrow7) != 0;
                        String string5 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                        String string6 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                        Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow10));
                        Integer numValueOf2 = cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11));
                        String string7 = cursorQuery.getString(columnIndexOrThrow12);
                        long j2 = cursorQuery.getLong(columnIndexOrThrow13);
                        int i2 = i;
                        int i3 = columnIndexOrThrow;
                        int i4 = columnIndexOrThrow12;
                        try {
                            List<Long> mutableLongList = this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(i2));
                            int i5 = columnIndexOrThrow15;
                            columnIndexOrThrow15 = i5;
                            List<String> mutableStringList = this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(i5));
                            int i6 = columnIndexOrThrow16;
                            int i7 = cursorQuery.getInt(i6);
                            columnIndexOrThrow17 = columnIndexOrThrow17;
                            boolean z3 = cursorQuery.getInt(columnIndexOrThrow17) != 0;
                            columnIndexOrThrow16 = i6;
                            int i8 = columnIndexOrThrow18;
                            String string8 = cursorQuery.isNull(i8) ? null : cursorQuery.getString(i8);
                            columnIndexOrThrow18 = i8;
                            int i9 = columnIndexOrThrow19;
                            int i10 = cursorQuery.getInt(i9);
                            columnIndexOrThrow19 = i9;
                            int i11 = columnIndexOrThrow20;
                            boolean z4 = cursorQuery.getInt(i11) != 0;
                            columnIndexOrThrow20 = i11;
                            columnIndexOrThrow21 = columnIndexOrThrow21;
                            String string9 = cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21);
                            String string10 = cursorQuery.getString(columnIndexOrThrow22);
                            columnIndexOrThrow22 = columnIndexOrThrow22;
                            List<Uri> mutableUriList = this.__roomDatabaseConverters.toMutableUriList(string10);
                            int i12 = columnIndexOrThrow23;
                            columnIndexOrThrow23 = i12;
                            List<Long> mutableLongList2 = this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(i12));
                            int i13 = columnIndexOrThrow24;
                            int i14 = columnIndexOrThrow25;
                            columnIndexOrThrow24 = i13;
                            arrayList.add(new PlatformEntity(j, string, string2, string3, string4, z, z2, string5, string6, numValueOf, numValueOf2, string7, j2, mutableLongList, mutableStringList, i7, z3, string8, i10, z4, string9, mutableUriList, mutableLongList2, cursorQuery.getInt(i13), cursorQuery.getString(i14)));
                            columnIndexOrThrow25 = i14;
                            columnIndexOrThrow = i3;
                            columnIndexOrThrow12 = i4;
                            i = i2;
                        } catch (Throwable th) {
                            th = th;
                            cursorQuery.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    }
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public LiveData<PlatformEntity> selectById(final long id2) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlatformEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PlatformEntity"}, false, new Callable<PlatformEntity>() { // from class: com.magneticchen.daijishou.data.db.dao.PlatformDAO_Impl.11
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public PlatformEntity call() throws Exception {
                PlatformEntity platformEntity;
                Cursor cursorQuery = DBUtil.query(PlatformDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "shortname");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_visible");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scrape_preview_media");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wallpaper_path");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_path");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_theme");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_on_theme");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accept_filename_regex");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "default_player_id");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player_id_list");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scraper_source_list");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "box_art_aspect_ratio_id");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_box_art_aspect_ratio");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_box_art_aspect_ratio");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "screen_aspect_ratio_id");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_screen_aspect_ratio");
                        int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_screen_aspect_ratio");
                        int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "items_sync_tree_uri_list");
                        int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "retro_achievements_console_id_list");
                        int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "position");
                        int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                        if (cursorQuery.moveToFirst()) {
                            try {
                                platformEntity = new PlatformEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.getInt(columnIndexOrThrow6) != 0, cursorQuery.getInt(columnIndexOrThrow7) != 0, cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8), cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9), cursorQuery.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow10)), cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11)), cursorQuery.getString(columnIndexOrThrow12), cursorQuery.getLong(columnIndexOrThrow13), PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(columnIndexOrThrow14)), PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(columnIndexOrThrow15)), cursorQuery.getInt(columnIndexOrThrow16), cursorQuery.getInt(columnIndexOrThrow17) != 0, cursorQuery.isNull(columnIndexOrThrow18) ? null : cursorQuery.getString(columnIndexOrThrow18), cursorQuery.getInt(columnIndexOrThrow19), cursorQuery.getInt(columnIndexOrThrow20) != 0, cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21), PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableUriList(cursorQuery.getString(columnIndexOrThrow22)), PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(columnIndexOrThrow23)), cursorQuery.getInt(columnIndexOrThrow24), cursorQuery.getString(columnIndexOrThrow25));
                            } catch (Throwable th) {
                                th = th;
                                cursorQuery.close();
                                throw th;
                            }
                        } else {
                            platformEntity = null;
                        }
                        cursorQuery.close();
                        return platformEntity;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public PlatformEntity selectByIdStatically(final long id2) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        PlatformEntity platformEntity;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlatformEntity WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, id2);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "shortname");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_visible");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scrape_preview_media");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wallpaper_path");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_path");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_theme");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_on_theme");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accept_filename_regex");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "default_player_id");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player_id_list");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scraper_source_list");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "box_art_aspect_ratio_id");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_box_art_aspect_ratio");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_box_art_aspect_ratio");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "screen_aspect_ratio_id");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_screen_aspect_ratio");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_screen_aspect_ratio");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "items_sync_tree_uri_list");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "retro_achievements_console_id_list");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "position");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                    if (cursorQuery.moveToFirst()) {
                        try {
                            platformEntity = new PlatformEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.getInt(columnIndexOrThrow6) != 0, cursorQuery.getInt(columnIndexOrThrow7) != 0, cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8), cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9), cursorQuery.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow10)), cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11)), cursorQuery.getString(columnIndexOrThrow12), cursorQuery.getLong(columnIndexOrThrow13), this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(columnIndexOrThrow14)), this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(columnIndexOrThrow15)), cursorQuery.getInt(columnIndexOrThrow16), cursorQuery.getInt(columnIndexOrThrow17) != 0, cursorQuery.isNull(columnIndexOrThrow18) ? null : cursorQuery.getString(columnIndexOrThrow18), cursorQuery.getInt(columnIndexOrThrow19), cursorQuery.getInt(columnIndexOrThrow20) != 0, cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21), this.__roomDatabaseConverters.toMutableUriList(cursorQuery.getString(columnIndexOrThrow22)), this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(columnIndexOrThrow23)), cursorQuery.getInt(columnIndexOrThrow24), cursorQuery.getString(columnIndexOrThrow25));
                        } catch (Throwable th) {
                            th = th;
                            cursorQuery.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    } else {
                        platformEntity = null;
                    }
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    return platformEntity;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public LiveData<PlatformEntity> selectByShortname(final String shortname) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlatformEntity WHERE shortname = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, shortname);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PlatformEntity"}, false, new Callable<PlatformEntity>() { // from class: com.magneticchen.daijishou.data.db.dao.PlatformDAO_Impl.12
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public PlatformEntity call() throws Exception {
                PlatformEntity platformEntity;
                Cursor cursorQuery = DBUtil.query(PlatformDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "shortname");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_visible");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scrape_preview_media");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wallpaper_path");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_path");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_theme");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_on_theme");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accept_filename_regex");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "default_player_id");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player_id_list");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scraper_source_list");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "box_art_aspect_ratio_id");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_box_art_aspect_ratio");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_box_art_aspect_ratio");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "screen_aspect_ratio_id");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_screen_aspect_ratio");
                        int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_screen_aspect_ratio");
                        int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "items_sync_tree_uri_list");
                        int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "retro_achievements_console_id_list");
                        int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "position");
                        int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                        if (cursorQuery.moveToFirst()) {
                            try {
                                platformEntity = new PlatformEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.getInt(columnIndexOrThrow6) != 0, cursorQuery.getInt(columnIndexOrThrow7) != 0, cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8), cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9), cursorQuery.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow10)), cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11)), cursorQuery.getString(columnIndexOrThrow12), cursorQuery.getLong(columnIndexOrThrow13), PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(columnIndexOrThrow14)), PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(columnIndexOrThrow15)), cursorQuery.getInt(columnIndexOrThrow16), cursorQuery.getInt(columnIndexOrThrow17) != 0, cursorQuery.isNull(columnIndexOrThrow18) ? null : cursorQuery.getString(columnIndexOrThrow18), cursorQuery.getInt(columnIndexOrThrow19), cursorQuery.getInt(columnIndexOrThrow20) != 0, cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21), PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableUriList(cursorQuery.getString(columnIndexOrThrow22)), PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(columnIndexOrThrow23)), cursorQuery.getInt(columnIndexOrThrow24), cursorQuery.getString(columnIndexOrThrow25));
                            } catch (Throwable th) {
                                th = th;
                                cursorQuery.close();
                                throw th;
                            }
                        } else {
                            platformEntity = null;
                        }
                        cursorQuery.close();
                        return platformEntity;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public PlatformEntity selectByShortnameStatically(final String shortname) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        PlatformEntity platformEntity;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlatformEntity WHERE shortname = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, shortname);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "shortname");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_visible");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scrape_preview_media");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wallpaper_path");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_path");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_theme");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_on_theme");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accept_filename_regex");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "default_player_id");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player_id_list");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scraper_source_list");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "box_art_aspect_ratio_id");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_box_art_aspect_ratio");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_box_art_aspect_ratio");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "screen_aspect_ratio_id");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_screen_aspect_ratio");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_screen_aspect_ratio");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "items_sync_tree_uri_list");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "retro_achievements_console_id_list");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "position");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                    if (cursorQuery.moveToFirst()) {
                        try {
                            platformEntity = new PlatformEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.getInt(columnIndexOrThrow6) != 0, cursorQuery.getInt(columnIndexOrThrow7) != 0, cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8), cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9), cursorQuery.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow10)), cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11)), cursorQuery.getString(columnIndexOrThrow12), cursorQuery.getLong(columnIndexOrThrow13), this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(columnIndexOrThrow14)), this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(columnIndexOrThrow15)), cursorQuery.getInt(columnIndexOrThrow16), cursorQuery.getInt(columnIndexOrThrow17) != 0, cursorQuery.isNull(columnIndexOrThrow18) ? null : cursorQuery.getString(columnIndexOrThrow18), cursorQuery.getInt(columnIndexOrThrow19), cursorQuery.getInt(columnIndexOrThrow20) != 0, cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21), this.__roomDatabaseConverters.toMutableUriList(cursorQuery.getString(columnIndexOrThrow22)), this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(columnIndexOrThrow23)), cursorQuery.getInt(columnIndexOrThrow24), cursorQuery.getString(columnIndexOrThrow25));
                        } catch (Throwable th) {
                            th = th;
                            cursorQuery.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    } else {
                        platformEntity = null;
                    }
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    return platformEntity;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public LiveData<PlatformEntity> selectByUniqueId(final String uniqueId) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlatformEntity WHERE unique_id = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, uniqueId);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PlatformEntity"}, false, new Callable<PlatformEntity>() { // from class: com.magneticchen.daijishou.data.db.dao.PlatformDAO_Impl.13
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public PlatformEntity call() throws Exception {
                PlatformEntity platformEntity;
                Cursor cursorQuery = DBUtil.query(PlatformDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "shortname");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_visible");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scrape_preview_media");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wallpaper_path");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_path");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_theme");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_on_theme");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accept_filename_regex");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "default_player_id");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player_id_list");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scraper_source_list");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "box_art_aspect_ratio_id");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_box_art_aspect_ratio");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_box_art_aspect_ratio");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "screen_aspect_ratio_id");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_screen_aspect_ratio");
                        int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_screen_aspect_ratio");
                        int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "items_sync_tree_uri_list");
                        int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "retro_achievements_console_id_list");
                        int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "position");
                        int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                        if (cursorQuery.moveToFirst()) {
                            try {
                                platformEntity = new PlatformEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.getInt(columnIndexOrThrow6) != 0, cursorQuery.getInt(columnIndexOrThrow7) != 0, cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8), cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9), cursorQuery.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow10)), cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11)), cursorQuery.getString(columnIndexOrThrow12), cursorQuery.getLong(columnIndexOrThrow13), PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(columnIndexOrThrow14)), PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(columnIndexOrThrow15)), cursorQuery.getInt(columnIndexOrThrow16), cursorQuery.getInt(columnIndexOrThrow17) != 0, cursorQuery.isNull(columnIndexOrThrow18) ? null : cursorQuery.getString(columnIndexOrThrow18), cursorQuery.getInt(columnIndexOrThrow19), cursorQuery.getInt(columnIndexOrThrow20) != 0, cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21), PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableUriList(cursorQuery.getString(columnIndexOrThrow22)), PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(columnIndexOrThrow23)), cursorQuery.getInt(columnIndexOrThrow24), cursorQuery.getString(columnIndexOrThrow25));
                            } catch (Throwable th) {
                                th = th;
                                cursorQuery.close();
                                throw th;
                            }
                        } else {
                            platformEntity = null;
                        }
                        cursorQuery.close();
                        return platformEntity;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public PlatformEntity selectByUniqueIdStatically(final String uniqueId) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        PlatformEntity platformEntity;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlatformEntity WHERE unique_id = ?", 1);
        roomSQLiteQueryAcquire.bindString(1, uniqueId);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "shortname");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_visible");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scrape_preview_media");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wallpaper_path");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_path");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_theme");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_on_theme");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accept_filename_regex");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "default_player_id");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player_id_list");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scraper_source_list");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "box_art_aspect_ratio_id");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_box_art_aspect_ratio");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_box_art_aspect_ratio");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "screen_aspect_ratio_id");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_screen_aspect_ratio");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_screen_aspect_ratio");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "items_sync_tree_uri_list");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "retro_achievements_console_id_list");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "position");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                    if (cursorQuery.moveToFirst()) {
                        try {
                            platformEntity = new PlatformEntity(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.getInt(columnIndexOrThrow6) != 0, cursorQuery.getInt(columnIndexOrThrow7) != 0, cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8), cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9), cursorQuery.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow10)), cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11)), cursorQuery.getString(columnIndexOrThrow12), cursorQuery.getLong(columnIndexOrThrow13), this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(columnIndexOrThrow14)), this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(columnIndexOrThrow15)), cursorQuery.getInt(columnIndexOrThrow16), cursorQuery.getInt(columnIndexOrThrow17) != 0, cursorQuery.isNull(columnIndexOrThrow18) ? null : cursorQuery.getString(columnIndexOrThrow18), cursorQuery.getInt(columnIndexOrThrow19), cursorQuery.getInt(columnIndexOrThrow20) != 0, cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21), this.__roomDatabaseConverters.toMutableUriList(cursorQuery.getString(columnIndexOrThrow22)), this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(columnIndexOrThrow23)), cursorQuery.getInt(columnIndexOrThrow24), cursorQuery.getString(columnIndexOrThrow25));
                        } catch (Throwable th) {
                            th = th;
                            cursorQuery.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    } else {
                        platformEntity = null;
                    }
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    return platformEntity;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public LiveData<List<PlatformEntity>> findWithName(final String search) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlatformEntity WHERE name LIKE '%' || ? || '%' ORDER BY name COLLATE NOCASE ASC", 1);
        roomSQLiteQueryAcquire.bindString(1, search);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PlatformEntity"}, false, new Callable<List<PlatformEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.PlatformDAO_Impl.14
            @Override // java.util.concurrent.Callable
            public List<PlatformEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(PlatformDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "shortname");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_visible");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scrape_preview_media");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wallpaper_path");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_path");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_theme");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_on_theme");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accept_filename_regex");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "default_player_id");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player_id_list");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scraper_source_list");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "box_art_aspect_ratio_id");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_box_art_aspect_ratio");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_box_art_aspect_ratio");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "screen_aspect_ratio_id");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_screen_aspect_ratio");
                        int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_screen_aspect_ratio");
                        int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "items_sync_tree_uri_list");
                        int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "retro_achievements_console_id_list");
                        int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "position");
                        int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                        int i = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            long j = cursorQuery.getLong(columnIndexOrThrow);
                            String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                            String string2 = cursorQuery.getString(columnIndexOrThrow3);
                            String string3 = cursorQuery.getString(columnIndexOrThrow4);
                            String string4 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                            boolean z = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                            boolean z2 = cursorQuery.getInt(columnIndexOrThrow7) != 0;
                            String string5 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                            String string6 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                            Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow10));
                            Integer numValueOf2 = cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11));
                            String string7 = cursorQuery.getString(columnIndexOrThrow12);
                            long j2 = cursorQuery.getLong(columnIndexOrThrow13);
                            int i2 = i;
                            int i3 = columnIndexOrThrow;
                            int i4 = columnIndexOrThrow13;
                            try {
                                List<Long> mutableLongList = PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(i2));
                                int i5 = columnIndexOrThrow15;
                                columnIndexOrThrow15 = i5;
                                List<String> mutableStringList = PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(i5));
                                int i6 = columnIndexOrThrow16;
                                int i7 = cursorQuery.getInt(i6);
                                columnIndexOrThrow17 = columnIndexOrThrow17;
                                boolean z3 = cursorQuery.getInt(columnIndexOrThrow17) != 0;
                                columnIndexOrThrow16 = i6;
                                int i8 = columnIndexOrThrow18;
                                String string8 = cursorQuery.isNull(i8) ? null : cursorQuery.getString(i8);
                                columnIndexOrThrow18 = i8;
                                int i9 = columnIndexOrThrow19;
                                int i10 = cursorQuery.getInt(i9);
                                columnIndexOrThrow19 = i9;
                                int i11 = columnIndexOrThrow20;
                                boolean z4 = cursorQuery.getInt(i11) != 0;
                                columnIndexOrThrow20 = i11;
                                columnIndexOrThrow21 = columnIndexOrThrow21;
                                String string9 = cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21);
                                String string10 = cursorQuery.getString(columnIndexOrThrow22);
                                columnIndexOrThrow22 = columnIndexOrThrow22;
                                List<Uri> mutableUriList = PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableUriList(string10);
                                int i12 = columnIndexOrThrow23;
                                columnIndexOrThrow23 = i12;
                                List<Long> mutableLongList2 = PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(i12));
                                int i13 = columnIndexOrThrow24;
                                int i14 = columnIndexOrThrow25;
                                columnIndexOrThrow24 = i13;
                                arrayList.add(new PlatformEntity(j, string, string2, string3, string4, z, z2, string5, string6, numValueOf, numValueOf2, string7, j2, mutableLongList, mutableStringList, i7, z3, string8, i10, z4, string9, mutableUriList, mutableLongList2, cursorQuery.getInt(i13), cursorQuery.getString(i14)));
                                columnIndexOrThrow25 = i14;
                                columnIndexOrThrow = i3;
                                columnIndexOrThrow13 = i4;
                                i = i2;
                            } catch (Throwable th) {
                                th = th;
                                cursorQuery.close();
                                throw th;
                            }
                        }
                        cursorQuery.close();
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public List<PlatformEntity> findWithNameStatically(final String search) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlatformEntity WHERE name LIKE '%' || ? || '%' ORDER BY name COLLATE NOCASE ASC", 1);
        roomSQLiteQueryAcquire.bindString(1, search);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "shortname");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_visible");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scrape_preview_media");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wallpaper_path");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_path");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_theme");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_on_theme");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accept_filename_regex");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "default_player_id");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player_id_list");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scraper_source_list");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "box_art_aspect_ratio_id");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_box_art_aspect_ratio");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_box_art_aspect_ratio");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "screen_aspect_ratio_id");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_screen_aspect_ratio");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_screen_aspect_ratio");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "items_sync_tree_uri_list");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "retro_achievements_console_id_list");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "position");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                    int i = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        long j = cursorQuery.getLong(columnIndexOrThrow);
                        String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string2 = cursorQuery.getString(columnIndexOrThrow3);
                        String string3 = cursorQuery.getString(columnIndexOrThrow4);
                        String string4 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        boolean z = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                        boolean z2 = cursorQuery.getInt(columnIndexOrThrow7) != 0;
                        String string5 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                        String string6 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                        Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow10));
                        Integer numValueOf2 = cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11));
                        String string7 = cursorQuery.getString(columnIndexOrThrow12);
                        long j2 = cursorQuery.getLong(columnIndexOrThrow13);
                        int i2 = i;
                        int i3 = columnIndexOrThrow;
                        int i4 = columnIndexOrThrow11;
                        try {
                            List<Long> mutableLongList = this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(i2));
                            int i5 = columnIndexOrThrow15;
                            columnIndexOrThrow15 = i5;
                            List<String> mutableStringList = this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(i5));
                            int i6 = columnIndexOrThrow16;
                            int i7 = cursorQuery.getInt(i6);
                            columnIndexOrThrow17 = columnIndexOrThrow17;
                            boolean z3 = cursorQuery.getInt(columnIndexOrThrow17) != 0;
                            columnIndexOrThrow16 = i6;
                            int i8 = columnIndexOrThrow18;
                            String string8 = cursorQuery.isNull(i8) ? null : cursorQuery.getString(i8);
                            columnIndexOrThrow18 = i8;
                            int i9 = columnIndexOrThrow19;
                            int i10 = cursorQuery.getInt(i9);
                            columnIndexOrThrow19 = i9;
                            int i11 = columnIndexOrThrow20;
                            boolean z4 = cursorQuery.getInt(i11) != 0;
                            columnIndexOrThrow20 = i11;
                            columnIndexOrThrow21 = columnIndexOrThrow21;
                            String string9 = cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21);
                            String string10 = cursorQuery.getString(columnIndexOrThrow22);
                            columnIndexOrThrow22 = columnIndexOrThrow22;
                            List<Uri> mutableUriList = this.__roomDatabaseConverters.toMutableUriList(string10);
                            int i12 = columnIndexOrThrow23;
                            columnIndexOrThrow23 = i12;
                            List<Long> mutableLongList2 = this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(i12));
                            int i13 = columnIndexOrThrow24;
                            int i14 = columnIndexOrThrow25;
                            columnIndexOrThrow24 = i13;
                            arrayList.add(new PlatformEntity(j, string, string2, string3, string4, z, z2, string5, string6, numValueOf, numValueOf2, string7, j2, mutableLongList, mutableStringList, i7, z3, string8, i10, z4, string9, mutableUriList, mutableLongList2, cursorQuery.getInt(i13), cursorQuery.getString(i14)));
                            columnIndexOrThrow25 = i14;
                            columnIndexOrThrow = i3;
                            columnIndexOrThrow11 = i4;
                            i = i2;
                        } catch (Throwable th) {
                            th = th;
                            cursorQuery.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    }
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public LiveData<List<PlatformEntity>> findWithShortName(final String search) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlatformEntity WHERE shortname LIKE '%' || ? || '%' ORDER BY name COLLATE NOCASE ASC", 1);
        roomSQLiteQueryAcquire.bindString(1, search);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PlatformEntity"}, false, new Callable<List<PlatformEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.PlatformDAO_Impl.15
            @Override // java.util.concurrent.Callable
            public List<PlatformEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(PlatformDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "shortname");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_visible");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scrape_preview_media");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wallpaper_path");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_path");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_theme");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_on_theme");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accept_filename_regex");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "default_player_id");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player_id_list");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scraper_source_list");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "box_art_aspect_ratio_id");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_box_art_aspect_ratio");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_box_art_aspect_ratio");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "screen_aspect_ratio_id");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_screen_aspect_ratio");
                        int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_screen_aspect_ratio");
                        int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "items_sync_tree_uri_list");
                        int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "retro_achievements_console_id_list");
                        int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "position");
                        int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                        int i = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            long j = cursorQuery.getLong(columnIndexOrThrow);
                            String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                            String string2 = cursorQuery.getString(columnIndexOrThrow3);
                            String string3 = cursorQuery.getString(columnIndexOrThrow4);
                            String string4 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                            boolean z = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                            boolean z2 = cursorQuery.getInt(columnIndexOrThrow7) != 0;
                            String string5 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                            String string6 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                            Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow10));
                            Integer numValueOf2 = cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11));
                            String string7 = cursorQuery.getString(columnIndexOrThrow12);
                            long j2 = cursorQuery.getLong(columnIndexOrThrow13);
                            int i2 = i;
                            int i3 = columnIndexOrThrow;
                            int i4 = columnIndexOrThrow13;
                            try {
                                List<Long> mutableLongList = PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(i2));
                                int i5 = columnIndexOrThrow15;
                                columnIndexOrThrow15 = i5;
                                List<String> mutableStringList = PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(i5));
                                int i6 = columnIndexOrThrow16;
                                int i7 = cursorQuery.getInt(i6);
                                columnIndexOrThrow17 = columnIndexOrThrow17;
                                boolean z3 = cursorQuery.getInt(columnIndexOrThrow17) != 0;
                                columnIndexOrThrow16 = i6;
                                int i8 = columnIndexOrThrow18;
                                String string8 = cursorQuery.isNull(i8) ? null : cursorQuery.getString(i8);
                                columnIndexOrThrow18 = i8;
                                int i9 = columnIndexOrThrow19;
                                int i10 = cursorQuery.getInt(i9);
                                columnIndexOrThrow19 = i9;
                                int i11 = columnIndexOrThrow20;
                                boolean z4 = cursorQuery.getInt(i11) != 0;
                                columnIndexOrThrow20 = i11;
                                columnIndexOrThrow21 = columnIndexOrThrow21;
                                String string9 = cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21);
                                String string10 = cursorQuery.getString(columnIndexOrThrow22);
                                columnIndexOrThrow22 = columnIndexOrThrow22;
                                List<Uri> mutableUriList = PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableUriList(string10);
                                int i12 = columnIndexOrThrow23;
                                columnIndexOrThrow23 = i12;
                                List<Long> mutableLongList2 = PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(i12));
                                int i13 = columnIndexOrThrow24;
                                int i14 = columnIndexOrThrow25;
                                columnIndexOrThrow24 = i13;
                                arrayList.add(new PlatformEntity(j, string, string2, string3, string4, z, z2, string5, string6, numValueOf, numValueOf2, string7, j2, mutableLongList, mutableStringList, i7, z3, string8, i10, z4, string9, mutableUriList, mutableLongList2, cursorQuery.getInt(i13), cursorQuery.getString(i14)));
                                columnIndexOrThrow25 = i14;
                                columnIndexOrThrow = i3;
                                columnIndexOrThrow13 = i4;
                                i = i2;
                            } catch (Throwable th) {
                                th = th;
                                cursorQuery.close();
                                throw th;
                            }
                        }
                        cursorQuery.close();
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public List<PlatformEntity> findWithShortNameStatically(final String search) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlatformEntity WHERE shortname LIKE '%' || ? || '%' ORDER BY name COLLATE NOCASE ASC", 1);
        roomSQLiteQueryAcquire.bindString(1, search);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "shortname");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_visible");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scrape_preview_media");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wallpaper_path");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_path");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_theme");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_on_theme");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accept_filename_regex");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "default_player_id");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player_id_list");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scraper_source_list");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "box_art_aspect_ratio_id");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_box_art_aspect_ratio");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_box_art_aspect_ratio");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "screen_aspect_ratio_id");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_screen_aspect_ratio");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_screen_aspect_ratio");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "items_sync_tree_uri_list");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "retro_achievements_console_id_list");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "position");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                    int i = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        long j = cursorQuery.getLong(columnIndexOrThrow);
                        String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string2 = cursorQuery.getString(columnIndexOrThrow3);
                        String string3 = cursorQuery.getString(columnIndexOrThrow4);
                        String string4 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        boolean z = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                        boolean z2 = cursorQuery.getInt(columnIndexOrThrow7) != 0;
                        String string5 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                        String string6 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                        Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow10));
                        Integer numValueOf2 = cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11));
                        String string7 = cursorQuery.getString(columnIndexOrThrow12);
                        long j2 = cursorQuery.getLong(columnIndexOrThrow13);
                        int i2 = i;
                        int i3 = columnIndexOrThrow;
                        int i4 = columnIndexOrThrow11;
                        try {
                            List<Long> mutableLongList = this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(i2));
                            int i5 = columnIndexOrThrow15;
                            columnIndexOrThrow15 = i5;
                            List<String> mutableStringList = this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(i5));
                            int i6 = columnIndexOrThrow16;
                            int i7 = cursorQuery.getInt(i6);
                            columnIndexOrThrow17 = columnIndexOrThrow17;
                            boolean z3 = cursorQuery.getInt(columnIndexOrThrow17) != 0;
                            columnIndexOrThrow16 = i6;
                            int i8 = columnIndexOrThrow18;
                            String string8 = cursorQuery.isNull(i8) ? null : cursorQuery.getString(i8);
                            columnIndexOrThrow18 = i8;
                            int i9 = columnIndexOrThrow19;
                            int i10 = cursorQuery.getInt(i9);
                            columnIndexOrThrow19 = i9;
                            int i11 = columnIndexOrThrow20;
                            boolean z4 = cursorQuery.getInt(i11) != 0;
                            columnIndexOrThrow20 = i11;
                            columnIndexOrThrow21 = columnIndexOrThrow21;
                            String string9 = cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21);
                            String string10 = cursorQuery.getString(columnIndexOrThrow22);
                            columnIndexOrThrow22 = columnIndexOrThrow22;
                            List<Uri> mutableUriList = this.__roomDatabaseConverters.toMutableUriList(string10);
                            int i12 = columnIndexOrThrow23;
                            columnIndexOrThrow23 = i12;
                            List<Long> mutableLongList2 = this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(i12));
                            int i13 = columnIndexOrThrow24;
                            int i14 = columnIndexOrThrow25;
                            columnIndexOrThrow24 = i13;
                            arrayList.add(new PlatformEntity(j, string, string2, string3, string4, z, z2, string5, string6, numValueOf, numValueOf2, string7, j2, mutableLongList, mutableStringList, i7, z3, string8, i10, z4, string9, mutableUriList, mutableLongList2, cursorQuery.getInt(i13), cursorQuery.getString(i14)));
                            columnIndexOrThrow25 = i14;
                            columnIndexOrThrow = i3;
                            columnIndexOrThrow11 = i4;
                            i = i2;
                        } catch (Throwable th) {
                            th = th;
                            cursorQuery.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    }
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public LiveData<List<PlatformEntity>> findWithBothNameAndShortName(final String search) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlatformEntity WHERE name LIKE '%' || ? || '%' OR shortname LIKE '%' || ? || '%' ORDER BY name COLLATE NOCASE ASC", 2);
        roomSQLiteQueryAcquire.bindString(1, search);
        roomSQLiteQueryAcquire.bindString(2, search);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PlatformEntity"}, false, new Callable<List<PlatformEntity>>() { // from class: com.magneticchen.daijishou.data.db.dao.PlatformDAO_Impl.16
            @Override // java.util.concurrent.Callable
            public List<PlatformEntity> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(PlatformDAO_Impl.this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "shortname");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_visible");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scrape_preview_media");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wallpaper_path");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_path");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_theme");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_on_theme");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accept_filename_regex");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "default_player_id");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player_id_list");
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scraper_source_list");
                        int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "box_art_aspect_ratio_id");
                        int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_box_art_aspect_ratio");
                        int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_box_art_aspect_ratio");
                        int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "screen_aspect_ratio_id");
                        int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_screen_aspect_ratio");
                        int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_screen_aspect_ratio");
                        int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "items_sync_tree_uri_list");
                        int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "retro_achievements_console_id_list");
                        int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "position");
                        int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                        int i = columnIndexOrThrow14;
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            long j = cursorQuery.getLong(columnIndexOrThrow);
                            String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                            String string2 = cursorQuery.getString(columnIndexOrThrow3);
                            String string3 = cursorQuery.getString(columnIndexOrThrow4);
                            String string4 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                            boolean z = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                            boolean z2 = cursorQuery.getInt(columnIndexOrThrow7) != 0;
                            String string5 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                            String string6 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                            Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow10));
                            Integer numValueOf2 = cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11));
                            String string7 = cursorQuery.getString(columnIndexOrThrow12);
                            long j2 = cursorQuery.getLong(columnIndexOrThrow13);
                            int i2 = i;
                            int i3 = columnIndexOrThrow;
                            int i4 = columnIndexOrThrow13;
                            try {
                                List<Long> mutableLongList = PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(i2));
                                int i5 = columnIndexOrThrow15;
                                columnIndexOrThrow15 = i5;
                                List<String> mutableStringList = PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(i5));
                                int i6 = columnIndexOrThrow16;
                                int i7 = cursorQuery.getInt(i6);
                                columnIndexOrThrow17 = columnIndexOrThrow17;
                                boolean z3 = cursorQuery.getInt(columnIndexOrThrow17) != 0;
                                columnIndexOrThrow16 = i6;
                                int i8 = columnIndexOrThrow18;
                                String string8 = cursorQuery.isNull(i8) ? null : cursorQuery.getString(i8);
                                columnIndexOrThrow18 = i8;
                                int i9 = columnIndexOrThrow19;
                                int i10 = cursorQuery.getInt(i9);
                                columnIndexOrThrow19 = i9;
                                int i11 = columnIndexOrThrow20;
                                boolean z4 = cursorQuery.getInt(i11) != 0;
                                columnIndexOrThrow20 = i11;
                                columnIndexOrThrow21 = columnIndexOrThrow21;
                                String string9 = cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21);
                                String string10 = cursorQuery.getString(columnIndexOrThrow22);
                                columnIndexOrThrow22 = columnIndexOrThrow22;
                                List<Uri> mutableUriList = PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableUriList(string10);
                                int i12 = columnIndexOrThrow23;
                                columnIndexOrThrow23 = i12;
                                List<Long> mutableLongList2 = PlatformDAO_Impl.this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(i12));
                                int i13 = columnIndexOrThrow24;
                                int i14 = columnIndexOrThrow25;
                                columnIndexOrThrow24 = i13;
                                arrayList.add(new PlatformEntity(j, string, string2, string3, string4, z, z2, string5, string6, numValueOf, numValueOf2, string7, j2, mutableLongList, mutableStringList, i7, z3, string8, i10, z4, string9, mutableUriList, mutableLongList2, cursorQuery.getInt(i13), cursorQuery.getString(i14)));
                                columnIndexOrThrow25 = i14;
                                columnIndexOrThrow = i3;
                                columnIndexOrThrow13 = i4;
                                i = i2;
                            } catch (Throwable th) {
                                th = th;
                                cursorQuery.close();
                                throw th;
                            }
                        }
                        cursorQuery.close();
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }

            protected void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.magneticchen.daijishou.data.db.dao.PlatformDAO
    public List<PlatformEntity> findWithBothNameAndShortNameStatically(final String search) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PlatformEntity WHERE name LIKE '%' || ? || '%' OR shortname LIKE '%' || ? || '%' ORDER BY name COLLATE NOCASE ASC", 2);
        roomSQLiteQueryAcquire.bindString(1, search);
        roomSQLiteQueryAcquire.bindString(2, search);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "unique_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "shortname");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_visible");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scrape_preview_media");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wallpaper_path");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_path");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_theme");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "color_on_theme");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accept_filename_regex");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "default_player_id");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "player_id_list");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "scraper_source_list");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "box_art_aspect_ratio_id");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_box_art_aspect_ratio");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_box_art_aspect_ratio");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "screen_aspect_ratio_id");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "use_custom_screen_aspect_ratio");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "custom_screen_aspect_ratio");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "items_sync_tree_uri_list");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "retro_achievements_console_id_list");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "position");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
                    int i = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        long j = cursorQuery.getLong(columnIndexOrThrow);
                        String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        String string2 = cursorQuery.getString(columnIndexOrThrow3);
                        String string3 = cursorQuery.getString(columnIndexOrThrow4);
                        String string4 = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                        boolean z = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                        boolean z2 = cursorQuery.getInt(columnIndexOrThrow7) != 0;
                        String string5 = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                        String string6 = cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9);
                        Integer numValueOf = cursorQuery.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow10));
                        Integer numValueOf2 = cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11));
                        String string7 = cursorQuery.getString(columnIndexOrThrow12);
                        long j2 = cursorQuery.getLong(columnIndexOrThrow13);
                        int i2 = i;
                        int i3 = columnIndexOrThrow;
                        int i4 = columnIndexOrThrow11;
                        try {
                            List<Long> mutableLongList = this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(i2));
                            int i5 = columnIndexOrThrow15;
                            columnIndexOrThrow15 = i5;
                            List<String> mutableStringList = this.__roomDatabaseConverters.toMutableStringList(cursorQuery.getString(i5));
                            int i6 = columnIndexOrThrow16;
                            int i7 = cursorQuery.getInt(i6);
                            columnIndexOrThrow17 = columnIndexOrThrow17;
                            boolean z3 = cursorQuery.getInt(columnIndexOrThrow17) != 0;
                            columnIndexOrThrow16 = i6;
                            int i8 = columnIndexOrThrow18;
                            String string8 = cursorQuery.isNull(i8) ? null : cursorQuery.getString(i8);
                            columnIndexOrThrow18 = i8;
                            int i9 = columnIndexOrThrow19;
                            int i10 = cursorQuery.getInt(i9);
                            columnIndexOrThrow19 = i9;
                            int i11 = columnIndexOrThrow20;
                            boolean z4 = cursorQuery.getInt(i11) != 0;
                            columnIndexOrThrow20 = i11;
                            columnIndexOrThrow21 = columnIndexOrThrow21;
                            String string9 = cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21);
                            String string10 = cursorQuery.getString(columnIndexOrThrow22);
                            columnIndexOrThrow22 = columnIndexOrThrow22;
                            List<Uri> mutableUriList = this.__roomDatabaseConverters.toMutableUriList(string10);
                            int i12 = columnIndexOrThrow23;
                            columnIndexOrThrow23 = i12;
                            List<Long> mutableLongList2 = this.__roomDatabaseConverters.toMutableLongList(cursorQuery.getString(i12));
                            int i13 = columnIndexOrThrow24;
                            int i14 = columnIndexOrThrow25;
                            columnIndexOrThrow24 = i13;
                            arrayList.add(new PlatformEntity(j, string, string2, string3, string4, z, z2, string5, string6, numValueOf, numValueOf2, string7, j2, mutableLongList, mutableStringList, i7, z3, string8, i10, z4, string9, mutableUriList, mutableLongList2, cursorQuery.getInt(i13), cursorQuery.getString(i14)));
                            columnIndexOrThrow25 = i14;
                            columnIndexOrThrow = i3;
                            i = i2;
                            columnIndexOrThrow11 = i4;
                        } catch (Throwable th) {
                            th = th;
                            cursorQuery.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    }
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
