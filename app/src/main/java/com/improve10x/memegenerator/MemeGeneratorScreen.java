package com.improve10x.memegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/*
Guidelines

To get Template name text, use
templateNameTxt.getText().toString()

To get top text, use
topTextTxt.getText().toString()

To get bottom text, use
bottomTextTxt.getText().toString()

To load a image using url
Picasso.get().load(<URL>).into(previewImg);
 */
public class MemeGeneratorScreen extends AppCompatActivity implements IMemeGeneratorScreen {

    private EditText templateNameTxt;
    private EditText topTextTxt;
    private EditText bottomTextTxt;
    private Button generateMemeBtn;
    private ImageView previewImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // shows the UI on screen
        initComponents(); // This will create objects for all the ui components
        setupListeners(); // Setting listener for button click action
    }

    // Do not touch this method
    private void initComponents() {
        templateNameTxt = findViewById(R.id.templateNameTxt);
        topTextTxt = findViewById(R.id.topTextTxt);
        bottomTextTxt = findViewById(R.id.bottomTextTxt);
        generateMemeBtn = findViewById(R.id.generateBtn);
        previewImg = findViewById(R.id.previewImg);
    }

    // DO not touch this method
    private void setupListeners() {
        generateMemeBtn.setOnClickListener(v -> {
            onGenerateMemeClicked();
        });
    }

    // This will create the meme image url using ApiMeme.com
    private String createMemeImageUrl(String template, String topText, String bottomText) {
        return "https://apimeme.com/meme?meme="+template+"&top="+topText+"&bottom=" + bottomText;
    }

    @Override
    public void showTitle(String title) {
        getSupportActionBar().setTitle("Meme Generator");
    }

    @Override
    public String getTemplateName() {
        return templateNameTxt.getText().toString();
    }

    @Override
    public String getTopText() {
        return topTextTxt.getText().toString();
    }

    @Override
    public String getBottomText() {
        return bottomTextTxt.getText().toString();
    }

    @Override
    public void onGenerateMemeClicked() {
        String memeImageUrl = createMemeImageUrl(getTemplateName(), getTopText(), getBottomText());
        Picasso.get().load(memeImageUrl).into(previewImg);
    }
}