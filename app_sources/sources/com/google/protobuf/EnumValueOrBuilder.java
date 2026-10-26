package com.google.protobuf;

import java.util.List;

/* INFO: loaded from: classes4.dex */
public interface EnumValueOrBuilder extends MessageOrBuilder {
    String getName();

    ByteString getNameBytes();

    int getNumber();

    Option getOptions(int index);

    int getOptionsCount();

    List<Option> getOptionsList();

    OptionOrBuilder getOptionsOrBuilder(int index);

    List<? extends OptionOrBuilder> getOptionsOrBuilderList();
}
