package com.thoughtworks.biblioteca;

import java.io.PrintStream;

/**
 * Created by sleblanc on 8/5/15.
 */
public class LibraryMenu {
    PrintStream printstream;

    public LibraryMenu (PrintStream printstream) {
        this.printstream = printstream;
    }

    public void listOptions() {
        printstream.println("List Books");
    }

}
