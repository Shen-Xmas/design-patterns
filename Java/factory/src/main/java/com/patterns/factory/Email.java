package com.patterns.factory;

/**
 * @author: Shen
 */
public class Email implements Notice {

    @Override
    public String notice() {
        return "Notification channel is Email";
    }

}
