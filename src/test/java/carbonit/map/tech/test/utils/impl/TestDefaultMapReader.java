/**
 * 
 */
package carbonit.map.tech.test.utils.impl;

import static carbonit.map.tech.test.constants.TestsConstants.CORRECTMAPDATA;
import static carbonit.map.tech.test.constants.TestsConstants.CORRECTMAPDATAVO;
import static carbonit.map.tech.test.constants.TestsConstants.INCORRECTMAPDATAA;
import static carbonit.map.tech.test.constants.TestsConstants.INCORRECTMAPDATAVOA;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import carbonit.map.tech.test.data.model.vo.TreasureMapVO;

/**
 * @author Elias
 *
 */
@RunWith(Parameterized.class)
public class TestDefaultMapReader {

	private String mapData;
	private TreasureMapVO expectedResult;

	private DefaultMapReaderWriter mapReaderWriter = new DefaultMapReaderWriter();

	public TestDefaultMapReader(String mapData, TreasureMapVO expectedResult) {
		this.expectedResult = expectedResult;
		this.mapData = mapData;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> plop() {
		return Arrays.asList(new Object[][] {
			{CORRECTMAPDATA, CORRECTMAPDATAVO},
			{INCORRECTMAPDATAA, INCORRECTMAPDATAVOA}
		});
	}

	@Test
	public void testDataReading() {
		TreasureMapVO mapVO = new TreasureMapVO();
		this.mapReaderWriter.readStringStream(mapVO, this.mapData.lines());
		assertThat(mapVO.getLength()).isEqualTo(this.expectedResult.getWidth());
		assertThat(mapVO.getWidth()).isEqualTo(this.expectedResult.getLength());
		if (mapVO.getLength() != 0 && mapVO.getWidth() != 0) {
			assertThat(mapVO.getMapElements()).isEqualTo(this.expectedResult.getMapElements());
		}
	}

}
