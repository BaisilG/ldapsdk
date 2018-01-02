/*
 * Copyright 2007-2018 Ping Identity Corporation
 * All Rights Reserved.
 */
/*
 * Copyright (C) 2007-2018 Ping Identity Corporation
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License (GPLv2 only)
 * or the terms of the GNU Lesser General Public License (LGPLv2.1 only)
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses>.
 */
package com.unboundid.ldap.sdk.controls;



import java.util.ArrayList;

import org.testng.annotations.Test;

import com.unboundid.ldap.sdk.LDAPSDKTestCase;



/**
 * This class provides a set of test cases for the PersistentSearchChangeType
 * class.
 */
public class PersistentSearchChangeTypeTestCase
       extends LDAPSDKTestCase
{
  /**
   * Tests the {@code getName} method.
   */
  @Test()
  public void testGetName()
  {
    assertEquals(PersistentSearchChangeType.ADD.getName(), "add");
    assertEquals(PersistentSearchChangeType.DELETE.getName(), "delete");
    assertEquals(PersistentSearchChangeType.MODIFY.getName(), "modify");
    assertEquals(PersistentSearchChangeType.MODIFY_DN.getName(), "moddn");
  }



  /**
   * Tests the {@code intValue} method.
   */
  @Test()
  public void testIntValue()
  {
    assertEquals(PersistentSearchChangeType.ADD.intValue(), 1);
    assertEquals(PersistentSearchChangeType.DELETE.intValue(), 2);
    assertEquals(PersistentSearchChangeType.MODIFY.intValue(), 4);
    assertEquals(PersistentSearchChangeType.MODIFY_DN.intValue(), 8);
  }



  /**
   * Tests the {@code valueOf} method that takes an int argument.
   */
  @Test()
  public void testValueOfInt()
  {
    assertEquals(PersistentSearchChangeType.valueOf(0), null);

    assertEquals(PersistentSearchChangeType.valueOf(1),
                 PersistentSearchChangeType.ADD);
    assertEquals(PersistentSearchChangeType.valueOf(2),
                 PersistentSearchChangeType.DELETE);
    assertEquals(PersistentSearchChangeType.valueOf(4),
                 PersistentSearchChangeType.MODIFY);
    assertEquals(PersistentSearchChangeType.valueOf(8),
                 PersistentSearchChangeType.MODIFY_DN);
  }



  /**
   * Tests the {@code valueOf} method that takes a string argument.
   */
  @Test()
  public void testValuesOfString()
  {
    assertEquals(PersistentSearchChangeType.valueOf("ADD"),
                 PersistentSearchChangeType.ADD);
    assertEquals(PersistentSearchChangeType.valueOf("DELETE"),
                 PersistentSearchChangeType.DELETE);
    assertEquals(PersistentSearchChangeType.valueOf("MODIFY"),
                 PersistentSearchChangeType.MODIFY);
    assertEquals(PersistentSearchChangeType.valueOf("MODIFY_DN"),
                 PersistentSearchChangeType.MODIFY_DN);
  }



  /**
   * Tests the {@code encodeChangeTypes} method.
   */
  @Test()
  public void testEncodeChangeTypesVarArgs()
  {
    assertEquals(PersistentSearchChangeType.encodeChangeTypes(
                     PersistentSearchChangeType.ADD),
                 1);
    assertEquals(PersistentSearchChangeType.encodeChangeTypes(
                     PersistentSearchChangeType.DELETE),
                 2);
    assertEquals(PersistentSearchChangeType.encodeChangeTypes(
                     PersistentSearchChangeType.MODIFY),
                 4);
    assertEquals(PersistentSearchChangeType.encodeChangeTypes(
                     PersistentSearchChangeType.MODIFY_DN),
                 8);

    assertEquals(PersistentSearchChangeType.encodeChangeTypes(
                     PersistentSearchChangeType.ADD,
                     PersistentSearchChangeType.DELETE),
                 3);
    assertEquals(PersistentSearchChangeType.encodeChangeTypes(
                     PersistentSearchChangeType.ADD,
                     PersistentSearchChangeType.MODIFY),
                 5);
    assertEquals(PersistentSearchChangeType.encodeChangeTypes(
                     PersistentSearchChangeType.ADD,
                     PersistentSearchChangeType.MODIFY_DN),
                 9);
    assertEquals(PersistentSearchChangeType.encodeChangeTypes(
                     PersistentSearchChangeType.DELETE,
                     PersistentSearchChangeType.MODIFY),
                 6);
    assertEquals(PersistentSearchChangeType.encodeChangeTypes(
                     PersistentSearchChangeType.DELETE,
                     PersistentSearchChangeType.MODIFY_DN),
                 10);
    assertEquals(PersistentSearchChangeType.encodeChangeTypes(
                     PersistentSearchChangeType.MODIFY,
                     PersistentSearchChangeType.MODIFY_DN),
                 12);

    assertEquals(PersistentSearchChangeType.encodeChangeTypes(
                     PersistentSearchChangeType.ADD,
                     PersistentSearchChangeType.DELETE,
                     PersistentSearchChangeType.MODIFY),
                 7);
    assertEquals(PersistentSearchChangeType.encodeChangeTypes(
                     PersistentSearchChangeType.ADD,
                     PersistentSearchChangeType.DELETE,
                     PersistentSearchChangeType.MODIFY_DN),
                 11);
    assertEquals(PersistentSearchChangeType.encodeChangeTypes(
                     PersistentSearchChangeType.ADD,
                     PersistentSearchChangeType.MODIFY,
                     PersistentSearchChangeType.MODIFY_DN),
                 13);
    assertEquals(PersistentSearchChangeType.encodeChangeTypes(
                     PersistentSearchChangeType.DELETE,
                     PersistentSearchChangeType.MODIFY,
                     PersistentSearchChangeType.MODIFY_DN),
                 14);

    assertEquals(PersistentSearchChangeType.encodeChangeTypes(
                     PersistentSearchChangeType.ADD,
                     PersistentSearchChangeType.DELETE,
                     PersistentSearchChangeType.MODIFY,
                     PersistentSearchChangeType.MODIFY_DN),
                 15);
  }



  /**
   * Tests the {@code encodeChangeTypes} method.
   */
  @Test()
  public void testEncodeChangeTypesList()
  {
    ArrayList<PersistentSearchChangeType> list = new
         ArrayList<PersistentSearchChangeType>(4);

    list.clear();
    list.add(PersistentSearchChangeType.ADD);
    assertEquals(PersistentSearchChangeType.encodeChangeTypes(list), 1);

    list.clear();
    list.add(PersistentSearchChangeType.DELETE);
    assertEquals(PersistentSearchChangeType.encodeChangeTypes(list), 2);

    list.clear();
    list.add(PersistentSearchChangeType.MODIFY);
    assertEquals(PersistentSearchChangeType.encodeChangeTypes(list), 4);

    list.clear();
    list.add(PersistentSearchChangeType.MODIFY_DN);
    assertEquals(PersistentSearchChangeType.encodeChangeTypes(list), 8);

    list.clear();
    list.add(PersistentSearchChangeType.ADD);
    list.add(PersistentSearchChangeType.DELETE);
    assertEquals(PersistentSearchChangeType.encodeChangeTypes(list), 3);

    list.clear();
    list.add(PersistentSearchChangeType.ADD);
    list.add(PersistentSearchChangeType.MODIFY);
    assertEquals(PersistentSearchChangeType.encodeChangeTypes(list), 5);

    list.clear();
    list.add(PersistentSearchChangeType.ADD);
    list.add(PersistentSearchChangeType.MODIFY_DN);
    assertEquals(PersistentSearchChangeType.encodeChangeTypes(list), 9);

    list.clear();
    list.add(PersistentSearchChangeType.DELETE);
    list.add(PersistentSearchChangeType.MODIFY);
    assertEquals(PersistentSearchChangeType.encodeChangeTypes(list), 6);

    list.clear();
    list.add(PersistentSearchChangeType.DELETE);
    list.add(PersistentSearchChangeType.MODIFY_DN);
    assertEquals(PersistentSearchChangeType.encodeChangeTypes(list), 10);

    list.clear();
    list.add(PersistentSearchChangeType.MODIFY);
    list.add(PersistentSearchChangeType.MODIFY_DN);
    assertEquals(PersistentSearchChangeType.encodeChangeTypes(list), 12);

    list.clear();
    list.add(PersistentSearchChangeType.ADD);
    list.add(PersistentSearchChangeType.DELETE);
    list.add(PersistentSearchChangeType.MODIFY);
    assertEquals(PersistentSearchChangeType.encodeChangeTypes(list), 7);

    list.clear();
    list.add(PersistentSearchChangeType.ADD);
    list.add(PersistentSearchChangeType.DELETE);
    list.add(PersistentSearchChangeType.MODIFY_DN);
    assertEquals(PersistentSearchChangeType.encodeChangeTypes(list), 11);

    list.clear();
    list.add(PersistentSearchChangeType.ADD);
    list.add(PersistentSearchChangeType.MODIFY);
    list.add(PersistentSearchChangeType.MODIFY_DN);
    assertEquals(PersistentSearchChangeType.encodeChangeTypes(list), 13);

    list.clear();
    list.add(PersistentSearchChangeType.DELETE);
    list.add(PersistentSearchChangeType.MODIFY);
    list.add(PersistentSearchChangeType.MODIFY_DN);
    assertEquals(PersistentSearchChangeType.encodeChangeTypes(list), 14);

    list.clear();
    list.add(PersistentSearchChangeType.ADD);
    list.add(PersistentSearchChangeType.DELETE);
    list.add(PersistentSearchChangeType.MODIFY);
    list.add(PersistentSearchChangeType.MODIFY_DN);
    assertEquals(PersistentSearchChangeType.encodeChangeTypes(list), 15);
  }



  /**
   * Tests the {@code decodeChangeTypes} method.
   */
  @Test()
  public void testDecodeChangeTypes()
  {
    ArrayList<PersistentSearchChangeType> list = new
         ArrayList<PersistentSearchChangeType>(4);

    list.clear();
    list.add(PersistentSearchChangeType.ADD);
    assertEquals(PersistentSearchChangeType.decodeChangeTypes(1), list);

    list.clear();
    list.add(PersistentSearchChangeType.DELETE);
    assertEquals(PersistentSearchChangeType.decodeChangeTypes(2), list);

    list.clear();
    list.add(PersistentSearchChangeType.MODIFY);
    assertEquals(PersistentSearchChangeType.decodeChangeTypes(4), list);

    list.clear();
    list.add(PersistentSearchChangeType.MODIFY_DN);
    assertEquals(PersistentSearchChangeType.decodeChangeTypes(8), list);

    list.clear();
    list.add(PersistentSearchChangeType.ADD);
    list.add(PersistentSearchChangeType.DELETE);
    assertEquals(PersistentSearchChangeType.decodeChangeTypes(3), list);

    list.clear();
    list.add(PersistentSearchChangeType.ADD);
    list.add(PersistentSearchChangeType.MODIFY);
    assertEquals(PersistentSearchChangeType.decodeChangeTypes(5), list);

    list.clear();
    list.add(PersistentSearchChangeType.ADD);
    list.add(PersistentSearchChangeType.MODIFY_DN);
    assertEquals(PersistentSearchChangeType.decodeChangeTypes(9), list);

    list.clear();
    list.add(PersistentSearchChangeType.DELETE);
    list.add(PersistentSearchChangeType.MODIFY);
    assertEquals(PersistentSearchChangeType.decodeChangeTypes(6), list);

    list.clear();
    list.add(PersistentSearchChangeType.DELETE);
    list.add(PersistentSearchChangeType.MODIFY_DN);
    assertEquals(PersistentSearchChangeType.decodeChangeTypes(10), list);

    list.clear();
    list.add(PersistentSearchChangeType.MODIFY);
    list.add(PersistentSearchChangeType.MODIFY_DN);
    assertEquals(PersistentSearchChangeType.decodeChangeTypes(12), list);

    list.clear();
    list.add(PersistentSearchChangeType.ADD);
    list.add(PersistentSearchChangeType.DELETE);
    list.add(PersistentSearchChangeType.MODIFY);
    assertEquals(PersistentSearchChangeType.decodeChangeTypes(7), list);

    list.clear();
    list.add(PersistentSearchChangeType.ADD);
    list.add(PersistentSearchChangeType.DELETE);
    list.add(PersistentSearchChangeType.MODIFY_DN);
    assertEquals(PersistentSearchChangeType.decodeChangeTypes(11), list);

    list.clear();
    list.add(PersistentSearchChangeType.ADD);
    list.add(PersistentSearchChangeType.MODIFY);
    list.add(PersistentSearchChangeType.MODIFY_DN);
    assertEquals(PersistentSearchChangeType.decodeChangeTypes(13), list);

    list.clear();
    list.add(PersistentSearchChangeType.DELETE);
    list.add(PersistentSearchChangeType.MODIFY);
    list.add(PersistentSearchChangeType.MODIFY_DN);
    assertEquals(PersistentSearchChangeType.decodeChangeTypes(14), list);

    list.clear();
    list.add(PersistentSearchChangeType.ADD);
    list.add(PersistentSearchChangeType.DELETE);
    list.add(PersistentSearchChangeType.MODIFY);
    list.add(PersistentSearchChangeType.MODIFY_DN);
    assertEquals(PersistentSearchChangeType.decodeChangeTypes(15), list);
  }



  /**
   * Tests the {@code toString} method.
   */
  @Test()
  public void testToString()
  {
    assertEquals(PersistentSearchChangeType.ADD.toString(), "add");
    assertEquals(PersistentSearchChangeType.DELETE.toString(), "delete");
    assertEquals(PersistentSearchChangeType.MODIFY.toString(), "modify");
    assertEquals(PersistentSearchChangeType.MODIFY_DN.toString(), "moddn");
  }



  /**
   * Tests the {@code values} method.
   */
  @Test()
  public void testValues()
  {
    assertEquals(PersistentSearchChangeType.values().length, 4);
  }



  /**
   * Tests the {@code allChangeTypes} method.
   */
  @Test()
  public void testAllChangeTypes()
  {
    assertEquals(PersistentSearchChangeType.allChangeTypes().size(), 4);
  }
}
