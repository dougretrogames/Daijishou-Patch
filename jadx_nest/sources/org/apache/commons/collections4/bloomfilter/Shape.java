package org.apache.commons.collections4.bloomfilter;

/* JADX INFO: loaded from: classes5.dex */
public final class Shape {
    private static final double DENOMINATOR;
    private static final double LN_2;
    private final int numberOfBits;
    private final int numberOfHashFunctions;

    static {
        double dLog = Math.log(2.0d);
        LN_2 = dLog;
        DENOMINATOR = (-dLog) * dLog;
    }

    private static int calculateNumberOfHashFunctions(int i, int i2) {
        long jRound = Math.round((LN_2 * ((double) i2)) / ((double) i));
        if (jRound >= 1) {
            return (int) jRound;
        }
        throw new IllegalArgumentException(String.format("Filter too small: Calculated number of hash functions (%s) was less than 1", Long.valueOf(jRound)));
    }

    private static void checkCalculatedProbability(double d) {
        if (d >= 1.0d) {
            throw new IllegalArgumentException("Calculated probability is greater than or equal to 1: " + d);
        }
    }

    private static int checkNumberOfBits(int i) {
        if (i >= 1) {
            return i;
        }
        throw new IllegalArgumentException("Number of bits must be greater than 0: " + i);
    }

    private static int checkNumberOfHashFunctions(int i) {
        if (i >= 1) {
            return i;
        }
        throw new IllegalArgumentException("Number of hash functions must be greater than 0: " + i);
    }

    private static int checkNumberOfItems(int i) {
        if (i >= 1) {
            return i;
        }
        throw new IllegalArgumentException("Number of items must be greater than 0: " + i);
    }

    private static void checkProbability(double d) {
        if (d <= 0.0d || d >= 1.0d) {
            throw new IllegalArgumentException("Probability must be greater than 0 and less than 1: " + d);
        }
    }

    public static Shape fromKM(int i, int i2) {
        return new Shape(i, i2);
    }

    public static Shape fromNM(int i, int i2) {
        checkNumberOfItems(i);
        checkNumberOfBits(i2);
        Shape shape = new Shape(calculateNumberOfHashFunctions(i, i2), i2);
        checkCalculatedProbability(shape.getProbability(i));
        return shape;
    }

    public static Shape fromNMK(int i, int i2, int i3) {
        checkNumberOfItems(i);
        checkNumberOfBits(i2);
        checkNumberOfHashFunctions(i3);
        Shape shape = new Shape(i3, i2);
        checkCalculatedProbability(shape.getProbability(i));
        return shape;
    }

    public static Shape fromNP(int i, double d) {
        checkNumberOfItems(i);
        checkProbability(d);
        double dCeil = Math.ceil((((double) i) * Math.log(d)) / DENOMINATOR);
        if (dCeil > 2.147483647E9d) {
            throw new IllegalArgumentException("Resulting filter has more than 2147483647 bits: " + dCeil);
        }
        int i2 = (int) dCeil;
        Shape shape = new Shape(calculateNumberOfHashFunctions(i, i2), i2);
        checkCalculatedProbability(shape.getProbability(i));
        return shape;
    }

    public static Shape fromPMK(double d, int i, int i2) {
        checkProbability(d);
        checkNumberOfBits(i);
        checkNumberOfHashFunctions(i2);
        double dCeil = Math.ceil(((double) i) / (((double) (-i2)) / Math.log(-Math.expm1(Math.log(d) / ((double) i2)))));
        Shape shape = new Shape(i2, i);
        checkCalculatedProbability(shape.getProbability((int) dCeil));
        return shape;
    }

    private Shape(int i, int i2) {
        this.numberOfHashFunctions = checkNumberOfHashFunctions(i);
        this.numberOfBits = checkNumberOfBits(i2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Shape) {
            Shape shape = (Shape) obj;
            if (this.numberOfBits == shape.numberOfBits && this.numberOfHashFunctions == shape.numberOfHashFunctions) {
                return true;
            }
        }
        return false;
    }

    public double estimateMaxN() {
        return (((double) this.numberOfBits) * LN_2) / ((double) this.numberOfHashFunctions);
    }

    public double estimateN(int i) {
        double d = i;
        double d2 = this.numberOfBits;
        return (-(d2 / ((double) this.numberOfHashFunctions))) * Math.log1p((-d) / d2);
    }

    public int getNumberOfBits() {
        return this.numberOfBits;
    }

    public int getNumberOfHashFunctions() {
        return this.numberOfHashFunctions;
    }

    public double getProbability(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Number of items must be greater than or equal to 0: " + i);
        }
        if (i == 0) {
            return 0.0d;
        }
        return Math.pow(-Math.expm1(((((double) this.numberOfHashFunctions) * (-1.0d)) * ((double) i)) / ((double) this.numberOfBits)), this.numberOfHashFunctions);
    }

    public int hashCode() {
        return ((this.numberOfBits + 31) * 31) + this.numberOfHashFunctions;
    }

    public boolean isSparse(int i) {
        return i <= BitMaps.numberOfBitMaps(this) * 2;
    }

    public String toString() {
        return String.format("Shape[k=%s m=%s]", Integer.valueOf(this.numberOfHashFunctions), Integer.valueOf(this.numberOfBits));
    }
}
