package com.example.user.pokemonapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.user.pokemonapp.API.Pokemon_API;
import com.example.user.pokemonapp.Model.Usuario;
import com.example.user.pokemonapp.R;
import com.example.user.pokemonapp.UserDAO.User_DAO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText login;
    EditText senha;
    Usuario usuario = new Usuario();
    private boolean remember;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (EditText) findViewById(R.id.User_Name);
        senha = (EditText) findViewById(R.id.Pass_User);

        User_DAO bd = new User_DAO(this);
        List<Usuario> user = bd.Busca();

        if(user.size() > 0){
            Intent intent = new Intent(LoginActivity.this, Lista_timeActivity.class);
            startActivity(intent);
        }
    }

    public void RegisterLay(View view){
        Intent registerpage = new Intent(this,RegisterActivity.class);
        startActivity(registerpage);
    }

    public void Login(View view){
        usuario.setUsuarioTag(login.getText().toString());
        usuario.setUsuarioSenha(senha.getText().toString());
        final Pokemon_API pokemon_api = Pokemon_API.retrofit.create(Pokemon_API.class);
        Call<Usuario> call = pokemon_api.login(usuario);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                usuario = response.body();
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {

            }
        });
        if(remember = true){
            User_DAO bd = new User_DAO(this);
            bd.addUser(usuario);
        }
        Intent pokepage = new Intent(this,Lista_timeActivity.class);
        startActivity(pokepage);
    }
}
