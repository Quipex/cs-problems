function Node(value) {
  this.value = value;
  this.prev = null;
  this.next = null;
}

function Deque() {
  this.left = null;
  this.right = null;
  this.size = 0;
  this.pushRight = function (value) {
    const node = new Node(value);
    if (this.size === 0) {
      this.left = node;
      this.right = node;
    } else {
      this.right.next = node;
      node.prev = this.right;
      this.right = node;
    }
    this.size++;
    return this.size;
  };
  this.popRight = function () {
    if (this.size === 0) return null;
    const removedNode = this.right;
    this.right = this.right.prev;
    if (this.right) this.right.next = null;
    this.size--;
    return removedNode;
  };
  this.pushLeft = function (value) {
    const node = new Node(value);
    if (this.size === 0) {
      this.left = node;
      this.right = node;
    } else {
      this.left.prev = node;
      node.next = this.left;
      this.left = node;
    }
    this.size++;
    return this.size;
  };
  this.popLeft = function () {
    if (this.size === 0) return null;
    const removedNode = this.left;
    this.left = this.left.next;
    if (this.left) this.left.prev = null;
    this.size--;
    return removedNode;
  };
}


/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var maxSlidingWindow = function (nums, k) {
  const deque = new Deque();
  const answer = [];
  let l = 0;
  let r = 0;

  while (r < nums.length) {
    // make sure that the leftmost element is the largest
    while (deque.size && nums[deque.right.value] < nums[r]) {
      deque.popRight();
    }

    deque.pushRight(r);

    // remove old elements
    if (deque.left.value < l) {
      deque.popLeft();
    }

    if (r + 1 >= k) {
      answer.push(nums[deque.left.value]);
      l++;
    }
    r++;
  }
  return answer;
};

// function check(result, expected) {
//   function arraysEqual(arr1, arr2) {
//     // Check if the arrays are the same length
//     if (arr1.length !== arr2.length) {
//       return false;
//     }
//
//     // Check each element in the arrays
//     for (let i = 0; i < arr1.length; i++) {
//       if (arr1[i] !== arr2[i]) {
//         return false;
//       }
//     }
//
//     // If all elements are equal, the arrays are equal
//     return true;
//   }
//
//   let equal;
//
//   if (Array.isArray(result) && Array.isArray(expected)) {
//     equal = arraysEqual(result, expected);
//   } else {
//     equal = result === expected;
//   }
//
//   console.log(equal, { result, expected });
// }
//
// check(maxSlidingWindow([1, 3, -1, -3, 5, 3, 6, 7], 3), [3, 3, 5, 5, 6, 7]);
// check(maxSlidingWindow([6, 7, 4, 3], 2), [7, 7, 4]);
// check(maxSlidingWindow([1, 3, 1, 2, 0, 5], 3), [3, 3, 2, 5]);
// check(maxSlidingWindow([1, 1, 1, 1, 1, 4, 5], 6), [4, 5]);
// check(maxSlidingWindow([8, 7, 6, 9], 2), [8, 7, 9]);
