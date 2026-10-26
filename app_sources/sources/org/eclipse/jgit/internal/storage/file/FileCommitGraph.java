package org.eclipse.jgit.internal.storage.file;

import androidx.compose.runtime.CompositionImpl$$ExternalSyntheticBackportWithForwarding0;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.commitgraph.CommitGraph;
import org.eclipse.jgit.internal.storage.commitgraph.CommitGraphFormatException;
import org.eclipse.jgit.internal.storage.commitgraph.CommitGraphLoader;
import org.eclipse.jgit.lib.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* INFO: loaded from: classes5.dex */
public class FileCommitGraph {
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) FileCommitGraph.class);
    private final AtomicReference<GraphSnapshot> baseGraph;

    FileCommitGraph(File file) {
        this.baseGraph = new AtomicReference<>(new GraphSnapshot(new File(file, Constants.INFO_COMMIT_GRAPH)));
    }

    CommitGraph get() {
        GraphSnapshot graphSnapshot;
        GraphSnapshot graphSnapshotRefresh;
        GraphSnapshot graphSnapshot2 = this.baseGraph.get();
        synchronized (this.baseGraph) {
            do {
                graphSnapshot = this.baseGraph.get();
                if (graphSnapshot != graphSnapshot2) {
                    return graphSnapshot.getCommitGraph();
                }
                graphSnapshotRefresh = graphSnapshot.refresh();
                if (graphSnapshotRefresh == graphSnapshot) {
                    return graphSnapshotRefresh.getCommitGraph();
                }
            } while (!CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.baseGraph, graphSnapshot, graphSnapshotRefresh));
            return graphSnapshotRefresh.getCommitGraph();
        }
    }

    private static final class GraphSnapshot {
        private final File file;
        private final CommitGraph graph;
        private final FileSnapshot snapshot;

        GraphSnapshot(File file) {
            this(file, null, null);
        }

        GraphSnapshot(File file, FileSnapshot fileSnapshot, CommitGraph commitGraph) {
            this.file = file;
            this.snapshot = fileSnapshot;
            this.graph = commitGraph;
        }

        CommitGraph getCommitGraph() {
            return this.graph;
        }

        GraphSnapshot refresh() {
            FileSnapshot fileSnapshot;
            if ((this.graph == null && !this.file.exists()) || ((fileSnapshot = this.snapshot) != null && !fileSnapshot.isModified(this.file))) {
                return this;
            }
            File file = this.file;
            return new GraphSnapshot(file, FileSnapshot.save(file), open(this.file));
        }

        private static CommitGraph open(File file) {
            try {
                return CommitGraphLoader.open(file);
            } catch (FileNotFoundException unused) {
                return null;
            } catch (IOException e) {
                if (e instanceof CommitGraphFormatException) {
                    FileCommitGraph.LOG.warn(MessageFormat.format(JGitText.get().corruptCommitGraph, file), (Throwable) e);
                } else {
                    FileCommitGraph.LOG.error(MessageFormat.format(JGitText.get().exceptionWhileLoadingCommitGraph, file), (Throwable) e);
                }
                return null;
            }
        }
    }
}
