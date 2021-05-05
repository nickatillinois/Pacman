package pacman.wormholes;

import java.util.*;

public class Wormhole {
	private static Set<Wormhole> wormholes = new HashSet<>();
	private ArrivalPortal arrivalPortal;
	
	public ArrivalPortal getArrivalPortal() {
		return arrivalPortal;
	}
	protected static Set<Wormhole> getWormholes() {
		return wormholes;
	}

	public void setArrivalPortal(ArrivalPortal arrivalPortal) {
		this.arrivalPortal = arrivalPortal;
	}

	public DeparturePortal getDeparturePortal() {
		return departurePortal;
	}

	public void setDeparturePortal(DeparturePortal departurePortal) {
		this.departurePortal = departurePortal;
	}

	private DeparturePortal departurePortal;
	
	public Wormhole(DeparturePortal departurePortal, ArrivalPortal arrivalPortal) {
		super();
		this.arrivalPortal = arrivalPortal;
		this.departurePortal = departurePortal;
		Wormhole.wormholes.add(this);
	}

	

}
