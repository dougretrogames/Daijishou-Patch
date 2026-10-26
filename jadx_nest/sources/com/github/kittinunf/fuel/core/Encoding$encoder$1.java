package com.github.kittinunf.fuel.core;

import com.github.kittinunf.fuel.core.requests.DefaultRequest;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: Encoding.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\"\u0010\u0006\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\t0\b\u0018\u00010\u0007j\u0004\u0018\u0001`\nH\n¢\u0006\u0002\b\u000b"}, d2 = {"<anonymous>", "Lcom/github/kittinunf/fuel/core/requests/DefaultRequest;", "method", "Lcom/github/kittinunf/fuel/core/Method;", "path", "", "parameters", "", "Lkotlin/Pair;", "", "Lcom/github/kittinunf/fuel/core/Parameters;", "invoke"}, k = 3, mv = {1, 4, 0})
final class Encoding$encoder$1 extends Lambda implements Function3<Method, String, List<? extends Pair<? extends String, ? extends Object>>, DefaultRequest> {
    final /* synthetic */ Encoding this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    Encoding$encoder$1(Encoding encoding) {
        super(3);
        this.this$0 = encoding;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ DefaultRequest invoke(Method method, String str, List<? extends Pair<? extends String, ? extends Object>> list) {
        return invoke2(method, str, (List<? extends Pair<String, ? extends Object>>) list);
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final DefaultRequest invoke2(Method method, String path, List<? extends Pair<String, ? extends Object>> list) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(path, "path");
        URL urlCreateUrl = this.this$0.createUrl(path);
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return new DefaultRequest(method, urlCreateUrl, Headers.INSTANCE.from(this.this$0.defaultHeaders), list, null, null, null, 112, null);
    }
}
