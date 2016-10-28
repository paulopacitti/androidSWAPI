package com.paulopacitti.starwarswiki;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import rest.*;
import models.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchPeople extends AppCompatActivity
{
    EditText edSearch;
    TextView txtResult;
    Button btnSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

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

        Call<PeopleResults> call = APIClient.get().searchPeople(tagword);

        call.enqueue(new Callback<PeopleResults>()
        {
            @Override
            public void onFailure(Call<PeopleResults> call, Throwable t)
            {
                txtResult.setText("An error ocurred: " + t.toString());
                edSearch.setText("");
            }

            @Override
            public void onResponse(Call<PeopleResults> call, Response<PeopleResults> response)
            {


                Log.d("APIPlug", "Successfully response fetched" );
                edSearch.setText("");
                PeopleResults people = response.body();

                if(people.results.size() > 0)
                    txtResult.setText(people.results.get(0).toString());
                else
                    txtResult.setText("Your request was not found!");

            }
        });
    }
}
