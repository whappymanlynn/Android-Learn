package com.example.whapp.listviewtest;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Fruit {

    private String name;
    private int ImageId;
    public Fruit(String name , int imageId){
        this.name = name;
        this.ImageId = imageId;
    }
    public String getName()
    {
        return name;
    }
    public int getImageId()
    {
        return ImageId;
    }
}

class FruitAdapter extends ArrayAdapter<Fruit>
{
    private int resourceId;

    public FruitAdapter(Context context, int textViewResourceId,
                        List<Fruit> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Fruit fruit = getItem(position);
        View view ;
        if(convertView ==null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        }else
        {
            view = convertView;
        }
        ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
        TextView  textView = (TextView) view.findViewById(R.id.fruit_name);
        fruitImage.setImageResource(fruit.getImageId());
        textView.setText(fruit.getName());
        return view;
    }
}