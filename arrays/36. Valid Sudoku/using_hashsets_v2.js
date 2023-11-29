/**
 * @param {string[][]} board
 * @return {boolean}
 */
var isValidSudoku = function (board) {
  const HEIGHT = board.length;
  const WIDTH = board[0]?.length ?? 0;
  const rowSets = {};
  const colSets = {};
  const squareSets = {};
  // going through the rows
  for (let r = 0; r < HEIGHT; r++) {
    for (let c = 0; c < WIDTH; c++) {
      const currentElement = board[r][c];
      if (currentElement === '.') {
        continue;
      }
      const rowSet = getOrInitSet(rowSets, r);
      const colSet = getOrInitSet(colSets, c);
      const squareSet = getOrInitSet(squareSets, `${Math.floor(r / 3)}${Math.floor(c / 3)}`);
      if (rowSet.has(currentElement) ||
        colSet.has(currentElement) ||
        squareSet.has(currentElement)) {
        return false;
      }
      rowSet.add(currentElement);
      colSet.add(currentElement);
      squareSet.add(currentElement);
    }
  }
  return true;
};

function getOrInitSet(obj, index) {
  if (obj[index] === undefined) {
    obj[index] = new Set();
  }
  return obj[index];
}
