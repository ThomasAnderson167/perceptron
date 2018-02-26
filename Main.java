class Main {
    public static void main(String[] args) {
        Perceptron perceptron = new Perceptron();
        
        perceptron.train(new Points(10000));

        perceptron.showResultOfTraining();
    }
}
