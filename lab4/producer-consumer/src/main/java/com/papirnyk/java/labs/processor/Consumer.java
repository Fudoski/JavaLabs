package com.papirnyk.java.labs.processor;

public class Consumer implements IConsumer {
    @Override
    public void consume(String value) {
        System.out.println( String.format( "Consumed -> %s", value ) );
    }
}
