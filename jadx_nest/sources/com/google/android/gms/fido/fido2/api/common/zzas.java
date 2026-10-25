package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzas implements Parcelable.Creator {
    zzas() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        String string = parcel.readString();
        if (string == null) {
            string = "";
        }
        try {
            return ResidentKeyRequirement.fromString(string);
        } catch (ResidentKeyRequirement.UnsupportedResidentKeyRequirementException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new ResidentKeyRequirement[i];
    }
}
