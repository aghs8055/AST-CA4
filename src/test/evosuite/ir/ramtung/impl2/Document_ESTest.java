/*
 * This file was automatically generated by EvoSuite
 * Wed Jun 05 07:40:02 GMT 2024
 */

package ir.ramtung.impl2;

import org.junit.Test;
import static org.junit.Assert.*;
import ir.ramtung.impl2.Book;
import ir.ramtung.impl2.Magazine;
import ir.ramtung.impl2.Reference;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Document_ESTest extends Document_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Book book0 = new Book((String) null, 1371);
      book0.getTitle();
      assertEquals(1371, book0.getCopies());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Magazine magazine0 = new Magazine("", 0, 0, 0);
      String string0 = magazine0.getTitle();
      assertNotNull(string0);
      assertEquals(0, magazine0.getCopies());
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Magazine magazine0 = new Magazine("", 0, 0, 0);
      assertEquals(2, magazine0.getDay());
      
      magazine0.day = 0;
      int int0 = magazine0.getDay();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Reference reference0 = new Reference("xoc", (-129));
      assertEquals(5, reference0.getDay());
      
      reference0.day = (-129);
      int int0 = reference0.getDay();
      assertEquals((-129), int0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Reference reference0 = new Reference("", 0);
      int int0 = reference0.getCopies();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Magazine magazine0 = new Magazine(" =A\"=(", 0, 0, 3);
      int int0 = magazine0.getCopies();
      assertEquals(3, int0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Magazine magazine0 = new Magazine("", 0, 0, 0);
      magazine0.calculatePenalty((-3260));
      assertEquals(0, magazine0.getCopies());
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Magazine magazine0 = new Magazine("MWauTj2DRAM'\"", (-2551), (-2551), (-2551));
      int int0 = magazine0.getCopies();
      assertEquals((-2551), int0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Magazine magazine0 = new Magazine("o", (-21), (-21), (-21));
      magazine0.returnBook();
      assertEquals((-20), magazine0.getCopies());
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Magazine magazine0 = new Magazine("o", (-21), (-21), (-21));
      int int0 = magazine0.getDay();
      assertEquals((-21), magazine0.getCopies());
      assertEquals(2, int0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Magazine magazine0 = new Magazine("MWauTj2DRAM'\"", (-2551), (-2551), (-2551));
      magazine0.barrowBook();
      assertEquals((-2552), magazine0.getCopies());
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Book book0 = new Book("MWauTj2DRAM'\"", (-2551));
      String string0 = book0.getTitle();
      assertEquals((-2551), book0.getCopies());
      assertNotNull(string0);
  }
}
