package com.paulopacitti.starwarswiki;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import models.FilmResults;
import models.PlanetResults;
import rest.APIClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchPlanets extends AppCompatActivity
{
    EditText edSearch;
    TextView txtResult;
    Button btnSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setTitle("Planets");
        setContentView(R.layout.activity_planets);

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

        Call<PlanetResults> call = APIClient.get().searchPlanets(tagword);

        call.enqueue(new Callback<PlanetResults>()
        {
            @Override
            public void onFailure(Call<PlanetResults> call, Throwable t)
            {
                txtResult.setText("An error ocurred: " + t.toString());
                edSearch.setText("");
            }

            @Override
            public void onResponse(Call<PlanetResults> call, Response<PlanetResults> response)
            {


                Log.d("APIPlug", "Successfully response fetched" );
                edSearch.setText("");
                PlanetResults planets = response.body();

                if(planets.results.size() > 0)
                    txtResult.setText(planets.results.get(0).toString());
                else
                    txtResult.setText("Your request was not found!");

            }
        });
    }
}
