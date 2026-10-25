package org.eclipse.jgit.merge;

import com.magneticchen.daijishou.daijishou_player.DaijishouPlayerTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.util.ChangeIdUtil;
import org.eclipse.jgit.util.StringUtils;

/* JADX INFO: loaded from: classes5.dex */
public class MergeMessageFormatter {
    public String format(List<Ref> list, Ref ref) {
        StringBuilder sb = new StringBuilder("Merge ");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        for (Ref ref2 : list) {
            if (ref2.getName().startsWith(Constants.R_HEADS)) {
                arrayList.add("'" + Repository.shortenRefName(ref2.getName()) + "'");
            } else if (ref2.getName().startsWith(Constants.R_REMOTES)) {
                arrayList2.add("'" + Repository.shortenRefName(ref2.getName()) + "'");
            } else if (ref2.getName().startsWith(Constants.R_TAGS)) {
                arrayList3.add("'" + Repository.shortenRefName(ref2.getName()) + "'");
            } else {
                ObjectId objectId = ref2.getObjectId();
                if (objectId != null && ref2.getName().equals(objectId.getName())) {
                    arrayList4.add("'" + ref2.getName() + "'");
                } else {
                    arrayList5.add(ref2.getName());
                }
            }
        }
        ArrayList arrayList6 = new ArrayList();
        if (!arrayList.isEmpty()) {
            arrayList6.add(joinNames(arrayList, ConfigConstants.CONFIG_BRANCH_SECTION, "branches"));
        }
        if (!arrayList2.isEmpty()) {
            arrayList6.add(joinNames(arrayList2, "remote-tracking branch", "remote-tracking branches"));
        }
        if (!arrayList3.isEmpty()) {
            arrayList6.add(joinNames(arrayList3, "tag", DaijishouPlayerTemplate.templateTagPrefix));
        }
        if (!arrayList4.isEmpty()) {
            arrayList6.add(joinNames(arrayList4, "commit", "commits"));
        }
        if (!arrayList5.isEmpty()) {
            arrayList6.add(StringUtils.join(arrayList5, ", ", " and "));
        }
        sb.append(StringUtils.join(arrayList6, ", "));
        String name = ref.getLeaf().getName();
        if (!name.equals("refs/heads/master")) {
            sb.append(" into " + Repository.shortenRefName(name));
        }
        return sb.toString();
    }

    public String formatWithConflicts(String str, Iterable<String> iterable, char c) {
        StringBuilder sb = new StringBuilder();
        String[] strArrSplit = str.split("\n");
        int iIndexOfFirstFooterLine = ChangeIdUtil.indexOfFirstFooterLine(strArrSplit);
        for (int i = 0; i < iIndexOfFirstFooterLine; i++) {
            sb.append(strArrSplit[i]).append('\n');
        }
        if (iIndexOfFirstFooterLine == strArrSplit.length && str.length() != 0) {
            sb.append('\n');
        }
        addConflictsMessage(iterable, sb, c);
        if (iIndexOfFirstFooterLine < strArrSplit.length) {
            sb.append('\n');
        }
        while (iIndexOfFirstFooterLine < strArrSplit.length) {
            sb.append(strArrSplit[iIndexOfFirstFooterLine]).append('\n');
            iIndexOfFirstFooterLine++;
        }
        return sb.toString();
    }

    private static void addConflictsMessage(Iterable<String> iterable, StringBuilder sb, char c) {
        sb.append(c).append(" Conflicts:\n");
        Iterator<String> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(c).append('\t').append(it.next()).append('\n');
        }
    }

    private static String joinNames(List<String> list, String str, String str2) {
        if (list.size() == 1) {
            return str + " " + list.get(0);
        }
        return str2 + " " + StringUtils.join(list, ", ", " and ");
    }
}
