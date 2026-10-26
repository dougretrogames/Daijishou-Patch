package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;

/* INFO: compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
/* INFO: loaded from: classes3.dex */
final class zzc implements Parcelable.Creator {
    zzc() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return ErrorCode.toErrorCode(parcel.readInt());
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new ErrorCode[i];
    }
}
