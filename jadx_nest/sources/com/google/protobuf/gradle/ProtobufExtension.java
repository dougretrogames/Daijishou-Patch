package com.google.protobuf.gradle;

import com.google.protobuf.gradle.internal.DefaultProtoSourceSet;
import com.google.protobuf.gradle.tasks.ProtoSourceSet;
import groovy.lang.Closure;
import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;
import groovy.lang.Reference;
import groovy.transform.Generated;
import groovy.transform.Internal;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import org.codehaus.groovy.reflection.ClassInfo;
import org.codehaus.groovy.runtime.BytecodeInterface8;
import org.codehaus.groovy.runtime.DefaultGroovyMethods;
import org.codehaus.groovy.runtime.GStringImpl;
import org.codehaus.groovy.runtime.GeneratedClosure;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.codehaus.groovy.runtime.callsite.CallSite;
import org.codehaus.groovy.runtime.callsite.CallSiteArray;
import org.codehaus.groovy.runtime.typehandling.DefaultTypeTransformation;
import org.codehaus.groovy.runtime.typehandling.ShortTypeHandling;
import org.gradle.api.Action;
import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.NamedDomainObjectFactory;
import org.gradle.api.Project;
import org.gradle.api.Transformer;
import org.gradle.api.file.Directory;
import org.gradle.api.provider.Property;
import org.gradle.api.provider.Provider;
import org.gradle.api.tasks.TaskCollection;

/* JADX INFO: compiled from: ProtobufExtension.groovy */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ProtobufExtension implements GroovyObject {
    private static /* synthetic */ ClassInfo $staticClassInfo;
    private static /* synthetic */ ClassInfo $staticClassInfo$;
    public static transient /* synthetic */ boolean __$stMC;
    final Provider<String> defaultGeneratedFilesBaseDir;
    private transient /* synthetic */ MetaClass metaClass;
    private final Project project;
    private final NamedDomainObjectContainer<ProtoSourceSet> sourceSets;
    private final ArrayList<Action<GenerateProtoTaskCollection>> taskConfigActions;
    private final GenerateProtoTaskCollection tasks;
    private final ToolsLocator tools;

    protected /* synthetic */ MetaClass $getStaticMetaClass() {
        if (getClass() != ProtobufExtension.class) {
            return ScriptBytecodeAdapter.initMetaClass(this);
        }
        ClassInfo classInfo = $staticClassInfo;
        if (classInfo == null) {
            classInfo = ClassInfo.getClassInfo(getClass());
            $staticClassInfo = classInfo;
        }
        return classInfo.getMetaClass();
    }

    abstract Property<String> getGeneratedFilesBaseDirProperty();

    @Generated
    @Internal
    public MetaClass getMetaClass() {
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
    public Object getProperty(String str) {
        return getMetaClass().getProperty(this, str);
    }

    @Generated
    @Internal
    public Object invokeMethod(String str, Object obj) {
        return getMetaClass().invokeMethod(this, str, obj);
    }

    @Generated
    @Internal
    public void setMetaClass(MetaClass metaClass) {
        this.metaClass = metaClass;
    }

    @Generated
    @Internal
    public void setProperty(String str, Object obj) {
        getMetaClass().setProperty(this, str, obj);
    }

    public /* synthetic */ Object this$dist$get$1(String str) {
        return ScriptBytecodeAdapter.getGroovyObjectProperty(ProtobufExtension.class, this, ShortTypeHandling.castToString(new GStringImpl(new Object[]{str}, new String[]{"", ""})));
    }

    public /* synthetic */ Object this$dist$invoke$1(String str, Object obj) {
        return ScriptBytecodeAdapter.invokeMethodOnCurrentN(ProtobufExtension.class, this, ShortTypeHandling.castToString(new GStringImpl(new Object[]{str}, new String[]{"", ""})), ScriptBytecodeAdapter.despreadList(new Object[0], new Object[]{obj}, new int[]{0}));
    }

    public /* synthetic */ void this$dist$set$1(String str, Object obj) {
        ScriptBytecodeAdapter.setGroovyObjectProperty(obj, ProtobufExtension.class, this, ShortTypeHandling.castToString(new GStringImpl(new Object[]{str}, new String[]{"", ""})));
    }

    public ProtobufExtension(Project project) {
        Reference reference = new Reference(project);
        this.metaClass = $getStaticMetaClass();
        this.project = (Project) reference.get();
        this.tasks = new GenerateProtoTaskCollection((Project) reference.get());
        this.tools = new ToolsLocator((Project) reference.get());
        this.taskConfigActions = new ArrayList<>();
        Provider<String> map = ((Project) reference.get()).getLayout().getBuildDirectory().dir("generated/source/proto").map((Transformer) ScriptBytecodeAdapter.castToType(new _closure1(this, this), Transformer.class));
        this.defaultGeneratedFilesBaseDir = map;
        getGeneratedFilesBaseDirProperty().convention(map);
        this.sourceSets = ((Project) reference.get()).getObjects().domainObjectContainer(ProtoSourceSet.class, (NamedDomainObjectFactory) ScriptBytecodeAdapter.castToType(new _closure2(this, this, reference), NamedDomainObjectFactory.class));
    }

    /* JADX INFO: compiled from: ProtobufExtension.groovy */
    public final class _closure1 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;

        public _closure1(Object obj, Object obj2) {
            super(obj, obj2);
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _closure1.class) {
                return ScriptBytecodeAdapter.initMetaClass(this);
            }
            ClassInfo classInfo = $staticClassInfo;
            if (classInfo == null) {
                classInfo = ClassInfo.getClassInfo(getClass());
                $staticClassInfo = classInfo;
            }
            return classInfo.getMetaClass();
        }

        public Object call() {
            return doCall(null);
        }

        public Object call(Object obj) {
            return doCall(obj);
        }

        @Generated
        public Object doCall() {
            return doCall(null);
        }

        public Object doCall(Object obj) {
            return ((Directory) obj).getAsFile().getPath();
        }
    }

    /* JADX INFO: compiled from: ProtobufExtension.groovy */
    public final class _closure2 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;
        private /* synthetic */ Reference project;

        public _closure2(Object obj, Object obj2, Reference reference) {
            super(obj, obj2);
            this.project = reference;
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _closure2.class) {
                return ScriptBytecodeAdapter.initMetaClass(this);
            }
            ClassInfo classInfo = $staticClassInfo;
            if (classInfo == null) {
                classInfo = ClassInfo.getClassInfo(getClass());
                $staticClassInfo = classInfo;
            }
            return classInfo.getMetaClass();
        }

        public Object call(String str) {
            return doCall(str);
        }

        @Generated
        public Project getProject() {
            return (Project) ScriptBytecodeAdapter.castToType(this.project.get(), Project.class);
        }

        public Object doCall(String str) {
            return new DefaultProtoSourceSet(str, ((Project) this.project.get()).getObjects());
        }
    }

    NamedDomainObjectContainer<ProtoSourceSet> getSourceSets() {
        return this.sourceSets;
    }

    ToolsLocator getTools() {
        return this.tools;
    }

    public String getGeneratedFilesBaseDir() {
        return ShortTypeHandling.castToString(getGeneratedFilesBaseDirProperty().get());
    }

    @Deprecated
    public void setGeneratedFilesBaseDir(String str) {
        getGeneratedFilesBaseDirProperty().set(str);
    }

    /* JADX INFO: compiled from: ProtobufExtension.groovy */
    public final class _configureTasks_closure3 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;

        public _configureTasks_closure3(Object obj, Object obj2) {
            super(obj, obj2);
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _configureTasks_closure3.class) {
                return ScriptBytecodeAdapter.initMetaClass(this);
            }
            ClassInfo classInfo = $staticClassInfo;
            if (classInfo == null) {
                classInfo = ClassInfo.getClassInfo(getClass());
                $staticClassInfo = classInfo;
            }
            return classInfo.getMetaClass();
        }

        public Object call() {
            return doCall(null);
        }

        public Object call(Object obj) {
            return doCall(obj);
        }

        public Object doCall(Object obj) {
            ((Action) obj).execute(((ProtobufExtension) getThisObject()).tasks);
            return null;
        }
    }

    void configureTasks() {
        DefaultGroovyMethods.each(this.taskConfigActions, new _configureTasks_closure3(this, this));
    }

    public void protoc(Action<ExecutableLocator> action) {
        action.execute(this.tools.getProtoc());
    }

    public void plugins(Action<NamedDomainObjectContainer<ExecutableLocator>> action) {
        action.execute(this.tools.getPlugins());
    }

    public void generateProtoTasks(Action<GenerateProtoTaskCollection> action) {
        this.taskConfigActions.add(action);
    }

    public GenerateProtoTaskCollection getGenerateProtoTasks() {
        return this.tasks;
    }

    /* JADX INFO: compiled from: ProtobufExtension.groovy */
    public class GenerateProtoTaskCollection implements GroovyObject {
        private static /* synthetic */ SoftReference $callSiteArray;
        private static /* synthetic */ ClassInfo $staticClassInfo;
        private static /* synthetic */ ClassInfo $staticClassInfo$;
        public static transient /* synthetic */ boolean __$stMC;
        private transient /* synthetic */ MetaClass metaClass = $getStaticMetaClass();
        private final Project project;

        private static /* synthetic */ CallSiteArray $createCallSiteArray() {
            String[] strArr = new String[3];
            $createCallSiteArray_1(strArr);
            return new CallSiteArray(GenerateProtoTaskCollection.class, strArr);
        }

        private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
            strArr[0] = "matching";
            strArr[1] = "all";
            strArr[2] = "matching";
        }

        private static /* synthetic */ CallSite[] $getCallSiteArray() {
            CallSiteArray callSiteArray$createCallSiteArray;
            SoftReference softReference = $callSiteArray;
            if (softReference == null || (callSiteArray$createCallSiteArray = (CallSiteArray) softReference.get()) == null) {
                callSiteArray$createCallSiteArray = $createCallSiteArray();
                $callSiteArray = new SoftReference(callSiteArray$createCallSiteArray);
            }
            return callSiteArray$createCallSiteArray.array;
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != GenerateProtoTaskCollection.class) {
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

        public /* synthetic */ Object methodMissing(String str, Object obj) {
            return ProtobufExtension.this.this$dist$invoke$1(str, obj);
        }

        public /* synthetic */ Object propertyMissing(String str) {
            return ProtobufExtension.this.this$dist$get$1(str);
        }

        public /* synthetic */ void propertyMissing(String str, Object obj) {
            ProtobufExtension.this.this$dist$set$1(str, obj);
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

        public GenerateProtoTaskCollection(Project project) {
            this.project = project;
        }

        public TaskCollection<GenerateProtoTask> all() {
            return this.project.getTasks().withType(GenerateProtoTask.class);
        }

        /* JADX INFO: compiled from: ProtobufExtension.groovy */
        public final class _ofSourceSet_closure1 extends Closure implements GeneratedClosure {
            private static /* synthetic */ ClassInfo $staticClassInfo;
            public static transient /* synthetic */ boolean __$stMC;
            private /* synthetic */ Reference sourceSet;

            public _ofSourceSet_closure1(Object obj, Object obj2, Reference reference) {
                super(obj, obj2);
                this.sourceSet = reference;
            }

            protected /* synthetic */ MetaClass $getStaticMetaClass() {
                if (getClass() != _ofSourceSet_closure1.class) {
                    return ScriptBytecodeAdapter.initMetaClass(this);
                }
                ClassInfo classInfo = $staticClassInfo;
                if (classInfo == null) {
                    classInfo = ClassInfo.getClassInfo(getClass());
                    $staticClassInfo = classInfo;
                }
                return classInfo.getMetaClass();
            }

            public Object call(GenerateProtoTask generateProtoTask) {
                return doCall(generateProtoTask);
            }

            @Generated
            public String getSourceSet() {
                return ShortTypeHandling.castToString(this.sourceSet.get());
            }

            public Object doCall(GenerateProtoTask generateProtoTask) {
                return Boolean.valueOf(!Utils.isAndroidProject(((GenerateProtoTaskCollection) getThisObject()).project) && ScriptBytecodeAdapter.compareEqual(generateProtoTask.getSourceSet().getName(), this.sourceSet.get()));
            }
        }

        public TaskCollection<GenerateProtoTask> ofSourceSet(String str) {
            return all().matching(new _ofSourceSet_closure1(this, this, new Reference(str)));
        }

        /* JADX INFO: compiled from: ProtobufExtension.groovy */
        public final class _ofFlavor_closure2 extends Closure implements GeneratedClosure {
            private static /* synthetic */ ClassInfo $staticClassInfo;
            public static transient /* synthetic */ boolean __$stMC;
            private /* synthetic */ Reference flavor;

            public _ofFlavor_closure2(Object obj, Object obj2, Reference reference) {
                super(obj, obj2);
                this.flavor = reference;
            }

            protected /* synthetic */ MetaClass $getStaticMetaClass() {
                if (getClass() != _ofFlavor_closure2.class) {
                    return ScriptBytecodeAdapter.initMetaClass(this);
                }
                ClassInfo classInfo = $staticClassInfo;
                if (classInfo == null) {
                    classInfo = ClassInfo.getClassInfo(getClass());
                    $staticClassInfo = classInfo;
                }
                return classInfo.getMetaClass();
            }

            public Object call(GenerateProtoTask generateProtoTask) {
                return doCall(generateProtoTask);
            }

            @Generated
            public String getFlavor() {
                return ShortTypeHandling.castToString(this.flavor.get());
            }

            public Object doCall(GenerateProtoTask generateProtoTask) {
                return Boolean.valueOf(Utils.isAndroidProject(((GenerateProtoTaskCollection) getThisObject()).project) && generateProtoTask.getFlavors().contains(this.flavor.get()));
            }
        }

        public TaskCollection<GenerateProtoTask> ofFlavor(String str) {
            return all().matching(new _ofFlavor_closure2(this, this, new Reference(str)));
        }

        /* JADX INFO: compiled from: ProtobufExtension.groovy */
        public final class _ofBuildType_closure3 extends Closure implements GeneratedClosure {
            private static /* synthetic */ ClassInfo $staticClassInfo;
            public static transient /* synthetic */ boolean __$stMC;
            private /* synthetic */ Reference buildType;

            public _ofBuildType_closure3(Object obj, Object obj2, Reference reference) {
                super(obj, obj2);
                this.buildType = reference;
            }

            protected /* synthetic */ MetaClass $getStaticMetaClass() {
                if (getClass() != _ofBuildType_closure3.class) {
                    return ScriptBytecodeAdapter.initMetaClass(this);
                }
                ClassInfo classInfo = $staticClassInfo;
                if (classInfo == null) {
                    classInfo = ClassInfo.getClassInfo(getClass());
                    $staticClassInfo = classInfo;
                }
                return classInfo.getMetaClass();
            }

            public Object call(GenerateProtoTask generateProtoTask) {
                return doCall(generateProtoTask);
            }

            @Generated
            public String getBuildType() {
                return ShortTypeHandling.castToString(this.buildType.get());
            }

            public Object doCall(GenerateProtoTask generateProtoTask) {
                return Boolean.valueOf(Utils.isAndroidProject(((GenerateProtoTaskCollection) getThisObject()).project) && ScriptBytecodeAdapter.compareEqual(generateProtoTask.getBuildType(), this.buildType.get()));
            }
        }

        public TaskCollection<GenerateProtoTask> ofBuildType(String str) {
            return all().matching(new _ofBuildType_closure3(this, this, new Reference(str)));
        }

        public TaskCollection<GenerateProtoTask> ofVariant(String str) {
            Reference reference = new Reference(str);
            CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
            return (TaskCollection) ScriptBytecodeAdapter.castToType((__$stMC || BytecodeInterface8.disabledStandardMetaClass()) ? callSiteArr$getCallSiteArray[0].call(callSiteArr$getCallSiteArray[1].callCurrent(this), new _ofVariant_closure4(this, this, reference)) : callSiteArr$getCallSiteArray[2].call(all(), new _ofVariant_closure4(this, this, reference)), TaskCollection.class);
        }

        /* JADX INFO: compiled from: ProtobufExtension.groovy */
        public final class _ofVariant_closure4 extends Closure implements GeneratedClosure {
            private static /* synthetic */ SoftReference $callSiteArray;
            private static /* synthetic */ ClassInfo $staticClassInfo;
            public static transient /* synthetic */ boolean __$stMC;
            private /* synthetic */ Reference variant;

            private static /* synthetic */ CallSiteArray $createCallSiteArray() {
                String[] strArr = new String[5];
                $createCallSiteArray_1(strArr);
                return new CallSiteArray(_ofVariant_closure4.class, strArr);
            }

            private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
                strArr[0] = "isAndroidProject";
                strArr[1] = "project";
                strArr[2] = "name";
                strArr[3] = "variant";
                strArr[4] = "doCall";
            }

            private static /* synthetic */ CallSite[] $getCallSiteArray() {
                CallSiteArray callSiteArray$createCallSiteArray;
                SoftReference softReference = $callSiteArray;
                if (softReference == null || (callSiteArray$createCallSiteArray = (CallSiteArray) softReference.get()) == null) {
                    callSiteArray$createCallSiteArray = $createCallSiteArray();
                    $callSiteArray = new SoftReference(callSiteArray$createCallSiteArray);
                }
                return callSiteArray$createCallSiteArray.array;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public _ofVariant_closure4(Object obj, Object obj2, Reference reference) {
                super(obj, obj2);
                $getCallSiteArray();
                this.variant = reference;
            }

            protected /* synthetic */ MetaClass $getStaticMetaClass() {
                if (getClass() != _ofVariant_closure4.class) {
                    return ScriptBytecodeAdapter.initMetaClass(this);
                }
                ClassInfo classInfo = $staticClassInfo;
                if (classInfo == null) {
                    classInfo = ClassInfo.getClassInfo(getClass());
                    $staticClassInfo = classInfo;
                }
                return classInfo.getMetaClass();
            }

            public Object call(GenerateProtoTask generateProtoTask) {
                return $getCallSiteArray()[4].callCurrent(this, generateProtoTask);
            }

            @Generated
            public String getVariant() {
                $getCallSiteArray();
                return ShortTypeHandling.castToString(this.variant.get());
            }

            public Object doCall(GenerateProtoTask generateProtoTask) {
                CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
                boolean z = false;
                if (DefaultTypeTransformation.booleanUnbox(callSiteArr$getCallSiteArray[0].call(Utils.class, callSiteArr$getCallSiteArray[1].callGroovyObjectGetProperty(this))) && ScriptBytecodeAdapter.compareEqual(callSiteArr$getCallSiteArray[2].callGetProperty(callSiteArr$getCallSiteArray[3].callGroovyObjectGetProperty(generateProtoTask)), this.variant.get())) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        }

        /* JADX INFO: compiled from: ProtobufExtension.groovy */
        public final class _ofNonTest_closure5 extends Closure implements GeneratedClosure {
            private static /* synthetic */ ClassInfo $staticClassInfo;
            public static transient /* synthetic */ boolean __$stMC;

            public _ofNonTest_closure5(Object obj, Object obj2) {
                super(obj, obj2);
            }

            protected /* synthetic */ MetaClass $getStaticMetaClass() {
                if (getClass() != _ofNonTest_closure5.class) {
                    return ScriptBytecodeAdapter.initMetaClass(this);
                }
                ClassInfo classInfo = $staticClassInfo;
                if (classInfo == null) {
                    classInfo = ClassInfo.getClassInfo(getClass());
                    $staticClassInfo = classInfo;
                }
                return classInfo.getMetaClass();
            }

            public Object call(GenerateProtoTask generateProtoTask) {
                return doCall(generateProtoTask);
            }

            public Object doCall(GenerateProtoTask generateProtoTask) {
                return Boolean.valueOf(Utils.isAndroidProject(((GenerateProtoTaskCollection) getThisObject()).project) && !generateProtoTask.getIsTestVariant());
            }
        }

        public TaskCollection<GenerateProtoTask> ofNonTest() {
            return all().matching(new _ofNonTest_closure5(this, this));
        }

        /* JADX INFO: compiled from: ProtobufExtension.groovy */
        public final class _ofTest_closure6 extends Closure implements GeneratedClosure {
            private static /* synthetic */ ClassInfo $staticClassInfo;
            public static transient /* synthetic */ boolean __$stMC;

            public _ofTest_closure6(Object obj, Object obj2) {
                super(obj, obj2);
            }

            protected /* synthetic */ MetaClass $getStaticMetaClass() {
                if (getClass() != _ofTest_closure6.class) {
                    return ScriptBytecodeAdapter.initMetaClass(this);
                }
                ClassInfo classInfo = $staticClassInfo;
                if (classInfo == null) {
                    classInfo = ClassInfo.getClassInfo(getClass());
                    $staticClassInfo = classInfo;
                }
                return classInfo.getMetaClass();
            }

            public Object call(GenerateProtoTask generateProtoTask) {
                return doCall(generateProtoTask);
            }

            public Object doCall(GenerateProtoTask generateProtoTask) {
                return Boolean.valueOf(Utils.isAndroidProject(((GenerateProtoTaskCollection) getThisObject()).project) && generateProtoTask.getIsTestVariant());
            }
        }

        public TaskCollection<GenerateProtoTask> ofTest() {
            return all().matching(new _ofTest_closure6(this, this));
        }
    }
}
