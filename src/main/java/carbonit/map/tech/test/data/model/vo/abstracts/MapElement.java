/**
 * 
 */
package carbonit.map.tech.test.data.model.vo.abstracts;

import carbonit.map.tech.test.business.model.abstracts.Localizable;
import carbonit.map.tech.test.business.model.bo.PositionBO;

/**
 * @author Elias
 *
 */
public abstract class MapElement implements Localizable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String SEPARATOR = " - ";
	// Fields
	private PositionBO position;

	// Constructors
	public MapElement(int x, int y) {
		super();
		this.position = new PositionBO(x, y);
	}

	// Inherited methods
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getLocalizableType().getShort())
		.append(SEPARATOR)
		.append(this.position.getX())
		.append(SEPARATOR)
		.append(this.position.getY());
		return builder.toString();
	}

	// Getters and setters
	public PositionBO getPosition() {
		return position;
	}

	public void setPosition(PositionBO position) {
		this.position = position;
	}
}
