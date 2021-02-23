package tour;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import search.Action;
import search.State;

public class TourState implements State {
	protected final Set<City> visitedCities;
	protected final City currentCity;
	
	public TourState(City startCity) {
		this.visitedCities = Collections.emptySet();
		this.currentCity = startCity;
	}
	public TourState(Set<City> visitedCities, City currentCity) {
		this.visitedCities = visitedCities;
		this.currentCity = currentCity;
	}
	public Set<Road> getApplicableActions() {
		return currentCity.outgoingRoads;
	}
	public State getActionResult(Action action) {
		Road road = (Road)action;
		Set<City> newVisitedCities = new LinkedHashSet<City>(visitedCities);
		newVisitedCities.add(road.targetCity);
		return new TourState(newVisitedCities, road.targetCity);
	}
	
	// one tour state is equal to another if the current city and the visited cities are the same.
	@Override
	public boolean equals(Object that) {
		// check the basics
		if (this == that) return true;
		if (that == null) return false;
		if (this.getClass() != that.getClass()) return false;
		
		final TourState other = (TourState)that;
		// check that the current cities of both states match
		if(!this.currentCity.name.equals(other.currentCity.name)) return false;
		
		// check that the set of visited cities of both states match
		if(this.visitedCities.equals(other.visitedCities)) return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		return currentCity.hashCode() + ((visitedCities == null) ? 0 : visitedCities.hashCode());
	}
}
