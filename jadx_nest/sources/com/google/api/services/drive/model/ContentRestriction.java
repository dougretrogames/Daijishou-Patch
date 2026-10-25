package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes3.dex */
public final class ContentRestriction extends GenericJson {

    @Key
    private Boolean ownerRestricted;

    @Key
    private Boolean readOnly;

    @Key
    private String reason;

    @Key
    private User restrictingUser;

    @Key
    private DateTime restrictionTime;

    @Key
    private Boolean systemRestricted;

    @Key
    private String type;

    public Boolean getOwnerRestricted() {
        return this.ownerRestricted;
    }

    public ContentRestriction setOwnerRestricted(Boolean bool) {
        this.ownerRestricted = bool;
        return this;
    }

    public Boolean getReadOnly() {
        return this.readOnly;
    }

    public ContentRestriction setReadOnly(Boolean bool) {
        this.readOnly = bool;
        return this;
    }

    public String getReason() {
        return this.reason;
    }

    public ContentRestriction setReason(String str) {
        this.reason = str;
        return this;
    }

    public User getRestrictingUser() {
        return this.restrictingUser;
    }

    public ContentRestriction setRestrictingUser(User user) {
        this.restrictingUser = user;
        return this;
    }

    public DateTime getRestrictionTime() {
        return this.restrictionTime;
    }

    public ContentRestriction setRestrictionTime(DateTime dateTime) {
        this.restrictionTime = dateTime;
        return this;
    }

    public Boolean getSystemRestricted() {
        return this.systemRestricted;
    }

    public ContentRestriction setSystemRestricted(Boolean bool) {
        this.systemRestricted = bool;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public ContentRestriction setType(String str) {
        this.type = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ContentRestriction set(String str, Object obj) {
        return (ContentRestriction) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ContentRestriction clone() {
        return (ContentRestriction) super.clone();
    }
}
