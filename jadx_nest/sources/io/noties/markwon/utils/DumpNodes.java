package io.noties.markwon.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.apache.http.message.TokenParser;
import org.commonmark.node.Node;
import org.commonmark.node.Visitor;

/* INFO: loaded from: classes4.dex */
public abstract class DumpNodes {

    public interface NodeProcessor {
        String process(Node node);
    }

    public static String dump(Node node) {
        return dump(node, null);
    }

    public static String dump(Node node, NodeProcessor nodeProcessor) {
        if (nodeProcessor == null) {
            nodeProcessor = new NodeProcessorToString(null);
        }
        Indent indent = new Indent(null);
        StringBuilder sb = new StringBuilder();
        node.accept((Visitor) Proxy.newProxyInstance(Visitor.class.getClassLoader(), new Class[]{Visitor.class}, new AnonymousClass1(indent, sb, nodeProcessor)));
        return sb.toString();
    }

    /* INFO: renamed from: io.noties.markwon.utils.DumpNodes$1, reason: invalid class name */
    class AnonymousClass1 implements InvocationHandler {
        final /* synthetic */ StringBuilder val$builder;
        final /* synthetic */ Indent val$indent;
        final /* synthetic */ NodeProcessor val$processor;

        AnonymousClass1(Indent indent, StringBuilder sb, NodeProcessor nodeProcessor) {
            this.val$indent = indent;
            this.val$builder = sb;
            this.val$processor = nodeProcessor;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            Node node = (Node) objArr[0];
            this.val$indent.appendTo(this.val$builder);
            this.val$builder.append(this.val$processor.process(node));
            if (node.getFirstChild() != null) {
                this.val$builder.append(" [\n");
                this.val$indent.increment();
                DumpNodes.visitChildren((Visitor) obj, node);
                this.val$indent.decrement();
                this.val$indent.appendTo(this.val$builder);
                this.val$builder.append("]\n");
                return null;
            }
            this.val$builder.append("\n");
            return null;
        }
    }

    private DumpNodes() {
    }

    private static class Indent {
        private int count;

        private Indent() {
        }

        /* synthetic */ Indent(AnonymousClass1 anonymousClass1) {
            this();
        }

        void increment() {
            this.count++;
        }

        void decrement() {
            this.count--;
        }

        void appendTo(StringBuilder sb) {
            for (int i = 0; i < this.count; i++) {
                sb.append(TokenParser.SP).append(TokenParser.SP);
            }
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static void visitChildren(Visitor visitor, Node node) {
        Node firstChild = node.getFirstChild();
        while (firstChild != null) {
            Node next = firstChild.getNext();
            firstChild.accept(visitor);
            firstChild = next;
        }
    }

    private static class NodeProcessorToString implements NodeProcessor {
        private NodeProcessorToString() {
        }

        /* synthetic */ NodeProcessorToString(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // io.noties.markwon.utils.DumpNodes.NodeProcessor
        public String process(Node node) {
            return node.toString();
        }
    }
}
