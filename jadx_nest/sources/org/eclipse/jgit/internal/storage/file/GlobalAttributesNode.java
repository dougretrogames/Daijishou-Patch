package org.eclipse.jgit.internal.storage.file;

import java.io.File;
import java.io.IOException;
import org.eclipse.jgit.attributes.AttributesNode;
import org.eclipse.jgit.lib.CoreConfig;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.util.FS;

/* INFO: loaded from: classes5.dex */
public class GlobalAttributesNode extends AttributesNode {
    final Repository repository;

    public GlobalAttributesNode(Repository repository) {
        this.repository = repository;
    }

    public AttributesNode load() throws IOException {
        File fileResolve;
        AttributesNode attributesNode = new AttributesNode();
        FS fs = this.repository.getFS();
        String attributesFile = ((CoreConfig) this.repository.getConfig().get(CoreConfig.KEY)).getAttributesFile();
        if (attributesFile != null) {
            if (attributesFile.startsWith("~/")) {
                fileResolve = fs.resolve(fs.userHome(), attributesFile.substring(2));
            } else {
                fileResolve = fs.resolve(null, attributesFile);
            }
            FileRepository.AttributesNodeProviderImpl.loadRulesFromFile(attributesNode, fileResolve);
        }
        if (attributesNode.getRules().isEmpty()) {
            return null;
        }
        return attributesNode;
    }
}
