/**
 * 535. Encode and Decode TinyURL
 * https://leetcode.com/problems/encode-and-decode-tinyurl/description/
 * 
 * Note: This is a companion problem to the System Design problem: Design TinyURL.
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl 
and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. 
There is no restriction on how your encode/decode algorithm should work.
 You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 * 
 */

let dict = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
let key2url = new Map(), url2key = new Map();
let tinyUrlHead = "http://tinyurl.com/";
/**
 * Encodes a URL to a shortened URL.
 *
 * @param {string} longUrl
 * @return {string}
 */
var encode = function (longUrl) {
    if (url2key.has(longUrl))
        return tinyUrlHead + url2key.get(longUrl);
    //let idx = 0;
    let key = null;
    do {
        let randStr = "";
        for (let i = 0; i < 6; i++) {
            let r = Math.floor((Math.random() * 100)) % dict.length;
            randStr += dict[r];
        }
        key = randStr;
    } while (key2url.has(key));
    //console.log(randStr);
    key2url.set(key, longUrl);
    url2key.set(longUrl, key);
    return BASE_HOST + key;
};

/**
 * Decodes a shortened URL to its original URL.
 *
 * @param {string} shortUrl
 * @return {string}
 */
var decode = function (shortUrl) {
    return url2key.get(shortUrl.replace(tinyUrlHead, ""));
};

/**
 * Your functions will be called as such:
 * decode(encode(url));
 */