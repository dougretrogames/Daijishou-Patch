package org.eclipse.jgit.treewalk;

import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.CoreConfig;

/* INFO: loaded from: classes5.dex */
public class WorkingTreeOptions {
    public static final Config.SectionParser<WorkingTreeOptions> KEY = new WorkingTreeOptions$$ExternalSyntheticLambda0();
    private final CoreConfig.AutoCRLF autoCRLF;
    private final CoreConfig.CheckStat checkStat;
    private final boolean dirNoGitLinks;
    private final CoreConfig.EOL eol;
    private final boolean fileMode;
    private final CoreConfig.HideDotFiles hideDotFiles;
    private final CoreConfig.SymLinks symlinks;

    public static /* synthetic */ WorkingTreeOptions $r8$lambda$j2Epj97OX_i22gHjt540PQL9nwI(Config config) {
        return new WorkingTreeOptions(config);
    }

    private WorkingTreeOptions(Config config) {
        this.fileMode = config.getBoolean(ConfigConstants.CONFIG_CORE_SECTION, ConfigConstants.CONFIG_KEY_FILEMODE, true);
        this.autoCRLF = (CoreConfig.AutoCRLF) config.getEnum(ConfigConstants.CONFIG_CORE_SECTION, null, ConfigConstants.CONFIG_KEY_AUTOCRLF, CoreConfig.AutoCRLF.FALSE);
        this.eol = (CoreConfig.EOL) config.getEnum(ConfigConstants.CONFIG_CORE_SECTION, null, ConfigConstants.CONFIG_KEY_EOL, CoreConfig.EOL.NATIVE);
        this.checkStat = (CoreConfig.CheckStat) config.getEnum(ConfigConstants.CONFIG_CORE_SECTION, null, ConfigConstants.CONFIG_KEY_CHECKSTAT, CoreConfig.CheckStat.DEFAULT);
        this.symlinks = (CoreConfig.SymLinks) config.getEnum(ConfigConstants.CONFIG_CORE_SECTION, null, ConfigConstants.CONFIG_KEY_SYMLINKS, CoreConfig.SymLinks.TRUE);
        this.hideDotFiles = (CoreConfig.HideDotFiles) config.getEnum(ConfigConstants.CONFIG_CORE_SECTION, null, ConfigConstants.CONFIG_KEY_HIDEDOTFILES, CoreConfig.HideDotFiles.DOTGITONLY);
        this.dirNoGitLinks = config.getBoolean(ConfigConstants.CONFIG_CORE_SECTION, null, ConfigConstants.CONFIG_KEY_DIRNOGITLINKS, false);
    }

    public boolean isFileMode() {
        return this.fileMode;
    }

    public CoreConfig.AutoCRLF getAutoCRLF() {
        return this.autoCRLF;
    }

    public CoreConfig.EOL getEOL() {
        return this.eol;
    }

    public CoreConfig.CheckStat getCheckStat() {
        return this.checkStat;
    }

    public CoreConfig.SymLinks getSymLinks() {
        return this.symlinks;
    }

    public CoreConfig.HideDotFiles getHideDotFiles() {
        return this.hideDotFiles;
    }

    public boolean isDirNoGitLinks() {
        return this.dirNoGitLinks;
    }
}
