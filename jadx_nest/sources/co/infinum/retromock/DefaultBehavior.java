package co.infinum.retromock;

/* INFO: loaded from: classes3.dex */
public class DefaultBehavior implements Behavior {
    static final DefaultBehavior INSTANCE = new DefaultBehavior(1000, 500);
    private final int durationDeviation;
    private final long durationMillis;
    private final RandomProvider randomProvider;

    DefaultBehavior(long j, int i) {
        this(j, i, new ThreadLocalRandomProvider());
    }

    DefaultBehavior(long j, int i, RandomProvider randomProvider) {
        if (i < 0) {
            throw new IllegalArgumentException("Behavior deviation must be positive or zero.");
        }
        this.durationMillis = j;
        this.durationDeviation = i;
        this.randomProvider = randomProvider;
    }

    @Override // co.infinum.retromock.Behavior
    public final long delayMillis() {
        int i = this.durationDeviation;
        if (i == 0) {
            return this.durationMillis;
        }
        return (this.durationMillis + this.randomProvider.nextLong(((long) i) * 2)) - ((long) this.durationDeviation);
    }
}
