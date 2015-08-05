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

/**
 * Created by sleblanc on 8/5/15.
 */
public class LibraryMenuTest {

    @Test
    public void shouldPrintMenuOptionsWhenOpened() {
        PrintStream printStream = mock(PrintStream.class);
        LibraryMenu menu = new LibraryMenu(printStream);
        menu.listOptions();
        verify(printStream).println(contains("List Books"));

    }
}