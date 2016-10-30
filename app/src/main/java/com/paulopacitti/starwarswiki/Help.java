package com.paulopacitti.starwarswiki;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Help extends AppCompatActivity
{

    TextView text;
    ImageView imgTwitter;
    ImageView imgGitHub;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        text = (TextView) findViewById(R.id.txtAbout);
        Linkify.addLinks(text, Linkify.ALL);

        imgTwitter = (ImageView) findViewById(R.id.imgTwitter);
        imgGitHub = (ImageView) findViewById(R.id.imgGitHub);
    }

    public void imgTwitter_onClick(View v)
    {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://twitter.com/paulopacitti"));
        startActivity(intent);
    }

    public void imgGitHub_onClick(View v)
    {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://github.com/paulopacitti/"));
        startActivity(intent);
    }

}
