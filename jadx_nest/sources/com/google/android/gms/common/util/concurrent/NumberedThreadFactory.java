package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.collections4.CollectionUtils;

/* INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* INFO: loaded from: classes3.dex */
public class NumberedThreadFactory implements ThreadFactory {
    private final String zza;
    private final AtomicInteger zzb = new AtomicInteger();
    private final ThreadFactory zzc = Executors.defaultThreadFactory();

    public NumberedThreadFactory(String str) {
        Preconditions.checkNotNull(str, "Name must not be null");
        this.zza = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.zzc.newThread(new zza(runnable, 0));
        threadNewThread.setName(this.zza + CollectionUtils.DEFAULT_TOSTRING_PREFIX + this.zzb.getAndIncrement() + CollectionUtils.DEFAULT_TOSTRING_SUFFIX);
        return threadNewThread;
    }
}
