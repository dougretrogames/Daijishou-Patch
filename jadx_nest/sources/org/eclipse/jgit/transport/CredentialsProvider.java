package org.eclipse.jgit.transport;

import java.util.List;
import org.eclipse.jgit.errors.UnsupportedCredentialItem;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CredentialsProvider {
    private static volatile CredentialsProvider defaultProvider;

    public abstract boolean get(URIish uRIish, CredentialItem... credentialItemArr) throws UnsupportedCredentialItem;

    public abstract boolean isInteractive();

    public void reset(URIish uRIish) {
    }

    public abstract boolean supports(CredentialItem... credentialItemArr);

    public static CredentialsProvider getDefault() {
        return defaultProvider;
    }

    public static void setDefault(CredentialsProvider credentialsProvider) {
        defaultProvider = credentialsProvider;
    }

    protected static boolean isAnyNull(CredentialItem... credentialItemArr) {
        for (CredentialItem credentialItem : credentialItemArr) {
            if (credentialItem == null) {
                return true;
            }
        }
        return false;
    }

    public boolean get(URIish uRIish, List<CredentialItem> list) throws UnsupportedCredentialItem {
        return get(uRIish, (CredentialItem[]) list.toArray(new CredentialItem[0]));
    }
}
