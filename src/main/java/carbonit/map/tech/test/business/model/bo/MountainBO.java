/**
 * 
 */
package carbonit.map.tech.test.business.model.bo;

import carbonit.map.tech.test.business.model.abstracts.Obstacle;
import carbonit.map.tech.test.data.model.vo.MountainVO;

/**
 * @author Elias
 *
 */
public class MountainBO implements Obstacle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Fields
	private MountainVO mountainVO;

	// Constructor
	public MountainBO(int x, int y) {
		this.mountainVO = new MountainVO(x, y);
	}

	// Inherited methods
	@Override
	public PositionBO getPosition() {
		return this.mountainVO.getPosition();
	}

	@Override
	public void setPosition(PositionBO p) {
		this.mountainVO.setPosition(p);
	}

	@Override
	public Localizables getLocalizableType() {
		return this.mountainVO.getLocalizableType();
	}

	// Getters and setters
	public MountainVO getMountainVO() {
		return mountainVO;
	}

	public void setMountainVO(MountainVO mountainVO) {
		this.mountainVO = mountainVO;
	}

}
