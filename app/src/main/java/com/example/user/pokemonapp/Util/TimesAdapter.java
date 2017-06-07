package com.example.user.pokemonapp.Util;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.user.pokemonapp.Model.Time;
import com.example.user.pokemonapp.R;

import java.util.List;

public class TimesAdapter extends BaseAdapter{

    private List<Time> times;
    private final Activity act;

    public TimesAdapter(List<Time>pTime, Activity pAct)
    {
        this.times = pTime;
        this.act = pAct;
    }

    @Override
    public int getCount() {
        return times.size();
    }

    @Override
    public Object getItem(int position) {
        return times.get(position);
    }

    @Override
    public long getItemId(int position) {
        return times.get(position).getTimeID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = act.getLayoutInflater()
                .inflate(R.layout.lista_times_layout, parent, false);
        Time time = times.get(position);

        TextView time_nome = (TextView) view.findViewById(R.id.Time_nome);
        TextView time_id = (TextView) view.findViewById(R.id.Time_ID);
        TextView pok1 = (TextView) view.findViewById(R.id.Pok1);
        TextView pok2 = (TextView) view.findViewById(R.id.Pok2);
        TextView pok3 = (TextView) view.findViewById(R.id.Pok3);
        TextView pok4 = (TextView) view.findViewById(R.id.Pok4);
        TextView pok5 = (TextView) view.findViewById(R.id.Pok5);
        TextView pok6 = (TextView) view.findViewById(R.id.Pok6);

        time_nome.setText(time.getTimeNome());
        String id = String.valueOf(time.getTimeID());
        time_id.setText(id);
        pok1.setText(time.getPokemon().get(0).getPokemonNome());
        pok2.setText(time.getPokemon().get(1).getPokemonNome());
        pok3.setText(time.getPokemon().get(2).getPokemonNome());
        pok4.setText(time.getPokemon().get(3).getPokemonNome());
        pok5.setText(time.getPokemon().get(4).getPokemonNome());
        pok6.setText(time.getPokemon().get(5).getPokemonNome());
        return view;
    }
}
