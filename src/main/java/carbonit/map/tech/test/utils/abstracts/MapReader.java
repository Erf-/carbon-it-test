/**
 * 
 */
package carbonit.map.tech.test.utils.abstracts;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import carbonit.map.tech.test.data.model.vo.TreasureMapVO;

/**
 * @author Elias
 *
 */
public interface MapReader extends Serializable {

	public TreasureMapVO read(File mapDataFile) throws IOException;
}
