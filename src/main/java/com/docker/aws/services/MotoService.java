package com.docker.aws.services;

import com.docker.aws.models.Moto;
import com.docker.aws.repositories.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoService {

    @Autowired
    private MotoRepository repository;

    public List<Moto> listarTodas() {
        return repository.findAll();
    }

    public void salvar(Moto moto) {
        repository.save(moto);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}