package de.fh.heuristicalSearch;

import java.util.Comparator;

import de.fh.pacman.PacmanPercept;
import de.fh.pacman.enums.PacmanTileType;
import de.fh.suche.Knoten;
import de.fh.util.Vector2;

public class AStern extends HeuristicSearch{

    public AStern(PacmanPercept pacmanPercept, Knoten zielKnoten){
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

        //TODO AStern
        
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
		
		// Bestimmen des pfadkosten.
		/*
		 * Wenn auf dem Weg zu einem Dot zu viele leere Zelle vorhanden sind, dann ist der Weg zu diesem Dot teuer,
		 * und wird nicht bevorzugt.
		 */
		Knoten vorgaenger = expansionsKandidat.getVorgaenger();
		if (vorgaenger != null) {
			// Vorgaenger Welt
			view = vorgaenger.getView();
			Vector2 pos = expansionsKandidat.getPos();
			int x = pos.getX();
			int y = pos.getY();
			if (view[x][y] == PacmanTileType.EMPTY) {
				pfadkosten = vorgaenger.getPfadkosten() + 1f;
			} else {
				pfadkosten = vorgaenger.getPfadkosten();
			}
		}
		pfadkosten = 0;
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

        //TODO AStern

        //Implementiert openList.add(Index,exp) mit dem richtigen Index gemäß Suchstrategie
		/*
		 * bei diesem Suchverfahren spielt eine Rolle, ob man am Anfang oder am Ende
		 * einfügt, denn das angewendete Sortierverfahren ist stabil.
		 */
        openList.add(0, expansionsKandidat);
        
        openList.sort(new Comparator<Knoten>() {
        	@Override
        	public int compare(Knoten k1, Knoten k2) {
        		return Float.compare(k1.getBewertung(), k2.getBewertung());
        	}
        });
        
		// openList aus der Konsole ausgeben.
//      openList.stream().forEach( (s)->{
//      	System.out.print(s.getBewertung() + " ");
//      });
//      System.out.println("");
        }


}
