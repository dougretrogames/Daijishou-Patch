package org.eclipse.jgit.internal.storage.pack;

/* INFO: loaded from: classes5.dex */
final class DeltaWindowEntry {
    byte[] buffer;
    DeltaIndex index;
    DeltaWindowEntry next;
    ObjectToPack object;
    DeltaWindowEntry prev;

    DeltaWindowEntry() {
    }

    final void set(ObjectToPack objectToPack) {
        this.object = objectToPack;
        this.index = null;
        this.buffer = null;
    }

    final int depth() {
        return this.object.getDeltaDepth();
    }

    final int type() {
        return this.object.getType();
    }

    final int size() {
        return this.object.getWeight();
    }

    final boolean empty() {
        return this.object == null;
    }

    final void makeNext(DeltaWindowEntry deltaWindowEntry) {
        DeltaWindowEntry deltaWindowEntry2 = deltaWindowEntry.prev;
        deltaWindowEntry2.next = deltaWindowEntry.next;
        deltaWindowEntry.next.prev = deltaWindowEntry2;
        deltaWindowEntry.next = this.next;
        deltaWindowEntry.prev = this;
        this.next.prev = deltaWindowEntry;
        this.next = deltaWindowEntry;
    }

    static DeltaWindowEntry createWindow(int i) {
        DeltaWindowEntry deltaWindowEntry = new DeltaWindowEntry();
        int i2 = 0;
        DeltaWindowEntry deltaWindowEntry2 = deltaWindowEntry;
        while (i2 < i) {
            DeltaWindowEntry deltaWindowEntry3 = new DeltaWindowEntry();
            deltaWindowEntry3.prev = deltaWindowEntry2;
            deltaWindowEntry2.next = deltaWindowEntry3;
            i2++;
            deltaWindowEntry2 = deltaWindowEntry3;
        }
        deltaWindowEntry2.next = deltaWindowEntry;
        deltaWindowEntry.prev = deltaWindowEntry2;
        return deltaWindowEntry;
    }
}
