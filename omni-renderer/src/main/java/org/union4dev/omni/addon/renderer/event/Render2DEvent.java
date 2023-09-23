
package org.union4dev.omni.addon.renderer.event;

import org.union4dev.omni.elements.event.Event;
import org.union4dev.omni.elements.wrapper.IScaledResolution;

public class Render2DEvent implements Event {

    private final IScaledResolution scaledResolution;
    private final float renderPartialTicks;

    public Render2DEvent(IScaledResolution scaledResolution, float renderPartialTicks) {
        this.scaledResolution = scaledResolution;
        this.renderPartialTicks = renderPartialTicks;
    }

    public IScaledResolution getScaledResolution() {
        return scaledResolution;
    }

    public float getRenderPartialTicks() {
        return renderPartialTicks;
    }
}
