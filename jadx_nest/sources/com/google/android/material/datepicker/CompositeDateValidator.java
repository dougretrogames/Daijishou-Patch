package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class CompositeDateValidator implements CalendarConstraints.DateValidator {
    private static final int COMPARATOR_ALL_ID = 2;
    private static final int COMPARATOR_ANY_ID = 1;
    private final Operator operator;
    private final List<CalendarConstraints.DateValidator> validators;
    private static final Operator ANY_OPERATOR = new AnonymousClass1();
    private static final Operator ALL_OPERATOR = new AnonymousClass2();
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new AnonymousClass3();

    private interface Operator {
        int getId();

        boolean isValid(List<CalendarConstraints.DateValidator> list, long j);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ CompositeDateValidator(List list, Operator operator, AnonymousClass1 anonymousClass1) {
        this(list, operator);
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.CompositeDateValidator$1, reason: invalid class name */
    class AnonymousClass1 implements Operator {
        @Override // com.google.android.material.datepicker.CompositeDateValidator.Operator
        public int getId() {
            return 1;
        }

        AnonymousClass1() {
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.Operator
        public boolean isValid(List<CalendarConstraints.DateValidator> list, long j) {
            for (CalendarConstraints.DateValidator dateValidator : list) {
                if (dateValidator != null && dateValidator.isValid(j)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.CompositeDateValidator$2, reason: invalid class name */
    class AnonymousClass2 implements Operator {
        @Override // com.google.android.material.datepicker.CompositeDateValidator.Operator
        public int getId() {
            return 2;
        }

        AnonymousClass2() {
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.Operator
        public boolean isValid(List<CalendarConstraints.DateValidator> list, long j) {
            for (CalendarConstraints.DateValidator dateValidator : list) {
                if (dateValidator != null && !dateValidator.isValid(j)) {
                    return false;
                }
            }
            return true;
        }
    }

    private CompositeDateValidator(List<CalendarConstraints.DateValidator> list, Operator operator) {
        this.validators = list;
        this.operator = operator;
    }

    public static CalendarConstraints.DateValidator allOf(List<CalendarConstraints.DateValidator> list) {
        return new CompositeDateValidator(list, ALL_OPERATOR);
    }

    public static CalendarConstraints.DateValidator anyOf(List<CalendarConstraints.DateValidator> list) {
        return new CompositeDateValidator(list, ANY_OPERATOR);
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.CompositeDateValidator$3, reason: invalid class name */
    class AnonymousClass3 implements Parcelable.Creator<CompositeDateValidator> {
        AnonymousClass3() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CompositeDateValidator createFromParcel(Parcel parcel) {
            ArrayList arrayList = parcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader());
            int i = parcel.readInt();
            Operator operator = (i != 2 && i == 1) ? CompositeDateValidator.ANY_OPERATOR : CompositeDateValidator.ALL_OPERATOR;
            return new CompositeDateValidator((List) Preconditions.checkNotNull(arrayList), operator, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CompositeDateValidator[] newArray(int i) {
            return new CompositeDateValidator[i];
        }
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean isValid(long j) {
        return this.operator.isValid(this.validators, j);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.validators);
        parcel.writeInt(this.operator.getId());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompositeDateValidator)) {
            return false;
        }
        CompositeDateValidator compositeDateValidator = (CompositeDateValidator) obj;
        return this.validators.equals(compositeDateValidator.validators) && this.operator.getId() == compositeDateValidator.operator.getId();
    }

    public int hashCode() {
        return this.validators.hashCode();
    }
}
