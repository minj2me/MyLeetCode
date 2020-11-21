/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
Note:
The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function (nums1, m, nums2, n) {
    let totalCount = m + n;
    let nums2Index = 0;
    while (m < totalCount) {
        nums1[m] = nums2[nums2Index];
        m++;
        nums2Index++;
    }
    //console.log(nums1);
    //sort again
    bubbleSort(nums1);
    console.log(nums1);
};

var bubbleSort = function (nums) {
    for (let i = 0; i < nums.length - 1; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            if (nums[i] > nums[j]) {
                let temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;//put the bigger one in behind
            }
        }
    }
}

var swap = function (arr, i, j) {
    let temp = arr[j];
    arr[j] = arr[i];
    arr[i] = temp;
};

var quickSort = function (arr, low, high) {
    if (low < high) {
        /* pi is partitioning index, arr[pi] is 
              now at right place */
        let storeIndex = quickSortPartition(arr, low, high);
        // Recursively sort elements before
        // partition and after partition
        quickSort(arr, low, storeIndex - 1);
        quickSort(arr, storeIndex + 1, high);
    }
};

/* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
var quickSortPartition = function (arr, low, high) {
    let pivot = arr[high];//// 直接选最右边的元素为基准元素
    //let i = low - 1;//index of smaller element
    let storeIndex = low;//index of smaller element
    for (let i = low; i < high; i++) {
        // If current element is smaller than or equal to pivot
        if (arr[i] < pivot) {
            //swap arr[i] and arr[j]
            swap(arr, storeIndex, i);
            storeIndex++;
        }
    }
    swap(arr, high, storeIndex);
    return storeIndex;
}