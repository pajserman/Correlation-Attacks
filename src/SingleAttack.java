public class SingleAttack {

    private double prob = 0.75;
    private int[] z;
    private int[] cd;

    SingleAttack(int[] cd) {
        this.z = Stream.Z;
        this.cd = cd;
    }

    private int hamming_distance(int[] x, int[] y) {
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

    private double estimate_p(int[] x, int[] y) {
        double p_prime = 1 - (hamming_distance(x, y))/Stream.Z.length;
        return p_prime;
    }
    
}
