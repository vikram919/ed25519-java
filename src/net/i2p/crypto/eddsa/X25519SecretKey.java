package net.i2p.crypto.eddsa;

import javax.crypto.SecretKey;

public class X25519SecretKey extends X25519Key implements SecretKey {
    public X25519SecretKey(byte[] key) {
        super(key);
    }
}
