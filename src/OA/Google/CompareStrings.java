package OA.Google;
import java.util.*;

public class CompareStrings {
    // "static void main" must be defined in a public class.
    public int[] myCompareStrings(String A, String B) {
        String[] stringsA = A.split(",");
        String[] stringsB = B.split(",");
        int lenB = stringsB.length;
        int[] result = new int[lenB];
        int[] freqA = countMinCharFreq(stringsA);
        int[] freqB = countMinCharFreq(stringsB);
        for (int i = 0; i < lenB; i++) {
            int count = 0;
            int b = freqB[i];
            for (int a: freqA) {
                if ( b > a) {
                    count += 1;
                }
            }
            result[i] = count;
        }
        return result;
    }

    public int[] countMinCharFreq(String[] strs) {
        int len = strs.length;
        int[] freq = new int[len];
        for (int i = 0; i<len; i++) {
            String sA = strs[i];
            // compute
            if(sA.length() == 0) {
                freq[i] = 0;
            } else {
                int[] counts = new int[26];
                int minCharIndex = 26;
                for (char c : sA.toCharArray()) {
                    counts[c - 'a'] += 1;
                    minCharIndex = Math.min(minCharIndex, c - 'a');
                }
                freq[i] = counts[minCharIndex];
            }
        }
        return freq;
    }








    public void printArray(int[] arr){
        for(int i: arr) System.out.print(i + " ");
        System.out.println();
    }



    public int[] compareStrings(String A, String B){
        int[] allLessEqualThanFreq = new int[11];
        String[] stringsA = A.split(",");
        String[] stringsB = B.split(",");
        int lengthB = stringsB.length;
        int[] result = new int[lengthB];
        for(String s: stringsA){
            if(s.length() == 0) continue;
            int[] counts = new int[26];
            int minCharIndex = 26;
            for(char c: s.toCharArray()){
                counts[c - 'a'] += 1;
                minCharIndex = Math.min(minCharIndex, c - 'a');
            }
            int freq = counts[minCharIndex];
            allLessEqualThanFreq[freq]++;
        }
        // use prefix sum to easily get sum from idx 0 to i
        for(int i = 1; i < 11; ++i) {
            allLessEqualThanFreq[i] += allLessEqualThanFreq[i - 1];
        }
        for(int i = 0; i < lengthB; ++i) {
            String s = stringsB[i];
            int[] counts = new int[26];
            int minCharIndex = 26;
            for(char c: s.toCharArray()){
                counts[c - 'a'] += 1;
                minCharIndex = Math.min(minCharIndex, c - 'a');
            }
            int freq = counts[minCharIndex];
            result[i] = (freq - 1 >= 0) ? allLessEqualThanFreq[freq - 1]: 0;
        }
        return result;
    }


    public int[] compareStrings2(String a, String b) {
        int c = 0;
        String[] stringsA = a.split(",");
        String[] stringsB = b.split(",");
        int lenA = stringsA.length;
        int lenB = stringsB.length;
        int res[] = new int[lenB];
        int aCount[] = new int[lenA];
        int bCount[] = new int[lenB];
        for (int i = 0; i < lenA; i++) {
            char arrA[] = stringsA[i].toCharArray();
            aCount[i] = count(arrA);
        }
        for (int i = 0; i < lenB; i++) {
            char arrB[] = stringsB[i].toCharArray();
            bCount[i] = count(arrB);
        }
        for (int i = 0; i < lenB; i++) {
            for (int j = 0; j < lenA; j++) {
                if (bCount[i] > aCount[j])
                    res[c]++;
            }
            c++;
        }
        return res;
    }

    public int count(char arr[]) {
        Arrays.sort(arr);
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1])
                break;
            else
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        CompareStrings main = new CompareStrings();
        String[] testcasesA = {"abcd,aabc,bd"}, testcasesB = {"aaa,aa"};
        for(int i = 0; i < testcasesA.length; ++i) {
            main.printArray(main.compareStrings(testcasesA[i], testcasesB[i]));
            main.printArray(main.myCompareStrings(testcasesA[i], testcasesB[i]));
        }
    }
}

