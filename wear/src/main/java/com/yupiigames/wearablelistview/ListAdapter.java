package com.yupiigames.wearablelistview;

import android.support.wearable.view.CircledImageView;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by yair.carreno on 10/8/2015.
 */
public class ListAdapter extends WearableListView.Adapter {

    private String[] mDataSet;
    private ArrayList<Integer> mListItems;

    // Provide a suitable constructor (depends on the kind of dataSet)
    public ListAdapter(String[] dataSet, ArrayList<Integer> listItems) {
        mDataSet = dataSet;
        mListItems = listItems;
    }

    // Provide a reference to the type of views you're using
    public static class ItemViewHolder extends WearableListView.ViewHolder {
        private TextView textView;
        private CircledImageView imgView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            // find the text view within the custom item's layout
            imgView = (CircledImageView) itemView.findViewById(R.id.image);
            textView = (TextView) itemView.findViewById(R.id.text);
        }
    }

    @Override
    public WearableListView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, null));
    }

    @Override
    public void onBindViewHolder(WearableListView.ViewHolder holder, int position) {
        // retrieve the text view
        ItemViewHolder itemHolder = (ItemViewHolder) holder;
        TextView textView = itemHolder.textView;
        CircledImageView imgView = itemHolder.imgView;
        // replace text contents
        textView.setText(mDataSet[position]);
        Integer resourceId = mListItems.get(position);
        imgView.setImageResource(resourceId);
        // replace list item's metadata
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}
