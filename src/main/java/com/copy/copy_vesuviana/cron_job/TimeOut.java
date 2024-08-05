package com.copy.copy_vesuviana.cron_job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.copy.copy_vesuviana.model.Macchina;
import com.copy.copy_vesuviana.repository.MacchinaRepository;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class TimeOut {

    @Autowired
    private MacchinaRepository macchinaRepository;

    @Scheduled(cron = "0 0 0 * * ?") // Esegue ogni giorno a mezzanotte
    public void verificaAvvisi() {
        List<Macchina> macchine = macchinaRepository.findAll();
        LocalDate today = LocalDate.now();
        
        // TODO: aggiungere filtro per contratto attivo

        for (Macchina macchina : macchine) {
            LocalDate dataAcquisto = macchina.getDataAcquisto();
            LocalDate dataUltimoAvviso = macchina.getDataUltimoAvviso();
            

            if (dataAcquisto != null) {
                // Se non esiste una data di ultimo avviso, considera la data di acquisto
                LocalDate dataUltimoAvvisoConsiderata = (dataUltimoAvviso != null) ? dataUltimoAvviso : dataAcquisto;
                Period period = Period.between(dataUltimoAvvisoConsiderata, today);

                // Verifica se sono trascorsi sei mesi o più dall'ultimo avviso
                if (period.toTotalMonths() >= 6) {
                    inviaAvviso(macchina);
                    // Aggiorna la data dell'ultimo avviso
                    macchina.setDataUltimoAvviso(today);
                    macchinaRepository.save(macchina); // Salva le modifiche nel database
                }
            }
        }
    }

    private void inviaAvviso(Macchina macchina) {
        // TODO:Logica per inviare l'avviso
        System.out.println("Invio avviso per la macchina con matricola: " + macchina.getMatricola());
    }
    
}
