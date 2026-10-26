package com.skydoves.balloon;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: BalloonPersistence.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\u0010"}, d2 = {"Lcom/skydoves/balloon/BalloonPersistence;", "", "<init>", "()V", "shouldShowUp", "", "name", "", "counts", "", "putIncrementedCounts", "", "clearAllPreferences", "getPersistedCounts", "putCounts", "Companion", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BalloonPersistence {

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String SHOWED_UP = "SHOWED_UP";
    private static volatile BalloonPersistence instance;
    private static SharedPreferences sharedPreferenceManager;

    public /* synthetic */ BalloonPersistence(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final BalloonPersistence getInstance(Context context) {
        return INSTANCE.getInstance(context);
    }

    @JvmStatic
    public static final String getPersistName(String str) {
        return INSTANCE.getPersistName(str);
    }

    private BalloonPersistence() {
    }

    public final boolean shouldShowUp(String name, int counts) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getPersistedCounts(name) < counts;
    }

    public final void putIncrementedCounts(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        putCounts(name, getPersistedCounts(name) + 1);
    }

    public final void clearAllPreferences() {
        SharedPreferences sharedPreferences = sharedPreferenceManager;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferenceManager");
            sharedPreferences = null;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.clear();
        editorEdit.apply();
    }

    private final int getPersistedCounts(String name) {
        SharedPreferences sharedPreferences = sharedPreferenceManager;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferenceManager");
            sharedPreferences = null;
        }
        return sharedPreferences.getInt(INSTANCE.getPersistName(name), 0);
    }

    private final void putCounts(String name, int counts) {
        SharedPreferences sharedPreferences = sharedPreferenceManager;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferenceManager");
            sharedPreferences = null;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putInt(INSTANCE.getPersistName(name), counts);
        editorEdit.apply();
    }

    /* INFO: compiled from: BalloonPersistence.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/skydoves/balloon/BalloonPersistence$Companion;", "", "<init>", "()V", "instance", "Lcom/skydoves/balloon/BalloonPersistence;", "sharedPreferenceManager", "Landroid/content/SharedPreferences;", BalloonPersistence.SHOWED_UP, "", "getInstance", "context", "Landroid/content/Context;", "getPersistName", "name", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BalloonPersistence getInstance(Context context) {
            BalloonPersistence balloonPersistence;
            Intrinsics.checkNotNullParameter(context, "context");
            BalloonPersistence balloonPersistence2 = BalloonPersistence.instance;
            if (balloonPersistence2 != null) {
                return balloonPersistence2;
            }
            synchronized (this) {
                balloonPersistence = BalloonPersistence.instance;
                if (balloonPersistence == null) {
                    balloonPersistence = new BalloonPersistence(null);
                    Companion companion = BalloonPersistence.INSTANCE;
                    BalloonPersistence.instance = balloonPersistence;
                    Companion companion2 = BalloonPersistence.INSTANCE;
                    BalloonPersistence.sharedPreferenceManager = context.getSharedPreferences("com.skydoves.balloon", 0);
                }
            }
            return balloonPersistence;
        }

        @JvmStatic
        public final String getPersistName(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return BalloonPersistence.SHOWED_UP + name;
        }
    }
}
