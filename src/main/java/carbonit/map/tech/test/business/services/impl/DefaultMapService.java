/**
 * 
 */
package carbonit.map.tech.test.business.services.impl;

import carbonit.map.tech.test.business.model.bo.TreasureMapBO;
import carbonit.map.tech.test.business.services.MapService;
import carbonit.map.tech.test.data.dao.TreasureMapDao;

/**
 * @author Elias
 *
 */
public class DefaultMapService implements MapService {

	// Fields
	private TreasureMapDao mapDAO;

	// Constructors
	public DefaultMapService(TreasureMapDao mapDAO) {
		super();
		this.mapDAO = mapDAO;
	}

	// Inherited methods
	@Override
	public TreasureMapBO loadMap(String mapDataFile) {
		return new TreasureMapBO(mapDAO.load(mapDataFile));
	}

	@Override
	public void publishMap(TreasureMapBO mapBO) {
		mapDAO.save(mapBO.getTreasureMapVO());
	}

	// Getters and setters
	public TreasureMapDao getMapDAO() {
		return mapDAO;
	}

	public void setMapDAO(TreasureMapDao mapDAO) {
		this.mapDAO = mapDAO;
	}

}
