package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;

/* INFO: loaded from: classes3.dex */
public final class Drive extends GenericJson {

    @Key
    private BackgroundImageFile backgroundImageFile;

    @Key
    private String backgroundImageLink;

    @Key
    private Capabilities capabilities;

    @Key
    private String colorRgb;

    @Key
    private DateTime createdTime;

    @Key
    private Boolean hidden;

    /* INFO: renamed from: id, reason: collision with root package name */
    @Key
    private String f42id;

    @Key
    private String kind;

    @Key
    private String name;

    @Key
    private String orgUnitId;

    @Key
    private Restrictions restrictions;

    @Key
    private String themeId;

    public BackgroundImageFile getBackgroundImageFile() {
        return this.backgroundImageFile;
    }

    public Drive setBackgroundImageFile(BackgroundImageFile backgroundImageFile) {
        this.backgroundImageFile = backgroundImageFile;
        return this;
    }

    public String getBackgroundImageLink() {
        return this.backgroundImageLink;
    }

    public Drive setBackgroundImageLink(String str) {
        this.backgroundImageLink = str;
        return this;
    }

    public Capabilities getCapabilities() {
        return this.capabilities;
    }

    public Drive setCapabilities(Capabilities capabilities) {
        this.capabilities = capabilities;
        return this;
    }

    public String getColorRgb() {
        return this.colorRgb;
    }

    public Drive setColorRgb(String str) {
        this.colorRgb = str;
        return this;
    }

    public DateTime getCreatedTime() {
        return this.createdTime;
    }

    public Drive setCreatedTime(DateTime dateTime) {
        this.createdTime = dateTime;
        return this;
    }

    public Boolean getHidden() {
        return this.hidden;
    }

    public Drive setHidden(Boolean bool) {
        this.hidden = bool;
        return this;
    }

    public String getId() {
        return this.f42id;
    }

    public Drive setId(String str) {
        this.f42id = str;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public Drive setKind(String str) {
        this.kind = str;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Drive setName(String str) {
        this.name = str;
        return this;
    }

    public String getOrgUnitId() {
        return this.orgUnitId;
    }

    public Drive setOrgUnitId(String str) {
        this.orgUnitId = str;
        return this;
    }

    public Restrictions getRestrictions() {
        return this.restrictions;
    }

    public Drive setRestrictions(Restrictions restrictions) {
        this.restrictions = restrictions;
        return this;
    }

    public String getThemeId() {
        return this.themeId;
    }

    public Drive setThemeId(String str) {
        this.themeId = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Drive set(String str, Object obj) {
        return (Drive) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Drive clone() {
        return (Drive) super.clone();
    }

    public static final class BackgroundImageFile extends GenericJson {

        /* INFO: renamed from: id, reason: collision with root package name */
        @Key
        private String f43id;

        @Key
        private Float width;

        @Key
        private Float xCoordinate;

        @Key
        private Float yCoordinate;

        public String getId() {
            return this.f43id;
        }

        public BackgroundImageFile setId(String str) {
            this.f43id = str;
            return this;
        }

        public Float getWidth() {
            return this.width;
        }

        public BackgroundImageFile setWidth(Float f) {
            this.width = f;
            return this;
        }

        public Float getXCoordinate() {
            return this.xCoordinate;
        }

        public BackgroundImageFile setXCoordinate(Float f) {
            this.xCoordinate = f;
            return this;
        }

        public Float getYCoordinate() {
            return this.yCoordinate;
        }

        public BackgroundImageFile setYCoordinate(Float f) {
            this.yCoordinate = f;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public BackgroundImageFile set(String str, Object obj) {
            return (BackgroundImageFile) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public BackgroundImageFile clone() {
            return (BackgroundImageFile) super.clone();
        }
    }

    public static final class Capabilities extends GenericJson {

        @Key
        private Boolean canAddChildren;

        @Key
        private Boolean canChangeCopyRequiresWriterPermissionRestriction;

        @Key
        private Boolean canChangeDomainUsersOnlyRestriction;

        @Key
        private Boolean canChangeDriveBackground;

        @Key
        private Boolean canChangeDriveMembersOnlyRestriction;

        @Key
        private Boolean canChangeSharingFoldersRequiresOrganizerPermissionRestriction;

        @Key
        private Boolean canComment;

        @Key
        private Boolean canCopy;

        @Key
        private Boolean canDeleteChildren;

        @Key
        private Boolean canDeleteDrive;

        @Key
        private Boolean canDownload;

        @Key
        private Boolean canEdit;

        @Key
        private Boolean canListChildren;

        @Key
        private Boolean canManageMembers;

        @Key
        private Boolean canReadRevisions;

        @Key
        private Boolean canRename;

        @Key
        private Boolean canRenameDrive;

        @Key
        private Boolean canResetDriveRestrictions;

        @Key
        private Boolean canShare;

        @Key
        private Boolean canTrashChildren;

        public Boolean getCanAddChildren() {
            return this.canAddChildren;
        }

        public Capabilities setCanAddChildren(Boolean bool) {
            this.canAddChildren = bool;
            return this;
        }

        public Boolean getCanChangeCopyRequiresWriterPermissionRestriction() {
            return this.canChangeCopyRequiresWriterPermissionRestriction;
        }

        public Capabilities setCanChangeCopyRequiresWriterPermissionRestriction(Boolean bool) {
            this.canChangeCopyRequiresWriterPermissionRestriction = bool;
            return this;
        }

        public Boolean getCanChangeDomainUsersOnlyRestriction() {
            return this.canChangeDomainUsersOnlyRestriction;
        }

        public Capabilities setCanChangeDomainUsersOnlyRestriction(Boolean bool) {
            this.canChangeDomainUsersOnlyRestriction = bool;
            return this;
        }

        public Boolean getCanChangeDriveBackground() {
            return this.canChangeDriveBackground;
        }

        public Capabilities setCanChangeDriveBackground(Boolean bool) {
            this.canChangeDriveBackground = bool;
            return this;
        }

        public Boolean getCanChangeDriveMembersOnlyRestriction() {
            return this.canChangeDriveMembersOnlyRestriction;
        }

        public Capabilities setCanChangeDriveMembersOnlyRestriction(Boolean bool) {
            this.canChangeDriveMembersOnlyRestriction = bool;
            return this;
        }

        public Boolean getCanChangeSharingFoldersRequiresOrganizerPermissionRestriction() {
            return this.canChangeSharingFoldersRequiresOrganizerPermissionRestriction;
        }

        public Capabilities setCanChangeSharingFoldersRequiresOrganizerPermissionRestriction(Boolean bool) {
            this.canChangeSharingFoldersRequiresOrganizerPermissionRestriction = bool;
            return this;
        }

        public Boolean getCanComment() {
            return this.canComment;
        }

        public Capabilities setCanComment(Boolean bool) {
            this.canComment = bool;
            return this;
        }

        public Boolean getCanCopy() {
            return this.canCopy;
        }

        public Capabilities setCanCopy(Boolean bool) {
            this.canCopy = bool;
            return this;
        }

        public Boolean getCanDeleteChildren() {
            return this.canDeleteChildren;
        }

        public Capabilities setCanDeleteChildren(Boolean bool) {
            this.canDeleteChildren = bool;
            return this;
        }

        public Boolean getCanDeleteDrive() {
            return this.canDeleteDrive;
        }

        public Capabilities setCanDeleteDrive(Boolean bool) {
            this.canDeleteDrive = bool;
            return this;
        }

        public Boolean getCanDownload() {
            return this.canDownload;
        }

        public Capabilities setCanDownload(Boolean bool) {
            this.canDownload = bool;
            return this;
        }

        public Boolean getCanEdit() {
            return this.canEdit;
        }

        public Capabilities setCanEdit(Boolean bool) {
            this.canEdit = bool;
            return this;
        }

        public Boolean getCanListChildren() {
            return this.canListChildren;
        }

        public Capabilities setCanListChildren(Boolean bool) {
            this.canListChildren = bool;
            return this;
        }

        public Boolean getCanManageMembers() {
            return this.canManageMembers;
        }

        public Capabilities setCanManageMembers(Boolean bool) {
            this.canManageMembers = bool;
            return this;
        }

        public Boolean getCanReadRevisions() {
            return this.canReadRevisions;
        }

        public Capabilities setCanReadRevisions(Boolean bool) {
            this.canReadRevisions = bool;
            return this;
        }

        public Boolean getCanRename() {
            return this.canRename;
        }

        public Capabilities setCanRename(Boolean bool) {
            this.canRename = bool;
            return this;
        }

        public Boolean getCanRenameDrive() {
            return this.canRenameDrive;
        }

        public Capabilities setCanRenameDrive(Boolean bool) {
            this.canRenameDrive = bool;
            return this;
        }

        public Boolean getCanResetDriveRestrictions() {
            return this.canResetDriveRestrictions;
        }

        public Capabilities setCanResetDriveRestrictions(Boolean bool) {
            this.canResetDriveRestrictions = bool;
            return this;
        }

        public Boolean getCanShare() {
            return this.canShare;
        }

        public Capabilities setCanShare(Boolean bool) {
            this.canShare = bool;
            return this;
        }

        public Boolean getCanTrashChildren() {
            return this.canTrashChildren;
        }

        public Capabilities setCanTrashChildren(Boolean bool) {
            this.canTrashChildren = bool;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Capabilities set(String str, Object obj) {
            return (Capabilities) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Capabilities clone() {
            return (Capabilities) super.clone();
        }
    }

    public static final class Restrictions extends GenericJson {

        @Key
        private Boolean adminManagedRestrictions;

        @Key
        private Boolean copyRequiresWriterPermission;

        @Key
        private Boolean domainUsersOnly;

        @Key
        private Boolean driveMembersOnly;

        @Key
        private Boolean sharingFoldersRequiresOrganizerPermission;

        public Boolean getAdminManagedRestrictions() {
            return this.adminManagedRestrictions;
        }

        public Restrictions setAdminManagedRestrictions(Boolean bool) {
            this.adminManagedRestrictions = bool;
            return this;
        }

        public Boolean getCopyRequiresWriterPermission() {
            return this.copyRequiresWriterPermission;
        }

        public Restrictions setCopyRequiresWriterPermission(Boolean bool) {
            this.copyRequiresWriterPermission = bool;
            return this;
        }

        public Boolean getDomainUsersOnly() {
            return this.domainUsersOnly;
        }

        public Restrictions setDomainUsersOnly(Boolean bool) {
            this.domainUsersOnly = bool;
            return this;
        }

        public Boolean getDriveMembersOnly() {
            return this.driveMembersOnly;
        }

        public Restrictions setDriveMembersOnly(Boolean bool) {
            this.driveMembersOnly = bool;
            return this;
        }

        public Boolean getSharingFoldersRequiresOrganizerPermission() {
            return this.sharingFoldersRequiresOrganizerPermission;
        }

        public Restrictions setSharingFoldersRequiresOrganizerPermission(Boolean bool) {
            this.sharingFoldersRequiresOrganizerPermission = bool;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Restrictions set(String str, Object obj) {
            return (Restrictions) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Restrictions clone() {
            return (Restrictions) super.clone();
        }
    }
}
