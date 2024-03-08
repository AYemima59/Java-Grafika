public class Exercise3 {
    public static void main(String[] args) {
        // variable
        double c = 1.0;
        double[] vector = {3, 2};


        double[][] matrix = {
            {c, 0, 6},
            {0, c, 4},
            {0, 0, c}
        };

        // jawaban 
        double[] result = new double[3];
        for (int i = 0; i < 3; i++) {
            result[i] = matrix[i][0] * vector[0] + matrix[i][1] * vector[1] + matrix[i][2];
        }

        System.out.println("Translation result:");
        System.out.println("x: " + result[0]);
        System.out.println("y: " + result[1]);
    }
}

