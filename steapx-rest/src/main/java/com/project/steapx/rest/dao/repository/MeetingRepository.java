package com.project.steapx.rest.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.steapx.rest.dao.entity.meeting.Meeting;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Integer> {

}
