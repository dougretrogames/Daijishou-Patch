import os

p = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/audio/MusicManager.java'
with open(p, 'r', encoding='utf-8') as f:
    lines = f.readlines()

new_lines = []
skip = False
for line in lines:
    if 'import com.magneticchen.daijishou.DaijishouApplication;' in line or \
       'import com.magneticchen.daijishou.data.db.entity.PlatformEntity;' in line or \
       'import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;' in line:
        continue
    if '// 1. Scan configured platform sync URIs' in line:
        skip = True
        new_lines.append('        // 1. Scan configured platform sync URIs via reflection\n')
        new_lines.append('        try {\n')
        new_lines.append('            java.lang.reflect.Method getRepo = appContext.getClass().getMethod("getDaijishouLibraryRepository");\n')
        new_lines.append('            Object repo = getRepo.invoke(appContext);\n')
        new_lines.append('            if (repo != null) {\n')
        new_lines.append('                java.lang.reflect.Method getPlatforms = repo.getClass().getMethod("getAllPlatformsStatically");\n')
        new_lines.append('                java.util.List<?> platforms = (java.util.List<?>) getPlatforms.invoke(repo);\n')
        new_lines.append('                if (platforms != null) {\n')
        new_lines.append('                    for (Object platform : platforms) {\n')
        new_lines.append('                        java.lang.reflect.Method getUris = platform.getClass().getMethod("getItemsSyncTreeUriList");\n')
        new_lines.append('                        java.util.List<Uri> syncUris = (java.util.List<Uri>) getUris.invoke(platform);\n')
        new_lines.append('                        if (syncUris != null) {\n')
        new_lines.append('                            for (Uri uri : syncUris) {\n')
        new_lines.append('                                scanUriForMusic(uri, foundUris);\n')
        new_lines.append('                            }\n')
        new_lines.append('                        }\n')
        new_lines.append('                    }\n')
        new_lines.append('                }\n')
        new_lines.append('            }\n')
        new_lines.append('        } catch (Throwable t) {\n')
        new_lines.append('            Log.w(TAG, "Failed to read platform sync URIs", t);\n')
        new_lines.append('        }\n')
        continue
    if skip:
        if '// 2. Scan standard external storage ROM locations' in line:
            skip = False
            new_lines.append(line)
        continue
    new_lines.append(line)

with open(p, 'w', encoding='utf-8') as f:
    f.writelines(new_lines)

print('Updated MusicManager cleanly!')
