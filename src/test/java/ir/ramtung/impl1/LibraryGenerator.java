package ir.ramtung.impl1;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.generator.GeneratorConfiguration;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import ir.ramtung.sts01.LibraryException;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.*;

public class LibraryGenerator extends Generator<Library> {
    private TestStuMember testStuMember;
    private TestProfMember testProfMember;
    private TestBook testBook;
    private TestMagazine testMagazine;
    private TestReference testReference;
    private FixtureCount fixtureCount;


    public LibraryGenerator() {
        super(Library.class);
    }

    @Override
    public Library generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
        Library library = new Library();
        List<String> memberNames = new ArrayList<>(Collections.emptyList());

        if (testStuMember != null) {
            try {
                library.addStudentMember(testStuMember.stuId(), testStuMember.stuName());
                memberNames.add("test");
                memberNames.add(testStuMember.stuName());
            } catch (LibraryException ignored) {
            }
        }

        if (testProfMember != null) {
            try {
                library.addProfMember(testProfMember.profName());
                memberNames.add(testProfMember.profName());
            } catch (LibraryException ignored) {
            }
        }

        if (testBook != null) {
            try {
                library.addBook(testBook.title(), testBook.copies());
            } catch (LibraryException ignored) {
            }
        }

        if (testMagazine != null) {
            try {
                library.addMagazine(testMagazine.title(), testMagazine.year(), testMagazine.number(), testMagazine.copies());
            } catch (LibraryException ignored) {
            }
        }

        if (testReference != null) {
            try {
                library.addReference(testReference.title(), testReference.copies());
            } catch (LibraryException ignored) {
            }
        }

        if (testStuMember != null) {
            addStudMember(library, fixtureCount.stuCount(), memberNames);
            addProfMember(library, fixtureCount.profCount(), memberNames);
            addBook(library, fixtureCount.bookCount());
            addMagazine(library, fixtureCount.magazineCount());
            addReference(library, fixtureCount.referenceCount());
        }

        try {
            simulateTimePass(library, fixtureCount.days(), memberNames);
        } catch (LibraryException ignored) {
        }

        return library;
    }

    public void simulateTimePass(Library library, int time, List<String> memberNames) throws LibraryException {
        List<List<String>> borrowedBooks = new ArrayList<>(Collections.emptyList());
        Random random = new Random();

        if (memberNames.isEmpty()) {
            library.timePass(time);
            return;
        }

        for (int i = 0; i < time; i++) {
            int borrowCount = randomInt();
            for (int j = 0; j < borrowCount; j++) {
                List<String> availableTitles = library.availableTitles();

                if (!availableTitles.isEmpty()) {
                    try {
                        String member = memberNames.get(random.nextInt(memberNames.size()));
                        String title = availableTitles.get(random.nextInt(availableTitles.size()));
                        library.borrow(member, title);
                        borrowedBooks.add(Arrays.asList(member, title));
                    } catch (LibraryException ignored) {
                    }
                }
            }

            if (!borrowedBooks.isEmpty()) {
                int extendCount = random.nextInt(borrowedBooks.size());
                for (int j = 0; j < extendCount; j++) {
                    try {
                        List<String> borrowedBook = borrowedBooks.get(random.nextInt(borrowedBooks.size()));
                        library.extend(borrowedBook.get(0), borrowedBook.get(1));
                    } catch (LibraryException ignored) {
                    }
                }

                int returnCount = random.nextInt(borrowedBooks.size());
                for (int j = 0; j < returnCount; j++) {
                    try {
                        List<String> borrowedBook = borrowedBooks.get(random.nextInt(borrowedBooks.size()));
                        library.returnDocument(borrowedBook.get(0), borrowedBook.get(1));
                        borrowedBooks.remove(borrowedBook);
                    } catch (LibraryException ignored) {
                    }
                }
            }

            library.timePass(1);
        }
    }

    public void addStudMember(Library library, int count, List<String> memberNames) {
        for (int i = 0; i < count; i++) {
            try {
                String stuName = randomString();
                library.addStudentMember(randomString(), stuName);
                memberNames.add(stuName);
            } catch (LibraryException ignored) {
            }
        }
    }

    public void addProfMember(Library library, int count, List<String> memberNames) {
        for (int i = 0; i < count; i++) {
            try {
                String profName = randomString();
                library.addProfMember(profName);
                memberNames.add(profName);
            } catch (LibraryException ignored) {
            }
        }
    }

    public void addBook(Library library, int count) {
        for (int i = 0; i < count; i++) {
            try {
                library.addBook(randomString(), randomInt());
            } catch (LibraryException ignored) {
            }
        }
    }

    public void addMagazine(Library library, int count) {
        for (int i = 0; i < count; i++) {
            try {
                library.addMagazine(randomString(), randomInt(), randomInt(), randomInt());
            } catch (LibraryException ignored) {
            }
        }
    }

    public void addReference(Library library, int count) {
        for (int i = 0; i < count; i++) {
            try {
                library.addReference(randomString(), randomInt());
            } catch (LibraryException ignored) {
            }
        }
    }

    private static String randomString() {
        return UUID.randomUUID().toString();
    }

    private static int randomInt() {
        return (int) (Math.random() * 100 + 1);
    }

    public void configure(TestStuMember testStuMember) {
        this.testStuMember = testStuMember;
    }

    public void configure(TestProfMember testProfMember) {
        this.testProfMember = testProfMember;
    }

    public void configure(TestBook testBook) {
        this.testBook = testBook;
    }

    public void configure(TestMagazine testMagazine) {
        this.testMagazine = testMagazine;
    }

    public void configure(TestReference testReference) {
        this.testReference = testReference;
    }

    public void configure(FixtureCount fixtureCount) {
        this.fixtureCount = fixtureCount;
    }

    @Target({ PARAMETER, FIELD, ANNOTATION_TYPE, TYPE_USE })
    @Retention(RUNTIME)
    @GeneratorConfiguration
    public @interface TestStuMember {
        String stuName();
        String stuId();
    }

        @Target({ PARAMETER, FIELD, ANNOTATION_TYPE, TYPE_USE })
        @Retention(RUNTIME)
        @GeneratorConfiguration
        public @interface TestProfMember {
            String profName();
        }

    @Target({ PARAMETER, FIELD, ANNOTATION_TYPE, TYPE_USE })
    @Retention(RUNTIME)
    @GeneratorConfiguration
    public @interface TestBook {
        String title();
        int copies();
    }

    @Target({ PARAMETER, FIELD, ANNOTATION_TYPE, TYPE_USE })
    @Retention(RUNTIME)
    @GeneratorConfiguration
    public @interface TestMagazine {
        String title();
        int number();
        int year();
        int copies();
    }

    @Target({ PARAMETER, FIELD, ANNOTATION_TYPE, TYPE_USE })
    @Retention(RUNTIME)
    @GeneratorConfiguration
    public @interface TestReference {
        String title();
        int copies();
    }

    @Target({ PARAMETER, FIELD, ANNOTATION_TYPE, TYPE_USE })
    @Retention(RUNTIME)
    @GeneratorConfiguration
    public @interface FixtureCount {
        int stuCount() default 10;
        int profCount() default 10;
        int bookCount() default 10;
        int magazineCount() default 10;
        int referenceCount() default 10;
        int days() default 10;
    }
}
