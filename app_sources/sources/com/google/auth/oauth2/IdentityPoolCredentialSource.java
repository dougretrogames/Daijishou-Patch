package com.google.auth.oauth2;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: loaded from: classes3.dex */
public class IdentityPoolCredentialSource extends ExternalAccountCredentials.CredentialSource {
    private static final long serialVersionUID = -745855247050085694L;
    CredentialFormatType credentialFormatType;
    String credentialLocation;
    IdentityPoolCredentialSourceType credentialSourceType;

    @Nullable
    Map<String, String> headers;

    @Nullable
    String subjectTokenFieldName;

    enum CredentialFormatType {
        TEXT,
        JSON
    }

    enum IdentityPoolCredentialSourceType {
        FILE,
        URL
    }

    public IdentityPoolCredentialSource(Map<String, Object> map) {
        super(map);
        if (map.containsKey("file") && map.containsKey("url")) {
            throw new IllegalArgumentException("Only one credential source type can be set, either file or url.");
        }
        if (map.containsKey("file")) {
            this.credentialLocation = (String) map.get("file");
            this.credentialSourceType = IdentityPoolCredentialSourceType.FILE;
        } else if (map.containsKey("url")) {
            this.credentialLocation = (String) map.get("url");
            this.credentialSourceType = IdentityPoolCredentialSourceType.URL;
        } else {
            throw new IllegalArgumentException("Missing credential source file location or URL. At least one must be specified.");
        }
        Map map2 = (Map) map.get("headers");
        if (map2 != null && !map2.isEmpty()) {
            HashMap map3 = new HashMap();
            this.headers = map3;
            map3.putAll(map2);
        }
        this.credentialFormatType = CredentialFormatType.TEXT;
        Map map4 = (Map) map.get(ConfigConstants.CONFIG_KEY_FORMAT);
        if (map4 == null || !map4.containsKey("type")) {
            return;
        }
        String str = (String) map4.get("type");
        if (str != null && "json".equals(str.toLowerCase(Locale.US))) {
            if (!map4.containsKey("subject_token_field_name")) {
                throw new IllegalArgumentException("When specifying a JSON credential type, the subject_token_field_name must be set.");
            }
            this.credentialFormatType = CredentialFormatType.JSON;
            this.subjectTokenFieldName = (String) map4.get("subject_token_field_name");
            return;
        }
        if (str != null && "text".equals(str.toLowerCase(Locale.US))) {
            this.credentialFormatType = CredentialFormatType.TEXT;
            return;
        }
        throw new IllegalArgumentException(String.format("Invalid credential source format type: %s.", str));
    }

    boolean hasHeaders() {
        Map<String, String> map = this.headers;
        return (map == null || map.isEmpty()) ? false : true;
    }
}
