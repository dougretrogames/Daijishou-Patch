package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class TextFormatParseInfoTree {
    private Map<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> locationsFromField;
    Map<Descriptors.FieldDescriptor, List<TextFormatParseInfoTree>> subtreesFromField;

    /* synthetic */ TextFormatParseInfoTree(Map map, Map map2, AnonymousClass1 anonymousClass1) {
        this(map, map2);
    }

    private TextFormatParseInfoTree(Map<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> locationsFromField, Map<Descriptors.FieldDescriptor, List<Builder>> subtreeBuildersFromField) {
        HashMap map = new HashMap();
        for (Map.Entry<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> entry : locationsFromField.entrySet()) {
            map.put(entry.getKey(), Collections.unmodifiableList(entry.getValue()));
        }
        this.locationsFromField = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        for (Map.Entry<Descriptors.FieldDescriptor, List<Builder>> entry2 : subtreeBuildersFromField.entrySet()) {
            ArrayList arrayList = new ArrayList();
            Iterator<Builder> it = entry2.getValue().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().build());
            }
            map2.put(entry2.getKey(), Collections.unmodifiableList(arrayList));
        }
        this.subtreesFromField = Collections.unmodifiableMap(map2);
    }

    public List<TextFormatParseLocation> getLocations(final Descriptors.FieldDescriptor fieldDescriptor) {
        List<TextFormatParseLocation> list = this.locationsFromField.get(fieldDescriptor);
        return list == null ? Collections.emptyList() : list;
    }

    public TextFormatParseLocation getLocation(final Descriptors.FieldDescriptor fieldDescriptor, int index) {
        return (TextFormatParseLocation) getFromList(getLocations(fieldDescriptor), index, fieldDescriptor);
    }

    public List<TextFormatParseInfoTree> getNestedTrees(final Descriptors.FieldDescriptor fieldDescriptor) {
        List<TextFormatParseInfoTree> list = this.subtreesFromField.get(fieldDescriptor);
        return list == null ? Collections.emptyList() : list;
    }

    public TextFormatParseInfoTree getNestedTree(final Descriptors.FieldDescriptor fieldDescriptor, int index) {
        return (TextFormatParseInfoTree) getFromList(getNestedTrees(fieldDescriptor), index, fieldDescriptor);
    }

    public static Builder builder() {
        return new Builder(null);
    }

    private static <T> T getFromList(List<T> list, int index, Descriptors.FieldDescriptor fieldDescriptor) {
        if (index >= list.size() || index < 0) {
            throw new IllegalArgumentException(String.format("Illegal index field: %s, index %d", fieldDescriptor == null ? "<null>" : fieldDescriptor.getName(), Integer.valueOf(index)));
        }
        return list.get(index);
    }

    public static class Builder {
        private Map<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> locationsFromField;
        private Map<Descriptors.FieldDescriptor, List<Builder>> subtreeBuildersFromField;

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            this.locationsFromField = new HashMap();
            this.subtreeBuildersFromField = new HashMap();
        }

        public Builder setLocation(final Descriptors.FieldDescriptor fieldDescriptor, TextFormatParseLocation location) {
            List<TextFormatParseLocation> arrayList = this.locationsFromField.get(fieldDescriptor);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.locationsFromField.put(fieldDescriptor, arrayList);
            }
            arrayList.add(location);
            return this;
        }

        public Builder getBuilderForSubMessageField(final Descriptors.FieldDescriptor fieldDescriptor) {
            List<Builder> arrayList = this.subtreeBuildersFromField.get(fieldDescriptor);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.subtreeBuildersFromField.put(fieldDescriptor, arrayList);
            }
            Builder builder = new Builder();
            arrayList.add(builder);
            return builder;
        }

        public TextFormatParseInfoTree build() {
            return new TextFormatParseInfoTree(this.locationsFromField, this.subtreeBuildersFromField, null);
        }
    }
}
