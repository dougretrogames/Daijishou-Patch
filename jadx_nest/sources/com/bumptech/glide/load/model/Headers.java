package com.bumptech.glide.load.model;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface Headers {

    @Deprecated
    public static final Headers NONE = new AnonymousClass1();
    public static final Headers DEFAULT = new LazyHeaders.Builder().build();

    Map<String, String> getHeaders();

    /* JADX INFO: renamed from: com.bumptech.glide.load.model.Headers$1, reason: invalid class name */
    class AnonymousClass1 implements Headers {
        AnonymousClass1() {
        }

        @Override // com.bumptech.glide.load.model.Headers
        public Map<String, String> getHeaders() {
            return Collections.emptyMap();
        }
    }
}
