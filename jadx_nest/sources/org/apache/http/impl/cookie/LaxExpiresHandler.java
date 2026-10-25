package org.apache.http.impl.cookie;

import java.util.BitSet;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.CommonCookieAttributeHandler;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.Args;
import org.apache.http.util.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public class LaxExpiresHandler extends AbstractCookieAttributeHandler implements CommonCookieAttributeHandler {
    private static final Pattern DAY_OF_MONTH_PATTERN;
    private static final BitSet DELIMS;
    private static final Map<String, Integer> MONTHS;
    private static final Pattern MONTH_PATTERN;
    private static final Pattern TIME_PATTERN;
    static final TimeZone UTC = TimeZone.getTimeZone("UTC");
    private static final Pattern YEAR_PATTERN;

    static {
        BitSet bitSet = new BitSet();
        bitSet.set(9);
        for (int i = 32; i <= 47; i++) {
            bitSet.set(i);
        }
        for (int i2 = 59; i2 <= 64; i2++) {
            bitSet.set(i2);
        }
        for (int i3 = 91; i3 <= 96; i3++) {
            bitSet.set(i3);
        }
        for (int i4 = 123; i4 <= 126; i4++) {
            bitSet.set(i4);
        }
        DELIMS = bitSet;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(12);
        concurrentHashMap.put("jan", 0);
        concurrentHashMap.put("feb", 1);
        concurrentHashMap.put("mar", 2);
        concurrentHashMap.put("apr", 3);
        concurrentHashMap.put("may", 4);
        concurrentHashMap.put("jun", 5);
        concurrentHashMap.put("jul", 6);
        concurrentHashMap.put("aug", 7);
        concurrentHashMap.put("sep", 8);
        concurrentHashMap.put("oct", 9);
        concurrentHashMap.put("nov", 10);
        concurrentHashMap.put("dec", 11);
        MONTHS = concurrentHashMap;
        TIME_PATTERN = Pattern.compile("^([0-9]{1,2}):([0-9]{1,2}):([0-9]{1,2})([^0-9].*)?$");
        DAY_OF_MONTH_PATTERN = Pattern.compile("^([0-9]{1,2})([^0-9].*)?$");
        MONTH_PATTERN = Pattern.compile("^(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)(.*)?$", 2);
        YEAR_PATTERN = Pattern.compile("^([0-9]{2,4})([^0-9].*)?$");
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0072 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x0074 A[Catch: NumberFormatException -> 0x015b, TryCatch #0 {NumberFormatException -> 0x015b, blocks: (B:6:0x002e, B:8:0x0034, B:12:0x0048, B:14:0x0054, B:16:0x0074, B:18:0x0080, B:20:0x008e, B:22:0x009a, B:24:0x00b6, B:26:0x00c2), top: B:62:0x002e }] */
    /* JADX WARN: Code duplicated, block: B:18:0x0080 A[Catch: NumberFormatException -> 0x015b, TryCatch #0 {NumberFormatException -> 0x015b, blocks: (B:6:0x002e, B:8:0x0034, B:12:0x0048, B:14:0x0054, B:16:0x0074, B:18:0x0080, B:20:0x008e, B:22:0x009a, B:24:0x00b6, B:26:0x00c2), top: B:62:0x002e }] */
    /* JADX WARN: Code duplicated, block: B:19:0x008c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x008e A[Catch: NumberFormatException -> 0x015b, TryCatch #0 {NumberFormatException -> 0x015b, blocks: (B:6:0x002e, B:8:0x0034, B:12:0x0048, B:14:0x0054, B:16:0x0074, B:18:0x0080, B:20:0x008e, B:22:0x009a, B:24:0x00b6, B:26:0x00c2), top: B:62:0x002e }] */
    /* JADX WARN: Code duplicated, block: B:22:0x009a A[Catch: NumberFormatException -> 0x015b, TryCatch #0 {NumberFormatException -> 0x015b, blocks: (B:6:0x002e, B:8:0x0034, B:12:0x0048, B:14:0x0054, B:16:0x0074, B:18:0x0080, B:20:0x008e, B:22:0x009a, B:24:0x00b6, B:26:0x00c2), top: B:62:0x002e }] */
    /* JADX WARN: Code duplicated, block: B:23:0x00b4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x00b6 A[Catch: NumberFormatException -> 0x015b, TryCatch #0 {NumberFormatException -> 0x015b, blocks: (B:6:0x002e, B:8:0x0034, B:12:0x0048, B:14:0x0054, B:16:0x0074, B:18:0x0080, B:20:0x008e, B:22:0x009a, B:24:0x00b6, B:26:0x00c2), top: B:62:0x002e }] */
    /* JADX WARN: Code duplicated, block: B:26:0x00c2 A[Catch: NumberFormatException -> 0x015b, TRY_LEAVE, TryCatch #0 {NumberFormatException -> 0x015b, blocks: (B:6:0x002e, B:8:0x0034, B:12:0x0048, B:14:0x0054, B:16:0x0074, B:18:0x0080, B:20:0x008e, B:22:0x009a, B:24:0x00b6, B:26:0x00c2), top: B:62:0x002e }] */
    /* JADX WARN: Code duplicated, block: B:28:0x00ce  */
    @Override // org.apache.http.cookie.CookieAttributeHandler
    public void parse(SetCookie setCookie, String str) throws MalformedCookieException {
        Matcher matcher;
        Matcher matcher2;
        Matcher matcher3;
        Args.notNull(setCookie, "Cookie");
        if (TextUtils.isBlank(str)) {
            return;
        }
        ParserCursor parserCursor = new ParserCursor(0, str.length());
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        int i = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int iIntValue = 0;
        while (!parserCursor.atEnd()) {
            try {
                skipDelims(str, parserCursor);
                sb.setLength(0);
                copyContent(str, parserCursor, sb);
                if (sb.length() == 0) {
                    break;
                }
                if (!z) {
                    Matcher matcher4 = TIME_PATTERN.matcher(sb);
                    if (matcher4.matches()) {
                        i3 = Integer.parseInt(matcher4.group(1));
                        i4 = Integer.parseInt(matcher4.group(2));
                        i5 = Integer.parseInt(matcher4.group(3));
                        z = true;
                    } else if (!z2) {
                        matcher3 = DAY_OF_MONTH_PATTERN.matcher(sb);
                        if (matcher3.matches()) {
                            i2 = Integer.parseInt(matcher3.group(1));
                            z2 = true;
                        } else if (!z3) {
                            matcher2 = MONTH_PATTERN.matcher(sb);
                            if (matcher2.matches()) {
                                iIntValue = MONTHS.get(matcher2.group(1).toLowerCase(Locale.ROOT)).intValue();
                                z3 = true;
                            } else if (!z4) {
                                matcher = YEAR_PATTERN.matcher(sb);
                                if (matcher.matches()) {
                                    i = Integer.parseInt(matcher.group(1));
                                    z4 = true;
                                }
                            }
                        } else if (!z4) {
                            matcher = YEAR_PATTERN.matcher(sb);
                            if (matcher.matches()) {
                                i = Integer.parseInt(matcher.group(1));
                                z4 = true;
                            }
                        }
                    } else if (!z3) {
                        matcher2 = MONTH_PATTERN.matcher(sb);
                        if (matcher2.matches()) {
                            iIntValue = MONTHS.get(matcher2.group(1).toLowerCase(Locale.ROOT)).intValue();
                            z3 = true;
                        } else if (!z4) {
                            matcher = YEAR_PATTERN.matcher(sb);
                            if (matcher.matches()) {
                                i = Integer.parseInt(matcher.group(1));
                                z4 = true;
                            }
                        }
                    } else if (!z4) {
                        matcher = YEAR_PATTERN.matcher(sb);
                        if (matcher.matches()) {
                            i = Integer.parseInt(matcher.group(1));
                            z4 = true;
                        }
                    }
                } else if (!z2) {
                    matcher3 = DAY_OF_MONTH_PATTERN.matcher(sb);
                    if (matcher3.matches()) {
                        i2 = Integer.parseInt(matcher3.group(1));
                        z2 = true;
                    } else if (!z3) {
                        matcher2 = MONTH_PATTERN.matcher(sb);
                        if (matcher2.matches()) {
                            iIntValue = MONTHS.get(matcher2.group(1).toLowerCase(Locale.ROOT)).intValue();
                            z3 = true;
                        } else if (!z4) {
                            matcher = YEAR_PATTERN.matcher(sb);
                            if (matcher.matches()) {
                                i = Integer.parseInt(matcher.group(1));
                                z4 = true;
                            }
                        }
                    } else if (!z4) {
                        matcher = YEAR_PATTERN.matcher(sb);
                        if (matcher.matches()) {
                            i = Integer.parseInt(matcher.group(1));
                            z4 = true;
                        }
                    }
                } else if (!z3) {
                    matcher2 = MONTH_PATTERN.matcher(sb);
                    if (matcher2.matches()) {
                        iIntValue = MONTHS.get(matcher2.group(1).toLowerCase(Locale.ROOT)).intValue();
                        z3 = true;
                    } else if (!z4) {
                        matcher = YEAR_PATTERN.matcher(sb);
                        if (matcher.matches()) {
                            i = Integer.parseInt(matcher.group(1));
                            z4 = true;
                        }
                    }
                } else if (!z4) {
                    matcher = YEAR_PATTERN.matcher(sb);
                    if (matcher.matches()) {
                        i = Integer.parseInt(matcher.group(1));
                        z4 = true;
                    }
                }
            } catch (NumberFormatException unused) {
                throw new MalformedCookieException("Invalid 'expires' attribute: " + str);
            }
        }
        if (!z || !z2 || !z3 || !z4) {
            throw new MalformedCookieException("Invalid 'expires' attribute: " + str);
        }
        if (i >= 70 && i <= 99) {
            i += 1900;
        }
        if (i >= 0 && i <= 69) {
            i += 2000;
        }
        if (i2 < 1 || i2 > 31 || i < 1601 || i3 > 23 || i4 > 59 || i5 > 59) {
            throw new MalformedCookieException("Invalid 'expires' attribute: " + str);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(UTC);
        calendar.setTimeInMillis(0L);
        calendar.set(13, i5);
        calendar.set(12, i4);
        calendar.set(11, i3);
        calendar.set(5, i2);
        calendar.set(2, iIntValue);
        calendar.set(1, i);
        setCookie.setExpiryDate(calendar.getTime());
    }

    private void skipDelims(CharSequence charSequence, ParserCursor parserCursor) {
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        for (int pos2 = parserCursor.getPos(); pos2 < upperBound; pos2++) {
            if (!DELIMS.get(charSequence.charAt(pos2))) {
                break;
            }
            pos++;
        }
        parserCursor.updatePos(pos);
    }

    private void copyContent(CharSequence charSequence, ParserCursor parserCursor, StringBuilder sb) {
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        for (int pos2 = parserCursor.getPos(); pos2 < upperBound; pos2++) {
            char cCharAt = charSequence.charAt(pos2);
            if (DELIMS.get(cCharAt)) {
                break;
            }
            pos++;
            sb.append(cCharAt);
        }
        parserCursor.updatePos(pos);
    }

    @Override // org.apache.http.cookie.CommonCookieAttributeHandler
    public String getAttributeName() {
        return ClientCookie.EXPIRES_ATTR;
    }
}
