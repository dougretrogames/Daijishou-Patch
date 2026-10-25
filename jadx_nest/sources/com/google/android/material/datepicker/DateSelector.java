package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.core.util.Pair;
import com.google.android.material.internal.ViewUtils;
import java.text.SimpleDateFormat;
import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public interface DateSelector<S> extends Parcelable {
    int getDefaultThemeResId(Context context);

    int getDefaultTitleResId();

    String getError();

    Collection<Long> getSelectedDays();

    Collection<Pair<Long, Long>> getSelectedRanges();

    S getSelection();

    String getSelectionContentDescription(Context context);

    String getSelectionDisplayString(Context context);

    boolean isSelectionComplete();

    View onCreateTextInputView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, OnSelectionChangedListener<S> onSelectionChangedListener);

    void select(long j);

    void setSelection(S s);

    void setTextInputFormat(SimpleDateFormat simpleDateFormat);

    static void showKeyboardWithAutoHideBehavior(EditText... editTextArr) {
        if (editTextArr.length == 0) {
            return;
        }
        DateSelector$$ExternalSyntheticLambda0 dateSelector$$ExternalSyntheticLambda0 = new DateSelector$$ExternalSyntheticLambda0(editTextArr);
        for (EditText editText : editTextArr) {
            editText.setOnFocusChangeListener(dateSelector$$ExternalSyntheticLambda0);
        }
        EditText editText2 = editTextArr[0];
        editText2.postDelayed(new DateSelector$$ExternalSyntheticLambda1(editText2), 100L);
    }

    static /* synthetic */ void lambda$showKeyboardWithAutoHideBehavior$0(EditText[] editTextArr, View view, boolean z) {
        for (EditText editText : editTextArr) {
            if (editText.hasFocus()) {
                return;
            }
        }
        ViewUtils.hideKeyboard(view, false);
    }
}
