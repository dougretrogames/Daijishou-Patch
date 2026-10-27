with open('build_tmp/sources_181_merged/com/magneticchen/daijishou/audio/MusicManager.java', 'r', encoding='utf-8') as f:
    code = f.read()

# Replace anonymous listener with strong field reference
old_field = '    private Uri lastPlayedUri;'
new_field = '''    private Uri lastPlayedUri;
    private SharedPreferences.OnSharedPreferenceChangeListener prefListener;'''

if 'private SharedPreferences.OnSharedPreferenceChangeListener prefListener;' not in code:
    code = code.replace(old_field, new_field)

old_reg = '''            try {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(appContext);
                prefs.registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
                    @Override
                    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                        if (PREF_KEY_PLAY_MUSIC.equals(key)) {
                            boolean enabled = sharedPreferences.getBoolean(PREF_KEY_PLAY_MUSIC, true);
                            if (enabled) {
                                startRandomTrack(appContext);
                            } else {
                                stop();
                            }
                        }
                    }
                });
            } catch (Throwable t) {'''

new_reg = '''            try {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(appContext);
                prefListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
                    @Override
                    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                        Log.i(TAG, "onSharedPreferenceChanged: " + key);
                        if (PREF_KEY_PLAY_MUSIC.equals(key)) {
                            boolean enabled = sharedPreferences.getBoolean(PREF_KEY_PLAY_MUSIC, true);
                            Log.i(TAG, "play_music changed to " + enabled);
                            if (enabled) {
                                startRandomTrack(appContext);
                            } else {
                                stop();
                            }
                        }
                    }
                };
                prefs.registerOnSharedPreferenceChangeListener(prefListener);
            } catch (Throwable t) {'''

code = code.replace(old_reg, new_reg)

with open('build_tmp/sources_181_merged/com/magneticchen/daijishou/audio/MusicManager.java', 'w', encoding='utf-8') as f:
    f.write(code)

with open('app_sources/sources/com/magneticchen/daijishou/audio/MusicManager.java', 'w', encoding='utf-8') as f:
    f.write(code)

print('Updated prefListener to strong reference!')
