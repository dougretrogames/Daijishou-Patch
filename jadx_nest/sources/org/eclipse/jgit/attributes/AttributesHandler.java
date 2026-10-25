package org.eclipse.jgit.attributes;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.dircache.DirCacheIterator;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.treewalk.AbstractTreeIterator;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.WorkingTreeIterator;

/* JADX INFO: loaded from: classes5.dex */
public class AttributesHandler {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$attributes$Attribute$State = null;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$treewalk$TreeWalk$OperationType = null;
    private static final List<Attribute> BINARY_RULE_ATTRIBUTES = new AttributesRule("[attr]binary", "-diff -merge -text").getAttributes();
    private static final String BINARY_RULE_KEY = "binary";
    private static final String MACRO_PREFIX = "[attr]";
    private final Supplier<CanonicalTreeParser> attributesTree;
    private final Map<String, List<Attribute>> expansions;
    private final AttributesNode globalNode;
    private final AttributesNode infoNode;
    private final TreeWalk treeWalk;

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$attributes$Attribute$State() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$attributes$Attribute$State;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[Attribute.State.valuesCustom().length];
        try {
            iArr2[Attribute.State.CUSTOM.ordinal()] = 4;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[Attribute.State.SET.ordinal()] = 1;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[Attribute.State.UNSET.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[Attribute.State.UNSPECIFIED.ordinal()] = 3;
        } catch (NoSuchFieldError unused4) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$attributes$Attribute$State = iArr2;
        return iArr2;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$treewalk$TreeWalk$OperationType() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$treewalk$TreeWalk$OperationType;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[TreeWalk.OperationType.valuesCustom().length];
        try {
            iArr2[TreeWalk.OperationType.CHECKIN_OP.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[TreeWalk.OperationType.CHECKOUT_OP.ordinal()] = 1;
        } catch (NoSuchFieldError unused2) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$treewalk$TreeWalk$OperationType = iArr2;
        return iArr2;
    }

    @Deprecated
    public AttributesHandler(TreeWalk treeWalk) throws IOException {
        this(treeWalk, new AttributesHandler$$ExternalSyntheticLambda0(treeWalk));
    }

    static /* synthetic */ CanonicalTreeParser lambda$0(TreeWalk treeWalk) {
        return (CanonicalTreeParser) treeWalk.getTree(CanonicalTreeParser.class);
    }

    public AttributesHandler(TreeWalk treeWalk, Supplier<CanonicalTreeParser> supplier) throws IOException {
        HashMap map = new HashMap();
        this.expansions = map;
        this.treeWalk = treeWalk;
        this.attributesTree = supplier;
        AttributesNodeProvider attributesNodeProvider = treeWalk.getAttributesNodeProvider();
        AttributesNode globalAttributesNode = attributesNodeProvider != null ? attributesNodeProvider.getGlobalAttributesNode() : null;
        this.globalNode = globalAttributesNode;
        AttributesNode infoAttributesNode = attributesNodeProvider != null ? attributesNodeProvider.getInfoAttributesNode() : null;
        this.infoNode = infoAttributesNode;
        AttributesNode attributesNode = attributesNode(treeWalk, (WorkingTreeIterator) rootOf((WorkingTreeIterator) treeWalk.getTree(WorkingTreeIterator.class)), (DirCacheIterator) rootOf((DirCacheIterator) treeWalk.getTree(DirCacheIterator.class)), (CanonicalTreeParser) rootOf(supplier.get()));
        map.put("binary", BINARY_RULE_ATTRIBUTES);
        AttributesNode[] attributesNodeArr = {globalAttributesNode, attributesNode, infoAttributesNode};
        for (int i = 0; i < 3; i++) {
            AttributesNode attributesNode2 = attributesNodeArr[i];
            if (attributesNode2 != null) {
                for (AttributesRule attributesRule : attributesNode2.getRules()) {
                    if (attributesRule.getPattern().startsWith(MACRO_PREFIX)) {
                        this.expansions.put(attributesRule.getPattern().substring(MACRO_PREFIX.length()).trim(), attributesRule.getAttributes());
                    }
                }
            }
        }
    }

    public Attributes getAttributes() throws IOException {
        String pathString = this.treeWalk.getPathString();
        boolean z = this.treeWalk.getFileMode() == FileMode.TREE;
        Attributes attributes = new Attributes(new Attribute[0]);
        mergeInfoAttributes(pathString, z, attributes);
        mergePerDirectoryEntryAttributes(pathString, pathString.lastIndexOf(47), z, (WorkingTreeIterator) this.treeWalk.getTree(WorkingTreeIterator.class), (DirCacheIterator) this.treeWalk.getTree(DirCacheIterator.class), this.attributesTree.get(), attributes);
        mergeGlobalAttributes(pathString, z, attributes);
        for (Attribute attribute : attributes.getAll()) {
            if (attribute.getState() == Attribute.State.UNSPECIFIED) {
                attributes.remove(attribute.getKey());
            }
        }
        return attributes;
    }

    private void mergeGlobalAttributes(String str, boolean z, Attributes attributes) {
        mergeAttributes(this.globalNode, str, z, attributes);
    }

    private void mergeInfoAttributes(String str, boolean z, Attributes attributes) {
        mergeAttributes(this.infoNode, str, z, attributes);
    }

    private void mergePerDirectoryEntryAttributes(String str, int i, boolean z, @Nullable WorkingTreeIterator workingTreeIterator, @Nullable DirCacheIterator dirCacheIterator, @Nullable CanonicalTreeParser canonicalTreeParser, Attributes attributes) throws IOException {
        Attributes attributes2;
        if (workingTreeIterator == null && dirCacheIterator == null && canonicalTreeParser == null) {
            return;
        }
        AttributesNode attributesNode = attributesNode(this.treeWalk, workingTreeIterator, dirCacheIterator, canonicalTreeParser);
        if (attributesNode != null) {
            attributes2 = attributes;
            mergeAttributes(attributesNode, str.substring(i + 1), z, attributes2);
        } else {
            attributes2 = attributes;
        }
        mergePerDirectoryEntryAttributes(str, str.lastIndexOf(47, i - 1), z, (WorkingTreeIterator) parentOf(workingTreeIterator), (DirCacheIterator) parentOf(dirCacheIterator), (CanonicalTreeParser) parentOf(canonicalTreeParser), attributes2);
    }

    protected void mergeAttributes(@Nullable AttributesNode attributesNode, String str, boolean z, Attributes attributes) {
        if (attributesNode == null) {
            return;
        }
        List<AttributesRule> rules = attributesNode.getRules();
        ListIterator<AttributesRule> listIterator = rules.listIterator(rules.size());
        while (listIterator.hasPrevious()) {
            AttributesRule attributesRulePrevious = listIterator.previous();
            if (attributesRulePrevious.isMatch(str, z)) {
                ListIterator<Attribute> listIterator2 = attributesRulePrevious.getAttributes().listIterator(attributesRulePrevious.getAttributes().size());
                while (listIterator2.hasPrevious()) {
                    expandMacro(listIterator2.previous(), attributes);
                }
            }
        }
    }

    protected void expandMacro(Attribute attribute, Attributes attributes) {
        if (attributes.containsKey(attribute.getKey())) {
            return;
        }
        attributes.put(attribute);
        List<Attribute> list = this.expansions.get(attribute.getKey());
        if (list == null) {
            return;
        }
        int i = $SWITCH_TABLE$org$eclipse$jgit$attributes$Attribute$State()[attribute.getState().ordinal()];
        if (i == 2) {
            for (Attribute attribute2 : list) {
                int i2 = $SWITCH_TABLE$org$eclipse$jgit$attributes$Attribute$State()[attribute2.getState().ordinal()];
                if (i2 == 1) {
                    expandMacro(new Attribute(attribute2.getKey(), Attribute.State.UNSET), attributes);
                } else if (i2 == 2) {
                    expandMacro(new Attribute(attribute2.getKey(), Attribute.State.SET), attributes);
                } else if (i2 == 3) {
                    expandMacro(new Attribute(attribute2.getKey(), Attribute.State.UNSPECIFIED), attributes);
                } else {
                    expandMacro(attribute2, attributes);
                }
            }
            return;
        }
        if (i == 3) {
            Iterator<Attribute> it = list.iterator();
            while (it.hasNext()) {
                expandMacro(new Attribute(it.next().getKey(), Attribute.State.UNSPECIFIED), attributes);
            }
        } else {
            if (i == 4) {
                for (Attribute attribute3 : list) {
                    int i3 = $SWITCH_TABLE$org$eclipse$jgit$attributes$Attribute$State()[attribute3.getState().ordinal()];
                    if (i3 == 1 || i3 == 2 || i3 == 3) {
                        expandMacro(attribute3, attributes);
                    } else {
                        expandMacro(new Attribute(attribute3.getKey(), attribute.getValue()), attributes);
                    }
                }
                return;
            }
            Iterator<Attribute> it2 = list.iterator();
            while (it2.hasNext()) {
                expandMacro(it2.next(), attributes);
            }
        }
    }

    private static AttributesNode attributesNode(TreeWalk treeWalk, @Nullable WorkingTreeIterator workingTreeIterator, @Nullable DirCacheIterator dirCacheIterator, @Nullable CanonicalTreeParser canonicalTreeParser) throws IOException {
        AttributesNode entryAttributesNode;
        int i = $SWITCH_TABLE$org$eclipse$jgit$treewalk$TreeWalk$OperationType()[treeWalk.getOperationType().ordinal()];
        if (i == 1) {
            entryAttributesNode = canonicalTreeParser != null ? canonicalTreeParser.getEntryAttributesNode(treeWalk.getObjectReader()) : null;
            if (entryAttributesNode == null && dirCacheIterator != null) {
                entryAttributesNode = dirCacheIterator.getEntryAttributesNode(treeWalk.getObjectReader());
            }
            return (entryAttributesNode != null || workingTreeIterator == null) ? entryAttributesNode : workingTreeIterator.getEntryAttributesNode();
        }
        if (i == 2) {
            entryAttributesNode = workingTreeIterator != null ? workingTreeIterator.getEntryAttributesNode() : null;
            if (entryAttributesNode == null && dirCacheIterator != null) {
                entryAttributesNode = dirCacheIterator.getEntryAttributesNode(treeWalk.getObjectReader());
            }
            return (entryAttributesNode != null || canonicalTreeParser == null) ? entryAttributesNode : canonicalTreeParser.getEntryAttributesNode(treeWalk.getObjectReader());
        }
        throw new IllegalStateException("The only supported operation types are:" + String.valueOf(TreeWalk.OperationType.CHECKIN_OP) + CollectionUtils.COMMA + String.valueOf(TreeWalk.OperationType.CHECKOUT_OP));
    }

    private static <T extends AbstractTreeIterator> T parentOf(@Nullable T t) {
        if (t == null) {
            return null;
        }
        Class<?> cls = t.getClass();
        AbstractTreeIterator abstractTreeIterator = t.parent;
        if (cls.isInstance(abstractTreeIterator)) {
            return (T) cls.cast(abstractTreeIterator);
        }
        return null;
    }

    private static <T extends AbstractTreeIterator> T rootOf(@Nullable T t) {
        if (t == null) {
            return null;
        }
        AbstractTreeIterator abstractTreeIterator = t;
        while (abstractTreeIterator != null && abstractTreeIterator.parent != null) {
            abstractTreeIterator = abstractTreeIterator.parent;
        }
        Class<?> cls = t.getClass();
        if (cls.isInstance(abstractTreeIterator)) {
            return (T) cls.cast(abstractTreeIterator);
        }
        return null;
    }
}
