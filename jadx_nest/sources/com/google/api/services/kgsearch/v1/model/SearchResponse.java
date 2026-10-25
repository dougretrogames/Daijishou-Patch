package com.google.api.services.kgsearch.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class SearchResponse extends GenericJson {

    @Key("@context")
    private Object context;

    @Key
    private List<Object> itemListElement;

    @Key("@type")
    private Object type;

    public Object getContext() {
        return this.context;
    }

    public SearchResponse setContext(Object obj) {
        this.context = obj;
        return this;
    }

    public Object getType() {
        return this.type;
    }

    public SearchResponse setType(Object obj) {
        this.type = obj;
        return this;
    }

    public List<Object> getItemListElement() {
        return this.itemListElement;
    }

    public SearchResponse setItemListElement(List<Object> list) {
        this.itemListElement = list;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public SearchResponse set(String str, Object obj) {
        return (SearchResponse) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public SearchResponse clone() {
        return (SearchResponse) super.clone();
    }
}
