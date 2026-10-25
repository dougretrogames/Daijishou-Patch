package org.eclipse.jgit.internal.storage.pack;

import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: loaded from: classes5.dex */
public enum PackExt {
    PACK(ConfigConstants.CONFIG_PACK_SECTION),
    INDEX("idx"),
    KEEP("keep"),
    BITMAP_INDEX("bitmap"),
    REFTABLE("ref"),
    REVERSE_INDEX("rev"),
    COMMIT_GRAPH("graph"),
    OBJECT_SIZE_INDEX("objsize");

    private final String ext;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static PackExt[] valuesCustom() {
        PackExt[] packExtArrValuesCustom = values();
        int length = packExtArrValuesCustom.length;
        PackExt[] packExtArr = new PackExt[length];
        System.arraycopy(packExtArrValuesCustom, 0, packExtArr, 0, length);
        return packExtArr;
    }

    PackExt(String str) {
        this.ext = str;
    }

    public String getExtension() {
        return this.ext;
    }

    public int getPosition() {
        return ordinal();
    }

    public int getBit() {
        return 1 << getPosition();
    }

    public String getTmpExtension() {
        return String.format(".%s_tmp", this.ext);
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.format("PackExt[%s, bit=0x%s]", getExtension(), Integer.toHexString(getBit()));
    }
}
