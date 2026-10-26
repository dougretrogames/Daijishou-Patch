package com.google.auth.oauth2;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonObjectParser;
import com.google.common.io.CharStreams;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;

/* INFO: loaded from: classes3.dex */
class FileIdentityPoolSubjectTokenSupplier implements IdentityPoolSubjectTokenSupplier {
    private final IdentityPoolCredentialSource credentialSource;
    private final long serialVersionUID = 2475549052347431992L;

    FileIdentityPoolSubjectTokenSupplier(IdentityPoolCredentialSource identityPoolCredentialSource) {
        this.credentialSource = identityPoolCredentialSource;
    }

    @Override // com.google.auth.oauth2.IdentityPoolSubjectTokenSupplier
    public String getSubjectToken(ExternalAccountSupplierContext externalAccountSupplierContext) throws IOException {
        String str = this.credentialSource.credentialLocation;
        if (!Files.exists(Paths.get(str, new String[0]), LinkOption.NOFOLLOW_LINKS)) {
            throw new IOException(String.format("Invalid credential location. The file at %s does not exist.", str));
        }
        try {
            return parseToken(new FileInputStream(new File(str)), this.credentialSource);
        } catch (IOException e) {
            throw new IOException("Error when attempting to read the subject token from the credential file.", e);
        }
    }

    static String parseToken(InputStream inputStream, IdentityPoolCredentialSource identityPoolCredentialSource) throws IOException {
        if (identityPoolCredentialSource.credentialFormatType == IdentityPoolCredentialSource.CredentialFormatType.TEXT) {
            return CharStreams.toString(new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)));
        }
        GenericJson genericJson = (GenericJson) new JsonObjectParser(OAuth2Utils.JSON_FACTORY).parseAndClose(inputStream, StandardCharsets.UTF_8, GenericJson.class);
        if (!genericJson.containsKey(identityPoolCredentialSource.subjectTokenFieldName)) {
            throw new IOException("Invalid subject token field name. No subject token was found.");
        }
        return (String) genericJson.get(identityPoolCredentialSource.subjectTokenFieldName);
    }
}
