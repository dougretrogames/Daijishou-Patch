package com.google.protobuf.gradle;

import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;
import groovy.transform.Generated;
import groovy.transform.Internal;
import org.codehaus.groovy.reflection.ClassInfo;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.codehaus.groovy.runtime.typehandling.ShortTypeHandling;
import org.gradle.api.Named;
import org.gradle.api.file.FileCollection;

/* JADX INFO: compiled from: ExecutableLocator.groovy */
/* JADX INFO: loaded from: classes4.dex */
public class ExecutableLocator implements Named, GroovyObject {
    private static /* synthetic */ ClassInfo $staticClassInfo;
    private static /* synthetic */ ClassInfo $staticClassInfo$;
    public static transient /* synthetic */ boolean __$stMC;
    private String artifact;
    private FileCollection artifactFiles;
    private transient /* synthetic */ MetaClass metaClass = $getStaticMetaClass();
    private final String name;
    private String path;
    private String simplifiedArtifactName;

    protected /* synthetic */ MetaClass $getStaticMetaClass() {
        if (getClass() != ExecutableLocator.class) {
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

    public ExecutableLocator(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public void setArtifact(String str) {
        this.artifact = str;
        this.path = ShortTypeHandling.castToString((Object) null);
    }

    public void setPath(String str) {
        this.path = str;
        this.artifact = ShortTypeHandling.castToString((Object) null);
    }

    public String getArtifact() {
        return this.artifact;
    }

    public String getPath() {
        return this.path;
    }

    FileCollection getArtifactFiles() {
        Preconditions.checkState(this.path == null, "Not artifact based");
        Preconditions.checkState(this.artifactFiles != null, "Not yet created resolved");
        return this.artifactFiles;
    }

    String getSimplifiedArtifactName() {
        Preconditions.checkState(this.path == null, "Not artifact based");
        Preconditions.checkState(this.simplifiedArtifactName != null, "Not yet resolved");
        return this.simplifiedArtifactName;
    }

    void resolve(FileCollection fileCollection, String str) {
        this.artifactFiles = fileCollection;
        this.simplifiedArtifactName = str;
    }
}
