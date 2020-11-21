var isPrimes = function (num) {
    if (num <= 1) return false;
    if (num == 2) return true;
    if (num % 2 == 0) return false;
    for (let i = 2; i < num; i++) {
        //console.log(num % i);
        if (num % i == 0)
            return false;
    }
    return true;
}

/**
 * Given an even number ( greater than 2 ), 
 * return two prime numbers whose sum will be equal to given number.
 * @param {*} A 
 */
var primesum = function (A) {
    //1.list all Primes
    let primeArray = [];
    for (let i = 0; i < A; i++) {
        if (isPrimes(i))
            primeArray.push(i);
    }
    //console.log(primeArray);
    let result = [];
    for (let i = 0; i < primeArray.length; i++) {
        let firstValue = primeArray[i];
        let needFindValue = A - primeArray[i];
        //console.log("needFindValue:" + needFindValue);
        //console.log(this.findInArray(needFindValue, primeArray));
        if (findInArray(needFindValue, primeArray) != -1) {
            result.push(firstValue, needFindValue);
            break;
        }
    }
    console.log(result);
    return result;
}

var findInArray = function (key, arr) {
    if (arr.length == 0) return -1;
    let start = 0, end = arr.length - 1;
    while (start <= end) {
        //let mid = (start + end) / 2;
        let mid = Math.floor((start + end) / 2);//if not use Math.floor,the value will be float
        if (key < arr[mid])
            end = mid - 1;
        else if (key > arr[mid])
            start = mid + 1;
        else
            return mid;
    }
    return -1;
}

var bubbleSort = function (arr) {
    for (let i = 0; i < arr.length; i++) {
        for (let j = i + 1; j < arr.length; j++) {
            if (arr[i] > arr[j]) {
                let temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}