package org.eclipse.jgit.lib;

import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.util.MutableInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class Constants {
    public static final String ATTR_BUILTIN_BINARY_MERGER = "binary";
    public static final String ATTR_BUILTIN_UNION_MERGE_DRIVER = "union";
    public static final String ATTR_DIFF = "diff";
    public static final String ATTR_FILTER = "filter";
    public static final String ATTR_FILTER_TYPE_CLEAN = "clean";
    public static final String ATTR_FILTER_TYPE_SMUDGE = "smudge";
    public static final String ATTR_MERGE = "merge";
    public static final String BUILTIN_FILTER_PREFIX = "jgit://builtin/";
    public static final String CHERRY_PICK_HEAD = "CHERRY_PICK_HEAD";
    public static final String CMS_SIGNATURE_PREFIX = "-----BEGIN SIGNED MESSAGE-----";
    public static final String COMMIT_EDITMSG = "COMMIT_EDITMSG";
    public static final int COMMIT_GENERATION_NOT_COMPUTED = 0;
    public static final int COMMIT_GENERATION_UNKNOWN = Integer.MAX_VALUE;
    public static final String COMMONDIR_FILE = "commondir";
    public static final String CONFIG = "config";
    public static final String DEFAULT_REMOTE_NAME = "origin";
    public static final String DOT_BUNDLE_EXT = ".bundle";
    public static final String DOT_GIT = ".git";
    public static final String DOT_GIT_ATTRIBUTES = ".gitattributes";
    public static final String DOT_GIT_EXT = ".git";
    public static final String DOT_GIT_IGNORE = ".gitignore";
    public static final String DOT_GIT_MODULES = ".gitmodules";
    public static final ObjectId EMPTY_BLOB_ID;
    public static final ObjectId EMPTY_TREE_ID;
    public static final String FETCH_HEAD = "FETCH_HEAD";
    public static final String GITDIR = "gitdir: ";
    public static final String GITDIR_FILE = "gitdir";
    public static final String GITIGNORE_FILENAME = ".gitignore";
    public static final String GIT_ALTERNATE_OBJECT_DIRECTORIES_KEY = "GIT_ALTERNATE_OBJECT_DIRECTORIES";
    public static final String GIT_AUTHOR_EMAIL_KEY = "GIT_AUTHOR_EMAIL";
    public static final String GIT_AUTHOR_NAME_KEY = "GIT_AUTHOR_NAME";
    public static final String GIT_CEILING_DIRECTORIES_KEY = "GIT_CEILING_DIRECTORIES";
    public static final String GIT_COMMITTER_EMAIL_KEY = "GIT_COMMITTER_EMAIL";
    public static final String GIT_COMMITTER_NAME_KEY = "GIT_COMMITTER_NAME";
    public static final String GIT_COMMON_DIR_KEY = "GIT_COMMON_DIR";
    public static final String GIT_CONFIG_NOSYSTEM_KEY = "GIT_CONFIG_NOSYSTEM";
    public static final String GIT_DIR_KEY = "GIT_DIR";
    public static final String GIT_INDEX_FILE_KEY = "GIT_INDEX_FILE";
    public static final String GIT_OBJECT_DIRECTORY_KEY = "GIT_OBJECT_DIRECTORY";
    public static final String GIT_WORK_TREE_KEY = "GIT_WORK_TREE";
    public static final String GPG_SIGNATURE_PREFIX = "-----BEGIN PGP SIGNATURE-----";
    private static final String HASH_FUNCTION = "SHA-1";
    public static final String HEAD = "HEAD";
    public static final String HEADS = "heads";
    public static final String HOOKS = "hooks";
    public static final int INFINITE_DEPTH = Integer.MAX_VALUE;
    public static final String INFO_ALTERNATES = "info/alternates";
    public static final String INFO_ATTRIBUTES = "info/attributes";
    public static final String INFO_COMMIT_GRAPH = "info/commit-graph";
    public static final String INFO_EXCLUDE = "info/exclude";
    public static final String INFO_HTTP_ALTERNATES = "info/http-alternates";
    public static final String INFO_REFS = "info/refs";
    public static final String LOCK_SUFFIX = ".lock";
    public static final String LOGS = "logs";
    public static final String L_LOGS = "logs/";
    public static final String MASTER = "master";
    public static final String MERGE_HEAD = "MERGE_HEAD";
    public static final String MERGE_MSG = "MERGE_MSG";
    public static final String MODULES = "modules";
    public static final String OBJECTS = "objects";
    public static final int OBJECT_ID_ABBREV_STRING_LENGTH = 7;
    public static final int OBJECT_ID_LENGTH = 20;
    public static final int OBJECT_ID_STRING_LENGTH = 40;
    public static final int OBJ_BAD = -1;
    public static final int OBJ_BLOB = 3;
    public static final int OBJ_COMMIT = 1;
    public static final int OBJ_EXT = 0;
    public static final int OBJ_OFS_DELTA = 6;
    public static final int OBJ_REF_DELTA = 7;
    public static final int OBJ_TAG = 4;
    public static final int OBJ_TREE = 2;
    public static final int OBJ_TYPE_5 = 5;
    public static final String ORIG_HEAD = "ORIG_HEAD";
    public static final String OS_USER_DIR = "user.dir";
    public static final String OS_USER_NAME_KEY = "user.name";
    public static final String PACKED_REFS = "packed-refs";
    public static final String REFTABLE = "reftable";
    public static final String REVERT_HEAD = "REVERT_HEAD";
    public static final String R_HEADS = "refs/heads/";
    public static final String R_NOTES = "refs/notes/";
    public static final String R_NOTES_COMMITS = "refs/notes/commits";
    public static final String R_REFS = "refs/";
    public static final String R_REMOTES = "refs/remotes/";
    public static final String R_STASH = "refs/stash";
    public static final String R_TAGS = "refs/tags/";
    public static final String SHALLOW = "shallow";
    public static final String SIGNED_OFF_BY_TAG = "Signed-off-by: ";
    public static final String SQUASH_MSG = "SQUASH_MSG";
    public static final String SSH_SIGNATURE_PREFIX = "-----BEGIN SSH SIGNATURE-----";
    public static final String STASH = "stash";
    public static final String TABLES_LIST = "tables.list";
    public static final String TYPE_COMMIT = "commit";
    public static final String TYPE_TAG = "tag";
    public static final String UNKNOWN_USER_DEFAULT = "unknown-user";
    public static final String XDG_CONFIG_HOME = "XDG_CONFIG_HOME";
    private static final byte[] ENCODED_TYPE_COMMIT = encodeASCII("commit");
    public static final String TYPE_BLOB = "blob";
    private static final byte[] ENCODED_TYPE_BLOB = encodeASCII(TYPE_BLOB);
    public static final String TYPE_TREE = "tree";
    private static final byte[] ENCODED_TYPE_TREE = encodeASCII(TYPE_TREE);
    private static final byte[] ENCODED_TYPE_TAG = encodeASCII("tag");
    public static final byte[] PACK_SIGNATURE = {80, 65, 67, 75};

    static {
        if (20 != newMessageDigest().getDigestLength()) {
            throw new LinkageError(JGitText.get().incorrectOBJECT_ID_LENGTH);
        }
        EMPTY_BLOB_ID = ObjectId.fromString("e69de29bb2d1d6434b8b29ae775ad8c2e48c5391");
        EMPTY_TREE_ID = ObjectId.fromString("4b825dc642cb6eb9a060e54bf8d69288fbee4904");
    }

    public static MessageDigest newMessageDigest() {
        try {
            return MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(MessageFormat.format(JGitText.get().requiredHashFunctionNotAvailable, "SHA-1"), e);
        }
    }

    public static String typeString(int i) {
        if (i == 1) {
            return "commit";
        }
        if (i == 2) {
            return TYPE_TREE;
        }
        if (i == 3) {
            return TYPE_BLOB;
        }
        if (i == 4) {
            return "tag";
        }
        throw new IllegalArgumentException(MessageFormat.format(JGitText.get().badObjectType, Integer.valueOf(i)));
    }

    public static byte[] encodedTypeString(int i) {
        if (i == 1) {
            return ENCODED_TYPE_COMMIT;
        }
        if (i == 2) {
            return ENCODED_TYPE_TREE;
        }
        if (i == 3) {
            return ENCODED_TYPE_BLOB;
        }
        if (i == 4) {
            return ENCODED_TYPE_TAG;
        }
        throw new IllegalArgumentException(MessageFormat.format(JGitText.get().badObjectType, Integer.valueOf(i)));
    }

    public static int decodeTypeString(AnyObjectId anyObjectId, byte[] bArr, byte b, MutableInteger mutableInteger) throws CorruptObjectException {
        try {
            int i = mutableInteger.value;
            byte b2 = bArr[i];
            if (b2 == 98) {
                if (bArr[i + 1] != 108 || bArr[i + 2] != 111 || bArr[i + 3] != 98 || bArr[i + 4] != b) {
                    throw new CorruptObjectException(anyObjectId, JGitText.get().corruptObjectInvalidType);
                }
                mutableInteger.value = i + 5;
                return 3;
            }
            if (b2 == 99) {
                if (bArr[i + 1] != 111 || bArr[i + 2] != 109 || bArr[i + 3] != 109 || bArr[i + 4] != 105 || bArr[i + 5] != 116 || bArr[i + 6] != b) {
                    throw new CorruptObjectException(anyObjectId, JGitText.get().corruptObjectInvalidType);
                }
                mutableInteger.value = i + 7;
                return 1;
            }
            if (b2 == 116) {
                byte b3 = bArr[i + 1];
                if (b3 == 97) {
                    if (bArr[i + 2] != 103 || bArr[i + 3] != b) {
                        throw new CorruptObjectException(anyObjectId, JGitText.get().corruptObjectInvalidType);
                    }
                    mutableInteger.value = i + 4;
                    return 4;
                }
                if (b3 == 114) {
                    if (bArr[i + 2] != 101 || bArr[i + 3] != 101 || bArr[i + 4] != b) {
                        throw new CorruptObjectException(anyObjectId, JGitText.get().corruptObjectInvalidType);
                    }
                    mutableInteger.value = i + 5;
                    return 2;
                }
                throw new CorruptObjectException(anyObjectId, JGitText.get().corruptObjectInvalidType);
            }
            throw new CorruptObjectException(anyObjectId, JGitText.get().corruptObjectInvalidType);
        } catch (ArrayIndexOutOfBoundsException e) {
            CorruptObjectException corruptObjectException = new CorruptObjectException(anyObjectId, JGitText.get().corruptObjectInvalidType);
            corruptObjectException.initCause(e);
            throw corruptObjectException;
        }
    }

    public static byte[] encodeASCII(long j) {
        return encodeASCII(Long.toString(j));
    }

    public static byte[] encodeASCII(String str) {
        try {
            return StandardCharsets.US_ASCII.newEncoder().onUnmappableCharacter(CodingErrorAction.REPORT).onMalformedInput(CodingErrorAction.REPORT).encode(CharBuffer.wrap(str)).array();
        } catch (CharacterCodingException e) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().notASCIIString, str), e);
        }
    }

    public static byte[] encode(String str) {
        return str.getBytes(StandardCharsets.UTF_8);
    }

    private Constants() {
    }
}
