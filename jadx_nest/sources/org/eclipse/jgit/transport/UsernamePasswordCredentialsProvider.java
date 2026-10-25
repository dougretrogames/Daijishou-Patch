package org.eclipse.jgit.transport;

import java.util.Arrays;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.errors.UnsupportedCredentialItem;

/* JADX INFO: loaded from: classes5.dex */
public class UsernamePasswordCredentialsProvider extends CredentialsProvider {
    private char[] password;
    private String username;

    @Override // org.eclipse.jgit.transport.CredentialsProvider
    public boolean isInteractive() {
        return false;
    }

    public UsernamePasswordCredentialsProvider(String str, String str2) {
        this(str, str2.toCharArray());
    }

    public UsernamePasswordCredentialsProvider(String str, char[] cArr) {
        this.username = str;
        this.password = cArr;
    }

    @Override // org.eclipse.jgit.transport.CredentialsProvider
    public boolean supports(CredentialItem... credentialItemArr) {
        for (CredentialItem credentialItem : credentialItemArr) {
            if (!(credentialItem instanceof CredentialItem.InformationalMessage) && !(credentialItem instanceof CredentialItem.Username) && !(credentialItem instanceof CredentialItem.Password) && (!(credentialItem instanceof CredentialItem.StringType) || !credentialItem.getPromptText().equals("Password: "))) {
                return false;
            }
        }
        return true;
    }

    @Override // org.eclipse.jgit.transport.CredentialsProvider
    public boolean get(URIish uRIish, CredentialItem... credentialItemArr) throws UnsupportedCredentialItem {
        for (CredentialItem credentialItem : credentialItemArr) {
            if (!(credentialItem instanceof CredentialItem.InformationalMessage)) {
                if (credentialItem instanceof CredentialItem.Username) {
                    ((CredentialItem.Username) credentialItem).setValue(this.username);
                } else if (credentialItem instanceof CredentialItem.Password) {
                    ((CredentialItem.Password) credentialItem).setValue(this.password);
                } else if ((credentialItem instanceof CredentialItem.StringType) && credentialItem.getPromptText().equals("Password: ")) {
                    ((CredentialItem.StringType) credentialItem).setValue(new String(this.password));
                } else {
                    throw new UnsupportedCredentialItem(uRIish, credentialItem.getClass().getName() + CollectionUtils.COLON + credentialItem.getPromptText());
                }
            }
        }
        return true;
    }

    public void clear() {
        this.username = null;
        char[] cArr = this.password;
        if (cArr != null) {
            Arrays.fill(cArr, (char) 0);
            this.password = null;
        }
    }
}
