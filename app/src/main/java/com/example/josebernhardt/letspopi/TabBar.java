package com.example.josebernhardt.letspopi;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.josebernhardt.letspopi.Adapters.PlacesAdapter;
import com.example.josebernhardt.letspopi.POJOs.Place;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by jbernhardt on 8/11/2017.
 */

public class TabBar extends Fragment {

    private  List<Place> barList;
    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.bars_tab, container, false);
        RecyclerView recyclerView  = (RecyclerView) view.findViewById(R.id.places_cardList);
         barList = new ArrayList<>();

        barList.add(new Place("eMe by Markecito", "Av. Gustavo Mejia Ricart #92, Piantini, Santo Domingo",
                "(809) 541-7878", "Viernes - Sábado 5:00 p.m. - 2:00 a.m", "Tapas", R.drawable.eme));

        barList.add(new Place("Camden", "Gustavo Mejía Ricart No. 83, Plaza Andalucía I, Piantini, local 1-B",
                "(809) 540-3588", "Viernes - Sábado 5:00 p.m. - 2:00 a.m", "Bar", R.drawable.camdem));

        barList.add(new Place("BeerMarket", "C/Isabel La Católica Esq. Padre Billini\n"
                + "Santo Domingo, Dominican Republic 10211",
                "(849) 245-4094", "Viernes - Sábado 4:00 p.m. - 2:00 a.m", "Bar", R.drawable.beer_market));

        barList.add(new Place("Local 3", "Calle Max Henriquez Ureña 33, Santo Domingo",
                "(849) 258-9133", "Viernes - Sábado 5:00 p.m. - 2:00 a.m", "Tapas-Bar", R.drawable.local_3));

        barList.add(new Place("Markecito", "Av. Winston Churchill (Poncio Sabater)\n" +
                "Santo Domingo, República Dominicana", "(829) 538-0000", "Viernes - Sábado 5:00 p.m. - 2:00 a.m",
                "Bar", R.drawable.markecito));

        barList.add(new Place("Santo Libre", " Calle Restauración, Santo Domingo 10212",
                "(809) 689-9351", "Viernes - Sábado 5:00 p.m. - 3:00 a.m", "Bar", R.drawable.santo_libre));

        barList.add(new Place("Monalisa", "Av. Abraham Lincoln no.858, Piantini, Santo Domingo",
                "(809) 475-9858", "Viernes - Sábado 5:00 p.m. - 2:00 a.m.", "Tapas", R.drawable.monalisa));

        barList.add(new Place("La Alpargateria", " Salomé Ureña, No. 59, Zona Colonial, Santo Domingo",
                "(809) 689-9351", "Viernes - Sábado 5:00 p.m. - 3:00 a.m", "Bar", R.drawable.alpa));



        recyclerView.setHasFixedSize(true);
        GridLayoutManager lLayout = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(lLayout);

        PlacesAdapter placeAdapter = new PlacesAdapter(barList, getActivity());
        recyclerView.setAdapter(placeAdapter);

        FloatingActionButton myFab = (FloatingActionButton) view.findViewById(R.id.fab_bar);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Random ran = new Random();
                int ranNumb = ran.nextInt(barList.size());
                final Place currentPlace = barList.get(ranNumb);

                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = getActivity().getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.custom_dialog, null);

                ImageView image = (ImageView) dialogView.findViewById(R.id.place_image) ;
                image.setImageResource(currentPlace.getPic());
                TextView placeName = (TextView) dialogView.findViewById(R.id.dialog_name_tv);
                placeName.setText(currentPlace.getName());
                TextView type = (TextView) dialogView.findViewById(R.id.dialog_type_tv);
                type.setText(currentPlace.getType());

                dialog.setCancelable(false);
                dialog.setMessage("Lets Popi to:");
                dialog.setPositiveButton("Go!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(
                                "http://maps.google.co.in/maps?q=" +currentPlace.getAddress()));
                        startActivity(i);
                    }
                });

                dialog.setView(dialogView);
                Dialog  b = dialog.create();
                b.show();
            }
        });

        //Returning the layout file after inflating
        return view;
    }


}
