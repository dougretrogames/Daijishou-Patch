package androidx.leanback.widget.picker;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import androidx.core.view.ViewCompat;
import androidx.leanback.R;
import com.google.android.material.timepicker.TimeModel;
import java.util.ArrayList;

/* INFO: loaded from: classes.dex */
public class PinPicker extends Picker {
    private static final int DEFAULT_COLUMN_COUNT = 4;

    public PinPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.pinPickerStyle);
    }

    public PinPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbPinPicker, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, R.styleable.lbPinPicker, attributeSet, typedArrayObtainStyledAttributes, i, 0);
        try {
            setSeparator(" ");
            setNumberOfColumns(typedArrayObtainStyledAttributes.getInt(R.styleable.lbPinPicker_columnCount, 4));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void setNumberOfColumns(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            PickerColumn pickerColumn = new PickerColumn();
            pickerColumn.setMinValue(0);
            pickerColumn.setMaxValue(9);
            pickerColumn.setLabelFormat(TimeModel.NUMBER_FORMAT);
            arrayList.add(pickerColumn);
        }
        setColumns(arrayList);
    }

    @Override // android.view.View
    public boolean performClick() {
        int selectedColumn = getSelectedColumn();
        if (selectedColumn == getColumnsCount() - 1) {
            return super.performClick();
        }
        setSelectedColumn(selectedColumn + 1);
        return false;
    }

    @Override // androidx.leanback.widget.picker.Picker, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() == 1 && keyCode >= 7 && keyCode <= 16) {
            setColumnValue(getSelectedColumn(), keyCode - 7, false);
            performClick();
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public String getPin() {
        StringBuilder sb = new StringBuilder();
        int columnsCount = getColumnsCount();
        for (int i = 0; i < columnsCount; i++) {
            sb.append(Integer.toString(getColumnAt(i).getCurrentValue()));
        }
        return sb.toString();
    }

    public void resetPin() {
        int columnsCount = getColumnsCount();
        for (int i = 0; i < columnsCount; i++) {
            setColumnValue(i, 0, false);
        }
        setSelectedColumn(0);
    }
}
