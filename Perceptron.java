class Perceptron {
    private float w1; // 1st weight
    private float w2; // 2nd weight
    private float bias;
    private float learnRate;
    private int errors; // number of errors
    private int iterations; // number of iterations

    Perceptron() {
        errors = 0;
        iterations = 0;
        learnRate = 0.1f;

        w1 = (float)(Math.random() * 2 - 1); // 
        w2 = (float)(Math.random() * 2 - 1); // Setting initial random values
                                             // for weights and bias
        bias = (float)Math.random();         //
    }
    
    // Showing number of errrors, received equation of 
    // separating line, values of weights and bias
    public void showResultOfTraining() {
        System.out.println("\n " + errors + " of " + iterations + " iterations");

        System.out.println("y = " + (-w1 / w2) + "x + " + (-bias / w2));

        System.out.println("\nw1 = " + w1 + " , w2 = " + w2 + "\nbias = " + bias);
    }

    // Receiving points for training
    public void train(Points points) {
        iterations += points.getLength();
        
        for(int i = 0; i < iterations; i++)
            learn(points.getX1(i), points.getX2(i), points.getType(i));
    }

    // Receiving output and made corrections if needed
    private void learn(float x1, float x2, int type) {
        int output = getOutput(x1, x2);

        System.out.print("Input: {" + x1 + "; " + x2 + "}, desired: " + type 
                          + " , achieved: " + output);

        if(output != type) {
            makeCorrections(type, x1, x2);
            errors++;

            System.out.print("  ERROR");
        }

        System.out.println();
    }

    // Calculating output
    private int getOutput(float x1, float x2) {
        float sum = w1 * x1 + w2 * x2 + bias;

        return sign(sum);
    }

    // Return 1 if argument > 0 and (-1) otherwise
    private int sign(float argument) {
        return (argument > 0) ? 1 : (-1);
    }

    // Correct weights and bias
    private void makeCorrections(int desired, float x1, float x2) {
        w1 += learnRate * desired * x1;
        w2 += learnRate * desired * x2;

        bias += learnRate * desired;
    }
}
