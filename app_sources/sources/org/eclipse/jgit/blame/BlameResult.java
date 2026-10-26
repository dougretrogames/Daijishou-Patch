package org.eclipse.jgit.blame;

import java.io.IOException;
import org.eclipse.jgit.diff.RawText;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.revwalk.RevCommit;

/* INFO: loaded from: classes5.dex */
public class BlameResult {
    private BlameGenerator generator;
    private int lastLength;
    private RawText resultContents;
    private final String resultPath;
    private final PersonIdent[] sourceAuthors;
    private final RevCommit[] sourceCommits;
    private final PersonIdent[] sourceCommitters;
    private final int[] sourceLines;
    private final String[] sourcePaths;

    public static BlameResult create(BlameGenerator blameGenerator) throws IOException {
        String resultPath = blameGenerator.getResultPath();
        RawText resultContents = blameGenerator.getResultContents();
        if (resultContents == null) {
            blameGenerator.close();
            return null;
        }
        return new BlameResult(blameGenerator, resultPath, resultContents);
    }

    BlameResult(BlameGenerator blameGenerator, String str, RawText rawText) {
        this.generator = blameGenerator;
        this.resultPath = str;
        this.resultContents = rawText;
        int size = rawText.size();
        this.sourceCommits = new RevCommit[size];
        this.sourceAuthors = new PersonIdent[size];
        this.sourceCommitters = new PersonIdent[size];
        this.sourceLines = new int[size];
        this.sourcePaths = new String[size];
    }

    public String getResultPath() {
        return this.resultPath;
    }

    public RawText getResultContents() {
        return this.resultContents;
    }

    public void discardResultContents() {
        this.resultContents = null;
    }

    public boolean hasSourceData(int i) {
        return this.sourceLines[i] != 0;
    }

    public boolean hasSourceData(int i, int i2) {
        while (i < i2) {
            if (this.sourceLines[i] == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    public RevCommit getSourceCommit(int i) {
        return this.sourceCommits[i];
    }

    public PersonIdent getSourceAuthor(int i) {
        return this.sourceAuthors[i];
    }

    public PersonIdent getSourceCommitter(int i) {
        return this.sourceCommitters[i];
    }

    public String getSourcePath(int i) {
        return this.sourcePaths[i];
    }

    public int getSourceLine(int i) {
        return this.sourceLines[i] - 1;
    }

    public void computeAll() throws IOException {
        BlameGenerator blameGenerator = this.generator;
        if (blameGenerator == null) {
            return;
        }
        while (blameGenerator.next()) {
            try {
                loadFrom(blameGenerator);
            } catch (Throwable th) {
                blameGenerator.close();
                this.generator = null;
                throw th;
            }
        }
        blameGenerator.close();
        this.generator = null;
    }

    public int computeNext() throws IOException {
        BlameGenerator blameGenerator = this.generator;
        if (blameGenerator == null) {
            return -1;
        }
        if (blameGenerator.next()) {
            loadFrom(blameGenerator);
            this.lastLength = blameGenerator.getRegionLength();
            return blameGenerator.getResultStart();
        }
        blameGenerator.close();
        this.generator = null;
        return -1;
    }

    public int lastLength() {
        return this.lastLength;
    }

    public void computeRange(int i, int i2) throws IOException {
        BlameGenerator blameGenerator = this.generator;
        if (blameGenerator == null) {
            return;
        }
        if (i == 0 && i2 == this.resultContents.size()) {
            computeAll();
            return;
        }
        while (i < i2 && !hasSourceData(i, i2)) {
            if (!blameGenerator.next()) {
                blameGenerator.close();
                this.generator = null;
                return;
            }
            loadFrom(blameGenerator);
            int resultStart = blameGenerator.getResultStart();
            int resultEnd = blameGenerator.getResultEnd();
            if (resultStart <= i && i < resultEnd) {
                i = resultEnd;
            }
            if (resultStart <= i2 && i2 < resultEnd) {
                i2 = resultStart;
            }
        }
    }

    public String toString() {
        return "BlameResult: " + getResultPath();
    }

    private void loadFrom(BlameGenerator blameGenerator) {
        RevCommit sourceCommit = blameGenerator.getSourceCommit();
        PersonIdent sourceAuthor = blameGenerator.getSourceAuthor();
        PersonIdent sourceCommitter = blameGenerator.getSourceCommitter();
        String sourcePath = blameGenerator.getSourcePath();
        int sourceStart = blameGenerator.getSourceStart();
        int resultEnd = blameGenerator.getResultEnd();
        for (int resultStart = blameGenerator.getResultStart(); resultStart < resultEnd; resultStart++) {
            int[] iArr = this.sourceLines;
            if (iArr[resultStart] == 0) {
                this.sourceCommits[resultStart] = sourceCommit;
                this.sourceAuthors[resultStart] = sourceAuthor;
                this.sourceCommitters[resultStart] = sourceCommitter;
                this.sourcePaths[resultStart] = sourcePath;
                sourceStart++;
                iArr[resultStart] = sourceStart;
            }
        }
    }
}
