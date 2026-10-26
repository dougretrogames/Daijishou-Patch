package com.google.api.client.json.gson;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonGenerator;
import com.google.api.client.json.JsonParser;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* INFO: loaded from: classes3.dex */
public class GsonFactory extends JsonFactory {
    private boolean readLeniency;

    /* synthetic */ GsonFactory(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public static GsonFactory getDefaultInstance() {
        return InstanceHolder.INSTANCE;
    }

    static class InstanceHolder {
        static final GsonFactory INSTANCE = new GsonFactory();

        InstanceHolder() {
        }
    }

    public GsonFactory() {
        this.readLeniency = false;
    }

    private GsonFactory(Builder builder) {
        this.readLeniency = false;
        this.readLeniency = builder.readLeniency;
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser createJsonParser(InputStream inputStream) {
        return createJsonParser(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser createJsonParser(InputStream inputStream, Charset charset) {
        if (charset == null) {
            return createJsonParser(inputStream);
        }
        return createJsonParser(new InputStreamReader(inputStream, charset));
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser createJsonParser(String str) {
        return createJsonParser(new StringReader(str));
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonParser createJsonParser(Reader reader) {
        return new GsonParser(this, new JsonReader(reader));
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonGenerator createJsonGenerator(OutputStream outputStream, Charset charset) {
        return createJsonGenerator(new OutputStreamWriter(outputStream, charset));
    }

    @Override // com.google.api.client.json.JsonFactory
    public JsonGenerator createJsonGenerator(Writer writer) {
        return new GsonGenerator(this, new JsonWriter(writer));
    }

    boolean getReadLeniency() {
        return this.readLeniency;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public static final class Builder {
        private boolean readLeniency;

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            this.readLeniency = false;
        }

        public Builder setReadLeniency(boolean z) {
            this.readLeniency = z;
            return this;
        }

        public GsonFactory build() {
            return new GsonFactory(this, null);
        }
    }
}
