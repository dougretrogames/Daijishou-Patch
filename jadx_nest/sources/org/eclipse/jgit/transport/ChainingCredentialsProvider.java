package org.eclipse.jgit.transport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jgit.errors.UnsupportedCredentialItem;

/* JADX INFO: loaded from: classes5.dex */
public class ChainingCredentialsProvider extends CredentialsProvider {
    private List<CredentialsProvider> credentialProviders;

    public ChainingCredentialsProvider(CredentialsProvider... credentialsProviderArr) {
        this.credentialProviders = new ArrayList(Arrays.asList(credentialsProviderArr));
    }

    @Override // org.eclipse.jgit.transport.CredentialsProvider
    public boolean isInteractive() {
        Iterator<CredentialsProvider> it = this.credentialProviders.iterator();
        while (it.hasNext()) {
            if (it.next().isInteractive()) {
                return true;
            }
        }
        return false;
    }

    @Override // org.eclipse.jgit.transport.CredentialsProvider
    public boolean supports(CredentialItem... credentialItemArr) {
        Iterator<CredentialsProvider> it = this.credentialProviders.iterator();
        while (it.hasNext()) {
            if (it.next().supports(credentialItemArr)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.eclipse.jgit.transport.CredentialsProvider
    public boolean get(URIish uRIish, CredentialItem... credentialItemArr) throws UnsupportedCredentialItem {
        for (CredentialsProvider credentialsProvider : this.credentialProviders) {
            if (credentialsProvider.supports(credentialItemArr)) {
                if (!credentialsProvider.get(uRIish, credentialItemArr)) {
                    if (credentialsProvider.isInteractive()) {
                        return false;
                    }
                } else if (!isAnyNull(credentialItemArr)) {
                    return true;
                }
            }
        }
        return false;
    }
}
