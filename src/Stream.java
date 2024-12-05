public class Stream {

        public static int[] Z =  {1,1,0,0,0,1,1,1,0,0,0,1,1,0,1,0,0,1,1,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0,1,1,1,1,1,1,0,0,0,
        0,0,1,0,0,1,0,0,0,0,0,0,0,1,1,0,0,1,1,1,0,0,0,0,1,1,0,1,1,1,0,1,1,0,0,0,0,1,0,1,0,1,1,0,1,1,1,1,1,1,
        1,0,0,0,1,0,1,1,1,0,1,0,0,1,1,1,1,1,1,0,0,1,0,0,1,1,0,1,1,1,1,1,0,1,0,1,1,1,0,1,0,0,1,0,1,1,1,1,0,0,
        1,0,0,1,1,1,0,0,0,0,0,1,0,1,0,0,1,1,0,1,1,1,1,0,1,0,0,1,1,0,0,0,0,1,1,1,1,0,1,0,1,0,1};
        
        // LFSR 1
        public static int[] CD_1 = {1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        LFSR lfsr_1;
        
        // LFSR 2
        public static int[] CD_2 = {1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1};
        LFSR lfsr_2;
        
        // LFSR 3
        public static int[] CD_3 = {1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1};
        LFSR lfsr_3;

        Stream(int[] key_1, int[] key_2, int[] key_3 ) {
            // Creating LFSRs
            this.lfsr_1 = new LFSR(CD_1, 2, key_1);
            this.lfsr_2 = new LFSR(CD_2, 2, key_2);
            this.lfsr_3 = new LFSR(CD_3, 2, key_3);
        }

        public int getNext() {
            int[] u  = {lfsr_1.getNext(), lfsr_2.getNext(), lfsr_3.getNext()};
            return majority(u);
        }

        private int majority(int[] u) {
            int sum = u[0] + u[1] + u[2];
            if (sum > 1) {
                return 1;
            }
            return 0;
        }


}
