/**
 * 
 */
package carbonit.map.tech.test.business.model.bo;

import java.util.List;
import java.util.Map;

import carbonit.map.tech.test.business.model.abstracts.Localizable;
import carbonit.map.tech.test.data.model.vo.TreasureMapVO;

/**
 * @author Elias
 *
 */
public class TreasureMapBO {

	// Fields
	private TreasureMapVO treasureMapVO;
	private Map<PositionBO, List<Localizable>> mapElements;

	// Constructors
	public TreasureMapBO(int width, int length) {
		this.setTreasureMapVO(new TreasureMapVO(width, length));
	}

	public TreasureMapBO(TreasureMapVO treasureMapVO) {
		this.treasureMapVO = treasureMapVO;
	}

	// Methods
	public Map<PositionBO, List<Localizable>> getMapElements() {
		return this.mapElements;
	}

	public double getWidth() {
		return this.treasureMapVO.getWidth();
	}

	public double getLength() {
		return this.treasureMapVO.getLength();
	}

	// Getters and setters
	public TreasureMapVO getTreasureMapVO() {
		return treasureMapVO;
	}

	public void setTreasureMapVO(TreasureMapVO treasureMapVO) {
		this.treasureMapVO = treasureMapVO;
	}

	public void setMapElements(Map<PositionBO, List<Localizable>> mapElements) {
		this.mapElements = mapElements;
	}

}
