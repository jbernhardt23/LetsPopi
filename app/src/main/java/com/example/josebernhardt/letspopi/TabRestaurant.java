package com.example.josebernhardt.letspopi;

import android.app.AlertDialog;
import android.app.Dialog;
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

public class TabRestaurant extends Fragment {

   private List<Place> restaurantList;
    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.restaurant_tab, container, false);
        RecyclerView recyclerView  = (RecyclerView) view.findViewById(R.id.places_cardList);

         restaurantList = new ArrayList<>();

        restaurantList.add(new Place("Made in China", "Av. Gustavo Mejia Ricart #92, Piantini, Santo Domingo",
                "(809) 620-4915", "Viernes - Sábado 11:30 a.m. - 12:00 a.m", "China", R.drawable.made_in_china));

        restaurantList.add(new Place("Forno Bravo", "Federico Geraldino Plaza MezzaLuna, Piantini, Santo Domingo",
                "(809) 222-9222", "Viernes - Sábado 12:00 p.m. - 12:00 a.m.", "Italina", R.drawable.forno_bravo));

        restaurantList.add(new Place("Coyo Taco", "Max Henriquez Ureña esquina Tiradentes, Naco, Santo Domingo",
                "(809) 918-4317", "Viernes - Sábado 11:00 a.m. - 3:00 a.m.", "Mexicana", R.drawable.coyo_taco));

        restaurantList.add(new Place("La Dolcerie Café Bistro", "Rafael Augusto Sánchez #20, Piantini, Santo Domingo",
                "(809) 565-0333", "Viernes - Sábado 7:30 a.m. - 12:00 a.m", "Internacional", R.drawable.dolcerie));

        restaurantList.add(new Place("Tony Roma's", "Av. Sarasota No. 29, Bella Vista, Santo Domingo",
                "(809) 535-5454", "Viernes - Sábado 11:00 a.m. - 12:00 a.m.", "Carnes", R.drawable.tony_romas));

        restaurantList.add(new Place("Santoña Colonial", " Calle Arzobispo Meriño 310-B, Zona Colonial, Santo Domingo",
                "(809) 794-5207", "Viernes - Sábado 6:00 p.m. - 2:00 a.m", "Tapas", R.drawable.santona_colonial));


        restaurantList.add(new Place("La Locanda", "Marginal Nuñez de Caceres # 312, El Millón, Santo Domingo",
                "(809) 794-8641", "Viernes - Sábado 12:00 p.m. - 11:00 p.m.", "Italina", R.drawable.la_locanda));

        restaurantList.add(new Place("Chili´s Grill & Bar", "Av. Sarasota esq. Bohechio Edificio, Bella Vista, Santo Domingo",
                "(809) 533-0202", "Viernes - Sábado 11:30 a.m. - 12:00 a.m.", "Americana", R.drawable.chilis));


        restaurantList.add(new Place("Mix", "Avenida Gustavo Mejia Ricart 71-84, Santo Domingo",
                "(809) 472-0100", "Viernes - Sábado 12:00 p.m. - 2:00 a.m", "Tapas", R.drawable.mix));

        restaurantList.add(new Place("Cuello Blanco", "C/19 de Marzo #203, Entre El Conde y la Arzobispo Nouel, Zona Colonial, Santo Domingo",
                "(809) 221-5982", "Viernes - Sábado 11:00 a.m. - 2:00 a.m", "Internacional", R.drawable.cuello_blanco));



        recyclerView.setHasFixedSize(true);
        GridLayoutManager lLayout = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(lLayout);

        PlacesAdapter placeAdapter = new PlacesAdapter(restaurantList, getActivity());
        recyclerView.setAdapter(placeAdapter);

        FloatingActionButton myFab = (FloatingActionButton) view.findViewById(R.id.fab2);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Random ran = new Random();
                int ranNumb = ran.nextInt(restaurantList.size());
                Place currentPlace = restaurantList.get(ranNumb);

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
                dialog.setPositiveButton("Go!", null);
                dialog.setView(dialogView);
                Dialog b = dialog.create();
                b.show();
            }
        });


        //Returning the layout file after inflating
        return view;
    }

    private void showRandomPlace(){

    }
}
