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

    @Column(name="ragione_sociale", unique = true)
    private String ragioneSociale;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="indirizzo_id", referencedColumnName = "id")
    private Indirizzo indirizzo;

    @Column(name="p_iva", unique = true)
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


    public Cliente(Long id, String ragioneSociale, Indirizzo indirizzo, String pIva, String email, String telefono,
            Boolean contratto, String alias, Set<Macchina> macchina) {
        this.id = id;
        this.ragioneSociale = ragioneSociale;
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

    public String getRagioneSociale() {
        return ragioneSociale;
    }
    
    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
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


    public String getpIva() {
        return pIva;
    }



    public void setpIva(String pIva) {
        this.pIva = pIva;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public String getTelefono() {
        return telefono;
    }



    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }



    public Boolean getContratto() {
        return contratto;
    }



    public void setContratto(Boolean contratto) {
        this.contratto = contratto;
    }



    public String getAlias() {
        return alias;
    }



    public void setAlias(String alias) {
        this.alias = alias;
    }


    @Override
    public String toString() {
        return "Cliente [id=" + id + ", ragioneSociale=" + ragioneSociale + ", indirizzo=" + indirizzo + ", pIva="
                + pIva + ", email=" + email + ", telefono=" + telefono + ", contratto=" + contratto + ", alias=" + alias
                + ", macchina=" + macchina + "]";
    }
    

    
    
}
