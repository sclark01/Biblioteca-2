package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Book> listOfBooks = new ArrayList<Book>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LibraryMenu menu = new LibraryMenu(System.out, reader);
        Book chronicles = new Book("Chronicles of Narnia", "CS Lewis", 1990);
        listOfBooks.add(chronicles);
        Book lordOfRings = new Book("Fellowship of the Rings", "JRR Tolkien", 1970);
        listOfBooks.add(lordOfRings);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new PrintStream(System.out), listOfBooks, menu);
        bibliotecaApp.start();
        bibliotecaApp.listBooks();
    }
}
