package com.example.user.pokemonapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 04/06/2017.
 */

public class Usuario {
    @SerializedName("usuarioID")
    @Expose
    private static long usuarioID;
    @SerializedName("usuarioTag")
    @Expose
    private static String usuarioTag;
    @SerializedName("usuarioSenha")
    @Expose
    private static String usuarioSenha;

    public Usuario(){}

    public Usuario(long pUsuarioID, String pUsuarioNome, String pUsuarioTag, String pUsuarioSenha)
    {
        this.usuarioID = pUsuarioID;
        this.usuarioTag = pUsuarioTag;
        this.usuarioSenha = pUsuarioSenha;
    }

    public long getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(long usuarioID) {
        this.usuarioID = usuarioID;
    }

    public String getUsuarioTag() {
        return usuarioTag;
    }

    public void setUsuarioTag(String usuarioTag) {
        this.usuarioTag = usuarioTag;
    }

    public String getUsuarioSenha() {
        return usuarioSenha;
    }

    public void setUsuarioSenha(String usuarioSenha) {
        this.usuarioSenha = usuarioSenha;
    }
}
