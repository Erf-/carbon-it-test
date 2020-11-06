/**
 * 
 */
package carbonit.map.tech.test.utils.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import carbonit.map.tech.test.business.model.abstracts.Localizable.Localizables;
import carbonit.map.tech.test.business.model.abstracts.Movable.Directions;
import carbonit.map.tech.test.business.model.abstracts.Movable.Moves;
import carbonit.map.tech.test.data.model.vo.AdventurerVO;
import carbonit.map.tech.test.data.model.vo.MountainVO;
import carbonit.map.tech.test.data.model.vo.TreasureMapVO;
import carbonit.map.tech.test.data.model.vo.TreasureVO;
import carbonit.map.tech.test.data.model.vo.abstracts.MapElement;
import carbonit.map.tech.test.utils.abstracts.MapReader;
import carbonit.map.tech.test.utils.abstracts.MapWriter;

/**
 * @author Elias
 *
 */
public class DefaultMapReaderWriter implements MapReader, MapWriter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Map<String, Function<String, MapElement>> computerMap;
	private static final String WHITESPACEREGEX = "//s";
	private static final String VALUESSEPARATORR = "-";
	private static final String VALUESSEPARATORW = " - ";
	private static final String NEWLINE = "\n";
	private static final String MAPDESIGNATOR = "C";

	static {
		computerMap = new HashMap<>();
		computerMap.put(Localizables.ADVENTURER.getShort(), DefaultMapReaderWriter::computeAdventurerVO);
		computerMap.put(Localizables.MOUNTAIN.getShort(), DefaultMapReaderWriter::computeMountainVO);
		computerMap.put(Localizables.TREASURE.getShort(), DefaultMapReaderWriter::computeTreasureVO);
	}

	// Private methods
	private MapElement computeMapElement(final String data) {
		if (data != null && !data.isBlank()) {
			String formattedData = formatToRead(data);
			String firstLetter = ("" + formattedData.charAt(0)).toUpperCase();
			Optional.ofNullable(computerMap.get(firstLetter))
			.ifPresent(computer -> computer.apply(formattedData));
		}
		
		return null;
	}

	private static AdventurerVO computeAdventurerVO(final String formattedData) {
		String[] valuesArray = formattedData.split(VALUESSEPARATORR);
		HashMap<String, Directions> directionsMap = new HashMap<>();
		for (Directions direction : Directions.values()) {
			directionsMap.put(direction.getShort(), direction);
		}
		HashMap<String, Moves> movesMap = new HashMap<>();
		for (Moves move : Moves.values()) {
			movesMap.put(move.getShort(), move);
		}
		ArrayList<Moves> moves = new ArrayList<>();
		for (char move : valuesArray[4].toCharArray()) {
			moves.add(movesMap.get(("" + move).toUpperCase()));
		}
		
		return new AdventurerVO(
				valuesArray[0],
				Integer.parseInt(valuesArray[1]),
				Integer.parseInt(valuesArray[2]),
				directionsMap.get(valuesArray[3].toUpperCase()),
				moves
				);
	}
	
	private static MountainVO computeMountainVO(final String formattedData) {
		String[] valuesArray = formattedData.split(VALUESSEPARATORR);
		return new MountainVO(Integer.parseInt(valuesArray[0]),
				Integer.parseInt(valuesArray[1]));
	}
	
	private static TreasureVO computeTreasureVO(final String formattedData) {
		String[] valuesArray = formattedData.split(VALUESSEPARATORR);
		return new TreasureVO(
				Integer.parseInt(valuesArray[0]),
				Integer.parseInt(valuesArray[1]),
				Integer.parseInt(valuesArray[2])
				);
	}

	private static boolean computedTreasureMapVO(final String data, final TreasureMapVO mapVO) {
		if (mapVO.getLength() != 0 && mapVO.getWidth() != 0) {
			return true;
		}
		if (data != null && !data.isBlank()) {
			String formattedData = formatToRead(data);
			String firstLetter = ("" + formattedData.charAt(0));
			if (firstLetter.equalsIgnoreCase(MAPDESIGNATOR)) {
				String[] valuesArray = formattedData.split(VALUESSEPARATORR);
				mapVO.setWidth(Integer.parseInt(valuesArray[0]));
				mapVO.setLength(Integer.parseInt(valuesArray[1]));
				return true;
			}
		}
		return false;
	}

	private static String formatToRead(final String data) {
		return data.replace(WHITESPACEREGEX, "");
	}

	private void addMapElement(final TreasureMapVO mapVO, final MapElement element) {
		Optional.ofNullable(mapVO.getMapElements())
		.orElseGet(() -> {
			List<MapElement> mapElements = new ArrayList<>();
			mapVO.setMapElements(mapElements);
			return mapElements;
		})
		.add(element);
	}

	private String writeString(TreasureMapVO mapVO) {
		StringBuilder builder = new StringBuilder();
		builder.append(String.join(VALUESSEPARATORW, "" + mapVO.getWidth(), "" + mapVO.getLength()));
		builder.append(NEWLINE);
		mapVO.getMapElements().stream()
		.forEach(mapElement -> {
			builder.append(mapElement.toString());
			builder.append(NEWLINE);
		});
		return builder.toString();
	}

	// Inherited methods
	@Override
	public TreasureMapVO read(File mapDataFile) throws IOException {
		TreasureMapVO mapVO = new TreasureMapVO();
		if (mapDataFile.canRead()) {
			try (Stream<String> mapData = Files.lines(Path.of(mapDataFile.toURI()))) {
				readStringStream(mapVO, mapData);
			}
		}
		return mapVO.getLength() != 0 && mapVO.getWidth() != 0 ? mapVO : null;
	}

	public void readStringStream(TreasureMapVO mapVO, Stream<String> mapData) {
		mapData.map(line -> line != null ? line.trim() : line)
		.filter(curLine -> curLine != null && !curLine.isBlank() && !computedTreasureMapVO(curLine, mapVO))
		.map(this::computeMapElement)
		.forEach(element -> addMapElement(mapVO, element));
	}

	@Override
	public void write(TreasureMapVO mapVO, File destination) throws IOException {
		Files.writeString(destination.toPath(), writeString(mapVO));
	}

}
