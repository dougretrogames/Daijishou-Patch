package com.github.kittinunf.fuel.core.extensions;

import com.github.kittinunf.fuel.core.Request;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Authentication.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0001¨\u0006\u0007"}, d2 = {"authenticate", "Lcom/github/kittinunf/fuel/core/Request;", "username", "", "password", "authentication", "Lcom/github/kittinunf/fuel/core/extensions/AuthenticatedRequest;", "fuel"}, k = 2, mv = {1, 4, 0})
public final class AuthenticationKt {
    public static final AuthenticatedRequest authentication(Request authentication) {
        Intrinsics.checkNotNullParameter(authentication, "$this$authentication");
        return new AuthenticatedRequest(authentication);
    }

    @Deprecated(message = "Use authentication() extension", replaceWith = @ReplaceWith(expression = "authentication().basic(username, password)", imports = {}))
    public static final Request authenticate(Request authenticate, String username, String password) {
        Intrinsics.checkNotNullParameter(authenticate, "$this$authenticate");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        return authentication(authenticate).basic(username, password);
    }
}
