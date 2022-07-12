# LoggerProject
## Introduction 
Ceci est un prototype de service de log écrit en Java.
Un logger est reparti sur différents niveaux :
- Debug
- Info
- Warn
- Critical
- Fatal

Les messages du log peuvent être sauvegardées dans un fichier ou bien affichées dans la console. Les messages dans ce cas seront coloriés d'une manière adéquate qui permet d'identifier facilement le type de message.

Si la taille du fichier log dépasse la limite prédéfini, il sera alors comprimé dans une archive tar.gz et un nouveau fichier sera créé.

## Installation

```
nvm package 
```

## Exécution
```
java -classpath "target/classes" Main
```
