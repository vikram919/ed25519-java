package net.i2p.crypto.eddsa;

import java.security.PrivateKey;

public final class X25519PrivateKey extends X25519Key implements PrivateKey {
    public X25519PrivateKey(byte[] key) {
        super(key);
    }
}
