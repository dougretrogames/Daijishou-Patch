package org.apache.commons.io.input;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.ByteOrderMark;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.build.AbstractStreamBuilder;
import org.apache.commons.io.function.IOConsumer;

/* JADX INFO: loaded from: classes5.dex */
public class XmlStreamReader extends Reader {
    private static final ByteOrderMark[] BOMS;
    private static final Pattern CHARSET_PATTERN;
    private static final String EBCDIC = "CP1047";
    public static final Pattern ENCODING_PATTERN;
    private static final String HTTP_EX_1 = "Illegal encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], BOM must be null";
    private static final String HTTP_EX_2 = "Illegal encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], encoding mismatch";
    private static final String HTTP_EX_3 = "Illegal encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], Illegal MIME";
    private static final String RAW_EX_1 = "Illegal encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch";
    private static final String RAW_EX_2 = "Illegal encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] unknown BOM";
    private static final String US_ASCII;
    private static final String UTF_16;
    private static final String UTF_16BE;
    private static final String UTF_16LE;
    private static final String UTF_32 = "UTF-32";
    private static final String UTF_32BE = "UTF-32BE";
    private static final String UTF_32LE = "UTF-32LE";
    private static final String UTF_8;
    private static final ByteOrderMark[] XML_GUESS_BYTES;
    private final String defaultEncoding;
    private final String encoding;
    private final Reader reader;

    public static class Builder extends AbstractStreamBuilder<XmlStreamReader, Builder> {
        private String httpContentType;
        private boolean nullCharset = true;
        private boolean lenient = true;

        @Override // org.apache.commons.io.function.IOSupplier
        public XmlStreamReader get() throws IOException {
            String strName = this.nullCharset ? null : getCharset().name();
            if (this.httpContentType == null) {
                return new XmlStreamReader(getInputStream(), this.lenient, strName);
            }
            return new XmlStreamReader(getInputStream(), this.httpContentType, this.lenient, strName);
        }

        @Override // org.apache.commons.io.build.AbstractStreamBuilder
        public Builder setCharset(Charset charset) {
            this.nullCharset = charset == null;
            return (Builder) super.setCharset(charset);
        }

        @Override // org.apache.commons.io.build.AbstractStreamBuilder
        public Builder setCharset(String str) {
            this.nullCharset = str == null;
            return (Builder) super.setCharset(Charsets.toCharset(str, getCharsetDefault()));
        }

        public Builder setHttpContentType(String str) {
            this.httpContentType = str;
            return this;
        }

        public Builder setLenient(boolean z) {
            this.lenient = z;
            return this;
        }
    }

    static {
        String strName = StandardCharsets.UTF_8.name();
        UTF_8 = strName;
        US_ASCII = StandardCharsets.US_ASCII.name();
        String strName2 = StandardCharsets.UTF_16BE.name();
        UTF_16BE = strName2;
        String strName3 = StandardCharsets.UTF_16LE.name();
        UTF_16LE = strName3;
        UTF_16 = StandardCharsets.UTF_16.name();
        BOMS = new ByteOrderMark[]{ByteOrderMark.UTF_8, ByteOrderMark.UTF_16BE, ByteOrderMark.UTF_16LE, ByteOrderMark.UTF_32BE, ByteOrderMark.UTF_32LE};
        XML_GUESS_BYTES = new ByteOrderMark[]{new ByteOrderMark(strName, 60, 63, 120, 109), new ByteOrderMark(strName2, 0, 60, 0, 63), new ByteOrderMark(strName3, 60, 0, 63, 0), new ByteOrderMark(UTF_32BE, 0, 0, 0, 60, 0, 0, 0, 63, 0, 0, 0, 120, 0, 0, 0, 109), new ByteOrderMark(UTF_32LE, 60, 0, 0, 0, 63, 0, 0, 0, 120, 0, 0, 0, 109, 0, 0, 0), new ByteOrderMark(EBCDIC, 76, 111, 167, 148)};
        CHARSET_PATTERN = Pattern.compile("charset=[\"']?([.[^; \"']]*)[\"']?");
        ENCODING_PATTERN = Pattern.compile("^<\\?xml\\s+(?:version\\s*=\\s*(?:(?:\"1\\.[0-9]+\")|(?:'1.[0-9]+'))\\s+)??encoding\\s*=\\s*((?:\"[A-Za-z0-9][A-Za-z0-9._+:-]*\")|(?:'[A-Za-z0-9][A-Za-z0-9._+:-]*'))", 8);
    }

    public static Builder builder() {
        return new Builder();
    }

    static String getContentTypeEncoding(String str) {
        int iIndexOf;
        if (str != null && (iIndexOf = str.indexOf(";")) > -1) {
            Matcher matcher = CHARSET_PATTERN.matcher(str.substring(iIndexOf + 1));
            String strGroup = matcher.find() ? matcher.group(1) : null;
            if (strGroup != null) {
                return strGroup.toUpperCase(Locale.ROOT);
            }
        }
        return null;
    }

    static String getContentTypeMime(String str) {
        if (str == null) {
            return null;
        }
        int iIndexOf = str.indexOf(";");
        if (iIndexOf >= 0) {
            str = str.substring(0, iIndexOf);
        }
        return str.trim();
    }

    private static String getXmlProlog(InputStream inputStream, String str) throws IOException {
        if (str == null) {
            return null;
        }
        byte[] bArrByteArray = IOUtils.byteArray();
        inputStream.mark(8192);
        int i = inputStream.read(bArrByteArray, 0, 8192);
        String str2 = "";
        int i2 = 8192;
        int i3 = 0;
        int iIndexOf = -1;
        while (i != -1 && iIndexOf == -1 && i3 < 8192) {
            i3 += i;
            i2 -= i;
            i = inputStream.read(bArrByteArray, i3, i2);
            str2 = new String(bArrByteArray, 0, i3, str);
            iIndexOf = str2.indexOf(62);
        }
        if (iIndexOf == -1) {
            if (i == -1) {
                throw new IOException("Unexpected end of XML stream");
            }
            throw new IOException("XML prolog or ROOT element not found on first " + i3 + " bytes");
        }
        if (i3 <= 0) {
            return null;
        }
        inputStream.reset();
        BufferedReader bufferedReader = new BufferedReader(new StringReader(str2.substring(0, iIndexOf + 1)));
        StringBuilder sb = new StringBuilder();
        IOConsumer.forEach(bufferedReader.lines(), new XmlStreamReader$$ExternalSyntheticLambda0(sb));
        Matcher matcher = ENCODING_PATTERN.matcher(sb);
        if (!matcher.find()) {
            return null;
        }
        String upperCase = matcher.group(1).toUpperCase(Locale.ROOT);
        return upperCase.substring(1, upperCase.length() - 1);
    }

    static boolean isAppXml(String str) {
        if (str == null) {
            return false;
        }
        if (str.equals("application/xml") || str.equals("application/xml-dtd") || str.equals("application/xml-external-parsed-entity")) {
            return true;
        }
        return str.startsWith("application/") && str.endsWith("+xml");
    }

    static boolean isTextXml(String str) {
        if (str == null) {
            return false;
        }
        if (str.equals("text/xml") || str.equals("text/xml-external-parsed-entity")) {
            return true;
        }
        return str.startsWith("text/") && str.endsWith("+xml");
    }

    @Deprecated
    public XmlStreamReader(File file) throws IOException {
        this(((File) Objects.requireNonNull(file, "file")).toPath());
    }

    @Deprecated
    public XmlStreamReader(InputStream inputStream) throws IOException {
        this(inputStream, true);
    }

    @Deprecated
    public XmlStreamReader(InputStream inputStream, boolean z) throws IOException {
        this(inputStream, z, (String) null);
    }

    @Deprecated
    public XmlStreamReader(InputStream inputStream, boolean z, String str) throws IOException {
        this.defaultEncoding = str;
        BOMInputStream bOMInputStream = new BOMInputStream(new BufferedInputStream((InputStream) Objects.requireNonNull(inputStream, "inputStream"), 8192), false, BOMS);
        BOMInputStream bOMInputStream2 = new BOMInputStream(bOMInputStream, true, XML_GUESS_BYTES);
        String strProcessHttpStream = processHttpStream(bOMInputStream, bOMInputStream2, z);
        this.encoding = strProcessHttpStream;
        this.reader = new InputStreamReader(bOMInputStream2, strProcessHttpStream);
    }

    @Deprecated
    public XmlStreamReader(InputStream inputStream, String str) throws IOException {
        this(inputStream, str, true);
    }

    @Deprecated
    public XmlStreamReader(InputStream inputStream, String str, boolean z) throws IOException {
        this(inputStream, str, z, null);
    }

    @Deprecated
    public XmlStreamReader(InputStream inputStream, String str, boolean z, String str2) throws IOException {
        this.defaultEncoding = str2;
        BOMInputStream bOMInputStream = new BOMInputStream(new BufferedInputStream((InputStream) Objects.requireNonNull(inputStream, "inputStream"), 8192), false, BOMS);
        BOMInputStream bOMInputStream2 = new BOMInputStream(bOMInputStream, true, XML_GUESS_BYTES);
        String strProcessHttpStream = processHttpStream(bOMInputStream, bOMInputStream2, z, str);
        this.encoding = strProcessHttpStream;
        this.reader = new InputStreamReader(bOMInputStream2, strProcessHttpStream);
    }

    @Deprecated
    public XmlStreamReader(Path path) throws IOException {
        this(Files.newInputStream((Path) Objects.requireNonNull(path, "file"), new OpenOption[0]));
    }

    public XmlStreamReader(URL url) throws IOException {
        this(((URL) Objects.requireNonNull(url, "url")).openConnection(), (String) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public XmlStreamReader(URLConnection uRLConnection, String str) throws IOException {
        Objects.requireNonNull(uRLConnection, "urlConnection");
        this.defaultEncoding = str;
        String contentType = uRLConnection.getContentType();
        BOMInputStream bOMInputStream = ((BOMInputStream.Builder) BOMInputStream.builder().setInputStream(new BufferedInputStream(uRLConnection.getInputStream(), 8192))).setInclude(false).setByteOrderMarks(BOMS).get();
        BOMInputStream bOMInputStream2 = ((BOMInputStream.Builder) BOMInputStream.builder().setInputStream(new BufferedInputStream(bOMInputStream, 8192))).setInclude(true).setByteOrderMarks(XML_GUESS_BYTES).get();
        if ((uRLConnection instanceof HttpURLConnection) || contentType != null) {
            this.encoding = processHttpStream(bOMInputStream, bOMInputStream2, true, contentType);
        } else {
            this.encoding = processHttpStream(bOMInputStream, bOMInputStream2, true);
        }
        this.reader = new InputStreamReader(bOMInputStream2, this.encoding);
    }

    String calculateHttpEncoding(String str, String str2, String str3, boolean z, String str4) throws IOException {
        if (z && str3 != null) {
            return str3;
        }
        String contentTypeMime = getContentTypeMime(str4);
        String contentTypeEncoding = getContentTypeEncoding(str4);
        boolean zIsAppXml = isAppXml(contentTypeMime);
        boolean zIsTextXml = isTextXml(contentTypeMime);
        if (!zIsAppXml && !zIsTextXml) {
            throw new XmlStreamReaderException(MessageFormat.format(HTTP_EX_3, contentTypeMime, contentTypeEncoding, str, str2, str3), contentTypeMime, contentTypeEncoding, str, str2, str3);
        }
        if (contentTypeEncoding == null) {
            if (zIsAppXml) {
                return calculateRawEncoding(str, str2, str3);
            }
            String str5 = this.defaultEncoding;
            return str5 == null ? US_ASCII : str5;
        }
        if (!contentTypeEncoding.equals(UTF_16BE) && !contentTypeEncoding.equals(UTF_16LE)) {
            String str6 = UTF_16;
            if (contentTypeEncoding.equals(str6)) {
                if (str == null || !str.startsWith(str6)) {
                    throw new XmlStreamReaderException(MessageFormat.format(HTTP_EX_2, contentTypeMime, contentTypeEncoding, str, str2, str3), contentTypeMime, contentTypeEncoding, str, str2, str3);
                }
            } else if (contentTypeEncoding.equals(UTF_32BE) || contentTypeEncoding.equals(UTF_32LE)) {
                if (str != null) {
                    throw new XmlStreamReaderException(MessageFormat.format(HTTP_EX_1, contentTypeMime, contentTypeEncoding, str, str2, str3), contentTypeMime, contentTypeEncoding, str, str2, str3);
                }
            } else if (contentTypeEncoding.equals(UTF_32)) {
                if (str == null || !str.startsWith(UTF_32)) {
                    throw new XmlStreamReaderException(MessageFormat.format(HTTP_EX_2, contentTypeMime, contentTypeEncoding, str, str2, str3), contentTypeMime, contentTypeEncoding, str, str2, str3);
                }
            }
            return str;
        }
        if (str != null) {
            throw new XmlStreamReaderException(MessageFormat.format(HTTP_EX_1, contentTypeMime, contentTypeEncoding, str, str2, str3), contentTypeMime, contentTypeEncoding, str, str2, str3);
        }
        return contentTypeEncoding;
    }

    String calculateRawEncoding(String str, String str2, String str3) throws IOException {
        if (str == null) {
            if (str2 != null && str3 != null) {
                return (str3.equals(UTF_16) && (str2.equals(UTF_16BE) || str2.equals(UTF_16LE))) ? str2 : str3;
            }
            String str4 = this.defaultEncoding;
            return str4 == null ? UTF_8 : str4;
        }
        String str5 = UTF_8;
        if (str.equals(str5)) {
            if (str2 != null && !str2.equals(str5)) {
                throw new XmlStreamReaderException(MessageFormat.format(RAW_EX_1, str, str2, str3), str, str2, str3);
            }
            if (str3 != null && !str3.equals(str5)) {
                throw new XmlStreamReaderException(MessageFormat.format(RAW_EX_1, str, str2, str3), str, str2, str3);
            }
        } else if (str.equals(UTF_16BE) || str.equals(UTF_16LE)) {
            if (str2 != null && !str2.equals(str)) {
                throw new XmlStreamReaderException(MessageFormat.format(RAW_EX_1, str, str2, str3), str, str2, str3);
            }
            if (str3 != null && !str3.equals(UTF_16) && !str3.equals(str)) {
                throw new XmlStreamReaderException(MessageFormat.format(RAW_EX_1, str, str2, str3), str, str2, str3);
            }
        } else if (str.equals(UTF_32BE) || str.equals(UTF_32LE)) {
            if (str2 != null && !str2.equals(str)) {
                throw new XmlStreamReaderException(MessageFormat.format(RAW_EX_1, str, str2, str3), str, str2, str3);
            }
            if (str3 != null && !str3.equals(UTF_32) && !str3.equals(str)) {
                throw new XmlStreamReaderException(MessageFormat.format(RAW_EX_1, str, str2, str3), str, str2, str3);
            }
        } else {
            throw new XmlStreamReaderException(MessageFormat.format(RAW_EX_2, str, str2, str3), str, str2, str3);
        }
        return str;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.reader.close();
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0042  */
    /* JADX WARN: Code duplicated, block: B:20:0x0048  */
    /* JADX WARN: Code duplicated, block: B:22:0x004c  */
    /* JADX WARN: Code duplicated, block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:? A[RETURN, SYNTHETIC] */
    private String doLenientDetection(String str, XmlStreamReaderException xmlStreamReaderException) throws IOException {
        XmlStreamReader xmlStreamReader;
        String xmlEncoding;
        String str2;
        if (str == null || !str.startsWith("text/html")) {
            xmlStreamReader = this;
        } else {
            try {
                xmlStreamReader = this;
                try {
                    return xmlStreamReader.calculateHttpEncoding(xmlStreamReaderException.getBomEncoding(), xmlStreamReaderException.getXmlGuessEncoding(), xmlStreamReaderException.getXmlEncoding(), true, "text/xml" + str.substring("text/html".length()));
                } catch (XmlStreamReaderException e) {
                    e = e;
                    xmlStreamReaderException = e;
                    xmlEncoding = xmlStreamReaderException.getXmlEncoding();
                    if (xmlEncoding == null) {
                        xmlEncoding = xmlStreamReaderException.getContentTypeEncoding();
                    }
                    if (xmlEncoding == null) {
                        return xmlEncoding;
                    }
                    str2 = xmlStreamReader.defaultEncoding;
                    if (str2 == null) {
                        return UTF_8;
                    }
                    return str2;
                }
            } catch (XmlStreamReaderException e2) {
                e = e2;
                xmlStreamReader = this;
            }
        }
        xmlEncoding = xmlStreamReaderException.getXmlEncoding();
        if (xmlEncoding == null) {
            xmlEncoding = xmlStreamReaderException.getContentTypeEncoding();
        }
        if (xmlEncoding == null) {
            return xmlEncoding;
        }
        str2 = xmlStreamReader.defaultEncoding;
        if (str2 == null) {
            return UTF_8;
        }
        return str2;
    }

    public String getDefaultEncoding() {
        return this.defaultEncoding;
    }

    public String getEncoding() {
        return this.encoding;
    }

    private String processHttpStream(BOMInputStream bOMInputStream, BOMInputStream bOMInputStream2, boolean z) throws IOException {
        String bOMCharsetName = bOMInputStream.getBOMCharsetName();
        String bOMCharsetName2 = bOMInputStream2.getBOMCharsetName();
        try {
            return calculateRawEncoding(bOMCharsetName, bOMCharsetName2, getXmlProlog(bOMInputStream2, bOMCharsetName2));
        } catch (XmlStreamReaderException e) {
            if (z) {
                return doLenientDetection(null, e);
            }
            throw e;
        }
    }

    private String processHttpStream(BOMInputStream bOMInputStream, BOMInputStream bOMInputStream2, boolean z, String str) throws IOException {
        String bOMCharsetName = bOMInputStream.getBOMCharsetName();
        String bOMCharsetName2 = bOMInputStream2.getBOMCharsetName();
        try {
            return calculateHttpEncoding(bOMCharsetName, bOMCharsetName2, getXmlProlog(bOMInputStream2, bOMCharsetName2), z, str);
        } catch (XmlStreamReaderException e) {
            if (z) {
                return doLenientDetection(str, e);
            }
            throw e;
        }
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        return this.reader.read(cArr, i, i2);
    }
}
