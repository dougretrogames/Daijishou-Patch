package com.google.auth;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface RequestMetadataCallback {
    void onFailure(Throwable th);

    void onSuccess(Map<String, List<String>> map);
}
