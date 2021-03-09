package search;

import npuzzle.Tiles;

public class MisplacedTilesHeuristicFunction implements NodeFunction {
	
	@Override
	public int nodeFunction(Node node) {
		int result = 0;
		Tiles tiles = (Tiles) node.state;
		int width = tiles.getWidth();
		int[] tilesArray = tiles.getTiles();
		int lastTileIndex = width * width - 1;
		for (int index = lastTileIndex - 1; index >=0; --index) {
			if (tilesArray[index] != index + 1) {
				result++;
			}
		}
		if (tilesArray[lastTileIndex] != Tiles.EMPTY_TILE) {
			result++;
		}
		return result;
	}

}
