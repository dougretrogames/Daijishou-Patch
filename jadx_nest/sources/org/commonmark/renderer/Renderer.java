package org.commonmark.renderer;

import org.commonmark.node.Node;

/* INFO: loaded from: classes5.dex */
public interface Renderer {
    String render(Node node);

    void render(Node node, Appendable appendable);
}
