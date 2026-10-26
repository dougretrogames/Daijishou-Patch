package androidx.customview.view;

import android.os.Parcel;
import android.os.Parcelable;

/* INFO: loaded from: classes.dex */
public abstract class AbsSavedState implements Parcelable {
    private final Parcelable mSuperState;
    public static final AbsSavedState EMPTY_STATE = new AnonymousClass1();
    public static final Parcelable.Creator<AbsSavedState> CREATOR = new AnonymousClass2();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* INFO: renamed from: androidx.customview.view.AbsSavedState$1, reason: invalid class name */
    class AnonymousClass1 extends AbsSavedState {
        AnonymousClass1() {
            super((AnonymousClass1) null);
        }
    }

    /* synthetic */ AbsSavedState(AnonymousClass1 anonymousClass1) {
        this();
    }

    private AbsSavedState() {
        this.mSuperState = null;
    }

    protected AbsSavedState(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        this.mSuperState = parcelable == EMPTY_STATE ? null : parcelable;
    }

    protected AbsSavedState(Parcel parcel) {
        this(parcel, null);
    }

    protected AbsSavedState(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.mSuperState = parcelable == null ? EMPTY_STATE : parcelable;
    }

    public final Parcelable getSuperState() {
        return this.mSuperState;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mSuperState, i);
    }

    /* INFO: renamed from: androidx.customview.view.AbsSavedState$2, reason: invalid class name */
    class AnonymousClass2 implements Parcelable.ClassLoaderCreator<AbsSavedState> {
        AnonymousClass2() {
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.ClassLoaderCreator
        public AbsSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) != null) {
                throw new IllegalStateException("superState must be null");
            }
            return AbsSavedState.EMPTY_STATE;
        }

        @Override // android.os.Parcelable.Creator
        public AbsSavedState createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, (ClassLoader) null);
        }

        @Override // android.os.Parcelable.Creator
        public AbsSavedState[] newArray(int i) {
            return new AbsSavedState[i];
        }
    }
}
