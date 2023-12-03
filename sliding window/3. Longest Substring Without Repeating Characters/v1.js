/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function (s) {
  let longestSubstr = 0;
  let leftP = 0;
  let rightP = 0;
  let visited = new Set();
  while ((rightP < s.length) && ((s.length - leftP) >= longestSubstr)) {
    const char = s[rightP];

    if (visited.has(char)) {
      visited.clear();
      leftP++;
      rightP = leftP;
      continue;
    }

    visited.add(char);
    longestSubstr = Math.max(longestSubstr, visited.size);
    rightP++;
  }
  return longestSubstr;
};
