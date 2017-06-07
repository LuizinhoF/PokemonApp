package com.example.user.pokemonapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Time {
    @SerializedName("timeID")
    private long timeID;
    @SerializedName("timeNome")
    private String timeNome;
    @SerializedName("usuario")
    private Usuario usuario;
    @SerializedName("pokemon")
    private List<Pokemon> pokemon = new ArrayList<Pokemon>();

    public Time() {
    }

    public Time(long timeID, String timeNome, Usuario usuario, List<Pokemon> pokemon1) {
        this.timeID = timeID;
        this.timeNome = timeNome;
        this.usuario = usuario;
        this.pokemon = pokemon1;
    }

    public long getTimeID() {
        return timeID;
    }

    public void setTimeID(long timeID) {
        this.timeID = timeID;
    }

    public String getTimeNome() {
        return timeNome;
    }

    public void setTimeNome(String timeNome) {
        this.timeNome = timeNome;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

}
