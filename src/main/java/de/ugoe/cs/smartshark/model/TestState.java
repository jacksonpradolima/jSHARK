/*
 * Copyright (C) 2017 University of Goettingen, Germany
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.ugoe.cs.smartshark.model;

import com.google.common.base.MoreObjects;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

/**
 * @author Fabian Trautsch
 */
@Entity(value = "test_state", noClassnameStored = true)
public class TestState {
    @Id
    @Property("_id")
    private ObjectId id;

    private String name;

    @Property("file_id")
    private ObjectId fileId;

    @Property("commit_id")
    private ObjectId commitId;

    @Property("execution_time")
    private Float executionTime;


    private Map<String, String> metrics = new HashMap<>();

    @Embedded("mutation_res")
    private Set<MutationResult> mutationResults = new HashSet<>();

    public TestState() {}

    public TestState(String id, Map<String, String> metrics, ObjectId fileId, ObjectId commitId, Set<MutationResult> mutationResults) {
        name = id;
        this.fileId = fileId;
        this.commitId = commitId;
        this.metrics = metrics;
        this.mutationResults = mutationResults;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObjectId getFileId() {
        return fileId;
    }

    public void setFileId(ObjectId fileId) {
        this.fileId = fileId;
    }

    public ObjectId getCommitId() {
        return commitId;
    }

    public void setCommitId(ObjectId commitId) {
        this.commitId = commitId;
    }

    public Float getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Float executionTime) {
        this.executionTime = executionTime;
    }

    public Map<String, String> getMetrics() {
        return metrics;
    }

    public void setMetrics(Map<String, String> metrics) {
        this.metrics = metrics;
    }

    public Set<MutationResult> getMutationResults() {
        return mutationResults;
    }

    public void setMutations(Set<MutationResult> mutationResults) {
        this.mutationResults = mutationResults;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof TestState)) {
            return false;
        }

        if(obj == this) {
            return true;
        }

        TestState otherNode = (TestState) obj;
        return new EqualsBuilder()
                .append(id, otherNode.id)
                .append(name, otherNode.name)
                .append(fileId, otherNode.fileId)
                .append(commitId, otherNode.commitId)
                .append(metrics, otherNode.metrics)
                .append(mutationResults, otherNode.mutationResults)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31)
                .append(id)
                .append(name)
                .append(fileId)
                .append(commitId)
                .append(metrics)
                .append(mutationResults)
                .toHashCode();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("fileId", fileId)
                .add("commitId", commitId)
                .add("metrics", metrics)
                .add("mutationResults", mutationResults)
                .toString();
    }
}
