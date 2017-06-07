package com.example.user.pokemonapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.user.pokemonapp.API.Pokemon_API;
import com.example.user.pokemonapp.Model.Usuario;
import com.example.user.pokemonapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterActivity extends AppCompatActivity{

    EditText login;
    EditText senha;
    Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        login = (EditText) findViewById(R.id.User_Name);
        senha = (EditText) findViewById(R.id.Pass_User);
        final Pokemon_API pokemon_api = Pokemon_API.retrofit.create(Pokemon_API.class);
        Call<Usuario> call = pokemon_api.register(login.getText().toString(), senha.getText().toString());
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                usuario = response.body();
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {

            }
        });
    }

    public void RegisterConfirm(View view){
        Intent registerconfirm = new Intent(this,Lista_timeActivity.class);
        startActivity(registerconfirm);
    }

    public void BackToLogin(View view){
        Intent loginpage = new Intent(this,LoginActivity.class);
        startActivity(loginpage);
    }
}
