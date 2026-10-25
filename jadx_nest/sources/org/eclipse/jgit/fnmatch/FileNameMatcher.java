package org.eclipse.jgit.fnmatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.errors.InvalidPatternException;
import org.eclipse.jgit.errors.NoClosingBracketException;

/* JADX INFO: loaded from: classes5.dex */
public class FileNameMatcher {
    static final List<Head> EMPTY_HEAD_LIST = Collections.emptyList();
    private static final Pattern characterClassStartPattern = Pattern.compile("\\[[.:=]");
    private List<Head> heads;
    private List<Head> headsStartValue;
    private List<Head> listForLocalUseage;

    private FileNameMatcher(List<Head> list) {
        this(list, list);
    }

    private FileNameMatcher(List<Head> list, List<Head> list2) {
        this.headsStartValue = list;
        ArrayList arrayList = new ArrayList(list2.size());
        this.heads = arrayList;
        arrayList.addAll(list2);
        this.listForLocalUseage = new ArrayList(list2.size());
    }

    public FileNameMatcher(String str, Character ch) throws InvalidPatternException {
        this(createHeadsStartValues(str, ch));
    }

    public FileNameMatcher(FileNameMatcher fileNameMatcher) {
        this(fileNameMatcher.headsStartValue, fileNameMatcher.heads);
    }

    private static List<Head> createHeadsStartValues(String str, Character ch) throws InvalidPatternException {
        List<AbstractHead> heads = parseHeads(str, ch);
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(LastHead.INSTANCE);
        for (int size = heads.size() - 1; size >= 0; size--) {
            AbstractHead abstractHead = heads.get(size);
            if (abstractHead.isStar()) {
                arrayList.add(abstractHead);
                abstractHead.setNewHeads(arrayList);
            } else {
                abstractHead.setNewHeads(arrayList);
                arrayList = new ArrayList(2);
                arrayList.add(abstractHead);
            }
        }
        return arrayList;
    }

    private static int findGroupEnd(int i, String str) throws InvalidPatternException {
        int i2 = i + 1;
        int i3 = i + 2;
        if (i2 >= str.length()) {
            throw new NoClosingBracketException(i, CollectionUtils.DEFAULT_TOSTRING_PREFIX, CollectionUtils.DEFAULT_TOSTRING_SUFFIX, str);
        }
        if (str.charAt(i2) == '!') {
            i2 = i + 2;
            i3 = i + 3;
        }
        Matcher matcher = characterClassStartPattern.matcher(str);
        int i4 = -1;
        while (i4 == -1) {
            int iIndexOfUnescaped = indexOfUnescaped(str, AbstractJsonLexerKt.END_LIST, i3);
            if (iIndexOfUnescaped == -1) {
                throw new NoClosingBracketException(i, CollectionUtils.DEFAULT_TOSTRING_PREFIX, CollectionUtils.DEFAULT_TOSTRING_SUFFIX, str);
            }
            if (!matcher.find(i2) || matcher.start() >= iIndexOfUnescaped) {
                i4 = iIndexOfUnescaped;
            } else {
                String strGroup = matcher.group(0);
                String str2 = strGroup.charAt(1) + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
                int iStart = matcher.start();
                int iIndexOf = str.indexOf(str2, iStart + 2);
                if (iIndexOf == -1) {
                    throw new NoClosingBracketException(iStart, strGroup, str2, str);
                }
                i3 = iIndexOf + 2;
                i2 = i3;
            }
        }
        return i4;
    }

    private static List<AbstractHead> parseHeads(String str, Character ch) throws InvalidPatternException {
        ArrayList arrayList = new ArrayList();
        int length = 0;
        while (length < str.length()) {
            int iIndexOfUnescaped = indexOfUnescaped(str, AbstractJsonLexerKt.BEGIN_LIST, length);
            if (iIndexOfUnescaped == -1) {
                arrayList.addAll(createSimpleHeads(str.substring(length), ch));
                length = str.length();
            } else {
                arrayList.addAll(createSimpleHeads(str.substring(length, iIndexOfUnescaped), ch));
                int iFindGroupEnd = findGroupEnd(iIndexOfUnescaped, str);
                arrayList.add(new GroupHead(str.substring(iIndexOfUnescaped + 1, iFindGroupEnd), str));
                length = iFindGroupEnd + 1;
            }
        }
        return arrayList;
    }

    private static List<AbstractHead> createSimpleHeads(String str, Character ch) {
        ArrayList arrayList = new ArrayList(str.length());
        boolean z = false;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (z) {
                arrayList.add(new CharacterHead(cCharAt));
                z = false;
            } else if (cCharAt == '*') {
                arrayList.add(createWildCardHead(ch, true));
            } else if (cCharAt == '?') {
                arrayList.add(createWildCardHead(ch, false));
            } else if (cCharAt != '\\') {
                arrayList.add(new CharacterHead(cCharAt));
            } else {
                z = true;
            }
        }
        return arrayList;
    }

    private static AbstractHead createWildCardHead(Character ch, boolean z) {
        if (ch != null) {
            return new RestrictedWildCardHead(ch.charValue(), z);
        }
        return new WildCardHead(z);
    }

    private boolean extendStringToMatchByOneCharacter(char c) {
        List<Head> list = this.listForLocalUseage;
        list.clear();
        List<Head> list2 = null;
        for (int i = 0; i < this.heads.size(); i++) {
            List<Head> nextHeads = this.heads.get(i).getNextHeads(c);
            if (nextHeads != list2) {
                if (!nextHeads.isEmpty()) {
                    list.addAll(nextHeads);
                }
                list2 = nextHeads;
            }
        }
        this.listForLocalUseage = this.heads;
        this.heads = list;
        return !list.isEmpty();
    }

    private static int indexOfUnescaped(String str, char c, int i) {
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt == c) {
                return i;
            }
            if (cCharAt == '\\') {
                i++;
            }
            i++;
        }
        return -1;
    }

    public void append(String str) {
        for (int i = 0; i < str.length() && extendStringToMatchByOneCharacter(str.charAt(i)); i++) {
        }
    }

    public void reset() {
        this.heads.clear();
        this.heads.addAll(this.headsStartValue);
    }

    public FileNameMatcher createMatcherForSuffix() {
        ArrayList arrayList = new ArrayList(this.heads.size());
        arrayList.addAll(this.heads);
        return new FileNameMatcher(arrayList);
    }

    public boolean isMatch() {
        if (this.heads.isEmpty()) {
            return false;
        }
        List<Head> list = this.heads;
        ListIterator<Head> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (listIterator.previous() == LastHead.INSTANCE) {
                return true;
            }
        }
        return false;
    }

    public boolean canAppendMatch() {
        Iterator<Head> it = this.heads.iterator();
        while (it.hasNext()) {
            if (it.next() != LastHead.INSTANCE) {
                return true;
            }
        }
        return false;
    }
}
