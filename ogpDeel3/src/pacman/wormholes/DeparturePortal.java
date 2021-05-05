package pacman.wormholes;

import java.util.HashSet;
import java.util.Set;

import pacman.Square;

public class DeparturePortal {
	private Square square;
	private Set<Wormhole> wormholes;

	public Set<Wormhole> getWormholes() {
		Set<Wormhole> wormholesDep = new HashSet<>();
		for(Wormhole deze : Wormhole.getWormholes()){
			if (deze.getDeparturePortal().equals(this)) {
				wormholesDep.add(deze);
			}
		}
		return wormholesDep;
	}
		
	public Square getSquare() {
		return square;
	}

	public DeparturePortal(Square square) {
		super();
		if (square == null)
			throw new IllegalArgumentException("`square is null");
		this.square = square;
	}
}
