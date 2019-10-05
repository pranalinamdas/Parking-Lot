package com.thoughtworks;

public class DummySecurityGuard implements SecurityGuard {

    int spaceIsAvailableAgainInformed = 0;
    int spaceIsFullInformed = 0;

    @Override
    public void informSpaceIsFull() {
        spaceIsFullInformed++;
    }

    @Override
    public void informSpaceIsAvailableAgain() {
        spaceIsAvailableAgainInformed++;
    }
}
