package com.magneticchen.daijishou.utils;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PegasusAmStartArgumentsPatchers.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Ra\u0010\u0003\u001aR\u0012\u0004\u0012\u00020\u0005\u0012\u001e\u0012\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u00070\u00060\u0004j(\u0012\u0004\u0012\u00020\u0005\u0012\u001e\u0012\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u00070\u0006`\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/magneticchen/daijishou/utils/PegasusAmStartArgumentsPatchers;", "", "()V", "patchers", "Ljava/util/HashMap;", "", "Lkotlin/Function1;", "Lkotlin/Pair;", "", "Lkotlin/collections/HashMap;", "getPatchers", "()Ljava/util/HashMap;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PegasusAmStartArgumentsPatchers {
    public static final PegasusAmStartArgumentsPatchers INSTANCE = new PegasusAmStartArgumentsPatchers();
    private static final HashMap<String, Function1<String, Pair<String, Boolean>>> patchers = MapsKt.hashMapOf(TuplesKt.to("com.dsemu.drastic", new Function1<String, Pair<? extends String, ? extends Boolean>>() { // from class: com.magneticchen.daijishou.utils.PegasusAmStartArgumentsPatchers$patchers$1
        @Override // kotlin.jvm.functions.Function1
        public final Pair<String, Boolean> invoke(String str) {
            return new Pair<>("-n com.dsemu.drastic/.DraSticActivity\n-d {file.path}\n--activity-clear-task\n--activity-clear-top", false);
        }
    }), TuplesKt.to("com.retroarch", new Function1<String, Pair<? extends String, ? extends Boolean>>() { // from class: com.magneticchen.daijishou.utils.PegasusAmStartArgumentsPatchers$patchers$2
        @Override // kotlin.jvm.functions.Function1
        public final Pair<String, Boolean> invoke(String str) {
            Intrinsics.checkNotNull(str);
            return new Pair<>(str, true);
        }
    }), TuplesKt.to("com.retroarch.aarch64", new Function1<String, Pair<? extends String, ? extends Boolean>>() { // from class: com.magneticchen.daijishou.utils.PegasusAmStartArgumentsPatchers$patchers$3
        @Override // kotlin.jvm.functions.Function1
        public final Pair<String, Boolean> invoke(String str) {
            Intrinsics.checkNotNull(str);
            return new Pair<>(str, true);
        }
    }));

    private PegasusAmStartArgumentsPatchers() {
    }

    public final HashMap<String, Function1<String, Pair<String, Boolean>>> getPatchers() {
        return patchers;
    }
}
