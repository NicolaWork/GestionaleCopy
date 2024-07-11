package com.copy.copy_vesuviana.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="fornitore")
public class Fornitore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="ragione_sociale")
    private String ragione_sociale;

    @Column(name="indirizzo")
    private String indirizzo;

    @Column(name="telefono")
    private String telefono;

    @Column(name="email")
    private String email;

    public Fornitore () {}

    

    public Fornitore(Long id, String ragione_sociale, String indirizzo, String telefono, String email) {
        this.id = id;
        this.ragione_sociale = ragione_sociale;
        this.indirizzo = indirizzo;
        this.telefono = telefono;
        this.email = email;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public String toString() {
        return "Fornitore [id=" + id + ", ragione_sociale=" + ragione_sociale + ", indirizzo=" + indirizzo
                + ", telefono=" + telefono + ", email=" + email + "]";
    }

    
    


}
