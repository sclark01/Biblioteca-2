package com.thoughtworks.biblioteca;

import com.javafx.tools.doclets.formats.html.SourceToHTMLConverter;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {
    private final PrintStream printStream;
    private List<Book> bookList;
    private LibraryMenu menu;

    public BibliotecaApp(PrintStream printStream, List<Book> listOfBooks, LibraryMenu menu){
        bookList = listOfBooks;
        this.printStream = printStream;
        this.menu = menu;
    }

    public void start() {
        printStream.println("Welcome to the Biblioteca Library!");
        menu.listOptions();
    }

    public void listBooks() {
        String output = "";
        for (Book book : bookList){
            output += book.getDetailsAsString() + "\n";
        }

        printStream.print(output);
    }


    public void showMenu() {
    }
}
