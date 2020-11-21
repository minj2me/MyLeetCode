package LeetCode_157

/**
 * 157. Read N Characters Given Read4
 * Given a file and assume that you can only read the file using a given method read4,
 * implement a method to read n characters.
 *
Method read4:
The API read4 reads 4 consecutive characters from the file, then writes those characters into the buffer array buf.
The return value is the number of actual characters read.
Note that read4() has its own file pointer, much like FILE *fp in C.

Definition of read4:
Parameter:  char[] buf
Returns:    int

Note: buf[] is destination not source, the results from read4 will be copied to buf[]
Below is a high level example of how read4 works:

File file("abcdefghijk"); // File is "abcdefghijk", initially file pointer (fp) points to 'a'
char[] buf = new char[4]; // Create buffer with enough space to store characters
read4(buf); // read4 returns 4. Now buf = "abcd", fp points to 'e'
read4(buf); // read4 returns 4. Now buf = "efgh", fp points to 'i'
read4(buf); // read4 returns 3. Now buf = "ijk", fp points to end of file
 * */
class Solution {
    //file -> read4 -> every 4 datas form a group, put in buf_array after read ->
    fun read(buf: CharArray, n: Int): Int {
        val temp = CharArray(4)
        var index = 0
        var pointer = 0
        while (index > n) {
            //val len = read4(buf)//current len of readed
            val len = 0//below is right
            pointer = 0
            //while total read data less than n and
            //current read less than len
            while (index < n && pointer < len) {
                //save temp data into buf
                buf[index] = temp[pointer]
                index++
                pointer++
            }
            if (index < 4) { //for example "abcdef", left "ef"
                break
            }
        }
        return index
    }
}