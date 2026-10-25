package org.eclipse.jgit.util.io;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.EnumSet;
import org.eclipse.jgit.attributes.Attributes;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.CoreConfig;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.WorkingTreeOptions;
import org.eclipse.jgit.util.SystemReader;

/* JADX INFO: loaded from: classes5.dex */
public final class EolStreamTypeUtil {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$CoreConfig$AutoCRLF;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$CoreConfig$EOL;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$CoreConfig$EolStreamType;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$treewalk$TreeWalk$OperationType;

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$CoreConfig$AutoCRLF() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$lib$CoreConfig$AutoCRLF;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[CoreConfig.AutoCRLF.valuesCustom().length];
        try {
            iArr2[CoreConfig.AutoCRLF.FALSE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[CoreConfig.AutoCRLF.INPUT.ordinal()] = 3;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[CoreConfig.AutoCRLF.TRUE.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$lib$CoreConfig$AutoCRLF = iArr2;
        return iArr2;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$CoreConfig$EOL() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$lib$CoreConfig$EOL;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[CoreConfig.EOL.valuesCustom().length];
        try {
            iArr2[CoreConfig.EOL.CRLF.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[CoreConfig.EOL.LF.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[CoreConfig.EOL.NATIVE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$lib$CoreConfig$EOL = iArr2;
        return iArr2;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$CoreConfig$EolStreamType() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$lib$CoreConfig$EolStreamType;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[CoreConfig.EolStreamType.valuesCustom().length];
        try {
            iArr2[CoreConfig.EolStreamType.AUTO_CRLF.ordinal()] = 3;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[CoreConfig.EolStreamType.AUTO_LF.ordinal()] = 4;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[CoreConfig.EolStreamType.DIRECT.ordinal()] = 5;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[CoreConfig.EolStreamType.TEXT_CRLF.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[CoreConfig.EolStreamType.TEXT_LF.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$lib$CoreConfig$EolStreamType = iArr2;
        return iArr2;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$treewalk$TreeWalk$OperationType() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$treewalk$TreeWalk$OperationType;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[TreeWalk.OperationType.valuesCustom().length];
        try {
            iArr2[TreeWalk.OperationType.CHECKIN_OP.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[TreeWalk.OperationType.CHECKOUT_OP.ordinal()] = 1;
        } catch (NoSuchFieldError unused2) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$treewalk$TreeWalk$OperationType = iArr2;
        return iArr2;
    }

    private EolStreamTypeUtil() {
    }

    public static CoreConfig.EolStreamType detectStreamType(TreeWalk.OperationType operationType, WorkingTreeOptions workingTreeOptions, Attributes attributes) {
        int i = $SWITCH_TABLE$org$eclipse$jgit$treewalk$TreeWalk$OperationType()[operationType.ordinal()];
        if (i == 1) {
            return checkOutStreamType(workingTreeOptions, attributes);
        }
        if (i == 2) {
            return checkInStreamType(workingTreeOptions, attributes);
        }
        throw new IllegalArgumentException("unknown OperationType " + String.valueOf(operationType));
    }

    public static InputStream wrapInputStream(InputStream inputStream, CoreConfig.EolStreamType eolStreamType) {
        return wrapInputStream(inputStream, eolStreamType, false);
    }

    public static InputStream wrapInputStream(InputStream inputStream, CoreConfig.EolStreamType eolStreamType, boolean z) {
        EnumSet enumSetOf;
        int i = $SWITCH_TABLE$org$eclipse$jgit$lib$CoreConfig$EolStreamType()[eolStreamType.ordinal()];
        if (i == 1) {
            return new AutoCRLFInputStream(inputStream, false);
        }
        if (i == 2) {
            return AutoLFInputStream.create(inputStream, new AutoLFInputStream.StreamFlag[0]);
        }
        if (i == 3) {
            return new AutoCRLFInputStream(inputStream, true);
        }
        if (i != 4) {
            return inputStream;
        }
        if (z) {
            enumSetOf = EnumSet.of(AutoLFInputStream.StreamFlag.DETECT_BINARY, AutoLFInputStream.StreamFlag.FOR_CHECKOUT);
        } else {
            enumSetOf = EnumSet.of(AutoLFInputStream.StreamFlag.DETECT_BINARY);
        }
        return new AutoLFInputStream(inputStream, enumSetOf);
    }

    public static OutputStream wrapOutputStream(OutputStream outputStream, CoreConfig.EolStreamType eolStreamType) {
        int i = $SWITCH_TABLE$org$eclipse$jgit$lib$CoreConfig$EolStreamType()[eolStreamType.ordinal()];
        if (i == 1) {
            return new AutoCRLFOutputStream(outputStream, false);
        }
        if (i == 2) {
            return new AutoLFOutputStream(outputStream, false);
        }
        if (i != 3) {
            return i != 4 ? outputStream : new AutoLFOutputStream(outputStream, true);
        }
        return new AutoCRLFOutputStream(outputStream, true);
    }

    private static CoreConfig.EolStreamType checkInStreamType(WorkingTreeOptions workingTreeOptions, Attributes attributes) {
        if (attributes.isUnset("text")) {
            return CoreConfig.EolStreamType.DIRECT;
        }
        if (attributes.isSet("crlf")) {
            return CoreConfig.EolStreamType.TEXT_LF;
        }
        if (attributes.isUnset("crlf")) {
            return CoreConfig.EolStreamType.DIRECT;
        }
        if ("input".equals(attributes.getValue("crlf"))) {
            return CoreConfig.EolStreamType.TEXT_LF;
        }
        if ("auto".equals(attributes.getValue("text"))) {
            return CoreConfig.EolStreamType.AUTO_LF;
        }
        if (attributes.getValue(ConfigConstants.CONFIG_KEY_EOL) != null) {
            return CoreConfig.EolStreamType.TEXT_LF;
        }
        if (attributes.isSet("text")) {
            return CoreConfig.EolStreamType.TEXT_LF;
        }
        int i = $SWITCH_TABLE$org$eclipse$jgit$lib$CoreConfig$AutoCRLF()[workingTreeOptions.getAutoCRLF().ordinal()];
        if (i == 1) {
            return CoreConfig.EolStreamType.DIRECT;
        }
        if (i == 2 || i == 3) {
            return CoreConfig.EolStreamType.AUTO_LF;
        }
        return CoreConfig.EolStreamType.DIRECT;
    }

    private static CoreConfig.EolStreamType getOutputFormat(WorkingTreeOptions workingTreeOptions) {
        int i = $SWITCH_TABLE$org$eclipse$jgit$lib$CoreConfig$AutoCRLF()[workingTreeOptions.getAutoCRLF().ordinal()];
        if (i == 2) {
            return CoreConfig.EolStreamType.TEXT_CRLF;
        }
        if (i == 3) {
            return CoreConfig.EolStreamType.DIRECT;
        }
        int i2 = $SWITCH_TABLE$org$eclipse$jgit$lib$CoreConfig$EOL()[workingTreeOptions.getEOL().ordinal()];
        if (i2 == 1) {
            return CoreConfig.EolStreamType.TEXT_CRLF;
        }
        if (i2 == 3) {
            if (SystemReader.getInstance().isWindows()) {
                return CoreConfig.EolStreamType.TEXT_CRLF;
            }
            return CoreConfig.EolStreamType.TEXT_LF;
        }
        return CoreConfig.EolStreamType.DIRECT;
    }

    private static CoreConfig.EolStreamType checkOutStreamType(WorkingTreeOptions workingTreeOptions, Attributes attributes) {
        if (attributes.isUnset("text")) {
            return CoreConfig.EolStreamType.DIRECT;
        }
        if (attributes.isSet("crlf")) {
            return getOutputFormat(workingTreeOptions);
        }
        if (attributes.isUnset("crlf")) {
            return CoreConfig.EolStreamType.DIRECT;
        }
        if ("input".equals(attributes.getValue("crlf"))) {
            return CoreConfig.EolStreamType.DIRECT;
        }
        String value = attributes.getValue(ConfigConstants.CONFIG_KEY_EOL);
        if (value != null) {
            if ("crlf".equals(value)) {
                if ("auto".equals(attributes.getValue("text"))) {
                    return CoreConfig.EolStreamType.AUTO_CRLF;
                }
                return CoreConfig.EolStreamType.TEXT_CRLF;
            }
            if ("lf".equals(value)) {
                return CoreConfig.EolStreamType.DIRECT;
            }
        }
        if (!attributes.isSet("text")) {
            if ("auto".equals(attributes.getValue("text"))) {
                CoreConfig.EolStreamType outputFormat = getOutputFormat(workingTreeOptions);
                int i = $SWITCH_TABLE$org$eclipse$jgit$lib$CoreConfig$EolStreamType()[outputFormat.ordinal()];
                if (i != 1) {
                    return i != 2 ? outputFormat : CoreConfig.EolStreamType.AUTO_LF;
                }
                return CoreConfig.EolStreamType.AUTO_CRLF;
            }
            if ($SWITCH_TABLE$org$eclipse$jgit$lib$CoreConfig$AutoCRLF()[workingTreeOptions.getAutoCRLF().ordinal()] == 2) {
                return CoreConfig.EolStreamType.AUTO_CRLF;
            }
            return CoreConfig.EolStreamType.DIRECT;
        }
        return getOutputFormat(workingTreeOptions);
    }
}
