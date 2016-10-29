package com.paulopacitti.starwarswiki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    Button btnFilm;
    Button btnPeople;
    Button btnPlanet;
    Button btnSpecie;
    Button btnStarship;
    Button btnVehicle;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFilm = (Button) findViewById(R.id.btnFilm);
        btnPeople = (Button) findViewById(R.id.btnPeople);
        btnPlanet = (Button) findViewById(R.id.btnSpecie);
        btnSpecie = (Button) findViewById(R.id.btnStarship);
        btnStarship = (Button) findViewById(R.id.btnStarship);
        btnVehicle = (Button) findViewById(R.id.btnVehicle);
    }

    public void btnPeople_onClick(View v)
    {
        Intent i = new Intent(MainActivity.this, SearchPeople.class);
        startActivity(i);
    }

    public void btnPlanet_onClick(View v)
    {
        Intent i = new Intent(MainActivity.this, SearchPlanets.class);
        startActivity(i);
    }

    public void btnStarship_onClick(View v)
    {
        Intent i = new Intent(MainActivity.this, SearchStarships.class);
        startActivity(i);
    }

    public void btnVehicle_onClick(View v)
    {
        Intent i = new Intent(MainActivity.this, SearchVehicles.class);
        startActivity(i);
    }

    public void btnSpecie_onClick(View v)
    {
        Intent i = new Intent(MainActivity.this, SearchSpecies.class);
        startActivity(i);
    }

    public void btnFilm_onClick(View v)
    {
        Intent i = new Intent(MainActivity.this, SearchFilms.class);
        startActivity(i);
    }
}
