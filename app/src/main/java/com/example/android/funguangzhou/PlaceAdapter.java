package com.example.android.funguangzhou;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * {@link PlaceAdapter} is an {@link RecyclerView.Adapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Place} objects.
 */
public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.MyViewHolder> {

    /**
     * Create a new list of {@link Place} object.
     */
    private List<Place> mPlacesList;

    /**
     * An implementation of RecyclerVIew OnItemClickListener.
     */
    private OnItemClickListener mOnItemClickListener;

    /**
     * Create a new {@link PlaceAdapter} object.
     *
     * @param placesList is a list of {@link Place} objects。
     */
    public PlaceAdapter(List<Place> placesList) {
        mPlacesList = placesList;
    }

    public void setOnItemClickListener(OnItemClickListener OnItemClickListener) {
        mOnItemClickListener = OnItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    /**
     * Bind the data to the views
     *
     * @param holder   is the custom ViewHolder
     * @param position is the current position in RecyclerView
     */
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Place place = mPlacesList.get(position);
        holder.imageImageView.setImageResource(place.getImageResourceId());
        holder.nameTextView.setText(place.getName());
        holder.typeTextView.setText(place.getType());
        holder.addressTextView.setText(place.getAddress());

        if (mOnItemClickListener != null) {
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onItemClick(view, holder.getAdapterPosition());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mPlacesList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    /**
     * {@link MyViewHolder} is an custom {@link RecyclerView.ViewHolder} that provide the ViewHolder
     * for each RecyclerView item based on {@link Place} objects.
     */
    static class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView nameTextView, typeTextView, addressTextView;
        ImageView imageImageView;

        MyViewHolder(View view) {
            super(view);

            cardView = view.findViewById(R.id.card_view);
            imageImageView = view.findViewById(R.id.image);
            nameTextView = view.findViewById(R.id.name);
            addressTextView = view.findViewById(R.id.address);
            typeTextView = view.findViewById(R.id.type);
        }
    }
}
