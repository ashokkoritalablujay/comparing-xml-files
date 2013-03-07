import java.nio.file.Files;
import java.nio.file.Path;

import com.sun.org.apache.xml.internal.security.Init;
import com.sun.org.apache.xml.internal.security.c14n.Canonicalizer;

class XMLUtil {
	public static String canonicalizeXML(String text) throws Exception {
		// initialize the canonicalization API
		Init.init();
		// create the canonicalizer
		Canonicalizer canon = Canonicalizer
				.getInstance(Canonicalizer.ALGO_ID_C14N_OMIT_COMMENTS);
		// canonicalize String containing XML code
		return new String(canon.canonicalize(text.getBytes()));
	}
}