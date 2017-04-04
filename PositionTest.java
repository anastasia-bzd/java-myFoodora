package myFoodoraTests;

import static org.junit.Assert.*;
import org.junit.Test;

import myFoodoraUsers.Position;

/**
 * @author anastasiabouzdine
 * Test permettant de vérifier le fonctionnement de la classe Position.
 */

public class PositionTest {
	
	Position position;

	@Test
	public void testPosition() {
		position = new Position(1,2);
	}

	@Test
	public void testGetX() {
		position = new Position(1,2);
		assertEquals(position.getX(), 1);
	}

	@Test
	public void testSetX() {
		position = new Position(1,2);
		position.setX(3);
		assertEquals(position.getX(), 3);
	}

	@Test
	public void testGetY() {
		position = new Position(1,2);
		assertEquals(position.getY(), 2);
	}

	@Test
	public void testSetY() {
		position = new Position(1,2);
		position.setY(4);
		assertEquals(position.getY(), 4);
	}

	@Test
	public void testCalculateDistance() {
		Position pos1 = new Position(1,2);
		Position pos2 = new Position(3,4);
		double distance = pos1.calculateDistance(pos2);
		assertTrue(distance == 4);
	}

	@Test
	public void testEqualsObject() {
		Position pos3 = new Position(1,1);
		Position pos4 = new Position(2,2);
		assertTrue(pos3.equals(pos4));
	}

}
