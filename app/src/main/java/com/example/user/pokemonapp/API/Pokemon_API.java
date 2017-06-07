package com.example.user.pokemonapp.API;

import com.example.user.pokemonapp.Model.Pokemon;
import com.example.user.pokemonapp.Model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Pokemon_API {
    @GET("Pokemon/Pesquisar")
    Call<List<Pokemon>> groupPokemon();

    @GET("/Pokemon/PokemonNome/{Nome}")
    Call<Pokemon> pokemonByName(@Path("Nome") String nome);

    @DELETE("/Times/RemoverTimes/{timeid}")
    Call<Long> deleteTime(@Path("timeid") int id);

    @POST("/User/Login")
    Call<Usuario> login(@Body Usuario user);

    @POST("/User/Cadastrar/{Tag}/{Password}")
    Call<Usuario> register(@Path("Tag") String tag, @Path("Password") String pass);

    public static final Retrofit retrofit = new Retrofit.Builder().baseUrl("").addConverterFactory(GsonConverterFactory.create()).build();
}
