package com.improve10x.memegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MemePreviewScreen extends AppCompatActivity {

    /*
    Guidelines

    To show screen title, use
    getSupportActionBar().setTitle(title);

    To get imageUrl from previous screen, use method
    getMemeImageUrl()

    To load a image using url
    Picasso.get().load(<URL>).into(previewImg);
     */

    private ImageView previewImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meme_preview_screen);
        initComponents();
    }

    // DO not touch this method
    private void initComponents() {
        previewImg = findViewById(R.id.previewImg);
    }

    // DO not touch this method
    private String getMemeImageUrl() {
        return getIntent().getStringExtra("MEME_IMAGE_URL");
    }

}

