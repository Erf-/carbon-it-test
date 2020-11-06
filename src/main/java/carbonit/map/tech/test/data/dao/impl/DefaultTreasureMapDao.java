/**
 * 
 */
package carbonit.map.tech.test.data.dao.impl;

import java.io.File;
import java.io.IOException;

import carbonit.map.tech.test.data.dao.TreasureMapDao;
import carbonit.map.tech.test.data.model.vo.TreasureMapVO;
import carbonit.map.tech.test.utils.abstracts.MapReader;
import carbonit.map.tech.test.utils.abstracts.MapWriter;

/**
 * @author Elias
 *
 */
public class DefaultTreasureMapDao implements TreasureMapDao {

	public static final String OUTPUT_RESULT_TXT = "output-result.txt";

	// Fields
	private MapReader mapReader;
	private MapWriter mapWriter;

	// Constructors
	public DefaultTreasureMapDao(MapReader mapReader, MapWriter mapWriter) {
		this.mapReader = mapReader;
		this.mapWriter = mapWriter;
	}

	// Inherited methods
	@Override
	public TreasureMapVO load(String mapDataFile) {
		try {
			return mapReader.read(new File(mapDataFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void save(TreasureMapVO convertToVO) {
		try {
			mapWriter.write(convertToVO, new File(OUTPUT_RESULT_TXT));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Getters and setters
	public MapReader getMapReader() {
		return mapReader;
	}

	public void setMapReader(MapReader mapReader) {
		this.mapReader = mapReader;
	}

	public MapWriter getMapWriter() {
		return mapWriter;
	}

	public void setMapWriter(MapWriter mapWriter) {
		this.mapWriter = mapWriter;
	}
}
