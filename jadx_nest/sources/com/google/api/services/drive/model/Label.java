package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class Label extends GenericJson {

    @Key
    private Map<String, LabelField> fields;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @Key
    private String f45id;

    @Key
    private String kind;

    @Key
    private String revisionId;

    public Map<String, LabelField> getFields() {
        return this.fields;
    }

    public Label setFields(Map<String, LabelField> map) {
        this.fields = map;
        return this;
    }

    public String getId() {
        return this.f45id;
    }

    public Label setId(String str) {
        this.f45id = str;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public Label setKind(String str) {
        this.kind = str;
        return this;
    }

    public String getRevisionId() {
        return this.revisionId;
    }

    public Label setRevisionId(String str) {
        this.revisionId = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Label set(String str, Object obj) {
        return (Label) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Label clone() {
        return (Label) super.clone();
    }
}
