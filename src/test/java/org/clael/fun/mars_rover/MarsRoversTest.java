package org.clael.fun.mars_rover;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarsRoversTest {

	@Test
	public void test0() {
		final String[] input = { "5 5", "1 2 N", "LMLMLMLMM", "3 3 E", "MMRMMRMRRM", };
		final String[] answer = { "1 3 N", "5 1 E"};
	
		runTest(input, answer);
	}

	@Test
	public void test1() {
		final String[] input = { "5 5", "1 2 N", "LLMMMM",};
		final String[] answer = { "FELL"};
	
		runTest(input, answer);
	}
	
	@Test
	public void test2() {
		final String[] input = { "5 5", "3 3 E", "MMRMMRMRRM", "1 2 N", "LLMMMM",};
		final String[] answer = { "5 1 E", "FELL",};
	
		runTest(input, answer);
	}
	
	private void runTest(final String[] input, final String[] answer) {
		final String[] output = new MarsRovers().solve(input);
		for (String robot : output) {
			System.out.println(robot);
		}
		
		if (answer.length != output.length) {
			fail("Wrong numbers of robots, expected " + answer.length + " but received " + output.length);
		}
		
		for (int i = 0;  i < answer.length; i++) {
			if (!answer[i].equals(output[i])) {
				fail("Expected robot at (" + answer[1] +") but received (" + output[i] +")");
			}
		}
	}
}
