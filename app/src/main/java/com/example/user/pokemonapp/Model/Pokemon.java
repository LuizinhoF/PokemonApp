package com.example.user.pokemonapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pokemon {

    @SerializedName("pokemonNome")
    @Expose
    private String pokemonNome;
    @SerializedName("elementoPrimario")
    @Expose
    private String elementoPrimario;
    @SerializedName("elementoSecundario")
    @Expose
    private String elementoSecundario;

    public Pokemon (){}

    public Pokemon (String pPokemonName, String pElementoPrimeiro, String pElementoSecundario)
    {
        this.pokemonNome = pPokemonName;
        this.elementoPrimario = pElementoPrimeiro;
        this.elementoSecundario = pElementoSecundario;
    }

    public String getPokemonNome() {
        return pokemonNome;
    }

    public void setPokemonNome(String pokemonNome) {
        this.pokemonNome = pokemonNome;
    }

    public String getElementoPrimario() {
        return elementoPrimario;
    }

    public void setElementoPrimario(String elementoPrimario) {
        this.elementoPrimario = elementoPrimario;
    }

    public String getElementoSecundario() {
        return elementoSecundario;
    }

    public void setElementoSecundario(String elementoSecundario) {
        this.elementoSecundario = elementoSecundario;
    }
}
