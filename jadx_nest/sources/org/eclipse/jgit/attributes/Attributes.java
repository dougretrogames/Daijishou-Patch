package org.eclipse.jgit.attributes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.lib.Constants;

/* INFO: loaded from: classes5.dex */
public final class Attributes {
    private final Map<String, Attribute> map = new LinkedHashMap();

    public Attributes(Attribute... attributeArr) {
        if (attributeArr != null) {
            for (Attribute attribute : attributeArr) {
                put(attribute);
            }
        }
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public Attribute get(String str) {
        return this.map.get(str);
    }

    public Collection<Attribute> getAll() {
        return new ArrayList(this.map.values());
    }

    public void put(Attribute attribute) {
        this.map.put(attribute.getKey(), attribute);
    }

    public void remove(String str) {
        this.map.remove(str);
    }

    public boolean containsKey(String str) {
        return this.map.containsKey(str);
    }

    public Attribute.State getState(String str) {
        Attribute attribute = this.map.get(str);
        return attribute != null ? attribute.getState() : Attribute.State.UNSPECIFIED;
    }

    public boolean isSet(String str) {
        return getState(str) == Attribute.State.SET;
    }

    public boolean isUnset(String str) {
        return getState(str) == Attribute.State.UNSET;
    }

    public boolean isUnspecified(String str) {
        return getState(str) == Attribute.State.UNSPECIFIED;
    }

    public boolean isCustom(String str) {
        return getState(str) == Attribute.State.CUSTOM;
    }

    public String getValue(String str) {
        Attribute attribute = this.map.get(str);
        if (attribute != null) {
            return attribute.getValue();
        }
        return null;
    }

    public boolean canBeContentMerged() {
        if (isUnset("merge")) {
            return false;
        }
        return (isCustom("merge") && getValue("merge").equals(Constants.ATTR_BUILTIN_BINARY_MERGER)) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[ ");
        Iterator<Attribute> it = this.map.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            sb.append(" ");
        }
        sb.append(CollectionUtils.DEFAULT_TOSTRING_SUFFIX);
        return sb.toString();
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Attributes) {
            return this.map.equals(((Attributes) obj).map);
        }
        return false;
    }
}
