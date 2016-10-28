package com.paulopacitti.starwarswiki;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import rest.*;
import models.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{
    EditText edSearch;
    TextView txtResult;
    Button btnSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edSearch = (EditText) findViewById(R.id.edSearch);
        txtResult = (TextView) findViewById(R.id.txtResult);
        btnSearch = (Button) findViewById(R.id.btnSearch);

    }

    public void btnSearch_onClick(View v)
    {
        searchPeople(edSearch.getText().toString());
    }

    private void searchPeople(String tagword)
    {

        Call<People> call = APIClient.get().getPeople(tagword);

        call.enqueue(new Callback<People>()
        {
            @Override
            public void onFailure(Call<People> call, Throwable t)
            {
                Log.d("APIPlug", "Error Occured: " + t.getMessage());
            }

            @Override
            public void onResponse(Call<People> call, Response<People> response)
            {


                Log.d("APIPlug", "Successfully response fetched" );

                People people = response.body();

                txtResult.setText(people.toString());

            }
        });
    }
}
