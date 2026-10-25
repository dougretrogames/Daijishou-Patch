package org.eclipse.jgit.merge;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;
import org.eclipse.jgit.diff.RawText;

/* JADX INFO: loaded from: classes5.dex */
class MergeFormatterPass {
    private final Charset charset;
    private String lastConflictingName;
    private final EolAwareOutputStream out;
    private final MergeResult<RawText> res;
    private final List<String> seqName;
    private final boolean threeWayMerge;
    private final boolean writeBase;

    MergeFormatterPass(OutputStream outputStream, MergeResult<RawText> mergeResult, List<String> list, Charset charset) {
        this(outputStream, mergeResult, list, charset, false);
    }

    MergeFormatterPass(OutputStream outputStream, MergeResult<RawText> mergeResult, List<String> list, Charset charset, boolean z) {
        this.out = new EolAwareOutputStream(outputStream);
        this.res = mergeResult;
        this.seqName = list;
        this.charset = charset;
        this.threeWayMerge = mergeResult.getSequences().size() == 3;
        this.writeBase = z;
    }

    void formatMerge() throws IOException {
        boolean zIsMissingNewlineAtEnd = false;
        for (MergeChunk mergeChunk : this.res) {
            if (!isBase(mergeChunk) || this.writeBase) {
                RawText rawText = (RawText) this.res.getSequences().get(mergeChunk.getSequenceIndex());
                writeConflictMetadata(mergeChunk);
                for (int begin = mergeChunk.getBegin(); begin < mergeChunk.getEnd(); begin++) {
                    writeLine(rawText, begin);
                }
                zIsMissingNewlineAtEnd = rawText.isMissingNewlineAtEnd();
            }
        }
        if (this.lastConflictingName != null) {
            writeConflictEnd();
        }
        if (zIsMissingNewlineAtEnd) {
            return;
        }
        this.out.beginln();
    }

    private void writeConflictMetadata(MergeChunk mergeChunk) throws IOException {
        if (this.lastConflictingName != null && !isTheirs(mergeChunk) && !isBase(mergeChunk)) {
            writeConflictEnd();
        }
        if (isOurs(mergeChunk)) {
            writeConflictStart(mergeChunk);
        } else if (isTheirs(mergeChunk)) {
            writeConflictChange(mergeChunk);
        } else if (isBase(mergeChunk)) {
            writeConflictBase(mergeChunk);
        }
    }

    private void writeConflictEnd() throws IOException {
        writeln(">>>>>>> " + this.lastConflictingName);
        this.lastConflictingName = null;
    }

    private void writeConflictStart(MergeChunk mergeChunk) throws IOException {
        String str = this.seqName.get(mergeChunk.getSequenceIndex());
        this.lastConflictingName = str;
        writeln("<<<<<<< " + str);
    }

    private void writeConflictChange(MergeChunk mergeChunk) throws IOException {
        String str = this.seqName.get(mergeChunk.getSequenceIndex());
        this.lastConflictingName = str;
        writeln(this.threeWayMerge ? "=======" : "======= " + str);
    }

    private void writeConflictBase(MergeChunk mergeChunk) throws IOException {
        String str = this.seqName.get(mergeChunk.getSequenceIndex());
        this.lastConflictingName = str;
        writeln("||||||| " + str);
    }

    private void writeln(String str) throws IOException {
        this.out.beginln();
        this.out.write((str + "\n").getBytes(this.charset));
    }

    private void writeLine(RawText rawText, int i) throws IOException {
        this.out.beginln();
        rawText.writeLine(this.out, i);
        if (this.out.isBeginln()) {
            this.out.write(10);
        }
    }

    private boolean isBase(MergeChunk mergeChunk) {
        return mergeChunk.getConflictState() == MergeChunk.ConflictState.BASE_CONFLICTING_RANGE;
    }

    private boolean isOurs(MergeChunk mergeChunk) {
        return mergeChunk.getConflictState() == MergeChunk.ConflictState.FIRST_CONFLICTING_RANGE;
    }

    private boolean isTheirs(MergeChunk mergeChunk) {
        return mergeChunk.getConflictState() == MergeChunk.ConflictState.NEXT_CONFLICTING_RANGE;
    }
}
