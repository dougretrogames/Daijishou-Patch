package com.google.protobuf;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
import org.apache.commons.io.FilenameUtils;
import org.eclipse.jgit.lib.BranchConfig;

/* JADX INFO: loaded from: classes4.dex */
@CheckReturnValue
public final class Descriptors {
    private static final Logger logger = Logger.getLogger(Descriptors.class.getName());
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final Descriptor[] EMPTY_DESCRIPTORS = new Descriptor[0];
    private static final FieldDescriptor[] EMPTY_FIELD_DESCRIPTORS = new FieldDescriptor[0];
    private static final EnumDescriptor[] EMPTY_ENUM_DESCRIPTORS = new EnumDescriptor[0];
    private static final ServiceDescriptor[] EMPTY_SERVICE_DESCRIPTORS = new ServiceDescriptor[0];
    private static final OneofDescriptor[] EMPTY_ONEOF_DESCRIPTORS = new OneofDescriptor[0];
    private static final ConcurrentHashMap<Integer, DescriptorProtos.FeatureSet> FEATURE_CACHE = new ConcurrentHashMap<>();
    private static volatile DescriptorProtos.FeatureSetDefaults javaEditionDefaults = null;

    private interface NumberGetter<T> {
        int getNumber(T t);
    }

    static void setTestJavaEditionDefaults(DescriptorProtos.FeatureSetDefaults defaults) {
        javaEditionDefaults = defaults;
    }

    static DescriptorProtos.FeatureSetDefaults getJavaEditionDefaults() {
        DescriptorProtos.FeatureSetDefaults.getDescriptor();
        JavaFeaturesProto.getDescriptor();
        if (javaEditionDefaults == null) {
            synchronized (Descriptors.class) {
                if (javaEditionDefaults == null) {
                    try {
                        ExtensionRegistry extensionRegistryNewInstance = ExtensionRegistry.newInstance();
                        extensionRegistryNewInstance.add((GeneratedMessage.GeneratedExtension<?, ?>) JavaFeaturesProto.java_);
                        setTestJavaEditionDefaults(DescriptorProtos.FeatureSetDefaults.parseFrom(JavaEditionDefaults.PROTOBUF_INTERNAL_JAVA_EDITION_DEFAULTS.getBytes(Internal.ISO_8859_1), extensionRegistryNewInstance));
                    } catch (Exception e) {
                        throw new AssertionError(e);
                    }
                }
            }
        }
        return javaEditionDefaults;
    }

    static DescriptorProtos.FeatureSet getEditionDefaults(DescriptorProtos.Edition edition) {
        DescriptorProtos.FeatureSetDefaults javaEditionDefaults2 = getJavaEditionDefaults();
        if (edition.getNumber() < javaEditionDefaults2.getMinimumEdition().getNumber()) {
            throw new IllegalArgumentException("Edition " + edition + " is lower than the minimum supported edition " + javaEditionDefaults2.getMinimumEdition() + "!");
        }
        if (edition.getNumber() > javaEditionDefaults2.getMaximumEdition().getNumber()) {
            throw new IllegalArgumentException("Edition " + edition + " is greater than the maximum supported edition " + javaEditionDefaults2.getMaximumEdition() + "!");
        }
        DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault featureSetEditionDefault = null;
        for (DescriptorProtos.FeatureSetDefaults.FeatureSetEditionDefault featureSetEditionDefault2 : javaEditionDefaults2.getDefaultsList()) {
            if (featureSetEditionDefault2.getEdition().getNumber() > edition.getNumber()) {
                break;
            }
            featureSetEditionDefault = featureSetEditionDefault2;
        }
        if (featureSetEditionDefault == null) {
            throw new IllegalArgumentException("Edition " + edition + " does not have a valid default FeatureSet!");
        }
        return featureSetEditionDefault.getFixedFeatures().toBuilder().mergeFrom(featureSetEditionDefault.getOverridableFeatures()).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DescriptorProtos.FeatureSet internFeatures(DescriptorProtos.FeatureSet features) {
        DescriptorProtos.FeatureSet featureSetPutIfAbsent = FEATURE_CACHE.putIfAbsent(Integer.valueOf(features.hashCode()), features);
        return featureSetPutIfAbsent == null ? features : featureSetPutIfAbsent;
    }

    public static final class FileDescriptor extends GenericDescriptor {
        private final FileDescriptor[] dependencies;
        private final EnumDescriptor[] enumTypes;
        private final FieldDescriptor[] extensions;
        private final Descriptor[] messageTypes;
        private volatile DescriptorProtos.FileOptions options;
        private final DescriptorPool pool;

        /* JADX INFO: renamed from: proto, reason: collision with root package name */
        private DescriptorProtos.FileDescriptorProto f58proto;
        private final FileDescriptor[] publicDependencies;
        private final ServiceDescriptor[] services;

        @Deprecated
        public interface InternalDescriptorAssigner {
            ExtensionRegistry assignDescriptors(FileDescriptor root);
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.FileDescriptorProto toProto() {
            return this.f58proto;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.f58proto.getName();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.f58proto.getName();
        }

        public String getPackage() {
            return this.f58proto.getPackage();
        }

        public DescriptorProtos.FileOptions getOptions() {
            if (this.options == null) {
                DescriptorProtos.FileOptions options = this.f58proto.getOptions();
                if (options.hasFeatures()) {
                    options = options.toBuilder().clearFeatures().build();
                }
                synchronized (this) {
                    if (this.options == null) {
                        this.options = options;
                    }
                }
            }
            return this.options;
        }

        public List<Descriptor> getMessageTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.messageTypes));
        }

        public List<EnumDescriptor> getEnumTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.enumTypes));
        }

        public List<ServiceDescriptor> getServices() {
            return Collections.unmodifiableList(Arrays.asList(this.services));
        }

        public List<FieldDescriptor> getExtensions() {
            return Collections.unmodifiableList(Arrays.asList(this.extensions));
        }

        public List<FileDescriptor> getDependencies() {
            return Collections.unmodifiableList(Arrays.asList(this.dependencies));
        }

        public List<FileDescriptor> getPublicDependencies() {
            return Collections.unmodifiableList(Arrays.asList(this.publicDependencies));
        }

        DescriptorProtos.Edition getEdition() {
            String syntax = this.f58proto.getSyntax();
            syntax.hashCode();
            if (syntax.equals("proto3")) {
                return DescriptorProtos.Edition.EDITION_PROTO3;
            }
            if (syntax.equals("editions")) {
                return this.f58proto.getEdition();
            }
            return DescriptorProtos.Edition.EDITION_PROTO2;
        }

        public void copyHeadingTo(DescriptorProtos.FileDescriptorProto.Builder protoBuilder) {
            protoBuilder.setName(getName()).setSyntax(this.f58proto.getSyntax());
            if (!getPackage().isEmpty()) {
                protoBuilder.setPackage(getPackage());
            }
            if (this.f58proto.getSyntax().equals("editions")) {
                protoBuilder.setEdition(this.f58proto.getEdition());
            }
            if (!this.f58proto.hasOptions() || this.f58proto.getOptions().equals(DescriptorProtos.FileOptions.getDefaultInstance())) {
                return;
            }
            protoBuilder.setOptions(this.f58proto.getOptions());
        }

        public Descriptor findMessageTypeByName(String name) {
            if (name.indexOf(46) != -1) {
                return null;
            }
            String str = getPackage();
            if (!str.isEmpty()) {
                name = str + FilenameUtils.EXTENSION_SEPARATOR + name;
            }
            GenericDescriptor genericDescriptorFindSymbol = this.pool.findSymbol(name);
            if ((genericDescriptorFindSymbol instanceof Descriptor) && genericDescriptorFindSymbol.getFile() == this) {
                return (Descriptor) genericDescriptorFindSymbol;
            }
            return null;
        }

        public EnumDescriptor findEnumTypeByName(String name) {
            if (name.indexOf(46) != -1) {
                return null;
            }
            String str = getPackage();
            if (!str.isEmpty()) {
                name = str + FilenameUtils.EXTENSION_SEPARATOR + name;
            }
            GenericDescriptor genericDescriptorFindSymbol = this.pool.findSymbol(name);
            if ((genericDescriptorFindSymbol instanceof EnumDescriptor) && genericDescriptorFindSymbol.getFile() == this) {
                return (EnumDescriptor) genericDescriptorFindSymbol;
            }
            return null;
        }

        public ServiceDescriptor findServiceByName(String name) {
            if (name.indexOf(46) != -1) {
                return null;
            }
            String str = getPackage();
            if (!str.isEmpty()) {
                name = str + FilenameUtils.EXTENSION_SEPARATOR + name;
            }
            GenericDescriptor genericDescriptorFindSymbol = this.pool.findSymbol(name);
            if ((genericDescriptorFindSymbol instanceof ServiceDescriptor) && genericDescriptorFindSymbol.getFile() == this) {
                return (ServiceDescriptor) genericDescriptorFindSymbol;
            }
            return null;
        }

        public FieldDescriptor findExtensionByName(String name) {
            if (name.indexOf(46) != -1) {
                return null;
            }
            String str = getPackage();
            if (!str.isEmpty()) {
                name = str + FilenameUtils.EXTENSION_SEPARATOR + name;
            }
            GenericDescriptor genericDescriptorFindSymbol = this.pool.findSymbol(name);
            if ((genericDescriptorFindSymbol instanceof FieldDescriptor) && genericDescriptorFindSymbol.getFile() == this) {
                return (FieldDescriptor) genericDescriptorFindSymbol;
            }
            return null;
        }

        public static FileDescriptor buildFrom(DescriptorProtos.FileDescriptorProto proto2, FileDescriptor[] dependencies) throws DescriptorValidationException {
            return buildFrom(proto2, dependencies, false);
        }

        public static FileDescriptor buildFrom(DescriptorProtos.FileDescriptorProto proto2, FileDescriptor[] dependencies, boolean allowUnknownDependencies) throws DescriptorValidationException {
            return buildFrom(proto2, dependencies, allowUnknownDependencies, false);
        }

        private static FileDescriptor buildFrom(DescriptorProtos.FileDescriptorProto proto2, FileDescriptor[] dependencies, boolean allowUnknownDependencies, boolean allowUnresolvedFeatures) throws DescriptorValidationException {
            FileDescriptor fileDescriptor = new FileDescriptor(proto2, dependencies, new DescriptorPool(dependencies, allowUnknownDependencies), allowUnknownDependencies);
            fileDescriptor.crossLink();
            if (!allowUnresolvedFeatures) {
                fileDescriptor.resolveAllFeaturesInternal();
            }
            return fileDescriptor;
        }

        private static byte[] latin1Cat(final String[] strings) {
            if (strings.length == 1) {
                return strings[0].getBytes(Internal.ISO_8859_1);
            }
            StringBuilder sb = new StringBuilder();
            for (String str : strings) {
                sb.append(str);
            }
            return sb.toString().getBytes(Internal.ISO_8859_1);
        }

        private static FileDescriptor[] findDescriptors(final Class<?> descriptorOuterClass, final String[] dependencyClassNames, final String[] dependencyFileNames) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < dependencyClassNames.length; i++) {
                try {
                    arrayList.add((FileDescriptor) descriptorOuterClass.getClassLoader().loadClass(dependencyClassNames[i]).getField("descriptor").get(null));
                } catch (Exception unused) {
                    Descriptors.logger.warning("Descriptors for \"" + dependencyFileNames[i] + "\" can not be found.");
                }
            }
            return (FileDescriptor[]) arrayList.toArray(new FileDescriptor[0]);
        }

        public static FileDescriptor internalBuildGeneratedFileFrom(final String[] descriptorDataParts, final FileDescriptor[] dependencies) {
            try {
                DescriptorProtos.FileDescriptorProto from = DescriptorProtos.FileDescriptorProto.parseFrom(latin1Cat(descriptorDataParts));
                try {
                    return buildFrom(from, dependencies, true, true);
                } catch (DescriptorValidationException e) {
                    throw new IllegalArgumentException("Invalid embedded descriptor for \"" + from.getName() + "\".", e);
                }
            } catch (InvalidProtocolBufferException e2) {
                throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e2);
            }
        }

        public static FileDescriptor internalBuildGeneratedFileFrom(final String[] descriptorDataParts, final Class<?> descriptorOuterClass, final String[] dependencyClassNames, final String[] dependencyFileNames) {
            return internalBuildGeneratedFileFrom(descriptorDataParts, findDescriptors(descriptorOuterClass, dependencyClassNames, dependencyFileNames));
        }

        public static void internalUpdateFileDescriptor(FileDescriptor descriptor, ExtensionRegistry registry) {
            try {
                descriptor.setProto(DescriptorProtos.FileDescriptorProto.parseFrom(descriptor.f58proto.toByteString(), registry));
            } catch (InvalidProtocolBufferException e) {
                throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e);
            }
        }

        private FileDescriptor(final DescriptorProtos.FileDescriptorProto proto2, final FileDescriptor[] dependencies, final DescriptorPool pool, boolean allowUnknownDependencies) throws DescriptorValidationException {
            Descriptor[] descriptorArr;
            EnumDescriptor[] enumDescriptorArr;
            ServiceDescriptor[] serviceDescriptorArr;
            FieldDescriptor[] fieldDescriptorArr;
            super(null);
            this.pool = pool;
            this.f58proto = proto2;
            this.dependencies = (FileDescriptor[]) dependencies.clone();
            HashMap map = new HashMap();
            for (FileDescriptor fileDescriptor : dependencies) {
                map.put(fileDescriptor.getName(), fileDescriptor);
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < proto2.getPublicDependencyCount(); i++) {
                int publicDependency = proto2.getPublicDependency(i);
                if (publicDependency < 0 || publicDependency >= proto2.getDependencyCount()) {
                    throw new DescriptorValidationException(this, "Invalid public dependency index.", (AnonymousClass1) null);
                }
                String dependency = proto2.getDependency(publicDependency);
                FileDescriptor fileDescriptor2 = (FileDescriptor) map.get(dependency);
                if (fileDescriptor2 != null) {
                    arrayList.add(fileDescriptor2);
                } else if (!allowUnknownDependencies) {
                    throw new DescriptorValidationException(this, "Invalid public dependency: " + dependency, (AnonymousClass1) null);
                }
            }
            FileDescriptor[] fileDescriptorArr = new FileDescriptor[arrayList.size()];
            this.publicDependencies = fileDescriptorArr;
            arrayList.toArray(fileDescriptorArr);
            pool.addPackage(getPackage(), this);
            if (proto2.getMessageTypeCount() <= 0) {
                descriptorArr = Descriptors.EMPTY_DESCRIPTORS;
            } else {
                descriptorArr = new Descriptor[proto2.getMessageTypeCount()];
            }
            this.messageTypes = descriptorArr;
            for (int i2 = 0; i2 < proto2.getMessageTypeCount(); i2++) {
                this.messageTypes[i2] = new Descriptor(proto2.getMessageType(i2), this, null, i2, null);
            }
            if (proto2.getEnumTypeCount() <= 0) {
                enumDescriptorArr = Descriptors.EMPTY_ENUM_DESCRIPTORS;
            } else {
                enumDescriptorArr = new EnumDescriptor[proto2.getEnumTypeCount()];
            }
            this.enumTypes = enumDescriptorArr;
            for (int i3 = 0; i3 < proto2.getEnumTypeCount(); i3++) {
                this.enumTypes[i3] = new EnumDescriptor(proto2.getEnumType(i3), this, null, i3, null);
            }
            if (proto2.getServiceCount() <= 0) {
                serviceDescriptorArr = Descriptors.EMPTY_SERVICE_DESCRIPTORS;
            } else {
                serviceDescriptorArr = new ServiceDescriptor[proto2.getServiceCount()];
            }
            this.services = serviceDescriptorArr;
            for (int i4 = 0; i4 < proto2.getServiceCount(); i4++) {
                this.services[i4] = new ServiceDescriptor(proto2.getService(i4), this, i4, null);
            }
            if (proto2.getExtensionCount() <= 0) {
                fieldDescriptorArr = Descriptors.EMPTY_FIELD_DESCRIPTORS;
            } else {
                fieldDescriptorArr = new FieldDescriptor[proto2.getExtensionCount()];
            }
            this.extensions = fieldDescriptorArr;
            for (int i5 = 0; i5 < proto2.getExtensionCount(); i5++) {
                this.extensions[i5] = new FieldDescriptor(proto2.getExtension(i5), this, null, i5, true, null);
            }
        }

        FileDescriptor(String packageName, Descriptor message) throws DescriptorValidationException {
            super(null);
            this.parent = null;
            DescriptorPool descriptorPool = new DescriptorPool(new FileDescriptor[0], true);
            this.pool = descriptorPool;
            this.f58proto = DescriptorProtos.FileDescriptorProto.newBuilder().setName(message.getFullName() + ".placeholder.proto").setPackage(packageName).addMessageType(message.toProto()).build();
            this.dependencies = new FileDescriptor[0];
            this.publicDependencies = new FileDescriptor[0];
            this.messageTypes = new Descriptor[]{message};
            this.enumTypes = Descriptors.EMPTY_ENUM_DESCRIPTORS;
            this.services = Descriptors.EMPTY_SERVICE_DESCRIPTORS;
            this.extensions = Descriptors.EMPTY_FIELD_DESCRIPTORS;
            descriptorPool.addPackage(packageName, this);
            descriptorPool.addSymbol(message);
        }

        public void resolveAllFeaturesImmutable() {
            try {
                resolveAllFeaturesInternal();
            } catch (DescriptorValidationException e) {
                throw new IllegalArgumentException("Invalid features for \"" + this.f58proto.getName() + "\".", e);
            }
        }

        private void resolveAllFeaturesInternal() throws DescriptorValidationException {
            if (this.features != null) {
                return;
            }
            synchronized (this) {
                if (this.features != null) {
                    return;
                }
                resolveFeatures(this.f58proto.getOptions().getFeatures());
                for (Descriptor descriptor : this.messageTypes) {
                    descriptor.resolveAllFeatures();
                }
                for (EnumDescriptor enumDescriptor : this.enumTypes) {
                    enumDescriptor.resolveAllFeatures();
                }
                for (ServiceDescriptor serviceDescriptor : this.services) {
                    serviceDescriptor.resolveAllFeatures();
                }
                for (FieldDescriptor fieldDescriptor : this.extensions) {
                    fieldDescriptor.resolveAllFeatures();
                }
            }
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        DescriptorProtos.FeatureSet inferLegacyProtoFeatures() {
            DescriptorProtos.FeatureSet.Builder builderNewBuilder = DescriptorProtos.FeatureSet.newBuilder();
            if (getEdition().getNumber() >= DescriptorProtos.Edition.EDITION_2023.getNumber()) {
                return builderNewBuilder.build();
            }
            if (getEdition() == DescriptorProtos.Edition.EDITION_PROTO2 && this.f58proto.getOptions().getJavaStringCheckUtf8()) {
                builderNewBuilder.setExtension(JavaFeaturesProto.java_, JavaFeaturesProto.JavaFeatures.newBuilder().setUtf8Validation(JavaFeaturesProto.JavaFeatures.Utf8Validation.VERIFY).build());
            }
            return builderNewBuilder.build();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        boolean hasInferredLegacyProtoFeatures() {
            return getEdition().getNumber() < DescriptorProtos.Edition.EDITION_2023.getNumber() && getEdition() == DescriptorProtos.Edition.EDITION_PROTO2 && this.f58proto.getOptions().getJavaStringCheckUtf8();
        }

        private void crossLink() throws DescriptorValidationException {
            for (Descriptor descriptor : this.messageTypes) {
                descriptor.crossLink();
            }
            for (ServiceDescriptor serviceDescriptor : this.services) {
                serviceDescriptor.crossLink();
            }
            for (FieldDescriptor fieldDescriptor : this.extensions) {
                fieldDescriptor.crossLink();
            }
        }

        private synchronized void setProto(final DescriptorProtos.FileDescriptorProto proto2) {
            this.f58proto = proto2;
            this.options = null;
            try {
                resolveFeatures(proto2.getOptions().getFeatures());
                int i = 0;
                int i2 = 0;
                while (true) {
                    Descriptor[] descriptorArr = this.messageTypes;
                    if (i2 >= descriptorArr.length) {
                        break;
                    }
                    descriptorArr[i2].setProto(proto2.getMessageType(i2));
                    i2++;
                    throw th;
                }
                int i3 = 0;
                while (true) {
                    EnumDescriptor[] enumDescriptorArr = this.enumTypes;
                    if (i3 >= enumDescriptorArr.length) {
                        break;
                    }
                    enumDescriptorArr[i3].setProto(proto2.getEnumType(i3));
                    i3++;
                    throw th;
                }
                int i4 = 0;
                while (true) {
                    ServiceDescriptor[] serviceDescriptorArr = this.services;
                    if (i4 >= serviceDescriptorArr.length) {
                        break;
                    }
                    serviceDescriptorArr[i4].setProto(proto2.getService(i4));
                    i4++;
                    throw th;
                }
                while (true) {
                    FieldDescriptor[] fieldDescriptorArr = this.extensions;
                    if (i < fieldDescriptorArr.length) {
                        fieldDescriptorArr[i].setProto(proto2.getExtension(i));
                        i++;
                    }
                }
            } catch (DescriptorValidationException e) {
                throw new IllegalArgumentException("Invalid features for \"" + proto2.getName() + "\".", e);
            }
        }
    }

    public static final class Descriptor extends GenericDescriptor {
        private final Descriptor containingType;
        private final EnumDescriptor[] enumTypes;
        private final int[] extensionRangeLowerBounds;
        private final int[] extensionRangeUpperBounds;
        private final FieldDescriptor[] extensions;
        private final FieldDescriptor[] fields;
        private final FieldDescriptor[] fieldsSortedByNumber;
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private final Descriptor[] nestedTypes;
        private final OneofDescriptor[] oneofs;
        private volatile DescriptorProtos.MessageOptions options;

        /* JADX INFO: renamed from: proto, reason: collision with root package name */
        private DescriptorProtos.DescriptorProto f53proto;
        private final int realOneofCount;

        /* synthetic */ Descriptor(DescriptorProtos.DescriptorProto descriptorProto, FileDescriptor fileDescriptor, Descriptor descriptor, int i, AnonymousClass1 anonymousClass1) throws DescriptorValidationException {
            this(descriptorProto, fileDescriptor, descriptor, i);
        }

        public int getIndex() {
            return this.index;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.DescriptorProto toProto() {
            return this.f53proto;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.f53proto.getName();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        public Descriptor getContainingType() {
            return this.containingType;
        }

        public DescriptorProtos.MessageOptions getOptions() {
            if (this.options == null) {
                DescriptorProtos.MessageOptions options = this.f53proto.getOptions();
                if (options.hasFeatures()) {
                    options = options.toBuilder().clearFeatures().build();
                }
                synchronized (this) {
                    if (this.options == null) {
                        this.options = options;
                    }
                }
            }
            return this.options;
        }

        public List<FieldDescriptor> getFields() {
            return Collections.unmodifiableList(Arrays.asList(this.fields));
        }

        public List<OneofDescriptor> getOneofs() {
            return Collections.unmodifiableList(Arrays.asList(this.oneofs));
        }

        public List<OneofDescriptor> getRealOneofs() {
            return Collections.unmodifiableList(Arrays.asList(this.oneofs).subList(0, this.realOneofCount));
        }

        public List<FieldDescriptor> getExtensions() {
            return Collections.unmodifiableList(Arrays.asList(this.extensions));
        }

        public List<Descriptor> getNestedTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.nestedTypes));
        }

        public List<EnumDescriptor> getEnumTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.enumTypes));
        }

        public boolean isExtensionNumber(final int number) {
            int iBinarySearch = Arrays.binarySearch(this.extensionRangeLowerBounds, number);
            if (iBinarySearch < 0) {
                iBinarySearch = (~iBinarySearch) - 1;
            }
            return iBinarySearch >= 0 && number < this.extensionRangeUpperBounds[iBinarySearch];
        }

        public boolean isReservedNumber(final int number) {
            for (DescriptorProtos.DescriptorProto.ReservedRange reservedRange : this.f53proto.getReservedRangeList()) {
                if (reservedRange.getStart() <= number && number < reservedRange.getEnd()) {
                    return true;
                }
            }
            return false;
        }

        public boolean isReservedName(final String name) {
            Internal.checkNotNull(name);
            Iterator<String> it = this.f53proto.getReservedNameList().iterator();
            while (it.hasNext()) {
                if (it.next().equals(name)) {
                    return true;
                }
            }
            return false;
        }

        public boolean isExtendable() {
            return !this.f53proto.getExtensionRangeList().isEmpty();
        }

        public FieldDescriptor findFieldByName(final String name) {
            GenericDescriptor genericDescriptorFindSymbol = this.file.pool.findSymbol(this.fullName + FilenameUtils.EXTENSION_SEPARATOR + name);
            if (genericDescriptorFindSymbol instanceof FieldDescriptor) {
                return (FieldDescriptor) genericDescriptorFindSymbol;
            }
            return null;
        }

        public FieldDescriptor findFieldByNumber(final int number) {
            FieldDescriptor[] fieldDescriptorArr = this.fieldsSortedByNumber;
            return (FieldDescriptor) Descriptors.binarySearch(fieldDescriptorArr, fieldDescriptorArr.length, FieldDescriptor.NUMBER_GETTER, number);
        }

        public Descriptor findNestedTypeByName(final String name) {
            GenericDescriptor genericDescriptorFindSymbol = this.file.pool.findSymbol(this.fullName + FilenameUtils.EXTENSION_SEPARATOR + name);
            if (genericDescriptorFindSymbol instanceof Descriptor) {
                return (Descriptor) genericDescriptorFindSymbol;
            }
            return null;
        }

        public EnumDescriptor findEnumTypeByName(final String name) {
            GenericDescriptor genericDescriptorFindSymbol = this.file.pool.findSymbol(this.fullName + FilenameUtils.EXTENSION_SEPARATOR + name);
            if (genericDescriptorFindSymbol instanceof EnumDescriptor) {
                return (EnumDescriptor) genericDescriptorFindSymbol;
            }
            return null;
        }

        Descriptor(final String fullname) throws DescriptorValidationException {
            String strSubstring;
            String strSubstring2;
            super(null);
            int iLastIndexOf = fullname.lastIndexOf(46);
            if (iLastIndexOf == -1) {
                strSubstring = "";
                strSubstring2 = fullname;
            } else {
                strSubstring2 = fullname.substring(iLastIndexOf + 1);
                strSubstring = fullname.substring(0, iLastIndexOf);
            }
            this.index = 0;
            this.f53proto = DescriptorProtos.DescriptorProto.newBuilder().setName(strSubstring2).addExtensionRange(DescriptorProtos.DescriptorProto.ExtensionRange.newBuilder().setStart(1).setEnd(536870912).build()).build();
            this.fullName = fullname;
            this.containingType = null;
            this.nestedTypes = Descriptors.EMPTY_DESCRIPTORS;
            this.enumTypes = Descriptors.EMPTY_ENUM_DESCRIPTORS;
            this.fields = Descriptors.EMPTY_FIELD_DESCRIPTORS;
            this.fieldsSortedByNumber = Descriptors.EMPTY_FIELD_DESCRIPTORS;
            this.extensions = Descriptors.EMPTY_FIELD_DESCRIPTORS;
            this.oneofs = Descriptors.EMPTY_ONEOF_DESCRIPTORS;
            this.realOneofCount = 0;
            FileDescriptor fileDescriptor = new FileDescriptor(strSubstring, this);
            this.file = fileDescriptor;
            this.parent = fileDescriptor;
            this.extensionRangeLowerBounds = new int[]{1};
            this.extensionRangeUpperBounds = new int[]{536870912};
        }

        private Descriptor(final DescriptorProtos.DescriptorProto proto2, final FileDescriptor file, final Descriptor parent, final int index) throws DescriptorValidationException {
            OneofDescriptor[] oneofDescriptorArr;
            Descriptor[] descriptorArr;
            EnumDescriptor[] enumDescriptorArr;
            FieldDescriptor[] fieldDescriptorArr;
            FieldDescriptor[] fieldDescriptorArr2;
            super(null);
            if (parent == null) {
                this.parent = file;
            } else {
                this.parent = parent;
            }
            this.index = index;
            this.f53proto = proto2;
            this.fullName = Descriptors.computeFullName(file, parent, proto2.getName());
            this.file = file;
            this.containingType = parent;
            if (proto2.getOneofDeclCount() <= 0) {
                oneofDescriptorArr = Descriptors.EMPTY_ONEOF_DESCRIPTORS;
            } else {
                oneofDescriptorArr = new OneofDescriptor[proto2.getOneofDeclCount()];
            }
            this.oneofs = oneofDescriptorArr;
            int i = 0;
            for (int i2 = 0; i2 < proto2.getOneofDeclCount(); i2++) {
                this.oneofs[i2] = new OneofDescriptor(proto2.getOneofDecl(i2), file, this, i2, null);
            }
            if (proto2.getNestedTypeCount() <= 0) {
                descriptorArr = Descriptors.EMPTY_DESCRIPTORS;
            } else {
                descriptorArr = new Descriptor[proto2.getNestedTypeCount()];
            }
            this.nestedTypes = descriptorArr;
            for (int i3 = 0; i3 < proto2.getNestedTypeCount(); i3++) {
                this.nestedTypes[i3] = new Descriptor(proto2.getNestedType(i3), file, this, i3);
            }
            if (proto2.getEnumTypeCount() <= 0) {
                enumDescriptorArr = Descriptors.EMPTY_ENUM_DESCRIPTORS;
            } else {
                enumDescriptorArr = new EnumDescriptor[proto2.getEnumTypeCount()];
            }
            this.enumTypes = enumDescriptorArr;
            for (int i4 = 0; i4 < proto2.getEnumTypeCount(); i4++) {
                this.enumTypes[i4] = new EnumDescriptor(proto2.getEnumType(i4), file, this, i4, null);
            }
            if (proto2.getFieldCount() <= 0) {
                fieldDescriptorArr = Descriptors.EMPTY_FIELD_DESCRIPTORS;
            } else {
                fieldDescriptorArr = new FieldDescriptor[proto2.getFieldCount()];
            }
            this.fields = fieldDescriptorArr;
            for (int i5 = 0; i5 < proto2.getFieldCount(); i5++) {
                this.fields[i5] = new FieldDescriptor(proto2.getField(i5), file, this, i5, false, null);
            }
            this.fieldsSortedByNumber = proto2.getFieldCount() > 0 ? (FieldDescriptor[]) this.fields.clone() : Descriptors.EMPTY_FIELD_DESCRIPTORS;
            if (proto2.getExtensionCount() <= 0) {
                fieldDescriptorArr2 = Descriptors.EMPTY_FIELD_DESCRIPTORS;
            } else {
                fieldDescriptorArr2 = new FieldDescriptor[proto2.getExtensionCount()];
            }
            this.extensions = fieldDescriptorArr2;
            for (int i6 = 0; i6 < proto2.getExtensionCount(); i6++) {
                this.extensions[i6] = new FieldDescriptor(proto2.getExtension(i6), file, this, i6, true, null);
            }
            for (int i7 = 0; i7 < proto2.getOneofDeclCount(); i7++) {
                OneofDescriptor oneofDescriptor = this.oneofs[i7];
                oneofDescriptor.fields = new FieldDescriptor[oneofDescriptor.getFieldCount()];
                this.oneofs[i7].fieldCount = 0;
            }
            for (int i8 = 0; i8 < proto2.getFieldCount(); i8++) {
                OneofDescriptor containingOneof = this.fields[i8].getContainingOneof();
                if (containingOneof != null) {
                    containingOneof.fields[OneofDescriptor.access$2908(containingOneof)] = this.fields[i8];
                }
            }
            int i9 = 0;
            for (OneofDescriptor oneofDescriptor2 : this.oneofs) {
                if (oneofDescriptor2.isSynthetic()) {
                    i9++;
                } else if (i9 > 0) {
                    throw new DescriptorValidationException(this, "Synthetic oneofs must come last.", (AnonymousClass1) null);
                }
            }
            this.realOneofCount = this.oneofs.length - i9;
            file.pool.addSymbol(this);
            if (proto2.getExtensionRangeCount() <= 0) {
                this.extensionRangeLowerBounds = Descriptors.EMPTY_INT_ARRAY;
                this.extensionRangeUpperBounds = Descriptors.EMPTY_INT_ARRAY;
                return;
            }
            this.extensionRangeLowerBounds = new int[proto2.getExtensionRangeCount()];
            this.extensionRangeUpperBounds = new int[proto2.getExtensionRangeCount()];
            for (DescriptorProtos.DescriptorProto.ExtensionRange extensionRange : proto2.getExtensionRangeList()) {
                this.extensionRangeLowerBounds[i] = extensionRange.getStart();
                this.extensionRangeUpperBounds[i] = extensionRange.getEnd();
                i++;
            }
            Arrays.sort(this.extensionRangeLowerBounds);
            Arrays.sort(this.extensionRangeUpperBounds);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void resolveAllFeatures() throws DescriptorValidationException {
            resolveFeatures(this.f53proto.getOptions().getFeatures());
            for (Descriptor descriptor : this.nestedTypes) {
                descriptor.resolveAllFeatures();
            }
            for (EnumDescriptor enumDescriptor : this.enumTypes) {
                enumDescriptor.resolveAllFeatures();
            }
            for (OneofDescriptor oneofDescriptor : this.oneofs) {
                oneofDescriptor.resolveAllFeatures();
            }
            for (FieldDescriptor fieldDescriptor : this.fields) {
                fieldDescriptor.resolveAllFeatures();
            }
            for (FieldDescriptor fieldDescriptor2 : this.extensions) {
                fieldDescriptor2.resolveAllFeatures();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void crossLink() throws DescriptorValidationException {
            for (Descriptor descriptor : this.nestedTypes) {
                descriptor.crossLink();
            }
            for (FieldDescriptor fieldDescriptor : this.fields) {
                fieldDescriptor.crossLink();
            }
            Arrays.sort(this.fieldsSortedByNumber);
            validateNoDuplicateFieldNumbers();
            for (FieldDescriptor fieldDescriptor2 : this.extensions) {
                fieldDescriptor2.crossLink();
            }
        }

        private void validateNoDuplicateFieldNumbers() throws DescriptorValidationException {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                FieldDescriptor[] fieldDescriptorArr = this.fieldsSortedByNumber;
                if (i2 >= fieldDescriptorArr.length) {
                    return;
                }
                FieldDescriptor fieldDescriptor = fieldDescriptorArr[i];
                FieldDescriptor fieldDescriptor2 = fieldDescriptorArr[i2];
                if (fieldDescriptor.getNumber() == fieldDescriptor2.getNumber()) {
                    throw new DescriptorValidationException(fieldDescriptor2, "Field number " + fieldDescriptor2.getNumber() + " has already been used in \"" + fieldDescriptor2.getContainingType().getFullName() + "\" by field \"" + fieldDescriptor.getName() + "\".", (AnonymousClass1) null);
                }
                i = i2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProto(final DescriptorProtos.DescriptorProto proto2) throws DescriptorValidationException {
            this.f53proto = proto2;
            this.options = null;
            resolveFeatures(proto2.getOptions().getFeatures());
            int i = 0;
            int i2 = 0;
            while (true) {
                Descriptor[] descriptorArr = this.nestedTypes;
                if (i2 >= descriptorArr.length) {
                    break;
                }
                descriptorArr[i2].setProto(proto2.getNestedType(i2));
                i2++;
            }
            int i3 = 0;
            while (true) {
                OneofDescriptor[] oneofDescriptorArr = this.oneofs;
                if (i3 >= oneofDescriptorArr.length) {
                    break;
                }
                oneofDescriptorArr[i3].setProto(proto2.getOneofDecl(i3));
                i3++;
            }
            int i4 = 0;
            while (true) {
                EnumDescriptor[] enumDescriptorArr = this.enumTypes;
                if (i4 >= enumDescriptorArr.length) {
                    break;
                }
                enumDescriptorArr[i4].setProto(proto2.getEnumType(i4));
                i4++;
            }
            int i5 = 0;
            while (true) {
                FieldDescriptor[] fieldDescriptorArr = this.fields;
                if (i5 >= fieldDescriptorArr.length) {
                    break;
                }
                fieldDescriptorArr[i5].setProto(proto2.getField(i5));
                i5++;
            }
            while (true) {
                FieldDescriptor[] fieldDescriptorArr2 = this.extensions;
                if (i >= fieldDescriptorArr2.length) {
                    return;
                }
                fieldDescriptorArr2[i].setProto(proto2.getExtension(i));
                i++;
            }
        }
    }

    public static final class FieldDescriptor extends GenericDescriptor implements Comparable<FieldDescriptor>, FieldSet.FieldDescriptorLite<FieldDescriptor> {
        private static final NumberGetter<FieldDescriptor> NUMBER_GETTER = new AnonymousClass1();
        private static final WireFormat.FieldType[] table = WireFormat.FieldType.values();
        private OneofDescriptor containingOneof;
        private Descriptor containingType;
        private Object defaultValue;
        private EnumDescriptor enumType;
        private final Descriptor extensionScope;
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private final boolean isProto3Optional;
        private String jsonName;
        private Descriptor messageType;
        private volatile DescriptorProtos.FieldOptions options;

        /* JADX INFO: renamed from: proto, reason: collision with root package name */
        private DescriptorProtos.FieldDescriptorProto f57proto;
        private Type type;

        /* synthetic */ FieldDescriptor(DescriptorProtos.FieldDescriptorProto fieldDescriptorProto, FileDescriptor fileDescriptor, Descriptor descriptor, int i, boolean z, AnonymousClass1 anonymousClass1) throws DescriptorValidationException {
            this(fieldDescriptorProto, fileDescriptor, descriptor, i, z);
        }

        /* JADX INFO: renamed from: com.google.protobuf.Descriptors$FieldDescriptor$1, reason: invalid class name */
        class AnonymousClass1 implements NumberGetter<FieldDescriptor> {
            AnonymousClass1() {
            }

            @Override // com.google.protobuf.Descriptors.NumberGetter
            public int getNumber(FieldDescriptor fieldDescriptor) {
                return fieldDescriptor.getNumber();
            }
        }

        static {
            if (Type.types.length != DescriptorProtos.FieldDescriptorProto.Type.values().length) {
                throw new RuntimeException("descriptor.proto has a new declared type but Descriptors.java wasn't updated.");
            }
        }

        public int getIndex() {
            return this.index;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.FieldDescriptorProto toProto() {
            return this.f57proto;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.f57proto.getName();
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public int getNumber() {
            return this.f57proto.getNumber();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        public String getJsonName() {
            String str = this.jsonName;
            if (str != null) {
                return str;
            }
            if (this.f57proto.hasJsonName()) {
                String jsonName = this.f57proto.getJsonName();
                this.jsonName = jsonName;
                return jsonName;
            }
            String strFieldNameToJsonName = fieldNameToJsonName(this.f57proto.getName());
            this.jsonName = strFieldNameToJsonName;
            return strFieldNameToJsonName;
        }

        public JavaType getJavaType() {
            return getType().getJavaType();
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType getLiteJavaType() {
            return getLiteType().getJavaType();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        public Type getType() {
            Descriptor descriptor;
            Descriptor descriptor2;
            if (this.type == Type.MESSAGE && (((descriptor = this.messageType) == null || !descriptor.toProto().getOptions().getMapEntry()) && (((descriptor2 = this.containingType) == null || !descriptor2.toProto().getOptions().getMapEntry()) && this.features != null && getFeatures().getMessageEncoding() == DescriptorProtos.FeatureSet.MessageEncoding.DELIMITED))) {
                return Type.GROUP;
            }
            return this.type;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType getLiteType() {
            return table[getType().ordinal()];
        }

        public boolean needsUtf8Check() {
            if (getType() != Type.STRING) {
                return false;
            }
            if (getContainingType().toProto().getOptions().getMapEntry() || ((JavaFeaturesProto.JavaFeatures) getFeatures().getExtension(JavaFeaturesProto.java_)).getUtf8Validation().equals(JavaFeaturesProto.JavaFeatures.Utf8Validation.VERIFY)) {
                return true;
            }
            return getFeatures().getUtf8Validation().equals(DescriptorProtos.FeatureSet.Utf8Validation.VERIFY);
        }

        public boolean isMapField() {
            return getType() == Type.MESSAGE && isRepeated() && getMessageType().toProto().getOptions().getMapEntry();
        }

        public boolean isRequired() {
            return getFeatures().getFieldPresence() == DescriptorProtos.FeatureSet.FieldPresence.LEGACY_REQUIRED;
        }

        public boolean isOptional() {
            return this.f57proto.getLabel() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL && getFeatures().getFieldPresence() != DescriptorProtos.FeatureSet.FieldPresence.LEGACY_REQUIRED;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isRepeated() {
            return this.f57proto.getLabel() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isPacked() {
            if (isPackable()) {
                return getFeatures().getRepeatedFieldEncoding().equals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.PACKED);
            }
            return false;
        }

        public boolean isPackable() {
            return isRepeated() && getLiteType().isPackable();
        }

        public boolean hasDefaultValue() {
            return this.f57proto.hasDefaultValue();
        }

        public Object getDefaultValue() {
            if (getJavaType() == JavaType.MESSAGE) {
                throw new UnsupportedOperationException("FieldDescriptor.getDefaultValue() called on an embedded message field.");
            }
            return this.defaultValue;
        }

        public DescriptorProtos.FieldOptions getOptions() {
            if (this.options == null) {
                DescriptorProtos.FieldOptions options = this.f57proto.getOptions();
                if (options.hasFeatures()) {
                    options = options.toBuilder().clearFeatures().build();
                }
                synchronized (this) {
                    if (this.options == null) {
                        this.options = options;
                    }
                }
            }
            return this.options;
        }

        public boolean isExtension() {
            return this.f57proto.hasExtendee();
        }

        public Descriptor getContainingType() {
            return this.containingType;
        }

        public OneofDescriptor getContainingOneof() {
            return this.containingOneof;
        }

        public OneofDescriptor getRealContainingOneof() {
            OneofDescriptor oneofDescriptor = this.containingOneof;
            if (oneofDescriptor == null || oneofDescriptor.isSynthetic()) {
                return null;
            }
            return this.containingOneof;
        }

        boolean hasOptionalKeyword() {
            if (this.isProto3Optional) {
                return true;
            }
            return this.file.getEdition() == DescriptorProtos.Edition.EDITION_PROTO2 && isOptional() && getContainingOneof() == null;
        }

        public boolean hasPresence() {
            if (isRepeated()) {
                return false;
            }
            return this.isProto3Optional || getType() == Type.MESSAGE || getType() == Type.GROUP || isExtension() || getContainingOneof() != null || getFeatures().getFieldPresence() != DescriptorProtos.FeatureSet.FieldPresence.IMPLICIT;
        }

        boolean isGroupLike() {
            if (getType() != Type.GROUP || !getMessageType().getName().toLowerCase().equals(getName()) || getMessageType().getFile() != getFile()) {
                return false;
            }
            if (isExtension()) {
                return getMessageType().getContainingType() == getExtensionScope();
            }
            return getMessageType().getContainingType() == getContainingType();
        }

        public Descriptor getExtensionScope() {
            if (!isExtension()) {
                throw new UnsupportedOperationException(String.format("This field is not an extension. (%s)", this.fullName));
            }
            return this.extensionScope;
        }

        public Descriptor getMessageType() {
            if (getJavaType() != JavaType.MESSAGE) {
                throw new UnsupportedOperationException(String.format("This field is not of message type. (%s)", this.fullName));
            }
            return this.messageType;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public EnumDescriptor getEnumType() {
            if (getJavaType() != JavaType.ENUM) {
                throw new UnsupportedOperationException(String.format("This field is not of enum type. (%s)", this.fullName));
            }
            return this.enumType;
        }

        public boolean legacyEnumFieldTreatedAsClosed() {
            if (getFile().getDependencies().isEmpty()) {
                return getType() == Type.ENUM && this.enumType.isClosed();
            }
            return getType() == Type.ENUM && (((JavaFeaturesProto.JavaFeatures) getFeatures().getExtension(JavaFeaturesProto.java_)).getLegacyClosedEnum() || this.enumType.isClosed());
        }

        @Override // java.lang.Comparable
        public int compareTo(final FieldDescriptor other) {
            if (other.containingType != this.containingType) {
                throw new IllegalArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
            }
            return getNumber() - other.getNumber();
        }

        public String toString() {
            return getFullName();
        }

        public enum Type {
            DOUBLE(JavaType.DOUBLE),
            FLOAT(JavaType.FLOAT),
            INT64(JavaType.LONG),
            UINT64(JavaType.LONG),
            INT32(JavaType.INT),
            FIXED64(JavaType.LONG),
            FIXED32(JavaType.INT),
            BOOL(JavaType.BOOLEAN),
            STRING(JavaType.STRING),
            GROUP(JavaType.MESSAGE),
            MESSAGE(JavaType.MESSAGE),
            BYTES(JavaType.BYTE_STRING),
            UINT32(JavaType.INT),
            ENUM(JavaType.ENUM),
            SFIXED32(JavaType.INT),
            SFIXED64(JavaType.LONG),
            SINT32(JavaType.INT),
            SINT64(JavaType.LONG);

            private static final Type[] types = values();
            private final JavaType javaType;

            Type(JavaType javaType) {
                this.javaType = javaType;
            }

            public DescriptorProtos.FieldDescriptorProto.Type toProto() {
                return DescriptorProtos.FieldDescriptorProto.Type.forNumber(ordinal() + 1);
            }

            public JavaType getJavaType() {
                return this.javaType;
            }

            public static Type valueOf(final DescriptorProtos.FieldDescriptorProto.Type type) {
                return types[type.getNumber() - 1];
            }
        }

        public enum JavaType {
            INT(0),
            LONG(0L),
            FLOAT(Float.valueOf(0.0f)),
            DOUBLE(Double.valueOf(0.0d)),
            BOOLEAN(false),
            STRING(""),
            BYTE_STRING(ByteString.EMPTY),
            ENUM(null),
            MESSAGE(null);

            private final Object defaultDefault;

            JavaType(final Object defaultDefault) {
                this.defaultDefault = defaultDefault;
            }
        }

        private static String fieldNameToJsonName(String name) {
            int length = name.length();
            StringBuilder sb = new StringBuilder(length);
            boolean z = false;
            for (int i = 0; i < length; i++) {
                char cCharAt = name.charAt(i);
                if (cCharAt == '_') {
                    z = true;
                } else if (z) {
                    if ('a' <= cCharAt && cCharAt <= 'z') {
                        cCharAt = (char) (cCharAt - ' ');
                    }
                    sb.append(cCharAt);
                    z = false;
                } else {
                    sb.append(cCharAt);
                }
            }
            return sb.toString();
        }

        private FieldDescriptor(final DescriptorProtos.FieldDescriptorProto proto2, final FileDescriptor file, final Descriptor parent, final int index, final boolean isExtension) throws DescriptorValidationException {
            super(null);
            this.parent = parent;
            this.index = index;
            this.f57proto = proto2;
            this.fullName = Descriptors.computeFullName(file, parent, proto2.getName());
            this.file = file;
            if (proto2.hasType()) {
                this.type = Type.valueOf(proto2.getType());
            }
            this.isProto3Optional = proto2.getProto3Optional();
            if (getNumber() > 0) {
                if (isExtension) {
                    if (!proto2.hasExtendee()) {
                        throw new DescriptorValidationException(this, "FieldDescriptorProto.extendee not set for extension field.", (AnonymousClass1) null);
                    }
                    this.containingType = null;
                    if (parent != null) {
                        this.extensionScope = parent;
                    } else {
                        this.extensionScope = null;
                        this.parent = file;
                    }
                    if (proto2.hasOneofIndex()) {
                        throw new DescriptorValidationException(this, "FieldDescriptorProto.oneof_index set for extension field.", (AnonymousClass1) null);
                    }
                    this.containingOneof = null;
                } else {
                    if (proto2.hasExtendee()) {
                        throw new DescriptorValidationException(this, "FieldDescriptorProto.extendee set for non-extension field.", (AnonymousClass1) null);
                    }
                    this.containingType = parent;
                    if (proto2.hasOneofIndex()) {
                        if (proto2.getOneofIndex() < 0 || proto2.getOneofIndex() >= parent.toProto().getOneofDeclCount()) {
                            throw new DescriptorValidationException(this, "FieldDescriptorProto.oneof_index is out of range for type " + parent.getName(), (AnonymousClass1) null);
                        }
                        OneofDescriptor oneofDescriptor = parent.getOneofs().get(proto2.getOneofIndex());
                        this.containingOneof = oneofDescriptor;
                        OneofDescriptor.access$2908(oneofDescriptor);
                        this.parent = this.containingOneof;
                    } else {
                        this.containingOneof = null;
                    }
                    this.extensionScope = null;
                }
                file.pool.addSymbol(this);
                return;
            }
            throw new DescriptorValidationException(this, "Field numbers must be positive integers.", (AnonymousClass1) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void resolveAllFeatures() throws DescriptorValidationException {
            resolveFeatures(this.f57proto.getOptions().getFeatures());
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        DescriptorProtos.FeatureSet inferLegacyProtoFeatures() {
            DescriptorProtos.FeatureSet.Builder builderNewBuilder = DescriptorProtos.FeatureSet.newBuilder();
            if (getFile().getEdition().getNumber() >= DescriptorProtos.Edition.EDITION_2023.getNumber()) {
                return builderNewBuilder.build();
            }
            if (this.f57proto.getLabel() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_REQUIRED) {
                builderNewBuilder.setFieldPresence(DescriptorProtos.FeatureSet.FieldPresence.LEGACY_REQUIRED);
            }
            if (this.f57proto.getType() == DescriptorProtos.FieldDescriptorProto.Type.TYPE_GROUP) {
                builderNewBuilder.setMessageEncoding(DescriptorProtos.FeatureSet.MessageEncoding.DELIMITED);
            }
            if (getFile().getEdition() == DescriptorProtos.Edition.EDITION_PROTO2 && this.f57proto.getOptions().getPacked()) {
                builderNewBuilder.setRepeatedFieldEncoding(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.PACKED);
            }
            if (getFile().getEdition() == DescriptorProtos.Edition.EDITION_PROTO3 && this.f57proto.getOptions().hasPacked() && !this.f57proto.getOptions().getPacked()) {
                builderNewBuilder.setRepeatedFieldEncoding(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.EXPANDED);
            }
            return builderNewBuilder.build();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        boolean hasInferredLegacyProtoFeatures() {
            if (getFile().getEdition().getNumber() >= DescriptorProtos.Edition.EDITION_2023.getNumber()) {
                return false;
            }
            if (this.f57proto.getLabel() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_REQUIRED || this.f57proto.getType() == DescriptorProtos.FieldDescriptorProto.Type.TYPE_GROUP || this.f57proto.getOptions().getPacked()) {
                return true;
            }
            return getFile().getEdition() == DescriptorProtos.Edition.EDITION_PROTO3 && this.f57proto.getOptions().hasPacked() && !this.f57proto.getOptions().getPacked();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        void validateFeatures() throws DescriptorValidationException {
            Descriptor descriptor = this.containingType;
            if (descriptor != null && descriptor.toProto().getOptions().getMessageSetWireFormat() && isExtension()) {
                if (!isOptional() || getType() != Type.MESSAGE) {
                    throw new DescriptorValidationException(this, "Extensions of MessageSets must be optional messages.", (AnonymousClass1) null);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void crossLink() throws DescriptorValidationException {
            if (this.f57proto.hasExtendee()) {
                GenericDescriptor genericDescriptorLookupSymbol = this.file.pool.lookupSymbol(this.f57proto.getExtendee(), this, DescriptorPool.SearchFilter.TYPES_ONLY);
                if (!(genericDescriptorLookupSymbol instanceof Descriptor)) {
                    throw new DescriptorValidationException(this, "\"" + this.f57proto.getExtendee() + "\" is not a message type.", (AnonymousClass1) null);
                }
                this.containingType = (Descriptor) genericDescriptorLookupSymbol;
                if (!getContainingType().isExtensionNumber(getNumber())) {
                    throw new DescriptorValidationException(this, "\"" + getContainingType().getFullName() + "\" does not declare " + getNumber() + " as an extension number.", (AnonymousClass1) null);
                }
            }
            if (this.f57proto.hasTypeName()) {
                GenericDescriptor genericDescriptorLookupSymbol2 = this.file.pool.lookupSymbol(this.f57proto.getTypeName(), this, DescriptorPool.SearchFilter.TYPES_ONLY);
                if (!this.f57proto.hasType()) {
                    if (genericDescriptorLookupSymbol2 instanceof Descriptor) {
                        this.type = Type.MESSAGE;
                    } else if (genericDescriptorLookupSymbol2 instanceof EnumDescriptor) {
                        this.type = Type.ENUM;
                    } else {
                        throw new DescriptorValidationException(this, "\"" + this.f57proto.getTypeName() + "\" is not a type.", (AnonymousClass1) null);
                    }
                }
                if (this.type.getJavaType() == JavaType.MESSAGE) {
                    if (!(genericDescriptorLookupSymbol2 instanceof Descriptor)) {
                        throw new DescriptorValidationException(this, "\"" + this.f57proto.getTypeName() + "\" is not a message type.", (AnonymousClass1) null);
                    }
                    this.messageType = (Descriptor) genericDescriptorLookupSymbol2;
                    if (this.f57proto.hasDefaultValue()) {
                        throw new DescriptorValidationException(this, "Messages can't have default values.", (AnonymousClass1) null);
                    }
                } else if (this.type.getJavaType() == JavaType.ENUM) {
                    if (!(genericDescriptorLookupSymbol2 instanceof EnumDescriptor)) {
                        throw new DescriptorValidationException(this, "\"" + this.f57proto.getTypeName() + "\" is not an enum type.", (AnonymousClass1) null);
                    }
                    this.enumType = (EnumDescriptor) genericDescriptorLookupSymbol2;
                } else {
                    throw new DescriptorValidationException(this, "Field with primitive type has type_name.", (AnonymousClass1) null);
                }
            } else if (this.type.getJavaType() == JavaType.MESSAGE || this.type.getJavaType() == JavaType.ENUM) {
                throw new DescriptorValidationException(this, "Field with message or enum type missing type_name.", (AnonymousClass1) null);
            }
            if (this.f57proto.getOptions().getPacked() && !isPackable()) {
                throw new DescriptorValidationException(this, "[packed = true] can only be specified for repeated primitive fields.", (AnonymousClass1) null);
            }
            if (this.f57proto.hasDefaultValue()) {
                if (isRepeated()) {
                    throw new DescriptorValidationException(this, "Repeated fields cannot have default values.", (AnonymousClass1) null);
                }
                try {
                    switch (AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[this.type.ordinal()]) {
                        case 1:
                        case 2:
                        case 3:
                            this.defaultValue = Integer.valueOf(TextFormat.parseInt32(this.f57proto.getDefaultValue()));
                            return;
                        case 4:
                        case 5:
                            this.defaultValue = Integer.valueOf(TextFormat.parseUInt32(this.f57proto.getDefaultValue()));
                            return;
                        case 6:
                        case 7:
                        case 8:
                            this.defaultValue = Long.valueOf(TextFormat.parseInt64(this.f57proto.getDefaultValue()));
                            return;
                        case 9:
                        case 10:
                            this.defaultValue = Long.valueOf(TextFormat.parseUInt64(this.f57proto.getDefaultValue()));
                            return;
                        case 11:
                            if (this.f57proto.getDefaultValue().equals("inf")) {
                                this.defaultValue = Float.valueOf(Float.POSITIVE_INFINITY);
                                return;
                            }
                            if (this.f57proto.getDefaultValue().equals("-inf")) {
                                this.defaultValue = Float.valueOf(Float.NEGATIVE_INFINITY);
                                return;
                            } else if (this.f57proto.getDefaultValue().equals("nan")) {
                                this.defaultValue = Float.valueOf(Float.NaN);
                                return;
                            } else {
                                this.defaultValue = Float.valueOf(this.f57proto.getDefaultValue());
                                return;
                            }
                        case 12:
                            if (this.f57proto.getDefaultValue().equals("inf")) {
                                this.defaultValue = Double.valueOf(Double.POSITIVE_INFINITY);
                                return;
                            }
                            if (this.f57proto.getDefaultValue().equals("-inf")) {
                                this.defaultValue = Double.valueOf(Double.NEGATIVE_INFINITY);
                                return;
                            } else if (this.f57proto.getDefaultValue().equals("nan")) {
                                this.defaultValue = Double.valueOf(Double.NaN);
                                return;
                            } else {
                                this.defaultValue = Double.valueOf(this.f57proto.getDefaultValue());
                                return;
                            }
                        case 13:
                            this.defaultValue = Boolean.valueOf(this.f57proto.getDefaultValue());
                            return;
                        case 14:
                            this.defaultValue = this.f57proto.getDefaultValue();
                            return;
                        case 15:
                            try {
                                this.defaultValue = TextFormat.unescapeBytes(this.f57proto.getDefaultValue());
                                return;
                            } catch (TextFormat.InvalidEscapeSequenceException e) {
                                throw new DescriptorValidationException(this, "Couldn't parse default value: " + e.getMessage(), e, null);
                            }
                        case 16:
                            EnumValueDescriptor enumValueDescriptorFindValueByName = this.enumType.findValueByName(this.f57proto.getDefaultValue());
                            this.defaultValue = enumValueDescriptorFindValueByName;
                            if (enumValueDescriptorFindValueByName == null) {
                                throw new DescriptorValidationException(this, "Unknown enum default value: \"" + this.f57proto.getDefaultValue() + '\"', (AnonymousClass1) null);
                            }
                            return;
                        case 17:
                        case 18:
                            throw new DescriptorValidationException(this, "Message type had default value.", (AnonymousClass1) null);
                        default:
                            return;
                    }
                } catch (NumberFormatException e2) {
                    throw new DescriptorValidationException(this, "Could not parse default value: \"" + this.f57proto.getDefaultValue() + '\"', e2, null);
                }
                throw new DescriptorValidationException(this, "Could not parse default value: \"" + this.f57proto.getDefaultValue() + '\"', e2, null);
            }
            if (isRepeated()) {
                this.defaultValue = Collections.emptyList();
                return;
            }
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[this.type.getJavaType().ordinal()];
            if (i == 1) {
                this.defaultValue = this.enumType.getValues().get(0);
            } else if (i != 2) {
                this.defaultValue = this.type.getJavaType().defaultDefault;
            } else {
                this.defaultValue = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProto(final DescriptorProtos.FieldDescriptorProto proto2) throws DescriptorValidationException {
            this.f57proto = proto2;
            this.options = null;
            resolveFeatures(proto2.getOptions().getFeatures());
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder internalMergeFrom(MessageLite.Builder to, MessageLite from) {
            return ((Message.Builder) to).mergeFrom((Message) from);
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.Descriptors$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;

        static {
            int[] iArr = new int[FieldDescriptor.JavaType.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType = iArr;
            try {
                iArr[FieldDescriptor.JavaType.ENUM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[FieldDescriptor.JavaType.MESSAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[FieldDescriptor.Type.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = iArr2;
            try {
                iArr2[FieldDescriptor.Type.INT32.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.SINT32.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.SFIXED32.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.UINT32.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.FIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.INT64.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.SINT64.ordinal()] = 7;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.SFIXED64.ordinal()] = 8;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.UINT64.ordinal()] = 9;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.FIXED64.ordinal()] = 10;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.FLOAT.ordinal()] = 11;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.DOUBLE.ordinal()] = 12;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.BOOL.ordinal()] = 13;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.STRING.ordinal()] = 14;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.BYTES.ordinal()] = 15;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.ENUM.ordinal()] = 16;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.MESSAGE.ordinal()] = 17;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.GROUP.ordinal()] = 18;
            } catch (NoSuchFieldError unused20) {
            }
        }
    }

    public static final class EnumDescriptor extends GenericDescriptor implements Internal.EnumLiteMap<EnumValueDescriptor> {
        private ReferenceQueue<EnumValueDescriptor> cleanupQueue;
        private final Descriptor containingType;
        private final int distinctNumbers;
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private volatile DescriptorProtos.EnumOptions options;

        /* JADX INFO: renamed from: proto, reason: collision with root package name */
        private DescriptorProtos.EnumDescriptorProto f55proto;
        private Map<Integer, WeakReference<EnumValueDescriptor>> unknownValues;
        private final EnumValueDescriptor[] values;
        private final EnumValueDescriptor[] valuesSortedByNumber;

        /* synthetic */ EnumDescriptor(DescriptorProtos.EnumDescriptorProto enumDescriptorProto, FileDescriptor fileDescriptor, Descriptor descriptor, int i, AnonymousClass1 anonymousClass1) throws DescriptorValidationException {
            this(enumDescriptorProto, fileDescriptor, descriptor, i);
        }

        public int getIndex() {
            return this.index;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.EnumDescriptorProto toProto() {
            return this.f55proto;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.f55proto.getName();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        public boolean isClosed() {
            return getFeatures().getEnumType() == DescriptorProtos.FeatureSet.EnumType.CLOSED;
        }

        public Descriptor getContainingType() {
            return this.containingType;
        }

        public DescriptorProtos.EnumOptions getOptions() {
            if (this.options == null) {
                DescriptorProtos.EnumOptions options = this.f55proto.getOptions();
                if (options.hasFeatures()) {
                    options = options.toBuilder().clearFeatures().build();
                }
                synchronized (this) {
                    if (this.options == null) {
                        this.options = options;
                    }
                }
            }
            return this.options;
        }

        public List<EnumValueDescriptor> getValues() {
            return Collections.unmodifiableList(Arrays.asList(this.values));
        }

        public boolean isReservedNumber(final int number) {
            for (DescriptorProtos.EnumDescriptorProto.EnumReservedRange enumReservedRange : this.f55proto.getReservedRangeList()) {
                if (enumReservedRange.getStart() <= number && number <= enumReservedRange.getEnd()) {
                    return true;
                }
            }
            return false;
        }

        public boolean isReservedName(final String name) {
            Internal.checkNotNull(name);
            Iterator<String> it = this.f55proto.getReservedNameList().iterator();
            while (it.hasNext()) {
                if (it.next().equals(name)) {
                    return true;
                }
            }
            return false;
        }

        public EnumValueDescriptor findValueByName(final String name) {
            GenericDescriptor genericDescriptorFindSymbol = this.file.pool.findSymbol(this.fullName + FilenameUtils.EXTENSION_SEPARATOR + name);
            if (genericDescriptorFindSymbol instanceof EnumValueDescriptor) {
                return (EnumValueDescriptor) genericDescriptorFindSymbol;
            }
            return null;
        }

        @Override // com.google.protobuf.Internal.EnumLiteMap
        public EnumValueDescriptor findValueByNumber(final int number) {
            return (EnumValueDescriptor) Descriptors.binarySearch(this.valuesSortedByNumber, this.distinctNumbers, EnumValueDescriptor.NUMBER_GETTER, number);
        }

        private static class UnknownEnumValueReference extends WeakReference<EnumValueDescriptor> {
            private final int number;

            /* synthetic */ UnknownEnumValueReference(int i, EnumValueDescriptor enumValueDescriptor, AnonymousClass1 anonymousClass1) {
                this(i, enumValueDescriptor);
            }

            private UnknownEnumValueReference(int number, EnumValueDescriptor descriptor) {
                super(descriptor);
                this.number = number;
            }
        }

        public EnumValueDescriptor findValueByNumberCreatingIfUnknown(final int number) {
            EnumValueDescriptor enumValueDescriptor;
            EnumValueDescriptor enumValueDescriptorFindValueByNumber = findValueByNumber(number);
            if (enumValueDescriptorFindValueByNumber != null) {
                return enumValueDescriptorFindValueByNumber;
            }
            synchronized (this) {
                if (this.cleanupQueue == null) {
                    this.cleanupQueue = new ReferenceQueue<>();
                    this.unknownValues = new HashMap();
                } else {
                    while (true) {
                        UnknownEnumValueReference unknownEnumValueReference = (UnknownEnumValueReference) this.cleanupQueue.poll();
                        if (unknownEnumValueReference == null) {
                            break;
                        }
                        this.unknownValues.remove(Integer.valueOf(unknownEnumValueReference.number));
                    }
                }
                WeakReference<EnumValueDescriptor> weakReference = this.unknownValues.get(Integer.valueOf(number));
                enumValueDescriptor = weakReference == null ? null : weakReference.get();
                if (enumValueDescriptor == null) {
                    enumValueDescriptor = new EnumValueDescriptor(this, Integer.valueOf(number), null);
                    this.unknownValues.put(Integer.valueOf(number), new UnknownEnumValueReference(number, enumValueDescriptor, null));
                }
            }
            return enumValueDescriptor;
        }

        int getUnknownEnumValueDescriptorCount() {
            return this.unknownValues.size();
        }

        private EnumDescriptor(final DescriptorProtos.EnumDescriptorProto proto2, final FileDescriptor file, final Descriptor parent, final int index) throws DescriptorValidationException {
            super(null);
            this.unknownValues = null;
            this.cleanupQueue = null;
            if (parent == null) {
                this.parent = file;
            } else {
                this.parent = parent;
            }
            this.index = index;
            this.f55proto = proto2;
            this.fullName = Descriptors.computeFullName(file, parent, proto2.getName());
            this.file = file;
            this.containingType = parent;
            if (proto2.getValueCount() == 0) {
                throw new DescriptorValidationException(this, "Enums must contain at least one value.", (AnonymousClass1) null);
            }
            this.values = new EnumValueDescriptor[proto2.getValueCount()];
            int i = 0;
            for (int i2 = 0; i2 < proto2.getValueCount(); i2++) {
                this.values[i2] = new EnumValueDescriptor(proto2.getValue(i2), file, this, i2, null);
            }
            EnumValueDescriptor[] enumValueDescriptorArr = (EnumValueDescriptor[]) this.values.clone();
            this.valuesSortedByNumber = enumValueDescriptorArr;
            Arrays.sort(enumValueDescriptorArr, EnumValueDescriptor.BY_NUMBER);
            for (int i3 = 1; i3 < proto2.getValueCount(); i3++) {
                EnumValueDescriptor[] enumValueDescriptorArr2 = this.valuesSortedByNumber;
                EnumValueDescriptor enumValueDescriptor = enumValueDescriptorArr2[i];
                EnumValueDescriptor enumValueDescriptor2 = enumValueDescriptorArr2[i3];
                if (enumValueDescriptor.getNumber() != enumValueDescriptor2.getNumber()) {
                    i++;
                    this.valuesSortedByNumber[i] = enumValueDescriptor2;
                }
            }
            int i4 = i + 1;
            this.distinctNumbers = i4;
            Arrays.fill(this.valuesSortedByNumber, i4, proto2.getValueCount(), (Object) null);
            file.pool.addSymbol(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void resolveAllFeatures() throws DescriptorValidationException {
            resolveFeatures(this.f55proto.getOptions().getFeatures());
            for (EnumValueDescriptor enumValueDescriptor : this.values) {
                enumValueDescriptor.resolveAllFeatures();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProto(final DescriptorProtos.EnumDescriptorProto proto2) throws DescriptorValidationException {
            this.f55proto = proto2;
            this.options = null;
            resolveFeatures(proto2.getOptions().getFeatures());
            int i = 0;
            while (true) {
                EnumValueDescriptor[] enumValueDescriptorArr = this.values;
                if (i >= enumValueDescriptorArr.length) {
                    return;
                }
                enumValueDescriptorArr[i].setProto(proto2.getValue(i));
                i++;
            }
        }
    }

    public static final class EnumValueDescriptor extends GenericDescriptor implements Internal.EnumLite {
        static final Comparator<EnumValueDescriptor> BY_NUMBER = new AnonymousClass1();
        static final NumberGetter<EnumValueDescriptor> NUMBER_GETTER = new AnonymousClass2();
        private final String fullName;
        private final int index;
        private volatile DescriptorProtos.EnumValueOptions options;

        /* JADX INFO: renamed from: proto, reason: collision with root package name */
        private DescriptorProtos.EnumValueDescriptorProto f56proto;
        private final EnumDescriptor type;

        /* synthetic */ EnumValueDescriptor(DescriptorProtos.EnumValueDescriptorProto enumValueDescriptorProto, FileDescriptor fileDescriptor, EnumDescriptor enumDescriptor, int i, AnonymousClass1 anonymousClass1) throws DescriptorValidationException {
            this(enumValueDescriptorProto, fileDescriptor, enumDescriptor, i);
        }

        /* synthetic */ EnumValueDescriptor(EnumDescriptor enumDescriptor, Integer num, AnonymousClass1 anonymousClass1) {
            this(enumDescriptor, num);
        }

        /* JADX INFO: renamed from: com.google.protobuf.Descriptors$EnumValueDescriptor$1, reason: invalid class name */
        class AnonymousClass1 implements Comparator<EnumValueDescriptor> {
            AnonymousClass1() {
            }

            @Override // java.util.Comparator
            public int compare(EnumValueDescriptor o1, EnumValueDescriptor o2) {
                return Integer.valueOf(o1.getNumber()).compareTo(Integer.valueOf(o2.getNumber()));
            }
        }

        /* JADX INFO: renamed from: com.google.protobuf.Descriptors$EnumValueDescriptor$2, reason: invalid class name */
        class AnonymousClass2 implements NumberGetter<EnumValueDescriptor> {
            AnonymousClass2() {
            }

            @Override // com.google.protobuf.Descriptors.NumberGetter
            public int getNumber(EnumValueDescriptor enumValueDescriptor) {
                return enumValueDescriptor.getNumber();
            }
        }

        public int getIndex() {
            return this.index;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.EnumValueDescriptorProto toProto() {
            return this.f56proto;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.f56proto.getName();
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.f56proto.getNumber();
        }

        public String toString() {
            return this.f56proto.getName();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.type.file;
        }

        public EnumDescriptor getType() {
            return this.type;
        }

        public DescriptorProtos.EnumValueOptions getOptions() {
            if (this.options == null) {
                DescriptorProtos.EnumValueOptions options = this.f56proto.getOptions();
                if (options.hasFeatures()) {
                    options = options.toBuilder().clearFeatures().build();
                }
                synchronized (this) {
                    if (this.options == null) {
                        this.options = options;
                    }
                }
            }
            return this.options;
        }

        private EnumValueDescriptor(final DescriptorProtos.EnumValueDescriptorProto proto2, final FileDescriptor file, final EnumDescriptor parent, final int index) throws DescriptorValidationException {
            super(null);
            this.parent = parent;
            this.index = index;
            this.f56proto = proto2;
            this.type = parent;
            this.fullName = parent.getFullName() + FilenameUtils.EXTENSION_SEPARATOR + proto2.getName();
            file.pool.addSymbol(this);
        }

        private EnumValueDescriptor(final EnumDescriptor parent, final Integer number) {
            super(null);
            DescriptorProtos.EnumValueDescriptorProto enumValueDescriptorProtoBuild = DescriptorProtos.EnumValueDescriptorProto.newBuilder().setName("UNKNOWN_ENUM_VALUE_" + parent.getName() + "_" + number).setNumber(number.intValue()).build();
            this.parent = parent;
            this.index = -1;
            this.f56proto = enumValueDescriptorProtoBuild;
            this.type = parent;
            this.fullName = parent.getFullName() + FilenameUtils.EXTENSION_SEPARATOR + enumValueDescriptorProtoBuild.getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void resolveAllFeatures() throws DescriptorValidationException {
            resolveFeatures(this.f56proto.getOptions().getFeatures());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProto(final DescriptorProtos.EnumValueDescriptorProto proto2) throws DescriptorValidationException {
            this.f56proto = proto2;
            this.options = null;
            resolveFeatures(proto2.getOptions().getFeatures());
        }
    }

    public static final class ServiceDescriptor extends GenericDescriptor {
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private MethodDescriptor[] methods;
        private volatile DescriptorProtos.ServiceOptions options;

        /* JADX INFO: renamed from: proto, reason: collision with root package name */
        private DescriptorProtos.ServiceDescriptorProto f61proto;

        /* synthetic */ ServiceDescriptor(DescriptorProtos.ServiceDescriptorProto serviceDescriptorProto, FileDescriptor fileDescriptor, int i, AnonymousClass1 anonymousClass1) throws DescriptorValidationException {
            this(serviceDescriptorProto, fileDescriptor, i);
        }

        public int getIndex() {
            return this.index;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.ServiceDescriptorProto toProto() {
            return this.f61proto;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.f61proto.getName();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        public DescriptorProtos.ServiceOptions getOptions() {
            if (this.options == null) {
                DescriptorProtos.ServiceOptions options = this.f61proto.getOptions();
                if (options.hasFeatures()) {
                    options = options.toBuilder().clearFeatures().build();
                }
                synchronized (this) {
                    if (this.options == null) {
                        this.options = options;
                    }
                }
            }
            return this.options;
        }

        public List<MethodDescriptor> getMethods() {
            return Collections.unmodifiableList(Arrays.asList(this.methods));
        }

        public MethodDescriptor findMethodByName(final String name) {
            GenericDescriptor genericDescriptorFindSymbol = this.file.pool.findSymbol(this.fullName + FilenameUtils.EXTENSION_SEPARATOR + name);
            if (genericDescriptorFindSymbol instanceof MethodDescriptor) {
                return (MethodDescriptor) genericDescriptorFindSymbol;
            }
            return null;
        }

        private ServiceDescriptor(final DescriptorProtos.ServiceDescriptorProto proto2, final FileDescriptor file, final int index) throws DescriptorValidationException {
            super(null);
            this.parent = file;
            this.index = index;
            this.f61proto = proto2;
            this.fullName = Descriptors.computeFullName(file, null, proto2.getName());
            this.file = file;
            this.methods = new MethodDescriptor[proto2.getMethodCount()];
            for (int i = 0; i < proto2.getMethodCount(); i++) {
                this.methods[i] = new MethodDescriptor(proto2.getMethod(i), file, this, i, null);
            }
            file.pool.addSymbol(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void resolveAllFeatures() throws DescriptorValidationException {
            resolveFeatures(this.f61proto.getOptions().getFeatures());
            for (MethodDescriptor methodDescriptor : this.methods) {
                methodDescriptor.resolveAllFeatures();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void crossLink() throws DescriptorValidationException {
            for (MethodDescriptor methodDescriptor : this.methods) {
                methodDescriptor.crossLink();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProto(final DescriptorProtos.ServiceDescriptorProto proto2) throws DescriptorValidationException {
            this.f61proto = proto2;
            this.options = null;
            resolveFeatures(proto2.getOptions().getFeatures());
            int i = 0;
            while (true) {
                MethodDescriptor[] methodDescriptorArr = this.methods;
                if (i >= methodDescriptorArr.length) {
                    return;
                }
                methodDescriptorArr[i].setProto(proto2.getMethod(i));
                i++;
            }
        }
    }

    public static final class MethodDescriptor extends GenericDescriptor {
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private Descriptor inputType;
        private volatile DescriptorProtos.MethodOptions options;
        private Descriptor outputType;

        /* JADX INFO: renamed from: proto, reason: collision with root package name */
        private DescriptorProtos.MethodDescriptorProto f59proto;
        private final ServiceDescriptor service;

        /* synthetic */ MethodDescriptor(DescriptorProtos.MethodDescriptorProto methodDescriptorProto, FileDescriptor fileDescriptor, ServiceDescriptor serviceDescriptor, int i, AnonymousClass1 anonymousClass1) throws DescriptorValidationException {
            this(methodDescriptorProto, fileDescriptor, serviceDescriptor, i);
        }

        public int getIndex() {
            return this.index;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.MethodDescriptorProto toProto() {
            return this.f59proto;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.f59proto.getName();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        public ServiceDescriptor getService() {
            return this.service;
        }

        public Descriptor getInputType() {
            return this.inputType;
        }

        public Descriptor getOutputType() {
            return this.outputType;
        }

        public boolean isClientStreaming() {
            return this.f59proto.getClientStreaming();
        }

        public boolean isServerStreaming() {
            return this.f59proto.getServerStreaming();
        }

        public DescriptorProtos.MethodOptions getOptions() {
            if (this.options == null) {
                DescriptorProtos.MethodOptions options = this.f59proto.getOptions();
                if (options.hasFeatures()) {
                    options = options.toBuilder().clearFeatures().build();
                }
                synchronized (this) {
                    if (this.options == null) {
                        this.options = options;
                    }
                }
            }
            return this.options;
        }

        private MethodDescriptor(final DescriptorProtos.MethodDescriptorProto proto2, final FileDescriptor file, final ServiceDescriptor parent, final int index) throws DescriptorValidationException {
            super(null);
            this.parent = parent;
            this.index = index;
            this.f59proto = proto2;
            this.file = file;
            this.service = parent;
            this.fullName = parent.getFullName() + FilenameUtils.EXTENSION_SEPARATOR + proto2.getName();
            file.pool.addSymbol(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void resolveAllFeatures() throws DescriptorValidationException {
            resolveFeatures(this.f59proto.getOptions().getFeatures());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void crossLink() throws DescriptorValidationException {
            GenericDescriptor genericDescriptorLookupSymbol = getFile().pool.lookupSymbol(this.f59proto.getInputType(), this, DescriptorPool.SearchFilter.TYPES_ONLY);
            if (!(genericDescriptorLookupSymbol instanceof Descriptor)) {
                throw new DescriptorValidationException(this, "\"" + this.f59proto.getInputType() + "\" is not a message type.", (AnonymousClass1) null);
            }
            this.inputType = (Descriptor) genericDescriptorLookupSymbol;
            GenericDescriptor genericDescriptorLookupSymbol2 = getFile().pool.lookupSymbol(this.f59proto.getOutputType(), this, DescriptorPool.SearchFilter.TYPES_ONLY);
            if (!(genericDescriptorLookupSymbol2 instanceof Descriptor)) {
                throw new DescriptorValidationException(this, "\"" + this.f59proto.getOutputType() + "\" is not a message type.", (AnonymousClass1) null);
            }
            this.outputType = (Descriptor) genericDescriptorLookupSymbol2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProto(final DescriptorProtos.MethodDescriptorProto proto2) throws DescriptorValidationException {
            this.f59proto = proto2;
            this.options = null;
            resolveFeatures(proto2.getOptions().getFeatures());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String computeFullName(final FileDescriptor file, final Descriptor parent, final String name) {
        if (parent != null) {
            return parent.getFullName() + FilenameUtils.EXTENSION_SEPARATOR + name;
        }
        String str = file.getPackage();
        return !str.isEmpty() ? str + FilenameUtils.EXTENSION_SEPARATOR + name : name;
    }

    public static abstract class GenericDescriptor {
        volatile DescriptorProtos.FeatureSet features;
        GenericDescriptor parent;

        public abstract FileDescriptor getFile();

        public abstract String getFullName();

        public abstract String getName();

        boolean hasInferredLegacyProtoFeatures() {
            return false;
        }

        public abstract Message toProto();

        void validateFeatures() throws DescriptorValidationException {
        }

        /* synthetic */ GenericDescriptor(AnonymousClass1 anonymousClass1) {
            this();
        }

        private GenericDescriptor() {
        }

        void resolveFeatures(DescriptorProtos.FeatureSet unresolvedFeatures) throws DescriptorValidationException {
            DescriptorProtos.FeatureSet.Builder builder;
            if (this.parent != null && unresolvedFeatures.equals(DescriptorProtos.FeatureSet.getDefaultInstance()) && !hasInferredLegacyProtoFeatures()) {
                this.features = this.parent.features;
                validateFeatures();
                return;
            }
            boolean z = false;
            boolean z2 = false;
            for (FieldDescriptor fieldDescriptor : unresolvedFeatures.getExtensionFields().keySet()) {
                if (fieldDescriptor.getNumber() == JavaFeaturesProto.java_.getNumber() && fieldDescriptor != JavaFeaturesProto.java_.getDescriptor()) {
                    z2 = true;
                }
            }
            if (!unresolvedFeatures.getUnknownFields().asMap().isEmpty() && unresolvedFeatures.getUnknownFields().hasField(JavaFeaturesProto.java_.getNumber())) {
                z = true;
            }
            if (z2 || z) {
                ExtensionRegistry extensionRegistryNewInstance = ExtensionRegistry.newInstance();
                extensionRegistryNewInstance.add((GeneratedMessage.GeneratedExtension<?, ?>) JavaFeaturesProto.java_);
                try {
                    unresolvedFeatures = DescriptorProtos.FeatureSet.parseFrom(unresolvedFeatures.toByteString(), extensionRegistryNewInstance);
                } catch (InvalidProtocolBufferException e) {
                    throw new DescriptorValidationException(this, "Failed to parse features with Java feature extension registry.", e, null);
                }
            }
            GenericDescriptor genericDescriptor = this.parent;
            if (genericDescriptor == null) {
                builder = Descriptors.getEditionDefaults(getFile().getEdition()).toBuilder();
            } else {
                builder = genericDescriptor.features.toBuilder();
            }
            builder.mergeFrom(inferLegacyProtoFeatures());
            builder.mergeFrom(unresolvedFeatures);
            this.features = Descriptors.internFeatures(builder.build());
            validateFeatures();
        }

        DescriptorProtos.FeatureSet inferLegacyProtoFeatures() {
            return DescriptorProtos.FeatureSet.getDefaultInstance();
        }

        DescriptorProtos.FeatureSet getFeatures() {
            if (this.features == null && (getFile().getEdition() == DescriptorProtos.Edition.EDITION_PROTO2 || getFile().getEdition() == DescriptorProtos.Edition.EDITION_PROTO3)) {
                getFile().resolveAllFeaturesImmutable();
            }
            return this.features;
        }
    }

    public static class DescriptorValidationException extends Exception {
        private static final long serialVersionUID = 5750205775490483148L;
        private final String description;
        private final String name;

        /* JADX INFO: renamed from: proto, reason: collision with root package name */
        private final Message f54proto;

        /* synthetic */ DescriptorValidationException(FileDescriptor fileDescriptor, String str, AnonymousClass1 anonymousClass1) {
            this(fileDescriptor, str);
        }

        /* synthetic */ DescriptorValidationException(GenericDescriptor genericDescriptor, String str, AnonymousClass1 anonymousClass1) {
            this(genericDescriptor, str);
        }

        /* synthetic */ DescriptorValidationException(GenericDescriptor genericDescriptor, String str, Throwable th, AnonymousClass1 anonymousClass1) {
            this(genericDescriptor, str, th);
        }

        public String getProblemSymbolName() {
            return this.name;
        }

        public Message getProblemProto() {
            return this.f54proto;
        }

        public String getDescription() {
            return this.description;
        }

        private DescriptorValidationException(final GenericDescriptor problemDescriptor, final String description) {
            super(problemDescriptor.getFullName() + ": " + description);
            this.name = problemDescriptor.getFullName();
            this.f54proto = problemDescriptor.toProto();
            this.description = description;
        }

        private DescriptorValidationException(final GenericDescriptor problemDescriptor, final String description, final Throwable cause) {
            this(problemDescriptor, description);
            initCause(cause);
        }

        private DescriptorValidationException(final FileDescriptor problemDescriptor, final String description) {
            super(problemDescriptor.getName() + ": " + description);
            this.name = problemDescriptor.getName();
            this.f54proto = problemDescriptor.toProto();
            this.description = description;
        }
    }

    private static final class DescriptorPool {
        private final boolean allowUnknownDependencies;
        private final Set<FileDescriptor> dependencies;
        private final Map<String, GenericDescriptor> descriptorsByName = new HashMap();

        enum SearchFilter {
            TYPES_ONLY,
            AGGREGATES_ONLY,
            ALL_SYMBOLS
        }

        DescriptorPool(final FileDescriptor[] dependencies, boolean allowUnknownDependencies) {
            this.dependencies = Collections.newSetFromMap(new IdentityHashMap(dependencies.length));
            this.allowUnknownDependencies = allowUnknownDependencies;
            for (FileDescriptor fileDescriptor : dependencies) {
                this.dependencies.add(fileDescriptor);
                importPublicDependencies(fileDescriptor);
            }
            for (FileDescriptor fileDescriptor2 : this.dependencies) {
                try {
                    addPackage(fileDescriptor2.getPackage(), fileDescriptor2);
                } catch (DescriptorValidationException e) {
                    throw new AssertionError(e);
                }
            }
        }

        private void importPublicDependencies(final FileDescriptor file) {
            for (FileDescriptor fileDescriptor : file.getPublicDependencies()) {
                if (this.dependencies.add(fileDescriptor)) {
                    importPublicDependencies(fileDescriptor);
                }
            }
        }

        GenericDescriptor findSymbol(final String fullName) {
            return findSymbol(fullName, SearchFilter.ALL_SYMBOLS);
        }

        GenericDescriptor findSymbol(final String fullName, final SearchFilter filter) {
            GenericDescriptor genericDescriptor = this.descriptorsByName.get(fullName);
            if (genericDescriptor != null && (filter == SearchFilter.ALL_SYMBOLS || ((filter == SearchFilter.TYPES_ONLY && isType(genericDescriptor)) || (filter == SearchFilter.AGGREGATES_ONLY && isAggregate(genericDescriptor))))) {
                return genericDescriptor;
            }
            Iterator<FileDescriptor> it = this.dependencies.iterator();
            while (it.hasNext()) {
                GenericDescriptor genericDescriptor2 = it.next().pool.descriptorsByName.get(fullName);
                if (genericDescriptor2 != null && (filter == SearchFilter.ALL_SYMBOLS || ((filter == SearchFilter.TYPES_ONLY && isType(genericDescriptor2)) || (filter == SearchFilter.AGGREGATES_ONLY && isAggregate(genericDescriptor2))))) {
                    return genericDescriptor2;
                }
            }
            return null;
        }

        boolean isType(GenericDescriptor descriptor) {
            return (descriptor instanceof Descriptor) || (descriptor instanceof EnumDescriptor);
        }

        boolean isAggregate(GenericDescriptor descriptor) {
            return (descriptor instanceof Descriptor) || (descriptor instanceof EnumDescriptor) || (descriptor instanceof PackageDescriptor) || (descriptor instanceof ServiceDescriptor);
        }

        GenericDescriptor lookupSymbol(final String name, final GenericDescriptor relativeTo, final SearchFilter filter) throws DescriptorValidationException {
            GenericDescriptor genericDescriptorFindSymbol;
            String string;
            if (name.startsWith(BranchConfig.LOCAL_REPOSITORY)) {
                string = name.substring(1);
                genericDescriptorFindSymbol = findSymbol(string, filter);
            } else {
                int iIndexOf = name.indexOf(46);
                String strSubstring = iIndexOf == -1 ? name : name.substring(0, iIndexOf);
                StringBuilder sb = new StringBuilder(relativeTo.getFullName());
                while (true) {
                    int iLastIndexOf = sb.lastIndexOf(BranchConfig.LOCAL_REPOSITORY);
                    if (iLastIndexOf == -1) {
                        genericDescriptorFindSymbol = findSymbol(name, filter);
                        string = name;
                        break;
                    }
                    int i = iLastIndexOf + 1;
                    sb.setLength(i);
                    sb.append(strSubstring);
                    GenericDescriptor genericDescriptorFindSymbol2 = findSymbol(sb.toString(), SearchFilter.AGGREGATES_ONLY);
                    if (genericDescriptorFindSymbol2 != null) {
                        if (iIndexOf != -1) {
                            sb.setLength(i);
                            sb.append(name);
                            genericDescriptorFindSymbol = findSymbol(sb.toString(), filter);
                        } else {
                            genericDescriptorFindSymbol = genericDescriptorFindSymbol2;
                        }
                        string = sb.toString();
                        break;
                    }
                    sb.setLength(iLastIndexOf);
                }
            }
            if (genericDescriptorFindSymbol != null) {
                return genericDescriptorFindSymbol;
            }
            if (this.allowUnknownDependencies && filter == SearchFilter.TYPES_ONLY) {
                Descriptors.logger.warning("The descriptor for message type \"" + name + "\" cannot be found and a placeholder is created for it");
                Descriptor descriptor = new Descriptor(string);
                this.dependencies.add(descriptor.getFile());
                return descriptor;
            }
            throw new DescriptorValidationException(relativeTo, "\"" + name + "\" is not defined.", (AnonymousClass1) null);
        }

        void addSymbol(final GenericDescriptor descriptor) throws DescriptorValidationException {
            validateSymbolName(descriptor);
            String fullName = descriptor.getFullName();
            GenericDescriptor genericDescriptorPut = this.descriptorsByName.put(fullName, descriptor);
            if (genericDescriptorPut != null) {
                this.descriptorsByName.put(fullName, genericDescriptorPut);
                if (descriptor.getFile() == genericDescriptorPut.getFile()) {
                    int iLastIndexOf = fullName.lastIndexOf(46);
                    if (iLastIndexOf == -1) {
                        throw new DescriptorValidationException(descriptor, "\"" + fullName + "\" is already defined.", (AnonymousClass1) null);
                    }
                    throw new DescriptorValidationException(descriptor, "\"" + fullName.substring(iLastIndexOf + 1) + "\" is already defined in \"" + fullName.substring(0, iLastIndexOf) + "\".", (AnonymousClass1) null);
                }
                throw new DescriptorValidationException(descriptor, "\"" + fullName + "\" is already defined in file \"" + genericDescriptorPut.getFile().getName() + "\".", (AnonymousClass1) null);
            }
        }

        private static final class PackageDescriptor extends GenericDescriptor {
            private final FileDescriptor file;
            private final String fullName;
            private final String name;

            @Override // com.google.protobuf.Descriptors.GenericDescriptor
            public Message toProto() {
                return this.file.toProto();
            }

            @Override // com.google.protobuf.Descriptors.GenericDescriptor
            public String getName() {
                return this.name;
            }

            @Override // com.google.protobuf.Descriptors.GenericDescriptor
            public String getFullName() {
                return this.fullName;
            }

            @Override // com.google.protobuf.Descriptors.GenericDescriptor
            public FileDescriptor getFile() {
                return this.file;
            }

            PackageDescriptor(final String name, final String fullName, final FileDescriptor file) {
                super(null);
                this.file = file;
                this.fullName = fullName;
                this.name = name;
            }
        }

        void addPackage(final String fullName, final FileDescriptor file) throws DescriptorValidationException {
            String strSubstring;
            int iLastIndexOf = fullName.lastIndexOf(46);
            if (iLastIndexOf == -1) {
                strSubstring = fullName;
            } else {
                addPackage(fullName.substring(0, iLastIndexOf), file);
                strSubstring = fullName.substring(iLastIndexOf + 1);
            }
            GenericDescriptor genericDescriptorPut = this.descriptorsByName.put(fullName, new PackageDescriptor(strSubstring, fullName, file));
            if (genericDescriptorPut != null) {
                this.descriptorsByName.put(fullName, genericDescriptorPut);
                if (!(genericDescriptorPut instanceof PackageDescriptor)) {
                    throw new DescriptorValidationException(file, "\"" + strSubstring + "\" is already defined (as something other than a package) in file \"" + genericDescriptorPut.getFile().getName() + "\".", (AnonymousClass1) null);
                }
            }
        }

        static void validateSymbolName(final GenericDescriptor descriptor) throws DescriptorValidationException {
            String name = descriptor.getName();
            if (name.length() == 0) {
                throw new DescriptorValidationException(descriptor, "Missing name.", (AnonymousClass1) null);
            }
            for (int i = 0; i < name.length(); i++) {
                char cCharAt = name.charAt(i);
                if (('a' > cCharAt || cCharAt > 'z') && (('A' > cCharAt || cCharAt > 'Z') && cCharAt != '_' && ('0' > cCharAt || cCharAt > '9' || i <= 0))) {
                    throw new DescriptorValidationException(descriptor, "\"" + name + "\" is not a valid identifier.", (AnonymousClass1) null);
                }
            }
        }
    }

    public static final class OneofDescriptor extends GenericDescriptor {
        private Descriptor containingType;
        private int fieldCount;
        private FieldDescriptor[] fields;
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private volatile DescriptorProtos.OneofOptions options;

        /* JADX INFO: renamed from: proto, reason: collision with root package name */
        private DescriptorProtos.OneofDescriptorProto f60proto;

        /* synthetic */ OneofDescriptor(DescriptorProtos.OneofDescriptorProto oneofDescriptorProto, FileDescriptor fileDescriptor, Descriptor descriptor, int i, AnonymousClass1 anonymousClass1) {
            this(oneofDescriptorProto, fileDescriptor, descriptor, i);
        }

        static /* synthetic */ int access$2908(OneofDescriptor oneofDescriptor) {
            int i = oneofDescriptor.fieldCount;
            oneofDescriptor.fieldCount = i + 1;
            return i;
        }

        public int getIndex() {
            return this.index;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.f60proto.getName();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        public Descriptor getContainingType() {
            return this.containingType;
        }

        public int getFieldCount() {
            return this.fieldCount;
        }

        public DescriptorProtos.OneofOptions getOptions() {
            if (this.options == null) {
                DescriptorProtos.OneofOptions options = this.f60proto.getOptions();
                if (options.hasFeatures()) {
                    options = options.toBuilder().clearFeatures().build();
                }
                synchronized (this) {
                    if (this.options == null) {
                        this.options = options;
                    }
                }
            }
            return this.options;
        }

        public List<FieldDescriptor> getFields() {
            return Collections.unmodifiableList(Arrays.asList(this.fields));
        }

        public FieldDescriptor getField(int index) {
            return this.fields[index];
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.OneofDescriptorProto toProto() {
            return this.f60proto;
        }

        boolean isSynthetic() {
            FieldDescriptor[] fieldDescriptorArr = this.fields;
            return fieldDescriptorArr.length == 1 && fieldDescriptorArr[0].isProto3Optional;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void resolveAllFeatures() throws DescriptorValidationException {
            resolveFeatures(this.f60proto.getOptions().getFeatures());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProto(final DescriptorProtos.OneofDescriptorProto proto2) throws DescriptorValidationException {
            this.f60proto = proto2;
            this.options = null;
            resolveFeatures(proto2.getOptions().getFeatures());
        }

        private OneofDescriptor(final DescriptorProtos.OneofDescriptorProto proto2, final FileDescriptor file, final Descriptor parent, final int index) {
            super(null);
            this.parent = parent;
            this.f60proto = proto2;
            this.fullName = Descriptors.computeFullName(file, parent, proto2.getName());
            this.file = file;
            this.index = index;
            this.containingType = parent;
            this.fieldCount = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T binarySearch(T[] array, int size, NumberGetter<T> getter, int number) {
        int i = size - 1;
        int i2 = 0;
        while (i2 <= i) {
            int i3 = (i2 + i) / 2;
            T t = array[i3];
            int number2 = getter.getNumber(t);
            if (number < number2) {
                i = i3 - 1;
            } else {
                if (number <= number2) {
                    return t;
                }
                i2 = i3 + 1;
            }
        }
        return null;
    }
}
