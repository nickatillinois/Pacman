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


class WormholeTest {
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
		maze.addWormhole(wormhole2);
		maze.addWormhole(wormhole1);
		assert wormhole1.getArrivalPortal() == arrivalPortals[0];
		assert wormhole2.getArrivalPortal() == arrivalPortals[1];
		assert wormhole1.getDeparturePortal() == departurePortals[0];
		assert wormhole2.getDeparturePortal() == departurePortals[1];
		assert maze.getWormholes().length == 2;
		assert maze.getWormholes()[0].equals(wormhole2);
		assert maze.getWormholes()[1].equals(wormhole1);
		wormhole2.setArrivalPortal(arrivalPortals[0]);
		assert wormhole2.getArrivalPortal() == arrivalPortals[0];
		wormhole2.setDeparturePortal(departurePortals[0]);
		assert wormhole2.getDeparturePortal() == departurePortals[0];
		
	}

}
