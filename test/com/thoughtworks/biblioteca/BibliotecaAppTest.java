package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class BibliotecaAppTest {

    private PrintStream printStream;
    private BibliotecaApp bibliotecaApp;
    private List<Book> bookList;
    private Book harryPotter;
    private LibraryMenu menu;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);

        bookList = new ArrayList<>();
        menu = mock(LibraryMenu.class);
        bibliotecaApp = new BibliotecaApp(printStream, bookList, menu);
        harryPotter = mock(Book.class);


    }

    @Test
    public void shouldPrintWelcomeMessageWhenStarting(){
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
        bibliotecaApp.listBooks();
        verify(printStream).print(contains(""));
    }

    @Test
    public void shouldShowMenuOptionsWhenLibraryStarts() {
        bibliotecaApp.start();
        verify(menu).listOptions();
    }
    






}