public class App {
    public static void main(String[] args) throws Exception {
        
        int[][] keys = new int[3][2];

        SingleAttack attack_1 = new SingleAttack(Stream.CD_1);
        keys[0] = attack_1.estimate_all_p();


        SingleAttack attack_2 = new SingleAttack(Stream.CD_2);
        keys[1] = attack_2.estimate_all_p();

        SingleAttack attack_3 = new SingleAttack(Stream.CD_3);
        keys[2] = attack_3.estimate_all_p();

        System.out.println("Found keys are:");
        for (int[] key : keys) {
            System.out.println("Key: " + key[0] + " with prob: " + key[1] + "%");
        }

        System.out.println("Same keys but in binary:");
        for (int i = 0; i < keys.length; i++) {
            int[] binary = SingleAttack.toBinaryArray(keys[i][0]);
            for (int j : binary) {
                System.out.print(j);
            }
            System.out.println();
        }

        System.out.println("Now testing if they give the same stream as Z...");

        // keys[0][0] = 1;
        
        Stream streamChipher = new Stream(SingleAttack.toBinaryArray(keys[0][0]), SingleAttack.toBinaryArray(keys[1][0]), SingleAttack.toBinaryArray(keys[2][0]));
        boolean check = true;
        for (int i = 0; i < Stream.Z.length; i++) {
            
            if(streamChipher.getNext() != Stream.Z[i]) {
                System.out.println("Wrong! The keys does not produce the same Z stream!");
                check = false;
                break;
            }

        }

        if(check) {
            System.out.println("OK! The streams match up! The keys are correct!");
        }

    }

       
}
