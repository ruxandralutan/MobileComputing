package com.example.galleryapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.GridView;
import android.widget.Toast;

import java.io.File;

public class ViewStoragePhotosActivity extends AppCompatActivity {

    AllImageAdapter myImageAdapter;
    GridView AllImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_storage_photos);

        GridView gridview = (GridView) findViewById(R.id.GV_Images);
        myImageAdapter = new AllImageAdapter(this);
        gridview.setAdapter(myImageAdapter);

        String ExternalStorageDirectoryPath = Environment
                .getExternalStorageDirectory()
                .getAbsolutePath();

        String targetPath = ExternalStorageDirectoryPath + "/Demo/";

        //Toast.makeText(getApplicationContext(), targetPath, Toast.LENGTH_LONG).show();
        File targetDirector = new File(targetPath);

        File[] files = targetDirector.listFiles();
        for (File file : files){
            myImageAdapter.add(file.getAbsolutePath());
        }

    }
}
