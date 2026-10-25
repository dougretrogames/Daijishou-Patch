package org.eclipse.jgit.treewalk;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import net.lingala.zip4j.util.InternalZipConstants;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.attributes.Attribute;
import org.eclipse.jgit.attributes.Attributes;
import org.eclipse.jgit.attributes.AttributesHandler;
import org.eclipse.jgit.attributes.AttributesNodeProvider;
import org.eclipse.jgit.attributes.AttributesProvider;
import org.eclipse.jgit.attributes.FilterCommandRegistry;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.errors.StopWalkException;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.BranchConfig;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.CoreConfig;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.MutableObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.treewalk.filter.PathFilter;
import org.eclipse.jgit.treewalk.filter.TreeFilter;
import org.eclipse.jgit.util.QuotedString;
import org.eclipse.jgit.util.RawParseUtils;
import org.eclipse.jgit.util.io.EolStreamTypeUtil;

/* JADX INFO: loaded from: classes5.dex */
public class TreeWalk implements AutoCloseable, AttributesProvider {
    private static final AbstractTreeIterator[] NO_TREES = new AbstractTreeIterator[0];
    private boolean advance;
    private AttributesHandler[] attributesHandlers;
    private AttributesNodeProvider attributesNodeProvider;
    private Attributes[] attrs;
    private final boolean closeReader;
    private Config config;
    AbstractTreeIterator currentHead;
    int depth;
    private TreeFilter filter;
    private Set<String> filterCommands;
    private Map<String, String> filterCommandsByNameDotType;
    private int headIndex;
    private final MutableObjectId idBuffer;
    private OperationType operationType;
    private boolean postChildren;
    private boolean postOrderTraversal;
    private final ObjectReader reader;
    private boolean recursive;
    AbstractTreeIterator[] trees;

    public enum OperationType {
        CHECKOUT_OP,
        CHECKIN_OP;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static OperationType[] valuesCustom() {
            OperationType[] operationTypeArrValuesCustom = values();
            int length = operationTypeArrValuesCustom.length;
            OperationType[] operationTypeArr = new OperationType[length];
            System.arraycopy(operationTypeArrValuesCustom, 0, operationTypeArr, 0, length);
            return operationTypeArr;
        }
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public static TreeWalk forPath(ObjectReader objectReader, String str, AnyObjectId... anyObjectIdArr) throws IOException {
        return forPath(null, objectReader, str, anyObjectIdArr);
    }

    public static TreeWalk forPath(@Nullable Repository repository, ObjectReader objectReader, String str, AnyObjectId... anyObjectIdArr) throws IOException {
        TreeWalk treeWalk = new TreeWalk(repository, objectReader);
        PathFilter pathFilterCreate = PathFilter.create(str);
        treeWalk.setFilter(pathFilterCreate);
        treeWalk.reset(anyObjectIdArr);
        treeWalk.setRecursive(false);
        while (treeWalk.next()) {
            if (pathFilterCreate.isDone(treeWalk)) {
                return treeWalk;
            }
            if (treeWalk.isSubtree()) {
                treeWalk.enterSubtree();
            }
        }
        return null;
    }

    public static TreeWalk forPath(Repository repository, String str, AnyObjectId... anyObjectIdArr) throws IOException {
        Throwable th = null;
        try {
            ObjectReader objectReaderNewObjectReader = repository.newObjectReader();
            try {
                return forPath(repository, objectReaderNewObjectReader, str, anyObjectIdArr);
            } finally {
                if (objectReaderNewObjectReader != null) {
                    objectReaderNewObjectReader.close();
                }
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                th.addSuppressed(th2);
            }
            throw null;
        }
    }

    public static TreeWalk forPath(Repository repository, String str, RevTree revTree) throws IOException {
        return forPath(repository, str, revTree);
    }

    public TreeWalk(Repository repository) {
        this(repository, repository.newObjectReader(), true);
    }

    public TreeWalk(@Nullable Repository repository, ObjectReader objectReader) {
        this(repository, objectReader, false);
    }

    public TreeWalk(ObjectReader objectReader) {
        this(null, objectReader, false);
    }

    private TreeWalk(@Nullable Repository repository, ObjectReader objectReader, boolean z) {
        this.operationType = OperationType.CHECKOUT_OP;
        this.filterCommandsByNameDotType = new HashMap();
        this.idBuffer = new MutableObjectId();
        this.headIndex = -1;
        if (repository != null) {
            this.config = repository.getConfig();
            this.attributesNodeProvider = repository.createAttributesNodeProvider();
            this.filterCommands = FilterCommandRegistry.getRegisteredFilterCommands();
        } else {
            this.config = null;
            this.attributesNodeProvider = null;
        }
        this.reader = objectReader;
        this.filter = TreeFilter.ALL;
        this.trees = NO_TREES;
        this.closeReader = z;
    }

    public ObjectReader getObjectReader() {
        return this.reader;
    }

    public OperationType getOperationType() {
        return this.operationType;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.closeReader) {
            this.reader.close();
        }
    }

    public TreeFilter getFilter() {
        return this.filter;
    }

    public void setFilter(TreeFilter treeFilter) {
        if (treeFilter == null) {
            treeFilter = TreeFilter.ALL;
        }
        this.filter = treeFilter;
    }

    public boolean isRecursive() {
        return this.recursive;
    }

    public void setRecursive(boolean z) {
        this.recursive = z;
    }

    public boolean isPostOrderTraversal() {
        return this.postOrderTraversal;
    }

    public void setPostOrderTraversal(boolean z) {
        this.postOrderTraversal = z;
    }

    public void setAttributesNodeProvider(AttributesNodeProvider attributesNodeProvider) {
        this.attributesNodeProvider = attributesNodeProvider;
    }

    public AttributesNodeProvider getAttributesNodeProvider() {
        return this.attributesNodeProvider;
    }

    public void setHead(int i) {
        if (i < 0 || i >= this.trees.length) {
            throw new IllegalArgumentException("Head index " + i + " out of range [0," + this.trees.length + ")");
        }
        this.headIndex = i;
    }

    @Override // org.eclipse.jgit.attributes.AttributesProvider
    public Attributes getAttributes() {
        return getAttributes(this.headIndex);
    }

    public Attributes getAttributes(int i) {
        int i2 = i + 1;
        Attributes attributes = this.attrs[i2];
        if (attributes != null) {
            return attributes;
        }
        if (this.attributesNodeProvider == null) {
            throw new IllegalStateException("The tree walk should have one AttributesNodeProvider set in order to compute the git attributes.");
        }
        try {
            AttributesHandler attributesHandler = this.attributesHandlers[i2];
            if (attributesHandler == null) {
                if (i < 0) {
                    attributesHandler = new AttributesHandler(this, new TreeWalk$$ExternalSyntheticLambda0(this));
                } else {
                    attributesHandler = new AttributesHandler(this, new TreeWalk$$ExternalSyntheticLambda1(this, i));
                }
                this.attributesHandlers[i2] = attributesHandler;
            }
            Attributes attributes2 = attributesHandler.getAttributes();
            this.attrs[i2] = attributes2;
            return attributes2;
        } catch (IOException e) {
            throw new JGitInternalException("Error while parsing attributes", e);
        }
    }

    /* JADX INFO: renamed from: lambda$0$org-eclipse-jgit-treewalk-TreeWalk, reason: not valid java name */
    /* synthetic */ CanonicalTreeParser m5853lambda$0$orgeclipsejgittreewalkTreeWalk() {
        return (CanonicalTreeParser) getTree(CanonicalTreeParser.class);
    }

    /* JADX INFO: renamed from: lambda$1$org-eclipse-jgit-treewalk-TreeWalk, reason: not valid java name */
    /* synthetic */ CanonicalTreeParser m5854lambda$1$orgeclipsejgittreewalkTreeWalk(int i) {
        AbstractTreeIterator abstractTreeIterator = this.trees[i];
        if (abstractTreeIterator instanceof CanonicalTreeParser) {
            return (CanonicalTreeParser) abstractTreeIterator;
        }
        return null;
    }

    @Nullable
    public CoreConfig.EolStreamType getEolStreamType(OperationType operationType) {
        Config config;
        if (this.attributesNodeProvider == null || (config = this.config) == null) {
            return null;
        }
        if (operationType == null) {
            operationType = this.operationType;
        }
        return EolStreamTypeUtil.detectStreamType(operationType, (WorkingTreeOptions) config.get(WorkingTreeOptions.KEY), getAttributes());
    }

    @Nullable
    public CoreConfig.EolStreamType getCheckoutEolStreamType(int i) {
        if (this.attributesNodeProvider == null || this.config == null) {
            return null;
        }
        return EolStreamTypeUtil.detectStreamType(OperationType.CHECKOUT_OP, (WorkingTreeOptions) this.config.get(WorkingTreeOptions.KEY), getAttributes(i));
    }

    public void reset() {
        this.attrs = null;
        this.attributesHandlers = null;
        this.headIndex = -1;
        this.trees = NO_TREES;
        this.advance = false;
        this.depth = 0;
    }

    public void reset(AnyObjectId anyObjectId) throws IOException {
        AbstractTreeIterator[] abstractTreeIteratorArr = this.trees;
        if (abstractTreeIteratorArr.length == 1) {
            AbstractTreeIterator abstractTreeIterator = abstractTreeIteratorArr[0];
            while (abstractTreeIterator.parent != null) {
                abstractTreeIterator = abstractTreeIterator.parent;
            }
            if (abstractTreeIterator instanceof CanonicalTreeParser) {
                abstractTreeIterator.matches = null;
                abstractTreeIterator.matchShift = 0;
                ((CanonicalTreeParser) abstractTreeIterator).reset(this.reader, anyObjectId);
                this.trees[0] = abstractTreeIterator;
            } else {
                this.trees[0] = parserFor(anyObjectId);
            }
        } else {
            this.trees = new AbstractTreeIterator[]{parserFor(anyObjectId)};
        }
        this.advance = false;
        this.depth = 0;
        this.attrs = new Attributes[2];
        this.attributesHandlers = new AttributesHandler[2];
        this.headIndex = -1;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0055  */
    public void reset(AnyObjectId... anyObjectIdArr) throws IOException {
        AbstractTreeIterator[] abstractTreeIteratorArr = this.trees;
        int length = abstractTreeIteratorArr.length;
        int length2 = anyObjectIdArr.length;
        if (length2 != length) {
            abstractTreeIteratorArr = new AbstractTreeIterator[length2];
        }
        for (int i = 0; i < length2; i++) {
            if (i < length) {
                AbstractTreeIterator abstractTreeIterator = this.trees[i];
                while (abstractTreeIterator.parent != null) {
                    abstractTreeIterator = abstractTreeIterator.parent;
                }
                if ((abstractTreeIterator instanceof CanonicalTreeParser) && abstractTreeIterator.pathOffset == 0) {
                    abstractTreeIterator.matches = null;
                    abstractTreeIterator.matchShift = 0;
                    ((CanonicalTreeParser) abstractTreeIterator).reset(this.reader, anyObjectIdArr[i]);
                    abstractTreeIteratorArr[i] = abstractTreeIterator;
                } else {
                    abstractTreeIteratorArr[i] = parserFor(anyObjectIdArr[i]);
                }
            } else {
                abstractTreeIteratorArr[i] = parserFor(anyObjectIdArr[i]);
            }
        }
        this.trees = abstractTreeIteratorArr;
        this.advance = false;
        this.depth = 0;
        if (length == length2) {
            Arrays.fill(this.attrs, (Object) null);
            Arrays.fill(this.attributesHandlers, (Object) null);
        } else {
            int i2 = length2 + 1;
            this.attrs = new Attributes[i2];
            this.attributesHandlers = new AttributesHandler[i2];
        }
        this.headIndex = -1;
    }

    public int addTree(AnyObjectId anyObjectId) throws IOException {
        return addTree(parserFor(anyObjectId));
    }

    public int addTree(AbstractTreeIterator abstractTreeIterator) {
        AbstractTreeIterator[] abstractTreeIteratorArr = this.trees;
        int length = abstractTreeIteratorArr.length;
        AbstractTreeIterator[] abstractTreeIteratorArr2 = new AbstractTreeIterator[length + 1];
        System.arraycopy(abstractTreeIteratorArr, 0, abstractTreeIteratorArr2, 0, length);
        abstractTreeIteratorArr2[length] = abstractTreeIterator;
        abstractTreeIterator.matches = null;
        abstractTreeIterator.matchShift = 0;
        this.trees = abstractTreeIteratorArr2;
        Attributes[] attributesArr = this.attrs;
        if (attributesArr == null) {
            this.attrs = new Attributes[length + 2];
        } else {
            this.attrs = (Attributes[]) Arrays.copyOf(attributesArr, length + 2);
        }
        AttributesHandler[] attributesHandlerArr = this.attributesHandlers;
        if (attributesHandlerArr == null) {
            this.attributesHandlers = new AttributesHandler[length + 2];
            return length;
        }
        this.attributesHandlers = (AttributesHandler[]) Arrays.copyOf(attributesHandlerArr, length + 2);
        return length;
    }

    public int getTreeCount() {
        return this.trees.length;
    }

    public boolean next() throws IOException {
        try {
            if (this.advance) {
                this.advance = false;
                this.postChildren = false;
                popEntriesEqual();
            }
            while (true) {
                Arrays.fill(this.attrs, (Object) null);
                AbstractTreeIterator abstractTreeIteratorMin = min();
                if (abstractTreeIteratorMin.eof()) {
                    if (this.depth <= 0) {
                        return false;
                    }
                    exitSubtree();
                    if (this.postOrderTraversal) {
                        this.advance = true;
                        this.postChildren = true;
                        return true;
                    }
                    popEntriesEqual();
                } else {
                    this.currentHead = abstractTreeIteratorMin;
                    if (this.filter.matchFilter(this) == 1) {
                        skipEntriesEqual();
                    } else if (this.recursive && FileMode.TREE.equals(abstractTreeIteratorMin.mode)) {
                        enterSubtree();
                    } else {
                        this.advance = true;
                        return true;
                    }
                }
            }
        } catch (StopWalkException unused) {
            stopWalk();
            return false;
        }
    }

    void stopWalk() throws IOException {
        for (AbstractTreeIterator abstractTreeIterator : this.trees) {
            abstractTreeIterator.stopWalk();
        }
    }

    public <T extends AbstractTreeIterator> T getTree(int i, Class<T> cls) {
        T t = (T) this.trees[i];
        if (t.matches == this.currentHead) {
            return t;
        }
        return null;
    }

    public int getRawMode(int i) {
        AbstractTreeIterator abstractTreeIterator = this.trees[i];
        if (abstractTreeIterator.matches == this.currentHead) {
            return abstractTreeIterator.mode;
        }
        return 0;
    }

    public FileMode getFileMode(int i) {
        return FileMode.fromBits(getRawMode(i));
    }

    public FileMode getFileMode() {
        return FileMode.fromBits(this.currentHead.mode);
    }

    public ObjectId getObjectId(int i) {
        AbstractTreeIterator abstractTreeIterator = this.trees[i];
        return abstractTreeIterator.matches == this.currentHead ? abstractTreeIterator.getEntryObjectId() : ObjectId.zeroId();
    }

    public void getObjectId(MutableObjectId mutableObjectId, int i) {
        AbstractTreeIterator abstractTreeIterator = this.trees[i];
        if (abstractTreeIterator.matches == this.currentHead) {
            abstractTreeIterator.getEntryObjectId(mutableObjectId);
        } else {
            mutableObjectId.clear();
        }
    }

    public boolean idEqual(int i, int i2) {
        AbstractTreeIterator abstractTreeIterator = this.currentHead;
        AbstractTreeIterator[] abstractTreeIteratorArr = this.trees;
        AbstractTreeIterator abstractTreeIterator2 = abstractTreeIteratorArr[i];
        AbstractTreeIterator abstractTreeIterator3 = abstractTreeIteratorArr[i2];
        if (abstractTreeIterator2.matches != abstractTreeIterator && abstractTreeIterator3.matches != abstractTreeIterator) {
            return true;
        }
        if (abstractTreeIterator2.hasId() && abstractTreeIterator3.hasId() && abstractTreeIterator2.matches == abstractTreeIterator && abstractTreeIterator3.matches == abstractTreeIterator) {
            return abstractTreeIterator2.idEqual(abstractTreeIterator3);
        }
        return false;
    }

    public String getNameString() {
        AbstractTreeIterator abstractTreeIterator = this.currentHead;
        return RawParseUtils.decode(StandardCharsets.UTF_8, abstractTreeIterator.path, abstractTreeIterator.pathOffset, abstractTreeIterator.pathLen);
    }

    public String getPathString() {
        return pathOf(this.currentHead);
    }

    public byte[] getRawPath() {
        AbstractTreeIterator abstractTreeIterator = this.currentHead;
        int i = abstractTreeIterator.pathLen;
        byte[] bArr = new byte[i];
        System.arraycopy(abstractTreeIterator.path, 0, bArr, 0, i);
        return bArr;
    }

    public int getPathLength() {
        return this.currentHead.pathLen;
    }

    public int isPathMatch(byte[] bArr, int i) {
        AbstractTreeIterator abstractTreeIterator = this.currentHead;
        byte[] bArr2 = abstractTreeIterator.path;
        int i2 = abstractTreeIterator.pathLen;
        int i3 = 0;
        while (i3 < i2 && i3 < i) {
            if ((bArr2[i3] & 255) - (bArr[i3] & 255) != 0) {
                return 1;
            }
            i3++;
        }
        if (i3 < i2) {
            return bArr2[i3] == 47 ? 0 : 1;
        }
        if (i3 < i) {
            return (bArr[i3] == 47 && FileMode.TREE.equals(abstractTreeIterator.mode)) ? -1 : 1;
        }
        return 0;
    }

    public int isPathPrefix(byte[] bArr, int i) {
        AbstractTreeIterator abstractTreeIterator = this.currentHead;
        byte[] bArr2 = abstractTreeIterator.path;
        int i2 = abstractTreeIterator.pathLen;
        int i3 = 0;
        while (i3 < i2 && i3 < i) {
            int i4 = (bArr2[i3] & 255) - (bArr[i3] & 255);
            if (i4 != 0) {
                return i4;
            }
            i3++;
        }
        if (i3 < i2) {
            return bArr2[i3] == 47 ? 0 : -1;
        }
        if (i3 < i) {
            return (bArr[i3] == 47 && FileMode.TREE.equals(abstractTreeIterator.mode)) ? 0 : -1;
        }
        return 0;
    }

    public boolean isPathSuffix(byte[] bArr, int i) {
        AbstractTreeIterator abstractTreeIterator = this.currentHead;
        byte[] bArr2 = abstractTreeIterator.path;
        int i2 = abstractTreeIterator.pathLen;
        for (int i3 = 1; i3 <= i; i3++) {
            if (i3 > i2 || bArr2[i2 - i3] != bArr[i - i3]) {
                return false;
            }
        }
        return true;
    }

    public int getDepth() {
        return this.depth;
    }

    public boolean isSubtree() {
        return FileMode.TREE.equals(this.currentHead.mode);
    }

    public boolean isPostChildren() {
        return this.postChildren && isSubtree();
    }

    public void enterSubtree() throws IOException {
        AbstractTreeIterator abstractTreeIteratorCreateEmptyTreeIterator;
        Arrays.fill(this.attrs, (Object) null);
        AbstractTreeIterator abstractTreeIterator = this.currentHead;
        AbstractTreeIterator[] abstractTreeIteratorArr = new AbstractTreeIterator[this.trees.length];
        int i = 0;
        while (true) {
            AbstractTreeIterator[] abstractTreeIteratorArr2 = this.trees;
            if (i < abstractTreeIteratorArr2.length) {
                AbstractTreeIterator abstractTreeIterator2 = abstractTreeIteratorArr2[i];
                if (abstractTreeIterator2.matches == abstractTreeIterator && !abstractTreeIterator2.eof() && (FileMode.TREE.equals(abstractTreeIterator2.mode) || (FileMode.GITLINK.equals(abstractTreeIterator2.mode) && abstractTreeIterator2.isWorkTree()))) {
                    abstractTreeIteratorCreateEmptyTreeIterator = abstractTreeIterator2.createSubtreeIterator(this.reader, this.idBuffer);
                } else {
                    abstractTreeIteratorCreateEmptyTreeIterator = abstractTreeIterator2.createEmptyTreeIterator();
                }
                abstractTreeIteratorArr[i] = abstractTreeIteratorCreateEmptyTreeIterator;
                i++;
            } else {
                this.depth++;
                this.advance = false;
                System.arraycopy(abstractTreeIteratorArr, 0, abstractTreeIteratorArr2, 0, abstractTreeIteratorArr2.length);
                return;
            }
        }
    }

    AbstractTreeIterator min() throws CorruptObjectException {
        int i = 0;
        AbstractTreeIterator abstractTreeIterator = this.trees[0];
        while (abstractTreeIterator.eof()) {
            i++;
            AbstractTreeIterator[] abstractTreeIteratorArr = this.trees;
            if (i >= abstractTreeIteratorArr.length) {
                break;
            }
            abstractTreeIterator = abstractTreeIteratorArr[i];
        }
        if (abstractTreeIterator.eof()) {
            return abstractTreeIterator;
        }
        abstractTreeIterator.matches = abstractTreeIterator;
        while (true) {
            i++;
            AbstractTreeIterator[] abstractTreeIteratorArr2 = this.trees;
            if (i >= abstractTreeIteratorArr2.length) {
                return abstractTreeIterator;
            }
            AbstractTreeIterator abstractTreeIterator2 = abstractTreeIteratorArr2[i];
            if (!abstractTreeIterator2.eof()) {
                int iPathCompare = abstractTreeIterator2.pathCompare(abstractTreeIterator);
                if (iPathCompare < 0) {
                    abstractTreeIterator2.matches = abstractTreeIterator2;
                    abstractTreeIterator = abstractTreeIterator2;
                } else if (iPathCompare == 0) {
                    abstractTreeIterator2.matches = abstractTreeIterator;
                }
            }
        }
    }

    void popEntriesEqual() throws CorruptObjectException {
        AbstractTreeIterator abstractTreeIterator = this.currentHead;
        for (AbstractTreeIterator abstractTreeIterator2 : this.trees) {
            if (abstractTreeIterator2.matches == abstractTreeIterator) {
                abstractTreeIterator2.next(1);
                abstractTreeIterator2.matches = null;
            }
        }
    }

    void skipEntriesEqual() throws CorruptObjectException {
        AbstractTreeIterator abstractTreeIterator = this.currentHead;
        for (AbstractTreeIterator abstractTreeIterator2 : this.trees) {
            if (abstractTreeIterator2.matches == abstractTreeIterator) {
                abstractTreeIterator2.skip();
                abstractTreeIterator2.matches = null;
            }
        }
    }

    void exitSubtree() {
        AbstractTreeIterator[] abstractTreeIteratorArr;
        this.depth--;
        int i = 0;
        while (true) {
            abstractTreeIteratorArr = this.trees;
            if (i >= abstractTreeIteratorArr.length) {
                break;
            }
            abstractTreeIteratorArr[i] = abstractTreeIteratorArr[i].parent;
            i++;
        }
        AbstractTreeIterator abstractTreeIterator = null;
        for (AbstractTreeIterator abstractTreeIterator2 : abstractTreeIteratorArr) {
            if (abstractTreeIterator2.matches == abstractTreeIterator2 && (abstractTreeIterator == null || abstractTreeIterator2.pathCompare(abstractTreeIterator) < 0)) {
                abstractTreeIterator = abstractTreeIterator2;
            }
        }
        this.currentHead = abstractTreeIterator;
    }

    private CanonicalTreeParser parserFor(AnyObjectId anyObjectId) throws IOException {
        CanonicalTreeParser canonicalTreeParser = new CanonicalTreeParser();
        canonicalTreeParser.reset(this.reader, anyObjectId);
        return canonicalTreeParser;
    }

    static String pathOf(AbstractTreeIterator abstractTreeIterator) {
        return RawParseUtils.decode(StandardCharsets.UTF_8, abstractTreeIterator.path, 0, abstractTreeIterator.pathLen);
    }

    static String pathOf(byte[] bArr, int i, int i2) {
        return RawParseUtils.decode(StandardCharsets.UTF_8, bArr, i, i2);
    }

    public <T extends AbstractTreeIterator> T getTree(Class<T> cls) {
        for (AbstractTreeIterator abstractTreeIterator : this.trees) {
            if (cls.isInstance(abstractTreeIterator)) {
                return cls.cast(abstractTreeIterator);
            }
        }
        return null;
    }

    public String getFilterCommand(String str) throws IOException {
        String value;
        String filterCommandDefinition;
        Attribute attribute = getAttributes().get("filter");
        if (attribute == null || (value = attribute.getValue()) == null || (filterCommandDefinition = getFilterCommandDefinition(value, str)) == null) {
            return null;
        }
        return filterCommandDefinition.replaceAll("%f", Matcher.quoteReplacement(QuotedString.BOURNE.quote(getPathString())));
    }

    public String getSmudgeCommand(int i) throws IOException {
        return getSmudgeCommand(getAttributes(i));
    }

    public String getSmudgeCommand(Attributes attributes) throws IOException {
        Attribute attribute;
        String value;
        String filterCommandDefinition;
        if (attributes == null || (attribute = attributes.get("filter")) == null || (value = attribute.getValue()) == null || (filterCommandDefinition = getFilterCommandDefinition(value, Constants.ATTR_FILTER_TYPE_SMUDGE)) == null) {
            return null;
        }
        return filterCommandDefinition.replaceAll("%f", Matcher.quoteReplacement(QuotedString.BOURNE.quote(getPathString())));
    }

    private String getFilterCommandDefinition(String str, String str2) {
        String str3 = str + BranchConfig.LOCAL_REPOSITORY + str2;
        String str4 = this.filterCommandsByNameDotType.get(str3);
        if (str4 != null) {
            return str4;
        }
        String string = this.config.getString("filter", str, str2);
        if (this.config.getBoolean("filter", str, ConfigConstants.CONFIG_KEY_USEJGITBUILTIN, false)) {
            String str5 = Constants.BUILTIN_FILTER_PREFIX + str + InternalZipConstants.ZIP_FILE_SEPARATOR + str2;
            Set<String> set = this.filterCommands;
            if (set != null && set.contains(str5)) {
                string = str5;
            }
        }
        if (string != null) {
            this.filterCommandsByNameDotType.put(str3, string);
        }
        return string;
    }
}
