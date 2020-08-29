package service;

import model.Usuario;

public class UsuarioService {

    /**
     * Regra sem sentido só para facilitar a implementacao.
     * Usuário é considerado válido se seu código for um número par.
     * @return True se usuário é válido, false caso contrário
     */
    public boolean isUsuarioValido(Usuario usuario) {
        return usuario.getCodigo() % 2 == 0;
    }

}
