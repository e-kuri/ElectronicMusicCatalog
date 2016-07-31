package com.example.admin.emc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.emc.db.DAO.DjDao;
import com.example.admin.emc.model.DJ;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DjDetailActivity extends AppCompatActivity {

    private TextView name, description;
    private ImageView image;

    public static final String DJ_KEY = "KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dj_detail);

        name = ((TextView) findViewById(R.id.name));
        description = ((TextView) findViewById(R.id.description));
        image = ((ImageView) findViewById(R.id.image));

        String key = getIntent().getStringExtra(DJ_KEY);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(DjDao.TABLE_NAME).child(key);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                DJ dj = dataSnapshot.getValue(DJ.class);
                setData(dj);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void setData(DJ dj){
        this.name.setText(dj.getName());
        this.description.setText(dj.getDescription());
        Glide.with(this.getApplicationContext()).load(dj.getImageURL()).override(600,400).into(image);
    }
}
