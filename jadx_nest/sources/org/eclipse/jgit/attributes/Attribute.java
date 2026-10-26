package org.eclipse.jgit.attributes;

/* INFO: loaded from: classes5.dex */
public final class Attribute {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$attributes$Attribute$State;
    private final String key;
    private final State state;
    private final String value;

    public enum State {
        SET,
        UNSET,
        UNSPECIFIED,
        CUSTOM;

        /* INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static State[] valuesCustom() {
            State[] stateArrValuesCustom = values();
            int length = stateArrValuesCustom.length;
            State[] stateArr = new State[length];
            System.arraycopy(stateArrValuesCustom, 0, stateArr, 0, length);
            return stateArr;
        }
    }

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$attributes$Attribute$State() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$attributes$Attribute$State;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[State.valuesCustom().length];
        try {
            iArr2[State.CUSTOM.ordinal()] = 4;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[State.SET.ordinal()] = 1;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[State.UNSET.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[State.UNSPECIFIED.ordinal()] = 3;
        } catch (NoSuchFieldError unused4) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$attributes$Attribute$State = iArr2;
        return iArr2;
    }

    public Attribute(String str, State state) {
        this(str, state, null);
    }

    private Attribute(String str, State state, String str2) {
        if (str == null) {
            throw new NullPointerException("The key of an attribute should not be null");
        }
        if (state == null) {
            throw new NullPointerException("The state of an attribute should not be null");
        }
        this.key = str;
        this.state = state;
        this.value = str2;
    }

    public Attribute(String str, String str2) {
        this(str, State.CUSTOM, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Attribute)) {
            return false;
        }
        Attribute attribute = (Attribute) obj;
        if (!this.key.equals(attribute.key) || this.state != attribute.state) {
            return false;
        }
        String str = this.value;
        if (str == null) {
            if (attribute.value != null) {
                return false;
            }
        } else if (!str.equals(attribute.value)) {
            return false;
        }
        return true;
    }

    public String getKey() {
        return this.key;
    }

    public State getState() {
        return this.state;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        int iHashCode = (((this.key.hashCode() + 31) * 31) + this.state.hashCode()) * 31;
        String str = this.value;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        int i = $SWITCH_TABLE$org$eclipse$jgit$attributes$Attribute$State()[this.state.ordinal()];
        if (i == 1) {
            return this.key;
        }
        if (i == 2) {
            return "-" + this.key;
        }
        if (i == 3) {
            return "!" + this.key;
        }
        return this.key + "=" + this.value;
    }
}
