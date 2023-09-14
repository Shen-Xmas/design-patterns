package com.patterns.factory;

/**
 * @author: Shen
 *
 * the product factory
 * 按照实际生产类的工厂
 */
public class NoticeFactory {

    public Notice getWay(String way) {

        if (way == null) {
            return null;
        }

        if (way.equalsIgnoreCase("facebook")) {
            return new FaceBook();
        } else if (way.equalsIgnoreCase("twitter")) {
            return new Twitter();
        } else if (way.equalsIgnoreCase("email")) {
            return new Email();
        } else {
            return null;
        }

    }

}
