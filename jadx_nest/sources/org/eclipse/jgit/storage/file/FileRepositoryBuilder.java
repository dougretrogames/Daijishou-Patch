package org.eclipse.jgit.storage.file;

import java.io.File;
import java.io.IOException;
import org.eclipse.jgit.errors.RepositoryNotFoundException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.BaseRepositoryBuilder;
import org.eclipse.jgit.lib.Repository;

/* INFO: loaded from: classes5.dex */
public class FileRepositoryBuilder extends BaseRepositoryBuilder<FileRepositoryBuilder, Repository> {
    @Override // org.eclipse.jgit.lib.BaseRepositoryBuilder
    public Repository build() throws IOException {
        FileRepository fileRepository = new FileRepository(setup());
        if (!isMustExist() || fileRepository.getObjectDatabase().exists()) {
            return fileRepository;
        }
        throw new RepositoryNotFoundException(getGitDir());
    }

    public static Repository create(File file) throws IOException {
        return new FileRepositoryBuilder().setGitDir(file).readEnvironment().build();
    }
}
