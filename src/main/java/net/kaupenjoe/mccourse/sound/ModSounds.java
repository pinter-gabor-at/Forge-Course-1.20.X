package net.kaupenjoe.mccourse.sound;

import static net.kaupenjoe.mccourse.util.ModNameUtil.modResourceLocation;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class ModSounds {
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
		DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MCCourseMod.MOD_ID);
	public static final RegistryObject<SoundEvent> METAL_DETECTOR_FOUND_ORE =
		registerSoundEvents("metal_detector_found_ore");

	@SuppressWarnings("SameParameterValue")
	private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
		ResourceLocation id = modResourceLocation(name);
		return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
	}

	public static void register(IEventBus eventBus) {
		SOUND_EVENTS.register(eventBus);
	}
}
