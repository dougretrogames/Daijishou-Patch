package com.magneticchen.daijishou.service.debug.passive_protocol.client_operations;

import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.service.debug.passive_protocol.ClientOperation;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.AccessDeniedException;
import kotlin.io.ByteStreamsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: FileOperation.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\nJ\u0006\u0010\u0014\u001a\u00020\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/magneticchen/daijishou/service/debug/passive_protocol/client_operations/FileOperation;", "Lcom/magneticchen/daijishou/service/debug/passive_protocol/ClientOperation;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "headerByteCode", "", "getHeaderByteCode", "()B", "isMainActivityRequired", "", "()Z", "handleDataStreams", "", "dataInputStream", "Ljava/io/DataInputStream;", "dataOutputStream", "Ljava/io/DataOutputStream;", "(Ljava/io/DataInputStream;Ljava/io/DataOutputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFileFromDataInputStreamToFile", "writeFileToDataInputStreamFromFile", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FileOperation extends ClientOperation {
    private static final Void MAKE_DIRECTORY_SUB_OPERATION_BYTE_CODE = null;
    private static final Void MOVE_FILE_SUB_OPERATION_BYTE_CODE = null;
    private static final int SUCCEED_RESULT_STATUS_BYTE_CODE = 0;
    private final byte headerByteCode;
    private final boolean isMainActivityRequired;
    public static final Companion Companion = new Companion(null);
    private static final int LIST_FILES_SUB_OPERATION_BYTE_CODE = 1;
    private static final int DELETE_FILE_SUB_OPERATION_BYTE_CODE = 2;
    private static final int PUSH_FILE_SUB_OPERATION_BYTE_CODE = 3;
    private static final int PULL_FILE_SUB_OPERATION_BYTE_CODE = 4;
    private static final int BYTES_CHUNK_SIZE = 524288;
    private static final int MAX_RETRIED_COUNT = 3;
    private static final int FAILED_RESULT_STATUS_BYTE_CODE = 1;
    private static final int NO_SUCH_FILE_RESULT_STATUS_BYTE_CODE = 2;
    private static final int ACCESS_DENIED_RESULT_STATUS_BYTE_CODE = 3;
    private static final int FILE_EXISTS_RESULT_STATUS_BYTE_CODE = 4;
    private static final int CHECKSUM_MISMATCHED_RESULT_STATUS_BYTE_CODE = 5;

    public final boolean readFileFromDataInputStreamToFile() {
        return false;
    }

    public final boolean writeFileToDataInputStreamFromFile() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileOperation(DaijishouApplication application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.headerByteCode = (byte) 4;
    }

    @Override // com.magneticchen.daijishou.service.debug.passive_protocol.ClientOperation
    public byte getHeaderByteCode() {
        return this.headerByteCode;
    }

    /* JADX INFO: compiled from: FileOperation.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0001\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0014\u0010\u001d\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0014\u0010\u001f\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0014\u0010!\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006¨\u0006#"}, d2 = {"Lcom/magneticchen/daijishou/service/debug/passive_protocol/client_operations/FileOperation$Companion;", "", "()V", "ACCESS_DENIED_RESULT_STATUS_BYTE_CODE", "", "getACCESS_DENIED_RESULT_STATUS_BYTE_CODE", "()I", "BYTES_CHUNK_SIZE", "getBYTES_CHUNK_SIZE", "CHECKSUM_MISMATCHED_RESULT_STATUS_BYTE_CODE", "getCHECKSUM_MISMATCHED_RESULT_STATUS_BYTE_CODE", "DELETE_FILE_SUB_OPERATION_BYTE_CODE", "getDELETE_FILE_SUB_OPERATION_BYTE_CODE", "FAILED_RESULT_STATUS_BYTE_CODE", "getFAILED_RESULT_STATUS_BYTE_CODE", "FILE_EXISTS_RESULT_STATUS_BYTE_CODE", "getFILE_EXISTS_RESULT_STATUS_BYTE_CODE", "LIST_FILES_SUB_OPERATION_BYTE_CODE", "getLIST_FILES_SUB_OPERATION_BYTE_CODE", "MAKE_DIRECTORY_SUB_OPERATION_BYTE_CODE", "", "getMAKE_DIRECTORY_SUB_OPERATION_BYTE_CODE", "()Ljava/lang/Void;", "MAX_RETRIED_COUNT", "getMAX_RETRIED_COUNT", "MOVE_FILE_SUB_OPERATION_BYTE_CODE", "getMOVE_FILE_SUB_OPERATION_BYTE_CODE", "NO_SUCH_FILE_RESULT_STATUS_BYTE_CODE", "getNO_SUCH_FILE_RESULT_STATUS_BYTE_CODE", "PULL_FILE_SUB_OPERATION_BYTE_CODE", "getPULL_FILE_SUB_OPERATION_BYTE_CODE", "PUSH_FILE_SUB_OPERATION_BYTE_CODE", "getPUSH_FILE_SUB_OPERATION_BYTE_CODE", "SUCCEED_RESULT_STATUS_BYTE_CODE", "getSUCCEED_RESULT_STATUS_BYTE_CODE", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getLIST_FILES_SUB_OPERATION_BYTE_CODE() {
            return FileOperation.LIST_FILES_SUB_OPERATION_BYTE_CODE;
        }

        public final int getDELETE_FILE_SUB_OPERATION_BYTE_CODE() {
            return FileOperation.DELETE_FILE_SUB_OPERATION_BYTE_CODE;
        }

        public final Void getMAKE_DIRECTORY_SUB_OPERATION_BYTE_CODE() {
            return FileOperation.MAKE_DIRECTORY_SUB_OPERATION_BYTE_CODE;
        }

        public final Void getMOVE_FILE_SUB_OPERATION_BYTE_CODE() {
            return FileOperation.MOVE_FILE_SUB_OPERATION_BYTE_CODE;
        }

        public final int getPUSH_FILE_SUB_OPERATION_BYTE_CODE() {
            return FileOperation.PUSH_FILE_SUB_OPERATION_BYTE_CODE;
        }

        public final int getPULL_FILE_SUB_OPERATION_BYTE_CODE() {
            return FileOperation.PULL_FILE_SUB_OPERATION_BYTE_CODE;
        }

        public final int getBYTES_CHUNK_SIZE() {
            return FileOperation.BYTES_CHUNK_SIZE;
        }

        public final int getMAX_RETRIED_COUNT() {
            return FileOperation.MAX_RETRIED_COUNT;
        }

        public final int getSUCCEED_RESULT_STATUS_BYTE_CODE() {
            return FileOperation.SUCCEED_RESULT_STATUS_BYTE_CODE;
        }

        public final int getFAILED_RESULT_STATUS_BYTE_CODE() {
            return FileOperation.FAILED_RESULT_STATUS_BYTE_CODE;
        }

        public final int getNO_SUCH_FILE_RESULT_STATUS_BYTE_CODE() {
            return FileOperation.NO_SUCH_FILE_RESULT_STATUS_BYTE_CODE;
        }

        public final int getACCESS_DENIED_RESULT_STATUS_BYTE_CODE() {
            return FileOperation.ACCESS_DENIED_RESULT_STATUS_BYTE_CODE;
        }

        public final int getFILE_EXISTS_RESULT_STATUS_BYTE_CODE() {
            return FileOperation.FILE_EXISTS_RESULT_STATUS_BYTE_CODE;
        }

        public final int getCHECKSUM_MISMATCHED_RESULT_STATUS_BYTE_CODE() {
            return FileOperation.CHECKSUM_MISMATCHED_RESULT_STATUS_BYTE_CODE;
        }
    }

    @Override // com.magneticchen.daijishou.service.debug.passive_protocol.ClientOperation
    public boolean isMainActivityRequired() {
        return this.isMainActivityRequired;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.service.debug.passive_protocol.client_operations.FileOperation$handleDataStreams$2, reason: invalid class name */
    /* JADX INFO: compiled from: FileOperation.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.service.debug.passive_protocol.client_operations.FileOperation$handleDataStreams$2", f = "FileOperation.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DataInputStream $dataInputStream;
        final /* synthetic */ DataOutputStream $dataOutputStream;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ FileOperation this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(DataInputStream dataInputStream, FileOperation fileOperation, DataOutputStream dataOutputStream, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$dataInputStream = dataInputStream;
            this.this$0 = fileOperation;
            this.$dataOutputStream = dataOutputStream;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$dataInputStream, this.this$0, this.$dataOutputStream, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            boolean zDeleteRecursively;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            byte b = this.$dataInputStream.readByte();
            this.this$0.getLogger().debug(this.this$0, "Byte code: " + ((int) b));
            try {
                try {
                    int i = 0;
                    if (b == FileOperation.Companion.getLIST_FILES_SUB_OPERATION_BYTE_CODE()) {
                        String stringFromDataInputStream = this.this$0.readStringFromDataInputStream(this.$dataInputStream);
                        if (this.this$0.getDaijishouUriHandler().isDaijishouFileUri(stringFromDataInputStream)) {
                            stringFromDataInputStream = this.this$0.getDaijishouUriHandler().decodeFromDaijishouFileUri(stringFromDataInputStream);
                        }
                        this.this$0.getLogger().debug(this.this$0, String.valueOf(stringFromDataInputStream));
                        File file = Paths.get(stringFromDataInputStream, new String[0]).toFile();
                        if (!file.exists()) {
                            throw new NoSuchFileException("File not found.");
                        }
                        if (!file.canRead()) {
                            Intrinsics.checkNotNull(file);
                            throw new AccessDeniedException(file, null, null, 6, null);
                        }
                        File[] fileArrListFiles = file.listFiles();
                        this.$dataOutputStream.write(this.this$0.getHeaderByteCode());
                        this.$dataOutputStream.write(FileOperation.Companion.getSUCCEED_RESULT_STATUS_BYTE_CODE());
                        this.$dataOutputStream.writeInt(fileArrListFiles != null ? fileArrListFiles.length : 0);
                        if (fileArrListFiles == null) {
                            return null;
                        }
                        DataOutputStream dataOutputStream = this.$dataOutputStream;
                        FileOperation fileOperation = this.this$0;
                        int length = fileArrListFiles.length;
                        while (i < length) {
                            File file2 = fileArrListFiles[i];
                            dataOutputStream.write(file2.isDirectory() ? 1 : 0);
                            dataOutputStream.writeLong(file2.length());
                            String name = file2.getName();
                            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                            fileOperation.writeStringToDataOutputStream(dataOutputStream, name);
                            String absolutePath = file2.getAbsolutePath();
                            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                            fileOperation.writeStringToDataOutputStream(dataOutputStream, absolutePath);
                            i++;
                        }
                        return Unit.INSTANCE;
                    }
                    if (b == FileOperation.Companion.getDELETE_FILE_SUB_OPERATION_BYTE_CODE()) {
                        String stringFromDataInputStream2 = this.this$0.readStringFromDataInputStream(this.$dataInputStream);
                        if (this.this$0.getDaijishouUriHandler().isDaijishouFileUri(stringFromDataInputStream2)) {
                            stringFromDataInputStream2 = this.this$0.getDaijishouUriHandler().decodeFromDaijishouFileUri(stringFromDataInputStream2);
                        }
                        File file3 = Paths.get(stringFromDataInputStream2, new String[0]).toFile();
                        if (!file3.exists()) {
                            throw new NoSuchFileException("File not found.");
                        }
                        if (!file3.canRead()) {
                            Intrinsics.checkNotNull(file3);
                            throw new AccessDeniedException(file3, null, null, 6, null);
                        }
                        if (!file3.canWrite()) {
                            Intrinsics.checkNotNull(file3);
                            throw new AccessDeniedException(file3, null, null, 6, null);
                        }
                        this.this$0.getLogger().debug(this.this$0, "delete");
                        if (file3.isFile()) {
                            zDeleteRecursively = file3.delete();
                        } else {
                            Intrinsics.checkNotNull(file3);
                            zDeleteRecursively = FilesKt.deleteRecursively(file3);
                        }
                        this.$dataOutputStream.write(this.this$0.getHeaderByteCode());
                        if (zDeleteRecursively) {
                            this.$dataOutputStream.write(FileOperation.Companion.getSUCCEED_RESULT_STATUS_BYTE_CODE());
                        } else {
                            this.$dataOutputStream.write(FileOperation.Companion.getACCESS_DENIED_RESULT_STATUS_BYTE_CODE());
                        }
                        return Unit.INSTANCE;
                    }
                    int i2 = 1;
                    if (b == FileOperation.Companion.getPUSH_FILE_SUB_OPERATION_BYTE_CODE()) {
                        String stringFromDataInputStream3 = this.this$0.readStringFromDataInputStream(this.$dataInputStream);
                        if (this.this$0.getDaijishouUriHandler().isDaijishouFileUri(stringFromDataInputStream3)) {
                            stringFromDataInputStream3 = this.this$0.getDaijishouUriHandler().decodeFromDaijishouFileUri(stringFromDataInputStream3);
                        }
                        String str = stringFromDataInputStream3;
                        Path path = Paths.get(str, new String[0]);
                        int i3 = this.$dataInputStream.readInt();
                        Files.createDirectories(path, new FileAttribute[0]);
                        File file4 = path.toFile();
                        if (!file4.exists()) {
                            throw new NoSuchFileException("File not found.");
                        }
                        if (!file4.canRead()) {
                            Intrinsics.checkNotNull(file4);
                            throw new AccessDeniedException(file4, null, null, 6, null);
                        }
                        if (!file4.canWrite()) {
                            Intrinsics.checkNotNull(file4);
                            throw new AccessDeniedException(file4, null, null, 6, null);
                        }
                        this.$dataOutputStream.write(this.this$0.getHeaderByteCode());
                        this.$dataOutputStream.write(FileOperation.Companion.getSUCCEED_RESULT_STATUS_BYTE_CODE());
                        int i4 = 0;
                        int i5 = 0;
                        while (i4 < i3) {
                            if (i5 >= 3) {
                                throw new Exception("Have retried " + i5 + " times with failure.");
                            }
                            try {
                                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                                String stringFromDataInputStream4 = this.this$0.readStringFromDataInputStream(this.$dataInputStream);
                                String[] strArr = new String[i2];
                                strArr[i] = stringFromDataInputStream4;
                                Path path2 = Paths.get(str, strArr);
                                long j = this.$dataInputStream.readLong();
                                this.this$0.getLogger().debug(this.this$0, "Downloading file \"" + stringFromDataInputStream4 + "\" to \"" + str + "\". In total " + j + " bytes.");
                                Files.createDirectories(path2.getParent(), new FileAttribute[i]);
                                FileOutputStream fileOutputStream = new FileOutputStream(path2.toString());
                                byte[] bArr = new byte[FileOperation.Companion.getBYTES_CHUNK_SIZE()];
                                long j2 = 0;
                                while (j2 < j) {
                                    long j3 = j - j2;
                                    byte[] bArrCopyOf = j3 >= ((long) FileOperation.Companion.getBYTES_CHUNK_SIZE()) ? bArr : new byte[(int) j3];
                                    int i6 = this.$dataInputStream.read(bArrCopyOf);
                                    if (i6 != FileOperation.Companion.getBYTES_CHUNK_SIZE()) {
                                        bArrCopyOf = Arrays.copyOf(bArrCopyOf, i6);
                                        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
                                    }
                                    fileOutputStream.write(bArrCopyOf);
                                    messageDigest.update(bArrCopyOf);
                                    j2 += (long) i6;
                                }
                                if (Arrays.equals(this.this$0.read32BytesFromDataInputStream(this.$dataInputStream), messageDigest.digest())) {
                                    this.$dataOutputStream.write(this.this$0.getHeaderByteCode());
                                    this.$dataOutputStream.write(FileOperation.Companion.getSUCCEED_RESULT_STATUS_BYTE_CODE());
                                    i4++;
                                    i5 = 0;
                                } else {
                                    this.this$0.getLogger().debug(this.this$0, "Checksum mismatched. Retry download.");
                                    this.$dataOutputStream.write(this.this$0.getHeaderByteCode());
                                    this.$dataOutputStream.write(FileOperation.Companion.getCHECKSUM_MISMATCHED_RESULT_STATUS_BYTE_CODE());
                                    i5++;
                                }
                            } catch (Exception e) {
                                this.this$0.getLogger().warn(this.this$0, ExceptionsKt.stackTraceToString(e));
                                this.$dataOutputStream.write(this.this$0.getHeaderByteCode());
                                this.$dataOutputStream.write(FileOperation.Companion.getFAILED_RESULT_STATUS_BYTE_CODE());
                            }
                            i = 0;
                            i2 = 1;
                        }
                        this.$dataOutputStream.write(this.this$0.getHeaderByteCode());
                        this.$dataOutputStream.write(FileOperation.Companion.getSUCCEED_RESULT_STATUS_BYTE_CODE());
                        return Unit.INSTANCE;
                    }
                    if (b == FileOperation.Companion.getPULL_FILE_SUB_OPERATION_BYTE_CODE()) {
                        String stringFromDataInputStream5 = this.this$0.readStringFromDataInputStream(this.$dataInputStream);
                        if (this.this$0.getDaijishouUriHandler().isDaijishouFileUri(stringFromDataInputStream5)) {
                            stringFromDataInputStream5 = this.this$0.getDaijishouUriHandler().decodeFromDaijishouFileUri(stringFromDataInputStream5);
                        }
                        Path path3 = Paths.get(stringFromDataInputStream5, new String[0]);
                        File file5 = path3.toFile();
                        if (!file5.canRead()) {
                            this.$dataOutputStream.write(this.this$0.getHeaderByteCode());
                            this.$dataOutputStream.write(FileOperation.Companion.getACCESS_DENIED_RESULT_STATUS_BYTE_CODE());
                            return Unit.INSTANCE;
                        }
                        if (!file5.exists()) {
                            this.$dataOutputStream.write(this.this$0.getHeaderByteCode());
                            this.$dataOutputStream.write(FileOperation.Companion.getNO_SUCH_FILE_RESULT_STATUS_BYTE_CODE());
                            return Unit.INSTANCE;
                        }
                        if (file5.exists()) {
                            this.$dataOutputStream.write(this.this$0.getHeaderByteCode());
                            this.$dataOutputStream.write(FileOperation.Companion.getSUCCEED_RESULT_STATUS_BYTE_CODE());
                            if (file5.isDirectory()) {
                                final ArrayList<Path> arrayList = new ArrayList();
                                Stream<Path> streamWalk = Files.walk(path3, new FileVisitOption[0]);
                                final C00052 c00052 = new Function1<Path, Boolean>() { // from class: com.magneticchen.daijishou.service.debug.passive_protocol.client_operations.FileOperation.handleDataStreams.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(Path path4) {
                                        Intrinsics.checkNotNull(path4);
                                        return Boolean.valueOf(!Files.isDirectory(path4, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)));
                                    }
                                };
                                Stream<Path> streamFilter = streamWalk.filter(new Predicate() { // from class: com.magneticchen.daijishou.service.debug.passive_protocol.client_operations.FileOperation$handleDataStreams$2$$ExternalSyntheticLambda0
                                    @Override // java.util.function.Predicate
                                    public final boolean test(Object obj2) {
                                        return FileOperation.AnonymousClass2.invokeSuspend$lambda$1(c00052, obj2);
                                    }
                                });
                                final Function1<Path, Unit> function1 = new Function1<Path, Unit>() { // from class: com.magneticchen.daijishou.service.debug.passive_protocol.client_operations.FileOperation.handleDataStreams.2.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Path path4) {
                                        invoke2(path4);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Path path4) {
                                        List<Path> list = arrayList;
                                        Intrinsics.checkNotNull(path4);
                                        list.add(path4);
                                    }
                                };
                                streamFilter.forEach(new Consumer() { // from class: com.magneticchen.daijishou.service.debug.passive_protocol.client_operations.FileOperation$handleDataStreams$2$$ExternalSyntheticLambda1
                                    @Override // java.util.function.Consumer
                                    public final void accept(Object obj2) {
                                        function1.invoke(obj2);
                                    }
                                });
                                this.$dataOutputStream.writeInt(arrayList.size());
                                DataOutputStream dataOutputStream2 = this.$dataOutputStream;
                                FileOperation fileOperation2 = this.this$0;
                                DataInputStream dataInputStream = this.$dataInputStream;
                                for (Path path4 : arrayList) {
                                    Ref.IntRef intRef = new Ref.IntRef();
                                    invokeSuspend$lambda$4$lambda$3$writeFileToSocket(intRef, fileOperation2, dataOutputStream2, path3, path4, dataInputStream);
                                    if (intRef.element >= FileOperation.Companion.getMAX_RETRIED_COUNT()) {
                                        dataOutputStream2.close();
                                        dataInputStream.close();
                                        return Unit.INSTANCE;
                                    }
                                }
                                dataOutputStream2.write(fileOperation2.getHeaderByteCode());
                                dataOutputStream2.write(FileOperation.Companion.getSUCCEED_RESULT_STATUS_BYTE_CODE());
                                return Unit.INSTANCE;
                            }
                            this.$dataOutputStream.writeInt(1);
                            Ref.IntRef intRef2 = new Ref.IntRef();
                            invokeSuspend$writeFileToSocket$5(intRef2, path3, this.this$0, this.$dataOutputStream, this.$dataInputStream);
                            if (intRef2.element >= FileOperation.Companion.getMAX_RETRIED_COUNT()) {
                                this.$dataOutputStream.close();
                                this.$dataInputStream.close();
                                return null;
                            }
                            this.$dataOutputStream.write(this.this$0.getHeaderByteCode());
                            this.$dataOutputStream.write(FileOperation.Companion.getSUCCEED_RESULT_STATUS_BYTE_CODE());
                            return null;
                        }
                        this.$dataOutputStream.write(this.this$0.getHeaderByteCode());
                        this.$dataOutputStream.write(FileOperation.Companion.getNO_SUCH_FILE_RESULT_STATUS_BYTE_CODE());
                        return Unit.INSTANCE;
                    }
                    this.this$0.getLogger().warn(this.this$0, "Unknown byte code: " + ((int) b));
                    return Unit.INSTANCE;
                } catch (Exception e2) {
                    this.this$0.getLogger().warn(this.this$0, ExceptionsKt.stackTraceToString(e2));
                    this.$dataOutputStream.write(this.this$0.getHeaderByteCode());
                    this.$dataOutputStream.write(FileOperation.Companion.getFAILED_RESULT_STATUS_BYTE_CODE());
                    return Unit.INSTANCE;
                }
            } catch (NoSuchFileException unused) {
                this.$dataOutputStream.write(this.this$0.getHeaderByteCode());
                this.$dataOutputStream.write(FileOperation.Companion.getNO_SUCH_FILE_RESULT_STATUS_BYTE_CODE());
                return Unit.INSTANCE;
            } catch (AccessDeniedException unused2) {
                this.$dataOutputStream.write(this.this$0.getHeaderByteCode());
                this.$dataOutputStream.write(FileOperation.Companion.getACCESS_DENIED_RESULT_STATUS_BYTE_CODE());
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$1(Function1 function1, Object obj) {
            return ((Boolean) function1.invoke(obj)).booleanValue();
        }

        private static final void invokeSuspend$lambda$4$lambda$3$writeFileToSocket(Ref.IntRef intRef, FileOperation fileOperation, DataOutputStream dataOutputStream, Path path, Path path2, DataInputStream dataInputStream) throws NoSuchAlgorithmException, IOException {
            if (intRef.element >= FileOperation.Companion.getMAX_RETRIED_COUNT()) {
                return;
            }
            fileOperation.writeStringToDataOutputStream(dataOutputStream, path.relativize(path2).toString());
            File file = path2.toFile();
            long length = file.length();
            dataOutputStream.writeLong(length);
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            FileInputStream fileInputStream = new FileInputStream(file);
            long length2 = 0;
            while (length2 < length) {
                byte[] bytes = ByteStreamsKt.readBytes(fileInputStream);
                messageDigest.update(bytes);
                dataOutputStream.write(bytes);
                length2 += (long) bytes.length;
            }
            dataOutputStream.write(messageDigest.digest());
            byte b = dataInputStream.readByte();
            byte b2 = dataInputStream.readByte();
            if (b == fileOperation.getHeaderByteCode() && b2 == FileOperation.Companion.getSUCCEED_RESULT_STATUS_BYTE_CODE()) {
                return;
            }
            intRef.element++;
            invokeSuspend$lambda$4$lambda$3$writeFileToSocket(intRef, fileOperation, dataOutputStream, path, path2, dataInputStream);
        }

        private static final void invokeSuspend$writeFileToSocket$5(Ref.IntRef intRef, Path path, FileOperation fileOperation, DataOutputStream dataOutputStream, DataInputStream dataInputStream) throws NoSuchAlgorithmException, IOException {
            if (intRef.element >= FileOperation.Companion.getMAX_RETRIED_COUNT()) {
                return;
            }
            File file = path.toFile();
            String name = file.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            fileOperation.writeStringToDataOutputStream(dataOutputStream, name);
            long length = file.length();
            dataOutputStream.writeLong(length);
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            FileInputStream fileInputStream = new FileInputStream(file);
            long length2 = 0;
            while (length2 < length) {
                byte[] bytes = ByteStreamsKt.readBytes(fileInputStream);
                messageDigest.update(bytes);
                dataOutputStream.write(bytes);
                length2 += (long) bytes.length;
            }
            dataOutputStream.write(messageDigest.digest());
            byte b = dataInputStream.readByte();
            byte b2 = dataInputStream.readByte();
            if (b == fileOperation.getHeaderByteCode() && b2 == FileOperation.Companion.getSUCCEED_RESULT_STATUS_BYTE_CODE()) {
                return;
            }
            intRef.element++;
            invokeSuspend$writeFileToSocket$5(intRef, path, fileOperation, dataOutputStream, dataInputStream);
        }
    }

    @Override // com.magneticchen.daijishou.service.debug.passive_protocol.ClientOperation
    public Object handleDataStreams(DataInputStream dataInputStream, DataOutputStream dataOutputStream, Continuation<? super Unit> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(dataInputStream, this, dataOutputStream, null), continuation);
    }
}
