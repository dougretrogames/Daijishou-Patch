package org.apache.commons.collections4.properties;

/* JADX INFO: loaded from: classes5.dex */
public class OrderedPropertiesFactory extends AbstractPropertiesFactory<OrderedProperties> {
    public static final OrderedPropertiesFactory INSTANCE = new OrderedPropertiesFactory();

    private OrderedPropertiesFactory() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.properties.AbstractPropertiesFactory
    public OrderedProperties createProperties() {
        return new OrderedProperties();
    }
}
