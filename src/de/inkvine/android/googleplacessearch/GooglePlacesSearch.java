package de.inkvine.android.googleplacessearch;

import java.util.List;

import android.location.Location;
import de.inkvine.android.googleplacessearch.exceptions.APIKeyNotSetException;
import de.inkvine.android.googleplacessearch.exceptions.LocationNotAvailableException;
import de.inkvine.android.googleplacessearch.exceptions.RequestDeniedException;
import de.inkvine.android.googleplacessearch.exceptions.RequestException;
import de.inkvine.android.googleplacessearch.exceptions.RequestLimitExceededException;
import de.inkvine.android.googleplacessearch.exceptions.RequestWrongFormattedException;
import de.inkvine.android.googleplacessearch.filter.FilterCriteria;
import de.inkvine.android.googleplacessearch.model.Place;

/**
 * The GooglePlacesSearch will return places that correspond to the filter
 * criterias provided to the search-Method.
 * 
 * The searchForStores-Method is just a convenient method to search for stores
 * that correspond to the provided store names.
 * 
 * Beware. A lot of threads will be instantiated when filtering. Assure you have
 * network access as the Google Places API needs to be consumed via HTTP.
 * 
 * @author Jeffrey Groneberg (www.twitter.com/inkvine)
 * 
 */
public interface GooglePlacesSearch {

	public static String STATUS_CODE_ZERO_RESULTS = "ZERO_RESULTS";
	public static String STATUS_CODE_OVER_QUERY_LIMIT = "OVER_QUERY_LIMIT";
	public static String STATUS_CODE_REQUEST_DENIED = "REQUEST_DENIED";
	public static String STATUS_CODE_INVALID_REQUEST = "INVALID_REQUEST";

	/**
	 * @param key
	 */
	public void setAPIKey(String key);

	/**
	 * @param location
	 */
	public void setLocation(Location location);

	/**
	 * @param location
	 * @return
	 */
	public Location getLocation(Location location);

	/**
	 * @param storeNames
	 * @param radius
	 * @param resultsPerCriteria
	 * @return
	 * @throws LocationNotAvailableException
	 * @throws APIKeyNotSetException
	 * @throws RequestWrongFormattedException
	 * @throws RequestLimitExceededException
	 * @throws RequestDeniedException
	 * @throws RequestException
	 */
	public List<Place> searchForStores(List<String> storeNames, int radius)
			throws LocationNotAvailableException, APIKeyNotSetException,
			RequestException;

	/**
	 * @param criterias
	 * @param radius
	 * @return
	 * @throws LocationNotAvailableException
	 * @throws APIKeyNotSetException
	 * @throws RequestWrongFormattedException
	 * @throws RequestLimitExceededException
	 * @throws RequestDeniedException
	 * @throws RequestException
	 */
	public List<Place> search(List<? extends FilterCriteria> criterias,
			int radius) throws LocationNotAvailableException,
			APIKeyNotSetException, RequestException;

}
