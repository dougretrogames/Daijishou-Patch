package com.magneticchen.daijishou.arcade;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ArcadeSystemAdapter extends RecyclerView.Adapter<ArcadeSystemAdapter.ViewHolder> {

    public interface OnSystemActionListener {
        void onSystemSelected(ArcadeItem item, int position);
        void onSystemFocused(ArcadeItem item, int position);
    }

    private final Context context;
    private final List<ArcadeItem> items = new ArrayList<>();
    private final OnSystemActionListener listener;
    private final boolean isVertical;
    private int selectedPosition = 0;
    private final Drawable focusedBadgeDrawable;

    public ArcadeSystemAdapter(Context context, boolean isVertical, OnSystemActionListener listener) {
        this.context = context;
        this.isVertical = isVertical;
        this.listener = listener;

        int badgeRes = ArcadeRes.getDrawable(context, "arcade_card_focused_badge");
        if (badgeRes != 0) {
            this.focusedBadgeDrawable = ContextCompat.getDrawable(context, badgeRes);
        } else {
            this.focusedBadgeDrawable = null;
        }
    }

    public void setItems(List<ArcadeItem> newItems) {
        items.clear();
        if (newItems != null) {
            items.addAll(newItems);
        }
        notifyDataSetChanged();
    }

    public ArcadeItem getItem(int position) {
        if (position >= 0 && position < items.size()) {
            return items.get(position);
        }
        return null;
    }

    public int getPositionOfPlatform(long platformId) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == platformId) {
                return i;
            }
        }
        return -1;
    }

    public void setSelectedPosition(int position) {
        int oldPos = selectedPosition;
        selectedPosition = position;
        notifyItemChanged(oldPos);
        notifyItemChanged(selectedPosition);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layoutId = ArcadeRes.getLayout(context, "item_arcade_system_card");
        View v = LayoutInflater.from(context).inflate(layoutId, parent, false);

        if (isVertical) {
            ViewGroup.LayoutParams lp = v.getLayoutParams();
            if (lp != null) {
                lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
                lp.height = (int) (110 * context.getResources().getDisplayMetrics().density);
                v.setLayoutParams(lp);
            }
        }

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final ArcadeItem item = items.get(position);
        holder.bind(item);

        boolean isSelected = (position == selectedPosition);
        applyItemVisuals(holder, isSelected, false);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.getBindingAdapterPosition();
                if (pos == RecyclerView.NO_POSITION) {
                    pos = holder.getAdapterPosition();
                }
                if (pos != RecyclerView.NO_POSITION && listener != null) {
                    setSelectedPosition(pos);
                    listener.onSystemSelected(items.get(pos), pos);
                }
            }
        });

        holder.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                int pos = holder.getBindingAdapterPosition();
                if (pos == RecyclerView.NO_POSITION) {
                    pos = holder.getAdapterPosition();
                }
                if (hasFocus) {
                    applyItemVisuals(holder, true, true);
                    if (pos != RecyclerView.NO_POSITION && listener != null) {
                        selectedPosition = pos;
                        listener.onSystemFocused(items.get(pos), pos);
                    }
                } else {
                    applyItemVisuals(holder, false, true);
                }
            }
        });
    }

    private void applyItemVisuals(ViewHolder holder, boolean isFocused, boolean animate) {
        float targetScale = isFocused ? 1.12f : 0.85f;
        float targetAlpha = isFocused ? 1.0f : 0.45f;

        if (isFocused) {
            if (focusedBadgeDrawable != null) {
                holder.cardRoot.setBackground(focusedBadgeDrawable.getConstantState().newDrawable().mutate());
            }
        } else {
            holder.cardRoot.setBackground(null);
        }

        if (animate) {
            holder.itemView.animate()
                .scaleX(targetScale)
                .scaleY(targetScale)
                .alpha(targetAlpha)
                .setDuration(180)
                .start();
        } else {
            holder.itemView.setScaleX(targetScale);
            holder.itemView.setScaleY(targetScale);
            holder.itemView.setAlpha(targetAlpha);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final FrameLayout cardRoot;
        public final ImageView logoView;
        public final TextView fallbackTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            int rootId = ArcadeRes.getId(itemView.getContext(), "arcade_card_root");
            int logoId = ArcadeRes.getId(itemView.getContext(), "arcade_system_logo");
            int titleId = ArcadeRes.getId(itemView.getContext(), "arcade_system_title_fallback");
            this.cardRoot = (FrameLayout) itemView.findViewById(rootId);
            this.logoView = itemView.findViewById(logoId);
            this.fallbackTitle = itemView.findViewById(titleId);
        }

        public void bind(ArcadeItem item) {
            ArcadeLogoResolver.resolveAndLoadLogo(itemView.getContext(), item, logoView, fallbackTitle);
        }
    }
}
