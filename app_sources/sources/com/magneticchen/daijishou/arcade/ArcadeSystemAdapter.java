package com.magneticchen.daijishou.arcade;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

    public ArcadeSystemAdapter(Context context, boolean isVertical, OnSystemActionListener listener) {
        this.context = context;
        this.isVertical = isVertical;
        this.listener = listener;
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

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId = ArcadeRes.getLayout(context, "item_arcade_system_card");
        View v = LayoutInflater.from(context).inflate(layoutId, parent, false);

        if (isVertical) {
            ViewGroup.LayoutParams lp = v.getLayoutParams();
            if (lp != null) {
                lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
                lp.height = (int) (120 * context.getResources().getDisplayMetrics().density);
                v.setLayoutParams(lp);
            }
        }

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final ArcadeItem item = items.get(position);
        holder.bind(item);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.getBindingAdapterPosition();
                if (pos == RecyclerView.NO_POSITION) {
                    pos = holder.getAdapterPosition();
                }
                if (pos != RecyclerView.NO_POSITION && listener != null) {
                    listener.onSystemSelected(items.get(pos), pos);
                }
            }
        });

        holder.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    v.animate().scaleX(1.15f).scaleY(1.15f).alpha(1.0f).setDuration(200).start();
                    int pos = holder.getBindingAdapterPosition();
                    if (pos == RecyclerView.NO_POSITION) {
                        pos = holder.getAdapterPosition();
                    }
                    if (pos != RecyclerView.NO_POSITION && listener != null) {
                        selectedPosition = pos;
                        listener.onSystemFocused(items.get(pos), pos);
                    }
                } else {
                    v.animate().scaleX(0.88f).scaleY(0.88f).alpha(0.65f).setDuration(200).start();
                }
            }
        });

        // Initial scale state
        if (position == selectedPosition) {
            holder.itemView.setScaleX(1.15f);
            holder.itemView.setScaleY(1.15f);
            holder.itemView.setAlpha(1.0f);
        } else {
            holder.itemView.setScaleX(0.88f);
            holder.itemView.setScaleY(0.88f);
            holder.itemView.setAlpha(0.65f);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView logoView;
        private final TextView fallbackTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            int logoId = ArcadeRes.getId(itemView.getContext(), "arcade_system_logo");
            int titleId = ArcadeRes.getId(itemView.getContext(), "arcade_system_title_fallback");
            this.logoView = itemView.findViewById(logoId);
            this.fallbackTitle = itemView.findViewById(titleId);
        }

        public void bind(ArcadeItem item) {
            ArcadeLogoResolver.resolveAndLoadLogo(itemView.getContext(), item, logoView, fallbackTitle);
        }
    }
}
