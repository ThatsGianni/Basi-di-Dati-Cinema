# Basi-di-Dati-Cinema

Il progetto è una piccolo esempio di realizzazione di una Base di Dati per la prenotazione di un biglietto al cinema.
Sarà possibile effettuare una prenotazioni nei vari cinema accreditati,
all’utente sarà richiesto di registrarsi per effettuare quest’operazione.
Viene fornito agli amministratori la facoltà di gestire le programmazioni
e inserire nuovi film, cinema e sale, inoltre è possibile da quest’ultimo
visualizzare i biglietti acquistati precedentemente in modo da poter
rintracciare i clienti qual ora ce ne fosse bisogno.

[Nel dettaglio]

Amministratore:
• [Inserire una programmazione.]
• [Inserire nuovi film.]
• [Inserire cinema e sale.]
• [Visualizzazione biglietti venduti in precedenza]
• [Visualizzazione vendite di eventi non ancora terminati]
Utente:
• [Registrazione/Login]
• [Prenotazione biglietto e scelta posto libero.]
• [Cancellazione prenotazione.]
• [Visualizzazione delle programmazioni e dei cinema accreditati.]
Operazioni Batch:
• [Cancellazioni delle programmazioni terminate.]
• [Registrazioni dei biglietti di precedenti proiezioni.]
• [Cancellazioni di biglietti di proiezioni precedenti.]


[Mapping dello schema er]

-UTENTI (username, nome, cognome, e-mail)
-CONSULTAZIONI (username: UTENTI, cod_prog: PROGRAMMAZIONI)
-PROGRAMMAZIONI (cod_prog, data, prezzo, id_film: FILM, cod_sala: SALE,data_inizio_disp,data_fine_disp)
-FILM (Id_film, nome, anno, durata, recensione, distributore, genere, Paese,id_regista: REGISTI)
-REGISTI (id_regista, cognome, nome)
-ATTORI (id_attore, cognome, nome)
-RECITAZIONI (Id_film: FILM, id_attore: ATTORI)
-CINEMA (id_cinema, nome, indirizzo, città, nazione, numero_sale)
-TELEFONI (numero, id_cinema: CINEMA)
-SALE (cod_sala, nums, superficie, capienza, id_cinema: CINEMA)
-POSTI (cod_posto, num_fila, num_colonne, cod_sala: SALE)
-BIGLIETTI (id_biglietto, data_emissione, username: UTENTE, cod_posto: POSTI,cod_prog:PROGRAMMAZIONI)
