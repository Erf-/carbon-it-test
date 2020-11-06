/**
 * 
 */
package carbonit.map.tech.test.business.services;

import carbonit.map.tech.test.business.model.bo.TreasureMapBO;

/**
 * @author Elias
 *
 */
public interface MapService {

	public TreasureMapBO loadMap(String mapDataFile);
	public void publishMap(TreasureMapBO mapBO);
}
