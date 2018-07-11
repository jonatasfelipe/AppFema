package fema.edu.br.femaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import static fema.edu.br.femaapp.R.layout.tela_menu2;


public class TelaMenu2 extends AppCompatActivity {

    ImageButton btnnota, btninformacao, btnboletos, btnDependencia, btnhorarios, btnmonografia, btncontratos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(tela_menu2);

        btnnota = (ImageButton)findViewById(R.id.btnnota);
        btninformacao = (ImageButton)findViewById(R.id.btninformacao);
        btnboletos = (ImageButton)findViewById(R.id.btnboletos);
        btnDependencia = (ImageButton)findViewById(R.id.btnDependencia);
        btnhorarios = (ImageButton)findViewById(R.id.btnhorarios);
        btnmonografia = (ImageButton)findViewById(R.id.btnmonografia);
        btncontratos = (ImageButton)findViewById(R.id.btncontratos);

        btnnota.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent abreNotas = new Intent(TelaMenu2.this, TelaNotasLancar.class);
                startActivity(abreNotas);
            }
        });
        btninformacao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent abreInformacao = new Intent(TelaMenu2.this, TelaInformacao.class);
                startActivity(abreInformacao);
            }
        });
        btnboletos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent abreBoletos = new Intent(TelaMenu2.this, TelaBoletos.class);
                startActivity(abreBoletos);
            }
        });
        btnDependencia.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent abreDp = new Intent(TelaMenu2.this, TelaDependencia.class);
                startActivity(abreDp);
            }
        });
        btnhorarios.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent abreHorarios = new Intent(TelaMenu2.this, TelaHorarios.class);
                startActivity(abreHorarios);
            }
        });btnmonografia.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent abreTcc = new Intent(TelaMenu2.this, TelaMonografia.class);
                startActivity(abreTcc);
            }
        });
        btncontratos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent abreContratos = new Intent(TelaMenu2.this, TelaContratos.class);
                startActivity(abreContratos);
            }
        });
}
}