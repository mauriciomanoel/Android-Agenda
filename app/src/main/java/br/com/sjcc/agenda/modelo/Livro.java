package br.com.sjcc.agenda.modelo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Mauricio on 17/08/2016.
 */
public class Livro implements Parcelable {
    private long id;
    private String nomeLivro;
    private String nomeAutor;
    private float nota;

    public Livro(long id, String nomeLivro, String nomeAutor, float nota) {
        this.setId(this.id);
        this.setNomeLivro(nomeLivro);
        this.setNomeAutor(nomeAutor);
        this.setNota(nota);
    }

    protected Livro(Parcel in) {
        setId(in.readLong());
        setNomeLivro(in.readString());
        setNomeAutor(in.readString());
        setNota(in.readFloat());
    }

    public static final Creator<Livro> CREATOR = new Creator<Livro>() {
        @Override
        public Livro createFromParcel(Parcel in) {
            return new Livro(in);
        }

        @Override
        public Livro[] newArray(int size) {
            return new Livro[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.getId());
        parcel.writeString(this.getNomeLivro());
        parcel.writeString(this.getNomeAutor());
        parcel.writeFloat(this.getNota());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
}