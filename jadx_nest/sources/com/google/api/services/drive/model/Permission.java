package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import java.util.List;

/* INFO: loaded from: classes3.dex */
public final class Permission extends GenericJson {

    @Key
    private Boolean allowFileDiscovery;

    @Key
    private Boolean deleted;

    @Key
    private String displayName;

    @Key
    private String domain;

    @Key
    private String emailAddress;

    @Key
    private DateTime expirationTime;

    /* INFO: renamed from: id, reason: collision with root package name */
    @Key
    private String f47id;

    @Key
    private String kind;

    @Key
    private Boolean pendingOwner;

    @Key
    private List<PermissionDetails> permissionDetails;

    @Key
    private String photoLink;

    @Key
    private String role;

    @Key
    private List<TeamDrivePermissionDetails> teamDrivePermissionDetails;

    @Key
    private String type;

    @Key
    private String view;

    static {
        Data.nullOf(PermissionDetails.class);
        Data.nullOf(TeamDrivePermissionDetails.class);
    }

    public Boolean getAllowFileDiscovery() {
        return this.allowFileDiscovery;
    }

    public Permission setAllowFileDiscovery(Boolean bool) {
        this.allowFileDiscovery = bool;
        return this;
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public Permission setDeleted(Boolean bool) {
        this.deleted = bool;
        return this;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public Permission setDisplayName(String str) {
        this.displayName = str;
        return this;
    }

    public String getDomain() {
        return this.domain;
    }

    public Permission setDomain(String str) {
        this.domain = str;
        return this;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public Permission setEmailAddress(String str) {
        this.emailAddress = str;
        return this;
    }

    public DateTime getExpirationTime() {
        return this.expirationTime;
    }

    public Permission setExpirationTime(DateTime dateTime) {
        this.expirationTime = dateTime;
        return this;
    }

    public String getId() {
        return this.f47id;
    }

    public Permission setId(String str) {
        this.f47id = str;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public Permission setKind(String str) {
        this.kind = str;
        return this;
    }

    public Boolean getPendingOwner() {
        return this.pendingOwner;
    }

    public Permission setPendingOwner(Boolean bool) {
        this.pendingOwner = bool;
        return this;
    }

    public List<PermissionDetails> getPermissionDetails() {
        return this.permissionDetails;
    }

    public Permission setPermissionDetails(List<PermissionDetails> list) {
        this.permissionDetails = list;
        return this;
    }

    public String getPhotoLink() {
        return this.photoLink;
    }

    public Permission setPhotoLink(String str) {
        this.photoLink = str;
        return this;
    }

    public String getRole() {
        return this.role;
    }

    public Permission setRole(String str) {
        this.role = str;
        return this;
    }

    public List<TeamDrivePermissionDetails> getTeamDrivePermissionDetails() {
        return this.teamDrivePermissionDetails;
    }

    public Permission setTeamDrivePermissionDetails(List<TeamDrivePermissionDetails> list) {
        this.teamDrivePermissionDetails = list;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public Permission setType(String str) {
        this.type = str;
        return this;
    }

    public String getView() {
        return this.view;
    }

    public Permission setView(String str) {
        this.view = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Permission set(String str, Object obj) {
        return (Permission) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Permission clone() {
        return (Permission) super.clone();
    }

    public static final class PermissionDetails extends GenericJson {

        @Key
        private Boolean inherited;

        @Key
        private String inheritedFrom;

        @Key
        private String permissionType;

        @Key
        private String role;

        public Boolean getInherited() {
            return this.inherited;
        }

        public PermissionDetails setInherited(Boolean bool) {
            this.inherited = bool;
            return this;
        }

        public String getInheritedFrom() {
            return this.inheritedFrom;
        }

        public PermissionDetails setInheritedFrom(String str) {
            this.inheritedFrom = str;
            return this;
        }

        public String getPermissionType() {
            return this.permissionType;
        }

        public PermissionDetails setPermissionType(String str) {
            this.permissionType = str;
            return this;
        }

        public String getRole() {
            return this.role;
        }

        public PermissionDetails setRole(String str) {
            this.role = str;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public PermissionDetails set(String str, Object obj) {
            return (PermissionDetails) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public PermissionDetails clone() {
            return (PermissionDetails) super.clone();
        }
    }

    public static final class TeamDrivePermissionDetails extends GenericJson {

        @Key
        private Boolean inherited;

        @Key
        private String inheritedFrom;

        @Key
        private String role;

        @Key
        private String teamDrivePermissionType;

        public Boolean getInherited() {
            return this.inherited;
        }

        public TeamDrivePermissionDetails setInherited(Boolean bool) {
            this.inherited = bool;
            return this;
        }

        public String getInheritedFrom() {
            return this.inheritedFrom;
        }

        public TeamDrivePermissionDetails setInheritedFrom(String str) {
            this.inheritedFrom = str;
            return this;
        }

        public String getRole() {
            return this.role;
        }

        public TeamDrivePermissionDetails setRole(String str) {
            this.role = str;
            return this;
        }

        public String getTeamDrivePermissionType() {
            return this.teamDrivePermissionType;
        }

        public TeamDrivePermissionDetails setTeamDrivePermissionType(String str) {
            this.teamDrivePermissionType = str;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public TeamDrivePermissionDetails set(String str, Object obj) {
            return (TeamDrivePermissionDetails) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public TeamDrivePermissionDetails clone() {
            return (TeamDrivePermissionDetails) super.clone();
        }
    }
}
