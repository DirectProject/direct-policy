package org.nhindirect.policy.x509;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.security.cert.X509Certificate;

import org.nhindirect.policy.util.TestUtils;
import org.junit.Test;
import org.nhindirect.policy.PolicyRequiredException;
import org.nhindirect.policy.x509.AuthorityKeyIdentifierKeyIdExtensionField;

public class AuthorityKeyIdentifierKeyIdExtensionField_injectReferenceValueTest
{
	@Test
	public void testInjectRefereneValue_keyIdDoesNotExist_notRequired_assertValue0() throws Exception
	{
		final X509Certificate cert = TestUtils.loadCertificate("cernerDemosCaCert.der");
		
		final AuthorityKeyIdentifierKeyIdExtensionField field = new AuthorityKeyIdentifierKeyIdExtensionField(false);
		
		field.injectReferenceValue(cert);
		
		assertEquals("", field.getPolicyValue().getPolicyValue());
	}
	
	@Test
	public void testInjectRefereneValue_keyIdDoesNotExist_required_assertException() throws Exception
	{
		final X509Certificate cert = TestUtils.loadCertificate("cernerDemosCaCert.der");
		
		final AuthorityKeyIdentifierKeyIdExtensionField field = new AuthorityKeyIdentifierKeyIdExtensionField(true);
		
		boolean exceptionOccured = false;
		
		try
		{
			field.injectReferenceValue(cert);
		}
		catch (PolicyRequiredException e)
		{
			exceptionOccured = true;
		}
		assertTrue(exceptionOccured);
	}	
	
	@Test
	public void testInjectRefereneValue_keyIdExists_assertValue() throws Exception
	{
		final X509Certificate cert = TestUtils.loadCertificate("AlAnderson@hospitalA.direct.visionshareinc.com.der");
		
		final AuthorityKeyIdentifierKeyIdExtensionField field = new AuthorityKeyIdentifierKeyIdExtensionField(false);
		
		field.injectReferenceValue(cert);
		
		assertEquals("3aa0074b77b2493efb447de5ce6cd055085de3f0", field.getPolicyValue().getPolicyValue());
		
	}	
	
	@Test
	public void testInjectRefereneValue_noInjection_getPolicyValue_assertException() throws Exception
	{
		
		final AuthorityKeyIdentifierKeyIdExtensionField field = new AuthorityKeyIdentifierKeyIdExtensionField(true);
		
		boolean exceptionOccured = false;
		
		try
		{
			field.getPolicyValue();
		}
		catch (IllegalStateException e)
		{
			exceptionOccured = true;
		}
		assertTrue(exceptionOccured);
	}
}
