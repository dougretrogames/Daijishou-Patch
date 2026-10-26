package com.google.common.reflect;

import com.google.common.base.Function;
import java.lang.reflect.Type;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class Types$ParameterizedTypeImpl$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ Types.JavaVersion f$0;

    public /* synthetic */ Types$ParameterizedTypeImpl$$ExternalSyntheticLambda0(Types.JavaVersion javaVersion) {
        this.f$0 = javaVersion;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        return this.f$0.typeName((Type) obj);
    }
}
