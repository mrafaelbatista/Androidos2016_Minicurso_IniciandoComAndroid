package br.com.mrafaelbatista.andandobarato;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private double vlGasolina, vlEtanol, resultCalculo;
    private EditText et_vlGasolina, et_vlEtanol;
    private TextView tv_resposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        et_vlGasolina = (EditText) findViewById(R.id.et_vlGasolina);
        et_vlEtanol = (EditText) findViewById(R.id.et_vlEtanol);

        tv_resposta = (TextView) findViewById(R.id.tv_resposta);

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

    public void calcularValores(View v) {

        NumberFormat nf = new DecimalFormat("#.##");
        String result;

        vlGasolina = Double.parseDouble(et_vlGasolina.getText().toString());
        vlEtanol = Double.parseDouble(et_vlEtanol.getText().toString());

        //Calculo para saber qual o "peso" do Etanol sobre a Gasolina
        resultCalculo = vlEtanol / vlGasolina;
        result = nf.format(resultCalculo);

        tv_resposta.setVisibility(View.VISIBLE);
        tv_resposta.setFocusable(true);

        if (resultCalculo > 0.7) {

            tv_resposta.setText("O etanol está mais caro do que a gasolina." +
                    "Ele custa: " + result + " em relação a gasolina em um limite de 0.7.");

        } else if (resultCalculo <= 0.7) {

            tv_resposta.setText("Pode escolher o ental em relação a gasolina." +
                    "Ele custa: " + result + " em relação a gasolina em um limite de 0.7.");

        } else {

            tv_resposta.setText("Verifique se digitou os valores no campos corretos.");
        }

    }
}
