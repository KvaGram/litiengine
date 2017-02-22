package de.gurkenlabs.litiengine.abilities.effects;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.abilities.Ability;
import de.gurkenlabs.litiengine.entities.ICombatEntity;
import de.gurkenlabs.litiengine.environment.IEnvironment;
import de.gurkenlabs.litiengine.sound.Sound;

public class SoundEffect extends Effect {
  private final Sound[] sounds;

  public SoundEffect(final IEnvironment environment, final Ability ability, final Sound... sounds) {
    super(environment, ability, EffectTarget.EXECUTINGENTITY);
    this.sounds = sounds;
  }

  public Sound getRandomSound() {
    if (this.sounds.length == 0) {
      return null;
    }

    final int randomIndex = (int) (Math.random() * this.sounds.length);
    return this.sounds[randomIndex];
  }

  @Override
  protected void apply(final ICombatEntity entity) {
    super.apply(entity);
    if (this.sounds.length == 0) {
      return;
    }

    Game.getSoundEngine().playSound(entity, this.getRandomSound());
  }
}
