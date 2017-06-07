package com.example.user.pokemonapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.user.pokemonapp.API.Pokemon_API;
import com.example.user.pokemonapp.Model.Pokemon;
import com.example.user.pokemonapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Pokemon_timeActivity extends AppCompatActivity {

    private Spinner pok1;
    private Spinner pok2;
    private Spinner pok3;
    private Spinner pok4;
    private Spinner pok5;
    private Spinner pok6;
    private List<Pokemon> pokemonList = new ArrayList<>();
    private List<String> pokemonNameList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemon_time);

        final Pokemon_API pokemon_api = Pokemon_API.retrofit.create(Pokemon_API.class);
        Call<List<Pokemon>> call = pokemon_api.groupPokemon();

        call.enqueue(new Callback<List<Pokemon>>() {
            @Override
            public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {
                pokemonList = response.body();
            }

            @Override
            public void onFailure(Call<List<Pokemon>> call, Throwable t) {

            }
        });

        for(int i = 0; i < pokemonList.size(); i++){
            pokemonNameList.add(i, pokemonList.toString());
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, pokemonNameList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        pok1.setAdapter(dataAdapter);
        pok2.setAdapter(dataAdapter);
        pok3.setAdapter(dataAdapter);
        pok4.setAdapter(dataAdapter);
        pok5.setAdapter(dataAdapter);
        pok6.setAdapter(dataAdapter);
    }

    public void criarTime(View view){

        //WEB-SERVICE para criação de um time será implementado aqui!

        Intent listaTimes = new Intent(this,RegisterActivity.class);
        startActivity(listaTimes);
    }

    public void cancelarCriacao(View view){
        Intent listaTimes = new Intent(this,RegisterActivity.class);
        startActivity(listaTimes);
    }
}