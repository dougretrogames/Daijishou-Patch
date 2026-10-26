package org.eclipse.jgit.revplot;

import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.revplot.PlotLane;
import org.eclipse.jgit.revwalk.RevCommit;

/* INFO: loaded from: classes5.dex */
public class PlotCommit<L extends PlotLane> extends RevCommit {
    static final PlotCommit[] NO_CHILDREN = new PlotCommit[0];
    static final PlotLane[] NO_LANES = new PlotLane[0];
    static final Ref[] NO_REFS = new Ref[0];
    PlotCommit[] children;
    PlotLane[] forkingOffLanes;
    PlotLane lane;
    PlotLane[] mergingLanes;
    PlotLane[] passingLanes;
    Ref[] refs;

    protected PlotCommit(AnyObjectId anyObjectId) {
        super(anyObjectId);
        PlotLane[] plotLaneArr = NO_LANES;
        this.forkingOffLanes = plotLaneArr;
        this.passingLanes = plotLaneArr;
        this.mergingLanes = plotLaneArr;
        this.children = NO_CHILDREN;
        this.refs = NO_REFS;
    }

    void addForkingOffLane(PlotLane plotLane) {
        this.forkingOffLanes = addLane(plotLane, this.forkingOffLanes);
    }

    void addPassingLane(PlotLane plotLane) {
        this.passingLanes = addLane(plotLane, this.passingLanes);
    }

    void addMergingLane(PlotLane plotLane) {
        this.mergingLanes = addLane(plotLane, this.mergingLanes);
    }

    private static PlotLane[] addLane(PlotLane plotLane, PlotLane[] plotLaneArr) {
        int length = plotLaneArr.length;
        if (length == 0) {
            return new PlotLane[]{plotLane};
        }
        if (length == 1) {
            return new PlotLane[]{plotLaneArr[0], plotLane};
        }
        PlotLane[] plotLaneArr2 = new PlotLane[length + 1];
        System.arraycopy(plotLaneArr, 0, plotLaneArr2, 0, length);
        plotLaneArr2[length] = plotLane;
        return plotLaneArr2;
    }

    void addChild(PlotCommit plotCommit) {
        PlotCommit[] plotCommitArr = this.children;
        int length = plotCommitArr.length;
        if (length == 0) {
            this.children = new PlotCommit[]{plotCommit};
            return;
        }
        if (length == 1) {
            if (plotCommit.getId().equals((AnyObjectId) this.children[0].getId())) {
                return;
            }
            this.children = new PlotCommit[]{this.children[0], plotCommit};
            return;
        }
        for (PlotCommit plotCommit2 : plotCommitArr) {
            if (plotCommit.getId().equals((AnyObjectId) plotCommit2.getId())) {
                return;
            }
        }
        PlotCommit[] plotCommitArr2 = new PlotCommit[length + 1];
        System.arraycopy(this.children, 0, plotCommitArr2, 0, length);
        plotCommitArr2[length] = plotCommit;
        this.children = plotCommitArr2;
    }

    public final int getChildCount() {
        return this.children.length;
    }

    public final PlotCommit getChild(int i) {
        return this.children[i];
    }

    public final boolean isChild(PlotCommit plotCommit) {
        for (PlotCommit plotCommit2 : this.children) {
            if (plotCommit2 == plotCommit) {
                return true;
            }
        }
        return false;
    }

    public final int getRefCount() {
        return this.refs.length;
    }

    public final Ref getRef(int i) {
        return this.refs[i];
    }

    public final L getLane() {
        return (L) this.lane;
    }

    @Override // org.eclipse.jgit.revwalk.RevCommit
    public void reset() {
        PlotLane[] plotLaneArr = NO_LANES;
        this.forkingOffLanes = plotLaneArr;
        this.passingLanes = plotLaneArr;
        this.mergingLanes = plotLaneArr;
        this.children = NO_CHILDREN;
        this.lane = null;
        super.reset();
    }
}
