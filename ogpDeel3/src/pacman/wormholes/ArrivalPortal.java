package pacman.wormholes;

import java.util.Set;

import pacman.Square;

public class ArrivalPortal {
	private Square square;
	private Set<Wormhole> wormholes;

	public Set<Wormhole> getWormholes() {
		return wormholes;
	}

	public Square getSquare() {
		return square;
	}

	public ArrivalPortal(Square square) {
		super();
		this.square = square;
	}

}
