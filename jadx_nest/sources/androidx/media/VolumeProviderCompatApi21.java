package androidx.media;

import android.media.VolumeProvider;

/* INFO: loaded from: classes.dex */
class VolumeProviderCompatApi21 {

    public interface Delegate {
        void onAdjustVolume(int i);

        void onSetVolumeTo(int i);
    }

    /* INFO: renamed from: androidx.media.VolumeProviderCompatApi21$1, reason: invalid class name */
    static class AnonymousClass1 extends VolumeProvider {
        final /* synthetic */ Delegate val$delegate;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, int i2, int i3, Delegate delegate) {
            super(i, i2, i3);
            this.val$delegate = delegate;
        }

        @Override // android.media.VolumeProvider
        public void onSetVolumeTo(int i) {
            this.val$delegate.onSetVolumeTo(i);
        }

        @Override // android.media.VolumeProvider
        public void onAdjustVolume(int i) {
            this.val$delegate.onAdjustVolume(i);
        }
    }

    public static Object createVolumeProvider(int i, int i2, int i3, Delegate delegate) {
        return new AnonymousClass1(i, i2, i3, delegate);
    }

    public static void setCurrentVolume(Object obj, int i) {
        ((VolumeProvider) obj).setCurrentVolume(i);
    }

    private VolumeProviderCompatApi21() {
    }
}
