const alphabet = "abcdefghijklmnopqrstuvwxyz";

/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
var checkInclusion = function (s1, s2) {
  if (s1.length > s2.length) {
    return false;
  }
  const s1FreqMap = calcFreqMap(s1);
  let leftP = 0;
  let rightP = s1.length - 1;
  const s2FreqMap = calcFreqMap(s2.substring(leftP, rightP + 1));
  let matchingCharFreq = compareCharFreq(s1FreqMap, s2FreqMap);

  while (rightP < s2.length) {
    const substr = s2.substring(leftP, rightP + 1)
    if (matchingCharFreq === alphabet.length) {
      return true;
    }
    const leftPChar = s2[leftP];
    s2FreqMap[leftPChar]--;
    leftP++;
    if (s2FreqMap[leftPChar] === s1FreqMap[leftPChar]) {
      matchingCharFreq++
    }
    if ((s2FreqMap[leftPChar] + 1) === s1FreqMap[leftPChar]) {
      matchingCharFreq--
    }

    const rightPChar = s2[rightP + 1];
    s2FreqMap[rightPChar]++;
    rightP++;
    if (s2FreqMap[rightPChar] === s1FreqMap[rightPChar]) {
      matchingCharFreq++
    }
    if ((s2FreqMap[rightPChar] - 1) === s1FreqMap[rightPChar]) {
      matchingCharFreq--
    }
  }
  return false;
};

function calcFreqMap(s) {
  const freqMap = {};
  s.split("").forEach(ch => {
    freqMap[ch] = (freqMap[ch] ?? 0) + 1;
  });
  alphabet.split("").forEach(letter => {
    if (freqMap[letter] === undefined) {
      freqMap[letter] = 0;
    }
  });
  return freqMap;
}

function compareCharFreq(freq1, freq2) {
  let matching = 0;
  alphabet.split("").forEach(letter => {
    if (freq1[letter] === freq2[letter]) {
      matching++;
    }
  });
  return matching;
}

console.log(checkInclusion("ab", "eidbaooo") === true);
console.log(checkInclusion("ab", "eidboaoo") === false);
console.log(checkInclusion("adc", "dcda") === true);
console.log(checkInclusion("abc", "ccccbbbbaaaa") === false);
