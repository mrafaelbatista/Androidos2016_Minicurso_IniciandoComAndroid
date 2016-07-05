package br.com.mrafaelbatista.mensagemagora;

import android.Manifest;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void compMensagem(View v) {

        //Compartilhar um texto
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plan");
        String text = "Testando a parada!";
        i.putExtra(Intent.EXTRA_TEXT, text);
        startActivity(Intent.createChooser(i, getResources().getText(R.string.app_name)));

    }

    public void acessarWeb(View v) {

        //Acessar uma página web
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.androidosday.com"));
        startActivity(i);

    }

    public void chamadaCall(View v) {
        //Realizar uma chamada
       Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+55)8332314577"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

            //Caso não tenha-se essa permissão no Android Manifest, então devemos dar uma resposta a isso.
            return;
        }

        startActivity(i);
    }

    public void chamadaDiscagem(View v) {

        //Tela de Discagem
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+49)12345789"));
        startActivity(i);

    }

    public void capturaImagem(View v) {
        //Captura de Imagem
        Intent i = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(i);
    }

    public void abrirContatos(View v) {
        //Abrir os conatos
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
        startActivity(i);
    }

    public void pesquisarWeb(View v) {
        //Pesquisar na Web
        Intent i = new Intent(Intent.ACTION_WEB_SEARCH).putExtra(SearchManager.QUERY, "Androidos");
        startActivity(i);
    }


    public void switchTelas(View v) {

        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);

        //Não voltar para a MainActivity
        //finish();
    }

    public void switchTelasValor(View v) {

        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("tagNameQualquer", "Valor em formato String a ser passado");
        startActivity(i);

        //Não voltar para a MainActivity
        //finish();
    }


}
