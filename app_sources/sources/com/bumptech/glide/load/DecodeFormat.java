package com.bumptech.glide.load;

/* WARN: Enum visitor error
decompiler.core.utils.exceptions.decompilerRuntimeException: Can't remove SSA var: r0v0 com.bumptech.glide.load.DecodeFormat, still in use, count: 1, list:
  (r0v0 com.bumptech.glide.load.DecodeFormat) from 0x001a: SPUT (r0v0 com.bumptech.glide.load.DecodeFormat) (LINE:43) com.bumptech.glide.load.DecodeFormat.DEFAULT com.bumptech.glide.load.DecodeFormat
	at decompiler.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at decompiler.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at decompiler.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
	at decompiler.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at decompiler.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at decompiler.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at decompiler.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* INFO: loaded from: classes3.dex */
public final class DecodeFormat {
    PREFER_ARGB_8888,
    PREFER_RGB_565;

    public static final DecodeFormat DEFAULT = new DecodeFormat();

    private DecodeFormat() {
        super(str, i);
    }

    public static DecodeFormat valueOf(String str) {
        return (DecodeFormat) Enum.valueOf(DecodeFormat.class, str);
    }

    public static DecodeFormat[] values() {
        return (DecodeFormat[]) $VALUES.clone();
    }

    static {
    }
}
