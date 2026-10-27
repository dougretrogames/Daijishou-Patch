p = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/audio/MusicManager.java'
with open(p, 'r', encoding='utf-8') as f:
    c = f.read()

old_init = """    public void init(Context context) {
        if (context != null && appContext == null) {
            appContext = context.getApplicationContext();
        }
    }"""

new_init = """    public void init(Context context) {
        if (context != null && appContext == null) {
            appContext = context.getApplicationContext();
            try {
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
            } catch (Throwable t) {
                Log.w(TAG, "Error registering pref listener", t);
            }
        }
    }"""

assert old_init in c, 'old_init not found'
c = c.replace(old_init, new_init)
with open(p, 'w', encoding='utf-8') as f:
    f.write(c)

print('Updated init with pref listener!')
