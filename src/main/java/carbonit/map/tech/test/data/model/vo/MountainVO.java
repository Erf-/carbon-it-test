/**
 * 
 */
package carbonit.map.tech.test.data.model.vo;

import carbonit.map.tech.test.data.model.vo.abstracts.MapElement;

/**
 * @author Elias
 *
 */
public class MountainVO extends MapElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Constructor
	public MountainVO(int x, int y) {
		super(x, y);
	}

	@Override
	public Localizables getLocalizableType() {
		return Localizables.MOUNTAIN;
	}

}
