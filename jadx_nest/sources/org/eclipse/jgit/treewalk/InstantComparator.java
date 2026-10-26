package org.eclipse.jgit.treewalk;

import java.time.Instant;
import java.util.Comparator;
import kotlin.time.DurationKt;

/* INFO: loaded from: classes5.dex */
class InstantComparator implements Comparator<Instant> {
    InstantComparator() {
    }

    @Override // java.util.Comparator
    public int compare(Instant instant, Instant instant2) {
        return compare(instant, instant2, false);
    }

    public int compare(Instant instant, Instant instant2, boolean z) {
        int iCompare = Long.compare(instant.getEpochSecond(), instant2.getEpochSecond());
        if (iCompare != 0) {
            return iCompare;
        }
        int nano = instant.getNano();
        int nano2 = instant2.getNano();
        if (z || nano == 0 || nano2 == 0) {
            return 0;
        }
        if (nano != nano2) {
            int i = nano % DurationKt.NANOS_IN_MILLIS;
            int i2 = nano2 % DurationKt.NANOS_IN_MILLIS;
            if (i == 0) {
                nano2 -= i2;
            } else if (i2 == 0) {
                nano -= i;
            } else {
                int i3 = nano % 1000;
                int i4 = nano2 % 1000;
                if (i3 == 0) {
                    nano2 -= i4;
                } else if (i4 == 0) {
                    nano -= i3;
                }
            }
        }
        return Integer.compare(nano, nano2);
    }
}
