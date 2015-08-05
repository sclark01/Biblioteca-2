package com.thoughtworks.biblioteca;

import com.javafx.tools.doclets.formats.html.SourceToHTMLConverter;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {
    private final PrintStream printStream;
    private List<Book> bookList;
    private LibraryMenu menu;
    BufferedReader reader;

    public BibliotecaApp(PrintStream printStream, List<Book> listOfBooks, LibraryMenu menu, BufferedReader reader){
        bookList = listOfBooks;
        this.printStream = printStream;
        this.menu = menu;
        this.reader = reader;
    }

    public void start() {
        printStream.println("Welcome to the Biblioteca Library!");
        menu.listOptions();
        String choice = menu.getUserInput();
        while (!choice.equals("Quit")) {
            if (choice.equals("List Books")) {
                listBooks();
            }
            choice = menu.getUserInput();
        }
    }

    public void listBooks() {
        String output = "";
        for (Book book : bookList){
            output += book.getDetailsAsString() + "\n";
        }

        printStream.print(output);
    }

}
