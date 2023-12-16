/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
var minWindow = function (s, t) {
  const targetFreq = {}, slidingWindowFreq = {};
  let minWindow = [0, 0];
  let minWindowLen = Number.MAX_SAFE_INTEGER;

  for (let ch of t) {
    targetFreq[ch] = (targetFreq[ch] ?? 0) + 1;
  }

  let neededCharacters = Object.keys(targetFreq).length;
  let windowCharacters = 0;

  let leftP = 0, rightP = 0;
  while (rightP < s.length) {
    if (windowCharacters === neededCharacters) {
      if (rightP - leftP + 1 < minWindowLen) {
        minWindow = [leftP, rightP];
        minWindowLen = rightP - leftP + 1;
      }

      const leftCh = s[leftP];
      slidingWindowFreq[leftCh]--;
      if ((leftCh in targetFreq) && (slidingWindowFreq[leftCh] < targetFreq[leftCh])) {
        windowCharacters--;
      }
      leftP++;
    } else {
      const rightCh = s[rightP];
      slidingWindowFreq[rightCh] = (slidingWindowFreq[rightCh] ?? 0) + 1;
      if ((rightCh in targetFreq) && (slidingWindowFreq[rightCh] === targetFreq[rightCh])) {
        windowCharacters++;
      }
    }
    if (windowCharacters !== neededCharacters) {
      rightP++;
    }
  }

  return minWindowLen !== Number.MAX_SAFE_INTEGER
         ? s.substring(minWindow[0], minWindow[1] + 1)
         : "";
};

function out(val, target) {
  console.log({ val, target, success: val === target });
}

out(minWindow("ADOBECODEBANC", "ABC"), "BANC");
out(minWindow("a", "a"), "a");
out(minWindow("a", "aa"), "");
