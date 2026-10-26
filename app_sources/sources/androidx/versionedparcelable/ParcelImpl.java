package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;

/* INFO: loaded from: classes3.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new AnonymousClass1();
    private final VersionedParcelable mParcel;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ParcelImpl(VersionedParcelable versionedParcelable) {
        this.mParcel = versionedParcelable;
    }

    protected ParcelImpl(Parcel parcel) {
        this.mParcel = new VersionedParcelParcel(parcel).readVersionedParcelable();
    }

    public <T extends VersionedParcelable> T getVersionedParcel() {
        return (T) this.mParcel;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        new VersionedParcelParcel(parcel).writeVersionedParcelable(this.mParcel);
    }

    /* INFO: renamed from: androidx.versionedparcelable.ParcelImpl$1, reason: invalid class name */
    static class AnonymousClass1 implements Parcelable.Creator<ParcelImpl> {
        AnonymousClass1() {
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelImpl[] newArray(int i) {
            return new ParcelImpl[i];
        }
    }
}
