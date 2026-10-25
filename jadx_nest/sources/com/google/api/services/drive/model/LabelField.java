package com.google.api.services.drive.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class LabelField extends GenericJson {

    @Key
    private List<DateTime> dateString;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @Key
    private String f46id;

    @JsonString
    @Key(TypedValues.Custom.S_INT)
    private List<Long> integer__;

    @Key
    private String kind;

    @Key
    private List<String> selection;

    @Key
    private List<String> text;

    @Key
    private List<User> user;

    @Key
    private String valueType;

    public List<DateTime> getDateString() {
        return this.dateString;
    }

    public LabelField setDateString(List<DateTime> list) {
        this.dateString = list;
        return this;
    }

    public String getId() {
        return this.f46id;
    }

    public LabelField setId(String str) {
        this.f46id = str;
        return this;
    }

    public List<Long> getInteger() {
        return this.integer__;
    }

    public LabelField setInteger(List<Long> list) {
        this.integer__ = list;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public LabelField setKind(String str) {
        this.kind = str;
        return this;
    }

    public List<String> getSelection() {
        return this.selection;
    }

    public LabelField setSelection(List<String> list) {
        this.selection = list;
        return this;
    }

    public List<String> getText() {
        return this.text;
    }

    public LabelField setText(List<String> list) {
        this.text = list;
        return this;
    }

    public List<User> getUser() {
        return this.user;
    }

    public LabelField setUser(List<User> list) {
        this.user = list;
        return this;
    }

    public String getValueType() {
        return this.valueType;
    }

    public LabelField setValueType(String str) {
        this.valueType = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public LabelField set(String str, Object obj) {
        return (LabelField) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public LabelField clone() {
        return (LabelField) super.clone();
    }
}
