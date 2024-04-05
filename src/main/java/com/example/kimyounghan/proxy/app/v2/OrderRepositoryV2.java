package com.example.kimyounghan.proxy.app.v2;

public class OrderRepositoryV2 {
    public void save(String itemId) {
        if(itemId.equals("ex")) {
            throw new IllegalStateException("예외 발생");
        }
        sleep(1000);
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
