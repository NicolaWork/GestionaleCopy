package com.copy.copy_vesuviana.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="fornitore")
public class Fornitore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="ragione_sociale", unique = true)
    private String ragioneSociale;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="indirizzo_id", referencedColumnName = "id")
    private Indirizzo indirizzo;

    @Column(name="telefono")
    private String telefono;

    @Column(name="email", unique = true)
    private String email;

    public Fornitore () {}


    public Fornitore(Long id, String ragioneSociale, Indirizzo indirizzo, String telefono, String email) {
        this.id = id;
        this.ragioneSociale = ragioneSociale;
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

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
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
        return "Fornitore [id=" + id + ", ragioneSociale=" + ragioneSociale + ", indirizzo=" + indirizzo
                + ", telefono=" + telefono + ", email=" + email + "]";
    }



    public Indirizzo getIndirizzo() {
        return indirizzo;
    }



    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    
    


}
