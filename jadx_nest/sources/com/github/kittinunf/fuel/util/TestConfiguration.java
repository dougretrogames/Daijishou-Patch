package com.github.kittinunf.fuel.util;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: TestConfiguration.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\r\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/github/kittinunf/fuel/util/TestConfiguration;", "", "timeout", "", "timeoutRead", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getTimeout", "()Ljava/lang/Integer;", "setTimeout", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTimeoutRead", "setTimeoutRead", "coerceTimeout", "coerceTimeoutRead", "component1", "component2", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/github/kittinunf/fuel/util/TestConfiguration;", "equals", "", "other", "hashCode", "toString", "", "fuel"}, k = 1, mv = {1, 4, 0})
public final /* data */ class TestConfiguration {
    private Integer timeout;
    private Integer timeoutRead;

    public TestConfiguration() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ TestConfiguration copy$default(TestConfiguration testConfiguration, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = testConfiguration.timeout;
        }
        if ((i & 2) != 0) {
            num2 = testConfiguration.timeoutRead;
        }
        return testConfiguration.copy(num, num2);
    }

    /* INFO: renamed from: component1, reason: from getter */
    public final Integer getTimeout() {
        return this.timeout;
    }

    /* INFO: renamed from: component2, reason: from getter */
    public final Integer getTimeoutRead() {
        return this.timeoutRead;
    }

    public final TestConfiguration copy(Integer timeout, Integer timeoutRead) {
        return new TestConfiguration(timeout, timeoutRead);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TestConfiguration)) {
            return false;
        }
        TestConfiguration testConfiguration = (TestConfiguration) other;
        return Intrinsics.areEqual(this.timeout, testConfiguration.timeout) && Intrinsics.areEqual(this.timeoutRead, testConfiguration.timeoutRead);
    }

    public int hashCode() {
        Integer num = this.timeout;
        int iHashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.timeoutRead;
        return iHashCode + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "TestConfiguration(timeout=" + this.timeout + ", timeoutRead=" + this.timeoutRead + ")";
    }

    public TestConfiguration(Integer num, Integer num2) {
        this.timeout = num;
        this.timeoutRead = num2;
    }

    /* WARN: Illegal instructions before constructor call */
    public /* synthetic */ TestConfiguration(Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        this(num, num2);
    }

    public final Integer getTimeout() {
        return this.timeout;
    }

    public final void setTimeout(Integer num) {
        this.timeout = num;
    }

    public final Integer getTimeoutRead() {
        return this.timeoutRead;
    }

    public final void setTimeoutRead(Integer num) {
        this.timeoutRead = num;
    }

    public final int coerceTimeout(int timeout) {
        Integer num = this.timeout;
        if (num == null) {
            return timeout;
        }
        int iIntValue = num.intValue();
        if (iIntValue == -1) {
            return Integer.MAX_VALUE;
        }
        return iIntValue;
    }

    public final int coerceTimeoutRead(int timeout) {
        Integer num = this.timeoutRead;
        if (num == null) {
            return timeout;
        }
        int iIntValue = num.intValue();
        if (iIntValue == -1) {
            return Integer.MAX_VALUE;
        }
        return iIntValue;
    }
}
