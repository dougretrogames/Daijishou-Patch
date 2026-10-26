package com.google.protobuf;

/* INFO: loaded from: classes4.dex */
@CheckReturnValue
final class OneofInfo {
    private final java.lang.reflect.Field caseField;

    /* INFO: renamed from: id, reason: collision with root package name */
    private final int f63id;
    private final java.lang.reflect.Field valueField;

    public OneofInfo(int id2, java.lang.reflect.Field caseField, java.lang.reflect.Field valueField) {
        this.f63id = id2;
        this.caseField = caseField;
        this.valueField = valueField;
    }

    public int getId() {
        return this.f63id;
    }

    public java.lang.reflect.Field getCaseField() {
        return this.caseField;
    }

    public java.lang.reflect.Field getValueField() {
        return this.valueField;
    }
}
