/**
 * 
 */
package carbonit.map.tech.test.data.model.vo;

import carbonit.map.tech.test.business.model.abstracts.Collectable.Collectables;
import carbonit.map.tech.test.data.model.vo.abstracts.MapElement;

/**
 * @author Elias
 *
 */
public class TreasureVO extends MapElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Fields
	private int itemsNB;

	// Constructor
	public TreasureVO(int x, int y, int itemsNB) {
		super(x, y);
		this.itemsNB = itemsNB;
	}

	public Collectables getCollectionType() {
		return Collectables.TREASURE;
	}

	// Getters and setters
	@Override
	public int getItemsNB() {
		return this.itemsNB;
	}

	public void setItemsNB(int boxes) {
		this.itemsNB = boxes;
	}

	@Override
	public Localizables getLocalizableType() {
		return Localizables.TREASURE;
	}

}
