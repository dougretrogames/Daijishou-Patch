package com.google.protobuf.gradle;

import com.google.gradle.osdetector.OsDetector;
import groovy.lang.Closure;
import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;
import groovy.transform.Generated;
import groovy.transform.Internal;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.codehaus.groovy.reflection.ClassInfo;
import org.codehaus.groovy.runtime.DefaultGroovyMethods;
import org.codehaus.groovy.runtime.GStringImpl;
import org.codehaus.groovy.runtime.GeneratedClosure;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.codehaus.groovy.runtime.StringGroovyMethods;
import org.codehaus.groovy.runtime.typehandling.DefaultTypeTransformation;
import org.codehaus.groovy.runtime.typehandling.ShortTypeHandling;
import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.Project;
import org.gradle.api.artifacts.Configuration;

/* INFO: compiled from: ToolsLocator.groovy */
/* INFO: loaded from: classes4.dex */
public class ToolsLocator implements GroovyObject {
    private static /* synthetic */ ClassInfo $staticClassInfo;
    private static /* synthetic */ ClassInfo $staticClassInfo$;
    public static transient /* synthetic */ boolean __$stMC;
    private final NamedDomainObjectContainer<ExecutableLocator> plugins;
    private transient /* synthetic */ MetaClass metaClass = $getStaticMetaClass();
    private final ExecutableLocator protoc = new ExecutableLocator("protoc");

    protected /* synthetic */ MetaClass $getStaticMetaClass() {
        if (getClass() != ToolsLocator.class) {
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
    public final NamedDomainObjectContainer<ExecutableLocator> getPlugins() {
        return this.plugins;
    }

    @Generated
    @Internal
    public /* synthetic */ Object getProperty(String str) {
        return getMetaClass().getProperty(this, str);
    }

    @Generated
    public final ExecutableLocator getProtoc() {
        return this.protoc;
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

    public static List<String> artifactParts(String str) {
        List list = StringGroovyMethods.tokenize(str, "@");
        Object at = DefaultGroovyMethods.getAt(list, 0);
        Object at2 = DefaultGroovyMethods.getAt(list, 1);
        String strCastToString = ShortTypeHandling.castToString(at);
        String strCastToString2 = ShortTypeHandling.castToString(at2);
        if (strCastToString2 == null && str.endsWith("@")) {
            strCastToString2 = "";
        }
        List list2 = StringGroovyMethods.tokenize(strCastToString, CollectionUtils.COLON);
        return ScriptBytecodeAdapter.createList(new Object[]{ShortTypeHandling.castToString(DefaultGroovyMethods.getAt(list2, 0)), ShortTypeHandling.castToString(DefaultGroovyMethods.getAt(list2, 1)), ShortTypeHandling.castToString(DefaultGroovyMethods.getAt(list2, 2)), ShortTypeHandling.castToString(DefaultGroovyMethods.getAt(list2, 3)), strCastToString2});
    }

    public ToolsLocator(Project project) {
        this.plugins = project.container(ExecutableLocator.class);
    }

    public void resolve(Project project) {
        if (this.protoc.getArtifact() != null) {
            resolveLocator(project, this.protoc);
        } else if (this.protoc.getPath() == null) {
            this.protoc.setPath("protoc");
        }
        Iterator it = (Iterator) ScriptBytecodeAdapter.castToType(ScriptBytecodeAdapter.invokeMethod0(ToolsLocator.class, this.plugins, "iterator"), Iterator.class);
        while (it.hasNext()) {
            ExecutableLocator executableLocator = (ExecutableLocator) ScriptBytecodeAdapter.castToType(it.next(), ExecutableLocator.class);
            if (executableLocator.getArtifact() != null) {
                resolveLocator(project, executableLocator);
            } else if (executableLocator.getPath() == null) {
                executableLocator.setPath(ShortTypeHandling.castToString(new GStringImpl(new Object[]{executableLocator.getName()}, new String[]{"protoc-gen-", ""})));
            }
        }
    }

    /* INFO: compiled from: ToolsLocator.groovy */
    public final class _resolveLocator_closure1 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;

        public _resolveLocator_closure1(Object obj, Object obj2) {
            super(obj, obj2);
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _resolveLocator_closure1.class) {
                return ScriptBytecodeAdapter.initMetaClass(this);
            }
            ClassInfo classInfo = $staticClassInfo;
            if (classInfo == null) {
                classInfo = ClassInfo.getClassInfo(getClass());
                $staticClassInfo = classInfo;
            }
            return classInfo.getMetaClass();
        }

        public Object call(Configuration configuration) {
            return doCall(configuration);
        }

        public Object doCall(Configuration configuration) {
            configuration.setVisible(false);
            configuration.setTransitive(false);
            return false;
        }
    }

    private void resolveLocator(Project project, ExecutableLocator executableLocator) {
        Configuration configuration = (Configuration) ScriptBytecodeAdapter.castToType(project.getConfigurations().create(ShortTypeHandling.castToString(new GStringImpl(new Object[]{executableLocator.getName()}, new String[]{"protobufToolsLocator_", ""})), new _resolveLocator_closure1(this, this)), Configuration.class);
        OsDetector osDetector = (OsDetector) ScriptBytecodeAdapter.asType(project.getExtensions().getByName("osdetector"), OsDetector.class);
        List<String> listArtifactParts = artifactParts(executableLocator.getArtifact());
        Object at = DefaultGroovyMethods.getAt(listArtifactParts, 0);
        Object at2 = DefaultGroovyMethods.getAt(listArtifactParts, 1);
        Object at3 = DefaultGroovyMethods.getAt(listArtifactParts, 2);
        Object at4 = DefaultGroovyMethods.getAt(listArtifactParts, 3);
        Object at5 = DefaultGroovyMethods.getAt(listArtifactParts, 4);
        String strCastToString = ShortTypeHandling.castToString(at);
        String strCastToString2 = ShortTypeHandling.castToString(at2);
        String strCastToString3 = ShortTypeHandling.castToString(at3);
        String strCastToString4 = ShortTypeHandling.castToString(at4);
        String strCastToString5 = ShortTypeHandling.castToString(at5);
        if (!DefaultTypeTransformation.booleanUnbox(strCastToString4)) {
            strCastToString4 = osDetector.getClassifier();
        }
        String str = strCastToString4;
        if (!DefaultTypeTransformation.booleanUnbox(strCastToString5)) {
            strCastToString5 = "exe";
        }
        project.getDependencies().add(configuration.getName(), (LinkedHashMap) ScriptBytecodeAdapter.castToType(ScriptBytecodeAdapter.createMap(new Object[]{"group", strCastToString, "name", strCastToString2, "version", strCastToString3, "classifier", str, "ext", strCastToString5}), LinkedHashMap.class));
        executableLocator.resolve(configuration, new GStringImpl(new Object[]{strCastToString, strCastToString2, strCastToString3}, new String[]{"", CollectionUtils.COLON, CollectionUtils.COLON, ""}).toString());
    }
}
