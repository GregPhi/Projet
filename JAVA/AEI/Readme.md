Projet AEI : version 3
----------------------

Projet réalisé par :
  * Philippot Grégoire

### Outils utilisés

  * Eclipse
  * Librairie Jackson
  * Swing

### But du projet

Permettre au conseil d'administration de l'Association des Etudiants en Informatique de l'Université de Lille (FST), de :
  * gérer leurs membres (afficher, ajouter, supprimer), sauvegarder dans le fichier file/membres.json
  * gérer l'organisation d'une tombola (affichage, ajout, suppression d'un participant et d'un lot), sauvegarder dans le fichier file/tombola.json et les participants sont sauvegardés dans file/participants.json
  * gérer un calendrier de l'avent

### Utilisation

*Compilation*

Deux options sont possibles afin de compiler le projet :
  * en ouvrant l'éditeur Eclipse que vous utilisez, puis en faisant clique droit sur le projet afin de l'exporter en fichier jar
  * ou grâce à la commande $ mvn package

*Exécution*

$ java -jar {fichier jar du projet créé} {option}

{option} :
  * 
