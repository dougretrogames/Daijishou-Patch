package com.google.gson;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes4.dex */
public abstract class LongSerializationPolicy {
    private static final /* synthetic */ LongSerializationPolicy[] $VALUES;
    public static final LongSerializationPolicy DEFAULT;
    public static final LongSerializationPolicy STRING;

    public abstract JsonElement serialize(Long l);

    private LongSerializationPolicy(String str, int i) {
        super(str, i);
    }

    /* synthetic */ LongSerializationPolicy(String str, int i, AnonymousClass1 anonymousClass1) {
        this(str, i);
    }

    public static LongSerializationPolicy valueOf(String str) {
        return (LongSerializationPolicy) Enum.valueOf(LongSerializationPolicy.class, str);
    }

    public static LongSerializationPolicy[] values() {
        return (LongSerializationPolicy[]) $VALUES.clone();
    }

    /* JADX INFO: renamed from: com.google.gson.LongSerializationPolicy$1, reason: invalid class name */
    final enum AnonymousClass1 extends LongSerializationPolicy {
        AnonymousClass1(String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l) {
            if (l == null) {
                return JsonNull.INSTANCE;
            }
            return new JsonPrimitive(l);
        }
    }

    static {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1("DEFAULT", 0);
        DEFAULT = anonymousClass1;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2("STRING", 1);
        STRING = anonymousClass2;
        $VALUES = new LongSerializationPolicy[]{anonymousClass1, anonymousClass2};
    }

    /* JADX INFO: renamed from: com.google.gson.LongSerializationPolicy$2, reason: invalid class name */
    final enum AnonymousClass2 extends LongSerializationPolicy {
        AnonymousClass2(String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l) {
            if (l == null) {
                return JsonNull.INSTANCE;
            }
            return new JsonPrimitive(l.toString());
        }
    }
}
