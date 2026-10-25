package org.eclipse.jgit.lib;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.TokenParser;
import org.eclipse.jgit.util.IO;
import org.eclipse.jgit.util.RawParseUtils;

/* JADX INFO: loaded from: classes5.dex */
public class RebaseTodoFile {
    private Repository repo;

    public RebaseTodoFile(Repository repository) {
        this.repo = repository;
    }

    public List<RebaseTodoLine> readRebaseTodo(String str, boolean z) throws IOException {
        byte[] fully = IO.readFully(new File(this.repo.getDirectory(), str));
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < fully.length) {
            int iNextLF = RawParseUtils.nextLF(fully, i);
            int i2 = iNextLF - 2;
            if (i2 >= 0 && fully[i2] == 13) {
                i2 = iNextLF - 3;
            }
            if (fully[i] != 35) {
                int iNextParsableToken = nextParsableToken(fully, i, i2);
                if (iNextParsableToken != -1) {
                    RebaseTodoLine line = parseLine(fully, iNextParsableToken, i2);
                    if (line != null) {
                        arrayList.add(line);
                    }
                } else if (z) {
                    arrayList.add(new RebaseTodoLine(RawParseUtils.decode(fully, i, i2 + 1)));
                }
            } else if (z) {
                parseComments(fully, i, arrayList, i2);
            }
            i = iNextLF;
        }
        return arrayList;
    }

    private static void parseComments(byte[] bArr, int i, List<RebaseTodoLine> list, int i2) {
        String strDecode = RawParseUtils.decode(bArr, i, i2 + 1);
        RebaseTodoLine rebaseTodoLine = null;
        try {
            int iNextParsableToken = nextParsableToken(bArr, i + 1, i2);
            if (iNextParsableToken != -1 && (rebaseTodoLine = parseLine(bArr, iNextParsableToken, i2)) != null) {
                rebaseTodoLine.setAction(RebaseTodoLine.Action.COMMENT);
                rebaseTodoLine.setComment(strDecode);
            }
            if (rebaseTodoLine == null) {
                rebaseTodoLine = new RebaseTodoLine(strDecode);
            }
            list.add(rebaseTodoLine);
        } catch (Exception unused) {
            list.add(new RebaseTodoLine(strDecode));
        } catch (Throwable th) {
            if (rebaseTodoLine == null) {
                rebaseTodoLine = new RebaseTodoLine(strDecode);
            }
            list.add(rebaseTodoLine);
            throw th;
        }
    }

    private static int nextParsableToken(byte[] bArr, int i, int i2) {
        while (i <= i2) {
            byte b = bArr[i];
            if (b != 32 && b != 9 && b != 13) {
                break;
            }
            i++;
        }
        if (i > i2) {
            return -1;
        }
        return i;
    }

    private static RebaseTodoLine parseLine(byte[] bArr, int i, int i2) {
        String str;
        int next = RawParseUtils.next(bArr, i, TokenParser.SP);
        int i3 = 0;
        RebaseTodoLine.Action action = null;
        AbbreviatedObjectId abbreviatedObjectIdFromString = null;
        while (i3 < 3 && next <= i2) {
            if (i3 != 0) {
                if (i3 == 1) {
                    next = RawParseUtils.next(bArr, i, TokenParser.SP);
                    if (next > i2 + 1) {
                        str = new String(bArr, i, (i2 - i) + 1, StandardCharsets.UTF_8);
                    } else {
                        str = new String(bArr, i, (next - i) - 1, StandardCharsets.UTF_8);
                    }
                    abbreviatedObjectIdFromString = AbbreviatedObjectId.fromString(str);
                } else if (i3 == 2) {
                    return new RebaseTodoLine(action, abbreviatedObjectIdFromString, RawParseUtils.decode(bArr, i, i2 + 1));
                }
                i3++;
            } else {
                action = RebaseTodoLine.Action.parse(new String(bArr, i, (next - i) - 1, StandardCharsets.UTF_8));
                if (action == null) {
                    return null;
                }
            }
            i = next;
            i3++;
        }
        if (i3 == 2) {
            return new RebaseTodoLine(action, abbreviatedObjectIdFromString, "");
        }
        return null;
    }

    public void writeRebaseTodoFile(String str, List<RebaseTodoLine> list, boolean z) throws IOException {
        Throwable th = null;
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(this.repo.getDirectory(), str), z));
            try {
                StringBuilder sb = new StringBuilder();
                for (RebaseTodoLine rebaseTodoLine : list) {
                    sb.setLength(0);
                    if (RebaseTodoLine.Action.COMMENT.equals(rebaseTodoLine.action)) {
                        sb.append(rebaseTodoLine.getComment());
                    } else {
                        sb.append(rebaseTodoLine.getAction().toToken());
                        sb.append(" ");
                        sb.append(rebaseTodoLine.getCommit().name());
                        sb.append(" ");
                        sb.append(rebaseTodoLine.getShortMessage().trim());
                    }
                    sb.append('\n');
                    bufferedOutputStream.write(Constants.encode(sb.toString()));
                }
            } finally {
                bufferedOutputStream.close();
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
}
