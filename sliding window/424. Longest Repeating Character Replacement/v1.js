/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var characterReplacement = function(s, k) {
  let maxFreq = 0
  let answer = 0
  let leftP = 0
  let rightP = 0
  const freqMap = {}

  while (rightP < s.length) {
    const subLen = rightP + 1 - leftP
    const rightLetter = s[rightP]
    freqMap[rightLetter] = (freqMap[rightLetter] ?? 0) + 1
    maxFreq = Math.max(maxFreq, freqMap[rightLetter])
    if ((subLen - maxFreq) <= k) {
      answer = Math.max(answer, subLen)
      rightP++
    } else {
      const leftLetter = s[leftP]
      freqMap[leftLetter] = freqMap[leftLetter] - 1
      leftP++
      rightP++
    }
  }

  return answer
};

console.log(characterReplacement("ABAB", 2), 4)
console.log(characterReplacement("AABABBA", 1), 4)
