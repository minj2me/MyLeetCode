package LeetCode_535

/**
 * 535. Encode and Decode TinyURL
 * https://leetcode.com/problems/encode-and-decode-tinyurl/description/
 *
 * TinyURL is a URL shortening service where you enter a URL such as
 * https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.
Design the encode and decode methods for the TinyURL service.
There is no restriction on how your encode/decode algorithm should work.
You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 * */
class Codec() {
    /*
    * solution, Two HaspMap
    * */
    private val BASE_URL = "http://tinyurl.com/"
    //total 62 characters for generate short_url
    val chatSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
    //key is long url,value short url
    val mapShortUrl = HashMap<String, String>()
    //key is short url,value long url
    val mapLongUrl = HashMap<String, String>()

    // Encodes a URL to a shortened URL.
    fun encode(longUrl: String): String {
        if (mapShortUrl.containsKey(longUrl)) {
            return mapShortUrl.get(longUrl) ?: ""
        }
        var key = ""
        do {
            val sb = StringBuilder()
            for (i in 0..6) {
                val r = (Math.random() * chatSet.length).toInt()
                sb.append(chatSet[r])
            }
            key = sb.toString()
            //if contains key, keep doing generate
        } while (mapShortUrl.containsKey(longUrl))
        val url = BASE_URL + key
        mapShortUrl.put(longUrl, url)
        mapLongUrl.put(url, longUrl)
        return url
    }

    // Decodes a shortened URL to its original URL.
    fun decode(shortUrl: String): String {
        return mapLongUrl.getOrDefault(shortUrl, "")
    }
}
/**
 * Your Codec object will be instantiated and called as such:
 * var obj = Codec()
 * var url = obj.encode(longUrl)
 * var ans = obj.decode(url)
 */