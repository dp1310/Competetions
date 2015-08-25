class TSTNode {
    public char data;

    public boolean isEnd;

    public TSTNode left, middle, right;

    /** Constructor **/
    public TSTNode(char data) {
        this.data = data;
        this.isEnd = false;
        this.left = null;
        this.middle = null;
        this.right = null;
    }
}

class TernarySearchTree {
    public TSTNode root;

    private ArrayList<String> al;

    /** Constructor **/
    public TernarySearchTree() {
        root = null;
    }

    /** function to check if empty **/
    public boolean isEmpty() {
        return root == null;
    }
    
    /** function to clear **/
    public void makeEmpty() {
        root = null;
    }

    /** function to insert for a word **/
    public void insert(String word) {
        root = insert(root, word.toCharArray(), 0);
    }

    /** function to insert for a word **/
    public TSTNode insert(TSTNode r, char[] word, int index) {
        if (r == null)
            r = new TSTNode(word[index]);

        if (word[index] < r.data)
            r.left = insert(r.left, word, index);
        else if (word[index] > r.data)
            r.right = insert(r.right, word, index);
        else {
            if (index + 1 < word.length)
                r.middle = insert(r.middle, word, index + 1);
            else
                r.isEnd = true;
        }
        return r;
    }

    /** function to delete a word **/
    public void delete(String word) {
        delete(root, word.toCharArray(), 0);
    }

    /** function to delete a word **/
    private void delete(TSTNode r, char[] word, int index) {
        if (r == null)
            return;

        if (word[index] < r.data)
            delete(r.left, word, index);
        else if (word[index] > r.data)
            delete(r.right, word, index);
        else {
            /** to delete a word just make isEnd false **/
            if (r.isEnd && index == word.length - 1)
                r.isEnd = false;

            else if (index + 1 < word.length)
                delete(r.middle, word, index + 1);
        }
    }

    /** function to search for a word **/
    public boolean search(String word) {
        return search(root, word.toCharArray(), 0);
    }

    /** function to search for a word **/
    private boolean search(TSTNode r, char[] word, int index) {
        if (r == null)
            return false;

        if (word[index] < r.data)
            return search(r.left, word, index);
        else if (word[index] > r.data)
            return search(r.right, word, index);
        else {
            if (r.isEnd && index == word.length - 1)
                return true;
            else if (index == word.length - 1)
                return false;
            else
                return search(r.middle, word, index + 1);
        }
    }

    /** function to print tree **/
    public String toString() {
        al = new ArrayList<String>();
        traverse(root, "");
        return "\nTernary Search Tree : " + al;
    }

    /** function to traverse tree **/
    private void traverse(TSTNode r, String str) {
        if (r != null) {
            traverse(r.left, str);

            str = str + r.data;
            if (r.isEnd)
                al.add(str);

            traverse(r.middle, str);
            // if we are going in right direction that means current character is not part of string.
            // so we need to exclude it.
            str = str.substring(0, str.length() - 1);

            traverse(r.right, str);
        }
    }
}