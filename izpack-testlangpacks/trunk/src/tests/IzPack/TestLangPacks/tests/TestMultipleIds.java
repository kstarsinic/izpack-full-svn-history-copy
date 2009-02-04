/*
 * IzPack - Copyright 2001-2009 Julien Ponge, All Rights Reserved.
 *
 * http://izpack.org/
 * http://izpack.codehaus.org/
 *
 * Copyright 2009 Ari Voutilainen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package IzPack.TestLangPacks.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Hashtable;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import IzPack.TestLangPacks.LanguageItem;
import IzPack.TestLangPacks.MultipleIds;

/**
 * Tests multiple ID's.
 */
public class TestMultipleIds extends TestBase
{
   private MultipleIds multipleIds;
   
   public TestMultipleIds()
   {
      super();
      try
      {
         createLangPackBase(fileXmlBase);
         createLangPackTest(xmlTestFile4);
      }
      catch (Exception e)
      {
         String msg = "Error in " + this.getClass().toString() + "().\n   " + e.getMessage();
         assertNotNull(msg, null);
      }

      // Create desired object.
      multipleIds = new MultipleIds(langItemsTest);
   }

   @BeforeClass
   public static void setUpClass() throws Exception
   {
   }

   @AfterClass
   public static void tearDownClass() throws Exception
   {
   }

   @Before
   public void setUp()
   {
   }

   @After
   public void tearDown()
   {
   }

   /**
    * Gets the results and checks them.
    */
   @Test
   public void getResults()
   {
      // Get results.
      Hashtable<String,ArrayList<LanguageItem>> result = multipleIds.getResult();

      // Get result without knowing anything about the key.
      ArrayList<LanguageItem> resultItems2 = result.values().iterator().next();
      assertEquals(3, resultItems2.size());
   }
   
   /**
    * Test whether string result is null or "". If it is its error.
    */
   @Test
   public void getResultString()
   {
      String result = multipleIds.getResultString();
      assertNotNull(result);
      Assert.assertNotSame("", result);
   }
}