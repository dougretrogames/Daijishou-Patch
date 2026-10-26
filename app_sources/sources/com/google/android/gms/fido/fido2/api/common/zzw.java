package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;

/* INFO: compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
/* INFO: loaded from: classes3.dex */
final class zzw implements Parcelable.Creator {
    zzw() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        try {
            return ErrorCode.toErrorCode(parcel.readInt());
        } catch (ErrorCode.UnsupportedErrorCodeException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new ErrorCode[i];
    }
}
