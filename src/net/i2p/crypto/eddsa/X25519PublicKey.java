package net.i2p.crypto.eddsa;

import java.security.PublicKey;

public final class X25519PublicKey extends X25519Key implements PublicKey {
    public X25519PublicKey(byte[] key) {
        super(key);
    }
}
