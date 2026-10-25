package org.apache.commons.io.file;

import java.util.stream.Stream;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes5.dex */
public enum StandardDeleteOption implements DeleteOption {
    OVERRIDE_READ_ONLY;

    public static boolean overrideReadOnly(DeleteOption[] deleteOptionArr) {
        if (IOUtils.length(deleteOptionArr) == 0) {
            return false;
        }
        return Stream.of((Object[]) deleteOptionArr).anyMatch(new StandardDeleteOption$$ExternalSyntheticLambda0());
    }

    static /* synthetic */ boolean lambda$overrideReadOnly$0(DeleteOption deleteOption) {
        return OVERRIDE_READ_ONLY == deleteOption;
    }
}
