import os

p = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/audio/MusicManager.java'
with open(p, 'r', encoding='utf-8') as f:
    c = f.read()

target = """    public static synchronized MusicManager getInstance() {
        if (instance == null) {
            instance = new MusicManager();
        }
        return instance;
    }"""

replacement = """    public static synchronized MusicManager getInstance() {
        if (instance == null) {
            instance = new MusicManager();
        }
        return instance;
    }

    public static synchronized MusicManager getInstance(Context context) {
        if (instance == null) {
            instance = new MusicManager();
        }
        if (context != null) {
            instance.init(context);
        }
        return instance;
    }

    public void start() {
        play(appContext);
    }"""

assert target in c, 'target not found'
c = c.replace(target, replacement)
with open(p, 'w', encoding='utf-8') as f:
    f.write(c)

print('Added getInstance(Context) and start() to MusicManager.java!')
