package com.example.galleryapplication;


import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

class Send extends AsyncTask<String, Void,Long > {

    String Name;

    public Send(String _name) {
        Name = _name;
    }

    protected Long doInBackground(String... urls) {

        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("https://ruxandralutan.000webhostapp.com/phpcode.php");

        try {
            // Add your data
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("Name", Name));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

          // execute HTTP post request
            HttpResponse response = httpclient.execute(httppost);

        } catch (Exception e) {
            // TODO Auto-generated catch block
        }
        return null;

    }
    protected void onProgressUpdate(Integer... progress) {

    }

    protected void onPostExecute(Long result) {

    }
}
