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

    @Column(name= "data_ultimo_avviso")
    private LocalDate dataUltimoAvviso;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "bnr_id")
    private Bnr bnr; 
    
    @OneToOne
    @JoinColumn(name = "cls_id")
    private Cls cls;

    @OneToOne
    @JoinColumn(name = "riciclatore_id")
    private Riciclatore riciclatore;

    @ManyToOne @JoinColumn(name = "fornitore_id")
    private Fornitore fornitore;
    
    public Macchina(){}

  
    public Macchina(Long id, String matricola, String modello, LocalDate dataAcquisto, LocalDate dataUltimoAvviso,
            Cliente cliente, Bnr bnr, Cls cls, Riciclatore riciclatore, Fornitore fornitore) {
        this.id = id;
        this.matricola = matricola;
        this.modello = modello;
        this.dataAcquisto = dataAcquisto;
        this.dataUltimoAvviso = dataUltimoAvviso;
        this.cliente = cliente;
        this.bnr = bnr;
        this.cls = cls;
        this.riciclatore = riciclatore;
        this.fornitore = fornitore;
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

    @Override
    public String toString() {
        return  "Macchina [id= "+ id+ ", matricola=" + matricola + ", modello=" + modello + " dataAcquisto=" + dataAcquisto + 
                "\n " + bnr + 
                "\n " + cls + 
                "\n " + riciclatore+
                "\n " + fornitore;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Fornitore getFornitore() {
        return fornitore;
    }



    public void setFornitore(Fornitore fornitore) {
        this.fornitore = fornitore;
    }


    public LocalDate getDataUltimoAvviso() {
        return dataUltimoAvviso;
    }


    public void setDataUltimoAvviso(LocalDate dataUltimoAvviso) {
        this.dataUltimoAvviso = dataUltimoAvviso;
    }

    
    
}
