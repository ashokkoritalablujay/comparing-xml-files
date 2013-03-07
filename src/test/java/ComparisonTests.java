import java.io.InputStream;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class ComparisonTests {

	@Test
	public void testComparisonWithString() throws Exception {
		String person1 = getContent("/person-1.xml");
		String person2 = getContent("/person-2.xml");
		Assert.assertNotEquals(person1, person2);
	}

	@Test
	public void testComparisonWithCanonicalization() throws Exception {
		String person1 = XMLUtil.canonicalizeXML(getContent("/person-1.xml"));
		String person2 = XMLUtil.canonicalizeXML(getContent("/person-2.xml"));
		Assert.assertEquals(person1, person2);
	}

	private String getContent(String resourceName) throws Exception {
		try (InputStream is = this.getClass().getResourceAsStream(resourceName)) {
			return new Scanner(is, "UTF-8").useDelimiter("\\A").next();
		}
	}

}
