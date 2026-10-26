package io.noties.markwon;

/* INFO: loaded from: classes4.dex */
abstract class MarkwonVisitorFactory {
    abstract MarkwonVisitor create();

    MarkwonVisitorFactory() {
    }

    /* INFO: renamed from: io.noties.markwon.MarkwonVisitorFactory$1, reason: invalid class name */
    class AnonymousClass1 extends MarkwonVisitorFactory {
        final /* synthetic */ MarkwonVisitor.Builder val$builder;
        final /* synthetic */ MarkwonConfiguration val$configuration;

        AnonymousClass1(MarkwonVisitor.Builder builder, MarkwonConfiguration markwonConfiguration) {
            this.val$builder = builder;
            this.val$configuration = markwonConfiguration;
        }

        @Override // io.noties.markwon.MarkwonVisitorFactory
        MarkwonVisitor create() {
            return this.val$builder.build(this.val$configuration, new RenderPropsImpl());
        }
    }

    static MarkwonVisitorFactory create(MarkwonVisitor.Builder builder, MarkwonConfiguration markwonConfiguration) {
        return new AnonymousClass1(builder, markwonConfiguration);
    }
}
