/**
 * 599. Minimum Index Sum of Two Lists
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/
 * 
 * Suppose Andy and Doris want to choose a restaurant for dinner, 
 * and they both have a list of favorite restaurants represented by strings.
You need to help them find out their common interest with the least list index sum. 
If there is a choice tie between answers, output all of them with no order requirement. 
You could assume there always exists an answer.

Example 1:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".

Example 2:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
 */
/**
 * @param {string[]} list1
 * @param {string[]} list2
 * @return {string[]}
 */
var findRestaurant = function (list1, list2) {
  let res = [];
  let minIndexSum = Math.pow(2, 31);
  let map = new Map();
  for (let i = 0; i < list1.length; i++) {
    map.set(list1[i], i);
  }
  for (let j = 0; j < list2.length; j++) {
    if (map.has(list2[j])) {
      let i = map.get(list2[j]);
      if ((i + j) < minIndexSum) {
        res = [];
        res.push(list2[j]);
        minIndexSum = i + j;
      } else if ((i + j) == minIndexSum) {
        //console.log("equal:"+(i+j));
        res.push(list2[j]);
      }
    }
  }
  console.log(res);
  return res;
};
