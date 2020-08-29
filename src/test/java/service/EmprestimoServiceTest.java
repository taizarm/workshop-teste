package service;

import static model.Emprestimo.EmprestimoStatus.ATIVO;

import model.Emprestimo;
import model.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repository.EmprestimoRepository;

class EmprestimoServiceTest {

    UsuarioService usuarioService = Mockito.mock(UsuarioService.class);
    EmprestimoRepository emprestimoRepository = Mockito.mock(EmprestimoRepository.class);
    EmprestimoService emprestimoService = new EmprestimoService(usuarioService, emprestimoRepository);

    @Test
    public void deveSalvarEmprestimoSeUsuarioValido() {
        /*
         * O que eu preciso fazer para esse teste funcionar?
         * 1) Usuario deve ser válido
         * 2) Chamar método que salva emprestimo (método sob test)
         * 3) Verificar se o emprestimo foi realmente salvo
         * 4) Verificar se o status do emprestimo retornado é ATIVO
         */

        Usuario usuario = Mockito.mock(Usuario.class);
        Emprestimo emprestimo = new Emprestimo(usuario, "livro");

        // 1) Usuario deve ser válido
        Mockito.when(usuarioService.isUsuarioValido(emprestimo.getUsuario())).thenReturn(true);

        // 2) Chamar método que salva emprestimo (método sob test)
        Emprestimo emprestimoSalvo = emprestimoService.salvaEmprestimo(emprestimo);

        //3) Verificar se o emprestimo foi realmente salvo
        Mockito.verify(emprestimoRepository).save(emprestimo);

        //4) Verifica se o status do emprestimo retornado é ATIVO
        Assertions.assertEquals(ATIVO, emprestimoSalvo.getStatus());
    }

    @Test
    public void deveRetornarExcecaoSeUsuarioForInvalido() {
        /*
         * O que eu preciso configurar para esse teste funcionar?
         * 1) Usuario deve ser inválido
         * 2) Chamar método que salva emprestimo (método sob test)
         * 3) Verificar se o método terminou em excecao
         * 4) Verificar se o emprestimo nao foi salvo no banco
         */

        Usuario usuario = Mockito.mock(Usuario.class);
        Emprestimo emprestimo = new Emprestimo(usuario, "livro");

        // 1) Usuario deve ser inválido
        Mockito.when(usuarioService.isUsuarioValido(emprestimo.getUsuario())).thenReturn(false);

        // 2) Chamar método que salva emprestimo (método sob test)
        // 3) Verificar se o método terminou em excecao
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            emprestimoService.salvaEmprestimo(emprestimo);
        });

        // 4) Verificar se o emprestimo nao foi salvo no banco
        Mockito.verify(emprestimoRepository, Mockito.times(0)).save(emprestimo);
    }
}