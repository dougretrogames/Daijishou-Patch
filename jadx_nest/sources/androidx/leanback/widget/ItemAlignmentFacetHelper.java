package androidx.leanback.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* INFO: loaded from: classes.dex */
class ItemAlignmentFacetHelper {
    private static final Rect sRect = new Rect();

    static int getAlignmentPosition(View view, ItemAlignmentFacet.ItemAlignmentDef itemAlignmentDef, int i) {
        View viewFindViewById;
        int width;
        int width2;
        int width3;
        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
        if (itemAlignmentDef.mViewId == 0 || (viewFindViewById = view.findViewById(itemAlignmentDef.mViewId)) == null) {
            viewFindViewById = view;
        }
        int opticalTopInset = itemAlignmentDef.mOffset;
        if (i == 0) {
            if (view.getLayoutDirection() == 1) {
                if (viewFindViewById == view) {
                    width2 = layoutParams.getOpticalWidth(viewFindViewById);
                } else {
                    width2 = viewFindViewById.getWidth();
                }
                int paddingLeft = width2 - opticalTopInset;
                if (itemAlignmentDef.mOffsetWithPadding) {
                    if (itemAlignmentDef.mOffsetPercent == 0.0f) {
                        paddingLeft -= viewFindViewById.getPaddingRight();
                    } else if (itemAlignmentDef.mOffsetPercent == 100.0f) {
                        paddingLeft += viewFindViewById.getPaddingLeft();
                    }
                }
                if (itemAlignmentDef.mOffsetPercent != -1.0f) {
                    if (viewFindViewById == view) {
                        width3 = layoutParams.getOpticalWidth(viewFindViewById);
                    } else {
                        width3 = viewFindViewById.getWidth();
                    }
                    paddingLeft -= (int) ((width3 * itemAlignmentDef.mOffsetPercent) / 100.0f);
                }
                if (view == viewFindViewById) {
                    return paddingLeft;
                }
                Rect rect = sRect;
                rect.right = paddingLeft;
                ((ViewGroup) view).offsetDescendantRectToMyCoords(viewFindViewById, rect);
                return rect.right + layoutParams.getOpticalRightInset();
            }
            if (itemAlignmentDef.mOffsetWithPadding) {
                if (itemAlignmentDef.mOffsetPercent == 0.0f) {
                    opticalTopInset += viewFindViewById.getPaddingLeft();
                } else if (itemAlignmentDef.mOffsetPercent == 100.0f) {
                    opticalTopInset -= viewFindViewById.getPaddingRight();
                }
            }
            if (itemAlignmentDef.mOffsetPercent != -1.0f) {
                if (viewFindViewById == view) {
                    width = layoutParams.getOpticalWidth(viewFindViewById);
                } else {
                    width = viewFindViewById.getWidth();
                }
                opticalTopInset += (int) ((width * itemAlignmentDef.mOffsetPercent) / 100.0f);
            }
            if (view == viewFindViewById) {
                return opticalTopInset;
            }
            Rect rect2 = sRect;
            rect2.left = opticalTopInset;
            ((ViewGroup) view).offsetDescendantRectToMyCoords(viewFindViewById, rect2);
            return rect2.left - layoutParams.getOpticalLeftInset();
        }
        if (itemAlignmentDef.mOffsetWithPadding) {
            if (itemAlignmentDef.mOffsetPercent == 0.0f) {
                opticalTopInset += viewFindViewById.getPaddingTop();
            } else if (itemAlignmentDef.mOffsetPercent == 100.0f) {
                opticalTopInset -= viewFindViewById.getPaddingBottom();
            }
        }
        if (itemAlignmentDef.mOffsetPercent != -1.0f) {
            opticalTopInset += (int) (((viewFindViewById == view ? layoutParams.getOpticalHeight(viewFindViewById) : viewFindViewById.getHeight()) * itemAlignmentDef.mOffsetPercent) / 100.0f);
        }
        if (view != viewFindViewById) {
            Rect rect3 = sRect;
            rect3.top = opticalTopInset;
            ((ViewGroup) view).offsetDescendantRectToMyCoords(viewFindViewById, rect3);
            opticalTopInset = rect3.top - layoutParams.getOpticalTopInset();
        }
        return itemAlignmentDef.isAlignedToTextViewBaseLine() ? opticalTopInset + viewFindViewById.getBaseline() : opticalTopInset;
    }

    private ItemAlignmentFacetHelper() {
    }
}
