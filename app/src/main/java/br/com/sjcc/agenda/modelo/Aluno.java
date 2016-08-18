package br.com.sjcc.agenda.modelo;

/**
 * Created by Mauricio on 16/08/2016.
 */
public class Aluno {
    private long id;
    private String nome;
    private String email;

    public Aluno(long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
