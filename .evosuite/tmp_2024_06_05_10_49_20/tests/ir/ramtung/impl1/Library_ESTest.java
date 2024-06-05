/*
 * This file was automatically generated by EvoSuite
 * Wed Jun 05 07:29:04 GMT 2024
 */

package ir.ramtung.impl1;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import ir.ramtung.impl1.Library;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Library_ESTest extends Library_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Library library0 = new Library();
      try { 
        library0.addBook("ir.ramtung.impl1.Book", (-1047));
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Negative or zero copies of a document cannot be added
         //
         verifyException("ir.ramtung.impl1.Library", e);
      }
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Library library0 = new Library();
      library0.timePass(0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Library library0 = new Library();
      library0.addProfMember((String) null);
      library0.addMagazine("Z[s+$eO>&5hXSUk@", 2630, 2630, 2630);
      library0.borrow((String) null, "Z[s+$eO>&5hXSUk@");
      library0.returnDocument((String) null, "Z[s+$eO>&5hXSUk@");
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Library library0 = new Library();
      library0.addMagazine("'R{`8<>", 2756, 1, 5);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Library library0 = new Library();
      library0.addStudentMember("1f,F", "+tH");
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Library library0 = new Library();
      library0.addProfMember("Z[s+$eO>&5hXSUk@");
      library0.addMagazine("Z[s+$eO>&5hXSUk@", 2598, 2598, 2598);
      library0.borrow("Z[s+$eO>&5hXSUk@", "Z[s+$eO>&5hXSUk@");
      library0.timePass(1);
      library0.extend("Z[s+$eO>&5hXSUk@", "Z[s+$eO>&5hXSUk@");
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Library library0 = new Library();
      library0.addProfMember((String) null);
      library0.addMagazine("Z[s+$eO>&5hXSUk@", 2630, 2630, 2630);
      library0.borrow((String) null, "Z[s+$eO>&5hXSUk@");
      library0.timePass(1376);
      int int0 = library0.getTotalPenalty((String) null);
      assertEquals(4122000, int0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Library library0 = new Library();
      try { 
        library0.addReference("", 0);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Documents with empty title are not allowed
         //
         verifyException("ir.ramtung.impl1.Document", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Library library0 = new Library();
      try { 
        library0.addMagazine("RJ+3J!!0 ;w^J 6'", (-1896), 0, (-3351));
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Magazine with zero or negative publication year
         //
         verifyException("ir.ramtung.impl1.Magazine", e);
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Library library0 = new Library();
      library0.addBook("&P/yRU?JYZoe", 860);
      try { 
        library0.addBook("&P/yRU?JYZoe", 1);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Document with the same title exists
         //
         verifyException("ir.ramtung.impl1.Library", e);
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Library library0 = new Library();
      library0.addProfMember("Cannot extend on the same day borrowed");
      try { 
        library0.addProfMember("Cannot extend on the same day borrowed");
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Member with the same name exists
         //
         verifyException("ir.ramtung.impl1.Library", e);
      }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Library library0 = new Library();
      library0.addProfMember((String) null);
      library0.addMagazine("s+VeI>&5hXUg5k", 2178, 2178, 2178);
      library0.addProfMember("s+VeI>&5hXUg5k");
      library0.borrow((String) null, "s+VeI>&5hXUg5k");
      library0.borrow("s+VeI>&5hXUg5k", "s+VeI>&5hXUg5k");
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Library library0 = new Library();
      library0.addMagazine("s+VeI>&5hXUg5k", 2178, 2178, 2178);
      library0.addProfMember("s+VeI>&5hXUg5k");
      library0.borrow("s+VeI>&5hXUg5k", "s+VeI>&5hXUg5k");
      try { 
        library0.returnDocument("s+VeI>&5hXUg5k", (String) null);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // The document is not in member's loan
         //
         verifyException("ir.ramtung.impl1.Library", e);
      }
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Library library0 = new Library();
      library0.addProfMember((String) null);
      library0.addMagazine("s+VeI>&5hXUg5k", 2178, 2178, 2178);
      library0.borrow((String) null, "s+VeI>&5hXUg5k");
      try { 
        library0.returnDocument("s+VeI>&5hXUg5k", (String) null);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // The document is not in member's loan
         //
         verifyException("ir.ramtung.impl1.Library", e);
      }
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Library library0 = new Library();
      library0.addProfMember((String) null);
      library0.addMagazine("s+VeI>&5hXUg5k", 2178, 2178, 2178);
      library0.addProfMember("s+VeI>&5hXUg5k");
      library0.borrow("s+VeI>&5hXUg5k", "s+VeI>&5hXUg5k");
      int int0 = library0.getTotalPenalty((String) null);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Library library0 = new Library();
      try { 
        library0.timePass((-264));
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Cannot go back in time
         //
         verifyException("ir.ramtung.impl1.Library", e);
      }
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Library library0 = new Library();
      try { 
        library0.getTotalPenalty("?n`V8SSE&-?;z'Y&>.r");
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Cannot find member
         //
         verifyException("ir.ramtung.impl1.Library", e);
      }
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Library library0 = new Library();
      try { 
        library0.extend("", "ir.ramtung.impl1.Loan");
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // The document is not in member's loan
         //
         verifyException("ir.ramtung.impl1.Library", e);
      }
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      Library library0 = new Library();
      library0.addProfMember("z^yVb1#CCafzLXq-");
      library0.addReference("z^yVb1#CCafzLXq-", 1);
      library0.borrow("z^yVb1#CCafzLXq-", "z^yVb1#CCafzLXq-");
      List<String> list0 = library0.availableTitles();
      assertFalse(list0.contains("z^yVb1#CCafzLXq-"));
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      Library library0 = new Library();
      library0.addReference("z^yVb1#CCafzLXq-", 1);
      List<String> list0 = library0.availableTitles();
      assertTrue(list0.contains("z^yVb1#CCafzLXq-"));
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      Library library0 = new Library();
      library0.addStudentMember("Document i not avBaCle to borrow", "Document i not avBaCle to borrow");
      library0.addReference("Document i not avBaCle to borrow", 24);
      library0.borrow("Document i not avBaCle to borrow", "Document i not avBaCle to borrow");
      library0.borrow("Document i not avBaCle to borrow", "Document i not avBaCle to borrow");
      try { 
        library0.borrow("Document i not avBaCle to borrow", "Document i not avBaCle to borrow");
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Cannot borrow more documents
         //
         verifyException("ir.ramtung.impl1.Library", e);
      }
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      Library library0 = new Library();
      library0.addProfMember("{ /xlHxAoq8P9>!.");
      library0.addReference("{ /xlHxAoq8P9>!.", 1);
      library0.borrow("{ /xlHxAoq8P9>!.", "{ /xlHxAoq8P9>!.");
      try { 
        library0.borrow("{ /xlHxAoq8P9>!.", "{ /xlHxAoq8P9>!.");
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Document is not available to borrow
         //
         verifyException("ir.ramtung.impl1.Library", e);
      }
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      Library library0 = new Library();
      library0.addReference("QkV.S", 26);
      try { 
        library0.borrow("QkV.S", "QkV.S");
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Cannot find member to borrow
         //
         verifyException("ir.ramtung.impl1.Library", e);
      }
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      Library library0 = new Library();
      try { 
        library0.borrow("", "=0");
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Cannot find document to borrow
         //
         verifyException("ir.ramtung.impl1.Library", e);
      }
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      Library library0 = new Library();
      try { 
        library0.addBook(":VNBw@TU(&tB'\"(Ed}", 0);
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Negative or zero copies of a document cannot be added
         //
         verifyException("ir.ramtung.impl1.Library", e);
      }
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      Library library0 = new Library();
      try { 
        library0.addStudentMember("", "");
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // Empty member name not allowed
         //
         verifyException("ir.ramtung.impl1.Member", e);
      }
  }
}
