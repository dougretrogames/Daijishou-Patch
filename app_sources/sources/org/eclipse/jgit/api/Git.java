package org.eclipse.jgit.api;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryBuilder;
import org.eclipse.jgit.lib.RepositoryCache;
import org.eclipse.jgit.lib.internal.WorkQueue;
import org.eclipse.jgit.nls.NLS;
import org.eclipse.jgit.util.FS;

/* INFO: loaded from: classes5.dex */
public class Git implements AutoCloseable {
    private final boolean closeRepo;
    private final Repository repo;

    public static Git open(File file) throws IOException {
        return open(file, FS.DETECTED);
    }

    public static Git open(File file, FS fs) throws IOException {
        return new Git(new RepositoryBuilder().setFS(fs).setGitDir(RepositoryCache.FileKey.lenient(file, fs).getFile()).setMustExist(true).build(), true);
    }

    public static Git wrap(Repository repository) {
        return new Git(repository);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.closeRepo) {
            this.repo.close();
        }
    }

    public static CloneCommand cloneRepository() {
        return new CloneCommand();
    }

    public static LsRemoteCommand lsRemoteRepository() {
        return new LsRemoteCommand(null);
    }

    public static InitCommand init() {
        return new InitCommand();
    }

    public static void shutdown() {
        WorkQueue.getExecutor().shutdownNow();
        NLS.clear();
    }

    public Git(Repository repository) {
        this(repository, false);
    }

    Git(Repository repository, boolean z) {
        this.repo = (Repository) Objects.requireNonNull(repository);
        this.closeRepo = z;
    }

    public CommitCommand commit() {
        return new CommitCommand(this.repo);
    }

    public LogCommand log() {
        return new LogCommand(this.repo);
    }

    public MergeCommand merge() {
        return new MergeCommand(this.repo);
    }

    public PullCommand pull() {
        return new PullCommand(this.repo);
    }

    public CreateBranchCommand branchCreate() {
        return new CreateBranchCommand(this.repo);
    }

    public DeleteBranchCommand branchDelete() {
        return new DeleteBranchCommand(this.repo);
    }

    public ListBranchCommand branchList() {
        return new ListBranchCommand(this.repo);
    }

    public ListTagCommand tagList() {
        return new ListTagCommand(this.repo);
    }

    public RenameBranchCommand branchRename() {
        return new RenameBranchCommand(this.repo);
    }

    public AddCommand add() {
        return new AddCommand(this.repo);
    }

    public TagCommand tag() {
        return new TagCommand(this.repo);
    }

    public FetchCommand fetch() {
        return new FetchCommand(this.repo);
    }

    public PushCommand push() {
        return new PushCommand(this.repo);
    }

    public CherryPickCommand cherryPick() {
        return new CherryPickCommand(this.repo);
    }

    public RevertCommand revert() {
        return new RevertCommand(this.repo);
    }

    public RebaseCommand rebase() {
        return new RebaseCommand(this.repo);
    }

    public RmCommand rm() {
        return new RmCommand(this.repo);
    }

    public CheckoutCommand checkout() {
        return new CheckoutCommand(this.repo);
    }

    public ResetCommand reset() {
        return new ResetCommand(this.repo);
    }

    public StatusCommand status() {
        return new StatusCommand(this.repo);
    }

    public ArchiveCommand archive() {
        return new ArchiveCommand(this.repo);
    }

    public AddNoteCommand notesAdd() {
        return new AddNoteCommand(this.repo);
    }

    public RemoveNoteCommand notesRemove() {
        return new RemoveNoteCommand(this.repo);
    }

    public ListNotesCommand notesList() {
        return new ListNotesCommand(this.repo);
    }

    public ShowNoteCommand notesShow() {
        return new ShowNoteCommand(this.repo);
    }

    public LsRemoteCommand lsRemote() {
        return new LsRemoteCommand(this.repo);
    }

    public CleanCommand clean() {
        return new CleanCommand(this.repo);
    }

    public BlameCommand blame() {
        return new BlameCommand(this.repo);
    }

    public ReflogCommand reflog() {
        return new ReflogCommand(this.repo);
    }

    public DiffCommand diff() {
        return new DiffCommand(this.repo);
    }

    public DeleteTagCommand tagDelete() {
        return new DeleteTagCommand(this.repo);
    }

    public SubmoduleAddCommand submoduleAdd() {
        return new SubmoduleAddCommand(this.repo);
    }

    public SubmoduleInitCommand submoduleInit() {
        return new SubmoduleInitCommand(this.repo);
    }

    public SubmoduleDeinitCommand submoduleDeinit() {
        return new SubmoduleDeinitCommand(this.repo);
    }

    public SubmoduleStatusCommand submoduleStatus() {
        return new SubmoduleStatusCommand(this.repo);
    }

    public SubmoduleSyncCommand submoduleSync() {
        return new SubmoduleSyncCommand(this.repo);
    }

    public SubmoduleUpdateCommand submoduleUpdate() {
        return new SubmoduleUpdateCommand(this.repo);
    }

    public StashListCommand stashList() {
        return new StashListCommand(this.repo);
    }

    public StashCreateCommand stashCreate() {
        return new StashCreateCommand(this.repo);
    }

    public StashApplyCommand stashApply() {
        return new StashApplyCommand(this.repo);
    }

    public StashDropCommand stashDrop() {
        return new StashDropCommand(this.repo);
    }

    public ApplyCommand apply() {
        return new ApplyCommand(this.repo);
    }

    public GarbageCollectCommand gc() {
        return new GarbageCollectCommand(this.repo);
    }

    public PackRefsCommand packRefs() {
        return new PackRefsCommand(this.repo);
    }

    public NameRevCommand nameRev() {
        return new NameRevCommand(this.repo);
    }

    public DescribeCommand describe() {
        return new DescribeCommand(this.repo);
    }

    public RemoteListCommand remoteList() {
        return new RemoteListCommand(this.repo);
    }

    public RemoteAddCommand remoteAdd() {
        return new RemoteAddCommand(this.repo);
    }

    public RemoteRemoveCommand remoteRemove() {
        return new RemoteRemoveCommand(this.repo);
    }

    public RemoteSetUrlCommand remoteSetUrl() {
        return new RemoteSetUrlCommand(this.repo);
    }

    public VerifySignatureCommand verifySignature() {
        return new VerifySignatureCommand(this.repo);
    }

    public Repository getRepository() {
        return this.repo;
    }

    public String toString() {
        return "Git[" + String.valueOf(this.repo) + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
    }
}
