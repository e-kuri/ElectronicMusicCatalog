package com.example.admin.electronicmusiccatalog;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 7/13/2016.
 */
public class DJAdapter extends CursorRecyclerViewAdapter<DJHolder>{
/*
    private List<DJ> DJList;

    public DJAdapter(List<DJ> djs){
        this.DJList = djs;
    }

    public DJAdapter(DJ[] djs){
        DJList = Arrays.asList(djs);
    }
*/

    private Cursor cursor;

    public DJAdapter(Context context, Cursor cursor){
        super(context, cursor);
    }

    @Override
    public DJHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.dj_layout, parent, false);
        return new DJHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(DJHolder holder, Cursor cursor) {
        //DJ dj = DJList.get(position);

        int nameIndex = cursor.getColumnIndex("name");
        int nationalityIndex = cursor.getColumnIndex("nationality");
        int genreIndex = cursor.getColumnIndex("genre");
        int imageIndex = cursor.getColumnIndex("imageURL");
/*
        DJ dj = new DJ(cursor.getString(nameIndex),
                cursor.getString(genreIndex),
                cursor.getString(nationalityIndex),
                cursor.getString(imageIndex));
*/
        holder.name.setText(cursor.getString(nameIndex));
        holder.description.setText(cursor.getString(genreIndex) + "\n" + cursor.getString(nationalityIndex));
        try {
            URL url = new URL(cursor.getString(imageIndex));
            HttpURLConnection connection = ((HttpURLConnection) url.openConnection());
            Log.e("response code", String.valueOf(connection.getResponseCode()));
            Bitmap bmp = BitmapFactory.decodeStream(connection.getInputStream());
            holder.image.setImageBitmap(bmp);
        } catch (Exception e) {
            holder.image.setImageResource(R.drawable.main);
            e.printStackTrace();
        }

    }


}
