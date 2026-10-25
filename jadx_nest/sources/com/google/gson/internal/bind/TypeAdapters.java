package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes4.dex */
public final class TypeAdapters {
    public static final TypeAdapter<AtomicBoolean> ATOMIC_BOOLEAN;
    public static final TypeAdapterFactory ATOMIC_BOOLEAN_FACTORY;
    public static final TypeAdapter<AtomicInteger> ATOMIC_INTEGER;
    public static final TypeAdapter<AtomicIntegerArray> ATOMIC_INTEGER_ARRAY;
    public static final TypeAdapterFactory ATOMIC_INTEGER_ARRAY_FACTORY;
    public static final TypeAdapterFactory ATOMIC_INTEGER_FACTORY;
    public static final TypeAdapter<BigDecimal> BIG_DECIMAL;
    public static final TypeAdapter<BigInteger> BIG_INTEGER;
    public static final TypeAdapter<BitSet> BIT_SET;
    public static final TypeAdapterFactory BIT_SET_FACTORY;
    public static final TypeAdapter<Boolean> BOOLEAN;
    public static final TypeAdapter<Boolean> BOOLEAN_AS_STRING;
    public static final TypeAdapterFactory BOOLEAN_FACTORY;
    public static final TypeAdapter<Number> BYTE;
    public static final TypeAdapterFactory BYTE_FACTORY;
    public static final TypeAdapter<Calendar> CALENDAR;
    public static final TypeAdapterFactory CALENDAR_FACTORY;
    public static final TypeAdapter<Character> CHARACTER;
    public static final TypeAdapterFactory CHARACTER_FACTORY;
    public static final TypeAdapter<Class> CLASS;
    public static final TypeAdapterFactory CLASS_FACTORY;
    public static final TypeAdapter<Currency> CURRENCY;
    public static final TypeAdapterFactory CURRENCY_FACTORY;
    public static final TypeAdapter<Number> DOUBLE;
    public static final TypeAdapterFactory ENUM_FACTORY;
    public static final TypeAdapter<Number> FLOAT;
    public static final TypeAdapter<InetAddress> INET_ADDRESS;
    public static final TypeAdapterFactory INET_ADDRESS_FACTORY;
    public static final TypeAdapter<Number> INTEGER;
    public static final TypeAdapterFactory INTEGER_FACTORY;
    public static final TypeAdapter<JsonElement> JSON_ELEMENT;
    public static final TypeAdapterFactory JSON_ELEMENT_FACTORY;
    public static final TypeAdapter<LazilyParsedNumber> LAZILY_PARSED_NUMBER;
    public static final TypeAdapter<Locale> LOCALE;
    public static final TypeAdapterFactory LOCALE_FACTORY;
    public static final TypeAdapter<Number> LONG;
    public static final TypeAdapter<Number> SHORT;
    public static final TypeAdapterFactory SHORT_FACTORY;
    public static final TypeAdapter<String> STRING;
    public static final TypeAdapter<StringBuffer> STRING_BUFFER;
    public static final TypeAdapterFactory STRING_BUFFER_FACTORY;
    public static final TypeAdapter<StringBuilder> STRING_BUILDER;
    public static final TypeAdapterFactory STRING_BUILDER_FACTORY;
    public static final TypeAdapterFactory STRING_FACTORY;
    public static final TypeAdapter<URI> URI;
    public static final TypeAdapterFactory URI_FACTORY;
    public static final TypeAdapter<URL> URL;
    public static final TypeAdapterFactory URL_FACTORY;
    public static final TypeAdapter<UUID> UUID;
    public static final TypeAdapterFactory UUID_FACTORY;

    private TypeAdapters() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$1, reason: invalid class name */
    class AnonymousClass1 extends TypeAdapter<Class> {
        AnonymousClass1() {
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Class cls) throws IOException {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Class read(JsonReader jsonReader) throws IOException {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    }

    static {
        TypeAdapter<Class> typeAdapterNullSafe = new AnonymousClass1().nullSafe();
        CLASS = typeAdapterNullSafe;
        CLASS_FACTORY = newFactory(Class.class, typeAdapterNullSafe);
        TypeAdapter<BitSet> typeAdapterNullSafe2 = new AnonymousClass2().nullSafe();
        BIT_SET = typeAdapterNullSafe2;
        BIT_SET_FACTORY = newFactory(BitSet.class, typeAdapterNullSafe2);
        AnonymousClass3 anonymousClass3 = new AnonymousClass3();
        BOOLEAN = anonymousClass3;
        BOOLEAN_AS_STRING = new AnonymousClass4();
        BOOLEAN_FACTORY = newFactory(Boolean.TYPE, Boolean.class, anonymousClass3);
        AnonymousClass5 anonymousClass5 = new AnonymousClass5();
        BYTE = anonymousClass5;
        BYTE_FACTORY = newFactory(Byte.TYPE, Byte.class, anonymousClass5);
        AnonymousClass6 anonymousClass6 = new AnonymousClass6();
        SHORT = anonymousClass6;
        SHORT_FACTORY = newFactory(Short.TYPE, Short.class, anonymousClass6);
        AnonymousClass7 anonymousClass7 = new AnonymousClass7();
        INTEGER = anonymousClass7;
        INTEGER_FACTORY = newFactory(Integer.TYPE, Integer.class, anonymousClass7);
        TypeAdapter<AtomicInteger> typeAdapterNullSafe3 = new AnonymousClass8().nullSafe();
        ATOMIC_INTEGER = typeAdapterNullSafe3;
        ATOMIC_INTEGER_FACTORY = newFactory(AtomicInteger.class, typeAdapterNullSafe3);
        TypeAdapter<AtomicBoolean> typeAdapterNullSafe4 = new AnonymousClass9().nullSafe();
        ATOMIC_BOOLEAN = typeAdapterNullSafe4;
        ATOMIC_BOOLEAN_FACTORY = newFactory(AtomicBoolean.class, typeAdapterNullSafe4);
        TypeAdapter<AtomicIntegerArray> typeAdapterNullSafe5 = new AnonymousClass10().nullSafe();
        ATOMIC_INTEGER_ARRAY = typeAdapterNullSafe5;
        ATOMIC_INTEGER_ARRAY_FACTORY = newFactory(AtomicIntegerArray.class, typeAdapterNullSafe5);
        LONG = new AnonymousClass11();
        FLOAT = new AnonymousClass12();
        DOUBLE = new AnonymousClass13();
        AnonymousClass14 anonymousClass14 = new AnonymousClass14();
        CHARACTER = anonymousClass14;
        CHARACTER_FACTORY = newFactory(Character.TYPE, Character.class, anonymousClass14);
        AnonymousClass15 anonymousClass15 = new AnonymousClass15();
        STRING = anonymousClass15;
        BIG_DECIMAL = new AnonymousClass16();
        BIG_INTEGER = new AnonymousClass17();
        LAZILY_PARSED_NUMBER = new AnonymousClass18();
        STRING_FACTORY = newFactory(String.class, anonymousClass15);
        AnonymousClass19 anonymousClass19 = new AnonymousClass19();
        STRING_BUILDER = anonymousClass19;
        STRING_BUILDER_FACTORY = newFactory(StringBuilder.class, anonymousClass19);
        AnonymousClass20 anonymousClass20 = new AnonymousClass20();
        STRING_BUFFER = anonymousClass20;
        STRING_BUFFER_FACTORY = newFactory(StringBuffer.class, anonymousClass20);
        AnonymousClass21 anonymousClass21 = new AnonymousClass21();
        URL = anonymousClass21;
        URL_FACTORY = newFactory(URL.class, anonymousClass21);
        AnonymousClass22 anonymousClass22 = new AnonymousClass22();
        URI = anonymousClass22;
        URI_FACTORY = newFactory(URI.class, anonymousClass22);
        AnonymousClass23 anonymousClass23 = new AnonymousClass23();
        INET_ADDRESS = anonymousClass23;
        INET_ADDRESS_FACTORY = newTypeHierarchyFactory(InetAddress.class, anonymousClass23);
        AnonymousClass24 anonymousClass24 = new AnonymousClass24();
        UUID = anonymousClass24;
        UUID_FACTORY = newFactory(UUID.class, anonymousClass24);
        TypeAdapter<Currency> typeAdapterNullSafe6 = new AnonymousClass25().nullSafe();
        CURRENCY = typeAdapterNullSafe6;
        CURRENCY_FACTORY = newFactory(Currency.class, typeAdapterNullSafe6);
        AnonymousClass26 anonymousClass26 = new AnonymousClass26();
        CALENDAR = anonymousClass26;
        CALENDAR_FACTORY = newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, anonymousClass26);
        AnonymousClass27 anonymousClass27 = new AnonymousClass27();
        LOCALE = anonymousClass27;
        LOCALE_FACTORY = newFactory(Locale.class, anonymousClass27);
        AnonymousClass28 anonymousClass28 = new AnonymousClass28();
        JSON_ELEMENT = anonymousClass28;
        JSON_ELEMENT_FACTORY = newTypeHierarchyFactory(JsonElement.class, anonymousClass28);
        ENUM_FACTORY = new AnonymousClass29();
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$2, reason: invalid class name */
    class AnonymousClass2 extends TypeAdapter<BitSet> {
        AnonymousClass2() {
        }

        @Override // com.google.gson.TypeAdapter
        public BitSet read(JsonReader jsonReader) throws IOException {
            BitSet bitSet = new BitSet();
            jsonReader.beginArray();
            JsonToken jsonTokenPeek = jsonReader.peek();
            int i = 0;
            while (jsonTokenPeek != JsonToken.END_ARRAY) {
                int i2 = AnonymousClass35.$SwitchMap$com$google$gson$stream$JsonToken[jsonTokenPeek.ordinal()];
                boolean zNextBoolean = true;
                if (i2 == 1 || i2 == 2) {
                    int iNextInt = jsonReader.nextInt();
                    if (iNextInt == 0) {
                        zNextBoolean = false;
                    } else if (iNextInt != 1) {
                        throw new JsonSyntaxException("Invalid bitset value " + iNextInt + ", expected 0 or 1; at path " + jsonReader.getPreviousPath());
                    }
                } else if (i2 == 3) {
                    zNextBoolean = jsonReader.nextBoolean();
                } else {
                    throw new JsonSyntaxException("Invalid bitset value type: " + jsonTokenPeek + "; at path " + jsonReader.getPath());
                }
                if (zNextBoolean) {
                    bitSet.set(i);
                }
                i++;
                jsonTokenPeek = jsonReader.peek();
            }
            jsonReader.endArray();
            return bitSet;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, BitSet bitSet) throws IOException {
            jsonWriter.beginArray();
            int length = bitSet.length();
            for (int i = 0; i < length; i++) {
                jsonWriter.value(bitSet.get(i) ? 1L : 0L);
            }
            jsonWriter.endArray();
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$35, reason: invalid class name */
    static /* synthetic */ class AnonymousClass35 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        static {
            int[] iArr = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$3, reason: invalid class name */
    class AnonymousClass3 extends TypeAdapter<Boolean> {
        AnonymousClass3() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Boolean read(JsonReader jsonReader) throws IOException {
            JsonToken jsonTokenPeek = jsonReader.peek();
            if (jsonTokenPeek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            if (jsonTokenPeek == JsonToken.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(jsonReader.nextString()));
            }
            return Boolean.valueOf(jsonReader.nextBoolean());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
            jsonWriter.value(bool);
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$4, reason: invalid class name */
    class AnonymousClass4 extends TypeAdapter<Boolean> {
        AnonymousClass4() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Boolean read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return Boolean.valueOf(jsonReader.nextString());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
            jsonWriter.value(bool == null ? AbstractJsonLexerKt.NULL : bool.toString());
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$5, reason: invalid class name */
    class AnonymousClass5 extends TypeAdapter<Number> {
        AnonymousClass5() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                int iNextInt = jsonReader.nextInt();
                if (iNextInt > 255 || iNextInt < -128) {
                    throw new JsonSyntaxException("Lossy conversion from " + iNextInt + " to byte; at path " + jsonReader.getPreviousPath());
                }
                return Byte.valueOf((byte) iNextInt);
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.byteValue());
            }
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$6, reason: invalid class name */
    class AnonymousClass6 extends TypeAdapter<Number> {
        AnonymousClass6() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                int iNextInt = jsonReader.nextInt();
                if (iNextInt > 65535 || iNextInt < -32768) {
                    throw new JsonSyntaxException("Lossy conversion from " + iNextInt + " to short; at path " + jsonReader.getPreviousPath());
                }
                return Short.valueOf((short) iNextInt);
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.shortValue());
            }
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$7, reason: invalid class name */
    class AnonymousClass7 extends TypeAdapter<Number> {
        AnonymousClass7() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Integer.valueOf(jsonReader.nextInt());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.intValue());
            }
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$8, reason: invalid class name */
    class AnonymousClass8 extends TypeAdapter<AtomicInteger> {
        AnonymousClass8() {
        }

        @Override // com.google.gson.TypeAdapter
        public AtomicInteger read(JsonReader jsonReader) throws IOException {
            try {
                return new AtomicInteger(jsonReader.nextInt());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, AtomicInteger atomicInteger) throws IOException {
            jsonWriter.value(atomicInteger.get());
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$9, reason: invalid class name */
    class AnonymousClass9 extends TypeAdapter<AtomicBoolean> {
        AnonymousClass9() {
        }

        @Override // com.google.gson.TypeAdapter
        public AtomicBoolean read(JsonReader jsonReader) throws IOException {
            return new AtomicBoolean(jsonReader.nextBoolean());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, AtomicBoolean atomicBoolean) throws IOException {
            jsonWriter.value(atomicBoolean.get());
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$10, reason: invalid class name */
    class AnonymousClass10 extends TypeAdapter<AtomicIntegerArray> {
        AnonymousClass10() {
        }

        @Override // com.google.gson.TypeAdapter
        public AtomicIntegerArray read(JsonReader jsonReader) throws IOException {
            ArrayList arrayList = new ArrayList();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                try {
                    arrayList.add(Integer.valueOf(jsonReader.nextInt()));
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }
            jsonReader.endArray();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i = 0; i < size; i++) {
                atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, AtomicIntegerArray atomicIntegerArray) throws IOException {
            jsonWriter.beginArray();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                jsonWriter.value(atomicIntegerArray.get(i));
            }
            jsonWriter.endArray();
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$11, reason: invalid class name */
    class AnonymousClass11 extends TypeAdapter<Number> {
        AnonymousClass11() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Long.valueOf(jsonReader.nextLong());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.longValue());
            }
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$12, reason: invalid class name */
    class AnonymousClass12 extends TypeAdapter<Number> {
        AnonymousClass12() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return Float.valueOf((float) jsonReader.nextDouble());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
                return;
            }
            if (!(number instanceof Float)) {
                number = Float.valueOf(number.floatValue());
            }
            jsonWriter.value(number);
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$13, reason: invalid class name */
    class AnonymousClass13 extends TypeAdapter<Number> {
        AnonymousClass13() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return Double.valueOf(jsonReader.nextDouble());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.doubleValue());
            }
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$14, reason: invalid class name */
    class AnonymousClass14 extends TypeAdapter<Character> {
        AnonymousClass14() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Character read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String strNextString = jsonReader.nextString();
            if (strNextString.length() != 1) {
                throw new JsonSyntaxException("Expecting character, got: " + strNextString + "; at " + jsonReader.getPreviousPath());
            }
            return Character.valueOf(strNextString.charAt(0));
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Character ch) throws IOException {
            jsonWriter.value(ch == null ? null : String.valueOf(ch));
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$15, reason: invalid class name */
    class AnonymousClass15 extends TypeAdapter<String> {
        AnonymousClass15() {
        }

        @Override // com.google.gson.TypeAdapter
        public String read(JsonReader jsonReader) throws IOException {
            JsonToken jsonTokenPeek = jsonReader.peek();
            if (jsonTokenPeek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            if (jsonTokenPeek == JsonToken.BOOLEAN) {
                return Boolean.toString(jsonReader.nextBoolean());
            }
            return jsonReader.nextString();
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, String str) throws IOException {
            jsonWriter.value(str);
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$16, reason: invalid class name */
    class AnonymousClass16 extends TypeAdapter<BigDecimal> {
        AnonymousClass16() {
        }

        @Override // com.google.gson.TypeAdapter
        public BigDecimal read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String strNextString = jsonReader.nextString();
            try {
                return new BigDecimal(strNextString);
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException("Failed parsing '" + strNextString + "' as BigDecimal; at path " + jsonReader.getPreviousPath(), e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, BigDecimal bigDecimal) throws IOException {
            jsonWriter.value(bigDecimal);
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$17, reason: invalid class name */
    class AnonymousClass17 extends TypeAdapter<BigInteger> {
        AnonymousClass17() {
        }

        @Override // com.google.gson.TypeAdapter
        public BigInteger read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String strNextString = jsonReader.nextString();
            try {
                return new BigInteger(strNextString);
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException("Failed parsing '" + strNextString + "' as BigInteger; at path " + jsonReader.getPreviousPath(), e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, BigInteger bigInteger) throws IOException {
            jsonWriter.value(bigInteger);
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$18, reason: invalid class name */
    class AnonymousClass18 extends TypeAdapter<LazilyParsedNumber> {
        AnonymousClass18() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public LazilyParsedNumber read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return new LazilyParsedNumber(jsonReader.nextString());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, LazilyParsedNumber lazilyParsedNumber) throws IOException {
            jsonWriter.value(lazilyParsedNumber);
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$19, reason: invalid class name */
    class AnonymousClass19 extends TypeAdapter<StringBuilder> {
        AnonymousClass19() {
        }

        @Override // com.google.gson.TypeAdapter
        public StringBuilder read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return new StringBuilder(jsonReader.nextString());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, StringBuilder sb) throws IOException {
            jsonWriter.value(sb == null ? null : sb.toString());
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$20, reason: invalid class name */
    class AnonymousClass20 extends TypeAdapter<StringBuffer> {
        AnonymousClass20() {
        }

        @Override // com.google.gson.TypeAdapter
        public StringBuffer read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return new StringBuffer(jsonReader.nextString());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, StringBuffer stringBuffer) throws IOException {
            jsonWriter.value(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$21, reason: invalid class name */
    class AnonymousClass21 extends TypeAdapter<URL> {
        AnonymousClass21() {
        }

        @Override // com.google.gson.TypeAdapter
        public URL read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String strNextString = jsonReader.nextString();
            if (AbstractJsonLexerKt.NULL.equals(strNextString)) {
                return null;
            }
            return new URL(strNextString);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, URL url) throws IOException {
            jsonWriter.value(url == null ? null : url.toExternalForm());
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$22, reason: invalid class name */
    class AnonymousClass22 extends TypeAdapter<URI> {
        AnonymousClass22() {
        }

        @Override // com.google.gson.TypeAdapter
        public URI read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                String strNextString = jsonReader.nextString();
                if (AbstractJsonLexerKt.NULL.equals(strNextString)) {
                    return null;
                }
                return new URI(strNextString);
            } catch (URISyntaxException e) {
                throw new JsonIOException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, URI uri) throws IOException {
            jsonWriter.value(uri == null ? null : uri.toASCIIString());
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$23, reason: invalid class name */
    class AnonymousClass23 extends TypeAdapter<InetAddress> {
        AnonymousClass23() {
        }

        @Override // com.google.gson.TypeAdapter
        public InetAddress read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return InetAddress.getByName(jsonReader.nextString());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, InetAddress inetAddress) throws IOException {
            jsonWriter.value(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$24, reason: invalid class name */
    class AnonymousClass24 extends TypeAdapter<UUID> {
        AnonymousClass24() {
        }

        @Override // com.google.gson.TypeAdapter
        public UUID read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String strNextString = jsonReader.nextString();
            try {
                return UUID.fromString(strNextString);
            } catch (IllegalArgumentException e) {
                throw new JsonSyntaxException("Failed parsing '" + strNextString + "' as UUID; at path " + jsonReader.getPreviousPath(), e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, UUID uuid) throws IOException {
            jsonWriter.value(uuid == null ? null : uuid.toString());
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$25, reason: invalid class name */
    class AnonymousClass25 extends TypeAdapter<Currency> {
        AnonymousClass25() {
        }

        @Override // com.google.gson.TypeAdapter
        public Currency read(JsonReader jsonReader) throws IOException {
            String strNextString = jsonReader.nextString();
            try {
                return Currency.getInstance(strNextString);
            } catch (IllegalArgumentException e) {
                throw new JsonSyntaxException("Failed parsing '" + strNextString + "' as Currency; at path " + jsonReader.getPreviousPath(), e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Currency currency) throws IOException {
            jsonWriter.value(currency.getCurrencyCode());
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$26, reason: invalid class name */
    class AnonymousClass26 extends TypeAdapter<Calendar> {
        private static final String DAY_OF_MONTH = "dayOfMonth";
        private static final String HOUR_OF_DAY = "hourOfDay";
        private static final String MINUTE = "minute";
        private static final String MONTH = "month";
        private static final String SECOND = "second";
        private static final String YEAR = "year";

        AnonymousClass26() {
        }

        @Override // com.google.gson.TypeAdapter
        public Calendar read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (jsonReader.peek() != JsonToken.END_OBJECT) {
                String strNextName = jsonReader.nextName();
                int iNextInt = jsonReader.nextInt();
                if (YEAR.equals(strNextName)) {
                    i = iNextInt;
                } else if (MONTH.equals(strNextName)) {
                    i2 = iNextInt;
                } else if (DAY_OF_MONTH.equals(strNextName)) {
                    i3 = iNextInt;
                } else if (HOUR_OF_DAY.equals(strNextName)) {
                    i4 = iNextInt;
                } else if (MINUTE.equals(strNextName)) {
                    i5 = iNextInt;
                } else if (SECOND.equals(strNextName)) {
                    i6 = iNextInt;
                }
            }
            jsonReader.endObject();
            return new GregorianCalendar(i, i2, i3, i4, i5, i6);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Calendar calendar) throws IOException {
            if (calendar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name(YEAR);
            jsonWriter.value(calendar.get(1));
            jsonWriter.name(MONTH);
            jsonWriter.value(calendar.get(2));
            jsonWriter.name(DAY_OF_MONTH);
            jsonWriter.value(calendar.get(5));
            jsonWriter.name(HOUR_OF_DAY);
            jsonWriter.value(calendar.get(11));
            jsonWriter.name(MINUTE);
            jsonWriter.value(calendar.get(12));
            jsonWriter.name(SECOND);
            jsonWriter.value(calendar.get(13));
            jsonWriter.endObject();
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$27, reason: invalid class name */
    class AnonymousClass27 extends TypeAdapter<Locale> {
        AnonymousClass27() {
        }

        @Override // com.google.gson.TypeAdapter
        public Locale read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.nextString(), "_");
            String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            if (strNextToken2 == null && strNextToken3 == null) {
                return new Locale(strNextToken);
            }
            if (strNextToken3 == null) {
                return new Locale(strNextToken, strNextToken2);
            }
            return new Locale(strNextToken, strNextToken2, strNextToken3);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Locale locale) throws IOException {
            jsonWriter.value(locale == null ? null : locale.toString());
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$28, reason: invalid class name */
    class AnonymousClass28 extends TypeAdapter<JsonElement> {
        AnonymousClass28() {
        }

        private JsonElement tryBeginNesting(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
            int i = AnonymousClass35.$SwitchMap$com$google$gson$stream$JsonToken[jsonToken.ordinal()];
            if (i == 4) {
                jsonReader.beginArray();
                return new JsonArray();
            }
            if (i != 5) {
                return null;
            }
            jsonReader.beginObject();
            return new JsonObject();
        }

        private JsonElement readTerminal(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
            int i = AnonymousClass35.$SwitchMap$com$google$gson$stream$JsonToken[jsonToken.ordinal()];
            if (i == 1) {
                return new JsonPrimitive(new LazilyParsedNumber(jsonReader.nextString()));
            }
            if (i == 2) {
                return new JsonPrimitive(jsonReader.nextString());
            }
            if (i == 3) {
                return new JsonPrimitive(Boolean.valueOf(jsonReader.nextBoolean()));
            }
            if (i == 6) {
                jsonReader.nextNull();
                return JsonNull.INSTANCE;
            }
            throw new IllegalStateException("Unexpected token: " + jsonToken);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public JsonElement read(JsonReader jsonReader) throws IOException {
            if (jsonReader instanceof JsonTreeReader) {
                return ((JsonTreeReader) jsonReader).nextJsonElement();
            }
            JsonToken jsonTokenPeek = jsonReader.peek();
            JsonElement jsonElementTryBeginNesting = tryBeginNesting(jsonReader, jsonTokenPeek);
            if (jsonElementTryBeginNesting == null) {
                return readTerminal(jsonReader, jsonTokenPeek);
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            while (true) {
                if (jsonReader.hasNext()) {
                    String strNextName = jsonElementTryBeginNesting instanceof JsonObject ? jsonReader.nextName() : null;
                    JsonToken jsonTokenPeek2 = jsonReader.peek();
                    JsonElement jsonElementTryBeginNesting2 = tryBeginNesting(jsonReader, jsonTokenPeek2);
                    boolean z = jsonElementTryBeginNesting2 != null;
                    if (jsonElementTryBeginNesting2 == null) {
                        jsonElementTryBeginNesting2 = readTerminal(jsonReader, jsonTokenPeek2);
                    }
                    if (jsonElementTryBeginNesting instanceof JsonArray) {
                        ((JsonArray) jsonElementTryBeginNesting).add(jsonElementTryBeginNesting2);
                    } else {
                        ((JsonObject) jsonElementTryBeginNesting).add(strNextName, jsonElementTryBeginNesting2);
                    }
                    if (z) {
                        arrayDeque.addLast(jsonElementTryBeginNesting);
                        jsonElementTryBeginNesting = jsonElementTryBeginNesting2;
                    }
                } else {
                    if (jsonElementTryBeginNesting instanceof JsonArray) {
                        jsonReader.endArray();
                    } else {
                        jsonReader.endObject();
                    }
                    if (arrayDeque.isEmpty()) {
                        return jsonElementTryBeginNesting;
                    }
                    jsonElementTryBeginNesting = (JsonElement) arrayDeque.removeLast();
                }
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, JsonElement jsonElement) throws IOException {
            if (jsonElement == null || jsonElement.isJsonNull()) {
                jsonWriter.nullValue();
                return;
            }
            if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    jsonWriter.value(asJsonPrimitive.getAsNumber());
                    return;
                } else if (asJsonPrimitive.isBoolean()) {
                    jsonWriter.value(asJsonPrimitive.getAsBoolean());
                    return;
                } else {
                    jsonWriter.value(asJsonPrimitive.getAsString());
                    return;
                }
            }
            if (jsonElement.isJsonArray()) {
                jsonWriter.beginArray();
                Iterator<JsonElement> it = jsonElement.getAsJsonArray().iterator();
                while (it.hasNext()) {
                    write(jsonWriter, it.next());
                }
                jsonWriter.endArray();
                return;
            }
            if (jsonElement.isJsonObject()) {
                jsonWriter.beginObject();
                for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    write(jsonWriter, entry.getValue());
                }
                jsonWriter.endObject();
                return;
            }
            throw new IllegalArgumentException("Couldn't write " + jsonElement.getClass());
        }
    }

    private static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
        private final Map<String, T> nameToConstant = new HashMap();
        private final Map<String, T> stringToConstant = new HashMap();
        private final Map<T, String> constantToName = new HashMap();

        public EnumTypeAdapter(Class<T> cls) {
            try {
                for (Field field : (Field[]) AccessController.doPrivileged(new AnonymousClass1(cls))) {
                    Enum r4 = (Enum) field.get(null);
                    String strName = r4.name();
                    String string = r4.toString();
                    SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
                    if (serializedName != null) {
                        strName = serializedName.value();
                        for (String str : serializedName.alternate()) {
                            this.nameToConstant.put(str, (T) r4);
                        }
                    }
                    this.nameToConstant.put(strName, (T) r4);
                    this.stringToConstant.put(string, (T) r4);
                    this.constantToName.put((T) r4, strName);
                }
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }

        /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$EnumTypeAdapter$1, reason: invalid class name */
        class AnonymousClass1 implements PrivilegedAction<Field[]> {
            final /* synthetic */ Class val$classOfT;

            AnonymousClass1(Class cls) {
                this.val$classOfT = cls;
            }

            @Override // java.security.PrivilegedAction
            public Field[] run() {
                Field[] declaredFields = this.val$classOfT.getDeclaredFields();
                ArrayList arrayList = new ArrayList(declaredFields.length);
                for (Field field : declaredFields) {
                    if (field.isEnumConstant()) {
                        arrayList.add(field);
                    }
                }
                Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
                AccessibleObject.setAccessible(fieldArr, true);
                return fieldArr;
            }
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String strNextString = jsonReader.nextString();
            T t = this.nameToConstant.get(strNextString);
            return t == null ? this.stringToConstant.get(strNextString) : t;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            jsonWriter.value(t == null ? null : this.constantToName.get(t));
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$29, reason: invalid class name */
    class AnonymousClass29 implements TypeAdapterFactory {
        AnonymousClass29() {
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                return null;
            }
            if (!rawType.isEnum()) {
                rawType = rawType.getSuperclass();
            }
            return new EnumTypeAdapter(rawType);
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$30, reason: invalid class name */
    class AnonymousClass30 implements TypeAdapterFactory {
        final /* synthetic */ TypeToken val$type;
        final /* synthetic */ TypeAdapter val$typeAdapter;

        AnonymousClass30(TypeToken typeToken, TypeAdapter typeAdapter) {
            this.val$type = typeToken;
            this.val$typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.equals(this.val$type)) {
                return this.val$typeAdapter;
            }
            return null;
        }
    }

    public static <TT> TypeAdapterFactory newFactory(TypeToken<TT> typeToken, TypeAdapter<TT> typeAdapter) {
        return new AnonymousClass30(typeToken, typeAdapter);
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$31, reason: invalid class name */
    class AnonymousClass31 implements TypeAdapterFactory {
        final /* synthetic */ Class val$type;
        final /* synthetic */ TypeAdapter val$typeAdapter;

        AnonymousClass31(Class cls, TypeAdapter typeAdapter) {
            this.val$type = cls;
            this.val$typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == this.val$type) {
                return this.val$typeAdapter;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.val$type.getName() + ",adapter=" + this.val$typeAdapter + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
        }
    }

    public static <TT> TypeAdapterFactory newFactory(Class<TT> cls, TypeAdapter<TT> typeAdapter) {
        return new AnonymousClass31(cls, typeAdapter);
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$32, reason: invalid class name */
    class AnonymousClass32 implements TypeAdapterFactory {
        final /* synthetic */ Class val$boxed;
        final /* synthetic */ TypeAdapter val$typeAdapter;
        final /* synthetic */ Class val$unboxed;

        AnonymousClass32(Class cls, Class cls2, TypeAdapter typeAdapter) {
            this.val$unboxed = cls;
            this.val$boxed = cls2;
            this.val$typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (rawType == this.val$unboxed || rawType == this.val$boxed) {
                return this.val$typeAdapter;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.val$boxed.getName() + Marker.ANY_NON_NULL_MARKER + this.val$unboxed.getName() + ",adapter=" + this.val$typeAdapter + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
        }
    }

    public static <TT> TypeAdapterFactory newFactory(Class<TT> cls, Class<TT> cls2, TypeAdapter<? super TT> typeAdapter) {
        return new AnonymousClass32(cls, cls2, typeAdapter);
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$33, reason: invalid class name */
    class AnonymousClass33 implements TypeAdapterFactory {
        final /* synthetic */ Class val$base;
        final /* synthetic */ Class val$sub;
        final /* synthetic */ TypeAdapter val$typeAdapter;

        AnonymousClass33(Class cls, Class cls2, TypeAdapter typeAdapter) {
            this.val$base = cls;
            this.val$sub = cls2;
            this.val$typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (rawType == this.val$base || rawType == this.val$sub) {
                return this.val$typeAdapter;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.val$base.getName() + Marker.ANY_NON_NULL_MARKER + this.val$sub.getName() + ",adapter=" + this.val$typeAdapter + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
        }
    }

    public static <TT> TypeAdapterFactory newFactoryForMultipleTypes(Class<TT> cls, Class<? extends TT> cls2, TypeAdapter<? super TT> typeAdapter) {
        return new AnonymousClass33(cls, cls2, typeAdapter);
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$34, reason: invalid class name */
    class AnonymousClass34 implements TypeAdapterFactory {
        final /* synthetic */ Class val$clazz;
        final /* synthetic */ TypeAdapter val$typeAdapter;

        AnonymousClass34(Class cls, TypeAdapter typeAdapter) {
            this.val$clazz = cls;
            this.val$typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T2> TypeAdapter<T2> create(Gson gson, TypeToken<T2> typeToken) {
            Class<? super T2> rawType = typeToken.getRawType();
            if (this.val$clazz.isAssignableFrom(rawType)) {
                return new AnonymousClass1(rawType);
            }
            return null;
        }

        /* JADX INFO: Add missing generic type declarations: [T1] */
        /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$34$1, reason: invalid class name */
        class AnonymousClass1<T1> extends TypeAdapter<T1> {
            final /* synthetic */ Class val$requestedType;

            AnonymousClass1(Class cls) {
                this.val$requestedType = cls;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, T1 t1) throws IOException {
                AnonymousClass34.this.val$typeAdapter.write(jsonWriter, t1);
            }

            @Override // com.google.gson.TypeAdapter
            public T1 read(JsonReader jsonReader) throws IOException {
                T1 t1 = (T1) AnonymousClass34.this.val$typeAdapter.read(jsonReader);
                if (t1 == null || this.val$requestedType.isInstance(t1)) {
                    return t1;
                }
                throw new JsonSyntaxException("Expected a " + this.val$requestedType.getName() + " but was " + t1.getClass().getName() + "; at path " + jsonReader.getPreviousPath());
            }
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.val$clazz.getName() + ",adapter=" + this.val$typeAdapter + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
        }
    }

    public static <T1> TypeAdapterFactory newTypeHierarchyFactory(Class<T1> cls, TypeAdapter<T1> typeAdapter) {
        return new AnonymousClass34(cls, typeAdapter);
    }
}
