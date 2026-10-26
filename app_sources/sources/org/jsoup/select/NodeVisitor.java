package org.jsoup.select;

import org.jsoup.nodes.Node;

/* INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface NodeVisitor {
    void head(Node node, int i);

    default void tail(Node node, int i) {
    }

    default void traverse(Node node) {
        NodeTraversor.traverse(this, node);
    }
}
