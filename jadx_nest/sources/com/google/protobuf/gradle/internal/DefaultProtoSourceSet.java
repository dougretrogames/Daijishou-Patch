package com.google.protobuf.gradle.internal;

import com.google.protobuf.gradle.tasks.ProtoSourceSet;
import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;
import groovy.transform.Generated;
import groovy.transform.Internal;
import org.codehaus.groovy.reflection.ClassInfo;
import org.codehaus.groovy.runtime.GStringImpl;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.codehaus.groovy.runtime.StringGroovyMethods;
import org.codehaus.groovy.runtime.typehandling.ShortTypeHandling;
import org.gradle.api.file.ConfigurableFileCollection;
import org.gradle.api.file.SourceDirectorySet;
import org.gradle.api.model.ObjectFactory;

/* JADX INFO: compiled from: DefaultProtoSourceSet.groovy */
/* JADX INFO: loaded from: classes4.dex */
public class DefaultProtoSourceSet implements ProtoSourceSet, GroovyObject {
    private static /* synthetic */ ClassInfo $staticClassInfo;
    private static /* synthetic */ ClassInfo $staticClassInfo$;
    public static transient /* synthetic */ boolean __$stMC;
    private final ConfigurableFileCollection includeProtoDirs;
    private transient /* synthetic */ MetaClass metaClass = $getStaticMetaClass();
    private final String name;
    private final ConfigurableFileCollection output;

    /* JADX INFO: renamed from: proto, reason: collision with root package name */
    private final SourceDirectorySet f64proto;

    protected /* synthetic */ MetaClass $getStaticMetaClass() {
        if (getClass() != DefaultProtoSourceSet.class) {
            return ScriptBytecodeAdapter.initMetaClass(this);
        }
        ClassInfo classInfo = $staticClassInfo;
        if (classInfo == null) {
            classInfo = ClassInfo.getClassInfo(getClass());
            $staticClassInfo = classInfo;
        }
        return classInfo.getMetaClass();
    }

    @Generated
    @Internal
    public /* synthetic */ MetaClass getMetaClass() {
        MetaClass metaClass = this.metaClass;
        if (metaClass != null) {
            return metaClass;
        }
        MetaClass metaClass$getStaticMetaClass = $getStaticMetaClass();
        this.metaClass = metaClass$getStaticMetaClass;
        return metaClass$getStaticMetaClass;
    }

    @Generated
    @Internal
    public /* synthetic */ Object getProperty(String str) {
        return getMetaClass().getProperty(this, str);
    }

    @Generated
    @Internal
    public /* synthetic */ Object invokeMethod(String str, Object obj) {
        return getMetaClass().invokeMethod(this, str, obj);
    }

    @Generated
    @Internal
    public /* synthetic */ void setMetaClass(MetaClass metaClass) {
        this.metaClass = metaClass;
    }

    @Generated
    @Internal
    public /* synthetic */ void setProperty(String str, Object obj) {
        getMetaClass().setProperty(this, str, obj);
    }

    public DefaultProtoSourceSet(String str, ObjectFactory objectFactory) {
        this.name = str;
        this.f64proto = objectFactory.sourceDirectorySet("proto", ShortTypeHandling.castToString(new GStringImpl(new Object[]{StringGroovyMethods.capitalize(str)}, new String[]{"", " Proto Source"})));
        this.includeProtoDirs = objectFactory.fileCollection();
        this.output = objectFactory.fileCollection();
    }

    @Override // com.google.protobuf.gradle.tasks.ProtoSourceSet
    public String getName() {
        return this.name;
    }

    @Override // com.google.protobuf.gradle.tasks.ProtoSourceSet
    public SourceDirectorySet getProto() {
        return this.f64proto;
    }

    @Override // com.google.protobuf.gradle.tasks.ProtoSourceSet
    public ConfigurableFileCollection getIncludeProtoDirs() {
        return this.includeProtoDirs;
    }

    @Override // com.google.protobuf.gradle.tasks.ProtoSourceSet
    public ConfigurableFileCollection getOutput() {
        return this.output;
    }

    @Override // com.google.protobuf.gradle.tasks.ProtoSourceSet
    public void includesFrom(ProtoSourceSet protoSourceSet) {
        this.includeProtoDirs.from(new Object[]{protoSourceSet.getProto().getSourceDirectories()});
        this.includeProtoDirs.from(new Object[]{protoSourceSet.getIncludeProtoDirs()});
    }

    @Override // com.google.protobuf.gradle.tasks.ProtoSourceSet
    public void extendsFrom(ProtoSourceSet protoSourceSet) {
        this.f64proto.source(protoSourceSet.getProto());
        this.includeProtoDirs.from(new Object[]{protoSourceSet.getIncludeProtoDirs()});
    }
}
