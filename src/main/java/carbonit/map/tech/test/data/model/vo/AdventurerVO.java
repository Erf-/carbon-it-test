/**
 * 
 */
package carbonit.map.tech.test.data.model.vo;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import carbonit.map.tech.test.business.model.abstracts.Collectable.Collectables;
import carbonit.map.tech.test.business.model.abstracts.Movable.Directions;
import carbonit.map.tech.test.business.model.abstracts.Movable.Moves;
import carbonit.map.tech.test.data.model.vo.abstracts.MapElement;

/**
 * @author Elias
 *
 */
public class AdventurerVO extends MapElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Fields
	private String name;
	private Directions direction;
	private List<Moves> path;
	private Map<Collectables, Integer> collection = new EnumMap<> (Collectables.class);

	// Constructor
	public AdventurerVO(String name, int x, int y, Directions direction, List<Moves> path) {
		super(x, y);
		this.name = name;
		this.direction = direction;
		this.path = path;
	}

	// Getters and setters
	public void setDirection(Directions direction) {
		this.direction = direction;
	}

	public Directions getDirection() {
		return this.direction;
	}

	public List<Moves> getPath() {
		return path;
	}

	public void setPath(List<Moves> path) {
		this.path = path;
	}

	public void setCollection(Map<Collectables, Integer> collection) {
		this.collection = collection;
	}

	public Map<Collectables, Integer> getCollection() {
		return this.collection;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Localizables getLocalizableType() {
		return Localizables.ADVENTURER;
	}

}
