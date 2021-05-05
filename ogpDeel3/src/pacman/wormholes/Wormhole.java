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
		if (this == null)
			throw new IllegalArgumentException("`this wormhole is null!");
		if (this.departurePortal == null)
			throw new IllegalArgumentException("`this wormhole's arrivalportal is null!");
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
