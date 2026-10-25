package org.eclipse.jgit.fnmatch;

import com.google.common.base.Ascii;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.message.TokenParser;
import org.eclipse.jgit.errors.InvalidPatternException;
import org.eclipse.jgit.internal.JGitText;

/* JADX INFO: loaded from: classes5.dex */
final class GroupHead extends AbstractHead {
    private static final Pattern REGEX_PATTERN = Pattern.compile("([^-][-][^-]|\\[[.:=].*?[.:=]\\])");
    private final List<CharacterPattern> characterClasses;
    private final boolean inverse;

    private interface CharacterPattern {
        boolean matches(char c);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GroupHead(String str, String str2) throws InvalidPatternException {
        super(false);
        this.characterClasses = new ArrayList();
        boolean zStartsWith = str.startsWith("!");
        this.inverse = zStartsWith;
        str = zStartsWith ? str.substring(1) : str;
        Matcher matcher = REGEX_PATTERN.matcher(str);
        while (matcher.find()) {
            String strGroup = matcher.group(0);
            if (strGroup.length() == 3 && strGroup.charAt(1) == '-') {
                this.characterClasses.add(new CharacterRange(strGroup.charAt(0), strGroup.charAt(2)));
            } else if (strGroup.equals("[:alnum:]")) {
                this.characterClasses.add(LetterPattern.INSTANCE);
                this.characterClasses.add(DigitPattern.INSTANCE);
            } else if (strGroup.equals("[:alpha:]")) {
                this.characterClasses.add(LetterPattern.INSTANCE);
            } else if (strGroup.equals("[:blank:]")) {
                this.characterClasses.add(new OneCharacterPattern(TokenParser.SP));
                this.characterClasses.add(new OneCharacterPattern('\t'));
            } else if (strGroup.equals("[:cntrl:]")) {
                this.characterClasses.add(new CharacterRange((char) 0, (char) 31));
                this.characterClasses.add(new OneCharacterPattern(Ascii.MAX));
            } else if (strGroup.equals("[:digit:]")) {
                this.characterClasses.add(DigitPattern.INSTANCE);
            } else if (strGroup.equals("[:graph:]")) {
                this.characterClasses.add(new CharacterRange('!', '~'));
                this.characterClasses.add(LetterPattern.INSTANCE);
                this.characterClasses.add(DigitPattern.INSTANCE);
            } else if (strGroup.equals("[:lower:]")) {
                this.characterClasses.add(LowerPattern.INSTANCE);
            } else if (strGroup.equals("[:print:]")) {
                this.characterClasses.add(new CharacterRange(TokenParser.SP, '~'));
                this.characterClasses.add(LetterPattern.INSTANCE);
                this.characterClasses.add(DigitPattern.INSTANCE);
            } else if (strGroup.equals("[:punct:]")) {
                this.characterClasses.add(PunctPattern.INSTANCE);
            } else if (strGroup.equals("[:space:]")) {
                this.characterClasses.add(WhitespacePattern.INSTANCE);
            } else if (strGroup.equals("[:upper:]")) {
                this.characterClasses.add(UpperPattern.INSTANCE);
            } else if (strGroup.equals("[:xdigit:]")) {
                this.characterClasses.add(new CharacterRange('0', '9'));
                this.characterClasses.add(new CharacterRange('a', 'f'));
                this.characterClasses.add(new CharacterRange('A', 'F'));
            } else if (strGroup.equals("[:word:]")) {
                this.characterClasses.add(new OneCharacterPattern('_'));
                this.characterClasses.add(LetterPattern.INSTANCE);
                this.characterClasses.add(DigitPattern.INSTANCE);
            } else {
                throw new InvalidPatternException(MessageFormat.format(JGitText.get().characterClassIsNotSupported, strGroup), str2);
            }
            str = matcher.replaceFirst("");
            matcher.reset(str);
        }
        for (int i = 0; i < str.length(); i++) {
            this.characterClasses.add(new OneCharacterPattern(str.charAt(i)));
        }
    }

    @Override // org.eclipse.jgit.fnmatch.AbstractHead
    protected final boolean matches(char c) {
        Iterator<CharacterPattern> it = this.characterClasses.iterator();
        while (it.hasNext()) {
            if (it.next().matches(c)) {
                return !this.inverse;
            }
        }
        return this.inverse;
    }

    private static final class CharacterRange implements CharacterPattern {
        private final char end;
        private final char start;

        CharacterRange(char c, char c2) {
            this.start = c;
            this.end = c2;
        }

        @Override // org.eclipse.jgit.fnmatch.GroupHead.CharacterPattern
        public final boolean matches(char c) {
            return this.start <= c && c <= this.end;
        }
    }

    private static final class DigitPattern implements CharacterPattern {
        static final DigitPattern INSTANCE = new DigitPattern();

        private DigitPattern() {
        }

        @Override // org.eclipse.jgit.fnmatch.GroupHead.CharacterPattern
        public final boolean matches(char c) {
            return Character.isDigit(c);
        }
    }

    private static final class LetterPattern implements CharacterPattern {
        static final LetterPattern INSTANCE = new LetterPattern();

        private LetterPattern() {
        }

        @Override // org.eclipse.jgit.fnmatch.GroupHead.CharacterPattern
        public final boolean matches(char c) {
            return Character.isLetter(c);
        }
    }

    private static final class LowerPattern implements CharacterPattern {
        static final LowerPattern INSTANCE = new LowerPattern();

        private LowerPattern() {
        }

        @Override // org.eclipse.jgit.fnmatch.GroupHead.CharacterPattern
        public final boolean matches(char c) {
            return Character.isLowerCase(c);
        }
    }

    private static final class UpperPattern implements CharacterPattern {
        static final UpperPattern INSTANCE = new UpperPattern();

        private UpperPattern() {
        }

        @Override // org.eclipse.jgit.fnmatch.GroupHead.CharacterPattern
        public final boolean matches(char c) {
            return Character.isUpperCase(c);
        }
    }

    private static final class WhitespacePattern implements CharacterPattern {
        static final WhitespacePattern INSTANCE = new WhitespacePattern();

        private WhitespacePattern() {
        }

        @Override // org.eclipse.jgit.fnmatch.GroupHead.CharacterPattern
        public final boolean matches(char c) {
            return Character.isWhitespace(c);
        }
    }

    private static final class OneCharacterPattern implements CharacterPattern {
        private char expectedCharacter;

        OneCharacterPattern(char c) {
            this.expectedCharacter = c;
        }

        @Override // org.eclipse.jgit.fnmatch.GroupHead.CharacterPattern
        public final boolean matches(char c) {
            return this.expectedCharacter == c;
        }
    }

    private static final class PunctPattern implements CharacterPattern {
        static final PunctPattern INSTANCE = new PunctPattern();
        private static String punctCharacters = "-!\"#$%&'()*+,./:;<=>?@[\\]_`{|}~";

        private PunctPattern() {
        }

        @Override // org.eclipse.jgit.fnmatch.GroupHead.CharacterPattern
        public boolean matches(char c) {
            return punctCharacters.indexOf(c) != -1;
        }
    }
}
