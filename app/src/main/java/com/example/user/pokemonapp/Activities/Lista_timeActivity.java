package com.example.user.pokemonapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.user.pokemonapp.Model.Time;
import com.example.user.pokemonapp.Model.Usuario;
import com.example.user.pokemonapp.R;
import com.example.user.pokemonapp.UserDAO.User_DAO;
import com.example.user.pokemonapp.Util.TimesAdapter;

import java.util.ArrayList;
import java.util.List;

public class Lista_timeActivity extends AppCompatActivity{

    private ListView times;
    private List<Time> lista_times = new ArrayList<Time>();
    private Usuario user = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_times);

        times = (ListView) findViewById(R.id.list_times);

        //WEB-SERVICE para pegar as informações dos time será implementado aqui!

        TimesAdapter timesAdapter = new TimesAdapter(lista_times, this);

        times.setAdapter(timesAdapter);

        times.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String codigo;
                codigo = String.valueOf(((Time) times.getItemAtPosition(position)).getTimeID());
                Intent intent = new Intent(Lista_timeActivity.this, Delete_timeActivity.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                finish();
            }
        });
    }

    public void criarEquipe(View view){
        Intent criarTime = new Intent(this,RegisterActivity.class);
        startActivity(criarTime);
    }

    public void logout(View view){
        User_DAO bd = new User_DAO(this);
        bd.DeleteUser(user);
        Intent logoff = new Intent(this,LoginActivity.class);
        startActivity(logoff);
    }
}
