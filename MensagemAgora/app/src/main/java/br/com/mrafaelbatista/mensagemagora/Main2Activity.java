package br.com.mrafaelbatista.mensagemagora;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView tv_tagName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tv_tagName = (TextView) findViewById(R.id.tv_recActivity);

       if (getIntent().getExtras() != null) {
           String tagName = getIntent().getExtras().getString("tagNameQualquer");
           tv_tagName.setText(tagName);
       } else {

           tv_tagName.setText("Você apenas troucou de tela!");

       }
    }

}
