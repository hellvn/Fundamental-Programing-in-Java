package views;

import controllers.bookcontroler;

import java.util.ArrayList;
import java.util.Scanner;
import models.*;

public class bookShop {
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        bookcontroler bc1 = new bookcontroler();
        bookShop bookShop1 = new bookShop();
        System.out.println("=====Welcome to ebook shop!=====");
        bc1.displayBook();
    }

    private void visitormenu() {
        ArrayList<books> cart = new ArrayList<>();
        
    }
}

