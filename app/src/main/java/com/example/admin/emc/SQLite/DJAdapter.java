package com.example.admin.emc.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.admin.emc.DJHolder;
import com.example.admin.emc.R;
import com.example.admin.emc.db.DAO.DjDao;

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

        int nameIndex = cursor.getColumnIndex(DjDao.DJColumns.NAME.toString());
        int nationalityIndex = cursor.getColumnIndex(DjDao.DJColumns.NATIONALITY.toString());
        int genreIndex = cursor.getColumnIndex(DjDao.DJColumns.SUBGENRE.toString());
        int imageIndex = cursor.getColumnIndex(DjDao.DJColumns.IMAGE_URL.toString());
/*
        DJ dj = new DJ(cursor.getString(nameIndex),
                cursor.getString(genreIndex),
                cursor.getString(nationalityIndex),
                cursor.getString(imageIndex));
*/
        holder.name.setText(cursor.getString(nameIndex));
        holder.description.setText(cursor.getString(genreIndex) + "\n" + cursor.getString(nationalityIndex));
        try {
           // URL url = new URL(cursor.getString(imageIndex));
           // HttpURLConnection connection = ((HttpURLConnection) url.openConnection());
           // Log.e("response code", String.valueOf(connection.getResponseCode()));
           // Bitmap bmp = BitmapFactory.decodeStream(connection.getInputStream());
            Glide.with(holder.image.getContext()).load(cursor.getString(imageIndex)).override(600,400).into(holder.image);
        } catch (Exception e) {
            holder.image.setImageResource(R.drawable.main);
            e.printStackTrace();
        }

    }


}
