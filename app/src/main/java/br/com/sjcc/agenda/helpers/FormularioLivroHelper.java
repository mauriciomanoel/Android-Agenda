package br.com.sjcc.agenda.helpers;

import android.widget.EditText;
import android.widget.RatingBar;

import br.com.sjcc.agenda.FormularioLivroActivity;
import br.com.sjcc.agenda.R;
import br.com.sjcc.agenda.modelo.Livro;

/**
 * Created by Mauricio on 18/08/2016.
 */
public class FormularioLivroHelper {

    private final EditText campoLivro;
    private final EditText campoAutor;
    private final RatingBar campoNota;

    public FormularioLivroHelper(FormularioLivroActivity activity) {
        campoLivro = (EditText) activity.findViewById(R.id.livro_nome);
        campoAutor = (EditText) activity.findViewById(R.id.livro_autor);
        campoNota = (RatingBar) activity.findViewById(R.id.livro_avaliacao);
    }

    public Livro criarLivro(){
        String mLivro = campoLivro.getText().toString();
        String mAutor = campoAutor.getText().toString();
        float mNota = campoNota.getRating();
        Livro livro = new Livro(0,mLivro, mAutor, mNota);
        return livro;
    }
}
