package com.paulopacitti.starwarswiki;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import models.PlanetResults;
import models.SpecieResults;
import rest.APIClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchSpecies extends AppCompatActivity
{
    EditText edSearch;
    TextView txtResult;
    Button btnSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setTitle("Species");
        setContentView(R.layout.activity_species);

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

        Call<SpecieResults> call = APIClient.get().searchSpecies(tagword);

        call.enqueue(new Callback<SpecieResults>()
        {
            @Override
            public void onFailure(Call<SpecieResults> call, Throwable t)
            {
                txtResult.setText("An error ocurred: " + t.toString());
                edSearch.setText("");
            }

            @Override
            public void onResponse(Call<SpecieResults> call, Response<SpecieResults> response)
            {


                Log.d("APIPlug", "Successfully response fetched" );
                edSearch.setText("");
                SpecieResults species = response.body();

                if(species.results.size() > 0)
                    txtResult.setText(species.results.get(0).toString());
                else
                    txtResult.setText("Your request was not found!");

            }
        });
    }
}
