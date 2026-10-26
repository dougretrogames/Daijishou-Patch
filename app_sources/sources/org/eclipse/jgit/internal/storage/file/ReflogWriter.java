package org.eclipse.jgit.internal.storage.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.text.MessageFormat;
import org.apache.http.message.TokenParser;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.CoreConfig;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefUpdate;
import org.eclipse.jgit.lib.ReflogEntry;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.util.FileUtils;

/* INFO: loaded from: classes5.dex */
public class ReflogWriter {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$CoreConfig$LogRefUpdates;
    private final boolean forceWrite;
    private final RefDirectory refdb;

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$CoreConfig$LogRefUpdates() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$lib$CoreConfig$LogRefUpdates;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[CoreConfig.LogRefUpdates.valuesCustom().length];
        try {
            iArr2[CoreConfig.LogRefUpdates.ALWAYS.ordinal()] = 3;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[CoreConfig.LogRefUpdates.FALSE.ordinal()] = 1;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[CoreConfig.LogRefUpdates.TRUE.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$lib$CoreConfig$LogRefUpdates = iArr2;
        return iArr2;
    }

    public static String refLockFor(String str) {
        return str + Constants.LOCK_SUFFIX;
    }

    public ReflogWriter(RefDirectory refDirectory) {
        this(refDirectory, false);
    }

    public ReflogWriter(RefDirectory refDirectory, boolean z) {
        this.refdb = refDirectory;
        this.forceWrite = z;
    }

    public ReflogWriter create() throws IOException {
        FileUtils.mkdir(this.refdb.logsDir);
        FileUtils.mkdir(this.refdb.logsRefsDir);
        FileUtils.mkdir(new File(this.refdb.logsRefsDir, Constants.R_HEADS.substring(Constants.R_REFS.length())));
        return this;
    }

    public ReflogWriter log(String str, ReflogEntry reflogEntry) throws IOException {
        return log(str, reflogEntry.getOldId(), reflogEntry.getNewId(), reflogEntry.getWho(), reflogEntry.getComment());
    }

    public ReflogWriter log(String str, ObjectId objectId, ObjectId objectId2, PersonIdent personIdent, String str2) throws IOException {
        return log(str, encode(objectId, objectId2, personIdent, str2));
    }

    public ReflogWriter log(RefUpdate refUpdate, String str, boolean z) throws IOException {
        PersonIdent personIdent;
        ObjectId oldObjectId = refUpdate.getOldObjectId();
        ObjectId newObjectId = refUpdate.getNewObjectId();
        Ref ref = refUpdate.getRef();
        PersonIdent refLogIdent = refUpdate.getRefLogIdent();
        if (refLogIdent == null) {
            personIdent = new PersonIdent(this.refdb.getRepository());
        } else {
            personIdent = new PersonIdent(refLogIdent);
        }
        byte[] bArrEncode = encode(oldObjectId, newObjectId, personIdent, str);
        if (z && ref.isSymbolic()) {
            log(ref.getName(), bArrEncode);
            log(ref.getLeaf().getName(), bArrEncode);
            return this;
        }
        log(ref.getName(), bArrEncode);
        return this;
    }

    private byte[] encode(ObjectId objectId, ObjectId objectId2, PersonIdent personIdent, String str) {
        return Constants.encode(ObjectId.toString(objectId) + TokenParser.SP + ObjectId.toString(objectId2) + TokenParser.SP + personIdent.toExternalString() + '\t' + str.replace("\r\n", " ").replace("\n", " ") + '\n');
    }

    private FileOutputStream getFileOutputStream(File file) throws IOException {
        try {
            return new FileOutputStream(file, true);
        } catch (FileNotFoundException e) {
            File parentFile = file.getParentFile();
            if (parentFile.exists()) {
                throw e;
            }
            if (!parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException(MessageFormat.format(JGitText.get().cannotCreateDirectory, parentFile));
            }
            return new FileOutputStream(file, true);
        }
    }

    private ReflogWriter log(String str, byte[] bArr) throws IOException {
        File fileLogFor = this.refdb.logFor(str);
        if (!this.forceWrite && !shouldAutoCreateLog(str) && !fileLogFor.isFile()) {
            return this;
        }
        WriteConfig writeConfig = (WriteConfig) this.refdb.getRepository().getConfig().get(WriteConfig.KEY);
        Throwable th = null;
        try {
            FileOutputStream fileOutputStream = getFileOutputStream(fileLogFor);
            try {
                if (writeConfig.getFSyncRefFiles()) {
                    FileChannel channel = fileOutputStream.getChannel();
                    ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                    while (byteBufferWrap.remaining() > 0) {
                        channel.write(byteBufferWrap);
                    }
                    channel.force(true);
                } else {
                    fileOutputStream.write(bArr);
                }
                return this;
            } finally {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                th.addSuppressed(th2);
            }
            throw null;
        }
    }

    private boolean shouldAutoCreateLog(String str) {
        CoreConfig.LogRefUpdates logRefUpdates;
        Repository repository = this.refdb.getRepository();
        if (repository.isBare()) {
            logRefUpdates = CoreConfig.LogRefUpdates.FALSE;
        } else {
            logRefUpdates = CoreConfig.LogRefUpdates.TRUE;
        }
        CoreConfig.LogRefUpdates logRefUpdates2 = (CoreConfig.LogRefUpdates) repository.getConfig().getEnum(ConfigConstants.CONFIG_CORE_SECTION, null, ConfigConstants.CONFIG_KEY_LOGALLREFUPDATES, logRefUpdates);
        if (logRefUpdates2 != null) {
            int i = $SWITCH_TABLE$org$eclipse$jgit$lib$CoreConfig$LogRefUpdates()[logRefUpdates2.ordinal()];
            if (i == 2) {
                return str.equals("HEAD") || str.startsWith(Constants.R_HEADS) || str.startsWith(Constants.R_REMOTES) || str.startsWith(Constants.R_NOTES);
            }
            if (i == 3) {
                return str.equals("HEAD") || str.startsWith(Constants.R_REFS);
            }
        }
        return false;
    }
}
