package pacman.wormholes;

import java.util.*;

/**
 * 
 * Each instance of this class represents a wormhole, with at each point in time exactly one departure portal representing the 'entrance square' and exactly one arrival portal,
 * representing the 'exit square'.
 * @invar Neither are null at any point in time
 * 		|getArrivalPortal() != null && getDeparturePortal() != null
 */
public class Wormhole {
	
	/**
	 * @invar The set of wormholes is never null
	 * 		| wormholes != null
	 */
	private static Set<Wormhole> wormholes = new HashSet<>();
	
	/**
	 * @invar This wormhole's arrivalportal is never null
	 * 		| arrivalPortal != null
	 * @peerObject
	 */
	private ArrivalPortal arrivalPortal;
	
	/**
	 * @invar This wormhole's departureportal is never null
	 * 		| departurePortal != null
	 * @peerObject
	 */
	private DeparturePortal departurePortal;
	
	/**
	 * Returns the arrival portal of this wormhole.
	 * 
	 * @basic
	 */
	public ArrivalPortal getArrivalPortal() {
		return arrivalPortal;
	}
	
	/**
	 * Returns the arrival portal of this wormhole.
	 * 
	 * @basic
	 */
	public DeparturePortal getDeparturePortal() {
		return departurePortal;
	}
	
	/**
	 * Sets this wormhole's arrival portal to the given arrival portal.
	 * @throws IllegalArgumentException | arrivalPortal == null
	 * @post This wormhole's arrival portal equals the given arrival portal.
	 * 		|getArrivalPortal() == arrivalPortal
	 * @post This wormhole's departurePortal remained unchanged.
	 * 		| getDeparturePortal() == old(getDeparturePortal())
	 * @post The set of wormholes associated with the arrivalPortal remained unchanged
	 * 		| getDeparturePortal().getWormholes().containsAll(old(getDeparturePortal()).getWormholes()) && getDeparturePortal().getWormholes().size() == old(getDeparturePortal()).getWormholes().size() 
	 * @mutates | this
	 * 
	 */
	public void setArrivalPortal(ArrivalPortal arrivalPortal) {
		if (arrivalPortal == null)
			throw new IllegalArgumentException("`given ArrivalPortal in Wormhole setter is null");
		this.arrivalPortal = arrivalPortal;
	}
	
	protected static Set<Wormhole> getWormholes() {
		return wormholes;
	}
	
	/**
	 * Sets this wormhole's departure portal to the given departure portal.
	 * @throws IllegalArgumentException | departurePortal == null
	 * @post This wormhole's departure portal equals the given departure portal.
	 * 		|getDeparturePortal() == departurePortal
	 * @post This wormhole's arrivalPortal remained unchanged.
	 * 		| getArrivalPortal() == old(getArrivalPortal())
	 * @post The set of wormholes associated with the arrivalPortal remained unchanged
	 * 		| getArrivalPortal().getWormholes().containsAll(old(getArrivalPortal()).getWormholes()) && getArrivalPortal().getWormholes().size() == old(getArrivalPortal()).getWormholes().size() 
	 * @mutates | this
	 * 
	 */
	public void setDeparturePortal(DeparturePortal departurePortal) {
		if (departurePortal == null)
			throw new IllegalArgumentException("`given DeparturePortal in Wormhole setter is null");
		this.departurePortal = departurePortal;
	}
	
	/**
	 * Initializes this wormhole so that its departure portal is the given departure portal, and its arrival portal is the given departure portal.
	 * 
	 * @throws IllegalArgumentException | departurePortal == null
	 * @throws IllegalArgumentException | arrivalPortal == null
	 * 
	 * @post | getArrivalPortal() == arrivalPortal
	 * @post | getDeparturePortal() == departurePortal
	 * 
	 */
	public Wormhole(DeparturePortal departurePortal, ArrivalPortal arrivalPortal) {
		super();
		if (departurePortal == null)
			throw new IllegalArgumentException("`given DeparturePortal in Wormhole constructor is null");
		if (arrivalPortal == null)
			throw new IllegalArgumentException("`given ArrivalPortalPortal in Wormhole constructor is null");
		this.arrivalPortal = arrivalPortal;
		this.departurePortal = departurePortal;
		Wormhole.wormholes.add(this);
	}

	

}
