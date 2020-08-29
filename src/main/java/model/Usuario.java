package model;

public class Usuario {

    String nome;
    Integer codigo;

    public Usuario(final String nome, final Integer codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

}
