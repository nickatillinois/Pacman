package pacman.wormholes;

import java.util.HashSet;
import java.util.Set;

import pacman.Square;

/**
 * Each instance of this class represents a departure portal, with a square indicating its position.
 * A departurePortal's square is always passable.
 * Each departure portal can have zero, one or more than one associated wormholes.
 * @invar | getSquare() != null && getSquare().isPassable()
 * @invar | getWormholes() != null && getWormholes().size() >= 0
 * @immutable
 */
public class DeparturePortal {
	
	/**
	 * @invar This square is not null, and it is a passable square
	 * 		| square != null && square.isPassable()
	 */
	private Square square;

	/**
	 * Returns the square of this departureportal.
	 * 
	 * @basic
	 */
	public Square getSquare() {
		return square;
	}
	
	/**
	 * Returns a set of wormholes associated with this departure portal
	 * @post The set is not null and has at least a size of 0
	 *  	| result != null && result.size() >= 0
	 * @basic
	 * @creates | result
	 */
	public Set<Wormhole> getWormholes() {
		Set<Wormhole> wormholesDep = new HashSet<>();
		Set<Wormhole> copyOfHoles = new HashSet<>();
		copyOfHoles.addAll(Wormhole.getWormholes());
		for(Wormhole deze : copyOfHoles){
			if (deze.getDeparturePortal().equals(this)) {
				wormholesDep.add(deze);
			}
		}
		return Set.copyOf(wormholesDep);
	}

	/**
	 * Initializes this object so that its position is the
	 * given square
	 * 
	 * @throws IllegalArgumentException | square == null
	 * @throws IllegalArgumentException | !square.isPassable()
	 * 
	 * @post | getSquare() == square
	 */
	public DeparturePortal(Square square) {
		super();
		if (square == null)
			throw new IllegalArgumentException("`given square in ArrivalPortal constructor is null");
		if (!square.isPassable())
			throw new IllegalArgumentException("`given square in ArrivalPortal constructor is not passable");
		this.square = square;
	}
}
