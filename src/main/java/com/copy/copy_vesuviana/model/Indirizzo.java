package com.copy.copy_vesuviana.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="indirizzo")
public class Indirizzo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="strada")
    private String strada;

    @Column(name="provincia")
    private String provincia;

    @Column(name="paese")
    private String paese;

    @Column(name="cap")
    private String cap;

    public Indirizzo () {}
    
    public Indirizzo(Long id, String strada, String provincia, String paese, String cap) {
        this.id = id;
        this.strada = strada;
        this.provincia = provincia;
        this.paese = paese;
        this.cap = cap;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPaese() {
        return paese;
    }

    public void setPaese(String paese) {
        this.paese = paese;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    @Override
    public String toString() {
        return "Indirizzo [id=" + id + ", strada=" + strada + ", provincia=" + provincia + ", paese=" + paese + ", cap="
                + cap + "]";
    }

    
    

}
