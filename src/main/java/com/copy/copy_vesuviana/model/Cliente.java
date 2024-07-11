package com.copy.copy_vesuviana.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name="ragione_sociale")
    private String ragione_sociale;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="indirizzo_id", referencedColumnName = "id")
    private Indirizzo indirizzo;

    @Column(name="p_iva")
    private String pIva;

    @Column(name="email", unique = true)
    private String email;

    @Column(name="telefono")
    private String telefono;

    @Column(name="contratto")
    private Boolean contratto;

    @Column(name="alias")
    private String alias;

    @OneToMany(mappedBy = "cliente")
    private Set<Macchina> macchina = new HashSet<>();
    
    public Cliente(){}

    

    public Cliente(Long id, String ragione_sociale, Indirizzo indirizzo, String pIva, String email, String telefono,
            Boolean contratto, String alias, Set<Macchina> macchina) {
        this.id = id;
        this.ragione_sociale = ragione_sociale;
        this.indirizzo = indirizzo;
        this.pIva = pIva;
        this.email = email;
        this.telefono = telefono;
        this.contratto = contratto;
        this.alias = alias;
        this.macchina = macchina;
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
    
    public Indirizzo getIndirizzo() {
        return indirizzo;
    }
    
    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }
    
    public Set<Macchina> getMacchina() {
        return macchina;
    }

    public void setMacchina(Set<Macchina> macchina) {
        this.macchina = macchina;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", ragione_sociale=" + ragione_sociale + ", indirizzo=" + indirizzo + ", pIva="
                + pIva + ", email=" + email + ", telefono=" + telefono + ", contratto=" + contratto + ", alias=" + alias
                + ", macchina=" + macchina + "]";
    }
    
    
}
