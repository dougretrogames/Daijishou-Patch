package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* INFO: loaded from: classes3.dex */
public class DateValidatorPointForward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointForward> CREATOR = new AnonymousClass1();
    private final long point;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ DateValidatorPointForward(long j, AnonymousClass1 anonymousClass1) {
        this(j);
    }

    private DateValidatorPointForward(long j) {
        this.point = j;
    }

    public static DateValidatorPointForward from(long j) {
        return new DateValidatorPointForward(j);
    }

    public static DateValidatorPointForward now() {
        return from(UtcDates.getTodayCalendar().getTimeInMillis());
    }

    /* INFO: renamed from: com.google.android.material.datepicker.DateValidatorPointForward$1, reason: invalid class name */
    class AnonymousClass1 implements Parcelable.Creator<DateValidatorPointForward> {
        AnonymousClass1() {
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DateValidatorPointForward createFromParcel(Parcel parcel) {
            return new DateValidatorPointForward(parcel.readLong(), null);
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DateValidatorPointForward[] newArray(int i) {
            return new DateValidatorPointForward[i];
        }
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean isValid(long j) {
        return j >= this.point;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.point);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DateValidatorPointForward) && this.point == ((DateValidatorPointForward) obj).point;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.point)});
    }
}
