/*
 * Copyright 2009-2020 Ping Identity Corporation
 * All Rights Reserved.
 */
/*
 * Copyright (C) 2009-2020 Ping Identity Corporation
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
package com.unboundid.ldap.protocol;



import java.io.ByteArrayInputStream;

import org.testng.annotations.Test;

import com.unboundid.asn1.ASN1Buffer;
import com.unboundid.asn1.ASN1Element;
import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.LDAPSDKTestCase;



/**
 * This class provides a set of test cases for the
 * {@code AbandonRequestProtocolOp} class.
 */
public class AbandonRequestProtocolOpTestCase
       extends LDAPSDKTestCase
{
  /**
   * Provides test coverage for the abandon request protocol op.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test()
  public void testAbandonRequestProtocolOp()
         throws Exception
  {
    AbandonRequestProtocolOp op = new AbandonRequestProtocolOp(1);
    ASN1Buffer buffer = new ASN1Buffer();
    op.writeTo(buffer);

    byte[] opBytes = buffer.toByteArray();
    ByteArrayInputStream inputStream = new ByteArrayInputStream(opBytes);
    ASN1StreamReader reader = new ASN1StreamReader(inputStream);

    op = new AbandonRequestProtocolOp(reader);

    op = AbandonRequestProtocolOp.decodeProtocolOp(op.encodeProtocolOp());

    assertEquals(op.getIDToAbandon(), 1);

    assertEquals(op.getProtocolOpType(), (byte) 0x50);

    assertNotNull(op.toString());
  }



  /**
   * Tests the behavior when trying to read a malformed abandon request.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test(expectedExceptions = { LDAPException.class })
  public void testReadMalformedRequest()
         throws Exception
  {
    byte[] requestBytes = { (byte) 0x50, 0x00 };
    ByteArrayInputStream inputStream = new ByteArrayInputStream(requestBytes);
    ASN1StreamReader reader = new ASN1StreamReader(inputStream);
    new AbandonRequestProtocolOp(reader);
  }



  /**
   * Tests the behavior when trying to decode a malformed abandon request.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test(expectedExceptions = { LDAPException.class })
  public void testDecodeMalformedRequest()
         throws Exception
  {
    AbandonRequestProtocolOp.decodeProtocolOp(new ASN1Element(
         LDAPMessage.PROTOCOL_OP_TYPE_ABANDON_REQUEST));
  }
}
