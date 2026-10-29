package com.magneticchen.daijishou.arcade;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ArcadeAppAdapter extends RecyclerView.Adapter<ArcadeAppAdapter.ViewHolder> {

    public interface OnAppActionListener {
        void onAppClick(ArcadeAppItem item, int position);
        void onAppFocused(ArcadeAppItem item, int position);
    }

    private final Context context;
    private final List<ArcadeAppItem> items = new ArrayList<>();
    private final OnAppActionListener listener;

    public ArcadeAppAdapter(Context context, OnAppActionListener listener) {
        this.context = context;
        this.listener = listener;
    }

    public void setItems(List<ArcadeAppItem> newItems) {
        items.clear();
        if (newItems != null) {
            items.addAll(newItems);
        }
        notifyDataSetChanged();
    }

    public ArcadeAppItem getItem(int position) {
        if (position >= 0 && position < items.size()) {
            return items.get(position);
        }
        return null;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layoutId = ArcadeRes.getLayout(context, "item_arcade_app_card");
        View v = LayoutInflater.from(context).inflate(layoutId, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final ArcadeAppItem item = items.get(position);
        holder.bind(item);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.getBindingAdapterPosition();
                if (pos == RecyclerView.NO_POSITION) {
                    pos = holder.getAdapterPosition();
                }
                if (pos != RecyclerView.NO_POSITION && listener != null) {
                    listener.onAppClick(items.get(pos), pos);
                }
            }
        });

        holder.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    v.animate().scaleX(1.10f).scaleY(1.10f).translationZ(8f).setDuration(150).start();
                    int pos = holder.getBindingAdapterPosition();
                    if (pos == RecyclerView.NO_POSITION) {
                        pos = holder.getAdapterPosition();
                    }
                    if (pos != RecyclerView.NO_POSITION && listener != null) {
                        listener.onAppFocused(items.get(pos), pos);
                    }
                } else {
                    v.animate().scaleX(1.0f).scaleY(1.0f).translationZ(0f).setDuration(150).start();
                }
            }
        });

        holder.itemView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BUTTON_A || keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER) {
                        int pos = holder.getBindingAdapterPosition();
                        if (pos == RecyclerView.NO_POSITION) {
                            pos = holder.getAdapterPosition();
                        }
                        if (pos != RecyclerView.NO_POSITION && listener != null) {
                            listener.onAppClick(items.get(pos), pos);
                            return true;
                        }
                    }
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView iconView;
        private final TextView labelView;

        public ViewHolder(View itemView) {
            super(itemView);
            iconView = itemView.findViewById(ArcadeRes.getId(itemView.getContext(), "arcade_app_icon"));
            labelView = itemView.findViewById(ArcadeRes.getId(itemView.getContext(), "arcade_app_label"));
        }

        public void bind(ArcadeAppItem item) {
            if (labelView != null) {
                labelView.setText(item.getLabel());
            }
            if (iconView != null) {
                iconView.setImageDrawable(item.getIcon());
            }
        }
    }
}
