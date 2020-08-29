package service;

import model.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UsuarioServiceTest {

    UsuarioService usuarioService = new UsuarioService();

    @Test
    void retornaTrueSeUsuarioValido() {
        Usuario usuario = new Usuario("Fulano", 20);

        boolean usuarioValido = usuarioService.isUsuarioValido(usuario);

        Assertions.assertTrue(usuarioValido);
    }

    @Test
    void retornaFalsoSeUsuarioInvalido() {
        Usuario usuario = new Usuario("Fulano", 11);

        boolean usuarioValido = usuarioService.isUsuarioValido(usuario);

        Assertions.assertFalse(usuarioValido);
    }

}