package org.pipelinecd.mock.pump.event.core

import com.yammer.dropwizard.lifecycle.Managed

import java.util.concurrent.Executors

import static java.util.concurrent.TimeUnit.MILLISECONDS

class EventPumper implements Managed {

    private EventBusManager busManager
    private pool = Executors.newScheduledThreadPool(2)

    EventPumper(EventBusManager busManager) {
        this.busManager = busManager
    }

    @Override
    void start() throws Exception {
        def topic = busManager.topic

        pool.scheduleWithFixedDelay({
            topic.publish("hello")
        } as Runnable, 1000, 500, MILLISECONDS)
    }

    @Override
    void stop() throws Exception {
        pool.shutdown()
    }
}
