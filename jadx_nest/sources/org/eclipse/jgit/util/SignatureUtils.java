package org.eclipse.jgit.util;

import java.text.MessageFormat;
import java.util.Locale;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.SignatureVerifier;

/* JADX INFO: loaded from: classes5.dex */
public final class SignatureUtils {
    private SignatureUtils() {
    }

    public static String toString(SignatureVerifier.SignatureVerification signatureVerification, PersonIdent personIdent, GitDateFormatter gitDateFormatter) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(MessageFormat.format(JGitText.get().verifySignatureMade, gitDateFormatter.formatDate(new PersonIdent(personIdent, signatureVerification.creationDate()))));
        sb.append('\n');
        sb.append(MessageFormat.format(JGitText.get().verifySignatureKey, signatureVerification.keyFingerprint().toUpperCase(Locale.ROOT)));
        sb.append('\n');
        if (!StringUtils.isEmptyOrNull(signatureVerification.signer())) {
            sb.append(MessageFormat.format(JGitText.get().verifySignatureIssuer, signatureVerification.signer()));
            sb.append('\n');
        }
        if (signatureVerification.verified()) {
            if (signatureVerification.expired()) {
                str = JGitText.get().verifySignatureExpired;
            } else {
                str = JGitText.get().verifySignatureGood;
            }
        } else {
            str = JGitText.get().verifySignatureBad;
        }
        sb.append(MessageFormat.format(str, signatureVerification.keyUser()));
        if (!SignatureVerifier.TrustLevel.UNKNOWN.equals(signatureVerification.trustLevel())) {
            sb.append(" " + MessageFormat.format(JGitText.get().verifySignatureTrust, signatureVerification.trustLevel().name().toLowerCase(Locale.ROOT)));
        }
        sb.append('\n');
        String strMessage = signatureVerification.message();
        if (!StringUtils.isEmptyOrNull(strMessage)) {
            sb.append(strMessage);
            sb.append('\n');
        }
        return sb.toString();
    }
}
