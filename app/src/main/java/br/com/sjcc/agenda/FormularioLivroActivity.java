package br.com.sjcc.agenda;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import br.com.sjcc.agenda.helpers.FormularioLivroHelper;
import br.com.sjcc.agenda.modelo.Livro;

public class FormularioLivroActivity extends AppCompatActivity {

    private FormularioLivroHelper helper;
    private Livro mLivro;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_livro);

        helper = new FormularioLivroHelper(this);

        mLivro = (Livro) getIntent().getParcelableExtra("livro");
        if (mLivro!=null) {
            TextView nAutor = (TextView) findViewById(R.id.livro_autor);
            TextView nLivro = (TextView) findViewById(R.id.livro_nome);
            RatingBar nNota = (RatingBar) findViewById(R.id.livro_avaliacao);

            nAutor.setText(mLivro.getNomeAutor());
            nLivro.setText(mLivro.getNomeLivro());
            nNota.setRating(mLivro.getNota());
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario_livro, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_formulario_livro_ok:
                Livro novoLivro = helper.criarLivro();
                mLivro.setNomeAutor(novoLivro.getNomeAutor());
                mLivro.setNomeLivro(novoLivro.getNomeLivro());
                mLivro.setNota(novoLivro.getNota());
                Intent i = new Intent();
                i.putExtra("LIVRO", mLivro);
                setResult(RESULT_OK, i);
                //Toast.makeText(FormularioLivroActivity.this, livro.getNomeAutor(), Toast.LENGTH_LONG).show();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
