package org.eclipse.jgit.attributes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* INFO: loaded from: classes5.dex */
public class AttributesNode {
    private final List<AttributesRule> rules;

    public AttributesNode() {
        this.rules = new ArrayList();
    }

    public AttributesNode(List<AttributesRule> list) {
        this.rules = list;
    }

    public void parse(InputStream inputStream) throws IOException {
        BufferedReader bufferedReaderAsReader = asReader(inputStream);
        while (true) {
            String line = bufferedReaderAsReader.readLine();
            if (line == null) {
                return;
            }
            String strTrim = line.trim();
            if (strTrim.length() > 0 && !strTrim.startsWith("#") && !strTrim.startsWith("!")) {
                int iIndexOf = strTrim.indexOf(32);
                int iIndexOf2 = strTrim.indexOf(9);
                if (iIndexOf == -1) {
                    iIndexOf = iIndexOf2;
                } else if (iIndexOf2 != -1) {
                    iIndexOf = Math.min(iIndexOf, iIndexOf2);
                }
                if (iIndexOf > -1) {
                    this.rules.add(new AttributesRule(strTrim.substring(0, iIndexOf), strTrim.substring(iIndexOf + 1).trim()));
                }
            }
        }
    }

    private static BufferedReader asReader(InputStream inputStream) {
        return new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
    }

    public List<AttributesRule> getRules() {
        return Collections.unmodifiableList(this.rules);
    }
}
