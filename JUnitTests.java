import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class JUnitTests {

	static HangmanGame gameTest;
	static WordGenerator generate;
	static Observer obv;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		gameTest = new HangmanGame("test_words.csv", obv, "hard");
		generate = new WordGenerator("test_words.csv");
	}

	@Test
	void guessTest() {
		
		assertEquals(gameTest.guessLetter('t'), true);
		assertEquals(gameTest.guessLetter('t'), false);
		assertEquals(gameTest.guessLetter('x'), false);
	}
	
	@Test
	void generateTest() {
		String s = generate.getRandomWord();
		assertEquals(s.contains("testing"), true);
	}


}
