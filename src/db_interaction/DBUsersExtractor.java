package db_interaction;

/**
 * Diese Klasse stellt mehrere Filterfunktionen bereit, die das Auslesen der Daten aus der Users-Datenbank nach
 * bestimmten Kriterien (nach Nutzername, Passwort, etc.) ermöglichen.
 */
public class DBUsersExtractor {

    //Filter-Algorithmus:
    //1. In Zeile 1 iterieren bis Spalte personnel_id gefunden (nihct einfach Spalte angeben, weil sich in der DB theoretisch die Spaltenanordnung ändern kann)
    //2. In dieser Spalte iterieren bis gesuchte personnel_id gefunden wurde
    //3. Diese Zeile merken, dann in 1. Zeile iterieren bis Spalte password gefunden (kann auch in Schritt 1 schon gemerkt werden)--> auch merken
    //4. Mit diesen beiden Werten Passwort-Zelle von betroffenem personnel (mit personnel_id) mit Passwort abgleichen

    /**
     * Diese Methode filtert die Tupel heraus, für die das Kriterium zutrifft
     * 
     * @param columnName
     * @param filterValue
     */
    public void filterDBRow(String columnName, Object filterValue){
        //da mehrere Tupel zu dem Filterkriterium existieren können, muss eine Liste (HashMap) mit den verschiedenen Usern erstellt werden
    }
}