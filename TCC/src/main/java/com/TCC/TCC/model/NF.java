package com.TCC.TCC.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "nf")
public class NF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String NF;
    private Double amount;

    @OneToMany(mappedBy = "nf")
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name="task_id", referencedColumnName="id")
    private Task task;

    public NF(String NF, Double amount, List<Product> products) {
        this.NF = NF;
        this.amount = amount;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNF() {
        return NF;
    }

    public void setNF(String NF) {
        this.NF = NF;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
