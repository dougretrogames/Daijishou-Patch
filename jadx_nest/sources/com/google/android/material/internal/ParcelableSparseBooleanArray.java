package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;

/* JADX INFO: loaded from: classes3.dex */
public class ParcelableSparseBooleanArray extends SparseBooleanArray implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseBooleanArray> CREATOR = new AnonymousClass1();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ParcelableSparseBooleanArray() {
    }

    public ParcelableSparseBooleanArray(int i) {
        super(i);
    }

    public ParcelableSparseBooleanArray(SparseBooleanArray sparseBooleanArray) {
        super(sparseBooleanArray.size());
        for (int i = 0; i < sparseBooleanArray.size(); i++) {
            put(sparseBooleanArray.keyAt(i), sparseBooleanArray.valueAt(i));
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int[] iArr = new int[size()];
        boolean[] zArr = new boolean[size()];
        for (int i2 = 0; i2 < size(); i2++) {
            iArr[i2] = keyAt(i2);
            zArr[i2] = valueAt(i2);
        }
        parcel.writeInt(size());
        parcel.writeIntArray(iArr);
        parcel.writeBooleanArray(zArr);
    }

    /* JADX INFO: renamed from: com.google.android.material.internal.ParcelableSparseBooleanArray$1, reason: invalid class name */
    class AnonymousClass1 implements Parcelable.Creator<ParcelableSparseBooleanArray> {
        AnonymousClass1() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableSparseBooleanArray createFromParcel(Parcel parcel) {
            int i = parcel.readInt();
            ParcelableSparseBooleanArray parcelableSparseBooleanArray = new ParcelableSparseBooleanArray(i);
            int[] iArr = new int[i];
            boolean[] zArr = new boolean[i];
            parcel.readIntArray(iArr);
            parcel.readBooleanArray(zArr);
            for (int i2 = 0; i2 < i; i2++) {
                parcelableSparseBooleanArray.put(iArr[i2], zArr[i2]);
            }
            return parcelableSparseBooleanArray;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableSparseBooleanArray[] newArray(int i) {
            return new ParcelableSparseBooleanArray[i];
        }
    }
}
