/**
 * 
 */
package carbonit.map.tech.test.business.model.bo;

import java.io.Serializable;

/**
 * @author Elias
 *
 */
public class PositionBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Fields
	private int x;
	private int y;

	// Constructor
	public PositionBO(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	// Methods
	public PositionBO copy() {
		return new PositionBO(this.x, this.y);
	}

	public void translate(int dx, int dy) {
		this.x = this.x + dx;
		this.y = this.y + dy;
	}

	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PositionBO other = (PositionBO) obj;
		if (x != other.x)
			return false;
		return y == other.y;
	}

	// Getters and setters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
