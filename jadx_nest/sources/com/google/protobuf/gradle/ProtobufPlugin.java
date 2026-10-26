package com.google.protobuf.gradle;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.android.build.gradle.api.BaseVariant;
import com.android.build.gradle.api.TestVariant;
import com.android.build.gradle.api.UnitTestVariant;
import com.android.builder.model.SourceProvider;
import com.google.gradle.osdetector.OsDetectorPlugin;
import com.google.protobuf.gradle.internal.DefaultProtoSourceSet;
import com.google.protobuf.gradle.internal.ProjectExt;
import com.google.protobuf.gradle.tasks.ProtoSourceSet;
import groovy.lang.Closure;
import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;
import groovy.lang.Reference;
import groovy.transform.Generated;
import groovy.transform.Internal;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.List;
import net.lingala.zip4j.util.InternalZipConstants;
import org.codehaus.groovy.reflection.ClassInfo;
import org.codehaus.groovy.runtime.ArrayUtil;
import org.codehaus.groovy.runtime.BytecodeInterface8;
import org.codehaus.groovy.runtime.DefaultGroovyMethods;
import org.codehaus.groovy.runtime.GStringImpl;
import org.codehaus.groovy.runtime.GeneratedClosure;
import org.codehaus.groovy.runtime.InvokerHelper;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.codehaus.groovy.runtime.StringGroovyMethods;
import org.codehaus.groovy.runtime.callsite.CallSite;
import org.codehaus.groovy.runtime.callsite.CallSiteArray;
import org.codehaus.groovy.runtime.typehandling.DefaultTypeTransformation;
import org.codehaus.groovy.runtime.typehandling.ShortTypeHandling;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;
import org.gradle.api.Action;
import org.gradle.api.GradleException;
import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Transformer;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.artifacts.type.ArtifactTypeDefinition;
import org.gradle.api.attributes.LibraryElements;
import org.gradle.api.attributes.Usage;
import org.gradle.api.file.CopySpec;
import org.gradle.api.file.FileCollection;
import org.gradle.api.file.SourceDirectorySet;
import org.gradle.api.internal.artifacts.ArtifactAttributes;
import org.gradle.api.plugins.AppliedPlugin;
import org.gradle.api.provider.Property;
import org.gradle.api.provider.Provider;
import org.gradle.api.tasks.SourceSet;
import org.gradle.api.tasks.TaskProvider;
import org.gradle.language.jvm.tasks.ProcessResources;
import org.gradle.util.GradleVersion;
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension;
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile;

/* INFO: compiled from: ProtobufPlugin.groovy */
/* INFO: loaded from: classes4.dex */
public class ProtobufPlugin implements Plugin<Project>, GroovyObject {
    private static /* synthetic */ SoftReference $callSiteArray;
    private static /* synthetic */ ClassInfo $staticClassInfo;
    private static /* synthetic */ ClassInfo $staticClassInfo$;
    private static final List<String> PREREQ_PLUGIN_OPTIONS = ScriptBytecodeAdapter.createList(new Object[]{"java", "java-library", "com.android.application", "com.android.feature", "com.android.library", "android", "android-library"});
    public static transient /* synthetic */ boolean __$stMC;
    private Project project;
    private ProtobufExtension protobufExtension;
    private boolean wasApplied = false;
    private transient /* synthetic */ MetaClass metaClass = $getStaticMetaClass();

    private static /* synthetic */ CallSiteArray $createCallSiteArray() {
        String[] strArr = new String[32];
        $createCallSiteArray_1(strArr);
        return new CallSiteArray(ProtobufPlugin.class, strArr);
    }

    private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
        strArr[0] = "isAndroidProject";
        strArr[1] = "configureEach";
        strArr[2] = "sourceSets";
        strArr[3] = "android";
        strArr[4] = "domainObjectContainer";
        strArr[5] = Constants.OBJECTS;
        strArr[6] = "forEachVariant";
        strArr[7] = "configureEach";
        strArr[8] = "sourceSets";
        strArr[9] = "afterEvaluate";
        strArr[10] = "name";
        strArr[11] = "proto";
        strArr[12] = "add";
        strArr[13] = ConfigConstants.CONFIG_EXTENSIONS_SECTION;
        strArr[14] = "srcDir";
        strArr[15] = "include";
        strArr[16] = "create";
        strArr[17] = "name";
        strArr[18] = "files";
        strArr[19] = "artifactView";
        strArr[20] = "incoming";
        strArr[21] = "compileConfiguration";
        strArr[22] = "add";
        strArr[23] = "setupExtractIncludeProtosTask";
        strArr[24] = "each";
        strArr[25] = "sourceSets";
        strArr[26] = "addGenerateProtoTask";
        strArr[27] = "hasProperty";
        strArr[28] = "android";
        strArr[29] = "configure";
        strArr[30] = "getProcessJavaResourcesProvider";
        strArr[31] = "add";
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

    @Generated
    public ProtobufPlugin() {
    }

    public static /* synthetic */ boolean pfaccess$01(ProtobufPlugin protobufPlugin, boolean z) {
        ScriptBytecodeAdapter.setGroovyObjectProperty(Boolean.valueOf(z), ProtobufPlugin.class, protobufPlugin, "wasApplied");
        return z;
    }

    protected /* synthetic */ MetaClass $getStaticMetaClass() {
        if (getClass() != ProtobufPlugin.class) {
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

    public void apply(Project project) throws Throwable {
        Reference reference = new Reference(project);
        if (ScriptBytecodeAdapter.compareLessThan(GradleVersion.current(), GradleVersion.version("5.6"))) {
            throw new GradleException(ShortTypeHandling.castToString(new GStringImpl(new Object[]{((Project) reference.get()).getGradle().getGradleVersion()}, new String[]{"Gradle version is ", ". Minimum supported version is 5.6"})));
        }
        this.protobufExtension = (ProtobufExtension) ScriptBytecodeAdapter.castToType(((Project) reference.get()).getExtensions().create("protobuf", ProtobufExtension.class, new Object[]{(Project) reference.get()}), ProtobufExtension.class);
        this.project = (Project) reference.get();
        ((Project) reference.get()).apply(ScriptBytecodeAdapter.createMap(new Object[]{"plugin", OsDetectorPlugin.class}));
        DefaultGroovyMethods.each(PREREQ_PLUGIN_OPTIONS, new _apply_closure2(this, this, reference, new Reference((Action) ScriptBytecodeAdapter.castToType(new _apply_closure1(this, this, reference), Action.class))));
        ((Project) reference.get()).afterEvaluate(new _apply_closure3(this, this));
    }

    /* INFO: compiled from: ProtobufPlugin.groovy */
    public final class _apply_closure1 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;
        private /* synthetic */ Reference project;

        public _apply_closure1(Object obj, Object obj2, Reference reference) {
            super(obj, obj2);
            this.project = reference;
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _apply_closure1.class) {
                return ScriptBytecodeAdapter.initMetaClass(this);
            }
            ClassInfo classInfo = $staticClassInfo;
            if (classInfo == null) {
                classInfo = ClassInfo.getClassInfo(getClass());
                $staticClassInfo = classInfo;
            }
            return classInfo.getMetaClass();
        }

        public Object call(AppliedPlugin appliedPlugin) {
            return doCall(appliedPlugin);
        }

        @Generated
        public Project getProject() {
            return (Project) ScriptBytecodeAdapter.castToType(this.project.get(), Project.class);
        }

        public Object doCall(AppliedPlugin appliedPlugin) {
            if (((ProtobufPlugin) getThisObject()).wasApplied) {
                ((Project) this.project.get()).getLogger().info(StringGroovyMethods.plus(StringGroovyMethods.plus(StringGroovyMethods.plus("The com.google.protobuf plugin was already applied to the project: ", ((Project) this.project.get()).getPath()), " and will not be applied again after plugin: "), appliedPlugin.getId()));
                return null;
            }
            ProtobufPlugin.pfaccess$01((ProtobufPlugin) getThisObject(), true);
            ((ProtobufPlugin) ScriptBytecodeAdapter.castToType(getThisObject(), ProtobufPlugin.class)).doApply();
            return null;
        }
    }

    /* INFO: compiled from: ProtobufPlugin.groovy */
    public final class _apply_closure2 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;
        private /* synthetic */ Reference applyWithPrerequisitePlugin;
        private /* synthetic */ Reference project;

        public _apply_closure2(Object obj, Object obj2, Reference reference, Reference reference2) {
            super(obj, obj2);
            this.project = reference;
            this.applyWithPrerequisitePlugin = reference2;
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _apply_closure2.class) {
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
        public Action getApplyWithPrerequisitePlugin() {
            return (Action) ScriptBytecodeAdapter.castToType(this.applyWithPrerequisitePlugin.get(), Action.class);
        }

        @Generated
        public Project getProject() {
            return (Project) ScriptBytecodeAdapter.castToType(this.project.get(), Project.class);
        }

        public Object doCall(Object obj) {
            ((Project) this.project.get()).getPluginManager().withPlugin(ShortTypeHandling.castToString(obj), (Action) ScriptBytecodeAdapter.castToType(this.applyWithPrerequisitePlugin.get(), Action.class));
            return null;
        }
    }

    /* INFO: compiled from: ProtobufPlugin.groovy */
    public final class _apply_closure3 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;

        public _apply_closure3(Object obj, Object obj2) {
            super(obj, obj2);
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _apply_closure3.class) {
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

        public Object doCall(Object obj) throws Throwable {
            if (((ProtobufPlugin) getThisObject()).wasApplied) {
                return null;
            }
            throw new GradleException(StringGroovyMethods.plus("The com.google.protobuf plugin could not be applied during project evaluation.", " The Java plugin or one of the Android plugins must be applied to the project first."));
        }
    }

    /* INFO: Access modifiers changed from: private */
    public void doApply() {
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        boolean zBooleanUnbox = DefaultTypeTransformation.booleanUnbox(callSiteArr$getCallSiteArray[0].call(Utils.class, this.project));
        Reference reference = new Reference(ScriptBytecodeAdapter.createList(new Object[0]));
        if (zBooleanUnbox) {
            callSiteArr$getCallSiteArray[1].call(callSiteArr$getCallSiteArray[2].callGetProperty(callSiteArr$getCallSiteArray[3].callGetProperty(this.project)), new _doApply_closure4(this, this));
            callSiteArr$getCallSiteArray[6].call(ProjectExt.class, this.project, new _doApply_closure6(this, this, new Reference((NamedDomainObjectContainer) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[4].call(callSiteArr$getCallSiteArray[5].callGetProperty(this.project), ProtoSourceSet.class, new _doApply_closure5(this, this)), NamedDomainObjectContainer.class)), reference));
        } else {
            callSiteArr$getCallSiteArray[7].call(callSiteArr$getCallSiteArray[8].callGetProperty(this.project), new _doApply_closure7(this, this, reference));
        }
        callSiteArr$getCallSiteArray[9].call(this.project, new _doApply_closure8(this, this, reference));
    }

    /* INFO: compiled from: ProtobufPlugin.groovy */
    public final class _doApply_closure4 extends Closure implements GeneratedClosure {
        private static /* synthetic */ SoftReference $callSiteArray;
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;

        private static /* synthetic */ CallSiteArray $createCallSiteArray() {
            String[] strArr = new String[7];
            $createCallSiteArray_1(strArr);
            return new CallSiteArray(_doApply_closure4.class, strArr);
        }

        private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
            strArr[0] = "create";
            strArr[1] = "sourceSets";
            strArr[2] = "protobufExtension";
            strArr[3] = "name";
            strArr[4] = "addSourceSetExtension";
            strArr[5] = "createProtobufConfiguration";
            strArr[6] = "setupExtractProtosTask";
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

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        public _doApply_closure4(Object obj, Object obj2) {
            super(obj, obj2);
            $getCallSiteArray();
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _doApply_closure4.class) {
                return ScriptBytecodeAdapter.initMetaClass(this);
            }
            ClassInfo classInfo = $staticClassInfo;
            if (classInfo == null) {
                classInfo = ClassInfo.getClassInfo(getClass());
                $staticClassInfo = classInfo;
            }
            return classInfo.getMetaClass();
        }

        public Object doCall(Object obj) {
            CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
            ProtoSourceSet protoSourceSet = (ProtoSourceSet) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[0].call(callSiteArr$getCallSiteArray[1].callGroovyObjectGetProperty(callSiteArr$getCallSiteArray[2].callGroovyObjectGetProperty(this)), callSiteArr$getCallSiteArray[3].callGetProperty(obj)), ProtoSourceSet.class);
            callSiteArr$getCallSiteArray[4].callCurrent(this, obj, protoSourceSet);
            return callSiteArr$getCallSiteArray[6].callCurrent(this, protoSourceSet, (Configuration) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[5].callCurrent(this, protoSourceSet), Configuration.class));
        }
    }

    /* INFO: compiled from: ProtobufPlugin.groovy */
    public final class _doApply_closure5 extends Closure implements GeneratedClosure {
        private static /* synthetic */ SoftReference $callSiteArray;
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;

        private static /* synthetic */ CallSiteArray $createCallSiteArray() {
            String[] strArr = new String[4];
            $createCallSiteArray_1(strArr);
            return new CallSiteArray(_doApply_closure5.class, strArr);
        }

        private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
            strArr[0] = "<$constructor$>";
            strArr[1] = Constants.OBJECTS;
            strArr[2] = "project";
            strArr[3] = "doCall";
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

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        public _doApply_closure5(Object obj, Object obj2) {
            super(obj, obj2);
            $getCallSiteArray();
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _doApply_closure5.class) {
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
            return (__$stMC || BytecodeInterface8.disabledStandardMetaClass()) ? $getCallSiteArray()[3].callCurrent(this, str) : doCall(str);
        }

        public Object doCall(String str) {
            CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
            return callSiteArr$getCallSiteArray[0].callConstructor(DefaultProtoSourceSet.class, str, callSiteArr$getCallSiteArray[1].callGetProperty(callSiteArr$getCallSiteArray[2].callGroovyObjectGetProperty(this)));
        }
    }

    /* INFO: compiled from: ProtobufPlugin.groovy */
    public final class _doApply_closure6 extends Closure implements GeneratedClosure {
        private static /* synthetic */ SoftReference $callSiteArray;
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;
        private /* synthetic */ Reference postConfigure;
        private /* synthetic */ Reference variantSourceSets;

        private static /* synthetic */ CallSiteArray $createCallSiteArray() {
            String[] strArr = new String[2];
            $createCallSiteArray_1(strArr);
            return new CallSiteArray(_doApply_closure6.class, strArr);
        }

        private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
            strArr[0] = "addTasksForVariant";
            strArr[1] = "doCall";
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

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        public _doApply_closure6(Object obj, Object obj2, Reference reference, Reference reference2) {
            super(obj, obj2);
            $getCallSiteArray();
            this.variantSourceSets = reference;
            this.postConfigure = reference2;
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _doApply_closure6.class) {
                return ScriptBytecodeAdapter.initMetaClass(this);
            }
            ClassInfo classInfo = $staticClassInfo;
            if (classInfo == null) {
                classInfo = ClassInfo.getClassInfo(getClass());
                $staticClassInfo = classInfo;
            }
            return classInfo.getMetaClass();
        }

        public Object call(BaseVariant baseVariant) {
            return $getCallSiteArray()[1].callCurrent(this, baseVariant);
        }

        @Generated
        public Collection getPostConfigure() {
            $getCallSiteArray();
            return (Collection) ScriptBytecodeAdapter.castToType(this.postConfigure.get(), Collection.class);
        }

        @Generated
        public NamedDomainObjectContainer getVariantSourceSets() {
            $getCallSiteArray();
            return (NamedDomainObjectContainer) ScriptBytecodeAdapter.castToType(this.variantSourceSets.get(), NamedDomainObjectContainer.class);
        }

        public Object doCall(BaseVariant baseVariant) {
            return $getCallSiteArray()[0].callCurrent(this, baseVariant, this.variantSourceSets.get(), this.postConfigure.get());
        }
    }

    /* INFO: compiled from: ProtobufPlugin.groovy */
    public final class _doApply_closure7 extends Closure implements GeneratedClosure {
        private static /* synthetic */ SoftReference $callSiteArray;
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;
        private /* synthetic */ Reference postConfigure;

        private static /* synthetic */ CallSiteArray $createCallSiteArray() {
            String[] strArr = new String[8];
            $createCallSiteArray_1(strArr);
            return new CallSiteArray(_doApply_closure7.class, strArr);
        }

        private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
            strArr[0] = "create";
            strArr[1] = "sourceSets";
            strArr[2] = "protobufExtension";
            strArr[3] = "name";
            strArr[4] = "addSourceSetExtension";
            strArr[5] = "createProtobufConfiguration";
            strArr[6] = "createCompileProtoPathConfiguration";
            strArr[7] = "addTasksForSourceSet";
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

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        public _doApply_closure7(Object obj, Object obj2, Reference reference) {
            super(obj, obj2);
            $getCallSiteArray();
            this.postConfigure = reference;
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _doApply_closure7.class) {
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
        public Collection getPostConfigure() {
            $getCallSiteArray();
            return (Collection) ScriptBytecodeAdapter.castToType(this.postConfigure.get(), Collection.class);
        }

        public Object doCall(Object obj) {
            CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
            ProtoSourceSet protoSourceSet = (ProtoSourceSet) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[0].call(callSiteArr$getCallSiteArray[1].callGroovyObjectGetProperty(callSiteArr$getCallSiteArray[2].callGroovyObjectGetProperty(this)), callSiteArr$getCallSiteArray[3].callGetProperty(obj)), ProtoSourceSet.class);
            callSiteArr$getCallSiteArray[4].callCurrent(this, obj, protoSourceSet);
            return callSiteArr$getCallSiteArray[7].callCurrent(this, ArrayUtil.createArray(obj, protoSourceSet, (Configuration) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[5].callCurrent(this, protoSourceSet), Configuration.class), (Configuration) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[6].callCurrent(this, protoSourceSet), Configuration.class), this.postConfigure.get()));
        }
    }

    /* INFO: compiled from: ProtobufPlugin.groovy */
    public final class _doApply_closure8 extends Closure implements GeneratedClosure {
        private static /* synthetic */ SoftReference $callSiteArray;
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;
        private /* synthetic */ Reference postConfigure;

        private static /* synthetic */ CallSiteArray $createCallSiteArray() {
            String[] strArr = new String[12];
            $createCallSiteArray_1(strArr);
            return new CallSiteArray(_doApply_closure8.class, strArr);
        }

        private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
            strArr[0] = "configureTasks";
            strArr[1] = "protobufExtension";
            strArr[2] = "configureEach";
            strArr[3] = "all";
            strArr[4] = "generateProtoTasks";
            strArr[5] = "protobufExtension";
            strArr[6] = "each";
            strArr[7] = "resolve";
            strArr[8] = "tools";
            strArr[9] = "protobuf";
            strArr[10] = "project";
            strArr[11] = "project";
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

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        public _doApply_closure8(Object obj, Object obj2, Reference reference) {
            super(obj, obj2);
            $getCallSiteArray();
            this.postConfigure = reference;
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _doApply_closure8.class) {
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
        public Object doCall() {
            $getCallSiteArray();
            return doCall(null);
        }

        @Generated
        public Collection getPostConfigure() {
            $getCallSiteArray();
            return (Collection) ScriptBytecodeAdapter.castToType(this.postConfigure.get(), Collection.class);
        }

        public Object doCall(Object obj) {
            CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
            callSiteArr$getCallSiteArray[0].call(callSiteArr$getCallSiteArray[1].callGroovyObjectGetProperty(getThisObject()));
            callSiteArr$getCallSiteArray[2].call(callSiteArr$getCallSiteArray[3].call(callSiteArr$getCallSiteArray[4].callGetProperty(callSiteArr$getCallSiteArray[5].callGroovyObjectGetProperty(getThisObject()))), new _closure24(this, getThisObject()));
            callSiteArr$getCallSiteArray[6].call(this.postConfigure.get(), new _closure25(this, getThisObject()));
            return callSiteArr$getCallSiteArray[7].call(callSiteArr$getCallSiteArray[8].callGetProperty(callSiteArr$getCallSiteArray[9].callGetProperty(callSiteArr$getCallSiteArray[10].callGroovyObjectGetProperty(this))), callSiteArr$getCallSiteArray[11].callGroovyObjectGetProperty(this));
        }

        /* INFO: compiled from: ProtobufPlugin.groovy */
        public final class _closure24 extends Closure implements GeneratedClosure {
            private static /* synthetic */ SoftReference $callSiteArray;
            private static /* synthetic */ ClassInfo $staticClassInfo;
            public static transient /* synthetic */ boolean __$stMC;

            private static /* synthetic */ CallSiteArray $createCallSiteArray() {
                String[] strArr = new String[1];
                $createCallSiteArray_1(strArr);
                return new CallSiteArray(_closure24.class, strArr);
            }

            private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
                strArr[0] = "doneConfig";
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

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            public _closure24(Object obj, Object obj2) {
                super(obj, obj2);
                $getCallSiteArray();
            }

            protected /* synthetic */ MetaClass $getStaticMetaClass() {
                if (getClass() != _closure24.class) {
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
            public Object doCall() {
                $getCallSiteArray();
                return doCall(null);
            }

            public Object doCall(Object obj) {
                return $getCallSiteArray()[0].call(obj);
            }
        }

        /* INFO: compiled from: ProtobufPlugin.groovy */
        public final class _closure25 extends Closure implements GeneratedClosure {
            private static /* synthetic */ SoftReference $callSiteArray;
            private static /* synthetic */ ClassInfo $staticClassInfo;
            public static transient /* synthetic */ boolean __$stMC;

            private static /* synthetic */ CallSiteArray $createCallSiteArray() {
                String[] strArr = new String[1];
                $createCallSiteArray_1(strArr);
                return new CallSiteArray(_closure25.class, strArr);
            }

            private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
                strArr[0] = NotificationCompat.CATEGORY_CALL;
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

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            public _closure25(Object obj, Object obj2) {
                super(obj, obj2);
                $getCallSiteArray();
            }

            protected /* synthetic */ MetaClass $getStaticMetaClass() {
                if (getClass() != _closure25.class) {
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
            public Object doCall() {
                $getCallSiteArray();
                return doCall(null);
            }

            public Object doCall(Object obj) {
                return $getCallSiteArray()[0].call(obj);
            }
        }
    }

    private Configuration createProtobufConfiguration(ProtoSourceSet protoSourceSet) {
        return (Configuration) ScriptBytecodeAdapter.castToType(this.project.getConfigurations().create(Utils.getConfigName(protoSourceSet.getName(), "protobuf"), new _createProtobufConfiguration_closure9(this, this)), Configuration.class);
    }

    /* INFO: compiled from: ProtobufPlugin.groovy */
    public final class _createProtobufConfiguration_closure9 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;

        public _createProtobufConfiguration_closure9(Object obj, Object obj2) {
            super(obj, obj2);
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _createProtobufConfiguration_closure9.class) {
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
            configuration.setTransitive(true);
            return true;
        }
    }

    private Configuration createCompileProtoPathConfiguration(ProtoSourceSet protoSourceSet) {
        return (Configuration) ScriptBytecodeAdapter.castToType(this.project.getConfigurations().create(Utils.getConfigName(protoSourceSet.getName(), "compileProtoPath"), new _createCompileProtoPathConfiguration_closure10(this, this, new Reference(this.project.getConfigurations().getByName(Utils.getConfigName(protoSourceSet.getName(), "compileOnly"))), new Reference(this.project.getConfigurations().getByName(Utils.getConfigName(protoSourceSet.getName(), "implementation"))))), Configuration.class);
    }

    /* INFO: compiled from: ProtobufPlugin.groovy */
    public final class _createCompileProtoPathConfiguration_closure10 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;
        private /* synthetic */ Reference compileConfig;
        private /* synthetic */ Reference implementationConfig;

        public _createCompileProtoPathConfiguration_closure10(Object obj, Object obj2, Reference reference, Reference reference2) {
            super(obj, obj2);
            this.compileConfig = reference;
            this.implementationConfig = reference2;
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _createCompileProtoPathConfiguration_closure10.class) {
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

        @Generated
        public Configuration getCompileConfig() {
            return (Configuration) ScriptBytecodeAdapter.castToType(this.compileConfig.get(), Configuration.class);
        }

        @Generated
        public Configuration getImplementationConfig() {
            return (Configuration) ScriptBytecodeAdapter.castToType(this.implementationConfig.get(), Configuration.class);
        }

        public Object doCall(Configuration configuration) {
            configuration.setVisible(false);
            configuration.setTransitive(true);
            configuration.setExtendsFrom(ScriptBytecodeAdapter.createList(new Object[]{this.compileConfig.get(), this.implementationConfig.get()}));
            configuration.setCanBeConsumed(false);
            return configuration.getAttributes().attribute(LibraryElements.LIBRARY_ELEMENTS_ATTRIBUTE, ((ProtobufPlugin) getThisObject()).project.getObjects().named(LibraryElements.class, LibraryElements.RESOURCES)).attribute(Usage.USAGE_ATTRIBUTE, ((ProtobufPlugin) getThisObject()).project.getObjects().named(Usage.class, Usage.JAVA_RUNTIME));
        }
    }

    private SourceDirectorySet addSourceSetExtension(Object obj, ProtoSourceSet protoSourceSet) {
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        String strCastToString = ShortTypeHandling.castToString(callSiteArr$getCallSiteArray[10].callGetProperty(obj));
        SourceDirectorySet sourceDirectorySet = (SourceDirectorySet) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[11].callGetProperty(protoSourceSet), SourceDirectorySet.class);
        callSiteArr$getCallSiteArray[12].call(callSiteArr$getCallSiteArray[13].callGetProperty(obj), "proto", sourceDirectorySet);
        callSiteArr$getCallSiteArray[14].call(sourceDirectorySet, new GStringImpl(new Object[]{strCastToString}, new String[]{"src/", "/proto"}));
        callSiteArr$getCallSiteArray[15].call(sourceDirectorySet, "**/*.proto");
        return sourceDirectorySet;
    }

    private void addTasksForSourceSet(SourceSet sourceSet, ProtoSourceSet protoSourceSet, Configuration configuration, Configuration configuration2, Collection<Closure> collection) {
        Reference reference = new Reference(sourceSet);
        Reference reference2 = new Reference(protoSourceSet);
        Reference reference3 = new Reference(setupExtractProtosTask((ProtoSourceSet) reference2.get(), configuration));
        Reference reference4 = new Reference(setupExtractIncludeProtosTask((ProtoSourceSet) reference2.get(), configuration2));
        if (Utils.isTest(((SourceSet) reference.get()).getName())) {
            ((ProtoSourceSet) reference2.get()).includesFrom((ProtoSourceSet) ScriptBytecodeAdapter.castToType(this.protobufExtension.getSourceSets().getByName("main"), ProtoSourceSet.class));
        }
        Reference reference5 = new Reference(addGenerateProtoTask((ProtoSourceSet) reference2.get(), (Action) ScriptBytecodeAdapter.castToType(new _addTasksForSourceSet_closure11(this, this, reference), Action.class)));
        ((SourceSet) reference.get()).getJava().srcDirs(new Object[]{((ProtoSourceSet) reference2.get()).getOutput()});
        this.project.getTasks().named(((SourceSet) reference.get()).getTaskName("process", "resources"), ProcessResources.class).configure((Action) ScriptBytecodeAdapter.castToType(new _addTasksForSourceSet_closure12(this, this, reference2), Action.class));
        collection.add(new _addTasksForSourceSet_closure13(this, this, reference5, reference, reference2, reference3, reference4));
    }

    /* INFO: compiled from: ProtobufPlugin.groovy */
    public final class _addTasksForSourceSet_closure11 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;
        private /* synthetic */ Reference sourceSet;

        public _addTasksForSourceSet_closure11(Object obj, Object obj2, Reference reference) {
            super(obj, obj2);
            this.sourceSet = reference;
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _addTasksForSourceSet_closure11.class) {
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

        @Generated
        public SourceSet getSourceSet() {
            return (SourceSet) ScriptBytecodeAdapter.castToType(this.sourceSet.get(), SourceSet.class);
        }

        public Object doCall(Object obj) {
            GenerateProtoTask generateProtoTask = (GenerateProtoTask) obj;
            generateProtoTask.setSourceSet((SourceSet) ScriptBytecodeAdapter.castToType(this.sourceSet.get(), SourceSet.class));
            generateProtoTask.doneInitializing();
            return generateProtoTask.getBuiltins().maybeCreate("java");
        }
    }

    /* INFO: compiled from: ProtobufPlugin.groovy */
    public final class _addTasksForSourceSet_closure12 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;
        private /* synthetic */ Reference protoSourceSet;

        public _addTasksForSourceSet_closure12(Object obj, Object obj2, Reference reference) {
            super(obj, obj2);
            this.protoSourceSet = reference;
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _addTasksForSourceSet_closure12.class) {
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

        @Generated
        public ProtoSourceSet getProtoSourceSet() {
            return (ProtoSourceSet) ScriptBytecodeAdapter.castToType(this.protoSourceSet.get(), ProtoSourceSet.class);
        }

        /* INFO: compiled from: ProtobufPlugin.groovy */
        public final class _closure26 extends Closure implements GeneratedClosure {
            private static /* synthetic */ ClassInfo $staticClassInfo;
            public static transient /* synthetic */ boolean __$stMC;

            public _closure26(Object obj, Object obj2) {
                super(obj, obj2);
            }

            protected /* synthetic */ MetaClass $getStaticMetaClass() {
                if (getClass() != _closure26.class) {
                    return ScriptBytecodeAdapter.initMetaClass(this);
                }
                ClassInfo classInfo = $staticClassInfo;
                if (classInfo == null) {
                    classInfo = ClassInfo.getClassInfo(getClass());
                    $staticClassInfo = classInfo;
                }
                return classInfo.getMetaClass();
            }

            public Object call(CopySpec copySpec) {
                return doCall(copySpec);
            }

            public Object doCall(CopySpec copySpec) {
                return copySpec.include(new String[]{"**/*.proto"});
            }
        }

        public Object doCall(Object obj) {
            return ((ProcessResources) obj).from(((ProtoSourceSet) this.protoSourceSet.get()).getProto(), new _closure26(this, getThisObject()));
        }
    }

    /* INFO: compiled from: ProtobufPlugin.groovy */
    public final class _addTasksForSourceSet_closure13 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;
        private /* synthetic */ Reference extractIncludeProtosTask;
        private /* synthetic */ Reference extractProtosTask;
        private /* synthetic */ Reference generateProtoTask;
        private /* synthetic */ Reference protoSourceSet;
        private /* synthetic */ Reference sourceSet;

        public _addTasksForSourceSet_closure13(Object obj, Object obj2, Reference reference, Reference reference2, Reference reference3, Reference reference4, Reference reference5) {
            super(obj, obj2);
            this.generateProtoTask = reference;
            this.sourceSet = reference2;
            this.protoSourceSet = reference3;
            this.extractProtosTask = reference4;
            this.extractIncludeProtosTask = reference5;
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _addTasksForSourceSet_closure13.class) {
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

        @Generated
        public Provider getExtractIncludeProtosTask() {
            return (Provider) ScriptBytecodeAdapter.castToType(this.extractIncludeProtosTask.get(), Provider.class);
        }

        @Generated
        public Provider getExtractProtosTask() {
            return (Provider) ScriptBytecodeAdapter.castToType(this.extractProtosTask.get(), Provider.class);
        }

        @Generated
        public Provider getGenerateProtoTask() {
            return (Provider) ScriptBytecodeAdapter.castToType(this.generateProtoTask.get(), Provider.class);
        }

        @Generated
        public ProtoSourceSet getProtoSourceSet() {
            return (ProtoSourceSet) ScriptBytecodeAdapter.castToType(this.protoSourceSet.get(), ProtoSourceSet.class);
        }

        @Generated
        public SourceSet getSourceSet() {
            return (SourceSet) ScriptBytecodeAdapter.castToType(this.sourceSet.get(), SourceSet.class);
        }

        public Object doCall(Object obj) {
            ((ProtobufPlugin) getThisObject()).project.getPlugins().withId("eclipse", (Action) ScriptBytecodeAdapter.castToType(new _closure27(this, getThisObject(), this.generateProtoTask), Action.class));
            ((ProtobufPlugin) getThisObject()).project.getPlugins().withId("idea", (Action) ScriptBytecodeAdapter.castToType(new _closure28(this, getThisObject(), this.sourceSet, this.protoSourceSet, this.extractProtosTask, this.extractIncludeProtosTask, this.generateProtoTask), Action.class));
            return null;
        }

        /* INFO: compiled from: ProtobufPlugin.groovy */
        public final class _closure27 extends Closure implements GeneratedClosure {
            private static /* synthetic */ ClassInfo $staticClassInfo;
            public static transient /* synthetic */ boolean __$stMC;
            private /* synthetic */ Reference generateProtoTask;

            public _closure27(Object obj, Object obj2, Reference reference) {
                super(obj, obj2);
                this.generateProtoTask = reference;
            }

            protected /* synthetic */ MetaClass $getStaticMetaClass() {
                if (getClass() != _closure27.class) {
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

            @Generated
            public Provider getGenerateProtoTask() {
                return (Provider) ScriptBytecodeAdapter.castToType(this.generateProtoTask.get(), Provider.class);
            }

            /* INFO: compiled from: ProtobufPlugin.groovy */
            public final class _closure29 extends Closure implements GeneratedClosure {
                private static /* synthetic */ ClassInfo $staticClassInfo;
                public static transient /* synthetic */ boolean __$stMC;

                public _closure29(Object obj, Object obj2) {
                    super(obj, obj2);
                }

                protected /* synthetic */ MetaClass $getStaticMetaClass() {
                    if (getClass() != _closure29.class) {
                        return ScriptBytecodeAdapter.initMetaClass(this);
                    }
                    ClassInfo classInfo = $staticClassInfo;
                    if (classInfo == null) {
                        classInfo = ClassInfo.getClassInfo(getClass());
                        $staticClassInfo = classInfo;
                    }
                    return classInfo.getMetaClass();
                }

                public Object call(File file) {
                    return doCall(file);
                }

                public Object doCall(File file) {
                    return Boolean.valueOf(file.mkdirs());
                }
            }

            public Object doCall(Object obj) {
                return DefaultGroovyMethods.each((Collection) ScriptBytecodeAdapter.castToType(InvokerHelper.invokeMethodSafe(((Provider) this.generateProtoTask.get()).get(), "getOutputSourceDirectories", new Object[0]), Collection.class), new _closure29(this, getThisObject()));
            }
        }

        /* INFO: compiled from: ProtobufPlugin.groovy */
        public final class _closure28 extends Closure implements GeneratedClosure {
            private static /* synthetic */ ClassInfo $staticClassInfo;
            public static transient /* synthetic */ boolean __$stMC;
            private /* synthetic */ Reference extractIncludeProtosTask;
            private /* synthetic */ Reference extractProtosTask;
            private /* synthetic */ Reference generateProtoTask;
            private /* synthetic */ Reference protoSourceSet;
            private /* synthetic */ Reference sourceSet;

            public _closure28(Object obj, Object obj2, Reference reference, Reference reference2, Reference reference3, Reference reference4, Reference reference5) {
                super(obj, obj2);
                this.sourceSet = reference;
                this.protoSourceSet = reference2;
                this.extractProtosTask = reference3;
                this.extractIncludeProtosTask = reference4;
                this.generateProtoTask = reference5;
            }

            protected /* synthetic */ MetaClass $getStaticMetaClass() {
                if (getClass() != _closure28.class) {
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

            @Generated
            public Provider getExtractIncludeProtosTask() {
                return (Provider) ScriptBytecodeAdapter.castToType(this.extractIncludeProtosTask.get(), Provider.class);
            }

            @Generated
            public Provider getExtractProtosTask() {
                return (Provider) ScriptBytecodeAdapter.castToType(this.extractProtosTask.get(), Provider.class);
            }

            @Generated
            public Provider getGenerateProtoTask() {
                return (Provider) ScriptBytecodeAdapter.castToType(this.generateProtoTask.get(), Provider.class);
            }

            @Generated
            public ProtoSourceSet getProtoSourceSet() {
                return (ProtoSourceSet) ScriptBytecodeAdapter.castToType(this.protoSourceSet.get(), ProtoSourceSet.class);
            }

            @Generated
            public SourceSet getSourceSet() {
                return (SourceSet) ScriptBytecodeAdapter.castToType(this.sourceSet.get(), SourceSet.class);
            }

            public Object doCall(Object obj) {
                Reference reference = new Reference(Boolean.valueOf(Utils.isTest(((SourceSet) this.sourceSet.get()).getName())));
                DefaultGroovyMethods.each(((ProtoSourceSet) this.protoSourceSet.get()).getProto().getSrcDirs(), new _closure30(this, getThisObject(), reference));
                Utils.addToIdeSources(((ProtobufPlugin) getThisObject()).project, DefaultTypeTransformation.booleanUnbox((Boolean) reference.get()), ((ProtobufPlugin) getThisObject()).project.files(new Object[]{this.extractProtosTask.get()}).getSingleFile(), true);
                Utils.addToIdeSources(((ProtobufPlugin) getThisObject()).project, DefaultTypeTransformation.booleanUnbox((Boolean) reference.get()), ((ProtobufPlugin) getThisObject()).project.files(new Object[]{this.extractIncludeProtosTask.get()}).getSingleFile(), true);
                return DefaultGroovyMethods.each((Collection) ScriptBytecodeAdapter.castToType(InvokerHelper.invokeMethodSafe(((Provider) this.generateProtoTask.get()).get(), "getOutputSourceDirectories", new Object[0]), Collection.class), new _closure31(this, getThisObject(), reference));
            }

            /* INFO: compiled from: ProtobufPlugin.groovy */
            public final class _closure30 extends Closure implements GeneratedClosure {
                private static /* synthetic */ ClassInfo $staticClassInfo;
                public static transient /* synthetic */ boolean __$stMC;
                private /* synthetic */ Reference isTest;

                public _closure30(Object obj, Object obj2, Reference reference) {
                    super(obj, obj2);
                    this.isTest = reference;
                }

                protected /* synthetic */ MetaClass $getStaticMetaClass() {
                    if (getClass() != _closure30.class) {
                        return ScriptBytecodeAdapter.initMetaClass(this);
                    }
                    ClassInfo classInfo = $staticClassInfo;
                    if (classInfo == null) {
                        classInfo = ClassInfo.getClassInfo(getClass());
                        $staticClassInfo = classInfo;
                    }
                    return classInfo.getMetaClass();
                }

                public Object call(File file) {
                    return doCall(file);
                }

                @Generated
                public Boolean getIsTest() {
                    return (Boolean) ScriptBytecodeAdapter.castToType(this.isTest.get(), Boolean.class);
                }

                public Object doCall(File file) {
                    Utils.addToIdeSources(((ProtobufPlugin) getThisObject()).project, DefaultTypeTransformation.booleanUnbox(this.isTest.get()), file, false);
                    return null;
                }
            }

            /* INFO: compiled from: ProtobufPlugin.groovy */
            public final class _closure31 extends Closure implements GeneratedClosure {
                private static /* synthetic */ ClassInfo $staticClassInfo;
                public static transient /* synthetic */ boolean __$stMC;
                private /* synthetic */ Reference isTest;

                public _closure31(Object obj, Object obj2, Reference reference) {
                    super(obj, obj2);
                    this.isTest = reference;
                }

                protected /* synthetic */ MetaClass $getStaticMetaClass() {
                    if (getClass() != _closure31.class) {
                        return ScriptBytecodeAdapter.initMetaClass(this);
                    }
                    ClassInfo classInfo = $staticClassInfo;
                    if (classInfo == null) {
                        classInfo = ClassInfo.getClassInfo(getClass());
                        $staticClassInfo = classInfo;
                    }
                    return classInfo.getMetaClass();
                }

                public Object call(File file) {
                    return doCall(file);
                }

                @Generated
                public Boolean getIsTest() {
                    return (Boolean) ScriptBytecodeAdapter.castToType(this.isTest.get(), Boolean.class);
                }

                public Object doCall(File file) {
                    Utils.addToIdeSources(((ProtobufPlugin) getThisObject()).project, DefaultTypeTransformation.booleanUnbox(this.isTest.get()), file, true);
                    return null;
                }
            }
        }
    }

    private void addTasksForVariant(Object obj, NamedDomainObjectContainer<ProtoSourceSet> namedDomainObjectContainer, Collection<Closure> collection) {
        ProtobufPlugin protobufPlugin;
        Reference reference = new Reference(obj);
        Reference reference2 = new Reference(namedDomainObjectContainer);
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        Reference reference3 = new Reference(Boolean.valueOf((reference.get() instanceof TestVariant) || (reference.get() instanceof UnitTestVariant)));
        Reference reference4 = new Reference((ProtoSourceSet) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[16].call((NamedDomainObjectContainer) reference2.get(), callSiteArr$getCallSiteArray[17].callGetProperty(reference.get())), ProtoSourceSet.class));
        FileCollection fileCollection = (FileCollection) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[18].callGetProperty(callSiteArr$getCallSiteArray[19].call(callSiteArr$getCallSiteArray[20].callGetProperty(callSiteArr$getCallSiteArray[21].callGetProperty(reference.get())), new _addTasksForVariant_closure14(this, this))), FileCollection.class);
        if ((reference.get() instanceof TestVariant) || (reference.get() instanceof UnitTestVariant)) {
            CallSite callSite = callSiteArr$getCallSiteArray[22];
            protobufPlugin = this;
            _addTasksForVariant_closure15 _addtasksforvariant_closure15 = new _addTasksForVariant_closure15(protobufPlugin, this, reference4, reference2, reference);
            reference4 = reference4;
            reference = reference;
            callSite.call(collection, _addtasksforvariant_closure15);
        } else {
            protobufPlugin = this;
        }
        callSiteArr$getCallSiteArray[23].callCurrent(this, (ProtoSourceSet) reference4.get(), fileCollection);
        callSiteArr$getCallSiteArray[24].call(callSiteArr$getCallSiteArray[25].callGetProperty(reference.get()), new _addTasksForVariant_closure16(this, this, reference4));
        Reference reference5 = new Reference((Provider) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[26].callCurrent(this, (ProtoSourceSet) reference4.get(), new _addTasksForVariant_closure17(this, this, reference, reference3)), Provider.class));
        if (DefaultTypeTransformation.booleanUnbox(callSiteArr$getCallSiteArray[27].call(callSiteArr$getCallSiteArray[28].callGetProperty(protobufPlugin.project), "libraryVariants"))) {
            callSiteArr$getCallSiteArray[29].call(callSiteArr$getCallSiteArray[30].call(reference.get()), new _addTasksForVariant_closure18(this, this, reference4));
        }
        callSiteArr$getCallSiteArray[31].call(collection, new _addTasksForVariant_closure19(protobufPlugin, this, reference, reference5, reference4));
    }

    /* INFO: compiled from: ProtobufPlugin.groovy */
    public final class _addTasksForVariant_closure14 extends Closure implements GeneratedClosure {
        private static /* synthetic */ SoftReference $callSiteArray;
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;

        private static /* synthetic */ CallSiteArray $createCallSiteArray() {
            String[] strArr = new String[4];
            $createCallSiteArray_1(strArr);
            return new CallSiteArray(_addTasksForVariant_closure14.class, strArr);
        }

        private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
            strArr[0] = "attribute";
            strArr[1] = "attributes";
            strArr[2] = "ARTIFACT_FORMAT";
            strArr[3] = "JAR_TYPE";
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

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        public _addTasksForVariant_closure14(Object obj, Object obj2) {
            super(obj, obj2);
            $getCallSiteArray();
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _addTasksForVariant_closure14.class) {
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
        public Object doCall() {
            $getCallSiteArray();
            return doCall(null);
        }

        public Object doCall(Object obj) {
            CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
            return callSiteArr$getCallSiteArray[0].call(callSiteArr$getCallSiteArray[1].callGroovyObjectGetProperty(this), callSiteArr$getCallSiteArray[2].callGetProperty(ArtifactAttributes.class), callSiteArr$getCallSiteArray[3].callGetProperty(ArtifactTypeDefinition.class));
        }
    }

    /* INFO: compiled from: ProtobufPlugin.groovy */
    public final class _addTasksForVariant_closure15 extends Closure implements GeneratedClosure {
        private static /* synthetic */ SoftReference $callSiteArray;
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;
        private /* synthetic */ Reference variant;
        private /* synthetic */ Reference variantSourceSet;
        private /* synthetic */ Reference variantSourceSets;

        private static /* synthetic */ CallSiteArray $createCallSiteArray() {
            String[] strArr = new String[8];
            $createCallSiteArray_1(strArr);
            return new CallSiteArray(_addTasksForVariant_closure15.class, strArr);
        }

        private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
            strArr[0] = "includesFrom";
            strArr[1] = "getByName";
            strArr[2] = "sourceSets";
            strArr[3] = "protobufExtension";
            strArr[4] = "includesFrom";
            strArr[5] = "getByName";
            strArr[6] = "name";
            strArr[7] = "testedVariant";
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

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        public _addTasksForVariant_closure15(Object obj, Object obj2, Reference reference, Reference reference2, Reference reference3) {
            super(obj, obj2);
            $getCallSiteArray();
            this.variantSourceSet = reference;
            this.variantSourceSets = reference2;
            this.variant = reference3;
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _addTasksForVariant_closure15.class) {
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
        public Object doCall() {
            $getCallSiteArray();
            return doCall(null);
        }

        @Generated
        public Object getVariant() {
            $getCallSiteArray();
            return this.variant.get();
        }

        @Generated
        public ProtoSourceSet getVariantSourceSet() {
            $getCallSiteArray();
            return (ProtoSourceSet) ScriptBytecodeAdapter.castToType(this.variantSourceSet.get(), ProtoSourceSet.class);
        }

        @Generated
        public NamedDomainObjectContainer getVariantSourceSets() {
            $getCallSiteArray();
            return (NamedDomainObjectContainer) ScriptBytecodeAdapter.castToType(this.variantSourceSets.get(), NamedDomainObjectContainer.class);
        }

        public Object doCall(Object obj) {
            CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
            callSiteArr$getCallSiteArray[0].call(this.variantSourceSet.get(), callSiteArr$getCallSiteArray[1].call(callSiteArr$getCallSiteArray[2].callGroovyObjectGetProperty(callSiteArr$getCallSiteArray[3].callGroovyObjectGetProperty(this)), "main"));
            return callSiteArr$getCallSiteArray[4].call(this.variantSourceSet.get(), callSiteArr$getCallSiteArray[5].call(this.variantSourceSets.get(), callSiteArr$getCallSiteArray[6].callGetProperty(callSiteArr$getCallSiteArray[7].callGetProperty(this.variant.get()))));
        }
    }

    /* INFO: compiled from: ProtobufPlugin.groovy */
    public final class _addTasksForVariant_closure16 extends Closure implements GeneratedClosure {
        private static /* synthetic */ SoftReference $callSiteArray;
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;
        private /* synthetic */ Reference variantSourceSet;

        private static /* synthetic */ CallSiteArray $createCallSiteArray() {
            String[] strArr = new String[6];
            $createCallSiteArray_1(strArr);
            return new CallSiteArray(_addTasksForVariant_closure16.class, strArr);
        }

        private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
            strArr[0] = "extendsFrom";
            strArr[1] = "getByName";
            strArr[2] = "sourceSets";
            strArr[3] = "protobufExtension";
            strArr[4] = "name";
            strArr[5] = "doCall";
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

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        public _addTasksForVariant_closure16(Object obj, Object obj2, Reference reference) {
            super(obj, obj2);
            $getCallSiteArray();
            this.variantSourceSet = reference;
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _addTasksForVariant_closure16.class) {
                return ScriptBytecodeAdapter.initMetaClass(this);
            }
            ClassInfo classInfo = $staticClassInfo;
            if (classInfo == null) {
                classInfo = ClassInfo.getClassInfo(getClass());
                $staticClassInfo = classInfo;
            }
            return classInfo.getMetaClass();
        }

        public Object call(SourceProvider sourceProvider) {
            return $getCallSiteArray()[5].callCurrent(this, sourceProvider);
        }

        @Generated
        public ProtoSourceSet getVariantSourceSet() {
            $getCallSiteArray();
            return (ProtoSourceSet) ScriptBytecodeAdapter.castToType(this.variantSourceSet.get(), ProtoSourceSet.class);
        }

        public Object doCall(SourceProvider sourceProvider) {
            CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
            return callSiteArr$getCallSiteArray[0].call(this.variantSourceSet.get(), callSiteArr$getCallSiteArray[1].call(callSiteArr$getCallSiteArray[2].callGroovyObjectGetProperty(callSiteArr$getCallSiteArray[3].callGroovyObjectGetProperty(this)), callSiteArr$getCallSiteArray[4].callGetProperty(sourceProvider)));
        }
    }

    /* INFO: compiled from: ProtobufPlugin.groovy */
    public final class _addTasksForVariant_closure17 extends Closure implements GeneratedClosure {
        private static /* synthetic */ SoftReference $callSiteArray;
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;
        private /* synthetic */ Reference isTestVariant;
        private /* synthetic */ Reference variant;

        private static /* synthetic */ CallSiteArray $createCallSiteArray() {
            String[] strArr = new String[7];
            $createCallSiteArray_1(strArr);
            return new CallSiteArray(_addTasksForVariant_closure17.class, strArr);
        }

        private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
            strArr[0] = "setVariant";
            strArr[1] = "collect";
            strArr[2] = "productFlavors";
            strArr[3] = "hasProperty";
            strArr[4] = "name";
            strArr[5] = "buildType";
            strArr[6] = "doneInitializing";
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

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        public _addTasksForVariant_closure17(Object obj, Object obj2, Reference reference, Reference reference2) {
            super(obj, obj2);
            $getCallSiteArray();
            this.variant = reference;
            this.isTestVariant = reference2;
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _addTasksForVariant_closure17.class) {
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
        public Object doCall() {
            $getCallSiteArray();
            return doCall(null);
        }

        @Generated
        public Boolean getIsTestVariant() {
            $getCallSiteArray();
            return (Boolean) ScriptBytecodeAdapter.castToType(this.isTestVariant.get(), Boolean.class);
        }

        @Generated
        public Object getVariant() {
            $getCallSiteArray();
            return this.variant.get();
        }

        /* INFO: compiled from: ProtobufPlugin.groovy */
        public final class _closure32 extends Closure implements GeneratedClosure {
            private static /* synthetic */ SoftReference $callSiteArray;
            private static /* synthetic */ ClassInfo $staticClassInfo;
            public static transient /* synthetic */ boolean __$stMC;

            private static /* synthetic */ CallSiteArray $createCallSiteArray() {
                String[] strArr = new String[1];
                $createCallSiteArray_1(strArr);
                return new CallSiteArray(_closure32.class, strArr);
            }

            private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
                strArr[0] = "name";
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

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            public _closure32(Object obj, Object obj2) {
                super(obj, obj2);
                $getCallSiteArray();
            }

            protected /* synthetic */ MetaClass $getStaticMetaClass() {
                if (getClass() != _closure32.class) {
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
            public Object doCall() {
                $getCallSiteArray();
                return doCall(null);
            }

            public Object doCall(Object obj) {
                return $getCallSiteArray()[0].callGetProperty(obj);
            }
        }

        public Object doCall(Object obj) {
            CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
            callSiteArr$getCallSiteArray[0].call(obj, this.variant.get(), this.isTestVariant.get());
            ScriptBytecodeAdapter.setProperty(callSiteArr$getCallSiteArray[1].call(callSiteArr$getCallSiteArray[2].callGetProperty(this.variant.get()), new _closure32(this, getThisObject())), (Class) null, obj, "flavors");
            if (DefaultTypeTransformation.booleanUnbox(callSiteArr$getCallSiteArray[3].call(this.variant.get(), "buildType"))) {
                ScriptBytecodeAdapter.setProperty(callSiteArr$getCallSiteArray[4].callGetProperty(callSiteArr$getCallSiteArray[5].callGetProperty(this.variant.get())), (Class) null, obj, "buildType");
            }
            return callSiteArr$getCallSiteArray[6].call(obj);
        }
    }

    /* INFO: compiled from: ProtobufPlugin.groovy */
    public final class _addTasksForVariant_closure18 extends Closure implements GeneratedClosure {
        private static /* synthetic */ SoftReference $callSiteArray;
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;
        private /* synthetic */ Reference variantSourceSet;

        private static /* synthetic */ CallSiteArray $createCallSiteArray() {
            String[] strArr = new String[2];
            $createCallSiteArray_1(strArr);
            return new CallSiteArray(_addTasksForVariant_closure18.class, strArr);
        }

        private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
            strArr[0] = TypedValues.TransitionType.S_FROM;
            strArr[1] = "proto";
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

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        public _addTasksForVariant_closure18(Object obj, Object obj2, Reference reference) {
            super(obj, obj2);
            $getCallSiteArray();
            this.variantSourceSet = reference;
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _addTasksForVariant_closure18.class) {
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
        public Object doCall() {
            $getCallSiteArray();
            return doCall(null);
        }

        @Generated
        public ProtoSourceSet getVariantSourceSet() {
            $getCallSiteArray();
            return (ProtoSourceSet) ScriptBytecodeAdapter.castToType(this.variantSourceSet.get(), ProtoSourceSet.class);
        }

        /* INFO: compiled from: ProtobufPlugin.groovy */
        public final class _closure33 extends Closure implements GeneratedClosure {
            private static /* synthetic */ SoftReference $callSiteArray;
            private static /* synthetic */ ClassInfo $staticClassInfo;
            public static transient /* synthetic */ boolean __$stMC;

            private static /* synthetic */ CallSiteArray $createCallSiteArray() {
                String[] strArr = new String[1];
                $createCallSiteArray_1(strArr);
                return new CallSiteArray(_closure33.class, strArr);
            }

            private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
                strArr[0] = "include";
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

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            public _closure33(Object obj, Object obj2) {
                super(obj, obj2);
                $getCallSiteArray();
            }

            protected /* synthetic */ MetaClass $getStaticMetaClass() {
                if (getClass() != _closure33.class) {
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
            public Object doCall() {
                $getCallSiteArray();
                return doCall(null);
            }

            public Object doCall(Object obj) {
                return $getCallSiteArray()[0].callCurrent(this, "**/*.proto");
            }
        }

        public Object doCall(Object obj) {
            CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
            return callSiteArr$getCallSiteArray[0].call(obj, callSiteArr$getCallSiteArray[1].callGetProperty(this.variantSourceSet.get()), new _closure33(this, getThisObject()));
        }
    }

    /* INFO: compiled from: ProtobufPlugin.groovy */
    public final class _addTasksForVariant_closure19 extends Closure implements GeneratedClosure {
        private static /* synthetic */ SoftReference $callSiteArray;
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;
        private /* synthetic */ Reference generateProtoTask;
        private /* synthetic */ Reference variant;
        private /* synthetic */ Reference variantSourceSet;

        private static /* synthetic */ CallSiteArray $createCallSiteArray() {
            String[] strArr = new String[7];
            $createCallSiteArray_1(strArr);
            return new CallSiteArray(_addTasksForVariant_closure19.class, strArr);
        }

        private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
            strArr[0] = "registerJavaGeneratingTask";
            strArr[1] = "get";
            strArr[2] = "outputSourceDirectories";
            strArr[3] = "get";
            strArr[4] = "withId";
            strArr[5] = "plugins";
            strArr[6] = "project";
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

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        public _addTasksForVariant_closure19(Object obj, Object obj2, Reference reference, Reference reference2, Reference reference3) {
            super(obj, obj2);
            $getCallSiteArray();
            this.variant = reference;
            this.generateProtoTask = reference2;
            this.variantSourceSet = reference3;
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _addTasksForVariant_closure19.class) {
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
        public Object doCall() {
            $getCallSiteArray();
            return doCall(null);
        }

        @Generated
        public Provider getGenerateProtoTask() {
            $getCallSiteArray();
            return (Provider) ScriptBytecodeAdapter.castToType(this.generateProtoTask.get(), Provider.class);
        }

        @Generated
        public Object getVariant() {
            $getCallSiteArray();
            return this.variant.get();
        }

        @Generated
        public ProtoSourceSet getVariantSourceSet() {
            $getCallSiteArray();
            return (ProtoSourceSet) ScriptBytecodeAdapter.castToType(this.variantSourceSet.get(), ProtoSourceSet.class);
        }

        public Object doCall(Object obj) {
            CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
            callSiteArr$getCallSiteArray[0].call(this.variant.get(), callSiteArr$getCallSiteArray[1].call(this.generateProtoTask.get()), callSiteArr$getCallSiteArray[2].callGetProperty(callSiteArr$getCallSiteArray[3].call(this.generateProtoTask.get())));
            return callSiteArr$getCallSiteArray[4].call(callSiteArr$getCallSiteArray[5].callGetProperty(callSiteArr$getCallSiteArray[6].callGroovyObjectGetProperty(this)), "org.jetbrains.kotlin.android", new _closure34(this, getThisObject(), this.variant, this.variantSourceSet, this.generateProtoTask));
        }

        /* INFO: compiled from: ProtobufPlugin.groovy */
        public final class _closure34 extends Closure implements GeneratedClosure {
            private static /* synthetic */ SoftReference $callSiteArray;
            private static /* synthetic */ ClassInfo $staticClassInfo;
            public static transient /* synthetic */ boolean __$stMC;
            private /* synthetic */ Reference generateProtoTask;
            private /* synthetic */ Reference variant;
            private /* synthetic */ Reference variantSourceSet;

            private static /* synthetic */ CallSiteArray $createCallSiteArray() {
                String[] strArr = new String[10];
                $createCallSiteArray_1(strArr);
                return new CallSiteArray(_closure34.class, strArr);
            }

            private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
                strArr[0] = "respondsTo";
                strArr[1] = "getByType";
                strArr[2] = ConfigConstants.CONFIG_EXTENSIONS_SECTION;
                strArr[3] = "project";
                strArr[4] = "named";
                strArr[5] = "compilations";
                strArr[6] = TypedValues.AttributesType.S_TARGET;
                strArr[7] = "name";
                strArr[8] = "afterEvaluate";
                strArr[9] = "project";
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

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            public _closure34(Object obj, Object obj2, Reference reference, Reference reference2, Reference reference3) {
                super(obj, obj2);
                $getCallSiteArray();
                this.variant = reference;
                this.variantSourceSet = reference2;
                this.generateProtoTask = reference3;
            }

            protected /* synthetic */ MetaClass $getStaticMetaClass() {
                if (getClass() != _closure34.class) {
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
            public Object doCall() {
                $getCallSiteArray();
                return doCall(null);
            }

            @Generated
            public Provider getGenerateProtoTask() {
                $getCallSiteArray();
                return (Provider) ScriptBytecodeAdapter.castToType(this.generateProtoTask.get(), Provider.class);
            }

            @Generated
            public Object getVariant() {
                $getCallSiteArray();
                return this.variant.get();
            }

            @Generated
            public ProtoSourceSet getVariantSourceSet() {
                $getCallSiteArray();
                return (ProtoSourceSet) ScriptBytecodeAdapter.castToType(this.variantSourceSet.get(), ProtoSourceSet.class);
            }

            public Object doCall(Object obj) {
                CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
                if (DefaultTypeTransformation.booleanUnbox(callSiteArr$getCallSiteArray[0].call(obj, "getPluginVersion"))) {
                    return callSiteArr$getCallSiteArray[4].call(callSiteArr$getCallSiteArray[5].callGetProperty(callSiteArr$getCallSiteArray[6].callGetProperty((KotlinAndroidProjectExtension) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[1].call(callSiteArr$getCallSiteArray[2].callGetProperty(callSiteArr$getCallSiteArray[3].callGroovyObjectGetProperty(this)), KotlinAndroidProjectExtension.class), KotlinAndroidProjectExtension.class))), callSiteArr$getCallSiteArray[7].callGetProperty(this.variant.get()), new _closure35(this, getThisObject(), this.variantSourceSet));
                }
                return callSiteArr$getCallSiteArray[8].call(callSiteArr$getCallSiteArray[9].callGroovyObjectGetProperty(this), new _closure36(this, getThisObject(), this.variant, this.generateProtoTask));
            }

            /* INFO: compiled from: ProtobufPlugin.groovy */
            public final class _closure35 extends Closure implements GeneratedClosure {
                private static /* synthetic */ SoftReference $callSiteArray;
                private static /* synthetic */ ClassInfo $staticClassInfo;
                public static transient /* synthetic */ boolean __$stMC;
                private /* synthetic */ Reference variantSourceSet;

                private static /* synthetic */ CallSiteArray $createCallSiteArray() {
                    String[] strArr = new String[4];
                    $createCallSiteArray_1(strArr);
                    return new CallSiteArray(_closure35.class, strArr);
                }

                private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
                    strArr[0] = "srcDirs";
                    strArr[1] = "kotlin";
                    strArr[2] = "defaultSourceSet";
                    strArr[3] = "output";
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

                /* WARN: 'super' call moved to the top of the method (can break code semantics) */
                public _closure35(Object obj, Object obj2, Reference reference) {
                    super(obj, obj2);
                    $getCallSiteArray();
                    this.variantSourceSet = reference;
                }

                protected /* synthetic */ MetaClass $getStaticMetaClass() {
                    if (getClass() != _closure35.class) {
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
                public Object doCall() {
                    $getCallSiteArray();
                    return doCall(null);
                }

                @Generated
                public ProtoSourceSet getVariantSourceSet() {
                    $getCallSiteArray();
                    return (ProtoSourceSet) ScriptBytecodeAdapter.castToType(this.variantSourceSet.get(), ProtoSourceSet.class);
                }

                public Object doCall(Object obj) {
                    CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
                    return callSiteArr$getCallSiteArray[0].call(callSiteArr$getCallSiteArray[1].callGetProperty(callSiteArr$getCallSiteArray[2].callGetProperty(obj)), callSiteArr$getCallSiteArray[3].callGetProperty(this.variantSourceSet.get()));
                }
            }

            /* INFO: compiled from: ProtobufPlugin.groovy */
            public final class _closure36 extends Closure implements GeneratedClosure {
                private static /* synthetic */ SoftReference $callSiteArray;
                private static /* synthetic */ ClassInfo $staticClassInfo;
                public static transient /* synthetic */ boolean __$stMC;
                private /* synthetic */ Reference generateProtoTask;
                private /* synthetic */ Reference variant;

                private static /* synthetic */ CallSiteArray $createCallSiteArray() {
                    String[] strArr = new String[6];
                    $createCallSiteArray_1(strArr);
                    return new CallSiteArray(_closure36.class, strArr);
                }

                private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
                    strArr[0] = "getKotlinAndroidCompileTaskName";
                    strArr[1] = "project";
                    strArr[2] = "name";
                    strArr[3] = "named";
                    strArr[4] = "tasks";
                    strArr[5] = "project";
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

                /* WARN: 'super' call moved to the top of the method (can break code semantics) */
                public _closure36(Object obj, Object obj2, Reference reference, Reference reference2) {
                    super(obj, obj2);
                    $getCallSiteArray();
                    this.variant = reference;
                    this.generateProtoTask = reference2;
                }

                protected /* synthetic */ MetaClass $getStaticMetaClass() {
                    if (getClass() != _closure36.class) {
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
                public Object doCall() {
                    $getCallSiteArray();
                    return doCall(null);
                }

                @Generated
                public Provider getGenerateProtoTask() {
                    $getCallSiteArray();
                    return (Provider) ScriptBytecodeAdapter.castToType(this.generateProtoTask.get(), Provider.class);
                }

                @Generated
                public Object getVariant() {
                    $getCallSiteArray();
                    return this.variant.get();
                }

                public Object doCall(Object obj) {
                    CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
                    return callSiteArr$getCallSiteArray[3].call(callSiteArr$getCallSiteArray[4].callGetProperty(callSiteArr$getCallSiteArray[5].callGroovyObjectGetProperty(this)), ShortTypeHandling.castToString(callSiteArr$getCallSiteArray[0].call(Utils.class, callSiteArr$getCallSiteArray[1].callGroovyObjectGetProperty(this), callSiteArr$getCallSiteArray[2].callGetProperty(this.variant.get()))), KotlinCompile.class, new _closure37(this, getThisObject(), this.generateProtoTask));
                }

                /* INFO: compiled from: ProtobufPlugin.groovy */
                public final class _closure37 extends Closure implements GeneratedClosure {
                    private static /* synthetic */ SoftReference $callSiteArray;
                    private static /* synthetic */ ClassInfo $staticClassInfo;
                    public static transient /* synthetic */ boolean __$stMC;
                    private /* synthetic */ Reference generateProtoTask;

                    private static /* synthetic */ CallSiteArray $createCallSiteArray() {
                        String[] strArr = new String[5];
                        $createCallSiteArray_1(strArr);
                        return new CallSiteArray(_closure37.class, strArr);
                    }

                    private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
                        strArr[0] = "dependsOn";
                        strArr[1] = "source";
                        strArr[2] = "outputSourceDirectories";
                        strArr[3] = "get";
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

                    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public _closure37(Object obj, Object obj2, Reference reference) {
                        super(obj, obj2);
                        $getCallSiteArray();
                        this.generateProtoTask = reference;
                    }

                    protected /* synthetic */ MetaClass $getStaticMetaClass() {
                        if (getClass() != _closure37.class) {
                            return ScriptBytecodeAdapter.initMetaClass(this);
                        }
                        ClassInfo classInfo = $staticClassInfo;
                        if (classInfo == null) {
                            classInfo = ClassInfo.getClassInfo(getClass());
                            $staticClassInfo = classInfo;
                        }
                        return classInfo.getMetaClass();
                    }

                    public Object call(KotlinCompile kotlinCompile) {
                        return $getCallSiteArray()[4].callCurrent(this, kotlinCompile);
                    }

                    @Generated
                    public Provider getGenerateProtoTask() {
                        $getCallSiteArray();
                        return (Provider) ScriptBytecodeAdapter.castToType(this.generateProtoTask.get(), Provider.class);
                    }

                    public Object doCall(KotlinCompile kotlinCompile) {
                        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
                        callSiteArr$getCallSiteArray[0].call(kotlinCompile, this.generateProtoTask.get());
                        return callSiteArr$getCallSiteArray[1].call(kotlinCompile, callSiteArr$getCallSiteArray[2].callGetProperty(callSiteArr$getCallSiteArray[3].call(this.generateProtoTask.get())));
                    }
                }
            }
        }
    }

    private Provider<GenerateProtoTask> addGenerateProtoTask(ProtoSourceSet protoSourceSet, Action<GenerateProtoTask> action) {
        Reference reference = new Reference(protoSourceSet);
        Reference reference2 = new Reference(action);
        Reference reference3 = new Reference(((ProtoSourceSet) reference.get()).getName());
        TaskProvider taskProviderRegister = this.project.getTasks().register(StringGroovyMethods.plus(StringGroovyMethods.plus("generate", Utils.getSourceSetSubstringForTaskNames((String) reference3.get())), "Proto"), GenerateProtoTask.class, (Action) ScriptBytecodeAdapter.castToType(new _addGenerateProtoTask_closure20(this, this, reference3, new Reference(this.protobufExtension.defaultGeneratedFilesBaseDir), reference, new Reference(this.protobufExtension.getGeneratedFilesBaseDirProperty()), reference2), Action.class));
        ((ProtoSourceSet) reference.get()).getOutput().from(new Object[]{taskProviderRegister.map((Transformer) ScriptBytecodeAdapter.castToType(new _addGenerateProtoTask_closure21(this, this), Transformer.class))});
        return taskProviderRegister;
    }

    /* INFO: compiled from: ProtobufPlugin.groovy */
    public final class _addGenerateProtoTask_closure20 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;
        private /* synthetic */ Reference configureAction;
        private /* synthetic */ Reference defaultGeneratedFilesBaseDir;
        private /* synthetic */ Reference generatedFilesBaseDirProvider;
        private /* synthetic */ Reference protoSourceSet;
        private /* synthetic */ Reference sourceSetName;

        public _addGenerateProtoTask_closure20(Object obj, Object obj2, Reference reference, Reference reference2, Reference reference3, Reference reference4, Reference reference5) {
            super(obj, obj2);
            this.sourceSetName = reference;
            this.defaultGeneratedFilesBaseDir = reference2;
            this.protoSourceSet = reference3;
            this.generatedFilesBaseDirProvider = reference4;
            this.configureAction = reference5;
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _addGenerateProtoTask_closure20.class) {
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

        @Generated
        public Action getConfigureAction() {
            return (Action) ScriptBytecodeAdapter.castToType(this.configureAction.get(), Action.class);
        }

        @Generated
        public Provider getDefaultGeneratedFilesBaseDir() {
            return (Provider) ScriptBytecodeAdapter.castToType(this.defaultGeneratedFilesBaseDir.get(), Provider.class);
        }

        @Generated
        public Provider getGeneratedFilesBaseDirProvider() {
            return (Provider) ScriptBytecodeAdapter.castToType(this.generatedFilesBaseDirProvider.get(), Provider.class);
        }

        @Generated
        public ProtoSourceSet getProtoSourceSet() {
            return (ProtoSourceSet) ScriptBytecodeAdapter.castToType(this.protoSourceSet.get(), ProtoSourceSet.class);
        }

        @Generated
        public String getSourceSetName() {
            return ShortTypeHandling.castToString(this.sourceSetName.get());
        }

        public Object doCall(Object obj) {
            Reference reference = new Reference(obj);
            Reference reference2 = new Reference(CopyActionFacade.Loader.create(((GenerateProtoTask) reference.get()).getProject(), ((GenerateProtoTask) reference.get()).getObjectFactory()));
            ((GenerateProtoTask) reference.get()).setDescription(new GStringImpl(new Object[]{this.sourceSetName.get()}, new String[]{"Compiles Proto source for '", "'"}).toString());
            ((GenerateProtoTask) reference.get()).setOutputBaseDir(((Provider) this.defaultGeneratedFilesBaseDir.get()).map((Transformer) ScriptBytecodeAdapter.castToType(new _closure38(this, getThisObject(), this.sourceSetName), Transformer.class)));
            ((GenerateProtoTask) reference.get()).addSourceDirs(((ProtoSourceSet) this.protoSourceSet.get()).getProto());
            ((GenerateProtoTask) reference.get()).addIncludeDir(((ProtoSourceSet) this.protoSourceSet.get()).getProto().getSourceDirectories());
            ((GenerateProtoTask) reference.get()).addIncludeDir(((ProtoSourceSet) this.protoSourceSet.get()).getIncludeProtoDirs());
            ((GenerateProtoTask) reference.get()).doLast(new _closure39(this, getThisObject(), this.generatedFilesBaseDirProvider, this.defaultGeneratedFilesBaseDir, reference2, reference, this.sourceSetName));
            ((Action) this.configureAction.get()).execute(reference.get());
            return null;
        }

        /* INFO: compiled from: ProtobufPlugin.groovy */
        public final class _closure38 extends Closure implements GeneratedClosure {
            private static /* synthetic */ ClassInfo $staticClassInfo;
            public static transient /* synthetic */ boolean __$stMC;
            private /* synthetic */ Reference sourceSetName;

            public _closure38(Object obj, Object obj2, Reference reference) {
                super(obj, obj2);
                this.sourceSetName = reference;
            }

            protected /* synthetic */ MetaClass $getStaticMetaClass() {
                if (getClass() != _closure38.class) {
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

            @Generated
            public String getSourceSetName() {
                return ShortTypeHandling.castToString(this.sourceSetName.get());
            }

            public Object doCall(Object obj) {
                return new GStringImpl(new Object[]{obj, this.sourceSetName.get()}, new String[]{"", InternalZipConstants.ZIP_FILE_SEPARATOR, ""}).toString();
            }
        }

        /* INFO: compiled from: ProtobufPlugin.groovy */
        public final class _closure39 extends Closure implements GeneratedClosure {
            private static /* synthetic */ Class $class$com$google$protobuf$gradle$CopyActionFacade;
            private static /* synthetic */ ClassInfo $staticClassInfo;
            public static transient /* synthetic */ boolean __$stMC;
            private /* synthetic */ Reference copyActionFacade;
            private /* synthetic */ Reference defaultGeneratedFilesBaseDir;
            private /* synthetic */ Reference generatedFilesBaseDirProvider;
            private /* synthetic */ Reference it;
            private /* synthetic */ Reference sourceSetName;

            private static /* synthetic */ Class $get$$class$com$google$protobuf$gradle$CopyActionFacade() {
                Class cls = $class$com$google$protobuf$gradle$CopyActionFacade;
                if (cls != null) {
                    return cls;
                }
                Class clsClass$ = class$("com.google.protobuf.gradle.CopyActionFacade");
                $class$com$google$protobuf$gradle$CopyActionFacade = clsClass$;
                return clsClass$;
            }

            public _closure39(Object obj, Object obj2, Reference reference, Reference reference2, Reference reference3, Reference reference4, Reference reference5) {
                super(obj, obj2);
                this.generatedFilesBaseDirProvider = reference;
                this.defaultGeneratedFilesBaseDir = reference2;
                this.copyActionFacade = reference3;
                this.it = reference4;
                this.sourceSetName = reference5;
            }

            static /* synthetic */ Class class$(String str) {
                try {
                    return Class.forName(str);
                } catch (ClassNotFoundException e) {
                    throw new NoClassDefFoundError(e.getMessage());
                }
            }

            protected /* synthetic */ MetaClass $getStaticMetaClass() {
                if (getClass() != _closure39.class) {
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
            public CopyActionFacade getCopyActionFacade() {
                return (CopyActionFacade) ScriptBytecodeAdapter.castToType(this.copyActionFacade.get(), $get$$class$com$google$protobuf$gradle$CopyActionFacade());
            }

            @Generated
            public Provider getDefaultGeneratedFilesBaseDir() {
                return (Provider) ScriptBytecodeAdapter.castToType(this.defaultGeneratedFilesBaseDir.get(), Provider.class);
            }

            @Generated
            public Provider getGeneratedFilesBaseDirProvider() {
                return (Provider) ScriptBytecodeAdapter.castToType(this.generatedFilesBaseDirProvider.get(), Provider.class);
            }

            @Generated
            public Object getIt() {
                return this.it.get();
            }

            @Generated
            public String getSourceSetName() {
                return ShortTypeHandling.castToString(this.sourceSetName.get());
            }

            public Object doCall(Object obj) {
                Reference reference = new Reference(ShortTypeHandling.castToString(((Property) this.generatedFilesBaseDirProvider.get()).get()));
                if (ScriptBytecodeAdapter.compareEqual((String) reference.get(), ((Provider) this.defaultGeneratedFilesBaseDir.get()).get())) {
                    return null;
                }
                return ((CopyActionFacade) this.copyActionFacade.get()).copy((Action) ScriptBytecodeAdapter.castToType(new _closure40(this, getThisObject(), this.it, reference, this.sourceSetName), Action.class));
            }

            /* INFO: compiled from: ProtobufPlugin.groovy */
            public final class _closure40 extends Closure implements GeneratedClosure {
                private static /* synthetic */ ClassInfo $staticClassInfo;
                public static transient /* synthetic */ boolean __$stMC;
                private /* synthetic */ Reference generatedFilesBaseDir;
                private /* synthetic */ Reference it;
                private /* synthetic */ Reference sourceSetName;

                public _closure40(Object obj, Object obj2, Reference reference, Reference reference2, Reference reference3) {
                    super(obj, obj2);
                    this.it = reference;
                    this.generatedFilesBaseDir = reference2;
                    this.sourceSetName = reference3;
                }

                protected /* synthetic */ MetaClass $getStaticMetaClass() {
                    if (getClass() != _closure40.class) {
                        return ScriptBytecodeAdapter.initMetaClass(this);
                    }
                    ClassInfo classInfo = $staticClassInfo;
                    if (classInfo == null) {
                        classInfo = ClassInfo.getClassInfo(getClass());
                        $staticClassInfo = classInfo;
                    }
                    return classInfo.getMetaClass();
                }

                public Object call(CopySpec copySpec) {
                    return doCall(copySpec);
                }

                @Generated
                public String getGeneratedFilesBaseDir() {
                    return ShortTypeHandling.castToString(this.generatedFilesBaseDir.get());
                }

                @Generated
                public Object getIt() {
                    return this.it.get();
                }

                @Generated
                public String getSourceSetName() {
                    return ShortTypeHandling.castToString(this.sourceSetName.get());
                }

                public Object doCall(CopySpec copySpec) {
                    copySpec.setIncludeEmptyDirs(false);
                    copySpec.from(new Object[]{((GenerateProtoTask) this.it.get()).getOutputBaseDir()});
                    return copySpec.into(new GStringImpl(new Object[]{this.generatedFilesBaseDir.get(), this.sourceSetName.get()}, new String[]{"", InternalZipConstants.ZIP_FILE_SEPARATOR, ""}));
                }
            }
        }
    }

    /* INFO: compiled from: ProtobufPlugin.groovy */
    public final class _addGenerateProtoTask_closure21 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;

        public _addGenerateProtoTask_closure21(Object obj, Object obj2) {
            super(obj, obj2);
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _addGenerateProtoTask_closure21.class) {
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
            return InvokerHelper.invokeMethodSafe(generateProtoTask, "getOutputSourceDirectories", new Object[0]);
        }
    }

    private Provider<ProtobufExtract> setupExtractProtosTask(ProtoSourceSet protoSourceSet, Configuration configuration) {
        Reference reference = new Reference(configuration);
        Reference reference2 = new Reference(protoSourceSet.getName());
        TaskProvider taskProviderRegister = this.project.getTasks().register(getExtractProtosTaskName((String) reference2.get()), ProtobufExtract.class, (Action) ScriptBytecodeAdapter.castToType(new _setupExtractProtosTask_closure22(this, this, reference2, reference), Action.class));
        protoSourceSet.getProto().srcDir(taskProviderRegister);
        return taskProviderRegister;
    }

    /* INFO: compiled from: ProtobufPlugin.groovy */
    public final class _setupExtractProtosTask_closure22 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;
        private /* synthetic */ Reference protobufConfig;
        private /* synthetic */ Reference sourceSetName;

        public _setupExtractProtosTask_closure22(Object obj, Object obj2, Reference reference, Reference reference2) {
            super(obj, obj2);
            this.sourceSetName = reference;
            this.protobufConfig = reference2;
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _setupExtractProtosTask_closure22.class) {
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

        @Generated
        public Configuration getProtobufConfig() {
            return (Configuration) ScriptBytecodeAdapter.castToType(this.protobufConfig.get(), Configuration.class);
        }

        @Generated
        public String getSourceSetName() {
            return ShortTypeHandling.castToString(this.sourceSetName.get());
        }

        public Object doCall(Object obj) {
            ProtobufExtract protobufExtract = (ProtobufExtract) obj;
            protobufExtract.setDescription("Extracts proto files/dependencies specified by 'protobuf' configuration");
            protobufExtract.getDestDir().set((File) ScriptBytecodeAdapter.asType(((ProtobufPlugin) ScriptBytecodeAdapter.castToType(getThisObject(), ProtobufPlugin.class)).getExtractedProtosDir(ShortTypeHandling.castToString(this.sourceSetName.get())), File.class));
            return protobufExtract.getInputFiles().from(new Object[]{this.protobufConfig.get()});
        }
    }

    private String getExtractProtosTaskName(String str) {
        return StringGroovyMethods.plus(StringGroovyMethods.plus("extract", Utils.getSourceSetSubstringForTaskNames(str)), "Proto");
    }

    private Provider<ProtobufExtract> setupExtractIncludeProtosTask(ProtoSourceSet protoSourceSet, FileCollection fileCollection) {
        Reference reference = new Reference(protoSourceSet);
        Reference reference2 = new Reference(fileCollection);
        TaskProvider taskProviderRegister = this.project.getTasks().register(StringGroovyMethods.plus(StringGroovyMethods.plus("extractInclude", Utils.getSourceSetSubstringForTaskNames(((ProtoSourceSet) reference.get()).getName())), "Proto"), ProtobufExtract.class, (Action) ScriptBytecodeAdapter.castToType(new _setupExtractIncludeProtosTask_closure23(this, this, reference, reference2), Action.class));
        ((ProtoSourceSet) reference.get()).getIncludeProtoDirs().from(new Object[]{taskProviderRegister});
        return taskProviderRegister;
    }

    /* INFO: compiled from: ProtobufPlugin.groovy */
    public final class _setupExtractIncludeProtosTask_closure23 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;
        private /* synthetic */ Reference archives;
        private /* synthetic */ Reference protoSourceSet;

        public _setupExtractIncludeProtosTask_closure23(Object obj, Object obj2, Reference reference, Reference reference2) {
            super(obj, obj2);
            this.protoSourceSet = reference;
            this.archives = reference2;
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _setupExtractIncludeProtosTask_closure23.class) {
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

        @Generated
        public FileCollection getArchives() {
            return (FileCollection) ScriptBytecodeAdapter.castToType(this.archives.get(), FileCollection.class);
        }

        @Generated
        public ProtoSourceSet getProtoSourceSet() {
            return (ProtoSourceSet) ScriptBytecodeAdapter.castToType(this.protoSourceSet.get(), ProtoSourceSet.class);
        }

        public Object doCall(Object obj) {
            ProtobufExtract protobufExtract = (ProtobufExtract) obj;
            protobufExtract.setDescription("Extracts proto files from compile dependencies for includes");
            protobufExtract.getDestDir().set((File) ScriptBytecodeAdapter.asType(((ProtobufPlugin) ScriptBytecodeAdapter.castToType(getThisObject(), ProtobufPlugin.class)).getExtractedIncludeProtosDir(((ProtoSourceSet) this.protoSourceSet.get()).getName()), File.class));
            return protobufExtract.getInputFiles().from(new Object[]{this.archives.get()});
        }
    }

    /* INFO: Access modifiers changed from: private */
    public String getExtractedIncludeProtosDir(String str) {
        return ShortTypeHandling.castToString(new GStringImpl(new Object[]{this.project.getBuildDir(), str}, new String[]{"", "/extracted-include-protos/", ""}));
    }

    /* INFO: Access modifiers changed from: private */
    public String getExtractedProtosDir(String str) {
        return ShortTypeHandling.castToString(new GStringImpl(new Object[]{this.project.getBuildDir(), str}, new String[]{"", "/extracted-protos/", ""}));
    }
}
