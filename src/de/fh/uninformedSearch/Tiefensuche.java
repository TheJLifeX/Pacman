package de.fh.uninformedSearch;

import de.fh.pacman.PacmanPercept;
import de.fh.suche.Knoten;

public class Tiefensuche extends UninformedSearch{

    public Tiefensuche(PacmanPercept pacmanPercept, Knoten zielKnoten){
        super(pacmanPercept, zielKnoten);
    }


    /**
     * Konkrete Implentierung des Einfügens eines Knoten in
     * die Openlist bei der Tiefensuche
     *
     * @param expansionsKandidat
     */
    @Override
    public void fuegeKnotenEin(Knoten expansionsKandidat) {

        //TODO Tiefensuche (Beispiel)
        //Implementiert openList.add(Index,exp), mit dem richtigen Index gemäß Suchstrategie
        openList.add(0,expansionsKandidat);
    }
}
