package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class LibraryTest {
    private List<String> books;
    private PrintStream printStream;
    private Library library;
    private DateTimeFormatter dateTimeFormatter;
    private DateTime time;


    /*

        List books tests. Implement the first three tests for the Verify exercise

     */

    @Before
    public void createBooksPrintSteamAndLibrary(){
        books = new ArrayList<>();
        printStream = mock(PrintStream.class);
        library = new Library(books, printStream, null);

    }

    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {

        createBooksPrintSteamAndLibrary();
        String title = "Book Title";
        books.add(title);
        library.listBooks();

        // add a verify statement here that shows that the book title was printed by to the printStream
        verify(printStream).println("Book Title");
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        createBooksPrintSteamAndLibrary();
        library.listBooks();

        verifyZeroInteractions(printStream);
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() {

        createBooksPrintSteamAndLibrary();
        String title = "Book Title";
        String title2 = "Book Title 2";
        books.add(title);
        books.add(title2);

        library.listBooks();

        verify(printStream).println("Book Title");
        verify(printStream).println("Book Title 2");

    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    @Before
    public void createBooksPrintStreamDateTimeAndLibrary(){
        books = new ArrayList<>();
        printStream = mock(PrintStream.class);
        dateTimeFormatter = mock(DateTimeFormatter.class);
        time = new DateTime();
        library = new Library(books, printStream, dateTimeFormatter);

    }
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {
        // We don't need to mock DateTime because it is a value object
        // We can't mock it because it is a final class
        createBooksPrintStreamDateTimeAndLibrary();
        library.welcome(time);
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {

        createBooksPrintStreamDateTimeAndLibrary();
        when(dateTimeFormatter.print(time)).thenReturn("");
        library.welcome(time);
        verify(printStream).println(contains("The current time is "));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {

        createBooksPrintStreamDateTimeAndLibrary();
        when(dateTimeFormatter.print(time)).thenReturn("6:16 PM");
        library.welcome(time);
        verify(printStream).println(contains("The current time is 6:16 PM"));

    }
}