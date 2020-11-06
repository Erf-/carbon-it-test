/**
 * 
 */
package carbonit.map.tech.test.data.model.vo;

import java.util.List;

import carbonit.map.tech.test.data.model.vo.abstracts.MapElement;

/**
 * @author Elias
 *
 */
public class TreasureMapVO {

	// Fields
	private int width;
	private int length;
	private List<MapElement> mapElements;

	// Constructors
	public TreasureMapVO(int width, int length) {
		this.width = width;
		this.length = length;
	}

	public TreasureMapVO() {}

	// Getters and setters
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public List<MapElement> getMapElements() {
		return mapElements;
	}

	public void setMapElements(List<MapElement> mapElements) {
		this.mapElements = mapElements;
	}

}
