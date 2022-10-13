class TrieNode {
  public:
    TrieNode *children[26]; // pointer can point as if it is some struct
    
   bool isWord; // a flag to detect if the word is completed at this point or not // it can be in multiple nodes in a single path 
    TrieNode() {
      for(int i=0; i<26; i++)  // for every 26 letters in english words let's set this in children as i  to NULL
        children[i] = NULL:
      
         isWord = false; // mark the word as false since this isn't is it?
        
    }
}

class Trie {
public:
  Trie () {
    root = new TrieNode(); // init new Trie node, it can be used for new cases
  }

  void insert(String word) {
    TrieNode* node = root;
    int cur = 0;
    for(int i=0; i<word.size(); i++) {
      int cur = word[i] - 'a';
      if(node->children[i] == NULL) // jodi NULL thake notun TrieNode boshai 
        node->children[i] = new TrieNode();
    }
    
    node = node->children[cur]; // ekhon latest node e loiya jai ar oikhane isWord true hobe 
    
    node->isWord = true;
  
  }

  bool search(string word) {
    TrieNode* node = root;
    int curr = 0;
    for (int i=0; i<word.size(); i++) {
        curr = word[i] - 'a';
        if (node->children[curr] == NULL) { // think about it similar to 
            return false;
        }
        node = node->children[curr];
    }
    return node->isWord; // true or false
  }
  
}
