package com.example.admin.mytourguide;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Admin on 7/28/2017.
 */

public class tourAdapter extends ArrayAdapter<tour>{
    private Context context;
    private ImageView photoImageView;
    private TextView headTextView,descriptionTextView;

    public tourAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<tour>objects){
        super(context,resource,objects);
        this.context=context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
      View listItemView = convertView;
        if (listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.activity_list_item,parent,false);

             photoImageView= (ImageView) listItemView.findViewById(R.id.imageView);
             headTextView= (TextView) listItemView.findViewById(R.id.head);
             descriptionTextView= (TextView)listItemView.findViewById(R.id.description);

            tour tour = getItem(position);
            boolean isPhoto = tour.getPhotoUrl()!=null;
            if (isPhoto){

                Glide.with(photoImageView.getContext())
                        .load(tour.getPhotoUrl())
                        .into(photoImageView);

                headTextView.setText(tour.getHead());
                descriptionTextView.setText(tour.getDescription());
            }else {
                photoImageView.setVisibility(View.GONE);
                headTextView.setText(tour.getHead());
                descriptionTextView.setText(tour.getDescription());
            }
        }
        return listItemView;
    }


}
