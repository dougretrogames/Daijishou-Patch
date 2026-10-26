package org.retroachivements.api.data.pojo.system;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;
import org.retroachivements.api.core.BooleanJsonDeserializer;

/* INFO: compiled from: GetConsoleID.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lorg/retroachivements/api/data/pojo/system/GetConsoleID;", "", "()V", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetConsoleID {

    /* INFO: compiled from: GetConsoleID.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lorg/retroachivements/api/data/pojo/system/GetConsoleID$Response;", "Ljava/util/ArrayList;", "Lorg/retroachivements/api/data/pojo/system/GetConsoleID$Response$Console;", "Lkotlin/collections/ArrayList;", "()V", "Console", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Response extends ArrayList<Console> {

        /* INFO: compiled from: GetConsoleID.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001d"}, d2 = {"Lorg/retroachivements/api/data/pojo/system/GetConsoleID$Response$Console;", "", "id", "", "name", "", "iconUrl", "active", "", "isGameSystem", "(JLjava/lang/String;Ljava/lang/String;ZZ)V", "getActive", "()Z", "getIconUrl", "()Ljava/lang/String;", "getId", "()J", "getName", "component1", "component2", "component3", "component4", "component5", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "other", "hashCode", "", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Console {

            @SerializedName("Active")
            @JsonAdapter(BooleanJsonDeserializer.class)
            private final boolean active;

            @SerializedName("IconURL")
            private final String iconUrl;

            @SerializedName("ID")
            private final long id;

            @SerializedName("IsGameSystem")
            @JsonAdapter(BooleanJsonDeserializer.class)
            private final boolean isGameSystem;

            @SerializedName("Name")
            private final String name;

            public static /* synthetic */ Console copy$default(Console console, long j, String str, String str2, boolean z, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = console.id;
                }
                long j2 = j;
                if ((i & 2) != 0) {
                    str = console.name;
                }
                String str3 = str;
                if ((i & 4) != 0) {
                    str2 = console.iconUrl;
                }
                String str4 = str2;
                if ((i & 8) != 0) {
                    z = console.active;
                }
                boolean z3 = z;
                if ((i & 16) != 0) {
                    z2 = console.isGameSystem;
                }
                return console.copy(j2, str3, str4, z3, z2);
            }

            /* INFO: renamed from: component1, reason: from getter */
            public final long getId() {
                return this.id;
            }

            /* INFO: renamed from: component2, reason: from getter */
            public final String getName() {
                return this.name;
            }

            /* INFO: renamed from: component3, reason: from getter */
            public final String getIconUrl() {
                return this.iconUrl;
            }

            /* INFO: renamed from: component4, reason: from getter */
            public final boolean getActive() {
                return this.active;
            }

            /* INFO: renamed from: component5, reason: from getter */
            public final boolean getIsGameSystem() {
                return this.isGameSystem;
            }

            public final Console copy(long id2, String name, String iconUrl, boolean active, boolean isGameSystem) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
                return new Console(id2, name, iconUrl, active, isGameSystem);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Console)) {
                    return false;
                }
                Console console = (Console) other;
                return this.id == console.id && Intrinsics.areEqual(this.name, console.name) && Intrinsics.areEqual(this.iconUrl, console.iconUrl) && this.active == console.active && this.isGameSystem == console.isGameSystem;
            }

            public int hashCode() {
                return (((((((Long.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + Boolean.hashCode(this.active)) * 31) + Boolean.hashCode(this.isGameSystem);
            }

            public String toString() {
                return "Console(id=" + this.id + ", name=" + this.name + ", iconUrl=" + this.iconUrl + ", active=" + this.active + ", isGameSystem=" + this.isGameSystem + ')';
            }

            public Console(long j, String name, String iconUrl, boolean z, boolean z2) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
                this.id = j;
                this.name = name;
                this.iconUrl = iconUrl;
                this.active = z;
                this.isGameSystem = z2;
            }

            public final long getId() {
                return this.id;
            }

            public final String getName() {
                return this.name;
            }

            public final String getIconUrl() {
                return this.iconUrl;
            }

            public final boolean getActive() {
                return this.active;
            }

            public final boolean isGameSystem() {
                return this.isGameSystem;
            }
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Console) {
                return contains((Console) obj);
            }
            return false;
        }

        public /* bridge */ boolean contains(Console console) {
            return super.contains((Object) console);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Console) {
                return indexOf((Console) obj);
            }
            return -1;
        }

        public /* bridge */ int indexOf(Console console) {
            return super.indexOf((Object) console);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Console) {
                return lastIndexOf((Console) obj);
            }
            return -1;
        }

        public /* bridge */ int lastIndexOf(Console console) {
            return super.lastIndexOf((Object) console);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ Console remove(int i) {
            return removeAt(i);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean remove(Object obj) {
            if (obj instanceof Console) {
                return remove((Console) obj);
            }
            return false;
        }

        public /* bridge */ boolean remove(Console console) {
            return super.remove((Object) console);
        }

        public /* bridge */ Console removeAt(int i) {
            return (Console) super.remove(i);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ int size() {
            return getSize();
        }
    }
}
