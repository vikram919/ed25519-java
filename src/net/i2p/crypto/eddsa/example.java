package net.i2p.crypto.eddsa;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;

import javax.crypto.KeyAgreement;

public class example {

	public static void main(String[] args) throws InvalidKeySpecException {
		KeyPairGenerator keyPairGenerator = new KeyPairGenerator();
		KeyPair bobkeypair = keyPairGenerator.generateKeyPair();
		PrivateKey bobPrivatekey = bobkeypair.getPrivate();
		byte[] pkcs8 = bobPrivatekey.getEncoded();
		KeySpec keyspec = new PKCS8EncodedKeySpec(pkcs8);
		net.i2p.crypto.eddsa.KeyFactory fact = new net.i2p.crypto.eddsa.KeyFactory();
		PrivateKey priv = fact.engineGeneratePrivate(keyspec);
		System.out.println(priv);
		PublicKey bobPubkey = bobkeypair.getPublic();
		KeyPair alicekeypair = keyPairGenerator.generateKeyPair();
		
		
	}

}
