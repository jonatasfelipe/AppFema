package fema.edu.br.femaapp;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

public class Validar extends AsyncTask<Void,Integer,Integer> {

    Context c;
    ListView lv;
    String data;

    ArrayList<String> alunos=new ArrayList<>();
    ProgressDialog pd;

    public Validar(Context c, String data, ListView lv) {
        this.c = c;
        this.data = data;
        this.lv = lv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(c);
        pd.setTitle("Validar");
        pd.setMessage("Validando aguarde");
        pd.show();
    }

    @Override
    protected Integer doInBackground(Void... params) {

        return this.Validar();
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);

        if(integer == 1)
        {
            //ADAPTER
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(c,android.R.layout.simple_list_item_1,alunos);

            //ADAPT TO LISTVIEW

            lv.setAdapter(adapter);

            //LISTENET
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    make(view,alunos.get(position), LENGTH_SHORT).show();;
                }
            });

        }else
        {
            makeText(c,"Unable to Parse", LENGTH_SHORT).show();
        }

        pd.dismiss();
    }

    private Dialog make(Drawable.Callback view, String s, int lengthShort) {
        return null;
    }

    //PARSE RECEIVED DATA
    private int Validar()
    {
        try
        {
            //ADD THAT DATA TO JSON ARRAY FIRST
            JSONArray ja=new JSONArray(data);

            //CREATE JO OBJ TO HOLD A SINGLE ITEM
            JSONObject jo=null;

            alunos.clear();

            //LOOP THRU ARRAY
            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);

                //RETRIOEVE NAME
                String nome=jo.getString("nome");

                //ADD IT TO OUR ARRAYLIST
                alunos.add(nome);
            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }

    private class Snackbar {
    }
}