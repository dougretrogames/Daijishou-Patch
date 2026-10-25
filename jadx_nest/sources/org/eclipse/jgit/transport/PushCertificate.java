package org.eclipse.jgit.transport;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.http.message.TokenParser;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Constants;

/* JADX INFO: loaded from: classes5.dex */
public class PushCertificate {
    private final List<ReceiveCommand> commands;
    private final String nonce;
    private final NonceStatus nonceStatus;
    private final String pushee;
    private final PushCertificateIdent pusher;
    private final String signature;
    private final String version;

    public enum NonceStatus {
        UNSOLICITED,
        BAD,
        MISSING,
        OK,
        SLOP;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static NonceStatus[] valuesCustom() {
            NonceStatus[] nonceStatusArrValuesCustom = values();
            int length = nonceStatusArrValuesCustom.length;
            NonceStatus[] nonceStatusArr = new NonceStatus[length];
            System.arraycopy(nonceStatusArrValuesCustom, 0, nonceStatusArr, 0, length);
            return nonceStatusArr;
        }
    }

    PushCertificate(String str, PushCertificateIdent pushCertificateIdent, String str2, String str3, NonceStatus nonceStatus, List<ReceiveCommand> list, String str4) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().pushCertificateInvalidField, "certificate version"));
        }
        if (pushCertificateIdent == null) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().pushCertificateInvalidField, "pusher"));
        }
        if (str3 == null || str3.isEmpty()) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().pushCertificateInvalidField, "nonce"));
        }
        if (nonceStatus == null) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().pushCertificateInvalidField, "nonce status"));
        }
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().pushCertificateInvalidField, "command"));
        }
        if (str4 == null || str4.isEmpty()) {
            throw new IllegalArgumentException(JGitText.get().pushCertificateInvalidSignature);
        }
        if (!str4.startsWith(Constants.GPG_SIGNATURE_PREFIX) || !str4.endsWith("-----END PGP SIGNATURE-----\n")) {
            throw new IllegalArgumentException(JGitText.get().pushCertificateInvalidSignature);
        }
        this.version = str;
        this.pusher = pushCertificateIdent;
        this.pushee = str2;
        this.nonce = str3;
        this.nonceStatus = nonceStatus;
        this.commands = list;
        this.signature = str4;
    }

    public String getVersion() {
        return this.version;
    }

    public String getPusher() {
        return this.pusher.getRaw();
    }

    public PushCertificateIdent getPusherIdent() {
        return this.pusher;
    }

    public String getPushee() {
        return this.pushee;
    }

    public String getNonce() {
        return this.nonce;
    }

    public NonceStatus getNonceStatus() {
        return this.nonceStatus;
    }

    public List<ReceiveCommand> getCommands() {
        return this.commands;
    }

    public String getSignature() {
        return this.signature;
    }

    public String toText() {
        return toStringBuilder().toString();
    }

    public String toTextWithSignature() {
        return toStringBuilder().append(this.signature).toString();
    }

    private StringBuilder toStringBuilder() {
        StringBuilder sbAppend = new StringBuilder().append("certificate version ").append(this.version).append("\npusher ").append(getPusher()).append('\n');
        if (this.pushee != null) {
            sbAppend.append("pushee ").append(this.pushee).append('\n');
        }
        sbAppend.append("nonce ").append(this.nonce).append("\n\n");
        for (ReceiveCommand receiveCommand : this.commands) {
            sbAppend.append(receiveCommand.getOldId().name()).append(TokenParser.SP).append(receiveCommand.getNewId().name()).append(TokenParser.SP).append(receiveCommand.getRefName()).append('\n');
        }
        return sbAppend;
    }

    public int hashCode() {
        return this.signature.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PushCertificate)) {
            return false;
        }
        PushCertificate pushCertificate = (PushCertificate) obj;
        return this.version.equals(pushCertificate.version) && this.pusher.equals(pushCertificate.pusher) && Objects.equals(this.pushee, pushCertificate.pushee) && this.nonceStatus == pushCertificate.nonceStatus && this.signature.equals(pushCertificate.signature) && commandsEqual(this, pushCertificate);
    }

    private static boolean commandsEqual(PushCertificate pushCertificate, PushCertificate pushCertificate2) {
        if (pushCertificate.commands.size() != pushCertificate2.commands.size()) {
            return false;
        }
        for (int i = 0; i < pushCertificate.commands.size(); i++) {
            ReceiveCommand receiveCommand = pushCertificate.commands.get(i);
            ReceiveCommand receiveCommand2 = pushCertificate2.commands.get(i);
            if (!receiveCommand.getOldId().equals((AnyObjectId) receiveCommand2.getOldId()) || !receiveCommand.getNewId().equals((AnyObjectId) receiveCommand2.getNewId()) || !receiveCommand.getRefName().equals(receiveCommand2.getRefName())) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return getClass().getSimpleName() + CollectionUtils.DEFAULT_TOSTRING_PREFIX + toTextWithSignature() + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
    }
}
