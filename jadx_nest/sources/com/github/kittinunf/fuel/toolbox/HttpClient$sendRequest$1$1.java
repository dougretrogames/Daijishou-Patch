package com.github.kittinunf.fuel.toolbox;

import java.net.HttpURLConnection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: HttpClient.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "key", "", "values", "invoke"}, k = 3, mv = {1, 4, 0})
final class HttpClient$sendRequest$1$1 extends Lambda implements Function2<String, String, Unit> {
    final /* synthetic */ HttpURLConnection $this_apply;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HttpClient$sendRequest$1$1(HttpURLConnection httpURLConnection) {
        super(2);
        this.$this_apply = httpURLConnection;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
        invoke2(str, str2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String key, String values) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(values, "values");
        this.$this_apply.setRequestProperty(key, values);
    }
}
