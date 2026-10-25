package org.eclipse.jgit.transport;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.storage.pack.PackConfig;
import org.eclipse.jgit.util.Base64;
import org.eclipse.jgit.util.Hex;

/* JADX INFO: loaded from: classes5.dex */
abstract class WalkEncryption {
    static final String JETS3T_CRYPTO_ALG = "jets3t-crypto-alg";
    static final String JETS3T_CRYPTO_VER = "jets3t-crypto-ver";
    static final WalkEncryption NONE = new NoEncryption(null);

    interface Keys {
        public static final String JGIT_CONTEXT = "jgit-crypto-context";
        public static final String JGIT_PROFILE = "jgit-crypto-profile";
        public static final String JGIT_VERSION = "jgit-crypto-version";
        public static final String X_ALGO = ".algo";
        public static final String X_KEY_ALGO = ".key.algo";
        public static final String X_KEY_ITER = ".key.iter";
        public static final String X_KEY_SALT = ".key.salt";
        public static final String X_KEY_SIZE = ".key.size";
    }

    interface Vals {
        public static final String DEFAULT_ALGO = "PBEWithMD5AndDES";
        public static final String DEFAULT_KEY_ALGO = "PBEWithMD5AndDES";
        public static final String DEFAULT_VERS = "0";
        public static final String EMPTY = "";
        public static final String REGEX_PBE = "(PBE).*(WITH).+(AND).+";
        public static final String REGEX_TRANS = "(.+)/(.+)/(.+)";
        public static final String REGEX_WS = "\\s+";
        public static final String DEFAULT_KEY_SIZE = Integer.toString(32);
        public static final String DEFAULT_KEY_ITER = Integer.toString(PackConfig.DEFAULT_BITMAP_DISTANT_COMMIT_SPAN);
        public static final String DEFAULT_KEY_SALT = Hex.toHexString(JetS3tV2.SALT);
    }

    abstract InputStream decrypt(InputStream inputStream) throws IOException;

    abstract OutputStream encrypt(OutputStream outputStream) throws IOException;

    abstract void request(HttpURLConnection httpURLConnection, String str) throws IOException;

    abstract void validate(HttpURLConnection httpURLConnection, String str) throws IOException;

    WalkEncryption() {
    }

    protected void validateImpl(HttpURLConnection httpURLConnection, String str, String str2, String str3) throws IOException {
        String headerField = httpURLConnection.getHeaderField(str + JETS3T_CRYPTO_VER);
        if (headerField == null) {
            headerField = "";
        }
        if (!str2.equals(headerField)) {
            throw new IOException(MessageFormat.format(JGitText.get().unsupportedEncryptionVersion, headerField));
        }
        String headerField2 = httpURLConnection.getHeaderField(str + JETS3T_CRYPTO_ALG);
        String str4 = headerField2 != null ? headerField2 : "";
        if (!str3.equalsIgnoreCase(str4)) {
            throw new IOException(MessageFormat.format(JGitText.get().unsupportedEncryptionAlgorithm, str4));
        }
    }

    IOException error(Throwable th) {
        return new IOException(MessageFormat.format(JGitText.get().encryptionError, th.getMessage()), th);
    }

    private static class NoEncryption extends WalkEncryption {
        /* synthetic */ NoEncryption(WalkEncryptionIA walkEncryptionIA) {
            this();
        }

        @Override // org.eclipse.jgit.transport.WalkEncryption
        InputStream decrypt(InputStream inputStream) {
            return inputStream;
        }

        @Override // org.eclipse.jgit.transport.WalkEncryption
        OutputStream encrypt(OutputStream outputStream) {
            return outputStream;
        }

        @Override // org.eclipse.jgit.transport.WalkEncryption
        void request(HttpURLConnection httpURLConnection, String str) {
        }

        private NoEncryption() {
        }

        @Override // org.eclipse.jgit.transport.WalkEncryption
        void validate(HttpURLConnection httpURLConnection, String str) throws IOException {
            validateImpl(httpURLConnection, str, "", "");
        }
    }

    static class JetS3tV2 extends WalkEncryption {
        static final String ALGORITHM = "PBEWithMD5AndDES";
        private static final String CRYPTO_VER = "2";
        static final int ITERATIONS = 5000;
        static final int KEY_SIZE = 32;
        static final String VERSION = "2";
        private final String cryptoAlg;
        private final AlgorithmParameterSpec paramSpec;
        private final SecretKey secretKey;
        static final byte[] SALT = {-92, Ascii.VT, -56, 52, -42, -107, -13, 19};
        static final byte[] ZERO_AES_IV = new byte[16];

        JetS3tV2(String str, String str2) throws GeneralSecurityException {
            this.cryptoAlg = str;
            Cipher cipherCreate = InsecureCipherFactory.create(str);
            String upperCase = str.toUpperCase(Locale.ROOT);
            if (!upperCase.startsWith("PBE")) {
                throw new GeneralSecurityException(JGitText.get().encryptionOnlyPBE);
            }
            char[] charArray = str2.toCharArray();
            byte[] bArr = SALT;
            SecretKey secretKeyGenerateSecret = SecretKeyFactory.getInstance(str).generateSecret(new PBEKeySpec(charArray, bArr, 5000, 32));
            this.secretKey = secretKeyGenerateSecret;
            if (upperCase.contains("AES")) {
                this.paramSpec = new PBEParameterSpec(bArr, 5000, new IvParameterSpec(ZERO_AES_IV));
            } else {
                this.paramSpec = new PBEParameterSpec(bArr, 5000);
            }
            cipherCreate.init(1, secretKeyGenerateSecret, this.paramSpec);
            cipherCreate.doFinal();
        }

        @Override // org.eclipse.jgit.transport.WalkEncryption
        void request(HttpURLConnection httpURLConnection, String str) {
            httpURLConnection.setRequestProperty(str + WalkEncryption.JETS3T_CRYPTO_VER, ExifInterface.GPS_MEASUREMENT_2D);
            httpURLConnection.setRequestProperty(str + WalkEncryption.JETS3T_CRYPTO_ALG, this.cryptoAlg);
        }

        @Override // org.eclipse.jgit.transport.WalkEncryption
        void validate(HttpURLConnection httpURLConnection, String str) throws IOException {
            validateImpl(httpURLConnection, str, ExifInterface.GPS_MEASUREMENT_2D, this.cryptoAlg);
        }

        @Override // org.eclipse.jgit.transport.WalkEncryption
        OutputStream encrypt(OutputStream outputStream) throws IOException {
            try {
                Cipher cipherCreate = InsecureCipherFactory.create(this.cryptoAlg);
                cipherCreate.init(1, this.secretKey, this.paramSpec);
                return new CipherOutputStream(outputStream, cipherCreate);
            } catch (GeneralSecurityException e) {
                throw error(e);
            }
        }

        @Override // org.eclipse.jgit.transport.WalkEncryption
        InputStream decrypt(InputStream inputStream) throws IOException {
            try {
                Cipher cipherCreate = InsecureCipherFactory.create(this.cryptoAlg);
                cipherCreate.init(2, this.secretKey, this.paramSpec);
                return new CipherInputStream(inputStream, cipherCreate);
            } catch (GeneralSecurityException e) {
                throw error(e);
            }
        }
    }

    static GeneralSecurityException securityError(String str, Throwable th) {
        GeneralSecurityException generalSecurityException = new GeneralSecurityException(MessageFormat.format(JGitText.get().encryptionError, str));
        generalSecurityException.initCause(th);
        return generalSecurityException;
    }

    static abstract class SymmetricEncryption extends WalkEncryption implements Keys, Vals {
        final String cipherAlgo;
        volatile String context;
        volatile Cipher decryptCipher;
        final String paramsAlgo;
        final String profile;
        final SecretKey secretKey;
        final String version;

        SymmetricEncryption(Properties properties) throws GeneralSecurityException {
            String property = properties.getProperty(AmazonS3.Keys.CRYPTO_ALG);
            this.profile = property;
            this.version = properties.getProperty(AmazonS3.Keys.CRYPTO_VER);
            String property2 = properties.getProperty("password");
            String property3 = properties.getProperty(property + Keys.X_ALGO, "PBEWithMD5AndDES");
            this.cipherAlgo = property3;
            String property4 = properties.getProperty(property + Keys.X_KEY_ALGO, "PBEWithMD5AndDES");
            String property5 = properties.getProperty(property + Keys.X_KEY_SIZE, DEFAULT_KEY_SIZE);
            String property6 = properties.getProperty(property + Keys.X_KEY_ITER, DEFAULT_KEY_ITER);
            String property7 = properties.getProperty(property + Keys.X_KEY_SALT, DEFAULT_KEY_SALT);
            Cipher cipherCreate = InsecureCipherFactory.create(property3);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(property4);
            try {
                int i = Integer.parseInt(property5);
                try {
                    try {
                        SecretKey secretKeyGenerateSecret = secretKeyFactory.generateSecret(new PBEKeySpec(property2.toCharArray(), Hex.decode(property7.replaceAll(Vals.REGEX_WS, "")), Integer.parseInt(property6), i));
                        String upperCase = property3.toUpperCase(Locale.ROOT);
                        Matcher matcher = Pattern.compile(Vals.REGEX_PBE).matcher(upperCase);
                        Matcher matcher2 = Pattern.compile(Vals.REGEX_TRANS).matcher(upperCase);
                        if (matcher.matches()) {
                            this.paramsAlgo = property3;
                            this.secretKey = secretKeyGenerateSecret;
                        } else if (matcher2.find()) {
                            String strGroup = matcher2.group(1);
                            this.paramsAlgo = strGroup;
                            this.secretKey = new SecretKeySpec(secretKeyGenerateSecret.getEncoded(), strGroup);
                        } else {
                            throw new GeneralSecurityException(MessageFormat.format(JGitText.get().unsupportedEncryptionAlgorithm, property3));
                        }
                        cipherCreate.init(1, this.secretKey);
                        cipherCreate.doFinal();
                    } catch (Exception e) {
                        throw securityError(Keys.X_KEY_SALT + property7, e);
                    }
                } catch (Exception e2) {
                    throw securityError(Keys.X_KEY_ITER + property6, e2);
                }
            } catch (Exception e3) {
                throw securityError(Keys.X_KEY_SIZE + property5, e3);
            }
        }

        @Override // org.eclipse.jgit.transport.WalkEncryption
        OutputStream encrypt(OutputStream outputStream) throws IOException {
            try {
                Cipher cipherCreate = InsecureCipherFactory.create(this.cipherAlgo);
                cipherCreate.init(1, this.secretKey);
                AlgorithmParameters parameters = cipherCreate.getParameters();
                if (parameters == null) {
                    this.context = "";
                } else {
                    this.context = Base64.encodeBytes(parameters.getEncoded());
                }
                return new CipherOutputStream(outputStream, cipherCreate);
            } catch (Exception e) {
                throw error(e);
            }
        }

        @Override // org.eclipse.jgit.transport.WalkEncryption
        void request(HttpURLConnection httpURLConnection, String str) throws IOException {
            httpURLConnection.setRequestProperty(str + Keys.JGIT_PROFILE, this.profile);
            httpURLConnection.setRequestProperty(str + Keys.JGIT_VERSION, this.version);
            httpURLConnection.setRequestProperty(str + Keys.JGIT_CONTEXT, this.context);
        }

        @Override // org.eclipse.jgit.transport.WalkEncryption
        void validate(HttpURLConnection httpURLConnection, String str) throws IOException {
            String headerField = httpURLConnection.getHeaderField(str + Keys.JGIT_PROFILE);
            String headerField2 = httpURLConnection.getHeaderField(str + Keys.JGIT_VERSION);
            String headerField3 = httpURLConnection.getHeaderField(str + Keys.JGIT_CONTEXT);
            if (headerField == null) {
                throw new IOException(MessageFormat.format(JGitText.get().encryptionError, Keys.JGIT_PROFILE));
            }
            if (headerField2 == null) {
                throw new IOException(MessageFormat.format(JGitText.get().encryptionError, Keys.JGIT_VERSION));
            }
            if (headerField3 == null) {
                throw new IOException(MessageFormat.format(JGitText.get().encryptionError, Keys.JGIT_CONTEXT));
            }
            if (!this.profile.equals(headerField)) {
                throw new IOException(MessageFormat.format(JGitText.get().unsupportedEncryptionAlgorithm, headerField));
            }
            if (!this.version.equals(headerField2)) {
                throw new IOException(MessageFormat.format(JGitText.get().unsupportedEncryptionVersion, headerField2));
            }
            try {
                this.decryptCipher = InsecureCipherFactory.create(this.cipherAlgo);
                if (headerField3.isEmpty()) {
                    this.decryptCipher.init(2, this.secretKey);
                    return;
                }
                AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance(this.paramsAlgo);
                algorithmParameters.init(Base64.decode(headerField3));
                this.decryptCipher.init(2, this.secretKey, algorithmParameters);
            } catch (Exception e) {
                throw error(e);
            }
        }

        @Override // org.eclipse.jgit.transport.WalkEncryption
        InputStream decrypt(InputStream inputStream) throws IOException {
            try {
                return new CipherInputStream(inputStream, this.decryptCipher);
            } finally {
                this.decryptCipher = null;
            }
        }
    }

    static class JGitV1 extends SymmetricEncryption {
        static final String VERSION = "1";

        static Properties wrap(String str, String str2) {
            Properties properties = new Properties();
            properties.put(AmazonS3.Keys.CRYPTO_ALG, str);
            properties.put(AmazonS3.Keys.CRYPTO_VER, VERSION);
            properties.put("password", str2);
            properties.put(str + Keys.X_ALGO, str);
            properties.put(str + Keys.X_KEY_ALGO, str);
            properties.put(str + Keys.X_KEY_ITER, DEFAULT_KEY_ITER);
            properties.put(str + Keys.X_KEY_SIZE, DEFAULT_KEY_SIZE);
            properties.put(str + Keys.X_KEY_SALT, DEFAULT_KEY_SALT);
            return properties;
        }

        JGitV1(String str, String str2) throws GeneralSecurityException {
            super(wrap(str, str2));
            if (!Pattern.compile(Vals.REGEX_PBE).matcher(this.cipherAlgo.toUpperCase(Locale.ROOT)).matches()) {
                throw new GeneralSecurityException(JGitText.get().encryptionOnlyPBE);
            }
        }
    }

    static class JGitV2 extends SymmetricEncryption {
        static final String VERSION = "2";

        JGitV2(Properties properties) throws GeneralSecurityException {
            super(properties);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    static WalkEncryption instance(Properties properties) throws GeneralSecurityException {
        String property = properties.getProperty(AmazonS3.Keys.CRYPTO_ALG, "PBEWithMD5AndDES");
        String property2 = properties.getProperty(AmazonS3.Keys.CRYPTO_VER, "0");
        String property3 = properties.getProperty("password");
        if (property3 == null) {
            return NONE;
        }
        switch (property2.hashCode()) {
            case 48:
                if (property2.equals("0")) {
                    return new JetS3tV2(property, property3);
                }
                break;
            case 49:
                if (property2.equals("1")) {
                    return new JGitV1(property, property3);
                }
                break;
            case 50:
                if (property2.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                    return new JGitV2(properties);
                }
                break;
        }
        throw new GeneralSecurityException(MessageFormat.format(JGitText.get().unsupportedEncryptionVersion, property2));
    }
}
