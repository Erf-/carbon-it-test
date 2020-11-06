/**
 * 
 */
package carbonit.map.tech.test.data.dao;

import carbonit.map.tech.test.data.model.vo.TreasureMapVO;

/**
 * @author Elias
 *
 */
public interface TreasureMapDao {

	public TreasureMapVO load(String mapDataFile);
	public void save(TreasureMapVO convertToVO);

}
