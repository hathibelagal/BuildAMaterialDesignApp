package com.github.hathibelagal.shoppinglist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Hathi on 13/3/16.
 */
public class InactiveItemViewHolder extends RecyclerView.ViewHolder {

    CheckBox itemStatus;
    TextView itemName;
    ImageView itemAction;

    public InactiveItemViewHolder(View itemView, CheckBox itemStatus, TextView itemName, ImageView itemAction) {
        super(itemView);
        this.itemStatus = itemStatus;
        this.itemName = itemName;
        this.itemAction = itemAction;
    }
}
