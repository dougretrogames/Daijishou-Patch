package com.google.auth.oauth2;

import java.io.Serializable;

/* INFO: loaded from: classes3.dex */
public class ExternalAccountSupplierContext implements Serializable {
    private static final long serialVersionUID = -7852130853542313494L;
    private final String audience;
    private final String subjectTokenType;

    /* synthetic */ ExternalAccountSupplierContext(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private ExternalAccountSupplierContext(Builder builder) {
        this.audience = builder.audience;
        this.subjectTokenType = builder.subjectTokenType;
    }

    public String getAudience() {
        return this.audience;
    }

    public String getSubjectTokenType() {
        return this.subjectTokenType;
    }

    static Builder newBuilder() {
        return new Builder();
    }

    static class Builder {
        protected String audience;
        protected String subjectTokenType;

        Builder() {
        }

        Builder setAudience(String str) {
            this.audience = str;
            return this;
        }

        Builder setSubjectTokenType(String str) {
            this.subjectTokenType = str;
            return this;
        }

        Builder setSubjectTokenType(ExternalAccountCredentials.SubjectTokenTypes subjectTokenTypes) {
            this.subjectTokenType = subjectTokenTypes.value;
            return this;
        }

        ExternalAccountSupplierContext build() {
            return new ExternalAccountSupplierContext(this, null);
        }
    }
}
