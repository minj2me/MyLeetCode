var contigous = function (nums, target) {
    let left = 1, right = 0, len = nums.length, sum = 0;
    let result = [];
    while (right < len) {
        let num = nums[right++];
        sum += num;
        result.push(num);
        console.log("sum:" + sum);
        while (sum >= target) {//found out the value larger than target
            if (sum == target)
                //break;
                return result;
            else {
                console.log("left:" + left);
                right = left;
                left++;
                sum = 0;
                result = [];
            }
        }
    }
    return [];
};