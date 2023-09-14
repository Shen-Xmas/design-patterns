package com.patterns.factory;

import org.junit.Test;

import static org.junit.Assert.assertSame;

/**
 * @author: Shen
 */
public class NoticeFactoryTest {

    @Test
    public void testNoticeFactory() {
        NoticeFactory factory = new NoticeFactory();

        Notice facebook = factory.getWay("facebook");
        assertSame(facebook.notice(), "Notification channel is FaceBook");
        System.out.println(facebook.notice());

        Notice twitter = factory.getWay("twitter");
        assertSame(twitter.notice(), "Notification channel is Twitter");
        System.out.println(twitter.notice());

        Notice email = factory.getWay("email");
        assertSame(email.notice(), "Notification channel is Email");
        System.out.println(email.notice());
    }

}
