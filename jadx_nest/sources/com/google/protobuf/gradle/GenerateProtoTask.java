package com.google.protobuf.gradle;

import groovy.lang.Closure;
import groovy.lang.GroovyObject;
import groovy.lang.IntRange;
import groovy.lang.MetaClass;
import groovy.lang.Reference;
import groovy.transform.Generated;
import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import javax.inject.Inject;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.collections4.CollectionUtils;
import org.codehaus.groovy.reflection.ClassInfo;
import org.codehaus.groovy.runtime.BytecodeInterface8;
import org.codehaus.groovy.runtime.DefaultGroovyMethods;
import org.codehaus.groovy.runtime.GStringImpl;
import org.codehaus.groovy.runtime.GeneratedClosure;
import org.codehaus.groovy.runtime.InvokerHelper;
import org.codehaus.groovy.runtime.ProcessGroovyMethods;
import org.codehaus.groovy.runtime.ResourceGroovyMethods;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.codehaus.groovy.runtime.StringGroovyMethods;
import org.codehaus.groovy.runtime.callsite.CallSite;
import org.codehaus.groovy.runtime.callsite.CallSiteArray;
import org.codehaus.groovy.runtime.dgmimpl.NumberNumberMinus;
import org.codehaus.groovy.runtime.powerassert.AssertionRenderer;
import org.codehaus.groovy.runtime.powerassert.ValueRecorder;
import org.codehaus.groovy.runtime.typehandling.DefaultTypeTransformation;
import org.codehaus.groovy.runtime.typehandling.ShortTypeHandling;
import org.codehaus.groovy.transform.ImmutableASTTransformation;
import org.gradle.api.Action;
import org.gradle.api.DefaultTask;
import org.gradle.api.GradleException;
import org.gradle.api.Named;
import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.file.ConfigurableFileCollection;
import org.gradle.api.file.DeleteSpec;
import org.gradle.api.file.FileCollection;
import org.gradle.api.file.ProjectLayout;
import org.gradle.api.file.SourceDirectorySet;
import org.gradle.api.logging.LogLevel;
import org.gradle.api.logging.Logger;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.Provider;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.tasks.CacheableTask;
import org.gradle.api.tasks.IgnoreEmptyDirectories;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.InputFiles;
import org.gradle.api.tasks.Internal;
import org.gradle.api.tasks.Nested;
import org.gradle.api.tasks.Optional;
import org.gradle.api.tasks.OutputDirectory;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.PathSensitive;
import org.gradle.api.tasks.PathSensitivity;
import org.gradle.api.tasks.SkipWhenEmpty;
import org.gradle.api.tasks.SourceSet;
import org.gradle.api.tasks.TaskAction;

/* JADX INFO: compiled from: GenerateProtoTask.groovy */
/* JADX INFO: loaded from: classes4.dex */
@CacheableTask
public abstract class GenerateProtoTask extends DefaultTask implements GroovyObject {
    private static /* synthetic */ SoftReference $callSiteArray = null;
    private static /* synthetic */ Class $class$com$google$protobuf$gradle$Preconditions = null;
    private static /* synthetic */ ClassInfo $staticClassInfo = null;
    private static /* synthetic */ ClassInfo $staticClassInfo$ = null;
    private static final int CMD_ARGUMENT_EXTRA_LENGTH = 3;
    private static final int DEFAULT_CMD_LENGTH_LIMIT = 65536;
    private static final String JAR_SUFFIX = ".jar";
    private static final int WINDOWS_CMD_LENGTH_LIMIT = 32760;
    public static transient /* synthetic */ boolean __$stMC;
    private String buildType;
    private List<String> flavors;

    @Internal("Handled as input via getDescriptorSetOptionsForCaching()")
    private boolean generateDescriptorSet;
    private boolean isTestVariant;
    private Provider<String> outputBaseDir;
    private transient SourceSet sourceSet;
    private transient Object variant;
    private final CopyActionFacade copyActionFacade = CopyActionFacade.Loader.create(getProject(), getObjectFactory());
    private final ConfigurableFileCollection includeDirs = getObjectFactory().fileCollection();
    private final ConfigurableFileCollection sourceDirs = getObjectFactory().fileCollection();
    private final NamedDomainObjectContainer<PluginOptions> builtins = getObjectFactory().domainObjectContainer(PluginOptions.class);
    private final NamedDomainObjectContainer<PluginOptions> plugins = getObjectFactory().domainObjectContainer(PluginOptions.class);
    private final ProjectLayout projectLayout = getProject().getLayout();
    private final ToolsLocator toolsLocator = ((ProtobufExtension) getProject().getExtensions().findByType(ProtobufExtension.class)).getTools();
    private final Provider<Boolean> isAndroidProject = getProviderFactory().provider(new _closure1(this, this));
    private final Provider<Boolean> isTestProvider = getProviderFactory().provider(new _closure2(this, this));

    @Internal("Handled as input via getDescriptorSetOptionsForCaching()")
    private final DescriptorSetOptions descriptorSetOptions = new DescriptorSetOptions();
    private State state = State.INIT;
    private transient /* synthetic */ MetaClass metaClass = $getStaticMetaClass();

    /* JADX INFO: compiled from: GenerateProtoTask.groovy */
    public class DescriptorSetOptions implements GroovyObject {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        private static /* synthetic */ ClassInfo $staticClassInfo$;
        public static transient /* synthetic */ boolean __$stMC;

        @Input
        private boolean includeImports;

        @Input
        private boolean includeSourceInfo;
        private transient /* synthetic */ MetaClass metaClass = $getStaticMetaClass();

        @OutputFile
        @Nullable
        @Optional
        private String path;

        @Generated
        public DescriptorSetOptions() {
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != DescriptorSetOptions.class) {
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
        public boolean getIncludeImports() {
            return this.includeImports;
        }

        @Generated
        public boolean getIncludeSourceInfo() {
            return this.includeSourceInfo;
        }

        @Generated
        @groovy.transform.Internal
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
        public String getPath() {
            return this.path;
        }

        @Generated
        @groovy.transform.Internal
        public /* synthetic */ Object getProperty(String str) {
            return getMetaClass().getProperty(this, str);
        }

        @Generated
        @groovy.transform.Internal
        public /* synthetic */ Object invokeMethod(String str, Object obj) {
            return getMetaClass().invokeMethod(this, str, obj);
        }

        @Generated
        public boolean isIncludeImports() {
            return this.includeImports;
        }

        @Generated
        public boolean isIncludeSourceInfo() {
            return this.includeSourceInfo;
        }

        public /* synthetic */ Object methodMissing(String str, Object obj) {
            return GenerateProtoTask.this.this$dist$invoke$3(str, obj);
        }

        public /* synthetic */ Object propertyMissing(String str) {
            return GenerateProtoTask.this.this$dist$get$3(str);
        }

        public /* synthetic */ void propertyMissing(String str, Object obj) {
            GenerateProtoTask.this.this$dist$set$3(str, obj);
        }

        @Generated
        public void setIncludeImports(boolean z) {
            this.includeImports = z;
        }

        @Generated
        public void setIncludeSourceInfo(boolean z) {
            this.includeSourceInfo = z;
        }

        @Generated
        @groovy.transform.Internal
        public /* synthetic */ void setMetaClass(MetaClass metaClass) {
            this.metaClass = metaClass;
        }

        @Generated
        public void setPath(String str) {
            this.path = str;
        }

        @Generated
        @groovy.transform.Internal
        public /* synthetic */ void setProperty(String str, Object obj) {
            getMetaClass().setProperty(this, str, obj);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: GenerateProtoTask.groovy */
    static final class State implements GroovyObject {
        private static final /* synthetic */ State[] $VALUES;
        private static /* synthetic */ ClassInfo $staticClassInfo;
        private static /* synthetic */ ClassInfo $staticClassInfo$;
        public static final State CONFIG;
        public static final State FINALIZED;
        public static final State INIT;
        public static final State MAX_VALUE;
        public static final State MIN_VALUE;
        public static transient /* synthetic */ boolean __$stMC;
        private transient /* synthetic */ MetaClass metaClass;

        public static final /* synthetic */ State $INIT(Object... objArr) {
            Object[] objArrDespreadList = ScriptBytecodeAdapter.despreadList(new Object[0], new Object[]{objArr}, new int[]{0});
            int iSelectConstructorAndTransformArguments = ScriptBytecodeAdapter.selectConstructorAndTransformArguments(objArrDespreadList, -1, State.class);
            if (iSelectConstructorAndTransformArguments == -1348271900) {
                return new State(ShortTypeHandling.castToString(objArrDespreadList[0]), DefaultTypeTransformation.intUnbox(objArrDespreadList[1]));
            }
            if (iSelectConstructorAndTransformArguments == -242181752) {
                return new State(ShortTypeHandling.castToString(objArrDespreadList[0]), DefaultTypeTransformation.intUnbox(objArrDespreadList[1]), (LinkedHashMap) ScriptBytecodeAdapter.castToType(objArrDespreadList[2], LinkedHashMap.class));
            }
            throw new IllegalArgumentException("This class has been compiled with a super class which is binary incompatible with the current super class found on classpath. You should recompile this class with the new version.");
        }

        static {
            State state$INIT = $INIT("INIT", 0);
            INIT = state$INIT;
            State state$INIT2 = $INIT("CONFIG", 1);
            CONFIG = state$INIT2;
            State state$INIT3 = $INIT("FINALIZED", 2);
            FINALIZED = state$INIT3;
            MIN_VALUE = state$INIT;
            MAX_VALUE = state$INIT3;
            $VALUES = new State[]{state$INIT, state$INIT2, state$INIT3};
        }

        @Generated
        public State(String str, int i) {
            this(str, i, new LinkedHashMap());
        }

        @Generated
        public State(String str, int i, LinkedHashMap linkedHashMap) {
            super(str, i);
            this.metaClass = $getStaticMetaClass();
            if (linkedHashMap == null) {
                throw new IllegalArgumentException("One of the enum constants for enum com.google.protobuf.gradle.GenerateProtoTask$State was initialized with null. Please use a non-null value or define your own constructor.");
            }
            ImmutableASTTransformation.checkPropNames(this, linkedHashMap);
        }

        public static State valueOf(String str) {
            return (State) ShortTypeHandling.castToEnum(Enum.valueOf(State.class, str), State.class);
        }

        public static final State[] values() {
            return (State[]) ScriptBytecodeAdapter.castToType($VALUES.clone(), State[].class);
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != State.class) {
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
        @groovy.transform.Internal
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
        @groovy.transform.Internal
        public /* synthetic */ Object getProperty(String str) {
            return getMetaClass().getProperty(this, str);
        }

        @Generated
        @groovy.transform.Internal
        public /* synthetic */ Object invokeMethod(String str, Object obj) {
            return getMetaClass().invokeMethod(this, str, obj);
        }

        public /* synthetic */ State next() {
            Object next = DefaultGroovyMethods.next(Integer.valueOf(ordinal()));
            State[] stateArr = $VALUES;
            if (ScriptBytecodeAdapter.compareGreaterThanEqual(next, Integer.valueOf(DefaultGroovyMethods.size((Object[]) ScriptBytecodeAdapter.castToType(stateArr, Object[].class))))) {
                next = 0;
            }
            return (State) ShortTypeHandling.castToEnum(BytecodeInterface8.objectArrayGet(stateArr, DefaultTypeTransformation.intUnbox(next)), State.class);
        }

        public /* synthetic */ State previous() {
            Number numberPrevious = DefaultGroovyMethods.previous(Integer.valueOf(ordinal()));
            if (ScriptBytecodeAdapter.compareLessThan(numberPrevious, 0)) {
                numberPrevious = NumberNumberMinus.minus(Integer.valueOf(DefaultGroovyMethods.size((Object[]) ScriptBytecodeAdapter.castToType($VALUES, Object[].class))), 1);
            }
            return (State) ShortTypeHandling.castToEnum(BytecodeInterface8.objectArrayGet($VALUES, DefaultTypeTransformation.intUnbox(numberPrevious)), State.class);
        }

        @Generated
        @groovy.transform.Internal
        public /* synthetic */ void setMetaClass(MetaClass metaClass) {
            this.metaClass = metaClass;
        }

        @Generated
        @groovy.transform.Internal
        public /* synthetic */ void setProperty(String str, Object obj) {
            getMetaClass().setProperty(this, str, obj);
        }
    }

    private static /* synthetic */ CallSiteArray $createCallSiteArray() {
        String[] strArr = new String[4];
        $createCallSiteArray_1(strArr);
        return new CallSiteArray(GenerateProtoTask.class, strArr);
    }

    private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
        strArr[0] = "checkState";
        strArr[1] = "get";
        strArr[2] = "checkState";
        strArr[3] = "name";
    }

    private static /* synthetic */ Class $get$$class$com$google$protobuf$gradle$Preconditions() {
        Class cls = $class$com$google$protobuf$gradle$Preconditions;
        if (cls != null) {
            return cls;
        }
        Class clsClass$ = class$("com.google.protobuf.gradle.Preconditions");
        $class$com$google$protobuf$gradle$Preconditions = clsClass$;
        return clsClass$;
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

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    @Generated
    public static int getCMD_ARGUMENT_EXTRA_LENGTH() {
        return CMD_ARGUMENT_EXTRA_LENGTH;
    }

    @Generated
    public static int getDEFAULT_CMD_LENGTH_LIMIT() {
        return DEFAULT_CMD_LENGTH_LIMIT;
    }

    @Generated
    public static int getWINDOWS_CMD_LENGTH_LIMIT() {
        return WINDOWS_CMD_LENGTH_LIMIT;
    }

    protected /* synthetic */ MetaClass $getStaticMetaClass() {
        if (getClass() != GenerateProtoTask.class) {
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
    public final DescriptorSetOptions getDescriptorSetOptions() {
        return this.descriptorSetOptions;
    }

    @Generated
    public boolean getGenerateDescriptorSet() {
        return this.generateDescriptorSet;
    }

    @Generated
    @groovy.transform.Internal
    public MetaClass getMetaClass() {
        MetaClass metaClass = this.metaClass;
        if (metaClass != null) {
            return metaClass;
        }
        MetaClass metaClass$getStaticMetaClass = $getStaticMetaClass();
        this.metaClass = metaClass$getStaticMetaClass;
        return metaClass$getStaticMetaClass;
    }

    @Inject
    public abstract ObjectFactory getObjectFactory();

    @Generated
    @groovy.transform.Internal
    public Object getProperty(String str) {
        return getMetaClass().getProperty(this, str);
    }

    @Inject
    public abstract ProviderFactory getProviderFactory();

    @Generated
    @groovy.transform.Internal
    public Object invokeMethod(String str, Object obj) {
        return getMetaClass().invokeMethod(this, str, obj);
    }

    @Generated
    public boolean isGenerateDescriptorSet() {
        return this.generateDescriptorSet;
    }

    @Generated
    public void setGenerateDescriptorSet(boolean z) {
        this.generateDescriptorSet = z;
    }

    @Generated
    @groovy.transform.Internal
    public void setMetaClass(MetaClass metaClass) {
        this.metaClass = metaClass;
    }

    public /* synthetic */ Object this$dist$get$3(String str) {
        return ScriptBytecodeAdapter.getGroovyObjectProperty(GenerateProtoTask.class, this, ShortTypeHandling.castToString(new GStringImpl(new Object[]{str}, new String[]{"", ""})));
    }

    public /* synthetic */ Object this$dist$invoke$3(String str, Object obj) {
        return ScriptBytecodeAdapter.invokeMethodOnCurrentN(GenerateProtoTask.class, this, ShortTypeHandling.castToString(new GStringImpl(new Object[]{str}, new String[]{"", ""})), ScriptBytecodeAdapter.despreadList(new Object[0], new Object[]{obj}, new int[]{0}));
    }

    public /* synthetic */ void this$dist$set$3(String str, Object obj) {
        ScriptBytecodeAdapter.setGroovyObjectProperty(obj, GenerateProtoTask.class, this, ShortTypeHandling.castToString(new GStringImpl(new Object[]{str}, new String[]{"", ""})));
    }

    @Generated
    public GenerateProtoTask() {
    }

    /* JADX INFO: compiled from: GenerateProtoTask.groovy */
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
            return Boolean.valueOf(Utils.isAndroidProject(((GenerateProtoTask) ((DefaultTask) ScriptBytecodeAdapter.castToType(getThisObject(), DefaultTask.class))).getProject()));
        }
    }

    /* JADX INFO: compiled from: GenerateProtoTask.groovy */
    public final class _closure2 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;

        public _closure2(Object obj, Object obj2) {
            super(obj, obj2);
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
            if (Utils.isAndroidProject(((GenerateProtoTask) ((DefaultTask) ScriptBytecodeAdapter.castToType(getThisObject(), DefaultTask.class))).getProject())) {
                return Boolean.valueOf(((GenerateProtoTask) ScriptBytecodeAdapter.castToType(getThisObject(), GenerateProtoTask.class)).getIsTestVariant());
            }
            return Boolean.valueOf(Utils.isTest(((GenerateProtoTask) ScriptBytecodeAdapter.castToType(getThisObject(), GenerateProtoTask.class)).getSourceSet().getName()));
        }
    }

    public static String makeOptionsPrefix(List<String> list) {
        Reference reference = new Reference(new StringBuilder());
        if (!list.isEmpty()) {
            DefaultGroovyMethods.each(list, new _makeOptionsPrefix_closure3(GenerateProtoTask.class, GenerateProtoTask.class, reference));
            ((StringBuilder) reference.get()).append(CollectionUtils.COLON);
        }
        return ((StringBuilder) reference.get()).toString();
    }

    /* JADX INFO: compiled from: GenerateProtoTask.groovy */
    public final class _makeOptionsPrefix_closure3 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;
        private /* synthetic */ Reference prefix;

        public _makeOptionsPrefix_closure3(Object obj, Object obj2, Reference reference) {
            super(obj, obj2);
            this.prefix = reference;
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _makeOptionsPrefix_closure3.class) {
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
        public StringBuilder getPrefix() {
            return (StringBuilder) ScriptBytecodeAdapter.castToType(this.prefix.get(), StringBuilder.class);
        }

        public Object doCall(Object obj) {
            if (((StringBuilder) this.prefix.get()).length() > 0) {
                ((StringBuilder) this.prefix.get()).append(CollectionUtils.COMMA);
            }
            return ((StringBuilder) this.prefix.get()).append(ShortTypeHandling.castToString(obj));
        }
    }

    public static List<List<String>> generateCmds(List<String> list, List<File> list2, int i) {
        List<List<String>> listCreateList = ScriptBytecodeAdapter.createList(new Object[0]);
        if (!list2.isEmpty()) {
            int iIntUnbox = DefaultTypeTransformation.intUnbox(ScriptBytecodeAdapter.asType(DefaultGroovyMethods.sum(list, new _generateCmds_closure4(GenerateProtoTask.class, GenerateProtoTask.class)), Integer.TYPE));
            List listCreateList2 = ScriptBytecodeAdapter.createList(new Object[0]);
            Iterator<File> it = list2.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                String strCastToString = ShortTypeHandling.castToString((File) ScriptBytecodeAdapter.castToType(it.next(), File.class));
                int length = strCastToString.length() + CMD_ARGUMENT_EXTRA_LENGTH;
                if (iIntUnbox + i2 + length > i) {
                    listCreateList.add(DefaultGroovyMethods.plus(list, listCreateList2));
                    listCreateList2.clear();
                    i2 = 0;
                }
                listCreateList2.add(strCastToString);
                i2 += length;
            }
            listCreateList.add(DefaultGroovyMethods.plus(list, listCreateList2));
        }
        return listCreateList;
    }

    /* JADX INFO: compiled from: GenerateProtoTask.groovy */
    public final class _generateCmds_closure4 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;

        public _generateCmds_closure4(Object obj, Object obj2) {
            super(obj, obj2);
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _generateCmds_closure4.class) {
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
            return Integer.valueOf(((String) obj).length() + GenerateProtoTask.getCMD_ARGUMENT_EXTRA_LENGTH());
        }
    }

    public static int getCmdLengthLimit() {
        return getCmdLengthLimit(System.getProperty("os.name"));
    }

    public static int getCmdLengthLimit(String str) {
        return isWindows(str) ? WINDOWS_CMD_LENGTH_LIMIT : DEFAULT_CMD_LENGTH_LIMIT;
    }

    public static boolean isWindows(String str) {
        return str != null && ScriptBytecodeAdapter.compareGreaterThan(Integer.valueOf(str.toLowerCase(Locale.ROOT).indexOf("win")), -1);
    }

    public static boolean isWindows() {
        return isWindows(System.getProperty("os.name"));
    }

    public static String escapePathUnix(String str) {
        return str.replace("'", "'\\''");
    }

    public static String escapePathWindows(String str) {
        String strReplace = str.replace("%", "%%");
        return strReplace.endsWith("\\") ? StringGroovyMethods.plus(strReplace, "\\") : strReplace;
    }

    public static void mkdirsForFile(File file) throws IOException {
        if (!file.getParentFile().isDirectory() && !file.getParentFile().mkdirs()) {
            throw new IOException(StringGroovyMethods.plus("unable to make directories for file: ", file.getCanonicalPath()));
        }
    }

    public static void setExecutableOrFail(File file) throws IOException {
        if (file.setExecutable(true)) {
            return;
        }
        file.delete();
        throw new IOException(StringGroovyMethods.plus("unable to set file as executable: ", file.getCanonicalPath()));
    }

    public static String computeJavaExePath(boolean z) throws IOException {
        File file = new File(System.getProperty("java.home"), z ? "bin/java.exe" : "bin/java");
        if (!file.exists()) {
            throw new IOException(StringGroovyMethods.plus("Could not find java executable at ", file.getPath()));
        }
        return file.getPath();
    }

    public void setOutputBaseDir(Provider<String> provider) {
        checkInitializing();
        Preconditions.checkState(this.outputBaseDir == null, "outputBaseDir is already set");
        this.outputBaseDir = provider;
    }

    @OutputDirectory
    public String getOutputBaseDir() {
        return ShortTypeHandling.castToString(this.outputBaseDir.get());
    }

    public void setSourceSet(SourceSet sourceSet) {
        checkInitializing();
        Preconditions.checkState(!DefaultTypeTransformation.booleanUnbox(this.isAndroidProject.get()), "sourceSet should not be set in an Android project");
        this.sourceSet = sourceSet;
    }

    public void setVariant(Object obj, boolean z) {
        checkInitializing();
        Preconditions.checkState(DefaultTypeTransformation.booleanUnbox(this.isAndroidProject.get()), "variant should not be set in a Java project");
        this.variant = obj;
        this.isTestVariant = z;
    }

    public void setFlavors(List<String> list) {
        checkInitializing();
        Preconditions.checkState(DefaultTypeTransformation.booleanUnbox(this.isAndroidProject.get()), "flavors should not be set in a Java project");
        this.flavors = Collections.unmodifiableList(new ArrayList(list));
    }

    public void setBuildType(String str) {
        checkInitializing();
        Preconditions.checkState(DefaultTypeTransformation.booleanUnbox(this.isAndroidProject.get()), "buildType should not be set in a Java project");
        this.buildType = str;
    }

    @Internal("Inputs tracked in getSourceDirs()")
    public SourceSet getSourceSet() {
        Preconditions.checkState(!DefaultTypeTransformation.booleanUnbox(this.isAndroidProject.get()), "sourceSet should not be used in an Android project");
        Preconditions.checkNotNull(this.sourceSet, "sourceSet is not set");
        return this.sourceSet;
    }

    @IgnoreEmptyDirectories
    @InputFiles
    @PathSensitive(PathSensitivity.RELATIVE)
    @SkipWhenEmpty
    public FileCollection getSourceDirs() {
        return this.sourceDirs;
    }

    @InputFiles
    @PathSensitive(PathSensitivity.RELATIVE)
    public FileCollection getIncludeDirs() {
        return this.includeDirs;
    }

    @Internal("Not an actual input to the task, only used to find tasks belonging to a variant")
    public Object getVariant() {
        Preconditions.checkState(DefaultTypeTransformation.booleanUnbox(this.isAndroidProject.get()), "variant should not be used in a Java project");
        Preconditions.checkNotNull(this.variant, "variant is not set");
        return this.variant;
    }

    /* JADX INFO: compiled from: GenerateProtoTask.groovy */
    public final class _getReleaseArtifacts_closure5 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;

        public _getReleaseArtifacts_closure5(Object obj, Object obj2) {
            super(obj, obj2);
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _getReleaseArtifacts_closure5.class) {
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

        /* JADX INFO: compiled from: GenerateProtoTask.groovy */
        public final class _closure18 extends Closure implements GeneratedClosure {
            private static /* synthetic */ ClassInfo $staticClassInfo;
            public static transient /* synthetic */ boolean __$stMC;

            public _closure18(Object obj, Object obj2) {
                super(obj, obj2);
            }

            protected /* synthetic */ MetaClass $getStaticMetaClass() {
                if (getClass() != _closure18.class) {
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
                return InvokerHelper.invokeMethodSafe(obj, "getSimplifiedArtifactName", new Object[0]);
            }
        }

        public Object doCall(Object obj) {
            return DefaultGroovyMethods.collect(((GenerateProtoTask) ScriptBytecodeAdapter.castToType(getThisObject(), GenerateProtoTask.class)).getReleaseExecutableLocators(), new _closure18(this, getThisObject()));
        }
    }

    @Input
    public Provider<List<String>> getReleaseArtifacts() {
        return getProviderFactory().provider(new _getReleaseArtifacts_closure5(this, this));
    }

    /* JADX INFO: compiled from: GenerateProtoTask.groovy */
    public final class _getExecutables_closure6 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;

        public _getExecutables_closure6(Object obj, Object obj2) {
            super(obj, obj2);
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _getExecutables_closure6.class) {
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

        /* JADX INFO: compiled from: GenerateProtoTask.groovy */
        public final class _closure19 extends Closure implements GeneratedClosure {
            private static /* synthetic */ ClassInfo $staticClassInfo;
            public static transient /* synthetic */ boolean __$stMC;
            private /* synthetic */ Reference release;

            public _closure19(Object obj, Object obj2, Reference reference) {
                super(obj, obj2);
                this.release = reference;
            }

            protected /* synthetic */ MetaClass $getStaticMetaClass() {
                if (getClass() != _closure19.class) {
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
            public List getRelease() {
                return (List) ScriptBytecodeAdapter.castToType(this.release.get(), List.class);
            }

            public Object doCall(Object obj) {
                return Boolean.valueOf(!((List) this.release.get()).contains(obj));
            }
        }

        public Object doCall(Object obj) {
            return DefaultGroovyMethods.collect(DefaultGroovyMethods.findAll(((GenerateProtoTask) ScriptBytecodeAdapter.castToType(getThisObject(), GenerateProtoTask.class)).getAllExecutableLocators(), new _closure19(this, getThisObject(), new Reference(((GenerateProtoTask) ScriptBytecodeAdapter.castToType(getThisObject(), GenerateProtoTask.class)).getReleaseExecutableLocators()))), new _closure20(this, getThisObject()));
        }

        /* JADX INFO: compiled from: GenerateProtoTask.groovy */
        public final class _closure20 extends Closure implements GeneratedClosure {
            private static /* synthetic */ ClassInfo $staticClassInfo;
            public static transient /* synthetic */ boolean __$stMC;

            public _closure20(Object obj, Object obj2) {
                super(obj, obj2);
            }

            protected /* synthetic */ MetaClass $getStaticMetaClass() {
                if (getClass() != _closure20.class) {
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
                ExecutableLocator executableLocator = (ExecutableLocator) obj;
                return executableLocator.getPath() != null ? executableLocator.getPath() : InvokerHelper.invokeMethodSafe(obj, "getArtifactFiles", new Object[0]);
            }
        }
    }

    @InputFiles
    @PathSensitive(PathSensitivity.NONE)
    public FileCollection getExecutables() {
        return getObjectFactory().fileCollection().from(new Object[]{getProviderFactory().provider(new _getExecutables_closure6(this, this))});
    }

    /* JADX INFO: compiled from: GenerateProtoTask.groovy */
    public final class _getReleaseExecutableLocators_closure7 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;

        public _getReleaseExecutableLocators_closure7(Object obj, Object obj2) {
            super(obj, obj2);
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _getReleaseExecutableLocators_closure7.class) {
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
            boolean z = false;
            if (((ExecutableLocator) obj).getPath() == null && !((String) InvokerHelper.invokeMethodSafe(obj, "getSimplifiedArtifactName", new Object[0])).endsWith("-SNAPSHOT")) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<ExecutableLocator> getReleaseExecutableLocators() {
        return DefaultGroovyMethods.findAll(getAllExecutableLocators(), new _getReleaseExecutableLocators_closure7(this, this));
    }

    /* JADX INFO: compiled from: GenerateProtoTask.groovy */
    public final class _getAllExecutableLocators_closure8 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;

        public _getAllExecutableLocators_closure8(Object obj, Object obj2) {
            super(obj, obj2);
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _getAllExecutableLocators_closure8.class) {
                return ScriptBytecodeAdapter.initMetaClass(this);
            }
            ClassInfo classInfo = $staticClassInfo;
            if (classInfo == null) {
                classInfo = ClassInfo.getClassInfo(getClass());
                $staticClassInfo = classInfo;
            }
            return classInfo.getMetaClass();
        }

        public Object call(PluginOptions pluginOptions) {
            return doCall(pluginOptions);
        }

        public Object doCall(PluginOptions pluginOptions) {
            return ((GenerateProtoTask) getThisObject()).toolsLocator.getPlugins().findByName(pluginOptions.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<ExecutableLocator> getAllExecutableLocators() {
        return DefaultGroovyMethods.plus(ScriptBytecodeAdapter.createList(new Object[]{this.toolsLocator.getProtoc()}), DefaultGroovyMethods.findResults(this.plugins, new _getAllExecutableLocators_closure8(this, this)));
    }

    @Internal("Not an actual input to the task, only used to find tasks belonging to a variant")
    public Provider<Boolean> getIsAndroidProject() {
        return this.isAndroidProject;
    }

    @Internal("Not an actual input to the task, only used to find tasks belonging to a variant")
    public boolean getIsTestVariant() {
        Preconditions.checkState(DefaultTypeTransformation.booleanUnbox(this.isAndroidProject.get()), "isTestVariant should not be used in a Java project");
        Preconditions.checkNotNull(this.variant, "variant is not set");
        return this.isTestVariant;
    }

    @Internal("Not an actual input to the task, only used to find tasks belonging to a variant")
    public List<String> getFlavors() {
        Preconditions.checkState(DefaultTypeTransformation.booleanUnbox(this.isAndroidProject.get()), "flavors should not be used in a Java project");
        Preconditions.checkNotNull(this.flavors, "flavors is not set");
        return this.flavors;
    }

    @Internal("Not an actual input to the task, only used to find tasks belonging to a variant")
    public String getBuildType() {
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        callSiteArr$getCallSiteArray[0].call($get$$class$com$google$protobuf$gradle$Preconditions(), callSiteArr$getCallSiteArray[1].call(this.isAndroidProject), "buildType should not be used in a Java project");
        callSiteArr$getCallSiteArray[2].call($get$$class$com$google$protobuf$gradle$Preconditions(), Boolean.valueOf(ScriptBytecodeAdapter.compareEqual(callSiteArr$getCallSiteArray[3].callGetProperty(this.variant), "test") || DefaultTypeTransformation.booleanUnbox(this.buildType)), "buildType is not set and task is not for local unit test variant");
        return this.buildType;
    }

    public void doneInitializing() {
        Preconditions.checkState(ScriptBytecodeAdapter.compareEqual(this.state, State.INIT), new GStringImpl(new Object[]{this.state}, new String[]{"Invalid state: ", ""}));
        this.state = State.CONFIG;
    }

    public void doneConfig() {
        Preconditions.checkState(ScriptBytecodeAdapter.compareEqual(this.state, State.CONFIG), new GStringImpl(new Object[]{this.state}, new String[]{"Invalid state: ", ""}));
        this.state = State.FINALIZED;
    }

    @Internal("Tracked as an input via getDescriptorSetOptionsForCaching()")
    public String getDescriptorPath() {
        if (this.generateDescriptorSet) {
            return ShortTypeHandling.castToString(this.descriptorSetOptions.getPath() != null ? this.descriptorSetOptions.getPath() : new GStringImpl(new Object[]{this.outputBaseDir.get()}, new String[]{"", "/descriptor_set.desc"}));
        }
        throw new IllegalStateException("requested descriptor path but descriptor generation is off");
    }

    public void builtins(Action<NamedDomainObjectContainer<PluginOptions>> action) {
        checkCanConfig();
        action.execute(this.builtins);
    }

    @Internal("Tracked as an input via getBuiltinsForCaching()")
    public NamedDomainObjectContainer<PluginOptions> getBuiltins() {
        checkCanConfig();
        return this.builtins;
    }

    public void plugins(Action<NamedDomainObjectContainer<PluginOptions>> action) {
        checkCanConfig();
        action.execute(this.plugins);
    }

    @Internal("Tracked as an input via getPluginsForCaching()")
    public NamedDomainObjectContainer<PluginOptions> getPlugins() {
        checkCanConfig();
        return this.plugins;
    }

    public boolean hasPlugin(String str) {
        return this.plugins.findByName(str) != null;
    }

    public void addIncludeDir(FileCollection fileCollection) {
        checkCanConfig();
        this.includeDirs.from(new Object[]{fileCollection});
    }

    public void addSourceDirs(FileCollection fileCollection) {
        checkCanConfig();
        this.sourceDirs.from(new Object[]{fileCollection});
    }

    @Internal("Not an actual input to the task, only used to find tasks of interest")
    public boolean getIsTest() {
        return DefaultTypeTransformation.booleanUnbox(this.isTestProvider.get());
    }

    @Internal("Already captured with getIsTest()")
    public Provider<Boolean> getIsTestProvider() {
        return this.isTestProvider;
    }

    /* JADX INFO: compiled from: GenerateProtoTask.groovy */
    public static class PluginOptions implements Named, GroovyObject {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        private static /* synthetic */ ClassInfo $staticClassInfo$;
        public static transient /* synthetic */ boolean __$stMC;
        private final String name;
        private String outputSubDir;
        private final List<String> options = ScriptBytecodeAdapter.createList(new Object[0]);
        private transient /* synthetic */ MetaClass metaClass = $getStaticMetaClass();

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != PluginOptions.class) {
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
        @groovy.transform.Internal
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
        @groovy.transform.Internal
        public /* synthetic */ Object getProperty(String str) {
            return getMetaClass().getProperty(this, str);
        }

        @Generated
        @groovy.transform.Internal
        public /* synthetic */ Object invokeMethod(String str, Object obj) {
            return getMetaClass().invokeMethod(this, str, obj);
        }

        public /* synthetic */ Object methodMissing(String str, Object obj) {
            return ScriptBytecodeAdapter.invokeMethodN(PluginOptions.class, GenerateProtoTask.class, ShortTypeHandling.castToString(new GStringImpl(new Object[]{str}, new String[]{"", ""})), ScriptBytecodeAdapter.despreadList(new Object[0], new Object[]{obj}, new int[]{0}));
        }

        public /* synthetic */ Object propertyMissing(String str) {
            return ScriptBytecodeAdapter.getProperty(PluginOptions.class, GenerateProtoTask.class, ShortTypeHandling.castToString(new GStringImpl(new Object[]{str}, new String[]{"", ""})));
        }

        public /* synthetic */ void propertyMissing(String str, Object obj) {
            ScriptBytecodeAdapter.setProperty(obj, (Class) null, GenerateProtoTask.class, ShortTypeHandling.castToString(new GStringImpl(new Object[]{str}, new String[]{"", ""})));
        }

        @Generated
        @groovy.transform.Internal
        public /* synthetic */ void setMetaClass(MetaClass metaClass) {
            this.metaClass = metaClass;
        }

        @Generated
        @groovy.transform.Internal
        public /* synthetic */ void setProperty(String str, Object obj) {
            getMetaClass().setProperty(this, str, obj);
        }

        public PluginOptions(String str) {
            this.name = str;
        }

        public PluginOptions option(String str) {
            this.options.add(str);
            return this;
        }

        @Input
        public List<String> getOptions() {
            return this.options;
        }

        @Input
        public String getName() {
            return this.name;
        }

        public void setOutputSubDir(String str) {
            this.outputSubDir = str;
        }

        @Input
        public String getOutputSubDir() {
            String str = this.outputSubDir;
            return str != null ? str : this.name;
        }
    }

    public String getOutputDir(PluginOptions pluginOptions) {
        return ShortTypeHandling.castToString(new GStringImpl(new Object[]{this.outputBaseDir.get(), pluginOptions.getOutputSubDir()}, new String[]{"", InternalZipConstants.ZIP_FILE_SEPARATOR, ""}));
    }

    @Internal
    @Deprecated
    public SourceDirectorySet getOutputSourceDirectorySet() {
        String strPlus = StringGroovyMethods.plus("generate-proto-", getName());
        SourceDirectorySet sourceDirectorySet = getObjectFactory().sourceDirectorySet(strPlus, strPlus);
        sourceDirectorySet.srcDirs(new Object[]{getObjectFactory().fileCollection().builtBy(new Object[]{this}).from(new Object[]{getProviderFactory().provider(new _getOutputSourceDirectorySet_closure9(this, this))})});
        return sourceDirectorySet;
    }

    /* JADX INFO: compiled from: GenerateProtoTask.groovy */
    public final class _getOutputSourceDirectorySet_closure9 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;

        public _getOutputSourceDirectorySet_closure9(Object obj, Object obj2) {
            super(obj, obj2);
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _getOutputSourceDirectorySet_closure9.class) {
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
            return InvokerHelper.invokeMethodSafe((GenerateProtoTask) getThisObject(), "getOutputSourceDirectories", new Object[0]);
        }
    }

    @Internal
    Collection<File> getOutputSourceDirectories() {
        Reference reference = new Reference((Set) ScriptBytecodeAdapter.asType(ScriptBytecodeAdapter.createList(new Object[0]), Set.class));
        DefaultGroovyMethods.each(this.builtins, new _getOutputSourceDirectories_closure10(this, this, reference));
        DefaultGroovyMethods.each(this.plugins, new _getOutputSourceDirectories_closure11(this, this, reference));
        return (Set) reference.get();
    }

    /* JADX INFO: compiled from: GenerateProtoTask.groovy */
    public final class _getOutputSourceDirectories_closure10 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;
        private /* synthetic */ Reference srcDirs;

        public _getOutputSourceDirectories_closure10(Object obj, Object obj2, Reference reference) {
            super(obj, obj2);
            this.srcDirs = reference;
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _getOutputSourceDirectories_closure10.class) {
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
        public Collection getSrcDirs() {
            return (Collection) ScriptBytecodeAdapter.castToType(this.srcDirs.get(), Collection.class);
        }

        public Object doCall(Object obj) {
            File file = new File(((GenerateProtoTask) ScriptBytecodeAdapter.castToType(getThisObject(), GenerateProtoTask.class)).getOutputDir((PluginOptions) ScriptBytecodeAdapter.castToType(obj, PluginOptions.class)));
            if (file.getName().endsWith(".zip") || file.getName().endsWith(".jar")) {
                return null;
            }
            return Boolean.valueOf(((Set) this.srcDirs.get()).add(file));
        }
    }

    /* JADX INFO: compiled from: GenerateProtoTask.groovy */
    public final class _getOutputSourceDirectories_closure11 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;
        private /* synthetic */ Reference srcDirs;

        public _getOutputSourceDirectories_closure11(Object obj, Object obj2, Reference reference) {
            super(obj, obj2);
            this.srcDirs = reference;
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _getOutputSourceDirectories_closure11.class) {
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
        public Collection getSrcDirs() {
            return (Collection) ScriptBytecodeAdapter.castToType(this.srcDirs.get(), Collection.class);
        }

        public Object doCall(Object obj) {
            File file = new File(((GenerateProtoTask) ScriptBytecodeAdapter.castToType(getThisObject(), GenerateProtoTask.class)).getOutputDir((PluginOptions) ScriptBytecodeAdapter.castToType(obj, PluginOptions.class)));
            if (file.getName().endsWith(".zip") || file.getName().endsWith(".jar")) {
                return null;
            }
            return Boolean.valueOf(((Set) this.srcDirs.get()).add(file));
        }
    }

    @TaskAction
    public void compile() throws Throwable {
        Preconditions.checkState(ScriptBytecodeAdapter.compareEqual(this.state, State.FINALIZED), "doneConfig() has not been called");
        this.copyActionFacade.delete((Action) ScriptBytecodeAdapter.castToType(new _compile_closure12(this, this), Action.class));
        List listSort = DefaultGroovyMethods.sort(this.sourceDirs.getAsFileTree().getFiles());
        ArrayList arrayList = new ArrayList();
        List listCreateList = ScriptBytecodeAdapter.createList(new Object[]{this.builtins, this.plugins});
        if (listCreateList != null) {
            for (Object obj : listCreateList) {
                if (obj != null) {
                    ((Iterable) obj).forEach((Consumer) ScriptBytecodeAdapter.castToType(new _compile_closure13(this, this), Consumer.class));
                }
                arrayList.add(null);
            }
        }
        List listCollect = DefaultGroovyMethods.collect((Iterable) ScriptBytecodeAdapter.castToType(ScriptBytecodeAdapter.getPropertySpreadSafe(GenerateProtoTask.class, this.includeDirs.filter(new _compile_closure14(this, this)), "path"), Iterable.class), new _compile_closure15(this, this));
        getLogger().debug(ShortTypeHandling.castToString(new GStringImpl(new Object[]{listCollect}, new String[]{"ProtobufCompile using directories ", ""})));
        getLogger().debug(ShortTypeHandling.castToString(new GStringImpl(new Object[]{listSort}, new String[]{"ProtobufCompile using files ", ""})));
        Reference reference = new Reference(ScriptBytecodeAdapter.createList(new Object[]{computeExecutablePath(this.toolsLocator.getProtoc())}));
        ((List) reference.get()).addAll(listCollect);
        DefaultGroovyMethods.each(this.builtins, new _compile_closure16(this, this, reference));
        DefaultGroovyMethods.each(this.plugins, new _compile_closure17(this, this, new Reference(this.toolsLocator.getPlugins().getAsMap()), reference));
        if (this.generateDescriptorSet) {
            String descriptorPath = getDescriptorPath();
            File parentFile = new File(descriptorPath).getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            reference.set(DefaultGroovyMethods.plus((List) reference.get(), new GStringImpl(new Object[]{descriptorPath}, new String[]{"--descriptor_set_out=", ""}).toString()));
            if (this.descriptorSetOptions.getIncludeImports()) {
                reference.set(DefaultGroovyMethods.plus((List) reference.get(), "--include_imports"));
            }
            if (this.descriptorSetOptions.getIncludeSourceInfo()) {
                reference.set(DefaultGroovyMethods.plus((List) reference.get(), "--include_source_info"));
            }
        }
        Iterator<List<String>> it = generateCmds((List) reference.get(), listSort, getCmdLengthLimit()).iterator();
        while (it.hasNext()) {
            compileFiles((List) ScriptBytecodeAdapter.castToType(it.next(), List.class));
        }
    }

    /* JADX INFO: compiled from: GenerateProtoTask.groovy */
    public final class _compile_closure12 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;

        public _compile_closure12(Object obj, Object obj2) {
            super(obj, obj2);
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _compile_closure12.class) {
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
            return ((DeleteSpec) obj).delete(new Object[]{((GenerateProtoTask) ScriptBytecodeAdapter.castToType(getThisObject(), GenerateProtoTask.class)).getOutputBaseDir()});
        }
    }

    /* JADX INFO: compiled from: GenerateProtoTask.groovy */
    public final class _compile_closure13 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;

        public _compile_closure13(Object obj, Object obj2) {
            super(obj, obj2);
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _compile_closure13.class) {
                return ScriptBytecodeAdapter.initMetaClass(this);
            }
            ClassInfo classInfo = $staticClassInfo;
            if (classInfo == null) {
                classInfo = ClassInfo.getClassInfo(getClass());
                $staticClassInfo = classInfo;
            }
            return classInfo.getMetaClass();
        }

        public Object call(PluginOptions pluginOptions) {
            return doCall(pluginOptions);
        }

        public Object doCall(PluginOptions pluginOptions) {
            String outputDir = ((GenerateProtoTask) ScriptBytecodeAdapter.castToType(getThisObject(), GenerateProtoTask.class)).getOutputDir(pluginOptions);
            File file = new File(outputDir);
            if (outputDir.endsWith(".jar") || outputDir.endsWith(".zip")) {
                file = file.getParentFile();
            }
            return Boolean.valueOf(file.mkdirs());
        }
    }

    /* JADX INFO: compiled from: GenerateProtoTask.groovy */
    public final class _compile_closure14 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;

        public _compile_closure14(Object obj, Object obj2) {
            super(obj, obj2);
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _compile_closure14.class) {
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
            return Boolean.valueOf(file.exists());
        }
    }

    /* JADX INFO: compiled from: GenerateProtoTask.groovy */
    public final class _compile_closure15 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;

        public _compile_closure15(Object obj, Object obj2) {
            super(obj, obj2);
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _compile_closure15.class) {
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
            return new GStringImpl(new Object[]{obj}, new String[]{"-I", ""}).toString();
        }
    }

    /* JADX INFO: compiled from: GenerateProtoTask.groovy */
    public final class _compile_closure16 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;
        private /* synthetic */ Reference baseCmd;

        public _compile_closure16(Object obj, Object obj2, Reference reference) {
            super(obj, obj2);
            this.baseCmd = reference;
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _compile_closure16.class) {
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
        public List getBaseCmd() {
            return (List) ScriptBytecodeAdapter.castToType(this.baseCmd.get(), List.class);
        }

        public Object doCall(Object obj) {
            PluginOptions pluginOptions = (PluginOptions) obj;
            List listPlus = DefaultGroovyMethods.plus((List) ScriptBytecodeAdapter.castToType(this.baseCmd.get(), List.class), new GStringImpl(new Object[]{pluginOptions.getName(), GenerateProtoTask.makeOptionsPrefix(pluginOptions.getOptions()), ((GenerateProtoTask) ScriptBytecodeAdapter.castToType(getThisObject(), GenerateProtoTask.class)).getOutputDir((PluginOptions) ScriptBytecodeAdapter.castToType(obj, PluginOptions.class))}, new String[]{"--", "_out=", "", ""}).toString());
            this.baseCmd.set(listPlus);
            return listPlus;
        }
    }

    /* JADX INFO: compiled from: GenerateProtoTask.groovy */
    public final class _compile_closure17 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;
        private /* synthetic */ Reference baseCmd;
        private /* synthetic */ Reference executableLocations;

        public _compile_closure17(Object obj, Object obj2, Reference reference, Reference reference2) {
            super(obj, obj2);
            this.executableLocations = reference;
            this.baseCmd = reference2;
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _compile_closure17.class) {
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
        public List getBaseCmd() {
            return (List) ScriptBytecodeAdapter.castToType(this.baseCmd.get(), List.class);
        }

        @Generated
        public Map getExecutableLocations() {
            return (Map) ScriptBytecodeAdapter.castToType(this.executableLocations.get(), Map.class);
        }

        public Object doCall(Object obj) {
            PluginOptions pluginOptions = (PluginOptions) obj;
            String name = pluginOptions.getName();
            ExecutableLocator executableLocator = (ExecutableLocator) ScriptBytecodeAdapter.castToType(((SortedMap) this.executableLocations.get()).get(name), ExecutableLocator.class);
            if (executableLocator != null) {
                this.baseCmd.set(DefaultGroovyMethods.plus((List) ScriptBytecodeAdapter.castToType(this.baseCmd.get(), List.class), new GStringImpl(new Object[]{name, InvokerHelper.invokeMethodSafe((GenerateProtoTask) getThisObject(), "computeExecutablePath", new Object[]{executableLocator})}, new String[]{"--plugin=protoc-gen-", "=", ""}).toString()));
            } else {
                ((GenerateProtoTask) ((DefaultTask) ScriptBytecodeAdapter.castToType(getThisObject(), DefaultTask.class))).getLogger().warn(ShortTypeHandling.castToString(new GStringImpl(new Object[]{name, name}, new String[]{"protoc plugin '", "' not defined. Trying to use 'protoc-gen-", "' from system path"})));
            }
            List listPlus = DefaultGroovyMethods.plus((List) ScriptBytecodeAdapter.castToType(this.baseCmd.get(), List.class), new GStringImpl(new Object[]{name, GenerateProtoTask.makeOptionsPrefix(pluginOptions.getOptions()), ((GenerateProtoTask) ScriptBytecodeAdapter.castToType(getThisObject(), GenerateProtoTask.class)).getOutputDir((PluginOptions) ScriptBytecodeAdapter.castToType(obj, PluginOptions.class))}, new String[]{"--", "_out=", "", ""}).toString());
            this.baseCmd.set(listPlus);
            return listPlus;
        }
    }

    @Nested
    @Optional
    protected DescriptorSetOptions getDescriptorSetOptionsForCaching() {
        return (DescriptorSetOptions) ScriptBytecodeAdapter.castToType(this.generateDescriptorSet ? this.descriptorSetOptions : null, DescriptorSetOptions.class);
    }

    @Nested
    protected Collection<PluginOptions> getBuiltinsForCaching() {
        return this.builtins;
    }

    @Nested
    protected Collection<PluginOptions> getPluginsForCaching() {
        return this.plugins;
    }

    private void checkInitializing() {
        Preconditions.checkState(ScriptBytecodeAdapter.compareEqual(this.state, State.INIT), "Should not be called after initilization has finished");
    }

    private void checkCanConfig() {
        Preconditions.checkState(ScriptBytecodeAdapter.compareEqual(this.state, State.CONFIG) || ScriptBytecodeAdapter.compareEqual(this.state, State.INIT), "Should not be called after configuration has finished");
    }

    private void compileFiles(List<String> list) throws Throwable {
        getLogger().log(LogLevel.INFO, list.toString());
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        Process processExecute = ProcessGroovyMethods.execute(list);
        ProcessGroovyMethods.waitForProcessOutput(processExecute, stringBuffer, stringBuffer2);
        String strCastToString = ShortTypeHandling.castToString(new GStringImpl(new Object[]{stringBuffer, stringBuffer2}, new String[]{"protoc: stdout: ", ". stderr: ", ""}));
        if (processExecute.exitValue() == 0) {
            getLogger().log(LogLevel.INFO, strCastToString);
            return;
        }
        throw new GradleException(strCastToString);
    }

    protected String computeExecutablePath(ExecutableLocator executableLocator) throws Throwable {
        if (executableLocator.getPath() != null) {
            boolean zEndsWith = executableLocator.getPath().endsWith(JAR_SUFFIX);
            String path = executableLocator.getPath();
            return zEndsWith ? createJarTrampolineScript(path) : path;
        }
        File singleFile = executableLocator.getArtifactFiles().getSingleFile();
        if (singleFile.getName().endsWith(JAR_SUFFIX)) {
            return createJarTrampolineScript(singleFile.getAbsolutePath());
        }
        if (!singleFile.canExecute() && !singleFile.setExecutable(true)) {
            throw new GradleException(ShortTypeHandling.castToString(new GStringImpl(new Object[]{singleFile}, new String[]{"Cannot set ", " as executable"})));
        }
        getLogger().info(ShortTypeHandling.castToString(new GStringImpl(new Object[]{singleFile}, new String[]{"Resolved artifact: ", ""})));
        return singleFile.getPath();
    }

    private String createJarTrampolineScript(String str) throws Throwable {
        GStringImpl gStringImpl;
        ValueRecorder valueRecorder = new ValueRecorder();
        try {
            valueRecorder.record(str, 8);
            String str2 = JAR_SUFFIX;
            valueRecorder.record(str2, 33);
            valueRecorder.record(str2, 33);
            boolean zEndsWith = str.endsWith(str2);
            valueRecorder.record(Boolean.valueOf(zEndsWith), 24);
            if (zEndsWith) {
                valueRecorder.clear();
            } else {
                ScriptBytecodeAdapter.assertFailed(AssertionRenderer.render("assert jarAbsolutePath.endsWith(JAR_SUFFIX)", valueRecorder), (Object) null);
            }
            boolean zIsWindows = isWindows();
            String name = new File(str).getName();
            if (name.length() <= str2.length()) {
                throw new GradleException(ShortTypeHandling.castToString(new GStringImpl(new Object[]{str}, new String[]{".jar protoc plugin path '", "' has no file name"})));
            }
            File file = new File(ShortTypeHandling.castToString(new GStringImpl(new Object[]{this.projectLayout.getBuildDirectory().get()}, new String[]{"", "/scripts/"}).plus(StringGroovyMethods.getAt(name, new IntRange(true, 0, (name.length() - str2.length()) - 1))).plus(new GStringImpl(new Object[]{getName()}, new String[]{"-", "-trampoline."})).plus(zIsWindows ? "bat" : "sh")));
            try {
                mkdirsForFile(file);
                String strComputeJavaExePath = computeJavaExePath(zIsWindows);
                if (zIsWindows) {
                    gStringImpl = new GStringImpl(new Object[]{escapePathWindows(strComputeJavaExePath), escapePathWindows(str)}, new String[]{"@ECHO OFF\r\n\"", "\" -jar \"", "\" %*\r\n"});
                } else {
                    gStringImpl = new GStringImpl(new Object[]{escapePathUnix(strComputeJavaExePath), escapePathUnix(str)}, new String[]{"#!/bin/sh\nexec '", "' -jar '", "' \"$@\"\n"});
                }
                String strCastToString = ShortTypeHandling.castToString(gStringImpl);
                String str3 = strCastToString;
                ResourceGroovyMethods.write(file, strCastToString, StandardCharsets.US_ASCII.name());
                setExecutableOrFail(file);
                GenerateProtoTask generateProtoTask = this;
                Logger logger = getLogger();
                String strCastToString2 = ShortTypeHandling.castToString(new GStringImpl(new Object[]{str, file}, new String[]{"Resolved artifact jar: ", ". Created trampoline file: ", ""}));
                String str4 = strCastToString2;
                logger.info(strCastToString2);
                return file.getPath();
            } catch (IOException e) {
                throw new GradleException("Unable to generate trampoline for .jar protoc plugin", e);
            }
        } catch (Throwable th) {
            valueRecorder.clear();
            throw th;
        }
    }
}
