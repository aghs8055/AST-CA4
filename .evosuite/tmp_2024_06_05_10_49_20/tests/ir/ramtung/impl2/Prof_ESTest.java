/*
 * This file was automatically generated by EvoSuite
 * Wed Jun 05 07:38:11 GMT 2024
 */

package ir.ramtung.impl2;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import ir.ramtung.impl2.Document;
import ir.ramtung.impl2.Prof;
import ir.ramtung.impl2.Reference;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Prof_ESTest extends Prof_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Prof prof0 = new Prof("");
      Reference reference0 = new Reference("", (-1458));
      prof0.borrow(reference0);
      prof0.borrow(reference0);
      prof0.borrow(reference0);
      prof0.borrow(reference0);
      assertTrue(prof0.canBorrow());
      
      prof0.borrow(reference0);
      prof0.borrow(reference0);
      boolean boolean0 = prof0.canBorrow();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Prof prof0 = new Prof("&<zYG0K!");
      List<Document> list0 = prof0.docsBorrow;
      prof0.docsBorrow = list0;
      prof0.docsBorrow = null;
      // Undeclared exception!
      try { 
        prof0.canBorrow();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("ir.ramtung.impl2.Prof", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Prof prof0 = new Prof("");
      boolean boolean0 = prof0.canBorrow();
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      Prof prof0 = new Prof("");
      Reference reference0 = new Reference("", (-1458));
      prof0.borrow(reference0);
      prof0.borrow(reference0);
      prof0.borrow(reference0);
      prof0.borrow(reference0);
      assertTrue(prof0.canBorrow());
      
      prof0.borrow(reference0);
      boolean boolean0 = prof0.canBorrow();
      assertFalse(boolean0);
  }
}
