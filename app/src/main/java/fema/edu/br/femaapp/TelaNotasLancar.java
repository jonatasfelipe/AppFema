package fema.edu.br.femaapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

public class TelaNotasLancar extends AppCompatActivity {

    String url="http://192.168.1.36/femaapp/alunos.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_lancanotas);


    }

}
