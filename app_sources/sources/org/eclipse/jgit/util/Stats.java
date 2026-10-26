package org.eclipse.jgit.util;

/* INFO: loaded from: classes5.dex */
public class Stats {
    private int n = 0;
    private double avg = 0.0d;
    private double min = 0.0d;
    private double max = 0.0d;
    private double sum = 0.0d;

    public void add(double d) {
        int i = this.n + 1;
        this.n = i;
        this.min = i == 1 ? d : Math.min(this.min, d);
        this.max = this.n == 1 ? d : Math.max(this.max, d);
        double d2 = this.avg;
        double d3 = d - d2;
        int i2 = this.n;
        this.avg = d2 + (d3 / ((double) i2));
        this.sum += ((d3 * d3) * ((double) (i2 - 1))) / ((double) i2);
    }

    public int count() {
        return this.n;
    }

    public double min() {
        if (this.n < 1) {
            return Double.NaN;
        }
        return this.min;
    }

    public double max() {
        if (this.n < 1) {
            return Double.NaN;
        }
        return this.max;
    }

    public double avg() {
        if (this.n < 1) {
            return Double.NaN;
        }
        return this.avg;
    }

    public double var() {
        int i = this.n;
        if (i < 2) {
            return Double.NaN;
        }
        return this.sum / ((double) (i - 1));
    }

    public double stddev() {
        return Math.sqrt(var());
    }
}
