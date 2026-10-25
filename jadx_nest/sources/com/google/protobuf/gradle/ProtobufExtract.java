package com.google.protobuf.gradle;

import groovy.lang.Closure;
import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;
import groovy.lang.Reference;
import groovy.transform.Generated;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;
import org.codehaus.groovy.reflection.ClassInfo;
import org.codehaus.groovy.runtime.DefaultGroovyMethods;
import org.codehaus.groovy.runtime.GStringImpl;
import org.codehaus.groovy.runtime.GeneratedClosure;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.codehaus.groovy.runtime.typehandling.DefaultTypeTransformation;
import org.codehaus.groovy.runtime.typehandling.ShortTypeHandling;
import org.gradle.api.Action;
import org.gradle.api.DefaultTask;
import org.gradle.api.Transformer;
import org.gradle.api.file.ConfigurableFileCollection;
import org.gradle.api.file.CopySpec;
import org.gradle.api.file.DirectoryProperty;
import org.gradle.api.file.DuplicatesStrategy;
import org.gradle.api.file.FileCollection;
import org.gradle.api.file.FileSystemLocation;
import org.gradle.api.file.FileTree;
import org.gradle.api.logging.Logger;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.tasks.InputFiles;
import org.gradle.api.tasks.Internal;
import org.gradle.api.tasks.OutputDirectory;
import org.gradle.api.tasks.PathSensitive;
import org.gradle.api.tasks.PathSensitivity;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.tasks.util.PatternFilterable;
import org.gradle.api.tasks.util.PatternSet;
import org.gradle.util.GradleVersion;

/* JADX INFO: compiled from: ProtobufExtract.groovy */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ProtobufExtract extends DefaultTask implements GroovyObject {
    private static /* synthetic */ ClassInfo $staticClassInfo;
    private static /* synthetic */ ClassInfo $staticClassInfo$;
    public static transient /* synthetic */ boolean __$stMC;
    private final CopyActionFacade copyActionFacade = CopyActionFacade.Loader.create(getProject(), getObjectFactory());
    private final ArchiveActionFacade archiveActionFacade = instantiateArchiveActionFacade();
    private final FileCollection filteredProtos = instantiateFilteredProtos();
    private transient /* synthetic */ MetaClass metaClass = $getStaticMetaClass();

    protected /* synthetic */ MetaClass $getStaticMetaClass() {
        if (getClass() != ProtobufExtract.class) {
            return ScriptBytecodeAdapter.initMetaClass(this);
        }
        ClassInfo classInfo = $staticClassInfo;
        if (classInfo == null) {
            classInfo = ClassInfo.getClassInfo(getClass());
            $staticClassInfo = classInfo;
        }
        return classInfo.getMetaClass();
    }

    @OutputDirectory
    public abstract DirectoryProperty getDestDir();

    @Internal
    public abstract ConfigurableFileCollection getInputFiles();

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
    protected abstract ObjectFactory getObjectFactory();

    @Generated
    @groovy.transform.Internal
    public Object getProperty(String str) {
        return getMetaClass().getProperty(this, str);
    }

    @Inject
    protected abstract ProviderFactory getProviderFactory();

    @Generated
    @groovy.transform.Internal
    public Object invokeMethod(String str, Object obj) {
        return getMetaClass().invokeMethod(this, str, obj);
    }

    @Generated
    @groovy.transform.Internal
    public void setMetaClass(MetaClass metaClass) {
        this.metaClass = metaClass;
    }

    @Generated
    public ProtobufExtract() {
    }

    /* JADX INFO: compiled from: ProtobufExtract.groovy */
    public final class _getInputProtoFiles_closure1 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;

        public _getInputProtoFiles_closure1(Object obj, Object obj2) {
            super(obj, obj2);
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _getInputProtoFiles_closure1.class) {
                return ScriptBytecodeAdapter.initMetaClass(this);
            }
            ClassInfo classInfo = $staticClassInfo;
            if (classInfo == null) {
                classInfo = ClassInfo.getClassInfo(getClass());
                $staticClassInfo = classInfo;
            }
            return classInfo.getMetaClass();
        }

        public Object call(PatternFilterable patternFilterable) {
            return doCall(patternFilterable);
        }

        public Object doCall(PatternFilterable patternFilterable) {
            return patternFilterable.include(new String[]{"**/*.proto"});
        }
    }

    @InputFiles
    @PathSensitive(PathSensitivity.RELATIVE)
    public FileTree getInputProtoFiles() {
        return this.filteredProtos.getAsFileTree().matching(new _getInputProtoFiles_closure1(this, this));
    }

    /* JADX INFO: compiled from: ProtobufExtract.groovy */
    public final class _extract_closure2 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;

        public _extract_closure2(Object obj, Object obj2) {
            super(obj, obj2);
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _extract_closure2.class) {
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
            CopySpec copySpec = (CopySpec) obj;
            copySpec.setIncludeEmptyDirs(false);
            copySpec.from(new Object[]{((ProtobufExtract) ScriptBytecodeAdapter.castToType(getThisObject(), ProtobufExtract.class)).getInputProtoFiles()});
            copySpec.into(((ProtobufExtract) ScriptBytecodeAdapter.castToType(getThisObject(), ProtobufExtract.class)).getDestDir());
            DuplicatesStrategy duplicatesStrategy = DuplicatesStrategy.INCLUDE;
            copySpec.setDuplicatesStrategy(duplicatesStrategy);
            return duplicatesStrategy;
        }
    }

    @TaskAction
    public void extract() {
        this.copyActionFacade.copy((Action) ScriptBytecodeAdapter.castToType(new _extract_closure2(this, this), Action.class));
    }

    private ArchiveActionFacade instantiateArchiveActionFacade() {
        if (ScriptBytecodeAdapter.compareGreaterThanEqual(GradleVersion.current(), GradleVersion.version("6.0"))) {
            return (ArchiveActionFacade) ScriptBytecodeAdapter.castToType(getObjectFactory().newInstance(ArchiveActionFacade.ServiceBased.class, new Object[0]), ArchiveActionFacade.class);
        }
        return new ArchiveActionFacade.ProjectBased(getProject());
    }

    private FileCollection instantiateFilteredProtos() {
        return getObjectFactory().fileCollection().from(new Object[]{getInputFiles().filter(new _instantiateFilteredProtos_closure3(this, this))}).from(new Object[]{getInputFiles().getElements().map((Transformer) ScriptBytecodeAdapter.castToType(new _instantiateFilteredProtos_closure4(this, this, new Reference(false), new Reference(getLogger()), new Reference(this.archiveActionFacade), new Reference(new PatternSet().include(new String[]{"**/*.proto"}))), Transformer.class))});
    }

    /* JADX INFO: compiled from: ProtobufExtract.groovy */
    public final class _instantiateFilteredProtos_closure3 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;

        public _instantiateFilteredProtos_closure3(Object obj, Object obj2) {
            super(obj, obj2);
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _instantiateFilteredProtos_closure3.class) {
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
            return false;
        }
    }

    /* JADX INFO: compiled from: ProtobufExtract.groovy */
    public final class _instantiateFilteredProtos_closure4 extends Closure implements GeneratedClosure {
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;
        private /* synthetic */ Reference archiveFacade;
        private /* synthetic */ Reference logger;
        private /* synthetic */ Reference protoFilter;
        private /* synthetic */ Reference warningLogged;

        public _instantiateFilteredProtos_closure4(Object obj, Object obj2, Reference reference, Reference reference2, Reference reference3, Reference reference4) {
            super(obj, obj2);
            this.warningLogged = reference;
            this.logger = reference2;
            this.archiveFacade = reference3;
            this.protoFilter = reference4;
        }

        protected /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _instantiateFilteredProtos_closure4.class) {
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
        public ArchiveActionFacade getArchiveFacade() {
            return (ArchiveActionFacade) ScriptBytecodeAdapter.castToType(this.archiveFacade.get(), ArchiveActionFacade.class);
        }

        @Generated
        public Logger getLogger() {
            return (Logger) ScriptBytecodeAdapter.castToType(this.logger.get(), Logger.class);
        }

        @Generated
        public PatternSet getProtoFilter() {
            return (PatternSet) ScriptBytecodeAdapter.castToType(this.protoFilter.get(), PatternSet.class);
        }

        @Generated
        public Boolean getWarningLogged() {
            return (Boolean) ScriptBytecodeAdapter.castToType(this.warningLogged.get(), Boolean.class);
        }

        public Object doCall(Object obj) {
            Reference reference = new Reference((Set) ScriptBytecodeAdapter.asType(ScriptBytecodeAdapter.createList(new Object[0]), Set.class));
            Iterator it = ((Set) obj).iterator();
            while (it.hasNext()) {
                File asFile = ((FileSystemLocation) ScriptBytecodeAdapter.castToType(it.next(), FileSystemLocation.class)).getAsFile();
                if (asFile.isDirectory()) {
                    ((Set) reference.get()).add(asFile);
                } else if (asFile.getPath().endsWith(".proto")) {
                    if (!DefaultTypeTransformation.booleanUnbox(this.warningLogged.get())) {
                        this.warningLogged.set(true);
                        ((Logger) this.logger.get()).warn(ShortTypeHandling.castToString(new GStringImpl(new Object[]{asFile.getPath()}, new String[]{"proto file '", "' directly specified in configuration. "}).plus("It's likely you specified files('path/to/foo.proto') or ").plus("fileTree('path/to/directory') in protobuf or compile configuration. ").plus("This makes you vulnerable to ").plus("https://github.com/google/protobuf-gradle-plugin/issues/248. ").plus("Please use files('path/to/directory') instead.")));
                    }
                    ((Set) reference.get()).add(asFile);
                } else if (asFile.getPath().endsWith(".jar") || asFile.getPath().endsWith(".zip")) {
                    ((Set) reference.get()).add(((ArchiveActionFacade) this.archiveFacade.get()).zipTree(asFile.getPath()).matching((PatternFilterable) ScriptBytecodeAdapter.castToType(this.protoFilter.get(), PatternFilterable.class)));
                } else if (asFile.getPath().endsWith(".aar")) {
                    DefaultGroovyMethods.each(((ArchiveActionFacade) this.archiveFacade.get()).zipTree(asFile.getPath()).filter(new _closure5(this, getThisObject())), new _closure6(this, getThisObject(), reference, this.archiveFacade, this.protoFilter));
                } else if (asFile.getPath().endsWith(".tar") || asFile.getPath().endsWith(".tar.gz") || asFile.getPath().endsWith(".tar.bz2") || asFile.getPath().endsWith(".tgz")) {
                    ((Set) reference.get()).add(((ArchiveActionFacade) this.archiveFacade.get()).tarTree(asFile.getPath()).matching((PatternFilterable) ScriptBytecodeAdapter.castToType(this.protoFilter.get(), PatternFilterable.class)));
                } else {
                    ((Logger) this.logger.get()).debug(ShortTypeHandling.castToString(new GStringImpl(new Object[]{asFile.getPath()}, new String[]{"Skipping unsupported file type (", ");"}).plus("handles only jar, tar, tar.gz, tar.bz2 & tgz")));
                }
            }
            return (Set) reference.get();
        }

        /* JADX INFO: compiled from: ProtobufExtract.groovy */
        public final class _closure5 extends Closure implements GeneratedClosure {
            private static /* synthetic */ ClassInfo $staticClassInfo;
            public static transient /* synthetic */ boolean __$stMC;

            public _closure5(Object obj, Object obj2) {
                super(obj, obj2);
            }

            protected /* synthetic */ MetaClass $getStaticMetaClass() {
                if (getClass() != _closure5.class) {
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
                return Boolean.valueOf(file.getPath().endsWith(".jar"));
            }
        }

        /* JADX INFO: compiled from: ProtobufExtract.groovy */
        public final class _closure6 extends Closure implements GeneratedClosure {
            private static /* synthetic */ ClassInfo $staticClassInfo;
            public static transient /* synthetic */ boolean __$stMC;
            private /* synthetic */ Reference archiveFacade;
            private /* synthetic */ Reference protoFilter;
            private /* synthetic */ Reference protoInputs;

            public _closure6(Object obj, Object obj2, Reference reference, Reference reference2, Reference reference3) {
                super(obj, obj2);
                this.protoInputs = reference;
                this.archiveFacade = reference2;
                this.protoFilter = reference3;
            }

            protected /* synthetic */ MetaClass $getStaticMetaClass() {
                if (getClass() != _closure6.class) {
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
            public ArchiveActionFacade getArchiveFacade() {
                return (ArchiveActionFacade) ScriptBytecodeAdapter.castToType(this.archiveFacade.get(), ArchiveActionFacade.class);
            }

            @Generated
            public PatternSet getProtoFilter() {
                return (PatternSet) ScriptBytecodeAdapter.castToType(this.protoFilter.get(), PatternSet.class);
            }

            @Generated
            public Set getProtoInputs() {
                return (Set) ScriptBytecodeAdapter.castToType(this.protoInputs.get(), Set.class);
            }

            public Object doCall(Object obj) {
                return Boolean.valueOf(((Set) this.protoInputs.get()).add(((ArchiveActionFacade) this.archiveFacade.get()).zipTree(obj).matching((PatternFilterable) ScriptBytecodeAdapter.castToType(this.protoFilter.get(), PatternFilterable.class))));
            }
        }
    }
}
