/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
  if (s.length !== t.length) {
    return false;
  }

  const sDict = gatherDict(s);
  const tDict = gatherDict(t);
  const sKeys = Object.keys(sDict);
  for (const k of sKeys) {
    if (sDict[k] !== tDict[k]) {
      return false;
    }
  }
  return true;
};

function gatherDict(word) {
  const dict = {};
  for (const letter of word) {
    const stored = dict[letter];
    if (stored !== undefined) {
      dict[letter] = stored + 1;
    } else {
      dict[letter] = 1;
    }
  }
  return dict;
}

let anagram = isAnagram("rat", "car");
console.log(anagram)
