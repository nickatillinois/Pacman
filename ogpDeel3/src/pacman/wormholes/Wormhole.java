package pacman.wormholes;

public class Wormhole {
	
	private ArrivalPortal arrivalPortal;
	public ArrivalPortal getArrivalPortal() {
		return arrivalPortal;
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
	
	public Wormhole(ArrivalPortal arrivalPortal, DeparturePortal departurePortal) {
		super();
		this.arrivalPortal = arrivalPortal;
		this.departurePortal = departurePortal;
	}

	

}
