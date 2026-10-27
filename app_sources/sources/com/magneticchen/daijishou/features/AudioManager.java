package com.magneticchen.daijishou.features;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.widget.Toast;
import com.magneticchen.daijishou.DaijishouApplication;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: AudioManager.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0002\"#B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\u0006\u0010\u001c\u001a\u00020\u0018J\u000e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0006J\u0006\u0010\u001f\u001a\u00020\u0018J\u0006\u0010 \u001a\u00020\u0018J\u0006\u0010!\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/magneticchen/daijishou/features/AudioManager;", "", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "current", "Lcom/magneticchen/daijishou/features/AudioManager$AudioFile;", "mp3Files", "", "player", "Landroid/media/MediaPlayer;", "prefListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "prefs", "Landroid/content/SharedPreferences;", "findMp3Files", "", "context", "Landroid/content/Context;", "treeUri", "Landroid/net/Uri;", "sub", "", "next", "", "observeChanges", "onLoadConfiguration", "onLoadPlaylist", "pause", "play", "audio", "resume", "shutdown", "stop", "AudioFile", "Configuration", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AudioManager {
    private final DaijishouApplication application;
    private AudioFile current;
    private List<AudioFile> mp3Files;
    private MediaPlayer player;
    private SharedPreferences.OnSharedPreferenceChangeListener prefListener;
    private final SharedPreferences prefs;

    /* JADX INFO: compiled from: AudioManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/magneticchen/daijishou/features/AudioManager$Configuration;", "", "(Ljava/lang/String;I)V", "DISABLED", "SHUFFLED", "ALPHABETICAL", "NUMERICAL", "ADDED", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum Configuration {
        DISABLED,
        SHUFFLED,
        ALPHABETICAL,
        NUMERICAL,
        ADDED;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Configuration> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: AudioManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Configuration.values().length];
            try {
                iArr[Configuration.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Configuration.SHUFFLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Configuration.NUMERICAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Configuration.ALPHABETICAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Configuration.ADDED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AudioManager(DaijishouApplication application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.application = application;
        this.prefs = application.getDefaultSharedPreferences();
        this.mp3Files = new ArrayList();
        onLoadPlaylist();
        observeChanges();
    }

    public final void next() {
        AudioFile audioFile = this.current;
        if (audioFile != null) {
            AudioFile audioFile2 = (AudioFile) CollectionsKt.getOrNull(this.mp3Files, this.mp3Files.indexOf(audioFile) + 1);
            if (audioFile2 == null) {
                play((AudioFile) CollectionsKt.first((List) this.mp3Files));
            } else {
                play(audioFile2);
            }
        }
    }

    public final void play(AudioFile audio) {
        Intrinsics.checkNotNullParameter(audio, "audio");
        try {
            this.current = audio;
            stop();
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setContentType(2).setUsage(1).build());
            mediaPlayer.setDataSource(this.application, audio.getUri());
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.magneticchen.daijishou.features.AudioManager$$ExternalSyntheticLambda0
                @Override // android.media.MediaPlayer.OnPreparedListener
                public final void onPrepared(MediaPlayer mediaPlayer2) {
                    mediaPlayer2.start();
                }
            });
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.magneticchen.daijishou.features.AudioManager$$ExternalSyntheticLambda1
                @Override // android.media.MediaPlayer.OnCompletionListener
                public final void onCompletion(MediaPlayer mediaPlayer2) {
                    AudioManager.play$lambda$2$lambda$1(AudioManager.this, mediaPlayer2);
                }
            });
            mediaPlayer.prepareAsync();
            this.player = mediaPlayer;
        } catch (Exception unused) {
            this.current = null;
            this.player = null;
            this.mp3Files.remove(audio);
            if (!this.mp3Files.isEmpty()) {
                Toast.makeText(this.application.getApplicationContext(), audio.getName() + " may be corrupted, skipping...", 0).show();
                play((AudioFile) CollectionsKt.first((List) this.mp3Files));
                return;
            }
            Toast.makeText(this.application.getApplicationContext(), audio.getName() + " may be corrupted, or a bad path was chosen.", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void play$lambda$2$lambda$1(AudioManager this$0, MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.next();
    }

    public final void pause() {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            if (!mediaPlayer.isPlaying()) {
                mediaPlayer = null;
            }
            if (mediaPlayer != null) {
                mediaPlayer.pause();
            }
        }
    }

    public final void resume() {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    public final void stop() {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        this.player = null;
    }

    public final void shutdown() {
        SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = this.prefListener;
        if (onSharedPreferenceChangeListener != null) {
            this.prefs.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        }
        this.prefListener = null;
        stop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLoadConfiguration() {
        String string = this.prefs.getString("music_configuration", "disabled");
        Intrinsics.checkNotNull(string);
        String upperCase = string.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        int i = WhenMappings.$EnumSwitchMapping$0[Configuration.valueOf(upperCase).ordinal()];
        if (i == 1) {
            stop();
            return;
        }
        if (i == 2) {
            this.mp3Files = CollectionsKt.toMutableList((Collection) CollectionsKt.shuffled(this.mp3Files));
        } else if (i == 3) {
            this.mp3Files = CollectionsKt.toMutableList((Collection) CollectionsKt.sortedWith(this.mp3Files, new Comparator() { // from class: com.magneticchen.daijishou.features.AudioManager$onLoadConfiguration$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(Object t, Object t2) {
                    String name = ((AudioManager.AudioFile) t).getName();
                    int length = name.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        if (!Character.isDigit(name.charAt(i2))) {
                            name = name.substring(0, i2);
                            Intrinsics.checkNotNullExpressionValue(name, "substring(...)");
                            break;
                        }
                    }
                    Integer intOrNull = StringsKt.toIntOrNull(name);
                    Integer numValueOf = Integer.valueOf(intOrNull != null ? intOrNull.intValue() : Integer.MAX_VALUE);
                    String name2 = ((AudioManager.AudioFile) t2).getName();
                    int length2 = name2.length();
                    for (int i3 = 0; i3 < length2; i3++) {
                        if (!Character.isDigit(name2.charAt(i3))) {
                            name2 = name2.substring(0, i3);
                            Intrinsics.checkNotNullExpressionValue(name2, "substring(...)");
                            break;
                        }
                    }
                    Integer intOrNull2 = StringsKt.toIntOrNull(name2);
                    return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(intOrNull2 != null ? intOrNull2.intValue() : Integer.MAX_VALUE));
                }
            }));
        } else if (i == 4) {
            this.mp3Files = CollectionsKt.toMutableList((Collection) CollectionsKt.sortedWith(this.mp3Files, new Comparator() { // from class: com.magneticchen.daijishou.features.AudioManager$onLoadConfiguration$$inlined$sortedBy$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(Object t, Object t2) {
                    return ComparisonsKt.compareValues(((AudioManager.AudioFile) t).getName(), ((AudioManager.AudioFile) t2).getName());
                }
            }));
        } else if (i == 5) {
            this.mp3Files = CollectionsKt.toMutableList((Collection) CollectionsKt.sortedWith(this.mp3Files, new Comparator() { // from class: com.magneticchen.daijishou.features.AudioManager$onLoadConfiguration$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(Object t, Object t2) {
                    return ComparisonsKt.compareValues(Long.valueOf(((AudioManager.AudioFile) t2).getTimestamp()), Long.valueOf(((AudioManager.AudioFile) t).getTimestamp()));
                }
            }));
        }
        if (this.mp3Files.isEmpty()) {
            return;
        }
        play((AudioFile) CollectionsKt.first((List) this.mp3Files));
    }

    private final void onLoadPlaylist() {
        String string = this.prefs.getString("music_playlist_uri", null);
        Uri uri = string != null ? Uri.parse(string) : null;
        if (uri == null) {
            return;
        }
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, uri, null), 3, (Object) null);
    }

    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Uri $dir;
        final /* synthetic */ AudioManager this$0;
        int label;

        AnonymousClass1(AudioManager audioManager, Uri uri, Continuation<?> continuation) {
            super(2, (Continuation<Object>) continuation);
            this.this$0 = audioManager;
            this.$dir = uri;
        }

        @Override
        public final Continuation create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$dir, continuation);
        }

        @Override
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) (Object) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            AudioManager audioManager = this.this$0;
            audioManager.mp3Files = CollectionsKt.toMutableList((Collection) AudioManager.findMp3Files$default(audioManager, audioManager.application, this.$dir, false, 4, null));
            this.this$0.onLoadConfiguration();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observeChanges$lambda$9(AudioManager this$0, SharedPreferences sharedPreferences, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (str != null && str.hashCode() == -1119642279 && str.equals("music_playlist_uri")) {
            this$0.onLoadPlaylist();
        }
        if (str != null && str.hashCode() == 766906460 && str.equals("music_configuration")) {
            this$0.onLoadConfiguration();
        }
    }

    private final void observeChanges() {
        SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.magneticchen.daijishou.features.AudioManager$$ExternalSyntheticLambda2
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                AudioManager.observeChanges$lambda$9(AudioManager.this, sharedPreferences, str);
            }
        };
        this.prefs.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        this.prefListener = onSharedPreferenceChangeListener;
    }

    static /* synthetic */ List findMp3Files$default(AudioManager audioManager, Context context, Uri uri, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return audioManager.findMp3Files(context, uri, z);
    }

    private final List<AudioFile> findMp3Files(Context context, Uri uri, boolean z) {
        String documentId;
        ArrayList arrayList = new ArrayList();
        if (!z) {
            documentId = DocumentsContract.getTreeDocumentId(uri);
        } else {
            documentId = DocumentsContract.getDocumentId(uri);
        }
        Cursor cursorQuery = context.getContentResolver().query(DocumentsContract.buildChildDocumentsUriUsingTree(uri, documentId), new String[]{"document_id", "_display_name", "mime_type"}, null, null, null);
        if (cursorQuery == null) {
            return arrayList;
        }
        Cursor cursor = cursorQuery;
        try {
            Cursor cursor2 = cursor;
            while (cursor2.moveToNext()) {
                String string = cursor2.getString(0);
                String string2 = cursor2.getString(1);
                String string3 = cursor2.getString(2);
                Uri uriBuildDocumentUriUsingTree = DocumentsContract.buildDocumentUriUsingTree(uri, string);
                if (Intrinsics.areEqual(string3, "vnd.android.document/directory")) {
                    Intrinsics.checkNotNull(string2);
                    if (!StringsKt.startsWith$default(string2, ".", false, 2, (Object) null)) {
                        Intrinsics.checkNotNull(uriBuildDocumentUriUsingTree);
                        CollectionsKt.addAll(arrayList, findMp3Files(context, uriBuildDocumentUriUsingTree, true));
                    }
                }
                if (!Intrinsics.areEqual(string3, "audio/mpeg")) {
                    Intrinsics.checkNotNull(string2);
                    if (StringsKt.endsWith(string2, ".mp3", true)) {
                    }
                }
                Intrinsics.checkNotNull(string2);
                Intrinsics.checkNotNull(uriBuildDocumentUriUsingTree);
                arrayList.add(new AudioFile(string2, uriBuildDocumentUriUsingTree, -1L));
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(cursor, null);
            return arrayList;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(cursor, th);
                throw th2;
            }
        }
    }

    /* JADX INFO: compiled from: AudioManager.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/magneticchen/daijishou/features/AudioManager$AudioFile;", "", "name", "", "uri", "Landroid/net/Uri;", "timestamp", "", "(Ljava/lang/String;Landroid/net/Uri;J)V", "getName", "()Ljava/lang/String;", "getTimestamp", "()J", "getUri", "()Landroid/net/Uri;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AudioFile {
        private final String name;
        private final long timestamp;
        private final Uri uri;

        public static /* synthetic */ AudioFile copy$default(AudioFile audioFile, String str, Uri uri, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = audioFile.name;
            }
            if ((i & 2) != 0) {
                uri = audioFile.uri;
            }
            if ((i & 4) != 0) {
                j = audioFile.timestamp;
            }
            return audioFile.copy(str, uri, j);
        }

        public final String component1() {
            return this.name;
        }

        public final Uri component2() {
            return this.uri;
        }

        public final long component3() {
            return this.timestamp;
        }

        public final AudioFile copy(String name, Uri uri, long j) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(uri, "uri");
            return new AudioFile(name, uri, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AudioFile)) {
                return false;
            }
            AudioFile audioFile = (AudioFile) obj;
            return Intrinsics.areEqual(this.name, audioFile.name) && Intrinsics.areEqual(this.uri, audioFile.uri) && this.timestamp == audioFile.timestamp;
        }

        public int hashCode() {
            return (((this.name.hashCode() * 31) + this.uri.hashCode()) * 31) + Long.hashCode(this.timestamp);
        }

        public String toString() {
            return "AudioFile(name=" + this.name + ", uri=" + this.uri + ", timestamp=" + this.timestamp + ")";
        }

        public AudioFile(String name, Uri uri, long j) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.name = name;
            this.uri = uri;
            this.timestamp = j;
        }

        public final String getName() {
            return this.name;
        }

        public final Uri getUri() {
            return this.uri;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }
    }
}
