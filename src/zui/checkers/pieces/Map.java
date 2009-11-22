package zui.checkers.pieces;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import zui.checkers.agents.Agent;

public class Map {
    
    /** Size of the map. */
    public static final int SIZE = 8;
    
    private List<List<Piece>> rDiagonals;
    
    private List<List<Piece>> lDiagonals;
    
    public Map() {
        initEmptyMap();
    }
    
    private void initEmptyMap() {
        rDiagonals = new ArrayList<List<Piece>>(2 * SIZE -1);
        lDiagonals = new ArrayList<List<Piece>>(2 * SIZE -1);
        
        for (int i = 1; i < SIZE; i++) {
            rDiagonals.add(createEmptyDiagonal(i));
            lDiagonals.add(createEmptyDiagonal(i));
        }
        rDiagonals.add(createEmptyDiagonal(SIZE));
        lDiagonals.add(createEmptyDiagonal(SIZE));
        for (int i = SIZE-1; i > 0; i--) {
            rDiagonals.add(createEmptyDiagonal(i));
            lDiagonals.add(createEmptyDiagonal(i));
        }
    }
    
    private List<Piece> createEmptyDiagonal(int size) {
        List<Piece> diag = new ArrayList<Piece>(size);
        for (int i = 0; i<size; i++) {
            diag.add(null);
        }
        return diag;
    }
    
    /**
     * Nastavi na policko so suradnicami <tt>(x, y)</tt> figurku <tt>piece</tt>.
     * Nastavenie hodnoty <tt>null</tt> znaci prazdne policko.
     * @param x x-ova suradnica
     * @param y y-ova suradnica
     * @param piece Figurka. <tt>null</tt> reprezentuje prazdne policko.
     * @return Figurku, ktora stala doteraz na policku so suradnicami <tt>(x, y)</tt>
     * alebo <tt>null</tt> ak na danom policku nestala ziadna figurka.
     */
    public Piece setPiece(int x, int y, Piece piece) {
        initPiece(x, y, piece);
        
        Piece rPiece = rDiagonals.get(getRDiagIndex(x, y)).set(x-1, piece);
        Piece lPiece = lDiagonals.get(getLDiagIndex(x, y)).set(y-1, piece);
        
        if (rPiece != lPiece) {
            throw new AssertionError("Nekonzistentna mapa! [" + lPiece + ", " + rPiece + "]");
        } else {
            return rPiece;
        }
    }
    
    /**
     * Nainicializuje figurku pre tuto mapu.
     */
    private void initPiece(int x, int y, Piece piece) {
    	
    	rDiagonals.set(getRDiagIndex(piece.getX(), piece.getY()), null);
    	lDiagonals.set(getLDiagIndex(piece.getX(), piece.getY()), null);
    	
        piece.setMap(this);
        piece.setX(x);
        piece.setY(y);
    }
    
    private int getRDiagIndex(int x, int y) {
        return SIZE - 3 - x + y;
    }
    
    private int getLDiagIndex(int x, int y) {
        return x + y - 2;
    }
    
    /**
     * @param x x-ova suradnica
     * @param y y-ova suradnica
     * @return Figurku stojacu na suradniciach <tt>(x, y)</tt> alebo <tt>null</tt>
     * ak je dane policko prazdne.
     */
    public Piece getPieceAt(int x, int y) {
        return rDiagonals.get(getRDiagIndex(x, y)).get(x-1);
    }
    
    /**
     * @param x x-ova suradnica
     * @param y y-ova suradnica
     * @return Vrati "pravu" diagonalu prechadzajucu polickom <tt>(x, y)<tt>.
     */
    public List<Piece> getRDiagonalAt(int x, int y) {
        return rDiagonals.get(getRDiagIndex(x, y));
    }
    
    /**
     * @param x x-ova suradnica
     * @param y y-ova suradnica
     * @return Vrati "lavu" diagonalu prechadzajucu polickom <tt>(x, y)<tt>.
     */
    public List<Piece> getLDiagonalAt(int x, int y) {
        return rDiagonals.get(getRDiagIndex(x, y));
    }
    
    /**
     * @param agent Hrac/agent
     * @return Vrati mnozinu vsetkych figurok na hracej ploche, ktore patria
     * danemu hracovi.
     */
    public Set<Piece> getPieces(Agent agent) {
        Set<Piece> agentsPieces = new HashSet<Piece>(8);
        for (int i = 0; i<rDiagonals.size(); i++) {
            List<Piece> diag = rDiagonals.get(i);
            for (int j = 0; j<diag.size(); j++) {
                if (diag.get(j).getAgent() == agent) {
                    agentsPieces.add(diag.get(j));
                }
            }
        }
        return agentsPieces;
    }

	@Override
	public Map clone(){

		try{
			return (Map)super.clone();
		}catch (Exception e) {
			new AssertionError("Clone not supported for "+getClass().getName());
		}
		
		return null;
		
	}
    
    
    

    
}
