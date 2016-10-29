package com.paulopacitti.starwarswiki;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import models.StarshipResults;
import models.VehicleResults;
import rest.APIClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchVehicles extends AppCompatActivity
{
    EditText edSearch;
    TextView txtResult;
    Button btnSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicles);

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

        Call<VehicleResults> call = APIClient.get().searchVehicles(tagword);

        call.enqueue(new Callback<VehicleResults>()
        {
            @Override
            public void onFailure(Call<VehicleResults> call, Throwable t)
            {
                txtResult.setText("An error ocurred: " + t.toString());
                edSearch.setText("");
            }

            @Override
            public void onResponse(Call<VehicleResults> call, Response<VehicleResults> response)
            {


                Log.d("APIPlug", "Successfully response fetched" );
                edSearch.setText("");
                VehicleResults vehicles = response.body();

                if(vehicles.results.size() > 0)
                    txtResult.setText(vehicles.results.get(0).toString());
                else
                    txtResult.setText("Your request was not found!");

            }
        });
    }
}
