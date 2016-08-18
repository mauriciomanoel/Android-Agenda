package br.com.sjcc.agenda.modelo;

/**
 * Created by Mauricio on 17/08/2016.
 */
public class Mensagem {
    private String titulo;
    private String texto;

    public Mensagem(String titulo, String texto) {
        this.setTitulo(titulo);
        this.setTexto(texto);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
