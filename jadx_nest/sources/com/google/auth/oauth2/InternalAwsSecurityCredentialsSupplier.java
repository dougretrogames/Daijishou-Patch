package com.google.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.json.GenericJson;
import com.google.auth.http.HttpTransportFactory;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
import net.lingala.zip4j.util.InternalZipConstants;
import org.eclipse.jgit.transport.AmazonS3;

/* JADX INFO: loaded from: classes3.dex */
class InternalAwsSecurityCredentialsSupplier implements AwsSecurityCredentialsSupplier {
    static final String AWS_ACCESS_KEY_ID = "AWS_ACCESS_KEY_ID";
    static final String AWS_DEFAULT_REGION = "AWS_DEFAULT_REGION";
    static final String AWS_IMDSV2_SESSION_TOKEN_HEADER = "x-aws-ec2-metadata-token";
    static final String AWS_IMDSV2_SESSION_TOKEN_TTL = "300";
    static final String AWS_IMDSV2_SESSION_TOKEN_TTL_HEADER = "x-aws-ec2-metadata-token-ttl-seconds";
    static final String AWS_REGION = "AWS_REGION";
    static final String AWS_SECRET_ACCESS_KEY = "AWS_SECRET_ACCESS_KEY";
    static final String AWS_SESSION_TOKEN = "AWS_SESSION_TOKEN";
    private static final long serialVersionUID = 4438370785261365013L;
    private final AwsCredentialSource awsCredentialSource;
    private EnvironmentProvider environmentProvider;
    private transient HttpTransportFactory transportFactory;

    InternalAwsSecurityCredentialsSupplier(AwsCredentialSource awsCredentialSource, EnvironmentProvider environmentProvider, HttpTransportFactory httpTransportFactory) {
        this.environmentProvider = environmentProvider;
        this.awsCredentialSource = awsCredentialSource;
        this.transportFactory = httpTransportFactory;
    }

    @Override // com.google.auth.oauth2.AwsSecurityCredentialsSupplier
    public AwsSecurityCredentials getCredentials(ExternalAccountSupplierContext externalAccountSupplierContext) throws IOException {
        if (canRetrieveSecurityCredentialsFromEnvironment()) {
            return new AwsSecurityCredentials(this.environmentProvider.getEnv(AWS_ACCESS_KEY_ID), this.environmentProvider.getEnv(AWS_SECRET_ACCESS_KEY), this.environmentProvider.getEnv(AWS_SESSION_TOKEN));
        }
        Map<String, Object> mapCreateMetadataRequestHeaders = createMetadataRequestHeaders(this.awsCredentialSource);
        if (this.awsCredentialSource.url == null || this.awsCredentialSource.url.isEmpty()) {
            throw new IOException("Unable to determine the AWS IAM role name. The credential source does not contain the url field.");
        }
        GenericJson genericJson = (GenericJson) OAuth2Utils.JSON_FACTORY.createJsonParser(retrieveResource(this.awsCredentialSource.url + InternalZipConstants.ZIP_FILE_SEPARATOR + retrieveResource(this.awsCredentialSource.url, "IAM role", mapCreateMetadataRequestHeaders), "credentials", mapCreateMetadataRequestHeaders)).parseAndClose(GenericJson.class);
        return new AwsSecurityCredentials((String) genericJson.get("AccessKeyId"), (String) genericJson.get("SecretAccessKey"), (String) genericJson.get("Token"));
    }

    @Override // com.google.auth.oauth2.AwsSecurityCredentialsSupplier
    public String getRegion(ExternalAccountSupplierContext externalAccountSupplierContext) throws IOException {
        if (canRetrieveRegionFromEnvironment()) {
            String env = this.environmentProvider.getEnv(AWS_REGION);
            return (env == null || env.trim().length() <= 0) ? this.environmentProvider.getEnv(AWS_DEFAULT_REGION) : env;
        }
        Map<String, Object> mapCreateMetadataRequestHeaders = createMetadataRequestHeaders(this.awsCredentialSource);
        if (this.awsCredentialSource.regionUrl == null || this.awsCredentialSource.regionUrl.isEmpty()) {
            throw new IOException("Unable to determine the AWS region. The credential source does not contain the region URL.");
        }
        String strRetrieveResource = retrieveResource(this.awsCredentialSource.regionUrl, AmazonS3.Keys.REGION, mapCreateMetadataRequestHeaders);
        return strRetrieveResource.substring(0, strRetrieveResource.length() - 1);
    }

    private boolean canRetrieveRegionFromEnvironment() {
        Iterator<E> it = ImmutableList.of(AWS_REGION, AWS_DEFAULT_REGION).iterator();
        while (it.hasNext()) {
            String env = this.environmentProvider.getEnv((String) it.next());
            if (env != null && env.trim().length() > 0) {
                return true;
            }
        }
        return false;
    }

    private boolean canRetrieveSecurityCredentialsFromEnvironment() {
        Iterator<E> it = ImmutableList.of(AWS_ACCESS_KEY_ID, AWS_SECRET_ACCESS_KEY).iterator();
        while (it.hasNext()) {
            String env = this.environmentProvider.getEnv((String) it.next());
            if (env == null || env.trim().length() == 0) {
                return false;
            }
        }
        return true;
    }

    boolean shouldUseMetadataServer() {
        return (canRetrieveRegionFromEnvironment() && canRetrieveSecurityCredentialsFromEnvironment()) ? false : true;
    }

    private String retrieveResource(String str, String str2, Map<String, Object> map) throws IOException {
        return retrieveResource(str, str2, "GET", map, null);
    }

    private String retrieveResource(String str, String str2, String str3, Map<String, Object> map, @Nullable HttpContent httpContent) throws IOException {
        try {
            HttpRequest httpRequestBuildRequest = this.transportFactory.create().createRequestFactory().buildRequest(str3, new GenericUrl(str), httpContent);
            HttpHeaders headers = httpRequestBuildRequest.getHeaders();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                headers.set(entry.getKey(), entry.getValue());
            }
            return httpRequestBuildRequest.execute().parseAsString();
        } catch (IOException e) {
            throw new IOException(String.format("Failed to retrieve AWS %s.", str2), e);
        }
    }

    Map<String, Object> createMetadataRequestHeaders(AwsCredentialSource awsCredentialSource) throws IOException {
        HashMap map = new HashMap();
        if (awsCredentialSource.imdsv2SessionTokenUrl != null) {
            map.put(AWS_IMDSV2_SESSION_TOKEN_HEADER, retrieveResource(awsCredentialSource.imdsv2SessionTokenUrl, "Session Token", "PUT", new AnonymousClass1(), null));
        }
        return map;
    }

    /* JADX INFO: renamed from: com.google.auth.oauth2.InternalAwsSecurityCredentialsSupplier$1, reason: invalid class name */
    class AnonymousClass1 extends HashMap<String, Object> {
        AnonymousClass1() {
            put(InternalAwsSecurityCredentialsSupplier.AWS_IMDSV2_SESSION_TOKEN_TTL_HEADER, InternalAwsSecurityCredentialsSupplier.AWS_IMDSV2_SESSION_TOKEN_TTL);
        }
    }
}
