package com.TCC.TCC.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="function_id", referencedColumnName="id")
    private Function function;

    @OneToMany(mappedBy = "task")
    private List<NF> nfs = new ArrayList<>();

    private TaskStatusEnum status;


    public Task(Function function, List<NF> nfs, TaskStatusEnum status) {
        this.function = function;
        this.nfs = nfs;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public List<NF> getNfs() {
        return nfs;
    }

    public void setNfs(List<NF> nfs) {
        this.nfs = nfs;
    }

    public TaskStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TaskStatusEnum status) {
        this.status = status;
    }
}
