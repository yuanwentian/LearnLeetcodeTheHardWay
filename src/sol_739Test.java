import org.junit.Test;

import static org.junit.Assert.*;

public class sol_739Test {

    sol_739 dT = new sol_739();
    @Test
    public void testdailyTemperatures() {
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] expectedAns = new int[]{1, 1, 4, 2, 1, 1, 0, 0};
        int[] actualAns = dT.dailyTemperatures_method2(T);
        for (int i = 0; i < T.length; i++) {
            assertEquals(expectedAns[i], actualAns[i]);
        }

    }
}