package com.example.user.pokemonapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.user.pokemonapp.API.Pokemon_API;
import com.example.user.pokemonapp.Model.Time;
import com.example.user.pokemonapp.Model.Usuario;
import com.example.user.pokemonapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Delete_timeActivity extends AppCompatActivity{

    String codigo;
    Time time = new Time();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_time);

        codigo = this.getIntent().getStringExtra("codigo");

        //WEB-SERVICE para pegar as informações de um time será implementado aqui!

        TextView time_nome = (TextView) findViewById(R.id.Time_nome);
        TextView time_id = (TextView) findViewById(R.id.Time_ID);
        TextView pok1 = (TextView) findViewById(R.id.Pok1);
        TextView pok2 = (TextView) findViewById(R.id.Pok2);
        TextView pok3 = (TextView) findViewById(R.id.Pok3);
        TextView pok4 = (TextView) findViewById(R.id.Pok4);
        TextView pok5 = (TextView) findViewById(R.id.Pok5);
        TextView pok6 = (TextView) findViewById(R.id.Pok6);

        time_nome.setText(time.getTimeNome());
        String id = String.valueOf(time.getTimeID());
        time_id.setText(id);
        pok1.setText(time.getPokemon().get(0).getPokemonNome());
        pok2.setText(time.getPokemon().get(1).getPokemonNome());
        pok3.setText(time.getPokemon().get(2).getPokemonNome());
        pok4.setText(time.getPokemon().get(3).getPokemonNome());
        pok5.setText(time.getPokemon().get(4).getPokemonNome());
        pok6.setText(time.getPokemon().get(5).getPokemonNome());
    }

    public void DeleteTime(View view){
        final Pokemon_API pokemon_api = Pokemon_API.retrofit.create(Pokemon_API.class);
        Call<Long> call = pokemon_api.deleteTime(((int) time.getTimeID()));
        call.enqueue(new Callback<Long>() {
            @Override
            public void onResponse(Call<Long> call, Response<Long> response) {

            }

            @Override
            public void onFailure(Call<Long> call, Throwable t) {

            }
        });
        Intent listaTimes = new Intent(this,Pokemon_timeActivity.class);
        startActivity(listaTimes);
    }
}
