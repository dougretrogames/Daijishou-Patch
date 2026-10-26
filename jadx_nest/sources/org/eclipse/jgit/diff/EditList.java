package org.eclipse.jgit.diff;

import java.util.ArrayList;

/* INFO: loaded from: classes5.dex */
public class EditList extends ArrayList<Edit> {
    private static final long serialVersionUID = 1;

    public static EditList singleton(Edit edit) {
        EditList editList = new EditList(1);
        editList.add(edit);
        return editList;
    }

    public EditList() {
        super(16);
    }

    public EditList(int i) {
        super(i);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return "EditList" + super.toString();
    }
}
