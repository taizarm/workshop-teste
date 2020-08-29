package model;

public class Emprestimo {

    private Usuario usuario;

    private String livro;

    private EmprestimoStatus status;

    public enum EmprestimoStatus {
        INATIVO, ATIVO, DEVOLVIDO
    }

    public Emprestimo(final Usuario usuario, final String livro) {
        this.usuario = usuario;
        this.livro = livro;
        this.status = EmprestimoStatus.INATIVO;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getLivro() {
        return livro;
    }

    public EmprestimoStatus getStatus() {
        return status;
    }

    public void setStatus(final EmprestimoStatus status) {
        this.status = status;
    }
}
