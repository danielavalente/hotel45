package com.hotel45.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel45.model.Room;

@Repository
public interface RoomDao extends JpaRepository<Room, Integer> {

}
