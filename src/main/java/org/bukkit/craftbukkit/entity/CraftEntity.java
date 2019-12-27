package org.bukkit.craftbukkit.entity;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AmbientEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.monster.CaveSpiderEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.fish.CodEntity;
import net.minecraft.entity.boss.dragon.EnderDragonPartEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.passive.DolphinEntity;
import net.minecraft.entity.projectile.DragonFireballEntity;
import net.minecraft.entity.monster.DrownedEntity;
import net.minecraft.entity.projectile.EggEntity;
import net.minecraft.entity.item.EnderCrystalEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.item.EnderPearlEntity;
import net.minecraft.entity.item.EyeOfEnderEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.EndermiteEntity;
import net.minecraft.entity.monster.EvokerEntity;
import net.minecraft.entity.projectile.EvokerFangsEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.entity.projectile.DamagingProjectileEntity;
import net.minecraft.entity.item.FireworkRocketEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.entity.FlyingEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.monster.GiantEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.monster.GuardianEntity;
import net.minecraft.entity.monster.ElderGuardianEntity;
import net.minecraft.entity.item.HangingEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.passive.horse.AbstractChestedHorseEntity;
import net.minecraft.entity.passive.horse.DonkeyEntity;
import net.minecraft.entity.passive.horse.MuleEntity;
import net.minecraft.entity.passive.horse.SkeletonHorseEntity;
import net.minecraft.entity.passive.horse.ZombieHorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.AbstractIllagerEntity;
import net.minecraft.entity.monster.IllusionerEntity;
import net.minecraft.entity.monster.SpellcastingIllagerEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.item.ItemFrameEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.item.LeashKnotEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.horse.LlamaEntity;
import net.minecraft.entity.projectile.LlamaSpitEntity;
import net.minecraft.entity.passive.horse.TraderLlamaEntity;
import net.minecraft.entity.monster.MagmaCubeEntity;
import net.minecraft.entity.item.minecart.AbstractMinecartEntity;
import net.minecraft.entity.item.minecart.ChestMinecartEntity;
import net.minecraft.entity.item.minecart.MinecartCommandBlockEntity;
import net.minecraft.entity.item.minecart.FurnaceMinecartEntity;
import net.minecraft.entity.item.minecart.HopperMinecartEntity;
import net.minecraft.entity.item.minecart.SpawnerMinecartEntity;
import net.minecraft.entity.item.minecart.MinecartEntity;
import net.minecraft.entity.item.minecart.TNTMinecartEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.MooshroomEntity;
import net.minecraft.entity.passive.OcelotEntity;
import net.minecraft.entity.item.PaintingEntity;
import net.minecraft.entity.passive.PandaEntity;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.monster.PhantomEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.monster.ZombiePigmanEntity;
import net.minecraft.entity.monster.PillagerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.entity.passive.fish.PufferfishEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.monster.RavagerEntity;
import net.minecraft.entity.passive.fish.SalmonEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.monster.ShulkerEntity;
import net.minecraft.entity.projectile.ShulkerBulletEntity;
import net.minecraft.entity.monster.SilverfishEntity;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.StrayEntity;
import net.minecraft.entity.monster.WitherSkeletonEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.item.ExperienceBottleEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.monster.VexEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.merchant.villager.WanderingTraderEntity;
import net.minecraft.entity.monster.VindicatorEntity;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.monster.WitchEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.HuskEntity;
import net.minecraft.entity.monster.ZombieVillagerEntity;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.nbt.CompoundNBT;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.block.CraftBlock;
import org.bukkit.craftbukkit.persistence.CraftPersistentDataContainer;
import org.bukkit.craftbukkit.persistence.CraftPersistentDataTypeRegistry;
import org.bukkit.craftbukkit.util.CraftChatMessage;
import org.bukkit.craftbukkit.util.CraftVector;
import org.bukkit.entity.Pose;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.PermissibleBase;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.permissions.ServerOperator;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.NumberConversions;
import org.bukkit.util.Vector;

public abstract class CraftEntity implements org.bukkit.entity.Entity {
    private static PermissibleBase perm;
    private static final CraftPersistentDataTypeRegistry DATA_TYPE_REGISTRY = new CraftPersistentDataTypeRegistry();

    protected final CraftServer server;
    protected Entity entity;
    private EntityDamageEvent lastDamageEvent;
    private final CraftPersistentDataContainer persistentDataContainer = new CraftPersistentDataContainer(DATA_TYPE_REGISTRY);

    public CraftEntity(final CraftServer server, final Entity entity) {
        this.server = server;
        this.entity = entity;
    }

    public static CraftEntity getEntity(CraftServer server, Entity entity) {
        /**
         * Order is *EXTREMELY* important -- keep it right! =D
         */
        if (entity instanceof EntityLiving) {
            // Players
            if (entity instanceof EntityHuman) {
                if (entity instanceof ServerPlayerEntity) { return new CraftPlayer(server, (ServerPlayerEntity) entity); }
                else { return new CraftHumanEntity(server, (EntityHuman) entity); }
            }
            // Water Animals
            else if (entity instanceof EntityWaterAnimal) {
                if (entity instanceof EntitySquid) { return new CraftSquid(server, (EntitySquid) entity); }
                else if (entity instanceof AbstractFishEntity) {
                    if (entity instanceof EntityCod) { return new CraftCod(server, (EntityCod) entity); }
                    else if (entity instanceof EntityPufferFish) { return new CraftPufferFish(server, (EntityPufferFish) entity); }
                    else if (entity instanceof EntitySalmon) { return new CraftSalmon(server, (EntitySalmon) entity); }
                    else if (entity instanceof EntityTropicalFish) { return new CraftTropicalFish(server, (EntityTropicalFish) entity); }
                    else { return new CraftFish(server, (AbstractFishEntity) entity); }
                }
                else if (entity instanceof EntityDolphin) { return new CraftDolphin(server, (EntityDolphin) entity); }
                else { return new CraftWaterMob(server, (EntityWaterAnimal) entity); }
            }
            else if (entity instanceof EntityCreature) {
                // Animals
                if (entity instanceof EntityAnimal) {
                    if (entity instanceof EntityChicken) { return new CraftChicken(server, (EntityChicken) entity); }
                    else if (entity instanceof EntityCow) {
                        if (entity instanceof EntityMushroomCow) { return new CraftMushroomCow(server, (EntityMushroomCow) entity); }
                        else { return new CraftCow(server, (EntityCow) entity); }
                    }
                    else if (entity instanceof EntityPig) { return new CraftPig(server, (EntityPig) entity); }
                    else if (entity instanceof EntityTameableAnimal) {
                        if (entity instanceof WolfEntity) { return new CraftWolf(server, (WolfEntity) entity); }
                        else if (entity instanceof EntityCat) { return new CraftCat(server, (EntityCat) entity); }
                        else if (entity instanceof EntityParrot) { return new CraftParrot(server, (EntityParrot) entity); }
                    }
                    else if (entity instanceof EntitySheep) { return new CraftSheep(server, (EntitySheep) entity); }
                    else if (entity instanceof EntityHorseAbstract) {
                        if (entity instanceof EntityHorseChestedAbstract){
                            if (entity instanceof EntityHorseDonkey) { return new CraftDonkey(server, (EntityHorseDonkey) entity); }
                            else if (entity instanceof MuleEntity) { return new CraftMule(server, (MuleEntity) entity); }
                            else if (entity instanceof EntityLlamaTrader) { return new CraftTraderLlama(server, (EntityLlamaTrader) entity); }
                            else if (entity instanceof EntityLlama) { return new CraftLlama(server, (EntityLlama) entity); }
                        } else if (entity instanceof EntityHorse) { return new CraftHorse(server, (EntityHorse) entity); }
                        else if (entity instanceof SkeletonHorseEntity) { return new CraftSkeletonHorse(server, (SkeletonHorseEntity) entity); }
                        else if (entity instanceof EntityHorseZombie) { return new CraftZombieHorse(server, (EntityHorseZombie) entity); }
                    }
                    else if (entity instanceof EntityRabbit) { return new CraftRabbit(server, (EntityRabbit) entity); }
                    else if (entity instanceof EntityPolarBear) { return new CraftPolarBear(server, (EntityPolarBear) entity); }
                    else if (entity instanceof EntityTurtle) { return new CraftTurtle(server, (EntityTurtle) entity); }
                    else if (entity instanceof EntityOcelot) { return new CraftOcelot(server, (EntityOcelot) entity); }
                    else if (entity instanceof EntityPanda) { return new CraftPanda(server, (EntityPanda) entity); }
                    else if (entity instanceof EntityFox) { return new CraftFox(server, (EntityFox) entity); }
                    else if (entity instanceof EntityBee) { return new CraftBee(server, (EntityBee) entity); }
                    else  { return new CraftAnimals(server, (EntityAnimal) entity); }
                }
                // Monsters
                else if (entity instanceof EntityMonster) {
                    if (entity instanceof EntityZombie) {
                        if (entity instanceof EntityPigZombie) { return new CraftPigZombie(server, (EntityPigZombie) entity); }
                        else if (entity instanceof EntityZombieHusk) { return new CraftHusk(server, (EntityZombieHusk) entity); }
                        else if (entity instanceof EntityZombieVillager) { return new CraftVillagerZombie(server, (EntityZombieVillager) entity); }
                        else if (entity instanceof EntityDrowned) { return new CraftDrowned(server, (EntityDrowned) entity); }
                        else { return new CraftZombie(server, (EntityZombie) entity); }
                    }
                    else if (entity instanceof EntityCreeper) { return new CraftCreeper(server, (EntityCreeper) entity); }
                    else if (entity instanceof EntityEnderman) { return new CraftEnderman(server, (EntityEnderman) entity); }
                    else if (entity instanceof EntitySilverfish) { return new CraftSilverfish(server, (EntitySilverfish) entity); }
                    else if (entity instanceof EntityGiantZombie) { return new CraftGiant(server, (EntityGiantZombie) entity); }
                    else if (entity instanceof SkeletonEntityAbstract) {
                        if (entity instanceof SkeletonEntityStray) { return new CraftStray(server, (SkeletonEntityStray) entity); }
                        else if (entity instanceof SkeletonEntityWither) { return new CraftWitherSkeleton(server, (SkeletonEntityWither) entity); }
                        else { return new CraftSkeleton(server, (SkeletonEntityAbstract) entity); }
                    }
                    else if (entity instanceof EntityBlaze) { return new CraftBlaze(server, (EntityBlaze) entity); }
                    else if (entity instanceof EntityWitch) { return new CraftWitch(server, (EntityWitch) entity); }
                    else if (entity instanceof EntityWither) { return new CraftWither(server, (EntityWither) entity); }
                    else if (entity instanceof EntitySpider) {
                        if (entity instanceof EntityCaveSpider) { return new CraftCaveSpider(server, (EntityCaveSpider) entity); }
                        else { return new CraftSpider(server, (EntitySpider) entity); }
                    }
                    else if (entity instanceof EndermiteEntity) { return new CraftEndermite(server, (EndermiteEntity) entity); }
                    else if (entity instanceof EntityGuardian) {
                        if (entity instanceof EntityGuardianElder) { return new CraftElderGuardian(server, (EntityGuardianElder) entity); }
                        else { return new CraftGuardian(server, (EntityGuardian) entity); }
                    }
                    else if (entity instanceof EntityVex) { return new CraftVex(server, (EntityVex) entity); }
                    else if (entity instanceof AbstractIllagerEntity) {
                        if (entity instanceof EntityIllagerWizard) {
                            if (entity instanceof EntityEvoker) { return new CraftEvoker(server, (EntityEvoker) entity); }
                            else if (entity instanceof EntityIllagerIllusioner) { return new CraftIllusioner(server, (EntityIllagerIllusioner) entity); }
                            else {  return new CraftSpellcaster(server, (EntityIllagerWizard) entity); }
                        }
                        else if (entity instanceof EntityVindicator) { return new CraftVindicator(server, (EntityVindicator) entity); }
                        else if (entity instanceof EntityPillager) { return new CraftPillager(server, (EntityPillager) entity); }
                        else { return new CraftIllager(server, (AbstractIllagerEntity) entity); }
                    }
                    else if (entity instanceof EntityRavager) { return new CraftRavager(server, (EntityRavager) entity); }

                    else  { return new CraftMonster(server, (EntityMonster) entity); }
                }
                else if (entity instanceof EntityGolem) {
                    if (entity instanceof EntitySnowman) { return new CraftSnowman(server, (EntitySnowman) entity); }
                    else if (entity instanceof EntityIronGolem) { return new CraftIronGolem(server, (EntityIronGolem) entity); }
                    else if (entity instanceof EntityShulker) { return new CraftShulker(server, (EntityShulker) entity); }
                }
                else if (entity instanceof EntityVillagerAbstract) {
                    if (entity instanceof EntityVillager) { return new CraftVillager(server, (EntityVillager) entity); }
                    else if (entity instanceof EntityVillagerTrader) { return new CraftWanderingTrader(server, (EntityVillagerTrader) entity); }
                    else { return new CraftAbstractVillager(server, (EntityVillagerAbstract) entity); }
                }
                else { return new CraftCreature(server, (EntityCreature) entity); }
            }
            // Slimes are a special (and broken) case
            else if (entity instanceof EntitySlime) {
                if (entity instanceof EntityMagmaCube) { return new CraftMagmaCube(server, (EntityMagmaCube) entity); }
                else { return new CraftSlime(server, (EntitySlime) entity); }
            }
            // Flying
            else if (entity instanceof FlyingEntity) {
                if (entity instanceof EntityGhast) { return new CraftGhast(server, (EntityGhast) entity); }
                else if (entity instanceof EntityPhantom) { return new CraftPhantom(server, (EntityPhantom) entity); }
                else { return new CraftFlying(server, (FlyingEntity) entity); }
            }
            else if (entity instanceof EntityEnderDragon) {
                return new CraftEnderDragon(server, (EntityEnderDragon) entity);
            }
            // Ambient
            else if (entity instanceof EntityAmbient) {
                if (entity instanceof EntityBat) { return new CraftBat(server, (EntityBat) entity); }
                else { return new CraftAmbient(server, (EntityAmbient) entity); }
            }
            else if (entity instanceof EntityArmorStand) { return new CraftArmorStand(server, (EntityArmorStand) entity); }
            else  { return new CraftLivingEntity(server, (EntityLiving) entity); }
        }
        else if (entity instanceof EntityComplexPart) {
            EntityComplexPart part = (EntityComplexPart) entity;
            if (part.owner instanceof EntityEnderDragon) { return new CraftEnderDragonPart(server, (EntityComplexPart) entity); }
            else { return new CraftComplexPart(server, (EntityComplexPart) entity); }
        }
        else if (entity instanceof EntityExperienceOrb) { return new CraftExperienceOrb(server, (EntityExperienceOrb) entity); }
        else if (entity instanceof EntityTippedArrow) { return new CraftTippedArrow(server, (EntityTippedArrow) entity); }
        else if (entity instanceof EntitySpectralArrow) { return new CraftSpectralArrow(server, (EntitySpectralArrow) entity); }
        else if (entity instanceof EntityArrow) {
            if (entity instanceof EntityThrownTrident) { return new CraftTrident(server, (EntityThrownTrident) entity); }
            else { return new CraftArrow(server, (EntityArrow) entity); }
        }
        else if (entity instanceof EntityBoat) { return new CraftBoat(server, (EntityBoat) entity); }
        else if (entity instanceof EntityProjectile) {
            if (entity instanceof EggEntity) { return new CraftEgg(server, (EggEntity) entity); }
            else if (entity instanceof EntitySnowball) { return new CraftSnowball(server, (EntitySnowball) entity); }
            else if (entity instanceof EntityPotion) { return new CraftThrownPotion(server, (EntityPotion) entity); }
            else if (entity instanceof EnderPearlEntity) { return new CraftEnderPearl(server, (EnderPearlEntity) entity); }
            else if (entity instanceof EntityThrownExpBottle) { return new CraftThrownExpBottle(server, (EntityThrownExpBottle) entity); }
        }
        else if (entity instanceof EntityFallingBlock) { return new CraftFallingBlock(server, (EntityFallingBlock) entity); }
        else if (entity instanceof EntityFireball) {
            if (entity instanceof EntitySmallFireball) { return new CraftSmallFireball(server, (EntitySmallFireball) entity); }
            else if (entity instanceof EntityLargeFireball) { return new CraftLargeFireball(server, (EntityLargeFireball) entity); }
            else if (entity instanceof EntityWitherSkull) { return new CraftWitherSkull(server, (EntityWitherSkull) entity); }
            else if (entity instanceof DragonFireballEntity) { return new CraftDragonFireball(server, (DragonFireballEntity) entity); }
            else { return new CraftFireball(server, (EntityFireball) entity); }
        }
        else if (entity instanceof EntityEnderSignal) { return new CraftEnderSignal(server, (EntityEnderSignal) entity); }
        else if (entity instanceof EntityEnderCrystal) { return new CraftEnderCrystal(server, (EntityEnderCrystal) entity); }
        else if (entity instanceof AbstractFishEntityingHook) { return new CraftFishHook(server, (AbstractFishEntityingHook) entity); }
        else if (entity instanceof EntityItem) { return new CraftItem(server, (EntityItem) entity); }
        else if (entity instanceof EntityLightning) { return new CraftLightningStrike(server, (EntityLightning) entity); }
        else if (entity instanceof EntityMinecartAbstract) {
            if (entity instanceof EntityMinecartFurnace) { return new CraftMinecartFurnace(server, (EntityMinecartFurnace) entity); }
            else if (entity instanceof EntityMinecartChest) { return new CraftMinecartChest(server, (EntityMinecartChest) entity); }
            else if (entity instanceof TNTMinecartEntity) { return new CraftMinecartTNT(server, (TNTMinecartEntity) entity); }
            else if (entity instanceof EntityMinecartHopper) { return new CraftMinecartHopper(server, (EntityMinecartHopper) entity); }
            else if (entity instanceof EntityMinecartMobSpawner) { return new CraftMinecartMobSpawner(server, (EntityMinecartMobSpawner) entity); }
            else if (entity instanceof EntityMinecartRideable) { return new CraftMinecartRideable(server, (EntityMinecartRideable) entity); }
            else if (entity instanceof EntityMinecartCommandBlock) { return new CraftMinecartCommand(server, (EntityMinecartCommandBlock) entity); }
        } else if (entity instanceof EntityHanging) {
            if (entity instanceof EntityPainting) { return new CraftPainting(server, (EntityPainting) entity); }
            else if (entity instanceof EntityItemFrame) { return new CraftItemFrame(server, (EntityItemFrame) entity); }
            else if (entity instanceof EntityLeash) { return new CraftLeash(server, (EntityLeash) entity); }
            else { return new CraftHanging(server, (EntityHanging) entity); }
        }
        else if (entity instanceof EntityTNTPrimed) { return new CraftTNTPrimed(server, (EntityTNTPrimed) entity); }
        else if (entity instanceof EntityFireworks) { return new CraftFirework(server, (EntityFireworks) entity); }
        else if (entity instanceof EntityShulkerBullet) { return new CraftShulkerBullet(server, (EntityShulkerBullet) entity); }
        else if (entity instanceof EntityAreaEffectCloud) { return new CraftAreaEffectCloud(server, (EntityAreaEffectCloud) entity); }
        else if (entity instanceof EntityEvokerFangs) { return new CraftEvokerFangs(server, (EntityEvokerFangs) entity); }
        else if (entity instanceof EntityLlamaSpit) { return new CraftLlamaSpit(server, (EntityLlamaSpit) entity); }

        throw new AssertionError("Unknown entity " + (entity == null ? null : entity.getClass()));
    }

    @Override
    public Location getLocation() {
        return new Location(getWorld(), entity.locX(), entity.locY(), entity.locZ(), entity.getBukkitYaw(), entity.pitch);
    }

    @Override
    public Location getLocation(Location loc) {
        if (loc != null) {
            loc.setWorld(getWorld());
            loc.setX(entity.locX());
            loc.setY(entity.locY());
            loc.setZ(entity.locZ());
            loc.setYaw(entity.getBukkitYaw());
            loc.setPitch(entity.pitch);
        }

        return loc;
    }

    @Override
    public Vector getVelocity() {
        return CraftVector.toBukkit(entity.getMot());
    }

    @Override
    public void setVelocity(Vector velocity) {
        Preconditions.checkArgument(velocity != null, "velocity");
        velocity.checkFinite();
        entity.setMot(CraftVector.toNMS(velocity));
        entity.velocityChanged = true;
    }

    @Override
    public double getHeight() {
        return getHandle().getHeight();
    }

    @Override
    public double getWidth() {
        return getHandle().getWidth();
    }

    @Override
    public BoundingBox getBoundingBox() {
        AxisAlignedBB bb = getHandle().getBoundingBox();
        return new BoundingBox(bb.minX, bb.minY, bb.minZ, bb.maxX, bb.maxY, bb.maxZ);
    }

    @Override
    public boolean isOnGround() {
        if (entity instanceof EntityArrow) {
            return ((EntityArrow) entity).inGround;
        }
        return entity.onGround;
    }

    @Override
    public World getWorld() {
        return entity.world.getWorld();
    }

    @Override
    public void setRotation(float yaw, float pitch) {
        NumberConversions.checkFinite(pitch, "pitch not finite");
        NumberConversions.checkFinite(yaw, "yaw not finite");

        yaw = Location.normalizeYaw(yaw);
        pitch = Location.normalizePitch(pitch);

        entity.yaw = yaw;
        entity.pitch = pitch;
        entity.lastYaw = yaw;
        entity.lastPitch = pitch;
        entity.setHeadRotation(yaw);
    }

    @Override
    public boolean teleport(Location location) {
        return teleport(location, TeleportCause.PLUGIN);
    }

    @Override
    public boolean teleport(Location location, TeleportCause cause) {
        Preconditions.checkArgument(location != null, "location");
        location.checkFinite();

        if (entity.isVehicle() || entity.dead) {
            return false;
        }

        // If this entity is riding another entity, we must dismount before teleporting.
        entity.stopRiding();

        // Let the server handle cross world teleports
        if (!location.getWorld().equals(getWorld())) {
            entity.teleportTo(((CraftWorld) location.getWorld()).getHandle().getDimension().getDimensionManager(), new BlockPos(location.getX(), location.getY(), location.getZ()));
            return true;
        }

        // entity.setLocation() throws no event, and so cannot be cancelled
        entity.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
        // SPIGOT-619: Force sync head rotation also
        entity.setHeadRotation(location.getYaw());

        return true;
    }

    @Override
    public boolean teleport(org.bukkit.entity.Entity destination) {
        return teleport(destination.getLocation());
    }

    @Override
    public boolean teleport(org.bukkit.entity.Entity destination, TeleportCause cause) {
        return teleport(destination.getLocation(), cause);
    }

    @Override
    public List<org.bukkit.entity.Entity> getNearbyEntities(double x, double y, double z) {
        List<Entity> notchEntityList = entity.world.getEntities(entity, entity.getBoundingBox().grow(x, y, z), null);
        List<org.bukkit.entity.Entity> bukkitEntityList = new java.util.ArrayList<org.bukkit.entity.Entity>(notchEntityList.size());

        for (Entity e : notchEntityList) {
            bukkitEntityList.add(e.getBukkitEntity());
        }
        return bukkitEntityList;
    }

    @Override
    public int getEntityId() {
        return entity.getId();
    }

    @Override
    public int getFireTicks() {
        return entity.fireTicks;
    }

    @Override
    public int getMaxFireTicks() {
        return entity.getMaxFireTicks();
    }

    @Override
    public void setFireTicks(int ticks) {
        entity.fireTicks = ticks;
    }

    @Override
    public void remove() {
        entity.die();
    }

    @Override
    public boolean isDead() {
        return !entity.isAlive();
    }

    @Override
    public boolean isValid() {
        return entity.isAlive() && entity.valid && entity.isChunkLoaded();
    }

    @Override
    public Server getServer() {
        return server;
    }

    @Override
    public boolean isPersistent() {
        return entity.persist;
    }

    @Override
    public void setPersistent(boolean persistent) {
        entity.persist = persistent;
    }

    public Vector getMomentum() {
        return getVelocity();
    }

    public void setMomentum(Vector value) {
        setVelocity(value);
    }

    @Override
    public org.bukkit.entity.Entity getPassenger() {
        return isEmpty() ? null : getHandle().passengers.get(0).getBukkitEntity();
    }

    @Override
    public boolean setPassenger(org.bukkit.entity.Entity passenger) {
        Preconditions.checkArgument(!this.equals(passenger), "Entity cannot ride itself.");
        if (passenger instanceof CraftEntity) {
            eject();
            return ((CraftEntity) passenger).getHandle().startRiding(getHandle());
        } else {
            return false;
        }
    }

    @Override
    public List<org.bukkit.entity.Entity> getPassengers() {
        return Lists.newArrayList(Lists.transform(getHandle().passengers, new Function<Entity, org.bukkit.entity.Entity>() {
            @Override
            public org.bukkit.entity.Entity apply(Entity input) {
                return input.getBukkitEntity();
            }
        }));
    }

    @Override
    public boolean addPassenger(org.bukkit.entity.Entity passenger) {
        Preconditions.checkArgument(passenger != null, "passenger == null");

        return ((CraftEntity) passenger).getHandle().a(getHandle(), true);
    }

    @Override
    public boolean removePassenger(org.bukkit.entity.Entity passenger) {
        Preconditions.checkArgument(passenger != null, "passenger == null");

        ((CraftEntity) passenger).getHandle().stopRiding();
        return true;
    }

    @Override
    public boolean isEmpty() {
        return !getHandle().isVehicle();
    }

    @Override
    public boolean eject() {
        if (isEmpty()) {
            return false;
        }

        getHandle().ejectPassengers();
        return true;
    }

    @Override
    public float getFallDistance() {
        return getHandle().fallDistance;
    }

    @Override
    public void setFallDistance(float distance) {
        getHandle().fallDistance = distance;
    }

    @Override
    public void setLastDamageCause(EntityDamageEvent event) {
        lastDamageEvent = event;
    }

    @Override
    public EntityDamageEvent getLastDamageCause() {
        return lastDamageEvent;
    }

    @Override
    public UUID getUniqueId() {
        return getHandle().getUniqueID();
    }

    @Override
    public int getTicksLived() {
        return getHandle().ticksLived;
    }

    @Override
    public void setTicksLived(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Age must be at least 1 tick");
        }
        getHandle().ticksLived = value;
    }

    public Entity getHandle() {
        return entity;
    }

    @Override
    public void playEffect(EntityEffect type) {
        Preconditions.checkArgument(type != null, "type");

        if (type.getApplicable().isInstance(this)) {
            this.getHandle().world.broadcastEntityEffect(getHandle(), type.getData());
        }
    }

    public void setHandle(final Entity entity) {
        this.entity = entity;
    }

    @Override
    public String toString() {
        return "CraftEntity{" + "id=" + getEntityId() + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CraftEntity other = (CraftEntity) obj;
        return (this.getEntityId() == other.getEntityId());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.getEntityId();
        return hash;
    }

    @Override
    public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
        server.getEntityMetadata().setMetadata(this, metadataKey, newMetadataValue);
    }

    @Override
    public List<MetadataValue> getMetadata(String metadataKey) {
        return server.getEntityMetadata().getMetadata(this, metadataKey);
    }

    @Override
    public boolean hasMetadata(String metadataKey) {
        return server.getEntityMetadata().hasMetadata(this, metadataKey);
    }

    @Override
    public void removeMetadata(String metadataKey, Plugin owningPlugin) {
        server.getEntityMetadata().removeMetadata(this, metadataKey, owningPlugin);
    }

    @Override
    public boolean isInsideVehicle() {
        return getHandle().isPassenger();
    }

    @Override
    public boolean leaveVehicle() {
        if (!isInsideVehicle()) {
            return false;
        }

        getHandle().stopRiding();
        return true;
    }

    @Override
    public org.bukkit.entity.Entity getVehicle() {
        if (!isInsideVehicle()) {
            return null;
        }

        return getHandle().getVehicle().getBukkitEntity();
    }

    @Override
    public void setCustomName(String name) {
        // sane limit for name length
        if (name != null && name.length() > 256) {
            name = name.substring(0, 256);
        }

        getHandle().setCustomName(CraftChatMessage.fromStringOrNull(name));
    }

    @Override
    public String getCustomName() {
        ITextComponent name = getHandle().getCustomName();

        if (name == null) {
            return null;
        }

        return CraftChatMessage.fromComponent(name);
    }

    @Override
    public void setCustomNameVisible(boolean flag) {
        getHandle().setCustomNameVisible(flag);
    }

    @Override
    public boolean isCustomNameVisible() {
        return getHandle().getCustomNameVisible();
    }

    @Override
    public void sendMessage(String message) {

    }

    @Override
    public void sendMessage(String[] messages) {

    }

    @Override
    public String getName() {
        return CraftChatMessage.fromComponent(getHandle().getDisplayName(), EnumChatFormat.WHITE);
    }

    @Override
    public boolean isPermissionSet(String name) {
        return getPermissibleBase().isPermissionSet(name);
    }

    @Override
    public boolean isPermissionSet(Permission perm) {
        return CraftEntity.getPermissibleBase().isPermissionSet(perm);
    }

    @Override
    public boolean hasPermission(String name) {
        return getPermissibleBase().hasPermission(name);
    }

    @Override
    public boolean hasPermission(Permission perm) {
        return getPermissibleBase().hasPermission(perm);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
        return getPermissibleBase().addAttachment(plugin, name, value);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin) {
        return getPermissibleBase().addAttachment(plugin);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
        return getPermissibleBase().addAttachment(plugin, name, value, ticks);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
        return getPermissibleBase().addAttachment(plugin, ticks);
    }

    @Override
    public void removeAttachment(PermissionAttachment attachment) {
        getPermissibleBase().removeAttachment(attachment);
    }

    @Override
    public void recalculatePermissions() {
        getPermissibleBase().recalculatePermissions();
    }

    @Override
    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return getPermissibleBase().getEffectivePermissions();
    }

    @Override
    public boolean isOp() {
        return getPermissibleBase().isOp();
    }

    @Override
    public void setOp(boolean value) {
        getPermissibleBase().setOp(value);
    }

    @Override
    public void setGlowing(boolean flag) {
        getHandle().glowing = flag;
        Entity e = getHandle();
        if (e.getFlag(6) != flag) {
            e.setFlag(6, flag);
        }
    }

    @Override
    public boolean isGlowing() {
        return getHandle().glowing;
    }

    @Override
    public void setInvulnerable(boolean flag) {
        getHandle().setInvulnerable(flag);
    }

    @Override
    public boolean isInvulnerable() {
        return getHandle().isInvulnerable(DamageSource.GENERIC);
    }

    @Override
    public boolean isSilent() {
        return getHandle().isSilent();
    }

    @Override
    public void setSilent(boolean flag) {
        getHandle().setSilent(flag);
    }

    @Override
    public boolean hasGravity() {
        return !getHandle().isNoGravity();
    }

    @Override
    public void setGravity(boolean gravity) {
        getHandle().setNoGravity(!gravity);
    }

    @Override
    public int getPortalCooldown() {
        return getHandle().portalCooldown;
    }

    @Override
    public void setPortalCooldown(int cooldown) {
        getHandle().portalCooldown = cooldown;
    }

    @Override
    public Set<String> getScoreboardTags() {
        return getHandle().getScoreboardTags();
    }

    @Override
    public boolean addScoreboardTag(String tag) {
        return getHandle().addScoreboardTag(tag);
    }

    @Override
    public boolean removeScoreboardTag(String tag) {
        return getHandle().removeScoreboardTag(tag);
    }

    @Override
    public PistonMoveReaction getPistonMoveReaction() {
        return PistonMoveReaction.getById(getHandle().getPushReaction().ordinal());
    }

    @Override
    public BlockFace getFacing() {
        // Use this method over getDirection because it handles boats and minecarts.
        return CraftBlock.notchToBlockFace(getHandle().getAdjustedDirection());
    }

    @Override
    public CraftPersistentDataContainer getPersistentDataContainer() {
        return persistentDataContainer;
    }

    @Override
    public Pose getPose() {
        return Pose.values()[getHandle().getPose().ordinal()];
    }

    public void storeBukkitValues(CompoundNBT c) {
        if (!this.persistentDataContainer.isEmpty()) {
            c.set("BukkitValues", this.persistentDataContainer.toTagCompound());
        }
    }

    public void readBukkitValues(CompoundNBT c) {
        CompoundNBT base = c.getCompound("BukkitValues");
        if (base != null) {
            this.persistentDataContainer.putAll(base);
        }
    }

    protected CompoundNBT save() {
        CompoundNBT nbttagcompound = new CompoundNBT();

        nbttagcompound.setString("id", getHandle().getSaveID());
        getHandle().save(nbttagcompound);

        return nbttagcompound;
    }

    private static PermissibleBase getPermissibleBase() {
        if (perm == null) {
            perm = new PermissibleBase(new ServerOperator() {

                @Override
                public boolean isOp() {
                    return false;
                }

                @Override
                public void setOp(boolean value) {

                }
            });
        }
        return perm;
    }
}