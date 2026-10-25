package com.google.protobuf.gradle.internal;

import com.android.build.gradle.AppExtension;
import com.android.build.gradle.BaseExtension;
import com.android.build.gradle.LibraryExtension;
import com.android.build.gradle.TestExtension;
import com.android.build.gradle.TestedExtension;
import com.android.build.gradle.api.BaseVariant;
import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;
import groovy.transform.Generated;
import groovy.transform.Internal;
import org.codehaus.groovy.reflection.ClassInfo;
import org.codehaus.groovy.runtime.GStringImpl;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.codehaus.groovy.runtime.typehandling.ShortTypeHandling;
import org.gradle.api.Action;
import org.gradle.api.Project;

/* JADX INFO: compiled from: ProjectExt.groovy */
/* JADX INFO: loaded from: classes4.dex */
public class ProjectExt implements GroovyObject {
    private static /* synthetic */ ClassInfo $staticClassInfo;
    private static /* synthetic */ ClassInfo $staticClassInfo$;
    public static transient /* synthetic */ boolean __$stMC;
    private transient /* synthetic */ MetaClass metaClass = $getStaticMetaClass();

    private ProjectExt() {
    }

    protected /* synthetic */ MetaClass $getStaticMetaClass() {
        if (getClass() != ProjectExt.class) {
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

    public static void forEachVariant(Project project, Action<? extends BaseVariant> action) {
        BaseExtension baseExtension = (BaseExtension) ScriptBytecodeAdapter.asType(project.getExtensions().getByName("android"), BaseExtension.class);
        project.getLogger().debug(ShortTypeHandling.castToString(new GStringImpl(new Object[]{project, baseExtension}, new String[]{"", " has '", "'"})));
        if (baseExtension instanceof AppExtension) {
            ((AppExtension) ScriptBytecodeAdapter.asType(baseExtension, AppExtension.class)).getApplicationVariants().all(action);
        }
        if (baseExtension instanceof LibraryExtension) {
            ((LibraryExtension) ScriptBytecodeAdapter.asType(baseExtension, LibraryExtension.class)).getLibraryVariants().all(action);
        }
        if (baseExtension instanceof TestExtension) {
            ((TestExtension) ScriptBytecodeAdapter.asType(baseExtension, TestExtension.class)).getApplicationVariants().all(action);
        }
        if (baseExtension instanceof TestedExtension) {
            ((TestedExtension) ScriptBytecodeAdapter.asType(baseExtension, TestedExtension.class)).getTestVariants().all(action);
            ((TestedExtension) ScriptBytecodeAdapter.asType(baseExtension, TestedExtension.class)).getUnitTestVariants().all(action);
        }
    }
}
