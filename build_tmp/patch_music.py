with open('build_tmp/sources_181_merged/com/magneticchen/daijishou/audio/MusicManager.java', 'r', encoding='utf-8') as f:
    content = f.read()

# Add logs
old_play = """    public void play(Context context) {
        init(context);
        if (!isPlayMusicEnabled(context)) {"""

new_play = """    public void play(Context context) {
        init(context);
        Log.i(TAG, "play() called, enabled=" + isPlayMusicEnabled(context));
        if (!isPlayMusicEnabled(context)) {"""

content = content.replace(old_play, new_play)

old_scan_done = """                        fullPlaylist.clear();
                        fullPlaylist.addAll(foundUris);"""

new_scan_done = """                        Log.i(TAG, "Scan complete. Found " + foundUris.size() + " music tracks.");
                        fullPlaylist.clear();
                        fullPlaylist.addAll(foundUris);"""

content = content.replace(old_scan_done, new_scan_done)

old_playing = """            mediaPlayer = player;
            mediaPlayer.start();"""

new_playing = """            Log.i(TAG, "Playing music track: " + trackUri);
            mediaPlayer = player;
            mediaPlayer.start();"""

content = content.replace(old_playing, new_playing)

# Also scan /sdcard/Music directly and music_playlist_uri
old_dirs = """                String[] commonDirs = new String[]{
                    "ROMs", "roms", "Roms", "RetroArch/roms", "Emulation/roms"
                };"""

new_dirs = """                scanDirectoryForMusic(new File(ext, "Music"), foundUris);
                scanDirectoryForMusic(new File(ext, "music"), foundUris);
                String[] commonDirs = new String[]{
                    "ROMs", "roms", "Roms", "RetroArch/roms", "Emulation/roms"
                };"""

content = content.replace(old_dirs, new_dirs)

old_custom = """        // 2. Scan standard external storage ROM locations"""
new_custom = """        try {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(appContext);
            String customUri = prefs.getString("music_playlist_uri", null);
            if (customUri != null && !customUri.isEmpty()) {
                scanUriForMusic(Uri.parse(customUri), foundUris);
            }
        } catch (Throwable t) {
            Log.w(TAG, "Failed to scan custom music_playlist_uri", t);
        }
        // 2. Scan standard external storage ROM locations"""

content = content.replace(old_custom, new_custom)

with open('build_tmp/sources_181_merged/com/magneticchen/daijishou/audio/MusicManager.java', 'w', encoding='utf-8') as f:
    f.write(content)

with open('app_sources/sources/com/magneticchen/daijishou/audio/MusicManager.java', 'w', encoding='utf-8') as f:
    f.write(content)

print('MusicManager.java successfully updated!')
