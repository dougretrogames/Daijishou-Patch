package com.bumptech.glide.load.engine;

/* INFO: loaded from: classes3.dex */
public interface Resource<Z> {
    Z get();

    Class<Z> getResourceClass();

    int getSize();

    void recycle();
}
