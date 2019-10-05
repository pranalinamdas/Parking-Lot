package com.thoughtworks;

public class SecurityGuard implements Subscriber {

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
