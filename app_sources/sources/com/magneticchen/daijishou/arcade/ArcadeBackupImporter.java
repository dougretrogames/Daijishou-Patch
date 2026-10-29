package com.magneticchen.daijishou.arcade;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Xml;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArcadeBackupImporter {

    private static final String TAG = "ArcadeBackupImporter";

    public interface OnImportListener {
        void onProgress(String message, int current, int total);
        void onSuccess(int platformsCount, int gamesCount);
        void onError(String error);
    }

    private static class PlatformInfo {
        long platformId;
        String name;
        String shortname;
        String romDirectory;

        PlatformInfo(long platformId, String name, String shortname, String romDirectory) {
            this.platformId = platformId;
            this.name = name;
            this.shortname = shortname;
            this.romDirectory = romDirectory;
        }
    }

    /**
     * Searches standard locations for ARC Browser export TAR files.
     */
    public static List<File> findKnownBackupFiles() {
        List<File> result = new ArrayList<>();
        File storage = Environment.getExternalStorageDirectory();

        File[] searchDirs = new File[] {
            new File(storage, "Download"),
            new File(storage, "Downloads"),
            new File(storage, "Daijishou"),
            new File(storage, "2-Jogos"),
            storage
        };

        for (File dir : searchDirs) {
            if (dir.exists() && dir.isDirectory()) {
                File[] files = dir.listFiles();
                if (files != null) {
                    for (File f : files) {
                        if (f.isFile() && f.getName().toLowerCase().endsWith(".tar")) {
                            String lower = f.getName().toLowerCase();
                            if (lower.contains("arc") || lower.contains("bkp") || lower.contains("browser") || lower.contains("memoria") || lower.contains("export")) {
                                result.add(f);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * Prompts the user with detected backup files or lets them pick one.
     */
    public static void promptOrAutoImport(final androidx.fragment.app.Fragment fragment, final Runnable onComplete) {
        if (fragment == null || fragment.getActivity() == null || fragment.getActivity().isFinishing()) return;

        final Activity activity = fragment.getActivity();
        final List<File> knownFiles = findKnownBackupFiles();

        List<String> options = new ArrayList<>();
        for (File f : knownFiles) {
            long sizeMb = f.length() / (1024 * 1024);
            options.add(f.getName() + " (" + sizeMb + " MB)");
        }
        options.add("Escolher outro arquivo (.tar)...");

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Importar Backup do ARC Browser");

        CharSequence[] items = options.toArray(new CharSequence[0]);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which < knownFiles.size()) {
                    // Import selected file directly
                    File selected = knownFiles.get(which);
                    importFromFile(activity, selected, onComplete);
                } else {
                    // Open system document picker
                    openFilePicker(fragment);
                }
            }
        });
        builder.setNegativeButton("Cancelar", null);
        builder.show();
    }

    public static void openFilePicker(androidx.fragment.app.Fragment fragment) {
        try {
            Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("*/*");
            fragment.startActivityForResult(intent, 9924);
        } catch (Exception e) {
            try {
                Intent fallback = new Intent(Intent.ACTION_GET_CONTENT);
                fallback.setType("*/*");
                fragment.startActivityForResult(fallback, 9924);
            } catch (Exception ex) {
                if (fragment.getContext() != null) {
                    Toast.makeText(fragment.getContext(), "Não foi possível abrir o seletor de arquivos.", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    /**
     * Prompts the user with detected backup files or lets them pick one (Activity variant).
     */
    public static void promptOrAutoImport(final Activity activity, final Runnable onComplete) {
        if (activity == null || activity.isFinishing()) return;

        final List<File> knownFiles = findKnownBackupFiles();

        List<String> options = new ArrayList<>();
        for (File f : knownFiles) {
            long sizeMb = f.length() / (1024 * 1024);
            options.add(f.getName() + " (" + sizeMb + " MB)");
        }
        options.add("Escolher outro arquivo (.tar)...");

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Importar Backup do ARC Browser");

        CharSequence[] items = options.toArray(new CharSequence[0]);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which < knownFiles.size()) {
                    // Import selected file directly
                    File selected = knownFiles.get(which);
                    importFromFile(activity, selected, onComplete);
                } else {
                    // Open system document picker
                    openFilePicker(activity);
                }
            }
        });
        builder.setNegativeButton("Cancelar", null);
        builder.show();
    }

    public static void openFilePicker(Activity activity) {
        try {
            Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("*/*");
            activity.startActivityForResult(intent, 9924);
        } catch (Exception e) {
            try {
                Intent fallback = new Intent(Intent.ACTION_GET_CONTENT);
                fallback.setType("*/*");
                activity.startActivityForResult(fallback, 9924);
            } catch (Exception ex) {
                Toast.makeText(activity, "Não foi possível abrir o seletor de arquivos.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static void importFromFile(final Activity activity, final File tarFile, final Runnable onComplete) {
        if (tarFile == null || !tarFile.exists()) {
            Toast.makeText(activity, "Arquivo de backup não encontrado.", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            FileInputStream fis = new FileInputStream(tarFile);
            importFromInputStream(activity, fis, tarFile.getName(), onComplete);
        } catch (Exception e) {
            Toast.makeText(activity, "Erro ao abrir arquivo: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public static void importFromUri(final Activity activity, final Uri uri, final Runnable onComplete) {
        if (uri == null) return;
        try {
            InputStream is = activity.getContentResolver().openInputStream(uri);
            if (is == null) {
                Toast.makeText(activity, "Não foi possível ler o arquivo selecionado.", Toast.LENGTH_SHORT).show();
                return;
            }
            importFromInputStream(activity, is, "backup.tar", onComplete);
        } catch (Exception e) {
            Toast.makeText(activity, "Erro ao ler arquivo: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public static void importFromInputStream(final Activity activity, final InputStream rawInputStream, final String fileName, final Runnable onComplete) {
        final ProgressDialog progressDialog = new ProgressDialog(activity);
        progressDialog.setTitle("Importando Backup do ARC Browser");
        progressDialog.setMessage("Descompactando e analisando dados...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.show();

        final Handler mainHandler = new Handler(Looper.getMainLooper());

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    doImport(activity, rawInputStream, new OnImportListener() {
                        @Override
                        public void onProgress(final String message, final int current, final int total) {
                            mainHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if (progressDialog.isShowing()) {
                                        progressDialog.setMessage(message);
                                        if (total > 0) {
                                            progressDialog.setMax(total);
                                            progressDialog.setProgress(current);
                                        }
                                    }
                                }
                            });
                        }

                        @Override
                        public void onSuccess(final int platformsCount, final int gamesCount) {
                            mainHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if (progressDialog.isShowing()) progressDialog.dismiss();
                                    new AlertDialog.Builder(activity)
                                        .setTitle("Importação Concluída")
                                        .setMessage("O backup do ARC Browser foi importado com sucesso!\n\n"
                                            + "• Plataformas importadas: " + platformsCount + "\n"
                                            + "• Jogos importados: " + gamesCount + "\n\n"
                                            + "Todos os jogos e coleções já estão prontos para jogar.")
                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                if (onComplete != null) onComplete.run();
                                            }
                                        })
                                        .show();
                                }
                            });
                        }

                        @Override
                        public void onError(final String error) {
                            mainHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if (progressDialog.isShowing()) progressDialog.dismiss();
                                    new AlertDialog.Builder(activity)
                                        .setTitle("Erro na Importação")
                                        .setMessage("Ocorreu uma falha ao importar o backup:\n" + error)
                                        .setPositiveButton("OK", null)
                                        .show();
                                }
                            });
                        }
                    });
                } catch (final Throwable t) {
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (progressDialog.isShowing()) progressDialog.dismiss();
                            Toast.makeText(activity, "Erro: " + t.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
    }

    private static void doImport(Context context, InputStream tarStream, OnImportListener listener) throws Exception {
        listener.onProgress("Extraindo arquivos do backup...", 0, 100);

        File cacheDir = new File(context.getCacheDir(), "arc_import_temp");
        if (cacheDir.exists()) {
            deleteRecursive(cacheDir);
        }
        cacheDir.mkdirs();

        // 1. Extract tar entries
        BufferedInputStream bis = new BufferedInputStream(tarStream, 65536);
        byte[] header = new byte[512];

        File emulatorsFile = null;
        File gamesFile = null;
        File collectionsFile = null;

        while (true) {
            int read = readFully(bis, header, 0, 512);
            if (read < 512 || isAllZero(header)) {
                break;
            }

            String entryName = parseTarString(header, 0, 100);
            long entrySize = parseTarOctal(header, 124, 12);
            long padding = (512 - (entrySize % 512)) % 512;

            if ("emulators.xml".equalsIgnoreCase(entryName) || entryName.endsWith("/emulators.xml")) {
                emulatorsFile = new File(cacheDir, "emulators.xml");
                extractEntryToFile(bis, entrySize, emulatorsFile);
            } else if ("games.xml".equalsIgnoreCase(entryName) || entryName.endsWith("/games.xml")) {
                gamesFile = new File(cacheDir, "games.xml");
                extractEntryToFile(bis, entrySize, gamesFile);
            } else if ("collections.xml".equalsIgnoreCase(entryName) || entryName.endsWith("/collections.xml")) {
                collectionsFile = new File(cacheDir, "collections.xml");
                extractEntryToFile(bis, entrySize, collectionsFile);
            } else {
                // Skip entry content
                skipFully(bis, entrySize);
            }

            // Skip tar padding block
            if (padding > 0) {
                skipFully(bis, padding);
            }
        }

        if (emulatorsFile == null || !emulatorsFile.exists() || gamesFile == null || !gamesFile.exists()) {
            throw new IllegalStateException("O arquivo .tar não contém os dados válidos do ARC Browser (emulators.xml ou games.xml ausentes).");
        }

        // 2. Open Daijishou Database
        File dbFile = context.getDatabasePath("Daijishou.db");
        if (!dbFile.exists()) {
            dbFile.getParentFile().mkdirs();
        }

        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(dbFile, null);

        try {
            // Ensure schema exists
            createSchemaIfNeeded(db);

            // 3. Parse Collections
            listener.onProgress("Processando coleções...", 10, 100);
            Map<String, List<String>> gameCollectionsMap = new HashMap<>();
            if (collectionsFile != null && collectionsFile.exists()) {
                parseCollections(collectionsFile, gameCollectionsMap);
            }

            // 4. Parse Emulators and insert platforms
            listener.onProgress("Configurando sistemas e plataformas...", 20, 100);
            Map<String, PlatformInfo> emulatorMap = parseAndInsertPlatforms(db, emulatorsFile);
            Log.i(TAG, "Mapeados " + emulatorMap.size() + " emuladores/sistemas do ARC Browser.");

            // 5. Parse Games and batch insert
            listener.onProgress("Importando jogos (isso levará apenas alguns segundos)...", 30, 100);
            int importedGames = parseAndInsertGames(db, gamesFile, emulatorMap, gameCollectionsMap, listener);
            Log.i(TAG, "Importados " + importedGames + " jogos para o Daijishou.");

            listener.onProgress("Finalizando importação...", 100, 100);
            listener.onSuccess(emulatorMap.size(), importedGames);

        } finally {
            if (db != null) db.close();
            deleteRecursive(cacheDir);
        }
    }

    private static Map<String, PlatformInfo> parseAndInsertPlatforms(SQLiteDatabase db, File emulatorsFile) throws Exception {
        Map<String, PlatformInfo> result = new HashMap<>();

        XmlPullParser parser = Xml.newPullParser();
        InputStreamReader reader = new InputStreamReader(new FileInputStream(emulatorsFile), StandardCharsets.UTF_8);
        parser.setInput(reader);

        int event = parser.getEventType();
        String currentEid = null;
        String currentKey = null;
        Map<String, String> currentData = new HashMap<>();
        int position = 0;
        boolean insideEmulator = false;
        boolean insideExtra = false;

        // Check max position existing in PlatformEntity
        Cursor posCursor = db.rawQuery("SELECT max(position) FROM PlatformEntity", null);
        if (posCursor != null && posCursor.moveToFirst()) {
            position = posCursor.getInt(0) + 1;
            posCursor.close();
        }

        while (event != XmlPullParser.END_DOCUMENT) {
            String tag = parser.getName();
            if (event == XmlPullParser.START_TAG) {
                if ("entry".equals(tag)) {
                    String type = parser.getAttributeValue(null, "type");
                    if ("emulator".equals(type)) {
                        insideEmulator = true;
                        insideExtra = false;
                        currentEid = parser.getAttributeValue(null, "id");
                        currentData.clear();
                    } else {
                        insideExtra = true;
                    }
                } else if ("data".equals(tag)) {
                    if (insideEmulator && !insideExtra) {
                        currentKey = parser.getAttributeValue(null, "key");
                    }
                }
            } else if (event == XmlPullParser.TEXT) {
                if (currentKey != null && currentEid != null && insideEmulator && !insideExtra) {
                    currentData.put(currentKey, parser.getText());
                }
            } else if (event == XmlPullParser.END_TAG) {
                if ("data".equals(tag)) {
                    currentKey = null;
                } else if ("entry".equals(tag)) {
                    if (insideExtra) {
                        insideExtra = false;
                    } else if (insideEmulator && currentEid != null) {
                        insideEmulator = false;
                        String romDir = currentData.get("romDirectory");
                        String name = currentData.get("name");
                        if (name == null || name.trim().isEmpty()) {
                            name = currentData.get("description");
                        }

                        if (romDir != null && !romDir.trim().isEmpty() && !"None".equalsIgnoreCase(romDir)) {
                            String folder = new File(romDir).getName();
                            String shortname = (folder != null && !folder.isEmpty()) ? folder : "unknown";

                            // Check if platform exists in DB
                            long pid = -1;
                            Cursor c = db.rawQuery("SELECT id FROM PlatformEntity WHERE shortname = ? OR name = ? LIMIT 1", new String[]{shortname, name});
                            if (c != null && c.moveToFirst()) {
                                pid = c.getLong(0);
                                c.close();
                            } else {
                                if (c != null) c.close();

                                // Insert new PlatformEntity
                                JSONArray syncTreeArr = new JSONArray();
                                syncTreeArr.put("file://" + romDir);

                                SQLiteStatement stmt = db.compileStatement(
                                    "INSERT INTO PlatformEntity (" +
                                    "name, shortname, is_visible, scrape_preview_media, " +
                                    "wallpaper_path, thumbnail_path, accept_filename_regex, " +
                                    "default_player_id, player_id_list, scraper_source_list, " +
                                    "box_art_aspect_ratio_id, use_custom_box_art_aspect_ratio, " +
                                    "screen_aspect_ratio_id, use_custom_screen_aspect_ratio, " +
                                    "items_sync_tree_uri_list, retro_achievements_console_id_list, " +
                                    "position, extra) " +
                                    "VALUES (?, ?, 1, 0, null, null, '.*', 0, '[]', '[]', 0, 0, 0, 0, ?, '[]', ?, '{}')"
                                );
                                stmt.bindString(1, name != null ? name : shortname);
                                stmt.bindString(2, shortname);
                                stmt.bindString(3, syncTreeArr.toString());
                                stmt.bindLong(4, position++);
                                pid = stmt.executeInsert();
                            }

                            if (pid > 0) {
                                result.put(currentEid, new PlatformInfo(pid, name, shortname, romDir));
                            }
                        }
                        currentEid = null;
                    }
                }
            }
            event = parser.next();
        }
        reader.close();
        return result;
    }

    private static void parseCollections(File collectionsFile, Map<String, List<String>> gameCollectionsMap) throws Exception {
        XmlPullParser parser = Xml.newPullParser();
        InputStreamReader reader = new InputStreamReader(new FileInputStream(collectionsFile), StandardCharsets.UTF_8);
        parser.setInput(reader);

        int event = parser.getEventType();
        String currentCollectionName = null;
        String currentKey = null;

        while (event != XmlPullParser.END_DOCUMENT) {
            String tag = parser.getName();
            if (event == XmlPullParser.START_TAG) {
                if ("entry".equals(tag)) {
                    String type = parser.getAttributeValue(null, "type");
                    String id = parser.getAttributeValue(null, "id");
                    if ("game".equals(type) && id != null && currentCollectionName != null) {
                        List<String> list = gameCollectionsMap.get(id);
                        if (list == null) {
                            list = new ArrayList<>();
                            gameCollectionsMap.put(id, list);
                        }
                        list.add(currentCollectionName);
                    }
                } else if ("data".equals(tag)) {
                    currentKey = parser.getAttributeValue(null, "key");
                }
            } else if (event == XmlPullParser.TEXT) {
                if ("name".equals(currentKey)) {
                    currentCollectionName = parser.getText();
                }
            } else if (event == XmlPullParser.END_TAG) {
                if ("data".equals(tag)) {
                    currentKey = null;
                }
            }
            event = parser.next();
        }
        reader.close();
    }

    private static int parseAndInsertGames(SQLiteDatabase db, File gamesFile, Map<String, PlatformInfo> emulatorMap, Map<String, List<String>> gameCollectionsMap, OnImportListener listener) throws Exception {
        XmlPullParser parser = Xml.newPullParser();
        InputStreamReader reader = new InputStreamReader(new FileInputStream(gamesFile), StandardCharsets.UTF_8);
        parser.setInput(reader);

        int event = parser.getEventType();
        String currentGameId = null;
        String currentKey = null;
        Map<String, String> currentData = new HashMap<>();

        SQLiteStatement insertGameStmt = db.compileStatement(
            "INSERT OR REPLACE INTO PlayableItemEntity (" +
            "is_singleton_disjoint_set, use_disjoint_set_primary_playable_item, " +
            "playable_item_type, name, do_scrape_name, description, " +
            "scraper_keyword_list, scrape_scraper_keywords, is_favorite, " +
            "is_searchable, is_visible, attached_platform_id, uri, " +
            "sync_tree_uri, md5, use_custom_player, play_count, " +
            "added_date_timestamp, do_not_prettify, is_completed, extra) " +
            "VALUES (1, 0, 1, ?, 1, ?, ?, 1, ?, 1, 1, ?, ?, ?, '', 0, 0, ?, 0, 0, ?)"
        );

        SQLiteStatement insertGenreStmt = db.compileStatement(
            "INSERT OR IGNORE INTO PlayableItemToGenrePairEntity (playable_item_id, genre_id, extra) VALUES (?, ?, '{}')"
        );

        db.beginTransaction();
        int gameCount = 0;
        long now = System.currentTimeMillis();

        try {
            while (event != XmlPullParser.END_DOCUMENT) {
                String tag = parser.getName();
                if (event == XmlPullParser.START_TAG) {
                    if ("entry".equals(tag)) {
                        String type = parser.getAttributeValue(null, "type");
                        if ("game".equals(type)) {
                            currentGameId = parser.getAttributeValue(null, "id");
                            currentData.clear();
                        }
                    } else if ("data".equals(tag)) {
                        currentKey = parser.getAttributeValue(null, "key");
                    }
                } else if (event == XmlPullParser.TEXT) {
                    if (currentKey != null && currentGameId != null) {
                        currentData.put(currentKey, parser.getText());
                    }
                } else if (event == XmlPullParser.END_TAG) {
                    if ("data".equals(tag)) {
                        currentKey = null;
                    } else if ("entry".equals(tag) && currentGameId != null) {
                        String eid = currentData.get("emulatorId");
                        String romFile = currentData.get("romFilename");
                        PlatformInfo pInfo = emulatorMap.get(eid);

                        if (pInfo != null && romFile != null && !romFile.trim().isEmpty()) {
                            String name = currentData.get("name");
                            if (name == null || name.trim().isEmpty()) {
                                name = romFile;
                            }
                            String desc = currentData.get("description");
                            if (desc == null) desc = "";

                            boolean isFav = "true".equalsIgnoreCase(currentData.get("favorite"));

                            String uri = "file://" + pInfo.romDirectory + "/" + romFile;
                            String syncTreeUri = "file://" + pInfo.romDirectory;

                            JSONArray kwArray = new JSONArray();
                            kwArray.put(name);

                            JSONObject extraObj = new JSONObject();
                            extraObj.put("developer", currentData.get("developer"));
                            extraObj.put("publisher", currentData.get("publisher"));
                            extraObj.put("releaseYear", currentData.get("releaseYear"));
                            extraObj.put("genres", currentData.get("genres"));
                            extraObj.put("arcGameId", currentGameId);

                            List<String> cols = gameCollectionsMap.get(currentGameId);
                            if (cols != null) {
                                JSONArray colArr = new JSONArray();
                                for (String c : cols) colArr.put(c);
                                extraObj.put("collections", colArr);
                            }

                            insertGameStmt.bindString(1, name);
                            insertGameStmt.bindString(2, desc);
                            insertGameStmt.bindString(3, kwArray.toString());
                            insertGameStmt.bindLong(4, isFav ? 1 : 0);
                            insertGameStmt.bindLong(5, pInfo.platformId);
                            insertGameStmt.bindString(6, uri);
                            insertGameStmt.bindString(7, syncTreeUri);
                            insertGameStmt.bindLong(8, now);
                            insertGameStmt.bindString(9, extraObj.toString());

                            long rowId = insertGameStmt.executeInsert();

                            // Insert genres & collection tags
                            if (rowId > 0) {
                                String genreStr = currentData.get("genres");
                                if (genreStr != null && !genreStr.trim().isEmpty()) {
                                    String[] parts = genreStr.split("[,;/]");
                                    for (String p : parts) {
                                        String clean = p.trim();
                                        if (!clean.isEmpty()) {
                                            insertGenreStmt.bindLong(1, rowId);
                                            insertGenreStmt.bindString(2, clean);
                                            insertGenreStmt.executeInsert();
                                        }
                                    }
                                }

                                if (cols != null) {
                                    for (String colName : cols) {
                                        insertGenreStmt.bindLong(1, rowId);
                                        insertGenreStmt.bindString(2, "Collection: " + colName);
                                        insertGenreStmt.executeInsert();
                                    }
                                }
                            }

                            gameCount++;
                            if (gameCount % 500 == 0) {
                                listener.onProgress("Importando jogos (" + gameCount + " processados)...", gameCount, 9000);
                            }
                        }
                        currentGameId = null;
                    }
                }
                event = parser.next();
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            reader.close();
        }

        return gameCount;
    }

    private static void createSchemaIfNeeded(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `PlatformEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `unique_id` TEXT, `name` TEXT NOT NULL, `shortname` TEXT NOT NULL, `description` TEXT, `is_visible` INTEGER NOT NULL, `scrape_preview_media` INTEGER NOT NULL, `wallpaper_path` TEXT, `thumbnail_path` TEXT, `color_theme` INTEGER, `color_on_theme` INTEGER, `accept_filename_regex` TEXT NOT NULL, `default_player_id` INTEGER NOT NULL, `player_id_list` TEXT NOT NULL, `scraper_source_list` TEXT NOT NULL, `box_art_aspect_ratio_id` INTEGER NOT NULL, `use_custom_box_art_aspect_ratio` INTEGER NOT NULL, `custom_box_art_aspect_ratio` TEXT, `screen_aspect_ratio_id` INTEGER NOT NULL, `use_custom_screen_aspect_ratio` INTEGER NOT NULL, `custom_screen_aspect_ratio` TEXT, `items_sync_tree_uri_list` TEXT NOT NULL, `retro_achievements_console_id_list` TEXT NOT NULL, `position` INTEGER NOT NULL, `extra` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `PlayableItemEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `is_singleton_disjoint_set` INTEGER NOT NULL, `use_disjoint_set_primary_playable_item` INTEGER NOT NULL, `disjoint_set_primary_playable_item_id` INTEGER, `playable_item_type` INTEGER NOT NULL, `name` TEXT NOT NULL, `do_scrape_name` INTEGER NOT NULL, `description` TEXT, `scraper_keyword_list` TEXT NOT NULL, `scrape_scraper_keywords` INTEGER NOT NULL, `is_favorite` INTEGER NOT NULL, `is_searchable` INTEGER NOT NULL, `is_visible` INTEGER NOT NULL, `preview_media_path` TEXT, `attached_platform_id` INTEGER, `uri` TEXT NOT NULL, `sync_tree_uri` TEXT NOT NULL, `md5` TEXT NOT NULL, `activity_component_string` TEXT, `use_custom_player` INTEGER NOT NULL, `custom_player_id` INTEGER, `play_count` INTEGER NOT NULL, `last_played_timestamp` INTEGER, `added_date_timestamp` INTEGER NOT NULL, `do_not_prettify` INTEGER NOT NULL, `is_completed` INTEGER NOT NULL, `extra` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `PlayableItemToGenrePairEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `playable_item_id` INTEGER NOT NULL, `genre_id` TEXT NOT NULL, `extra` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'ca3ff695079ec67187ce163b62fe671c')");
    }

    private static String parseTarString(byte[] header, int offset, int length) {
        int end = offset;
        while (end < offset + length && header[end] != 0) {
            end++;
        }
        return new String(header, offset, end - offset, StandardCharsets.US_ASCII).trim();
    }

    private static long parseTarOctal(byte[] header, int offset, int length) {
        long result = 0;
        int end = offset + length;
        int i = offset;
        while (i < end && (header[i] == ' ' || header[i] == '0')) {
            i++;
        }
        for (; i < end; i++) {
            byte b = header[i];
            if (b >= '0' && b <= '7') {
                result = (result << 3) + (b - '0');
            } else {
                break;
            }
        }
        return result;
    }

    private static boolean isAllZero(byte[] buf) {
        for (byte b : buf) {
            if (b != 0) return false;
        }
        return true;
    }

    private static int readFully(InputStream is, byte[] b, int off, int len) throws Exception {
        int total = 0;
        while (total < len) {
            int count = is.read(b, off + total, len - total);
            if (count < 0) break;
            total += count;
        }
        return total;
    }

    private static void skipFully(InputStream is, long n) throws Exception {
        long remaining = n;
        byte[] buf = new byte[8192];
        while (remaining > 0) {
            long skipped = is.skip(remaining);
            if (skipped <= 0) {
                int toRead = (int) Math.min(buf.length, remaining);
                int count = is.read(buf, 0, toRead);
                if (count < 0) break;
                remaining -= count;
            } else {
                remaining -= skipped;
            }
        }
    }

    private static void extractEntryToFile(InputStream is, long size, File dest) throws Exception {
        FileOutputStream fos = new FileOutputStream(dest);
        byte[] buf = new byte[32768];
        long remaining = size;
        while (remaining > 0) {
            int toRead = (int) Math.min(buf.length, remaining);
            int count = is.read(buf, 0, toRead);
            if (count < 0) break;
            fos.write(buf, 0, count);
            remaining -= count;
        }
        fos.flush();
        fos.close();
    }

    private static void deleteRecursive(File f) {
        if (f.isDirectory()) {
            File[] files = f.listFiles();
            if (files != null) {
                for (File child : files) deleteRecursive(child);
            }
        }
        f.delete();
    }
}
