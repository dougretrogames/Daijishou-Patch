package io.noties.markwon;

import org.commonmark.node.SoftLineBreak;

/* JADX INFO: loaded from: classes4.dex */
public class SoftBreakAddsNewLinePlugin extends AbstractMarkwonPlugin {
    public static SoftBreakAddsNewLinePlugin create() {
        return new SoftBreakAddsNewLinePlugin();
    }

    /* JADX INFO: renamed from: io.noties.markwon.SoftBreakAddsNewLinePlugin$1, reason: invalid class name */
    class AnonymousClass1 implements MarkwonVisitor.NodeVisitor<SoftLineBreak> {
        AnonymousClass1() {
        }

        @Override // io.noties.markwon.MarkwonVisitor.NodeVisitor
        public void visit(MarkwonVisitor markwonVisitor, SoftLineBreak softLineBreak) {
            markwonVisitor.ensureNewLine();
        }
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureVisitor(MarkwonVisitor.Builder builder) {
        builder.on(SoftLineBreak.class, new AnonymousClass1());
    }
}
