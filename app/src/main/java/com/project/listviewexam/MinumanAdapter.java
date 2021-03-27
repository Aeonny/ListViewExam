package com.project.listviewexam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MinumanAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<Minuman> minumans;

    public void setMinumans(ArrayList<Minuman> minumans){
        this.minumans = minumans;
    }

        public MinumanAdapter(Context context){
            this.context = context;
            minumans = new ArrayList<>();
        }

    @Override
    public int getCount() {
        return minumans.size();
    }

    @Override
    public Object getItem(int i) {
        return minumans.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
           view = LayoutInflater.from(context).inflate(R.layout.item_minuman, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Minuman minuman = (Minuman) getItem(i);
        viewHolder.bind(minuman);
        return view;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;
        ViewHolder(View view){
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }
        void bind (Minuman minuman){
            txtName.setText(minuman.getName());
            txtDescription.setText(minuman.getDescription());
            imgPhoto.setImageResource(minuman.getPhoto());
        }
    }
}
