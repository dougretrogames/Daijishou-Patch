package org.eclipse.jgit.diff;

import org.apache.commons.collections4.CollectionUtils;

/* INFO: loaded from: classes5.dex */
public class Edit {
    int beginA;
    int beginB;
    int endA;
    int endB;

    public enum Type {
        INSERT,
        DELETE,
        REPLACE,
        EMPTY;

        /* INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static Type[] valuesCustom() {
            Type[] typeArrValuesCustom = values();
            int length = typeArrValuesCustom.length;
            Type[] typeArr = new Type[length];
            System.arraycopy(typeArrValuesCustom, 0, typeArr, 0, length);
            return typeArr;
        }
    }

    public Edit(int i, int i2) {
        this(i, i, i2, i2);
    }

    public Edit(int i, int i2, int i3, int i4) {
        this.beginA = i;
        this.endA = i2;
        this.beginB = i3;
        this.endB = i4;
    }

    public final Type getType() {
        if (this.beginA < this.endA) {
            if (this.beginB < this.endB) {
                return Type.REPLACE;
            }
            return Type.DELETE;
        }
        if (this.beginB < this.endB) {
            return Type.INSERT;
        }
        return Type.EMPTY;
    }

    public final boolean isEmpty() {
        return this.beginA == this.endA && this.beginB == this.endB;
    }

    public final int getBeginA() {
        return this.beginA;
    }

    public final int getEndA() {
        return this.endA;
    }

    public final int getBeginB() {
        return this.beginB;
    }

    public final int getEndB() {
        return this.endB;
    }

    public final int getLengthA() {
        return this.endA - this.beginA;
    }

    public final int getLengthB() {
        return this.endB - this.beginB;
    }

    public final void shift(int i) {
        this.beginA += i;
        this.endA += i;
        this.beginB += i;
        this.endB += i;
    }

    public final Edit before(Edit edit) {
        return new Edit(this.beginA, edit.beginA, this.beginB, edit.beginB);
    }

    public final Edit after(Edit edit) {
        return new Edit(edit.endA, this.endA, edit.endB, this.endB);
    }

    public void extendA() {
        this.endA++;
    }

    public void extendB() {
        this.endB++;
    }

    public void swap() {
        int i = this.beginA;
        int i2 = this.endA;
        this.beginA = this.beginB;
        this.endA = this.endB;
        this.beginB = i;
        this.endB = i2;
    }

    public int hashCode() {
        return this.beginA ^ this.endA;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Edit) {
            Edit edit = (Edit) obj;
            if (this.beginA == edit.beginA && this.endA == edit.endA && this.beginB == edit.beginB && this.endB == edit.endB) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return String.valueOf(getType()) + "(" + this.beginA + "-" + this.endA + CollectionUtils.COMMA + this.beginB + "-" + this.endB + ")";
    }
}
