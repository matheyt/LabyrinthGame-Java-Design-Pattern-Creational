package fr.iutvalence.info.dut.m3105.labyrinthGame;

import java.util.HashSet;
import java.util.Set;

public class SimpleLabyrinthBuilder implements LabyrinthBuilder {
	
	private int width;
	private int height;
	private Position exitPosition;
	private Set<Position> forbiddenCellsPositions;
	
	public SimpleLabyrinthBuilder(){
		this.forbiddenCellsPositions = new HashSet<Position>();
	}
	
	public LabyrinthBuilder width(int width){
		this.width = width;
		return this;
	}

	public LabyrinthBuilder height(int height){
		this.height = height;
		return this;
	}

	public LabyrinthBuilder exitPosition(Position exitPosition){
		this.exitPosition = exitPosition;
		return this;
	}

	public LabyrinthBuilder setForbiddenCellsPositions(Set<Position> forbiddenCellsPositions){
		this.forbiddenCellsPositions = forbiddenCellsPositions;
		return this;
	}
	
	public LabyrinthBuilder addForbiddenCellsPosition(Position forbiddenCellsPosition){
		this.forbiddenCellsPositions.add(forbiddenCellsPosition);
		return this;
	}
	
	public Labyrinth getLabyrinth() throws ExceptionWidthNotNegative, ExceptionHeightNotNegative,
				ExceptionOutOfBoundExitPosition, ExceptionUndefinedExitPosition,
				ExceptionUndefinedForbiddenCellsPositions, ExceptionOutOfBoundForbiddenCellPosition{
		if(this.width<=0)
			throw new ExceptionWidthNotNegative();
		if(this.height<=0)
			throw new ExceptionHeightNotNegative();
		if(this.exitPosition==null)
			throw new ExceptionUndefinedExitPosition();
		if(this.exitPosition.getX()<0 || this.exitPosition.getX()>this.width 
				|| this.exitPosition.getY()<0 || this.exitPosition.getY()>this.height)
			throw new ExceptionOutOfBoundExitPosition();
		if(this.forbiddenCellsPositions.isEmpty())
			throw new ExceptionUndefinedForbiddenCellsPositions();
		if(this.checkForbiddenCellsPositions()==false)
			throw new ExceptionOutOfBoundForbiddenCellPosition();
		return new Labyrinth(this.width,this.height,this.forbiddenCellsPositions,this.exitPosition);
	}

	private boolean checkForbiddenCellsPositions() {
		for (Position position : forbiddenCellsPositions) {
			if (position.getX()<0 || position.getX()>this.width 
					|| position.getY()<0 || position.getY()>this.height)
				return false;
		}
		return true;
	}
}
