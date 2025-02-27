package Controller;

import Model.Pet;
import View.PetView;

public class PetController {
    private Pet pet;
    private PetView petView;

    public PetController(Pet pet, PetView petView) {
        this.pet = pet;
        this.petView = petView;
    }
    //Some boring trigonometry
    public void updatePetPosition() {
        if (petView.isMouseInsideCanvas()) {
            int targetX = petView.getTargetX();
            int targetY = petView.getTargetY();

            int dx = Integer.compare(targetX, pet.getX());
            int dy = Integer.compare(targetY, pet.getY());

            pet.setX(pet.getX() + dx);
            pet.setY(pet.getY() + dy);

            petView.repaint();
        }
    }
}