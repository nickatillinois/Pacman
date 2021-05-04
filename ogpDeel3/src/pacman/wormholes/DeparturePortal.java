package pacman.wormholes;

import java.util.Set;

import pacman.Square;

public class DeparturePortal {
	private Square square;
	private Set<Wormhole> wormholes;

	public Set<Wormhole> getWormholes() {
		return wormholes;
	}

	public Square getSquare() {
		return square;
	}

	public DeparturePortal(Square square) {
		super();
		this.square = square;
	}
}
