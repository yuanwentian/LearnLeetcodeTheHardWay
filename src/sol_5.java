public class sol_5 {
    public String longestPalindrome_DP(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        boolean[][] P = new boolean[len][len];
        int dist = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                int currDist = 0;
                if (i == j) {
                    P[j][i] = true;
                }
                else if ((i == j + 1) && (s.charAt(i) == s.charAt(j)))  {
                    P[j][i] = true;
                    currDist = 1;
                } else if (P[j+1][i-1] && (s.charAt(i) == s.charAt(j))) {
                    P[j][i] = true;
                    currDist = i - j;
                }
                if (currDist > dist) {
                    dist = currDist;
                    start = j;
                    end = i;
                }
            }
        }
        return s.substring(start, end+1);
    }

    public String longestPalindrome_Center(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
