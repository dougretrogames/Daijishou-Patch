package com.magneticchen.daijishou.utils;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PegasusAmStartArgumentsPatchers.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Ra\u0010\u0003\u001aR\u0012\u0004\u0012\u00020\u0005\u0012\u001e\u0012\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u00070\u00060\u0004j(\u0012\u0004\u0012\u00020\u0005\u0012\u001e\u0012\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u00070\u0006`\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/magneticchen/daijishou/utils/PegasusAmStartArgumentsPatchers;", "", "()V", "patchers", "Ljava/util/HashMap;", "", "Lkotlin/Function1;", "Lkotlin/Pair;", "", "Lkotlin/collections/HashMap;", "getPatchers", "()Ljava/util/HashMap;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PegasusAmStartArgumentsPatchers {
    public static final PegasusAmStartArgumentsPatchers INSTANCE = new PegasusAmStartArgumentsPatchers();
    private static final HashMap<String, Function1<String, Pair<String, Boolean>>> patchers = MapsKt.<String, Function1<String, Pair<String, Boolean>>>hashMapOf(TuplesKt.to("com.dsemu.drastic", (Function1<String, Pair<String, Boolean>>) (Function1) PegasusAmStartArgumentsPatchers$patchers$1.INSTANCE), TuplesKt.to("com.retroarch", (Function1<String, Pair<String, Boolean>>) (Function1) PegasusAmStartArgumentsPatchers$patchers$2.INSTANCE), TuplesKt.to("com.retroarch.aarch64", (Function1<String, Pair<String, Boolean>>) (Function1) PegasusAmStartArgumentsPatchers$patchers$3.INSTANCE));

    private PegasusAmStartArgumentsPatchers() {
    }

    public final HashMap<String, Function1<String, Pair<String, Boolean>>> getPatchers() {
        return patchers;
    }
}
