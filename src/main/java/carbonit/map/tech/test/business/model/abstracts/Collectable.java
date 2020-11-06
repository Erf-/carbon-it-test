/**
 * 
 */
package carbonit.map.tech.test.business.model.abstracts;

/**
 * @author Elias
 *
 */
public interface Collectable {

	public enum Collectables {
		TREASURE,
	}

	public void collect(int nbToCollect);
	public Collectables getCollectionType();
}
