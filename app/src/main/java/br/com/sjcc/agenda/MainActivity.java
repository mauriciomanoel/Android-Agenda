package br.com.sjcc.agenda;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.sjcc.agenda.adapters.MensagemAdapter;
import br.com.sjcc.agenda.modelo.Mensagem;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity
        extends AppCompatActivity {

    @Bind(R.id.edtTitulo)
    EditText mEdtTitulo;
    @Bind(R.id.edtTexto)
    EditText mEdtMensagem;
    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;

    List<Mensagem> mMensagens;
    MensagemAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mMensagens = new ArrayList<Mensagem>();
        mAdapter = new MensagemAdapter(mMensagens, mListener);
        mRecyclerView.setAdapter(mAdapter);

        GridLayoutManager layoutManager =
                new GridLayoutManager(this, 2);

        layoutManager.setSpanSizeLookup(
                new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int pos) {
                        return pos == 0 ? 2 : 1;
                    }
                });
        mRecyclerView.setLayoutManager(layoutManager);
    }

    @OnClick(R.id.fab)
    public void onClick(View view) {
        Mensagem mensagem = new Mensagem(
                mEdtTitulo.getText().toString(),
                mEdtMensagem.getText().toString());
        mMensagens.add(mensagem);
        mAdapter.notifyItemInserted(mMensagens.size() - 1);

        mEdtTitulo.getText().clear();
        mEdtMensagem.getText().clear();
    }

    private MensagemAdapter.AoClicarNaMensagem mListener=
            new MensagemAdapter.AoClicarNaMensagem() {
                @Override
                public void mensagemClicada(Mensagem msg) {
                    String s = String.format(
                            "%s %s", msg.getTitulo(), msg.getTexto());
                    Toast.makeText(MainActivity.this,
                            s, Toast.LENGTH_SHORT).show();
                }
            };
}