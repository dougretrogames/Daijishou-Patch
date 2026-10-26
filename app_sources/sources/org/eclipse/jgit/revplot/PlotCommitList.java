package org.eclipse.jgit.revplot;

import java.text.MessageFormat;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.revplot.PlotLane;
import org.eclipse.jgit.revwalk.RevCommitList;
import org.eclipse.jgit.revwalk.RevWalk;

/* INFO: loaded from: classes5.dex */
public class PlotCommitList<L extends PlotLane> extends RevCommitList<PlotCommit<L>> {
    static final int MAX_LENGTH = 25;
    private int positionsAllocated;
    private final TreeSet<Integer> freePositions = new TreeSet<>();
    private final HashSet<PlotLane> activeLanes = new HashSet<>(32);
    private final HashMap<PlotLane, Integer> laneLength = new HashMap<>(32);

    protected void recycleLane(L l) {
    }

    @Override // org.eclipse.jgit.revwalk.RevCommitList, org.eclipse.jgit.revwalk.RevObjectList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        super.clear();
        this.positionsAllocated = 0;
        this.freePositions.clear();
        this.activeLanes.clear();
        this.laneLength.clear();
    }

    @Override // org.eclipse.jgit.revwalk.RevCommitList
    public void source(RevWalk revWalk) {
        if (!(revWalk instanceof PlotWalk)) {
            throw new ClassCastException(MessageFormat.format(JGitText.get().classCastNotA, PlotWalk.class.getName()));
        }
        super.source(revWalk);
    }

    /* WARN: Multi-variable type inference failed */
    public void findPassingThrough(PlotCommit<L> plotCommit, Collection<L> collection) {
        for (PlotLane plotLane : plotCommit.passingLanes) {
            collection.add(plotLane);
        }
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // org.eclipse.jgit.revwalk.RevCommitList
    public void enter(int i, PlotCommit<L> plotCommit) {
        int iValueOf;
        setupChildren(plotCommit);
        int childCount = plotCommit.getChildCount();
        if (childCount == 0) {
            plotCommit.lane = nextFreeLane();
        } else if (childCount != 1 || plotCommit.children[0].getParentCount() >= 2) {
            int iIntValue = -1;
            PlotLane plotLane = null;
            PlotCommit plotCommit2 = null;
            for (int i2 = 0; i2 < childCount; i2++) {
                PlotCommit plotCommit3 = plotCommit.children[i2];
                if (plotCommit3.getParent(0) == plotCommit) {
                    Integer num = this.laneLength.get(plotCommit3.lane);
                    if (num.intValue() > iIntValue) {
                        plotLane = plotCommit3.lane;
                        iIntValue = num.intValue();
                        plotCommit2 = plotCommit3;
                    }
                }
            }
            if (plotLane != null) {
                plotCommit.lane = plotLane;
                this.laneLength.put(plotLane, Integer.valueOf(iIntValue + 1));
                handleBlockedLanes(i, plotCommit, plotCommit2);
            } else {
                plotCommit.lane = nextFreeLane();
                handleBlockedLanes(i, plotCommit, null);
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                PlotCommit plotCommit4 = plotCommit.children[i3];
                PlotCommit plotCommit5 = (PlotCommit) plotCommit4.getParent(0);
                if (plotCommit5.lane != null && plotCommit5.lane != plotCommit4.lane) {
                    closeLane(plotCommit4.lane);
                }
            }
        } else {
            plotCommit.lane = plotCommit.children[0].lane;
            Integer num2 = this.laneLength.get(plotCommit.lane);
            if (num2 != null) {
                iValueOf = Integer.valueOf(num2.intValue() + 1);
            } else {
                iValueOf = 0;
            }
            this.laneLength.put(plotCommit.lane, iValueOf);
        }
        continueActiveLanes(plotCommit);
        if (plotCommit.getParentCount() == 0) {
            closeLane(plotCommit.lane);
        }
    }

    private void continueActiveLanes(PlotCommit plotCommit) {
        for (PlotLane plotLane : this.activeLanes) {
            if (plotLane != plotCommit.lane) {
                plotCommit.addPassingLane(plotLane);
            }
        }
    }

    private void handleBlockedLanes(int i, PlotCommit plotCommit, PlotCommit plotCommit2) {
        int i2;
        PlotCommit plotCommit3;
        PlotCommit plotCommit4;
        PlotCommit[] plotCommitArr = plotCommit.children;
        int length = plotCommitArr.length;
        int i3 = 0;
        while (i3 < length) {
            PlotCommit plotCommit5 = plotCommitArr[i3];
            if (plotCommit5 == plotCommit2) {
                i2 = i;
                plotCommit3 = plotCommit;
                plotCommit4 = plotCommit2;
            } else if (plotCommit5.getParent(0) != plotCommit) {
                i2 = i;
                plotCommit3 = plotCommit;
                plotCommit4 = plotCommit2;
                plotCommit5.addMergingLane(handleMerge(i2, plotCommit3, plotCommit4, plotCommit5, plotCommit.lane));
            } else {
                i2 = i;
                plotCommit3 = plotCommit;
                plotCommit4 = plotCommit2;
                plotCommit3.addForkingOffLane(plotCommit5.lane);
            }
            i3++;
            i = i2;
            plotCommit = plotCommit3;
            plotCommit2 = plotCommit4;
        }
    }

    private PlotLane handleMerge(int i, PlotCommit plotCommit, PlotCommit plotCommit2, PlotCommit plotCommit3, PlotLane plotLane) {
        BitSet bitSet = new BitSet();
        int i2 = i - 1;
        int i3 = i2;
        while (true) {
            if (i3 < 0) {
                i3 = i;
                break;
            }
            PlotCommit plotCommit4 = (PlotCommit) get(i3);
            if (plotCommit4 == plotCommit3) {
                break;
            }
            addBlockedPosition(bitSet, plotCommit4);
            i3--;
        }
        if (bitSet.get(plotLane.getPosition())) {
            if (plotCommit2 != null) {
                while (i2 > i3) {
                    if (((PlotCommit) get(i2)) == plotCommit2) {
                        plotLane = nextFreeLane(bitSet);
                        plotCommit.addForkingOffLane(plotLane);
                        closeLane(plotLane);
                    } else {
                        i2--;
                    }
                }
                int freePosition = getFreePosition(bitSet);
                this.freePositions.add(Integer.valueOf(plotLane.getPosition()));
                plotLane.position = freePosition;
            } else {
                int freePosition2 = getFreePosition(bitSet);
                this.freePositions.add(Integer.valueOf(plotLane.getPosition()));
                plotLane.position = freePosition2;
            }
        }
        drawLaneToChild(i, plotCommit3, plotLane);
        return plotLane;
    }

    private void drawLaneToChild(int i, PlotCommit plotCommit, PlotLane plotLane) {
        for (int i2 = i - 1; i2 >= 0; i2--) {
            PlotCommit plotCommit2 = (PlotCommit) get(i2);
            if (plotCommit2 == plotCommit) {
                return;
            }
            if (plotCommit2 != null) {
                plotCommit2.addPassingLane(plotLane);
            }
        }
    }

    private static void addBlockedPosition(BitSet bitSet, PlotCommit plotCommit) {
        if (plotCommit != null) {
            PlotLane lane = plotCommit.getLane();
            if (lane != null) {
                bitSet.set(lane.getPosition());
            }
            for (PlotLane plotLane : plotCommit.forkingOffLanes) {
                bitSet.set(plotLane.getPosition());
            }
            for (PlotLane plotLane2 : plotCommit.mergingLanes) {
                bitSet.set(plotLane2.getPosition());
            }
        }
    }

    private void closeLane(PlotLane plotLane) {
        if (this.activeLanes.remove(plotLane)) {
            recycleLane(plotLane);
            this.laneLength.remove(plotLane);
            this.freePositions.add(Integer.valueOf(plotLane.getPosition()));
        }
    }

    private void setupChildren(PlotCommit<L> plotCommit) {
        int parentCount = plotCommit.getParentCount();
        for (int i = 0; i < parentCount; i++) {
            ((PlotCommit) plotCommit.getParent(i)).addChild(plotCommit);
        }
    }

    private PlotLane nextFreeLane() {
        return nextFreeLane(null);
    }

    private PlotLane nextFreeLane(BitSet bitSet) {
        PlotLane plotLaneCreateLane = createLane();
        plotLaneCreateLane.position = getFreePosition(bitSet);
        this.activeLanes.add(plotLaneCreateLane);
        this.laneLength.put(plotLaneCreateLane, 1);
        return plotLaneCreateLane;
    }

    private int getFreePosition(BitSet bitSet) {
        if (this.freePositions.isEmpty()) {
            int i = this.positionsAllocated;
            this.positionsAllocated = i + 1;
            return i;
        }
        if (bitSet != null) {
            for (Integer num : this.freePositions) {
                if (!bitSet.get(num.intValue())) {
                    this.freePositions.remove(num);
                    return num.intValue();
                }
            }
            int i2 = this.positionsAllocated;
            this.positionsAllocated = i2 + 1;
            return i2;
        }
        Integer numFirst = this.freePositions.first();
        this.freePositions.remove(numFirst);
        return numFirst.intValue();
    }

    protected L createLane() {
        return (L) new PlotLane();
    }
}
