package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public enum zzay implements Parcelable {
    USER_VERIFICATION_REQUIRED(ConfigConstants.CONFIG_KEY_REQUIRED),
    USER_VERIFICATION_PREFERRED("preferred"),
    USER_VERIFICATION_DISCOURAGED("discouraged");

    public static final Parcelable.Creator<zzay> CREATOR = new zzaw();
    private final String zze;

    zzay(String str) {
        this.zze = str;
    }

    public static zzay zza(String str) throws zzax {
        for (zzay zzayVar : values()) {
            if (str.equals(zzayVar.zze)) {
                return zzayVar;
            }
        }
        throw new zzax(str);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.zze;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zze);
    }
}
