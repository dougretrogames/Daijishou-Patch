package org.apache.commons.collections4.sequence;

/* INFO: loaded from: classes5.dex */
public interface CommandVisitor<T> {
    void visitDeleteCommand(T t);

    void visitInsertCommand(T t);

    void visitKeepCommand(T t);
}
