package com.wesleyxbz.springbootmvc.dao;

import com.wesleyxbz.springbootmvc.domain.Cargo;

import java.util.List;

public interface CargoDao {

    public void save(Cargo cargo);

    public void update(Cargo cargo);

    public void delete(Long id);

    public Cargo findById(Long id);

    public List<Cargo> findAll();
}
