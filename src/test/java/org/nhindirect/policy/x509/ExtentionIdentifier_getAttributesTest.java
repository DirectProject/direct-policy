package org.nhindirect.policy.x509;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class ExtentionIdentifier_getAttributesTest 
{
	@Test
	public void testGetAttributes()
	{
		assertEquals("2.5.29.15",  ExtensionIdentifier.KEY_USAGE.getId());
		assertEquals("Subject Alternative Name",  ExtensionIdentifier.SUBJECT_ALT_NAME.getDisplay());
		assertEquals("SubjectAltName",  ExtensionIdentifier.SUBJECT_ALT_NAME.getRfcName());
	}
}
