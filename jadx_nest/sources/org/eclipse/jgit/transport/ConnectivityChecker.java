package org.eclipse.jgit.transport;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevWalk;

/* INFO: loaded from: classes5.dex */
public interface ConnectivityChecker {
    void checkConnectivity(ConnectivityCheckInfo connectivityCheckInfo, Set<ObjectId> set, ProgressMonitor progressMonitor) throws IOException;

    public static class ConnectivityCheckInfo {
        private boolean checkObjects;
        private List<ReceiveCommand> commands;
        private PackParser parser;
        private Repository repository;
        private RevWalk walk;

        public Repository getRepository() {
            return this.repository;
        }

        public void setRepository(Repository repository) {
            this.repository = repository;
        }

        public PackParser getParser() {
            return this.parser;
        }

        public void setParser(PackParser packParser) {
            this.parser = packParser;
        }

        public boolean isCheckObjects() {
            return this.checkObjects;
        }

        public void setCheckObjects(boolean z) {
            this.checkObjects = z;
        }

        public List<ReceiveCommand> getCommands() {
            return this.commands;
        }

        public void setCommands(List<ReceiveCommand> list) {
            this.commands = list;
        }

        public void setWalk(RevWalk revWalk) {
            this.walk = revWalk;
        }

        public RevWalk getWalk() {
            return this.walk;
        }
    }
}
