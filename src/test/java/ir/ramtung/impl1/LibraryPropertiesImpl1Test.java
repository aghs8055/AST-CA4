package ir.ramtung.impl1;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import ir.ramtung.sts01.LibraryException;
import org.junit.runner.RunWith;
import ir.ramtung.impl1.LibraryGenerator.TestStuMember;
import ir.ramtung.impl1.LibraryGenerator.TestProfMember;
import ir.ramtung.impl1.LibraryGenerator.TestBook;
import ir.ramtung.impl1.LibraryGenerator.TestReference;
import ir.ramtung.impl1.LibraryGenerator.TestMagazine;
import ir.ramtung.impl1.LibraryGenerator.FixtureCount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(JUnitQuickcheck.class)
public class LibraryPropertiesImpl1Test {

    @Property
    public void nameCheckingInAddStudentMember(String studentId, String studentName) {
        Library library = new Library();

        try {
            library.addStudentMember(studentId, studentName);

            if (studentId.isEmpty() || studentName.isEmpty())
                fail("Expected exception while adding student member with empty id or name");
        } catch (LibraryException e) {
            if (!studentId.isEmpty() && !studentName.isEmpty())
                fail("Got exception while adding student member with non empty name and id: " + e.getMessage());
        } catch (Exception ignored) {
            fail("Got an unexpected error");
        }
    }

    @Property
    public void equalityOfAddedPenaltyForEachDayAfterTenDays(
            @From(LibraryGenerator.class)
            @FixtureCount()
            @TestStuMember(stuName = "Ali", stuId = "123")
            Library library
    ) {
        try {
            library.timePass(55);
            int penalty1 = library.getTotalPenalty("Ali");
            library.timePass(1);
            int penalty2 = library.getTotalPenalty("Ali");
            library.timePass(1);
            int penalty3 = library.getTotalPenalty("Ali");
            assertEquals(penalty2 - penalty1, penalty3 - penalty2);
        } catch (LibraryException e) {
            fail("Got exception while getting total penalty for existing member: " + e.getMessage());
        } catch (Exception ignored) {
            fail("Got an unexpected error");
        }

    }

    @Property
    public void illegalityOfExtendAtDayOfBorrowing(
            @From(LibraryGenerator.class)
            @FixtureCount()
            @TestStuMember(stuName = "Ali", stuId = "123")
            @TestBook(title = "Book", copies = 1)
            Library library
    ) {
        try {
            library.borrow("Ali", "Book");
        } catch (LibraryException ignored) {
            return;
        }

        try {
            library.extend("Ali", "Book");
            fail("Expected exception while extending at day of borrowing");
        } catch (LibraryException ignored) {
        } catch (Exception ignored) {
            fail("Got an unexpected error");
        }
    }

    @Property
    public void legalityOfTwoExtendsBeforeReturningDate(
            @From(LibraryGenerator.class)
            @FixtureCount(stuCount = 0, profCount = 0, bookCount = 0, magazineCount = 0, referenceCount = 0)
            @TestStuMember(stuName = "Ali", stuId = "123")
            @TestBook(title = "Book", copies = 1)
            Library library
    ) {
        try {
            library.returnDocument("Ali", "Book");
        } catch (LibraryException ignored) {
        } catch (Exception ignored) {
            fail("Got an unexpected error");
        }

        try {
            library.borrow("Ali", "Book");
        } catch (LibraryException e) {
            fail("Got exception while borrowing book: " + e.getMessage());
        } catch (Exception ignored) {
            fail("Got an unexpected error");
        }

        try {
            library.timePass(1);
            library.extend("Ali", "Book");
            library.timePass(1);
            library.extend("Ali", "Book");
        } catch (LibraryException e) {
            fail("Got exception while extending book: " + e.getMessage());
        } catch (Exception ignored) {
            fail("Got an unexpected error");
        }
    }

    @Property
    public void illegalityOfMoreThanTwoExtendsBeforeReturningDate(
            @From(LibraryGenerator.class)
            @FixtureCount(stuCount = 0, profCount = 0, bookCount = 0, magazineCount = 0, referenceCount = 0)
            @TestStuMember(stuName = "Ali", stuId = "123")
            @TestBook(title = "Book", copies = 1)
            Library library
    ) {
        try {
            library.returnDocument("Ali", "Book");
        } catch (LibraryException ignored) {
        } catch (Exception ignored) {
            fail("Got an unexpected error");
        }

        try {
            library.borrow("Ali", "Book");
        } catch (LibraryException e) {
            fail("Got exception while borrowing book: " + e.getMessage());
        } catch (Exception ignored) {
            fail("Got an unexpected error");
        }

        try {
            library.timePass(1);
            library.extend("Ali", "Book");
            library.timePass(1);
            library.extend("Ali", "Book");
            library.timePass(1);
            library.extend("Ali", "Book");
            fail("Expected exception while extending more than two times before returning date");
        } catch (LibraryException ignored) {
        } catch (Exception ignored) {
            fail("Got an unexpected error");
        }
    }

    @Property
    public void availabilityOfFullyBorrowedBookAfterReturningOneCopy(
            @From(LibraryGenerator.class)
            @FixtureCount(stuCount = 0, profCount = 0, bookCount = 0, magazineCount = 0, referenceCount = 0)
            @TestStuMember(stuName = "Ali", stuId = "123")
            @TestBook(title = "Book", copies = 2)
            Library library
    ) {
        try {
            library.borrow("Ali", "Book");
            library.borrow("Ali", "Book");
        } catch (LibraryException ignored) {
        } catch (Exception ignored) {
            fail("Got an unexpected error");
        }

        assertEquals(0, library.availableTitles().size());

        try {
            library.returnDocument("Ali", "Book");
        } catch (LibraryException e) {
            fail("Got exception while returning book: " + e.getMessage());
        } catch (Exception ignored) {
            fail("Got an unexpected error");
        }

        assertEquals(1, library.availableTitles().size());
    }

    @Property
    public void illegalityOfBorrowingMoreThanFiveDocumentsByProf(
            @From(LibraryGenerator.class)
            @FixtureCount(stuCount = 0, profCount = 0, bookCount = 0, magazineCount = 0, referenceCount = 0)
            @TestProfMember(profName = "Prof. Ali")
            @TestBook(title = "Book", copies = 10)
            Library library
    ) {
        for (int i = 0; i < 5; i++) {
            try {
                library.returnDocument("Prof. Ali", "Book");
            } catch (LibraryException ignored) {
                break;
            } catch (Exception ignored) {
                fail("Got an unexpected error");
            }
        }

        try {
            library.borrow("Prof. Ali", "Book");
            library.borrow("Prof. Ali", "Book");
            library.borrow("Prof. Ali", "Book");
            library.borrow("Prof. Ali", "Book");
            library.borrow("Prof. Ali", "Book");
        } catch (LibraryException e) {
            fail("Got an exception while borrowing less that six documents by prof: " + e.getMessage());
        } catch (Exception ignored) {
            fail("Got an unexpected error");
        }

        try {
            library.borrow("Prof. Ali", "Book");
            fail("Expected exception while borrowing more than five documents by prof");
        } catch (LibraryException ignored) {
        } catch (Exception ignored) {
            fail("Got an unexpected error");
        }
    }

    @Property
    public void correctnessOfComputingPenaltyForDocument(
            @From(LibraryGenerator.class)
            @FixtureCount(stuCount = 0, profCount = 0, bookCount = 0, magazineCount = 0, referenceCount = 0)
            @TestStuMember(stuName = "Ali", stuId = "123")
            @TestReference(title = "Reference", copies = 2)
            Library library
    ) {
        try {
            library.returnDocument("Ali", "Reference");
        } catch (LibraryException ignored) {
        } catch (Exception ignored) {
            fail("Got an unexpected error");
        }

        try {
            library.timePass(60);
            int penalty1 = library.getTotalPenalty("Ali");
            library.timePass(1);
            int penalty2 = library.getTotalPenalty("Ali");
            int penaltyDiff = penalty2 - penalty1;
            library.borrow("Ali", "Reference");
            library.timePass(5);
            assertEquals(library.getTotalPenalty("Ali"), penalty2 + 5 * penaltyDiff);
            library.timePass(1);
            assertEquals(library.getTotalPenalty("Ali"), penalty2 + 6 * penaltyDiff + 5000);
            library.timePass(3);
            assertEquals(library.getTotalPenalty("Ali"), penalty2 + 9 * penaltyDiff + 22000);
        } catch (LibraryException e) {
            fail("Got exception while passing time: " + e.getMessage());
        } catch (Exception ignored) {
            fail("Got an unexpected error");
        }
    }

    @Property
    public void illegalityOfExtendingMagazine(
            @From(LibraryGenerator.class)
            @FixtureCount()
            @TestStuMember(stuName = "Ali", stuId = "123")
            @TestMagazine(title = "Magazine", copies = 1, year = 1400, number = 1)
            Library library
    ) {
        try {
            library.borrow("Ali", "Magazine");
        } catch (LibraryException ignored) {
            return;
        }

        try {
            library.extend("Ali", "Magazine");
            fail("Expected exception while extending magazine");
        } catch (LibraryException ignored) {
        } catch (Exception ignored) {
            fail("Got an unexpected error");
        }
    }
}
