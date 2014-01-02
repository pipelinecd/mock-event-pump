package org.pipelinecd.api.event;

import org.pipelinecd.api.ProjectPipelineId;

public interface ProjectPipelineEvent extends PipelineEvent {
    ProjectPipelineId getPipelineId();
}
