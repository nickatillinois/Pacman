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
	
	public ArrivalPortal[] getArrivalPortals() {
		return arrivalPortals;
	}
	
	public DeparturePortal[] getDeparturePortals() {
		return departurePortals;
	}
	
	public Wormhole[] getWormholes() {
		return wormholes;
	}
	private void setWormholes(Wormhole[] wormholes) {
		this.wormholes = wormholes.clone();
	}
	
	public Maze(Random random, MazeMap map, PacMan pacMan, Ghost[] ghosts, FoodItem[] foodItems, 
			DeparturePortal[] departurePortals, ArrivalPortal[] arrivalPortals
	 ) {
		this.random = random;
		this.map = map;
		this.pacMan = pacMan;
		this.ghosts = ghosts.clone();
		this.foodItems = foodItems.clone();
		
		int m = this.getMap().getWidth();
		int n = this.getMap().getHeight();
		ArrivalPortal[] sortedArrivalPortals = new ArrivalPortal[arrivalPortals.length];
		int arrayCounter = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for(ArrivalPortal deze: arrivalPortals) {
					if (deze.getSquare().getRowIndex() == i & deze.getSquare().getColumnIndex() == j) {
						sortedArrivalPortals[arrayCounter++] = deze;
					}
				}
			}
		}
		this.arrivalPortals = sortedArrivalPortals.clone();
		DeparturePortal[] sortedDeparturePortals = new DeparturePortal[departurePortals.length];
		arrayCounter = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for(DeparturePortal deze: departurePortals) {
					if (deze.getSquare().getRowIndex() == i & deze.getSquare().getColumnIndex() == j) {
						sortedDeparturePortals[arrayCounter++] = deze;
					}
				}
			}
		}
		this.departurePortals = sortedDeparturePortals.clone();
	}
	
	public void addWormhole(Wormhole wormhole) {
		if (wormhole == null)
			throw new IllegalArgumentException("`given wormhole in addwormhole is null");
		ArrivalPortal A = wormhole.getArrivalPortal();
		DeparturePortal D = wormhole.getDeparturePortal();
		boolean arrival = false;
		boolean departure = false;
		for(ArrivalPortal deze : this.getArrivalPortals()) {
			if (deze.equals(A)){
				arrival = true;
			}
		}
		for(DeparturePortal deze : this.getDeparturePortals()) {
			if (deze.equals(D)){
				departure = true;
			}
		}
		if (arrival & departure) {
			if(this.getWormholes() == null) {
				Wormhole[] firstWormholes = new Wormhole[1];
				firstWormholes[0] = wormhole;
				this.setWormholes(firstWormholes);
			}
			else {
				int n = this.getWormholes().length;
				Wormhole[] wormCopy = this.getWormholes().clone();
				Wormhole[] newWormholes = new Wormhole[n + 1];
				for(int i = 0; i < n; i++){
					newWormholes[i] = wormCopy[i];
				}
				newWormholes[n] = wormhole;
				this.setWormholes(newWormholes);
			}
		}
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
	private Square pickWormhole(Square square) {
		
		for(DeparturePortal deze : this.getDeparturePortals()) {
			if (deze.getSquare().equals(square)){
				Wormhole[] arrayOfHoles = new Wormhole[deze.getWormholes().size()];
				deze.getWormholes().toArray(arrayOfHoles);
				Square nextSquare = arrayOfHoles[random.nextInt(arrayOfHoles.length)].getArrivalPortal().getSquare();
				return nextSquare;
			}
		}return null;
		
	}
	private boolean checkDeparturePortal(Square square) {
		for(DeparturePortal deze : this.getDeparturePortals()) {
			if (deze.getSquare().equals(square) & deze.getWormholes().size() > 0){
				return true;
			}
		}
		return false;
	}
	public void movePacMan(Direction direction) {
		Square newSquare = pacMan.getSquare().getNeighbor(direction);
		if (newSquare.isPassable() & !checkDeparturePortal(newSquare)) {
			pacMan.setSquare(newSquare);
			checkFoodItemCollision(newSquare);
			checkPacManDamage();
		}
		// Dus dit vakje is een departureportal met minstens 1 wormhole
		else if (newSquare.isPassable() & checkDeparturePortal(newSquare)) {
			pacMan.setSquare(newSquare);
			checkPacManDamage();
			pacMan.setSquare(pickWormhole(newSquare));
			checkPacManDamage();
		}
	}
	
}
