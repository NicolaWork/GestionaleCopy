package com.copy.copy_vesuviana.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cls")
public class Cls {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name= "matricola")
    private String matricola;

    @Column(name= "modello")
    private String modello;

    @Column(name="assistenza")
    private Boolean assistenza;

    @OneToOne(mappedBy = "cls")
    private Macchina macchina;

    @ManyToOne
    private Fornitore fornitore;
    
    public Cls(){}

    

    public Cls(Long id, String matricola, String modello, Boolean assistenza) {
        this.id = id;
        this.matricola = matricola;
        this.modello = modello;
        this.assistenza = assistenza;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isAssistenza() {
        return assistenza;
    }

    public void setAssistenza(Boolean assistenza) {
        this.assistenza = assistenza;
    }



    @Override
    public String toString() {
        return "Cls [id=" + id + ", matricola=" + matricola + ", modello=" + modello + ", assistenza=" + assistenza + "]";
    }



    public Macchina getMacchina() {
        return macchina;
    }



    public void setMacchina(Macchina macchina) {
        this.macchina = macchina;
    }
    

    
}
