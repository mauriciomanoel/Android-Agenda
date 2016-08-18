package br.com.sjcc.agenda.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.sjcc.agenda.R;
import br.com.sjcc.agenda.modelo.Aluno;

/**
 * Created by Mauricio on 16/08/2016.
 */
public class AlunoAdapter extends BaseAdapter {
    private Context ctx;
    private List<Aluno> alunos;

    public AlunoAdapter(Context ctx, List<Aluno> alunos) {
        this.ctx = ctx;
        this.alunos = alunos;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Object getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return alunos.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        Aluno a = alunos.get(position);
        if (view == null) {
            view = LayoutInflater.from(ctx).inflate(R.layout.content_tela_lista, null);
            holder = new ViewHolder();
            holder.txtNome = (TextView) view.findViewById(R.id.alunoNome);
            holder.txtEmail = (TextView) view.findViewById(R.id.alunoEmail);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.txtNome.setText(a.getNome());
        holder.txtEmail.setText(a.getEmail());

        return view;
    }
    static class ViewHolder {
        TextView txtNome;
        TextView txtEmail;
    }
}
