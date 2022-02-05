# BookYourTicket

Il progetto è una piccolo esempio di realizzazione di una Base di Dati per la prenotazione di un biglietto al cinema.
Sarà possibile effettuare una prenotazioni nei vari cinema accreditati,
all’utente sarà richiesto di registrarsi per effettuare quest’operazione.
Viene fornito agli amministratori la facoltà di gestire le programmazioni
e inserire nuovi film, cinema e sale, inoltre è possibile da quest’ultimo
visualizzare i biglietti acquistati precedentemente in modo da poter
rintracciare i clienti qual ora ce ne fosse bisogno.

[Nel dettaglio]

La parte di persistenza dell'applicazione è stata realizzata con MySQL e si tratta di un Database di tipo relazionare.
Per l'applicazione invece è stato utilizzato Java come tecnlogia e la libreria JDBC per creare la connessione al database per effettuare operazioni CRUD.

Amministratore:
<ul><li>[Inserire una programmazione.]</li>
<li>[Inserire nuovi film]</li>
<li> [Inserire cinema e sale]</i>
<li>[Visualizzazione biglietti venduti in precedenza]</li>
<li> [Visualizzazione vendite di eventi non ancora terminati]</li></ul>

Utente:
 <ul><li>[Registrazione/Login]
<li>[Prenotazione biglietto e scelta posto libero.]</li>
<li>[Cancellazione prenotazione]</li>
<li>[Visualizzazione delle programmazioni e dei cinema accreditati.]</li></ul>

Operazioni Batch:
<ul><li>[Cancellazioni delle programmazioni terminate]</li>
<li> [Registrazioni dei biglietti di precedenti proiezioni]</li>
<li>[Cancellazioni di biglietti di proiezioni precedenti.]</ul>


[Mapping dello schema er]

<ol><li>UTENTI (username, nome, cognome, e-mail)</li>
<li>CONSULTAZIONI (username: UTENTI, cod_prog: PROGRAMMAZIONI)</li>
<li>PROGRAMMAZIONI (cod_prog, data, prezzo, id_film: FILM, cod_sala: SALE,data_inizio_disp,data_fine_disp)</li>
<li>FILM (Id_film, nome, anno, durata, recensione, distributore, genere, Paese,id_regista: REGISTI)</li>
<li>REGISTI (id_regista, cognome, nome)</li>
<li>ATTORI (id_attore, cognome, nome)</li>
<li>RECITAZIONI (Id_film: FILM, id_attore: ATTORI)</li>
<li>CINEMA (id_cinema, nome, indirizzo, città, nazione, numero_sale)</li>
<li>TELEFONI (numero, id_cinema: CINEMA)</li>
<li>SALE (cod_sala, nums, superficie, capienza, id_cinema: CINEMA)</li>
<li>POSTI (cod_posto, num_fila, num_colonne, cod_sala: SALE)</li>
<li>BIGLIETTI (id_biglietto, data_emissione, username: UTENTE, cod_posto: POSTI,cod_prog:PROGRAMMAZIONI).</li></ol>
