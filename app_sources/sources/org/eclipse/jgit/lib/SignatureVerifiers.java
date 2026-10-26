package org.eclipse.jgit.lib;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevTag;
import org.eclipse.jgit.util.RawParseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* INFO: loaded from: classes5.dex */
public final class SignatureVerifiers {
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) SignatureVerifiers.class);
    private static final byte[] PGP_PREFIX = Constants.GPG_SIGNATURE_PREFIX.getBytes(StandardCharsets.US_ASCII);
    private static final byte[] X509_PREFIX = Constants.CMS_SIGNATURE_PREFIX.getBytes(StandardCharsets.US_ASCII);
    private static final byte[] SSH_PREFIX = Constants.SSH_SIGNATURE_PREFIX.getBytes(StandardCharsets.US_ASCII);
    private static final Map<GpgConfig.GpgFormat, SignatureVerifierFactory> FACTORIES = loadSignatureVerifiers();
    private static final Map<GpgConfig.GpgFormat, SignatureVerifier> VERIFIERS = new ConcurrentHashMap();

    private static Map<GpgConfig.GpgFormat, SignatureVerifierFactory> loadSignatureVerifiers() {
        EnumMap enumMap = new EnumMap(GpgConfig.GpgFormat.class);
        try {
            for (SignatureVerifierFactory signatureVerifierFactory : ServiceLoader.load(SignatureVerifierFactory.class)) {
                GpgConfig.GpgFormat type = signatureVerifierFactory.getType();
                SignatureVerifierFactory signatureVerifierFactory2 = (SignatureVerifierFactory) enumMap.get(type);
                if (signatureVerifierFactory2 != null) {
                    LOG.warn("{}", MessageFormat.format(JGitText.get().signatureServiceConflict, "SignatureVerifierFactory", type, signatureVerifierFactory2.getClass().getCanonicalName(), signatureVerifierFactory.getClass().getCanonicalName()));
                } else {
                    enumMap.put(type, signatureVerifierFactory);
                }
            }
            return enumMap;
        } catch (ServiceConfigurationError e) {
            LOG.error(e.getMessage(), (Throwable) e);
            return enumMap;
        }
    }

    private SignatureVerifiers() {
    }

    public static SignatureVerifier get(GpgConfig.GpgFormat gpgFormat) {
        return VERIFIERS.computeIfAbsent(gpgFormat, new SignatureVerifiers$$ExternalSyntheticLambda0(gpgFormat));
    }

    static /* synthetic */ SignatureVerifier lambda$0(GpgConfig.GpgFormat gpgFormat, GpgConfig.GpgFormat gpgFormat2) {
        SignatureVerifierFactory signatureVerifierFactory = FACTORIES.get(gpgFormat);
        if (signatureVerifierFactory == null) {
            return null;
        }
        return signatureVerifierFactory.create();
    }

    public static void set(GpgConfig.GpgFormat gpgFormat, SignatureVerifier signatureVerifier) {
        SignatureVerifier signatureVerifierPut;
        if (signatureVerifier == null) {
            signatureVerifierPut = VERIFIERS.remove(gpgFormat);
        } else {
            signatureVerifierPut = VERIFIERS.put(gpgFormat, signatureVerifier);
        }
        if (signatureVerifierPut != null) {
            signatureVerifierPut.clear();
        }
    }

    @Nullable
    public static SignatureVerifier.SignatureVerification verify(Repository repository, GpgConfig gpgConfig, RevObject revObject) throws IOException {
        RevTag revTag;
        byte[] rawGpgSignature;
        byte[] rawBuffer;
        int iHeaderStart;
        if (revObject instanceof RevCommit) {
            RevCommit revCommit = (RevCommit) revObject;
            byte[] rawGpgSignature2 = revCommit.getRawGpgSignature();
            if (rawGpgSignature2 == null || (iHeaderStart = RawParseUtils.headerStart(new byte[]{103, 112, 103, 115, 105, 103}, (rawBuffer = revCommit.getRawBuffer()), 0)) < 0) {
                return null;
            }
            int iNextLfSkippingSplitLines = RawParseUtils.nextLfSkippingSplitLines(rawBuffer, iHeaderStart);
            int i = iHeaderStart - 7;
            if (iNextLfSkippingSplitLines < rawBuffer.length) {
                iNextLfSkippingSplitLines++;
            }
            byte[] bArr = new byte[rawBuffer.length - (iNextLfSkippingSplitLines - i)];
            System.arraycopy(rawBuffer, 0, bArr, 0, i);
            System.arraycopy(rawBuffer, iNextLfSkippingSplitLines, bArr, i, rawBuffer.length - iNextLfSkippingSplitLines);
            return verify(repository, gpgConfig, bArr, rawGpgSignature2);
        }
        if (!(revObject instanceof RevTag) || (rawGpgSignature = (revTag = (RevTag) revObject).getRawGpgSignature()) == null) {
            return null;
        }
        byte[] rawBuffer2 = revTag.getRawBuffer();
        return verify(repository, gpgConfig, Arrays.copyOfRange(rawBuffer2, 0, rawBuffer2.length - rawGpgSignature.length), rawGpgSignature);
    }

    @Nullable
    public static SignatureVerifier.SignatureVerification verify(Repository repository, GpgConfig gpgConfig, byte[] bArr, byte[] bArr2) throws IOException {
        SignatureVerifier signatureVerifier;
        GpgConfig.GpgFormat format = getFormat(bArr2);
        if (format == null || (signatureVerifier = get(format)) == null) {
            return null;
        }
        return signatureVerifier.verify(repository, gpgConfig, bArr, bArr2);
    }

    @Nullable
    public static GpgConfig.GpgFormat getFormat(byte[] bArr) {
        if (RawParseUtils.match(bArr, 0, PGP_PREFIX) > 0) {
            return GpgConfig.GpgFormat.OPENPGP;
        }
        if (RawParseUtils.match(bArr, 0, X509_PREFIX) > 0) {
            return GpgConfig.GpgFormat.X509;
        }
        if (RawParseUtils.match(bArr, 0, SSH_PREFIX) > 0) {
            return GpgConfig.GpgFormat.SSH;
        }
        return null;
    }
}
