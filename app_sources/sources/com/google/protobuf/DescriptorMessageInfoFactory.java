package com.google.protobuf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

/* INFO: loaded from: classes4.dex */
final class DescriptorMessageInfoFactory implements MessageInfoFactory {
    private static final String GET_DEFAULT_INSTANCE_METHOD_NAME = "getDefaultInstance";
    private static final DescriptorMessageInfoFactory instance = new DescriptorMessageInfoFactory();
    private static final Set<String> specialFieldNames = new HashSet(Arrays.asList("Class", "DefaultInstanceForType", "ParserForType", "SerializedSize", "AllFields", "DescriptorForType", "InitializationErrorString", "UnknownFields", "CachedSize"));
    private static IsInitializedCheckAnalyzer isInitializedCheckAnalyzer = new IsInitializedCheckAnalyzer();

    private DescriptorMessageInfoFactory() {
    }

    public static DescriptorMessageInfoFactory getInstance() {
        return instance;
    }

    @Override // com.google.protobuf.MessageInfoFactory
    public boolean isSupported(Class<?> messageType) {
        return GeneratedMessage.class.isAssignableFrom(messageType);
    }

    @Override // com.google.protobuf.MessageInfoFactory
    public MessageInfo messageInfoFor(Class<?> messageType) {
        if (!GeneratedMessage.class.isAssignableFrom(messageType)) {
            throw new IllegalArgumentException("Unsupported message type: " + messageType.getName());
        }
        return convert(messageType, descriptorForType(messageType));
    }

    private static Message getDefaultInstance(Class<?> messageType) {
        try {
            return (Message) messageType.getDeclaredMethod(GET_DEFAULT_INSTANCE_METHOD_NAME, new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to get default instance for message class " + messageType.getName(), e);
        }
    }

    private static Descriptors.Descriptor descriptorForType(Class<?> messageType) {
        return getDefaultInstance(messageType).getDescriptorForType();
    }

    private static ProtoSyntax convertSyntax(DescriptorProtos.Edition edition) {
        int i = AnonymousClass3.$SwitchMap$com$google$protobuf$DescriptorProtos$Edition[edition.ordinal()];
        if (i == 1) {
            return ProtoSyntax.PROTO2;
        }
        if (i == 2) {
            return ProtoSyntax.PROTO3;
        }
        return ProtoSyntax.EDITIONS;
    }

    private static MessageInfo convert(Class<?> messageType, Descriptors.Descriptor messageDescriptor) {
        java.lang.reflect.Field field;
        FieldInfo fieldInfoForExplicitPresenceField;
        FieldInfo fieldInfoForField;
        List<Descriptors.FieldDescriptor> fields = messageDescriptor.getFields();
        StructuralMessageInfo.Builder builderNewBuilder = StructuralMessageInfo.newBuilder(fields.size());
        builderNewBuilder.withDefaultInstance(getDefaultInstance(messageType));
        builderNewBuilder.withSyntax(convertSyntax(messageDescriptor.getFile().getEdition()));
        builderNewBuilder.withMessageSetWireFormat(messageDescriptor.getOptions().getMessageSetWireFormat());
        Internal.EnumVerifier enumVerifier = null;
        OneofState oneofState = new OneofState(null);
        java.lang.reflect.Field fieldBitField = null;
        int i = 0;
        int i2 = 0;
        int i3 = 1;
        while (i < fields.size()) {
            Descriptors.FieldDescriptor fieldDescriptor = fields.get(i);
            boolean zNeedsUtf8Check = fieldDescriptor.needsUtf8Check();
            Internal.EnumVerifier anonymousClass1 = (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM && fieldDescriptor.legacyEnumFieldTreatedAsClosed()) ? new AnonymousClass1(fieldDescriptor) : enumVerifier;
            if (fieldDescriptor.getRealContainingOneof() != null) {
                builderNewBuilder.withField(buildOneofMember(messageType, fieldDescriptor, oneofState, zNeedsUtf8Check, anonymousClass1));
            } else {
                java.lang.reflect.Field field2 = field(messageType, fieldDescriptor);
                int number = fieldDescriptor.getNumber();
                FieldType fieldType = getFieldType(fieldDescriptor);
                if (!fieldDescriptor.hasPresence()) {
                    if (fieldDescriptor.isMapField()) {
                        Descriptors.FieldDescriptor fieldDescriptorFindFieldByNumber = fieldDescriptor.getMessageType().findFieldByNumber(2);
                        if (fieldDescriptorFindFieldByNumber.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM && fieldDescriptorFindFieldByNumber.legacyEnumFieldTreatedAsClosed()) {
                            anonymousClass1 = new AnonymousClass2(fieldDescriptorFindFieldByNumber);
                        }
                        fieldInfoForField = FieldInfo.forMapField(field2, number, SchemaUtil.getMapDefaultEntry(messageType, fieldDescriptor.getName()), anonymousClass1);
                    } else if (fieldDescriptor.isRepeated() && fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        fieldInfoForField = FieldInfo.forRepeatedMessageField(field2, number, fieldType, getTypeForRepeatedMessageField(messageType, fieldDescriptor));
                    } else if (fieldDescriptor.isPacked()) {
                        if (anonymousClass1 != null) {
                            fieldInfoForField = FieldInfo.forPackedFieldWithEnumVerifier(field2, number, fieldType, anonymousClass1, cachedSizeField(messageType, fieldDescriptor));
                        } else {
                            fieldInfoForField = FieldInfo.forPackedField(field2, number, fieldType, cachedSizeField(messageType, fieldDescriptor));
                        }
                    } else if (anonymousClass1 != null) {
                        fieldInfoForField = FieldInfo.forFieldWithEnumVerifier(field2, number, fieldType, anonymousClass1);
                    } else {
                        fieldInfoForField = FieldInfo.forField(field2, number, fieldType, zNeedsUtf8Check);
                    }
                    builderNewBuilder.withField(fieldInfoForField);
                } else {
                    if (fieldBitField == null) {
                        fieldBitField = bitField(messageType, i2);
                    }
                    if (fieldDescriptor.isRequired()) {
                        field = fieldBitField;
                        fieldInfoForExplicitPresenceField = FieldInfo.forLegacyRequiredField(field2, number, fieldType, field, i3, zNeedsUtf8Check, anonymousClass1);
                    } else {
                        field = fieldBitField;
                        fieldInfoForExplicitPresenceField = FieldInfo.forExplicitPresenceField(field2, number, fieldType, field, i3, zNeedsUtf8Check, anonymousClass1);
                    }
                    builderNewBuilder.withField(fieldInfoForExplicitPresenceField);
                    i3 <<= 1;
                    if (i3 == 0) {
                        i2++;
                        fieldBitField = null;
                        i3 = 1;
                    } else {
                        fieldBitField = field;
                    }
                }
            }
            i++;
            enumVerifier = null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < fields.size(); i4++) {
            Descriptors.FieldDescriptor fieldDescriptor2 = fields.get(i4);
            if (fieldDescriptor2.isRequired() || (fieldDescriptor2.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE && needsIsInitializedCheck(fieldDescriptor2.getMessageType()))) {
                arrayList.add(Integer.valueOf(fieldDescriptor2.getNumber()));
            }
        }
        int size = arrayList.size();
        int[] iArr = new int[size];
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            iArr[i5] = ((Integer) arrayList.get(i5)).intValue();
        }
        if (size > 0) {
            builderNewBuilder.withCheckInitialized(iArr);
        }
        return builderNewBuilder.build();
    }

    /* INFO: renamed from: com.google.protobuf.DescriptorMessageInfoFactory$1, reason: invalid class name */
    class AnonymousClass1 implements Internal.EnumVerifier {
        final /* synthetic */ Descriptors.FieldDescriptor val$fd;

        AnonymousClass1(final Descriptors.FieldDescriptor val$fd) {
            this.val$fd = val$fd;
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int number) {
            return this.val$fd.getEnumType().findValueByNumber(number) != null;
        }
    }

    /* INFO: renamed from: com.google.protobuf.DescriptorMessageInfoFactory$2, reason: invalid class name */
    class AnonymousClass2 implements Internal.EnumVerifier {
        final /* synthetic */ Descriptors.FieldDescriptor val$valueField;

        AnonymousClass2(final Descriptors.FieldDescriptor val$valueField) {
            this.val$valueField = val$valueField;
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int number) {
            return this.val$valueField.getEnumType().findValueByNumber(number) != null;
        }
    }

    static class IsInitializedCheckAnalyzer {
        private final Map<Descriptors.Descriptor, Boolean> resultCache = new ConcurrentHashMap();
        private int index = 0;
        private final Stack<Node> stack = new Stack<>();
        private final Map<Descriptors.Descriptor, Node> nodeCache = new HashMap();

        IsInitializedCheckAnalyzer() {
        }

        public boolean needsIsInitializedCheck(Descriptors.Descriptor descriptor) {
            Boolean bool = this.resultCache.get(descriptor);
            if (bool != null) {
                return bool.booleanValue();
            }
            synchronized (this) {
                Boolean bool2 = this.resultCache.get(descriptor);
                if (bool2 != null) {
                    return bool2.booleanValue();
                }
                return dfs(descriptor).component.needsIsInitializedCheck;
            }
        }

        private static class Node {
            StronglyConnectedComponent component = null;
            final Descriptors.Descriptor descriptor;
            final int index;
            int lowLink;

            Node(Descriptors.Descriptor descriptor, int index) {
                this.descriptor = descriptor;
                this.index = index;
                this.lowLink = index;
            }
        }

        private static class StronglyConnectedComponent {
            final List<Descriptors.Descriptor> messages;
            boolean needsIsInitializedCheck;

            private StronglyConnectedComponent() {
                this.messages = new ArrayList();
                this.needsIsInitializedCheck = false;
            }

            /* synthetic */ StronglyConnectedComponent(AnonymousClass1 anonymousClass1) {
                this();
            }
        }

        private Node dfs(Descriptors.Descriptor descriptor) {
            Node nodePop;
            int i = this.index;
            this.index = i + 1;
            Node node = new Node(descriptor, i);
            this.stack.push(node);
            this.nodeCache.put(descriptor, node);
            for (Descriptors.FieldDescriptor fieldDescriptor : descriptor.getFields()) {
                if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    Node node2 = this.nodeCache.get(fieldDescriptor.getMessageType());
                    if (node2 == null) {
                        node.lowLink = Math.min(node.lowLink, dfs(fieldDescriptor.getMessageType()).lowLink);
                    } else if (node2.component == null) {
                        node.lowLink = Math.min(node.lowLink, node2.lowLink);
                    }
                }
            }
            if (node.index == node.lowLink) {
                StronglyConnectedComponent stronglyConnectedComponent = new StronglyConnectedComponent(null);
                do {
                    nodePop = this.stack.pop();
                    nodePop.component = stronglyConnectedComponent;
                    stronglyConnectedComponent.messages.add(nodePop.descriptor);
                } while (nodePop != node);
                analyze(stronglyConnectedComponent);
            }
            return node;
        }

        private void analyze(StronglyConnectedComponent component) {
            boolean z;
            Iterator<Descriptors.Descriptor> it = component.messages.iterator();
            loop0: while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                Descriptors.Descriptor next = it.next();
                z = true;
                if (next.isExtendable()) {
                    break;
                }
                for (Descriptors.FieldDescriptor fieldDescriptor : next.getFields()) {
                    if (fieldDescriptor.isRequired()) {
                        break loop0;
                    }
                    if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        Node node = this.nodeCache.get(fieldDescriptor.getMessageType());
                        if (node.component != component && node.component.needsIsInitializedCheck) {
                            break loop0;
                        }
                    }
                }
            }
            component.needsIsInitializedCheck = z;
            Iterator<Descriptors.Descriptor> it2 = component.messages.iterator();
            while (it2.hasNext()) {
                this.resultCache.put(it2.next(), Boolean.valueOf(component.needsIsInitializedCheck));
            }
        }
    }

    private static boolean needsIsInitializedCheck(Descriptors.Descriptor descriptor) {
        return isInitializedCheckAnalyzer.needsIsInitializedCheck(descriptor);
    }

    private static FieldInfo buildOneofMember(Class<?> messageType, Descriptors.FieldDescriptor fd, OneofState oneofState, boolean enforceUtf8, Internal.EnumVerifier enumVerifier) {
        OneofInfo oneof = oneofState.getOneof(messageType, fd.getContainingOneof());
        FieldType fieldType = getFieldType(fd);
        return FieldInfo.forOneofMemberField(fd.getNumber(), fieldType, oneof, getOneofStoredType(messageType, fd, fieldType), enforceUtf8, enumVerifier);
    }

    private static Class<?> getOneofStoredType(Class<?> messageType, Descriptors.FieldDescriptor fd, FieldType type) {
        switch (AnonymousClass3.$SwitchMap$com$google$protobuf$JavaType[type.getJavaType().ordinal()]) {
            case 1:
                return Boolean.class;
            case 2:
                return ByteString.class;
            case 3:
                return Double.class;
            case 4:
                return Float.class;
            case 5:
            case 6:
                return Integer.class;
            case 7:
                return Long.class;
            case 8:
                return String.class;
            case 9:
                return getOneofStoredTypeForMessage(messageType, fd);
            default:
                throw new IllegalArgumentException("Invalid type for oneof: " + type);
        }
    }

    /* INFO: renamed from: com.google.protobuf.DescriptorMessageInfoFactory$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$DescriptorProtos$Edition;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$JavaType;

        static {
            int[] iArr = new int[Descriptors.FieldDescriptor.Type.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = iArr;
            try {
                iArr[Descriptors.FieldDescriptor.Type.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.GROUP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.INT32.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.INT64.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SFIXED32.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SFIXED64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SINT32.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SINT64.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.STRING.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.UINT32.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.UINT64.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[JavaType.values().length];
            $SwitchMap$com$google$protobuf$JavaType = iArr2;
            try {
                iArr2[JavaType.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$google$protobuf$JavaType[JavaType.BYTE_STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$google$protobuf$JavaType[JavaType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$google$protobuf$JavaType[JavaType.FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$google$protobuf$JavaType[JavaType.ENUM.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$google$protobuf$JavaType[JavaType.INT.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$google$protobuf$JavaType[JavaType.LONG.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$google$protobuf$JavaType[JavaType.STRING.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$google$protobuf$JavaType[JavaType.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
            int[] iArr3 = new int[DescriptorProtos.Edition.values().length];
            $SwitchMap$com$google$protobuf$DescriptorProtos$Edition = iArr3;
            try {
                iArr3[DescriptorProtos.Edition.EDITION_PROTO2.ordinal()] = 1;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$com$google$protobuf$DescriptorProtos$Edition[DescriptorProtos.Edition.EDITION_PROTO3.ordinal()] = 2;
            } catch (NoSuchFieldError unused29) {
            }
        }
    }

    private static FieldType getFieldType(Descriptors.FieldDescriptor fd) {
        switch (AnonymousClass3.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[fd.getType().ordinal()]) {
            case 1:
                if (fd.isRepeated()) {
                    return fd.isPacked() ? FieldType.BOOL_LIST_PACKED : FieldType.BOOL_LIST;
                }
                return FieldType.BOOL;
            case 2:
                return fd.isRepeated() ? FieldType.BYTES_LIST : FieldType.BYTES;
            case 3:
                if (fd.isRepeated()) {
                    return fd.isPacked() ? FieldType.DOUBLE_LIST_PACKED : FieldType.DOUBLE_LIST;
                }
                return FieldType.DOUBLE;
            case 4:
                if (fd.isRepeated()) {
                    return fd.isPacked() ? FieldType.ENUM_LIST_PACKED : FieldType.ENUM_LIST;
                }
                return FieldType.ENUM;
            case 5:
                if (fd.isRepeated()) {
                    return fd.isPacked() ? FieldType.FIXED32_LIST_PACKED : FieldType.FIXED32_LIST;
                }
                return FieldType.FIXED32;
            case 6:
                if (fd.isRepeated()) {
                    return fd.isPacked() ? FieldType.FIXED64_LIST_PACKED : FieldType.FIXED64_LIST;
                }
                return FieldType.FIXED64;
            case 7:
                if (fd.isRepeated()) {
                    return fd.isPacked() ? FieldType.FLOAT_LIST_PACKED : FieldType.FLOAT_LIST;
                }
                return FieldType.FLOAT;
            case 8:
                return fd.isRepeated() ? FieldType.GROUP_LIST : FieldType.GROUP;
            case 9:
                if (fd.isRepeated()) {
                    return fd.isPacked() ? FieldType.INT32_LIST_PACKED : FieldType.INT32_LIST;
                }
                return FieldType.INT32;
            case 10:
                if (fd.isRepeated()) {
                    return fd.isPacked() ? FieldType.INT64_LIST_PACKED : FieldType.INT64_LIST;
                }
                return FieldType.INT64;
            case 11:
                if (fd.isMapField()) {
                    return FieldType.MAP;
                }
                return fd.isRepeated() ? FieldType.MESSAGE_LIST : FieldType.MESSAGE;
            case 12:
                if (fd.isRepeated()) {
                    return fd.isPacked() ? FieldType.SFIXED32_LIST_PACKED : FieldType.SFIXED32_LIST;
                }
                return FieldType.SFIXED32;
            case 13:
                if (fd.isRepeated()) {
                    return fd.isPacked() ? FieldType.SFIXED64_LIST_PACKED : FieldType.SFIXED64_LIST;
                }
                return FieldType.SFIXED64;
            case 14:
                if (fd.isRepeated()) {
                    return fd.isPacked() ? FieldType.SINT32_LIST_PACKED : FieldType.SINT32_LIST;
                }
                return FieldType.SINT32;
            case 15:
                if (fd.isRepeated()) {
                    return fd.isPacked() ? FieldType.SINT64_LIST_PACKED : FieldType.SINT64_LIST;
                }
                return FieldType.SINT64;
            case 16:
                return fd.isRepeated() ? FieldType.STRING_LIST : FieldType.STRING;
            case 17:
                if (fd.isRepeated()) {
                    return fd.isPacked() ? FieldType.UINT32_LIST_PACKED : FieldType.UINT32_LIST;
                }
                return FieldType.UINT32;
            case 18:
                if (fd.isRepeated()) {
                    return fd.isPacked() ? FieldType.UINT64_LIST_PACKED : FieldType.UINT64_LIST;
                }
                return FieldType.UINT64;
            default:
                throw new IllegalArgumentException("Unsupported field type: " + fd.getType());
        }
    }

    private static java.lang.reflect.Field bitField(Class<?> messageType, int index) {
        return field(messageType, "bitField" + index + "_");
    }

    private static java.lang.reflect.Field field(Class<?> messageType, Descriptors.FieldDescriptor fd) {
        return field(messageType, getFieldName(fd));
    }

    private static java.lang.reflect.Field cachedSizeField(Class<?> messageType, Descriptors.FieldDescriptor fd) {
        return field(messageType, getCachedSizeFieldName(fd));
    }

    /* INFO: Access modifiers changed from: private */
    public static java.lang.reflect.Field field(Class<?> messageType, String fieldName) {
        try {
            return messageType.getDeclaredField(fieldName);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Unable to find field " + fieldName + " in message class " + messageType.getName());
        }
    }

    static String getFieldName(Descriptors.FieldDescriptor fd) {
        String name;
        String str;
        if (fd.getType() == Descriptors.FieldDescriptor.Type.GROUP) {
            name = fd.getMessageType().getName();
        } else {
            name = fd.getName();
        }
        if (specialFieldNames.contains(snakeCaseToUpperCamelCase(name))) {
            str = "__";
        } else {
            str = "_";
        }
        return snakeCaseToLowerCamelCase(name) + str;
    }

    private static String getCachedSizeFieldName(Descriptors.FieldDescriptor fd) {
        return snakeCaseToLowerCamelCase(fd.getName()) + "MemoizedSerializedSize";
    }

    /* INFO: Access modifiers changed from: private */
    public static String snakeCaseToLowerCamelCase(String snakeCase) {
        return snakeCaseToCamelCase(snakeCase, false);
    }

    private static String snakeCaseToUpperCamelCase(String snakeCase) {
        return snakeCaseToCamelCase(snakeCase, true);
    }

    private static String snakeCaseToCamelCase(String snakeCase, boolean capFirst) {
        StringBuilder sb = new StringBuilder(snakeCase.length() + 1);
        for (int i = 0; i < snakeCase.length(); i++) {
            char cCharAt = snakeCase.charAt(i);
            if (cCharAt == '_') {
                capFirst = true;
            } else if (Character.isDigit(cCharAt)) {
                sb.append(cCharAt);
                capFirst = true;
            } else if (capFirst) {
                sb.append(Character.toUpperCase(cCharAt));
                capFirst = false;
            } else if (i == 0) {
                sb.append(Character.toLowerCase(cCharAt));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    private static Class<?> getOneofStoredTypeForMessage(Class<?> messageType, Descriptors.FieldDescriptor fd) {
        try {
            return messageType.getDeclaredMethod(getterForField(fd.getType() == Descriptors.FieldDescriptor.Type.GROUP ? fd.getMessageType().getName() : fd.getName()), new Class[0]).getReturnType();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Class<?> getTypeForRepeatedMessageField(Class<?> messageType, Descriptors.FieldDescriptor fd) {
        try {
            return messageType.getDeclaredMethod(getterForField(fd.getType() == Descriptors.FieldDescriptor.Type.GROUP ? fd.getMessageType().getName() : fd.getName()), Integer.TYPE).getReturnType();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String getterForField(String snakeCase) {
        String strSnakeCaseToLowerCamelCase = snakeCaseToLowerCamelCase(snakeCase);
        return "get" + Character.toUpperCase(strSnakeCaseToLowerCamelCase.charAt(0)) + strSnakeCaseToLowerCamelCase.substring(1, strSnakeCaseToLowerCamelCase.length());
    }

    private static final class OneofState {
        private OneofInfo[] oneofs;

        private OneofState() {
            this.oneofs = new OneofInfo[2];
        }

        /* synthetic */ OneofState(AnonymousClass1 anonymousClass1) {
            this();
        }

        OneofInfo getOneof(Class<?> messageType, Descriptors.OneofDescriptor desc) {
            int index = desc.getIndex();
            OneofInfo[] oneofInfoArr = this.oneofs;
            if (index >= oneofInfoArr.length) {
                this.oneofs = (OneofInfo[]) Arrays.copyOf(oneofInfoArr, index * 2);
            }
            OneofInfo oneofInfo = this.oneofs[index];
            if (oneofInfo != null) {
                return oneofInfo;
            }
            OneofInfo oneofInfoNewInfo = newInfo(messageType, desc);
            this.oneofs[index] = oneofInfoNewInfo;
            return oneofInfoNewInfo;
        }

        private static OneofInfo newInfo(Class<?> messageType, Descriptors.OneofDescriptor desc) {
            String strSnakeCaseToLowerCamelCase = DescriptorMessageInfoFactory.snakeCaseToLowerCamelCase(desc.getName());
            return new OneofInfo(desc.getIndex(), DescriptorMessageInfoFactory.field(messageType, strSnakeCaseToLowerCamelCase + "Case_"), DescriptorMessageInfoFactory.field(messageType, strSnakeCaseToLowerCamelCase + "_"));
        }
    }
}
