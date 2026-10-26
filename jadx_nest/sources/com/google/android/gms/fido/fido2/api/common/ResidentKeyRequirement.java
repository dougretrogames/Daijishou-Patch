package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
/* INFO: loaded from: classes3.dex */
public enum ResidentKeyRequirement implements Parcelable {
    RESIDENT_KEY_DISCOURAGED("discouraged"),
    RESIDENT_KEY_PREFERRED("preferred"),
    RESIDENT_KEY_REQUIRED(ConfigConstants.CONFIG_KEY_REQUIRED);

    public static final Parcelable.Creator<ResidentKeyRequirement> CREATOR = new zzas();
    private final String zzb;

    /* INFO: compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
    public static class UnsupportedResidentKeyRequirementException extends Exception {
        public UnsupportedResidentKeyRequirementException(String str) {
            super(String.format("Resident key requirement %s not supported", str));
        }
    }

    ResidentKeyRequirement(String str) {
        this.zzb = str;
    }

    public static ResidentKeyRequirement fromString(String str) throws UnsupportedResidentKeyRequirementException {
        for (ResidentKeyRequirement residentKeyRequirement : values()) {
            if (str.equals(residentKeyRequirement.zzb)) {
                return residentKeyRequirement;
            }
        }
        throw new UnsupportedResidentKeyRequirementException(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.zzb;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzb);
    }
}
