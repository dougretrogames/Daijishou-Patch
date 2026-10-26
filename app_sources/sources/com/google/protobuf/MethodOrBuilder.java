package com.google.protobuf;

import java.util.List;

/* INFO: loaded from: classes4.dex */
public interface MethodOrBuilder extends MessageOrBuilder {
    String getName();

    ByteString getNameBytes();

    Option getOptions(int index);

    int getOptionsCount();

    List<Option> getOptionsList();

    OptionOrBuilder getOptionsOrBuilder(int index);

    List<? extends OptionOrBuilder> getOptionsOrBuilderList();

    boolean getRequestStreaming();

    String getRequestTypeUrl();

    ByteString getRequestTypeUrlBytes();

    boolean getResponseStreaming();

    String getResponseTypeUrl();

    ByteString getResponseTypeUrlBytes();

    Syntax getSyntax();

    int getSyntaxValue();
}
