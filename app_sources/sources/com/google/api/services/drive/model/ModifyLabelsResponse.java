package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* INFO: loaded from: classes3.dex */
public final class ModifyLabelsResponse extends GenericJson {

    @Key
    private String kind;

    @Key
    private List<Label> modifiedLabels;

    static {
        Data.nullOf(Label.class);
    }

    public String getKind() {
        return this.kind;
    }

    public ModifyLabelsResponse setKind(String str) {
        this.kind = str;
        return this;
    }

    public List<Label> getModifiedLabels() {
        return this.modifiedLabels;
    }

    public ModifyLabelsResponse setModifiedLabels(List<Label> list) {
        this.modifiedLabels = list;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ModifyLabelsResponse set(String str, Object obj) {
        return (ModifyLabelsResponse) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ModifyLabelsResponse clone() {
        return (ModifyLabelsResponse) super.clone();
    }
}
