package org.union4dev.omni.struct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rotation {
    private float yaw, pitch;

    public void add(Rotation rotation) {
        this.yaw += rotation.getYaw();
        this.pitch += rotation.getPitch();
    }

    public Rotation createAdded(Rotation rotation) {
        return new Rotation(this.yaw + rotation.getYaw(), this.pitch + rotation.getPitch());
    }
}