package org.eclipse.jgit.transport;

import java.io.IOException;
import java.io.Writer;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;

/* JADX INFO: loaded from: classes5.dex */
class FetchHeadRecord {
    ObjectId newValue;
    boolean notForMerge;
    String sourceName;
    URIish sourceURI;

    FetchHeadRecord() {
    }

    void write(Writer writer) throws IOException {
        String strSubstring;
        String str;
        if (this.sourceName.startsWith(Constants.R_HEADS)) {
            strSubstring = this.sourceName.substring(Constants.R_HEADS.length());
            str = ConfigConstants.CONFIG_BRANCH_SECTION;
        } else if (this.sourceName.startsWith(Constants.R_TAGS)) {
            strSubstring = this.sourceName.substring(Constants.R_TAGS.length());
            str = "tag";
        } else if (this.sourceName.startsWith(Constants.R_REMOTES)) {
            strSubstring = this.sourceName.substring(Constants.R_REMOTES.length());
            str = "remote branch";
        } else {
            strSubstring = this.sourceName;
            str = "";
        }
        writer.write(this.newValue.name());
        writer.write(9);
        if (this.notForMerge) {
            writer.write("not-for-merge");
        }
        writer.write(9);
        writer.write(str);
        writer.write(" '");
        writer.write(strSubstring);
        writer.write("' of ");
        writer.write(this.sourceURI.toString());
        writer.write("\n");
    }
}
