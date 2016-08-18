package br.com.sjcc.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.sjcc.agenda.adapters.LivroAdapter;
import br.com.sjcc.agenda.modelo.Livro;
import br.com.sjcc.agenda.interfaces.IClickListener;

public class LivroActivity extends AppCompatActivity {
    private LivroAdapter mLivroAdapter;
    private ArrayList<Livro> livros;
    private RecyclerView recyclerView;
    static final int PICK_CONTACT_REQUEST = 1;
    private int idx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livro);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        livros = new ArrayList<Livro>();
        livros.add(new Livro(0, "Android", "Glauber", 10));
        livros.add(new Livro(1, "iOS", "Mauricio", 3));
        livros.add(new Livro(2, "Xamarin", "Mateus", 5));

        //RecyclerView.LayoutManager layout = new GridLayoutManager(this, 2);
        //RecyclerView.LayoutManager layout = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layout);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST);
        recyclerView.addItemDecoration(itemDecoration);

        mLivroAdapter = new LivroAdapter(livros);
        recyclerView.setAdapter(mLivroAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new IClickListener() {
            @Override
            public void onClick(View view, int position) {
                idx = position;
                Intent intentFormularioLivro = new Intent(LivroActivity.this, FormularioLivroActivity.class);
                intentFormularioLivro.putExtra("livro", livros.get(position));
                startActivityForResult(intentFormularioLivro, PICK_CONTACT_REQUEST);
            }
            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(getApplicationContext(), "Long selected!", Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Check which request we're responding to
        if (requestCode == PICK_CONTACT_REQUEST) {
            if (resultCode == RESULT_OK) {
                Livro livroSelecionado = (Livro) data.getParcelableExtra("LIVRO");
                livros.set(idx, livroSelecionado);
                Toast.makeText(getApplicationContext(), livroSelecionado.getNomeAutor() + " Atualizado com Sucesso!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    protected void onResume() {
        super.onResume();
        mLivroAdapter.notifyDataSetChanged();
    }
}
