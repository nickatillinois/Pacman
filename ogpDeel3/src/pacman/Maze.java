package pacman;

import java.util.Arrays;
import java.util.Random;

import pacman.wormholes.ArrivalPortal;
import pacman.wormholes.DeparturePortal;
import pacman.wormholes.Wormhole;

public class Maze {
	
	
	private Random random;
	private MazeMap map;
	private PacMan pacMan;
	private Ghost[] ghosts;
	private FoodItem[] foodItems;
	private DeparturePortal[] departurePortals;
	private ArrivalPortal[] arrivalPortals;
	private Wormhole[] wormholes;
	
	public MazeMap getMap() { return map; }
	
	public PacMan getPacMan() { return pacMan; }
	
	public Ghost[] getGhosts() { return ghosts.clone(); }
	
	public FoodItem[] getFoodItems() { return foodItems.clone(); }
	
	public DeparturePortal[] getDeparturePortals() {
		int m = this.getMap().getWidth();
		int n = this.getMap().getHeight();
		DeparturePortal[] sortedDeparturePortals = new DeparturePortal[this.departurePortals.length];
		int arrayCounter = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for(DeparturePortal deze: departurePortals) {
					if (deze.getSquare().getRowIndex() == i & deze.getSquare().getColumnIndex() == j) {
						sortedDeparturePortals[arrayCounter++] = deze;
					}
				}
			}
		}
		return departurePortals;
	}

	public ArrivalPortal[] getArrivalPortals() {
		return arrivalPortals;
	}

	public Wormhole[] getWormholes() {
		return wormholes;
	}
	
	public Maze(Random random, MazeMap map, PacMan pacMan, Ghost[] ghosts, FoodItem[] foodItems, 
			DeparturePortal[] departurePortals, ArrivalPortal[] arrivalPortals
	 ) {
		this.random = random;
		this.map = map;
		this.pacMan = pacMan;
		this.ghosts = ghosts.clone();
		this.foodItems = foodItems.clone();
		this.departurePortals = departurePortals.clone();
		this.arrivalPortals = arrivalPortals.clone();
	}
	
	public boolean isCompleted() {
		return foodItems.length == 0;
	}
	
	private void checkPacManDamage() {
		for (Ghost ghost : ghosts)
			if (ghost.getSquare().equals(pacMan.getSquare()))
				ghost.hitBy(pacMan);
	}
	
	public void moveGhosts() {
		for (Ghost ghost : ghosts)
			ghost.move(random);
		checkPacManDamage();
	}
	
	public void pacManAtePowerPellet() {
		for (Ghost ghost : ghosts)
			ghost.pacManAtePowerPellet();
	}
	
	private void removeFoodItemsAtIndex(int index) {
		FoodItem[] newFoodItems = new FoodItem[foodItems.length - 1];
		System.arraycopy(foodItems, 0, newFoodItems, 0, index);
		System.arraycopy(foodItems, index + 1, newFoodItems, index, newFoodItems.length - index);
		foodItems = newFoodItems;
	}
	
	private void checkFoodItemCollision(Square square) {
		for (int i = 0; i < foodItems.length; i++) {
			if (foodItems[i].getSquare().equals(square)) {
				foodItems[i].eatenByPacMan(this);
				removeFoodItemsAtIndex(i);
				return;
			}
		}
	}
	
	public void movePacMan(Direction direction) {
		Square newSquare = pacMan.getSquare().getNeighbor(direction);
		if (newSquare.isPassable()) {
			pacMan.setSquare(newSquare);
			checkFoodItemCollision(newSquare);
			checkPacManDamage();
		}
	}
	
}
