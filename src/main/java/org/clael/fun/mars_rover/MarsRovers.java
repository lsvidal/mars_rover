package org.clael.fun.mars_rover;

public class MarsRovers {

	public String[] solve(final String[] input) {

		// Parse plateau dimensions
		final String[] dimensions = input[0].split(" ");
		final int x = Integer.parseInt(dimensions[0]);
		final int y = Integer.parseInt(dimensions[1]);

		// Parse and send commands to robots
		final int nRobots = (input.length - 1) / 2;
		final String[] resp = new String[nRobots];
		int j = 0;
		for (int i = 1; i < input.length; i += 2) {
			resp[j++] = getPosition(input[i], input[i + 1], x, y);
		}
		return resp;
	}

	private final String mapDirections = "NESW";
	private final int[] moveX = {0, 1, 0, -1};
	private final int[] moveY = {1, 0, -1, 0};
	
	private String getPosition(final String position, final String commands, final int maxX, final int maxY) {
		final String[] pos = position.split(" ");
		int x = Integer.parseInt(pos[0]);
		int y = Integer.parseInt(pos[1]);
		int direction = mapDirections.indexOf(pos[2].charAt(0));

		for (final char command : commands.toCharArray()) {
			switch (command) {
			case 'L': direction = (direction + 3) % 4;				
				break;
			case 'R': direction = (direction + 1) % 4;
				break;
			case 'M': x += moveX[direction];
					  y += moveY[direction];
			}
			if (x < 0 || x > maxX || y < 0 || y > maxY) {
				return "FELL";
			}
		}
		return String.valueOf(x) + " " + String.valueOf(y) + " " + mapDirections.charAt(direction);
	}
}
