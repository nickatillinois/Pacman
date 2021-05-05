package pacman.wormholes;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import pacman.Square;

public class ArrivalPortal {
	private Square square;
	private Set<Wormhole> wormholes;

	public Set<Wormhole> getWormholes() {
		Set<Wormhole> wormholesArr = new HashSet<>();
		for(Wormhole deze : Wormhole.getWormholes()){
			if (deze.getArrivalPortal().equals(this)) {
				wormholesArr.add(deze);
			}
		}
		return wormholesArr;
	}

	public Square getSquare() {
		return square;
	}

	public ArrivalPortal(Square square) {
		super();
		this.square = square;
	}

}
