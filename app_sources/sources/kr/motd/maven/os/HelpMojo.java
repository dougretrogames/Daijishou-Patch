package kr.motd.maven.os;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.http.message.TokenParser;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.eclipse.jgit.lib.ConfigConstants;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* INFO: loaded from: classes5.dex */
public class HelpMojo extends AbstractMojo {
    private static final int DEFAULT_LINE_LENGTH = 80;
    private static final String PLUGIN_HELP_PATH = "/META-INF/maven/kr.motd.maven/os-maven-plugin/plugin-help.xml";
    private boolean detail;
    private String goal;
    private int indentSize;
    private int lineLength;

    /* INFO: Thrown type has an unknown type hierarchy: org.apache.maven.plugin.MojoExecutionException */
    private Document build() throws MojoExecutionException {
        getLog().debug("load plugin-help.xml: /META-INF/maven/kr.motd.maven/os-maven-plugin/plugin-help.xml");
        InputStream resourceAsStream = null;
        try {
            try {
                try {
                    resourceAsStream = getClass().getResourceAsStream(PLUGIN_HELP_PATH);
                    Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(resourceAsStream);
                    if (resourceAsStream == null) {
                        return document;
                    }
                    try {
                        resourceAsStream.close();
                        return document;
                    } catch (IOException e) {
                        throw new MojoExecutionException(e.getMessage(), e);
                    }
                } catch (Throwable th) {
                    if (resourceAsStream != null) {
                        try {
                            resourceAsStream.close();
                        } catch (IOException e2) {
                            throw new MojoExecutionException(e2.getMessage(), e2);
                        }
                    }
                    throw th;
                }
            } catch (ParserConfigurationException e3) {
                throw new MojoExecutionException(e3.getMessage(), e3);
            }
        } catch (IOException e4) {
            throw new MojoExecutionException(e4.getMessage(), e4);
        } catch (SAXException e5) {
            throw new MojoExecutionException(e5.getMessage(), e5);
        }
    }

    /* INFO: Thrown type has an unknown type hierarchy: org.apache.maven.plugin.MojoExecutionException */
    public void execute() throws MojoExecutionException {
        if (this.lineLength <= 0) {
            getLog().warn("The parameter 'lineLength' should be positive, using '80' as default.");
            this.lineLength = 80;
        }
        if (this.indentSize <= 0) {
            getLog().warn("The parameter 'indentSize' should be positive, using '2' as default.");
            this.indentSize = 2;
        }
        Document documentBuild = build();
        StringBuilder sb = new StringBuilder();
        Node singleChild = getSingleChild(documentBuild, "plugin");
        String value = getValue(singleChild, "name");
        String value2 = getValue(singleChild, "version");
        String str = getValue(singleChild, "groupId") + CollectionUtils.COLON + getValue(singleChild, "artifactId") + CollectionUtils.COLON + value2;
        if (isNotEmpty(value) && !value.contains(str)) {
            append(sb, value + " " + value2, 0);
        } else if (isNotEmpty(value)) {
            append(sb, value, 0);
        } else {
            append(sb, str, 0);
        }
        append(sb, getValue(singleChild, "description"), 1);
        append(sb, "", 0);
        String value3 = getValue(singleChild, "goalPrefix");
        List<Node> listFindNamedChild = findNamedChild(getSingleChild(singleChild, "mojos"), "mojo");
        String str2 = this.goal;
        if (str2 == null || str2.length() <= 0) {
            append(sb, "This plugin has " + listFindNamedChild.size() + (listFindNamedChild.size() > 1 ? " goals:" : " goal:"), 0);
            append(sb, "", 0);
        }
        Iterator<Node> it = listFindNamedChild.iterator();
        while (it.hasNext()) {
            writeGoal(sb, value3, (Element) it.next());
        }
        if (getLog().isInfoEnabled()) {
            getLog().info(sb.toString());
        }
    }

    private static boolean isNotEmpty(String str) {
        return str != null && str.length() > 0;
    }

    private String getValue(Node node, String str) throws MojoExecutionException {
        return getSingleChild(node, str).getTextContent();
    }

    /* INFO: Thrown type has an unknown type hierarchy: org.apache.maven.plugin.MojoExecutionException */
    private Node getSingleChild(Node node, String str) throws MojoExecutionException {
        List<Node> listFindNamedChild = findNamedChild(node, str);
        if (listFindNamedChild.isEmpty()) {
            throw new MojoExecutionException("Could not find " + str + " in plugin-help.xml");
        }
        if (listFindNamedChild.size() > 1) {
            throw new MojoExecutionException("Multiple " + str + " in plugin-help.xml");
        }
        return listFindNamedChild.get(0);
    }

    private List<Node> findNamedChild(Node node, String str) {
        ArrayList arrayList = new ArrayList();
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            if (str.equals(nodeItem.getNodeName())) {
                arrayList.add(nodeItem);
            }
        }
        return arrayList;
    }

    /* INFO: Thrown type has an unknown type hierarchy: org.apache.maven.plugin.MojoExecutionException */
    private Node findSingleChild(Node node, String str) throws MojoExecutionException {
        List<Node> listFindNamedChild = findNamedChild(node, str);
        if (listFindNamedChild.isEmpty()) {
            return null;
        }
        if (listFindNamedChild.size() > 1) {
            throw new MojoExecutionException("Multiple " + str + "in plugin-help.xml");
        }
        return listFindNamedChild.get(0);
    }

    /* INFO: Thrown type has an unknown type hierarchy: org.apache.maven.plugin.MojoExecutionException */
    private void writeGoal(StringBuilder sb, String str, Element element) throws MojoExecutionException {
        String value = getValue(element, "goal");
        Node nodeFindSingleChild = findSingleChild(element, "configuration");
        Node nodeFindSingleChild2 = findSingleChild(element, "description");
        String str2 = this.goal;
        if (str2 == null || str2.length() <= 0 || value.equals(this.goal)) {
            append(sb, str + CollectionUtils.COLON + value, 0);
            Node nodeFindSingleChild3 = findSingleChild(element, "deprecated");
            if (nodeFindSingleChild3 != null && isNotEmpty(nodeFindSingleChild3.getTextContent())) {
                append(sb, "Deprecated. " + nodeFindSingleChild3.getTextContent(), 1);
                if (this.detail && nodeFindSingleChild2 != null) {
                    append(sb, "", 0);
                    append(sb, nodeFindSingleChild2.getTextContent(), 1);
                }
            } else if (nodeFindSingleChild2 != null) {
                append(sb, nodeFindSingleChild2.getTextContent(), 1);
            }
            append(sb, "", 0);
            if (this.detail) {
                List<Node> listFindNamedChild = findNamedChild(getSingleChild(element, "parameters"), "parameter");
                append(sb, "Available parameters:", 1);
                append(sb, "", 0);
                Iterator<Node> it = listFindNamedChild.iterator();
                while (it.hasNext()) {
                    writeParameter(sb, it.next(), nodeFindSingleChild);
                }
            }
        }
    }

    /* INFO: Thrown type has an unknown type hierarchy: org.apache.maven.plugin.MojoExecutionException */
    private void writeParameter(StringBuilder sb, Node node, Node node2) throws MojoExecutionException {
        String str;
        String value = getValue(node, "name");
        String value2 = getValue(node, "description");
        Element element = node2 != null ? (Element) findSingleChild(node2, value) : null;
        if (element == null || !element.hasAttribute("default-value")) {
            str = "";
        } else {
            str = " (Default: " + element.getAttribute("default-value") + ")";
        }
        append(sb, value + str, 2);
        Node nodeFindSingleChild = findSingleChild(node, "deprecated");
        if (nodeFindSingleChild != null && isNotEmpty(nodeFindSingleChild.getTextContent())) {
            append(sb, "Deprecated. " + nodeFindSingleChild.getTextContent(), 3);
            append(sb, "", 0);
        }
        append(sb, value2, 3);
        if ("true".equals(getValue(node, ConfigConstants.CONFIG_KEY_REQUIRED))) {
            append(sb, "Required: Yes", 3);
        }
        if (element != null && isNotEmpty(element.getTextContent())) {
            append(sb, "User property: " + getPropertyFromExpression(element.getTextContent()), 3);
        }
        append(sb, "", 0);
    }

    private static String repeat(String str, int i) {
        StringBuilder sb = new StringBuilder(str.length() * i);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(str);
        }
        return sb.toString();
    }

    private void append(StringBuilder sb, String str, int i) {
        Iterator<String> it = toLines(str, i, this.indentSize, this.lineLength).iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append('\n');
        }
    }

    private static List<String> toLines(String str, int i, int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        String strRepeat = repeat("\t", i);
        for (String str2 : str.split("(\r\n)|(\r)|(\n)")) {
            toLines(arrayList, strRepeat + str2, i2, i3);
        }
        return arrayList;
    }

    private static void toLines(List<String> list, String str, int i, int i2) {
        int indentLevel = getIndentLevel(str);
        StringBuilder sb = new StringBuilder(256);
        for (String str2 : str.split(" +")) {
            if (sb.length() > 0) {
                if (sb.length() + str2.length() >= i2) {
                    list.add(sb.toString());
                    sb.setLength(0);
                    sb.append(repeat(" ", indentLevel * i));
                } else {
                    sb.append(TokenParser.SP);
                }
            }
            for (int i3 = 0; i3 < str2.length(); i3++) {
                char cCharAt = str2.charAt(i3);
                if (cCharAt == '\t') {
                    sb.append(repeat(" ", i - (sb.length() % i)));
                } else if (cCharAt == 160) {
                    sb.append(TokenParser.SP);
                } else {
                    sb.append(cCharAt);
                }
            }
        }
        list.add(sb.toString());
    }

    private static int getIndentLevel(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length() && str.charAt(i2) == '\t'; i2++) {
            i++;
        }
        int i3 = i + 1;
        for (int i4 = i3; i4 <= i + 4 && i4 < str.length(); i4++) {
            if (str.charAt(i4) == '\t') {
                return i3;
            }
        }
        return i;
    }

    private String getPropertyFromExpression(String str) {
        if (str == null || !str.startsWith("${") || !str.endsWith("}") || str.substring(2).contains("${")) {
            return null;
        }
        return str.substring(2, str.length() - 1);
    }
}
