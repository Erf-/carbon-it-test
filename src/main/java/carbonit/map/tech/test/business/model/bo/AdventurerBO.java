/**
 * 
 */
package carbonit.map.tech.test.business.model.bo;

import java.util.List;
import java.util.Map;

import carbonit.map.tech.test.business.model.abstracts.Collectable;
import carbonit.map.tech.test.business.model.abstracts.Collectable.Collectables;
import carbonit.map.tech.test.business.model.abstracts.Collector;
import carbonit.map.tech.test.business.model.abstracts.Movable;
import carbonit.map.tech.test.business.model.abstracts.Obstacle;
import carbonit.map.tech.test.data.model.vo.AdventurerVO;

/**
 * @author Elias
 *
 */
public class AdventurerBO extends Movable implements Obstacle, Collector {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Fields
	private AdventurerVO adventurerVO;
	private int currentStep = 0;

	// Constructor
	public AdventurerBO(String name, int x, int y, Directions direction, List<Moves> path) {
		super();
		this.adventurerVO = new AdventurerVO(name, x, y, direction, path);
	}

	// Inherited methods
	@Override
	public Localizables getLocalizableType() {
		return this.adventurerVO.getLocalizableType();
	}

	@Override
	public void move(TreasureMapBO card) {
		PositionBO currentPosition = this.getPosition().copy();
		super.move(card);
		if (!currentPosition.equals(this.getPosition())) {
			card.getMapElements().remove(currentPosition);
			this.place(card);
		}
	}

	@Override
	public void place(TreasureMapBO card) {
		card.getMapElements().get(this.getPosition()).stream()
			.filter(element -> element instanceof Collectable)
			.findFirst()
			.map(collectable -> (Collectable) collectable)
			.ifPresent(this::collect);
		Obstacle.super.place(card);
	}

	@Override
	public int compareTo(Movable arg0) {
		return arg0.getPriority() - this.getPriority();
	}

	@Override
	public PositionBO getPosition() {
		return this.adventurerVO.getPosition();
	}

	@Override
	public void setPosition(PositionBO p) {
		this.adventurerVO.setPosition(p);
	}

	@Override
	public Map<Collectables, Integer> getCollection() {
		return this.adventurerVO.getCollection();
	}

	@Override
	public void setDirection(Directions direction) {
		this.adventurerVO.setDirection(direction);
	}

	@Override
	public Directions getDirection() {
		return this.adventurerVO.getDirection();
	}

	// Getters and setters
	public AdventurerVO getAdventurerVO() {
		return adventurerVO;
	}

	public void setAdventurerVO(AdventurerVO adventurerVO) {
		this.adventurerVO = adventurerVO;
	}

	@Override
	public int getCurrentStep() {
		return currentStep;
	}

	public void setCurrentStep(int currentStep) {
		this.currentStep = currentStep;
	}

	@Override
	public List<Moves> getMoves() {
		return this.adventurerVO.getPath();
	}

}
