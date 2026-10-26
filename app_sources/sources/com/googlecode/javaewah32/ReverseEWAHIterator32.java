package com.googlecode.javaewah32;

import java.util.Stack;

/* INFO: loaded from: classes4.dex */
final class ReverseEWAHIterator32 {
    private int pointer = 0;
    private Stack<Integer> positions;
    protected RunningLengthWord32 rlw;

    public ReverseEWAHIterator32(Buffer32 buffer32) {
        this.rlw = new RunningLengthWord32(buffer32, this.pointer);
        Stack<Integer> stack = new Stack<>();
        this.positions = stack;
        stack.ensureCapacity(buffer32.sizeInWords());
        while (this.pointer < buffer32.sizeInWords()) {
            this.positions.push(Integer.valueOf(this.pointer));
            this.rlw.position = this.pointer;
            this.pointer += this.rlw.getNumberOfLiteralWords() + 1;
        }
    }

    public Buffer32 buffer() {
        return this.rlw.buffer;
    }

    public int position() {
        return this.pointer;
    }

    public boolean hasPrevious() {
        return !this.positions.isEmpty();
    }

    public RunningLengthWord32 previous() {
        int iIntValue = this.positions.pop().intValue();
        this.pointer = iIntValue;
        this.rlw.position = iIntValue;
        return this.rlw;
    }
}
