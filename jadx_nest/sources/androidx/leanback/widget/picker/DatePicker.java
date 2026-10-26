package androidx.leanback.widget.picker;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.view.ViewCompat;
import androidx.leanback.R;
import com.google.android.material.timepicker.TimeModel;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* INFO: loaded from: classes.dex */
public class DatePicker extends Picker {
    private static final int[] DATE_FIELDS = {5, 2, 1};
    private static final String DATE_FORMAT = "MM/dd/yyyy";
    private static final String LOG_TAG = "DatePicker";
    private int mColDayIndex;
    private int mColMonthIndex;
    private int mColYearIndex;
    private PickerUtility.DateConstant mConstant;
    private Calendar mCurrentDate;
    private final DateFormat mDateFormat;
    private String mDatePickerFormat;
    private PickerColumn mDayColumn;
    private Calendar mMaxDate;
    private Calendar mMinDate;
    private PickerColumn mMonthColumn;
    private Calendar mTempDate;
    private PickerColumn mYearColumn;

    public DatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.datePickerStyle);
    }

    public DatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
        updateCurrentLocale();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbDatePicker);
        ViewCompat.saveAttributeDataForStyleable(this, context, R.styleable.lbDatePicker, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        try {
            String string = typedArrayObtainStyledAttributes.getString(R.styleable.lbDatePicker_android_minDate);
            String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.lbDatePicker_android_maxDate);
            String string3 = typedArrayObtainStyledAttributes.getString(R.styleable.lbDatePicker_datePickerFormat);
            typedArrayObtainStyledAttributes.recycle();
            this.mTempDate.clear();
            if (TextUtils.isEmpty(string) || !parseDate(string, this.mTempDate)) {
                this.mTempDate.set(1900, 0, 1);
            }
            this.mMinDate.setTimeInMillis(this.mTempDate.getTimeInMillis());
            this.mTempDate.clear();
            if (TextUtils.isEmpty(string2) || !parseDate(string2, this.mTempDate)) {
                this.mTempDate.set(2100, 0, 1);
            }
            this.mMaxDate.setTimeInMillis(this.mTempDate.getTimeInMillis());
            setDatePickerFormat(TextUtils.isEmpty(string3) ? new String(android.text.format.DateFormat.getDateFormatOrder(context)) : string3);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private boolean parseDate(String str, Calendar calendar) {
        try {
            calendar.setTime(this.mDateFormat.parse(str));
            return true;
        } catch (ParseException unused) {
            Log.w(LOG_TAG, "Date: " + str + " not in format: MM/dd/yyyy");
            return false;
        }
    }

    String getBestYearMonthDayPattern(String str) {
        String bestDateTimePattern = android.text.format.DateFormat.getBestDateTimePattern(this.mConstant.locale, str);
        return TextUtils.isEmpty(bestDateTimePattern) ? DATE_FORMAT : bestDateTimePattern;
    }

    List<CharSequence> extractSeparators() {
        String bestYearMonthDayPattern = getBestYearMonthDayPattern(this.mDatePickerFormat);
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        char[] cArr = {'Y', 'y', 'M', 'm', 'D', 'd'};
        boolean z = false;
        char c = 0;
        for (int i = 0; i < bestYearMonthDayPattern.length(); i++) {
            char cCharAt = bestYearMonthDayPattern.charAt(i);
            if (cCharAt != ' ') {
                if (cCharAt != '\'') {
                    if (z || !isAnyOf(cCharAt, cArr)) {
                        sb.append(cCharAt);
                    } else if (cCharAt != c) {
                        arrayList.add(sb.toString());
                        sb.setLength(0);
                    }
                    c = cCharAt;
                } else if (z) {
                    z = false;
                } else {
                    sb.setLength(0);
                    z = true;
                }
            }
        }
        arrayList.add(sb.toString());
        return arrayList;
    }

    private static boolean isAnyOf(char c, char[] cArr) {
        for (char c2 : cArr) {
            if (c == c2) {
                return true;
            }
        }
        return false;
    }

    public void setDatePickerFormat(String str) {
        if (TextUtils.isEmpty(str)) {
            str = new String(android.text.format.DateFormat.getDateFormatOrder(getContext()));
        }
        if (TextUtils.equals(this.mDatePickerFormat, str)) {
            return;
        }
        this.mDatePickerFormat = str;
        List<CharSequence> listExtractSeparators = extractSeparators();
        if (listExtractSeparators.size() != str.length() + 1) {
            throw new IllegalStateException("Separators size: " + listExtractSeparators.size() + " must equal the size of datePickerFormat: " + str.length() + " + 1");
        }
        setSeparators(listExtractSeparators);
        this.mDayColumn = null;
        this.mMonthColumn = null;
        this.mYearColumn = null;
        this.mColMonthIndex = -1;
        this.mColDayIndex = -1;
        this.mColYearIndex = -1;
        String upperCase = str.toUpperCase(this.mConstant.locale);
        ArrayList arrayList = new ArrayList(3);
        for (int i = 0; i < upperCase.length(); i++) {
            char cCharAt = upperCase.charAt(i);
            if (cCharAt == 'D') {
                if (this.mDayColumn != null) {
                    throw new IllegalArgumentException("datePicker format error");
                }
                PickerColumn pickerColumn = new PickerColumn();
                this.mDayColumn = pickerColumn;
                arrayList.add(pickerColumn);
                this.mDayColumn.setLabelFormat(TimeModel.ZERO_LEADING_NUMBER_FORMAT);
                this.mColDayIndex = i;
            } else if (cCharAt == 'M') {
                if (this.mMonthColumn != null) {
                    throw new IllegalArgumentException("datePicker format error");
                }
                PickerColumn pickerColumn2 = new PickerColumn();
                this.mMonthColumn = pickerColumn2;
                arrayList.add(pickerColumn2);
                this.mMonthColumn.setStaticLabels(this.mConstant.months);
                this.mColMonthIndex = i;
            } else if (cCharAt == 'Y') {
                if (this.mYearColumn != null) {
                    throw new IllegalArgumentException("datePicker format error");
                }
                PickerColumn pickerColumn3 = new PickerColumn();
                this.mYearColumn = pickerColumn3;
                arrayList.add(pickerColumn3);
                this.mColYearIndex = i;
                this.mYearColumn.setLabelFormat(TimeModel.NUMBER_FORMAT);
            } else {
                throw new IllegalArgumentException("datePicker format error");
            }
        }
        setColumns(arrayList);
        updateSpinners(false);
    }

    public String getDatePickerFormat() {
        return this.mDatePickerFormat;
    }

    private void updateCurrentLocale() {
        PickerUtility.DateConstant dateConstantInstance = PickerUtility.getDateConstantInstance(Locale.getDefault(), getContext().getResources());
        this.mConstant = dateConstantInstance;
        this.mTempDate = PickerUtility.getCalendarForLocale(this.mTempDate, dateConstantInstance.locale);
        this.mMinDate = PickerUtility.getCalendarForLocale(this.mMinDate, this.mConstant.locale);
        this.mMaxDate = PickerUtility.getCalendarForLocale(this.mMaxDate, this.mConstant.locale);
        this.mCurrentDate = PickerUtility.getCalendarForLocale(this.mCurrentDate, this.mConstant.locale);
        PickerColumn pickerColumn = this.mMonthColumn;
        if (pickerColumn != null) {
            pickerColumn.setStaticLabels(this.mConstant.months);
            setColumnAt(this.mColMonthIndex, this.mMonthColumn);
        }
    }

    @Override // androidx.leanback.widget.picker.Picker
    public final void onColumnValueChanged(int i, int i2) {
        this.mTempDate.setTimeInMillis(this.mCurrentDate.getTimeInMillis());
        int currentValue = getColumnAt(i).getCurrentValue();
        if (i == this.mColDayIndex) {
            this.mTempDate.add(5, i2 - currentValue);
        } else if (i == this.mColMonthIndex) {
            this.mTempDate.add(2, i2 - currentValue);
        } else if (i == this.mColYearIndex) {
            this.mTempDate.add(1, i2 - currentValue);
        } else {
            throw new IllegalArgumentException();
        }
        setDate(this.mTempDate.get(1), this.mTempDate.get(2), this.mTempDate.get(5));
    }

    public void setMinDate(long j) {
        this.mTempDate.setTimeInMillis(j);
        if (this.mTempDate.get(1) != this.mMinDate.get(1) || this.mTempDate.get(6) == this.mMinDate.get(6)) {
            this.mMinDate.setTimeInMillis(j);
            if (this.mCurrentDate.before(this.mMinDate)) {
                this.mCurrentDate.setTimeInMillis(this.mMinDate.getTimeInMillis());
            }
            updateSpinners(false);
        }
    }

    public long getMinDate() {
        return this.mMinDate.getTimeInMillis();
    }

    public void setMaxDate(long j) {
        this.mTempDate.setTimeInMillis(j);
        if (this.mTempDate.get(1) != this.mMaxDate.get(1) || this.mTempDate.get(6) == this.mMaxDate.get(6)) {
            this.mMaxDate.setTimeInMillis(j);
            if (this.mCurrentDate.after(this.mMaxDate)) {
                this.mCurrentDate.setTimeInMillis(this.mMaxDate.getTimeInMillis());
            }
            updateSpinners(false);
        }
    }

    public long getMaxDate() {
        return this.mMaxDate.getTimeInMillis();
    }

    public long getDate() {
        return this.mCurrentDate.getTimeInMillis();
    }

    private void setDate(int i, int i2, int i3) {
        setDate(i, i2, i3, false);
    }

    public void setDate(long j) {
        this.mTempDate.setTimeInMillis(j);
        setDate(this.mTempDate.get(1), this.mTempDate.get(2), this.mTempDate.get(5), false);
    }

    public void setDate(int i, int i2, int i3, boolean z) {
        if (isNewDate(i, i2, i3)) {
            this.mCurrentDate.set(i, i2, i3);
            if (this.mCurrentDate.before(this.mMinDate)) {
                this.mCurrentDate.setTimeInMillis(this.mMinDate.getTimeInMillis());
            } else if (this.mCurrentDate.after(this.mMaxDate)) {
                this.mCurrentDate.setTimeInMillis(this.mMaxDate.getTimeInMillis());
            }
            updateSpinners(z);
        }
    }

    private boolean isNewDate(int i, int i2, int i3) {
        return (this.mCurrentDate.get(1) == i && this.mCurrentDate.get(2) == i3 && this.mCurrentDate.get(5) == i2) ? false : true;
    }

    private static boolean updateMin(PickerColumn pickerColumn, int i) {
        if (i == pickerColumn.getMinValue()) {
            return false;
        }
        pickerColumn.setMinValue(i);
        return true;
    }

    private static boolean updateMax(PickerColumn pickerColumn, int i) {
        if (i == pickerColumn.getMaxValue()) {
            return false;
        }
        pickerColumn.setMaxValue(i);
        return true;
    }

    void updateSpinnersImpl(boolean z) {
        boolean zUpdateMin;
        boolean zUpdateMax;
        int[] iArr = {this.mColDayIndex, this.mColMonthIndex, this.mColYearIndex};
        boolean z2 = true;
        boolean z3 = true;
        for (int length = DATE_FIELDS.length - 1; length >= 0; length--) {
            int i = iArr[length];
            if (i >= 0) {
                int i2 = DATE_FIELDS[length];
                PickerColumn columnAt = getColumnAt(i);
                if (z2) {
                    zUpdateMin = updateMin(columnAt, this.mMinDate.get(i2));
                } else {
                    zUpdateMin = updateMin(columnAt, this.mCurrentDate.getActualMinimum(i2));
                }
                if (z3) {
                    zUpdateMax = updateMax(columnAt, this.mMaxDate.get(i2));
                } else {
                    zUpdateMax = updateMax(columnAt, this.mCurrentDate.getActualMaximum(i2));
                }
                boolean z4 = zUpdateMin | zUpdateMax;
                z2 &= this.mCurrentDate.get(i2) == this.mMinDate.get(i2);
                z3 &= this.mCurrentDate.get(i2) == this.mMaxDate.get(i2);
                if (z4) {
                    setColumnAt(iArr[length], columnAt);
                }
                setColumnValue(iArr[length], this.mCurrentDate.get(i2), z);
            }
        }
    }

    /* INFO: renamed from: androidx.leanback.widget.picker.DatePicker$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ boolean val$animation;

        AnonymousClass1(boolean z) {
            this.val$animation = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            DatePicker.this.updateSpinnersImpl(this.val$animation);
        }
    }

    private void updateSpinners(boolean z) {
        post(new AnonymousClass1(z));
    }
}
