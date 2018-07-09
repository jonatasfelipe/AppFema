package fema.edu.br.femaapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

import static fema.edu.br.femaapp.R.layout.tela_inicial;

public class TelaInicial extends AppCompatActivity {

    ImageButton btnAluno, btnProfessor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(tela_inicial);

        btnAluno = (ImageButton)findViewById(R.id.btnAluno);
        btnProfessor = (ImageButton)findViewById(R.id.btnProfessor);

        btnAluno.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent abreLogin = new Intent(TelaInicial.this, TelaLogin.class);
                startActivity(abreLogin);
            }
        });

        btnProfessor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent abreLogin2 = new Intent(TelaInicial.this, TelaLogin2.class);
                startActivity(abreLogin2);
            }
        });


    }
}

