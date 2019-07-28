package com.wesleyxbz.springbootmvc.service;

import com.wesleyxbz.springbootmvc.dao.FuncionarioDao;
import com.wesleyxbz.springbootmvc.domain.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = false)
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioDao dao;

    @Override
    public void salvar(Funcionario funcionario) {
        dao.save(funcionario);
    }

    @Override
    public void editar(Funcionario funcionario) {
        dao.update(funcionario);
    }

    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Funcionario buscarPorId(Long id) {

        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Funcionario> buscarTodos() {

        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Funcionario> buscarPorNome(String nome) {
        return dao.findByNome(nome);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Funcionario> buscarPorCargo(Long id) {
        return dao.findByCargoId(id);
    }

    @Override
    public List<Funcionario> buscarPorDatas(LocalDate entrada, LocalDate saida) {
        if (entrada != null && saida != null) {
            return dao.findByDataEntradaDataSaida(entrada, saida);
        } else if (entrada != null) {
            return dao.findByDataEntrada(entrada);
        } else if (saida != null) {
            return dao.findByDataSaida(saida);
        } else {
            return new ArrayList<>();
        }
    }

}
