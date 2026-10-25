package com.google.protobuf;

/* JADX INFO: loaded from: classes4.dex */
interface MutabilityOracle {
    public static final MutabilityOracle IMMUTABLE = new AnonymousClass1();

    void ensureMutable();

    /* JADX INFO: renamed from: com.google.protobuf.MutabilityOracle$1, reason: invalid class name */
    class AnonymousClass1 implements MutabilityOracle {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.MutabilityOracle
        public void ensureMutable() {
            throw new UnsupportedOperationException();
        }
    }
}
