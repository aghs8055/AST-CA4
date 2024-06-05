/*
 * This file was automatically generated by EvoSuite
 * Wed Jun 05 07:34:13 GMT 2024
 */

package ir.ramtung.impl2;

import org.junit.Test;
import static org.junit.Assert.*;
import ir.ramtung.impl2.Book;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Book_ESTest extends Book_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Book book0 = new Book((String) null, (-15));
      int int0 = book0.calculatePenalty((-15));
      assertEquals(10, book0.getDay());
      assertEquals(3000, int0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Book book0 = new Book("['Aeq^@ii_", 10);
      int int0 = book0.calculatePenalty((-7));
      assertEquals(2000, int0);
      assertEquals(10, book0.getDay());
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Book book0 = new Book("", (-2016));
      int int0 = book0.calculatePenalty((-21));
      assertEquals(3000, int0);
      assertEquals(10, book0.getDay());
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      Book book0 = new Book("", (-2016));
      int int0 = book0.calculatePenalty(0);
      assertEquals(10, book0.getDay());
      assertEquals(2000, int0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      Book book0 = new Book("", (-2016));
      int int0 = book0.calculatePenalty((-2016));
      assertEquals(2000, int0);
      assertEquals(10, book0.getDay());
  }
}
