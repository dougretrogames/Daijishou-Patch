package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

/* INFO: compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class zacu implements RemoteCall {
    public final /* synthetic */ BiConsumer zaa;

    public /* synthetic */ zacu(BiConsumer biConsumer) {
        this.zaa = biConsumer;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        this.zaa.accept((Api.AnyClient) obj, (TaskCompletionSource) obj2);
    }
}
