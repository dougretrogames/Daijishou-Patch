package com.google.protobuf.gradle;

import groovy.lang.Closure;
import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;
import groovy.lang.Reference;
import groovy.transform.Generated;
import groovy.transform.Internal;
import java.io.File;
import java.util.List;
import org.codehaus.groovy.reflection.ClassInfo;
import org.codehaus.groovy.runtime.DefaultGroovyMethods;
import org.codehaus.groovy.runtime.GeneratedClosure;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.codehaus.groovy.runtime.StringGroovyMethods;
import org.codehaus.groovy.runtime.typehandling.DefaultTypeTransformation;
import org.gradle.api.Action;
import org.gradle.api.Project;
import org.gradle.api.file.ConfigurableFileCollection;
import org.gradle.api.tasks.SourceSet;
import org.gradle.plugins.ide.idea.GenerateIdeaModule;
import org.gradle.plugins.ide.idea.model.IdeaModel;
import org.gradle.util.GradleVersion;

/* INFO: compiled from: Utils.groovy */
/* INFO: loaded from: classes4.dex */
public class Utils implements GroovyObject {
    private static /* synthetic */ ClassInfo $staticClassInfo = null;
    private static /* synthetic */ ClassInfo $staticClassInfo$ = null;
    private static final String ANDROID_BASE_PLUGIN_ID = "com.android.base";
    public static transient /* synthetic */ boolean __$stMC;
    private transient /* synthetic */ MetaClass metaClass = $getStaticMetaClass();
    private static final GradleVersion GRADLE_7_4 = GradleVersion.version("7.4");
    private static final List<String> ANDROID_PLUGIN_IDS = ScriptBytecodeAdapter.createList(new Object[]{"android", "android-library", "com.android.application", "com.android.feature", "com.android.instantapp", "com.android.library", "com.android.test"});

    @Generated
    public Utils() {
    }

    public static /* synthetic */ GradleVersion pfaccess$0(Utils utils) {
        return GRADLE_7_4;
    }

    protected /* synthetic */ MetaClass $getStaticMetaClass() {
        if (getClass() != Utils.class) {
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

    public static String getConfigName(String str, String str2) {
        return ScriptBytecodeAdapter.compareEqual(str, SourceSet.MAIN_SOURCE_SET_NAME) ? str2 : StringGroovyMethods.plus(str, StringGroovyMethods.capitalize(str2));
    }

    public static String getSourceSetSubstringForTaskNames(String str) {
        return ScriptBytecodeAdapter.compareEqual(str, SourceSet.MAIN_SOURCE_SET_NAME) ? "" : StringGroovyMethods.capitalize(str);
    }

    public static boolean isAndroidProject(Project project) {
        Reference reference = new Reference(project);
        return ((Project) reference.get()).getPlugins().hasPlugin(ANDROID_BASE_PLUGIN_ID) || DefaultGroovyMethods.any(ANDROID_PLUGIN_IDS, new _isAndroidProject_closure1(Utils.class, Utils.class, reference));
    }

    /* INFO: compiled from: Utils.groovy */
    public final class _isAndroidProject_closure1 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;
        private /* synthetic */ Reference project;

        public _isAndroidProject_closure1(Object obj, Object obj2, Reference reference) {
            super(obj, obj2);
            this.project = reference;
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _isAndroidProject_closure1.class) {
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
            return Boolean.valueOf(((Project) this.project.get()).getPlugins().hasPlugin(str));
        }
    }

    public static String getKotlinAndroidCompileTaskName(Project project, String str) {
        Preconditions.checkState(isAndroidProject(project));
        return StringGroovyMethods.plus(StringGroovyMethods.plus("compile", StringGroovyMethods.capitalize(str)), "Kotlin");
    }

    public static boolean isTest(String str) {
        return ScriptBytecodeAdapter.compareEqual(str, "test") || str.toLowerCase().contains("androidtest") || str.toLowerCase().contains("unittest");
    }

    /* INFO: compiled from: Utils.groovy */
    public final class _addToIdeSources_closure2 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;
        private /* synthetic */ Reference f;
        private /* synthetic */ Reference isGenerated;
        private /* synthetic */ Reference isTest;
        private /* synthetic */ Reference project;

        public _addToIdeSources_closure2(Object obj, Object obj2, Reference reference, Reference reference2, Reference reference3, Reference reference4) {
            super(obj, obj2);
            this.project = reference;
            this.isTest = reference2;
            this.f = reference3;
            this.isGenerated = reference4;
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _addToIdeSources_closure2.class) {
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
        public File getF() {
            return (File) ScriptBytecodeAdapter.castToType(this.f.get(), File.class);
        }

        @Generated
        public boolean getIsGenerated() {
            return DefaultTypeTransformation.booleanUnbox(this.isGenerated.get());
        }

        @Generated
        public boolean getIsTest() {
            return DefaultTypeTransformation.booleanUnbox(this.isTest.get());
        }

        @Generated
        public Project getProject() {
            return (Project) ScriptBytecodeAdapter.castToType(this.project.get(), Project.class);
        }

        public Object doCall(Object obj) {
            IdeaModel ideaModel = (IdeaModel) ScriptBytecodeAdapter.castToType(((Project) this.project.get()).getExtensions().findByType(IdeaModel.class), IdeaModel.class);
            if (DefaultTypeTransformation.booleanUnbox(this.isTest.get())) {
                if (ScriptBytecodeAdapter.compareGreaterThanEqual(GradleVersion.current(), Utils.pfaccess$0(null))) {
                    ((ConfigurableFileCollection) ScriptBytecodeAdapter.castToType(DefaultGroovyMethods.invokeMethod(ideaModel.getModule(), "getTestSources", (Object) null), ConfigurableFileCollection.class)).from(new Object[]{this.f.get()});
                } else {
                    ideaModel.getModule().setTestSourceDirs(DefaultGroovyMethods.plus(ideaModel.getModule().getTestSourceDirs(), this.f.get()));
                }
            } else {
                ideaModel.getModule().setSourceDirs(DefaultGroovyMethods.plus(ideaModel.getModule().getSourceDirs(), this.f.get()));
            }
            if (DefaultTypeTransformation.booleanUnbox(this.isGenerated.get())) {
                ideaModel.getModule().setGeneratedSourceDirs(DefaultGroovyMethods.plus(ideaModel.getModule().getGeneratedSourceDirs(), this.f.get()));
            }
            return DefaultGroovyMethods.each(((Project) this.project.get()).getTasks().withType(GenerateIdeaModule.class), new _closure3(this, getThisObject(), this.f));
        }

        /* INFO: compiled from: Utils.groovy */
        public final class _closure3 extends Closure implements GeneratedClosure {
            private static /* synthetic */ ClassInfo $staticClassInfo;
            public static transient /* synthetic */ boolean __$stMC;
            private /* synthetic */ Reference f;

            public _closure3(Object obj, Object obj2, Reference reference) {
                super(obj, obj2);
                this.f = reference;
            }

            protected /* synthetic */ MetaClass $getStaticMetaClass() {
                if (getClass() != _closure3.class) {
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
            public File getF() {
                return (File) ScriptBytecodeAdapter.castToType(this.f.get(), File.class);
            }

            public Object doCall(Object obj) {
                return ((GenerateIdeaModule) obj).doFirst(new _closure4(this, getThisObject(), this.f));
            }

            /* INFO: compiled from: Utils.groovy */
            public final class _closure4 extends Closure implements GeneratedClosure {
                private static /* synthetic */ ClassInfo $staticClassInfo;
                public static transient /* synthetic */ boolean __$stMC;
                private /* synthetic */ Reference f;

                public _closure4(Object obj, Object obj2, Reference reference) {
                    super(obj, obj2);
                    this.f = reference;
                }

                protected /* synthetic */ MetaClass $getStaticMetaClass() {
                    if (getClass() != _closure4.class) {
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
                public File getF() {
                    return (File) ScriptBytecodeAdapter.castToType(this.f.get(), File.class);
                }

                public Object doCall(Object obj) {
                    return Boolean.valueOf(((File) this.f.get()).mkdirs());
                }
            }
        }
    }

    public static void addToIdeSources(Project project, boolean z, File file, boolean z2) {
        Reference reference = new Reference(project);
        ((Project) reference.get()).getPlugins().withId("idea", (Action) ScriptBytecodeAdapter.castToType(new _addToIdeSources_closure2(Utils.class, Utils.class, reference, new Reference(Boolean.valueOf(z)), new Reference(file), new Reference(Boolean.valueOf(z2))), Action.class));
    }
}
