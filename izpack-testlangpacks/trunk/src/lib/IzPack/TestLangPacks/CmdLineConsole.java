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

package IzPack.TestLangPacks;

import java.io.PrintStream;

/**
 * Handles command line tasks.
 */
public class CmdLineConsole extends LangPackFileHandling
{
   /**
    * The default contructor of the class. Not allowed.
    */
   @SuppressWarnings("unused")
   private CmdLineConsole()
   {
      super();
   }
   
   /**
    * Constructor of the class.
    * @param args Command line arguments.
    */
   public CmdLineConsole(String[] args)
   {
      super();

      System.out.println("\n" + Utils.getNameAndVersionInfo());
      System.out.println("");

      // We need at least one argument.
      if (args.length == 0)
      {
         System.out.println("No any IzPack language file given to be checked!\n");
         printHelp();
         return;
      }

      if (args[0].equals("-h") || args[0].equals("-?")) // For help.
      {
         printHelp();
         return;
      }

      String xmlBaseFile = "eng.xml";
      String xmlTestFile = null;
      boolean checkOnlyBaseFile = false;
      boolean printSameStrings = false;

      // Handle command line arguments.
      for (int x = 0; x < args.length; x++)
      {
         if (args[x].equals("-b")) // Path and file name for base file.
         {
            if (x < args.length)
            {
               x++;
               xmlBaseFile = args[x];
            }
         }
         else if (args[x].equals("-cb"))
         {
            checkOnlyBaseFile = true;  // Check only base file.
         }
         else if (args[x].equals("-s"))
         {
            printSameStrings = true;  // Check same strings in XML file.
         }
         else if (args[x].contains("-"))
         {
            System.err.println("Command line contains invalid argument: \"" + args[x] + "\"!\n");
            printHelp();
            return;
         }
         else
         {
            xmlTestFile = args[x];  // Lang file to be tested.
         }
      }

      // Load and parse language XML base file.
      System.out.println("Loading and checking base file: " + xmlBaseFile);

      try
      {
         this.createLangPackBase(xmlBaseFile);
      }
      catch (Exception e)
      {
         printMessage(System.err, "Error in base file", e.getMessage());
         return;
      }

      if (checkOnlyBaseFile)
      {
         return;
      }

      // Load and parse language XML file to be tested.
      System.out.println("\nLoading and checking file to check: " + xmlTestFile);
      try
      {
         this.createLangPackTest(xmlTestFile);
      }
      catch (Exception e)
      {
         printMessage(System.err, "Error in file to be tested", e.getMessage());
         return;
      }

      // Finding missing string ID's.
      // ---------------------------
      System.out.println("\nFinding ID's which should be added ("+xmlBaseFile+" => "+xmlTestFile+"):");
      MissingIds missingIds = new MissingIds(this.langItemsBase, this.langItemsTest);
      System.out.println(missingIds.getResultString());
//
//      for (LanguageItem itemBase : langItemsBase)
//      {
//         key = itemBase.getKey();
//         // If there isn't any ID string,
//         if (key==null)
//         {
//            continue;   // just go to next.
//         }
//         for (LanguageItem itemToCheck : langItemsTest)
//         {
//            String checkKey = itemToCheck.getKey();
//            if (checkKey!=null)
//            {
//               if (key.equals(checkKey))
//               {
//                  if (itemToCheck.getValue() != null)
//                  {
//                     found = true;  // Only filled id and txt will procedure true!
//                  }
//               }
//            }
//         }
//
//         if (!found)
//         {
//            System.out.println(makeKeyValueString(key, itemBase.getValue()));
//            itemPrinted = true;
//         }
//         found = false;
//      }
//
//      if (!itemPrinted)
//      {
//         System.out.println("   (none)");
//      }

      // Finding ID's which are not needed anymore.
      // -----------------------------------------
      System.out.println("\nFinding ID's which are not needed anymore in " + xmlTestFile + ":");
      NotNeededIds notNeededIds = new NotNeededIds(this.langItemsBase, this.langItemsTest);
      System.out.println(notNeededIds.getResultString());
//       key = null;
//       found = false;
//       itemPrinted = false;
//       for (LanguageItem itemToCheck : langItemsTest)
//       {
//          key = itemToCheck.getKey();
//          // If there isn't any ID string,
//          if (key == null)
//          {
//             continue;   // just go to the next.
//          }
//          for (LanguageItem itemBase : langItemsBase)
//          {
//             String checkKey = itemBase.getKey();
//             String checkValue = itemBase.getValue();
//             if (checkKey != null && checkValue != null)
//             {
//                if (checkKey.equals(key))
//                {
//                   if (checkValue != null)
//                   {
//                      found = true;  // Only filled id and txt will procedure true!
//                   }
//                }
//             }
//          }

//          if (!found)
//          {
//             System.out.println(Utils.makeKeyValueString(key, itemToCheck.getValue()));
//             itemPrinted = true;
//          }
//          found = false;
//       }

//       if (!itemPrinted)
//       {
//          System.out.println("   (none)");
//       }

      // Check unknown attributes.
      // ------------------------
      System.out.println("\nFinding unknown attributes in " + xmlTestFile + ":");
      UnknownAttributes unknownAttributes = new UnknownAttributes(this.langItemsBase, this.langItemsTest);
      System.out.println(unknownAttributes.getResultString());
//       found = false;
//       for (LanguageItem itemToCheck : langItemsTest)
//       {
//          String[] unknownAttrs = itemToCheck.getUnknownAttributes();
//          if (unknownAttrs != null)
//          {
//             String msg = "   Found unknown attributes in";
//             msg = msg + Utils.makeKeyValueString(itemToCheck.getKey(), itemToCheck.getValue());
//             System.out.println(msg + ":");
//             int max = unknownAttrs.length;
//             for (int x = 0; x < max; x++)
//             {
//                System.out.println("      " + unknownAttrs[x]);
//             }
//             unknownAttrs = null;
//             found = true;
//          }
//       }

//       if (!found)
//       {
//          System.out.println("   (none)");
//       }

      // Finding unknown elements.
      // ------------------------
      System.out.println("\nFinding unknown elements in " + xmlTestFile + ":");
      System.out.println("(means elements which are not supported)");
      UnknownElements unknownElements = new UnknownElements(this.langPackTest);
      System.out.println(unknownElements.getResultString());
//      String[] unknownElements = langPackTest.getUnknownElements();
//      if (unknownElements.length == 0)
//      {
//         System.out.println("   (none)");
//      }
//      else
//      {
//         for (String elem : unknownElements)
//         {
//            System.out.println("   <" + elem + " ... />");
//         }
//      }

      if (printSameStrings)
      {
         // Finding possible same strings (finding with last word in the ID which
         // consists of two words or more).
         // ---------------------------------------------------------------------
         System.out.println("\nFinding possible same strings in " + xmlTestFile + ":");
         System.out.println("   (Checks that translations are congruent (meaning the strings in same context");
         System.out.println("    have been translated at the same way). This also produces incorrect");
         System.out.println("    results!)\n");
         System.out.println("    Do NOT change at once! Check by hand in unclear cases.");

         SameStrings sameStrings = new SameStrings(this.langItemsTest);
         System.out.println(sameStrings.getResultString());
//         // Collect same strings.
//         Hashtable<String, ArrayList<LanguageItem>> sameStrings = getSameStrings(langItemsTest);
//         if (sameStrings.size() > 0)
//         {
//            Set<Map.Entry<String, ArrayList<LanguageItem>>> keyValuePairs = sameStrings.entrySet();
//            Iterator<Map.Entry<String, ArrayList<LanguageItem>>> iter = keyValuePairs.iterator();
//
//            // 'while' handles the "heading" for the same strings.
//            while (iter.hasNext())
//            {
//               java.util.Map.Entry<String, ArrayList<LanguageItem>> keyValuePair = iter.next();
//               String sameKey = keyValuePair.getKey();
//               ArrayList<LanguageItem> values = keyValuePair.getValue();
//               int numValues = values.size();
//               if (numValues > 1)
//               {
//                  System.out.println("\n   \"" + sameKey + "\":");
//                  // 'for' handles all str elements for the "heading".
//                  for (int i = 0; i < numValues; i++)
//                  {
//                     String itemKey = "      \"";
//                     String itemValue = "          \"";
//                     itemKey += values.get(i).getKey() + "\"";
//                     itemValue += values.get(i).getValue() + "\"";
//                     System.out.println(itemKey + ":\n" + itemValue);
//                  }
//               }
//            }
//         }
//         else
//         {
//            System.out.println("   (none)");
//         }
      }
   }

   /**
    * Prints the message on the console screen.
    *
    * @param outStream  Output stream. System.out or System.err.
    * @param caption    The caption of the message.
    * @param msg        The message.
    */
   public static void printMessage (PrintStream outStream, String caption, String msg) {
      String totMsg = "";
      if (caption != null && caption.contains(""))
      {
         totMsg = "\n" + caption + ":\n   ";
      }
      totMsg = totMsg + msg;
      outStream.println(totMsg);
   }

   /**
    * Prints the help on the System.out.
    */
   private static void printHelp () {
      String helpMsg =
         "Usage: java -jar TestLangPacks.jar {langfile} [-b {basefile}] [-cb] [-s]\n" +
         "where:\n\n" +
         "{langfile} is the IzPack language file to be tested. File name can contain path\n" +
         "           to the file.\n\n" +
         "{basefile} is the IzPack language file which is used as a base file to the\n" +
         "           comparisons. If -b exists there must be space between -b and\n" +
         "           {basefile}. The name can contain also a path. If you want to give\n" +
         "           the path to default base file you must give both path and file.\n" +
         "           This file is optional. Default base file name is eng.xml.\n" +
         "-cb        Checks only base file (no other xml files needed)\n\n" +
         "-s         Prints same strings found in XML file. Comparing is done with\n" +
         "           the last word found in 'id' string in 'str' element.\n" +
         "           NOTE: Because this produces always something results and also\n" +
         "                 strings which are not related with each other this feature\n" +
         "                 must be activated by hand.\n" +
         "\n" +
         "To have results into the file put '>filename.ext' end of the line.\n\n" +
         "If you give -? or -h you will get this help." +
         "\n";
      System.out.print(helpMsg);
   }
}
