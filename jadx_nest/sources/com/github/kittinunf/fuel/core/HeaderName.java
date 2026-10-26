package com.github.kittinunf.fuel.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: Headers.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/github/kittinunf/fuel/core/HeaderName;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "normalized", "component1", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "fuel"}, k = 1, mv = {1, 4, 0})
public final /* data */ class HeaderName {
    private final String name;
    private final String normalized;

    public static /* synthetic */ HeaderName copy$default(HeaderName headerName, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = headerName.name;
        }
        return headerName.copy(str);
    }

    /* INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final HeaderName copy(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new HeaderName(name);
    }

    public HeaderName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        if (name == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String upperCase = name.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
        this.normalized = upperCase;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.normalized.hashCode();
    }

    public boolean equals(Object other) {
        if (other instanceof HeaderName) {
            return Intrinsics.areEqual(((HeaderName) other).normalized, this.normalized);
        }
        if (other instanceof String) {
            return Intrinsics.areEqual(new HeaderName((String) other).normalized, this.normalized);
        }
        return false;
    }

    public String toString() {
        return this.name;
    }
}
