package com.webkype.happiroo.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.webkype.happiroo.R;
import com.webkype.happiroo.model.NotoficationModel;
import com.webkype.happiroo.view.adapter.NotificationAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NotificationsActivity extends AppCompatActivity {

    private Context context;
    private NotificationAdapter notificationAdapter;
    private List<NotoficationModel> mNotificationList= new ArrayList<>();

    @BindView(R.id.rv_notification)
    RecyclerView rv_notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        context = NotificationsActivity.this;
        ButterKnife.bind(this);
        mNotificationList.add(new NotoficationModel());
        mNotificationList.add(new NotoficationModel());
        mNotificationList.add(new NotoficationModel());
        notificationAdapter = new NotificationAdapter(this,mNotificationList);
        rv_notification.setLayoutManager(new LinearLayoutManager(this));
        rv_notification.setAdapter(notificationAdapter);
    }

    @OnClick({R.id.backNotification})
    void onClick(View view){
        switch (view.getId()){

            case R.id.backNotification:

                onBackPressed();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
