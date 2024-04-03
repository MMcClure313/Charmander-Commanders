import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class JUnitTests {

	HangmanGame gameTest;
	WordGenerator generate;
	@BeforeAll
	void setUpBeforeClass() throws Exception {
		Observer obv = null;
		gameTest = new HangmanGame("default_words.csv", obv, "hard");
		generate = new WordGenerator("default_words.csv");
	}

	@Test
	void guessTest() {
		
		assertEquals(gameTest.guessLetter('b'), true);
		assertEquals(gameTest.guessLetter('b'), false);
	
	}
	
	@Test
	void generateTest() {
		String s = generate.getRandomWord();
		assert(!s.isEmpty());
	}

}
