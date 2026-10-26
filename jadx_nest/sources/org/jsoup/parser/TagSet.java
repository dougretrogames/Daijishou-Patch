package org.jsoup.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import org.eclipse.jgit.lib.ConfigConstants;
import org.jsoup.helper.Validate;
import org.jsoup.internal.SharedConstants;

/* INFO: loaded from: classes5.dex */
public class TagSet {
    static final TagSet HtmlTagSet = initHtmlDefault();
    private ArrayList<Consumer<Tag>> customizers;
    private final TagSet source;
    private final Map<String, Map<String, Tag>> tags;

    public static TagSet Html() {
        return new TagSet(HtmlTagSet);
    }

    public TagSet() {
        this.tags = new HashMap();
        this.source = null;
    }

    public TagSet(TagSet tagSet) {
        this.tags = new HashMap();
        this.source = tagSet;
    }

    public TagSet add(Tag tag) {
        tag.set(Tag.Known);
        doAdd(tag);
        return this;
    }

    private void doAdd(Tag tag) {
        ArrayList<Consumer<Tag>> arrayList = this.customizers;
        if (arrayList != null) {
            Iterator<Consumer<Tag>> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().accept(tag);
            }
        }
        this.tags.computeIfAbsent(tag.namespace, new TagSet$$ExternalSyntheticLambda0()).put(tag.tagName, tag);
    }

    static /* synthetic */ Map lambda$doAdd$0(String str) {
        return new HashMap();
    }

    public Tag get(String str, String str2) {
        Tag tag;
        Tag tag2;
        Validate.notNull(str);
        Validate.notNull(str2);
        Map<String, Tag> map = this.tags.get(str2);
        if (map != null && (tag2 = map.get(str)) != null) {
            return tag2;
        }
        TagSet tagSet = this.source;
        if (tagSet == null || (tag = tagSet.get(str, str2)) == null) {
            return null;
        }
        Tag tagClone = tag.clone();
        doAdd(tagClone);
        return tagClone;
    }

    Tag valueOf(String str, String str2, String str3, boolean z) {
        Validate.notNull(str);
        Validate.notNull(str3);
        String strTrim = str.trim();
        Validate.notEmpty(strTrim);
        Tag tag = get(strTrim, str3);
        if (tag != null) {
            return tag;
        }
        if (!z) {
            strTrim = str2;
        }
        Tag tag2 = get(str2, str3);
        if (tag2 != null) {
            if (!z || strTrim.equals(str2)) {
                return tag2;
            }
            Tag tagClone = tag2.clone();
            tagClone.tagName = strTrim;
            doAdd(tagClone);
            return tagClone;
        }
        Tag tag3 = new Tag(strTrim, str2, str3);
        doAdd(tag3);
        return tag3;
    }

    public Tag valueOf(String str, String str2, ParseSettings parseSettings) {
        return valueOf(str, ParseSettings.normalName(str), str2, parseSettings.preserveTagCase());
    }

    public Tag valueOf(String str, String str2) {
        return valueOf(str, str2, ParseSettings.preserveCase);
    }

    public TagSet onNewTag(Consumer<Tag> consumer) {
        Validate.notNull(consumer);
        if (this.customizers == null) {
            this.customizers = new ArrayList<>();
        }
        this.customizers.add(consumer);
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TagSet) {
            return Objects.equals(this.tags, ((TagSet) obj).tags);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.tags);
    }

    static TagSet initHtmlDefault() {
        String[] strArr = {"html", "head", "body", "frameset", "script", "noscript", "style", "meta", "link", "title", TypedValues.AttributesType.S_FRAME, "noframes", "section", "nav", "aside", "hgroup", "header", "footer", "p", "h1", "h2", "h3", "h4", "h5", "h6", "br", "button", "ul", "ol", "pre", "div", "blockquote", "hr", "address", "figure", "figcaption", "form", "fieldset", "ins", "del", "dl", "dt", "dd", "li", "table", "caption", "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", "td", "video", "audio", "canvas", "details", "menu", "plaintext", ConfigConstants.CONFIG_KEY_COMMIT_TEMPLATE, "article", "main", "center", ConfigConstants.CONFIG_KEY_COMMIT_TEMPLATE, "dir", "applet", "marquee", "listing", "#root"};
        String[] strArr2 = {"object", "base", "font", "tt", "i", "b", "u", "big", "small", "em", "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", "time", "acronym", "mark", "ruby", "rt", "rp", "rtc", "a", "img", "wbr", "map", "q", "sub", "sup", "bdo", "iframe", "embed", "span", "input", "select", "textarea", "label", "optgroup", "option", "legend", "datalist", "keygen", "output", "progress", "meter", "area", "param", "source", "track", "summary", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track", "data", "bdi", "s", "strike", "nobr", "rb"};
        String[] strArr3 = {"title", "a", "p", "h1", "h2", "h3", "h4", "h5", "h6", "pre", "address", "li", "th", "td", "script", "style", "ins", "del", "s", "button"};
        return new TagSet().setupTags(Parser.NamespaceHtml, strArr, new TagSet$$ExternalSyntheticLambda5()).setupTags(Parser.NamespaceHtml, strArr2, new TagSet$$ExternalSyntheticLambda9()).setupTags(Parser.NamespaceHtml, strArr3, new TagSet$$ExternalSyntheticLambda10()).setupTags(Parser.NamespaceHtml, new String[]{"meta", "link", "base", TypedValues.AttributesType.S_FRAME, "img", "br", "wbr", "embed", "hr", "input", "keygen", "col", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track"}, new TagSet$$ExternalSyntheticLambda11()).setupTags(Parser.NamespaceHtml, new String[]{"pre", "plaintext", "title", "textarea", "script"}, new TagSet$$ExternalSyntheticLambda12()).setupTags(Parser.NamespaceHtml, new String[]{"title", "textarea"}, new TagSet$$ExternalSyntheticLambda13()).setupTags(Parser.NamespaceHtml, new String[]{"iframe", "noembed", "noframes", "script", "style", "xmp"}, new TagSet$$ExternalSyntheticLambda1()).setupTags(Parser.NamespaceHtml, SharedConstants.FormSubmitTags, new TagSet$$ExternalSyntheticLambda2()).setupTags(Parser.NamespaceMathml, new String[]{"math"}, new TagSet$$ExternalSyntheticLambda3()).setupTags(Parser.NamespaceMathml, new String[]{"mi", "mo", "msup", "mn", "mtext"}, new TagSet$$ExternalSyntheticLambda4()).setupTags(Parser.NamespaceSvg, new String[]{"svg", "femerge", "femergenode"}, new TagSet$$ExternalSyntheticLambda6()).setupTags(Parser.NamespaceSvg, new String[]{"text"}, new TagSet$$ExternalSyntheticLambda7()).setupTags(Parser.NamespaceSvg, new String[]{"script"}, new TagSet$$ExternalSyntheticLambda8());
    }

    private TagSet setupTags(String str, String[] strArr, Consumer<Tag> consumer) {
        for (String str2 : strArr) {
            Tag tag = get(str2, str);
            if (tag == null) {
                tag = new Tag(str2, str2, str);
                tag.options = 0;
                add(tag);
            }
            consumer.accept(tag);
        }
        return this;
    }
}
