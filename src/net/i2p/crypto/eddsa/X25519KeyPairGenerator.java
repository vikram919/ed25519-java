package net.i2p.crypto.eddsa;

import java.security.KeyPair;
import java.security.SecureRandom;

public class X25519KeyPairGenerator {
	private static final int KEY_SIZE = 32;
    private SecureRandom mSecureRandom;

    public X25519KeyPairGenerator() {
        this(new SecureRandom());
    }

    public X25519KeyPairGenerator(SecureRandom secureRandom) {
        mSecureRandom = secureRandom;
    }

    public KeyPair generateKeyPair() {
        byte[] privateKey = new byte[KEY_SIZE];
        mSecureRandom.nextBytes(privateKey);

        byte[] publicKey = new byte[KEY_SIZE];
        byte[] s = new byte[KEY_SIZE];
        X25519KeyAgreement.keygen(publicKey, s, privateKey);

        return new KeyPair(new X25519PublicKey(publicKey),
                new X25519PrivateKey(privateKey));
    }
}
