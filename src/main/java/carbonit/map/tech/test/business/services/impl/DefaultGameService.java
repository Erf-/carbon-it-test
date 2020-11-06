/**
 * 
 */
package carbonit.map.tech.test.business.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import carbonit.map.tech.test.business.model.abstracts.Movable;
import carbonit.map.tech.test.business.model.bo.TreasureMapBO;
import carbonit.map.tech.test.business.services.GameService;
import carbonit.map.tech.test.business.services.MapService;

/**
 * @author Elias
 *
 */
public class DefaultGameService implements GameService {

	// Fields
	private MapService mapService;
	private TreasureMapBO mapBO;

	// Constructors
	public DefaultGameService(MapService mapService, TreasureMapBO mapBO) {
		super();
		this.mapService = mapService;
		this.mapBO = mapBO;
	}

	// Inherited methods
	@Override
	public void init(String mapDataFile) {
		this.mapBO = mapService.loadMap(mapDataFile);
	}

	@Override
	public boolean next() {
		List<Movable> moveList = this.mapBO.getMapElements().values().stream()
		.filter(element -> element instanceof Movable)
		.map(mapElement -> (Movable) mapElement)
		.filter(movableElem -> movableElem.getCurrentStep() < movableElem.getMoves().size())
		.collect(Collectors.toList());
		if (moveList == null || moveList.isEmpty()) {
			return false;
		}
		moveList.stream().forEachOrdered(movable -> movable.move(mapBO));
		return true;
	}

	// Getters and setters
	public MapService getMapService() {
		return mapService;
	}

	public void setMapService(MapService mapService) {
		this.mapService = mapService;
	}

	public TreasureMapBO getMapBO() {
		return mapBO;
	}

	public void setMapBO(TreasureMapBO mapBO) {
		this.mapBO = mapBO;
	}

}
