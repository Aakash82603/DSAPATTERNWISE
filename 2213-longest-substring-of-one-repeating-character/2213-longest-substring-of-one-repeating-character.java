class Solution {

    class Node {
        char leftChar;
        char rightChar;
        int prefix;
        int suffix;
        int max;
        int length;

        Node(char leftChar, char rightChar,
             int prefix, int suffix, int max, int length) {

            this.leftChar = leftChar;
            this.rightChar = rightChar;
            this.prefix = prefix;
            this.suffix = suffix;
            this.max = max;
            this.length = length;
        }
    }

    Node[] tree;
    char[] s;

    public int[] longestRepeating(String s,
                                  String queryCharacters,
                                  int[] queryIndices) {

        this.s = s.toCharArray();

        int n = s.length();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {

            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            update(1, 0, n - 1, index, ch);

            ans[i] = tree[1].max;
        }

        return ans;
    }

    void build(int node, int l, int r) {

        if (l == r) {
            tree[node] = new Node(
                s[l], s[l],
                1, 1, 1, 1
            );
            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    void update(int node, int l, int r,
                int index, char ch) {

        if (l == r) {

            s[index] = ch;

            tree[node] = new Node(
                ch, ch,
                1, 1, 1, 1
            );

            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, ch);
        } else {
            update(node * 2 + 1, mid + 1, r, index, ch);
        }

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    Node merge(Node left, Node right) {

        char leftChar = left.leftChar;
        char rightChar = right.rightChar;

        int prefix = left.prefix;

        if (left.prefix == left.length &&
            left.rightChar == right.leftChar) {

            prefix = left.length + right.prefix;
        }

        int suffix = right.suffix;

        if (right.suffix == right.length &&
            left.rightChar == right.leftChar) {

            suffix = right.length + left.suffix;
        }

        int maximum = Math.max(left.max, right.max);

        if (left.rightChar == right.leftChar) {

            maximum = Math.max(
                maximum,
                left.suffix + right.prefix
            );
        }

        return new Node(
            leftChar,
            rightChar,
            prefix,
            suffix,
            maximum,
            left.length + right.length
        );
    }
}