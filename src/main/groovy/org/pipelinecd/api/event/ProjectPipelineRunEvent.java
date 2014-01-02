package org.pipelinecd.api.event;

import org.pipelinecd.api.ProjectPipelineRunId;

public interface ProjectPipelineRunEvent extends PipelineEvent {
    ProjectPipelineRunId getRunId();
}
