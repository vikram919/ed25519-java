package net.i2p.crypto.eddsa;

import java.security.Key;

class X25519Key implements Key {
    private byte[] mKey;

    X25519Key(byte[] key) {
        mKey = key;
    }

    public String getAlgorithm() {
        return "X.25519";
    }

    public String getFormat() {
        return null;
    }

    public byte[] getEncoded() {
        return mKey;
    }
}
