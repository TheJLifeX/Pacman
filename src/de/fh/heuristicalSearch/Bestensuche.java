package de.fh.heuristicalSearch;

import java.util.Comparator;

import de.fh.pacman.PacmanPercept;
import de.fh.pacman.enums.PacmanTileType;
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
        
        // Bestimmen des Schaetzwertes.
        /*
         * Die Knoten( Zustünde ), deren Gesamtwelt am wenigsten Dots enthält, werden
         * bevorzugzt. also werden als nächstes expandiert.
         * so wird der Pacman nach und nach alle Dots fressen.
         */
        float anzahlDots = 0;
        PacmanTileType[][] view =  expansionsKandidat.getView();
		for (int i = 0; i < view.length; i++) {
			for (int j = 0; j < view[i].length; j++) {
				if (view[i][j] == PacmanTileType.DOT) {
					anzahlDots++;
				}
			}
		}
		schaetzwert = anzahlDots;

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
        /*
         *  bei diesem Suchverfahren spielt eine Rolle, ob man am Anfang oder am Ende einfügt,
         *  denn das angewendete Sortierverfahren ist stabil.
         */
        openList.add(0, expansionsKandidat);
        
        openList.sort(new Comparator<Knoten>() {
        	@Override
        	public int compare(Knoten k1, Knoten k2) {
        		return Float.compare(k1.getSchaetzwert(), k2.getSchaetzwert());
        	}
        });

    }


}
