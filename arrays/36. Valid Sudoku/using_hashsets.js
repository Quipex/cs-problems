/**
 * @param {string[][]} board
 * @return {boolean}
 */
var isValidSudoku = function(board) {
  const HEIGHT = board.length;
  const WIDTH = board[0]?.length ?? 0;
  // going through the rows
  for (let i = 0; i < HEIGHT; i++) {
    const set = new Set();
    for (let j = 0; j < WIDTH; j++) {
      const currentElement = board[i][j];
      if (isBoardInvalid(set, currentElement)) {
        return false;
      }
    }
  }
  // cols
  for (let j = 0; j < WIDTH; j++) {
    const set = new Set();
    for (let i = 0; i < HEIGHT; i++) {
      const currentElement = board[i][j];
      if (isBoardInvalid(set, currentElement)) {
        return false;
      }
    }
  }
  // squares 3x3
  const sets = {};
  for (let i = 0; i < HEIGHT; i++) {
    for (let j = 0; j < WIDTH; j++) {
      const squareX = Math.floor(i / 3); // because squares are 3x3
      const squareY = Math.floor(j / 3);
      const currentElement = board[i][j];
      const setIndex = `${squareX}${squareY}`;
      if (sets[setIndex] === undefined) {
        sets[setIndex] = new Set();
      }
      const designatedSet = sets[setIndex];
      if (isBoardInvalid(designatedSet, currentElement)) {
        return false;
      }
    }
  }
  return true;
};

function isBoardInvalid(set, element) {
  if (element === '.') {
    return false;
  }
  if (set.has(element)) {
    return true;
  }
  set.add(element);
  return false;
}
