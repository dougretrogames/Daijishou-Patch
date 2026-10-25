package com.magneticchen.daijishou.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: DayChangedBroadcastReceiver.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/text/SimpleDateFormat;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class DayChangedBroadcastReceiver$dateFormat$2 extends Lambda<SimpleDateFormat> implements Function0<SimpleDateFormat> {
    public static final DayChangedBroadcastReceiver$dateFormat$2 INSTANCE = new DayChangedBroadcastReceiver$dateFormat$2();

    DayChangedBroadcastReceiver$dateFormat$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final SimpleDateFormat invoke() {
        return new SimpleDateFormat("yyMMdd", Locale.getDefault());
    }
}
