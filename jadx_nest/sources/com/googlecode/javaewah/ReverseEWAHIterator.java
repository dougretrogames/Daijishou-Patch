package com.googlecode.javaewah;

import java.util.Stack;

/* JADX INFO: loaded from: classes4.dex */
final class ReverseEWAHIterator {
    private int pointer = 0;
    private Stack<Integer> positions;
    protected RunningLengthWord rlw;

    public ReverseEWAHIterator(Buffer buffer) {
        this.rlw = new RunningLengthWord(buffer, this.pointer);
        Stack<Integer> stack = new Stack<>();
        this.positions = stack;
        stack.ensureCapacity(buffer.sizeInWords());
        while (this.pointer < buffer.sizeInWords()) {
            this.positions.push(Integer.valueOf(this.pointer));
            this.rlw.position = this.pointer;
            this.pointer += this.rlw.getNumberOfLiteralWords() + 1;
        }
    }

    public Buffer buffer() {
        return this.rlw.buffer;
    }

    public int position() {
        return this.pointer;
    }

    public boolean hasPrevious() {
        return !this.positions.isEmpty();
    }

    public RunningLengthWord previous() {
        int iIntValue = this.positions.pop().intValue();
        this.pointer = iIntValue;
        this.rlw.position = iIntValue;
        return this.rlw;
    }
}
