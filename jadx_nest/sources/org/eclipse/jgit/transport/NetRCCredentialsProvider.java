package org.eclipse.jgit.transport;

import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.errors.UnsupportedCredentialItem;

/* JADX INFO: loaded from: classes5.dex */
public class NetRCCredentialsProvider extends CredentialsProvider {
    NetRC netrc = new NetRC();

    @Override // org.eclipse.jgit.transport.CredentialsProvider
    public boolean isInteractive() {
        return false;
    }

    public static void install() {
        CredentialsProvider.setDefault(new NetRCCredentialsProvider());
    }

    @Override // org.eclipse.jgit.transport.CredentialsProvider
    public boolean supports(CredentialItem... credentialItemArr) {
        for (CredentialItem credentialItem : credentialItemArr) {
            if (!(credentialItem instanceof CredentialItem.Username) && !(credentialItem instanceof CredentialItem.Password)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.eclipse.jgit.transport.CredentialsProvider
    public boolean get(URIish uRIish, CredentialItem... credentialItemArr) throws UnsupportedCredentialItem {
        NetRC.NetRCEntry entry = this.netrc.getEntry(uRIish.getHost());
        if (entry == null) {
            return false;
        }
        for (CredentialItem credentialItem : credentialItemArr) {
            if (credentialItem instanceof CredentialItem.Username) {
                ((CredentialItem.Username) credentialItem).setValue(entry.login);
            } else if (credentialItem instanceof CredentialItem.Password) {
                ((CredentialItem.Password) credentialItem).setValue(entry.password);
            } else if ((credentialItem instanceof CredentialItem.StringType) && credentialItem.getPromptText().equals("Password: ")) {
                ((CredentialItem.StringType) credentialItem).setValue(new String(entry.password));
            } else {
                throw new UnsupportedCredentialItem(uRIish, credentialItem.getClass().getName() + CollectionUtils.COLON + credentialItem.getPromptText());
            }
        }
        return !isAnyNull(credentialItemArr);
    }
}
