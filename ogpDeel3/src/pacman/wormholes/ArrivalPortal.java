package pacman.wormholes;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import pacman.Square;

/**
 * Each instance of this class represents an arrival portal, with a square indicating its position.
 * Each arrival portal can have zero, one or more than one associated wormholes.
 * A departurePortal's square is always passable.
 * @invar | getSquare() != null && getSquare().isPassable()
 * @invar | getWormholes() != null && getWormholes().size() >= 0
 * @immutable
 */
public class ArrivalPortal {
	/**
	 * @invar This square is not null, and it is a passable square
	 * 		| square != null && square.isPassable()
	 */
	private Square square;

	/**
	 * Returns the square of this arrivalportal.
	 * 
	 * @basic
	 */
	public Square getSquare() {
		return square;
	}
	
	/**
	 * Returns a set of wormholes associated with this arrival portal
	 * @post The set is not null and has at least a size of 0
	 *  	| result != null && result.size() >= 0
	 * @basic
	 */
	public Set<Wormhole> getWormholes() {
		Set<Wormhole> wormholesSet = new HashSet<>();
		for(Wormhole deze : Wormhole.getWormholes()){
			if (deze.getArrivalPortal().equals(this)) {
				wormholesSet.add(deze);
			}
		}
		return wormholesSet;
	}
	
	/**
	 * Initializes this object so that its position is the
	 * given square
	 * 
	 * @throws | square == null
	 * @throws | !square.isPassable()
	 * 
	 * @post | getSquare() == square
	 */
	public ArrivalPortal(Square square) {
		super();
		if (square == null)
			throw new IllegalArgumentException("`given square in ArrivalPortal constructor is null");
		if (!square.isPassable())
			throw new IllegalArgumentException("`given square in ArrivalPortal constructor is not passable");
		this.square = square;
	}

}
