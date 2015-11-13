package fr.iutvalence.info.dut.m3105.labyrinthGame;

public class RobotMaker {
	/**
	 * 
	 * @return RobotAI
	 */
	public static RobotArtificialIntelligence createRobot(String typeRobot)
	{
		switch (typeRobot)
		{
		case "LDR":
			return new LesserDumbBotArtificialIntelligence();
		case "DR":
			return new DumbBotArtificialIntelligence();
		default:
			return new DumbBotArtificialIntelligence();
		}
	}
}
