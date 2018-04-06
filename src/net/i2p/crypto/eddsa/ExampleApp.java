package net.i2p.crypto.eddsa;

import static org.junit.Assert.assertArrayEquals;

import java.security.KeyPair;

import javax.crypto.SecretKey;

public class ExampleApp {
	public static void main(String[] args) {
		try {
			X25519KeyPairGenerator keyPairGenerator = new X25519KeyPairGenerator();
			// Alice Key pair
			KeyPair aliceKeyPair = keyPairGenerator.generateKeyPair();
			// Bob now generates his key pair:
			KeyPair bobKeyPair = keyPairGenerator.generateKeyPair();
			
			System.out.println(toHexString(bobKeyPair.getPrivate().getEncoded()));

			// // Now Bob obtains the bobSharedSecret in this manner:
			// X25519KeyAgreement bobKeyAgreement = new
			// X25519KeyAgreement(bobKeyPair.getPrivate());
			// bobKeyAgreement.doFinal(aliceKeyPair.getPublic());
			// SecretKey bobSharedSecret = bobKeyAgreement.generateSecret("X25519");
			//
			// // And, by using this shared secret, Bob can now encrypt the message.
			//
			// // At the Ana's side, the same shared secret is generated from the
			// // public key sent by Bob.
			// X25519KeyAgreement anaKeyAgreement = new
			// X25519KeyAgreement(aliceKeyPair.getPrivate());
			// anaKeyAgreement.doFinal(bobKeyPair.getPublic());
			// SecretKey aliceSharedSecret = anaKeyAgreement.generateSecret("X25519");
			//
			//// // Confirms that both shared secrets are equal.
			// assertArrayEquals(aliceSharedSecret.getEncoded(),
			// bobSharedSecret.getEncoded());
			// System.out.println(aliceSharedSecret);
			// System.out.println(bobSharedSecret);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String toHexString(byte[] byteArray) {

		if (byteArray != null && byteArray.length != 0) {
			char[] bytesHexadecimal = new char[byteArray.length * 3];
			for (int src = 0, dest = 0; src < byteArray.length; src++) {
				int value = byteArray[src] & 0xFF;
				bytesHexadecimal[dest++] = BIN_TO_HEX_ARRAY[value >>> 4];
				bytesHexadecimal[dest++] = BIN_TO_HEX_ARRAY[value & 0x0F];
				bytesHexadecimal[dest++] = ' ';
			}
			return new String(bytesHexadecimal, 0, bytesHexadecimal.length - 1);
		} else {
			return "--";
		}
	}
	private final static char[] BIN_TO_HEX_ARRAY = "0123456789ABCDEF".toCharArray();
}
