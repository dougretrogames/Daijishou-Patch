package com.github.kittinunf.fuel.core.requests;

import java.io.ByteArrayInputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: DefaultBody.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/io/ByteArrayInputStream;", "invoke"}, k = 3, mv = {1, 4, 0})
final class DefaultBody$Companion$EMPTY_STREAM$1 extends Lambda implements Function0<ByteArrayInputStream> {
    public static final DefaultBody$Companion$EMPTY_STREAM$1 INSTANCE = new DefaultBody$Companion$EMPTY_STREAM$1();

    DefaultBody$Companion$EMPTY_STREAM$1() {
        super(0);
    }

    /* WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ByteArrayInputStream invoke() {
        return new ByteArrayInputStream(new byte[0]);
    }
}
