package org.eclipse.jgit.merge;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jgit.diff.RawText;

/* INFO: loaded from: classes5.dex */
public class MergeFormatter {
    public void formatMerge(OutputStream outputStream, MergeResult<RawText> mergeResult, List<String> list, Charset charset) throws IOException {
        new MergeFormatterPass(outputStream, mergeResult, list, charset).formatMerge();
    }

    public void formatMergeDiff3(OutputStream outputStream, MergeResult<RawText> mergeResult, List<String> list, Charset charset) throws IOException {
        new MergeFormatterPass(outputStream, mergeResult, list, charset, true).formatMerge();
    }

    public void formatMerge(OutputStream outputStream, MergeResult mergeResult, String str, String str2, String str3, Charset charset) throws IOException {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        arrayList.add(str2);
        arrayList.add(str3);
        formatMerge(outputStream, mergeResult, arrayList, charset);
    }

    public void formatMergeDiff3(OutputStream outputStream, MergeResult mergeResult, String str, String str2, String str3, Charset charset) throws IOException {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        arrayList.add(str2);
        arrayList.add(str3);
        formatMergeDiff3(outputStream, mergeResult, arrayList, charset);
    }
}
