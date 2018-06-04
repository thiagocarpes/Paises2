package br.usjt.paises;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetalhePaises extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_paises);

        android.support.v4.app.FragmentManager fm  = getSupportFragmentManager();

        if (savedInstanceState == null){
            //começa a transação
            FragmentTransaction ft = fm.beginTransaction();
            DadosPais dp = new DadosPais();
            //adiciona
            ft.add (R.id.layoutPais, dp, "DadosPaises");
            //confirma e fecha a transação
            ft.commit();
        }

        TextView txtPais = (TextView)findViewById(R.id.txtPais);
        Intent intent = getIntent();
        Pais pais = (Pais)intent.getSerializableExtra(Lista_paises.PAIS);
        txtPais.setText(pais.toString());
    }
}
