package org.commonmark.renderer;

import java.util.Set;
import org.commonmark.node.Node;

/* INFO: loaded from: classes5.dex */
public interface NodeRenderer {
    Set<Class<? extends Node>> getNodeTypes();

    void render(Node node);
}
