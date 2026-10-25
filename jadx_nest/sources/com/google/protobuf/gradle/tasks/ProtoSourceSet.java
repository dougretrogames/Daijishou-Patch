package com.google.protobuf.gradle.tasks;

import org.gradle.api.file.ConfigurableFileCollection;
import org.gradle.api.file.SourceDirectorySet;

/* JADX INFO: compiled from: ProtoSourceSet.groovy */
/* JADX INFO: loaded from: classes4.dex */
public interface ProtoSourceSet {
    void extendsFrom(ProtoSourceSet protoSourceSet);

    ConfigurableFileCollection getIncludeProtoDirs();

    String getName();

    ConfigurableFileCollection getOutput();

    SourceDirectorySet getProto();

    void includesFrom(ProtoSourceSet protoSourceSet);
}
