package dkeep.test;

import static org.junit.Assert.*;

import org.junit.Test;

import dkeep.logic.Guard;

public class TestGuard {

	@Test
	public void testGuard() {
		Guard guard = new Guard(1,8);
		assertEquals(guard.getLetter(), 'G');
		assertEquals(guard.getX(), 1);
		assertEquals(guard.getY(), 8);
		
		guard.setposXY(1,7);
		assertEquals(1, guard.getI());
		guard.setposXY(1,8);		
		assertEquals(0, guard.getI());
		
		guard.setposXY(2,7);
		assertEquals(2, guard.getI());
		guard.setposXY(2,8);
		assertEquals(23, guard.getI());
		
		guard.setposXY(3,7);
		assertEquals(3, guard.getI());
		guard.setposXY(3,8);
		assertEquals(22, guard.getI());
		
		guard.setposXY(4,7);
		assertEquals(4, guard.getI());
		guard.setposXY(4,8);
		assertEquals(21, guard.getI());
		
		guard.setposXY(5,1);
		assertEquals(11, guard.getI());
		guard.setposXY(5,2);
		assertEquals(10, guard.getI());
		guard.setposXY(5,3);
		assertEquals(9, guard.getI());
		guard.setposXY(5,4);
		assertEquals(8, guard.getI());
		guard.setposXY(5,5);
		assertEquals(7, guard.getI());
		guard.setposXY(5,6);
		assertEquals(6, guard.getI());
		guard.setposXY(5,7);
		assertEquals(5, guard.getI());
		guard.setposXY(5,8);
		assertEquals(20, guard.getI());
		
		guard.setposXY(6,1);
		assertEquals(12, guard.getI());
		guard.setposXY(6,2);
		assertEquals(13, guard.getI());
		guard.setposXY(6,3);
		assertEquals(14, guard.getI());
		guard.setposXY(6,4);
		assertEquals(15, guard.getI());
		guard.setposXY(6,5);
		assertEquals(16, guard.getI());
		guard.setposXY(6,6);
		assertEquals(17, guard.getI());
		guard.setposXY(6,7);
		assertEquals(18, guard.getI());
		guard.setposXY(6,8);
		assertEquals(19, guard.getI());
	}

}
