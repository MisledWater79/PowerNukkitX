package cn.nukkit.level.terra.delegate;

import cn.nukkit.api.PowerNukkitXOnly;
import cn.nukkit.api.Since;
import com.dfsek.terra.api.util.MathUtil;
import com.dfsek.terra.api.world.biome.Biome;
import com.dfsek.terra.api.world.biome.generation.BiomeProvider;

import java.util.WeakHashMap;

@PowerNukkitXOnly
@Since("1.6.0.0-PNX")
public class PNXBiomeProviderDelegate implements BiomeProvider {

    private final BiomeProvider delegate;
    private final WeakHashMap<Long, Biome> cacheMap;

    public PNXBiomeProviderDelegate(BiomeProvider delegate) {
        this.delegate = delegate;
        cacheMap = new WeakHashMap<>();
    }

    //todo: impl 3D biomes
    @Override
    public Biome getBiome(int x,int y, int z, long seed) {
        final var hash = MathUtil.squash(x, z);
        final var obj = cacheMap.get(hash);
        if (obj != null) {
            return obj;
        }
        final var tmp = delegate.getBiome(x, y, z, seed);
        cacheMap.put(hash, tmp);
        return tmp;
    }

    @Override
    public Iterable<Biome> getBiomes() {
        return null;
    }
}
