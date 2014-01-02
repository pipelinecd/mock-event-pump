package org.pipelinecd.api.event;

import org.pipelinecd.api.ProjectId;

public interface ProjectEvent extends PipelineEvent {
    ProjectId getProjectId();
}
