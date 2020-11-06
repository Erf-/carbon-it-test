package carbonit.map.tech.test.business.model.abstracts;

import java.util.List;

import carbonit.map.tech.test.business.model.bo.TreasureMapBO;

public interface Placeable extends Localizable {

	public default void place(TreasureMapBO card) {
		if (checkBoundaries(card) && checkObstacle(card)) {
			card.getMapElements().compute(this.getPosition(), (key, value) -> {
				value.add(this);
				return value;
			});
		}
	}

	private boolean checkBoundaries(TreasureMapBO card) {
		return 0 <= this.getPosition().getX()
				&& this.getPosition().getX() < card.getWidth()
				&& 0 <= this.getPosition().getY()
				&& this.getPosition().getY() < card.getLength();
	}

	private boolean checkObstacle(TreasureMapBO card) {
		List<Localizable> listOfElements = card.getMapElements().get(this.getPosition());
		return listOfElements == null
				|| listOfElements.isEmpty()
				|| listOfElements.stream().anyMatch(element -> element instanceof Obstacle);
	}
}
