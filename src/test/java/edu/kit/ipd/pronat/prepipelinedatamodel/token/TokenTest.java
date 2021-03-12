package edu.kit.ipd.pronat.prepipelinedatamodel.token;

import static org.junit.Assert.fail;

import java.util.List;

import edu.kit.ipd.pronat.prepipedatamodel.token.MainHypothesisToken;
import edu.kit.ipd.pronat.prepipedatamodel.token.Token;
import edu.kit.ipd.pronat.prepipedatamodel.tools.StringToHypothesis;
import org.junit.Test;

/**
 * @author Sebastian Weigelt
 */
public class TokenTest {

	@Test
	public void hashNotNull() {
		List<MainHypothesisToken> mhtl = StringToHypothesis.stringToMainHypothesis("Check, one, two!");
		for (MainHypothesisToken mainHypothesisToken : mhtl) {
			// if tokens are created from a mht feed some attributes are null
			Token t = new Token(mainHypothesisToken);
			try {
				t.hashCode();
			} catch (NullPointerException e) {
				fail("NullPointer in hash" + e);
			}
		}
	}
}
