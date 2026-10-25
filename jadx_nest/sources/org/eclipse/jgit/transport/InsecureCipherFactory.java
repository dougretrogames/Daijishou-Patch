package org.eclipse.jgit.transport;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: classes5.dex */
class InsecureCipherFactory {
    InsecureCipherFactory() {
    }

    static Cipher create(String str) throws NoSuchPaddingException, NoSuchAlgorithmException {
        return Cipher.getInstance(str);
    }
}
