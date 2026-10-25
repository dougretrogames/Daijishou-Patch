package androidx.leanback.media;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.view.SurfaceHolder;
import androidx.leanback.R;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class MediaPlayerAdapter extends PlayerAdapter {
    long mBufferedProgress;
    boolean mBufferingStart;
    Context mContext;
    boolean mHasDisplay;
    SurfaceHolderGlueHost mSurfaceHolderGlueHost;
    final MediaPlayer mPlayer = new MediaPlayer();
    final Runnable mRunnable = new AnonymousClass1();
    final Handler mHandler = new Handler();
    boolean mInitialized = false;
    Uri mMediaSourceUri = null;
    MediaPlayer.OnPreparedListener mOnPreparedListener = new AnonymousClass2();
    final MediaPlayer.OnCompletionListener mOnCompletionListener = new AnonymousClass3();
    final MediaPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener = new AnonymousClass4();
    final MediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener = new AnonymousClass5();
    final MediaPlayer.OnErrorListener mOnErrorListener = new AnonymousClass6();
    final MediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener = new AnonymousClass7();
    final MediaPlayer.OnInfoListener mOnInfoListener = new AnonymousClass8();

    public int getProgressUpdatingInterval() {
        return 16;
    }

    protected boolean onError(int i, int i2) {
        return false;
    }

    protected boolean onInfo(int i, int i2) {
        return false;
    }

    protected void onSeekComplete() {
    }

    /* JADX INFO: renamed from: androidx.leanback.media.MediaPlayerAdapter$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MediaPlayerAdapter.this.getCallback().onCurrentPositionChanged(MediaPlayerAdapter.this);
            MediaPlayerAdapter.this.mHandler.postDelayed(this, MediaPlayerAdapter.this.getProgressUpdatingInterval());
        }
    }

    /* JADX INFO: renamed from: androidx.leanback.media.MediaPlayerAdapter$2, reason: invalid class name */
    class AnonymousClass2 implements MediaPlayer.OnPreparedListener {
        AnonymousClass2() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            MediaPlayerAdapter.this.mInitialized = true;
            MediaPlayerAdapter.this.notifyBufferingStartEnd();
            if (MediaPlayerAdapter.this.mSurfaceHolderGlueHost == null || MediaPlayerAdapter.this.mHasDisplay) {
                MediaPlayerAdapter.this.getCallback().onPreparedStateChanged(MediaPlayerAdapter.this);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.leanback.media.MediaPlayerAdapter$3, reason: invalid class name */
    class AnonymousClass3 implements MediaPlayer.OnCompletionListener {
        AnonymousClass3() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            MediaPlayerAdapter.this.getCallback().onPlayStateChanged(MediaPlayerAdapter.this);
            MediaPlayerAdapter.this.getCallback().onPlayCompleted(MediaPlayerAdapter.this);
        }
    }

    /* JADX INFO: renamed from: androidx.leanback.media.MediaPlayerAdapter$4, reason: invalid class name */
    class AnonymousClass4 implements MediaPlayer.OnBufferingUpdateListener {
        AnonymousClass4() {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            MediaPlayerAdapter mediaPlayerAdapter = MediaPlayerAdapter.this;
            mediaPlayerAdapter.mBufferedProgress = (mediaPlayerAdapter.getDuration() * ((long) i)) / 100;
            MediaPlayerAdapter.this.getCallback().onBufferedPositionChanged(MediaPlayerAdapter.this);
        }
    }

    /* JADX INFO: renamed from: androidx.leanback.media.MediaPlayerAdapter$5, reason: invalid class name */
    class AnonymousClass5 implements MediaPlayer.OnVideoSizeChangedListener {
        AnonymousClass5() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            MediaPlayerAdapter.this.getCallback().onVideoSizeChanged(MediaPlayerAdapter.this, i, i2);
        }
    }

    /* JADX INFO: renamed from: androidx.leanback.media.MediaPlayerAdapter$6, reason: invalid class name */
    class AnonymousClass6 implements MediaPlayer.OnErrorListener {
        AnonymousClass6() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            PlayerAdapter.Callback callback = MediaPlayerAdapter.this.getCallback();
            MediaPlayerAdapter mediaPlayerAdapter = MediaPlayerAdapter.this;
            callback.onError(mediaPlayerAdapter, i, mediaPlayerAdapter.mContext.getString(R.string.lb_media_player_error, Integer.valueOf(i), Integer.valueOf(i2)));
            return MediaPlayerAdapter.this.onError(i, i2);
        }
    }

    /* JADX INFO: renamed from: androidx.leanback.media.MediaPlayerAdapter$7, reason: invalid class name */
    class AnonymousClass7 implements MediaPlayer.OnSeekCompleteListener {
        AnonymousClass7() {
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            MediaPlayerAdapter.this.onSeekComplete();
        }
    }

    /* JADX INFO: renamed from: androidx.leanback.media.MediaPlayerAdapter$8, reason: invalid class name */
    class AnonymousClass8 implements MediaPlayer.OnInfoListener {
        AnonymousClass8() {
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            boolean z;
            if (i != 701) {
                if (i != 702) {
                    z = false;
                } else {
                    MediaPlayerAdapter.this.mBufferingStart = false;
                    MediaPlayerAdapter.this.notifyBufferingStartEnd();
                }
                return !z || MediaPlayerAdapter.this.onInfo(i, i2);
            }
            MediaPlayerAdapter.this.mBufferingStart = true;
            MediaPlayerAdapter.this.notifyBufferingStartEnd();
            z = true;
            if (z) {
            }
        }
    }

    void notifyBufferingStartEnd() {
        getCallback().onBufferingStateChanged(this, this.mBufferingStart || !this.mInitialized);
    }

    public MediaPlayerAdapter(Context context) {
        this.mContext = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.leanback.media.PlayerAdapter
    public void onAttachedToHost(PlaybackGlueHost playbackGlueHost) {
        if (playbackGlueHost instanceof SurfaceHolderGlueHost) {
            SurfaceHolderGlueHost surfaceHolderGlueHost = (SurfaceHolderGlueHost) playbackGlueHost;
            this.mSurfaceHolderGlueHost = surfaceHolderGlueHost;
            surfaceHolderGlueHost.setSurfaceHolderCallback(new VideoPlayerSurfaceHolderCallback());
        }
    }

    public void reset() {
        changeToUnitialized();
        this.mPlayer.reset();
    }

    void changeToUnitialized() {
        if (this.mInitialized) {
            this.mInitialized = false;
            notifyBufferingStartEnd();
            if (this.mHasDisplay) {
                getCallback().onPreparedStateChanged(this);
            }
        }
    }

    public void release() {
        changeToUnitialized();
        this.mHasDisplay = false;
        this.mPlayer.release();
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void onDetachedFromHost() {
        SurfaceHolderGlueHost surfaceHolderGlueHost = this.mSurfaceHolderGlueHost;
        if (surfaceHolderGlueHost != null) {
            surfaceHolderGlueHost.setSurfaceHolderCallback(null);
            this.mSurfaceHolderGlueHost = null;
        }
        reset();
        release();
    }

    void setDisplay(SurfaceHolder surfaceHolder) {
        boolean z = this.mHasDisplay;
        boolean z2 = surfaceHolder != null;
        this.mHasDisplay = z2;
        if (z == z2) {
            return;
        }
        this.mPlayer.setDisplay(surfaceHolder);
        if (this.mHasDisplay) {
            if (this.mInitialized) {
                getCallback().onPreparedStateChanged(this);
            }
        } else if (this.mInitialized) {
            getCallback().onPreparedStateChanged(this);
        }
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void setProgressUpdatingEnabled(boolean z) {
        this.mHandler.removeCallbacks(this.mRunnable);
        if (z) {
            this.mHandler.postDelayed(this.mRunnable, getProgressUpdatingInterval());
        }
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public boolean isPlaying() {
        return this.mInitialized && this.mPlayer.isPlaying();
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public long getDuration() {
        if (this.mInitialized) {
            return this.mPlayer.getDuration();
        }
        return -1L;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public long getCurrentPosition() {
        if (this.mInitialized) {
            return this.mPlayer.getCurrentPosition();
        }
        return -1L;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void play() {
        if (!this.mInitialized || this.mPlayer.isPlaying()) {
            return;
        }
        this.mPlayer.start();
        getCallback().onPlayStateChanged(this);
        getCallback().onCurrentPositionChanged(this);
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void pause() {
        if (isPlaying()) {
            this.mPlayer.pause();
            getCallback().onPlayStateChanged(this);
        }
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void seekTo(long j) {
        if (this.mInitialized) {
            this.mPlayer.seekTo((int) j);
        }
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public long getBufferedPosition() {
        return this.mBufferedProgress;
    }

    public boolean setDataSource(Uri uri) {
        Uri uri2 = this.mMediaSourceUri;
        if (uri2 != null) {
            if (uri2.equals(uri)) {
                return false;
            }
        } else if (uri == null) {
            return false;
        }
        this.mMediaSourceUri = uri;
        prepareMediaForPlaying();
        return true;
    }

    private void prepareMediaForPlaying() {
        reset();
        try {
            Uri uri = this.mMediaSourceUri;
            if (uri != null) {
                this.mPlayer.setDataSource(this.mContext, uri);
                this.mPlayer.setAudioStreamType(3);
                this.mPlayer.setOnPreparedListener(this.mOnPreparedListener);
                this.mPlayer.setOnVideoSizeChangedListener(this.mOnVideoSizeChangedListener);
                this.mPlayer.setOnErrorListener(this.mOnErrorListener);
                this.mPlayer.setOnSeekCompleteListener(this.mOnSeekCompleteListener);
                this.mPlayer.setOnCompletionListener(this.mOnCompletionListener);
                this.mPlayer.setOnInfoListener(this.mOnInfoListener);
                this.mPlayer.setOnBufferingUpdateListener(this.mOnBufferingUpdateListener);
                notifyBufferingStartEnd();
                this.mPlayer.prepareAsync();
                getCallback().onPlayStateChanged(this);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public final MediaPlayer getMediaPlayer() {
        return this.mPlayer;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public boolean isPrepared() {
        if (this.mInitialized) {
            return this.mSurfaceHolderGlueHost == null || this.mHasDisplay;
        }
        return false;
    }

    class VideoPlayerSurfaceHolderCallback implements SurfaceHolder.Callback {
        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        VideoPlayerSurfaceHolderCallback() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            MediaPlayerAdapter.this.setDisplay(surfaceHolder);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            MediaPlayerAdapter.this.setDisplay(null);
        }
    }
}
