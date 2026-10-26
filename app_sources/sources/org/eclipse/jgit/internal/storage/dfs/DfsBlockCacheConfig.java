package org.eclipse.jgit.internal.storage.dfs;

import java.io.PrintWriter;
import java.text.MessageFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.pack.PackExt;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: loaded from: classes5.dex */
public class DfsBlockCacheConfig {
    public static final int DEFAULT_CACHE_HOT_MAX = 1;
    static final String DEFAULT_NAME = "<default>";
    public static final int KB = 1024;
    public static final int MB = 1048576;
    private long blockLimit;
    private int blockSize;
    private Map<PackExt, Integer> cacheHotMap;
    private int concurrencyLevel;
    private IndexEventConsumer indexEventConsumer;
    private String name = DEFAULT_NAME;
    private List<DfsBlockCachePackExtConfig> packExtCacheConfigurations;
    private Consumer<Long> refLock;
    private double streamRatio;

    public interface IndexEventConsumer {
        default void acceptEvictedEvent(int i, long j, int i2, Duration duration) {
        }

        void acceptRequestedEvent(int i, boolean z, long j, long j2, Duration duration);

        default boolean shouldReportEvictedEvent() {
            return false;
        }
    }

    public DfsBlockCacheConfig() {
        setBlockLimit(33554432L);
        setBlockSize(65536);
        setStreamRatio(0.3d);
        setConcurrencyLevel(32);
        this.cacheHotMap = Collections.emptyMap();
        this.packExtCacheConfigurations = Collections.emptyList();
    }

    public void print(PrintWriter printWriter) {
        print("", "  ", printWriter);
    }

    /* INFO: Access modifiers changed from: private */
    public void print(String str, String str2, PrintWriter printWriter) {
        if (!this.name.isEmpty() || !this.packExtCacheConfigurations.isEmpty()) {
            printWriter.println(str + "Name: " + (this.name.isEmpty() ? DEFAULT_NAME : this.name));
            str = str + str2;
        }
        printWriter.println(str + "BlockLimit: " + this.blockLimit);
        printWriter.println(str + "BlockSize: " + this.blockSize);
        printWriter.println(str + "StreamRatio: " + this.streamRatio);
        printWriter.println(str + "ConcurrencyLevel: " + this.concurrencyLevel);
        for (Map.Entry<PackExt, Integer> entry : this.cacheHotMap.entrySet()) {
            printWriter.println(str + "CacheHotMapEntry: " + String.valueOf(entry.getKey()) + " : " + String.valueOf(entry.getValue()));
        }
        Iterator<DfsBlockCachePackExtConfig> it = this.packExtCacheConfigurations.iterator();
        while (it.hasNext()) {
            it.next().print(str, str2, printWriter);
        }
    }

    public String getName() {
        return this.name;
    }

    DfsBlockCacheConfig setName(String str) {
        this.name = str;
        return this;
    }

    public long getBlockLimit() {
        return this.blockLimit;
    }

    public DfsBlockCacheConfig setBlockLimit(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().blockLimitNotPositive, Long.valueOf(j)));
        }
        this.blockLimit = j;
        return this;
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public DfsBlockCacheConfig setBlockSize(int i) {
        int iMax = Math.max(512, i);
        if (((iMax - 1) & iMax) != 0) {
            throw new IllegalArgumentException(JGitText.get().blockSizeNotPowerOf2);
        }
        this.blockSize = iMax;
        return this;
    }

    public int getConcurrencyLevel() {
        return this.concurrencyLevel;
    }

    public DfsBlockCacheConfig setConcurrencyLevel(int i) {
        this.concurrencyLevel = i;
        return this;
    }

    public double getStreamRatio() {
        return this.streamRatio;
    }

    public DfsBlockCacheConfig setStreamRatio(double d) {
        this.streamRatio = Math.max(0.0d, Math.min(d, 1.0d));
        return this;
    }

    public Consumer<Long> getRefLockWaitTimeConsumer() {
        return this.refLock;
    }

    public DfsBlockCacheConfig setRefLockWaitTimeConsumer(Consumer<Long> consumer) {
        this.refLock = consumer;
        return this;
    }

    public Map<PackExt, Integer> getCacheHotMap() {
        return this.cacheHotMap;
    }

    public DfsBlockCacheConfig setCacheHotMap(Map<PackExt, Integer> map) {
        Map<PackExt, Integer> mapUnmodifiableMap = Collections.unmodifiableMap(map);
        this.cacheHotMap = mapUnmodifiableMap;
        setCacheHotMapToPackExtConfigs(mapUnmodifiableMap);
        return this;
    }

    private void setCacheHotMapToPackExtConfigs(Map<PackExt, Integer> map) {
        Iterator<DfsBlockCachePackExtConfig> it = this.packExtCacheConfigurations.iterator();
        while (it.hasNext()) {
            it.next().setCacheHotMap(map);
        }
    }

    public IndexEventConsumer getIndexEventConsumer() {
        return this.indexEventConsumer;
    }

    public DfsBlockCacheConfig setIndexEventConsumer(IndexEventConsumer indexEventConsumer) {
        this.indexEventConsumer = indexEventConsumer;
        return this;
    }

    List<DfsBlockCachePackExtConfig> getPackExtCacheConfigurations() {
        return this.packExtCacheConfigurations;
    }

    DfsBlockCacheConfig setPackExtCacheConfigurations(List<DfsBlockCachePackExtConfig> list) {
        this.packExtCacheConfigurations = list;
        return this;
    }

    public DfsBlockCacheConfig fromConfig(Config config) {
        fromConfig(ConfigConstants.CONFIG_CORE_SECTION, ConfigConstants.CONFIG_DFS_SECTION, config);
        loadPackExtConfigs(config);
        return this;
    }

    /* INFO: Access modifiers changed from: private */
    public void fromConfig(String str, String str2, Config config) {
        long j = config.getLong(str, str2, ConfigConstants.CONFIG_KEY_BLOCK_LIMIT, getBlockLimit());
        int i = config.getInt(str, str2, ConfigConstants.CONFIG_KEY_BLOCK_SIZE, getBlockSize());
        long j2 = i;
        if (j % j2 != 0) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().blockLimitNotMultipleOfBlockSize, Long.valueOf(j), Long.valueOf(j2)));
        }
        if (config.getSubsections(str).contains(str2)) {
            this.name = str2;
        }
        setBlockLimit(j);
        setBlockSize(i);
        setConcurrencyLevel(config.getInt(str, str2, ConfigConstants.CONFIG_KEY_CONCURRENCY_LEVEL, getConcurrencyLevel()));
        String string = config.getString(str, str2, ConfigConstants.CONFIG_KEY_STREAM_RATIO);
        if (string != null) {
            try {
                setStreamRatio(Double.parseDouble(string));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(MessageFormat.format(JGitText.get().enumValueNotSupported3, str, str2, ConfigConstants.CONFIG_KEY_STREAM_RATIO, string), e);
            }
        }
    }

    private void loadPackExtConfigs(Config config) {
        List<String> list = (List) config.getSubsections(ConfigConstants.CONFIG_CORE_SECTION).stream().filter(new DfsBlockCacheConfig$$ExternalSyntheticLambda0()).collect(Collectors.toList());
        if (list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (String str : list) {
            DfsBlockCachePackExtConfig dfsBlockCachePackExtConfigFromConfig = DfsBlockCachePackExtConfig.fromConfig(config, ConfigConstants.CONFIG_CORE_SECTION, str);
            Set setIntersection = intersection(hashSet, dfsBlockCachePackExtConfigFromConfig.packExts);
            if (setIntersection.size() > 0) {
                throw new IllegalArgumentException(MessageFormat.format(JGitText.get().duplicatePackExtensionsSet, ConfigConstants.CONFIG_CORE_SECTION, str, ConfigConstants.CONFIG_KEY_PACK_EXTENSIONS, (String) setIntersection.stream().map(new DfsBlockCacheConfig$$ExternalSyntheticLambda1()).collect(Collectors.joining(CollectionUtils.COMMA))));
            }
            hashSet.addAll(dfsBlockCachePackExtConfigFromConfig.packExts);
            arrayList.add(dfsBlockCachePackExtConfigFromConfig);
        }
        this.packExtCacheConfigurations = arrayList;
        setCacheHotMapToPackExtConfigs(this.cacheHotMap);
    }

    private static <T> Set<T> intersection(Set<T> set, Set<T> set2) {
        HashSet hashSet = new HashSet();
        for (T t : set2) {
            if (set.contains(t)) {
                hashSet.add(t);
            }
        }
        return hashSet;
    }

    static class DfsBlockCachePackExtConfig {
        private final DfsBlockCacheConfig packExtCacheConfiguration;
        private final EnumSet<PackExt> packExts;

        DfsBlockCachePackExtConfig(EnumSet<PackExt> enumSet, DfsBlockCacheConfig dfsBlockCacheConfig) {
            this.packExts = enumSet;
            this.packExtCacheConfiguration = dfsBlockCacheConfig;
        }

        Set<PackExt> getPackExts() {
            return this.packExts;
        }

        DfsBlockCacheConfig getPackExtCacheConfiguration() {
            return this.packExtCacheConfiguration;
        }

        void setCacheHotMap(Map<PackExt, Integer> map) {
            Stream stream = this.packExts.stream();
            map.getClass();
            Stream streamFilter = stream.filter(new DfsBlockCacheConfig$DfsBlockCachePackExtConfig$$ExternalSyntheticLambda0(map));
            Function functionIdentity = Function.identity();
            map.getClass();
            this.packExtCacheConfiguration.setCacheHotMap((Map) streamFilter.collect(Collectors.toUnmodifiableMap(functionIdentity, new DfsBlockCacheConfig$DfsBlockCachePackExtConfig$$ExternalSyntheticLambda1(map))));
        }

        /* INFO: Access modifiers changed from: private */
        public static DfsBlockCachePackExtConfig fromConfig(Config config, String str, String str2) {
            String string = config.getString(str, str2, ConfigConstants.CONFIG_KEY_PACK_EXTENSIONS);
            if (string == null) {
                throw new IllegalArgumentException(JGitText.get().noPackExtGivenForConfiguration);
            }
            String[] strArrSplit = string.split(" ", -1);
            HashSet hashSet = new HashSet(strArrSplit.length);
            for (String str3 : strArrSplit) {
                try {
                    hashSet.add(PackExt.valueOf(str3));
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException(MessageFormat.format(JGitText.get().unknownPackExtension, str, str2, ConfigConstants.CONFIG_KEY_PACK_EXTENSIONS, str3), e);
                }
            }
            DfsBlockCacheConfig dfsBlockCacheConfig = new DfsBlockCacheConfig();
            dfsBlockCacheConfig.fromConfig(str, str2, config);
            return new DfsBlockCachePackExtConfig(EnumSet.copyOf((Collection) hashSet), dfsBlockCacheConfig);
        }

        void print(String str, String str2, PrintWriter printWriter) {
            this.packExtCacheConfiguration.print(str, str2, printWriter);
            printWriter.println(str + str2 + "PackExts: " + String.valueOf(this.packExts.stream().sorted().collect(Collectors.toList())));
        }
    }
}
