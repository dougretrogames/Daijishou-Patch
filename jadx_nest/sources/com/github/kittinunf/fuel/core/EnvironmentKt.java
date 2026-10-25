package com.github.kittinunf.fuel.core;

import kotlin.Metadata;

/* JADX INFO: compiled from: Environment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0002\u001a\u00020\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0004"}, d2 = {"AndroidEnvironmentClass", "", "createEnvironment", "Lcom/github/kittinunf/fuel/core/Environment;", "fuel"}, k = 2, mv = {1, 4, 0})
public final class EnvironmentKt {
    public static final String AndroidEnvironmentClass = "com.github.kittinunf.fuel.android.util.AndroidEnvironment";

    public static final Environment createEnvironment() throws IllegalAccessException, InstantiationException {
        try {
            Object objNewInstance = Class.forName(AndroidEnvironmentClass).newInstance();
            if (objNewInstance != null) {
                return (Environment) objNewInstance;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.github.kittinunf.fuel.core.Environment");
        } catch (ClassNotFoundException unused) {
            return new DefaultEnvironment();
        }
    }
}
