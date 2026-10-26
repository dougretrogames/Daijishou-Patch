package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* INFO: loaded from: classes3.dex */
public final class AppIcons extends GenericJson {

    @Key
    private String category;

    @Key
    private String iconUrl;

    @Key
    private Integer size;

    public String getCategory() {
        return this.category;
    }

    public AppIcons setCategory(String str) {
        this.category = str;
        return this;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public AppIcons setIconUrl(String str) {
        this.iconUrl = str;
        return this;
    }

    public Integer getSize() {
        return this.size;
    }

    public AppIcons setSize(Integer num) {
        this.size = num;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public AppIcons set(String str, Object obj) {
        return (AppIcons) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public AppIcons clone() {
        return (AppIcons) super.clone();
    }
}
