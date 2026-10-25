package org.eclipse.jgit.internal.storage.dfs;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.pack.PackExt;
import org.eclipse.jgit.lib.CommitConfig$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes5.dex */
class PackExtBlockCacheTable implements DfsBlockCacheTable {
    private final List<DfsBlockCacheTable> blockCacheTableList;
    private final DfsBlockCacheTable defaultBlockCacheTable;
    private final Map<PackExt, DfsBlockCacheTable> extBlockCacheTables;
    private final String name;

    static PackExtBlockCacheTable fromBlockCacheConfigs(DfsBlockCacheConfig dfsBlockCacheConfig) {
        ClockBlockCacheTable clockBlockCacheTable = new ClockBlockCacheTable(dfsBlockCacheConfig);
        HashMap map = new HashMap();
        List<DfsBlockCacheConfig.DfsBlockCachePackExtConfig> packExtCacheConfigurations = dfsBlockCacheConfig.getPackExtCacheConfigurations();
        if (packExtCacheConfigurations == null || packExtCacheConfigurations.size() == 0) {
            throw new IllegalArgumentException(JGitText.get().noPackExtConfigurationGiven);
        }
        for (DfsBlockCacheConfig.DfsBlockCachePackExtConfig dfsBlockCachePackExtConfig : packExtCacheConfigurations) {
            ClockBlockCacheTable clockBlockCacheTable2 = new ClockBlockCacheTable(dfsBlockCachePackExtConfig.getPackExtCacheConfiguration());
            for (PackExt packExt : dfsBlockCachePackExtConfig.getPackExts()) {
                if (map.containsKey(packExt)) {
                    throw new IllegalArgumentException(MessageFormat.format(JGitText.get().duplicatePackExtensionsForCacheTables, packExt));
                }
                map.put(packExt, clockBlockCacheTable2);
            }
        }
        return fromCacheTables(clockBlockCacheTable, map);
    }

    static PackExtBlockCacheTable fromCacheTables(DfsBlockCacheTable dfsBlockCacheTable, Map<PackExt, DfsBlockCacheTable> map) {
        HashSet hashSet = new HashSet();
        hashSet.add(dfsBlockCacheTable);
        hashSet.addAll(map.values());
        return new PackExtBlockCacheTable(dfsBlockCacheTable.getName() + CollectionUtils.COMMA + ((String) map.values().stream().map(new PackExtBlockCacheTable$$ExternalSyntheticLambda1()).sorted().collect(Collectors.joining(CollectionUtils.COMMA))), dfsBlockCacheTable, CommitConfig$$ExternalSyntheticBackport0.m((Collection) hashSet), map);
    }

    private PackExtBlockCacheTable(String str, DfsBlockCacheTable dfsBlockCacheTable, List<DfsBlockCacheTable> list, Map<PackExt, DfsBlockCacheTable> map) {
        this.name = str;
        this.defaultBlockCacheTable = dfsBlockCacheTable;
        this.blockCacheTableList = list;
        this.extBlockCacheTables = map;
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable
    public boolean hasBlock0(DfsStreamKey dfsStreamKey) {
        return getTable(dfsStreamKey).hasBlock0(dfsStreamKey);
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable
    public DfsBlock getOrLoad(BlockBasedFile blockBasedFile, long j, DfsReader dfsReader, DfsBlockCache.ReadableChannelSupplier readableChannelSupplier) throws IOException {
        return getTable(blockBasedFile.ext).getOrLoad(blockBasedFile, j, dfsReader, readableChannelSupplier);
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable
    public <T> DfsBlockCache.Ref<T> getOrLoadRef(DfsStreamKey dfsStreamKey, long j, DfsBlockCache.RefLoader<T> refLoader) throws IOException {
        return getTable(dfsStreamKey).getOrLoadRef(dfsStreamKey, j, refLoader);
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable
    public void put(DfsBlock dfsBlock) {
        getTable(dfsBlock.stream).put(dfsBlock);
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable
    public <T> DfsBlockCache.Ref<T> put(DfsStreamKey dfsStreamKey, long j, long j2, T t) {
        return getTable(dfsStreamKey).put(dfsStreamKey, j, j2, t);
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable
    public <T> DfsBlockCache.Ref<T> putRef(DfsStreamKey dfsStreamKey, long j, T t) {
        return getTable(dfsStreamKey).putRef(dfsStreamKey, j, t);
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable
    public boolean contains(DfsStreamKey dfsStreamKey, long j) {
        return getTable(dfsStreamKey).contains(dfsStreamKey, j);
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable
    public <T> T get(DfsStreamKey dfsStreamKey, long j) {
        return (T) getTable(dfsStreamKey).get(dfsStreamKey, j);
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable
    public List<DfsBlockCacheTable.BlockCacheStats> getBlockCacheStats() {
        return (List) this.blockCacheTableList.stream().flatMap(new PackExtBlockCacheTable$$ExternalSyntheticLambda2()).collect(Collectors.toList());
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCacheTable
    public String getName() {
        return this.name;
    }

    private DfsBlockCacheTable getTable(PackExt packExt) {
        return this.extBlockCacheTables.getOrDefault(packExt, this.defaultBlockCacheTable);
    }

    private DfsBlockCacheTable getTable(DfsStreamKey dfsStreamKey) {
        return this.extBlockCacheTables.getOrDefault(getPackExt(dfsStreamKey), this.defaultBlockCacheTable);
    }

    private static PackExt getPackExt(DfsStreamKey dfsStreamKey) {
        return PackExt.valuesCustom()[dfsStreamKey.packExtPos];
    }
}
