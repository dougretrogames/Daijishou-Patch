package org.eclipse.jgit.blame;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: loaded from: classes5.dex */
class Region {
    int length;
    Region next;
    int resultStart;
    int sourceStart;

    Region(int i, int i2, int i3) {
        this.resultStart = i;
        this.sourceStart = i2;
        this.length = i3;
    }

    Region copy(int i) {
        return new Region(this.resultStart, i, this.length);
    }

    Region splitFirst(int i, int i2) {
        return new Region(this.resultStart, i, i2);
    }

    void slideAndShrink(int i) {
        this.resultStart += i;
        this.sourceStart += i;
        this.length -= i;
    }

    Region deepCopy() {
        Region region = new Region(this.resultStart, this.sourceStart, this.length);
        Region region2 = this.next;
        Region region3 = region;
        while (region2 != null) {
            Region region4 = new Region(region2.resultStart, region2.sourceStart, region2.length);
            region3.next = region4;
            region2 = region2.next;
            region3 = region4;
        }
        return region;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Region region = this;
        do {
            if (region != this) {
                sb.append(AbstractJsonLexerKt.COMMA);
            }
            sb.append(region.resultStart);
            sb.append(Soundex.SILENT_MARKER);
            sb.append(region.resultStart + region.length);
            region = region.next;
        } while (region != null);
        return sb.toString();
    }
}
