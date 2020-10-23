# ATdIT_Gruppe5
GitHub Repository für Gruppe 5 (Aktuelle Themen der IT 1)

**Alle bewertungsrelevanten Files liegen im master-Branch.**

## Ordnerstruktur
&#x1F4D8; **01April_Aufgabe1** beinhaltet die Prototypen der Gruppenmitglieder (bzgl. Aufgabe der 1. Vorlesung)  

&#x1F4D8; **01April_Aufgabe2** beinhaltet den gemeinsamen Prototypen der Gruppe (bzgl. Aufgabe der 1. Vorlesung)

&#x1F4D8; **databases** beinhaltet folgende Datenbanken:
+ "XYZ.xlsx" sind die originalen Datenbanken, die im Coding selbst nicht genutzt werden und damit nur als Backup dienen.
+ "DefaultXYZ.xlsx" sind die Datenbanken, die der reinen Datenextraktion dienen.

&#x1F4D8; **Library** beinhaltet folgendende Ordner und Dateien:
+ **diagrams** &rarr; ER-Diagramm, Klassendiagramm, Codeablaufplan (PAP)
+ **documentation**  &rarr; Wissenschaftliche Ausarbeitung, Storyline-Dokument, javadoc 
+ **images** &rarr; genutzte Bilder
+ **prototype** &rarr; Prototyp der Anwendung
+ genutzte, externe Bibliotheken als .jar-Files &rarr; müssen dem Klassenpfad hinzugefügt werden

&#x1F4D8; **src** beinhaltet den Quellcode gegliedert in folgende Subordner:
+ **main** (enthält: Ausführungsklasse und erste UI-aufbauende Klassen; "Stylesheet-Klasse")
+ **panels** (enthält: Hauptpanelscreens, die die Anwendung annehmen kann)
+ **subpanels** (enthält: Panels, die von den Hauptpanels genutzt werden)
+ **dialogs** (enthält: Dialogscreens, die die Interaktion mit dem Benutzer erlaubt)
+ **listener** (enthält: Listenerklassen)
+ **exceptions** (enthält: Eigene Exceptionklassen)
+ **db_interaction** (enthält: Klassen, die die Interaktion mit den Datenbanken regeln)
+ **test** (enthält: Unit-Tests zu den obigen Klassen)

## How to...
+ "src/main/AppRunner.java": diese Klasse ist die ausführbare Klasse (enthält main-Methode), von der aus die Programmausführung gestartet wird.
+ "ATdIT_Gruppe5.jar": Ausführbare Datei für Anwendung

## Erklärungen
<code>.gitignore</code>: Wie der Name schon sagt, werden die in diesem Dokument gelisteten Files von GitHub ignoriert
<code>ATdIT_Gruppe5.jar</code>: Diese Datei kann durch Öffnen automatisch die gesamte Anwendung (ohne weitere Einstellungen) ausführen.

## Hinweise
+ bei Warnungen im Editor, "nicht auffindbare" Files einmal öffnen --> Meldungen gehen weg (oder: über VSCode-Extension "Language Support for Java(TM) by Red Hat" "java clean" in Command Pallette ausführen)
+ werden Libraries nicht gefunden, überprüfen, ob die .jar-Bibliotheken im Ordner Library dem Classpath hinzugefügt sind
  + in VSCODE: links unten über referenced libraries oder vscode.settings-File
  + in Eclipse: über Build Path
