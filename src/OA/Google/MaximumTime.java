package OA.Google;

public class MaximumTime {
    //https://leetcode.com/discuss/interview-question/396769/google-oa-2019-maximum-time
    public static String maxTime(String time){
        char[] inputTime = time.toCharArray();
//        char[] maxTime = "23:59".toCharArray();
        char[] maxTime = new char[5];
        if (inputTime[1] != '?' && inputTime[1] > '3') {
            maxTime[0] = '1';
        } else {
            maxTime[0] = '2';
        }
        if (inputTime[0] == '?' || inputTime[0] == '2') {
            maxTime[1] = '3';
        } else {
            maxTime[1] = '9';
        }
//        maxTime[0] = cTime[1] != '?' && cTime[1] > '3' ? '1' : maxTime[0];
//        maxTime[1] = cTime[0] != '?' && cTime[0] < '2' ? '9' : maxTime[1];
        maxTime[2] = ':';
        maxTime[3] = '5';
        maxTime[4] = '9';
        for(int i = 0; i < inputTime.length; ++i){
            maxTime[i] = inputTime[i] != '?' ? inputTime[i] : maxTime[i];
        }
        return new String(maxTime);
    }

    //https://leetcode.com/discuss/interview-question/396769/google-oa-2019-maximum-time
    public static String maxTime2(String time){
        char[] cTime = time.toCharArray(), ans = "23:59".toCharArray();
        ans[0] = cTime[1] != '?' && cTime[1] > '3' ? '1' : ans[0];
        ans[1] = cTime[0] != '?' && cTime[0] < '2' ? '9' : ans[1];
        for(int i = 0; i < cTime.length; ++i){
            ans[i] = cTime[i] != '?' ? cTime[i] : ans[i];
        }
        return new String(ans);
    }

    public static void main(String[] args) {
        System.out.println(maxTime("?4:5?") + " v.s." +  maxTime2("?4:5?"));
        System.out.println(maxTime("?4:??") + " v.s." +  maxTime2("?4:??"));
        System.out.println(maxTime("?3:??") + " v.s." +  maxTime2("?3:??"));
        System.out.println(maxTime("23:5?") + " v.s." +  maxTime2("23:5?"));
        System.out.println(maxTime("2?:22") + " v.s." +  maxTime2("2?:22"));
        System.out.println(maxTime("0?:??") + " v.s." +  maxTime2("0?:??"));
        System.out.println(maxTime("1?:??") + " v.s." +  maxTime2("1?:??"));
        System.out.println(maxTime("??:??") + " v.s." +  maxTime2("??:??"));
        System.out.println(maxTime("?4:0?") + " v.s." +  maxTime2("?4:0?"));
        System.out.println(maxTime("?9:4?") + " v.s." +  maxTime2("?9:4?"));
    }
}
