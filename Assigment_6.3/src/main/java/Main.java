import Controller.PetController;
import Model.Pet;
import View.PetView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Pet pet = new Pet(100, 100);

        PetView petView = new PetView(pet);

        PetController petController = new PetController(pet, petView);

        JFrame frame = new JFrame("Virtual Pet");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.add(petView);
        frame.setVisible(true);

        new Timer(10, e -> petController.updatePetPosition()).start();
    }
}
