package cn.nukkit.entity.item;

import cn.nukkit.entity.Entity;
import cn.nukkit.level.format.IChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.nbt.tag.DoubleTag;
import cn.nukkit.nbt.tag.FloatTag;
import cn.nukkit.nbt.tag.ListTag;
import cn.nukkit.potion.Effect;
import cn.nukkit.potion.Potion;
import org.jetbrains.annotations.NotNull;


public class EntityLingeringPotion extends EntitySplashPotion {
    @Override
    @NotNull public String getIdentifier() {
        return LINGERING_POTION;
    }

    public EntityLingeringPotion(IChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    public EntityLingeringPotion(IChunk chunk, CompoundTag nbt, Entity shootingEntity) {
        super(chunk, nbt, shootingEntity);
    }

    @Override
    protected void initEntity() {
        super.initEntity();
        setDataFlag(DATA_FLAGS, DATA_FLAG_LINGER, true);
    }

    @Override
    protected void splash(Entity collidedWith) {
        super.splash(collidedWith);
        saveNBT();
        ListTag<?> pos = (ListTag<?>) namedTag.getList("Pos", CompoundTag.class).copy();
        EntityAreaEffectCloud entity = (EntityAreaEffectCloud) Entity.createEntity(Entity.AREA_EFFECT_CLOUD, getChunk(),
                new CompoundTag().putList("Pos",pos)
                        .putList("Rotation",new ListTag<>()
                                .add(new FloatTag(0))
                                .add(new FloatTag(0))
                        )
                        .putList("Motion",new ListTag<>()
                                .add(new DoubleTag(0))
                                .add(new DoubleTag(0))
                                .add(new DoubleTag(0))
                        )
                        .putShort("PotionId", potionId)
        );

        Effect effect = Potion.getEffect(potionId, true);

        if (effect != null && entity != null) {
            entity.cloudEffects.add(effect/*.setDuration(1)*/.setVisible(false).setAmbient(false));
            entity.spawnToAll();
        }
    }

    @Override
    public String getOriginalName() {
        return "Lingering Potion";
    }
}
