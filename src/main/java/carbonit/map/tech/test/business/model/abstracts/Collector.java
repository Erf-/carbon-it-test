/**
 * 
 */
package carbonit.map.tech.test.business.model.abstracts;

import java.util.Map;

import carbonit.map.tech.test.business.model.abstracts.Collectable.Collectables;

/**
 * @author Elias
 *
 */
public interface Collector {

	public Map<Collectables, Integer> getCollection();

	// Default methods
	public default void collect(Collectable collectable) {
		final Collectables type = collectable.getCollectionType();
		int itemsNB = this.getCollection().getOrDefault(type, 0);
		this.getCollection().put(type, itemsNB + 1);
		collectable.collect(1);
	}
}
