/**
 * 0, 1, 2, 3: 4 / 2 = 2 (r)
 * 0, 1, 2: 3 // 2 = 1
 *
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
  const string = sanitized(s);
  if(s.length === 0) {
    return true;
  }
  let left, right;
  if (s.length % 2 === 0) {
    right = (s.length / 2)
    left = right - 1;
  } else {
    const middle = Math.floor(s.length / 2)
    left = middle - 1;
    right = middle + 1;
  }

  while (left >= 0) {
    if (string[left])
    left--;
    right++;
  }
};

function sanitized(str) {
  return str.toLowerCase().replaceAll(/^[a-z]/, "")
}
