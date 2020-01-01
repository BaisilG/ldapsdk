/*
 * Copyright 2012-2020 Ping Identity Corporation
 * All Rights Reserved.
 */
/*
 * Copyright (C) 2012-2020 Ping Identity Corporation
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
package com.unboundid.ldif;



import com.unboundid.util.StaticUtils;
import com.unboundid.util.ThreadSafety;
import com.unboundid.util.ThreadSafetyLevel;



/**
 * This enum defines a set of possible behaviors that may be exhibited by the
 * LDIF reader when encountering entries with duplicate attribute values.
 */
@ThreadSafety(level=ThreadSafetyLevel.COMPLETELY_THREADSAFE)
public enum DuplicateValueBehavior
{
  /**
   * Indicates that duplicate values should be stripped, so that the resulting
   * entry will have only one copy of the value.
   */
  STRIP,



  /**
   * Indicates that duplicate values should be retained, so that the resulting
   * entry may have multiple copies of the value.  This is illegal and may cause
   * significant problems with attempts to use the resulting entry.
   */
  RETAIN,



  /**
   * Indicates that any entry containing duplicate attribute values should be
   * rejected.
   */
  REJECT;



  /**
   * Retrieves the duplicate value behavior with the specified name.
   *
   * @param  name  The name of the duplicate value behavior to retrieve.  It
   *               must not be {@code null}.
   *
   * @return  The requested duplicate value behavior, or {@code null} if no such
   *          behavior is defined.
   */
  public static DuplicateValueBehavior forName(final String name)
  {
    switch (StaticUtils.toLowerCase(name))
    {
      case "strip":
        return STRIP;
      case "retain":
        return RETAIN;
      case "reject":
        return REJECT;
      default:
        return null;
    }
  }
}
