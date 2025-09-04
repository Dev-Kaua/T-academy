package SistemaStreamingMidia.Funcionalidades;

public class Avaliacao {

    private int estrelas;
    private boolean like;
    private String comentario;

    public Avaliacao(int estrelas, boolean like, String comentario) {
        this.estrelas = estrelas;
        this.like = like;
        this.comentario = comentario;
    }

    public int getEstrelas() {
        return estrelas;
    }

    public boolean isLike() {
        return like;
    }

    public String getComentario() {
        return comentario;
    }
}
