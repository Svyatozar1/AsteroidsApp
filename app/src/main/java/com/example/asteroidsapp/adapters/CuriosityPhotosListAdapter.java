package com.example.asteroidsapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asteroidsapp.R;
import com.example.asteroidsapp.data.entities.Photo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CuriosityPhotosListAdapter
        extends RecyclerView.Adapter<CuriosityPhotosListAdapter.CuriosityPhotosListHolder>{
    private ArrayList<Photo> data;
    private Context context;

    public CuriosityPhotosListAdapter(ArrayList<Photo> photos, Context context) {
        this.data = photos;
        this.context = context;
        notifyDataSetChanged();
    }

    public void changeData(ArrayList<Photo> newData) {
        this.data = newData;
        notifyDataSetChanged();
    }

    class CuriosityPhotosListHolder extends RecyclerView.ViewHolder {
        private ImageView photo;

        CuriosityPhotosListHolder(View view) {
            super(view);
            photo = view.findViewById(R.id.curiosityPhoto);
        }

        void setContent(String curiosityPhotoUrl, String curiosityPhotoDateText) {
            Picasso.with(context)
                    .load(curiosityPhotoUrl)
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder_error)
                    .into(photo);
        }
    }

    @NonNull
    @Override
    public CuriosityPhotosListHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.photo_list_item, viewGroup, false);
        return new CuriosityPhotosListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CuriosityPhotosListHolder curiosityPhotosListHolder,
                                 final int i) {
        String photoUrl = data.get(i).img_src;
        String photoDate = data.get(i).earth_date;
        curiosityPhotosListHolder.setContent(photoUrl, photoDate);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
