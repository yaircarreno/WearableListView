package com.yupiigames.wearablelistview;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.support.wearable.view.WearableListView;
import java.util.ArrayList;

public class MainActivity extends Activity implements WearableListView.ClickListener {

    private WearableListView mListView;
    private static ArrayList<Integer> listItems;
    String[] elements = {"Account", "Alarm", "Language", "Settings", "Shopping" };

    static {
        listItems = new ArrayList<>();
        listItems.add(R.drawable.ic_account_circle_black_24dp);
        listItems.add(R.drawable.ic_alarm_black_24dp);
        listItems.add(R.drawable.ic_language_black_24dp);
        listItems.add(R.drawable.ic_settings_black_24dp);
        listItems.add(R.drawable.ic_shopping_cart_black_24dp);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                // Get the list component from the layout of the activity
                mListView = (WearableListView) stub.findViewById(R.id.wearable_list);
                // Assign an adapter to the list
                mListView.setAdapter(new ListAdapter(elements, listItems));
                // Set a click listener
                mListView.setClickListener(MainActivity.this);
            }
        });
    }

    @Override
    public void onClick(WearableListView.ViewHolder viewHolder) {
        Integer tag = (Integer) viewHolder.itemView.getTag();
        buildWearableOnlyNotification(elements[tag], getResources().getString(R.string.content_notification) + " "
                + tag);
        finish();
    }

    @Override
    public void onTopEmptyRegionClick() {
    }

    /**
     * Builds a simple notification on the wearable.
     */
    private void buildWearableOnlyNotification(String title, String content) {
        Notification.Builder builder = new Notification.Builder(this).setSmallIcon(R.drawable.ic_title)
                .setContentTitle(title).setContentText(content);

        ((NotificationManager) getSystemService(NOTIFICATION_SERVICE)).notify(1, builder.build());
    }
}
