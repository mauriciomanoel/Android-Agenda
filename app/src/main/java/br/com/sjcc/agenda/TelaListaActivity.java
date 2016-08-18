package br.com.sjcc.agenda;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import br.com.sjcc.agenda.adapters.AlunoAdapter;
import br.com.sjcc.agenda.modelo.Aluno;

public class TelaListaActivity extends ListActivity
        implements
        Response.Listener<JSONObject>,
        Response.ErrorListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String url = "http://www.4reuse.info/exemplo.json";

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsObjRequest =
                new JsonObjectRequest(
                        Request.Method.GET, // Requisição via HTTP_GET
                        url,   // url da requisição
                        null,  // JSONObject a ser enviado via POST
                        this,  // Response.Listener
                        this); // Response.ErrorListener

        requestQueue.add(jsObjRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Erro!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        try {
            JSONArray jsonAluno = response.getJSONArray("alunos");

            for (int i = 0; i < jsonAluno.length(); i++) {
                JSONObject jsonAlunoItem = jsonAluno.getJSONObject(i);

                long id = Long.parseLong(jsonAlunoItem.getString("id"));
                String nome = jsonAlunoItem.getString("name");
                String email = jsonAlunoItem.getString("email");

                alunos.add(new Aluno(id, nome, email));
            }
        } catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        setListAdapter(new AlunoAdapter(this, alunos));
    }
}
