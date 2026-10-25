package org.eclipse.jgit.merge;

import java.text.MessageFormat;
import java.util.HashMap;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.Repository;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MergeStrategy {
    public static final MergeStrategy OURS;
    public static final ThreeWayMergeStrategy RECURSIVE;
    public static final ThreeWayMergeStrategy RESOLVE;
    public static final ThreeWayMergeStrategy SIMPLE_TWO_WAY_IN_CORE;
    private static final HashMap<String, MergeStrategy> STRATEGIES;
    public static final MergeStrategy THEIRS;

    public abstract String getName();

    public abstract Merger newMerger(ObjectInserter objectInserter, Config config);

    public abstract Merger newMerger(Repository repository);

    public abstract Merger newMerger(Repository repository, boolean z);

    static {
        StrategyOneSided strategyOneSided = new StrategyOneSided("ours", 0);
        OURS = strategyOneSided;
        StrategyOneSided strategyOneSided2 = new StrategyOneSided("theirs", 1);
        THEIRS = strategyOneSided2;
        StrategySimpleTwoWayInCore strategySimpleTwoWayInCore = new StrategySimpleTwoWayInCore();
        SIMPLE_TWO_WAY_IN_CORE = strategySimpleTwoWayInCore;
        StrategyResolve strategyResolve = new StrategyResolve();
        RESOLVE = strategyResolve;
        StrategyRecursive strategyRecursive = new StrategyRecursive();
        RECURSIVE = strategyRecursive;
        STRATEGIES = new HashMap<>();
        register(strategyOneSided);
        register(strategyOneSided2);
        register(strategySimpleTwoWayInCore);
        register(strategyResolve);
        register(strategyRecursive);
    }

    public static void register(MergeStrategy mergeStrategy) {
        register(mergeStrategy.getName(), mergeStrategy);
    }

    public static synchronized void register(String str, MergeStrategy mergeStrategy) {
        HashMap<String, MergeStrategy> map = STRATEGIES;
        if (map.containsKey(str)) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().mergeStrategyAlreadyExistsAsDefault, str));
        }
        map.put(str, mergeStrategy);
    }

    public static synchronized MergeStrategy get(String str) {
        return STRATEGIES.get(str);
    }

    public static synchronized MergeStrategy[] get() {
        MergeStrategy[] mergeStrategyArr;
        HashMap<String, MergeStrategy> map = STRATEGIES;
        mergeStrategyArr = new MergeStrategy[map.size()];
        map.values().toArray(mergeStrategyArr);
        return mergeStrategyArr;
    }
}
