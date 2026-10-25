package org.jsoup.select;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

/* JADX INFO: loaded from: classes5.dex */
public class Collector {
    private Collector() {
    }

    public static Elements collect(Evaluator evaluator, Element element) {
        Stream<Element> stream;
        if (evaluator.wantsNodes()) {
            stream = streamNodes(evaluator, element, Element.class);
        } else {
            stream = stream(evaluator, element);
        }
        return (Elements) stream.collect(Collectors.toCollection(new Collector$$ExternalSyntheticLambda1()));
    }

    public static Stream<Element> stream(Evaluator evaluator, Element element) {
        evaluator.reset();
        return element.stream().filter(evaluator.asPredicate(element));
    }

    public static <T extends Node> Stream<T> streamNodes(Evaluator evaluator, Element element, Class<T> cls) {
        evaluator.reset();
        return element.nodeStream(cls).filter(evaluator.asNodePredicate(element));
    }

    public static Element findFirst(Evaluator evaluator, Element element) {
        return stream(evaluator, element).findFirst().orElse(null);
    }

    public static <T extends Node> T findFirstNode(Evaluator evaluator, Element element, Class<T> cls) {
        return (T) streamNodes(evaluator, element, cls).findFirst().orElse(null);
    }

    public static <T extends Node> Nodes<T> collectNodes(Evaluator evaluator, Element element, Class<T> cls) {
        return (Nodes) streamNodes(evaluator, element, cls).collect(Collectors.toCollection(new Collector$$ExternalSyntheticLambda0()));
    }
}
