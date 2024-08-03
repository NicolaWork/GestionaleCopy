-- Inserimento dati nella tabella 'indirizzo'
INSERT INTO indirizzo (strada, provincia, paese, cap) VALUES
('Via Roma, 1', 'RM', 'Italia', '00100'),
('Corso Vittorio, 10', 'MI', 'Italia', '20100'),
('Via Garibaldi, 3', 'TO', 'Italia', '10100'),
('Piazza Duomo, 5', 'FI', 'Italia', '50100'),
('Via Dante, 7', 'NA', 'Italia', '80100'),
('Via Verdi, 9', 'VE', 'Italia', '30100'),
('Corso Italia, 11', 'BO', 'Italia', '40100'),
('Via Mazzini, 13', 'GE', 'Italia', '16100'),
('Via Manzoni, 15', 'PA', 'Italia', '90100'),
('Piazza San Marco, 17', 'VE', 'Italia', '30124'),
('Via Colombo, 19', 'CA', 'Italia', '09100');

-- Inserimento dati nella tabella 'fornitore'
INSERT INTO fornitore (ragione_sociale, indirizzo_id, telefono, email) VALUES
('Fornitore S.p.A.', 1, '0123456789', 'fornitore@example.com'),
('Fornitore 2 S.r.l.', 2, '0987654321', 'fornitore2@example.com'),
('Fornitore 3 S.p.A.', 3, '0234567891', 'fornitore3@example.com'),
('Fornitore 4 S.r.l.', 4, '0345678912', 'fornitore4@example.com'),
('Fornitore 5 S.p.A.', 5, '0456789123', 'fornitore5@example.com'),
('Fornitore 6 S.r.l.', 6, '0567891234', 'fornitore6@example.com'),
('Fornitore 7 S.p.A.', 7, '0678912345', 'fornitore7@example.com'),
('Fornitore 8 S.r.l.', 8, '0789123456', 'fornitore8@example.com'),
('Fornitore 9 S.p.A.', 9, '0891234567', 'fornitore9@example.com'),
('Fornitore 10 S.r.l.', 10, '0912345678', 'fornitore10@example.com'),
('Fornitore 11 S.p.A.', 11, '0123456789', 'fornitore11@example.com');

-- Inserimento dati nella tabella 'cliente'
INSERT INTO cliente (ragione_sociale, indirizzo_id, p_iva, email, telefono, contratto, alias) VALUES
('Cliente S.p.A.', 1, '12345678901', 'cliente@example.com', '0123456789', TRUE, 'Alias Cliente 1'),
('Cliente 2 S.r.l.', 2, '10987654321', 'cliente2@example.com', '0987654321', FALSE, 'Alias Cliente 2'),
('Cliente 3 S.p.A.', 3, '22345678901', 'cliente3@example.com', '1123456789', TRUE, 'Alias Cliente 3'),
('Cliente 4 S.r.l.', 4, '20987654321', 'cliente4@example.com', '1987654321', FALSE, 'Alias Cliente 4'),
('Cliente 5 S.p.A.', 5, '32345678901', 'cliente5@example.com', '2123456789', TRUE, 'Alias Cliente 5'),
('Cliente 6 S.r.l.', 6, '30987654321', 'cliente6@example.com', '2987654321', FALSE, 'Alias Cliente 6'),
('Cliente 7 S.p.A.', 7, '42345678901', 'cliente7@example.com', '3123456789', TRUE, 'Alias Cliente 7'),
('Cliente 8 S.r.l.', 8, '40987654321', 'cliente8@example.com', '3987654321', FALSE, 'Alias Cliente 8'),
('Cliente 9 S.p.A.', 9, '52345678901', 'cliente9@example.com', '4123456789', TRUE, 'Alias Cliente 9'),
('Cliente 10 S.r.l.', 10, '50987654321', 'cliente10@example.com', '4987654321', FALSE, 'Alias Cliente 10'),
('Cliente 11 S.p.A.', 11, '62345678901', 'cliente11@example.com', '5123456789', TRUE, 'Alias Cliente 11');

-- Inserimento dati nella tabella 'bnr'
INSERT INTO bnr (matricola, modello, assistenza, fornitore_id) VALUES
('B12345', 'Modello BNR1', TRUE, 1),
('B67890', 'Modello BNR2', FALSE, 2),
('B23456', 'Modello BNR3', TRUE, 3),
('B78901', 'Modello BNR4', FALSE, 4),
('B34567', 'Modello BNR5', TRUE, 5),
('B89012', 'Modello BNR6', FALSE, 6),
('B45678', 'Modello BNR7', TRUE, 7),
('B90123', 'Modello BNR8', FALSE, 8),
('B56789', 'Modello BNR9', TRUE, 9),
('B01234', 'Modello BNR10', FALSE, 10),
('B67891', 'Modello BNR11', TRUE, 11);

-- Inserimento dati nella tabella 'cls'
INSERT INTO cls (matricola, modello, assistenza, fornitore_id) VALUES
('C12345', 'Modello CLS1', TRUE, 1),
('C67890', 'Modello CLS2', FALSE, 2),
('C23456', 'Modello CLS3', TRUE, 3),
('C78901', 'Modello CLS4', FALSE, 4),
('C34567', 'Modello CLS5', TRUE, 5),
('C89012', 'Modello CLS6', FALSE, 6),
('C45678', 'Modello CLS7', TRUE, 7),
('C90123', 'Modello CLS8', FALSE, 8),
('C56789', 'Modello CLS9', TRUE, 9),
('C01234', 'Modello CLS10', FALSE, 10),
('C67891', 'Modello CLS11', TRUE, 11);

-- Inserimento dati nella tabella 'riciclatore'
INSERT INTO riciclatore (matricola, modello, assistenza, fornitore_id) VALUES
('R12345', 'Modello Ric1', TRUE, 1),
('R67890', 'Modello Ric2', FALSE, 2),
('R23456', 'Modello Ric3', TRUE, 3),
('R78901', 'Modello Ric4', FALSE, 4),
('R34567', 'Modello Ric5', TRUE, 5),
('R89012', 'Modello Ric6', FALSE, 6),
('R45678', 'Modello Ric7', TRUE, 7),
('R90123', 'Modello Ric8', FALSE, 8),
('R56789', 'Modello Ric9', TRUE, 9),
('R01234', 'Modello Ric10', FALSE, 10),
('R67891', 'Modello Ric11', TRUE, 11);

-- Inserimento dati nella tabella 'macchina'
INSERT INTO macchina (matricola, modello, data_acquisto, cliente_id, bnr_id, cls_id, riciclatore_id, fornitore_id) VALUES
('M12345', 'Modello Mac1', '2023-01-01', 1, 1, NULL, NULL, 1),
('M67890', 'Modello Mac2', '2023-06-01', 2, NULL, 1, NULL, 2),
('M23456', 'Modello Mac3', '2023-02-01', 3, 3, NULL, NULL, 3),
('M78901', 'Modello Mac4', '2023-07-01', 4, NULL, 3, NULL, 4),
('M34567', 'Modello Mac5', '2023-03-01', 5, 5, NULL, NULL, 5),
('M89012', 'Modello Mac6', '2023-08-01', 6, NULL, 5, NULL, 6),
('M45678', 'Modello Mac7', '2023-04-01', 7, 7, NULL, NULL, 7),
('M90123', 'Modello Mac8', '2023-09-01', 8, NULL, 7, NULL, 8),
('M56789', 'Modello Mac9', '2023-05-01', 9, 9, NULL, NULL, 9),
('M01234', 'Modello Mac10', '2023-10-01', 10, NULL, 9, NULL, 10),
('M67891', 'Modello Mac11', '2023-11-01', 11, 11, NULL, NULL, 11);

-- Inserimento dati nella tabella 'intervento_manutenzione'
INSERT INTO intervento_manutenzione (data_intervento, descrizione, macchina_id, bnr_id, cls_id, riciclatore_id) VALUES
('2023-07-01', 'Sostituzione pezzo A', 1, 1, NULL, NULL),
('2023-08-01', 'Controllo generale', 2, NULL, 1, NULL),
('2023-09-01', 'Riparazione motore', 3, 3, NULL, NULL),
('2023-10-01', 'Verifica sistema idraulico', 4, NULL, 3, NULL),
('2023-11-01', 'Sostituzione batteria', 5, 5, NULL, NULL),
('2023-12-01', 'Manutenzione preventiva', 6, NULL, 5, NULL),
('2023-01-01', 'Aggiornamento software', 7, 7, NULL, NULL),
('2023-02-01', 'Pulizia interna', 8, NULL, 7, NULL),
('2023-03-01', 'Verifica sospensioni', 9, 9, NULL, NULL),
('2023-04-01', 'Sostituzione filtro olio', 10, NULL, 9, NULL),
('2023-05-01', 'Riparazione circuito elettrico', 11, 11, NULL, NULL);

-- Inserimento dati nella tabella 'lista_spostamenti'
INSERT INTO lista_spostamenti (note, data) VALUES
('Nota di spostamento 1', '2023-09-01'),
('Nota di spostamento 2', '2023-10-01'),
('Nota di spostamento 3', '2023-11-01'),
('Nota di spostamento 4', '2023-12-01'),
('Nota di spostamento 5', '2024-01-01'),
('Nota di spostamento 6', '2024-02-01'),
('Nota di spostamento 7', '2024-03-01'),
('Nota di spostamento 8', '2024-04-01'),
('Nota di spostamento 9', '2024-05-01'),
('Nota di spostamento 10', '2024-06-01'),
('Nota di spostamento 11', '2024-07-01');

-- Inserimento dati nelle tabelle relazionali di 'lista_spostamenti'
-- Per la tabella 'lista_spostamenti_cliente'
INSERT INTO lista_spostamenti_cliente (lista_spostamenti_id, cliente_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(11, 11);

-- Per la tabella 'lista_spostamenti_cls'
INSERT INTO lista_spostamenti_cls (lista_spostamenti_id, cls_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(11, 11);

-- Per la tabella 'lista_spostamenti_bnr'
INSERT INTO lista_spostamenti_bnr (lista_spostamenti_id, bnr_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(11, 11);

-- Per la tabella 'lista_spostamenti_riciclatore'
INSERT INTO lista_spostamenti_riciclatore (lista_spostamenti_id, riciclatore_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(11, 11);

-- Per la tabella 'lista_spostamenti_macchina'
INSERT INTO lista_spostamenti_macchina (lista_spostamenti_id, macchina_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(11, 11);
