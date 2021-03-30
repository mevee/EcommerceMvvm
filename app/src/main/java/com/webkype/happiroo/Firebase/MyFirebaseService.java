package com.webkype.happiroo.Firebase;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.pref.Preference;
import com.webkype.happiroo.view.activity.DashboardActivity;
import com.webkype.happiroo.view.activity.auth.AuthenticateActivity;
import com.webkype.happiroo.view.activity.bookings.BookingDetailActivity;

import java.util.Map;
import java.util.Random;

public class MyFirebaseService extends FirebaseMessagingService {
    private static final String TYPE_NEW_BKNG = "booking";
    private static final String TYPE_REMINDER = "reminder";
    private static final String TYPE_PROMO = "promotions";
    private static final String TYPE = "notification_type";
    private static final String VIBRATE = "vibrate";
    private static final String TAG = "fcm_service";

    public MyFirebaseService() {
    }

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
    }


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        String title = null;
        String body = null;
        String bookingId = null;
        String bookingType = null;
        String notif_Type = null;

        Log.d(TAG, "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
            try {

                title = remoteMessage.getData().get("title");
                body = remoteMessage.getData().get("text");
                bookingId = remoteMessage.getData().get("bookingId");
                bookingType = remoteMessage.getData().get("bookingType");
                notif_Type = remoteMessage.getData().get(TYPE);

                Log.d(TAG, " body: " + body);
                Log.d(TAG, " titile: " + title);
                Log.d(TAG, " id: " + bookingId);
                Log.d(TAG, " bkn_type: " + bookingType);
                Log.d(TAG, "notif_type:" + notif_Type);
                Log.e(TAG, "FireBase: " + body + "" + title + "" + bookingId + "" + notif_Type);
            } catch (Exception e) {
                Log.e(TAG, "Exception: " + e.getMessage());
            }

            handleDataMessage(title, body, notif_Type, bookingId, bookingType);

        }
    }
        private void handleDataMessage(String title, String body, String notfType, String bookingId, String bookingType){
            Log.e(TAG, "FireBase Notification: " + title + "" + body + "" + bookingId + "" + bookingType);
            final int icon = R.drawable.logo;

            String channelId = getString(R.string.channel_id);
            Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Intent notifyIntent = null;

            switch (notfType) {
                case TYPE_NEW_BKNG:
                    if (Preference.getUser(getBaseContext())!=null){
                        if (!TextUtils.isEmpty(bookingId)) {
                            notifyIntent = new Intent(getBaseContext(), BookingDetailActivity.class);
                            notifyIntent.putExtra("from", "notificaton");
                            notifyIntent.putExtra("type", "" + bookingType);
                            notifyIntent.putExtra("bookingId", "" + bookingId);
                        }else {
                            notifyIntent = new Intent(getBaseContext(), DashboardActivity.class);
                        }
                    }else {
                        notifyIntent = new Intent(getBaseContext(), DashboardActivity.class);
                    }
            }
//
            if (notifyIntent != null) {
                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, notifyIntent,
                        PendingIntent.FLAG_ONE_SHOT | PendingIntent.FLAG_UPDATE_CURRENT);

                NotificationCompat.BigTextStyle messageBody = new NotificationCompat.BigTextStyle().bigText(body);

                NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(R.drawable.logo)
                        .setContentTitle(title)
                         .setAutoCancel(true)
                        .setLargeIcon((BitmapFactory.decodeResource(this.getResources(), icon)))
                        .setSound(defaultSoundUri)
                        .setStyle(messageBody)
                        .setSmallIcon(icon)

                        .setContentIntent(pendingIntent);

                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                assert notificationManager != null;

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new NotificationChannel(channelId,
                            "Welcome to Happiroo",
                            NotificationManager.IMPORTANCE_DEFAULT);
                    notificationManager.createNotificationChannel(channel);
                }
                int idChannel = new Random().nextInt();

                notificationManager.notify(idChannel++, notificationBuilder.build());
            }
        }

    }