package org.eclipse.jgit.internal.storage.commitgraph;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import org.eclipse.jgit.errors.ConfigInvalidException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.util.IO;
import org.eclipse.jgit.util.NB;
import org.eclipse.jgit.util.SystemReader;
import org.eclipse.jgit.util.io.SilentFileInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class CommitGraphLoader {
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) CommitGraphLoader.class);

    public static CommitGraph open(File file) throws IOException {
        Throwable th = null;
        try {
            SilentFileInputStream silentFileInputStream = new SilentFileInputStream(file);
            try {
                try {
                    CommitGraph commitGraph = read(silentFileInputStream);
                    silentFileInputStream.close();
                    return commitGraph;
                } catch (CommitGraphFormatException e) {
                    throw e;
                } catch (IOException e2) {
                    throw new IOException(MessageFormat.format(JGitText.get().unreadableCommitGraph, file.getAbsolutePath()), e2);
                }
            } catch (Throwable th2) {
                silentFileInputStream.close();
                throw th2;
            }
        } catch (Throwable th3) {
            if (0 == 0) {
                throw th3;
            }
            if (null != th3) {
                th.addSuppressed(th3);
            }
            throw null;
        }
    }

    public static CommitGraph read(InputStream inputStream) throws IOException {
        boolean z = false;
        try {
            z = SystemReader.getInstance().getJGitConfig().getBoolean("commitGraph", ConfigConstants.CONFIG_KEY_READ_CHANGED_PATHS, false);
        } catch (ConfigInvalidException unused) {
        }
        return read(inputStream, z);
    }

    public static CommitGraph read(InputStream inputStream, boolean z) throws IOException {
        byte[] bArr = new byte[8];
        IO.readFully(inputStream, bArr, 0, 8);
        if (NB.decodeInt32(bArr, 0) != 1128747080) {
            throw new CommitGraphFormatException(JGitText.get().notACommitGraph);
        }
        if (bArr[5] != 1) {
            throw new CommitGraphFormatException(JGitText.get().incorrectOBJECT_ID_LENGTH);
        }
        byte b = bArr[4];
        if (b != 1) {
            throw new CommitGraphFormatException(MessageFormat.format(JGitText.get().unsupportedCommitGraphVersion, Integer.valueOf(b)));
        }
        int i = bArr[6];
        int i2 = i + 1;
        int i3 = i2 * 12;
        byte[] bArr2 = new byte[i3];
        IO.readFully(inputStream, bArr2, 0, i3);
        ArrayList arrayList = new ArrayList(i2);
        for (int i4 = 0; i4 <= i; i4++) {
            int i5 = i4 * 12;
            arrayList.add(new ChunkSegment(NB.decodeInt32(bArr2, i5), NB.decodeInt64(bArr2, i5 + 4), null));
        }
        CommitGraphBuilder commitGraphBuilderBuilder = CommitGraphBuilder.builder();
        int i6 = 0;
        while (i6 < i) {
            long j = ((ChunkSegment) arrayList.get(i6)).offset;
            int i7 = ((ChunkSegment) arrayList.get(i6)).f116id;
            i6++;
            long j2 = ((ChunkSegment) arrayList.get(i6)).offset - j;
            if (j2 > 2147483639) {
                throw new CommitGraphFormatException(JGitText.get().commitGraphFileIsTooLargeForJgit);
            }
            int i8 = (int) j2;
            byte[] bArr3 = new byte[i8];
            IO.readFully(inputStream, bArr3, 0, i8);
            switch (i7) {
                case 1111769428:
                    if (z) {
                        commitGraphBuilderBuilder.addBloomFilterData(bArr3);
                    }
                    break;
                case 1112097880:
                    if (z) {
                        commitGraphBuilderBuilder.addBloomFilterIndex(bArr3);
                    }
                    break;
                case 1128546644:
                    commitGraphBuilderBuilder.addCommitData(bArr3);
                    break;
                case 1162102597:
                    commitGraphBuilderBuilder.addExtraList(bArr3);
                    break;
                case 1330201670:
                    commitGraphBuilderBuilder.addOidFanout(bArr3);
                    break;
                case 1330201676:
                    commitGraphBuilderBuilder.addOidLookUp(bArr3);
                    break;
                default:
                    LOG.warn(MessageFormat.format(JGitText.get().commitGraphChunkUnknown, Integer.toHexString(i7)));
                    break;
            }
        }
        return commitGraphBuilderBuilder.build();
    }

    private static class ChunkSegment {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        final int f116id;
        final long offset;

        /* synthetic */ ChunkSegment(int i, long j, CommitGraphLoaderIA commitGraphLoaderIA) {
            this(i, j);
        }

        private ChunkSegment(int i, long j) {
            this.f116id = i;
            this.offset = j;
        }
    }
}
