package kr.motd.maven.os;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.codec.language.Soundex;
import org.eclipse.jgit.transport.WalkEncryption;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Detector {
    public static final String DETECTED_ARCH = "os.detected.arch";
    public static final String DETECTED_BITNESS = "os.detected.bitness";
    public static final String DETECTED_CLASSIFIER = "os.detected.classifier";
    public static final String DETECTED_NAME = "os.detected.name";
    public static final String DETECTED_RELEASE = "os.detected.release";
    public static final String DETECTED_RELEASE_LIKE_PREFIX = "os.detected.release.like.";
    public static final String DETECTED_RELEASE_VERSION = "os.detected.release.version";
    public static final String DETECTED_VERSION = "os.detected.version";
    public static final String DETECTED_VERSION_MAJOR = "os.detected.version.major";
    public static final String DETECTED_VERSION_MINOR = "os.detected.version.minor";
    private static final String LINUX_ID_LIKE_PREFIX = "ID_LIKE=";
    private static final String LINUX_ID_PREFIX = "ID=";
    private static final String LINUX_VERSION_ID_PREFIX = "VERSION_ID=";
    private static final String REDHAT_RELEASE_FILE = "/etc/redhat-release";
    private static final String UNKNOWN = "unknown";
    private final FileOperationProvider fileOperationProvider;
    private final SystemPropertyOperationProvider systemPropertyOperationProvider;
    private static final String[] LINUX_OS_RELEASE_FILES = {"/etc/os-release", "/usr/lib/os-release"};
    private static final String[] DEFAULT_REDHAT_VARIANTS = {"rhel", "fedora"};
    private static final Pattern VERSION_REGEX = Pattern.compile("((\\d+)\\.(\\d+)).*");
    private static final Pattern REDHAT_MAJOR_VERSION_REGEX = Pattern.compile("(\\d+)");

    protected abstract void log(String str);

    protected abstract void logProperty(String str, String str2);

    public Detector() {
        this(new SimpleSystemPropertyOperations(null), new SimpleFileOperations(null));
    }

    public Detector(SystemPropertyOperationProvider systemPropertyOperationProvider, FileOperationProvider fileOperationProvider) {
        this.systemPropertyOperationProvider = systemPropertyOperationProvider;
        this.fileOperationProvider = fileOperationProvider;
    }

    protected void detect(Properties properties, List<String> list) {
        log("------------------------------------------------------------------------");
        log("Detecting the operating system and CPU architecture");
        log("------------------------------------------------------------------------");
        String systemProperty = this.systemPropertyOperationProvider.getSystemProperty("os.name");
        String systemProperty2 = this.systemPropertyOperationProvider.getSystemProperty("os.arch");
        String systemProperty3 = this.systemPropertyOperationProvider.getSystemProperty("os.version");
        String strNormalizeOs = normalizeOs(systemProperty);
        String strNormalizeArch = normalizeArch(systemProperty2);
        int iDetermineBitness = determineBitness(strNormalizeArch);
        setProperty(properties, DETECTED_NAME, strNormalizeOs);
        setProperty(properties, DETECTED_ARCH, strNormalizeArch);
        setProperty(properties, DETECTED_BITNESS, "" + iDetermineBitness);
        Matcher matcher = VERSION_REGEX.matcher(systemProperty3);
        if (matcher.matches()) {
            setProperty(properties, DETECTED_VERSION, matcher.group(1));
            setProperty(properties, DETECTED_VERSION_MAJOR, matcher.group(2));
            setProperty(properties, DETECTED_VERSION_MINOR, matcher.group(3));
        }
        if (!"false".equalsIgnoreCase(this.systemPropertyOperationProvider.getSystemProperty("failOnUnknownOS"))) {
            if ("unknown".equals(strNormalizeOs)) {
                throw new DetectionException("unknown os.name: " + systemProperty);
            }
            if ("unknown".equals(strNormalizeArch)) {
                throw new DetectionException("unknown os.arch: " + systemProperty2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(strNormalizeOs);
        sb.append(Soundex.SILENT_MARKER);
        sb.append(strNormalizeArch);
        LinuxRelease linuxRelease = "linux".equals(strNormalizeOs) ? getLinuxRelease() : null;
        if (linuxRelease != null) {
            setProperty(properties, DETECTED_RELEASE, linuxRelease.f105id);
            if (linuxRelease.version != null) {
                setProperty(properties, DETECTED_RELEASE_VERSION, linuxRelease.version);
            }
            Iterator<String> it = linuxRelease.like.iterator();
            while (it.hasNext()) {
                setProperty(properties, DETECTED_RELEASE_LIKE_PREFIX + it.next(), "true");
            }
            for (String str : list) {
                if (linuxRelease.like.contains(str)) {
                    sb.append(Soundex.SILENT_MARKER);
                    sb.append(str);
                    break;
                }
            }
        }
        setProperty(properties, DETECTED_CLASSIFIER, sb.toString());
    }

    private void setProperty(Properties properties, String str, String str2) {
        properties.setProperty(str, str2);
        this.systemPropertyOperationProvider.setSystemProperty(str, str2);
        logProperty(str, str2);
    }

    private static String normalizeOs(String str) {
        String strNormalize = normalize(str);
        if (strNormalize.startsWith("aix")) {
            return "aix";
        }
        if (strNormalize.startsWith("hpux")) {
            return "hpux";
        }
        if (strNormalize.startsWith("os400") && (strNormalize.length() <= 5 || !Character.isDigit(strNormalize.charAt(5)))) {
            return "os400";
        }
        if (strNormalize.startsWith("linux")) {
            return "linux";
        }
        String str2 = "osx";
        if (!strNormalize.startsWith("mac") && !strNormalize.startsWith("osx")) {
            if (strNormalize.startsWith("freebsd")) {
                return "freebsd";
            }
            if (strNormalize.startsWith("openbsd")) {
                return "openbsd";
            }
            if (strNormalize.startsWith("netbsd")) {
                return "netbsd";
            }
            str2 = "sunos";
            if (!strNormalize.startsWith("solaris") && !strNormalize.startsWith("sunos")) {
                if (strNormalize.startsWith("windows")) {
                    return "windows";
                }
                if (strNormalize.startsWith("zos")) {
                    return "zos";
                }
                return "unknown";
            }
        }
        return str2;
    }

    private static String normalizeArch(String str) {
        String strNormalize = normalize(str);
        if (strNormalize.matches("^(x8664|amd64|ia32e|em64t|x64)$")) {
            return "x86_64";
        }
        if (strNormalize.matches("^(x8632|x86|i[3-6]86|ia32|x32)$")) {
            return "x86_32";
        }
        if (strNormalize.matches("^(ia64w?|itanium64)$")) {
            return "itanium_64";
        }
        if ("ia64n".equals(strNormalize)) {
            return "itanium_32";
        }
        if (strNormalize.matches("^(sparc|sparc32)$")) {
            return "sparc_32";
        }
        if (strNormalize.matches("^(sparcv9|sparc64)$")) {
            return "sparc_64";
        }
        if (strNormalize.matches("^(arm|arm32)$")) {
            return "arm_32";
        }
        if ("aarch64".equals(strNormalize)) {
            return "aarch_64";
        }
        if (strNormalize.matches("^(mips|mips32)$")) {
            return "mips_32";
        }
        if (strNormalize.matches("^(mipsel|mips32el)$")) {
            return "mipsel_32";
        }
        if ("mips64".equals(strNormalize)) {
            return "mips_64";
        }
        if ("mips64el".equals(strNormalize)) {
            return "mipsel_64";
        }
        if (strNormalize.matches("^(ppc|ppc32)$")) {
            return "ppc_32";
        }
        if (strNormalize.matches("^(ppcle|ppc32le)$")) {
            return "ppcle_32";
        }
        if ("ppc64".equals(strNormalize)) {
            return "ppc_64";
        }
        if ("ppc64le".equals(strNormalize)) {
            return "ppcle_64";
        }
        if ("s390".equals(strNormalize)) {
            return "s390_32";
        }
        if ("s390x".equals(strNormalize)) {
            return "s390_64";
        }
        if (strNormalize.matches("^(riscv|riscv32)$")) {
            return "riscv";
        }
        if ("riscv64".equals(strNormalize)) {
            return "riscv64";
        }
        if ("e2k".equals(strNormalize)) {
            return "e2k";
        }
        if ("loongarch64".equals(strNormalize)) {
            return "loongarch_64";
        }
        return "unknown";
    }

    private static String normalize(String str) {
        return str == null ? "" : str.toLowerCase(Locale.US).replaceAll("[^a-z0-9]+", "");
    }

    private LinuxRelease getLinuxRelease() throws Throwable {
        for (String str : LINUX_OS_RELEASE_FILES) {
            LinuxRelease linuxOsReleaseFile = parseLinuxOsReleaseFile(str);
            if (linuxOsReleaseFile != null) {
                return linuxOsReleaseFile;
            }
        }
        return parseLinuxRedhatReleaseFile(REDHAT_RELEASE_FILE);
    }

    private LinuxRelease parseLinuxOsReleaseFile(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(this.fileOperationProvider.readFile(str), "utf-8"));
            try {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                String strNormalizeOsReleaseValue = null;
                String strNormalizeOsReleaseValue2 = null;
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    if (line.startsWith(LINUX_ID_PREFIX)) {
                        strNormalizeOsReleaseValue = normalizeOsReleaseValue(line.substring(LINUX_ID_PREFIX.length()));
                        linkedHashSet.add(strNormalizeOsReleaseValue);
                    } else if (line.startsWith(LINUX_VERSION_ID_PREFIX)) {
                        strNormalizeOsReleaseValue2 = normalizeOsReleaseValue(line.substring(LINUX_VERSION_ID_PREFIX.length()));
                    } else if (line.startsWith(LINUX_ID_LIKE_PREFIX)) {
                        Collections.addAll(linkedHashSet, normalizeOsReleaseValue(line.substring(LINUX_ID_LIKE_PREFIX.length())).split(WalkEncryption.Vals.REGEX_WS));
                    }
                }
                if (strNormalizeOsReleaseValue != null) {
                    LinuxRelease linuxRelease = new LinuxRelease(strNormalizeOsReleaseValue, strNormalizeOsReleaseValue2, linkedHashSet);
                    closeQuietly(bufferedReader);
                    return linuxRelease;
                }
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                closeQuietly(bufferedReader2);
                throw th;
            }
        } catch (IOException unused2) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
        closeQuietly(bufferedReader);
        return null;
    }

    private LinuxRelease parseLinuxRedhatReleaseFile(String str) throws Throwable {
        BufferedReader bufferedReader;
        String str2 = "fedora";
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(this.fileOperationProvider.readFile(str), "utf-8"));
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    String lowerCase = line.toLowerCase(Locale.US);
                    if (lowerCase.contains("centos")) {
                        str2 = "centos";
                    } else if (!lowerCase.contains("fedora")) {
                        if (!lowerCase.contains("red hat enterprise linux")) {
                            closeQuietly(bufferedReader);
                            return null;
                        }
                        str2 = "rhel";
                    }
                    Matcher matcher = REDHAT_MAJOR_VERSION_REGEX.matcher(lowerCase);
                    String strGroup = matcher.find() ? matcher.group(1) : null;
                    LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(DEFAULT_REDHAT_VARIANTS));
                    linkedHashSet.add(str2);
                    LinuxRelease linuxRelease = new LinuxRelease(str2, strGroup, linkedHashSet);
                    closeQuietly(bufferedReader);
                    return linuxRelease;
                }
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                closeQuietly(bufferedReader2);
                throw th;
            }
        } catch (IOException unused2) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
        closeQuietly(bufferedReader);
        return null;
    }

    private static String normalizeOsReleaseValue(String str) {
        return str.trim().replace("\"", "");
    }

    private int determineBitness(String str) {
        String systemProperty = this.systemPropertyOperationProvider.getSystemProperty("sun.arch.data.model", "");
        if (!systemProperty.isEmpty() && systemProperty.matches("[0-9]+")) {
            return Integer.parseInt(systemProperty, 10);
        }
        String systemProperty2 = this.systemPropertyOperationProvider.getSystemProperty("com.ibm.vm.bitmode", "");
        if (!systemProperty2.isEmpty() && systemProperty2.matches("[0-9]+")) {
            return Integer.parseInt(systemProperty2, 10);
        }
        return guessBitnessFromArchitecture(str);
    }

    public static int guessBitnessFromArchitecture(String str) {
        return str.contains("64") ? 64 : 32;
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private static class LinuxRelease {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        final String f105id;
        final Collection<String> like;
        final String version;

        LinuxRelease(String str, String str2, Set<String> set) {
            this.f105id = str;
            this.version = str2;
            this.like = Collections.unmodifiableCollection(set);
        }
    }

    private static class SimpleSystemPropertyOperations implements SystemPropertyOperationProvider {
        private SimpleSystemPropertyOperations() {
        }

        /* synthetic */ SimpleSystemPropertyOperations(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // kr.motd.maven.os.SystemPropertyOperationProvider
        public String getSystemProperty(String str) {
            return System.getProperty(str);
        }

        @Override // kr.motd.maven.os.SystemPropertyOperationProvider
        public String getSystemProperty(String str, String str2) {
            return System.getProperty(str, str2);
        }

        @Override // kr.motd.maven.os.SystemPropertyOperationProvider
        public String setSystemProperty(String str, String str2) {
            return System.setProperty(str, str2);
        }
    }

    private static class SimpleFileOperations implements FileOperationProvider {
        private SimpleFileOperations() {
        }

        /* synthetic */ SimpleFileOperations(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // kr.motd.maven.os.FileOperationProvider
        public InputStream readFile(String str) throws IOException {
            return new FileInputStream(str);
        }
    }
}
