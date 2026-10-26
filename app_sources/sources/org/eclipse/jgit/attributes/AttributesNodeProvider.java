package org.eclipse.jgit.attributes;

import java.io.IOException;

/* INFO: loaded from: classes5.dex */
public interface AttributesNodeProvider {
    AttributesNode getGlobalAttributesNode() throws IOException;

    AttributesNode getInfoAttributesNode() throws IOException;
}
