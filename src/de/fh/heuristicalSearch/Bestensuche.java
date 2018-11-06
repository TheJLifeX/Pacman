package de.fh.heuristicalSearch;

import de.fh.pacman.PacmanPercept;
import de.fh.suche.Knoten;

public class Bestensuche extends HeuristicSearch{

    public Bestensuche(PacmanPercept pacmanPercept, Knoten zielKnoten){
        super(pacmanPercept, zielKnoten);
    }


    /**
     * Konkrete Implentierung des Bewerten eines Knotens
     * gemäß der entsprechenden Suche
     *
     * @param expansionsKandidat
     */
    @Override
    public void bewerteKnoten(Knoten expansionsKandidat) {

        float schaetzwert = 0f, pfadkosten = 0f;

        //TODO Bestensuche

        //setzt die bisherigen Pfadkosten zu dem Knoten
        expansionsKandidat.setPfadkosten(pfadkosten);
        //Setzt den richtigen Schätzwert für den Knoten
        expansionsKandidat.setSchaetzwert(schaetzwert);

    }


    /**
     * Konkrete Implentierung des Einfügens eines Knoten in
     * die Openlist bei der Tiefensuche
     *
     * @param expansionsKandidat
     */
    @Override
    public void fuegeKnotenEin(Knoten expansionsKandidat) {

        //TODO Bestensuche

        //Implementiert openList.add(Index,exp) mit dem richtigen Index gemäß Suchstrategie
        openList.add(0, expansionsKandidat);

    }


}
