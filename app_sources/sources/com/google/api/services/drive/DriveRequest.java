package com.google.api.services.drive;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.util.Key;

/* INFO: loaded from: classes3.dex */
public abstract class DriveRequest<T> extends AbstractGoogleJsonClientRequest<T> {

    @Key("$.xgafv")
    private String $Xgafv;

    @Key("access_token")
    private String accessToken;

    @Key
    private String alt;

    @Key
    private String callback;

    @Key
    private String fields;

    @Key
    private String key;

    @Key("oauth_token")
    private String oauthToken;

    @Key
    private Boolean prettyPrint;

    @Key
    private String quotaUser;

    @Key("upload_protocol")
    private String uploadProtocol;

    @Key
    private String uploadType;

    public DriveRequest(Drive drive, String str, String str2, Object obj, Class<T> cls) {
        super(drive, str, str2, obj, cls);
    }

    public String get$Xgafv() {
        return this.$Xgafv;
    }

    /* INFO: renamed from: set$Xgafv */
    public DriveRequest<T> set$Xgafv2(String str) {
        this.$Xgafv = str;
        return this;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    /* INFO: renamed from: setAccessToken */
    public DriveRequest<T> setAccessToken2(String str) {
        this.accessToken = str;
        return this;
    }

    public String getAlt() {
        return this.alt;
    }

    /* INFO: renamed from: setAlt */
    public DriveRequest<T> setAlt2(String str) {
        this.alt = str;
        return this;
    }

    public String getCallback() {
        return this.callback;
    }

    /* INFO: renamed from: setCallback */
    public DriveRequest<T> setCallback2(String str) {
        this.callback = str;
        return this;
    }

    public String getFields() {
        return this.fields;
    }

    /* INFO: renamed from: setFields */
    public DriveRequest<T> setFields2(String str) {
        this.fields = str;
        return this;
    }

    public String getKey() {
        return this.key;
    }

    /* INFO: renamed from: setKey */
    public DriveRequest<T> setKey2(String str) {
        this.key = str;
        return this;
    }

    public String getOauthToken() {
        return this.oauthToken;
    }

    /* INFO: renamed from: setOauthToken */
    public DriveRequest<T> setOauthToken2(String str) {
        this.oauthToken = str;
        return this;
    }

    public Boolean getPrettyPrint() {
        return this.prettyPrint;
    }

    /* INFO: renamed from: setPrettyPrint */
    public DriveRequest<T> setPrettyPrint2(Boolean bool) {
        this.prettyPrint = bool;
        return this;
    }

    public String getQuotaUser() {
        return this.quotaUser;
    }

    /* INFO: renamed from: setQuotaUser */
    public DriveRequest<T> setQuotaUser2(String str) {
        this.quotaUser = str;
        return this;
    }

    public String getUploadType() {
        return this.uploadType;
    }

    /* INFO: renamed from: setUploadType */
    public DriveRequest<T> setUploadType2(String str) {
        this.uploadType = str;
        return this;
    }

    public String getUploadProtocol() {
        return this.uploadProtocol;
    }

    /* INFO: renamed from: setUploadProtocol */
    public DriveRequest<T> setUploadProtocol2(String str) {
        this.uploadProtocol = str;
        return this;
    }

    @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest
    public final Drive getAbstractGoogleClient() {
        return (Drive) super.getAbstractGoogleClient();
    }

    @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest
    public DriveRequest<T> setDisableGZipContent(boolean z) {
        return (DriveRequest) super.setDisableGZipContent(z);
    }

    @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest
    public DriveRequest<T> setRequestHeaders(HttpHeaders httpHeaders) {
        return (DriveRequest) super.setRequestHeaders(httpHeaders);
    }

    @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
    public DriveRequest<T> set(String str, Object obj) {
        return (DriveRequest) super.set(str, obj);
    }
}
