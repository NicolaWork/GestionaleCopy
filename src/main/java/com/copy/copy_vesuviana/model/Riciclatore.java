package com.copy.copy_vesuviana.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="riciclatore")
public class Riciclatore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    
    @Column(name= "matricola")
    private String matricola;
    
    @Column(name= "modello")
    private String modello;
    
    @Column(name= "data_acquisto")
    private LocalDate dataAcquisto;

    @Column(name="assistenza")
    private Boolean assistenza;
    
    @OneToOne @JoinColumn(name = "macchina_id")
    private Macchina macchina;      

    public Riciclatore(){}
    
    
    
    public Riciclatore(Long id, String matricola, String modello, LocalDate dataAcquisto, Boolean assistenza) {
        this.id = id;
        this.matricola = matricola;
        this.modello = modello;
        this.dataAcquisto = dataAcquisto;
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
    
    public LocalDate getDataAcquisto() {
        return dataAcquisto;
    }
    
    public void setDataAcquisto(LocalDate dataAcquisto) {
        this.dataAcquisto = dataAcquisto;
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
        return "Riciclatore [id=" + id + ", matricola=" + matricola + ", modello=" + modello + ", dataAcquisto="
                + dataAcquisto + ", assistenza=" + assistenza + "]";
    }



    public Macchina getMacchina() {
        return macchina;
    }



    public void setMacchina(Macchina macchina) {
        this.macchina = macchina;
    }

    
    
}
