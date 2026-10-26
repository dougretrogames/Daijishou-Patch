package org.eclipse.jgit.internal.storage.file;

import androidx.compose.runtime.CompositionImpl$$ExternalSyntheticBackportWithForwarding0;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.errors.PackInvalidException;
import org.eclipse.jgit.errors.PackMismatchException;
import org.eclipse.jgit.errors.SearchForReuseTimeout;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.pack.ObjectToPack;
import org.eclipse.jgit.internal.storage.pack.PackExt;
import org.eclipse.jgit.internal.storage.pack.PackWriter;
import org.eclipse.jgit.lib.AbbreviatedObjectId;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* INFO: loaded from: classes5.dex */
class PackDirectory {
    private static final int MAX_PACKLIST_RESCAN_ATTEMPTS = 5;
    private final Config config;
    private final File directory;
    private final AtomicReference<PackList> packList = new AtomicReference<>(NO_PACKS);
    private final boolean trustFolderStat;
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) PackDirectory.class);
    private static final PackList NO_PACKS = new PackList(FileSnapshot.DIRTY, new Pack[0]);

    private boolean doLogExponentialBackoff(int i) {
        return (i & (i + (-1))) == 0;
    }

    PackDirectory(Config config, File file) {
        this.config = config;
        this.directory = file;
        this.trustFolderStat = config.getBoolean(ConfigConstants.CONFIG_CORE_SECTION, ConfigConstants.CONFIG_KEY_TRUSTFOLDERSTAT, true);
    }

    File getDirectory() {
        return this.directory;
    }

    void create() throws IOException {
        FileUtils.mkdir(this.directory);
    }

    void close() {
        PackList packList = this.packList.get();
        PackList packList2 = NO_PACKS;
        if (packList == packList2 || !CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.packList, packList, packList2)) {
            return;
        }
        for (Pack pack : packList.packs) {
            pack.close();
        }
    }

    Collection<Pack> getPacks() {
        PackList packListScanPacks;
        do {
            packListScanPacks = this.packList.get();
            if (packListScanPacks == NO_PACKS) {
                packListScanPacks = scanPacks(packListScanPacks);
            }
        } while (searchPacksAgain(packListScanPacks));
        return Collections.unmodifiableCollection(Arrays.asList(packListScanPacks.packs));
    }

    public String toString() {
        return "PackDirectory[" + String.valueOf(getDirectory()) + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
    }

    boolean has(AnyObjectId anyObjectId) {
        return getPack(anyObjectId) != null;
    }

    @Nullable
    Pack getPack(AnyObjectId anyObjectId) {
        PackList packList;
        do {
            packList = this.packList.get();
            for (Pack pack : packList.packs) {
                try {
                    if (pack.hasObject(anyObjectId)) {
                        return pack;
                    }
                } catch (IOException e) {
                    LOG.warn(MessageFormat.format(JGitText.get().unableToReadPackfile, pack.getPackFile().getAbsolutePath()), (Throwable) e);
                    remove(pack);
                }
            }
        } while (searchPacksAgain(packList));
        return null;
    }

    boolean resolve(Set<ObjectId> set, AbbreviatedObjectId abbreviatedObjectId, int i) {
        PackList packList;
        int size = set.size();
        do {
            packList = this.packList.get();
            for (Pack pack : packList.packs) {
                try {
                    pack.resolve(set, abbreviatedObjectId, i);
                    pack.resetTransientErrorCount();
                } catch (IOException e) {
                    handlePackError(e, pack);
                }
                if (set.size() > i) {
                    return false;
                }
            }
            if (set.size() != size) {
                return true;
            }
        } while (searchPacksAgain(packList));
        return true;
    }

    ObjectLoader open(WindowCursor windowCursor, AnyObjectId anyObjectId) throws PackMismatchException {
        PackList packList;
        do {
            int iCheckRescanPackThreshold = 0;
            while (true) {
                packList = this.packList.get();
                Pack[] packArr = packList.packs;
                int length = packArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    Pack pack = packArr[i];
                    try {
                        ObjectLoader objectLoader = pack.get(windowCursor, anyObjectId);
                        pack.resetTransientErrorCount();
                        if (objectLoader != null) {
                            return objectLoader;
                        }
                        i++;
                    } catch (PackMismatchException e) {
                        if (searchPacksAgain(packList)) {
                            iCheckRescanPackThreshold = checkRescanPackThreshold(iCheckRescanPackThreshold, e);
                        }
                    } catch (IOException e2) {
                        handlePackError(e2, pack);
                    }
                }
            }
        } while (searchPacksAgain(packList));
        return null;
    }

    long getSize(WindowCursor windowCursor, AnyObjectId anyObjectId) throws PackMismatchException {
        PackList packList;
        do {
            int iCheckRescanPackThreshold = 0;
            while (true) {
                packList = this.packList.get();
                Pack[] packArr = packList.packs;
                int length = packArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    Pack pack = packArr[i];
                    try {
                        long objectSize = pack.getObjectSize(windowCursor, anyObjectId);
                        pack.resetTransientErrorCount();
                        if (0 <= objectSize) {
                            return objectSize;
                        }
                        i++;
                    } catch (PackMismatchException e) {
                        if (searchPacksAgain(packList)) {
                            iCheckRescanPackThreshold = checkRescanPackThreshold(iCheckRescanPackThreshold, e);
                        }
                    } catch (IOException e2) {
                        handlePackError(e2, pack);
                    }
                }
            }
        } while (searchPacksAgain(packList));
        return -1L;
    }

    void selectRepresentation(PackWriter packWriter, ObjectToPack objectToPack, WindowCursor windowCursor) throws PackMismatchException {
        PackList packListScanPacks = this.packList.get();
        int iCheckRescanPackThreshold = 0;
        while (true) {
            for (Pack pack : packListScanPacks.packs) {
                try {
                    LocalObjectRepresentation localObjectRepresentationRepresentation = pack.representation(windowCursor, objectToPack);
                    pack.resetTransientErrorCount();
                    if (localObjectRepresentationRepresentation != null) {
                        packWriter.select(objectToPack, localObjectRepresentationRepresentation);
                        packWriter.checkSearchForReuseTimeout();
                    }
                } catch (PackMismatchException e) {
                    iCheckRescanPackThreshold = checkRescanPackThreshold(iCheckRescanPackThreshold, e);
                    packListScanPacks = scanPacks(packListScanPacks);
                } catch (SearchForReuseTimeout unused) {
                    return;
                } catch (IOException e2) {
                    handlePackError(e2, pack);
                }
            }
            return;
        }
    }

    private int checkRescanPackThreshold(int i, PackMismatchException packMismatchException) throws PackMismatchException {
        int i2 = i + 1;
        if (i <= 5) {
            return i2;
        }
        packMismatchException.setPermanent(true);
        throw packMismatchException;
    }

    private void handlePackError(IOException iOException, Pack pack) {
        String str;
        String str2 = JGitText.get().exceptionWhileReadingPack;
        int iIncrementTransientErrorCount = 0;
        if ((iOException instanceof CorruptObjectException) || (iOException instanceof PackInvalidException)) {
            str = JGitText.get().corruptPack;
            LOG.warn(MessageFormat.format(str, pack.getPackFile().getAbsolutePath()), (Throwable) iOException);
            remove(pack);
        } else {
            str = null;
            if (iOException instanceof FileNotFoundException) {
                if (pack.getPackFile().exists()) {
                    str2 = JGitText.get().packInaccessible;
                    iIncrementTransientErrorCount = pack.incrementTransientErrorCount();
                } else {
                    str = JGitText.get().packWasDeleted;
                    remove(pack);
                }
            } else if (FileUtils.isStaleFileHandleInCausalChain(iOException)) {
                str = JGitText.get().packHandleIsStale;
                remove(pack);
            } else {
                iIncrementTransientErrorCount = pack.incrementTransientErrorCount();
            }
        }
        if (str != null) {
            LOG.warn(MessageFormat.format(str, pack.getPackFile().getAbsolutePath()), (Throwable) iOException);
        } else if (doLogExponentialBackoff(iIncrementTransientErrorCount)) {
            LOG.error(MessageFormat.format(str2, pack.getPackFile().getAbsolutePath(), Integer.valueOf(iIncrementTransientErrorCount)), (Throwable) iOException);
        }
    }

    boolean searchPacksAgain(PackList packList) {
        return (!this.trustFolderStat || packList.snapshot.isModified(this.directory)) && packList != scanPacks(packList);
    }

    void insert(Pack pack) {
        PackList packList;
        Pack[] packArr;
        do {
            packList = this.packList.get();
            Pack[] packArr2 = packList.packs;
            String name = pack.getPackFile().getName();
            for (Pack pack2 : packArr2) {
                if (name.equals(pack2.getPackFile().getName())) {
                    return;
                }
            }
            packArr = new Pack[packArr2.length + 1];
            packArr[0] = pack;
            System.arraycopy(packArr2, 0, packArr, 1, packArr2.length);
        } while (!CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.packList, packList, new PackList(packList.snapshot, packArr)));
    }

    private void remove(Pack pack) {
        PackList packList;
        Pack[] packArr;
        do {
            packList = this.packList.get();
            Pack[] packArr2 = packList.packs;
            int iIndexOf = indexOf(packArr2, pack);
            if (iIndexOf < 0) {
                break;
            }
            int length = packArr2.length - 1;
            packArr = new Pack[length];
            System.arraycopy(packArr2, 0, packArr, 0, iIndexOf);
            System.arraycopy(packArr2, iIndexOf + 1, packArr, iIndexOf, length - iIndexOf);
        } while (!CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.packList, packList, new PackList(packList.snapshot, packArr)));
        pack.close();
    }

    private static int indexOf(Pack[] packArr, Pack pack) {
        for (int i = 0; i < packArr.length; i++) {
            if (packArr[i] == pack) {
                return i;
            }
        }
        return -1;
    }

    private PackList scanPacks(PackList packList) {
        PackList packList2;
        PackList packListScanPacksImpl;
        synchronized (this.packList) {
            do {
                packList2 = this.packList.get();
                if (packList2 != packList) {
                    return packList2;
                }
                packListScanPacksImpl = scanPacksImpl(packList2);
                if (packListScanPacksImpl == packList2) {
                    return packListScanPacksImpl;
                }
            } while (!CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.packList, packList2, packListScanPacksImpl));
            return packListScanPacksImpl;
        }
    }

    private PackList scanPacksImpl(PackList packList) {
        Map<String, Pack> mapReuseMap = reuseMap(packList);
        FileSnapshot fileSnapshotSave = FileSnapshot.save(this.directory);
        Map<String, Map<PackExt, PackFile>> packFilesByExtById = getPackFilesByExtById();
        ArrayList arrayList = new ArrayList(packFilesByExtById.size());
        boolean z = false;
        for (Map<PackExt, PackFile> map : packFilesByExtById.values()) {
            PackFile packFile = map.get(PackExt.PACK);
            if (packFile != null && map.containsKey(PackExt.INDEX)) {
                Pack pack = mapReuseMap.get(packFile.getName());
                if (pack != null && !pack.getFileSnapshot().isModified(packFile)) {
                    mapReuseMap.remove(packFile.getName());
                    arrayList.add(pack);
                    try {
                        if (pack.getBitmapIndex() == null) {
                            pack.refreshBitmapIndex(map.get(PackExt.BITMAP_INDEX));
                        }
                    } catch (IOException e) {
                        LOG.warn(JGitText.get().bitmapAccessErrorForPackfile, pack.getPackName(), e);
                    }
                } else {
                    arrayList.add(new Pack(this.config, packFile, map.get(PackExt.BITMAP_INDEX)));
                    z = true;
                }
            }
        }
        if (!z && mapReuseMap.isEmpty() && fileSnapshotSave.equals(packList.snapshot)) {
            packList.snapshot.setClean(fileSnapshotSave);
            return packList;
        }
        Iterator<Pack> it = mapReuseMap.values().iterator();
        while (it.hasNext()) {
            it.next().close();
        }
        if (arrayList.isEmpty()) {
            return new PackList(fileSnapshotSave, NO_PACKS.packs);
        }
        Pack[] packArr = (Pack[]) arrayList.toArray(new Pack[0]);
        Arrays.sort(packArr, Pack.SORT);
        return new PackList(fileSnapshotSave, packArr);
    }

    private static Map<String, Pack> reuseMap(PackList packList) {
        HashMap map = new HashMap();
        for (Pack pack : packList.packs) {
            if (pack.invalid()) {
                pack.close();
            } else {
                Pack pack2 = (Pack) map.put(pack.getPackFile().getName(), pack);
                if (pack2 != null) {
                    map.put(pack2.getPackFile().getName(), pack2);
                    pack.close();
                }
            }
        }
        return map;
    }

    private Map<String, Map<PackExt, PackFile>> getPackFilesByExtById() {
        String[] list = this.directory.list();
        if (list == null) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap(list.length / 2);
        for (String str : list) {
            try {
                PackFile packFile = new PackFile(this.directory, str);
                if (packFile.getPackExt() != null && !packFile.isTmpGCFile()) {
                    Map enumMap = (Map) map.get(packFile.getId());
                    if (enumMap == null) {
                        enumMap = new EnumMap(PackExt.class);
                        map.put(packFile.getId(), enumMap);
                    }
                    enumMap.put(packFile.getPackExt(), packFile);
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        return map;
    }

    static final class PackList {
        final Pack[] packs;
        final FileSnapshot snapshot;

        PackList(FileSnapshot fileSnapshot, Pack[] packArr) {
            this.snapshot = fileSnapshot;
            this.packs = packArr;
        }
    }
}
