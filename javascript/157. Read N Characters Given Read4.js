/**
 * Lock by Leetcode
 * 
 * 157. Read N Characters Given Read4
 * https://www.jianshu.com/p/78a3b01c8e0a
 * https://www.cnblogs.com/Dylan-Java-NYC/p/5321849.html
 * 
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function will only be called once for each test case.
 */
var read = function (buf, n) {
    let total = 0;
    let bufTemp = new Array(4);
    let eof = false;
    while (!eof && total < n) {
        let count = read4(bufTemp);
        eof = (count < 4);
        // in case that n is less than the length of file 
        count = Math.min(count, n - total);
        for (let i = 0; i < count; i++) {
            buf[total++] = bufTemp[i];
        }
    }
    return total;
}