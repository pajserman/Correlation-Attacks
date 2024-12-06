import java.util.ArrayList;

public class SingleAttack {

    private int[] z;
    private int[] cd;

    SingleAttack(int[] cd) {
        this.z = Stream.Z;
        this.cd = cd;
    }

    public static double hamming_distance(int[] x, int[] y) {
        if(x.length != y.length) {
            return -1;
        }
        int sum = 0;
        for(int i = 0; i < x.length; i++) {
            if(x[i] != y[i]) {
                sum++;
            }
        }
        return sum;

    }

    private double estimate_one_p(int[] x, int[] y) {
        double p_prime = 1 - ((hamming_distance(x, y))/x.length);
        return p_prime;
    }

    public int[] estimate_all_p() {
        int [] ans = new int[2];
        double largest_p = 0;
        double K = Math.pow(2, cd.length-1);
        int L = (int)K;
        for(int i = 0; i < L; i++) {
            LFSR lfsr = new LFSR(cd, 2, toBinaryArray(i));
            int[] z2 = new int[z.length];
            for(int j = 0; j < z.length; j++) {
                z2[j] = lfsr.getNext();
            }
            double p = estimate_one_p(z, z2);
            if(p > largest_p) {
                largest_p = p;
                ans[0] = i;
                ans[1] = (int)(p*100);
            }
        }
        return ans;
    }

         public static int[] toBinaryArray(int number) {
        if (number == 0) {
            return new int[]{0};
        }

        ArrayList<Integer> binaryList = new ArrayList<>();

        while (number > 0) {
            binaryList.add(0, number % 2);
            number /= 2;
        }

        int[] binaryArray = new int[binaryList.size()];
        for (int i = 0; i < binaryList.size(); i++) {
            binaryArray[i] = binaryList.get(i);
        }

        return binaryArray;
    }
    
}
