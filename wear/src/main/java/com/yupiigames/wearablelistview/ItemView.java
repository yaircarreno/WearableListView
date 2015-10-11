package com.yupiigames.wearablelistview;

import android.content.Context;
import android.support.wearable.view.CircledImageView;
import android.support.wearable.view.WearableListView;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by yair.carreno on 10/8/2015.
 */
public class ItemView extends LinearLayout implements WearableListView.OnScrollListener, WearableListView.OnCenterProximityListener  {

    private CircledImageView imgView;
    private TextView txtView;
    private final float mFadedTextAlpha;
    private final float mChosenAlpha;

    public ItemView(Context context) {
        this(context, null);
    }

    public ItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mFadedTextAlpha = 0.5f;
        mChosenAlpha = 1.0f;
    }

    // Get references to the icon and text in the item layout definition
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        // These are defined in the layout file for list items
        // (see next section)
        imgView = (CircledImageView) findViewById(R.id.image);
        txtView = (TextView) findViewById(R.id.text);
    }

    @Override // WearableListView.OnScrollListener
    public void onScroll(int i) {

    }

    @Override // WearableListView.OnScrollListener
    public void onAbsoluteScrollChange(int i) {

    }

    @Override // WearableListView.OnScrollListener
    public void onScrollStateChanged(int i) {

    }

    @Override // WearableListView.OnCenterProximityListener
    public void onCentralPositionChanged(int i) {

    }

    @Override // // WearableListView.OnCenterProximityListener
    public void onCenterPosition(boolean b) {
        txtView.setAlpha(mChosenAlpha);
        imgView.setAlpha(mChosenAlpha);
    }

    @Override // WearableListView.OnCenterProximityListener
    public void onNonCenterPosition(boolean b) {
        txtView.setAlpha(mFadedTextAlpha);
        imgView.setAlpha(mFadedTextAlpha);
    }
}