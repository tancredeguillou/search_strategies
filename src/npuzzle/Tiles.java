package npuzzle;

import java.util.LinkedHashSet;
import java.util.Set;

import search.Action;
import search.State;

public class Tiles implements State {
	public static final int EMPTY_TILE = 0;
	
	protected final int width;
	protected final int[] tiles;
	protected final int emptyTileRow;
	protected final int emptyTileColumn;
	
	public Tiles(int[][] tiles) {
		width = tiles.length;
		this.tiles = new int[width * width];
		int emptyRow = -1;
		int emptyColumn = -1;
		int index=0;
		for (int row = 0; row < width; row++)
			for (int column = 0; column < width; column++) {
				int tile = tiles[row][column];
				if (tile == EMPTY_TILE) {
					emptyRow = row;
					emptyColumn = column;
				}
				this.tiles[index++] = tile;
			}
		emptyTileRow = emptyRow;
		emptyTileColumn = emptyColumn;
	}
	protected Tiles(int width, int[] tiles, int emptyTileRow, int emptyTileColumn) {
		this.width = width;
		this.tiles = tiles;
		this.emptyTileRow = emptyTileRow;
		this.emptyTileColumn = emptyTileColumn;
	}
	public int getWidth() {
		return width;
	}
	public int getEmptyTileRow() {
		return emptyTileRow;
	}
	public int getEmptyTileColumn() {
		return emptyTileColumn;
	}
	public int getTile(int row, int column) {
		return tiles[row * width + column];
	}
	public Set<Action> getApplicableActions() {
		Set<Action> actions = new LinkedHashSet<Action>();
		for (Movement movement : Movement.values()) {
			int newEmptyTileRow = emptyTileRow + movement.deltaRow;
			int newEmptyTileColumn = emptyTileColumn + movement.deltaColumn;
			if (0 <= newEmptyTileRow && newEmptyTileRow < width && 0 <= newEmptyTileColumn & newEmptyTileColumn < width)
				actions.add(movement);
		}
		return actions;
	}
	public State getActionResult(Action action) {
		Movement movement=(Movement)action;
		int newEmptyTileRow = emptyTileRow + movement.deltaRow;
		int newEmptyTileColumn = emptyTileColumn + movement.deltaColumn;
		int[] newTiles = tiles.clone();
		newTiles[emptyTileRow * width + emptyTileColumn] = getTile(newEmptyTileRow, newEmptyTileColumn);
		newTiles[newEmptyTileRow * width + newEmptyTileColumn] = EMPTY_TILE;
		return new Tiles(width, newTiles, newEmptyTileRow, newEmptyTileColumn);
	}
	
	// one n-puzzle state is equal to another if every tiles are placed in the same way
	@Override
	public boolean equals(Object that) {
		// check the basics
		if (this == that) return true;
		if (that == null) return false;
		if (this.getClass() != that.getClass()) return false;
		
		final Tiles other = (Tiles)that;
		
		// check if the width and empty tile match
		if (this.getWidth() != other.getWidth() || this.getEmptyTileColumn() != other.getEmptyTileColumn()
				|| this.getEmptyTileRow() != other.getEmptyTileRow()) return false;
		
		// now go through all tiles and check that everyone matches
		for (int i = 0; i < this.getWidth(); i++) {
			for (int j = 0; j < this.getWidth(); j++) {
				if (this.getTile(i, j) != other.getTile(i, j)) return false;
			}
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int hash = 0;
		for (int i = 0; i < this.getWidth(); i++) {
			for (int j = 0; j < this.getWidth(); j++) {
				hash += 7*hash + this.getTile(i, j);
			}
		}
		return hash;
	}
	
}
