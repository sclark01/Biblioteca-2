package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;


public class BibliotecaAppTest {

    private PrintStream printStream;
    private BibliotecaApp bibliotecaApp;
    private List<Book> bookList;
    private Book harryPotter;
    private LibraryMenu menu;
    private BufferedReader reader;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        bookList = new ArrayList<>();
        menu = mock(LibraryMenu.class);
        bibliotecaApp = new BibliotecaApp(printStream, bookList, menu, reader);
        harryPotter = mock(Book.class);


    }

    @Test
    public void shouldPrintWelcomeMessageWhenStarting(){
        when(menu.getUserInput()).thenReturn("List Books", "Quit");
        bibliotecaApp.start();
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldListExistingBooksInLibrary(){
        bookList.add(harryPotter);
        when(harryPotter.getDetailsAsString()).thenReturn("some string");
        bibliotecaApp.listBooks();
        verify(printStream).print(contains("some string"));
    }

    @Test
    public void shouldListNothingWhenNoBooksInLibrary(){
        when(menu.getUserInput()).thenReturn("List Books", "Quit");
        bibliotecaApp.start();
        //bibliotecaApp.listBooks();
        verify(printStream).print(contains(""));
    }

    @Test
    public void shouldShowMenuOptionsWhenLibraryStarts() throws IOException {
        when(menu.getUserInput()).thenReturn("List Books", "Quit");
        bibliotecaApp.start();
        verify(menu).listOptions();
    }

    @Test
    public void shouldGetUserInputWhenLibraryStarts() {
        when(menu.getUserInput()).thenReturn("List Books", "Quit");
        bibliotecaApp.start();
        verify(menu, atLeastOnce()).getUserInput();
    }

    @Test
    public void shouldStopPromptingWhenUserEntersQuit() throws IOException {
        when(menu.getUserInput()).thenReturn("List Books", "List Books", "Quit");
        bibliotecaApp.start();
        verify(menu, times(3)).getUserInput();
    }


}