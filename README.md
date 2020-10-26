# ATdIT_Gruppe5

GitHub Repository für Gruppe 5 (Aktuelle Themen der IT 1)

**Alle bewertungsrelevanten Files liegen im master-Branch.**

## Ordnerstruktur

&#x1F4D8; **Library** beinhaltet folgendende Ordner und Dateien:

- **diagrams** &rarr; ER-Diagramme, Klassendiagramm (UML), Grafik zum Durchlauf der Klassen
- **documentation** &rarr; Wissenschaftliche Ausarbeitung, Storyline-Dokument (Probleme, Lessons Learned), Quellensammlung, Info zu Setter für Order-ID und User-ID
- **prototype** &rarr; Prototyp der Anwendung

&#x1F4D8; **group5** : Maven-Projektordner und beinhaltet gegliedert in folgende Subordner den Quellcode und konfiguratorische Dateien (_pom.xml_, _.classpath_ u.ä. hier nicht aufgelistet):

- **src/main/java/atdit1/group5**

  - **\*/mainclasses** (enthält: Ausführungsklasse und primäre UI-aufbauende Klassen)
  - **\*/db_interaction** (enthält: Klassen, die die Interaktion mit den Datenbanken regeln)
  - **\*/dialogs** (enthält: Dialogscreens, die die Interaktion mit dem Benutzer erlaubt)
  - **\*/exceptions** (enthält: Eigene Exceptionklassen)
  - **\*/listener** (enthält: Listenerklassen)
  - **\*/panels** (enthält: Hauptpanelscreens, die die Anwendung annehmen kann)
  - **\*/subpanels** (enthält: Panels, die von den Hauptpanels genutzt werden)
  - **\*/verifiers** (enthält: Verifier zur Überprüfung der Eingabe-Validität)
    &nbsp;

- **src/main/resources** (enthält: Ressourcen, die im Coding genutzt werden)

  - **\*/databases** (enthält: Datenbanken)
    - "_XYZ.xlsx_" sind die Datenbanken, die im Coding selbst nicht genutzt werden und damit nur als Backup dienen.
    - "_DefaultXYZ.xlsx_" sind die Datenbanken, die auch produktiv im Coding genutzt werden.
  - **\*/i18n** (enthält: Strings zur Internationalisierung)
  - **\*/images** (enthält: Bilddateien)
    &nbsp;

- **src/test/java** (enthält: JUnit-Testklassen zu den Klassen in "**src/main/\***")
  &nbsp;

- **src/test/resources** (enthält: nichts; ist aber für mögliche Testressourcen erstellt)
  &nbsp;

## How to...

- "**src/main/java/atdit1/group5/AppRunner.java**": diese Klasse ist die ausführbare Klasse (enthält main-Methode), von der aus die Programmausführung gestartet wird.

## Hinweise

- bei Warnungen im Editor, "nicht auffindbare" Files einmal öffnen --> Meldungen gehen weg (oder: über VSCode-Extension "Language Support for Java(TM) by Red Hat" "java clean" in Command Pallette ausführen)
