package org.eclipse.jgit.internal.storage.file;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.text.ParseException;
import java.time.Instant;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.util.FileUtils;
import org.eclipse.jgit.util.GitDateParser;
import org.eclipse.jgit.util.SystemReader;

/* JADX INFO: loaded from: classes5.dex */
class GcLog {
    private static final String LOG_EXPIRY_DEFAULT = "1.day.ago";
    private Instant gcLogExpire;
    private final LockFile lock;
    private final File logFile;
    private boolean nonEmpty = false;
    private final FileRepository repo;

    GcLog(FileRepository fileRepository) {
        this.repo = fileRepository;
        File file = new File(fileRepository.getCommonDirectory(), "gc.log");
        this.logFile = file;
        this.lock = new LockFile(file);
    }

    private Instant getLogExpiry() throws ParseException {
        if (this.gcLogExpire == null) {
            String string = this.repo.getConfig().getString(ConfigConstants.CONFIG_GC_SECTION, null, ConfigConstants.CONFIG_KEY_LOGEXPIRY);
            if (string == null) {
                string = LOG_EXPIRY_DEFAULT;
            }
            this.gcLogExpire = GitDateParser.parse(string, null, SystemReader.getInstance().getLocale()).toInstant();
        }
        return this.gcLogExpire;
    }

    private boolean autoGcBlockedByOldLockFile() {
        try {
            return Files.getLastModifiedTime(FileUtils.toPath(this.logFile), new LinkOption[0]).toInstant().compareTo(getLogExpiry()) > 0;
        } catch (NoSuchFileException unused) {
        } catch (IOException e) {
            e = e;
            throw new JGitInternalException(e.getMessage(), e);
        } catch (ParseException e2) {
            e = e2;
            throw new JGitInternalException(e.getMessage(), e);
        }
    }

    boolean lock() {
        try {
            if (!this.lock.lock()) {
                return false;
            }
            if (!autoGcBlockedByOldLockFile()) {
                return true;
            }
            this.lock.unlock();
            return false;
        } catch (IOException e) {
            throw new JGitInternalException(e.getMessage(), e);
        }
    }

    void unlock() {
        this.lock.unlock();
    }

    boolean commit() {
        if (this.nonEmpty) {
            return this.lock.commit();
        }
        this.logFile.delete();
        this.lock.unlock();
        return true;
    }

    void write(String str) throws IOException {
        if (str.length() > 0) {
            this.nonEmpty = true;
        }
        this.lock.write(str.getBytes(StandardCharsets.UTF_8));
    }
}
