package net.lingala.zip4j.tasks;

import java.io.IOException;
import net.lingala.zip4j.headers.HeaderUtil;
import net.lingala.zip4j.io.inputstream.SplitFileInputStream;
import net.lingala.zip4j.io.inputstream.ZipInputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.UnzipParameters;
import net.lingala.zip4j.model.Zip4jConfig;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.util.UnzipUtil;

/* INFO: loaded from: classes5.dex */
public class ExtractAllFilesTask extends AbstractExtractFileTask<ExtractAllFilesTaskParameters> {
    private final char[] password;
    private SplitFileInputStream splitInputStream;

    public ExtractAllFilesTask(ZipModel zipModel, char[] cArr, UnzipParameters unzipParameters, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(zipModel, unzipParameters, asyncTaskParameters);
        this.password = cArr;
    }

    /* INFO: Access modifiers changed from: protected */
    /* WARN: Code duplicated, block: B:41:0x007f  */
    /* WARN: Code duplicated, block: B:43:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* WARN: Code duplicated, block: B:59:? A[Catch: all -> 0x0076, SYNTHETIC, TRY_LEAVE, TryCatch #1 {all -> 0x0076, blocks: (B:34:0x0075, B:33:0x0072, B:20:0x005c, B:29:0x006c), top: B:45:0x0000, inners: #0 }] */
    /* WARN: Code duplicated, block: B:61:? A[SYNTHETIC] */
    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    public void executeTask(ExtractAllFilesTaskParameters extractAllFilesTaskParameters, ProgressMonitor progressMonitor) throws Throwable {
        ExtractAllFilesTask extractAllFilesTask;
        Throwable th;
        SplitFileInputStream splitFileInputStream;
        Throwable th2;
        try {
            try {
                ZipInputStream zipInputStreamPrepareZipInputStream = prepareZipInputStream(extractAllFilesTaskParameters.zip4jConfig);
                try {
                    for (FileHeader fileHeader : getZipModel().getCentralDirectory().getFileHeaders()) {
                        if (fileHeader.getFileName().startsWith("__MACOSX")) {
                            try {
                                progressMonitor.updateWorkCompleted(fileHeader.getUncompressedSize());
                            } catch (Throwable th3) {
                                th2 = th3;
                                extractAllFilesTask = this;
                                if (zipInputStreamPrepareZipInputStream != null) {
                                    throw th2;
                                }
                                try {
                                    zipInputStreamPrepareZipInputStream.close();
                                    throw th2;
                                } catch (Throwable th4) {
                                    th2.addSuppressed(th4);
                                    throw th2;
                                }
                            }
                        } else {
                            this.splitInputStream.prepareExtractionForFileHeader(fileHeader);
                            extractAllFilesTask = this;
                            ProgressMonitor progressMonitor2 = progressMonitor;
                            try {
                                extractAllFilesTask.extractFile(zipInputStreamPrepareZipInputStream, fileHeader, extractAllFilesTaskParameters.outputPath, null, progressMonitor2, new byte[extractAllFilesTaskParameters.zip4jConfig.getBufferSize()]);
                                verifyIfTaskIsCancelled();
                                progressMonitor = progressMonitor2;
                            } catch (Throwable th5) {
                                th = th5;
                                th2 = th;
                                if (zipInputStreamPrepareZipInputStream != null) {
                                    throw th2;
                                }
                                zipInputStreamPrepareZipInputStream.close();
                                throw th2;
                            }
                        }
                    }
                    if (zipInputStreamPrepareZipInputStream != null) {
                        zipInputStreamPrepareZipInputStream.close();
                    }
                    SplitFileInputStream splitFileInputStream2 = this.splitInputStream;
                    if (splitFileInputStream2 != null) {
                        splitFileInputStream2.close();
                    }
                } catch (Throwable th6) {
                    th = th6;
                    extractAllFilesTask = this;
                }
            } catch (Throwable th7) {
                th = th7;
                th = th;
                splitFileInputStream = extractAllFilesTask.splitInputStream;
                if (splitFileInputStream != null) {
                    splitFileInputStream.close();
                    throw th;
                }
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
            extractAllFilesTask = this;
            th = th;
            splitFileInputStream = extractAllFilesTask.splitInputStream;
            if (splitFileInputStream != null) {
                splitFileInputStream.close();
                throw th;
            }
            throw th;
        }
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    public long calculateTotalWork(ExtractAllFilesTaskParameters extractAllFilesTaskParameters) {
        return HeaderUtil.getTotalUncompressedSizeOfAllFileHeaders(getZipModel().getCentralDirectory().getFileHeaders());
    }

    private ZipInputStream prepareZipInputStream(Zip4jConfig zip4jConfig) throws IOException {
        this.splitInputStream = UnzipUtil.createSplitInputStream(getZipModel());
        FileHeader firstFileHeader = getFirstFileHeader(getZipModel());
        if (firstFileHeader != null) {
            this.splitInputStream.prepareExtractionForFileHeader(firstFileHeader);
        }
        return new ZipInputStream(this.splitInputStream, this.password, zip4jConfig);
    }

    private FileHeader getFirstFileHeader(ZipModel zipModel) {
        if (zipModel.getCentralDirectory() == null || zipModel.getCentralDirectory().getFileHeaders() == null || zipModel.getCentralDirectory().getFileHeaders().size() == 0) {
            return null;
        }
        return zipModel.getCentralDirectory().getFileHeaders().get(0);
    }

    public static class ExtractAllFilesTaskParameters extends AbstractZipTaskParameters {
        private final String outputPath;

        public ExtractAllFilesTaskParameters(String str, Zip4jConfig zip4jConfig) {
            super(zip4jConfig);
            this.outputPath = str;
        }
    }
}
