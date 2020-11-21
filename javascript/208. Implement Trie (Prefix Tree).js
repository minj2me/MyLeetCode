/**
 * 208. Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 * Initialize your data structure here.
 * 
 * https://www.cnblogs.com/grandyang/p/4491665.html
 * https://github.com/paopao2/leetcode-js/blob/master/Implement%20Trie%20(Prefix%20Tree).js
 * 
 * 我们先来看第一种实现方法，这种方法实现起来简单直观，字母的字典树每个节点要定义一个大小为26的子节点指针数组，
 * 然后用一个标志符用来记录到当前位置为止是否为一个词，初始化的时候讲26个子节点都赋为空。
 * 那么insert操作只需要对于要插入的字符串的每一个字符算出其的位置，然后找是否存在这个子节点，若不存在则新建一个，然后再查找下一个。
 * 查找词和找前缀操作跟insert操作都很类似，不同点在于若不存在子节点，则返回false。查找次最后还要看标识位，而找前缀直接返回true即可
 */
var TireNode = function () {
    let isEnd = false;//links = {};
    //try array
    let arr = null;
    //Memory Limit Exceeded 
    return {
        // has: function (n) {
        //   return links[n] != undefined;
        // },
        // put: function (ch, node) {
        //   links[ch] = node;
        // },
        // get: function (ch) {
        //   return links[ch];
        // },
        getArr: function () {
            if (arr == null)
                arr = new Array(26);
            //console.log("arr:"+arr);
            return arr;
        },
        setEnd: function () {
            isEnd = true;
        },
        isEnd: function () {
            return isEnd;
        },
    };
};

let root;

/**
 * Initialize your data structure here.
 */
var Trie = function () {
    root = new TireNode();
    //root.getArr().fill(null);
};

/**
 * Inserts a word into the trie. 
 * @param {string} word
 * @return {void}
 * 
 *  // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode p = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            int index = c-'a';
            if(p.arr[index]==null){
                TrieNode temp = new TrieNode();
                p.arr[index]=temp;
                p = temp;
            }else{
                p=p.arr[index];
            }
        }
        p.isEnd=true;
    }
 */
Trie.prototype.insert = function (word) {
    let len = word.length;
    let node = root, ch;
    for (let i = 0; i < len; i++) {
        ch = word.charAt(i);
        let index = ch.charCodeAt(0) - 'a'.charCodeAt(0);
        if (node.getArr()[index] == null || node.getArr()[index] == undefined) {
            let temp = new TireNode();
            node.getArr()[index] = temp;
            node = temp;
        } else
            node = node.getArr()[index];
    }
    node.setEnd();
};

/**
 * Returns if the word is in the trie. 
 * @param {string} word
 * @return {boolean}
 *  // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode p = searchNode(word);
        if(p==null){
            return false;
        }else{
            if(p.isEnd)
                return true;
        }
 
        return false;
    }
 */
Trie.prototype.search = function (word) {
    let node = searchPrefix(word);
    if (node == null)
        return false;
    else {
        if (node.isEnd())
            return true;
    }
    return false;

};

/**
 * Returns if there is any word in the trie that starts with the given prefix. 
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function (prefix) {
    //return searchPrefix(prefix) != null;
    let node = searchPrefix(prefix);
    return node == null ? false : true;
};

/**
 * 
    public TrieNode searchNode(String s){
        TrieNode p = root;
        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            int index = c-'a';
            if(p.arr[index]!=null){
                p = p.arr[index];
            }else{
                return null;
            }
        }
 
        if(p==root)
            return null;
 
        return p;
    }
 */
searchPrefix = function (prefix) {
    let len = prefix.length;
    let node = root, ch, index;
    for (let i = 0; i < len; i++) {
        ch = prefix.charAt(i);
        index = ch.charCodeAt(0) - 'a'.charCodeAt(0);
        //console.log("index:" + index);
        if (node.getArr()[index] != null)
            node = node.getArr()[index];
        else
            return null;
    }

    if (node==root)
        return null;

    return node;
};

  /** 
   * Your Trie object will be instantiated and called as such:
   * var obj = Object.create(Trie).createNew()
   * obj.insert(word)
   * var param_2 = obj.search(word)
   * var param_3 = obj.startsWith(prefix)
   */