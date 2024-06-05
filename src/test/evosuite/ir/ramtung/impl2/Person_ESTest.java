/*
 * This file was automatically generated by EvoSuite
 * Wed Jun 05 07:32:20 GMT 2024
 */

package ir.ramtung.impl2;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import ir.ramtung.impl2.Book;
import ir.ramtung.impl2.Document;
import ir.ramtung.impl2.Magazine;
import ir.ramtung.impl2.Prof;
import ir.ramtung.impl2.Reference;
import ir.ramtung.impl2.Student;
import java.util.LinkedList;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Person_ESTest extends Person_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Prof prof0 = new Prof("!F7Tb$[!t");
      Magazine magazine0 = new Magazine("!F7Tb$[!t", 0, (-2542), (-2542));
      LinkedList<Integer> linkedList0 = new LinkedList<Integer>();
      prof0.penalty = (-2542);
      prof0.dayBorrow = (List<Integer>) linkedList0;
      prof0.borrow(magazine0);
      Integer integer0 = new Integer(0);
      linkedList0.addFirst(integer0);
      prof0.timePass();
      assertEquals((-542), prof0.getPenalty());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Prof prof0 = new Prof("!F7Tb$[!t");
      LinkedList<Integer> linkedList0 = new LinkedList<Integer>();
      prof0.penalty = (-2542);
      prof0.dayBorrow = (List<Integer>) linkedList0;
      Integer integer0 = new Integer(0);
      linkedList0.addFirst(integer0);
      // Undeclared exception!
      try { 
        prof0.timePass();
        fail("Expecting exception: IndexOutOfBoundsException");
      
      } catch(IndexOutOfBoundsException e) {
         //
         // Index: 0, Size: 0
         //
         verifyException("java.util.ArrayList", e);
      }
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Prof prof0 = new Prof("");
      Magazine magazine0 = new Magazine("", 3000, 3000, 3000);
      prof0.borrow(magazine0);
      prof0.timePass();
      prof0.timePass();
      assertEquals(0, prof0.getPenalty());
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Prof prof0 = new Prof("0[h=PF!4:Qx\u0006~ZefXJ");
      Magazine magazine0 = new Magazine("0[h=PF!4:Qx\u0006~ZefXJ", 2185, (-1760), (-422));
      prof0.borrow(magazine0);
      prof0.penalty = (-1);
      prof0.returnDoc("0[h=PF!4:Qx\u0006~ZefXJ");
      assertEquals("0[h=PF!4:Qx\u0006~ZefXJ", prof0.getName());
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Prof prof0 = new Prof("!ymjE");
      prof0.penalty = (-2147483645);
      LinkedList<Document> linkedList0 = new LinkedList<Document>();
      Magazine magazine0 = new Magazine("!ymjE", (-2147483645), 1468, (-1));
      linkedList0.add((Document) magazine0);
      prof0.docsBorrow = (List<Document>) linkedList0;
      // Undeclared exception!
      try { 
        prof0.returnDoc("!ymjE");
        fail("Expecting exception: IndexOutOfBoundsException");
      
      } catch(IndexOutOfBoundsException e) {
         //
         // Index: 0, Size: 0
         //
         verifyException("java.util.ArrayList", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Prof prof0 = new Prof("!F7Tb$[!t");
      Magazine magazine0 = new Magazine("!F7Tb$[!t", 0, (-2542), (-2542));
      prof0.penalty = (-2542);
      prof0.borrow(magazine0);
      prof0.extend("!F7Tb$[!t");
      assertTrue(prof0.canBorrow());
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Prof prof0 = new Prof("");
      Reference reference0 = new Reference("", 0);
      reference0.day = 0;
      prof0.borrow(reference0);
      prof0.timePass();
      int int0 = prof0.getPenalty();
      assertEquals(5000, int0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Prof prof0 = new Prof("!F7Tb$[!t");
      prof0.penalty = (-2542);
      int int0 = prof0.getPenalty();
      assertEquals((-2542), int0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Prof prof0 = new Prof((String) null);
      prof0.getName();
      assertEquals(0, prof0.getPenalty());
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Prof prof0 = new Prof("E<'2kL*hJzV7Zx-");
      prof0.name = "";
      prof0.getName();
      assertEquals(0, prof0.getPenalty());
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Prof prof0 = new Prof("0[h=PF!4:Qx\u0006~ZefXJ");
      prof0.canBorrow();
      assertEquals(0, prof0.getPenalty());
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Student student0 = new Student("", "ir.ramtung.impl2.Student");
      Reference reference0 = new Reference("ir.ramtung.impl2.Student", 0);
      student0.borrow(reference0);
      student0.borrow(reference0);
      boolean boolean0 = student0.canBorrow();
      assertFalse(student0.canBorrow());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Prof prof0 = new Prof("");
      prof0.dayBorrow = null;
      // Undeclared exception!
      try { 
        prof0.timePass();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("ir.ramtung.impl2.Person", e);
      }
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Prof prof0 = new Prof("");
      prof0.dayBorrow = null;
      LinkedList<Document> linkedList0 = new LinkedList<Document>();
      Reference reference0 = new Reference("", 0);
      linkedList0.add((Document) reference0);
      prof0.docsBorrow = (List<Document>) linkedList0;
      // Undeclared exception!
      try { 
        prof0.returnDoc("");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("ir.ramtung.impl2.Person", e);
      }
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Student student0 = new Student("ir.ramtung.impl2.Magazine", "ir.ramtung.impl2.Magazine");
      Book book0 = new Book((String) null, 2864);
      student0.borrow(book0);
      // Undeclared exception!
      try { 
        student0.extend("ir.ramtung.impl2.Magazine");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
      }
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Student student0 = new Student((String) null, (String) null);
      Book book0 = new Book("", 1);
      student0.borrow(book0);
      LinkedList<Integer> linkedList0 = new LinkedList<Integer>();
      student0.dayBorrow = (List<Integer>) linkedList0;
      // Undeclared exception!
      try { 
        student0.extend("");
        fail("Expecting exception: IndexOutOfBoundsException");
      
      } catch(IndexOutOfBoundsException e) {
         //
         // Index: 0, Size: 0
         //
         verifyException("java.util.LinkedList", e);
      }
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Prof prof0 = new Prof("4yW*x#rQ\"Pr>");
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
  public void test17()  throws Throwable  {
      Prof prof0 = new Prof("");
      // Undeclared exception!
      try { 
        prof0.borrow((Document) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("ir.ramtung.impl2.Person", e);
      }
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      Student student0 = new Student("cant Uxtend", "cant Uxtend");
      Book book0 = new Book("cant Sxtend", (-1937019871));
      student0.borrow(book0);
      assertTrue(student0.canBorrow());
      
      student0.returnDoc("cant Uxtend");
      assertEquals(0, student0.getPenalty());
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      Prof prof0 = new Prof("U8B2pICQo");
      Book book0 = new Book("U8B2pICQo", (-1379));
      prof0.borrow(book0);
      prof0.extend("U8B2pICQo");
      try { 
        prof0.extend("U8B2pICQo");
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // cant extend
         //
         verifyException("ir.ramtung.impl2.Person", e);
      }
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      Prof prof0 = new Prof("l)'fzv|ReR>:");
      Book book0 = new Book("l)'fzv|ReR>:", 0);
      prof0.borrow(book0);
      try { 
        prof0.extend("");
        fail("Expecting exception: Exception");
      
      } catch(Exception e) {
         //
         // cant extend
         //
         verifyException("ir.ramtung.impl2.Person", e);
      }
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      Prof prof0 = new Prof("!F7Tb$[!t");
      String string0 = prof0.getName();
      assertNotNull(string0);
      assertEquals(0, prof0.getPenalty());
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      Prof prof0 = new Prof("!F7Tb$[!t");
      int int0 = prof0.getPenalty();
      assertEquals(0, int0);
  }
}
