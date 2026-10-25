package com.google.api.services.kgsearch.v1;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes3.dex */
public abstract class KgsearchRequest<T> extends AbstractGoogleJsonClientRequest<T> {

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

    public KgsearchRequest(Kgsearch kgsearch, String str, String str2, Object obj, Class<T> cls) {
        super(kgsearch, str, str2, obj, cls);
    }

    public String get$Xgafv() {
        return this.$Xgafv;
    }

    /* JADX INFO: renamed from: set$Xgafv */
    public KgsearchRequest<T> set$Xgafv2(String str) {
        this.$Xgafv = str;
        return this;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    /* JADX INFO: renamed from: setAccessToken */
    public KgsearchRequest<T> setAccessToken2(String str) {
        this.accessToken = str;
        return this;
    }

    public String getAlt() {
        return this.alt;
    }

    /* JADX INFO: renamed from: setAlt */
    public KgsearchRequest<T> setAlt2(String str) {
        this.alt = str;
        return this;
    }

    public String getCallback() {
        return this.callback;
    }

    /* JADX INFO: renamed from: setCallback */
    public KgsearchRequest<T> setCallback2(String str) {
        this.callback = str;
        return this;
    }

    public String getFields() {
        return this.fields;
    }

    /* JADX INFO: renamed from: setFields */
    public KgsearchRequest<T> setFields2(String str) {
        this.fields = str;
        return this;
    }

    public String getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: setKey */
    public KgsearchRequest<T> setKey2(String str) {
        this.key = str;
        return this;
    }

    public String getOauthToken() {
        return this.oauthToken;
    }

    /* JADX INFO: renamed from: setOauthToken */
    public KgsearchRequest<T> setOauthToken2(String str) {
        this.oauthToken = str;
        return this;
    }

    public Boolean getPrettyPrint() {
        return this.prettyPrint;
    }

    /* JADX INFO: renamed from: setPrettyPrint */
    public KgsearchRequest<T> setPrettyPrint2(Boolean bool) {
        this.prettyPrint = bool;
        return this;
    }

    public String getQuotaUser() {
        return this.quotaUser;
    }

    /* JADX INFO: renamed from: setQuotaUser */
    public KgsearchRequest<T> setQuotaUser2(String str) {
        this.quotaUser = str;
        return this;
    }

    public String getUploadType() {
        return this.uploadType;
    }

    /* JADX INFO: renamed from: setUploadType */
    public KgsearchRequest<T> setUploadType2(String str) {
        this.uploadType = str;
        return this;
    }

    public String getUploadProtocol() {
        return this.uploadProtocol;
    }

    /* JADX INFO: renamed from: setUploadProtocol */
    public KgsearchRequest<T> setUploadProtocol2(String str) {
        this.uploadProtocol = str;
        return this;
    }

    @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest
    public final Kgsearch getAbstractGoogleClient() {
        return (Kgsearch) super.getAbstractGoogleClient();
    }

    @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest
    public KgsearchRequest<T> setDisableGZipContent(boolean z) {
        return (KgsearchRequest) super.setDisableGZipContent(z);
    }

    @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest
    public KgsearchRequest<T> setRequestHeaders(HttpHeaders httpHeaders) {
        return (KgsearchRequest) super.setRequestHeaders(httpHeaders);
    }

    @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
    public KgsearchRequest<T> set(String str, Object obj) {
        return (KgsearchRequest) super.set(str, obj);
    }
}
