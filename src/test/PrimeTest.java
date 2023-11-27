package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Prime;

public class PrimeTest {

	Prime prime;

	@BeforeEach
	void initPrime() {
		prime = new Prime();
	}

	@Test
	@DisplayName("Test user input for interval between 0 and 1000")
	void testUserInput() {
		InputStream in = new ByteArrayInputStream("0\n1000\n".getBytes());
		System.setIn(in);
		assertEquals(168, prime.getUserInput());
	}

	@Test
	@DisplayName("Test user input for interval NOT between 0 and 1000")
	void testUserInputWrongInterval() {
		InputStream in = new ByteArrayInputStream("-4\n1000\n".getBytes());
		System.setIn(in);
		assertEquals(-1, prime.getUserInput());
	}

	@Test
	@DisplayName("Test user input for wrong format")
	void testUserInputWrongFormat() {
		InputStream in = new ByteArrayInputStream("a\nb\n".getBytes());
		System.setIn(in);
		assertEquals(-1, prime.getUserInput());
	}

	@Test
	@DisplayName("Test amount of primes")
	void testAmountOfPrimes() {
		prime.calculatePrimes(0, 1000);

		int amount = prime.getPrimes().size();
		assertEquals(168, amount);
	}

	@Test
	@DisplayName("Test sum of primes between 0 and 1000")
	void testSumOfPrimes() {
		assertEquals(76127, prime.calculatePrimes(0, 1000));
	}

}