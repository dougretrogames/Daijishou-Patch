package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import java.util.List;

/* INFO: loaded from: classes3.dex */
public final class LabelFieldModification extends GenericJson {

    @Key
    private String fieldId;

    @Key
    private String kind;

    @Key
    private List<DateTime> setDateValues;

    @JsonString
    @Key
    private List<Long> setIntegerValues;

    @Key
    private List<String> setSelectionValues;

    @Key
    private List<String> setTextValues;

    @Key
    private List<String> setUserValues;

    @Key
    private Boolean unsetValues;

    public String getFieldId() {
        return this.fieldId;
    }

    public LabelFieldModification setFieldId(String str) {
        this.fieldId = str;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public LabelFieldModification setKind(String str) {
        this.kind = str;
        return this;
    }

    public List<DateTime> getSetDateValues() {
        return this.setDateValues;
    }

    public LabelFieldModification setSetDateValues(List<DateTime> list) {
        this.setDateValues = list;
        return this;
    }

    public List<Long> getSetIntegerValues() {
        return this.setIntegerValues;
    }

    public LabelFieldModification setSetIntegerValues(List<Long> list) {
        this.setIntegerValues = list;
        return this;
    }

    public List<String> getSetSelectionValues() {
        return this.setSelectionValues;
    }

    public LabelFieldModification setSetSelectionValues(List<String> list) {
        this.setSelectionValues = list;
        return this;
    }

    public List<String> getSetTextValues() {
        return this.setTextValues;
    }

    public LabelFieldModification setSetTextValues(List<String> list) {
        this.setTextValues = list;
        return this;
    }

    public List<String> getSetUserValues() {
        return this.setUserValues;
    }

    public LabelFieldModification setSetUserValues(List<String> list) {
        this.setUserValues = list;
        return this;
    }

    public Boolean getUnsetValues() {
        return this.unsetValues;
    }

    public LabelFieldModification setUnsetValues(Boolean bool) {
        this.unsetValues = bool;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public LabelFieldModification set(String str, Object obj) {
        return (LabelFieldModification) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public LabelFieldModification clone() {
        return (LabelFieldModification) super.clone();
    }
}
