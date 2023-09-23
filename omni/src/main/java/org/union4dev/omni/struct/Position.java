package org.union4dev.omni.struct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position {
    private double x, y, z;

    public void add(double x, double y, double z) {
        this.x += x;
        this.y += y;
        this.z += z;
    }

    public void add(Position position) {
        this.x += position.getX();
        this.y += position.getY();
        this.z += position.getZ();
    }

    public Position createAdded(double x, double y, double z) {
        return new Position(this.x + x, this.y + y, this.z + z);
    }

    public Position createAdded(Position position) {
        return new Position(this.x + position.getX(), this.y + position.getY(), this.z + position.getZ());
    }

    public double distance(double toX, double toY, double toZ) {
        double xDiff = this.x - toX;
        double yDiff = this.y - toY;
        double zDiff = this.z - toZ;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff + zDiff * zDiff);
    }

    public double distance(Position toPosition) {
        double xDiff = this.x - toPosition.getX();
        double yDiff = this.y - toPosition.getY();
        double zDiff = this.z - toPosition.getZ();
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff + zDiff * zDiff);
    }
}
