package org.eclipse.jgit.api.errors;

/* JADX INFO: loaded from: classes5.dex */
public class InvalidConfigurationException extends GitAPIException {
    private static final long serialVersionUID = 1;

    public InvalidConfigurationException(String str, Throwable th) {
        super(str, th);
    }

    public InvalidConfigurationException(String str) {
        super(str);
    }
}
