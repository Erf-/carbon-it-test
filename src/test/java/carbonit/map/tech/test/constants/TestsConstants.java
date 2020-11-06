/**
 * 
 */
package carbonit.map.tech.test.constants;

import java.util.ArrayList;
import java.util.List;

import carbonit.map.tech.test.data.model.vo.TreasureMapVO;
import carbonit.map.tech.test.data.model.vo.abstracts.MapElement;

/**
 * @author Elias
 *
 */
public class TestsConstants {

	public static final String CORRECTMAPDATA = "C - 3 - 4\n"
			+ "M - 1 - 0\n"
			+ "M - 2 - 1\n"
			+ "T - 0 - 3 - 2\n"
			+ "T - 1 - 3 - 3\n"
			+ "A - Lara - 1 - 1 - S - AADADAGGA";
	public static final TreasureMapVO CORRECTMAPDATAVO;
	// bad format of map
	public static final String INCORRECTMAPDATAA = "M - 1 - 0\n"
			+ "M - 2 - 1\n"
			+ "T - 0 - 3 - 2\n"
			+ "T - 1 - 3 - 3\n"
			+ "A - Lara - 1 - 1 - S - AADADAGGA";
	public static final TreasureMapVO INCORRECTMAPDATAVOA;
	// bad format of treasure
	public static String INCORRECTMAPDATAB = "C - 3 - 4\n"
			+ "M - 1 - 0\n"
			+ "M - 2 - 1\n"
			+ "T - 0 - 3 - 2\n"
			+ "T - 1 - 3 - 0\n"
			+ "A - Lara - 1 - 1 - S - AADADAGGA";
	public static final TreasureMapVO INCORRECTMAPDATAVOB;
	// bad format of adventurer
	public static String INCORRECTMAPDATAC = "C - 3 - 4\n"
			+ "M - 1 - 0\n"
			+ "M - 2 - 1\n"
			+ "T - 0 - 3 - 2\n"
			+ "T - 1 - 3 - 3\n"
			+ "A - Lara - 4 - 1 - S - AADADAGGA";
	public static final TreasureMapVO INCORRECTMAPDATAVOC;
	// bad format of mountain
	public static final String INCORRECTMAPDATAD = "C - 3 - 4\n"
			+ "M - 4 - 0\n"
			+ "M - 2 - 1\n"
			+ "T - 0 - 3 - 2\n"
			+ "T - 1 - 3 - 3\n"
			+ "A - Lara - 1 - 1 - S - AADADAGGA";
	public static final TreasureMapVO INCORRECTMAPDATAVOD;

	static {
		CORRECTMAPDATAVO = new TreasureMapVO(3, 4);
		List<MapElement> mapElements = new ArrayList<>();
		CORRECTMAPDATAVO.setMapElements(mapElements);
		INCORRECTMAPDATAVOA = new TreasureMapVO();
		INCORRECTMAPDATAVOB = new TreasureMapVO();
		INCORRECTMAPDATAVOC = new TreasureMapVO();
		INCORRECTMAPDATAVOD = new TreasureMapVO();
	}

}
