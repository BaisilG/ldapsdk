/*
 * Copyright 2016-2018 Ping Identity Corporation
 * All Rights Reserved.
 */
/*
 * Copyright (C) 2016-2018 Ping Identity Corporation
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
package com.unboundid.ldap.sdk.experimental;



import org.testng.annotations.Test;

import com.unboundid.ldap.sdk.Entry;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.LDAPSDKTestCase;
import com.unboundid.ldap.sdk.OperationType;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.util.StaticUtils;



/**
 * This class provides a set of test cases for the
 * {@code DraftChuLDAPLogSchema00ExtendedEntry} class.
 */
public final class DraftChuLDAPLogSchema00ExtendedEntryTestCase
       extends LDAPSDKTestCase
{
  /**
   * Tests the behavior with an entry that represents a valid extended operation
   * without a request value.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test()
  public void testDecodeValidExtendedNoRequestValue()
         throws Exception
  {
    final DraftChuLDAPLogSchema00ExtendedEntry e =
         (DraftChuLDAPLogSchema00ExtendedEntry)
         DraftChuLDAPLogSchema00Entry.decode(new Entry(
              "dn: reqStart=20160102030406.789012Z,cn=log",
              "objectClass: auditExtended",
              "reqStart: 20160102030406.789012Z",
              "reqType: extended1.2.3.4.5.6.7",
              "reqSession: 1234",
              "reqResult: 0",
              "reqAuthzID: cn=manager,dc=example,dc=com"));

    assertNotNull(e);

    assertNotNull(e.getOperationType());
    assertEquals(e.getOperationType(), OperationType.EXTENDED);

    assertNull(e.getTargetEntryDN());

    assertNotNull(e.getProcessingStartTimeString());
    assertEquals(e.getProcessingStartTimeString(), "20160102030406.789012Z");

    assertNotNull(e.getProcessingStartTimeDate());
    assertEquals(e.getProcessingStartTimeDate(),
         StaticUtils.decodeGeneralizedTime("20160102030406.789Z"));

    assertNull(e.getProcessingEndTimeString());

    assertNull(e.getProcessingEndTimeDate());

    assertNotNull(e.getSessionID());
    assertEquals(e.getSessionID(), "1234");

    assertNotNull(e.getRequestControls());
    assertTrue(e.getRequestControls().isEmpty());

    assertNotNull(e.getRequestControlArray());
    assertEquals(e.getRequestControlArray().length, 0);

    assertNotNull(e.getResultCode());
    assertEquals(e.getResultCode(), ResultCode.SUCCESS);

    assertNull(e.getDiagnosticMessage());

    assertNotNull(e.getReferralURLs());
    assertTrue(e.getReferralURLs().isEmpty());

    assertNotNull(e.getResponseControls());
    assertTrue(e.getResponseControls().isEmpty());

    assertNotNull(e.getAuthorizationIdentityDN());
    assertDNsEqual(e.getAuthorizationIdentityDN(),
         "cn=manager,dc=example,dc=com");

    assertNotNull(e.toLDAPResult());

    assertNotNull(e.getRequestOID());
    assertEquals(e.getRequestOID(), "1.2.3.4.5.6.7");

    assertNull(e.getRequestValue());

    assertNotNull(e.toExtendedRequest());
    assertEquals(e.toExtendedRequest().getOID(), "1.2.3.4.5.6.7");
    assertNull(e.toExtendedRequest().getValue());
  }



  /**
   * Tests the behavior with an entry that represents a valid extended operation
   * that has a request value.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test()
  public void testDecodeValidExtendedWithRequestValue()
         throws Exception
  {
    final DraftChuLDAPLogSchema00ExtendedEntry e =
         (DraftChuLDAPLogSchema00ExtendedEntry)
         DraftChuLDAPLogSchema00Entry.decode(new Entry(
              "dn: reqStart=20160102030406.789012Z,cn=log",
              "objectClass: auditExtended",
              "reqStart: 20160102030406.789012Z",
              "reqType: extended1.2.3.4.5.6.7",
              "reqSession: 1234",
              "reqData: this is the request data",
              "reqResult: 0",
              "reqAuthzID: cn=manager,dc=example,dc=com"));

    assertNotNull(e);

    assertNotNull(e.getOperationType());
    assertEquals(e.getOperationType(), OperationType.EXTENDED);

    assertNull(e.getTargetEntryDN());

    assertNotNull(e.getProcessingStartTimeString());
    assertEquals(e.getProcessingStartTimeString(), "20160102030406.789012Z");

    assertNotNull(e.getProcessingStartTimeDate());
    assertEquals(e.getProcessingStartTimeDate(),
         StaticUtils.decodeGeneralizedTime("20160102030406.789Z"));

    assertNull(e.getProcessingEndTimeString());

    assertNull(e.getProcessingEndTimeDate());

    assertNotNull(e.getSessionID());
    assertEquals(e.getSessionID(), "1234");

    assertNotNull(e.getRequestControls());
    assertTrue(e.getRequestControls().isEmpty());

    assertNotNull(e.getRequestControlArray());
    assertEquals(e.getRequestControlArray().length, 0);

    assertNotNull(e.getResultCode());
    assertEquals(e.getResultCode(), ResultCode.SUCCESS);

    assertNull(e.getDiagnosticMessage());

    assertNotNull(e.getReferralURLs());
    assertTrue(e.getReferralURLs().isEmpty());

    assertNotNull(e.getResponseControls());
    assertTrue(e.getResponseControls().isEmpty());

    assertNotNull(e.getAuthorizationIdentityDN());
    assertDNsEqual(e.getAuthorizationIdentityDN(),
         "cn=manager,dc=example,dc=com");

    assertNotNull(e.toLDAPResult());

    assertNotNull(e.getRequestOID());
    assertEquals(e.getRequestOID(), "1.2.3.4.5.6.7");

    assertNotNull(e.getRequestValue());
    assertEquals(e.getRequestValue().stringValue(), "this is the request data");

    assertNotNull(e.toExtendedRequest());
    assertEquals(e.toExtendedRequest().getOID(), "1.2.3.4.5.6.7");
    assertNotNull(e.toExtendedRequest().getValue());
    assertEquals(e.toExtendedRequest().getValue().stringValue(),
         "this is the request data");
  }



  /**
   * Tests the behavior with an extended operation entry that is missing the
   * request OID.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test(expectedExceptions = { LDAPException.class })
  public void testDecodeExtendedWithoutRequestOID()
         throws Exception
  {
    DraftChuLDAPLogSchema00Entry.decode(new Entry(
         "dn: reqStart=20160102030406.789012Z,cn=log",
         "objectClass: auditExtended",
         "reqStart: 20160102030406.789012Z",
         "reqType: extended",
         "reqSession: 1234"));
  }
}
