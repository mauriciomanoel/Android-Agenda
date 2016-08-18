package br.com.sjcc.agenda.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.sjcc.agenda.R;
import br.com.sjcc.agenda.modelo.Livro;

/**
 * Created by Mauricio on 17/08/2016.
 */
public class LivroAdapter extends RecyclerView.Adapter<LivroAdapter.ViewHolder> {
    private List<Livro> livros;

    public LivroAdapter(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.livro_list_row, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        ViewHolder holder = (ViewHolder) viewHolder;

        Livro livro  = livros.get(position);

        holder.nome.setText(livro.getNomeLivro());
        holder.autor.setText(livro.getNomeAutor());
        holder.nota.setText(String.valueOf(livro.getNota()));
    }

    @Override
    public int getItemCount() {
        return livros.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nome;
        final TextView autor;
        final TextView nota;
        public TextView mTextView;

        public ViewHolder(View view) {
            super(view);
            nome = (TextView) view.findViewById(R.id.item_livro_titulo);
            nota = (TextView) view.findViewById(R.id.item_livro_nota);
            autor = (TextView) view.findViewById(R.id.item_livro_autor);
        }

    }
}
