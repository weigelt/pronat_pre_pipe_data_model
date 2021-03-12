package edu.kit.ipd.pronat.prepipelinedatamodel.token;

import edu.kit.ipd.parse.luna.graph.Pair;
import edu.kit.ipd.pronat.prepipedatamodel.token.Chunk;
import edu.kit.ipd.pronat.prepipedatamodel.token.ChunkIOB;
import edu.kit.ipd.pronat.prepipedatamodel.token.POSTag;
import edu.kit.ipd.pronat.prepipedatamodel.token.Token;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;

/**
 * @author Sebastian Weigelt
 */
public class EqualsTest {
	@Test
	public void StringTokenPairEquals() {
		final Pair<String, Token> stringTokenPair1 = new Pair<String, Token>("4",
				new Token("forty-two", POSTag.CARDINAL_NUMBER, ChunkIOB.UNDEFINED, new Chunk(), 0, 0));
		final Pair<String, Token> stringTokenPair2 = new Pair<String, Token>("4",
				new Token("forty-two", POSTag.CARDINAL_NUMBER, ChunkIOB.UNDEFINED, new Chunk(), 0, 0));
		assertTrue(stringTokenPair1.equals(stringTokenPair2));
		assertEquals(stringTokenPair1.hashCode(), stringTokenPair2.hashCode());
	}

	@Test
	public void StringTokenPairNotEquals() {
		final Pair<String, Token> stringTokenPair1 = new Pair<String, Token>("4",
				new Token("forty-two", POSTag.CARDINAL_NUMBER, ChunkIOB.UNDEFINED, new Chunk(), 0, 0));
		final Pair<String, Token> stringTokenPair2 = new Pair<String, Token>("4",
				new Token("forty-two", POSTag.ADJECTIVE, ChunkIOB.UNDEFINED, new Chunk(), 0, 0));
		assertFalse(stringTokenPair1.equals(stringTokenPair2));
		assertNotEquals(stringTokenPair1.hashCode(), stringTokenPair2.hashCode());
	}
}
