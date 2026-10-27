p = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/data/db/entity/PlayableItemEntity.java'
with open(p, 'r', encoding='utf-8') as f:
    c = f.read()

start_target = 'public /* synthetic */ PlayableItemEntity(long j, PlayableItemEntityMergedInfo playableItemEntityMergedInfo, boolean z, boolean z2, Long l, int i, String str, boolean z3, String str2, List list, boolean z4, boolean z5, boolean z6, boolean z7, String str3, Long l2, Uri uri, Uri uri2, String str4, String str5, boolean z8, Long l3, int i2, Date date, Date date2, boolean z9, boolean z10, String str6, int i3, DefaultConstructorMarker defaultConstructorMarker) {'
end_target = 'public final PlayableItemEntityMergedInfo getMergedInfo() {'

idx1 = c.find(start_target)
idx2 = c.find(end_target)
assert idx1 != -1 and idx2 != -1

new_ctor = '''public /* synthetic */ PlayableItemEntity(long j, PlayableItemEntityMergedInfo playableItemEntityMergedInfo, boolean z, boolean z2, Long l, int i, String str, boolean z3, String str2, List list, boolean z4, boolean z5, boolean z6, boolean z7, String str3, Long l2, Uri uri, Uri uri2, String str4, String str5, boolean z8, Long l3, int i2, Date date, Date date2, boolean z9, boolean z10, String str6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(
            (i3 & 1) != 0 ? 0L : j,
            (i3 & 2) != 0 ? new PlayableItemEntityMergedInfo(null, null, null, false, false, false, false, false, false, false, false, 0, null, null, 16383, null) : playableItemEntityMergedInfo,
            (i3 & 4) != 0 ? true : z,
            (i3 & 8) != 0 ? false : z2,
            (i3 & 16) != 0 ? null : l,
            (i3 & 32) != 0 ? 1 : i,
            (i3 & 64) != 0 ? "Item name" : str,
            (i3 & 128) != 0 ? true : z3,
            (i3 & 256) != 0 ? null : str2,
            (i3 & 512) != 0 ? new ArrayList<String>() : list,
            (i3 & 1024) != 0 ? true : z4,
            (i3 & 2048) != 0 ? false : z5,
            (i3 & 4096) != 0 ? true : z6,
            (i3 & 8192) != 0 ? true : z7,
            (i3 & 16384) != 0 ? null : str3,
            (32768 & i3) != 0 ? null : l2,
            (i3 & 65536) != 0 ? Uri.EMPTY : uri,
            (i3 & 131072) != 0 ? Uri.EMPTY : uri2,
            (i3 & 262144) != 0 ? "" : str4,
            (i3 & 524288) != 0 ? null : str5,
            (i3 & 1048576) != 0 ? false : z8,
            (i3 & 2097152) != 0 ? null : l3,
            (i3 & 4194304) != 0 ? 0 : i2,
            (i3 & 8388608) != 0 ? null : date,
            (i3 & 16777216) != 0 ? new Date() : date2,
            (i3 & 33554432) != 0 ? false : z9,
            (i3 & 67108864) != 0 ? false : z10,
            (i3 & 134217728) != 0 ? "" : str6
        );
    }

    '''

c = c[:idx1] + new_ctor + c[idx2:]
with open(p, 'w', encoding='utf-8') as f:
    f.write(c)

print('Fixed PlayableItemEntity.java successfully')
