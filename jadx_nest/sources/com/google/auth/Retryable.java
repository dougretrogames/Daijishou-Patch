package com.google.auth;

/* JADX INFO: loaded from: classes3.dex */
public interface Retryable {
    int getRetryCount();

    boolean isRetryable();
}
