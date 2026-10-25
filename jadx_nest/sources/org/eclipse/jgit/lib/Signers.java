package org.eclipse.jgit.lib;

import java.text.MessageFormat;
import java.util.EnumMap;
import java.util.Map;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.jgit.internal.JGitText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public final class Signers {
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) Signers.class);
    private static final Map<GpgConfig.GpgFormat, SignerFactory> SIGNER_FACTORIES = loadSigners();
    private static final Map<GpgConfig.GpgFormat, Signer> SIGNERS = new ConcurrentHashMap();

    private static Map<GpgConfig.GpgFormat, SignerFactory> loadSigners() {
        EnumMap enumMap = new EnumMap(GpgConfig.GpgFormat.class);
        try {
            for (SignerFactory signerFactory : ServiceLoader.load(SignerFactory.class)) {
                GpgConfig.GpgFormat type = signerFactory.getType();
                SignerFactory signerFactory2 = (SignerFactory) enumMap.get(type);
                if (signerFactory2 != null) {
                    LOG.warn("{}", MessageFormat.format(JGitText.get().signatureServiceConflict, "SignerFactory", type, signerFactory2.getClass().getCanonicalName(), signerFactory.getClass().getCanonicalName()));
                } else {
                    enumMap.put(type, signerFactory);
                }
            }
            return enumMap;
        } catch (ServiceConfigurationError e) {
            LOG.error(e.getMessage(), (Throwable) e);
            return enumMap;
        }
    }

    private Signers() {
    }

    public static Signer get(GpgConfig.GpgFormat gpgFormat) {
        return SIGNERS.computeIfAbsent(gpgFormat, new Signers$$ExternalSyntheticLambda0(gpgFormat));
    }

    static /* synthetic */ Signer lambda$0(GpgConfig.GpgFormat gpgFormat, GpgConfig.GpgFormat gpgFormat2) {
        SignerFactory signerFactory = SIGNER_FACTORIES.get(gpgFormat);
        if (signerFactory == null) {
            return null;
        }
        return signerFactory.create();
    }

    public static void set(GpgConfig.GpgFormat gpgFormat, Signer signer) {
        if (signer == null) {
            SIGNERS.remove(gpgFormat);
        } else {
            SIGNERS.put(gpgFormat, signer);
        }
    }
}
