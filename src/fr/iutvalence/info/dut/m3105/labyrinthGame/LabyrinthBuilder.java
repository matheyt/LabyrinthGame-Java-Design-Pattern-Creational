package fr.iutvalence.info.dut.m3105.labyrinthGame;

import java.util.Set;

public interface LabyrinthBuilder {
	
	public LabyrinthBuilder width(int width);

	public LabyrinthBuilder height(int height);

	public LabyrinthBuilder exitPosition(Position exitPosition);

	public LabyrinthBuilder setForbiddenCellsPositions(Set<Position> forbiddenCellsPositions);
	
	public LabyrinthBuilder addForbiddenCellsPosition(Position forbiddenCellsPosition);
	
	public Labyrinth getLabyrinth() throws ExceptionWidthNotNegative,
			ExceptionHeightNotNegative, ExceptionOutOfBoundExitPosition,
			ExceptionUndefinedExitPosition, ExceptionUndefinedForbiddenCellsPositions,
			ExceptionOutOfBoundForbiddenCellPosition;
}
