package com.android.asynctaskloader19110189;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class getPageSourceData extends AsyncTask<String, Void, String>
{
    String pageUrl;
    private WeakReference<TextView> pageSource;
    public getPageSourceData(TextView textView)
    {
        pageSource = new WeakReference<TextView>(textView);
    }

    @Override
    protected String doInBackground(String... strings)
    {
        StringBuilder stringBuilder = new StringBuilder();
        try
        {
            URL url = new URL(strings[0]);
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public getPageSourceData()
    {
        super();
    }

    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        pageSource.get().setText(s);
    }


    @Override
    protected void onCancelled(String s) {
        super.onCancelled(s);
    }

}
