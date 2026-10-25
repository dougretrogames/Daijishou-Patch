package net.lingala.zip4j.tasks;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderUtil;
import net.lingala.zip4j.io.inputstream.SplitFileInputStream;
import net.lingala.zip4j.io.inputstream.ZipInputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.UnzipParameters;
import net.lingala.zip4j.model.Zip4jConfig;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.util.FileUtils;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.UnzipUtil;
import net.lingala.zip4j.util.Zip4jUtil;

/* JADX INFO: loaded from: classes5.dex */
public class ExtractFileTask extends AbstractExtractFileTask<ExtractFileTaskParameters> {
    private char[] password;
    private SplitFileInputStream splitInputStream;

    public ExtractFileTask(ZipModel zipModel, char[] cArr, UnzipParameters unzipParameters, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(zipModel, unzipParameters, asyncTaskParameters);
        this.password = cArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code duplicated, block: B:36:0x006b  */
    /* JADX WARN: Code duplicated, block: B:50:? A[SYNTHETIC] */
    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    public void executeTask(ExtractFileTaskParameters extractFileTaskParameters, ProgressMonitor progressMonitor) throws Throwable {
        ExtractFileTask extractFileTask;
        Throwable th;
        SplitFileInputStream splitFileInputStream;
        List<FileHeader> fileHeadersToExtract = getFileHeadersToExtract(extractFileTaskParameters.fileToExtract);
        try {
            try {
                ZipInputStream zipInputStreamCreateZipInputStream = createZipInputStream(extractFileTaskParameters.zip4jConfig);
                try {
                    byte[] bArr = new byte[extractFileTaskParameters.zip4jConfig.getBufferSize()];
                    for (FileHeader fileHeader : fileHeadersToExtract) {
                        this.splitInputStream.prepareExtractionForFileHeader(fileHeader);
                        extractFileTask = this;
                        ProgressMonitor progressMonitor2 = progressMonitor;
                        try {
                            extractFileTask.extractFile(zipInputStreamCreateZipInputStream, fileHeader, extractFileTaskParameters.outputPath, determineNewFileName(extractFileTaskParameters.newFileName, extractFileTaskParameters.fileToExtract, fileHeader), progressMonitor2, bArr);
                            progressMonitor = progressMonitor2;
                        } catch (Throwable th2) {
                            th = th2;
                            Throwable th3 = th;
                            if (zipInputStreamCreateZipInputStream == null) {
                                throw th3;
                            }
                            try {
                                zipInputStreamCreateZipInputStream.close();
                                throw th3;
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                                throw th3;
                            }
                        }
                    }
                    if (zipInputStreamCreateZipInputStream != null) {
                        zipInputStreamCreateZipInputStream.close();
                    }
                    SplitFileInputStream splitFileInputStream2 = this.splitInputStream;
                    if (splitFileInputStream2 != null) {
                        splitFileInputStream2.close();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    extractFileTask = this;
                }
            } catch (Throwable th6) {
                th = th6;
                th = th;
                splitFileInputStream = extractFileTask.splitInputStream;
                if (splitFileInputStream != null) {
                    splitFileInputStream.close();
                    throw th;
                }
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            extractFileTask = this;
            th = th;
            splitFileInputStream = extractFileTask.splitInputStream;
            if (splitFileInputStream != null) {
                splitFileInputStream.close();
                throw th;
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    public long calculateTotalWork(ExtractFileTaskParameters extractFileTaskParameters) throws ZipException {
        return HeaderUtil.getTotalUncompressedSizeOfAllFileHeaders(getFileHeadersToExtract(extractFileTaskParameters.fileToExtract));
    }

    private List<FileHeader> getFileHeadersToExtract(String str) throws ZipException {
        if (!FileUtils.isZipEntryDirectory(str)) {
            FileHeader fileHeader = HeaderUtil.getFileHeader(getZipModel(), str);
            if (fileHeader == null) {
                throw new ZipException("No file found with name " + str + " in zip file", ZipException.Type.FILE_NOT_FOUND);
            }
            return Collections.singletonList(fileHeader);
        }
        return HeaderUtil.getFileHeadersUnderDirectory(getZipModel().getCentralDirectory().getFileHeaders(), str);
    }

    private ZipInputStream createZipInputStream(Zip4jConfig zip4jConfig) throws IOException {
        this.splitInputStream = UnzipUtil.createSplitInputStream(getZipModel());
        return new ZipInputStream(this.splitInputStream, this.password, zip4jConfig);
    }

    private String determineNewFileName(String str, String str2, FileHeader fileHeader) {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str) || !FileUtils.isZipEntryDirectory(str2)) {
            return str;
        }
        String str3 = InternalZipConstants.ZIP_FILE_SEPARATOR;
        if (str.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            str3 = "";
        }
        return fileHeader.getFileName().replaceFirst(str2, str + str3);
    }

    public static class ExtractFileTaskParameters extends AbstractZipTaskParameters {
        private String fileToExtract;
        private String newFileName;
        private String outputPath;

        public ExtractFileTaskParameters(String str, String str2, String str3, Zip4jConfig zip4jConfig) {
            super(zip4jConfig);
            this.outputPath = str;
            this.fileToExtract = str2;
            this.newFileName = str3;
        }
    }
}
