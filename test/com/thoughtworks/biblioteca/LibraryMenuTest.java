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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    }

    @Test
    public void shouldGetUserInputWhenPrompted() throws IOException {
        when(reader.readLine()).thenReturn("List Books");
        assertEquals("List Books", menu.getUserInput());
    }
}