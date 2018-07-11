package fema.edu.br.femaapp;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaLogin2 extends AppCompatActivity {

    EditText editRa2, editSenha2;
    Button btnLogar2;

    String url = "";
    String parametros = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login2);

        editRa2 = (EditText)findViewById(R.id.editRa2);
        editSenha2 = (EditText)findViewById(R.id.editSenha2);
        btnLogar2 = (Button)findViewById(R.id.btnLogar2);

        btnLogar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                ConnectivityManager connMgr = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

                if (networkInfo != null && networkInfo.isConnected()){

                    String ra2 = editRa2.getText().toString();
                    String senha2 = editSenha2.getText().toString();

                    if(ra2.isEmpty() || senha2.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Nenhuma campo pode estar vazio", Toast.LENGTH_SHORT).show();
                    } else {
                        //url = "http://10.0.119.17/femaapp/logar2.php";
                        url = "http://192.168.1.36/femaapp/logar2.php";

                        parametros = "ra2=" + ra2 + "&senha2=" + senha2;

                        new SolicitaDados2().execute(url);
                    }

                }else {
                    Toast.makeText(getApplicationContext(), "Nenhuma conexão foi detectada", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private class SolicitaDados2 extends AsyncTask<String, Void, String>{
        @Override
        protected String doInBackground(String... urls) {

            return Conexao.postDados(urls[0], parametros);
        }

        @Override
        protected void onPostExecute(String resultado) {

            if(resultado.contains("login_ok")){
                Intent abreMenu2 = new Intent(TelaLogin2.this, TelaMenu2.class);
                startActivity(abreMenu2);
            } else {
                Toast.makeText(getApplicationContext(), "Usuário ou senha estão incorretos", Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}