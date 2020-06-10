package com.papirnyk.java.labs.processor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ProcessorTest {

    private static final String PRODUCER_VALUE = "Produced value";

    private Processor processor;

    private IConsumer consumer;
    private IProducer producer;

    @Before
    public void setUp(){
        processor = new Processor();
        consumer = mock( Consumer.class );
        producer = mock( Producer.class );
        processor.setProducer( producer );
        processor.setConsumer( consumer );
    }

    @Test
    public void shouldConsumeValueWhenProducerProduceNotNullValue() {
        ArgumentCaptor<String> producedValueCaptor = ArgumentCaptor.forClass( String.class );
        when(producer.produce()).thenReturn( PRODUCER_VALUE );
        doCallRealMethod().when( consumer ).consume( PRODUCER_VALUE);
        processor.process();
        verify( producer ).produce();
        verify( consumer ).consume( producedValueCaptor.capture() );
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowsIllegalStateExceptionWhenProducerProduceNull() {
        when(producer.produce()).thenReturn( null );
        processor.process();
    }
}