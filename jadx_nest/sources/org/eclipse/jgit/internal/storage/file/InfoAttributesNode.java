package org.eclipse.jgit.internal.storage.file;

import java.io.IOException;
import org.eclipse.jgit.attributes.AttributesNode;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Repository;

/* INFO: loaded from: classes5.dex */
public class InfoAttributesNode extends AttributesNode {
    final Repository repository;

    public InfoAttributesNode(Repository repository) {
        this.repository = repository;
    }

    public AttributesNode load() throws IOException {
        AttributesNode attributesNode = new AttributesNode();
        FileRepository.AttributesNodeProviderImpl.loadRulesFromFile(attributesNode, this.repository.getFS().resolve(this.repository.getCommonDirectory(), Constants.INFO_ATTRIBUTES));
        if (attributesNode.getRules().isEmpty()) {
            return null;
        }
        return attributesNode;
    }
}
