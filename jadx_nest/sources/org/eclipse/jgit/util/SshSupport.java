package org.eclipse.jgit.util;

import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.errors.CommandFailedException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.RemoteSession;
import org.eclipse.jgit.transport.SshSessionFactory;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.util.io.MessageWriter;
import org.eclipse.jgit.util.io.StreamCopyThread;

/* INFO: loaded from: classes5.dex */
public class SshSupport {
    /* WARN: Code duplicated, block: B:102:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* WARN: Code duplicated, block: B:104:? A[SYNTHETIC] */
    /* WARN: Code duplicated, block: B:67:0x00eb A[Catch: IllegalThreadStateException -> 0x010a, TryCatch #1 {IllegalThreadStateException -> 0x010a, blocks: (B:65:0x00e5, B:67:0x00eb, B:68:0x0106), top: B:81:0x00e5 }] */
    /* WARN: Code duplicated, block: B:74:0x012c  */
    /* WARN: Code duplicated, block: B:81:0x00e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* WARN: Code duplicated, block: B:96:0x00dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* WARN: Multi-variable type inference failed */
    public static String runSshCommand(URIish uRIish, @Nullable CredentialsProvider credentialsProvider, FS fs, String str, int i) throws Throwable {
        RemoteSession session;
        Process processExec;
        StreamCopyThread streamCopyThread;
        int iCheckTimeout;
        StreamCopyThread streamCopyThread2;
        String string;
        boolean zWaitFor;
        MessageWriter messageWriter = new MessageWriter();
        MessageWriter messageWriter2 = new MessageWriter();
        StreamCopyThread streamCopyThread3 = null;
        CommandFailedException commandFailedException = null;
        streamCopyThread3 = null;
        try {
            long jNanoTime = System.nanoTime();
            session = SshSessionFactory.getInstance().getSession(uRIish, credentialsProvider, fs, i * 1000);
            if (i > 0) {
                try {
                    iCheckTimeout = checkTimeout(str, i, jNanoTime);
                } catch (Throwable th) {
                    th = th;
                    processExec = null;
                    streamCopyThread = processExec;
                    if (streamCopyThread3 != null) {
                        try {
                            streamCopyThread3.halt();
                        } catch (InterruptedException unused) {
                        }
                    }
                    if (streamCopyThread != 0) {
                        try {
                            streamCopyThread.halt();
                        } catch (InterruptedException unused2) {
                        }
                    }
                    if (processExec != null) {
                        try {
                            if (processExec.exitValue() != 0) {
                                new CommandFailedException(processExec.exitValue(), MessageFormat.format(JGitText.get().sshCommandFailed, str, messageWriter.toString()));
                            }
                            messageWriter2.toString();
                        } catch (IllegalThreadStateException unused3) {
                            new CommandFailedException(0, MessageFormat.format(JGitText.get().sshCommandTimeout, str, Integer.valueOf(i)));
                        }
                        processExec.destroy();
                    }
                    messageWriter.close();
                    messageWriter2.close();
                    if (session == null) {
                        throw th;
                    }
                    SshSessionFactory.getInstance().releaseSession(session);
                    throw th;
                }
            } else {
                iCheckTimeout = i;
            }
            processExec = session.exec(str, iCheckTimeout);
            if (i > 0) {
                try {
                    iCheckTimeout = checkTimeout(str, i, jNanoTime);
                } catch (Throwable th2) {
                    th = th2;
                    streamCopyThread = 0;
                    if (streamCopyThread3 != null) {
                        streamCopyThread3.halt();
                    }
                    if (streamCopyThread != 0) {
                        streamCopyThread.halt();
                    }
                    if (processExec != null) {
                        if (processExec.exitValue() != 0) {
                            new CommandFailedException(processExec.exitValue(), MessageFormat.format(JGitText.get().sshCommandFailed, str, messageWriter.toString()));
                        }
                        messageWriter2.toString();
                        processExec.destroy();
                    }
                    messageWriter.close();
                    messageWriter2.close();
                    if (session == null) {
                        throw th;
                    }
                    SshSessionFactory.getInstance().releaseSession(session);
                    throw th;
                }
            }
            StreamCopyThread streamCopyThread4 = new StreamCopyThread(processExec.getErrorStream(), messageWriter.getRawStream());
            try {
                streamCopyThread4.start();
                streamCopyThread2 = new StreamCopyThread(processExec.getInputStream(), messageWriter2.getRawStream());
                try {
                    streamCopyThread2.start();
                    try {
                        if (i <= 0) {
                            processExec.waitFor();
                            zWaitFor = true;
                        } else {
                            zWaitFor = processExec.waitFor(iCheckTimeout, TimeUnit.SECONDS);
                        }
                        string = zWaitFor ? messageWriter2.toString() : null;
                    } catch (InterruptedException unused4) {
                    }
                    try {
                        streamCopyThread4.halt();
                    } catch (InterruptedException unused5) {
                    }
                    try {
                        streamCopyThread2.halt();
                    } catch (InterruptedException unused6) {
                    }
                    if (processExec != null) {
                        try {
                            commandFailedException = processExec.exitValue() != 0 ? new CommandFailedException(processExec.exitValue(), MessageFormat.format(JGitText.get().sshCommandFailed, str, messageWriter.toString())) : null;
                            string = messageWriter2.toString();
                        } catch (IllegalThreadStateException unused7) {
                            commandFailedException = new CommandFailedException(0, MessageFormat.format(JGitText.get().sshCommandTimeout, str, Integer.valueOf(i)));
                        }
                        processExec.destroy();
                    }
                    messageWriter.close();
                    messageWriter2.close();
                    if (session != null) {
                        SshSessionFactory.getInstance().releaseSession(session);
                    }
                    if (commandFailedException == null) {
                        return string;
                    }
                    throw commandFailedException;
                } catch (Throwable th3) {
                    th = th3;
                    streamCopyThread3 = streamCopyThread4;
                    streamCopyThread = streamCopyThread2;
                    if (streamCopyThread3 != null) {
                        streamCopyThread3.halt();
                    }
                    if (streamCopyThread != 0) {
                        streamCopyThread.halt();
                    }
                    if (processExec != null) {
                        if (processExec.exitValue() != 0) {
                            new CommandFailedException(processExec.exitValue(), MessageFormat.format(JGitText.get().sshCommandFailed, str, messageWriter.toString()));
                        }
                        messageWriter2.toString();
                        processExec.destroy();
                    }
                    messageWriter.close();
                    messageWriter2.close();
                    if (session == null) {
                        throw th;
                    }
                    SshSessionFactory.getInstance().releaseSession(session);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                streamCopyThread2 = null;
            }
        } catch (Throwable th5) {
            th = th5;
            session = null;
            processExec = null;
        }
    }

    private static int checkTimeout(String str, int i, long j) throws CommandFailedException {
        int seconds = i - ((int) TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - j));
        if (seconds > 0) {
            return seconds;
        }
        throw new CommandFailedException(0, MessageFormat.format(JGitText.get().sshCommandTimeout, str, Integer.valueOf(i)));
    }
}
