package com.ottego.PgManagement.repository;

import com.ottego.PgManagement.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    long countRoomsByPgId(Integer pgId);
    List<Room> findAllByPg_Id(Integer pgId);
}
