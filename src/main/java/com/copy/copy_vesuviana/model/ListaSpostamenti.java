package com.copy.copy_vesuviana.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "lista_spostamenti")
public class ListaSpostamenti {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Cliente> cliente;

    @OneToMany
    private List<Cls> cls;

    @OneToMany
    private List<Bnr> bnr;

    @OneToMany
    private List<Riciclatore> riciclatore;

    @OneToMany
    private List<Macchina>macchina;

    @Column (name = "note")
    private String note;

    @Column (name="data")
    private LocalDate data;

    public ListaSpostamenti() {}

    

    public ListaSpostamenti(Long id, List<Cliente> cliente, List<Cls> cls, List<Bnr> bnr, List<Riciclatore> riciclatore,
            List<Macchina> macchina, String note, LocalDate data) {
        this.id = id;
        this.cliente = cliente;
        this.cls = cls;
        this.bnr = bnr;
        this.riciclatore = riciclatore;
        this.macchina = macchina;
        this.note = note;
        this.data = data;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(List<Cliente> cliente) {
        this.cliente = cliente;
    }

    public List<Cls> getCls() {
        return cls;
    }

    public void setCls(List<Cls> cls) {
        this.cls = cls;
    }

    public List<Bnr> getBnr() {
        return bnr;
    }

    public void setBnr(List<Bnr> bnr) {
        this.bnr = bnr;
    }

    public List<Riciclatore> getRiciclatore() {
        return riciclatore;
    }

    public void setRiciclatore(List<Riciclatore> riciclatore) {
        this.riciclatore = riciclatore;
    }

    public List<Macchina> getMacchina() {
        return macchina;
    }

    public void setMacchina(List<Macchina> macchina) {
        this.macchina = macchina;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    
    
}
