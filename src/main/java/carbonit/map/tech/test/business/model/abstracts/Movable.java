/**
 * 
 */
package carbonit.map.tech.test.business.model.abstracts;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.ToIntFunction;

import carbonit.map.tech.test.business.model.bo.PositionBO;
import carbonit.map.tech.test.business.model.bo.TreasureMapBO;

/**
 * @author Elias
 *
 */
public abstract class Movable implements Localizable, Comparable<Movable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum Directions {
		NORTH("N"), EAST("E"), SOUTH("S"), WEST("W"),;

		private String shortValue;

		Directions(String shortValue) {
			this.shortValue = shortValue;
		}

		public String getShort() {
			return shortValue;
		}
	}
	
	public enum Moves {
		FORWARD("A"), LEFT("G"), RIGHT("D"),;

		private String shortValue;

		Moves(String shortValue) {
			this.shortValue = shortValue;
		}

		public String getShort() {
			return shortValue;
		}
	}

	// Fields
	private static final AtomicInteger PRIORITYCOUNTER = new AtomicInteger(0);
	private int priority;

	// Constructor
	public Movable() {
		this.priority =  PRIORITYCOUNTER.incrementAndGet();
	}

	// Abstract methods
	public abstract void setDirection(Directions direction);
	public abstract Directions getDirection();
	public abstract int getCurrentStep();
	public abstract void setCurrentStep(int step);
	public abstract List<Moves> getMoves();

	// Private methods
	private void turn(Moves move) {
		ToIntFunction<Moves> increment = m -> m.equals(Moves.LEFT) ? -1 : 1;
		List<Directions> directions = Arrays.asList(Directions.values());
		int directionsNB = directions.size();
		Directions currentDirection = this.getDirection();
		int currentIndex = directions.indexOf(currentDirection) + 1;
		int finalIndex = ((currentIndex + increment.applyAsInt(move)) % directionsNB) - 1;
		this.setDirection(directions.get(finalIndex));
	}

	private void moveForward(TreasureMapBO card) {
		Directions direction = this.getDirection();
		PositionBO newPosition = this.getPosition().copy();

		switch (direction ) {
		case NORTH:
			newPosition.translate(0, -1);
			break;
		case SOUTH:
			newPosition.translate(0, 1);
			break;
		case EAST:
			newPosition.translate(1, 0);
			break;
		case WEST:
			newPosition.translate(-1, 0);
			break;

		default:
			break;
		}

		// Check position
		int finalX = newPosition.getX();
		int finalY = newPosition.getY();
		if (!(finalX >= 0 && finalX < card.getWidth())) {
			finalX = this.getPosition().getX();
		}
		if (!(finalY >= 0 && finalY < card.getLength())) {
			finalY = this.getPosition().getX();
		}
		newPosition.setLocation(finalX, finalY);
		if (card.getMapElements().get(newPosition).stream()
				.noneMatch(element -> element instanceof Obstacle)) {
			this.setPosition(newPosition);
		}
	}

	// Concrete methods
	public void move(TreasureMapBO card) {
		final int currentStep = this.getCurrentStep();
		if (currentStep >= this.getMoves().size()) {
			return;
		}
		Moves move = this.getMoves().get(currentStep);
		if (move.equals(Moves.FORWARD)) {
			this.moveForward(card);
		} else {
			this.turn(move);
		}
		this.setCurrentStep(currentStep + 1);
	}

	// Getters and setters
	public int getPriority() {
		return priority;
	}

}
