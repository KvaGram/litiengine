package de.gurkenlabs.litiengine.abilities.effects;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.abilities.Ability;
import de.gurkenlabs.litiengine.entities.ICombatEntity;
import de.gurkenlabs.litiengine.sound.Sound;

public class SoundEffect extends Effect {
  private final Sound[] sounds;

  /**
   * Initializes a new instance of the <code>SoundEffect</code> class.
   *
   * @param ability
   *          The ability that performs the effect.
   * @param sounds
   *          The sounds to chose from when applying the effect.
   */
  public SoundEffect(final Ability ability, final Sound... sounds) {
    super(ability, EffectTarget.EXECUTINGENTITY);
    this.sounds = sounds;
  }

  @Override
  protected void apply(final ICombatEntity entity) {
    super.apply(entity);
    if (this.sounds.length == 0) {
      return;
    }

    Game.audio().playSound(this.getRandomSound(), entity);
  }

  private Sound getRandomSound() {
    if (this.sounds.length == 0) {
      return null;
    }

    return Game.random().choose(this.sounds);
  }
}
