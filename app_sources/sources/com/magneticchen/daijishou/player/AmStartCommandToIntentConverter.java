package com.magneticchen.daijishou.player;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.common.primitives.Ints;
import com.magneticchen.daijishou.data.Constants;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AmStartCommandToIntentConverter.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\t0\b¨\u0006\n"}, d2 = {"Lcom/magneticchen/daijishou/player/AmStartCommandToIntentConverter;", "", "()V", "createIntentByCommandArgs", "Landroid/content/Intent;", "arguments", "", "tokenReplaceList", "", "Lkotlin/Pair;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AmStartCommandToIntentConverter {
    public static final AmStartCommandToIntentConverter INSTANCE = new AmStartCommandToIntentConverter();

    private AmStartCommandToIntentConverter() {
    }

    /* JADX WARN: Code duplicated, block: B:183:0x0571  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final Intent createIntentByCommandArgs(String arguments, List<Pair<String, String>> tokenReplaceList) throws URISyntaxException {
        Intent intent;
        Intent uri;
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(tokenReplaceList, "tokenReplaceList");
        List<String> listSplit = new Regex("[\\n\\s]+").split(arguments, 0);
        int size = listSplit.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String strReplace$default = listSplit.get(i);
            Iterator<T> it = tokenReplaceList.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                strReplace$default = StringsKt.replace$default(strReplace$default, (String) pair.getFirst(), (String) pair.getSecond(), false, 4, (Object) null);
            }
            arrayList.add(strReplace$default);
        }
        ArrayList arrayList2 = arrayList;
        Log.d("daijishou_debug", "AmStart args: " + arrayList2);
        LinkedList linkedList = new LinkedList(arrayList2);
        Intent intent2 = new Intent();
        Intent intent3 = intent2;
        boolean z = false;
        Uri uri2 = null;
        String str = null;
        while (true) {
            boolean z2 = true;
            if (linkedList.isEmpty()) {
                intent3.setDataAndType(uri2, str);
                boolean z3 = intent3 != intent2;
                if (z3) {
                    intent2.setSelector(intent3);
                } else {
                    intent2 = intent3;
                }
                String str2 = linkedList.isEmpty() ? null : (String) linkedList.pop();
                if (str2 != null) {
                    String str3 = str2;
                    if (StringsKt.indexOf$default((CharSequence) str3, ':', 0, false, 6, (Object) null) >= 0) {
                        uri = Intent.parseUri(str2, 7);
                    } else {
                        if (StringsKt.indexOf$default((CharSequence) str3, '/', 0, false, 6, (Object) null) >= 0) {
                            intent = new Intent("android.intent.action.MAIN");
                            intent.addCategory("android.intent.category.LAUNCHER");
                            intent.setComponent(ComponentName.unflattenFromString(str2));
                        } else {
                            intent = new Intent("android.intent.action.MAIN");
                            intent.addCategory("android.intent.category.LAUNCHER");
                            intent.setPackage(str2);
                        }
                        uri = intent;
                    }
                } else if (z3) {
                    uri = new Intent("android.intent.action.MAIN");
                    uri.addCategory("android.intent.category.LAUNCHER");
                } else {
                    uri = null;
                }
                if (uri != null) {
                    Bundle extras = intent2.getExtras();
                    intent2.replaceExtras((Bundle) null);
                    Bundle extras2 = uri.getExtras();
                    uri.replaceExtras((Bundle) null);
                    if (intent2.getAction() != null && uri.getCategories() != null) {
                        Iterator it2 = new HashSet(uri.getCategories()).iterator();
                        while (it2.hasNext()) {
                            uri.removeCategory((String) it2.next());
                        }
                    }
                    intent2.fillIn(uri, 72);
                    if (extras == null) {
                        extras = extras2;
                    } else if (extras2 != null) {
                        extras2.putAll(extras);
                        extras = extras2;
                    }
                    intent2.replaceExtras(extras);
                    z = true;
                }
                if (!z) {
                    throw new IllegalArgumentException("No intent supplied".toString());
                }
                intent2.addFlags(268435456);
                intent2.addFlags(1);
                return intent2;
            }
            String str4 = (String) linkedList.pop();
            if (str4 != null) {
                switch (str4.hashCode()) {
                    case -2147394086:
                        if (str4.equals("--grant-prefix-uri-permission")) {
                            intent3.addFlags(128);
                            Unit unit = Unit.INSTANCE;
                        }
                        break;
                    case -2118172637:
                        if (str4.equals("--activity-task-on-home")) {
                            intent3.addFlags(16384);
                            Unit unit2 = Unit.INSTANCE;
                        }
                        break;
                    case -1630559130:
                        if (str4.equals("--activity-no-history")) {
                            intent3.addFlags(Ints.MAX_POWER_OF_TWO);
                            Unit unit3 = Unit.INSTANCE;
                        }
                        break;
                    case -1252939549:
                        if (str4.equals("--activity-clear-task")) {
                            intent3.addFlags(32768);
                            Unit unit4 = Unit.INSTANCE;
                        }
                        break;
                    case -1237221598:
                        if (!str4.equals("--display")) {
                        }
                        linkedList.pop();
                        Unit unit5 = Unit.INSTANCE;
                        break;
                    case -1200004030:
                        if (!str4.equals("--track-allocation")) {
                        }
                        Unit unit6 = Unit.INSTANCE;
                        break;
                    case -1175525740:
                        if (!str4.equals("--start-profiler")) {
                        }
                        linkedList.pop();
                        Unit unit7 = Unit.INSTANCE;
                        break;
                    case -1069446353:
                        if (str4.equals("--debug-log-resolution")) {
                            intent3.addFlags(8);
                            Unit unit8 = Unit.INSTANCE;
                        }
                        break;
                    case -849288499:
                        if (!str4.equals("--receiver-permission")) {
                        }
                        linkedList.pop();
                        Unit unit9 = Unit.INSTANCE;
                        break;
                    case -848214457:
                        if (str4.equals("--activity-reorder-to-front")) {
                            intent3.addFlags(131072);
                            Unit unit10 = Unit.INSTANCE;
                        }
                        break;
                    case -833172539:
                        if (str4.equals("--activity-brought-to-front")) {
                            intent3.addFlags(4194304);
                            Unit unit11 = Unit.INSTANCE;
                        }
                        break;
                    case -792169302:
                        if (str4.equals("--activity-previous-is-top")) {
                            intent3.addFlags(16777216);
                            Unit unit12 = Unit.INSTANCE;
                        }
                        break;
                    case -568831203:
                        if (!str4.equals("--attach-agent")) {
                        }
                        linkedList.pop();
                        Unit unit13 = Unit.INSTANCE;
                        break;
                    case -487759033:
                        if (!str4.equals("--lock-task")) {
                        }
                        Unit unit14 = Unit.INSTANCE;
                        break;
                    case -191661803:
                        if (!str4.equals("--windowingMode")) {
                        }
                        linkedList.pop();
                        Unit unit15 = Unit.INSTANCE;
                        break;
                    case 0:
                        if (!str4.equals("")) {
                        }
                        Unit unit16 = Unit.INSTANCE;
                        break;
                    case 1463:
                        if (!str4.equals("-D")) {
                        }
                        Unit unit17 = Unit.INSTANCE;
                        break;
                    case 1473:
                        if (!str4.equals("-N")) {
                        }
                        Unit unit18 = Unit.INSTANCE;
                        break;
                    case 1475:
                        if (!str4.equals("-P")) {
                        }
                        linkedList.pop();
                        Unit unit19 = Unit.INSTANCE;
                        break;
                    case 1477:
                        if (!str4.equals("-R")) {
                        }
                        linkedList.pop();
                        Unit unit110 = Unit.INSTANCE;
                        break;
                    case 1478:
                        if (!str4.equals("-S")) {
                        }
                        Unit unit111 = Unit.INSTANCE;
                        break;
                    case 1482:
                        if (!str4.equals("-W")) {
                        }
                        Unit unit112 = Unit.INSTANCE;
                        break;
                    case 1492:
                        if (str4.equals("-a")) {
                            intent3.setAction((String) linkedList.pop());
                            if (intent3 == intent2) {
                                z = true;
                            }
                            Unit unit20 = Unit.INSTANCE;
                        }
                        break;
                    case 1494:
                        if (str4.equals("-c")) {
                            intent3.addCategory((String) linkedList.pop());
                            if (intent3 == intent2) {
                                z = true;
                            }
                            Unit unit21 = Unit.INSTANCE;
                        }
                        break;
                    case 1495:
                        if (str4.equals("-d")) {
                            uri2 = Uri.parse((String) linkedList.pop());
                            if (intent3 == intent2) {
                                z = true;
                            }
                            Unit unit22 = Unit.INSTANCE;
                        }
                        break;
                    case 1496:
                        if (!str4.equals("-e")) {
                        }
                        intent3.putExtra((String) linkedList.pop(), (String) linkedList.pop());
                        Unit unit23 = Unit.INSTANCE;
                        break;
                    case 1497:
                        if (str4.equals("-f")) {
                            intent3.setFlags(Integer.decode((String) linkedList.pop()).intValue());
                            Unit unit24 = Unit.INSTANCE;
                        }
                        break;
                    case Constants.guaranteeSplashScreenMs /* 1500 */:
                        if (str4.equals("-i")) {
                            intent3.setIdentifier((String) linkedList.pop());
                            if (intent3 == intent2) {
                                z = true;
                            }
                            Unit unit25 = Unit.INSTANCE;
                        }
                        break;
                    case 1505:
                        if (str4.equals("-n")) {
                            String str5 = (String) linkedList.pop();
                            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str5);
                            if (componentNameUnflattenFromString == null) {
                                throw new IllegalArgumentException("Bad component name: " + str5);
                            }
                            intent3.setComponent(componentNameUnflattenFromString);
                            if (intent3 == intent2) {
                                z = true;
                            }
                            Unit unit26 = Unit.INSTANCE;
                        }
                        break;
                    case 1507:
                        if (str4.equals("-p")) {
                            intent3.setPackage((String) linkedList.pop());
                            if (intent3 == intent2) {
                                z = true;
                            }
                            Unit unit27 = Unit.INSTANCE;
                        }
                        break;
                    case 1511:
                        if (str4.equals("-t")) {
                            str = (String) linkedList.pop();
                            if (intent3 == intent2) {
                                z = true;
                            }
                            Unit unit28 = Unit.INSTANCE;
                        }
                        break;
                    case 1387073:
                        if (str4.equals("--ef")) {
                            String str6 = (String) linkedList.pop();
                            Float fValueOf = Float.valueOf((String) linkedList.pop());
                            Intrinsics.checkNotNullExpressionValue(fValueOf, "valueOf(...)");
                            intent3.putExtra(str6, fValueOf.floatValue());
                            Unit unit29 = Unit.INSTANCE;
                            z = true;
                        }
                        break;
                    case 1387076:
                        if (str4.equals("--ei")) {
                            String str7 = (String) linkedList.pop();
                            Integer numDecode = Integer.decode((String) linkedList.pop());
                            Intrinsics.checkNotNullExpressionValue(numDecode, "decode(...)");
                            intent3.putExtra(str7, numDecode.intValue());
                            Unit unit30 = Unit.INSTANCE;
                        }
                        break;
                    case 1387079:
                        if (str4.equals("--el")) {
                            String str8 = (String) linkedList.pop();
                            Long lValueOf = Long.valueOf((String) linkedList.pop());
                            Intrinsics.checkNotNullExpressionValue(lValueOf, "valueOf(...)");
                            intent3.putExtra(str8, lValueOf.longValue());
                            Unit unit31 = Unit.INSTANCE;
                        }
                        break;
                    case 1387086:
                        if (!str4.equals("--es")) {
                        }
                        intent3.putExtra((String) linkedList.pop(), (String) linkedList.pop());
                        Unit unit210 = Unit.INSTANCE;
                        break;
                    case 1387088:
                        if (str4.equals("--eu")) {
                            intent3.putExtra((String) linkedList.pop(), Uri.parse((String) linkedList.pop()));
                            Unit unit32 = Unit.INSTANCE;
                        }
                        break;
                    case 1387093:
                        if (str4.equals("--ez")) {
                            String str9 = (String) linkedList.pop();
                            Object objPop = linkedList.pop();
                            Intrinsics.checkNotNullExpressionValue(objPop, "pop(...)");
                            Locale locale = Locale.getDefault();
                            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                            String lowerCase = ((String) objPop).toLowerCase(locale);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            if (!Intrinsics.areEqual("true", lowerCase) && !Intrinsics.areEqual("t", lowerCase)) {
                                if (Intrinsics.areEqual("false", lowerCase) || Intrinsics.areEqual("f", lowerCase)) {
                                    z2 = false;
                                } else {
                                    try {
                                        Integer numDecode2 = Integer.decode(lowerCase);
                                        if (numDecode2 != null && numDecode2.intValue() == 0) {
                                            z2 = false;
                                        }
                                    } catch (NumberFormatException unused) {
                                        throw new IllegalArgumentException("Invalid boolean value: " + lowerCase);
                                    }
                                }
                            }
                            intent3.putExtra(str9, z2);
                            Unit unit33 = Unit.INSTANCE;
                        }
                        break;
                    case 35286153:
                        if (!str4.equals("--activityType")) {
                        }
                        linkedList.pop();
                        Unit unit113 = Unit.INSTANCE;
                        break;
                    case 42999280:
                        if (str4.equals("--ecn")) {
                            String str10 = (String) linkedList.pop();
                            String str11 = (String) linkedList.pop();
                            ComponentName componentNameUnflattenFromString2 = ComponentName.unflattenFromString(str11);
                            if (componentNameUnflattenFromString2 == null) {
                                throw new IllegalArgumentException("Bad component name: " + str11);
                            }
                            intent3.putExtra(str10, componentNameUnflattenFromString2);
                            Unit unit34 = Unit.INSTANCE;
                        }
                        break;
                    case 42999360:
                        if (str4.equals("--efa")) {
                            String str12 = (String) linkedList.pop();
                            String str13 = (String) linkedList.pop();
                            Intrinsics.checkNotNull(str13);
                            String[] strArr = (String[]) StringsKt.split$default((CharSequence) str13, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
                            float[] fArr = new float[strArr.length];
                            for (int i2 = 0; i2 < strArr.length; i2++) {
                                Float fValueOf2 = Float.valueOf(strArr[i2]);
                                Intrinsics.checkNotNullExpressionValue(fValueOf2, "valueOf(...)");
                                fArr[i2] = fValueOf2.floatValue();
                            }
                            intent3.putExtra(str12, fArr);
                            Unit unit35 = Unit.INSTANCE;
                            z = true;
                        }
                        break;
                    case 42999453:
                        if (str4.equals("--eia")) {
                            String str14 = (String) linkedList.pop();
                            String str15 = (String) linkedList.pop();
                            Intrinsics.checkNotNull(str15);
                            String[] strArr2 = (String[]) StringsKt.split$default((CharSequence) str15, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
                            int[] iArr = new int[strArr2.length];
                            for (int i3 = 0; i3 < strArr2.length; i3++) {
                                Integer numDecode3 = Integer.decode(strArr2[i3]);
                                Intrinsics.checkNotNullExpressionValue(numDecode3, "decode(...)");
                                iArr[i3] = numDecode3.intValue();
                            }
                            intent3.putExtra(str14, iArr);
                            Unit unit36 = Unit.INSTANCE;
                        }
                        break;
                    case 42999546:
                        if (str4.equals("--ela")) {
                            String str16 = (String) linkedList.pop();
                            String str17 = (String) linkedList.pop();
                            Intrinsics.checkNotNull(str17);
                            String[] strArr3 = (String[]) StringsKt.split$default((CharSequence) str17, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
                            long[] jArr = new long[strArr3.length];
                            for (int i4 = 0; i4 < strArr3.length; i4++) {
                                Long lValueOf2 = Long.valueOf(strArr3[i4]);
                                Intrinsics.checkNotNullExpressionValue(lValueOf2, "valueOf(...)");
                                jArr[i4] = lValueOf2.longValue();
                            }
                            intent3.putExtra(str16, jArr);
                            Unit unit37 = Unit.INSTANCE;
                            z = true;
                        }
                        break;
                    case 42999763:
                        if (str4.equals("--esa")) {
                            String str18 = (String) linkedList.pop();
                            String str19 = (String) linkedList.pop();
                            Intrinsics.checkNotNull(str19);
                            intent3.putExtra(str18, (String[]) new Regex("(?<!\\\\),").split(str19, 0).toArray(new String[0]));
                            Unit unit38 = Unit.INSTANCE;
                            z = true;
                        }
                        break;
                    case 42999776:
                        if (str4.equals("--esn")) {
                            intent3.putExtra((String) linkedList.pop(), (String) null);
                            Unit unit39 = Unit.INSTANCE;
                        }
                        break;
                    case 69120454:
                        if (str4.equals("--activity-exclude-from-recents")) {
                            intent3.addFlags(8388608);
                            Unit unit40 = Unit.INSTANCE;
                        }
                        break;
                    case 88747734:
                        if (str4.equals("--activity-no-animation")) {
                            intent3.addFlags(65536);
                            Unit unit41 = Unit.INSTANCE;
                        }
                        break;
                    case 122182893:
                        if (!str4.equals("--attach-agent-bind")) {
                        }
                        linkedList.pop();
                        Unit unit114 = Unit.INSTANCE;
                        break;
                    case 172779202:
                        if (!str4.equals("--streaming")) {
                        }
                        Unit unit115 = Unit.INSTANCE;
                        break;
                    case 190913209:
                        if (str4.equals("--activity-reset-task-if-needed")) {
                            intent3.addFlags(2097152);
                            Unit unit42 = Unit.INSTANCE;
                        }
                        break;
                    case 236677687:
                        if (str4.equals("--activity-clear-top")) {
                            intent3.addFlags(67108864);
                            Unit unit43 = Unit.INSTANCE;
                        }
                        break;
                    case 429439306:
                        if (str4.equals("--activity-no-user-action")) {
                            intent3.addFlags(262144);
                            Unit unit44 = Unit.INSTANCE;
                        }
                        break;
                    case 436286937:
                        if (str4.equals("--receiver-registered-only")) {
                            intent3.addFlags(Ints.MAX_POWER_OF_TWO);
                            Unit unit45 = Unit.INSTANCE;
                        }
                        break;
                    case 438531630:
                        if (str4.equals("--activity-single-top")) {
                            intent3.addFlags(536870912);
                            Unit unit46 = Unit.INSTANCE;
                        }
                        break;
                    case 527014976:
                        if (str4.equals("--grant-persistable-uri-permission")) {
                            intent3.addFlags(64);
                            Unit unit47 = Unit.INSTANCE;
                        }
                        break;
                    case 580418080:
                        if (str4.equals("--exclude-stopped-packages")) {
                            intent3.addFlags(16);
                            Unit unit48 = Unit.INSTANCE;
                        }
                        break;
                    case 749648146:
                        if (str4.equals("--include-stopped-packages")) {
                            intent3.addFlags(32);
                            Unit unit49 = Unit.INSTANCE;
                        }
                        break;
                    case 775126336:
                        if (str4.equals("--receiver-replace-pending")) {
                            intent3.addFlags(536870912);
                            Unit unit50 = Unit.INSTANCE;
                        }
                        break;
                    case 1061985704:
                        if (!str4.equals("--task-overlay")) {
                        }
                        Unit unit116 = Unit.INSTANCE;
                        break;
                    case 1110195121:
                        if (str4.equals("--activity-match-external")) {
                            intent3.addFlags(2048);
                            Unit unit51 = Unit.INSTANCE;
                        }
                        break;
                    case 1207327103:
                        if (str4.equals("--selector")) {
                            intent3.setDataAndType(uri2, str);
                            intent3 = new Intent();
                            Unit unit52 = Unit.INSTANCE;
                        }
                        break;
                    case 1332980268:
                        if (str4.equals("--efal")) {
                            String str20 = (String) linkedList.pop();
                            String str21 = (String) linkedList.pop();
                            Intrinsics.checkNotNull(str21);
                            String[] strArr4 = (String[]) StringsKt.split$default((CharSequence) str21, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
                            ArrayList arrayList3 = new ArrayList(strArr4.length);
                            for (String str22 : strArr4) {
                                arrayList3.add(Float.valueOf(str22));
                            }
                            intent3.putExtra(str20, arrayList3);
                            Unit unit53 = Unit.INSTANCE;
                            z = true;
                        }
                        break;
                    case 1332983151:
                        if (str4.equals("--eial")) {
                            String str23 = (String) linkedList.pop();
                            String str24 = (String) linkedList.pop();
                            Intrinsics.checkNotNull(str24);
                            String[] strArr5 = (String[]) StringsKt.split$default((CharSequence) str24, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
                            ArrayList arrayList4 = new ArrayList(strArr5.length);
                            for (String str25 : strArr5) {
                                arrayList4.add(Integer.decode(str25));
                            }
                            intent3.putExtra(str23, arrayList4);
                            Unit unit54 = Unit.INSTANCE;
                        }
                        break;
                    case 1332986034:
                        if (str4.equals("--elal")) {
                            String str26 = (String) linkedList.pop();
                            String str27 = (String) linkedList.pop();
                            Intrinsics.checkNotNull(str27);
                            String[] strArr6 = (String[]) StringsKt.split$default((CharSequence) str27, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
                            ArrayList arrayList5 = new ArrayList(strArr6.length);
                            for (String str28 : strArr6) {
                                arrayList5.add(Long.valueOf(str28));
                            }
                            intent3.putExtra(str26, arrayList5);
                            Unit unit55 = Unit.INSTANCE;
                            z = true;
                        }
                        break;
                    case 1332992761:
                        if (str4.equals("--esal")) {
                            String str29 = (String) linkedList.pop();
                            String str30 = (String) linkedList.pop();
                            Intrinsics.checkNotNull(str30);
                            String[] strArr7 = (String[]) new Regex("(?<!\\\\),").split(str30, 0).toArray(new String[0]);
                            ArrayList arrayList6 = new ArrayList(strArr7.length);
                            for (String str31 : strArr7) {
                                arrayList6.add(str31);
                            }
                            intent3.putExtra(str29, arrayList6);
                            Unit unit56 = Unit.INSTANCE;
                            z = true;
                        }
                        break;
                    case 1333422885:
                        if (!str4.equals("--task")) {
                        }
                        linkedList.pop();
                        Unit unit117 = Unit.INSTANCE;
                        break;
                    case 1333469547:
                        if (!str4.equals("--user")) {
                        }
                        linkedList.pop();
                        Unit unit118 = Unit.INSTANCE;
                        break;
                    case 1353919836:
                        if (str4.equals("--activity-clear-when-task-reset")) {
                            intent3.addFlags(524288);
                            Unit unit57 = Unit.INSTANCE;
                        }
                        break;
                    case 1398403374:
                        if (str4.equals("--activity-launched-from-history")) {
                            intent3.addFlags(1048576);
                            Unit unit58 = Unit.INSTANCE;
                        }
                        break;
                    case 1453225122:
                        if (str4.equals("--receiver-no-abort")) {
                            intent3.addFlags(134217728);
                            Unit unit59 = Unit.INSTANCE;
                        }
                        break;
                    case 1623312596:
                        if (!str4.equals("--allow-background-activity-starts")) {
                        }
                        Unit unit119 = Unit.INSTANCE;
                        break;
                    case 1652786753:
                        if (str4.equals("--receiver-foreground")) {
                            intent3.addFlags(268435456);
                            Unit unit60 = Unit.INSTANCE;
                        }
                        break;
                    case 1742380566:
                        if (str4.equals("--grant-read-uri-permission")) {
                            intent3.addFlags(1);
                            Unit unit61 = Unit.INSTANCE;
                        }
                        break;
                    case 1765369476:
                        if (str4.equals("--activity-multiple-task")) {
                            intent3.addFlags(134217728);
                            Unit unit62 = Unit.INSTANCE;
                        }
                        break;
                    case 1816558127:
                        if (str4.equals("--grant-write-uri-permission")) {
                            intent3.addFlags(2);
                            Unit unit63 = Unit.INSTANCE;
                        }
                        break;
                    case 1991325063:
                        if (!str4.equals("--sampling")) {
                        }
                        linkedList.pop();
                        Unit unit1110 = Unit.INSTANCE;
                        break;
                    default:
                        break;
                }
            }
            throw new IllegalArgumentException("Unknown option: " + str4);
        }
    }
}
