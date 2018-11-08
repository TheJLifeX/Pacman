package de.fh.heuristicalSearch;

import java.util.Comparator;

import de.fh.pacman.PacmanPercept;
import de.fh.pacman.enums.PacmanTileType;
import de.fh.suche.Knoten;
import de.fh.util.Vector2;

public class Dijkstra extends HeuristicSearch {

	public Dijkstra(PacmanPercept pacmanPercept, Knoten zielKnoten) {
		super(pacmanPercept, zielKnoten);
	}

	/**
	 * Konkrete Implentierung des Bewerten eines Knotens gemäß der entsprechenden
	 * Suche
	 *
	 * @param expansionsKandidat
	 */
	@Override
	public void bewerteKnoten(Knoten expansionsKandidat) {

		float schaetzwert = 0f, pfadkosten = 0f;

		// TODO Dijkstra

		// Bestimmen des pfadkosten.
		/*
		 * Wenn der Pacman auf eine leere Zelle geht, ist das teuer, weil unser Ziel ist
		 * alle Dots zu fressen, daher erhöhe ich die pfadkosten falls das der fall ist.
		 * ansonst bleibt der Pfadkosten gleich.
		 * 
		 * teuere Wegstücke :: leere Zelle 
		 * billige Wegstücke :: volle Zelle ( also mit einem Dot ).
		 */
		Knoten vorgaenger = expansionsKandidat.getVorgaenger();
		if (vorgaenger != null) {
			// Vorgaenger Welt
			PacmanTileType[][] view = vorgaenger.getView();
			Vector2 pos = expansionsKandidat.getPos();
			int x = pos.getX();
			int y = pos.getY();
			if (view[x][y] == PacmanTileType.EMPTY) {
				pfadkosten = vorgaenger.getPfadkosten() + 1;
			} else {
				pfadkosten = vorgaenger.getPfadkosten();
			}
		}

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.
		/*
		 * Wenn auf dem Weg zu einem Dot zu viele leere Zelle vorhanden sind, dann ist
		 * der Weg zu diesem Dot teuer, und wird nicht bevorzugt.
		 */
//        Knoten currentNode = expansionsKandidat;
//        List<Vector2> vectorList = new LinkedList<>();
//        while(currentNode.getVorgaenger() != null) {
//        	vectorList.add(currentNode.getPos());
//        	currentNode = currentNode.getVorgaenger();
//        }
//        
//        // hier ist currentNode die Wurzel
//        PacmanTileType[][] view =  currentNode.getView();
//        float count = 0;
//        while( !vectorList.isEmpty()) {
//        	Vector2 pos = vectorList.remove(0);
//        	int x = pos.getX();
//        	int y = pos.getY();
//        	if( view[x][y] == PacmanTileType.EMPTY ) {
//        		count++;
//        	}
//        }

		// setzt die bisherigen Pfadkosten zu dem Knoten
		expansionsKandidat.setPfadkosten(pfadkosten);
		// Setzt den richtigen Schätzwert für den Knoten
		expansionsKandidat.setSchaetzwert(schaetzwert);

	}

	/**
	 * Konkrete Implentierung des Einfügens eines Knoten in die Openlist bei der
	 * Tiefensuche
	 *
	 * @param expansionsKandidat
	 */
	@Override
	public void fuegeKnotenEin(Knoten expansionsKandidat) {

		// TODO Dijkstra
		// Implementiert openList.add(Index,exp) mit dem richtigen Index gemäß
		// Suchstrategie
		/*
		 * bei diesem Suchverfahren spielt eine Rolle, ob man am Anfang oder am Ende
		 * einfügt, denn das angewendete Sortierverfahren ist stabil.
		 */
		openList.add(0, expansionsKandidat);
		openList.sort(new Comparator<Knoten>() {
			@Override
			public int compare(Knoten k1, Knoten k2) {
				return Float.compare(k1.getPfadkosten(), k2.getPfadkosten());
			}
		});

		// Expansionkandidat direkt in der Liste an der richtigen Stelle einfügen.
		// Effizierter !?
//		Knoten currentNode ;
//		boolean eingefuegt = false;
//    	for (int i = 0; i < openList.size() && !eingefuegt; i++) {
//    		currentNode = openList.get(i);
//    		if(expansionsKandidat.getPfadkosten() <= currentNode.getPfadkosten() ) {
//    			openList.add(i, expansionsKandidat);
//    			eingefuegt = true;
//    		}
//		}
//		if( openList.size() == 0 || !eingefuegt) {
//			openList.add(expansionsKandidat);
//		}

		// openList aus der Konsole ausgeben.
//        openList.stream().forEach( (s)->{
//        	System.out.print(s.getPfadkosten() + " \n");
//        });

	}

}
