# BookYourTicket🎫

🎥The project is a small example of the creation of a database for booking a cinema ticket. It will be possible to make reservations in the various accredited cinemas, the user will be required to register to carry out this operation. Administrators are given the ability to manage schedules and insert new films, cinemas and theaters, and it is also possible for the latter to view tickets purchased previously so that customers can be traced back when needed.

<h2>[Details]📜</h2>

<p>The persistence part of the application was created with MySQL and it is a relational database.
For the logical part, on the other hand, Java was used as a technology and the JDBC library to create the connection to the database to perform CRUD operations.</p>

<h3>Administrator:</h3>
<ul> <li> [Enter a schedule.] </li>
<li> [Insert new movies] </li>
<li> [Insert cinemas and theaters] </i>
<li> [View Previously Sold Tickets] </li>
<li> [View sales of unfinished events] </li> </ul>

<h3>User:</h3>
<ul> <li> [Registration / Login]
<li> [Ticket reservation and choice of free seat.] </li>
<li> [Cancellation of reservation] </li>
<li> [Display of programs and accredited cinemas.] </li> </ul>

<h3>Batch operations:</h3>
<ul> <li> [Schedule cancellations finished] </li>
<li> [Ticket cancellations from previous screenings.] </ul>


<h2>[Mapping]🗄️</h2>

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

<h2>[Technologies used]⌨️</h2>
<ul><li><a href="https://www.oracle.com/java/technologies/javase/11-relnotes.html">Java™ SE Development Kit </a></li><br>
<li><a href="https://dev.mysql.com/doc/relnotes/mysql/8.0/en/news-8-0-28.html">MySQL 8.0</a></li>
