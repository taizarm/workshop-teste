package service;

import static model.Emprestimo.EmprestimoStatus.ATIVO;

import model.Emprestimo;
import repository.EmprestimoRepository;

public class EmprestimoService {

    UsuarioService usuarioService;
    EmprestimoRepository emprestimoRepository;

    public EmprestimoService(final UsuarioService usuarioService, final EmprestimoRepository emprestimoRepository) {
        this.usuarioService = usuarioService;
        this.emprestimoRepository = emprestimoRepository;
    }

    public Emprestimo salvaEmprestimo(Emprestimo emprestimo){

        if (!usuarioService.isUsuarioValido(emprestimo.getUsuario())) {
            throw new IllegalArgumentException("Usuario invalido");
        }

        emprestimo.setStatus(ATIVO);

        emprestimoRepository.save(emprestimo);

        return emprestimo;
    }

}
