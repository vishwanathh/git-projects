import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.demo.caching.impl.InMemoryCache;

/**
 * @author evishha
 *
 */
public class CacheTest {
	
	private static InMemoryCache cache = new InMemoryCache();
	

	@Before
	public void setup() {
		cache.add("key-1", "value1", 10000);
		cache.add("key-2", "value2", 20000);
		cache.add("key-3", "value3", 30000);
	}
	
	@Test
	public void testCacheSize() {
		Assert.assertEquals(3, cache.size());
	}
	
	@Test
	public void testCacheGet() {
		Assert.assertEquals(cache.get("key-2"), "value2");
	}
	
	@Test
	public void testCacheRemove() {
		cache.remove("key-1");
		Assert.assertNull(cache.get("key-1"));
	}

}
