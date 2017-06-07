package com.example.user.pokemonapp.UserDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.user.pokemonapp.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class User_DAO extends SQLiteOpenHelper{

    private static final String NOME_BD = "Usuario";
    private static final int VERSAO = 1;


    public User_DAO(Context ctx){
        super(ctx, NOME_BD, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(id long primary key, tag text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table user;");
        onCreate(db);
    }

    public void addUser(Usuario user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", user.getUsuarioID());
        values.put("tag", user.getUsuarioTag());

        db.insert("user", null, values);
        db.close();
    }

    public void DeleteUser(Usuario user){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("user", "id= " +user.getUsuarioID(), null);
    }

    public List<Usuario> Busca(){
        List<Usuario> usuarios = new ArrayList<Usuario>();
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = new String[]{"id", "tag"};
        Cursor cursor = db.query("user",columns, null,null,null,null,null);
        if(cursor.getCount() > 0){
            Usuario u = new Usuario();
            u.setUsuarioID(cursor.getLong(0));
            u.setUsuarioTag(cursor.getString(1));
            usuarios.add(u);
        }
        return usuarios;
    }
}
