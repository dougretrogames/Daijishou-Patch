package com.magneticchen.daijishou.daijishou_recycler_view;

import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.RequestBuilder;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: DaijishouRecyclerView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00072\b\u0010\b\u001a\u0004\b\u00028\u0000H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b9¨\u0006\n"}, d2 = {"com/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter$addGlidePreloaderBuilderCreator$preloadModelProvider$1", "Lcom/bumptech/glide/ListPreloader$PreloadModelProvider;", "getPreloadItems", "", "position", "", "getPreloadRequestBuilder", "Lcom/bumptech/glide/RequestBuilder;", "item", "(Ljava/lang/Object;)Lcom/bumptech/glide/RequestBuilder;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouRecyclerView$Adapter$addGlidePreloaderBuilderCreator$preloadModelProvider$1<T> implements ListPreloader.PreloadModelProvider<T> {
    final /* synthetic */ Function1<T, RequestBuilder<?>> $builderCreator;
    final /* synthetic */ DaijishouRecyclerView.Adapter<T> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    DaijishouRecyclerView$Adapter$addGlidePreloaderBuilderCreator$preloadModelProvider$1(DaijishouRecyclerView.Adapter<T> adapter, Function1<? super T, ? extends RequestBuilder<?>> function1) {
        this.this$0 = adapter;
        this.$builderCreator = (Function1<T, RequestBuilder<?>>) (Function1) function1;
    }

    @Override // com.bumptech.glide.ListPreloader.PreloadModelProvider
    public List<T> getPreloadItems(int position) {
        List<T> listSingletonList = Collections.singletonList(this.this$0.getItemList().get(position));
        Intrinsics.checkNotNullExpressionValue(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    @Override // com.bumptech.glide.ListPreloader.PreloadModelProvider
    public RequestBuilder<?> getPreloadRequestBuilder(T item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return this.$builderCreator.invoke(item);
    }
}
