package pacman.wormholes.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import pacman.Maze;
import pacman.MazeDescriptions;
import pacman.MazeMap;
import pacman.Square;
import pacman.wormholes.ArrivalPortal;
import pacman.wormholes.DeparturePortal;
import pacman.wormholes.Wormhole;

class ArrivalPortalTest {
	Maze maze = MazeDescriptions.createMazeFromDescription(new Random(), """
			#####################
			#D........#...A....D#
			#.###.###.#.###.###.#
			#....A....P.........#
			#.###.#.#####.#.###.#
			#.....#...#...#.....#
			#####################
			""");
	ArrivalPortal[] arrivalPortals = maze.getArrivalPortals();
	DeparturePortal[] departurePortals = maze.getDeparturePortals();
	Wormhole wormhole2 = new Wormhole (departurePortals[1], arrivalPortals[1]);
	Wormhole wormhole1 = new Wormhole (departurePortals[0], arrivalPortals[0]);
	@Test
	void test() {
		assert !arrivalPortals[0].getWormholes().contains(wormhole2);
		assert arrivalPortals[0].getWormholes().contains(wormhole1);
	}
}
