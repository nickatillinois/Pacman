package pacman.wormholes.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pacman.MazeMap;
import pacman.Square;
import pacman.wormholes.ArrivalPortal;
import pacman.wormholes.DeparturePortal;

class DeparturePortalTest {
	// 0 = false = niet passable = muur
	// 1 = true = passable = geen muur
	// 1100
	// 1100
	// 0111
	// 0000
	MazeMap myMazemap = new MazeMap(4, 4, new boolean[] {true, true, false, false, true, 
    		true, false, false, false, true, true, true, false, false, false, false});
	Square vierkant0 = Square.of(myMazemap, 1, 1);
	Square vierkant1 = Square.of(myMazemap, 0, 0);
	Square vierkant2 = Square.of(myMazemap, 2, 1);
	DeparturePortal departureportal0 = new DeparturePortal(vierkant0);
	DeparturePortal departureportal1 = new DeparturePortal(vierkant1);
	DeparturePortal departureportal2 = new DeparturePortal(vierkant2); 
	@Test
	void constructorAndGetSquaretest() {
		assert departureportal0.getSquare().equals(vierkant0);
		assert departureportal1.getSquare().equals(vierkant1);
		assert departureportal2.getSquare().equals(vierkant2);
	}

}
