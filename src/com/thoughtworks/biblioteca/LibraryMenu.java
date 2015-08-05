package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.mockito.Mockito.mock;

/**
 * Created by sleblanc on 8/5/15.
 */
public class LibraryMenu {
    private BufferedReader reader;
    private PrintStream printstream;
    private BibliotecaApp library;


    public LibraryMenu(PrintStream printstream, BufferedReader reader) {
        this.printstream = printstream;
        this.reader = reader;

    }

    public void listOptions() {
        printstream.println("List Books");
    }

    public String getUserInput() {
        String input = "";
        try {
            input = reader.readLine();
            if (!input.equals("List Books")) {
                printstream.println("Select a valid option!");
                getUserInput();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }
}
