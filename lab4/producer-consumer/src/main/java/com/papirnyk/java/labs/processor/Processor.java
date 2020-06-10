package com.papirnyk.java.labs.processor;

public class Processor {
    private IProducer producer;
    private IConsumer consumer;

    public void process() {
        String value = producer.produce();

        if (value == null) {
            throw new IllegalStateException( "Produced values must not be null" );
        }

        consumer.consume( value );
    }

    public void setProducer(IProducer producer) {
        this.producer = producer;
    }

    public void setConsumer(IConsumer consumer) {
        this.consumer = consumer;
    }
}
