package com.google.api.services.drive;

import com.google.api.client.googleapis.GoogleUtils;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient;
import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UriTemplate;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.services.drive.model.App;
import com.google.api.services.drive.model.AppList;
import com.google.api.services.drive.model.ChangeList;
import com.google.api.services.drive.model.Channel;
import com.google.api.services.drive.model.Comment;
import com.google.api.services.drive.model.CommentList;
import com.google.api.services.drive.model.DriveList;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.api.services.drive.model.GeneratedIds;
import com.google.api.services.drive.model.LabelList;
import com.google.api.services.drive.model.ModifyLabelsRequest;
import com.google.api.services.drive.model.ModifyLabelsResponse;
import com.google.api.services.drive.model.Permission;
import com.google.api.services.drive.model.PermissionList;
import com.google.api.services.drive.model.Reply;
import com.google.api.services.drive.model.ReplyList;
import com.google.api.services.drive.model.Revision;
import com.google.api.services.drive.model.RevisionList;
import com.google.api.services.drive.model.StartPageToken;
import com.google.api.services.drive.model.TeamDrive;
import com.google.api.services.drive.model.TeamDriveList;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: loaded from: classes3.dex */
public class Drive extends AbstractGoogleJsonClient {
    public static final String DEFAULT_BASE_URL = "https://www.googleapis.com/drive/v3/";
    public static final String DEFAULT_BATCH_PATH = "batch/drive/v3";
    public static final String DEFAULT_MTLS_ROOT_URL = "https://www.mtls.googleapis.com/";
    public static final String DEFAULT_ROOT_URL = "https://www.googleapis.com/";
    public static final String DEFAULT_SERVICE_PATH = "drive/v3/";

    static {
        boolean z = true;
        if ((GoogleUtils.MAJOR_VERSION.intValue() != 1 || (GoogleUtils.MINOR_VERSION.intValue() < 32 && (GoogleUtils.MINOR_VERSION.intValue() != 31 || GoogleUtils.BUGFIX_VERSION.intValue() < 1))) && GoogleUtils.MAJOR_VERSION.intValue() < 2) {
            z = false;
        }
        Preconditions.checkState(z, "You are currently running with version %s of google-api-client. You need at least version 1.31.1 of google-api-client to run version 2.0.0 of the Google Drive API library.", GoogleUtils.VERSION);
    }

    public Drive(HttpTransport httpTransport, JsonFactory jsonFactory, HttpRequestInitializer httpRequestInitializer) {
        this(new Builder(httpTransport, jsonFactory, httpRequestInitializer));
    }

    Drive(Builder builder) {
        super(builder);
    }

    @Override // com.google.api.client.googleapis.services.AbstractGoogleClient
    protected void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
        super.initialize(abstractGoogleClientRequest);
    }

    public About about() {
        return new About();
    }

    public class About {
        public About() {
        }

        public Get get() throws IOException {
            Get get = new Get();
            Drive.this.initialize(get);
            return get;
        }

        public class Get extends DriveRequest<com.google.api.services.drive.model.About> {
            private static final String REST_PATH = "about";

            protected Get() {
                super(Drive.this, "GET", REST_PATH, null, com.google.api.services.drive.model.About.class);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv, reason: merged with bridge method [inline-methods] */
            public DriveRequest<com.google.api.services.drive.model.About> set$Xgafv2(String str) {
                return (Get) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken, reason: merged with bridge method [inline-methods] */
            public DriveRequest<com.google.api.services.drive.model.About> setAccessToken2(String str) {
                return (Get) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt, reason: merged with bridge method [inline-methods] */
            public DriveRequest<com.google.api.services.drive.model.About> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback, reason: merged with bridge method [inline-methods] */
            public DriveRequest<com.google.api.services.drive.model.About> setCallback2(String str) {
                return (Get) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields, reason: merged with bridge method [inline-methods] */
            public DriveRequest<com.google.api.services.drive.model.About> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey, reason: merged with bridge method [inline-methods] */
            public DriveRequest<com.google.api.services.drive.model.About> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken, reason: merged with bridge method [inline-methods] */
            public DriveRequest<com.google.api.services.drive.model.About> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint, reason: merged with bridge method [inline-methods] */
            public DriveRequest<com.google.api.services.drive.model.About> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser, reason: merged with bridge method [inline-methods] */
            public DriveRequest<com.google.api.services.drive.model.About> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType, reason: merged with bridge method [inline-methods] */
            public DriveRequest<com.google.api.services.drive.model.About> setUploadType2(String str) {
                return (Get) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol, reason: merged with bridge method [inline-methods] */
            public DriveRequest<com.google.api.services.drive.model.About> setUploadProtocol2(String str) {
                return (Get) super.setUploadProtocol2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }
    }

    public Apps apps() {
        return new Apps();
    }

    public class Apps {
        public Apps() {
        }

        public Get get(String str) throws IOException {
            Get get = new Get(str);
            Drive.this.initialize(get);
            return get;
        }

        public class Get extends DriveRequest<App> {
            private static final String REST_PATH = "apps/{appId}";

            @Key
            private String appId;

            protected Get(String str) {
                super(Drive.this, "GET", REST_PATH, null, App.class);
                this.appId = (String) Preconditions.checkNotNull(str, "Required parameter appId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<App> set$Xgafv2(String str) {
                return (Get) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<App> setAccessToken2(String str) {
                return (Get) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<App> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<App> setCallback2(String str) {
                return (Get) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<App> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<App> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<App> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<App> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<App> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<App> setUploadType2(String str) {
                return (Get) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<App> setUploadProtocol2(String str) {
                return (Get) super.setUploadProtocol2(str);
            }

            public String getAppId() {
                return this.appId;
            }

            public Get setAppId(String str) {
                this.appId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        public List list() throws IOException {
            List list = new List();
            Drive.this.initialize(list);
            return list;
        }

        public class List extends DriveRequest<AppList> {
            private static final String REST_PATH = "apps";

            @Key
            private String appFilterExtensions;

            @Key
            private String appFilterMimeTypes;

            @Key
            private String languageCode;

            protected List() {
                super(Drive.this, "GET", REST_PATH, null, AppList.class);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<AppList> set$Xgafv2(String str) {
                return (List) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<AppList> setAccessToken2(String str) {
                return (List) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<AppList> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<AppList> setCallback2(String str) {
                return (List) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<AppList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<AppList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<AppList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<AppList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<AppList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<AppList> setUploadType2(String str) {
                return (List) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<AppList> setUploadProtocol2(String str) {
                return (List) super.setUploadProtocol2(str);
            }

            public String getAppFilterExtensions() {
                return this.appFilterExtensions;
            }

            public List setAppFilterExtensions(String str) {
                this.appFilterExtensions = str;
                return this;
            }

            public String getAppFilterMimeTypes() {
                return this.appFilterMimeTypes;
            }

            public List setAppFilterMimeTypes(String str) {
                this.appFilterMimeTypes = str;
                return this;
            }

            public String getLanguageCode() {
                return this.languageCode;
            }

            public List setLanguageCode(String str) {
                this.languageCode = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }
    }

    public Changes changes() {
        return new Changes();
    }

    public class Changes {
        public Changes() {
        }

        public GetStartPageToken getStartPageToken() throws IOException {
            GetStartPageToken getStartPageToken = new GetStartPageToken();
            Drive.this.initialize(getStartPageToken);
            return getStartPageToken;
        }

        public class GetStartPageToken extends DriveRequest<StartPageToken> {
            private static final String REST_PATH = "changes/startPageToken";

            @Key
            private String driveId;

            @Key
            private Boolean supportsAllDrives;

            @Key
            private Boolean supportsTeamDrives;

            @Key
            private String teamDriveId;

            protected GetStartPageToken() {
                super(Drive.this, "GET", REST_PATH, null, StartPageToken.class);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<StartPageToken> set$Xgafv2(String str) {
                return (GetStartPageToken) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<StartPageToken> setAccessToken2(String str) {
                return (GetStartPageToken) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<StartPageToken> setAlt2(String str) {
                return (GetStartPageToken) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<StartPageToken> setCallback2(String str) {
                return (GetStartPageToken) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<StartPageToken> setFields2(String str) {
                return (GetStartPageToken) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<StartPageToken> setKey2(String str) {
                return (GetStartPageToken) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<StartPageToken> setOauthToken2(String str) {
                return (GetStartPageToken) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<StartPageToken> setPrettyPrint2(Boolean bool) {
                return (GetStartPageToken) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<StartPageToken> setQuotaUser2(String str) {
                return (GetStartPageToken) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<StartPageToken> setUploadType2(String str) {
                return (GetStartPageToken) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<StartPageToken> setUploadProtocol2(String str) {
                return (GetStartPageToken) super.setUploadProtocol2(str);
            }

            public String getDriveId() {
                return this.driveId;
            }

            public GetStartPageToken setDriveId(String str) {
                this.driveId = str;
                return this;
            }

            public Boolean getSupportsAllDrives() {
                return this.supportsAllDrives;
            }

            public GetStartPageToken setSupportsAllDrives(Boolean bool) {
                this.supportsAllDrives = bool;
                return this;
            }

            public boolean isSupportsAllDrives() {
                Boolean bool = this.supportsAllDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.supportsAllDrives.booleanValue();
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public GetStartPageToken setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.supportsTeamDrives.booleanValue();
            }

            public String getTeamDriveId() {
                return this.teamDriveId;
            }

            public GetStartPageToken setTeamDriveId(String str) {
                this.teamDriveId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public GetStartPageToken set(String str, Object obj) {
                return (GetStartPageToken) super.set(str, obj);
            }
        }

        public List list(String str) throws IOException {
            List list = new List(str);
            Drive.this.initialize(list);
            return list;
        }

        public class List extends DriveRequest<ChangeList> {
            private static final String REST_PATH = "changes";

            @Key
            private String driveId;

            @Key
            private Boolean includeCorpusRemovals;

            @Key
            private Boolean includeItemsFromAllDrives;

            @Key
            private String includeLabels;

            @Key
            private String includePermissionsForView;

            @Key
            private Boolean includeRemoved;

            @Key
            private Boolean includeTeamDriveItems;

            @Key
            private Integer pageSize;

            @Key
            private String pageToken;

            @Key
            private Boolean restrictToMyDrive;

            @Key
            private String spaces;

            @Key
            private Boolean supportsAllDrives;

            @Key
            private Boolean supportsTeamDrives;

            @Key
            private String teamDriveId;

            protected List(String str) {
                super(Drive.this, "GET", REST_PATH, null, ChangeList.class);
                this.pageToken = (String) Preconditions.checkNotNull(str, "Required parameter pageToken must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<ChangeList> set$Xgafv2(String str) {
                return (List) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<ChangeList> setAccessToken2(String str) {
                return (List) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<ChangeList> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<ChangeList> setCallback2(String str) {
                return (List) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<ChangeList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<ChangeList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<ChangeList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<ChangeList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<ChangeList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<ChangeList> setUploadType2(String str) {
                return (List) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<ChangeList> setUploadProtocol2(String str) {
                return (List) super.setUploadProtocol2(str);
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public String getDriveId() {
                return this.driveId;
            }

            public List setDriveId(String str) {
                this.driveId = str;
                return this;
            }

            public Boolean getIncludeCorpusRemovals() {
                return this.includeCorpusRemovals;
            }

            public List setIncludeCorpusRemovals(Boolean bool) {
                this.includeCorpusRemovals = bool;
                return this;
            }

            public boolean isIncludeCorpusRemovals() {
                Boolean bool = this.includeCorpusRemovals;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.includeCorpusRemovals.booleanValue();
            }

            public Boolean getIncludeItemsFromAllDrives() {
                return this.includeItemsFromAllDrives;
            }

            public List setIncludeItemsFromAllDrives(Boolean bool) {
                this.includeItemsFromAllDrives = bool;
                return this;
            }

            public boolean isIncludeItemsFromAllDrives() {
                Boolean bool = this.includeItemsFromAllDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.includeItemsFromAllDrives.booleanValue();
            }

            public String getIncludeLabels() {
                return this.includeLabels;
            }

            public List setIncludeLabels(String str) {
                this.includeLabels = str;
                return this;
            }

            public String getIncludePermissionsForView() {
                return this.includePermissionsForView;
            }

            public List setIncludePermissionsForView(String str) {
                this.includePermissionsForView = str;
                return this;
            }

            public Boolean getIncludeRemoved() {
                return this.includeRemoved;
            }

            public List setIncludeRemoved(Boolean bool) {
                this.includeRemoved = bool;
                return this;
            }

            public boolean isIncludeRemoved() {
                Boolean bool = this.includeRemoved;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return true;
                }
                return this.includeRemoved.booleanValue();
            }

            public Boolean getIncludeTeamDriveItems() {
                return this.includeTeamDriveItems;
            }

            public List setIncludeTeamDriveItems(Boolean bool) {
                this.includeTeamDriveItems = bool;
                return this;
            }

            public boolean isIncludeTeamDriveItems() {
                Boolean bool = this.includeTeamDriveItems;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.includeTeamDriveItems.booleanValue();
            }

            public Integer getPageSize() {
                return this.pageSize;
            }

            public List setPageSize(Integer num) {
                this.pageSize = num;
                return this;
            }

            public Boolean getRestrictToMyDrive() {
                return this.restrictToMyDrive;
            }

            public List setRestrictToMyDrive(Boolean bool) {
                this.restrictToMyDrive = bool;
                return this;
            }

            public boolean isRestrictToMyDrive() {
                Boolean bool = this.restrictToMyDrive;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.restrictToMyDrive.booleanValue();
            }

            public String getSpaces() {
                return this.spaces;
            }

            public List setSpaces(String str) {
                this.spaces = str;
                return this;
            }

            public Boolean getSupportsAllDrives() {
                return this.supportsAllDrives;
            }

            public List setSupportsAllDrives(Boolean bool) {
                this.supportsAllDrives = bool;
                return this;
            }

            public boolean isSupportsAllDrives() {
                Boolean bool = this.supportsAllDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.supportsAllDrives.booleanValue();
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public List setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.supportsTeamDrives.booleanValue();
            }

            public String getTeamDriveId() {
                return this.teamDriveId;
            }

            public List setTeamDriveId(String str) {
                this.teamDriveId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        public Watch watch(String str, Channel channel) throws IOException {
            Watch watch = new Watch(str, channel);
            Drive.this.initialize(watch);
            return watch;
        }

        public class Watch extends DriveRequest<Channel> {
            private static final String REST_PATH = "changes/watch";

            @Key
            private String driveId;

            @Key
            private Boolean includeCorpusRemovals;

            @Key
            private Boolean includeItemsFromAllDrives;

            @Key
            private String includeLabels;

            @Key
            private String includePermissionsForView;

            @Key
            private Boolean includeRemoved;

            @Key
            private Boolean includeTeamDriveItems;

            @Key
            private Integer pageSize;

            @Key
            private String pageToken;

            @Key
            private Boolean restrictToMyDrive;

            @Key
            private String spaces;

            @Key
            private Boolean supportsAllDrives;

            @Key
            private Boolean supportsTeamDrives;

            @Key
            private String teamDriveId;

            protected Watch(String str, Channel channel) {
                super(Drive.this, "POST", REST_PATH, channel, Channel.class);
                this.pageToken = (String) Preconditions.checkNotNull(str, "Required parameter pageToken must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<Channel> set$Xgafv2(String str) {
                return (Watch) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<Channel> setAccessToken2(String str) {
                return (Watch) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<Channel> setAlt2(String str) {
                return (Watch) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<Channel> setCallback2(String str) {
                return (Watch) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<Channel> setFields2(String str) {
                return (Watch) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<Channel> setKey2(String str) {
                return (Watch) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<Channel> setOauthToken2(String str) {
                return (Watch) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<Channel> setPrettyPrint2(Boolean bool) {
                return (Watch) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<Channel> setQuotaUser2(String str) {
                return (Watch) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<Channel> setUploadType2(String str) {
                return (Watch) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<Channel> setUploadProtocol2(String str) {
                return (Watch) super.setUploadProtocol2(str);
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public Watch setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public String getDriveId() {
                return this.driveId;
            }

            public Watch setDriveId(String str) {
                this.driveId = str;
                return this;
            }

            public Boolean getIncludeCorpusRemovals() {
                return this.includeCorpusRemovals;
            }

            public Watch setIncludeCorpusRemovals(Boolean bool) {
                this.includeCorpusRemovals = bool;
                return this;
            }

            public boolean isIncludeCorpusRemovals() {
                Boolean bool = this.includeCorpusRemovals;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.includeCorpusRemovals.booleanValue();
            }

            public Boolean getIncludeItemsFromAllDrives() {
                return this.includeItemsFromAllDrives;
            }

            public Watch setIncludeItemsFromAllDrives(Boolean bool) {
                this.includeItemsFromAllDrives = bool;
                return this;
            }

            public boolean isIncludeItemsFromAllDrives() {
                Boolean bool = this.includeItemsFromAllDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.includeItemsFromAllDrives.booleanValue();
            }

            public String getIncludeLabels() {
                return this.includeLabels;
            }

            public Watch setIncludeLabels(String str) {
                this.includeLabels = str;
                return this;
            }

            public String getIncludePermissionsForView() {
                return this.includePermissionsForView;
            }

            public Watch setIncludePermissionsForView(String str) {
                this.includePermissionsForView = str;
                return this;
            }

            public Boolean getIncludeRemoved() {
                return this.includeRemoved;
            }

            public Watch setIncludeRemoved(Boolean bool) {
                this.includeRemoved = bool;
                return this;
            }

            public boolean isIncludeRemoved() {
                Boolean bool = this.includeRemoved;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return true;
                }
                return this.includeRemoved.booleanValue();
            }

            public Boolean getIncludeTeamDriveItems() {
                return this.includeTeamDriveItems;
            }

            public Watch setIncludeTeamDriveItems(Boolean bool) {
                this.includeTeamDriveItems = bool;
                return this;
            }

            public boolean isIncludeTeamDriveItems() {
                Boolean bool = this.includeTeamDriveItems;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.includeTeamDriveItems.booleanValue();
            }

            public Integer getPageSize() {
                return this.pageSize;
            }

            public Watch setPageSize(Integer num) {
                this.pageSize = num;
                return this;
            }

            public Boolean getRestrictToMyDrive() {
                return this.restrictToMyDrive;
            }

            public Watch setRestrictToMyDrive(Boolean bool) {
                this.restrictToMyDrive = bool;
                return this;
            }

            public boolean isRestrictToMyDrive() {
                Boolean bool = this.restrictToMyDrive;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.restrictToMyDrive.booleanValue();
            }

            public String getSpaces() {
                return this.spaces;
            }

            public Watch setSpaces(String str) {
                this.spaces = str;
                return this;
            }

            public Boolean getSupportsAllDrives() {
                return this.supportsAllDrives;
            }

            public Watch setSupportsAllDrives(Boolean bool) {
                this.supportsAllDrives = bool;
                return this;
            }

            public boolean isSupportsAllDrives() {
                Boolean bool = this.supportsAllDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.supportsAllDrives.booleanValue();
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public Watch setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.supportsTeamDrives.booleanValue();
            }

            public String getTeamDriveId() {
                return this.teamDriveId;
            }

            public Watch setTeamDriveId(String str) {
                this.teamDriveId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Watch set(String str, Object obj) {
                return (Watch) super.set(str, obj);
            }
        }
    }

    public Channels channels() {
        return new Channels();
    }

    public class Channels {
        public Channels() {
        }

        public Stop stop(Channel channel) throws IOException {
            Stop stop = new Stop(channel);
            Drive.this.initialize(stop);
            return stop;
        }

        public class Stop extends DriveRequest<Void> {
            private static final String REST_PATH = "channels/stop";

            protected Stop(Channel channel) {
                super(Drive.this, "POST", REST_PATH, channel, Void.class);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<Void> set$Xgafv2(String str) {
                return (Stop) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<Void> setAccessToken2(String str) {
                return (Stop) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Stop) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<Void> setCallback2(String str) {
                return (Stop) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Stop) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Stop) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Stop) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Stop) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Stop) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<Void> setUploadType2(String str) {
                return (Stop) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<Void> setUploadProtocol2(String str) {
                return (Stop) super.setUploadProtocol2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Stop set(String str, Object obj) {
                return (Stop) super.set(str, obj);
            }
        }
    }

    public Comments comments() {
        return new Comments();
    }

    public class Comments {
        public Comments() {
        }

        public Create create(String str, Comment comment) throws IOException {
            Create create = new Create(str, comment);
            Drive.this.initialize(create);
            return create;
        }

        public class Create extends DriveRequest<Comment> {
            private static final String REST_PATH = "files/{fileId}/comments";

            @Key
            private String fileId;

            protected Create(String str, Comment comment) {
                super(Drive.this, "POST", REST_PATH, comment, Comment.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                checkRequiredParameter(comment, "content");
                checkRequiredParameter(comment.getContent(), "Comment.getContent()");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<Comment> set$Xgafv2(String str) {
                return (Create) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<Comment> setAccessToken2(String str) {
                return (Create) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<Comment> setAlt2(String str) {
                return (Create) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<Comment> setCallback2(String str) {
                return (Create) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<Comment> setFields2(String str) {
                return (Create) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<Comment> setKey2(String str) {
                return (Create) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<Comment> setOauthToken2(String str) {
                return (Create) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<Comment> setPrettyPrint2(Boolean bool) {
                return (Create) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<Comment> setQuotaUser2(String str) {
                return (Create) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<Comment> setUploadType2(String str) {
                return (Create) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<Comment> setUploadProtocol2(String str) {
                return (Create) super.setUploadProtocol2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Create setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Create set(String str, Object obj) {
                return (Create) super.set(str, obj);
            }
        }

        public Delete delete(String str, String str2) throws IOException {
            Delete delete = new Delete(str, str2);
            Drive.this.initialize(delete);
            return delete;
        }

        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}";

            @Key
            private String commentId;

            @Key
            private String fileId;

            protected Delete(String str, String str2) {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.commentId = (String) Preconditions.checkNotNull(str2, "Required parameter commentId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<Void> set$Xgafv2(String str) {
                return (Delete) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<Void> setAccessToken2(String str) {
                return (Delete) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Delete) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<Void> setCallback2(String str) {
                return (Delete) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Delete) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Delete) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<Void> setUploadType2(String str) {
                return (Delete) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<Void> setUploadProtocol2(String str) {
                return (Delete) super.setUploadProtocol2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Delete setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getCommentId() {
                return this.commentId;
            }

            public Delete setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        public Get get(String str, String str2) throws IOException {
            Get get = new Get(str, str2);
            Drive.this.initialize(get);
            return get;
        }

        public class Get extends DriveRequest<Comment> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}";

            @Key
            private String commentId;

            @Key
            private String fileId;

            @Key
            private Boolean includeDeleted;

            protected Get(String str, String str2) {
                super(Drive.this, "GET", REST_PATH, null, Comment.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.commentId = (String) Preconditions.checkNotNull(str2, "Required parameter commentId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<Comment> set$Xgafv2(String str) {
                return (Get) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<Comment> setAccessToken2(String str) {
                return (Get) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<Comment> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<Comment> setCallback2(String str) {
                return (Get) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<Comment> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<Comment> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<Comment> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<Comment> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<Comment> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<Comment> setUploadType2(String str) {
                return (Get) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<Comment> setUploadProtocol2(String str) {
                return (Get) super.setUploadProtocol2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getCommentId() {
                return this.commentId;
            }

            public Get setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public Boolean getIncludeDeleted() {
                return this.includeDeleted;
            }

            public Get setIncludeDeleted(Boolean bool) {
                this.includeDeleted = bool;
                return this;
            }

            public boolean isIncludeDeleted() {
                Boolean bool = this.includeDeleted;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.includeDeleted.booleanValue();
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        public List list(String str) throws IOException {
            List list = new List(str);
            Drive.this.initialize(list);
            return list;
        }

        public class List extends DriveRequest<CommentList> {
            private static final String REST_PATH = "files/{fileId}/comments";

            @Key
            private String fileId;

            @Key
            private Boolean includeDeleted;

            @Key
            private Integer pageSize;

            @Key
            private String pageToken;

            @Key
            private String startModifiedTime;

            protected List(String str) {
                super(Drive.this, "GET", REST_PATH, null, CommentList.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<CommentList> set$Xgafv2(String str) {
                return (List) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<CommentList> setAccessToken2(String str) {
                return (List) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<CommentList> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<CommentList> setCallback2(String str) {
                return (List) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<CommentList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<CommentList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<CommentList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<CommentList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<CommentList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<CommentList> setUploadType2(String str) {
                return (List) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<CommentList> setUploadProtocol2(String str) {
                return (List) super.setUploadProtocol2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public List setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Boolean getIncludeDeleted() {
                return this.includeDeleted;
            }

            public List setIncludeDeleted(Boolean bool) {
                this.includeDeleted = bool;
                return this;
            }

            public boolean isIncludeDeleted() {
                Boolean bool = this.includeDeleted;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.includeDeleted.booleanValue();
            }

            public Integer getPageSize() {
                return this.pageSize;
            }

            public List setPageSize(Integer num) {
                this.pageSize = num;
                return this;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public String getStartModifiedTime() {
                return this.startModifiedTime;
            }

            public List setStartModifiedTime(String str) {
                this.startModifiedTime = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        public Update update(String str, String str2, Comment comment) throws IOException {
            Update update = new Update(str, str2, comment);
            Drive.this.initialize(update);
            return update;
        }

        public class Update extends DriveRequest<Comment> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}";

            @Key
            private String commentId;

            @Key
            private String fileId;

            protected Update(String str, String str2, Comment comment) {
                super(Drive.this, "PATCH", REST_PATH, comment, Comment.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.commentId = (String) Preconditions.checkNotNull(str2, "Required parameter commentId must be specified.");
                checkRequiredParameter(comment, "content");
                checkRequiredParameter(comment.getContent(), "Comment.getContent()");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<Comment> set$Xgafv2(String str) {
                return (Update) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<Comment> setAccessToken2(String str) {
                return (Update) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<Comment> setAlt2(String str) {
                return (Update) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<Comment> setCallback2(String str) {
                return (Update) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<Comment> setFields2(String str) {
                return (Update) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<Comment> setKey2(String str) {
                return (Update) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<Comment> setOauthToken2(String str) {
                return (Update) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<Comment> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<Comment> setQuotaUser2(String str) {
                return (Update) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<Comment> setUploadType2(String str) {
                return (Update) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<Comment> setUploadProtocol2(String str) {
                return (Update) super.setUploadProtocol2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Update setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getCommentId() {
                return this.commentId;
            }

            public Update setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }
    }

    public Drives drives() {
        return new Drives();
    }

    public class Drives {
        public Drives() {
        }

        public Create create(String str, com.google.api.services.drive.model.Drive drive) throws IOException {
            Create create = new Create(str, drive);
            Drive.this.initialize(create);
            return create;
        }

        public class Create extends DriveRequest<com.google.api.services.drive.model.Drive> {
            private static final String REST_PATH = "drives";

            @Key
            private String requestId;

            protected Create(String str, com.google.api.services.drive.model.Drive drive) {
                super(Drive.this, "POST", REST_PATH, drive, com.google.api.services.drive.model.Drive.class);
                this.requestId = (String) Preconditions.checkNotNull(str, "Required parameter requestId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<com.google.api.services.drive.model.Drive> set$Xgafv2(String str) {
                return (Create) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<com.google.api.services.drive.model.Drive> setAccessToken2(String str) {
                return (Create) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<com.google.api.services.drive.model.Drive> setAlt2(String str) {
                return (Create) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<com.google.api.services.drive.model.Drive> setCallback2(String str) {
                return (Create) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<com.google.api.services.drive.model.Drive> setFields2(String str) {
                return (Create) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<com.google.api.services.drive.model.Drive> setKey2(String str) {
                return (Create) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<com.google.api.services.drive.model.Drive> setOauthToken2(String str) {
                return (Create) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<com.google.api.services.drive.model.Drive> setPrettyPrint2(Boolean bool) {
                return (Create) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<com.google.api.services.drive.model.Drive> setQuotaUser2(String str) {
                return (Create) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<com.google.api.services.drive.model.Drive> setUploadType2(String str) {
                return (Create) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<com.google.api.services.drive.model.Drive> setUploadProtocol2(String str) {
                return (Create) super.setUploadProtocol2(str);
            }

            public String getRequestId() {
                return this.requestId;
            }

            public Create setRequestId(String str) {
                this.requestId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Create set(String str, Object obj) {
                return (Create) super.set(str, obj);
            }
        }

        public Delete delete(String str) throws IOException {
            Delete delete = new Delete(str);
            Drive.this.initialize(delete);
            return delete;
        }

        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "drives/{driveId}";

            @Key
            private Boolean allowItemDeletion;

            @Key
            private String driveId;

            @Key
            private Boolean useDomainAdminAccess;

            protected Delete(String str) {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
                this.driveId = (String) Preconditions.checkNotNull(str, "Required parameter driveId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<Void> set$Xgafv2(String str) {
                return (Delete) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<Void> setAccessToken2(String str) {
                return (Delete) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Delete) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<Void> setCallback2(String str) {
                return (Delete) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Delete) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Delete) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<Void> setUploadType2(String str) {
                return (Delete) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<Void> setUploadProtocol2(String str) {
                return (Delete) super.setUploadProtocol2(str);
            }

            public String getDriveId() {
                return this.driveId;
            }

            public Delete setDriveId(String str) {
                this.driveId = str;
                return this;
            }

            public Boolean getAllowItemDeletion() {
                return this.allowItemDeletion;
            }

            public Delete setAllowItemDeletion(Boolean bool) {
                this.allowItemDeletion = bool;
                return this;
            }

            public boolean isAllowItemDeletion() {
                Boolean bool = this.allowItemDeletion;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.allowItemDeletion.booleanValue();
            }

            public Boolean getUseDomainAdminAccess() {
                return this.useDomainAdminAccess;
            }

            public Delete setUseDomainAdminAccess(Boolean bool) {
                this.useDomainAdminAccess = bool;
                return this;
            }

            public boolean isUseDomainAdminAccess() {
                Boolean bool = this.useDomainAdminAccess;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.useDomainAdminAccess.booleanValue();
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        public Get get(String str) throws IOException {
            Get get = new Get(str);
            Drive.this.initialize(get);
            return get;
        }

        public class Get extends DriveRequest<com.google.api.services.drive.model.Drive> {
            private static final String REST_PATH = "drives/{driveId}";

            @Key
            private String driveId;

            @Key
            private Boolean useDomainAdminAccess;

            protected Get(String str) {
                super(Drive.this, "GET", REST_PATH, null, com.google.api.services.drive.model.Drive.class);
                this.driveId = (String) Preconditions.checkNotNull(str, "Required parameter driveId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<com.google.api.services.drive.model.Drive> set$Xgafv2(String str) {
                return (Get) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<com.google.api.services.drive.model.Drive> setAccessToken2(String str) {
                return (Get) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<com.google.api.services.drive.model.Drive> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<com.google.api.services.drive.model.Drive> setCallback2(String str) {
                return (Get) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<com.google.api.services.drive.model.Drive> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<com.google.api.services.drive.model.Drive> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<com.google.api.services.drive.model.Drive> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<com.google.api.services.drive.model.Drive> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<com.google.api.services.drive.model.Drive> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<com.google.api.services.drive.model.Drive> setUploadType2(String str) {
                return (Get) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<com.google.api.services.drive.model.Drive> setUploadProtocol2(String str) {
                return (Get) super.setUploadProtocol2(str);
            }

            public String getDriveId() {
                return this.driveId;
            }

            public Get setDriveId(String str) {
                this.driveId = str;
                return this;
            }

            public Boolean getUseDomainAdminAccess() {
                return this.useDomainAdminAccess;
            }

            public Get setUseDomainAdminAccess(Boolean bool) {
                this.useDomainAdminAccess = bool;
                return this;
            }

            public boolean isUseDomainAdminAccess() {
                Boolean bool = this.useDomainAdminAccess;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.useDomainAdminAccess.booleanValue();
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        public Hide hide(String str) throws IOException {
            Hide hide = new Hide(str);
            Drive.this.initialize(hide);
            return hide;
        }

        public class Hide extends DriveRequest<com.google.api.services.drive.model.Drive> {
            private static final String REST_PATH = "drives/{driveId}/hide";

            @Key
            private String driveId;

            protected Hide(String str) {
                super(Drive.this, "POST", REST_PATH, null, com.google.api.services.drive.model.Drive.class);
                this.driveId = (String) Preconditions.checkNotNull(str, "Required parameter driveId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<com.google.api.services.drive.model.Drive> set$Xgafv2(String str) {
                return (Hide) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<com.google.api.services.drive.model.Drive> setAccessToken2(String str) {
                return (Hide) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<com.google.api.services.drive.model.Drive> setAlt2(String str) {
                return (Hide) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<com.google.api.services.drive.model.Drive> setCallback2(String str) {
                return (Hide) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<com.google.api.services.drive.model.Drive> setFields2(String str) {
                return (Hide) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<com.google.api.services.drive.model.Drive> setKey2(String str) {
                return (Hide) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<com.google.api.services.drive.model.Drive> setOauthToken2(String str) {
                return (Hide) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<com.google.api.services.drive.model.Drive> setPrettyPrint2(Boolean bool) {
                return (Hide) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<com.google.api.services.drive.model.Drive> setQuotaUser2(String str) {
                return (Hide) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<com.google.api.services.drive.model.Drive> setUploadType2(String str) {
                return (Hide) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<com.google.api.services.drive.model.Drive> setUploadProtocol2(String str) {
                return (Hide) super.setUploadProtocol2(str);
            }

            public String getDriveId() {
                return this.driveId;
            }

            public Hide setDriveId(String str) {
                this.driveId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Hide set(String str, Object obj) {
                return (Hide) super.set(str, obj);
            }
        }

        public List list() throws IOException {
            List list = new List();
            Drive.this.initialize(list);
            return list;
        }

        public class List extends DriveRequest<DriveList> {
            private static final String REST_PATH = "drives";

            @Key
            private Integer pageSize;

            @Key
            private String pageToken;

            @Key
            private String q;

            @Key
            private Boolean useDomainAdminAccess;

            protected List() {
                super(Drive.this, "GET", REST_PATH, null, DriveList.class);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<DriveList> set$Xgafv2(String str) {
                return (List) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<DriveList> setAccessToken2(String str) {
                return (List) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<DriveList> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<DriveList> setCallback2(String str) {
                return (List) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<DriveList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<DriveList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<DriveList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<DriveList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<DriveList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<DriveList> setUploadType2(String str) {
                return (List) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<DriveList> setUploadProtocol2(String str) {
                return (List) super.setUploadProtocol2(str);
            }

            public Integer getPageSize() {
                return this.pageSize;
            }

            public List setPageSize(Integer num) {
                this.pageSize = num;
                return this;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public String getQ() {
                return this.q;
            }

            public List setQ(String str) {
                this.q = str;
                return this;
            }

            public Boolean getUseDomainAdminAccess() {
                return this.useDomainAdminAccess;
            }

            public List setUseDomainAdminAccess(Boolean bool) {
                this.useDomainAdminAccess = bool;
                return this;
            }

            public boolean isUseDomainAdminAccess() {
                Boolean bool = this.useDomainAdminAccess;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.useDomainAdminAccess.booleanValue();
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        public Unhide unhide(String str) throws IOException {
            Unhide unhide = new Unhide(str);
            Drive.this.initialize(unhide);
            return unhide;
        }

        public class Unhide extends DriveRequest<com.google.api.services.drive.model.Drive> {
            private static final String REST_PATH = "drives/{driveId}/unhide";

            @Key
            private String driveId;

            protected Unhide(String str) {
                super(Drive.this, "POST", REST_PATH, null, com.google.api.services.drive.model.Drive.class);
                this.driveId = (String) Preconditions.checkNotNull(str, "Required parameter driveId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<com.google.api.services.drive.model.Drive> set$Xgafv2(String str) {
                return (Unhide) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<com.google.api.services.drive.model.Drive> setAccessToken2(String str) {
                return (Unhide) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<com.google.api.services.drive.model.Drive> setAlt2(String str) {
                return (Unhide) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<com.google.api.services.drive.model.Drive> setCallback2(String str) {
                return (Unhide) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<com.google.api.services.drive.model.Drive> setFields2(String str) {
                return (Unhide) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<com.google.api.services.drive.model.Drive> setKey2(String str) {
                return (Unhide) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<com.google.api.services.drive.model.Drive> setOauthToken2(String str) {
                return (Unhide) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<com.google.api.services.drive.model.Drive> setPrettyPrint2(Boolean bool) {
                return (Unhide) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<com.google.api.services.drive.model.Drive> setQuotaUser2(String str) {
                return (Unhide) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<com.google.api.services.drive.model.Drive> setUploadType2(String str) {
                return (Unhide) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<com.google.api.services.drive.model.Drive> setUploadProtocol2(String str) {
                return (Unhide) super.setUploadProtocol2(str);
            }

            public String getDriveId() {
                return this.driveId;
            }

            public Unhide setDriveId(String str) {
                this.driveId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Unhide set(String str, Object obj) {
                return (Unhide) super.set(str, obj);
            }
        }

        public Update update(String str, com.google.api.services.drive.model.Drive drive) throws IOException {
            Update update = new Update(str, drive);
            Drive.this.initialize(update);
            return update;
        }

        public class Update extends DriveRequest<com.google.api.services.drive.model.Drive> {
            private static final String REST_PATH = "drives/{driveId}";

            @Key
            private String driveId;

            @Key
            private Boolean useDomainAdminAccess;

            protected Update(String str, com.google.api.services.drive.model.Drive drive) {
                super(Drive.this, "PATCH", REST_PATH, drive, com.google.api.services.drive.model.Drive.class);
                this.driveId = (String) Preconditions.checkNotNull(str, "Required parameter driveId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<com.google.api.services.drive.model.Drive> set$Xgafv2(String str) {
                return (Update) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<com.google.api.services.drive.model.Drive> setAccessToken2(String str) {
                return (Update) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<com.google.api.services.drive.model.Drive> setAlt2(String str) {
                return (Update) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<com.google.api.services.drive.model.Drive> setCallback2(String str) {
                return (Update) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<com.google.api.services.drive.model.Drive> setFields2(String str) {
                return (Update) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<com.google.api.services.drive.model.Drive> setKey2(String str) {
                return (Update) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<com.google.api.services.drive.model.Drive> setOauthToken2(String str) {
                return (Update) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<com.google.api.services.drive.model.Drive> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<com.google.api.services.drive.model.Drive> setQuotaUser2(String str) {
                return (Update) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<com.google.api.services.drive.model.Drive> setUploadType2(String str) {
                return (Update) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<com.google.api.services.drive.model.Drive> setUploadProtocol2(String str) {
                return (Update) super.setUploadProtocol2(str);
            }

            public String getDriveId() {
                return this.driveId;
            }

            public Update setDriveId(String str) {
                this.driveId = str;
                return this;
            }

            public Boolean getUseDomainAdminAccess() {
                return this.useDomainAdminAccess;
            }

            public Update setUseDomainAdminAccess(Boolean bool) {
                this.useDomainAdminAccess = bool;
                return this;
            }

            public boolean isUseDomainAdminAccess() {
                Boolean bool = this.useDomainAdminAccess;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.useDomainAdminAccess.booleanValue();
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }
    }

    public Files files() {
        return new Files();
    }

    public class Files {
        public Files() {
        }

        public Copy copy(String str, File file) throws IOException {
            Copy copy = new Copy(str, file);
            Drive.this.initialize(copy);
            return copy;
        }

        public class Copy extends DriveRequest<File> {
            private static final String REST_PATH = "files/{fileId}/copy";

            @Key
            private Boolean enforceSingleParent;

            @Key
            private String fileId;

            @Key
            private Boolean ignoreDefaultVisibility;

            @Key
            private String includeLabels;

            @Key
            private String includePermissionsForView;

            @Key
            private Boolean keepRevisionForever;

            @Key
            private String ocrLanguage;

            @Key
            private Boolean supportsAllDrives;

            @Key
            private Boolean supportsTeamDrives;

            protected Copy(String str, File file) {
                super(Drive.this, "POST", REST_PATH, file, File.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<File> set$Xgafv2(String str) {
                return (Copy) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<File> setAccessToken2(String str) {
                return (Copy) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<File> setAlt2(String str) {
                return (Copy) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<File> setCallback2(String str) {
                return (Copy) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<File> setFields2(String str) {
                return (Copy) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<File> setKey2(String str) {
                return (Copy) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<File> setOauthToken2(String str) {
                return (Copy) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<File> setPrettyPrint2(Boolean bool) {
                return (Copy) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<File> setQuotaUser2(String str) {
                return (Copy) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<File> setUploadType2(String str) {
                return (Copy) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<File> setUploadProtocol2(String str) {
                return (Copy) super.setUploadProtocol2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Copy setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Boolean getEnforceSingleParent() {
                return this.enforceSingleParent;
            }

            public Copy setEnforceSingleParent(Boolean bool) {
                this.enforceSingleParent = bool;
                return this;
            }

            public boolean isEnforceSingleParent() {
                Boolean bool = this.enforceSingleParent;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.enforceSingleParent.booleanValue();
            }

            public Boolean getIgnoreDefaultVisibility() {
                return this.ignoreDefaultVisibility;
            }

            public Copy setIgnoreDefaultVisibility(Boolean bool) {
                this.ignoreDefaultVisibility = bool;
                return this;
            }

            public boolean isIgnoreDefaultVisibility() {
                Boolean bool = this.ignoreDefaultVisibility;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.ignoreDefaultVisibility.booleanValue();
            }

            public String getIncludeLabels() {
                return this.includeLabels;
            }

            public Copy setIncludeLabels(String str) {
                this.includeLabels = str;
                return this;
            }

            public String getIncludePermissionsForView() {
                return this.includePermissionsForView;
            }

            public Copy setIncludePermissionsForView(String str) {
                this.includePermissionsForView = str;
                return this;
            }

            public Boolean getKeepRevisionForever() {
                return this.keepRevisionForever;
            }

            public Copy setKeepRevisionForever(Boolean bool) {
                this.keepRevisionForever = bool;
                return this;
            }

            public boolean isKeepRevisionForever() {
                Boolean bool = this.keepRevisionForever;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.keepRevisionForever.booleanValue();
            }

            public String getOcrLanguage() {
                return this.ocrLanguage;
            }

            public Copy setOcrLanguage(String str) {
                this.ocrLanguage = str;
                return this;
            }

            public Boolean getSupportsAllDrives() {
                return this.supportsAllDrives;
            }

            public Copy setSupportsAllDrives(Boolean bool) {
                this.supportsAllDrives = bool;
                return this;
            }

            public boolean isSupportsAllDrives() {
                Boolean bool = this.supportsAllDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.supportsAllDrives.booleanValue();
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public Copy setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.supportsTeamDrives.booleanValue();
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Copy set(String str, Object obj) {
                return (Copy) super.set(str, obj);
            }
        }

        public Create create(File file) throws IOException {
            Create create = new Create(file);
            Drive.this.initialize(create);
            return create;
        }

        public Create create(File file, AbstractInputStreamContent abstractInputStreamContent) throws IOException {
            Create create = new Create(file, abstractInputStreamContent);
            Drive.this.initialize(create);
            return create;
        }

        public class Create extends DriveRequest<File> {
            private static final String REST_PATH = "files";

            @Key
            private Boolean enforceSingleParent;

            @Key
            private Boolean ignoreDefaultVisibility;

            @Key
            private String includeLabels;

            @Key
            private String includePermissionsForView;

            @Key
            private Boolean keepRevisionForever;

            @Key
            private String ocrLanguage;

            @Key
            private Boolean supportsAllDrives;

            @Key
            private Boolean supportsTeamDrives;

            @Key
            private Boolean useContentAsIndexableText;

            protected Create(File file) {
                super(Drive.this, "POST", REST_PATH, file, File.class);
            }

            protected Create(File file, AbstractInputStreamContent abstractInputStreamContent) {
                super(Drive.this, "POST", "/upload/" + Drive.this.getServicePath() + REST_PATH, file, File.class);
                Preconditions.checkNotNull(abstractInputStreamContent, "Required parameter mediaContent must be specified.");
                initializeMediaUpload(abstractInputStreamContent);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<File> set$Xgafv2(String str) {
                return (Create) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<File> setAccessToken2(String str) {
                return (Create) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<File> setAlt2(String str) {
                return (Create) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<File> setCallback2(String str) {
                return (Create) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<File> setFields2(String str) {
                return (Create) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<File> setKey2(String str) {
                return (Create) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<File> setOauthToken2(String str) {
                return (Create) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<File> setPrettyPrint2(Boolean bool) {
                return (Create) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<File> setQuotaUser2(String str) {
                return (Create) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<File> setUploadType2(String str) {
                return (Create) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<File> setUploadProtocol2(String str) {
                return (Create) super.setUploadProtocol2(str);
            }

            public Boolean getEnforceSingleParent() {
                return this.enforceSingleParent;
            }

            public Create setEnforceSingleParent(Boolean bool) {
                this.enforceSingleParent = bool;
                return this;
            }

            public boolean isEnforceSingleParent() {
                Boolean bool = this.enforceSingleParent;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.enforceSingleParent.booleanValue();
            }

            public Boolean getIgnoreDefaultVisibility() {
                return this.ignoreDefaultVisibility;
            }

            public Create setIgnoreDefaultVisibility(Boolean bool) {
                this.ignoreDefaultVisibility = bool;
                return this;
            }

            public boolean isIgnoreDefaultVisibility() {
                Boolean bool = this.ignoreDefaultVisibility;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.ignoreDefaultVisibility.booleanValue();
            }

            public String getIncludeLabels() {
                return this.includeLabels;
            }

            public Create setIncludeLabels(String str) {
                this.includeLabels = str;
                return this;
            }

            public String getIncludePermissionsForView() {
                return this.includePermissionsForView;
            }

            public Create setIncludePermissionsForView(String str) {
                this.includePermissionsForView = str;
                return this;
            }

            public Boolean getKeepRevisionForever() {
                return this.keepRevisionForever;
            }

            public Create setKeepRevisionForever(Boolean bool) {
                this.keepRevisionForever = bool;
                return this;
            }

            public boolean isKeepRevisionForever() {
                Boolean bool = this.keepRevisionForever;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.keepRevisionForever.booleanValue();
            }

            public String getOcrLanguage() {
                return this.ocrLanguage;
            }

            public Create setOcrLanguage(String str) {
                this.ocrLanguage = str;
                return this;
            }

            public Boolean getSupportsAllDrives() {
                return this.supportsAllDrives;
            }

            public Create setSupportsAllDrives(Boolean bool) {
                this.supportsAllDrives = bool;
                return this;
            }

            public boolean isSupportsAllDrives() {
                Boolean bool = this.supportsAllDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.supportsAllDrives.booleanValue();
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public Create setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.supportsTeamDrives.booleanValue();
            }

            public Boolean getUseContentAsIndexableText() {
                return this.useContentAsIndexableText;
            }

            public Create setUseContentAsIndexableText(Boolean bool) {
                this.useContentAsIndexableText = bool;
                return this;
            }

            public boolean isUseContentAsIndexableText() {
                Boolean bool = this.useContentAsIndexableText;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.useContentAsIndexableText.booleanValue();
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Create set(String str, Object obj) {
                return (Create) super.set(str, obj);
            }
        }

        public Delete delete(String str) throws IOException {
            Delete delete = new Delete(str);
            Drive.this.initialize(delete);
            return delete;
        }

        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}";

            @Key
            private Boolean enforceSingleParent;

            @Key
            private String fileId;

            @Key
            private Boolean supportsAllDrives;

            @Key
            private Boolean supportsTeamDrives;

            protected Delete(String str) {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<Void> set$Xgafv2(String str) {
                return (Delete) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<Void> setAccessToken2(String str) {
                return (Delete) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Delete) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<Void> setCallback2(String str) {
                return (Delete) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Delete) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Delete) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<Void> setUploadType2(String str) {
                return (Delete) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<Void> setUploadProtocol2(String str) {
                return (Delete) super.setUploadProtocol2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Delete setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Boolean getEnforceSingleParent() {
                return this.enforceSingleParent;
            }

            public Delete setEnforceSingleParent(Boolean bool) {
                this.enforceSingleParent = bool;
                return this;
            }

            public boolean isEnforceSingleParent() {
                Boolean bool = this.enforceSingleParent;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.enforceSingleParent.booleanValue();
            }

            public Boolean getSupportsAllDrives() {
                return this.supportsAllDrives;
            }

            public Delete setSupportsAllDrives(Boolean bool) {
                this.supportsAllDrives = bool;
                return this;
            }

            public boolean isSupportsAllDrives() {
                Boolean bool = this.supportsAllDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.supportsAllDrives.booleanValue();
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public Delete setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.supportsTeamDrives.booleanValue();
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        public EmptyTrash emptyTrash() throws IOException {
            EmptyTrash emptyTrash = new EmptyTrash();
            Drive.this.initialize(emptyTrash);
            return emptyTrash;
        }

        public class EmptyTrash extends DriveRequest<Void> {
            private static final String REST_PATH = "files/trash";

            @Key
            private String driveId;

            @Key
            private Boolean enforceSingleParent;

            protected EmptyTrash() {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<Void> set$Xgafv2(String str) {
                return (EmptyTrash) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<Void> setAccessToken2(String str) {
                return (EmptyTrash) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (EmptyTrash) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<Void> setCallback2(String str) {
                return (EmptyTrash) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (EmptyTrash) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (EmptyTrash) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (EmptyTrash) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (EmptyTrash) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (EmptyTrash) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<Void> setUploadType2(String str) {
                return (EmptyTrash) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<Void> setUploadProtocol2(String str) {
                return (EmptyTrash) super.setUploadProtocol2(str);
            }

            public String getDriveId() {
                return this.driveId;
            }

            public EmptyTrash setDriveId(String str) {
                this.driveId = str;
                return this;
            }

            public Boolean getEnforceSingleParent() {
                return this.enforceSingleParent;
            }

            public EmptyTrash setEnforceSingleParent(Boolean bool) {
                this.enforceSingleParent = bool;
                return this;
            }

            public boolean isEnforceSingleParent() {
                Boolean bool = this.enforceSingleParent;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.enforceSingleParent.booleanValue();
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public EmptyTrash set(String str, Object obj) {
                return (EmptyTrash) super.set(str, obj);
            }
        }

        public Export export(String str, String str2) throws IOException {
            Export export = new Export(str, str2);
            Drive.this.initialize(export);
            return export;
        }

        public class Export extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}/export";

            @Key
            private String fileId;

            @Key
            private String mimeType;

            protected Export(String str, String str2) {
                super(Drive.this, "GET", REST_PATH, null, Void.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.mimeType = (String) Preconditions.checkNotNull(str2, "Required parameter mimeType must be specified.");
                initializeMediaDownload();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public void executeMediaAndDownloadTo(OutputStream outputStream) throws IOException {
                super.executeMediaAndDownloadTo(outputStream);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public InputStream executeMediaAsInputStream() throws IOException {
                return super.executeMediaAsInputStream();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeMedia() throws IOException {
                return super.executeMedia();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public GenericUrl buildHttpRequestUrl() {
                return new GenericUrl(UriTemplate.expand(("media".equals(get("alt")) && getMediaHttpUploader() == null) ? Drive.this.getRootUrl() + "download/" + Drive.this.getServicePath() : Drive.this.getBaseUrl(), getUriTemplate(), this, true));
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<Void> set$Xgafv2(String str) {
                return (Export) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<Void> setAccessToken2(String str) {
                return (Export) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Export) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<Void> setCallback2(String str) {
                return (Export) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Export) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Export) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Export) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Export) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Export) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<Void> setUploadType2(String str) {
                return (Export) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<Void> setUploadProtocol2(String str) {
                return (Export) super.setUploadProtocol2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Export setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getMimeType() {
                return this.mimeType;
            }

            public Export setMimeType(String str) {
                this.mimeType = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Export set(String str, Object obj) {
                return (Export) super.set(str, obj);
            }
        }

        public GenerateIds generateIds() throws IOException {
            GenerateIds generateIds = new GenerateIds();
            Drive.this.initialize(generateIds);
            return generateIds;
        }

        public class GenerateIds extends DriveRequest<GeneratedIds> {
            private static final String REST_PATH = "files/generateIds";

            @Key
            private Integer count;

            @Key
            private String space;

            @Key
            private String type;

            protected GenerateIds() {
                super(Drive.this, "GET", REST_PATH, null, GeneratedIds.class);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<GeneratedIds> set$Xgafv2(String str) {
                return (GenerateIds) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<GeneratedIds> setAccessToken2(String str) {
                return (GenerateIds) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<GeneratedIds> setAlt2(String str) {
                return (GenerateIds) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<GeneratedIds> setCallback2(String str) {
                return (GenerateIds) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<GeneratedIds> setFields2(String str) {
                return (GenerateIds) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<GeneratedIds> setKey2(String str) {
                return (GenerateIds) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<GeneratedIds> setOauthToken2(String str) {
                return (GenerateIds) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<GeneratedIds> setPrettyPrint2(Boolean bool) {
                return (GenerateIds) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<GeneratedIds> setQuotaUser2(String str) {
                return (GenerateIds) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<GeneratedIds> setUploadType2(String str) {
                return (GenerateIds) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<GeneratedIds> setUploadProtocol2(String str) {
                return (GenerateIds) super.setUploadProtocol2(str);
            }

            public Integer getCount() {
                return this.count;
            }

            public GenerateIds setCount(Integer num) {
                this.count = num;
                return this;
            }

            public String getSpace() {
                return this.space;
            }

            public GenerateIds setSpace(String str) {
                this.space = str;
                return this;
            }

            public String getType() {
                return this.type;
            }

            public GenerateIds setType(String str) {
                this.type = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public GenerateIds set(String str, Object obj) {
                return (GenerateIds) super.set(str, obj);
            }
        }

        public Get get(String str) throws IOException {
            Get get = new Get(str);
            Drive.this.initialize(get);
            return get;
        }

        public class Get extends DriveRequest<File> {
            private static final String REST_PATH = "files/{fileId}";

            @Key
            private Boolean acknowledgeAbuse;

            @Key
            private String fileId;

            @Key
            private String includeLabels;

            @Key
            private String includePermissionsForView;

            @Key
            private Boolean supportsAllDrives;

            @Key
            private Boolean supportsTeamDrives;

            protected Get(String str) {
                super(Drive.this, "GET", REST_PATH, null, File.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                initializeMediaDownload();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public void executeMediaAndDownloadTo(OutputStream outputStream) throws IOException {
                super.executeMediaAndDownloadTo(outputStream);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public InputStream executeMediaAsInputStream() throws IOException {
                return super.executeMediaAsInputStream();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeMedia() throws IOException {
                return super.executeMedia();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public GenericUrl buildHttpRequestUrl() {
                return new GenericUrl(UriTemplate.expand(("media".equals(get("alt")) && getMediaHttpUploader() == null) ? Drive.this.getRootUrl() + "download/" + Drive.this.getServicePath() : Drive.this.getBaseUrl(), getUriTemplate(), this, true));
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<File> set$Xgafv2(String str) {
                return (Get) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<File> setAccessToken2(String str) {
                return (Get) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<File> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<File> setCallback2(String str) {
                return (Get) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<File> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<File> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<File> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<File> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<File> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<File> setUploadType2(String str) {
                return (Get) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<File> setUploadProtocol2(String str) {
                return (Get) super.setUploadProtocol2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Boolean getAcknowledgeAbuse() {
                return this.acknowledgeAbuse;
            }

            public Get setAcknowledgeAbuse(Boolean bool) {
                this.acknowledgeAbuse = bool;
                return this;
            }

            public boolean isAcknowledgeAbuse() {
                Boolean bool = this.acknowledgeAbuse;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.acknowledgeAbuse.booleanValue();
            }

            public String getIncludeLabels() {
                return this.includeLabels;
            }

            public Get setIncludeLabels(String str) {
                this.includeLabels = str;
                return this;
            }

            public String getIncludePermissionsForView() {
                return this.includePermissionsForView;
            }

            public Get setIncludePermissionsForView(String str) {
                this.includePermissionsForView = str;
                return this;
            }

            public Boolean getSupportsAllDrives() {
                return this.supportsAllDrives;
            }

            public Get setSupportsAllDrives(Boolean bool) {
                this.supportsAllDrives = bool;
                return this;
            }

            public boolean isSupportsAllDrives() {
                Boolean bool = this.supportsAllDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.supportsAllDrives.booleanValue();
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public Get setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.supportsTeamDrives.booleanValue();
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        public List list() throws IOException {
            List list = new List();
            Drive.this.initialize(list);
            return list;
        }

        public class List extends DriveRequest<FileList> {
            private static final String REST_PATH = "files";

            @Key
            private String corpora;

            @Key
            private String corpus;

            @Key
            private String driveId;

            @Key
            private Boolean includeItemsFromAllDrives;

            @Key
            private String includeLabels;

            @Key
            private String includePermissionsForView;

            @Key
            private Boolean includeTeamDriveItems;

            @Key
            private String orderBy;

            @Key
            private Integer pageSize;

            @Key
            private String pageToken;

            @Key
            private String q;

            @Key
            private String spaces;

            @Key
            private Boolean supportsAllDrives;

            @Key
            private Boolean supportsTeamDrives;

            @Key
            private String teamDriveId;

            protected List() {
                super(Drive.this, "GET", REST_PATH, null, FileList.class);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<FileList> set$Xgafv2(String str) {
                return (List) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<FileList> setAccessToken2(String str) {
                return (List) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<FileList> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<FileList> setCallback2(String str) {
                return (List) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<FileList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<FileList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<FileList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<FileList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<FileList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<FileList> setUploadType2(String str) {
                return (List) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<FileList> setUploadProtocol2(String str) {
                return (List) super.setUploadProtocol2(str);
            }

            public String getCorpora() {
                return this.corpora;
            }

            public List setCorpora(String str) {
                this.corpora = str;
                return this;
            }

            public String getCorpus() {
                return this.corpus;
            }

            public List setCorpus(String str) {
                this.corpus = str;
                return this;
            }

            public String getDriveId() {
                return this.driveId;
            }

            public List setDriveId(String str) {
                this.driveId = str;
                return this;
            }

            public Boolean getIncludeItemsFromAllDrives() {
                return this.includeItemsFromAllDrives;
            }

            public List setIncludeItemsFromAllDrives(Boolean bool) {
                this.includeItemsFromAllDrives = bool;
                return this;
            }

            public boolean isIncludeItemsFromAllDrives() {
                Boolean bool = this.includeItemsFromAllDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.includeItemsFromAllDrives.booleanValue();
            }

            public String getIncludeLabels() {
                return this.includeLabels;
            }

            public List setIncludeLabels(String str) {
                this.includeLabels = str;
                return this;
            }

            public String getIncludePermissionsForView() {
                return this.includePermissionsForView;
            }

            public List setIncludePermissionsForView(String str) {
                this.includePermissionsForView = str;
                return this;
            }

            public Boolean getIncludeTeamDriveItems() {
                return this.includeTeamDriveItems;
            }

            public List setIncludeTeamDriveItems(Boolean bool) {
                this.includeTeamDriveItems = bool;
                return this;
            }

            public boolean isIncludeTeamDriveItems() {
                Boolean bool = this.includeTeamDriveItems;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.includeTeamDriveItems.booleanValue();
            }

            public String getOrderBy() {
                return this.orderBy;
            }

            public List setOrderBy(String str) {
                this.orderBy = str;
                return this;
            }

            public Integer getPageSize() {
                return this.pageSize;
            }

            public List setPageSize(Integer num) {
                this.pageSize = num;
                return this;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public String getQ() {
                return this.q;
            }

            public List setQ(String str) {
                this.q = str;
                return this;
            }

            public String getSpaces() {
                return this.spaces;
            }

            public List setSpaces(String str) {
                this.spaces = str;
                return this;
            }

            public Boolean getSupportsAllDrives() {
                return this.supportsAllDrives;
            }

            public List setSupportsAllDrives(Boolean bool) {
                this.supportsAllDrives = bool;
                return this;
            }

            public boolean isSupportsAllDrives() {
                Boolean bool = this.supportsAllDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.supportsAllDrives.booleanValue();
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public List setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.supportsTeamDrives.booleanValue();
            }

            public String getTeamDriveId() {
                return this.teamDriveId;
            }

            public List setTeamDriveId(String str) {
                this.teamDriveId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        public ListLabels listLabels(String str) throws IOException {
            ListLabels listLabels = new ListLabels(str);
            Drive.this.initialize(listLabels);
            return listLabels;
        }

        public class ListLabels extends DriveRequest<LabelList> {
            private static final String REST_PATH = "files/{fileId}/listLabels";

            @Key
            private String fileId;

            @Key
            private Integer maxResults;

            @Key
            private String pageToken;

            protected ListLabels(String str) {
                super(Drive.this, "GET", REST_PATH, null, LabelList.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<LabelList> set$Xgafv2(String str) {
                return (ListLabels) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<LabelList> setAccessToken2(String str) {
                return (ListLabels) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<LabelList> setAlt2(String str) {
                return (ListLabels) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<LabelList> setCallback2(String str) {
                return (ListLabels) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<LabelList> setFields2(String str) {
                return (ListLabels) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<LabelList> setKey2(String str) {
                return (ListLabels) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<LabelList> setOauthToken2(String str) {
                return (ListLabels) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<LabelList> setPrettyPrint2(Boolean bool) {
                return (ListLabels) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<LabelList> setQuotaUser2(String str) {
                return (ListLabels) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<LabelList> setUploadType2(String str) {
                return (ListLabels) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<LabelList> setUploadProtocol2(String str) {
                return (ListLabels) super.setUploadProtocol2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public ListLabels setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Integer getMaxResults() {
                return this.maxResults;
            }

            public ListLabels setMaxResults(Integer num) {
                this.maxResults = num;
                return this;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public ListLabels setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public ListLabels set(String str, Object obj) {
                return (ListLabels) super.set(str, obj);
            }
        }

        public ModifyLabels modifyLabels(String str, ModifyLabelsRequest modifyLabelsRequest) throws IOException {
            ModifyLabels modifyLabels = new ModifyLabels(str, modifyLabelsRequest);
            Drive.this.initialize(modifyLabels);
            return modifyLabels;
        }

        public class ModifyLabels extends DriveRequest<ModifyLabelsResponse> {
            private static final String REST_PATH = "files/{fileId}/modifyLabels";

            @Key
            private String fileId;

            protected ModifyLabels(String str, ModifyLabelsRequest modifyLabelsRequest) {
                super(Drive.this, "POST", REST_PATH, modifyLabelsRequest, ModifyLabelsResponse.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<ModifyLabelsResponse> set$Xgafv2(String str) {
                return (ModifyLabels) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<ModifyLabelsResponse> setAccessToken2(String str) {
                return (ModifyLabels) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<ModifyLabelsResponse> setAlt2(String str) {
                return (ModifyLabels) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<ModifyLabelsResponse> setCallback2(String str) {
                return (ModifyLabels) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<ModifyLabelsResponse> setFields2(String str) {
                return (ModifyLabels) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<ModifyLabelsResponse> setKey2(String str) {
                return (ModifyLabels) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<ModifyLabelsResponse> setOauthToken2(String str) {
                return (ModifyLabels) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<ModifyLabelsResponse> setPrettyPrint2(Boolean bool) {
                return (ModifyLabels) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<ModifyLabelsResponse> setQuotaUser2(String str) {
                return (ModifyLabels) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<ModifyLabelsResponse> setUploadType2(String str) {
                return (ModifyLabels) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<ModifyLabelsResponse> setUploadProtocol2(String str) {
                return (ModifyLabels) super.setUploadProtocol2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public ModifyLabels setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public ModifyLabels set(String str, Object obj) {
                return (ModifyLabels) super.set(str, obj);
            }
        }

        public Update update(String str, File file) throws IOException {
            Update update = new Update(str, file);
            Drive.this.initialize(update);
            return update;
        }

        public Update update(String str, File file, AbstractInputStreamContent abstractInputStreamContent) throws IOException {
            Update update = new Update(str, file, abstractInputStreamContent);
            Drive.this.initialize(update);
            return update;
        }

        public class Update extends DriveRequest<File> {
            private static final String REST_PATH = "files/{fileId}";

            @Key
            private String addParents;

            @Key
            private Boolean enforceSingleParent;

            @Key
            private String fileId;

            @Key
            private String includeLabels;

            @Key
            private String includePermissionsForView;

            @Key
            private Boolean keepRevisionForever;

            @Key
            private String ocrLanguage;

            @Key
            private String removeParents;

            @Key
            private Boolean supportsAllDrives;

            @Key
            private Boolean supportsTeamDrives;

            @Key
            private Boolean useContentAsIndexableText;

            protected Update(String str, File file) {
                super(Drive.this, "PATCH", REST_PATH, file, File.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
            }

            protected Update(String str, File file, AbstractInputStreamContent abstractInputStreamContent) {
                super(Drive.this, "PATCH", "/upload/" + Drive.this.getServicePath() + REST_PATH, file, File.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                Preconditions.checkNotNull(abstractInputStreamContent, "Required parameter mediaContent must be specified.");
                initializeMediaUpload(abstractInputStreamContent);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<File> set$Xgafv2(String str) {
                return (Update) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<File> setAccessToken2(String str) {
                return (Update) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<File> setAlt2(String str) {
                return (Update) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<File> setCallback2(String str) {
                return (Update) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<File> setFields2(String str) {
                return (Update) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<File> setKey2(String str) {
                return (Update) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<File> setOauthToken2(String str) {
                return (Update) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<File> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<File> setQuotaUser2(String str) {
                return (Update) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<File> setUploadType2(String str) {
                return (Update) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<File> setUploadProtocol2(String str) {
                return (Update) super.setUploadProtocol2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Update setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getAddParents() {
                return this.addParents;
            }

            public Update setAddParents(String str) {
                this.addParents = str;
                return this;
            }

            public Boolean getEnforceSingleParent() {
                return this.enforceSingleParent;
            }

            public Update setEnforceSingleParent(Boolean bool) {
                this.enforceSingleParent = bool;
                return this;
            }

            public boolean isEnforceSingleParent() {
                Boolean bool = this.enforceSingleParent;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.enforceSingleParent.booleanValue();
            }

            public String getIncludeLabels() {
                return this.includeLabels;
            }

            public Update setIncludeLabels(String str) {
                this.includeLabels = str;
                return this;
            }

            public String getIncludePermissionsForView() {
                return this.includePermissionsForView;
            }

            public Update setIncludePermissionsForView(String str) {
                this.includePermissionsForView = str;
                return this;
            }

            public Boolean getKeepRevisionForever() {
                return this.keepRevisionForever;
            }

            public Update setKeepRevisionForever(Boolean bool) {
                this.keepRevisionForever = bool;
                return this;
            }

            public boolean isKeepRevisionForever() {
                Boolean bool = this.keepRevisionForever;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.keepRevisionForever.booleanValue();
            }

            public String getOcrLanguage() {
                return this.ocrLanguage;
            }

            public Update setOcrLanguage(String str) {
                this.ocrLanguage = str;
                return this;
            }

            public String getRemoveParents() {
                return this.removeParents;
            }

            public Update setRemoveParents(String str) {
                this.removeParents = str;
                return this;
            }

            public Boolean getSupportsAllDrives() {
                return this.supportsAllDrives;
            }

            public Update setSupportsAllDrives(Boolean bool) {
                this.supportsAllDrives = bool;
                return this;
            }

            public boolean isSupportsAllDrives() {
                Boolean bool = this.supportsAllDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.supportsAllDrives.booleanValue();
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public Update setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.supportsTeamDrives.booleanValue();
            }

            public Boolean getUseContentAsIndexableText() {
                return this.useContentAsIndexableText;
            }

            public Update setUseContentAsIndexableText(Boolean bool) {
                this.useContentAsIndexableText = bool;
                return this;
            }

            public boolean isUseContentAsIndexableText() {
                Boolean bool = this.useContentAsIndexableText;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.useContentAsIndexableText.booleanValue();
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }

        public Watch watch(String str, Channel channel) throws IOException {
            Watch watch = new Watch(str, channel);
            Drive.this.initialize(watch);
            return watch;
        }

        public class Watch extends DriveRequest<Channel> {
            private static final String REST_PATH = "files/{fileId}/watch";

            @Key
            private Boolean acknowledgeAbuse;

            @Key
            private String fileId;

            @Key
            private String includeLabels;

            @Key
            private String includePermissionsForView;

            @Key
            private Boolean supportsAllDrives;

            @Key
            private Boolean supportsTeamDrives;

            protected Watch(String str, Channel channel) {
                super(Drive.this, "POST", REST_PATH, channel, Channel.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<Channel> set$Xgafv2(String str) {
                return (Watch) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<Channel> setAccessToken2(String str) {
                return (Watch) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<Channel> setAlt2(String str) {
                return (Watch) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<Channel> setCallback2(String str) {
                return (Watch) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<Channel> setFields2(String str) {
                return (Watch) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<Channel> setKey2(String str) {
                return (Watch) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<Channel> setOauthToken2(String str) {
                return (Watch) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<Channel> setPrettyPrint2(Boolean bool) {
                return (Watch) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<Channel> setQuotaUser2(String str) {
                return (Watch) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<Channel> setUploadType2(String str) {
                return (Watch) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<Channel> setUploadProtocol2(String str) {
                return (Watch) super.setUploadProtocol2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Watch setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Boolean getAcknowledgeAbuse() {
                return this.acknowledgeAbuse;
            }

            public Watch setAcknowledgeAbuse(Boolean bool) {
                this.acknowledgeAbuse = bool;
                return this;
            }

            public boolean isAcknowledgeAbuse() {
                Boolean bool = this.acknowledgeAbuse;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.acknowledgeAbuse.booleanValue();
            }

            public String getIncludeLabels() {
                return this.includeLabels;
            }

            public Watch setIncludeLabels(String str) {
                this.includeLabels = str;
                return this;
            }

            public String getIncludePermissionsForView() {
                return this.includePermissionsForView;
            }

            public Watch setIncludePermissionsForView(String str) {
                this.includePermissionsForView = str;
                return this;
            }

            public Boolean getSupportsAllDrives() {
                return this.supportsAllDrives;
            }

            public Watch setSupportsAllDrives(Boolean bool) {
                this.supportsAllDrives = bool;
                return this;
            }

            public boolean isSupportsAllDrives() {
                Boolean bool = this.supportsAllDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.supportsAllDrives.booleanValue();
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public Watch setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.supportsTeamDrives.booleanValue();
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Watch set(String str, Object obj) {
                return (Watch) super.set(str, obj);
            }
        }
    }

    public Permissions permissions() {
        return new Permissions();
    }

    public class Permissions {
        public Permissions() {
        }

        public Create create(String str, Permission permission) throws IOException {
            Create create = new Create(str, permission);
            Drive.this.initialize(create);
            return create;
        }

        public class Create extends DriveRequest<Permission> {
            private static final String REST_PATH = "files/{fileId}/permissions";

            @Key
            private String emailMessage;

            @Key
            private Boolean enforceSingleParent;

            @Key
            private String fileId;

            @Key
            private Boolean moveToNewOwnersRoot;

            @Key
            private Boolean sendNotificationEmail;

            @Key
            private Boolean supportsAllDrives;

            @Key
            private Boolean supportsTeamDrives;

            @Key
            private Boolean transferOwnership;

            @Key
            private Boolean useDomainAdminAccess;

            protected Create(String str, Permission permission) {
                super(Drive.this, "POST", REST_PATH, permission, Permission.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                checkRequiredParameter(permission, "content");
                checkRequiredParameter(permission.getRole(), "Permission.getRole()");
                checkRequiredParameter(permission, "content");
                checkRequiredParameter(permission.getType(), "Permission.getType()");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<Permission> set$Xgafv2(String str) {
                return (Create) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<Permission> setAccessToken2(String str) {
                return (Create) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<Permission> setAlt2(String str) {
                return (Create) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<Permission> setCallback2(String str) {
                return (Create) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<Permission> setFields2(String str) {
                return (Create) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<Permission> setKey2(String str) {
                return (Create) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<Permission> setOauthToken2(String str) {
                return (Create) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<Permission> setPrettyPrint2(Boolean bool) {
                return (Create) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<Permission> setQuotaUser2(String str) {
                return (Create) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<Permission> setUploadType2(String str) {
                return (Create) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<Permission> setUploadProtocol2(String str) {
                return (Create) super.setUploadProtocol2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Create setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getEmailMessage() {
                return this.emailMessage;
            }

            public Create setEmailMessage(String str) {
                this.emailMessage = str;
                return this;
            }

            public Boolean getEnforceSingleParent() {
                return this.enforceSingleParent;
            }

            public Create setEnforceSingleParent(Boolean bool) {
                this.enforceSingleParent = bool;
                return this;
            }

            public boolean isEnforceSingleParent() {
                Boolean bool = this.enforceSingleParent;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.enforceSingleParent.booleanValue();
            }

            public Boolean getMoveToNewOwnersRoot() {
                return this.moveToNewOwnersRoot;
            }

            public Create setMoveToNewOwnersRoot(Boolean bool) {
                this.moveToNewOwnersRoot = bool;
                return this;
            }

            public boolean isMoveToNewOwnersRoot() {
                Boolean bool = this.moveToNewOwnersRoot;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.moveToNewOwnersRoot.booleanValue();
            }

            public Boolean getSendNotificationEmail() {
                return this.sendNotificationEmail;
            }

            public Create setSendNotificationEmail(Boolean bool) {
                this.sendNotificationEmail = bool;
                return this;
            }

            public Boolean getSupportsAllDrives() {
                return this.supportsAllDrives;
            }

            public Create setSupportsAllDrives(Boolean bool) {
                this.supportsAllDrives = bool;
                return this;
            }

            public boolean isSupportsAllDrives() {
                Boolean bool = this.supportsAllDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.supportsAllDrives.booleanValue();
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public Create setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.supportsTeamDrives.booleanValue();
            }

            public Boolean getTransferOwnership() {
                return this.transferOwnership;
            }

            public Create setTransferOwnership(Boolean bool) {
                this.transferOwnership = bool;
                return this;
            }

            public boolean isTransferOwnership() {
                Boolean bool = this.transferOwnership;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.transferOwnership.booleanValue();
            }

            public Boolean getUseDomainAdminAccess() {
                return this.useDomainAdminAccess;
            }

            public Create setUseDomainAdminAccess(Boolean bool) {
                this.useDomainAdminAccess = bool;
                return this;
            }

            public boolean isUseDomainAdminAccess() {
                Boolean bool = this.useDomainAdminAccess;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.useDomainAdminAccess.booleanValue();
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Create set(String str, Object obj) {
                return (Create) super.set(str, obj);
            }
        }

        public Delete delete(String str, String str2) throws IOException {
            Delete delete = new Delete(str, str2);
            Drive.this.initialize(delete);
            return delete;
        }

        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}/permissions/{permissionId}";

            @Key
            private String fileId;

            @Key
            private String permissionId;

            @Key
            private Boolean supportsAllDrives;

            @Key
            private Boolean supportsTeamDrives;

            @Key
            private Boolean useDomainAdminAccess;

            protected Delete(String str, String str2) {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.permissionId = (String) Preconditions.checkNotNull(str2, "Required parameter permissionId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<Void> set$Xgafv2(String str) {
                return (Delete) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<Void> setAccessToken2(String str) {
                return (Delete) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Delete) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<Void> setCallback2(String str) {
                return (Delete) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Delete) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Delete) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<Void> setUploadType2(String str) {
                return (Delete) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<Void> setUploadProtocol2(String str) {
                return (Delete) super.setUploadProtocol2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Delete setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getPermissionId() {
                return this.permissionId;
            }

            public Delete setPermissionId(String str) {
                this.permissionId = str;
                return this;
            }

            public Boolean getSupportsAllDrives() {
                return this.supportsAllDrives;
            }

            public Delete setSupportsAllDrives(Boolean bool) {
                this.supportsAllDrives = bool;
                return this;
            }

            public boolean isSupportsAllDrives() {
                Boolean bool = this.supportsAllDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.supportsAllDrives.booleanValue();
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public Delete setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.supportsTeamDrives.booleanValue();
            }

            public Boolean getUseDomainAdminAccess() {
                return this.useDomainAdminAccess;
            }

            public Delete setUseDomainAdminAccess(Boolean bool) {
                this.useDomainAdminAccess = bool;
                return this;
            }

            public boolean isUseDomainAdminAccess() {
                Boolean bool = this.useDomainAdminAccess;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.useDomainAdminAccess.booleanValue();
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        public Get get(String str, String str2) throws IOException {
            Get get = new Get(str, str2);
            Drive.this.initialize(get);
            return get;
        }

        public class Get extends DriveRequest<Permission> {
            private static final String REST_PATH = "files/{fileId}/permissions/{permissionId}";

            @Key
            private String fileId;

            @Key
            private String permissionId;

            @Key
            private Boolean supportsAllDrives;

            @Key
            private Boolean supportsTeamDrives;

            @Key
            private Boolean useDomainAdminAccess;

            protected Get(String str, String str2) {
                super(Drive.this, "GET", REST_PATH, null, Permission.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.permissionId = (String) Preconditions.checkNotNull(str2, "Required parameter permissionId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<Permission> set$Xgafv2(String str) {
                return (Get) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<Permission> setAccessToken2(String str) {
                return (Get) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<Permission> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<Permission> setCallback2(String str) {
                return (Get) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<Permission> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<Permission> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<Permission> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<Permission> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<Permission> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<Permission> setUploadType2(String str) {
                return (Get) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<Permission> setUploadProtocol2(String str) {
                return (Get) super.setUploadProtocol2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getPermissionId() {
                return this.permissionId;
            }

            public Get setPermissionId(String str) {
                this.permissionId = str;
                return this;
            }

            public Boolean getSupportsAllDrives() {
                return this.supportsAllDrives;
            }

            public Get setSupportsAllDrives(Boolean bool) {
                this.supportsAllDrives = bool;
                return this;
            }

            public boolean isSupportsAllDrives() {
                Boolean bool = this.supportsAllDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.supportsAllDrives.booleanValue();
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public Get setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.supportsTeamDrives.booleanValue();
            }

            public Boolean getUseDomainAdminAccess() {
                return this.useDomainAdminAccess;
            }

            public Get setUseDomainAdminAccess(Boolean bool) {
                this.useDomainAdminAccess = bool;
                return this;
            }

            public boolean isUseDomainAdminAccess() {
                Boolean bool = this.useDomainAdminAccess;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.useDomainAdminAccess.booleanValue();
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        public List list(String str) throws IOException {
            List list = new List(str);
            Drive.this.initialize(list);
            return list;
        }

        public class List extends DriveRequest<PermissionList> {
            private static final String REST_PATH = "files/{fileId}/permissions";

            @Key
            private String fileId;

            @Key
            private String includePermissionsForView;

            @Key
            private Integer pageSize;

            @Key
            private String pageToken;

            @Key
            private Boolean supportsAllDrives;

            @Key
            private Boolean supportsTeamDrives;

            @Key
            private Boolean useDomainAdminAccess;

            protected List(String str) {
                super(Drive.this, "GET", REST_PATH, null, PermissionList.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<PermissionList> set$Xgafv2(String str) {
                return (List) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<PermissionList> setAccessToken2(String str) {
                return (List) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<PermissionList> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<PermissionList> setCallback2(String str) {
                return (List) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<PermissionList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<PermissionList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<PermissionList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<PermissionList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<PermissionList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<PermissionList> setUploadType2(String str) {
                return (List) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<PermissionList> setUploadProtocol2(String str) {
                return (List) super.setUploadProtocol2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public List setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getIncludePermissionsForView() {
                return this.includePermissionsForView;
            }

            public List setIncludePermissionsForView(String str) {
                this.includePermissionsForView = str;
                return this;
            }

            public Integer getPageSize() {
                return this.pageSize;
            }

            public List setPageSize(Integer num) {
                this.pageSize = num;
                return this;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public Boolean getSupportsAllDrives() {
                return this.supportsAllDrives;
            }

            public List setSupportsAllDrives(Boolean bool) {
                this.supportsAllDrives = bool;
                return this;
            }

            public boolean isSupportsAllDrives() {
                Boolean bool = this.supportsAllDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.supportsAllDrives.booleanValue();
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public List setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.supportsTeamDrives.booleanValue();
            }

            public Boolean getUseDomainAdminAccess() {
                return this.useDomainAdminAccess;
            }

            public List setUseDomainAdminAccess(Boolean bool) {
                this.useDomainAdminAccess = bool;
                return this;
            }

            public boolean isUseDomainAdminAccess() {
                Boolean bool = this.useDomainAdminAccess;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.useDomainAdminAccess.booleanValue();
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        public Update update(String str, String str2, Permission permission) throws IOException {
            Update update = new Update(str, str2, permission);
            Drive.this.initialize(update);
            return update;
        }

        public class Update extends DriveRequest<Permission> {
            private static final String REST_PATH = "files/{fileId}/permissions/{permissionId}";

            @Key
            private String fileId;

            @Key
            private String permissionId;

            @Key
            private Boolean removeExpiration;

            @Key
            private Boolean supportsAllDrives;

            @Key
            private Boolean supportsTeamDrives;

            @Key
            private Boolean transferOwnership;

            @Key
            private Boolean useDomainAdminAccess;

            protected Update(String str, String str2, Permission permission) {
                super(Drive.this, "PATCH", REST_PATH, permission, Permission.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.permissionId = (String) Preconditions.checkNotNull(str2, "Required parameter permissionId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<Permission> set$Xgafv2(String str) {
                return (Update) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<Permission> setAccessToken2(String str) {
                return (Update) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<Permission> setAlt2(String str) {
                return (Update) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<Permission> setCallback2(String str) {
                return (Update) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<Permission> setFields2(String str) {
                return (Update) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<Permission> setKey2(String str) {
                return (Update) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<Permission> setOauthToken2(String str) {
                return (Update) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<Permission> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<Permission> setQuotaUser2(String str) {
                return (Update) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<Permission> setUploadType2(String str) {
                return (Update) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<Permission> setUploadProtocol2(String str) {
                return (Update) super.setUploadProtocol2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Update setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getPermissionId() {
                return this.permissionId;
            }

            public Update setPermissionId(String str) {
                this.permissionId = str;
                return this;
            }

            public Boolean getRemoveExpiration() {
                return this.removeExpiration;
            }

            public Update setRemoveExpiration(Boolean bool) {
                this.removeExpiration = bool;
                return this;
            }

            public boolean isRemoveExpiration() {
                Boolean bool = this.removeExpiration;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.removeExpiration.booleanValue();
            }

            public Boolean getSupportsAllDrives() {
                return this.supportsAllDrives;
            }

            public Update setSupportsAllDrives(Boolean bool) {
                this.supportsAllDrives = bool;
                return this;
            }

            public boolean isSupportsAllDrives() {
                Boolean bool = this.supportsAllDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.supportsAllDrives.booleanValue();
            }

            public Boolean getSupportsTeamDrives() {
                return this.supportsTeamDrives;
            }

            public Update setSupportsTeamDrives(Boolean bool) {
                this.supportsTeamDrives = bool;
                return this;
            }

            public boolean isSupportsTeamDrives() {
                Boolean bool = this.supportsTeamDrives;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.supportsTeamDrives.booleanValue();
            }

            public Boolean getTransferOwnership() {
                return this.transferOwnership;
            }

            public Update setTransferOwnership(Boolean bool) {
                this.transferOwnership = bool;
                return this;
            }

            public boolean isTransferOwnership() {
                Boolean bool = this.transferOwnership;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.transferOwnership.booleanValue();
            }

            public Boolean getUseDomainAdminAccess() {
                return this.useDomainAdminAccess;
            }

            public Update setUseDomainAdminAccess(Boolean bool) {
                this.useDomainAdminAccess = bool;
                return this;
            }

            public boolean isUseDomainAdminAccess() {
                Boolean bool = this.useDomainAdminAccess;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.useDomainAdminAccess.booleanValue();
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }
    }

    public Replies replies() {
        return new Replies();
    }

    public class Replies {
        public Replies() {
        }

        public Create create(String str, String str2, Reply reply) throws IOException {
            Create create = new Create(str, str2, reply);
            Drive.this.initialize(create);
            return create;
        }

        public class Create extends DriveRequest<Reply> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}/replies";

            @Key
            private String commentId;

            @Key
            private String fileId;

            protected Create(String str, String str2, Reply reply) {
                super(Drive.this, "POST", REST_PATH, reply, Reply.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.commentId = (String) Preconditions.checkNotNull(str2, "Required parameter commentId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<Reply> set$Xgafv2(String str) {
                return (Create) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<Reply> setAccessToken2(String str) {
                return (Create) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<Reply> setAlt2(String str) {
                return (Create) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<Reply> setCallback2(String str) {
                return (Create) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<Reply> setFields2(String str) {
                return (Create) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<Reply> setKey2(String str) {
                return (Create) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<Reply> setOauthToken2(String str) {
                return (Create) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<Reply> setPrettyPrint2(Boolean bool) {
                return (Create) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<Reply> setQuotaUser2(String str) {
                return (Create) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<Reply> setUploadType2(String str) {
                return (Create) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<Reply> setUploadProtocol2(String str) {
                return (Create) super.setUploadProtocol2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Create setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getCommentId() {
                return this.commentId;
            }

            public Create setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Create set(String str, Object obj) {
                return (Create) super.set(str, obj);
            }
        }

        public Delete delete(String str, String str2, String str3) throws IOException {
            Delete delete = new Delete(str, str2, str3);
            Drive.this.initialize(delete);
            return delete;
        }

        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}/replies/{replyId}";

            @Key
            private String commentId;

            @Key
            private String fileId;

            @Key
            private String replyId;

            protected Delete(String str, String str2, String str3) {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.commentId = (String) Preconditions.checkNotNull(str2, "Required parameter commentId must be specified.");
                this.replyId = (String) Preconditions.checkNotNull(str3, "Required parameter replyId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<Void> set$Xgafv2(String str) {
                return (Delete) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<Void> setAccessToken2(String str) {
                return (Delete) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Delete) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<Void> setCallback2(String str) {
                return (Delete) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Delete) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Delete) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<Void> setUploadType2(String str) {
                return (Delete) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<Void> setUploadProtocol2(String str) {
                return (Delete) super.setUploadProtocol2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Delete setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getCommentId() {
                return this.commentId;
            }

            public Delete setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public String getReplyId() {
                return this.replyId;
            }

            public Delete setReplyId(String str) {
                this.replyId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        public Get get(String str, String str2, String str3) throws IOException {
            Get get = new Get(str, str2, str3);
            Drive.this.initialize(get);
            return get;
        }

        public class Get extends DriveRequest<Reply> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}/replies/{replyId}";

            @Key
            private String commentId;

            @Key
            private String fileId;

            @Key
            private Boolean includeDeleted;

            @Key
            private String replyId;

            protected Get(String str, String str2, String str3) {
                super(Drive.this, "GET", REST_PATH, null, Reply.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.commentId = (String) Preconditions.checkNotNull(str2, "Required parameter commentId must be specified.");
                this.replyId = (String) Preconditions.checkNotNull(str3, "Required parameter replyId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<Reply> set$Xgafv2(String str) {
                return (Get) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<Reply> setAccessToken2(String str) {
                return (Get) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<Reply> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<Reply> setCallback2(String str) {
                return (Get) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<Reply> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<Reply> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<Reply> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<Reply> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<Reply> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<Reply> setUploadType2(String str) {
                return (Get) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<Reply> setUploadProtocol2(String str) {
                return (Get) super.setUploadProtocol2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getCommentId() {
                return this.commentId;
            }

            public Get setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public String getReplyId() {
                return this.replyId;
            }

            public Get setReplyId(String str) {
                this.replyId = str;
                return this;
            }

            public Boolean getIncludeDeleted() {
                return this.includeDeleted;
            }

            public Get setIncludeDeleted(Boolean bool) {
                this.includeDeleted = bool;
                return this;
            }

            public boolean isIncludeDeleted() {
                Boolean bool = this.includeDeleted;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.includeDeleted.booleanValue();
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        public List list(String str, String str2) throws IOException {
            List list = new List(str, str2);
            Drive.this.initialize(list);
            return list;
        }

        public class List extends DriveRequest<ReplyList> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}/replies";

            @Key
            private String commentId;

            @Key
            private String fileId;

            @Key
            private Boolean includeDeleted;

            @Key
            private Integer pageSize;

            @Key
            private String pageToken;

            protected List(String str, String str2) {
                super(Drive.this, "GET", REST_PATH, null, ReplyList.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.commentId = (String) Preconditions.checkNotNull(str2, "Required parameter commentId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<ReplyList> set$Xgafv2(String str) {
                return (List) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<ReplyList> setAccessToken2(String str) {
                return (List) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<ReplyList> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<ReplyList> setCallback2(String str) {
                return (List) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<ReplyList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<ReplyList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<ReplyList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<ReplyList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<ReplyList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<ReplyList> setUploadType2(String str) {
                return (List) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<ReplyList> setUploadProtocol2(String str) {
                return (List) super.setUploadProtocol2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public List setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getCommentId() {
                return this.commentId;
            }

            public List setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public Boolean getIncludeDeleted() {
                return this.includeDeleted;
            }

            public List setIncludeDeleted(Boolean bool) {
                this.includeDeleted = bool;
                return this;
            }

            public boolean isIncludeDeleted() {
                Boolean bool = this.includeDeleted;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.includeDeleted.booleanValue();
            }

            public Integer getPageSize() {
                return this.pageSize;
            }

            public List setPageSize(Integer num) {
                this.pageSize = num;
                return this;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        public Update update(String str, String str2, String str3, Reply reply) throws IOException {
            Update update = new Update(str, str2, str3, reply);
            Drive.this.initialize(update);
            return update;
        }

        public class Update extends DriveRequest<Reply> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}/replies/{replyId}";

            @Key
            private String commentId;

            @Key
            private String fileId;

            @Key
            private String replyId;

            protected Update(String str, String str2, String str3, Reply reply) {
                super(Drive.this, "PATCH", REST_PATH, reply, Reply.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.commentId = (String) Preconditions.checkNotNull(str2, "Required parameter commentId must be specified.");
                this.replyId = (String) Preconditions.checkNotNull(str3, "Required parameter replyId must be specified.");
                checkRequiredParameter(reply, "content");
                checkRequiredParameter(reply.getContent(), "Reply.getContent()");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<Reply> set$Xgafv2(String str) {
                return (Update) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<Reply> setAccessToken2(String str) {
                return (Update) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<Reply> setAlt2(String str) {
                return (Update) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<Reply> setCallback2(String str) {
                return (Update) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<Reply> setFields2(String str) {
                return (Update) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<Reply> setKey2(String str) {
                return (Update) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<Reply> setOauthToken2(String str) {
                return (Update) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<Reply> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<Reply> setQuotaUser2(String str) {
                return (Update) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<Reply> setUploadType2(String str) {
                return (Update) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<Reply> setUploadProtocol2(String str) {
                return (Update) super.setUploadProtocol2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Update setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getCommentId() {
                return this.commentId;
            }

            public Update setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public String getReplyId() {
                return this.replyId;
            }

            public Update setReplyId(String str) {
                this.replyId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }
    }

    public Revisions revisions() {
        return new Revisions();
    }

    public class Revisions {
        public Revisions() {
        }

        public Delete delete(String str, String str2) throws IOException {
            Delete delete = new Delete(str, str2);
            Drive.this.initialize(delete);
            return delete;
        }

        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}/revisions/{revisionId}";

            @Key
            private String fileId;

            @Key
            private String revisionId;

            protected Delete(String str, String str2) {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.revisionId = (String) Preconditions.checkNotNull(str2, "Required parameter revisionId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<Void> set$Xgafv2(String str) {
                return (Delete) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<Void> setAccessToken2(String str) {
                return (Delete) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Delete) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<Void> setCallback2(String str) {
                return (Delete) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Delete) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Delete) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<Void> setUploadType2(String str) {
                return (Delete) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<Void> setUploadProtocol2(String str) {
                return (Delete) super.setUploadProtocol2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Delete setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getRevisionId() {
                return this.revisionId;
            }

            public Delete setRevisionId(String str) {
                this.revisionId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        public Get get(String str, String str2) throws IOException {
            Get get = new Get(str, str2);
            Drive.this.initialize(get);
            return get;
        }

        public class Get extends DriveRequest<Revision> {
            private static final String REST_PATH = "files/{fileId}/revisions/{revisionId}";

            @Key
            private Boolean acknowledgeAbuse;

            @Key
            private String fileId;

            @Key
            private String revisionId;

            protected Get(String str, String str2) {
                super(Drive.this, "GET", REST_PATH, null, Revision.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.revisionId = (String) Preconditions.checkNotNull(str2, "Required parameter revisionId must be specified.");
                initializeMediaDownload();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public void executeMediaAndDownloadTo(OutputStream outputStream) throws IOException {
                super.executeMediaAndDownloadTo(outputStream);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public InputStream executeMediaAsInputStream() throws IOException {
                return super.executeMediaAsInputStream();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeMedia() throws IOException {
                return super.executeMedia();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public GenericUrl buildHttpRequestUrl() {
                return new GenericUrl(UriTemplate.expand(("media".equals(get("alt")) && getMediaHttpUploader() == null) ? Drive.this.getRootUrl() + "download/" + Drive.this.getServicePath() : Drive.this.getBaseUrl(), getUriTemplate(), this, true));
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<Revision> set$Xgafv2(String str) {
                return (Get) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<Revision> setAccessToken2(String str) {
                return (Get) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<Revision> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<Revision> setCallback2(String str) {
                return (Get) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<Revision> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<Revision> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<Revision> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<Revision> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<Revision> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<Revision> setUploadType2(String str) {
                return (Get) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<Revision> setUploadProtocol2(String str) {
                return (Get) super.setUploadProtocol2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getRevisionId() {
                return this.revisionId;
            }

            public Get setRevisionId(String str) {
                this.revisionId = str;
                return this;
            }

            public Boolean getAcknowledgeAbuse() {
                return this.acknowledgeAbuse;
            }

            public Get setAcknowledgeAbuse(Boolean bool) {
                this.acknowledgeAbuse = bool;
                return this;
            }

            public boolean isAcknowledgeAbuse() {
                Boolean bool = this.acknowledgeAbuse;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.acknowledgeAbuse.booleanValue();
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        public List list(String str) throws IOException {
            List list = new List(str);
            Drive.this.initialize(list);
            return list;
        }

        public class List extends DriveRequest<RevisionList> {
            private static final String REST_PATH = "files/{fileId}/revisions";

            @Key
            private String fileId;

            @Key
            private Integer pageSize;

            @Key
            private String pageToken;

            protected List(String str) {
                super(Drive.this, "GET", REST_PATH, null, RevisionList.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<RevisionList> set$Xgafv2(String str) {
                return (List) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<RevisionList> setAccessToken2(String str) {
                return (List) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<RevisionList> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<RevisionList> setCallback2(String str) {
                return (List) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<RevisionList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<RevisionList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<RevisionList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<RevisionList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<RevisionList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<RevisionList> setUploadType2(String str) {
                return (List) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<RevisionList> setUploadProtocol2(String str) {
                return (List) super.setUploadProtocol2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public List setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Integer getPageSize() {
                return this.pageSize;
            }

            public List setPageSize(Integer num) {
                this.pageSize = num;
                return this;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        public Update update(String str, String str2, Revision revision) throws IOException {
            Update update = new Update(str, str2, revision);
            Drive.this.initialize(update);
            return update;
        }

        public class Update extends DriveRequest<Revision> {
            private static final String REST_PATH = "files/{fileId}/revisions/{revisionId}";

            @Key
            private String fileId;

            @Key
            private String revisionId;

            protected Update(String str, String str2, Revision revision) {
                super(Drive.this, "PATCH", REST_PATH, revision, Revision.class);
                this.fileId = (String) Preconditions.checkNotNull(str, "Required parameter fileId must be specified.");
                this.revisionId = (String) Preconditions.checkNotNull(str2, "Required parameter revisionId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<Revision> set$Xgafv2(String str) {
                return (Update) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<Revision> setAccessToken2(String str) {
                return (Update) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<Revision> setAlt2(String str) {
                return (Update) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<Revision> setCallback2(String str) {
                return (Update) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<Revision> setFields2(String str) {
                return (Update) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<Revision> setKey2(String str) {
                return (Update) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<Revision> setOauthToken2(String str) {
                return (Update) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<Revision> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<Revision> setQuotaUser2(String str) {
                return (Update) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<Revision> setUploadType2(String str) {
                return (Update) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<Revision> setUploadProtocol2(String str) {
                return (Update) super.setUploadProtocol2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Update setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getRevisionId() {
                return this.revisionId;
            }

            public Update setRevisionId(String str) {
                this.revisionId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }
    }

    public Teamdrives teamdrives() {
        return new Teamdrives();
    }

    public class Teamdrives {
        public Teamdrives() {
        }

        public Create create(String str, TeamDrive teamDrive) throws IOException {
            Create create = new Create(str, teamDrive);
            Drive.this.initialize(create);
            return create;
        }

        public class Create extends DriveRequest<TeamDrive> {
            private static final String REST_PATH = "teamdrives";

            @Key
            private String requestId;

            protected Create(String str, TeamDrive teamDrive) {
                super(Drive.this, "POST", REST_PATH, teamDrive, TeamDrive.class);
                this.requestId = (String) Preconditions.checkNotNull(str, "Required parameter requestId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<TeamDrive> set$Xgafv2(String str) {
                return (Create) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<TeamDrive> setAccessToken2(String str) {
                return (Create) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<TeamDrive> setAlt2(String str) {
                return (Create) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<TeamDrive> setCallback2(String str) {
                return (Create) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<TeamDrive> setFields2(String str) {
                return (Create) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<TeamDrive> setKey2(String str) {
                return (Create) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<TeamDrive> setOauthToken2(String str) {
                return (Create) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<TeamDrive> setPrettyPrint2(Boolean bool) {
                return (Create) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<TeamDrive> setQuotaUser2(String str) {
                return (Create) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<TeamDrive> setUploadType2(String str) {
                return (Create) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<TeamDrive> setUploadProtocol2(String str) {
                return (Create) super.setUploadProtocol2(str);
            }

            public String getRequestId() {
                return this.requestId;
            }

            public Create setRequestId(String str) {
                this.requestId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Create set(String str, Object obj) {
                return (Create) super.set(str, obj);
            }
        }

        public Delete delete(String str) throws IOException {
            Delete delete = new Delete(str);
            Drive.this.initialize(delete);
            return delete;
        }

        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "teamdrives/{teamDriveId}";

            @Key
            private String teamDriveId;

            protected Delete(String str) {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
                this.teamDriveId = (String) Preconditions.checkNotNull(str, "Required parameter teamDriveId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<Void> set$Xgafv2(String str) {
                return (Delete) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<Void> setAccessToken2(String str) {
                return (Delete) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Delete) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<Void> setCallback2(String str) {
                return (Delete) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Delete) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Delete) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<Void> setUploadType2(String str) {
                return (Delete) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<Void> setUploadProtocol2(String str) {
                return (Delete) super.setUploadProtocol2(str);
            }

            public String getTeamDriveId() {
                return this.teamDriveId;
            }

            public Delete setTeamDriveId(String str) {
                this.teamDriveId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        public Get get(String str) throws IOException {
            Get get = new Get(str);
            Drive.this.initialize(get);
            return get;
        }

        public class Get extends DriveRequest<TeamDrive> {
            private static final String REST_PATH = "teamdrives/{teamDriveId}";

            @Key
            private String teamDriveId;

            @Key
            private Boolean useDomainAdminAccess;

            protected Get(String str) {
                super(Drive.this, "GET", REST_PATH, null, TeamDrive.class);
                this.teamDriveId = (String) Preconditions.checkNotNull(str, "Required parameter teamDriveId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<TeamDrive> set$Xgafv2(String str) {
                return (Get) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<TeamDrive> setAccessToken2(String str) {
                return (Get) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<TeamDrive> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<TeamDrive> setCallback2(String str) {
                return (Get) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<TeamDrive> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<TeamDrive> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<TeamDrive> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<TeamDrive> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<TeamDrive> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<TeamDrive> setUploadType2(String str) {
                return (Get) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<TeamDrive> setUploadProtocol2(String str) {
                return (Get) super.setUploadProtocol2(str);
            }

            public String getTeamDriveId() {
                return this.teamDriveId;
            }

            public Get setTeamDriveId(String str) {
                this.teamDriveId = str;
                return this;
            }

            public Boolean getUseDomainAdminAccess() {
                return this.useDomainAdminAccess;
            }

            public Get setUseDomainAdminAccess(Boolean bool) {
                this.useDomainAdminAccess = bool;
                return this;
            }

            public boolean isUseDomainAdminAccess() {
                Boolean bool = this.useDomainAdminAccess;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.useDomainAdminAccess.booleanValue();
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        public List list() throws IOException {
            List list = new List();
            Drive.this.initialize(list);
            return list;
        }

        public class List extends DriveRequest<TeamDriveList> {
            private static final String REST_PATH = "teamdrives";

            @Key
            private Integer pageSize;

            @Key
            private String pageToken;

            @Key
            private String q;

            @Key
            private Boolean useDomainAdminAccess;

            protected List() {
                super(Drive.this, "GET", REST_PATH, null, TeamDriveList.class);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<TeamDriveList> set$Xgafv2(String str) {
                return (List) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<TeamDriveList> setAccessToken2(String str) {
                return (List) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<TeamDriveList> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<TeamDriveList> setCallback2(String str) {
                return (List) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<TeamDriveList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<TeamDriveList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<TeamDriveList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<TeamDriveList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<TeamDriveList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<TeamDriveList> setUploadType2(String str) {
                return (List) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<TeamDriveList> setUploadProtocol2(String str) {
                return (List) super.setUploadProtocol2(str);
            }

            public Integer getPageSize() {
                return this.pageSize;
            }

            public List setPageSize(Integer num) {
                this.pageSize = num;
                return this;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public String getQ() {
                return this.q;
            }

            public List setQ(String str) {
                this.q = str;
                return this;
            }

            public Boolean getUseDomainAdminAccess() {
                return this.useDomainAdminAccess;
            }

            public List setUseDomainAdminAccess(Boolean bool) {
                this.useDomainAdminAccess = bool;
                return this;
            }

            public boolean isUseDomainAdminAccess() {
                Boolean bool = this.useDomainAdminAccess;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.useDomainAdminAccess.booleanValue();
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        public Update update(String str, TeamDrive teamDrive) throws IOException {
            Update update = new Update(str, teamDrive);
            Drive.this.initialize(update);
            return update;
        }

        public class Update extends DriveRequest<TeamDrive> {
            private static final String REST_PATH = "teamdrives/{teamDriveId}";

            @Key
            private String teamDriveId;

            @Key
            private Boolean useDomainAdminAccess;

            protected Update(String str, TeamDrive teamDrive) {
                super(Drive.this, "PATCH", REST_PATH, teamDrive, TeamDrive.class);
                this.teamDriveId = (String) Preconditions.checkNotNull(str, "Required parameter teamDriveId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: set$Xgafv */
            public DriveRequest<TeamDrive> set$Xgafv2(String str) {
                return (Update) super.set$Xgafv2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAccessToken */
            public DriveRequest<TeamDrive> setAccessToken2(String str) {
                return (Update) super.setAccessToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setAlt */
            public DriveRequest<TeamDrive> setAlt2(String str) {
                return (Update) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setCallback */
            public DriveRequest<TeamDrive> setCallback2(String str) {
                return (Update) super.setCallback2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setFields */
            public DriveRequest<TeamDrive> setFields2(String str) {
                return (Update) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setKey */
            public DriveRequest<TeamDrive> setKey2(String str) {
                return (Update) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setOauthToken */
            public DriveRequest<TeamDrive> setOauthToken2(String str) {
                return (Update) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setPrettyPrint */
            public DriveRequest<TeamDrive> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setQuotaUser */
            public DriveRequest<TeamDrive> setQuotaUser2(String str) {
                return (Update) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadType */
            public DriveRequest<TeamDrive> setUploadType2(String str) {
                return (Update) super.setUploadType2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* INFO: renamed from: setUploadProtocol */
            public DriveRequest<TeamDrive> setUploadProtocol2(String str) {
                return (Update) super.setUploadProtocol2(str);
            }

            public String getTeamDriveId() {
                return this.teamDriveId;
            }

            public Update setTeamDriveId(String str) {
                this.teamDriveId = str;
                return this;
            }

            public Boolean getUseDomainAdminAccess() {
                return this.useDomainAdminAccess;
            }

            public Update setUseDomainAdminAccess(Boolean bool) {
                this.useDomainAdminAccess = bool;
                return this;
            }

            public boolean isUseDomainAdminAccess() {
                Boolean bool = this.useDomainAdminAccess;
                if (bool == null || bool == Data.NULL_BOOLEAN) {
                    return false;
                }
                return this.useDomainAdminAccess.booleanValue();
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }
    }

    public static final class Builder extends AbstractGoogleJsonClient.Builder {
        private static String chooseEndpoint(HttpTransport httpTransport) {
            String str = System.getenv("GOOGLE_API_USE_MTLS_ENDPOINT");
            if (str == null) {
                str = "auto";
            }
            if (!ConfigConstants.CONFIG_KEY_ALWAYS.equals(str)) {
                if ("auto".equals(str) && httpTransport != null && httpTransport.isMtls()) {
                    return Drive.DEFAULT_MTLS_ROOT_URL;
                }
                return Drive.DEFAULT_ROOT_URL;
            }
            return Drive.DEFAULT_MTLS_ROOT_URL;
        }

        public Builder(HttpTransport httpTransport, JsonFactory jsonFactory, HttpRequestInitializer httpRequestInitializer) {
            super(httpTransport, jsonFactory, chooseEndpoint(httpTransport), Drive.DEFAULT_SERVICE_PATH, httpRequestInitializer, false);
            setBatchPath(Drive.DEFAULT_BATCH_PATH);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Drive build() {
            return new Drive(this);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setRootUrl(String str) {
            return (Builder) super.setRootUrl(str);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setServicePath(String str) {
            return (Builder) super.setServicePath(str);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setBatchPath(String str) {
            return (Builder) super.setBatchPath(str);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setHttpRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
            return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setApplicationName(String str) {
            return (Builder) super.setApplicationName(str);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setSuppressPatternChecks(boolean z) {
            return (Builder) super.setSuppressPatternChecks(z);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setSuppressRequiredParameterChecks(boolean z) {
            return (Builder) super.setSuppressRequiredParameterChecks(z);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setSuppressAllChecks(boolean z) {
            return (Builder) super.setSuppressAllChecks(z);
        }

        public Builder setDriveRequestInitializer(DriveRequestInitializer driveRequestInitializer) {
            return (Builder) super.setGoogleClientRequestInitializer((GoogleClientRequestInitializer) driveRequestInitializer);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer googleClientRequestInitializer) {
            return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setUniverseDomain(String str) {
            return (Builder) super.setUniverseDomain(str);
        }
    }
}
