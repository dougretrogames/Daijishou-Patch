package org.apache.commons.codec.language;

import java.util.Arrays;
import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;
import org.eclipse.jgit.lib.BranchConfig;

/* INFO: loaded from: classes5.dex */
public class ColognePhonetic implements StringEncoder {
    private static final char CHAR_IGNORE = '-';
    private static final char[] AEIJOUY = {'A', 'E', 'I', 'J', 'O', 'U', 'Y'};
    private static final char[] CSZ = {'C', 'S', 'Z'};
    private static final char[] FPVW = {'F', 'P', 'V', 'W'};
    private static final char[] GKQ = {'G', 'K', 'Q'};
    private static final char[] CKQ = {'C', 'K', 'Q'};
    private static final char[] AHKLOQRUX = {'A', 'H', 'K', 'L', 'O', 'Q', 'R', 'U', 'X'};
    private static final char[] SZ = {'S', 'Z'};
    private static final char[] AHKOQUX = {'A', 'H', 'K', 'O', 'Q', 'U', 'X'};
    private static final char[] DTX = {'D', 'T', 'X'};

    static abstract class CologneBuffer {
        protected final char[] data;
        protected int length;

        protected abstract char[] copyData(int i, int i2);

        CologneBuffer(char[] cArr) {
            this.data = cArr;
            this.length = cArr.length;
        }

        CologneBuffer(int i) {
            this.data = new char[i];
            this.length = 0;
        }

        public boolean isEmpty() {
            return length() == 0;
        }

        public int length() {
            return this.length;
        }

        public String toString() {
            return new String(copyData(0, this.length));
        }
    }

    private final class CologneInputBuffer extends CologneBuffer {
        CologneInputBuffer(char[] cArr) {
            super(cArr);
        }

        @Override // org.apache.commons.codec.language.ColognePhonetic.CologneBuffer
        protected char[] copyData(int i, int i2) {
            char[] cArr = new char[i2];
            System.arraycopy(this.data, (this.data.length - this.length) + i, cArr, 0, i2);
            return cArr;
        }

        public char getNextChar() {
            return this.data[getNextPos()];
        }

        protected int getNextPos() {
            return this.data.length - this.length;
        }

        public char removeNext() {
            char nextChar = getNextChar();
            this.length--;
            return nextChar;
        }
    }

    private final class CologneOutputBuffer extends CologneBuffer {
        private char lastCode;

        CologneOutputBuffer(int i) {
            super(i);
            this.lastCode = '/';
        }

        @Override // org.apache.commons.codec.language.ColognePhonetic.CologneBuffer
        protected char[] copyData(int i, int i2) {
            return Arrays.copyOfRange(this.data, i, i2);
        }

        public void put(char c) {
            if (c != '-' && this.lastCode != c && (c != '0' || this.length == 0)) {
                this.data[this.length] = c;
                this.length++;
            }
            this.lastCode = c;
        }
    }

    private static boolean arrayContains(char[] cArr, char c) {
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    public String colognePhonetic(String str) {
        if (str == null) {
            return null;
        }
        CologneInputBuffer cologneInputBuffer = new CologneInputBuffer(preprocess(str));
        CologneOutputBuffer cologneOutputBuffer = new CologneOutputBuffer(cologneInputBuffer.length() * 2);
        char c = '-';
        while (!cologneInputBuffer.isEmpty()) {
            char cRemoveNext = cologneInputBuffer.removeNext();
            char nextChar = !cologneInputBuffer.isEmpty() ? cologneInputBuffer.getNextChar() : '-';
            if (cRemoveNext >= 'A' && cRemoveNext <= 'Z') {
                if (arrayContains(AEIJOUY, cRemoveNext)) {
                    cologneOutputBuffer.put('0');
                } else if (cRemoveNext == 'B' || (cRemoveNext == 'P' && nextChar != 'H')) {
                    cologneOutputBuffer.put('1');
                } else if ((cRemoveNext == 'D' || cRemoveNext == 'T') && !arrayContains(CSZ, nextChar)) {
                    cologneOutputBuffer.put('2');
                } else if (arrayContains(FPVW, cRemoveNext)) {
                    cologneOutputBuffer.put('3');
                } else if (arrayContains(GKQ, cRemoveNext)) {
                    cologneOutputBuffer.put('4');
                } else if (cRemoveNext == 'X' && !arrayContains(CKQ, c)) {
                    cologneOutputBuffer.put('4');
                    cologneOutputBuffer.put('8');
                } else if (cRemoveNext == 'S' || cRemoveNext == 'Z') {
                    cologneOutputBuffer.put('8');
                } else if (cRemoveNext == 'C') {
                    if (cologneOutputBuffer.isEmpty()) {
                        if (arrayContains(AHKLOQRUX, nextChar)) {
                            cologneOutputBuffer.put('4');
                        } else {
                            cologneOutputBuffer.put('8');
                        }
                    } else if (arrayContains(SZ, c) || !arrayContains(AHKOQUX, nextChar)) {
                        cologneOutputBuffer.put('8');
                    } else {
                        cologneOutputBuffer.put('4');
                    }
                } else if (arrayContains(DTX, cRemoveNext)) {
                    cologneOutputBuffer.put('8');
                } else if (cRemoveNext == 'H') {
                    cologneOutputBuffer.put('-');
                } else if (cRemoveNext == 'R') {
                    cologneOutputBuffer.put('7');
                } else {
                    switch (cRemoveNext) {
                        case 'L':
                            cologneOutputBuffer.put('5');
                            break;
                        case 'M':
                        case 'N':
                            cologneOutputBuffer.put('6');
                            break;
                    }
                }
                c = cRemoveNext;
            }
        }
        return cologneOutputBuffer.toString();
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (!(obj instanceof String)) {
            throw new EncoderException("This method's parameter was expected to be of the type " + String.class.getName() + ". But actually it was of the type " + obj.getClass().getName() + BranchConfig.LOCAL_REPOSITORY);
        }
        return encode((String) obj);
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        return colognePhonetic(str);
    }

    public boolean isEncodeEqual(String str, String str2) {
        return colognePhonetic(str).equals(colognePhonetic(str2));
    }

    private char[] preprocess(String str) {
        char[] charArray = str.toUpperCase(Locale.GERMAN).toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == 196) {
                charArray[i] = 'A';
            } else if (c == 214) {
                charArray[i] = 'O';
            } else if (c == 220) {
                charArray[i] = 'U';
            }
        }
        return charArray;
    }
}
