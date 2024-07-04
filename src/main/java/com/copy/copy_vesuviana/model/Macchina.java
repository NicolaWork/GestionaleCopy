package com.copy.copy_vesuviana.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="macchina")
public class Macchina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name= "matricola")
    private String matricola;

    @Column(name= "modello")
    private String modello;

    @Column(name= "data_acquisto")
    private LocalDate dataAcquisto;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToOne
    private Bnr bnr; 
    
    @OneToOne
    private Cls cls;

    @OneToOne
    private Riciclatore riciclatore;
    
    public Macchina(){}

    public Macchina(String matricola, String modello, LocalDate dataAcquisto) {
        this.matricola = matricola;
        this.modello = modello;
        this.dataAcquisto = dataAcquisto;
    }

    public Long getId() {
        return id;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public LocalDate getDataAcquisto() {
        return dataAcquisto;
    }

    public void setDataAcquisto(LocalDate dataAcquisto) {
        this.dataAcquisto = dataAcquisto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Bnr getBnr() {
        return bnr;
    }

    public void setBnr(Bnr bnr) {
        this.bnr = bnr;
    }

    public Cls getCls() {
        return cls;
    }

    public void setCls(Cls cls) {
        this.cls = cls;
    }

    public Riciclatore getRiciclatore() {
        return riciclatore;
    }

    public void setRiciclatore(Riciclatore riciclatore) {
        this.riciclatore = riciclatore;
    }

}
