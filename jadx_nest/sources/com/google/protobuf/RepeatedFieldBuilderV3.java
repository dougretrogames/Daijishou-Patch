package com.google.protobuf;

import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage.Builder;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class RepeatedFieldBuilderV3<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> extends RepeatedFieldBuilder<MType, BType, IType> {
    public RepeatedFieldBuilderV3(List<MType> messages, boolean isMessagesListMutable, AbstractMessage.BuilderParent parent, boolean isClean) {
        super(messages, isMessagesListMutable, parent, isClean);
    }
}
