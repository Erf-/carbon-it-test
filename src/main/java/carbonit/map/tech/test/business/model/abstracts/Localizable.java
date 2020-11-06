/**
 * 
 */
package carbonit.map.tech.test.business.model.abstracts;

import java.io.Serializable;

import carbonit.map.tech.test.business.model.bo.PositionBO;

/**
 * @author Elias
 *
 */
public interface Localizable extends Serializable {

	public enum Localizables {
		TREASURE("T"), ADVENTURER("A"), MOUNTAIN("M"),;

		private String shortValue;

		Localizables(String shortValue) {
			this.shortValue = shortValue;
		}

		public String getShort() {
			return shortValue;
		}
	}

	public PositionBO getPosition();
	public void setPosition(PositionBO p);
	public Localizables getLocalizableType();

	// Default methods
	public default int getItemsNB() {
		return 1;
	}
}
