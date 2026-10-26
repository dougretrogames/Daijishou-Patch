package org.apache.http;

/* INFO: loaded from: classes5.dex */
public interface ExceptionLogger {
    public static final ExceptionLogger NO_OP = new AnonymousClass1();
    public static final ExceptionLogger STD_ERR = new AnonymousClass2();

    void log(Exception exc);

    /* INFO: renamed from: org.apache.http.ExceptionLogger$1, reason: invalid class name */
    static class AnonymousClass1 implements ExceptionLogger {
        @Override // org.apache.http.ExceptionLogger
        public void log(Exception exc) {
        }

        AnonymousClass1() {
        }
    }

    /* INFO: renamed from: org.apache.http.ExceptionLogger$2, reason: invalid class name */
    static class AnonymousClass2 implements ExceptionLogger {
        AnonymousClass2() {
        }

        @Override // org.apache.http.ExceptionLogger
        public void log(Exception exc) {
            exc.printStackTrace();
        }
    }
}
