class Solution {
    public String findTheString(int[][] lcp) {

        int n = lcp.length;

        for(int i = 0; i < n; i++) {
            if(lcp[i][i] != n - i)
                return "";
        }

        char[] word = new char[n];

        for(int i = 0; i < n; i++)
            word[i] = '#';

        char ch = 'a';

        for(int i = 0; i < n; i++) {

            if(word[i] != '#')
                continue;

            if(ch > 'z')
                return "";

            for(int j = i; j < n; j++) {

                if(lcp[i][j] > 0)
                    word[j] = ch;
            }

            ch++;
        }

        for(int i = n - 1; i >= 0; i--) {

            for(int j = n - 1; j >= 0; j--) {

                int expected = 0;

                if(word[i] == word[j]) {

                    if(i == n - 1 || j == n - 1)
                        expected = 1;
                    else
                        expected = 1 + lcp[i + 1][j + 1];
                }

                if(lcp[i][j] != expected)
                    return "";
            }
        }

        return new String(word);
    }
}