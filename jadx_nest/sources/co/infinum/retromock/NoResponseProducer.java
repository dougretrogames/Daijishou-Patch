package co.infinum.retromock;

/* JADX INFO: loaded from: classes3.dex */
final class NoResponseProducer implements ParamsProducer {
    private final ResponseParams defaults;
    private final Retromock retromock;

    NoResponseProducer(Retromock retromock, ResponseParams responseParams) {
        this.retromock = retromock;
        this.defaults = responseParams;
    }

    @Override // co.infinum.retromock.ParamsProducer
    public ResponseParams produce() {
        return this.defaults.newBuilder().bodyFactory(new RetromockBodyFactory(this.retromock.bodyFactory(PassThroughBodyFactory.class), "")).build();
    }
}
