package com.prof18.rssparser.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import okhttp3.Call;

/* INFO: compiled from: JvmXmlFetcher.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class JvmXmlFetcher$awaitForInputStream$2$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ Call $this_awaitForInputStream;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    JvmXmlFetcher$awaitForInputStream$2$1(Call call) {
        super(1);
        this.$this_awaitForInputStream = call;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        this.$this_awaitForInputStream.cancel();
    }
}
