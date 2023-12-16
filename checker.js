function check(result, expected) {
  function arraysEqual(arr1, arr2) {
    // Check if the arrays are the same length
    if (arr1.length !== arr2.length) {
      return false;
    }

    // Check each element in the arrays
    for (let i = 0; i < arr1.length; i++) {
      if (arr1[i] !== arr2[i]) {
        return false;
      }
    }

    // If all elements are equal, the arrays are equal
    return true;
  }
  let equal;

  if (Array.isArray(result) && Array.isArray(expected)) {
    equal = arraysEqual(result, expected)
  } else {
    equal = result === expected
  }

  console.log(equal, { result, expected })
}
