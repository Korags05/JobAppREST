package org.kunal.JobAppREST.repo;

import org.kunal.JobAppREST.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

}
