package com.magneticchen.daijishou.logger;

import android.app.Service;
import android.content.Context;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;

/* INFO: compiled from: Logger.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 02\u00020\u0001:\u000201B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\fJ\u0006\u0010\u001f\u001a\u00020\u001dJ\u0016\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\fJ\u0016\u0010#\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\fJ\u0016\u0010$\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\fJ\u000e\u0010%\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\fJ \u0010&\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u00012\u0006\u0010'\u001a\u00020(2\u0006\u0010\"\u001a\u00020\fH\u0002J\u0010\u0010)\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0002J\u0018\u0010*\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010+\u001a\u00020(J\u0006\u0010,\u001a\u00020\u001dJ\u0016\u0010-\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\fJ\u0018\u0010.\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010/\u001a\u00020\fH\u0002R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/magneticchen/daijishou/logger/Logger;", "", "application", "Landroid/app/Service;", "(Landroid/app/Service;)V", "_latestLogRecordLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/magneticchen/daijishou/logger/Logger$LogRecord;", "getApplication", "()Landroid/app/Service;", "components", "Ljava/util/SortedSet;", "", "getComponents", "()Ljava/util/SortedSet;", "json", "Lkotlinx/serialization/json/Json;", "latestLogRecordLiveData", "Landroidx/lifecycle/LiveData;", "getLatestLogRecordLiveData", "()Landroidx/lifecycle/LiveData;", Constants.LOGS, "", "getLogs", "()Ljava/util/List;", "previousTimestamp", "", "weakJson", "appendLogsFromFile", "", "filename", "clear", "debug", "fromComponent", "message", "error", "info", "logger", "printLog", "LoggerCode", "", "readFromFile", "saveLogsToFile", "length", "trim", "warn", "writeToFile", "data", "Companion", "LogRecord", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Logger {
    public static final int DEBUG_LOG_RECORD_TYPE = 1;
    public static final int ERROR_LOG_RECORD_TYPE = 3;
    public static final int INFO_LOG_RECORD_TYPE = 0;
    public static final int LOGGER_LOG_RECORD_TYPE = -1;
    public static final int MESSAGE_MAX_SIZE = 4096;
    public static final String TAG = "daijishou_logging_service";
    public static final int WARN_LOG_RECORD_TYPE = 2;
    private final MutableLiveData<LogRecord> _latestLogRecordLiveData;
    private final Service application;
    private final SortedSet<String> components;
    private final Json json;
    private final List<LogRecord> logs;
    private long previousTimestamp;
    private final Json weakJson;

    public final void trim() {
    }

    public Logger(Service application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.application = application;
        this.previousTimestamp = System.currentTimeMillis();
        this.weakJson = JsonKt.Json$default(null, Logger$weakJson$1.INSTANCE, 1, null);
        this.json = JsonKt.Json$default(null, Logger$json$1.INSTANCE, 1, null);
        this.logs = new ArrayList();
        this.components = SetsKt.sortedSetOf(new String[0]);
        this._latestLogRecordLiveData = new MutableLiveData<>(null);
    }

    public final Service getApplication() {
        return this.application;
    }

    /* INFO: compiled from: Logger.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(B=\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB+\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\rJ\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\bHÖ\u0001J&\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%HÁ\u0001¢\u0006\u0002\b&R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006)"}, d2 = {"Lcom/magneticchen/daijishou/logger/Logger$LogRecord;", "", "seen1", "", "timestamp", "", "type", "fromComponent", "", "message", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(JILjava/lang/String;Ljava/lang/String;)V", "getFromComponent", "()Ljava/lang/String;", "getMessage", "getTimestamp", "()J", "getType", "()I", "component1", "component2", "component3", "component4", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Serializable
    public static final /* data */ class LogRecord {

        /* INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String fromComponent;
        private final String message;
        private final long timestamp;
        private final int type;

        public static /* synthetic */ LogRecord copy$default(LogRecord logRecord, long j, int i, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = logRecord.timestamp;
            }
            long j2 = j;
            if ((i2 & 2) != 0) {
                i = logRecord.type;
            }
            int i3 = i;
            if ((i2 & 4) != 0) {
                str = logRecord.fromComponent;
            }
            String str3 = str;
            if ((i2 & 8) != 0) {
                str2 = logRecord.message;
            }
            return logRecord.copy(j2, i3, str3, str2);
        }

        /* INFO: renamed from: component1, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        /* INFO: renamed from: component2, reason: from getter */
        public final int getType() {
            return this.type;
        }

        /* INFO: renamed from: component3, reason: from getter */
        public final String getFromComponent() {
            return this.fromComponent;
        }

        /* INFO: renamed from: component4, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final LogRecord copy(long timestamp, int type, String fromComponent, String message) {
            Intrinsics.checkNotNullParameter(fromComponent, "fromComponent");
            Intrinsics.checkNotNullParameter(message, "message");
            return new LogRecord(timestamp, type, fromComponent, message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LogRecord)) {
                return false;
            }
            LogRecord logRecord = (LogRecord) other;
            return this.timestamp == logRecord.timestamp && this.type == logRecord.type && Intrinsics.areEqual(this.fromComponent, logRecord.fromComponent) && Intrinsics.areEqual(this.message, logRecord.message);
        }

        public int hashCode() {
            return (((((Long.hashCode(this.timestamp) * 31) + Integer.hashCode(this.type)) * 31) + this.fromComponent.hashCode()) * 31) + this.message.hashCode();
        }

        public String toString() {
            return "LogRecord(timestamp=" + this.timestamp + ", type=" + this.type + ", fromComponent=" + this.fromComponent + ", message=" + this.message + ")";
        }

        /* INFO: compiled from: Logger.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/magneticchen/daijishou/logger/Logger$LogRecord$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/magneticchen/daijishou/logger/Logger$LogRecord;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<LogRecord> serializer() {
                return Logger$LogRecord$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ LogRecord(int i, long j, int i2, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if (8 != (i & 8)) {
                PluginExceptionsKt.throwMissingFieldException(i, 8, Logger$LogRecord$$serializer.INSTANCE.getDescriptor());
            }
            this.timestamp = (i & 1) == 0 ? 0L : j;
            if ((i & 2) == 0) {
                this.type = -1;
            } else {
                this.type = i2;
            }
            if ((i & 4) == 0) {
                this.fromComponent = "Unknown";
            } else {
                this.fromComponent = str;
            }
            this.message = str2;
        }

        public LogRecord(long j, int i, String fromComponent, String message) {
            Intrinsics.checkNotNullParameter(fromComponent, "fromComponent");
            Intrinsics.checkNotNullParameter(message, "message");
            this.timestamp = j;
            this.type = i;
            this.fromComponent = fromComponent;
            this.message = message;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$app_release(LogRecord self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.timestamp != 0) {
                output.encodeLongElement(serialDesc, 0, self.timestamp);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.type != -1) {
                output.encodeIntElement(serialDesc, 1, self.type);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.fromComponent, "Unknown")) {
                output.encodeStringElement(serialDesc, 2, self.fromComponent);
            }
            output.encodeStringElement(serialDesc, 3, self.message);
        }



        public /* synthetic */ LogRecord(long j, int i, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0L : j, (i2 & 2) != 0 ? -1 : i, (i2 & 4) != 0 ? "Unknown" : str, str2);
        }


    }

    public final List<LogRecord> getLogs() {
        return this.logs;
    }

    public final SortedSet<String> getComponents() {
        return this.components;
    }

    public final LiveData<LogRecord> getLatestLogRecordLiveData() {
        return this._latestLogRecordLiveData;
    }

    private final void writeToFile(String filename, String data) {
        Context applicationContext = this.application.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(applicationContext.openFileOutput(filename, 0));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        } catch (IOException e) {
            throw new IllegalStateException(("File write failed: " + e).toString());
        }
    }

    private final String readFromFile(String filename) {
        Context applicationContext = this.application.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        try {
            FileInputStream fileInputStreamOpenFileInput = applicationContext.openFileInput(filename);
            Intrinsics.checkNotNullExpressionValue(fileInputStreamOpenFileInput, "openFileInput(...)");
            FileInputStream fileInputStream = fileInputStreamOpenFileInput;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append("\n").append(line);
                } else {
                    fileInputStream.close();
                    String string = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    return string;
                }
            }
        } catch (FileNotFoundException e) {
            throw new IllegalStateException(("File not found: " + e).toString());
        } catch (IOException e2) {
            throw new IllegalStateException(("Can not read file: " + e2).toString());
        }
    }

    private final void printLog(Object fromComponent, int LoggerCode, String message) {
        String str;
        String simpleName = fromComponent instanceof String ? (String) fromComponent : fromComponent.getClass().getSimpleName();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.previousTimestamp;
        if (jCurrentTimeMillis <= j) {
            jCurrentTimeMillis = 1 + j;
        }
        long j2 = jCurrentTimeMillis;
        this.previousTimestamp = j2;
        Intrinsics.checkNotNull(simpleName);
        if (message.length() > 4096) {
            String strSubstring = message.substring(0, 4093);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            str = strSubstring + "...";
        } else {
            str = message;
        }
        LogRecord logRecord = new LogRecord(j2, LoggerCode, simpleName, str);
        this.logs.add(logRecord);
        this.components.add(simpleName);
        this._latestLogRecordLiveData.postValue(logRecord);
        if (LoggerCode == -1) {
            Log.i(TAG, CollectionUtils.DEFAULT_TOSTRING_PREFIX + simpleName + "] " + message);
            return;
        }
        if (LoggerCode == 0) {
            Log.i(TAG, CollectionUtils.DEFAULT_TOSTRING_PREFIX + simpleName + "] " + message);
            return;
        }
        if (LoggerCode == 1) {
            Log.d(TAG, CollectionUtils.DEFAULT_TOSTRING_PREFIX + simpleName + "] " + message);
        } else if (LoggerCode == 2) {
            Log.w(TAG, CollectionUtils.DEFAULT_TOSTRING_PREFIX + simpleName + "] " + message);
        } else {
            if (LoggerCode != 3) {
                return;
            }
            Log.e(TAG, CollectionUtils.DEFAULT_TOSTRING_PREFIX + simpleName + "] " + message);
        }
    }

    public final void appendLogsFromFile(String filename) {
        LogRecord logRecord;
        Intrinsics.checkNotNullParameter(filename, "filename");
        try {
            Json json = this.weakJson;
            String fromFile = readFromFile(filename);
            json.getSerializersModule();
            List list = (List) json.decodeFromString(new ArrayListSerializer(LogRecord.INSTANCE.serializer()), fromFile);
            this.logs.addAll(list);
            SortedSet<String> sortedSet = this.components;
            List list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((LogRecord) it.next()).getFromComponent());
            }
            sortedSet.addAll(CollectionsKt.toSet(arrayList));
            List<LogRecord> list3 = this.logs;
            if (list3.size() > 1) {
                CollectionsKt.sortWith(list3, new Logger$appendLogsFromFile$$inlined$sortBy$1());
            }
            MutableLiveData<LogRecord> mutableLiveData = this._latestLogRecordLiveData;
            if (this.logs.isEmpty()) {
                logRecord = null;
            } else {
                List<LogRecord> list4 = this.logs;
                logRecord = list4.get(list4.size() - 1);
            }
            mutableLiveData.setValue(logRecord);
        } catch (Exception e) {
            logger("Append logs from file error.");
            error(this, ExceptionsKt.stackTraceToString(e));
        }
    }

    public static /* synthetic */ void saveLogsToFile$default(Logger logger, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 256;
        }
        logger.saveLogsToFile(str, i);
    }

    public final void saveLogsToFile(String filename, int length) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        try {
            Json json = this.json;
            List listTakeLast = CollectionsKt.takeLast(this.logs, length);
            json.getSerializersModule();
            writeToFile(filename, json.encodeToString(new ArrayListSerializer(LogRecord.INSTANCE.serializer()), listTakeLast));
        } catch (Exception e) {
            logger("Save logs to file. error.");
            error(this, ExceptionsKt.stackTraceToString(e));
        }
    }

    public final void logger(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        printLog(this, -1, message);
    }

    public final void debug(Object fromComponent, String message) {
        Intrinsics.checkNotNullParameter(fromComponent, "fromComponent");
        Intrinsics.checkNotNullParameter(message, "message");
        printLog(fromComponent, 1, message);
    }

    public final void info(Object fromComponent, String message) {
        Intrinsics.checkNotNullParameter(fromComponent, "fromComponent");
        Intrinsics.checkNotNullParameter(message, "message");
        printLog(fromComponent, 0, message);
    }

    public final void error(Object fromComponent, String message) {
        Intrinsics.checkNotNullParameter(fromComponent, "fromComponent");
        Intrinsics.checkNotNullParameter(message, "message");
        printLog(fromComponent, 3, message);
    }

    public final void warn(Object fromComponent, String message) {
        Intrinsics.checkNotNullParameter(fromComponent, "fromComponent");
        Intrinsics.checkNotNullParameter(message, "message");
        printLog(fromComponent, 2, message);
    }

    public final void clear() {
        this.logs.clear();
        this.components.clear();
        this._latestLogRecordLiveData.postValue(null);
        logger("Logger cleared.");
    }
}
