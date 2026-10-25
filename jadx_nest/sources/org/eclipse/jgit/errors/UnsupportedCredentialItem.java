package org.eclipse.jgit.errors;

import org.eclipse.jgit.transport.URIish;

/* JADX INFO: loaded from: classes5.dex */
public class UnsupportedCredentialItem extends RuntimeException {
    private static final long serialVersionUID = 1;

    public UnsupportedCredentialItem(URIish uRIish, String str) {
        super(String.valueOf(uRIish.setPass(null)) + ": " + str);
    }
}
