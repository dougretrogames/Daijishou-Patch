package org.eclipse.jgit.storage.file;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.eclipse.jgit.errors.ConfigInvalidException;
import org.eclipse.jgit.lib.CommitConfig$$ExternalSyntheticBackport0;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.util.FS;

/* JADX INFO: loaded from: classes5.dex */
public class UserConfigFile extends FileBasedConfig {
    private final FileBasedConfig parent;

    public UserConfigFile(Config config, File file, File file2, FS fs) {
        super(new FileBasedConfig(config, file2, fs), file, fs);
        this.parent = (FileBasedConfig) getBaseConfig();
    }

    @Override // org.eclipse.jgit.lib.Config
    public void setStringList(String str, String str2, String str3, List<String> list) {
        if (exists() || !this.parent.exists()) {
            super.setStringList(str, str2, str3, list);
        } else {
            this.parent.setStringList(str, str2, str3, list);
        }
    }

    @Override // org.eclipse.jgit.lib.Config
    public void unset(String str, String str2, String str3) {
        if (exists() || !this.parent.exists()) {
            super.unset(str, str2, str3);
        } else {
            this.parent.unset(str, str2, str3);
        }
    }

    @Override // org.eclipse.jgit.lib.Config
    public void unsetSection(String str, String str2) {
        if (exists() || !this.parent.exists()) {
            super.unsetSection(str, str2);
        } else {
            this.parent.unsetSection(str, str2);
        }
    }

    @Override // org.eclipse.jgit.lib.Config
    public boolean removeSection(String str, String str2) {
        if (exists() || !this.parent.exists()) {
            return super.removeSection(str, str2);
        }
        return this.parent.removeSection(str, str2);
    }

    @Override // org.eclipse.jgit.storage.file.FileBasedConfig
    public boolean isOutdated() {
        return super.isOutdated() || this.parent.isOutdated();
    }

    @Override // org.eclipse.jgit.storage.file.FileBasedConfig, org.eclipse.jgit.lib.StoredConfig
    public void load() throws ConfigInvalidException, IOException {
        if (super.isOutdated()) {
            super.load();
        }
        if (this.parent.isOutdated()) {
            this.parent.load();
        }
    }

    @Override // org.eclipse.jgit.storage.file.FileBasedConfig, org.eclipse.jgit.lib.StoredConfig
    public void save() throws IOException {
        if (exists() || !this.parent.exists()) {
            if (exists() || !CommitConfig$$ExternalSyntheticBackport0.m(toText()).isEmpty()) {
                super.save();
                return;
            }
            return;
        }
        this.parent.save();
    }
}
