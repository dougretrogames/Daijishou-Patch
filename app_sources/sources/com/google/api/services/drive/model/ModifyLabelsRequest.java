package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* INFO: loaded from: classes3.dex */
public final class ModifyLabelsRequest extends GenericJson {

    @Key
    private String kind;

    @Key
    private List<LabelModification> labelModifications;

    static {
        Data.nullOf(LabelModification.class);
    }

    public String getKind() {
        return this.kind;
    }

    public ModifyLabelsRequest setKind(String str) {
        this.kind = str;
        return this;
    }

    public List<LabelModification> getLabelModifications() {
        return this.labelModifications;
    }

    public ModifyLabelsRequest setLabelModifications(List<LabelModification> list) {
        this.labelModifications = list;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ModifyLabelsRequest set(String str, Object obj) {
        return (ModifyLabelsRequest) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ModifyLabelsRequest clone() {
        return (ModifyLabelsRequest) super.clone();
    }
}
