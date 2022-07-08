package cn.nukkit.entity.ai.memory;

import cn.nukkit.api.PowerNukkitXOnly;
import cn.nukkit.api.Since;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@PowerNukkitXOnly
@Since("1.6.0.0-PNX")
@Getter
public class MemoryStorage implements IMemoryStorage{

    protected Map<Class<?>,IMemory<?>> memoryMap = new HashMap<>();

    @Override
    public void put(IMemory<?> memory) {
        this.memoryMap.put(memory.getClass(),memory);
    }

    @Override
    public void remove(Class<?> memoryClazz) {
        memoryMap.remove(memoryClazz);
    }

    @Override
    public IMemory<?> get(Class<?> memoryClazz) {
        return memoryMap.get(memoryClazz);
    }
}