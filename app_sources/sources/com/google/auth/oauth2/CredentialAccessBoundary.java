package com.google.auth.oauth2;

import com.google.api.client.json.GenericJson;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

/* INFO: loaded from: classes3.dex */
public final class CredentialAccessBoundary {
    private static final int RULES_SIZE_LIMIT = 10;
    private final List<AccessBoundaryRule> accessBoundaryRules;

    CredentialAccessBoundary(List<AccessBoundaryRule> list) {
        Preconditions.checkNotNull(list);
        Preconditions.checkArgument(!list.isEmpty(), "At least one access boundary rule must be provided.");
        Preconditions.checkArgument(list.size() < 10, String.format("The provided list has more than %s access boundary rules.", 10));
        this.accessBoundaryRules = list;
    }

    String toJson() {
        ArrayList arrayList = new ArrayList();
        for (AccessBoundaryRule accessBoundaryRule : this.accessBoundaryRules) {
            GenericJson genericJson = new GenericJson();
            genericJson.setFactory(OAuth2Utils.JSON_FACTORY);
            genericJson.put("availableResource", (Object) accessBoundaryRule.getAvailableResource());
            genericJson.put("availablePermissions", (Object) accessBoundaryRule.getAvailablePermissions());
            AccessBoundaryRule.AvailabilityCondition availabilityCondition = accessBoundaryRule.getAvailabilityCondition();
            if (availabilityCondition != null) {
                GenericJson genericJson2 = new GenericJson();
                genericJson2.setFactory(OAuth2Utils.JSON_FACTORY);
                genericJson2.put("expression", (Object) availabilityCondition.getExpression());
                if (availabilityCondition.getTitle() != null) {
                    genericJson2.put("title", (Object) availabilityCondition.getTitle());
                }
                if (availabilityCondition.getDescription() != null) {
                    genericJson2.put("description", (Object) availabilityCondition.getDescription());
                }
                genericJson.put("availabilityCondition", (Object) genericJson2);
            }
            arrayList.add(genericJson);
        }
        GenericJson genericJson3 = new GenericJson();
        genericJson3.setFactory(OAuth2Utils.JSON_FACTORY);
        genericJson3.put("accessBoundaryRules", (Object) arrayList);
        GenericJson genericJson4 = new GenericJson();
        genericJson4.setFactory(OAuth2Utils.JSON_FACTORY);
        genericJson4.put("accessBoundary", (Object) genericJson3);
        return genericJson4.toString();
    }

    public List<AccessBoundaryRule> getAccessBoundaryRules() {
        return this.accessBoundaryRules;
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public static class Builder {
        private List<AccessBoundaryRule> accessBoundaryRules;

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
        }

        public Builder setRules(List<AccessBoundaryRule> list) {
            this.accessBoundaryRules = new ArrayList((Collection) Preconditions.checkNotNull(list));
            return this;
        }

        public Builder addRule(AccessBoundaryRule accessBoundaryRule) {
            if (this.accessBoundaryRules == null) {
                this.accessBoundaryRules = new ArrayList();
            }
            this.accessBoundaryRules.add((AccessBoundaryRule) Preconditions.checkNotNull(accessBoundaryRule));
            return this;
        }

        public CredentialAccessBoundary build() {
            return new CredentialAccessBoundary(this.accessBoundaryRules);
        }
    }

    public static final class AccessBoundaryRule {

        @Nullable
        private final AvailabilityCondition availabilityCondition;
        private final List<String> availablePermissions;
        private final String availableResource;

        AccessBoundaryRule(String str, List<String> list, @Nullable AvailabilityCondition availabilityCondition) {
            this.availableResource = (String) Preconditions.checkNotNull(str);
            this.availablePermissions = new ArrayList((Collection) Preconditions.checkNotNull(list));
            this.availabilityCondition = availabilityCondition;
            Preconditions.checkArgument(!str.isEmpty(), "The provided availableResource is empty.");
            Preconditions.checkArgument(!list.isEmpty(), "The list of provided availablePermissions is empty.");
            for (String str2 : list) {
                if (str2 == null) {
                    throw new IllegalArgumentException("One of the provided available permissions is null.");
                }
                if (str2.isEmpty()) {
                    throw new IllegalArgumentException("One of the provided available permissions is empty.");
                }
            }
        }

        public String getAvailableResource() {
            return this.availableResource;
        }

        public List<String> getAvailablePermissions() {
            return this.availablePermissions;
        }

        @Nullable
        public AvailabilityCondition getAvailabilityCondition() {
            return this.availabilityCondition;
        }

        public static Builder newBuilder() {
            return new Builder(null);
        }

        public static class Builder {

            @Nullable
            private AvailabilityCondition availabilityCondition;
            private List<String> availablePermissions;
            private String availableResource;

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
            }

            public Builder setAvailableResource(String str) {
                this.availableResource = str;
                return this;
            }

            public Builder setAvailablePermissions(List<String> list) {
                this.availablePermissions = new ArrayList((Collection) Preconditions.checkNotNull(list));
                return this;
            }

            public Builder addAvailablePermission(String str) {
                if (this.availablePermissions == null) {
                    this.availablePermissions = new ArrayList();
                }
                this.availablePermissions.add(str);
                return this;
            }

            public Builder setAvailabilityCondition(AvailabilityCondition availabilityCondition) {
                this.availabilityCondition = availabilityCondition;
                return this;
            }

            public AccessBoundaryRule build() {
                return new AccessBoundaryRule(this.availableResource, this.availablePermissions, this.availabilityCondition);
            }
        }

        public static final class AvailabilityCondition {

            @Nullable
            private final String description;
            private final String expression;

            @Nullable
            private final String title;

            AvailabilityCondition(String str, @Nullable String str2, @Nullable String str3) {
                this.expression = (String) Preconditions.checkNotNull(str);
                this.title = str2;
                this.description = str3;
                Preconditions.checkArgument(!str.isEmpty(), "The provided expression is empty.");
            }

            public String getExpression() {
                return this.expression;
            }

            @Nullable
            public String getTitle() {
                return this.title;
            }

            @Nullable
            public String getDescription() {
                return this.description;
            }

            public static Builder newBuilder() {
                return new Builder(null);
            }

            public static final class Builder {

                @Nullable
                private String description;
                private String expression;

                @Nullable
                private String title;

                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                }

                public Builder setExpression(String str) {
                    this.expression = str;
                    return this;
                }

                public Builder setTitle(String str) {
                    this.title = str;
                    return this;
                }

                public Builder setDescription(String str) {
                    this.description = str;
                    return this;
                }

                public AvailabilityCondition build() {
                    return new AvailabilityCondition(this.expression, this.title, this.description);
                }
            }
        }
    }
}
