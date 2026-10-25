package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.core.util.Pair;
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new AnonymousClass2();
    private CharSequence error;
    private Long selectedItem;
    private SimpleDateFormat textInputFormat;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void select(long j) {
        this.selectedItem = Long.valueOf(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSelection() {
        this.selectedItem = null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void setSelection(Long l) {
        this.selectedItem = l == null ? null : Long.valueOf(UtcDates.canonicalYearMonthDay(l.longValue()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        return this.selectedItem != null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<Pair<Long, Long>> getSelectedRanges() {
        return new ArrayList();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<Long> getSelectedDays() {
        ArrayList arrayList = new ArrayList();
        Long l = this.selectedItem;
        if (l != null) {
            arrayList.add(l);
        }
        return arrayList;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    public Long getSelection() {
        return this.selectedItem;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void setTextInputFormat(SimpleDateFormat simpleDateFormat) {
        if (simpleDateFormat != null) {
            simpleDateFormat = (SimpleDateFormat) UtcDates.getNormalizedFormat(simpleDateFormat);
        }
        this.textInputFormat = simpleDateFormat;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View onCreateTextInputView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, OnSelectionChangedListener<Long> onSelectionChangedListener) {
        String defaultTextInputHint;
        View viewInflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R.id.mtrl_picker_text_input_date);
        EditText editText = textInputLayout.getEditText();
        if (ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters()) {
            editText.setInputType(17);
        }
        SimpleDateFormat defaultTextInputFormat = this.textInputFormat;
        boolean z = defaultTextInputFormat != null;
        if (!z) {
            defaultTextInputFormat = UtcDates.getDefaultTextInputFormat();
        }
        SimpleDateFormat simpleDateFormat = defaultTextInputFormat;
        if (z) {
            defaultTextInputHint = simpleDateFormat.toPattern();
        } else {
            defaultTextInputHint = UtcDates.getDefaultTextInputHint(viewInflate.getResources(), simpleDateFormat);
        }
        String str = defaultTextInputHint;
        textInputLayout.setPlaceholderText(str);
        Long l = this.selectedItem;
        if (l != null) {
            editText.setText(simpleDateFormat.format(l));
        }
        editText.addTextChangedListener(new AnonymousClass1(str, simpleDateFormat, textInputLayout, calendarConstraints, onSelectionChangedListener, textInputLayout));
        DateSelector.showKeyboardWithAutoHideBehavior(editText);
        return viewInflate;
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.SingleDateSelector$1, reason: invalid class name */
    class AnonymousClass1 extends DateFormatTextWatcher {
        final /* synthetic */ TextInputLayout val$dateTextInput;
        final /* synthetic */ OnSelectionChangedListener val$listener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, OnSelectionChangedListener onSelectionChangedListener, TextInputLayout textInputLayout2) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.val$listener = onSelectionChangedListener;
            this.val$dateTextInput = textInputLayout2;
        }

        @Override // com.google.android.material.datepicker.DateFormatTextWatcher
        void onValidDate(Long l) {
            if (l == null) {
                SingleDateSelector.this.clearSelection();
            } else {
                SingleDateSelector.this.select(l.longValue());
            }
            SingleDateSelector.this.error = null;
            this.val$listener.onSelectionChanged(SingleDateSelector.this.getSelection());
        }

        @Override // com.google.android.material.datepicker.DateFormatTextWatcher
        void onInvalidDate() {
            SingleDateSelector.this.error = this.val$dateTextInput.getError();
            this.val$listener.onIncompleteSelectionChanged();
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultThemeResId(Context context) {
        return MaterialAttributes.resolveOrThrow(context, R.attr.materialCalendarTheme, MaterialDatePicker.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String getSelectionDisplayString(Context context) {
        Resources resources = context.getResources();
        Long l = this.selectedItem;
        if (l == null) {
            return resources.getString(R.string.mtrl_picker_date_header_unselected);
        }
        return resources.getString(R.string.mtrl_picker_date_header_selected, DateStrings.getYearMonthDay(l.longValue()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String getSelectionContentDescription(Context context) {
        String yearMonthDay;
        Resources resources = context.getResources();
        Long l = this.selectedItem;
        if (l == null) {
            yearMonthDay = resources.getString(R.string.mtrl_picker_announce_current_selection_none);
        } else {
            yearMonthDay = DateStrings.getYearMonthDay(l.longValue());
        }
        return resources.getString(R.string.mtrl_picker_announce_current_selection, yearMonthDay);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String getError() {
        if (TextUtils.isEmpty(this.error)) {
            return null;
        }
        return this.error.toString();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultTitleResId() {
        return R.string.mtrl_picker_date_header_title;
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.SingleDateSelector$2, reason: invalid class name */
    class AnonymousClass2 implements Parcelable.Creator<SingleDateSelector> {
        AnonymousClass2() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SingleDateSelector createFromParcel(Parcel parcel) {
            SingleDateSelector singleDateSelector = new SingleDateSelector();
            singleDateSelector.selectedItem = (Long) parcel.readValue(Long.class.getClassLoader());
            return singleDateSelector;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SingleDateSelector[] newArray(int i) {
            return new SingleDateSelector[i];
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.selectedItem);
    }
}
