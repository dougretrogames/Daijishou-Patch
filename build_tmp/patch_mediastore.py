with open('build_tmp/sources_181_merged/com/magneticchen/daijishou/audio/MusicManager.java', 'r', encoding='utf-8') as f:
    code = f.read()

# Add imports
imports = """import android.content.ContentUris;
import android.database.Cursor;
import android.provider.MediaStore;
"""
if 'android.provider.MediaStore;' not in code:
    code = code.replace('import android.content.Context;', 'import android.content.Context;\n' + imports)

# Call scanMediaStore in scanAllMusicFolders
old_scan_call = """        // 2. Scan standard external storage ROM locations"""
new_scan_call = """        scanMediaStore(foundUris);
        // 2. Scan standard external storage ROM locations"""
if 'scanMediaStore(foundUris);' not in code:
    code = code.replace(old_scan_call, new_scan_call)

# Add scanMediaStore method
media_store_method = r"""
    private void scanMediaStore(Set<Uri> foundUris) {
        if (appContext == null) {
            return;
        }
        try {
            Uri collection = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            String[] projection = new String[]{
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.DATA
            };
            Cursor cursor = appContext.getContentResolver().query(collection, projection, null, null, null);
            if (cursor != null) {
                int idCol = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID);
                int dataCol = cursor.getColumnIndex(MediaStore.Audio.Media.DATA);
                while (cursor.moveToNext()) {
                    long id = cursor.getLong(idCol);
                    String data = dataCol >= 0 ? cursor.getString(dataCol) : null;
                    if (data != null) {
                        String lower = data.toLowerCase(Locale.ROOT);
                        if (lower.contains("/music") || lower.contains("/roms") || lower.contains("/retroarch")) {
                            foundUris.add(ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, id));
                        }
                    } else {
                        foundUris.add(ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, id));
                    }
                }
                cursor.close();
            }
        } catch (Throwable t) {
            Log.w(TAG, "Failed to scan MediaStore", t);
        }
    }
"""

if 'void scanMediaStore(' not in code:
    idx = code.rfind('}')
    code = code[:idx] + media_store_method + '\n}'

with open('build_tmp/sources_181_merged/com/magneticchen/daijishou/audio/MusicManager.java', 'w', encoding='utf-8') as f:
    f.write(code)

with open('app_sources/sources/com/magneticchen/daijishou/audio/MusicManager.java', 'w', encoding='utf-8') as f:
    f.write(code)

print('Added scanMediaStore successfully!')
