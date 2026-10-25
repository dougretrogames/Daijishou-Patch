package org.eclipse.jgit.lib;

import com.android.tools.r8.RecordTag;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public interface SignatureVerifier {

    public enum TrustLevel {
        UNKNOWN,
        NEVER,
        MARGINAL,
        FULL,
        ULTIMATE;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static TrustLevel[] valuesCustom() {
            TrustLevel[] trustLevelArrValuesCustom = values();
            int length = trustLevelArrValuesCustom.length;
            TrustLevel[] trustLevelArr = new TrustLevel[length];
            System.arraycopy(trustLevelArrValuesCustom, 0, trustLevelArr, 0, length);
            return trustLevelArr;
        }
    }

    void clear();

    String getName();

    SignatureVerification verify(Repository repository, GpgConfig gpgConfig, byte[] bArr, byte[] bArr2) throws IOException;

    public static final class SignatureVerification extends RecordTag {
        private final Date creationDate;
        private final boolean expired;
        private final String keyFingerprint;
        private final String keyUser;
        private final String message;
        private final String signer;
        private final TrustLevel trustLevel;
        private final boolean verified;
        private final String verifierName;

        private /* synthetic */ boolean $record$equals(Object obj) {
            if (!(obj instanceof SignatureVerification)) {
                return false;
            }
            SignatureVerification signatureVerification = (SignatureVerification) obj;
            return this.verified == signatureVerification.verified && this.expired == signatureVerification.expired && Objects.equals(this.verifierName, signatureVerification.verifierName) && Objects.equals(this.creationDate, signatureVerification.creationDate) && Objects.equals(this.signer, signatureVerification.signer) && Objects.equals(this.keyFingerprint, signatureVerification.keyFingerprint) && Objects.equals(this.keyUser, signatureVerification.keyUser) && Objects.equals(this.trustLevel, signatureVerification.trustLevel) && Objects.equals(this.message, signatureVerification.message);
        }

        private /* synthetic */ Object[] $record$getFieldsAsObjects() {
            return new Object[]{this.verifierName, this.creationDate, this.signer, this.keyFingerprint, this.keyUser, Boolean.valueOf(this.verified), Boolean.valueOf(this.expired), this.trustLevel, this.message};
        }

        public final boolean equals(Object obj) {
            return $record$equals(obj);
        }

        public final int hashCode() {
            return CommitConfig$$ExternalSyntheticBackport0.m(this.verified, this.expired, this.verifierName, this.creationDate, this.signer, this.keyFingerprint, this.keyUser, this.trustLevel, this.message);
        }

        public final String toString() {
            return CommitConfig$$ExternalSyntheticBackport0.m($record$getFieldsAsObjects(), SignatureVerification.class, "verifierName;creationDate;signer;keyFingerprint;keyUser;verified;expired;trustLevel;message");
        }

        public SignatureVerification(String verifierName, Date creationDate, String signer, String keyFingerprint, String keyUser, boolean verified, boolean expired, TrustLevel trustLevel, String message) {
            this.verifierName = verifierName;
            this.creationDate = creationDate;
            this.signer = signer;
            this.keyFingerprint = keyFingerprint;
            this.keyUser = keyUser;
            this.verified = verified;
            this.expired = expired;
            this.trustLevel = trustLevel;
            this.message = message;
        }

        public String verifierName() {
            return this.verifierName;
        }

        public Date creationDate() {
            return this.creationDate;
        }

        public String signer() {
            return this.signer;
        }

        public String keyFingerprint() {
            return this.keyFingerprint;
        }

        public String keyUser() {
            return this.keyUser;
        }

        public boolean verified() {
            return this.verified;
        }

        public boolean expired() {
            return this.expired;
        }

        public TrustLevel trustLevel() {
            return this.trustLevel;
        }

        public String message() {
            return this.message;
        }
    }
}
