package com.TCC.TCC.model;

import javax.persistence.*;

@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name="nf_id", referencedColumnName="id")
    private NF nf;

    public Product(String name, NF nf) {
        this.name = name;
        this.nf = nf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NF getNf() {
        return nf;
    }

    public void setNf(NF nf) {
        this.nf = nf;
    }

}
