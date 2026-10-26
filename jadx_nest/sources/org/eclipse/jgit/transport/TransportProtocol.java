package org.eclipse.jgit.transport;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import org.eclipse.jgit.errors.NotSupportedException;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Repository;

/* INFO: loaded from: classes5.dex */
public abstract class TransportProtocol {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$TransportProtocol$URIishField;

    public enum URIishField {
        USER,
        PASS,
        HOST,
        PORT,
        PATH;

        /* INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static URIishField[] valuesCustom() {
            URIishField[] uRIishFieldArrValuesCustom = values();
            int length = uRIishFieldArrValuesCustom.length;
            URIishField[] uRIishFieldArr = new URIishField[length];
            System.arraycopy(uRIishFieldArrValuesCustom, 0, uRIishFieldArr, 0, length);
            return uRIishFieldArr;
        }
    }

    public int getDefaultPort() {
        return -1;
    }

    public abstract String getName();

    public abstract Transport open(URIish uRIish, Repository repository, String str) throws NotSupportedException, TransportException;

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$TransportProtocol$URIishField() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$transport$TransportProtocol$URIishField;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[URIishField.valuesCustom().length];
        try {
            iArr2[URIishField.HOST.ordinal()] = 3;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[URIishField.PASS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[URIishField.PATH.ordinal()] = 5;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[URIishField.PORT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[URIishField.USER.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$transport$TransportProtocol$URIishField = iArr2;
        return iArr2;
    }

    public Set<String> getSchemes() {
        return Collections.emptySet();
    }

    public Set<URIishField> getRequiredFields() {
        return Collections.unmodifiableSet(EnumSet.of(URIishField.PATH));
    }

    public Set<URIishField> getOptionalFields() {
        return Collections.emptySet();
    }

    public boolean canHandle(URIish uRIish) {
        return canHandle(uRIish, null, null);
    }

    public boolean canHandle(URIish uRIish, Repository repository, String str) {
        if (!getSchemes().isEmpty() && !getSchemes().contains(uRIish.getScheme())) {
            return false;
        }
        Iterator<URIishField> it = getRequiredFields().iterator();
        while (it.hasNext()) {
            int i = $SWITCH_TABLE$org$eclipse$jgit$transport$TransportProtocol$URIishField()[it.next().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            if (uRIish.getPort() <= 0) {
                                return false;
                            }
                        } else if (i != 5 || uRIish.getPath() == null || uRIish.getPath().length() == 0) {
                            return false;
                        }
                    } else if (uRIish.getHost() == null || uRIish.getHost().length() == 0) {
                        return false;
                    }
                } else if (uRIish.getPass() == null || uRIish.getPass().length() == 0) {
                    return false;
                }
            } else if (uRIish.getUser() == null || uRIish.getUser().length() == 0) {
                return false;
            }
        }
        EnumSet enumSetCopyOf = EnumSet.copyOf((Collection) getRequiredFields());
        enumSetCopyOf.addAll(getOptionalFields());
        if (uRIish.getUser() != null && !enumSetCopyOf.contains(URIishField.USER)) {
            return false;
        }
        if (uRIish.getPass() != null && !enumSetCopyOf.contains(URIishField.PASS)) {
            return false;
        }
        if (uRIish.getHost() != null && !enumSetCopyOf.contains(URIishField.HOST)) {
            return false;
        }
        if (uRIish.getPort() <= 0 || enumSetCopyOf.contains(URIishField.PORT)) {
            return uRIish.getPath() == null || enumSetCopyOf.contains(URIishField.PATH);
        }
        return false;
    }

    public Transport open(URIish uRIish) throws NotSupportedException, TransportException {
        throw new NotSupportedException(JGitText.get().transportNeedsRepository);
    }
}
