package com.magneticchen.daijishou.utils;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: PegasusAmStartArgumentsPatchers.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<no name provided>", "Lkotlin/Pair;", "", "", "args", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class PegasusAmStartArgumentsPatchers$patchers$2 extends Lambda<Pair<? extends String, ? extends Boolean>> implements Function1<String, Pair<? extends String, ? extends Boolean>> {
    public static final PegasusAmStartArgumentsPatchers$patchers$2 INSTANCE = new PegasusAmStartArgumentsPatchers$patchers$2();

    PegasusAmStartArgumentsPatchers$patchers$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Pair<String, Boolean> invoke(String str) {
        Intrinsics.checkNotNull(str);
        return new Pair<>(str, true);
    }
}
