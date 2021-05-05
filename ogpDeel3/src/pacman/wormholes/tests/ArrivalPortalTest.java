//package pacman.wormholes.tests;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//import pacman.*;
//import pacman.wormholes.*;
//class ArrivalPortalTest {
//
//	// 0 = false = niet passable = muur
//	// 1 = true = passable = geen muur
//	// 1100
//	// 1100
//	// 0111
//	// 0000
//    MazeMap myMazemap = new MazeMap(4, 4, new boolean[] {true, true, false, false, true, 
//    		true, false, false, false, true, true, true, false, false, false, false});
//	assert myMazemap.getWidth() == 4;
//	assert myMazemap.getHeight() == 4;
//	assert myMazemap.isPassable(1,1) == true;
//	assert myMazemap.isPassable(0, 0) == true;
//	assert myMazemap.isPassable(2, 1) == true;
//	Square vierkant0 = Square.of(myMazemap, 1, 1);
//	Square vierkant1 = Square.of(myMazemap, 0, 0);
//	Square vierkant2 = Square.of(myMazemap, 2, 1);
//	ArrivalPortal arrivalportal0 = new ArrivalPortal(vierkant0);
//	ArrivalPortal arrivalportal1 = new ArrivalPortal(vierkant1);
//	ArrivalPortal arrivalportal2 = new ArrivalPortal(vierkant2);
//	
//	@Test
//	void constructiontest() {
//		assert arrivalportal0.getSquare().equals(vierkant0);
//		assert arrivalportal1.getSquare().equals(vierkant1);
//		assert arrivalportal2.getSquare().equals(vierkant2);
//	}

//}