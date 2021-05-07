package pacman.wormholes.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import pacman.Maze;
import pacman.MazeDescriptions;
import pacman.MazeMap;
import pacman.wormholes.Wormhole;

class WormholeTest {
	Maze maze = MazeDescriptions.createMazeFromDescription(new Random(), """
			#####################
			#A........#...D....D#
			#.###.###.#.###.###.#
			#....A....D...A...A.#
			#.###.#.#####.#.###.#
			#.....#...#...#..D..#
			#####################
			""");
	maze.addWormhole(new Wormhole(departurePortals[0], arrivalPortals[2]));
	maze.addWormhole(new Wormhole(departurePortals[0], arrivalPortals[0]));
	maze.addWormhole(new Wormhole(departurePortals[1], arrivalPortals[1]));
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
