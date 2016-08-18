package br.com.sjcc.agenda;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class ListaAlunosActivity extends AppCompatActivity implements Response.Listener<JSONObject>,
        Response.ErrorListener {
    private String json_url = "http://www.4reuse.info/exemplo.json";
    private RequestQueue requestQueue;
    private List<String> alunos = new ArrayList();
    private ListView listaAlunos;
    private Button buttonGet;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        listaAlunos = (ListView) findViewById(R.id.lista_alunos);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void carregarAlunos() {
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, json_url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        JSONArray jsonAlunos = null;
                        try {
                            jsonAlunos = response.getJSONArray("alunos");
                            for (int i = 0; i < jsonAlunos.length(); i++) {
                                JSONObject aluno = jsonAlunos.getJSONObject(i);
                                alunos.add(aluno.getString("name"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", "ERROR");
                    }
                }
        );

        Toast.makeText(this,alunos.toString(),Toast.LENGTH_LONG).show();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListaAlunosActivity.this, android.R.layout.simple_list_item_1, alunos);
        listaAlunos.setAdapter(adapter);

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsObjRequest);

    }

    @Override
    protected void onResume() {
        super.onResume();

        //Toast.makeText(this,"Resume" + alunos.toString(),Toast.LENGTH_LONG).show();
    }


    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {
        carregarAlunos();
    }
}
