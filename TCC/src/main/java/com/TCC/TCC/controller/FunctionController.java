package com.TCC.TCC.controller;

import com.TCC.TCC.model.Function;
import com.TCC.TCC.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/function")
public class FunctionController {

    private FunctionService functionService;

    @Autowired
    public FunctionController(FunctionService functionService) {
        this.functionService = functionService;
    }

    @PostMapping
    public ResponseEntity<Function> Post(@RequestBody Function function) {
        return new ResponseEntity(this.functionService.Create(function), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Function> Put( @RequestBody Function function, @PathVariable("id") Long id) {
        return new ResponseEntity(this.functionService.Update(id, function), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Function> Put( @PathVariable("id") Long id) {
        return new ResponseEntity(this.functionService.Delete(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Function>> Get() {
        return new ResponseEntity(this.functionService.Find(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Function> Get( @PathVariable("id") Long id) {
        return new ResponseEntity(this.functionService.Find(id), HttpStatus.OK);
    }
}
