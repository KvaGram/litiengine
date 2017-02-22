package de.gurkenlabs.litiengine.configuration;

import de.gurkenlabs.configuration.Configuration;
import de.gurkenlabs.configuration.ConfigurationGroup;

public class GameConfiguration extends Configuration {
  public final ClientConfiguration CLIENT;
  public final DebugConfiguration DEBUG;
  public final GraphicConfiguration GRAPHICS;
  public final InputConfiguration INPUT;
  public final SoundConfiguration SOUND;

  public GameConfiguration(final ConfigurationGroup... groups) {
    super(groups);
    this.CLIENT = new ClientConfiguration();
    this.SOUND = new SoundConfiguration();
    this.GRAPHICS = new GraphicConfiguration();
    this.INPUT = new InputConfiguration();
    this.DEBUG = new DebugConfiguration();
    this.getConfigurationGroups().add(this.CLIENT);
    this.getConfigurationGroups().add(this.SOUND);
    this.getConfigurationGroups().add(this.GRAPHICS);
    this.getConfigurationGroups().add(this.INPUT);
    this.getConfigurationGroups().add(this.DEBUG);
  }
}
