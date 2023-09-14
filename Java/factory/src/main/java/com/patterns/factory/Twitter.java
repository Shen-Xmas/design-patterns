package com.patterns.factory;

/**
 * @author: Shen
 */
public class Twitter implements Notice {

    @Override
    public String notice() {
        return "Notification channel is Twitter";
    }

}
