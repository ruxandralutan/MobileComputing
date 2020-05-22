package com.example.galleryapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.gridView);
        Button buttonSensorActivity = (Button) findViewById(R.id.buttonSensor);
        Button buttonViewStoragePhotos = (Button) findViewById(R.id.buttonViewStoragePhoto);
        Button buttonGoogleMaps = (Button) findViewById(R.id.buttonGoogleMaps);
        Button buttonNotification = (Button) findViewById(R.id.buttonNotification);

        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), FullScreenImageActivity.class);
                i.putExtra("id", position);
                startActivity(i);
            }
        });

        buttonSensorActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), TakePhotoActivity.class);

                startActivity(i);
            }
        });

        buttonViewStoragePhotos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ViewStoragePhotosActivity.class);

                startActivity(i);
            }
        });

        buttonGoogleMaps.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), GoogleMapsActivity.class);

                startActivity(i);
            }
        });

        buttonNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 1, i, PendingIntent.FLAG_UPDATE_CURRENT);

                String message = "This is a notification";
                // Set the information about the notification
                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        MainActivity.this

                )
                        .setSmallIcon(R.drawable.ic_message)
                        . setContentTitle("RL Gallery Notification")
                        .setContentText(message)
                        .setAutoCancel(true)
                        .setContentIntent(pendingIntent);

                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(MainActivity.this);
                //display the notification with id 0
                notificationManagerCompat.notify(0, builder.build());
            }
        });



    }
}
