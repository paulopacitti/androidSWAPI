package com.paulopacitti.starwarswiki;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import models.SpecieResults;
import models.StarshipResults;
import rest.APIClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchStarships extends AppCompatActivity
{
    EditText edSearch;
    TextView txtResult;
    Button btnSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setTitle("Starships");
        setContentView(R.layout.activity_starships);

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

        Call<StarshipResults> call = APIClient.get().searchStarships(tagword);

        call.enqueue(new Callback<StarshipResults>()
        {
            @Override
            public void onFailure(Call<StarshipResults> call, Throwable t)
            {
                txtResult.setText("An error ocurred: " + t.toString());
                edSearch.setText("");
            }

            @Override
            public void onResponse(Call<StarshipResults> call, Response<StarshipResults> response)
            {


                Log.d("APIPlug", "Successfully response fetched" );
                edSearch.setText("");
                StarshipResults starships = response.body();

                if(starships.results.size() > 0)
                    txtResult.setText(starships.results.get(0).toString());
                else
                    txtResult.setText("Your request was not found!");

            }
        });
    }
}
