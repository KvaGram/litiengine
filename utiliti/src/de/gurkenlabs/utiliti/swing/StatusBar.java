package de.gurkenlabs.utiliti.swing;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.input.Input;
import de.gurkenlabs.litiengine.resources.Resources;
import de.gurkenlabs.utiliti.Style;
import de.gurkenlabs.utiliti.components.Editor;
import de.gurkenlabs.utiliti.swing.panels.PropertyPanel;

public final class StatusBar {
  private static JLabel statusLabel;

  private StatusBar() {
  }

  public static JLabel create() {
    statusLabel = new JLabel("");
    statusLabel.setPreferredSize(new Dimension(0, (int) (16 * Editor.preferences().getUiScale())));
    statusLabel.setFont(new Font(Style.FONTNAME_CONSOLE, Font.PLAIN, (int) (14 * Editor.preferences().getUiScale())));
    statusLabel.setBorder(new EmptyBorder(PropertyPanel.LABEL_GAP, PropertyPanel.LABEL_GAP, PropertyPanel.LABEL_GAP, PropertyPanel.LABEL_GAP));
    return statusLabel;
  }

  public static void update() {
    String position = String.format("x/y: %d,%d", (int) Input.mouse().getMapLocation().getX(), (int) Input.mouse().getMapLocation().getY());
    String tile = String.format("Tile: %d,%d", Input.mouse().getTile().x, Input.mouse().getTile().y);
    String zoom = String.format(" %6d%%", (int) (Game.world().camera().getRenderScale() * 100));
    String status = String.format("%-14s %-14s %s", position, tile, zoom);

    int size = Editor.instance().getMapComponent().getSelectedMapObjects().size();
    if (size <= 0) {
      statusLabel.setText("");
    } else {
      status += " " + Resources.strings().get("status_selected_objects", size);
    }

    statusLabel.setText(status);
  }
}
