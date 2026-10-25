package com.google.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public abstract class GeneratedMessageV3 extends GeneratedMessage {
    private static final long serialVersionUID = 1;

    protected GeneratedMessageV3() {
    }

    protected GeneratedMessageV3(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    @Deprecated
    public static abstract class ExtendableBuilder<MessageT extends GeneratedMessage.ExtendableMessage<MessageT>, BuilderT extends ExtendableBuilder<MessageT, BuilderT>> extends GeneratedMessage.ExtendableBuilder<MessageT, BuilderT> implements GeneratedMessage.ExtendableMessageOrBuilder<MessageT> {
        protected ExtendableBuilder() {
        }

        protected ExtendableBuilder(AbstractMessage.BuilderParent parent) {
            super(parent);
        }

        public <T> BuilderT setExtension(final GeneratedMessage.GeneratedExtension<MessageT, T> extension, final T value) {
            return setExtension((ExtensionLite) extension, (Object) value);
        }

        public <T> BuilderT setExtension(final GeneratedMessage.GeneratedExtension<MessageT, List<T>> extension, final int index, final T value) {
            return setExtension((ExtensionLite) extension, index, (Object) value);
        }

        public <T> BuilderT addExtension(final GeneratedMessage.GeneratedExtension<MessageT, List<T>> extension, final T value) {
            return addExtension((ExtensionLite) extension, (Object) value);
        }

        public <T> BuilderT clearExtension(final GeneratedMessage.GeneratedExtension<MessageT, T> extension) {
            return clearExtension((ExtensionLite) extension);
        }
    }
}
