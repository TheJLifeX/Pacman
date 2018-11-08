package de.fh.suche;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import de.fh.heuristicalSearch.HeuristicSearch;
import de.fh.pacman.PacmanPercept;
import de.fh.pacman.enums.PacmanAction;
import de.fh.pacman.enums.PacmanTileType;
import de.fh.util.Vector2;

/**
 * Created by daniel on 22.09.16.
 * Generische Klasse f�r unsere Suchalgorithmen
 */
public abstract class Suche {

    public enum Suchstrategie{TIEFENSUCHE, BREITENSUCHE, DIJKSTAR, BESTENSUCHE, ASTERN}

    private Knoten zielKnoten;
    private PacmanPercept pacmanPercept;

     //In der Openlist befinden sich die zu expandierenden Knoten
    protected List<Knoten> openList;

    //In der Closelist befinden sich die bereits expandierenten Knoten als Hashwert um Loops verhindern
    protected HashSet<Integer> closedList;

    private int countSysout = 0;


    public Suche(PacmanPercept pacmanPercept, Knoten zielKnoten){
        this.zielKnoten = zielKnoten;
        this.pacmanPercept = pacmanPercept;

        openList = new LinkedList<>();
        closedList = new HashSet<Integer>();
    }

    /**
     * Ist die Suche f�ndig geworden, gibt die start-Methode den gefundenen Zielknoten zur�ck,
     * �ber den man sich dann wiederum die entsprechenden Actions (vom Start zum bis zum Ziel),
     * �ber eine entsprechende Methode, holen kann
     *
     * @return Ziel Knoten
     * */
     public Knoten start(){
         //Baue den Baum gem�� gew�nschter Suche auf

         if (this.zielKnoten == null || this.pacmanPercept == null) {
             throw new NullPointerException("Ung�ltiger Zielzustand");
         }


         //Erzeuge Wurzelknoten
         this.fuegeKnotenEin(new Knoten(pacmanPercept.getView(), pacmanPercept.getPosition()));
         // TODO
         int anzahlScritte = 0;
         //Solange noch Expansionskandidaten vorhanden (Mindestens die Wurzel)
         while (!openList.isEmpty()) {
             //Es wird *immer* der erste Knoten aus der Openlist entnommen
             //Die Sortierung der Openlist bestimmt die Suche bzw. Ihr :-)
             Knoten expansionsKandidat = this.openList.remove(0);
             //Wird ein Knoten aus der Openlist entfernt landet
             //dieser sofort in der Closelist, damit dieser nicht noch einmal
             //expandiert wird (wir wollen keine loops im Baum!)
             this.closedList.add(expansionsKandidat.hashCode());

             //Schaue ob Knoten Ziel ist
             if (expansionsKandidat.isZiel(this.zielKnoten)) {
                 //Kandidat entspricht dem ge�nschten Zielzustand
                 Knoten loesungsKnoten = expansionsKandidat;
                 loesungsKnoten.berechnePacmanActions();
                 // TODO
                 System.out.println("\nZielzustand: \no:" + openList.size() + "|" + "c:" + closedList.size());
                 System.out.println("Anzahl der Schritte: " + anzahlScritte);
                 return loesungsKnoten;
             } else {
                 //Ist nicht gleich dem Zielzustand, also expandiere n�chsten Knoten
                 expandiereKnoten(expansionsKandidat);
                 anzahlScritte++;
             }
         }

         //Keine L�sung gefunden
         return null;
     }

    private void expandiereKnoten(Knoten vorgaenger) {
        /**
         * Die Nachfolgerknoten werden der Reihe nach in die Openlist
         * verschoben. Bei dieser Reihenfolge wird beim n�chsten expandieren
         * immer der n�rdliche, dann der �stliche, usw. angeschaut
         */

        // West
        berechneNachfolger(PacmanAction.GO_WEST, vorgaenger);

        // South
        berechneNachfolger(PacmanAction.GO_SOUTH, vorgaenger);

        // East
        berechneNachfolger(PacmanAction.GO_EAST, vorgaenger);

        // Nord
        berechneNachfolger(PacmanAction.GO_NORTH, vorgaenger);


        if(countSysout % 100 ==  0) {
            System.out.println("o:" + openList.size() + "|" + "c:" + closedList.size());
        }
        countSysout++;

    }

    private void berechneNachfolger(PacmanAction bewegungsRichtung, Knoten vorgaenger) {
        //Ist die neue Postion eine Wandposition kann man sich das Erzeugen
        //des neuen Knoten und das Pr�fen ob er sich schon in der closedList enthalten ist sparen
        Vector2 pos = vorgaenger.berechneNeuePosition(vorgaenger.getPos(), bewegungsRichtung);
        if (vorgaenger.getView()[pos.getX()][pos.getY()] == PacmanTileType.WALL)
            return;

        //Erzeuge Nachfolgerknoten nach gew�nschter Bewegungsrichtung
        Knoten nachfolger = new Knoten(vorgaenger, bewegungsRichtung);


        //Durchsuche Closelist ob es diesen Zustand (Zustand der Welt und Pacman-Position) schon mal gab
        if (closedList.contains(nachfolger.hashCode()))
            //Zustand ist gleich, also nicht erneut in die Openlist aufnehmen (sonst Loop!)
        	return;

        //Knoten wird gemaess der Suchstrategie bewertet
    	if (this instanceof HeuristicSearch)
    		((HeuristicSearch)this).bewerteKnoten(nachfolger);
        //Es ist ein g�ltiger Nachfolgezustand, also in die Openlist
        fuegeKnotenEin(nachfolger);
    }




    /**
     * Zu implementierende Funktion f�r das  Einf�gen eines Knoten in die Openlist
     *
     * @param expansionsKandidat
     */
    public abstract void fuegeKnotenEin(Knoten expansionsKandidat);


}
