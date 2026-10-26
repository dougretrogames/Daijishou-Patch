package com.magneticchen.daijishou.audio;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.documentfile.provider.DocumentFile;
import androidx.preference.PreferenceManager;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import java.io.File;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MusicManager {
    private static final String TAG = "MusicManager";
    public static final String PREF_KEY_PLAY_MUSIC = "play_music";

    private static MusicManager sInstance;

    private MediaPlayer mediaPlayer;
    private final List<Uri> fullPlaylist = new ArrayList<>();
    private final List<Uri> currentQueue = new ArrayList<>();
    private final SecureRandom secureRandom = new SecureRandom();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final ExecutorService scanExecutor = Executors.newSingleThreadExecutor();

    private boolean isScanning = false;
    private boolean isPaused = false;
    private Context appContext;
    private Uri lastPlayedUri;

    private MusicManager() {
    }

    public static synchronized MusicManager getInstance() {
        if (sInstance == null) {
            sInstance = new MusicManager();
        }
        return sInstance;
    }

    public void init(Context context) {
        if (context != null && appContext == null) {
            appContext = context.getApplicationContext();
        }
    }

    public boolean isPlayMusicEnabled(Context context) {
        Context ctx = context != null ? context : appContext;
        if (ctx == null) {
            return true;
        }
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return prefs.getBoolean(PREF_KEY_PLAY_MUSIC, true);
    }

    public void play(Context context) {
        init(context);
        if (!isPlayMusicEnabled(context)) {
            stop();
            return;
        }
        if (isPaused && mediaPlayer != null) {
            resume(context);
            return;
        }
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            return;
        }
        if (fullPlaylist.isEmpty()) {
            refreshPlaylistAndPlay(context);
        } else {
            playNextTrack();
        }
    }

    public void pause() {
        if (mediaPlayer != null) {
            try {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    isPaused = true;
                }
            } catch (Throwable t) {
                Log.w(TAG, "Error pausing MediaPlayer", t);
            }
        }
    }

    public void resume(Context context) {
        init(context);
        if (!isPlayMusicEnabled(context)) {
            stop();
            return;
        }
        if (isPaused && mediaPlayer != null) {
            try {
                mediaPlayer.start();
                isPaused = false;
                return;
            } catch (Throwable t) {
                Log.w(TAG, "Error resuming MediaPlayer, will play next track", t);
            }
        }
        if (mediaPlayer == null) {
            play(context);
        }
    }

    public void onPreferenceChanged(Context context, boolean enabled) {
        init(context);
        Context ctx = context != null ? context : appContext;
        if (ctx != null) {
            PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putBoolean(PREF_KEY_PLAY_MUSIC, enabled)
                .apply();
        }
        if (enabled) {
            startRandomTrack(context);
        } else {
            stop();
        }
    }

    public void startRandomTrack(Context context) {
        init(context);
        releasePlayer();
        isPaused = false;
        if (fullPlaylist.isEmpty()) {
            refreshPlaylistAndPlay(context);
        } else {
            currentQueue.clear();
            currentQueue.addAll(fullPlaylist);
            Collections.shuffle(currentQueue, secureRandom);
            if (currentQueue.size() > 1 && lastPlayedUri != null && currentQueue.get(0).equals(lastPlayedUri)) {
                Collections.swap(currentQueue, 0, currentQueue.size() - 1);
            }
            playNextTrack();
        }
    }

    public void stop() {
        releasePlayer();
        isPaused = false;
    }

    public void release() {
        stop();
    }

    private void releasePlayer() {
        if (mediaPlayer != null) {
            try {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                mediaPlayer.reset();
                mediaPlayer.release();
            } catch (Throwable ignored) {
            }
            mediaPlayer = null;
        }
    }

    public void refreshPlaylistAndPlay(final Context context) {
        init(context);
        if (isScanning) {
            return;
        }
        isScanning = true;
        scanExecutor.execute(new Runnable() {
            @Override
            public void run() {
                final Set<Uri> foundUris = new HashSet<>();
                try {
                    scanAllMusicFolders(foundUris);
                } catch (Throwable t) {
                    Log.e(TAG, "Error scanning for music", t);
                }
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        isScanning = false;
                        fullPlaylist.clear();
                        fullPlaylist.addAll(foundUris);
                        currentQueue.clear();
                        if (!fullPlaylist.isEmpty() && isPlayMusicEnabled(appContext)) {
                            playNextTrack();
                        } else {
                            stop();
                        }
                    }
                });
            }
        });
    }

    private void playNextTrack() {
        if (appContext == null || !isPlayMusicEnabled(appContext)) {
            stop();
            return;
        }
        if (fullPlaylist.isEmpty()) {
            return;
        }
        if (currentQueue.isEmpty()) {
            currentQueue.addAll(fullPlaylist);
            Collections.shuffle(currentQueue, secureRandom);
        }
        if (currentQueue.isEmpty()) {
            return;
        }

        Uri trackUri = currentQueue.remove(0);
        lastPlayedUri = trackUri;
        releasePlayer();

        try {
            MediaPlayer player = new MediaPlayer();
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player.setDataSource(appContext, trackUri);
            player.prepare();
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    playNextTrack();
                }
            });
            player.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    Log.w(TAG, "MediaPlayer error: what=" + what + " extra=" + extra);
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            playNextTrack();
                        }
                    });
                    return true;
                }
            });
            mediaPlayer = player;
            mediaPlayer.start();
            isPaused = false;
        } catch (Throwable t) {
            Log.w(TAG, "Error playing audio file: " + trackUri, t);
            releasePlayer();
            if (!currentQueue.isEmpty()) {
                mainHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        playNextTrack();
                    }
                }, 300);
            }
        }
    }

    private void scanAllMusicFolders(Set<Uri> foundUris) {
        if (appContext == null) {
            return;
        }

        // 1. Scan configured platform sync URIs
        if (appContext instanceof DaijishouApplication) {
            DaijishouApplication app = (DaijishouApplication) appContext;
            try {
                if (app.getDaijishouLibraryRepository() != null) {
                    List<PlatformEntity> platforms = app.getDaijishouLibraryRepository().getAllPlatformsStatically();
                    if (platforms != null) {
                        for (PlatformEntity platform : platforms) {
                            List<Uri> syncUris = platform.getItemsSyncTreeUriList();
                            if (syncUris != null) {
                                for (Uri uri : syncUris) {
                                    scanUriForMusic(uri, foundUris);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable t) {
                Log.w(TAG, "Failed to read platform sync URIs", t);
            }
        }

        // 2. Scan standard external storage ROM locations
        try {
            File ext = Environment.getExternalStorageDirectory();
            if (ext != null && ext.isDirectory()) {
                String[] commonDirs = new String[]{
                    "ROMs", "roms", "Roms", "RetroArch/roms", "Emulation/roms"
                };
                for (String dirName : commonDirs) {
                    File romDir = new File(ext, dirName);
                    if (romDir.isDirectory()) {
                        scanDirectoryForMusic(new File(romDir, "music"), foundUris);
                        scanDirectoryForMusic(new File(romDir, "Music"), foundUris);
                    }
                }
            }
        } catch (Throwable t) {
            Log.w(TAG, "Failed to scan standard storage locations", t);
        }
    }

    private void scanUriForMusic(Uri uri, Set<Uri> foundUris) {
        if (uri == null) {
            return;
        }

        // Try Storage Access Framework (SAF) DocumentTree
        try {
            DocumentFile doc = DocumentFile.fromTreeUri(appContext, uri);
            if (doc != null && doc.isDirectory()) {
                DocumentFile musicDoc = doc.findFile("music");
                if (musicDoc == null) {
                    musicDoc = doc.findFile("Music");
                }
                if (musicDoc != null && musicDoc.isDirectory()) {
                    for (DocumentFile file : musicDoc.listFiles()) {
                        if (file.isFile() && isAudioFileName(file.getName())) {
                            foundUris.add(file.getUri());
                        }
                    }
                }
            }
        } catch (Throwable ignored) {
        }

        // Try direct file path
        try {
            File file = resolveFileFromUri(uri);
            if (file != null && file.isDirectory()) {
                scanDirectoryForMusic(new File(file, "music"), foundUris);
                scanDirectoryForMusic(new File(file, "Music"), foundUris);

                File parent = file.getParentFile();
                if (parent != null && parent.isDirectory()) {
                    scanDirectoryForMusic(new File(parent, "music"), foundUris);
                    scanDirectoryForMusic(new File(parent, "Music"), foundUris);
                }
            }
        } catch (Throwable ignored) {
        }
    }

    private void scanDirectoryForMusic(File dir, Set<Uri> foundUris) {
        if (dir == null || !dir.isDirectory()) {
            return;
        }
        File[] files = dir.listFiles();
        if (files == null) {
            return;
        }
        for (File f : files) {
            if (f.isFile() && isAudioFileName(f.getName())) {
                foundUris.add(Uri.fromFile(f));
            }
        }
    }

    private File resolveFileFromUri(Uri uri) {
        if (uri == null) {
            return null;
        }
        if ("file".equalsIgnoreCase(uri.getScheme())) {
            String path = uri.getPath();
            return path != null ? new File(path) : null;
        }
        String path = uri.getPath();
        if (path != null) {
            if (path.contains("primary:")) {
                String subPath = path.substring(path.indexOf("primary:") + "primary:".length());
                return new File(Environment.getExternalStorageDirectory(), subPath);
            }
            if (path.startsWith("/tree/") || path.startsWith("/document/")) {
                int colonIndex = path.indexOf(':');
                if (colonIndex != -1) {
                    String subPath = path.substring(colonIndex + 1);
                    return new File(Environment.getExternalStorageDirectory(), subPath);
                }
            }
            File directFile = new File(path);
            if (directFile.exists()) {
                return directFile;
            }
        }
        return null;
    }

    private static boolean isAudioFileName(String name) {
        if (name == null) {
            return false;
        }
        String lower = name.toLowerCase(Locale.ROOT);
        return lower.endsWith(".mp3")
            || lower.endsWith(".ogg")
            || lower.endsWith(".wav")
            || lower.endsWith(".m4a")
            || lower.endsWith(".flac")
            || lower.endsWith(".aac")
            || lower.endsWith(".opus")
            || lower.endsWith(".mid")
            || lower.endsWith(".midi");
    }
}
