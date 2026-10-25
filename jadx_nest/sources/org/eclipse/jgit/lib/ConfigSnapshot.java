package org.eclipse.jgit.lib;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.jgit.util.StringUtils;

/* JADX INFO: loaded from: classes5.dex */
class ConfigSnapshot {
    final ConfigSnapshot baseState;
    final Map<Object, Object> cache = new ConcurrentHashMap(16, 0.75f, 1);
    final List<ConfigLine> entryList;
    volatile SectionNames names;
    volatile List<ConfigLine> sorted;

    ConfigSnapshot(List<ConfigLine> list, ConfigSnapshot configSnapshot) {
        this.entryList = list;
        this.baseState = configSnapshot;
    }

    Set<String> getSections() {
        return names().sections;
    }

    Set<String> getSubsections(String str) {
        Map<String, Set<String>> map = names().subsections;
        Set<String> set = map.get(str);
        if (set == null) {
            set = map.get(StringUtils.toLowerCase(str));
        }
        if (set == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(set);
    }

    Set<String> getNames(String str, String str2) {
        return getNames(str, str2, false);
    }

    Set<String> getNames(String str, String str2, boolean z) {
        return new CaseFoldingSet(getNamesInternal(str, str2, z));
    }

    private Map<String, String> getNamesInternal(String str, String str2, boolean z) {
        ConfigSnapshot configSnapshot;
        List<ConfigLine> listSorted = sorted();
        int iFind = find(listSorted, str, str2, "");
        if (iFind < 0) {
            iFind = -(iFind + 1);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (iFind < listSorted.size()) {
            int i = iFind + 1;
            ConfigLine configLine = listSorted.get(iFind);
            if (!configLine.match(str, str2)) {
                break;
            }
            if (configLine.name != null) {
                String lowerCase = StringUtils.toLowerCase(configLine.name);
                if (!linkedHashMap.containsKey(lowerCase)) {
                    linkedHashMap.put(lowerCase, configLine.name);
                }
            }
            iFind = i;
        }
        if (z && (configSnapshot = this.baseState) != null) {
            linkedHashMap.putAll(configSnapshot.getNamesInternal(str, str2, z));
        }
        return linkedHashMap;
    }

    String[] get(String str, String str2, String str3) {
        List<ConfigLine> listSorted = sorted();
        int iFind = find(listSorted, str, str2, str3);
        if (iFind < 0) {
            return null;
        }
        int iEnd = end(listSorted, iFind, str, str2, str3);
        String[] strArr = new String[iEnd - iFind];
        int i = 0;
        while (iFind < iEnd) {
            strArr[i] = listSorted.get(iFind).value;
            i++;
            iFind++;
        }
        return strArr;
    }

    private int find(List<ConfigLine> list, String str, String str2, String str3) {
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = (i + size) >>> 1;
            ConfigLine configLine = list.get(i2);
            int iCompare2 = compare2(str, str2, str3, configLine.section, configLine.subsection, configLine.name);
            if (iCompare2 < 0) {
                size = i2;
            } else {
                if (iCompare2 == 0) {
                    return first(list, i2, str, str2, str3);
                }
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    private int first(List<ConfigLine> list, int i, String str, String str2, String str3) {
        while (i > 0 && list.get(i - 1).match(str, str2, str3)) {
            i--;
        }
        return i;
    }

    private int end(List<ConfigLine> list, int i, String str, String str2, String str3) {
        while (i < list.size() && list.get(i).match(str, str2, str3)) {
            i++;
        }
        return i;
    }

    private List<ConfigLine> sorted() {
        List<ConfigLine> list = this.sorted;
        if (list != null) {
            return list;
        }
        List<ConfigLine> listSort = sort(this.entryList);
        this.sorted = listSort;
        return listSort;
    }

    private static List<ConfigLine> sort(List<ConfigLine> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (ConfigLine configLine : list) {
            if (configLine.section != null && configLine.name != null) {
                arrayList.add(configLine);
            }
        }
        Collections.sort(arrayList, new LineComparator(null));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int compare2(String str, String str2, String str3, String str4, String str5, String str6) {
        int iCompareWithCase;
        int iCompareIgnoreCase = StringUtils.compareIgnoreCase(str, str4);
        if (iCompareIgnoreCase != 0) {
            return iCompareIgnoreCase;
        }
        if (str2 == null && str5 != null) {
            return -1;
        }
        if (str2 == null || str5 != null) {
            return (str2 == null || (iCompareWithCase = StringUtils.compareWithCase(str2, str5)) == 0) ? StringUtils.compareIgnoreCase(str3, str6) : iCompareWithCase;
        }
        return 1;
    }

    private static class LineComparator implements Comparator<ConfigLine> {
        /* synthetic */ LineComparator(ConfigSnapshotIA configSnapshotIA) {
            this();
        }

        private LineComparator() {
        }

        @Override // java.util.Comparator
        public int compare(ConfigLine configLine, ConfigLine configLine2) {
            return ConfigSnapshot.compare2(configLine.section, configLine.subsection, configLine.name, configLine2.section, configLine2.subsection, configLine2.name);
        }
    }

    private SectionNames names() {
        SectionNames sectionNames = this.names;
        if (sectionNames != null) {
            return sectionNames;
        }
        SectionNames sectionNames2 = new SectionNames(this);
        this.names = sectionNames2;
        return sectionNames2;
    }

    private static class SectionNames {
        final CaseFoldingSet sections;
        final Map<String, Set<String>> subsections;

        SectionNames(ConfigSnapshot configSnapshot) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            HashMap map = new HashMap();
            while (configSnapshot != null) {
                for (ConfigLine configLine : configSnapshot.entryList) {
                    if (configLine.section != null) {
                        String lowerCase = StringUtils.toLowerCase(configLine.section);
                        if (!linkedHashMap.containsKey(lowerCase)) {
                            linkedHashMap.put(lowerCase, configLine.section);
                        }
                        if (configLine.subsection != null) {
                            Set linkedHashSet = (Set) map.get(lowerCase);
                            if (linkedHashSet == null) {
                                linkedHashSet = new LinkedHashSet();
                                map.put(lowerCase, linkedHashSet);
                            }
                            linkedHashSet.add(configLine.subsection);
                        }
                    }
                }
                configSnapshot = configSnapshot.baseState;
            }
            this.sections = new CaseFoldingSet(linkedHashMap);
            this.subsections = map;
        }
    }

    private static class CaseFoldingSet extends AbstractSet<String> {
        private final Map<String, String> names;

        CaseFoldingSet(Map<String, String> map) {
            this.names = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof String)) {
                return false;
            }
            String str = (String) obj;
            return this.names.containsKey(str) || this.names.containsKey(StringUtils.toLowerCase(str));
        }

        /* JADX INFO: renamed from: org.eclipse.jgit.lib.ConfigSnapshot$CaseFoldingSet$1, reason: invalid class name */
        class AnonymousClass1 implements Iterator<String> {
            private final /* synthetic */ Iterator val$i;

            AnonymousClass1(Iterator it) {
                this.val$i = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.val$i.hasNext();
            }

            @Override // java.util.Iterator
            public String next() {
                return (String) this.val$i.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<String> iterator() {
            return new AnonymousClass1(this.names.values().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.names.size();
        }
    }
}
