package OA.Quora;

public class ProductSum {
//    很简单，一个数字，求所有位数的乘积减去所有位数的和。
    public static int productSum(int number) {
        int sum = 0;
        int product = 1;
        int result;
        while (number != 0) {
            int n = number % 10;
            number /= 10;
            sum += n;
            product *= n;
        }
        result = product - sum;
        return result;
    }
}


