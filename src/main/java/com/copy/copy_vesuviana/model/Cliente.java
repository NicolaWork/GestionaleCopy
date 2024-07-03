package com.copy.copy_vesuviana.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name="ragione_sociale")
    private String ragione_sociale;

    @Column(name="indirizzo")
    private String indirizzo;

    @OneToMany(mappedBy = "cliente")
    private Set<Macchina> macchina = new HashSet<>();
    
    public Cliente(){}

    public Cliente(String ragione_sociale, String indirizzo) {
        this.ragione_sociale = ragione_sociale;
        this.indirizzo = indirizzo;
    }

    public Long getId() {
        return id;
    }
    
    public String getRagione_sociale() {
        return ragione_sociale;
    }
    
    public void setRagione_sociale(String ragione_sociale) {
        this.ragione_sociale = ragione_sociale;
    }
    
    public String getIndirizzo() {
        return indirizzo;
    }
    
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
    
    public Set<Macchina> getMacchina() {
        return macchina;
    }

    public void setMacchina(Set<Macchina> macchina) {
        this.macchina = macchina;
    }
    
    
}
