package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.example.project.Repair.RepairSchedule;

public class TestRepair {

    @Test
    public void testAddRepairPARTA() {
        //create repair schedule with 3 mechanics
        RepairSchedule schedule = new RepairSchedule(3); 

        assertTrue(schedule.addRepair(0, 1),"A");
        assertEquals(1, schedule.getSchedule().size());

        //adding a repair with duplicate mechanic should return False
        assertFalse(schedule.addRepair(0, 2),"B");

        // adding a repair with the same bay --> return flase
        assertFalse(schedule.addRepair(1, 1),"C");

        // adding a repair with a new mechanic (1) and new bay (2))
        assertTrue(schedule.addRepair(1, 2),"D");
        assertEquals(2, schedule.getSchedule().size());

  
    }

    @Test
    public void testAvailableMechanicsPARTB() {
        RepairSchedule schedule = new RepairSchedule(3); 

        // all mechanics free
        ArrayList<Integer> availableMechanics = schedule.availableMechanics();
        assertEquals(3, availableMechanics.size());
        assertTrue(availableMechanics.contains(0),"A");
        assertTrue(availableMechanics.contains(1),"B");
        assertTrue(availableMechanics.contains(2),"C");

        // Assign a repair to mechanic 0
        schedule.addRepair(0, 1);

        availableMechanics = schedule.availableMechanics();
        assertEquals(2, availableMechanics.size());
        assertTrue(availableMechanics.contains(1),"D");//mechanic 1 still  available
        assertTrue(availableMechanics.contains(2),"E");//mechanic 2 still available

        // Assign a repair to mechanic 1
        schedule.addRepair(1, 2);

   
        availableMechanics = schedule.availableMechanics();
        assertEquals(1, availableMechanics.size()); // mechanic 2 should be the only mechanic in the list
        assertTrue(availableMechanics.contains(2),"F"); //mechanic 2 available

        schedule.addRepair(2, 3);

        // no more mechanics available
        availableMechanics = schedule.availableMechanics();
        assertEquals(0, availableMechanics.size());
    }
}
