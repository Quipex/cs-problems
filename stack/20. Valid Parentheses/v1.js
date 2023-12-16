const PARENTHESES_MAP = {
  "(": ")",
  "{": "}",
  "[": "]"
}

/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
  if (s.length % 2 !== 0) {
    return false;
  }
  const openParentheses = [];
  for (let ch of s) {
    if (Object.keys(PARENTHESES_MAP).includes(ch)) {
      openParentheses.push(ch)
      continue;
    }

    if (openParentheses.length === 0) {
      return false;
    }

    const lastOpenParentheses = openParentheses.pop();
    if (ch !== PARENTHESES_MAP[lastOpenParentheses]) {
      return false;
    }
  }

  return openParentheses.length === 0;
};

const q1 = "({}[)]"
console.log(q1, isValid(q1), false)
const q2 = "(){}[]"
console.log(q2, isValid(q2), true)
