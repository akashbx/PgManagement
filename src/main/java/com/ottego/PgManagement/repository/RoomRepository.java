package com.ottego.PgManagement.repository;

import com.ottego.PgManagement.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    Room findByRoomNumber(String roomNumber);
}
