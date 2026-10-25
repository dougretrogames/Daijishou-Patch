package org.eclipse.jgit.internal.storage.pack;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.collections4.CollectionUtils;

/* JADX INFO: loaded from: classes5.dex */
public class DeltaIndex {
    static final int BLKSZ = 16;
    private static final int MAX_CHAIN_LENGTH = 64;
    private static final int[] T = {0, -725175507, 2102121847, -1450351014, 777066947, -90723602, 1394265268, -2015592551, 1554133894, -2006679381, 568977137, -181447204, 1928538693, -1506436760, 263782194, -612479969, 1837290529, -1186699508, 281608534, -1005604229, 1137954274, -1760198961, 1050155157, -362894408, 824240039, -437889910, 1282093776, -1733459459, 527564388, -877179575, 1647979283, -1224959938, 264444783, -620386238, 1921568280, -1504805579, 563217068, -178998911, 1557780443, -2011208458, 1398876393, -2019058748, 774569374, -85176653, 2100310314, -1443462649, 8119389, -725788816, 1648480078, -1232634781, 520755769, -875779820, 1276171917, -1730779744, 828048378, -442650409, 1055128776, -366653467, 1135094207, -1754359150, 280159499, -999008730, 1845047420, -1187019951, 528889566, -884963853, 1657660329, -1240772476, 836185885, -451830736, 1285356138, -1738913465, 1126434136, -1746749835, 1047515183, -357997822, 1836391579, -1179406410, 272550380, -990348607, 1912922879, -1497214510, 256849800, -611744603, 1549138748, -2003613679, 555626059, -170353306, 782684537, -94346668, 1408041998, -2027178205, 16238778, -734954601, 2109480397, -1451577632, 272969137, -998007140, 1829697734, -1178055701, 1041511538, -355301537, 1130356997, -1751559640, 1290214967, -1742623462, 833407808, -446007187, 1656096756, -1234127655, 536728195, -885300818, 2110257552, -1459533123, 9186535, -733306934, 1402396755, -2024778882, 786248996, -98859511, 560318998, -173835973, 1546526561, -1998017460, 255120341, -604872456, 1920927394, -1497778801, 1057779132, -339026287, 1111996619, -1769927706, 291337343, -979646638, 1813422344, -1194323419, 1672371770, -1217860329, 518359885, -903661472, 1308575737, -1724255020, 817140366, -462282333, 1385085341, -2042099024, 801467626, -83632185, 2095030366, -1474751629, 26506537, -715995644, 237799963, -622184138, 1936154476, -1482560447, 545100760, -189062923, 1563838127, -1980697214, 818902739, -469121538, 1300538276, -1723723639, 513699600, -900146115, 1674951271, -1223489206, 1819100501, -1196689800, 287739938, -975166705, 1111252118, -1761939525, 1064798689, -340706612, 1565369074, -1987374625, 537294725, -188693336, 1931262769, -1478883300, 240610886, -627974805, 32477556, -718724519, 2091140099, -1469909202, 801015991, -76006502, 1391812032, -2043416851, 545938274, -196286385, 1572965909, -1996014280, 249250465, -635571828, 1938855894, -1487526661, 2083023076, -1460741175, 23313811, -710603074, 1383690535, -2034253302, 791848016, -67889283, 1292406595, -1714537362, 809720372, -460986087, 1666815616, -1214306899, 504513527, -892014374, 296402117, -982773784, 1826711986, -1205347681, 1073456390, -348318165, 1118859377, -1770601636, 793329677, -74452192, 1375901050, -2033965481, 18373070, -706811165, 2085850297, -1466613868, 1944810379, -1490173786, 245409532, -630843951, 1572497992, -1988306587, 552714047, -197719022, 1120637996, -1777522943, 1065369947, -347671946, 1822068207, -1201914174, 298932376, -988288075, 510240682, -894495609, 1663202013, -1209744912, 809025129, -453112508, 1299409694, -1716135885};
    private static final int[] U = {0, 315025679, 630051358, 927677201, 1260102716, 1507675443, 1855354402, 2085658413, 1123154773, 1345786458, 1736190283, 1975173188, 166354793, 455915110, 744983927, 1050764408, 1361397127, 1138994312, 1957205913, 1718517398, 440328635, 150472884, 1068708773, 762698410, 332709586, 17979357, 911830220, 614434243, 1489967854, 1242166241, 2101528816, 1870930431, 1988900899, 1682624812, 1392634429, 1103561522, 1033346079, 793867536, 404377089, 182232846, 880657270, 649800313, 300945768, 53934183, 2137417546, 1839238725, 1525396820, 1210932315, 665419172, 896505003, 35958714, 283264693, 1823660440, 2121543831, 1228868486, 1543103113, 1700300529, 2006872062, 1087722735, 1377025504, 776151757, 1015401410, 198111443, 419961308, 970900331, 723004004, 475206005, 244709498, 1925539671, 1610845784, 1464382793, 1166957638, 2066692158, 1776931121, 1587735072, 1281622831, 808754178, 586315021, 364465692, 125806355, 1761314540, 2050846691, 1299600626, 1605418493, 601891536, 824626143, 107868366, 346757569, 705330617, 952931510, 260550567, 490817192, 1628559749, 1943482506, 1151077275, 1448796820, 1330838344, 1569985095, 1793010006, 2014953561, 71917428, 378517115, 566529386, 855794789, 228786205, 526772498, 674157059, 988297996, 1186505761, 1417563438, 1664448063, 1911791408, 511164111, 212948928, 1006267601, 691832286, 1433148147, 1202385916, 1893845229, 1646731746, 1552303514, 1312861333, 2030802820, 1808629387, 396222886, 89852073, 839922616, 550951607, 1941800662, 1635479513, 1446008008, 1157021127, 950412010, 710986725, 489418996, 267196923, 827096451, 596284556, 348237725, 101140114, 2052577727, 1754345648, 1608125345, 1293738670, 580436817, 811477598, 118821199, 366213184, 1770219373, 2068156002, 1276032371, 1590189180, 1617508356, 1924124939, 1172630042, 1461846805, 728931384, 968127799, 251612710, 473540393, 87146229, 402085882, 549219563, 846890468, 1311382217, 1559032774, 1806158039, 2036408792, 1203783072, 1426500783, 1649252286, 1888190129, 215736732, 505219219, 693515138, 999348877, 1410661234, 1188172413, 1905863020, 1667219555, 521101134, 231323201, 981634384, 675570783, 384106535, 69462312, 862507577, 565066550, 1576969243, 1329089812, 2020832773, 1790287626, 1248019901, 1487252658, 1877907363, 2099805868, 24699265, 331221134, 620049311, 909367952, 143834856, 441735143, 757034230, 1071220217, 1133058772, 1364194267, 1711589578, 1958879685, 457572410, 159443253, 1053544996, 739064619, 1348314118, 1117474057, 1976595992, 1729535767, 1505229679, 1265701472, 2084186481, 1862058110, 313286483, 6993500, 924945741, 635921474, 1022328222, 774476945, 425897856, 195315343, 2012535202, 1697788077, 1383664572, 1086317235, 2115929803, 1826123716, 1536382165, 1230355930, 889529079, 667143160, 277410025, 38672870, 1841969177, 2131546390, 1212672519, 1518404360, 651271205, 873952554, 56380987, 295348020, 792445772, 1040001603, 179704146, 410056797, 1679845232, 1994821247, 1101903214, 1399544929};
    private final long[] entries;
    private final byte[] src;
    private final int[] table;
    private final int tableMask;

    private static int keyOf(long j) {
        return (int) (j >>> 32);
    }

    private static int sizeOfArray(int i, int i2) {
        return (i2 * i) + 12;
    }

    private static int valOf(long j) {
        return (int) j;
    }

    public static long estimateIndexSize(int i) {
        long j = i;
        return j + ((3 * j) / 4);
    }

    public DeltaIndex(byte[] bArr) {
        this.src = bArr;
        DeltaIndexScanner deltaIndexScanner = new DeltaIndexScanner(bArr, bArr.length);
        this.table = deltaIndexScanner.table;
        this.tableMask = deltaIndexScanner.tableMask;
        this.entries = new long[countEntries(deltaIndexScanner) + 1];
        copyEntries(deltaIndexScanner);
    }

    private int countEntries(DeltaIndexScanner deltaIndexScanner) {
        int i = 0;
        for (int i2 : this.table) {
            if (i2 != 0) {
                int i3 = 0;
                do {
                    i3++;
                    if (i3 == 64) {
                        deltaIndexScanner.next[i2] = 0;
                        break;
                    }
                    i2 = deltaIndexScanner.next[i2];
                } while (i2 != 0);
                i += i3;
            }
        }
        return i;
    }

    private void copyEntries(DeltaIndexScanner deltaIndexScanner) {
        int i = 1;
        int i2 = 0;
        while (true) {
            int[] iArr = this.table;
            if (i2 >= iArr.length) {
                return;
            }
            int i3 = iArr[i2];
            if (i3 != 0) {
                iArr[i2] = i;
                do {
                    this.entries[i] = deltaIndexScanner.entries[i3];
                    i3 = deltaIndexScanner.next[i3];
                    i++;
                } while (i3 != 0);
            }
            i2++;
        }
    }

    public long getSourceSize() {
        return this.src.length;
    }

    public long getIndexSize() {
        return 24 + sizeOf(this.src) + sizeOf(this.table) + sizeOf(this.entries);
    }

    private static long sizeOf(byte[] bArr) {
        return sizeOfArray(1, bArr.length);
    }

    private static long sizeOf(int[] iArr) {
        return sizeOfArray(4, iArr.length);
    }

    private static long sizeOf(long[] jArr) {
        return sizeOfArray(8, jArr.length);
    }

    public void encode(OutputStream outputStream, byte[] bArr) throws IOException {
        encode(outputStream, bArr, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v3, types: [int] */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [int] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9, types: [int] */
    public boolean encode(OutputStream outputStream, byte[] bArr, int i) throws IOException {
        int i2;
        int i3;
        boolean z;
        ?? Negmatch;
        int length = bArr.length;
        DeltaEncoder deltaEncoderNewEncoder = newEncoder(outputStream, length, i);
        if (length < 16 || this.table.length == 0) {
            return deltaEncoderNewEncoder.insert(bArr);
        }
        boolean z2 = false;
        int iHashBlock = hashBlock(bArr, 0);
        int i4 = 16;
        int i5 = 0;
        int i6 = 0;
        while (i4 < length) {
            int i7 = this.tableMask & iHashBlock;
            int i8 = this.table[i7];
            if (i8 == 0) {
                i2 = i5 + 1;
                i3 = i4 + 1;
                iHashBlock = step(iHashBlock, bArr[i5], bArr[i4]);
            } else {
                int i9 = -1;
                ?? r14 = z2;
                int iValOf = -1;
                while (true) {
                    z = z2;
                    int i10 = i8 + 1;
                    long j = this.entries[i8];
                    if (keyOf(j) == iHashBlock) {
                        if (i6 < i5) {
                            Negmatch = negmatch(bArr, i5, this.src, valOf(j), i5 - i6);
                        } else {
                            Negmatch = z;
                        }
                        int iFwdmatch = fwdmatch(bArr, i5, this.src, valOf(j)) + Negmatch;
                        r14 = r14;
                        if (i9 < iFwdmatch) {
                            r14 = Negmatch;
                            iValOf = valOf(j);
                            i9 = iFwdmatch;
                        }
                    } else if ((keyOf(j) & this.tableMask) != i7) {
                        r14 = r14;
                        break;
                    }
                    r14 = r14;
                    if (i9 >= 4096 || i10 >= this.entries.length) {
                        break;
                    }
                    i8 = i10;
                    z2 = z;
                    r14 = r14;
                }
                if (i9 < 16) {
                    i2 = i5 + 1;
                    i3 = i4 + 1;
                    iHashBlock = step(iHashBlock, bArr[i5], bArr[i4]);
                    z2 = z;
                } else {
                    int i11 = i5 - r14;
                    if ((i6 < i11 && !deltaEncoderNewEncoder.insert(bArr, i6, i11 - i6)) || !deltaEncoderNewEncoder.copy((long) (iValOf - r14), i9)) {
                        return z;
                    }
                    i6 = i11 + i9;
                    i4 = i6 + 16;
                    if (length <= i4) {
                        break;
                    }
                    iHashBlock = hashBlock(bArr, i6);
                    z2 = z;
                    i5 = i6;
                }
            }
            i5 = i2;
            i4 = i3;
        }
        if (i6 < length) {
            return deltaEncoderNewEncoder.insert(bArr, i6, length - i6);
        }
        return true;
    }

    private DeltaEncoder newEncoder(OutputStream outputStream, long j, int i) throws IOException {
        return new DeltaEncoder(outputStream, getSourceSize(), j, i);
    }

    private static int fwdmatch(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = i;
        while (i3 < bArr.length && i2 < bArr2.length && bArr[i3] == bArr2[i2]) {
            i3++;
            i2++;
        }
        return i3 - i;
    }

    private static int negmatch(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (i2 == 0) {
            return 0;
        }
        int i4 = i - 1;
        int i5 = i2 - 1;
        int i6 = i4;
        while (bArr[i6] == bArr2[i5]) {
            i6--;
            i5--;
            if (i5 < 0 || (i3 = i3 - 1) <= 0) {
                break;
            }
        }
        return i4 - i6;
    }

    public String toString() {
        int i = 0;
        String[] strArr = {"bytes", "KiB", "MiB", "GiB"};
        long indexSize = getIndexSize();
        while (1024 <= indexSize && i < 3) {
            int i2 = (int) (indexSize % 1024);
            indexSize /= 1024;
            if (i2 != 0) {
                indexSize++;
            }
            i++;
        }
        return "DeltaIndex[" + indexSize + " " + strArr[i] + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
    }

    static int hashBlock(byte[] bArr, int i) {
        int i2 = ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8) | (bArr[i + 3] & 255);
        int[] iArr = T;
        int i3 = i2 ^ iArr[i2 >>> 31];
        int i4 = iArr[i3 >>> 23] ^ ((i3 << 8) | (bArr[i + 4] & 255));
        int i5 = iArr[i4 >>> 23] ^ ((i4 << 8) | (bArr[i + 5] & 255));
        int i6 = iArr[i5 >>> 23] ^ ((i5 << 8) | (bArr[i + 6] & 255));
        int i7 = iArr[i6 >>> 23] ^ ((i6 << 8) | (bArr[i + 7] & 255));
        int i8 = iArr[i7 >>> 23] ^ ((i7 << 8) | (bArr[i + 8] & 255));
        int i9 = iArr[i8 >>> 23] ^ ((i8 << 8) | (bArr[i + 9] & 255));
        int i10 = iArr[i9 >>> 23] ^ ((i9 << 8) | (bArr[i + 10] & 255));
        int i11 = iArr[i10 >>> 23] ^ ((i10 << 8) | (bArr[i + 11] & 255));
        int i12 = iArr[i11 >>> 23] ^ ((i11 << 8) | (bArr[i + 12] & 255));
        int i13 = iArr[i12 >>> 23] ^ ((i12 << 8) | (bArr[i + 13] & 255));
        int i14 = iArr[i13 >>> 23] ^ ((i13 << 8) | (bArr[i + 14] & 255));
        return ((bArr[i + 15] & 255) | (i14 << 8)) ^ iArr[i14 >>> 23];
    }

    private static int step(int i, byte b, byte b2) {
        int i2 = i ^ U[b & 255];
        return T[i2 >>> 23] ^ ((i2 << 8) | (b2 & 255));
    }
}
