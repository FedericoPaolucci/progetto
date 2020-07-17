# Progetto Esame Retweets

L'applicazione, creata con Spring Boot, è una REST API che, grazie alle chiamate effettuate con un client (per esempio Postman) fornisce metadati,dati e statistiche sulle frequenze delle menzioni presenti nei retweet.

All'avvio, viene scaricato un json attraverso l'API di twitter "https://api.twitter.com/1.1/statuses/retweets_of_me.json" (in questo caso l'indirizzo non è questo ma viene usato un proxy che rimanda a quelle ufficiali), viene salvato localmente in un file .json e viene eseguito il parsing.
Con il parsing viene creato un ArrayList di oggetti Proprieties che rappresenta tutti i tweets retwittati dell'utente con le relative informazioni.

Per ottenere un json più completo ho inserito subito dopo il Resource URL scritto sopra, la seguente stringa: 

"?include_entities=true&tweet_mode=extended&count=50"

* *include_entities* è uguale a "true" poichè nel json voglio vedere hashtags utilizzati e, soprattutto, le menzioni scritte nel corpo del retweet.
* *tweet_mode* è uguale ad "extended" perchè nelle impostazioni di default delle api di twitter, il testo viene troncato dopo 140 caratteri. In questo modo il testo del retweet viene visualizzato fino al 280esimo carattere e "text" nel json viene sostituito con "full_text". Questa modifica è utile per visualizzare correttamente tutte le menzioni.
* *count* è impostato a 50 per visualizzare i primi 50 retweets. Di default è impostato a 20.


## Richieste

Si possono effettuare le seguenti richieste:

**GET/metadata**: restituisce, in formato json, i metadati più significativi di un retweet ovvero gli alias utilizzati, da dove proviene e il tipo di un certo attributo.

**GET/data**: restituisce, in formato json, tutti i retweets dell'utente autenticato.

**GET/stats**: restituisce, in formato json, una lista di tutte le menzioni effettuate dall'utente autenticato con accanto il numero di volte in cui queste appaiono negli ultimi 50 retweets. Inoltre viene restituito anche il numero di volte in cui è stato rilevato un retweet senza menzione. 

<img src="https://github.com/FedericoPaolucci/progetto/blob/master/UseCase.jpg" alt="UseCaseDiagram" width="500" height="500">

Il software Postman permette di eseguire richieste al server locale associato all'indirizzo http://localhost:8080.

## Programma


### Packages e classi
<img src="https://github.com/FedericoPaolucci/progetto/blob/master/Diagramma%20classi.jpg" alt="UseCaseDiagram" width="1000" height="750">


In totale i packages sono 5:
* *com.project.EsameProgettoTwitter* contiene la classe "EsameProgettoTwitterApplication" che contiene il main e che quindi avvia Spring.
* *com.project.EsameProgettoTwitter.controller* contiene la classe "ControllerClass" che si occupa di gestire le chiamate effettuate dall'utente.
* *com.project.EsameProgettoTwitter.retweets* contiene la classe "RetweetsClass" che si occupa di gestire ciò che ha a che fare con il json che scarichiamo. Infatti al suo interno abbiamo l'operazione che effettua il download del json e le operazioni che ritornano l'ArrayList di Metadati e l'Arraylist dei Dati quando vengono richiesti.
* *com.project.EsameProgettoTwitter.model* contiene le classi "Metadata" e "Proprieties" che servono per costruire ArrayList di Oggetti Metadata e Proprieties.
* *com.project.EsameProgettoTwitter.service* contiene le classi "Parser" e "CalcStats". Il primo si occupa di effettuare il parsing del json scaricato, organizzando i retweets e salvando le proprietà più rilevanti di essi. "CalcStats" invece si occupa di creare una mappa che mostra tutte le menzioni fatte dall'utente autenticato con la loro frequenza.


## Sequence Diagrams
I seguenti diagrammi mostrano il funzionamento del programma.


### GET/metadata
<img src="https://github.com/FedericoPaolucci/progetto/blob/master/Sequence%20Diagram%20GetMetadata.jpg" alt="UseCaseDiagram" width="900" height="500">


### GET/data
<img src="https://github.com/FedericoPaolucci/progetto/blob/master/Sequence%20Diagram%20GetData.jpg" alt="UseCaseDiagram" width="900" height="400">


### GET/stats
<img src="https://github.com/FedericoPaolucci/progetto/blob/master/Sequence%20Diagram%20GetStats.jpg" alt="UseCaseDiagram" width="900" height="600">


## Autore
**Federico Paolucci**
