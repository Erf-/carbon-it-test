/**
 * 
 */
package carbonit.map.tech.test.business.model.bo;

import carbonit.map.tech.test.business.model.abstracts.Collectable;
import carbonit.map.tech.test.business.model.abstracts.Placeable;
import carbonit.map.tech.test.data.model.vo.TreasureVO;

/**
 * @author Elias
 *
 */
public class TreasureBO implements Collectable, Placeable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Fields
	private TreasureVO treasureVO;

	// Constructors
	public TreasureBO(int x, int y, int itemsNB) {
		this.treasureVO = new TreasureVO(x, y, itemsNB);
	}

	public TreasureBO(TreasureVO treasureVO) {
		this.treasureVO = treasureVO;
	}

	// Inherited methods
	@Override
	public void place(TreasureMapBO card) {
		if (this.getItemsNB() != 0) {
			Placeable.super.place(card);
		}
	}

	@Override
	public void collect(int nbToSub) {
		int itemsNB = this.treasureVO.getItemsNB();
		int itemsFinalNB = itemsNB >= nbToSub ? itemsNB - nbToSub : 0;
		this.treasureVO.setItemsNB(itemsFinalNB);
	}

	@Override
	public PositionBO getPosition() {
		return this.treasureVO.getPosition();
	}

	@Override
	public void setPosition(PositionBO p) {
		this.treasureVO.setPosition(p);
	}

	@Override
	public Localizables getLocalizableType() {
		return this.treasureVO.getLocalizableType();
	}

	@Override
	public Collectables getCollectionType() {
		return Collectables.TREASURE;
	}

	// Getters and setters
	public TreasureVO getTreasureVO() {
		return treasureVO;
	}

	public void setTreasureVO(TreasureVO treasureVO) {
		this.treasureVO = treasureVO;
	}

}
