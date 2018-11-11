package com.TCC.TCC.service;

import com.TCC.TCC.BusinessExceptions.Exceptions;
import com.TCC.TCC.model.Function;
import com.TCC.TCC.repository.FunctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FunctionService {
    private FunctionRepository functionRepository;

    @Autowired
    public FunctionService(FunctionRepository functionRepository) {
        this.functionRepository = functionRepository;
    }

    @Transactional
    public Function Save(Function function){
        Function sameName = this.functionRepository.findByNameEquals(function.getName());
        if(sameName != null && !sameName.getId().equals(function.getId())){
            throw Exceptions.SameValue("NAME", function.getName());
        };

        Function result = this.functionRepository.save(function);
        return result;
    }

    @Transactional
    public Function Create(Function function){
        function.setId(null);
        return this.Save(function);
    }

    @Transactional
    public Function Update(Long id, Function function){
        function.setId(id);
        return this.Save(function);
    }

    @Transactional
    public Function Delete(Long id){
        Function function = this.Find(id);
        this.functionRepository.delete(function);

        return function;
    }

    public Function Find(Long id) {
        Optional<Function> result = this.functionRepository.findById(id);
        if(!result.isPresent()) {
            throw Exceptions.NotFound(id);
        }

        return result.get();
    }

    public List<Function> Find() {
        return this.functionRepository.findAll();
    }
}
