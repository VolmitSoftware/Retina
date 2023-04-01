package com.volmit.retina.content.tags;

import art.arcane.source.NoisePlane;
import art.arcane.source.util.NoisePreset;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.Seeder;
import com.volmit.retina.generator.tag.RetinaTag;

public class TagHumidity implements RetinaTag {
    private final NoisePlane noise;

    public TagHumidity(RetinaWorld world) {
        this.noise = NoisePreset.PERLIN.create(world.getSeeder().next())
            .scale(0.01)
            .fit(0, 1);
    }

    @Override
    public String getKey() {
        return "humidity";
    }

    @Override
    public double get(int x, int z) {
        return noise.noise(x, z);
    }

    @Override
    public double maxValue() {
        return 1;
    }

    @Override
    public double minValue() {
        return 0;
    }
}