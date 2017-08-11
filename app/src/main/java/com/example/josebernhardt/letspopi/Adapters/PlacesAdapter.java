package com.example.josebernhardt.letspopi.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

import com.example.josebernhardt.letspopi.POJOs.Place;
import com.example.josebernhardt.letspopi.R;
import java.util.ArrayList;
import java.util.List;

/**`
 * Created by Jose Bernhardt on 8/10/2017.
 */

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.PlacesHolder>{


  private List<Place> placeList = new ArrayList<>();
  private Context mContext;

  public PlacesAdapter(List<Place> placeList, Context mContext) {
    this.placeList = placeList;
    this.mContext = mContext;
  }

  @Override
  public PlacesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.row_places, parent, false);
    return new PlacesHolder(v);
  }

  @Override
  public void onBindViewHolder(PlacesHolder holder, int position) {

    holder.placeName.setText(placeList.get(position).getName());
    holder.placeType.setText(placeList.get(position).getType());
    holder.placeAddress.setText(placeList.get(position).getAddress());
    holder.placeHours.setText(placeList.get(position).getBusinnessHours());
    holder.placePhone.setText(placeList.get(position).getPhoneNumber());
    holder.placeImage.setImageResource(placeList.get(position).getPic());


  }

  @Override
  public int getItemCount() {
    return placeList.size();
  }

  // Provides a reference to the views for each data item
static class PlacesHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.name_tv)
    TextView placeName;
    @BindView(R.id.type_tv)
    TextView placeType;
    @BindView(R.id.address_tv)
    TextView placeAddress;
    @BindView(R.id.hours_tv)
    TextView placeHours;
    @BindView(R.id.phone_tv)
    TextView placePhone;
    @BindView(R.id.restaurant_img)
    ImageView placeImage;
    PlacesHolder(View v){
      super(v);
      ButterKnife.bind(this, v);
    }
  }
}



