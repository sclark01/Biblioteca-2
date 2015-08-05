package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

/**
 * Created by sleblanc on 8/5/15.
 */
public class LibraryMenuTest {

    private PrintStream printStream;
    private LibraryMenu menu;
    private BufferedReader reader;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        menu = new LibraryMenu(printStream, reader);
    }

    @Test
    public void shouldPrintMenuOptionsWhenOpened() {
        menu.listOptions();
        verify(printStream).println(contains("List Books"));
        verify(printStream).println(contains("Quit"));
    }

    @Test
    public void shouldGetUserInputWhenPrompted() throws IOException {
        when(reader.readLine()).thenReturn("List Books");
        assertEquals("List Books", menu.getUserInput());
    }

    @Test
    public void shouldDisplayInvalidMenuOptionWhenInputIsInvalid() throws IOException {
        when(reader.readLine()).thenReturn("Something invalid", "List Books");
        menu.getUserInput();
        verify(printStream).println(contains("Select a valid option!"));
    }

    @Test
    public void shouldCallGetUserInputMoreThanOnceWhenInputIsInvalid() throws IOException {
        when(reader.readLine()).thenReturn("Something invalid", "Something invalid", "List Books");
        menu.getUserInput();
        verify(reader, atLeast(2)).readLine();
    }


}