package br.com.sjcc.agenda.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.sjcc.agenda.R;
import br.com.sjcc.agenda.modelo.Mensagem;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Mauricio on 17/08/2016.
 */
public class MensagemAdapter
        extends RecyclerView.Adapter<MensagemAdapter.VH> {

    List<Mensagem> mMensagens;
    AoClicarNaMensagem mListener;

    public MensagemAdapter(List<Mensagem> mensagens, AoClicarNaMensagem listener) {
        this.mMensagens = mensagens;
        this.mListener = listener;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mensagem, parent, false);
        final VH vh = new VH(v);
        vh.itemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (mListener != null) {
                            int pos = vh.getAdapterPosition();
                            Mensagem mensagem = mMensagens.get(pos);
                            mListener.mensagemClicada(mensagem);
                        }
                    }
                }
        );
        return vh;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        Mensagem msg = mMensagens.get(position);
        holder.textTexto.setText(msg.getTitulo());
        holder.textTitulo.setText(msg.getTitulo());
    }

    @Override
    public int getItemCount() {
        return mMensagens != null ? mMensagens.size() : 0;
    }

    public static class VH extends
            RecyclerView.ViewHolder {

        @Bind(R.id.txtTitulo)
        public TextView textTitulo;
        @Bind(R.id.txtMensagem)
        public TextView textTexto;

        public VH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface AoClicarNaMensagem {
        void mensagemClicada(Mensagem mensagem);
    }
}

