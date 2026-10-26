package org.eclipse.jgit.transport;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class Daemon$Acceptor$$ExternalSyntheticLambda0 implements Thread.UncaughtExceptionHandler {
    public final /* synthetic */ Daemon.Acceptor f$0;

    public /* synthetic */ Daemon$Acceptor$$ExternalSyntheticLambda0(Daemon.Acceptor acceptor) {
        this.f$0 = acceptor;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        this.f$0.m5805lambda$0$orgeclipsejgittransportDaemon$Acceptor(thread, th);
    }
}
