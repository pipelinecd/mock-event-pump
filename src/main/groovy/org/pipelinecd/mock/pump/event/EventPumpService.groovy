package org.pipelinecd.mock.pump.event

import com.yammer.dropwizard.Service
import com.yammer.dropwizard.config.Bootstrap
import com.yammer.dropwizard.config.Environment
import org.pipelinecd.mock.pump.event.core.EventBusManager
import org.pipelinecd.mock.pump.event.core.EventPumper
import org.pipelinecd.mock.pump.event.core.EventReader

class EventPumpService extends Service<EventPumpConfiguration> {

    @Override
    void initialize(Bootstrap<EventPumpConfiguration> bootstrap) {
    }

    @Override
    void run(EventPumpConfiguration config, Environment env) throws Exception {
        def busManager = new EventBusManager()
        env.manage(busManager)
        env.manage(new EventPumper(busManager))
        env.manage(new EventReader(busManager))
    }
}
