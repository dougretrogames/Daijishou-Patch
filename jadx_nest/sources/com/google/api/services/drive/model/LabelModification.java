package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class LabelModification extends GenericJson {

    @Key
    private List<LabelFieldModification> fieldModifications;

    @Key
    private String kind;

    @Key
    private String labelId;

    @Key
    private Boolean removeLabel;

    static {
        Data.nullOf(LabelFieldModification.class);
    }

    public List<LabelFieldModification> getFieldModifications() {
        return this.fieldModifications;
    }

    public LabelModification setFieldModifications(List<LabelFieldModification> list) {
        this.fieldModifications = list;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public LabelModification setKind(String str) {
        this.kind = str;
        return this;
    }

    public String getLabelId() {
        return this.labelId;
    }

    public LabelModification setLabelId(String str) {
        this.labelId = str;
        return this;
    }

    public Boolean getRemoveLabel() {
        return this.removeLabel;
    }

    public LabelModification setRemoveLabel(Boolean bool) {
        this.removeLabel = bool;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public LabelModification set(String str, Object obj) {
        return (LabelModification) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public LabelModification clone() {
        return (LabelModification) super.clone();
    }
}
