// Perceptron
// Copyright (C) 2018 Yurii Khomiak
// Yurii Khomiak licenses this file to you under the MIT license.
// See the LICENSE file in the project root for more information.


class Main {
    public static void main(String[] args) {
        Perceptron perceptron = new Perceptron();
        
        perceptron.train(new Points(10000));

        perceptron.showResultOfTraining();
    }
}
