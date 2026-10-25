package org.eclipse.jgit.util.sha1;

import java.text.MessageFormat;
import java.util.Arrays;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.MutableObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.util.NB;
import org.eclipse.jgit.util.SystemReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
class SHA1Java extends SHA1 {
    private static final boolean DETECT_COLLISIONS;
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) SHA1Java.class);
    private final byte[] buffer;
    private boolean detectCollision;
    private boolean foundCollision;
    private final State h;
    private final State hIn;
    private final State hTmp;
    private long length;
    private final State state58;
    private final State state65;
    private final int[] w;
    private final int[] w2;

    static {
        String property = SystemReader.getInstance().getProperty("org.eclipse.jgit.util.sha1.detectCollision");
        DETECT_COLLISIONS = property != null ? Boolean.parseBoolean(property) : true;
    }

    SHA1Java() {
        State state = new State(null);
        this.h = state;
        this.w = new int[80];
        this.buffer = new byte[64];
        this.detectCollision = DETECT_COLLISIONS;
        this.w2 = new int[80];
        this.state58 = new State(null);
        this.state65 = new State(null);
        this.hIn = new State(null);
        this.hTmp = new State(null);
        state.init();
    }

    @Override // org.eclipse.jgit.util.sha1.SHA1
    public SHA1 setDetectCollision(boolean z) {
        this.detectCollision = z;
        return this;
    }

    @Override // org.eclipse.jgit.util.sha1.SHA1
    public void update(byte b) {
        long j = this.length;
        int i = (int) (63 & j);
        this.length = j + 1;
        byte[] bArr = this.buffer;
        bArr[i] = b;
        if (i == 63) {
            compress(bArr, 0);
        }
    }

    @Override // org.eclipse.jgit.util.sha1.SHA1
    public void update(byte[] bArr) {
        update(bArr, 0, bArr.length);
    }

    @Override // org.eclipse.jgit.util.sha1.SHA1
    public void update(byte[] bArr, int i, int i2) {
        long j = this.length;
        int i3 = (int) (63 & j);
        this.length = j + ((long) i2);
        if (i3 > 0) {
            int iMin = Math.min(64 - i3, i2);
            System.arraycopy(bArr, i, this.buffer, i3, iMin);
            i += iMin;
            i2 -= iMin;
            if (i3 + iMin < 64) {
                return;
            } else {
                compress(this.buffer, 0);
            }
        }
        while (i2 >= 64) {
            compress(bArr, i);
            i += 64;
            i2 -= 64;
        }
        if (i2 > 0) {
            System.arraycopy(bArr, i, this.buffer, 0, i2);
        }
    }

    private void compress(byte[] bArr, int i) {
        initBlock(bArr, i);
        int iCheck = this.detectCollision ? UbcCheck.check(this.w) : 0;
        compress();
        while (iCheck != 0) {
            int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(Integer.lowestOneBit(iCheck));
            UbcCheck.DvInfo dvInfo = UbcCheck.DV[iNumberOfTrailingZeros];
            for (int i2 = 0; i2 < 80; i2++) {
                this.w2[i2] = this.w[i2] ^ dvInfo.dm[i2];
            }
            recompress(dvInfo.testt);
            if (eq(this.hTmp, this.h)) {
                this.foundCollision = true;
                return;
            }
            iCheck &= ~(1 << iNumberOfTrailingZeros);
        }
    }

    private void initBlock(byte[] bArr, int i) {
        int i2;
        int i3 = 0;
        while (true) {
            if (i3 >= 16) {
                break;
            }
            this.w[i3] = NB.decodeInt32(bArr, (i3 << 2) + i);
            i3++;
        }
        for (i2 = 16; i2 < 80; i2++) {
            int[] iArr = this.w;
            iArr[i2] = Integer.rotateLeft(((iArr[i2 - 3] ^ iArr[i2 - 8]) ^ iArr[i2 - 14]) ^ iArr[i2 - 16], 1);
        }
    }

    private void compress() {
        int i = this.h.a;
        int i2 = this.h.b;
        int i3 = this.h.c;
        int i4 = this.h.d;
        int iS1 = this.h.e + s1(i, i2, i3, i4, this.w[0]);
        int iRotateLeft = Integer.rotateLeft(i2, 30);
        int iS2 = i4 + s1(iS1, i, iRotateLeft, i3, this.w[1]);
        int iRotateLeft2 = Integer.rotateLeft(i, 30);
        int iS3 = i3 + s1(iS2, iS1, iRotateLeft2, iRotateLeft, this.w[2]);
        int iRotateLeft3 = Integer.rotateLeft(iS1, 30);
        int iS4 = iRotateLeft + s1(iS3, iS2, iRotateLeft3, iRotateLeft2, this.w[3]);
        int iRotateLeft4 = Integer.rotateLeft(iS2, 30);
        int iS5 = iRotateLeft2 + s1(iS4, iS3, iRotateLeft4, iRotateLeft3, this.w[4]);
        int iRotateLeft5 = Integer.rotateLeft(iS3, 30);
        int iS6 = iRotateLeft3 + s1(iS5, iS4, iRotateLeft5, iRotateLeft4, this.w[5]);
        int iRotateLeft6 = Integer.rotateLeft(iS4, 30);
        int iS7 = iRotateLeft4 + s1(iS6, iS5, iRotateLeft6, iRotateLeft5, this.w[6]);
        int iRotateLeft7 = Integer.rotateLeft(iS5, 30);
        int iS8 = iRotateLeft5 + s1(iS7, iS6, iRotateLeft7, iRotateLeft6, this.w[7]);
        int iRotateLeft8 = Integer.rotateLeft(iS6, 30);
        int iS9 = iRotateLeft6 + s1(iS8, iS7, iRotateLeft8, iRotateLeft7, this.w[8]);
        int iRotateLeft9 = Integer.rotateLeft(iS7, 30);
        int iS10 = iRotateLeft7 + s1(iS9, iS8, iRotateLeft9, iRotateLeft8, this.w[9]);
        int iRotateLeft10 = Integer.rotateLeft(iS8, 30);
        int iS11 = iRotateLeft8 + s1(iS10, iS9, iRotateLeft10, iRotateLeft9, this.w[10]);
        int iRotateLeft11 = Integer.rotateLeft(iS9, 30);
        int iS12 = iRotateLeft9 + s1(iS11, iS10, iRotateLeft11, iRotateLeft10, this.w[11]);
        int iRotateLeft12 = Integer.rotateLeft(iS10, 30);
        int iS13 = iRotateLeft10 + s1(iS12, iS11, iRotateLeft12, iRotateLeft11, this.w[12]);
        int iRotateLeft13 = Integer.rotateLeft(iS11, 30);
        int iS14 = iRotateLeft11 + s1(iS13, iS12, iRotateLeft13, iRotateLeft12, this.w[13]);
        int iRotateLeft14 = Integer.rotateLeft(iS12, 30);
        int iS15 = iRotateLeft12 + s1(iS14, iS13, iRotateLeft14, iRotateLeft13, this.w[14]);
        int iRotateLeft15 = Integer.rotateLeft(iS13, 30);
        int iS16 = iRotateLeft13 + s1(iS15, iS14, iRotateLeft15, iRotateLeft14, this.w[15]);
        int iRotateLeft16 = Integer.rotateLeft(iS14, 30);
        int iS17 = iRotateLeft14 + s1(iS16, iS15, iRotateLeft16, iRotateLeft15, this.w[16]);
        int iRotateLeft17 = Integer.rotateLeft(iS15, 30);
        int iS18 = iRotateLeft15 + s1(iS17, iS16, iRotateLeft17, iRotateLeft16, this.w[17]);
        int iRotateLeft18 = Integer.rotateLeft(iS16, 30);
        int iS19 = iRotateLeft16 + s1(iS18, iS17, iRotateLeft18, iRotateLeft17, this.w[18]);
        int iRotateLeft19 = Integer.rotateLeft(iS17, 30);
        int iS20 = iRotateLeft17 + s1(iS19, iS18, iRotateLeft19, iRotateLeft18, this.w[19]);
        int iRotateLeft20 = Integer.rotateLeft(iS18, 30);
        int iS21 = iRotateLeft18 + s2(iS20, iS19, iRotateLeft20, iRotateLeft19, this.w[20]);
        int iRotateLeft21 = Integer.rotateLeft(iS19, 30);
        int iS22 = iRotateLeft19 + s2(iS21, iS20, iRotateLeft21, iRotateLeft20, this.w[21]);
        int iRotateLeft22 = Integer.rotateLeft(iS20, 30);
        int iS23 = iRotateLeft20 + s2(iS22, iS21, iRotateLeft22, iRotateLeft21, this.w[22]);
        int iRotateLeft23 = Integer.rotateLeft(iS21, 30);
        int iS24 = iRotateLeft21 + s2(iS23, iS22, iRotateLeft23, iRotateLeft22, this.w[23]);
        int iRotateLeft24 = Integer.rotateLeft(iS22, 30);
        int iS25 = iRotateLeft22 + s2(iS24, iS23, iRotateLeft24, iRotateLeft23, this.w[24]);
        int iRotateLeft25 = Integer.rotateLeft(iS23, 30);
        int iS26 = iRotateLeft23 + s2(iS25, iS24, iRotateLeft25, iRotateLeft24, this.w[25]);
        int iRotateLeft26 = Integer.rotateLeft(iS24, 30);
        int iS27 = iRotateLeft24 + s2(iS26, iS25, iRotateLeft26, iRotateLeft25, this.w[26]);
        int iRotateLeft27 = Integer.rotateLeft(iS25, 30);
        int iS28 = iRotateLeft25 + s2(iS27, iS26, iRotateLeft27, iRotateLeft26, this.w[27]);
        int iRotateLeft28 = Integer.rotateLeft(iS26, 30);
        int iS29 = iRotateLeft26 + s2(iS28, iS27, iRotateLeft28, iRotateLeft27, this.w[28]);
        int iRotateLeft29 = Integer.rotateLeft(iS27, 30);
        int iS30 = iRotateLeft27 + s2(iS29, iS28, iRotateLeft29, iRotateLeft28, this.w[29]);
        int iRotateLeft30 = Integer.rotateLeft(iS28, 30);
        int iS31 = iRotateLeft28 + s2(iS30, iS29, iRotateLeft30, iRotateLeft29, this.w[30]);
        int iRotateLeft31 = Integer.rotateLeft(iS29, 30);
        int iS32 = iRotateLeft29 + s2(iS31, iS30, iRotateLeft31, iRotateLeft30, this.w[31]);
        int iRotateLeft32 = Integer.rotateLeft(iS30, 30);
        int iS33 = iRotateLeft30 + s2(iS32, iS31, iRotateLeft32, iRotateLeft31, this.w[32]);
        int iRotateLeft33 = Integer.rotateLeft(iS31, 30);
        int iS34 = iRotateLeft31 + s2(iS33, iS32, iRotateLeft33, iRotateLeft32, this.w[33]);
        int iRotateLeft34 = Integer.rotateLeft(iS32, 30);
        int iS35 = iRotateLeft32 + s2(iS34, iS33, iRotateLeft34, iRotateLeft33, this.w[34]);
        int iRotateLeft35 = Integer.rotateLeft(iS33, 30);
        int iS36 = iRotateLeft33 + s2(iS35, iS34, iRotateLeft35, iRotateLeft34, this.w[35]);
        int iRotateLeft36 = Integer.rotateLeft(iS34, 30);
        int iS37 = iRotateLeft34 + s2(iS36, iS35, iRotateLeft36, iRotateLeft35, this.w[36]);
        int iRotateLeft37 = Integer.rotateLeft(iS35, 30);
        int iS38 = iRotateLeft35 + s2(iS37, iS36, iRotateLeft37, iRotateLeft36, this.w[37]);
        int iRotateLeft38 = Integer.rotateLeft(iS36, 30);
        int iS39 = iRotateLeft36 + s2(iS38, iS37, iRotateLeft38, iRotateLeft37, this.w[38]);
        int iRotateLeft39 = Integer.rotateLeft(iS37, 30);
        int iS40 = iRotateLeft37 + s2(iS39, iS38, iRotateLeft39, iRotateLeft38, this.w[39]);
        int iRotateLeft40 = Integer.rotateLeft(iS38, 30);
        int iS41 = iRotateLeft38 + s3(iS40, iS39, iRotateLeft40, iRotateLeft39, this.w[40]);
        int iRotateLeft41 = Integer.rotateLeft(iS39, 30);
        int iS42 = iRotateLeft39 + s3(iS41, iS40, iRotateLeft41, iRotateLeft40, this.w[41]);
        int iRotateLeft42 = Integer.rotateLeft(iS40, 30);
        int iS43 = iRotateLeft40 + s3(iS42, iS41, iRotateLeft42, iRotateLeft41, this.w[42]);
        int iRotateLeft43 = Integer.rotateLeft(iS41, 30);
        int iS44 = iRotateLeft41 + s3(iS43, iS42, iRotateLeft43, iRotateLeft42, this.w[43]);
        int iRotateLeft44 = Integer.rotateLeft(iS42, 30);
        int iS45 = iRotateLeft42 + s3(iS44, iS43, iRotateLeft44, iRotateLeft43, this.w[44]);
        int iRotateLeft45 = Integer.rotateLeft(iS43, 30);
        int iS46 = iRotateLeft43 + s3(iS45, iS44, iRotateLeft45, iRotateLeft44, this.w[45]);
        int iRotateLeft46 = Integer.rotateLeft(iS44, 30);
        int iS47 = iRotateLeft44 + s3(iS46, iS45, iRotateLeft46, iRotateLeft45, this.w[46]);
        int iRotateLeft47 = Integer.rotateLeft(iS45, 30);
        int iS48 = iRotateLeft45 + s3(iS47, iS46, iRotateLeft47, iRotateLeft46, this.w[47]);
        int iRotateLeft48 = Integer.rotateLeft(iS46, 30);
        int iS49 = iRotateLeft46 + s3(iS48, iS47, iRotateLeft48, iRotateLeft47, this.w[48]);
        int iRotateLeft49 = Integer.rotateLeft(iS47, 30);
        int iS50 = iRotateLeft47 + s3(iS49, iS48, iRotateLeft49, iRotateLeft48, this.w[49]);
        int iRotateLeft50 = Integer.rotateLeft(iS48, 30);
        int iS51 = iRotateLeft48 + s3(iS50, iS49, iRotateLeft50, iRotateLeft49, this.w[50]);
        int iRotateLeft51 = Integer.rotateLeft(iS49, 30);
        int iS52 = iRotateLeft49 + s3(iS51, iS50, iRotateLeft51, iRotateLeft50, this.w[51]);
        int iRotateLeft52 = Integer.rotateLeft(iS50, 30);
        int iS53 = iRotateLeft50 + s3(iS52, iS51, iRotateLeft52, iRotateLeft51, this.w[52]);
        int iRotateLeft53 = Integer.rotateLeft(iS51, 30);
        int iS54 = iRotateLeft51 + s3(iS53, iS52, iRotateLeft53, iRotateLeft52, this.w[53]);
        int iRotateLeft54 = Integer.rotateLeft(iS52, 30);
        int iS55 = iRotateLeft52 + s3(iS54, iS53, iRotateLeft54, iRotateLeft53, this.w[54]);
        int iRotateLeft55 = Integer.rotateLeft(iS53, 30);
        int iS56 = iRotateLeft53 + s3(iS55, iS54, iRotateLeft55, iRotateLeft54, this.w[55]);
        int iRotateLeft56 = Integer.rotateLeft(iS54, 30);
        int iS57 = iRotateLeft54 + s3(iS56, iS55, iRotateLeft56, iRotateLeft55, this.w[56]);
        int iRotateLeft57 = Integer.rotateLeft(iS55, 30);
        int iS58 = iRotateLeft55 + s3(iS57, iS56, iRotateLeft57, iRotateLeft56, this.w[57]);
        int iRotateLeft58 = Integer.rotateLeft(iS56, 30);
        this.state58.save(iRotateLeft57, iRotateLeft56, iS58, iS57, iRotateLeft58);
        int iS59 = iRotateLeft56 + s3(iS58, iS57, iRotateLeft58, iRotateLeft57, this.w[58]);
        int iRotateLeft59 = Integer.rotateLeft(iS57, 30);
        int iS60 = iRotateLeft57 + s3(iS59, iS58, iRotateLeft59, iRotateLeft58, this.w[59]);
        int iRotateLeft60 = Integer.rotateLeft(iS58, 30);
        int iS61 = iRotateLeft58 + s4(iS60, iS59, iRotateLeft60, iRotateLeft59, this.w[60]);
        int iRotateLeft61 = Integer.rotateLeft(iS59, 30);
        int iS62 = iRotateLeft59 + s4(iS61, iS60, iRotateLeft61, iRotateLeft60, this.w[61]);
        int iRotateLeft62 = Integer.rotateLeft(iS60, 30);
        int iS63 = iRotateLeft60 + s4(iS62, iS61, iRotateLeft62, iRotateLeft61, this.w[62]);
        int iRotateLeft63 = Integer.rotateLeft(iS61, 30);
        int iS64 = iRotateLeft61 + s4(iS63, iS62, iRotateLeft63, iRotateLeft62, this.w[63]);
        int iRotateLeft64 = Integer.rotateLeft(iS62, 30);
        int iS65 = iRotateLeft62 + s4(iS64, iS63, iRotateLeft64, iRotateLeft63, this.w[64]);
        int iRotateLeft65 = Integer.rotateLeft(iS63, 30);
        this.state65.save(iS65, iS64, iRotateLeft65, iRotateLeft64, iRotateLeft63);
        int iS66 = iRotateLeft63 + s4(iS65, iS64, iRotateLeft65, iRotateLeft64, this.w[65]);
        int iRotateLeft66 = Integer.rotateLeft(iS64, 30);
        int iS67 = iRotateLeft64 + s4(iS66, iS65, iRotateLeft66, iRotateLeft65, this.w[66]);
        int iRotateLeft67 = Integer.rotateLeft(iS65, 30);
        int iS68 = iRotateLeft65 + s4(iS67, iS66, iRotateLeft67, iRotateLeft66, this.w[67]);
        int iRotateLeft68 = Integer.rotateLeft(iS66, 30);
        int iS69 = iRotateLeft66 + s4(iS68, iS67, iRotateLeft68, iRotateLeft67, this.w[68]);
        int iRotateLeft69 = Integer.rotateLeft(iS67, 30);
        int iS70 = iRotateLeft67 + s4(iS69, iS68, iRotateLeft69, iRotateLeft68, this.w[69]);
        int iRotateLeft70 = Integer.rotateLeft(iS68, 30);
        int iS71 = iRotateLeft68 + s4(iS70, iS69, iRotateLeft70, iRotateLeft69, this.w[70]);
        int iRotateLeft71 = Integer.rotateLeft(iS69, 30);
        int iS72 = iRotateLeft69 + s4(iS71, iS70, iRotateLeft71, iRotateLeft70, this.w[71]);
        int iRotateLeft72 = Integer.rotateLeft(iS70, 30);
        int iS73 = iRotateLeft70 + s4(iS72, iS71, iRotateLeft72, iRotateLeft71, this.w[72]);
        int iRotateLeft73 = Integer.rotateLeft(iS71, 30);
        int iS74 = iRotateLeft71 + s4(iS73, iS72, iRotateLeft73, iRotateLeft72, this.w[73]);
        int iRotateLeft74 = Integer.rotateLeft(iS72, 30);
        int iS75 = iRotateLeft72 + s4(iS74, iS73, iRotateLeft74, iRotateLeft73, this.w[74]);
        int iRotateLeft75 = Integer.rotateLeft(iS73, 30);
        int iS76 = iRotateLeft73 + s4(iS75, iS74, iRotateLeft75, iRotateLeft74, this.w[75]);
        int iRotateLeft76 = Integer.rotateLeft(iS74, 30);
        int iS77 = iRotateLeft74 + s4(iS76, iS75, iRotateLeft76, iRotateLeft75, this.w[76]);
        int iRotateLeft77 = Integer.rotateLeft(iS75, 30);
        int iS78 = iRotateLeft75 + s4(iS77, iS76, iRotateLeft77, iRotateLeft76, this.w[77]);
        int iRotateLeft78 = Integer.rotateLeft(iS76, 30);
        int iS79 = iRotateLeft76 + s4(iS78, iS77, iRotateLeft78, iRotateLeft77, this.w[78]);
        int iRotateLeft79 = Integer.rotateLeft(iS77, 30);
        int iS80 = iRotateLeft77 + s4(iS79, iS78, iRotateLeft79, iRotateLeft78, this.w[79]);
        int iRotateLeft80 = Integer.rotateLeft(iS78, 30);
        State state = this.h;
        state.save(state.a + iS80, this.h.b + iS79, this.h.c + iRotateLeft80, this.h.d + iRotateLeft79, this.h.e + iRotateLeft78);
    }

    private void recompress(int i) {
        State state;
        if (i == 58) {
            state = this.state58;
        } else if (i == 65) {
            state = this.state65;
        } else {
            throw new IllegalStateException();
        }
        int iS3 = state.a;
        int iS4 = state.b;
        int iRotateRight = state.c;
        int iRotateRight2 = state.d;
        int iS5 = state.e;
        if (i == 65) {
            int iRotateRight3 = Integer.rotateRight(iRotateRight, 30);
            int iS6 = iS3 - s4(iS4, iRotateRight3, iRotateRight2, iS5, this.w2[64]);
            int iRotateRight4 = Integer.rotateRight(iRotateRight2, 30);
            int iS7 = iS4 - s4(iRotateRight3, iRotateRight4, iS5, iS6, this.w2[63]);
            int iRotateRight5 = Integer.rotateRight(iS5, 30);
            int iS8 = iRotateRight3 - s4(iRotateRight4, iRotateRight5, iS6, iS7, this.w2[62]);
            int iRotateRight6 = Integer.rotateRight(iS6, 30);
            int iS9 = iRotateRight4 - s4(iRotateRight5, iRotateRight6, iS7, iS8, this.w2[61]);
            int iRotateRight7 = Integer.rotateRight(iS7, 30);
            iS5 = iRotateRight5 - s4(iRotateRight6, iRotateRight7, iS8, iS9, this.w2[60]);
            iRotateRight = Integer.rotateRight(iS8, 30);
            iS3 = iRotateRight6 - s3(iRotateRight7, iRotateRight, iS9, iS5, this.w2[59]);
            iRotateRight2 = Integer.rotateRight(iS9, 30);
            iS4 = iRotateRight7 - s3(iRotateRight, iRotateRight2, iS5, iS3, this.w2[58]);
        }
        int iRotateRight8 = Integer.rotateRight(iS5, 30);
        int iS10 = iRotateRight - s3(iRotateRight2, iRotateRight8, iS3, iS4, this.w2[57]);
        int iRotateRight9 = Integer.rotateRight(iS3, 30);
        int iS11 = iRotateRight2 - s3(iRotateRight8, iRotateRight9, iS4, iS10, this.w2[56]);
        int iRotateRight10 = Integer.rotateRight(iS4, 30);
        int iS12 = iRotateRight8 - s3(iRotateRight9, iRotateRight10, iS10, iS11, this.w2[55]);
        int iRotateRight11 = Integer.rotateRight(iS10, 30);
        int iS13 = iRotateRight9 - s3(iRotateRight10, iRotateRight11, iS11, iS12, this.w2[54]);
        int iRotateRight12 = Integer.rotateRight(iS11, 30);
        int iS14 = iRotateRight10 - s3(iRotateRight11, iRotateRight12, iS12, iS13, this.w2[53]);
        int iRotateRight13 = Integer.rotateRight(iS12, 30);
        int iS15 = iRotateRight11 - s3(iRotateRight12, iRotateRight13, iS13, iS14, this.w2[52]);
        int iRotateRight14 = Integer.rotateRight(iS13, 30);
        int iS16 = iRotateRight12 - s3(iRotateRight13, iRotateRight14, iS14, iS15, this.w2[51]);
        int iRotateRight15 = Integer.rotateRight(iS14, 30);
        int iS17 = iRotateRight13 - s3(iRotateRight14, iRotateRight15, iS15, iS16, this.w2[50]);
        int iRotateRight16 = Integer.rotateRight(iS15, 30);
        int iS18 = iRotateRight14 - s3(iRotateRight15, iRotateRight16, iS16, iS17, this.w2[49]);
        int iRotateRight17 = Integer.rotateRight(iS16, 30);
        int iS19 = iRotateRight15 - s3(iRotateRight16, iRotateRight17, iS17, iS18, this.w2[48]);
        int iRotateRight18 = Integer.rotateRight(iS17, 30);
        int iS20 = iRotateRight16 - s3(iRotateRight17, iRotateRight18, iS18, iS19, this.w2[47]);
        int iRotateRight19 = Integer.rotateRight(iS18, 30);
        int iS21 = iRotateRight17 - s3(iRotateRight18, iRotateRight19, iS19, iS20, this.w2[46]);
        int iRotateRight20 = Integer.rotateRight(iS19, 30);
        int iS22 = iRotateRight18 - s3(iRotateRight19, iRotateRight20, iS20, iS21, this.w2[45]);
        int iRotateRight21 = Integer.rotateRight(iS20, 30);
        int iS23 = iRotateRight19 - s3(iRotateRight20, iRotateRight21, iS21, iS22, this.w2[44]);
        int iRotateRight22 = Integer.rotateRight(iS21, 30);
        int iS24 = iRotateRight20 - s3(iRotateRight21, iRotateRight22, iS22, iS23, this.w2[43]);
        int iRotateRight23 = Integer.rotateRight(iS22, 30);
        int iS25 = iRotateRight21 - s3(iRotateRight22, iRotateRight23, iS23, iS24, this.w2[42]);
        int iRotateRight24 = Integer.rotateRight(iS23, 30);
        int iS26 = iRotateRight22 - s3(iRotateRight23, iRotateRight24, iS24, iS25, this.w2[41]);
        int iRotateRight25 = Integer.rotateRight(iS24, 30);
        int iS27 = iRotateRight23 - s3(iRotateRight24, iRotateRight25, iS25, iS26, this.w2[40]);
        int iRotateRight26 = Integer.rotateRight(iS25, 30);
        int iS2 = iRotateRight24 - s2(iRotateRight25, iRotateRight26, iS26, iS27, this.w2[39]);
        int iRotateRight27 = Integer.rotateRight(iS26, 30);
        int iS28 = iRotateRight25 - s2(iRotateRight26, iRotateRight27, iS27, iS2, this.w2[38]);
        int iRotateRight28 = Integer.rotateRight(iS27, 30);
        int iS29 = iRotateRight26 - s2(iRotateRight27, iRotateRight28, iS2, iS28, this.w2[37]);
        int iRotateRight29 = Integer.rotateRight(iS2, 30);
        int iS30 = iRotateRight27 - s2(iRotateRight28, iRotateRight29, iS28, iS29, this.w2[36]);
        int iRotateRight30 = Integer.rotateRight(iS28, 30);
        int iS31 = iRotateRight28 - s2(iRotateRight29, iRotateRight30, iS29, iS30, this.w2[35]);
        int iRotateRight31 = Integer.rotateRight(iS29, 30);
        int iS32 = iRotateRight29 - s2(iRotateRight30, iRotateRight31, iS30, iS31, this.w2[34]);
        int iRotateRight32 = Integer.rotateRight(iS30, 30);
        int iS33 = iRotateRight30 - s2(iRotateRight31, iRotateRight32, iS31, iS32, this.w2[33]);
        int iRotateRight33 = Integer.rotateRight(iS31, 30);
        int iS34 = iRotateRight31 - s2(iRotateRight32, iRotateRight33, iS32, iS33, this.w2[32]);
        int iRotateRight34 = Integer.rotateRight(iS32, 30);
        int iS35 = iRotateRight32 - s2(iRotateRight33, iRotateRight34, iS33, iS34, this.w2[31]);
        int iRotateRight35 = Integer.rotateRight(iS33, 30);
        int iS36 = iRotateRight33 - s2(iRotateRight34, iRotateRight35, iS34, iS35, this.w2[30]);
        int iRotateRight36 = Integer.rotateRight(iS34, 30);
        int iS37 = iRotateRight34 - s2(iRotateRight35, iRotateRight36, iS35, iS36, this.w2[29]);
        int iRotateRight37 = Integer.rotateRight(iS35, 30);
        int iS38 = iRotateRight35 - s2(iRotateRight36, iRotateRight37, iS36, iS37, this.w2[28]);
        int iRotateRight38 = Integer.rotateRight(iS36, 30);
        int iS39 = iRotateRight36 - s2(iRotateRight37, iRotateRight38, iS37, iS38, this.w2[27]);
        int iRotateRight39 = Integer.rotateRight(iS37, 30);
        int iS40 = iRotateRight37 - s2(iRotateRight38, iRotateRight39, iS38, iS39, this.w2[26]);
        int iRotateRight40 = Integer.rotateRight(iS38, 30);
        int iS41 = iRotateRight38 - s2(iRotateRight39, iRotateRight40, iS39, iS40, this.w2[25]);
        int iRotateRight41 = Integer.rotateRight(iS39, 30);
        int iS42 = iRotateRight39 - s2(iRotateRight40, iRotateRight41, iS40, iS41, this.w2[24]);
        int iRotateRight42 = Integer.rotateRight(iS40, 30);
        int iS43 = iRotateRight40 - s2(iRotateRight41, iRotateRight42, iS41, iS42, this.w2[23]);
        int iRotateRight43 = Integer.rotateRight(iS41, 30);
        int iS44 = iRotateRight41 - s2(iRotateRight42, iRotateRight43, iS42, iS43, this.w2[22]);
        int iRotateRight44 = Integer.rotateRight(iS42, 30);
        int iS45 = iRotateRight42 - s2(iRotateRight43, iRotateRight44, iS43, iS44, this.w2[21]);
        int iRotateRight45 = Integer.rotateRight(iS43, 30);
        int iS46 = iRotateRight43 - s2(iRotateRight44, iRotateRight45, iS44, iS45, this.w2[20]);
        int iRotateRight46 = Integer.rotateRight(iS44, 30);
        int iS1 = iRotateRight44 - s1(iRotateRight45, iRotateRight46, iS45, iS46, this.w2[19]);
        int iRotateRight47 = Integer.rotateRight(iS45, 30);
        int iS47 = iRotateRight45 - s1(iRotateRight46, iRotateRight47, iS46, iS1, this.w2[18]);
        int iRotateRight48 = Integer.rotateRight(iS46, 30);
        int iS48 = iRotateRight46 - s1(iRotateRight47, iRotateRight48, iS1, iS47, this.w2[17]);
        int iRotateRight49 = Integer.rotateRight(iS1, 30);
        int iS49 = iRotateRight47 - s1(iRotateRight48, iRotateRight49, iS47, iS48, this.w2[16]);
        int iRotateRight50 = Integer.rotateRight(iS47, 30);
        int iS50 = iRotateRight48 - s1(iRotateRight49, iRotateRight50, iS48, iS49, this.w2[15]);
        int iRotateRight51 = Integer.rotateRight(iS48, 30);
        int iS51 = iRotateRight49 - s1(iRotateRight50, iRotateRight51, iS49, iS50, this.w2[14]);
        int iRotateRight52 = Integer.rotateRight(iS49, 30);
        int iS52 = iRotateRight50 - s1(iRotateRight51, iRotateRight52, iS50, iS51, this.w2[13]);
        int iRotateRight53 = Integer.rotateRight(iS50, 30);
        int iS53 = iRotateRight51 - s1(iRotateRight52, iRotateRight53, iS51, iS52, this.w2[12]);
        int iRotateRight54 = Integer.rotateRight(iS51, 30);
        int iS54 = iRotateRight52 - s1(iRotateRight53, iRotateRight54, iS52, iS53, this.w2[11]);
        int iRotateRight55 = Integer.rotateRight(iS52, 30);
        int iS55 = iRotateRight53 - s1(iRotateRight54, iRotateRight55, iS53, iS54, this.w2[10]);
        int iRotateRight56 = Integer.rotateRight(iS53, 30);
        int iS56 = iRotateRight54 - s1(iRotateRight55, iRotateRight56, iS54, iS55, this.w2[9]);
        int iRotateRight57 = Integer.rotateRight(iS54, 30);
        int iS57 = iRotateRight55 - s1(iRotateRight56, iRotateRight57, iS55, iS56, this.w2[8]);
        int iRotateRight58 = Integer.rotateRight(iS55, 30);
        int iS58 = iRotateRight56 - s1(iRotateRight57, iRotateRight58, iS56, iS57, this.w2[7]);
        int iRotateRight59 = Integer.rotateRight(iS56, 30);
        int iS59 = iRotateRight57 - s1(iRotateRight58, iRotateRight59, iS57, iS58, this.w2[6]);
        int iRotateRight60 = Integer.rotateRight(iS57, 30);
        int iS60 = iRotateRight58 - s1(iRotateRight59, iRotateRight60, iS58, iS59, this.w2[5]);
        int iRotateRight61 = Integer.rotateRight(iS58, 30);
        int iS61 = iRotateRight59 - s1(iRotateRight60, iRotateRight61, iS59, iS60, this.w2[4]);
        int iRotateRight62 = Integer.rotateRight(iS59, 30);
        int iS62 = iRotateRight60 - s1(iRotateRight61, iRotateRight62, iS60, iS61, this.w2[3]);
        int iRotateRight63 = Integer.rotateRight(iS60, 30);
        int iS63 = iRotateRight61 - s1(iRotateRight62, iRotateRight63, iS61, iS62, this.w2[2]);
        int iRotateRight64 = Integer.rotateRight(iS61, 30);
        int iS64 = iRotateRight62 - s1(iRotateRight63, iRotateRight64, iS62, iS63, this.w2[1]);
        int iRotateRight65 = Integer.rotateRight(iS62, 30);
        this.hIn.save(iRotateRight64, iRotateRight65, iS63, iS64, iRotateRight63 - s1(iRotateRight64, iRotateRight65, iS63, iS64, this.w2[0]));
        int iS65 = state.a;
        int iS66 = state.b;
        int iRotateLeft = state.c;
        int iRotateLeft2 = state.d;
        int iRotateLeft3 = state.e;
        if (i == 58) {
            int iS67 = iS66 + s3(iRotateLeft, iRotateLeft2, iRotateLeft3, iS65, this.w2[58]);
            int iRotateLeft4 = Integer.rotateLeft(iRotateLeft2, 30);
            int iS68 = iS65 + s3(iS67, iRotateLeft, iRotateLeft4, iRotateLeft3, this.w2[59]);
            int iRotateLeft5 = Integer.rotateLeft(iRotateLeft, 30);
            int iS69 = iRotateLeft3 + s4(iS68, iS67, iRotateLeft5, iRotateLeft4, this.w2[60]);
            int iRotateLeft6 = Integer.rotateLeft(iS67, 30);
            int iS70 = iRotateLeft4 + s4(iS69, iS68, iRotateLeft6, iRotateLeft5, this.w2[61]);
            int iRotateLeft7 = Integer.rotateLeft(iS68, 30);
            int iS71 = iRotateLeft5 + s4(iS70, iS69, iRotateLeft7, iRotateLeft6, this.w2[62]);
            iRotateLeft3 = Integer.rotateLeft(iS69, 30);
            iS66 = iRotateLeft6 + s4(iS71, iS70, iRotateLeft3, iRotateLeft7, this.w2[63]);
            iRotateLeft2 = Integer.rotateLeft(iS70, 30);
            iS65 = iRotateLeft7 + s4(iS66, iS71, iRotateLeft2, iRotateLeft3, this.w2[64]);
            iRotateLeft = Integer.rotateLeft(iS71, 30);
        }
        int iS72 = iRotateLeft3 + s4(iS65, iS66, iRotateLeft, iRotateLeft2, this.w2[65]);
        int iRotateLeft8 = Integer.rotateLeft(iS66, 30);
        int iS73 = iRotateLeft2 + s4(iS72, iS65, iRotateLeft8, iRotateLeft, this.w2[66]);
        int iRotateLeft9 = Integer.rotateLeft(iS65, 30);
        int iS74 = iRotateLeft + s4(iS73, iS72, iRotateLeft9, iRotateLeft8, this.w2[67]);
        int iRotateLeft10 = Integer.rotateLeft(iS72, 30);
        int iS75 = iRotateLeft8 + s4(iS74, iS73, iRotateLeft10, iRotateLeft9, this.w2[68]);
        int iRotateLeft11 = Integer.rotateLeft(iS73, 30);
        int iS76 = iRotateLeft9 + s4(iS75, iS74, iRotateLeft11, iRotateLeft10, this.w2[69]);
        int iRotateLeft12 = Integer.rotateLeft(iS74, 30);
        int iS77 = iRotateLeft10 + s4(iS76, iS75, iRotateLeft12, iRotateLeft11, this.w2[70]);
        int iRotateLeft13 = Integer.rotateLeft(iS75, 30);
        int iS78 = iRotateLeft11 + s4(iS77, iS76, iRotateLeft13, iRotateLeft12, this.w2[71]);
        int iRotateLeft14 = Integer.rotateLeft(iS76, 30);
        int iS79 = iRotateLeft12 + s4(iS78, iS77, iRotateLeft14, iRotateLeft13, this.w2[72]);
        int iRotateLeft15 = Integer.rotateLeft(iS77, 30);
        int iS80 = iRotateLeft13 + s4(iS79, iS78, iRotateLeft15, iRotateLeft14, this.w2[73]);
        int iRotateLeft16 = Integer.rotateLeft(iS78, 30);
        int iS81 = iRotateLeft14 + s4(iS80, iS79, iRotateLeft16, iRotateLeft15, this.w2[74]);
        int iRotateLeft17 = Integer.rotateLeft(iS79, 30);
        int iS82 = iRotateLeft15 + s4(iS81, iS80, iRotateLeft17, iRotateLeft16, this.w2[75]);
        int iRotateLeft18 = Integer.rotateLeft(iS80, 30);
        int iS83 = iRotateLeft16 + s4(iS82, iS81, iRotateLeft18, iRotateLeft17, this.w2[76]);
        int iRotateLeft19 = Integer.rotateLeft(iS81, 30);
        int iS84 = iRotateLeft17 + s4(iS83, iS82, iRotateLeft19, iRotateLeft18, this.w2[77]);
        int iRotateLeft20 = Integer.rotateLeft(iS82, 30);
        int iS85 = iRotateLeft18 + s4(iS84, iS83, iRotateLeft20, iRotateLeft19, this.w2[78]);
        int iRotateLeft21 = Integer.rotateLeft(iS83, 30);
        this.hTmp.save(this.hIn.a + iRotateLeft19 + s4(iS85, iS84, iRotateLeft21, iRotateLeft20, this.w2[79]), this.hIn.b + iS85, this.hIn.c + Integer.rotateLeft(iS84, 30), this.hIn.d + iRotateLeft21, this.hIn.e + iRotateLeft20);
    }

    private static int s1(int i, int i2, int i3, int i4, int i5) {
        return Integer.rotateLeft(i, 5) + (((~i2) & i4) | (i3 & i2)) + 1518500249 + i5;
    }

    private static int s2(int i, int i2, int i3, int i4, int i5) {
        return Integer.rotateLeft(i, 5) + ((i2 ^ i3) ^ i4) + 1859775393 + i5;
    }

    private static int s3(int i, int i2, int i3, int i4, int i5) {
        return ((Integer.rotateLeft(i, 5) + ((i2 & (i3 | i4)) | (i3 & i4))) - 1894007588) + i5;
    }

    private static int s4(int i, int i2, int i3, int i4, int i5) {
        return ((Integer.rotateLeft(i, 5) + ((i2 ^ i3) ^ i4)) - 899497514) + i5;
    }

    private static boolean eq(State state, State state2) {
        return state.a == state2.a && state.b == state2.b && state.c == state2.c && state.d == state2.d && state.e == state2.e;
    }

    private void finish() {
        int i = (int) (this.length & 63);
        if (i > 55) {
            byte[] bArr = this.buffer;
            bArr[i] = -128;
            Arrays.fill(bArr, i + 1, 64, (byte) 0);
            compress(this.buffer, 0);
            Arrays.fill(this.buffer, 0, 56, (byte) 0);
        } else {
            byte[] bArr2 = this.buffer;
            bArr2[i] = -128;
            Arrays.fill(bArr2, i + 1, 56, (byte) 0);
        }
        NB.encodeInt32(this.buffer, 56, (int) (this.length >>> 29));
        NB.encodeInt32(this.buffer, 60, (int) (this.length << 3));
        compress(this.buffer, 0);
        if (this.foundCollision) {
            ObjectId objectId = this.h.toObjectId();
            LOG.warn(MessageFormat.format(JGitText.get().sha1CollisionDetected, objectId.name()));
            throw new Sha1CollisionException(objectId);
        }
    }

    @Override // org.eclipse.jgit.util.sha1.SHA1
    public byte[] digest() throws Sha1CollisionException {
        finish();
        byte[] bArr = new byte[20];
        NB.encodeInt32(bArr, 0, this.h.a);
        NB.encodeInt32(bArr, 4, this.h.b);
        NB.encodeInt32(bArr, 8, this.h.c);
        NB.encodeInt32(bArr, 12, this.h.d);
        NB.encodeInt32(bArr, 16, this.h.e);
        return bArr;
    }

    @Override // org.eclipse.jgit.util.sha1.SHA1
    public ObjectId toObjectId() throws Sha1CollisionException {
        finish();
        return this.h.toObjectId();
    }

    @Override // org.eclipse.jgit.util.sha1.SHA1
    public void digest(MutableObjectId mutableObjectId) throws Sha1CollisionException {
        finish();
        mutableObjectId.set(this.h.a, this.h.b, this.h.c, this.h.d, this.h.e);
    }

    @Override // org.eclipse.jgit.util.sha1.SHA1
    public boolean hasCollision() {
        return this.foundCollision;
    }

    @Override // org.eclipse.jgit.util.sha1.SHA1
    public SHA1 reset() {
        this.h.init();
        this.length = 0L;
        this.foundCollision = false;
        return this;
    }

    private static final class State {
        int a;
        int b;
        int c;
        int d;
        int e;

        /* synthetic */ State(SHA1JavaIA sHA1JavaIA) {
            this();
        }

        private State() {
        }

        final void init() {
            save(1732584193, -271733879, -1732584194, 271733878, -1009589776);
        }

        final void save(int i, int i2, int i3, int i4, int i5) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
        }

        ObjectId toObjectId() {
            return new ObjectId(this.a, this.b, this.c, this.d, this.e);
        }
    }
}
