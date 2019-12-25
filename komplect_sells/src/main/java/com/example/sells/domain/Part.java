package com.example.sells.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String partNumber;

    private String name;

    private Integer quantity;

    private Double price;
    private LocalDate dateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    public Part(String partNumber, String name, Integer quantity, Double price, Supplier supplier, LocalDate dateTime) {
        this.partNumber = partNumber;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.supplier = supplier;
        this.dateTime = dateTime;
    }

    public Double priceOut(){
        return price*(supplier.getIndex());
    }

    public Part() {
    }

    public String getSupplierName(){
        return supplier!=null ? supplier.getName() : "<none>";
    }


    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier suplier) {
        this.supplier = suplier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String part_number) {
        this.partNumber = part_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
