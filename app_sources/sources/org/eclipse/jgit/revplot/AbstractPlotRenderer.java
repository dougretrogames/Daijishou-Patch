package org.eclipse.jgit.revplot;

import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.revplot.PlotLane;
import org.eclipse.jgit.revwalk.RevFlag;

/* INFO: loaded from: classes5.dex */
public abstract class AbstractPlotRenderer<TLane extends PlotLane, TColor> {
    private static final int LANE_WIDTH = 14;
    private static final int LEFT_PAD = 2;
    private static final int LINE_WIDTH = 2;

    protected abstract void drawBoundaryDot(int i, int i2, int i3, int i4);

    protected abstract void drawCommitDot(int i, int i2, int i3, int i4);

    protected abstract int drawLabel(int i, int i2, Ref ref);

    protected abstract void drawLine(TColor tcolor, int i, int i2, int i3, int i4, int i5);

    protected abstract void drawText(String str, int i, int i2);

    protected abstract TColor laneColor(TLane tlane);

    protected void paintCommit(PlotCommit<TLane> plotCommit, int i) {
        AbstractPlotRenderer<TLane, TColor> abstractPlotRenderer;
        AbstractPlotRenderer<TLane, TColor> abstractPlotRenderer2;
        int i2;
        AbstractPlotRenderer<TLane, TColor> abstractPlotRenderer3 = this;
        int iComputeDotSize = computeDotSize(i);
        PlotLane lane = plotCommit.getLane();
        int iLaneC = laneC(lane);
        TColor tcolorLaneColor = abstractPlotRenderer3.laneColor(lane);
        PlotLane[] plotLaneArr = plotCommit.passingLanes;
        int length = plotLaneArr.length;
        int iMax = iLaneC;
        int i3 = 0;
        while (i3 < length) {
            TColor tcolor = tcolorLaneColor;
            int i4 = iLaneC;
            PlotLane plotLane = plotLaneArr[i3];
            int iLaneC2 = laneC(plotLane);
            abstractPlotRenderer3.drawLine(abstractPlotRenderer3.laneColor(plotLane), iLaneC2, 0, iLaneC2, i, 2);
            iMax = Math.max(iMax, iLaneC2);
            i3++;
            abstractPlotRenderer3 = this;
            tcolorLaneColor = tcolor;
            iLaneC = i4;
        }
        int i5 = (iLaneC - (iComputeDotSize / 2)) - 1;
        int i6 = (i - iComputeDotSize) / 2;
        if (plotCommit.getParentCount() > 0) {
            abstractPlotRenderer3.drawLine(tcolorLaneColor, iLaneC, i, iLaneC, (i + iComputeDotSize) / 2, 2);
            PlotLane[] plotLaneArr2 = plotCommit.mergingLanes;
            int length2 = plotLaneArr2.length;
            int i7 = 0;
            while (i7 < length2) {
                PlotLane plotLane2 = plotLaneArr2[i7];
                int i8 = length2;
                TColor tcolorLaneColor2 = abstractPlotRenderer3.laneColor(plotLane2);
                int iLaneC3 = laneC(plotLane2);
                if (Math.abs(iLaneC - iLaneC3) > 14) {
                    int i9 = i / 2;
                    int i10 = iLaneC < iLaneC3 ? iLaneC3 - 7 : iLaneC3 + 7;
                    abstractPlotRenderer3.drawLine(tcolorLaneColor2, iLaneC, i9, i10, i9, 2);
                    iLaneC3 = iLaneC3;
                    drawLine(tcolorLaneColor2, i10, i9, iLaneC3, i, 2);
                    iLaneC = iLaneC;
                } else {
                    drawLine(tcolorLaneColor2, iLaneC, i / 2, iLaneC3, i, 2);
                }
                iMax = Math.max(iMax, iLaneC3);
                i7++;
                abstractPlotRenderer3 = this;
                length2 = i8;
            }
        }
        if (plotCommit.getChildCount() > 0) {
            PlotLane[] plotLaneArr3 = plotCommit.forkingOffLanes;
            int length3 = plotLaneArr3.length;
            int i11 = 0;
            while (i11 < length3) {
                int i12 = iLaneC;
                TColor tcolor2 = tcolorLaneColor;
                PlotLane plotLane3 = plotLaneArr3[i11];
                int i13 = i11;
                TColor tcolorLaneColor3 = laneColor(plotLane3);
                int iLaneC4 = laneC(plotLane3);
                if (Math.abs(i12 - iLaneC4) > 14) {
                    int i14 = i12 < iLaneC4 ? iLaneC4 - 7 : iLaneC4 + 7;
                    int i15 = i / 2;
                    int i16 = i14;
                    drawLine(tcolorLaneColor3, i12, i15, i16, i15, 2);
                    iLaneC4 = iLaneC4;
                    drawLine(tcolorLaneColor3, i16, i15, iLaneC4, 0, 2);
                    i2 = i12;
                } else {
                    drawLine(tcolorLaneColor3, i12, i / 2, iLaneC4, 0, 2);
                    i2 = i12;
                }
                iMax = Math.max(iMax, iLaneC4);
                i11 = i13 + 1;
                tcolorLaneColor = tcolor2;
                length3 = length3;
                iLaneC = i2;
            }
            if (plotCommit.getChildCount() - plotCommit.forkingOffLanes.length > 0) {
                drawLine(tcolorLaneColor, iLaneC, 0, iLaneC, i6, 2);
                abstractPlotRenderer2 = this;
            } else {
                abstractPlotRenderer2 = this;
            }
            abstractPlotRenderer = abstractPlotRenderer2;
        } else {
            abstractPlotRenderer = this;
            i = i;
        }
        if (plotCommit.has(RevFlag.UNINTERESTING)) {
            abstractPlotRenderer.drawBoundaryDot(i5, i6, iComputeDotSize, iComputeDotSize);
        } else {
            abstractPlotRenderer.drawCommitDot(i5, i6, iComputeDotSize, iComputeDotSize);
        }
        int iMax2 = Math.max(iMax + 7, i5 + iComputeDotSize) + 8;
        int length4 = plotCommit.refs.length;
        for (int i17 = 0; i17 < length4; i17++) {
            iMax2 += abstractPlotRenderer.drawLabel(iMax2 + iComputeDotSize, i / 2, plotCommit.refs[i17]);
        }
        abstractPlotRenderer.drawText(plotCommit.getShortMessage(), iMax2 + iComputeDotSize, i);
    }

    private static int computeDotSize(int i) {
        int iMin = (int) (Math.min(i, 14) * 0.5f);
        return iMin + (iMin & 1);
    }

    private static int laneX(PlotLane plotLane) {
        return ((plotLane != null ? plotLane.getPosition() : 0) * 14) + 2;
    }

    private static int laneC(PlotLane plotLane) {
        return laneX(plotLane) + 7;
    }
}
