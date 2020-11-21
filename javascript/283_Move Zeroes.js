
/**
 * 283. Move Zeroes
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
* @param {number[]} nums
* @return {void} Do not return anything, modify nums in-place instead.
*/
var moveZeroes = function (nums) {
    //124ms
    // let zeroArray = [], result = [], numsLength = nums.length;
    // let index = 0, foundZero = false;
    // for (; index < numsLength; index++) {
    //     if (foundZero)
    //         index = 0;//找到0就从头来过
    //     if (nums[index] == 0) {
    //         //splice中第一个参数是删除的起始索引,第二个参数是删除元素的个数。
    //         nums.splice(index, 1);//delete zero in nums array,这种nums长度会变的，影响了外层的loop的结果
    //         //delete nums[i];//这种方式数组长度不变,此时arnumsr[i]变为undefined了
    //         zeroArray.push(0);
    //         //index = 0;
    //         foundZero = true;
    //     } else
    //         foundZero = false;
    // }//end for
    // //result = nums.concat(zeroArray);
    // for (let i = 0; i < zeroArray.length; i++) {
    //     nums.push(zeroArray[i]);
    // }
    // console.log(result);

    //64ms
    // var indexArr = [], i;
    // for(i = 0; i < nums.length; i++){
    //      if(nums[i] === 0){
    //          indexArr.push(i);
    //     }
    // }
    // for(i = indexArr.length - 1; i >= 0; i--){
    //     nums.splice(indexArr[i], 1);
    // }
    // for(i = 0; i < indexArr.length; i++){
    //     nums.push(0);
    // }

    //64 ms
    let s = 0;
    for (let e = 0; e < nums.length; e++) {
        if (nums[e] == 0)
            continue;
        nums[s++] = nums[e];//前s个是非0
        //console.log(nums[e]);
    }
    //before is [0,1,0,3,12], nums is [ 1, 3, 12, 3, 12 ] now
    for (; s < nums.length; s++)
        nums[s] = 0;//后面的补上0

    console.log(nums);
},