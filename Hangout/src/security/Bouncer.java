package security;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Utilizes DSA encryption algorithm
 * @author Alex
 *
 */
public class Bouncer {

	private KeyPair myKeyPair;
	private PublicKey myPublicKey;
	private PrivateKey myPrivateKey;
	private PublicKey theirPublicKey = null;
	
	public Bouncer() {
		try {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA", "SUN");
			myKeyPair = keyGen.generateKeyPair();
			myPublicKey = myKeyPair.getPublic();
			myPrivateKey = myKeyPair.getPrivate();
		} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
			e.printStackTrace();
		}
	}
}
