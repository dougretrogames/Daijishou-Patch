package com.vdurmont.semver4j;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;
import org.apache.commons.codec.language.Soundex;

/* INFO: loaded from: classes4.dex */
public class Tokenizer {
    private static final Map<Semver.SemverType, Map<Character, Token>> SPECIAL_CHARS = new HashMap();

    static {
        for (Semver.SemverType semverType : Semver.SemverType.values()) {
            SPECIAL_CHARS.put(semverType, new HashMap());
        }
        for (TokenType tokenType : TokenType.values()) {
            if (tokenType.character != null) {
                for (Semver.SemverType semverType2 : Semver.SemverType.values()) {
                    if (tokenType.supports(semverType2)) {
                        SPECIAL_CHARS.get(semverType2).put(tokenType.character, new Token(tokenType));
                    }
                }
            }
        }
    }

    protected static List<Token> tokenize(String str, Semver.SemverType semverType) {
        Token token;
        Map<Character, Token> map = SPECIAL_CHARS.get(semverType);
        if (semverType == Semver.SemverType.COCOAPODS) {
            str = str.replace("~>", "~");
        } else if (semverType == Semver.SemverType.NPM) {
            str = str.replace("||", "|");
        }
        String strReplace = str.replace("<=", "≤").replace(">=", "≥");
        LinkedList linkedList = new LinkedList();
        Token token2 = null;
        Token token3 = null;
        for (char c : strReplace.toCharArray()) {
            if (c != ' ') {
                if (map.containsKey(Character.valueOf(c))) {
                    if (token2 != null) {
                        linkedList.add(token2);
                        token = null;
                    } else {
                        Token token4 = token3;
                        token = token2;
                        token2 = token4;
                    }
                    Token token5 = map.get(Character.valueOf(c));
                    if (token5.type.isUnary() && token2 != null && token2.type == TokenType.VERSION) {
                        linkedList.add(new Token(TokenType.AND));
                    }
                    linkedList.add(token5);
                    token2 = token;
                    token3 = token5;
                } else {
                    if (token2 == null) {
                        token2 = new Token(TokenType.VERSION);
                    }
                    token2.append(c);
                }
            }
        }
        if (token2 != null) {
            linkedList.add(token2);
        }
        return linkedList;
    }

    protected static class Token {
        public final TokenType type;
        public String value;

        public Token(TokenType tokenType) {
            this(tokenType, null);
        }

        public Token(TokenType tokenType, String str) {
            this.type = tokenType;
            this.value = str;
        }

        public void append(char c) {
            if (this.value == null) {
                this.value = "";
            }
            this.value += c;
        }
    }

    protected enum TokenType {
        TILDE('~', true, Semver.SemverType.COCOAPODS, Semver.SemverType.NPM),
        CARET('^', true, Semver.SemverType.NPM),
        EQ('=', true, Semver.SemverType.NPM),
        LT(Character.valueOf(Typography.less), true, Semver.SemverType.COCOAPODS, Semver.SemverType.NPM),
        LTE(Character.valueOf(Typography.lessOrEqual), true, Semver.SemverType.COCOAPODS, Semver.SemverType.NPM),
        GT(Character.valueOf(Typography.greater), true, Semver.SemverType.COCOAPODS, Semver.SemverType.NPM),
        GTE(Character.valueOf(Typography.greaterOrEqual), true, Semver.SemverType.COCOAPODS, Semver.SemverType.NPM),
        HYPHEN(Character.valueOf(Soundex.SILENT_MARKER), false, Semver.SemverType.NPM),
        OR('|', false, Semver.SemverType.NPM),
        AND(null, false, new Semver.SemverType[0]),
        OPENING('(', false, Semver.SemverType.NPM),
        CLOSING(')', false, Semver.SemverType.NPM),
        VERSION(null, false, new Semver.SemverType[0]);

        public final Character character;
        private final Semver.SemverType[] supportedTypes;
        private final boolean unary;

        TokenType(Character ch, boolean z, Semver.SemverType... semverTypeArr) {
            this.character = ch;
            this.unary = z;
            this.supportedTypes = semverTypeArr;
        }

        public boolean isUnary() {
            return this.unary;
        }

        public boolean supports(Semver.SemverType semverType) {
            for (Semver.SemverType semverType2 : this.supportedTypes) {
                if (semverType2 == semverType) {
                    return true;
                }
            }
            return false;
        }
    }
}
