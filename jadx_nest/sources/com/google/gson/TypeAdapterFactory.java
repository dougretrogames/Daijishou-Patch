package com.google.gson;

import com.google.gson.reflect.TypeToken;

/* INFO: loaded from: classes4.dex */
public interface TypeAdapterFactory {
    <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken);
}
