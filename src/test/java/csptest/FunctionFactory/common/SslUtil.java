package csptest.FunctionFactory.common;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
//import java.util.Base64;

/**
 * 
 * @author Ryan
 * @version Aug 24, 2017 2:43:58 PM
 */
public class SslUtil {

	public static SSLSocketFactory getSSLSocktet(String caPath, String crtPath, String keyPath, String password)
			throws Exception {
		// CAcertificate is used to authenticate server
		CertificateFactory cAf = CertificateFactory.getInstance("X.509");
		FileInputStream caIn = new FileInputStream(caPath);
		X509Certificate ca = (X509Certificate) cAf.generateCertificate(caIn);
		KeyStore caKs = KeyStore.getInstance(KeyStore.getDefaultType());
		caKs.load(null, null);
		caKs.setCertificateEntry("ca-certificate", ca);
		TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
		tmf.init(caKs);
		caIn.close();

		/*CertificateFactory cf = CertificateFactory.getInstance("X.509");
		FileInputStream crtIn = new FileInputStream(crtPath);
		X509Certificate caCert = (X509Certificate) cf.generateCertificate(crtIn);
		crtIn.close();*/

		// clientkey and certificatesare sent to server so it can authenticate us
		/*KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
		// ks.load(caIn,password.toCharArray());
		ks.load(null, null);
		ks.setCertificateEntry("certificate", caCert);
		ks.setKeyEntry("private-key", getPrivateKey(keyPath), password.toCharArray(),
				new java.security.cert.Certificate[] { caCert });
		KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
		kmf.init(ks, password.toCharArray());*/
		// keyIn.close();

		// finally,create SSL socket factory
		SSLContext context = SSLContext.getInstance("TLSv1");

		context.init(null, tmf.getTrustManagers(), new SecureRandom());

		return context.getSocketFactory();
	}
	

	private static PrivateKey getPrivateKey(String path) throws Exception {
		
//		byte[] buffer = Base64.getDecoder().decode(getPem(path));

//		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//		return keyFactory.generatePrivate(keySpec);
		return null;
	}

	private static String getPem(String path) throws Exception {
		FileInputStream fin = new FileInputStream(path);
		BufferedReader br = new BufferedReader(new InputStreamReader(fin));
		String readLine = null;
		StringBuilder sb = new StringBuilder();
		while ((readLine = br.readLine()) != null) {
			if (readLine.charAt(0) == '-') {
				continue;
			} else {
				sb.append(readLine);
				sb.append('\r');
			}
		}
		fin.close();
		return sb.toString();
	}

}
