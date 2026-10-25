package com.google.common.io;

import com.google.common.base.StandardSystemProperty;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclEntryFlag;
import java.nio.file.attribute.AclEntryPermission;
import java.nio.file.attribute.AclEntryType;
import java.nio.file.attribute.FileAttribute;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.transport.AmazonS3;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract class TempFileCreator {
    static final TempFileCreator INSTANCE = pickSecureCreator();

    abstract File createTempDir();

    abstract File createTempFile(String prefix) throws IOException;

    /* synthetic */ TempFileCreator(AnonymousClass1 anonymousClass1) {
        this();
    }

    private static TempFileCreator pickSecureCreator() {
        try {
            try {
                Class.forName("java.nio.file.Path");
                return new JavaNioCreator(null);
            } catch (ClassNotFoundException unused) {
                if (((Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null)).intValue() < ((Integer) Class.forName("android.os.Build$VERSION_CODES").getField("JELLY_BEAN").get(null)).intValue()) {
                    return new ThrowingCreator(null);
                }
                return new JavaIoCreator(null);
            }
        } catch (ClassNotFoundException unused2) {
            return new ThrowingCreator(null);
        } catch (IllegalAccessException unused3) {
            return new ThrowingCreator(null);
        } catch (NoSuchFieldException unused4) {
            return new ThrowingCreator(null);
        }
    }

    static void testMakingUserPermissionsFromScratch() throws IOException {
        JavaNioCreator.userPermissions().get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class JavaNioCreator extends TempFileCreator {
        private static final PermissionSupplier directoryPermissions;
        private static final PermissionSupplier filePermissions;

        /* JADX INFO: Access modifiers changed from: private */
        interface PermissionSupplier {
            FileAttribute<?> get() throws IOException;
        }

        static /* synthetic */ FileAttribute lambda$userPermissions$3(FileAttribute fileAttribute) throws IOException {
            return fileAttribute;
        }

        private JavaNioCreator() {
            super(null);
        }

        /* synthetic */ JavaNioCreator(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.io.TempFileCreator
        File createTempDir() {
            try {
                return java.nio.file.Files.createTempDirectory(Paths.get(StandardSystemProperty.JAVA_IO_TMPDIR.value(), new String[0]), null, directoryPermissions.get()).toFile();
            } catch (IOException e) {
                throw new IllegalStateException("Failed to create directory", e);
            }
        }

        @Override // com.google.common.io.TempFileCreator
        File createTempFile(String prefix) throws IOException {
            return java.nio.file.Files.createTempFile(Paths.get(StandardSystemProperty.JAVA_IO_TMPDIR.value(), new String[0]), prefix, null, filePermissions.get()).toFile();
        }

        static {
            Set<String> setSupportedFileAttributeViews = FileSystems.getDefault().supportedFileAttributeViews();
            if (setSupportedFileAttributeViews.contains("posix")) {
                filePermissions = new TempFileCreator$JavaNioCreator$$ExternalSyntheticLambda0();
                directoryPermissions = new TempFileCreator$JavaNioCreator$$ExternalSyntheticLambda1();
            } else if (setSupportedFileAttributeViews.contains(AmazonS3.Keys.ACL)) {
                PermissionSupplier permissionSupplierUserPermissions = userPermissions();
                directoryPermissions = permissionSupplierUserPermissions;
                filePermissions = permissionSupplierUserPermissions;
            } else {
                TempFileCreator$JavaNioCreator$$ExternalSyntheticLambda2 tempFileCreator$JavaNioCreator$$ExternalSyntheticLambda2 = new TempFileCreator$JavaNioCreator$$ExternalSyntheticLambda2();
                directoryPermissions = tempFileCreator$JavaNioCreator$$ExternalSyntheticLambda2;
                filePermissions = tempFileCreator$JavaNioCreator$$ExternalSyntheticLambda2;
            }
        }

        static /* synthetic */ FileAttribute lambda$static$2() throws IOException {
            throw new IOException("unrecognized FileSystem type " + FileSystems.getDefault());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static PermissionSupplier userPermissions() {
            try {
                return new TempFileCreator$JavaNioCreator$$ExternalSyntheticLambda3(new AnonymousClass1(ImmutableList.of(AclEntry.newBuilder().setType(AclEntryType.ALLOW).setPrincipal(FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName(getUsername())).setPermissions(EnumSet.allOf(AclEntryPermission.class)).setFlags(AclEntryFlag.DIRECTORY_INHERIT, AclEntryFlag.FILE_INHERIT).build())));
            } catch (IOException e) {
                return new TempFileCreator$JavaNioCreator$$ExternalSyntheticLambda4(e);
            }
        }

        /* JADX INFO: renamed from: com.google.common.io.TempFileCreator$JavaNioCreator$1, reason: invalid class name */
        class AnonymousClass1 implements FileAttribute<ImmutableList<AclEntry>> {
            final /* synthetic */ ImmutableList val$acl;

            AnonymousClass1(final ImmutableList val$acl) {
                this.val$acl = val$acl;
            }

            @Override // java.nio.file.attribute.FileAttribute
            public String name() {
                return "acl:acl";
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.nio.file.attribute.FileAttribute
            public ImmutableList<AclEntry> value() {
                return this.val$acl;
            }
        }

        static /* synthetic */ FileAttribute lambda$userPermissions$4(IOException iOException) throws IOException {
            throw new IOException("Could not find user", iOException);
        }

        private static String getUsername() {
            String str = (String) Objects.requireNonNull(StandardSystemProperty.USER_NAME.value());
            try {
                Class<?> cls = Class.forName("java.lang.ProcessHandle");
                Class<?> cls2 = Class.forName("java.lang.ProcessHandle$Info");
                Class<?> cls3 = Class.forName("java.util.Optional");
                Method method = cls.getMethod("current", new Class[0]);
                return (String) Objects.requireNonNull(cls3.getMethod("orElse", Object.class).invoke(cls2.getMethod(ConfigConstants.CONFIG_USER_SECTION, new Class[0]).invoke(cls.getMethod("info", new Class[0]).invoke(method.invoke(null, new Object[0]), new Object[0]), new Object[0]), str));
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException unused) {
                return str;
            } catch (InvocationTargetException e) {
                Throwables.throwIfUnchecked(e.getCause());
                return str;
            }
        }
    }

    private static final class JavaIoCreator extends TempFileCreator {
        private static final int TEMP_DIR_ATTEMPTS = 10000;

        private JavaIoCreator() {
            super(null);
        }

        /* synthetic */ JavaIoCreator(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.io.TempFileCreator
        File createTempDir() {
            File file = new File(StandardSystemProperty.JAVA_IO_TMPDIR.value());
            String str = System.currentTimeMillis() + "-";
            for (int i = 0; i < 10000; i++) {
                File file2 = new File(file, str + i);
                if (file2.mkdir()) {
                    return file2;
                }
            }
            throw new IllegalStateException("Failed to create directory within 10000 attempts (tried " + str + "0 to " + str + "9999)");
        }

        @Override // com.google.common.io.TempFileCreator
        File createTempFile(String prefix) throws IOException {
            return File.createTempFile(prefix, null, null);
        }
    }

    private static final class ThrowingCreator extends TempFileCreator {
        private static final String MESSAGE = "Guava cannot securely create temporary files or directories under SDK versions before Jelly Bean. You can create one yourself, either in the insecure default directory or in a more secure directory, such as context.getCacheDir(). For more information, see the Javadoc for Files.createTempDir().";

        private ThrowingCreator() {
            super(null);
        }

        /* synthetic */ ThrowingCreator(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.io.TempFileCreator
        File createTempDir() {
            throw new IllegalStateException(MESSAGE);
        }

        @Override // com.google.common.io.TempFileCreator
        File createTempFile(String prefix) throws IOException {
            throw new IOException(MESSAGE);
        }
    }

    private TempFileCreator() {
    }
}
