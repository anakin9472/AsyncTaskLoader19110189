package com.android.asynctaskloader19110189;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner spinner;
    private EditText urlInput;
    private TextView pageSource;
    private Button btnGet;
    String protocol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinnerItem);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.option, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        protocol = spinner.getSelectedItem().toString();
        urlInput = (EditText)findViewById(R.id.pageSourceInput);
        pageSource = (TextView)findViewById(R.id.textViewPageSource);
        btnGet = (Button) findViewById(R.id.buttonGetPageSource);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {
        protocol = adapterView.getItemAtPosition(i).toString();
//        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {

    }

    public void getPageSourceClick(View view)
    {
        // Get the search string from the input field.
        Toast.makeText(MainActivity.this,"Hãy chờ đợi trong giây lát",Toast.LENGTH_SHORT).show();
        String pageUrl;
        pageUrl = protocol + urlInput.getText().toString();
        getPageSourceData getPageSourceData = new getPageSourceData(pageSource);
        getPageSourceData.execute(pageUrl);
        Log.d("myurl", pageUrl);
    }
}