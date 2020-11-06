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
public interface MapWriter extends Serializable {

	public void write(TreasureMapVO mapVO, File destination) throws IOException;
}
