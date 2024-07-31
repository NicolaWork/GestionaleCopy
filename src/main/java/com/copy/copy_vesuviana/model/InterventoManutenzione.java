package com.copy.copy_vesuviana.model;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "intervento_manutenzione")
public class InterventoManutenzione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_intervento")
    private LocalDate dataIntervento;

    @Column(name = "descrizione")
    private String descrizione;

    @ManyToOne
    @JoinColumn(name = "macchina_id", nullable = true)
    private Macchina macchina;

    @ManyToOne
    @JoinColumn(name = "bnr_id", nullable = true)
    private Bnr bnr;

    @ManyToOne
    @JoinColumn(name = "cls_id", nullable = true)
    private Cls cls;

    @ManyToOne
    @JoinColumn(name = "riciclatore_id", nullable = true)
    private Riciclatore riciclatore;

    public InterventoManutenzione() {}

    public InterventoManutenzione(LocalDate dataIntervento, String descrizione, Macchina macchina, Bnr bnr, Cls cls, Riciclatore riciclatore) {
        this.dataIntervento = dataIntervento;
        this.descrizione = descrizione;
        this.macchina = macchina;
        this.bnr = bnr;
        this.cls = cls;
        this.riciclatore = riciclatore;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataIntervento() {
        return dataIntervento;
    }

    public void setDataIntervento(LocalDate dataIntervento) {
        this.dataIntervento = dataIntervento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Macchina getMacchina() {
        return macchina;
    }

    public void setMacchina(Macchina macchina) {
        this.macchina = macchina;
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
        return "InterventoManutenzione [id=" + id + ", dataIntervento=" + dataIntervento + ", descrizione="
                + descrizione + ", macchina=" + macchina + ", bnr=" + bnr + ", cls=" + cls + ", riciclatore="
                + riciclatore + "]";
    }

    
}
