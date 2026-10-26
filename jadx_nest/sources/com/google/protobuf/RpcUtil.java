package com.google.protobuf;

/* INFO: loaded from: classes4.dex */
public final class RpcUtil {
    /* WARN: Multi-variable type inference failed */
    public static <Type extends Message> RpcCallback<Type> specializeCallback(final RpcCallback<Message> originalCallback) {
        return originalCallback;
    }

    private RpcUtil() {
    }

    /* INFO: renamed from: com.google.protobuf.RpcUtil$1, reason: invalid class name */
    class AnonymousClass1 implements RpcCallback<Message> {
        final /* synthetic */ Message val$defaultInstance;
        final /* synthetic */ RpcCallback val$originalCallback;
        final /* synthetic */ Class val$originalClass;

        AnonymousClass1(final Class val$originalClass, final Message val$defaultInstance, final RpcCallback val$originalCallback) {
            this.val$originalClass = val$originalClass;
            this.val$defaultInstance = val$defaultInstance;
            this.val$originalCallback = val$originalCallback;
        }

        @Override // com.google.protobuf.RpcCallback
        public void run(final Message parameter) {
            Message messageCopyAsType;
            try {
                messageCopyAsType = (Message) this.val$originalClass.cast(parameter);
            } catch (ClassCastException unused) {
                messageCopyAsType = RpcUtil.copyAsType(this.val$defaultInstance, parameter);
            }
            this.val$originalCallback.run(messageCopyAsType);
        }
    }

    public static <Type extends Message> RpcCallback<Message> generalizeCallback(final RpcCallback<Type> originalCallback, final Class<Type> originalClass, final Type defaultInstance) {
        return new AnonymousClass1(originalClass, defaultInstance, originalCallback);
    }

    /* INFO: Access modifiers changed from: private */
    public static <Type extends Message> Type copyAsType(Type type, Message message) {
        return (Type) type.newBuilderForType().mergeFrom(message).build();
    }

    /* INFO: Add missing generic type declarations: [ParameterType] */
    /* INFO: renamed from: com.google.protobuf.RpcUtil$2, reason: invalid class name */
    class AnonymousClass2<ParameterType> implements RpcCallback<ParameterType> {
        private boolean alreadyCalled = false;
        final /* synthetic */ RpcCallback val$originalCallback;

        AnonymousClass2(final RpcCallback val$originalCallback) {
            this.val$originalCallback = val$originalCallback;
        }

        @Override // com.google.protobuf.RpcCallback
        public void run(final ParameterType parameter) {
            synchronized (this) {
                if (this.alreadyCalled) {
                    throw new AlreadyCalledException();
                }
                this.alreadyCalled = true;
            }
            this.val$originalCallback.run(parameter);
        }
    }

    public static <ParameterType> RpcCallback<ParameterType> newOneTimeCallback(final RpcCallback<ParameterType> originalCallback) {
        return new AnonymousClass2(originalCallback);
    }

    public static final class AlreadyCalledException extends RuntimeException {
        private static final long serialVersionUID = 5469741279507848266L;

        public AlreadyCalledException() {
            super("This RpcCallback was already called and cannot be called multiple times.");
        }
    }
}
