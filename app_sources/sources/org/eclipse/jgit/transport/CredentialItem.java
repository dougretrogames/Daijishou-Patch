package org.eclipse.jgit.transport;

import java.util.Arrays;
import org.eclipse.jgit.internal.JGitText;

/* INFO: loaded from: classes5.dex */
public abstract class CredentialItem {
    private final String promptText;
    private final boolean valueSecure;

    public abstract void clear();

    public CredentialItem(String str, boolean z) {
        this.promptText = str;
        this.valueSecure = z;
    }

    public String getPromptText() {
        return this.promptText;
    }

    public boolean isValueSecure() {
        return this.valueSecure;
    }

    public static class StringType extends CredentialItem {
        private String value;

        public StringType(String str, boolean z) {
            super(str, z);
        }

        @Override // org.eclipse.jgit.transport.CredentialItem
        public void clear() {
            this.value = null;
        }

        public String getValue() {
            return this.value;
        }

        public void setValue(String str) {
            this.value = str;
        }
    }

    public static class CharArrayType extends CredentialItem {
        private char[] value;

        public CharArrayType(String str, boolean z) {
            super(str, z);
        }

        @Override // org.eclipse.jgit.transport.CredentialItem
        public void clear() {
            char[] cArr = this.value;
            if (cArr != null) {
                Arrays.fill(cArr, (char) 0);
                this.value = null;
            }
        }

        public char[] getValue() {
            return this.value;
        }

        public void setValue(char[] cArr) {
            clear();
            if (cArr != null) {
                char[] cArr2 = new char[cArr.length];
                this.value = cArr2;
                System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
            }
        }

        public void setValueNoCopy(char[] cArr) {
            clear();
            this.value = cArr;
        }
    }

    public static class YesNoType extends CredentialItem {
        private boolean value;

        public YesNoType(String str) {
            super(str, false);
        }

        @Override // org.eclipse.jgit.transport.CredentialItem
        public void clear() {
            this.value = false;
        }

        public boolean getValue() {
            return this.value;
        }

        public void setValue(boolean z) {
            this.value = z;
        }
    }

    public static class InformationalMessage extends CredentialItem {
        @Override // org.eclipse.jgit.transport.CredentialItem
        public void clear() {
        }

        public InformationalMessage(String str) {
            super(str, false);
        }
    }

    public static class Username extends StringType {
        public Username() {
            super(JGitText.get().credentialUsername, false);
        }
    }

    public static class Password extends CharArrayType {
        public Password() {
            super(JGitText.get().credentialPassword, true);
        }

        public Password(String str) {
            super(str, true);
        }
    }
}
