package org.eclipse.jgit.transport;

import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.internal.storage.file.LazyObjectIdSetFile;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.ObjectChecker;
import org.eclipse.jgit.lib.ObjectIdSet;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.util.StringUtils;
import org.eclipse.jgit.util.SystemReader;

/* JADX INFO: loaded from: classes5.dex */
public class TransferConfig {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$TransferConfig$FsckMode = null;
    private static final String FSCK = "fsck";
    public static final Config.SectionParser<TransferConfig> KEY = new TransferConfig$$ExternalSyntheticLambda0();
    private final boolean advertiseObjectInfo;
    private final boolean advertiseSidebandAll;
    private final boolean advertiseWaitForDone;
    private final boolean allowAnySha1InWant;
    private final boolean allowFilter;
    private final boolean allowInvalidPersonIdent;
    private final boolean allowReachableSha1InWant;
    private final boolean allowReceiveClientSID;
    private final boolean allowRefInWant;
    private final boolean allowSidebandAll;
    private final boolean allowTipSha1InWant;
    private final boolean fetchFsck;
    private final String fsckSkipList;
    final String[] hideRefs;
    private final EnumSet<ObjectChecker.ErrorType> ignore;

    @Nullable
    final ProtocolVersion protocolVersion;
    private final boolean receiveFsck;
    private final boolean safeForMacOS;
    private final boolean safeForWindows;

    public enum FsckMode {
        ERROR,
        WARN,
        IGNORE;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static FsckMode[] valuesCustom() {
            FsckMode[] fsckModeArrValuesCustom = values();
            int length = fsckModeArrValuesCustom.length;
            FsckMode[] fsckModeArr = new FsckMode[length];
            System.arraycopy(fsckModeArrValuesCustom, 0, fsckModeArr, 0, length);
            return fsckModeArr;
        }
    }

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$TransferConfig$FsckMode() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$transport$TransferConfig$FsckMode;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[FsckMode.valuesCustom().length];
        try {
            iArr2[FsckMode.ERROR.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[FsckMode.IGNORE.ordinal()] = 3;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[FsckMode.WARN.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$transport$TransferConfig$FsckMode = iArr2;
        return iArr2;
    }

    public enum ProtocolVersion {
        V0("0"),
        V2(ExifInterface.GPS_MEASUREMENT_2D);

        final String name;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static ProtocolVersion[] valuesCustom() {
            ProtocolVersion[] protocolVersionArrValuesCustom = values();
            int length = protocolVersionArrValuesCustom.length;
            ProtocolVersion[] protocolVersionArr = new ProtocolVersion[length];
            System.arraycopy(protocolVersionArrValuesCustom, 0, protocolVersionArr, 0, length);
            return protocolVersionArr;
        }

        ProtocolVersion(String str) {
            this.name = str;
        }

        public String version() {
            return this.name;
        }

        @Nullable
        static ProtocolVersion parse(@Nullable String str) {
            if (str == null) {
                return null;
            }
            for (ProtocolVersion protocolVersion : valuesCustom()) {
                if (protocolVersion.name.equals(str)) {
                    return protocolVersion;
                }
            }
            if ("1".equals(str)) {
                return V0;
            }
            return null;
        }
    }

    public TransferConfig(Repository repository) {
        this(repository.getConfig());
    }

    public TransferConfig(Config config) {
        ObjectChecker.ErrorType errorType;
        boolean z = config.getBoolean("transfer", "fsckobjects", false);
        this.fetchFsck = config.getBoolean("fetch", "fsckobjects", z);
        this.receiveFsck = config.getBoolean(ConfigConstants.CONFIG_RECEIVE_SECTION, "fsckobjects", z);
        this.fsckSkipList = config.getString(FSCK, null, "skipList");
        this.allowInvalidPersonIdent = config.getBoolean(FSCK, "allowInvalidPersonIdent", false);
        this.safeForWindows = config.getBoolean(FSCK, "safeForWindows", SystemReader.getInstance().isWindows());
        this.safeForMacOS = config.getBoolean(FSCK, "safeForMacOS", SystemReader.getInstance().isMacOS());
        this.ignore = EnumSet.noneOf(ObjectChecker.ErrorType.class);
        EnumSet enumSetNoneOf = EnumSet.noneOf(ObjectChecker.ErrorType.class);
        for (String str : config.getNames(FSCK)) {
            if (!StringUtils.equalsIgnoreCase(str, "skipList") && !StringUtils.equalsIgnoreCase(str, "allowLeadingZeroFileMode") && !StringUtils.equalsIgnoreCase(str, "allowInvalidPersonIdent") && !StringUtils.equalsIgnoreCase(str, "safeForWindows") && !StringUtils.equalsIgnoreCase(str, "safeForMacOS") && (errorType = FsckKeyNameHolder.parse(str)) != null) {
                int i = $SWITCH_TABLE$org$eclipse$jgit$transport$TransferConfig$FsckMode()[((FsckMode) config.getEnum(FSCK, null, str, FsckMode.ERROR)).ordinal()];
                if (i == 1) {
                    this.ignore.remove(errorType);
                } else if (i == 2 || i == 3) {
                    this.ignore.add(errorType);
                }
                enumSetNoneOf.add(errorType);
            }
        }
        if (!enumSetNoneOf.contains(ObjectChecker.ErrorType.ZERO_PADDED_FILEMODE) && config.getBoolean(FSCK, "allowLeadingZeroFileMode", false)) {
            this.ignore.add(ObjectChecker.ErrorType.ZERO_PADDED_FILEMODE);
        }
        this.allowRefInWant = config.getBoolean("uploadpack", "allowrefinwant", false);
        this.allowTipSha1InWant = config.getBoolean("uploadpack", "allowtipsha1inwant", false);
        this.allowReachableSha1InWant = config.getBoolean("uploadpack", "allowreachablesha1inwant", false);
        this.allowAnySha1InWant = config.getBoolean("uploadpack", "allowanysha1inwant", false);
        this.allowFilter = config.getBoolean("uploadpack", "allowfilter", false);
        this.protocolVersion = ProtocolVersion.parse(config.getString("protocol", null, "version"));
        this.hideRefs = config.getStringList("uploadpack", null, "hiderefs");
        this.allowSidebandAll = config.getBoolean("uploadpack", "allowsidebandall", false);
        this.advertiseSidebandAll = config.getBoolean("uploadpack", "advertisesidebandall", false);
        this.advertiseWaitForDone = config.getBoolean("uploadpack", "advertisewaitfordone", false);
        this.advertiseObjectInfo = config.getBoolean("uploadpack", "advertiseobjectinfo", false);
        this.allowReceiveClientSID = config.getBoolean("transfer", "advertisesid", false);
    }

    @Nullable
    public ObjectChecker newObjectChecker() {
        return newObjectChecker(this.fetchFsck);
    }

    @Nullable
    public ObjectChecker newReceiveObjectChecker() {
        return newObjectChecker(this.receiveFsck);
    }

    private ObjectChecker newObjectChecker(boolean z) {
        if (z) {
            return new ObjectChecker().setIgnore(this.ignore).setAllowInvalidPersonIdent(this.allowInvalidPersonIdent).setSafeForWindows(this.safeForWindows).setSafeForMacOS(this.safeForMacOS).setSkipList(skipList());
        }
        return null;
    }

    private ObjectIdSet skipList() {
        String str = this.fsckSkipList;
        if (str == null || str.isEmpty()) {
            return null;
        }
        return new LazyObjectIdSetFile(new File(this.fsckSkipList));
    }

    public boolean isAllowTipSha1InWant() {
        return this.allowTipSha1InWant;
    }

    public boolean isAllowReachableSha1InWant() {
        return this.allowReachableSha1InWant;
    }

    public boolean isAllowAnySha1InWant() {
        return this.allowAnySha1InWant;
    }

    public boolean isAllowFilter() {
        return this.allowFilter;
    }

    public boolean isAllowRefInWant() {
        return this.allowRefInWant;
    }

    public boolean isAllowSidebandAll() {
        return this.allowSidebandAll;
    }

    public boolean isAdvertiseSidebandAll() {
        return this.advertiseSidebandAll && this.allowSidebandAll;
    }

    public boolean isAdvertiseWaitForDone() {
        return this.advertiseWaitForDone;
    }

    public boolean isAdvertiseObjectInfo() {
        return this.advertiseObjectInfo;
    }

    public boolean isAllowReceiveClientSID() {
        return this.allowReceiveClientSID;
    }

    public RefFilter getRefFilter() {
        if (this.hideRefs.length == 0) {
            return RefFilter.DEFAULT;
        }
        return new AnonymousClass1();
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.transport.TransferConfig$1, reason: invalid class name */
    class AnonymousClass1 implements RefFilter {
        AnonymousClass1() {
        }

        @Override // org.eclipse.jgit.transport.RefFilter
        public Map<String, Ref> filter(Map<String, Ref> map) {
            HashMap map2 = new HashMap();
            for (Map.Entry<String, Ref> entry : map.entrySet()) {
                String[] strArr = TransferConfig.this.hideRefs;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        String str = strArr[i];
                        if (entry.getKey().equals(str) || prefixMatch(str, entry.getKey())) {
                            break;
                        }
                        i++;
                    } else {
                        map2.put(entry.getKey(), entry.getValue());
                        break;
                    }
                }
            }
            return map2;
        }

        private boolean prefixMatch(String str, String str2) {
            return str.charAt(str.length() - 1) == '/' && str2.startsWith(str);
        }
    }

    boolean hasDefaultRefFilter() {
        return this.hideRefs.length == 0;
    }

    static class FsckKeyNameHolder {
        private static final Map<String, ObjectChecker.ErrorType> errors = new HashMap();

        static {
            for (ObjectChecker.ErrorType errorType : ObjectChecker.ErrorType.valuesCustom()) {
                errors.put(keyNameFor(errorType.name()), errorType);
            }
        }

        @Nullable
        static ObjectChecker.ErrorType parse(String str) {
            return errors.get(StringUtils.toLowerCase(str));
        }

        private static String keyNameFor(String str) {
            StringBuilder sb = new StringBuilder(str.length());
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '_') {
                    sb.append(cCharAt);
                }
            }
            return StringUtils.toLowerCase(sb.toString());
        }

        private FsckKeyNameHolder() {
        }
    }
}
