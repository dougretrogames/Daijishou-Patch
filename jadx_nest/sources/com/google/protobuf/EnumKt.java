package com.google.protobuf;

import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: EnumKt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/EnumKt;", "", "()V", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EnumKt {
    public static final EnumKt INSTANCE = new EnumKt();

    /* JADX INFO: compiled from: EnumKt.kt */
    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\u0012\b\u0007\u0018\u0000 K2\u00020\u0001:\u0003KLMB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010.\u001a\u00020/H\u0001J\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u000201J\u0006\u00103\u001a\u000201J\u0006\u00104\u001a\u000201J\u0006\u00105\u001a\u000206J%\u00107\u001a\u000201*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0005\u001a\u00020\u000eH\u0007¢\u0006\u0002\b8J%\u00107\u001a\u000201*\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\r2\u0006\u0010\u0005\u001a\u00020\u0016H\u0007¢\u0006\u0002\b9J+\u0010:\u001a\u000201*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000e0<H\u0007¢\u0006\u0002\b=J+\u0010:\u001a\u000201*\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\r2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00160<H\u0007¢\u0006\u0002\b>J\u001d\u0010?\u001a\u000201*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0007¢\u0006\u0002\b@J\u001d\u0010?\u001a\u000201*\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\rH\u0007¢\u0006\u0002\bAJ&\u0010B\u001a\u000201*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0005\u001a\u00020\u000eH\u0087\n¢\u0006\u0002\bCJ,\u0010B\u001a\u000201*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000e0<H\u0087\n¢\u0006\u0002\bDJ&\u0010B\u001a\u000201*\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\r2\u0006\u0010\u0005\u001a\u00020\u0016H\u0087\n¢\u0006\u0002\bEJ,\u0010B\u001a\u000201*\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\r2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00160<H\u0087\n¢\u0006\u0002\bFJ.\u0010G\u001a\u000201*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010H\u001a\u00020%2\u0006\u0010\u0005\u001a\u00020\u000eH\u0087\u0002¢\u0006\u0002\bIJ.\u0010G\u001a\u000201*\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\r2\u0006\u0010H\u001a\u00020%2\u0006\u0010\u0005\u001a\u00020\u0016H\u0087\u0002¢\u0006\u0002\bJR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001d\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\r8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0011R$\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00198G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u001f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010&\u001a\u00020%2\u0006\u0010\u0005\u001a\u00020%8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0017\u0010+\u001a\u0004\u0018\u00010\u0019*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u0006N"}, d2 = {"Lcom/google/protobuf/EnumKt$Dsl;", "", "_builder", "Lcom/google/protobuf/Enum$Builder;", "(Lcom/google/protobuf/Enum$Builder;)V", "value", "", "edition", "getEdition", "()Ljava/lang/String;", "setEdition", "(Ljava/lang/String;)V", "enumvalue", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/google/protobuf/EnumValue;", "Lcom/google/protobuf/EnumKt$Dsl$EnumvalueProxy;", "getEnumvalue", "()Lcom/google/protobuf/kotlin/DslList;", "name", "getName", "setName", "options", "Lcom/google/protobuf/Option;", "Lcom/google/protobuf/EnumKt$Dsl$OptionsProxy;", "getOptions", "Lcom/google/protobuf/SourceContext;", "sourceContext", "getSourceContext", "()Lcom/google/protobuf/SourceContext;", "setSourceContext", "(Lcom/google/protobuf/SourceContext;)V", "Lcom/google/protobuf/Syntax;", "syntax", "getSyntax", "()Lcom/google/protobuf/Syntax;", "setSyntax", "(Lcom/google/protobuf/Syntax;)V", "", "syntaxValue", "getSyntaxValue", "()I", "setSyntaxValue", "(I)V", "sourceContextOrNull", "getSourceContextOrNull", "(Lcom/google/protobuf/EnumKt$Dsl;)Lcom/google/protobuf/SourceContext;", "_build", "Lcom/google/protobuf/Enum;", "clearEdition", "", "clearName", "clearSourceContext", "clearSyntax", "hasSourceContext", "", "add", "addEnumvalue", "addOptions", "addAll", "values", "", "addAllEnumvalue", "addAllOptions", "clear", "clearEnumvalue", "clearOptions", "plusAssign", "plusAssignEnumvalue", "plusAssignAllEnumvalue", "plusAssignOptions", "plusAssignAllOptions", "set", ConfigConstants.CONFIG_INDEX_SECTION, "setEnumvalue", "setOptions", "Companion", "EnumvalueProxy", "OptionsProxy", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Dsl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Enum.Builder _builder;

        public /* synthetic */ Dsl(Enum.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        private Dsl(Enum.Builder builder) {
            this._builder = builder;
        }

        /* JADX INFO: compiled from: EnumKt.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/EnumKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/EnumKt$Dsl;", "builder", "Lcom/google/protobuf/Enum$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Dsl _create(Enum.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public final /* synthetic */ Enum _build() {
            Enum enumBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(enumBuild, "_builder.build()");
            return enumBuild;
        }

        public final String getName() {
            String name = this._builder.getName();
            Intrinsics.checkNotNullExpressionValue(name, "_builder.getName()");
            return name;
        }

        public final void setName(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setName(value);
        }

        public final void clearName() {
            this._builder.clearName();
        }

        /* JADX INFO: compiled from: EnumKt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/EnumKt$Dsl$EnumvalueProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class EnumvalueProxy extends DslProxy {
            private EnumvalueProxy() {
            }
        }

        public final /* synthetic */ DslList getEnumvalue() {
            List<EnumValue> enumvalueList = this._builder.getEnumvalueList();
            Intrinsics.checkNotNullExpressionValue(enumvalueList, "_builder.getEnumvalueList()");
            return new DslList(enumvalueList);
        }

        public final /* synthetic */ void addEnumvalue(DslList dslList, EnumValue value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addEnumvalue(value);
        }

        public final /* synthetic */ void plusAssignEnumvalue(DslList<EnumValue, EnumvalueProxy> dslList, EnumValue value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addEnumvalue(dslList, value);
        }

        public final /* synthetic */ void addAllEnumvalue(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllEnumvalue(values);
        }

        public final /* synthetic */ void plusAssignAllEnumvalue(DslList<EnumValue, EnumvalueProxy> dslList, Iterable<EnumValue> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllEnumvalue(dslList, values);
        }

        public final /* synthetic */ void setEnumvalue(DslList dslList, int i, EnumValue value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setEnumvalue(i, value);
        }

        public final /* synthetic */ void clearEnumvalue(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearEnumvalue();
        }

        /* JADX INFO: compiled from: EnumKt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/EnumKt$Dsl$OptionsProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class OptionsProxy extends DslProxy {
            private OptionsProxy() {
            }
        }

        public final /* synthetic */ DslList getOptions() {
            List<Option> optionsList = this._builder.getOptionsList();
            Intrinsics.checkNotNullExpressionValue(optionsList, "_builder.getOptionsList()");
            return new DslList(optionsList);
        }

        public final /* synthetic */ void addOptions(DslList dslList, Option value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addOptions(value);
        }

        public final /* synthetic */ void plusAssignOptions(DslList<Option, OptionsProxy> dslList, Option value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addOptions(dslList, value);
        }

        public final /* synthetic */ void addAllOptions(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllOptions(values);
        }

        public final /* synthetic */ void plusAssignAllOptions(DslList<Option, OptionsProxy> dslList, Iterable<Option> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllOptions(dslList, values);
        }

        public final /* synthetic */ void setOptions(DslList dslList, int i, Option value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setOptions(i, value);
        }

        public final /* synthetic */ void clearOptions(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearOptions();
        }

        public final SourceContext getSourceContext() {
            SourceContext sourceContext = this._builder.getSourceContext();
            Intrinsics.checkNotNullExpressionValue(sourceContext, "_builder.getSourceContext()");
            return sourceContext;
        }

        public final void setSourceContext(SourceContext value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setSourceContext(value);
        }

        public final void clearSourceContext() {
            this._builder.clearSourceContext();
        }

        public final boolean hasSourceContext() {
            return this._builder.hasSourceContext();
        }

        public final SourceContext getSourceContextOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return EnumKtKt.getSourceContextOrNull(dsl._builder);
        }

        public final Syntax getSyntax() {
            Syntax syntax = this._builder.getSyntax();
            Intrinsics.checkNotNullExpressionValue(syntax, "_builder.getSyntax()");
            return syntax;
        }

        public final void setSyntax(Syntax value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setSyntax(value);
        }

        public final int getSyntaxValue() {
            return this._builder.getSyntaxValue();
        }

        public final void setSyntaxValue(int i) {
            this._builder.setSyntaxValue(i);
        }

        public final void clearSyntax() {
            this._builder.clearSyntax();
        }

        public final String getEdition() {
            String edition = this._builder.getEdition();
            Intrinsics.checkNotNullExpressionValue(edition, "_builder.getEdition()");
            return edition;
        }

        public final void setEdition(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setEdition(value);
        }

        public final void clearEdition() {
            this._builder.clearEdition();
        }
    }

    private EnumKt() {
    }
}
