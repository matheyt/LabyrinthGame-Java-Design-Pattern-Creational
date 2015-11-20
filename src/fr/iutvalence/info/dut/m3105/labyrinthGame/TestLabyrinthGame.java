package fr.iutvalence.info.dut.m3105.labyrinthGame;

import java.util.HashSet;
import java.util.Set;
/**
 * Test application for labyrinth game
 * 
 */
public class TestLabyrinthGame
{
	/**
	 * Application's main
	 * 
	 * @param args
	 *            command-line arguments (none expected here)
	 * @throws ExceptionOutOfBoundExitPosition 
	 * @throws ExceptionHeightNotNegative 
	 * @throws ExceptionWidthNotNegative 
	 * @throws ExceptionOutOfBoundForbiddenCellPosition 
	 * @throws ExceptionUndefinedForbiddenCellsPositions 
	 * @throws ExceptionUndefinedExitPosition 
	 */
	public static void main(String[] args) throws ExceptionWidthNotNegative, ExceptionHeightNotNegative, ExceptionOutOfBoundExitPosition, ExceptionUndefinedExitPosition, ExceptionUndefinedForbiddenCellsPositions, ExceptionOutOfBoundForbiddenCellPosition
	{
		String typeRobot = "LDR";
		Set<Position> blockPositions = new HashSet<Position>();
		blockPositions.add(new Position(2,0));
		blockPositions.add(new Position(3,0));
		blockPositions.add(new Position(0,1));
		blockPositions.add(new Position(0,2));
		blockPositions.add(new Position(1,2));
		blockPositions.add(new Position(3,2));
		blockPositions.add(new Position(3,3));
		
		//new LabyrinthGame(new Labyrinth(4, 4, blockPositions, new Position(3,1)), RobotMaker.createRobot(typeRobot)).play();
		
		Labyrinth lab = new SimpleLabyrinthBuilder().width(4).height(4).exitPosition(new Position(3,1)).setForbiddenCellsPositions(blockPositions).getLabyrinth();
		new LabyrinthGame(lab,RobotMaker.createRobot(typeRobot)).play();
	}
}
