package runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.BookingMoscowTest;
import tests.BookingOsloTest;
import tests.BookingParisTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({BookingParisTest.class, BookingMoscowTest.class, BookingOsloTest.class})
public class BookingRunner {
}
