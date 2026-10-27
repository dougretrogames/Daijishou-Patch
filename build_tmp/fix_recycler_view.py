import os

p = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView.java'
with open(p, 'r', encoding='utf-8') as f:
    c = f.read()

start_target = 'public ViewHolder(final Adapter adapter, final View itemView) {'
end_target = 'if (!this$1.getEnforceSelectionInSelectableMode() && this$1.getSelectableMode()) {'

idx1 = c.find(start_target)
idx2 = c.find(end_target)
assert idx1 != -1 and idx2 != -1, 'targets not found'

new_part = """public ViewHolder(final Adapter adapter, final View itemView) {
                super(itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.this$0 = adapter;
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public final void onClick(View view) {
                        _init_$lambda$0(adapter, itemView, view);
                    }
                });
                itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public final boolean onLongClick(View view) {
                        return _init_$lambda$1(adapter, itemView, view);
                    }
                });
                itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public final void onFocusChange(View view, boolean z) {
                        _init_$lambda$2(adapter, itemView, view, z);
                    }
                });
            }

            public final boolean getSelected() {
                return this.selected;
            }

            public final void setSelected(boolean z) {
                this.selected = z;
            }

            public final void _init_$lambda$0(Adapter this$0, View itemView, View view) {
                Function4 onItemClickListener;
                Function4 onItemClickListener2;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(itemView, "$itemView");
                if (this$0.getSelectableMode()) {
                    if (this$0.getKeepSelectedItemFocusedInSelectableMode()) {
                        itemView.setFocusableInTouchMode(true);
                    }
                    if (this.getAbsoluteAdapterPosition() != this$0._selectedPosition) {
                        this$0._selectedPosition = this.getAbsoluteAdapterPosition();
                        this$0.selectViewHolder(this);
                        itemView.requestFocus();
                    } else if (this.onClick() && (onItemClickListener2 = this$0.getOnItemClickListener()) != null) {
                        onItemClickListener2.invoke(itemView, Integer.valueOf(this.getAbsoluteAdapterPosition()), Long.valueOf(this.getItemId()), this$0.getItemList().get(this.getAbsoluteAdapterPosition()));
                    }
                    if (this$0.getKeepSelectedItemFocusedInSelectableMode()) {
                        itemView.requestFocus();
                        return;
                    }
                    return;
                }
                if (!this.onClick() || this.getAbsoluteAdapterPosition() < 0 || (onItemClickListener = this$0.getOnItemClickListener()) == null) {
                    return;
                }
                onItemClickListener.invoke(itemView, Integer.valueOf(this.getAbsoluteAdapterPosition()), Long.valueOf(this.getItemId()), this$0.getItemList().get(this.getAbsoluteAdapterPosition()));
            }

            public final boolean _init_$lambda$1(Adapter this$1, View itemView, View view) {
                Boolean bool;
                Intrinsics.checkNotNullParameter(this$1, "this$1");
                Intrinsics.checkNotNullParameter(itemView, "$itemView");
                if (!this.onLongClick()) {
                    return false;
                }
                if (this$1.getSelectableMode() && this.getAbsoluteAdapterPosition() != this$1._selectedPosition) {
                    if (this$1.getKeepSelectedItemFocusedInSelectableMode()) {
                        itemView.setFocusableInTouchMode(true);
                    }
                    this$1._selectedPosition = this.getAbsoluteAdapterPosition();
                    this$1.selectViewHolder(this);
                    itemView.requestFocus();
                }
                if (this.getAbsoluteAdapterPosition() >= 0) {
                    Function4 onItemLongClickListener = this$1.getOnItemLongClickListener();
                    bool = onItemLongClickListener != null ? (Boolean) onItemLongClickListener.invoke(itemView, Integer.valueOf(this.getAbsoluteAdapterPosition()), Long.valueOf(this.getItemId()), this$1.getItemList().get(this.getAbsoluteAdapterPosition())) : null;
                } else {
                    bool = true;
                }
                if (bool != null) {
                    return bool.booleanValue();
                }
                return true;
            }

            public final void _init_$lambda$2(Adapter this$1, View itemView, View view, boolean z) {
                Intrinsics.checkNotNullParameter(this$1, "this$1");
                Intrinsics.checkNotNullParameter(itemView, "$itemView");
                if (z) {
                    this.onFocus();
                    if (this$1.getSelectableMode() && this.getAbsoluteAdapterPosition() >= 0) {
                        this$1.selectViewHolder(this);
                        this$1._selectedPosition = this.getAbsoluteAdapterPosition();
                        return;
                    } else {
                        if (this.getAbsoluteAdapterPosition() >= 0) {
                            this$1._selectedPosition = this.getAbsoluteAdapterPosition();
                            return;
                        }
                        return;
                    }
                }
                if (itemView.isFocusableInTouchMode()) {
                    itemView.setFocusableInTouchMode(false);
                }
                this.onFocusClear(this.getAbsoluteAdapterPosition() >= 0);
                """

c = c[:idx1] + new_part + c[idx2:]
with open(p, 'w', encoding='utf-8') as f:
    f.write(c)
print('Fixed DaijishouRecyclerView.java successfully')
