package com.google.common.cache;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class RemovalCause {
    public static final RemovalCause EXPLICIT = new AnonymousClass1("EXPLICIT", 0);
    public static final RemovalCause REPLACED = new AnonymousClass2("REPLACED", 1);
    public static final RemovalCause COLLECTED = new AnonymousClass3("COLLECTED", 2);
    public static final RemovalCause EXPIRED = new AnonymousClass4("EXPIRED", 3);
    public static final RemovalCause SIZE = new AnonymousClass5("SIZE", 4);
    private static final /* synthetic */ RemovalCause[] $VALUES = $values();

    abstract boolean wasEvicted();

    private static /* synthetic */ RemovalCause[] $values() {
        return new RemovalCause[]{EXPLICIT, REPLACED, COLLECTED, EXPIRED, SIZE};
    }

    public static RemovalCause valueOf(String name) {
        return (RemovalCause) Enum.valueOf(RemovalCause.class, name);
    }

    public static RemovalCause[] values() {
        return (RemovalCause[]) $VALUES.clone();
    }

    private RemovalCause(String $enum$name, int $enum$ordinal) {
        super($enum$name, $enum$ordinal);
    }

    /* synthetic */ RemovalCause(String str, int i, AnonymousClass1 anonymousClass1) {
        this(str, i);
    }

    /* JADX INFO: renamed from: com.google.common.cache.RemovalCause$1, reason: invalid class name */
    final enum AnonymousClass1 extends RemovalCause {
        @Override // com.google.common.cache.RemovalCause
        boolean wasEvicted() {
            return false;
        }

        AnonymousClass1(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal, null);
        }
    }

    /* JADX INFO: renamed from: com.google.common.cache.RemovalCause$2, reason: invalid class name */
    final enum AnonymousClass2 extends RemovalCause {
        @Override // com.google.common.cache.RemovalCause
        boolean wasEvicted() {
            return false;
        }

        AnonymousClass2(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal, null);
        }
    }

    /* JADX INFO: renamed from: com.google.common.cache.RemovalCause$3, reason: invalid class name */
    final enum AnonymousClass3 extends RemovalCause {
        @Override // com.google.common.cache.RemovalCause
        boolean wasEvicted() {
            return true;
        }

        AnonymousClass3(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal, null);
        }
    }

    /* JADX INFO: renamed from: com.google.common.cache.RemovalCause$4, reason: invalid class name */
    final enum AnonymousClass4 extends RemovalCause {
        @Override // com.google.common.cache.RemovalCause
        boolean wasEvicted() {
            return true;
        }

        AnonymousClass4(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal, null);
        }
    }

    /* JADX INFO: renamed from: com.google.common.cache.RemovalCause$5, reason: invalid class name */
    final enum AnonymousClass5 extends RemovalCause {
        @Override // com.google.common.cache.RemovalCause
        boolean wasEvicted() {
            return true;
        }

        AnonymousClass5(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal, null);
        }
    }
}
